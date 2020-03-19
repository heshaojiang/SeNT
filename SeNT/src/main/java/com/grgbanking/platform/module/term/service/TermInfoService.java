/**
 * 文件名：TermInfoService.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.utils.FileUtil;
import com.grgbanking.platform.core.utils.ImportExcelUtil;
import com.grgbanking.platform.module.area.dao.AreaDao;
import com.grgbanking.platform.module.area.entity.Area;
import com.grgbanking.platform.module.area.service.AreaService;
import com.grgbanking.platform.module.cashbox.entity.BoxInfo;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.entity.SysDatadir;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.exproperty.dao.ExtendPropertyDao;
import com.grgbanking.platform.module.exproperty.entity.ExtendProperty;
import com.grgbanking.platform.module.exproperty.service.ExPropertyService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.dao.TermBrandDao;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.dao.TermModelDao;
import com.grgbanking.platform.module.term.dao.TermTypeDao;
import com.grgbanking.platform.module.term.entity.TermBrand;
import com.grgbanking.platform.module.term.entity.TermInfo;
import com.grgbanking.platform.module.term.entity.TermInfoVO;
import com.grgbanking.platform.module.term.entity.TermModel;
import com.grgbanking.platform.module.term.entity.TermType;
import com.grgbanking.sent.rule.service.BlackRegulationService;
import com.grgbanking.sent.utils.POIUtils;
import com.grgbanking.sent.utils.S2005Msg;
import com.grgbanking.sent.utils.Transfer;

import flex.messaging.FlexContext;

/**
 * 终端基础信息 service<br>
 * 
 * Terminal basal information Service
 * 
 * 
 * @author Jonas
 * 
 */
@Service
@Transactional
@SuppressWarnings( { "unchecked", "rawtypes" })
// @WebService(endpointInterface =
// "com.grgbanking.platform.module.term.service.wsinterface.ITermInfoService")
public class TermInfoService {
	private static Logger logger = LoggerFactory
			.getLogger(TermInfoService.class);
	/** 扩展属性 */
	public static Map<String, String> exPropertyMap = new HashMap<String, String>();

	@Autowired
	public void loadExproperty(ExPropertyService service,
			ExtendPropertyDao exPropertyDao) {
		List<ExtendProperty> exPropertyList = service
				.getExtendPropertyList(TermInfo.TABLE_NAME);
		for (ExtendProperty ex : exPropertyList) {
			exPropertyMap
					.put(ex.getPropertyName(), ex.getEntityClassProperty());
		}
	}

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
	OrgInfoDao orgInfoDao;

	@Autowired
	AreaDao areaDao;
	
	@Autowired
	TermModelService termModelService;
	@Autowired
	TermBrandService termBrandService;
	@Autowired
	TermTypeService termTypeService;
	@Autowired
	AreaService areaService;
	@Autowired
	ParamDao paramDao;

	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public String exportTermInfo(Map<String, String> params) {
		if(params.get("orgId")==null || params.get("orgId")==""){
			params.remove("orgId");
			params.put("orgId", params.get("userOrgid"));
		}
		Boolean isPrintTemplate = (params.get("isPrintTemplate").equals("0"));
		List terList = new ArrayList();
		if(!isPrintTemplate){
			terList = terminalInfoDao.getTermInfoPageByParams(params);
		}
		
		ArrayList<Object[]> dataList = new ArrayList<Object[]>();
		HttpServletRequest request = FlexContext.getHttpRequest();

		String fileName = UUID.randomUUID() + "Terminal.xls";
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ File.separator + "exportFile" + File.separator + fileName;// 导出文件路径
		String modelName = request.getSession().getServletContext()
				.getRealPath("")
				+ File.separator
				+ "exportFile"
				+ File.separator + "Terminal1.xls";// 文件模板路径
		
		Object[] row;
		List<OrgInfo> orgInfos = orgInfoDao.getAll();
		List<TermModel> termModels = termModelService.getAllTermModel();
		List<TermBrand> termBrands = termBrandService.getAllTermBrand();
		List<TermType> termTypes = termTypeService.getAllTermType();
		List<Area> areas = areaService.getAllArea();
		for (int i = 0; i < terList.size(); i++) {
			row = new Object[10];
			TermInfo termInfo = (TermInfo) terList.get(i);
			row[0] = termInfo.getTermCode();
			for (OrgInfo orgInfo : orgInfos) {
				if(orgInfo.getId().equals(termInfo.getOrgId())) {
					row[1] = orgInfo.getOrgName();
					break;
				}
			}
			// row[1] = termInfo.getOrgId();
			row[2] = termInfo.getNetAddr();
			row[3] = termInfo.getTellerIp();
			for (TermModel termModel : termModels) {
				if (termModel.getId().equals(termInfo.getModel())) {
					row[4] = termModel.getModelName();
					break;
				}
			}
			
			for (TermBrand termBrand : termBrands) {
				if (termBrand.getId().equals(termInfo.getBrand())) {
					row[5] = termBrand.getBrandName();
					break;
				}
			}
			
			
			for (TermType termType : termTypes) {
				if (termType.getId().equals(termInfo.getTermType())) {
					row[6] = termType.getTypeName();		
					break;
				}
			}
			
			for (Area area : areas) {
				if (area.getId().equals(termInfo.getAreaId())) {
					row[7] = area.getAreaName();
					break;
				}
				
			}
			
			row[8] = termInfo.getTermSEQ()==null?"":termInfo.getTermSEQ();
			row[9] = termInfo.getCounterCode()==null?"":termInfo.getCounterCode();
			
			dataList.add(row);
		}
		if(dataList==null || dataList.size()==0){
			// 没有数据就给出提示，不能导出
			return "noData";
		}
		String fileUrl = POIUtils.makeExcelFile(dataList, modelName, filePath);
		return fileName;
	}
	
