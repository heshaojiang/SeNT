package com.grgbanking.platform.module.cashbox.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.ImportExcelUtil;
import com.grgbanking.platform.module.area.dao.AreaDao;
import com.grgbanking.platform.module.cashbox.dao.BoxInfoDao;
import com.grgbanking.platform.module.cashbox.entity.BoxInfo;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.dao.TermBrandDao;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.dao.TermModelDao;
import com.grgbanking.platform.module.term.dao.TermTypeDao;
import com.grgbanking.platform.module.term.entity.TermBrand;
import com.grgbanking.platform.module.term.entity.TermModel;
import com.grgbanking.platform.module.term.entity.TermType;
import com.grgbanking.sent.transmgr.constants.BoxInfoConsts;
import com.grgbanking.sent.transmgr.dao.BarcodeInCashboxDao;

import flex.messaging.FlexContext;

@Service
@Transactional
public class BoxInfoService extends BaseService
{
	
	@Autowired
	BoxInfoDao boxInfoDao;
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	@Autowired
	TermInfoDao terminalInfoDao;
	
	@Autowired
	TermModelDao terminalModelDao;
	
	@Autowired
	TermBrandDao terminalBrandDao;
	
	@Autowired
	TermTypeDao terminalTypeDao;
	
	@Autowired
	SysDatadirService sysDatadirService;
	
	@Autowired
	AreaDao areaDao;
	
	@Autowired
	private ParamDao paramDao;
	
	@Autowired
	BarcodeInCashboxDao barcodeInCashboxDao;
	
	/**
	 * 
	 */
	public BoxInfo getBoxDetailInfoByBoxNum(Map<Object, Object> parameter)
	{
		String boxNum = (String)parameter.get("boxNum");
		BoxInfo boxInfo = boxInfoDao.getBoxByBoxNum(boxNum);
		if( boxInfo==null )
		{
			return boxInfo;
		}
		String orgId = boxInfo.getOrgid();
		if( orgId==null )
		{
			return boxInfo;
		}
		OrgInfo orgInfo = orgInfoDao.get(orgId);
		if( orgInfo==null )
		{
			return boxInfo;
		}
		boxInfo.setOrgName(orgInfo.getOrgName());
		boxInfo.setOrgFullName(orgInfo.getOrgFullName());
		return boxInfo;
	}
	
	/**
	 * 根据传入的参数查找分页的钞箱数据
	 * @param page 页对象
	 * @param params 条件参数
	 * @return Page<BoxInfo>
	 */
	public Page<BoxInfo> getBoxInfoByParams(Page<BoxInfo> page, Map<String ,String> params)
	{
		Page<BoxInfo> pageObject = boxInfoDao.getBoxInfoByParams(page, params);
		return  pageObject;
	}

	public String[] getOrgNameAndModelNameByBoxNum(String boxNum)
	{
		BoxInfo boxInfo = boxInfoDao.getBoxByBoxNum(boxNum);
		String sa;
		String sb = orgInfoDao.get(boxInfo.getOrgid()).getOrgName().toString();
		if(boxInfo.getBoxType().equals(AppConstants.BOX_TYPE_ATM)){
			sa = terminalModelDao.get(boxInfo.getAtmModel()).getModelName().toString();
			
		}else{
			sa = null;
		}
		
		String boxQRCodePrintSwitch = "0";
		
		try{
			boxQRCodePrintSwitch = paramDao
				.getValueByPath(com.grgbanking.sent.common.Constants.AppConstants.BOX_QRCODE_RPINT_SWITCH)==null?"0":paramDao
						.getValueByPath(com.grgbanking.sent.common.Constants.AppConstants.BOX_QRCODE_RPINT_SWITCH);
		}catch(Exception e){
			boxQRCodePrintSwitch = "0";
		}
		String[] s1 = {sb,sa,boxQRCodePrintSwitch};
		return s1;
	}

	/**
	 * 更新钞箱信息
	 * @param boxInfo 更新的数据
	 * @return
	 */
	public boolean updateBoxInfo(BoxInfo boxInfo){
		validateBoxInfo(boxInfo);
		//查询数据库验证钞箱编号是否已存在
		BoxInfo existedBoxInfo = boxInfoDao.getBoxByBoxNum(boxInfo.getBoxNum());
		if(existedBoxInfo != null){
			throw new AppException(MessageKeyConstants.BOX_BOXNUM_EXISTS,"boxNum already exist!");
		}
		boxInfoDao.copyUpdate(boxInfo);

		return true;
	}
	/**
	 * 保存钞箱信息
	 * @param boxInfo 要保存的钞箱
	 * @return
	 */
	public boolean saveBoxInfo(BoxInfo boxInfo)
	{
		validateBoxInfo(boxInfo);
		BoxInfo existedBoxInfo = boxInfoDao.getBoxByBoxNum(boxInfo.getBoxNum());
		if (existedBoxInfo != null)
		{
			throw new AppException(MessageKeyConstants.BOX_BOXNUM_EXISTS, "boxNum already exist!");
		}
		if (boxInfo.getId() == null)
		{
			boxInfoDao.saveNew(boxInfo);
		}
		else
		{
			boxInfoDao.copyUpdate(boxInfo);
		}
		return true;
	}
	