	public String makeExcelFile(ArrayList dataList, String modelName,
			String filePath) {
		HSSFWorkbook templatewb = null;
		int perSize = 7000;
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					modelName));
			templatewb = new HSSFWorkbook(fs);
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
		try {
			int sheetNo = dataList.size() % perSize > 0 ? dataList.size()
					/ perSize + 1 : dataList.size() / perSize;
			for (int sheet = 0; sheet < sheetNo; sheet++) {
				HSSFSheet tosheet = templatewb.getSheetAt(sheet);

				// data row
				int size = dataList.size();
				HSSFRow templateRow = tosheet.getRow(1);
				HSSFCellStyle[] styles = new HSSFCellStyle[templateRow
						.getPhysicalNumberOfCells()];
				for (int i = 0; i < templateRow.getPhysicalNumberOfCells(); i++) {
					styles[i] = templateRow.getCell(i).getCellStyle();
				}
				int rowSize = (sheet + 1) * perSize > size ? size : (sheet + 1)
						* perSize;
				for (int rowId = sheet * perSize; rowId < rowSize; rowId++) {

					Object[] valueList = (Object[]) dataList.get(rowId);
					HSSFRow hssfRow = tosheet.createRow(rowId + 2);
					for (int columnId = 0; columnId < (0 + valueList.length); columnId++) {
						String dataValue = String.valueOf(valueList[columnId]);

						HSSFCell cell = hssfRow.createCell(columnId);

						cell.setCellValue(dataValue);

					}
				}
			}
			// write data to new file
			OutputStream os = new FileOutputStream(new File(filePath));
			templatewb.write(os);
			os.flush();
			os.close();
		} catch (OutOfMemoryError e) {
			logger.error("Data Exceeded!", e);
			return null;
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
		return filePath;

	}
	
	/**
	 * 保存 终端基础信息 <br>
	 * 
	 * save terminal basal information
	 * 
	 * @param terminalInfo
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean saveTerminalInfo(TermInfo terminalInfo) {
		validateTerminalInfo(terminalInfo);

		TermInfo existedTerminalInfo = terminalInfoDao
				.getByTermCode(terminalInfo.getTermCode());
		if (existedTerminalInfo != null)
			throw new AppException(
					MessageKeyConstants.TERM_EXISTED_TERMINAL_TERM_CODE,
					"The terminal Code has already existed. Please change the terminal Code and submit again. ");

		TermInfo existedTerminalInfo2 = terminalInfoDao.findUniqueBy("netAddr",
				terminalInfo.getNetAddr());
		if (existedTerminalInfo2 != null)
			throw new AppException(
					MessageKeyConstants.TERM_EXISTED_TERMINAL_NETADDR,
					"The terminal IP has already existed. Please change the terminal IP and submit again. ");

		if (terminalInfo.getId() == null) {
			terminalInfoDao.save(terminalInfo);
		} else {
			terminalInfoDao.copyUpdate(terminalInfo);
		}
		//同步SeNTServer
		syncSendToSentServerRightNow(1);
		return true;
	}

	/**
	 * 删除 终端基础信息 <br>
	 * 
	 * delete terminal basal information
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteTerminalInfo(String id) {
		validateId(id);
		terminalInfoDao.delete(id);
		
		return true;
	}
	
	/**
	 * 删除 终端基础信息 <br>
	 * 
	 * delete terminal basal information
	 * 
	 * @param id
	 * @return
	 */
	public boolean updateNoderInfo(String id) {
		terminalInfoDao.updateTermInfoForTermInfo(terminalInfoDao.get(id).getTermCode());
		
		return true;
	} 

	/**
	 * 校验id是否为空 <br>
	 * 
	 * check whether is it a empty id
	 * 
	 * @param id
	 */
	private void validateId(String id) {
		if (!StringUtils.hasText(id))
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
					"No record is selected. ");
	}

	/**
	 * 批量删除 终端基础信息 <br>
	 * 
	 * batch delete terminal basal information
	 * 
	 * @param ids
	 * @return
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0)
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
					"No record is selected. ");

		for (String id : ids) {
			updateNoderInfo(id);
			deleteTerminalInfo(id);

		}
		//同步SeNTServer
		syncSendToSentServerRightNow(1);
		return true;
	}

	/**
	 * 更新终端基础信息 <br>
	 * 
	 * update terminal basal information
	 * 
	 * @param terminalInfo
	 * @return
	 */
	public boolean updateTerminalInfo(TermInfo terminalInfo) {
		validateTerminalInfo(terminalInfo);
		String newId = terminalInfo.getId();
		validateId(newId);

		TermInfo existedTerminalInfo = terminalInfoDao
				.getByTermCode(terminalInfo.getTermCode());

		if (existedTerminalInfo != null) {
			if (!newId.equals(existedTerminalInfo.getId()))
				throw new AppException(
						MessageKeyConstants.TERM_EXISTED_TERMINAL_TERM_CODE,
						"The terminal Id has already existed. Please change the terminal Id and submit again. ");
		}

		TermInfo existedTerminalInfo2 = terminalInfoDao.findUniqueBy("netAddr",
				terminalInfo.getNetAddr());
		if (existedTerminalInfo2 != null) {
			if (!newId.equals(existedTerminalInfo2.getId()))
				throw new AppException(
						MessageKeyConstants.TERM_EXISTED_TERMINAL_NETADDR,
						"The Net Address has already existed. Please change the Net Address and submit again. ");
		}

		terminalInfoDao.copyUpdate(terminalInfo);
		//同步SeNTServer
		syncSendToSentServerRightNow(1);

		return true;
	}

	/**
	 * 根据终端编号查找分页的终端数据<br>
	 * 
	 * get 1 page of terminal by terminal and page information
	 * 
	 * @param page
	 * @param termCode
	 * @return
	 */
	public Page<TermInfo> getTermInfoPage(final Page<TermInfo> page,
			String termCode) {
		return terminalInfoDao.getByTermCodeFuzzily(page, termCode);
	}

	public Page<TermInfo> getTermInfoPageByParams(final Page<TermInfo> page,
			Map<String, String> params) {
		if (params.get("orgId") == null || params.get("orgId") == "") {
			params.remove("orgId");
			params.put("orgId", params.get("userOrgid"));
		}
		return terminalInfoDao.getTermInfoPageByParams(page, params);
	}

	public List getTermModelList(String status, String status1) {
		List<TermModel> termModels = terminalModelDao
				.find("from TermModel tm where tm.status = 'Y' ");

		return termModels;
	}

	/**
	 * 
	 * @param file
	 *            文件字节
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public String importTermInfoExcel(byte[] file) {
		StringBuffer errBuf = new StringBuffer(); // 错误信息

		List<TermInfoVO> importList = new ArrayList<TermInfoVO>();

		InputStream is = new ByteArrayInputStream(file);

		try {
			HSSFWorkbook wb = new HSSFWorkbook(is);
			importList = ImportExcelUtil.importExcel(wb, 0, TermInfoVO.class);
		} catch (Exception e) {
			logger.error("", e);
			return "excel内容格式错误,导入失败,请检查!";
			//throw new AppException(MessageKeyConstants.TERM_IMPORT_EXCEL_ERROR,
			//		"Import Excel error!");
		}

		// 做检查
		// 检查重复
		Set<String> idSet = new HashSet<String>();
		Set<String> ipSet = new HashSet<String>();
		String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		for (TermInfoVO obj : importList) {
			if(obj.getTermCode() == null || obj.getTermCode().trim().length() <= 0){
				return "终端编号必须输入";
			} else if (!idSet.contains(obj.getTermCode())) {
				idSet.add(obj.getTermCode());
			} else {
				errBuf.append("终端编号【" + obj.getTermCode() + "】重复\r\n");
			}
			
			//判断ip地址是否与正则表达式匹配     
			if(obj.getNetAddr() == null || obj.getNetAddr().trim().length() <= 0){
				return "终端IP必须输入";
			} else if(!obj.getNetAddr().matches(regex)){
				errBuf.append("终端IP【" + obj.getNetAddr() + "】格式错误\r\n");
				continue;
			} else if (!ipSet.contains(obj.getNetAddr())) {
				ipSet.add(obj.getNetAddr());
			} else {
				errBuf.append("终端IP【" + obj.getNetAddr() + "】重复\r\n");
				continue;
			}
			
			TermInfo existedTerminalInfo2 = terminalInfoDao.findUniqueBy("netAddr",
					obj.getNetAddr());
			if (existedTerminalInfo2 != null){
				errBuf.append("终端IP【" + obj.getNetAddr() + "】已存在\r\n");
			}
			//判断柜面ip地址是否与正则表达式匹配
			if(!obj.getTellerIp().matches(regex)){
				errBuf.append("柜面IP【" + obj.getTellerIp() + "】格式错误\r\n");
				continue;
			} else if (!ipSet.contains(obj.getTellerIp())) {
				ipSet.add(obj.getTellerIp());
			} else {
				errBuf.append("柜面IP【" + obj.getTellerIp() + "】重复\r\n");
				continue;
			}
			
			TermInfo existedTerminalInfo3 = terminalInfoDao.findUniqueBy("tellerIp",
					obj.getTellerIp());
			if (existedTerminalInfo3 != null){
				errBuf.append("柜面IP【" + obj.getTellerIp() + "】已存在\r\n");
			}
		}
		
		
		if (errBuf.length() > 0)
			return errBuf.toString();

		// 先检查机构号
		List<OrgInfo> orgList = orgInfoDao.getAll();
		Map<String, String> orgCodeMap = new HashMap<String, String>();
		for (OrgInfo orgInfo : orgList) {
			orgCodeMap.put(orgInfo.getOrgCode(), orgInfo.getId());
		}

		for (TermInfoVO ternInfo : importList) {
			if (ternInfo.getOrgCode() == null
					|| ternInfo.getOrgCode().trim().length() <= 0) {
				return "所属机构号必须输入";
			}
			if (!orgCodeMap.keySet().contains(ternInfo.getOrgCode())) {
				errBuf.append("终端编号【" + ternInfo.getTermCode() + "】的所属机构号【"
						+ ternInfo.getOrgCode() + "】不存在\r\n");
			}
		}

		if (errBuf.length() > 0) {
			return errBuf.toString();
		}

		// 检查区域
		List<Area> areaList = areaDao.getAll();

		Map<String, Area> areaMap = new HashMap<String, Area>();
		for (Area area : areaList) {
			areaMap.put(area.getAreaName(), area);
		}
		for (TermInfoVO obj : importList) {
			if (obj.getAreaName() == null
					|| obj.getAreaName().trim().length() <= 0) {
				return "所属区域必须输入";
			}
			if (!areaMap.containsKey(obj.getAreaName())) {
				errBuf.append("终端编号【" + obj.getTermCode() + "】的所属区域【"
						+ obj.getAreaName() + "】不存在\r\n");
			}
		}

		if (errBuf.length() > 0) {
			return errBuf.toString();
		}

		// 检查品牌信息
		List<TermBrand> brandList = terminalBrandDao.getAll();
		Map<String, String> brandMap = new HashMap<String, String>();
		for (TermBrand termBrand : brandList) {
			brandMap.put(termBrand.getBrandName(), termBrand.getId());
		}
		for (TermInfoVO obj : importList) {
			if (obj.getBrand() == null || obj.getBrand().trim().length() <= 0) {
				return "终端品牌必须输入";
			}
			if (!brandMap.keySet().contains(obj.getBrand())) {
				errBuf.append("终端编号【" + obj.getTermCode() + "】的终端品牌【"
						+ obj.getBrand() + "】不存在\r\n");
			}
		}

		if (errBuf.length() > 0) {
			return errBuf.toString();
		}

		// 检查类型
		List<TermType> typeList = terminalTypeDao.getAll();
		Map<String, String> typeMap = new HashMap<String, String>();
		for (TermType obj : typeList) {
			typeMap.put(obj.getType(), obj.getId());
		}
		for (TermInfoVO obj : importList) {
			if (obj.getTermType() == null
					|| obj.getTermType().trim().length() <= 0)
				return "终端类型必须输入";

			if (!typeMap.keySet().contains(obj.getTermType())) {
				errBuf.append("终端编号【" + obj.getTermCode() + "】的终端类型【"
						+ obj.getTermType() + "】不存在\r\n");
			}
		}

		if (errBuf.length() > 0) {
			return errBuf.toString();
		}

		// 检查机型
		List<TermModel> modelList = terminalModelDao.getAll();
		Map<String, String> modelMap = new HashMap<String, String>();
		for (TermModel obj : modelList) {
			modelMap.put(obj.getModelName(), obj.getId());
		}
		for (TermInfoVO termInfo : importList) {
			if (termInfo.getModel() == null
					|| termInfo.getModel().trim().length() <= 0) {
				return "设备型号必须输入";
			}
			if (!modelMap.keySet().contains(termInfo.getModel())) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的设备型号【"
						+ termInfo.getModel() + "】不存在\r\n");
			}
		}

		// 检查营业开始时间
		for (TermInfoVO obj : importList) {
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			if (obj.getBusiBeginTime() == null || obj.getBusiBeginTime().trim()==""){
				return "营业开始时间必须输入";
			}
			try{
				 sdf.parse(obj.getBusiBeginTime());
				}catch(Exception ex){
					errBuf.append("终端编号【" + obj.getTermCode() + "】的营业开始时间格式不对");
				}
		}
		
		// 检查营业结束时间
		for (TermInfoVO obj : importList) {
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			if (obj.getBusiEndTime() == null || obj.getBusiEndTime().trim()==""){
				return "营业结束时间必须输入";
			}
			try{
				 sdf.parse(obj.getBusiEndTime());
				}catch(Exception ex){
					errBuf.append("终端编号【" + obj.getTermCode() + "】的营业结束时间格式不对");
				}
		}

		if (errBuf.length() > 0) {
			return errBuf.toString();
		}

		List<SysDatadir> instTypeList = sysDatadirService
				.getDatadirChildrenByPath("SysDatadirMgr.javapt.term.instType",
						"zh_CN");
		Map<String, String> instTypeMap = new HashMap<String, String>();
		for (SysDatadir obj : instTypeList) {
			instTypeMap.put(obj.getValue(), obj.getKey());
		}

		List<SysDatadir> layTypeList = sysDatadirService
				.getDatadirChildrenByPath("SysDatadirMgr.javapt.term.layType",
						"zh_CN");
		Map<String, String> layTypeMap = new HashMap<String, String>();
		for (SysDatadir obj : layTypeList) {
			layTypeMap.put(obj.getValue(), obj.getKey());
		}

		List<SysDatadir> statusList = sysDatadirService
				.getDatadirChildrenByPath("SysDatadirMgr.javapt.term.status",
						"zh_CN");
		Map<String, String> statusMap = new HashMap<String, String>();
		for (SysDatadir obj : statusList) {
			statusMap.put(obj.getValue(), obj.getKey());
		}
		
		List<SysDatadir> machineTypeList = sysDatadirService
		.getDatadirChildrenByPath("SysDatadirMgr.javapt.term.machineType",
						"zh_CN");
		Map<String, String> machineTypeMap = new HashMap<String, String>();
		for (SysDatadir obj : machineTypeList) {
			machineTypeMap.put(obj.getValue(), obj.getKey());
		}
				
		

		List<TermInfo> list = new ArrayList<TermInfo>();

		for (TermInfoVO termInfo : importList) {
			TermInfo info = terminalInfoDao.getByTermCode(termInfo
					.getTermCode());
			if (info == null) {
				info = new TermInfo();
			}
			// 复制属性
			info.setTermCode(termInfo.getTermCode());
			info.setTermSEQ(termInfo.getTermSEQ());
			info.setCounterCode(termInfo.getCounterCode());
			info.setNetAddr(termInfo.getNetAddr());
			info.setTellerIp(termInfo.getTellerIp()) ;
			info.setTermAddr(termInfo.getTermAddr());
			info.setBusiBeginTime(termInfo.getBusiBeginTime());
			info.setBusiEndTime(termInfo.getBusiEndTime());
			info.setServiceType(termInfo.getServiceType());
			info.setIsVideoWatch(termInfo.getIsVideoWatch());
			info.setIsUPS(termInfo.getIsUPS());
			info.setIsInterATM(termInfo.getIsInterATM());
			info.setSoftVersion(termInfo.getSoftVersion());
			info.setSpVersion(termInfo.getSpVersion());
			info.setTermName(termInfo.getTermName());
			info.setConnserver(termInfo.getConnServer());
			info.setConnprotocol(termInfo.getConnProcotol());
			info.setConnline(termInfo.getConnLine());
			info.setVip(termInfo.getVip());
			info.setInterventionlevel(termInfo.getInterventionLevle());
			info.setAreaId(areaMap.get(termInfo.getAreaName()).getId());

			info.setTermType(typeMap.get(termInfo.getTermType()));
			info.setBrand(brandMap.get(termInfo.getBrand()));
			info.setModel(modelMap.get(termInfo.getModel())); 

			try {
				if (termInfo.getActiveDate() != null
						&& termInfo.getActiveDate().trim().length() > 0) {
					info.setActiveDate(FORMAT.parse(termInfo.getActiveDate()
							.replace("\\", "")));
				} else {
					info.setActiveDate(new Date());
				}
			} catch (ParseException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的开通时间格式错误\r\n");
			}

			try {
				if (termInfo.getInstDate() != null
						&& termInfo.getInstDate().trim().length() > 0) {
					info.setInstDate(FORMAT.parse(termInfo.getInstDate()
							.replace("\\", "")));
				} else {
					info.setInstDate(new Date());
				}
			} catch (ParseException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的安装日期格式错误\r\n");
			}
			try {
				if (termInfo.getServStartDate() != null
						&& termInfo.getServStartDate().trim().length() > 0) {
					info.setServStartDate(FORMAT.parse(termInfo
							.getServStartDate().replace("\\", "")));
				} else {
					info.setServStartDate(new Date());
				}
			} catch (ParseException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode()
						+ "】的维护开始日期格式错误\r\n");
			}
			try {
				if (termInfo.getServEndDate() != null
						&& termInfo.getServEndDate().trim().length() > 0) {
					info.setServEndDate(FORMAT.parse(termInfo.getServEndDate()
							.replace("\\", "")));
				} else {
					info.setServEndDate(FORMAT.parse("2099-12-31"));
				}
			} catch (ParseException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode()
						+ "】的维护结束日期格式错误\r\n");
			}

			try {
				if (termInfo.getNetPort() != null
						&& termInfo.getNetPort().trim().length() > 0) {
					info.setNetPort(Integer.valueOf(termInfo.getNetPort()));
				}
			} catch (NumberFormatException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的端口格式错误\r\n");
			}
			try {
				if (termInfo.getSaveBox() != null
						&& termInfo.getSaveBox().trim().length() > 0) {
					info.setSaveBox(Integer.valueOf(termInfo.getSaveBox()));
				}
			} catch (NumberFormatException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的存款箱数量错误\r\n");
			}
			try {
				if (termInfo.getCwdBox() != null
						&& termInfo.getCwdBox().trim().length() > 0) {
					info.setCwdBox(Integer.valueOf(termInfo.getCwdBox()));
				}
			} catch (NumberFormatException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的取款箱数量错误\r\n");
			}
			try {
				if (termInfo.getServYears() != null
						&& termInfo.getServYears().trim().length() > 0) {
					info.setServYears(Integer.valueOf(termInfo.getServYears()));
				}
			} catch (NumberFormatException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的维护年限错误\r\n");
			}
			try {
				if (termInfo.getCashLackNum() != null
						&& termInfo.getCashLackNum().trim().length() > 0) {
					info
							.setCashLackNum(Long.valueOf(termInfo
									.getCashLackNum()));
				}
			} catch (NumberFormatException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的钞少总张数错误\r\n");
			}
			try {
				if (termInfo.getCashFullNum() != null
						&& termInfo.getCashFullNum().trim().length() > 0) {
					info
							.setCashFullNum(Long.valueOf(termInfo
									.getCashFullNum()));
				}
			} catch (NumberFormatException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的钞满总张数错误\r\n");
			}
			try {
				if (termInfo.getCoinCashLackNum() != null
						&& termInfo.getCoinCashLackNum().trim().length() > 0) {
					info.setCoinCashLackNum(Long.valueOf(termInfo
							.getCoinCashLackNum()));
				}
			} catch (NumberFormatException e) {
				errBuf
						.append("终端编号【" + termInfo.getTermCode()
								+ "】的硬币钞少总张数错误\r\n");
			}
			try {
				if (termInfo.getCoinCashFullNum() != null
						&& termInfo.getCoinCashFullNum().trim().length() > 0) {
					info.setCoinCashFullNum(Long.valueOf(termInfo
							.getCoinCashFullNum()));
				}
			} catch (NumberFormatException e) {
				errBuf
						.append("终端编号【" + termInfo.getTermCode()
								+ "】的硬币钞满总张数错误\r\n");
			}
			try {
				if (termInfo.getX() != null
						&& termInfo.getX().trim().length() > 0) {
					info.setX(Double.valueOf(termInfo.getX()));
				}
			} catch (NumberFormatException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的经度错误\r\n");
			}
			try {
				if (termInfo.getY() != null
						&& termInfo.getY().trim().length() > 0) {
					info.setY(Double.valueOf(termInfo.getY()));
				}
			} catch (NumberFormatException e) {
				errBuf.append("终端编号【" + termInfo.getTermCode() + "】的维度错误\r\n");
			}

			if (termInfo.getInstType() != null
					&& termInfo.getInstType().trim().length() > 0) {
				if (!instTypeMap.keySet().contains(termInfo.getInstType())) {
					errBuf.append("终端编号【" + termInfo.getTermCode()
							+ "】的安装方式不正确\r\n");
				} else {
					info.setInstType(instTypeMap.get(termInfo.getInstType()));
				}
			} else {
				info.setInstType("inWall"); // 默认：入墙式
			}
			
			if (termInfo.getMachineType() != null
					&& termInfo.getMachineType().trim().length() > 0) {
				if (!machineTypeMap.keySet().contains(termInfo.getMachineType())) {
					errBuf.append("终端编号【" + termInfo.getTermCode()
							+ "】的机具类型不正确\r\n");
				}  else {
					info.setMachineType(machineTypeMap.get(termInfo.getMachineType()));
				}
			} else {
				info.setMachineType("0"); // 默认：清分机
			}

			if (termInfo.getLayType() != null
					&& termInfo.getLayType().trim().length() > 0) {
				if (!layTypeMap.keySet().contains(termInfo.getLayType())) {
					errBuf.append("终端编号【" + termInfo.getTermCode()
							+ "】的设立形式不正确\r\n");
				} else {
					info.setLayType(layTypeMap.get(termInfo.getLayType()));
				}
			} else {
				info.setLayType("1"); // 默认：在行
			}

			if (termInfo.getStatus() != null
					&& termInfo.getStatus().trim().length() > 0) {
				if (statusMap.containsValue(termInfo.getStatus())) { // 有初始化
					info.setStatus(termInfo.getStatus());
				} else if (!statusMap.keySet().contains(termInfo.getStatus())) {
					errBuf
							.append("终端编号【" + termInfo.getTermCode()
									+ "】的状态不正确\r\n");
				} else {
					info.setStatus(statusMap.get(termInfo.getStatus()));
				}
			} else {
				info.setStatus("1"); // 默认：开通
			}

			if (errBuf.length() > 0)
				return errBuf.toString();

			info.setOrgId(orgCodeMap.get(termInfo.getOrgCode()));
			// 实际加入添加列表
			list.add(info);
		}

		for (TermInfo obj : list) {
			try {
				saveTerminalInfo(obj);
			} catch (Exception ex) {
				// 保存出错需要继续处理其他的记录
				logger.error("The termial with termCode is "
						+ obj.getTermCode() + " import error!", ex);
			}
		}

		return "";
	}

	/**
	 * 根据当前语言获取表单或module的基础数据<br>
	 * 
	 * get init datas by language
	 * 
	 * @param language
	 * @return
	 */
	public Map<String, Object> getTermInfoFormInitDatas(String language) {
		Map<String, Object> formInitDatas = new HashMap<String, Object>();

		// get Term Model List from valid TermModel(status = 'Y')
		List<TermModel> termModels = terminalModelDao
				.find(" from TermModel tm ");
		formInitDatas.put("modelList", termModels);

		// get Term Brand List from valid TermBrand(status = 'Y')
		List<TermBrand> termBrands = terminalBrandDao
				.find("from TermBrand tb ");
		formInitDatas.put("brandList", termBrands);

		// get Term Type List from valid TermType(status = 'Y')
		List<TermType> termTypes = terminalTypeDao.find("from TermType tt ");
		formInitDatas.put("typeList", termTypes);

		// get serviceType List from datadir
		List<Object[]> serviceTypeList = sysDatadirService
				.getDatadirChildrenByPath(AppConstants.SERVICE_TYPE_PATH,
						language);
		formInitDatas.put("serviceTypeList", serviceTypeList);

		// get instType List from datadir
		List instTypeList = sysDatadirService.getDatadirChildrenByPath(
				AppConstants.INST_TYPE_PATH, language);
		formInitDatas.put("instTypeList", instTypeList);

		// get layType List from datadir
		List layTypeList = sysDatadirService.getDatadirChildrenByPath(
				AppConstants.LAY_TYPE_PATH, language);
		formInitDatas.put("layTypeList", layTypeList);
		
		// get machineType List from datadir
		List machineTypeList = sysDatadirService.getDatadirChildrenByPath(
				AppConstants.MACHINE_TYPE_PATH, language);
		if(machineTypeList!=null && !machineTypeList.isEmpty())
			machineTypeList.remove(machineTypeList.size()-1);
		formInitDatas.put("machineTypeList", machineTypeList);

		// get isVideoWatch List from datadir
		// List yesOrNo = sysDatadirService.getDatadirChildrenByPath(
		// AppConstants.YES_OR_NO,
		// language);
		// formInitDatas.put("yesOrNo", yesOrNo);

		return formInitDatas;
	}

	/**
	 * 根据当前语言获取表单或module的基础数据<br>
	 * 
	 * get init datas by language
	 * 
	 * @param language
	 * @return
	 */
	public Map<String, Object> getTermInfoInitDatas(String language) {
		Map<String, Object> formInitDatas = new HashMap<String, Object>();

		// get serviceType List from datadir
		List<Object[]> serviceTypeList = sysDatadirService
				.getDatadirChildrenByPath(AppConstants.SERVICE_TYPE_PATH,
						language);
		formInitDatas.put("serviceTypeList", serviceTypeList);

		// get instType List from datadir
		List instTypeList = sysDatadirService.getDatadirChildrenByPath(
				AppConstants.INST_TYPE_PATH, language);
		formInitDatas.put("instTypeList", instTypeList);

		// get layType List from datadir
		List layTypeList = sysDatadirService.getDatadirChildrenByPath(
				AppConstants.LAY_TYPE_PATH, language);
		formInitDatas.put("layTypeList", layTypeList);

		// get isVideoWatch List from datadir
		// List yesOrNo = sysDatadirService.getDatadirChildrenByPath(
		// AppConstants.YES_OR_NO,
		// language);
		// formInitDatas.put("yesOrNo", yesOrNo);

		formInitDatas.putAll(getTermBaseInfoDatas());

		return formInitDatas;
	}

	/**
	 * 获取终端品牌，型号，类型信息
	 * 
	 * @return
	 */
	public Map<String, Object> getTermBaseInfoDatas() {
		Map<String, Object> formInitDatas = new HashMap<String, Object>();
		// get Term Model List from valid TermModel(status = 'Y')
		List<TermModel> termModels = terminalModelDao
				.find(" from TermModel tm where tm.status = 'Y' and "
						+ "tm.brand in ( from TermBrand tb where tb.status = 'Y') and "
						+ "tm.type in ( from TermType tt where tt.status = 'Y') ");
		formInitDatas.put("modelList", termModels);

		// get Term Brand List from valid TermBrand(status = 'Y')
		List<TermBrand> termBrands = terminalBrandDao
				.find("from TermBrand tb where tb.status = 'Y' ");
		formInitDatas.put("brandList", termBrands);

		// get Term Type List from valid TermType(status = 'Y')
		List<TermType> termTypes = terminalTypeDao
				.find("from TermType tt where tt.status = 'Y' ");
		formInitDatas.put("typeList", termTypes);
		return formInitDatas;
	}

	private boolean validateTerminalInfo(TermInfo terminalInfo) {
		if (terminalInfo == null)
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");

		if (!StringUtils.hasText(terminalInfo.getTermCode()))
			throw new AppException(
					MessageKeyConstants.TERM_TERMINAL_TERM_CODE_NOT_NULL,
					"Terminal ID can not be left empty. Please input terminal ID and submit again.");
		return true;

	}

	/**
	 * 
	 */
	public boolean isExistsByTermCode(String termCode) {
		String hql = " select 1 from TermInfo t where t.termCode=?";
		Integer r = terminalInfoDao.findFirst(hql, termCode);
		if (r == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 */
	public List<TermInfo> getTermInfoListByTermCodes(String termCodes) {
		return terminalInfoDao.getTermInfoListByTermCodes(termCodes);
	}

	//根据冠字号记录，查询终端设备
	public TermInfo getTermInfoById(Map<String,Object> para) {
		
		String id = (String)para.get("p_termid");
		//TermInfo termInfo = terminalInfoDao.get(id);
		String hql = "from TermInfo t where t.termCode=?";
		List<TermInfo> infoLst = terminalInfoDao.find(hql, new Object[]{id});
		if(infoLst.size()==1){
			return infoLst.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 根据终端号获取所属的机构名称和PathCode
	 * 
	 * @param termCode
	 * @return
	 */
	public String getOrgPathAndNameByTermCode(String termCode){
		TermInfo termInfo = terminalInfoDao.getByTermCode(termCode);
		if(termInfo != null){
			OrgInfo orgInfo = orgInfoDao.get(termInfo.getOrgId());
			if(orgInfo != null){
				return orgInfo.getOrgName() + "," + orgInfo.getPathCode();
			}
		}
		return AppConstants.ORG_CHINA_ORGNAME + "," + AppConstants.ORG_CHINA_PATHCODE;// 默认返回
	}
	
	public String[] getTermInfoForPrint(String termCode)
	{
		TermInfo termInfo = terminalInfoDao.getByTermCode(termCode);
		List<TermModel> termModels = termModelService.getAllTermModel();
		List<TermBrand> termBrands = termBrandService.getAllTermBrand();
		List<TermType> termTypes = termTypeService.getAllTermType();
		String orgName;
		String ip = termInfo.getNetAddr();
		String termModelName = "";
		String termBrandName = "";
		String termTypeName = "";
		for (TermModel termModel : termModels) {
			if (termModel.getId().equals(termInfo.getModel())) {
				termModelName = termModel.getModelName();
				break;
			}
		}
		
		for (TermBrand termBrand : termBrands) {
			if (termBrand.getId().equals(termInfo.getBrand())) {
				termBrandName = termBrand.getBrandName();
				break;
			}
		}
		
		
		for (TermType termType : termTypes) {
			if (termType.getId().equals(termInfo.getTermType())) {
				termTypeName = termType.getTypeName();		
				break;
			}
		}
		
		orgName = orgInfoDao.get(termInfo.getOrgId()).getOrgName().toString();
	
		String boxQRCodePrintSwitch = "0";
		
		try{
			boxQRCodePrintSwitch = paramDao
				.getValueByPath(com.grgbanking.sent.common.Constants.AppConstants.BOX_QRCODE_RPINT_SWITCH)==null?"0":paramDao
						.getValueByPath(com.grgbanking.sent.common.Constants.AppConstants.BOX_QRCODE_RPINT_SWITCH);
		}catch(Exception e){
			boxQRCodePrintSwitch = "0";
		}
		String[] s1 = {orgName,ip,termModelName,termBrandName,termTypeName,boxQRCodePrintSwitch};
		return s1;
	}
	
	
	public void syncSendToSentServerRightNow(int synchType) {
		S2005Msg smsg = new S2005Msg();
		String messageNo = String.valueOf(new Date().getTime())
				.substring(1, 13);
		smsg.setType(17);
		smsg.setMessageno(Integer.parseInt(messageNo.substring(0, 9)));
		smsg.setDevidLen(0);
		smsg.setLength(4);
		smsg.setSynchInfoLen(0);
		smsg.setSynchType(synchType);

		byte[] sendpack = smsg.packMessage();

		Transfer transfer = new Transfer();
		transfer.initByService(paramDao);
		SyncThread syncThread= new SyncThread();
		syncThread.transfer = transfer;
		syncThread.sendpack = sendpack;
		syncThread.start();

	}
	
	 class SyncThread extends Thread{
         private Transfer transfer;  
         private byte[] sendpack;

		    public void run(){ 
		    	try {
					transfer.sendPack(sendpack);
				} catch (IOException e) {
					logger.error("", e);
				}
		    }
	}
}