	public boolean saveBoxInfo(BoxInfo boxInfo,Boolean change){
		validateBoxInfo(boxInfo);
		BoxInfo existedBoxInfo = boxInfoDao.getBoxByBoxNum(boxInfo.getBoxNum());
		if(change){
			if(existedBoxInfo != null){
				throw new AppException(MessageKeyConstants.BOX_BOXNUM_EXISTS,"boxNum already exist!");
			}
		}
		
		if(boxInfo.getBoxType().equals(AppConstants.BOX_TYPE_BRANCH)){
			boxInfo.setAtmModel(null);
			boxInfo.setAtmBoxTypes(null);
		}
		if(boxInfo.getId() == null){
			boxInfoDao.saveNew(boxInfo);
		}else{
			boxInfoDao.copyUpdate(boxInfo);
		}
		return true;
	}
	/**
	 * 删除钞箱信息
	 */
	/*
	public boolean deleteBoxInfo(BoxInfo boxInfo){
		boxInfoDao.delete(boxInfo);
		return true;
	}
	*/
	public boolean deleteBoxInfo(Collection<String> ids){
		if(ids == null || ids.size() == 0)
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");

		for(String id : ids){
			boxInfoDao.delete(id);
		}
		return true;
	}
	
	/**
	 * 恢复钞箱流转状态为初始状态
	 */
	public boolean restoreBoxFlowStage(String boxNum){
		if(boxNum == null || boxNum=="")
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected. ");

		BoxInfo boxInfo =  boxInfoDao.getBoxByBoxNum(boxNum);
		if(boxInfo==null) return false;
		barcodeInCashboxDao.deleteByBoxNum(boxInfo.getBoxNum());
		boxInfo.setUsageStatus(BoxInfoConsts.USAGE_STATUS_FREE);//初始状态
		boxInfoDao.copyUpdate(boxInfo);
		return true;
	}
	
	/**
	 * 验证窗体是否有输入参数
	 * @param boxInfo
	 * @return
	 */
	private boolean validateBoxInfo(BoxInfo boxInfo)
	{
		if (boxInfo == null)
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL, "The Input is null. Please check and submit again. ");

		if (!StringUtils.hasText(boxInfo.getBoxNum()))
			throw new AppException(MessageKeyConstants.BOX_NUM_NOT_NULL, "BoxNum can not be left empty. Please input boxNum and submit again.");
		return true;
	}
	
	/**
	 * 
	 * @param file
	 *            文件字节
	 */
//	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Transactional
	public Map<String, Object> importExcel(byte[] file)
	{
		List<BoxInfo> importList = new ArrayList<BoxInfo>();
		
		StringBuffer errBuf = new StringBuffer(); // 错误信息
		
		// 读取要导入的文件
		InputStream is = new ByteArrayInputStream(file);
		try
		{
			HSSFWorkbook wb = new HSSFWorkbook(is);
			importList = ImportExcelUtil.importExcel(wb, 0, BoxInfo.class);
		}catch (Exception e)
		{
			errBuf.append("excel内容格式错误,导入失败,请检查!");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("importedNum", 0);
			map.put("errMsg", errBuf.toString());
			return map;
			//throw new AppException(MessageKeyConstants.BOX_IMPORT_EXCEL_ERROR, "Import Excel error!");
		}

		// 先检查机构号，从机构信息数据表中获取全部的机构信息（主要是获取机构的id）
		List<OrgInfo> orgList = orgInfoDao.getAll();
		Map<String, OrgInfo> orgNameMap = new HashMap<String, OrgInfo>();
		for (OrgInfo orgInfo : orgList)
		{
			orgNameMap.put(orgInfo.getOrgName(), orgInfo);
		}

		
		int totalNumImport = 0;
		// 将验证通过的钞箱信息记录增加到列表中
		for( BoxInfo obj : importList )
		{
			boolean checkFail = false;
			
			if (obj.getBoxNum() == null || obj.getBoxNum().trim().length() <= 0)
			{
				checkFail = true;
				errBuf.append("钞箱号不能为空，请检查\r\n");
				continue;
			}
			
			// 判断是否有机构信息
			if (obj.getOrgName() == null || obj.getOrgName().trim().length() <= 0)
			{
				checkFail = true;
				errBuf.append("钞箱号[" + obj.getBoxNum() + "]所属机构名称不能为空，请检查\r\n");
				continue;
			}
			
			if (obj.getBoxType() == null || obj.getBoxType().trim().length() <= 0)
			{
				checkFail = true;
				errBuf.append("钞箱号[" + obj.getBoxNum() + "]钞箱类别不能为空，请检查\r\n");
				continue;
			}
			
			if (obj.getBoxStatus() == null || obj.getBoxStatus().trim().length() <= 0)
			{
				checkFail = true;
				errBuf.append("钞箱号[" + obj.getBoxNum() + "]钞箱状态不能为空，请检查\r\n");
				continue;
			}else {
				String str1 = obj.getBoxStatus().trim();
				if (!"Y".equals(str1) && !"N".equals(str1)){
					checkFail = true;
					errBuf.append("钞箱号[" + obj.getBoxNum() + "]钞箱状态填写有误（必须是Y或者N），请检查\r\n");
					continue;
				}
			}
			
			if(obj.getUsageStatus()!=null && !("0000".equals (obj.getUsageStatus().trim())) ){
				checkFail = true;
				errBuf.append("钞箱号[" + obj.getBoxNum() + "]使用状态列输入为非“0000”，请检查\r\n");
				continue;
			}
			
			
			if(obj.getAtmBoxTypes()!=null && (obj.getAtmBoxTypes().length()>20 ||isChineseChar(obj.getAtmBoxTypes()))){
				checkFail = true;
				errBuf.append("钞箱号[" + obj.getBoxNum() + "]钞箱类型列输入有误，请检查\r\n");
				continue;
			}
			if(!("0".equals(obj.getAtmBoxTypes()) || "1".equals(obj.getAtmBoxTypes()) || "2".equals(obj.getAtmBoxTypes()))
					&& "1".equals(obj.getBoxType())){
				checkFail = true;
				errBuf.append("钞箱号[" + obj.getBoxNum() + "]钞箱为ATM钞箱，请检查该钞箱的钞箱类型是否正确(0:循环钞箱;1:取款钞箱;2:回收钞箱)\r\n");
				continue;
			}
			if(obj.getBoxStatus()==null && ! ("0000".equals(obj.getUsageStatus().trim()))){
				checkFail = true;
				errBuf.append("钞箱号[" + obj.getBoxNum() + "]状态列输入必须为“0000”，请检查\r\n");
				continue;
			}
			if(obj.getBoxNum()!=null && (obj.getBoxNum().length()>32 ||isChineseChar(obj.getBoxNum()))){
				checkFail = true;
				errBuf.append("钞箱号[" + obj.getBoxNum() + "]钞箱号列输入超长，请检查\r\n");
				continue;
			}
			if(obj.getBoxType()!=null && (obj.getBoxType().length()>2 ||isChineseChar(obj.getBoxType()))){
				checkFail = true;
				errBuf.append("钞箱号[" + obj.getBoxNum() + "]钞箱类别输入有误，请检查\r\n");
				continue;
			}
			if(obj.getBoxType()!=null &&  BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(obj.getBoxType())){
				if(obj.getAtmBoxTypes()==null ){
					checkFail = true;
					errBuf.append("ATM钞箱号[" + obj.getBoxNum() + "]钞箱类型列不能为空，请检查\r\n");
					continue;
				}
				if(obj.getAtmModel()==null ){
					checkFail = true;
					errBuf.append("ATM钞箱号[" + obj.getBoxNum() + "]ATM型号列不能为空，请检查\r\n");
					continue;
				}
			}
			
			// 判断钞箱所属机构是否存在以及钞箱号是否已存在
			OrgInfo orgInfo = orgNameMap.get(obj.getOrgName());
			if( orgInfo==null )
			{
				checkFail = true;
				errBuf.append("钞箱[" + obj.getBoxNum() + "]所属机构[" + obj.getOrgName() + "]不存在\r\n");
			}else{
			
				BoxInfo info = boxInfoDao.getBoxByBoxNum(obj.getBoxNum());
				if (info == null)
				{
					info = new BoxInfo();
					// 复制属性
					info.setBoxNum(obj.getBoxNum());
					info.setOrgid(orgInfo.getId());
					if( obj.getAtmModel()!=null )
					{
						TermModel termModel = terminalModelDao.getByModelName(obj.getAtmModel());
						if( termModel != null )
						{
							info.setAtmModel(termModel.getId());
						}else
						{
							checkFail = true;
							errBuf.append("无法找到对应的ATM型号["+obj.getAtmModel()+"]\r\n");
						}
					}else
					{
						info.setAtmModel(null);
					}
					info.setAtmBoxTypes(obj.getAtmBoxTypes());
					info.setBoxStatus(obj.getBoxStatus());
					info.setBoxType(obj.getBoxType());
					info.setUsageStatus(obj.getUsageStatus()==null?BoxInfoConsts.USAGE_STATUS_FREE:obj.getUsageStatus());
				}else
				{
					checkFail = true;
					errBuf.append("钞箱号[" + info.getBoxNum() + "]已存在\r\n");
				}	
				if( checkFail ){
					continue;	
				}
				try
				{
					if(info.getBoxType().equals(AppConstants.BOX_TYPE_BRANCH)){
						info.setAtmModel(null);
						info.setAtmBoxTypes(null);
					}
					boxInfoDao.saveNew(info);
					totalNumImport++;
				}catch (Exception ex)
				{
					// 保存出错需要继续处理其他的记录
					logger.error("The box with boxNum is " + obj.getBoxNum() + " import error!", ex);
				}
			}
		}
		String errMsg = errBuf.toString();
		logger.info("errMsg : "+errMsg);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("importedNum", totalNumImport);
		map.put("errMsg", errMsg);
		return map;
	}
	
	
	public  boolean isChineseChar(String str){
        boolean temp = false;
        Pattern p=Pattern.compile("[\u4e00-\u9fa5]"); 
        Matcher m=p.matcher(str); 
        if(m.find()){ 
            temp =  true;
        }
        return temp;
    }
	
	/**
	 * 导出Excel模板
	 */
	public String exportExcel(){
		//HttpServletResponse res = FlexContext.getHttpResponse();
		HttpServletRequest req = FlexContext.getHttpRequest();
		HSSFWorkbook hssf = new HSSFWorkbook();
		String filename = "BoxInfoImportModel.xls";
		FileOutputStream fileOut = null;
		
		final String[] firstRow = {"orgName","boxNum","boxType","atmModel","atmBoxTypes","boxStatus","usageStatus"};
		final String[] secondRow = {"所属机构名称","钞箱号","钞箱类别(1:ATM钞箱;2:款箱钞袋;)","ATM型号","ATM钞箱类型(0:循环钞箱;1:取款钞箱;2:回收钞箱)","状态(Y:启用;N:禁用)","使用状态(初始状态均为0)"};
		
		try{
			HSSFSheet sheet = hssf.createSheet();
			HSSFRow row,row1;
			String text = "";
			String text1 = "";
			row = sheet.createRow(0);
			row1 = sheet.createRow(1);
			for(int i=0;i<firstRow.length;i++){
				HSSFCell cell = row.createCell(i);
				HSSFCell cell1 = row1.createCell(i);
				text = firstRow[i];
				text1 = secondRow[i];
				cell.setCellValue(text);
				cell1.setCellValue(text1);
			}
			
			//File f = new File(filename);
			String filePath = req.getSession().getServletContext().getRealPath("/")+File.separator+"exportFile"+File.separator+filename;
			fileOut = new FileOutputStream(filePath);
			hssf.write(fileOut);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				fileOut.close();
				fileOut.flush();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		//System.out.println("filename:"+filename);
		return filename;
	}
	
	/**
	 * 根据当前语言获取表单或module的基础数据<br>
	 * 
	 * get init datas by language
	 * 
	 * @param language
	 * @return
	 */
	public Map<String, Object> getBoxInfoFormInitDatas(String language) {
		Map<String, Object> formInitDatas = new HashMap<String, Object>();

		// get Term Model List from valid TermModel(status = 'Y')
		List<TermModel> termModels = terminalModelDao
				.find(" from TermModel tm ");
		formInitDatas.put("modelList", termModels);
		//System.out.println("models length:"+termModels.size());

		// get Term Brand List from valid TermBrand(status = 'Y')
		List<TermBrand> termBrands = terminalBrandDao
				.find("from TermBrand tb ");
		formInitDatas.put("brandList", termBrands);

		// get Term Type List from valid TermType(status = 'Y')
		List<TermType> termTypes = terminalTypeDao.find("from TermType tt ");
		formInitDatas.put("typeList", termTypes);

		//get boxType list from datadir
		List boxType = sysDatadirService.getDatadirChildrenByPath(AppConstants.BOX_TYPE, language);
		formInitDatas.put("boxTypeList", boxType);
		
		return formInitDatas;
	}
}
