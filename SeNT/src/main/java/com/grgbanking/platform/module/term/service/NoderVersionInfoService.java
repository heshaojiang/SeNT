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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.dao.NoderVersionInfoDao;
import com.grgbanking.platform.module.term.entity.NoderVersionInfo;
import com.grgbanking.platform.module.term.entity.TermBrand;
import com.grgbanking.platform.module.term.entity.TermModel;
import com.grgbanking.platform.module.term.entity.TermType;
import com.grgbanking.sent.stride.utils.StrideZipFsnContentUtil;
import com.grgbanking.sent.stride.utils.ZipUtil;
import com.grgbanking.sent.utils.StringUtil;
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
// "com.grgbanking.platform.module.term.service.wsinterface.INoderInfoService")
public class NoderVersionInfoService {
	private static Logger logger = LoggerFactory
			.getLogger(NoderVersionInfoService.class);
	/** 扩展属性
	public static Map<String, String> exPropertyMap = new HashMap<String, String>();

	@Autowired
	public void loadExproperty(ExPropertyService service,
			ExtendPropertyDao exPropertyDao) {
		List<ExtendProperty> exPropertyList = service
				.getExtendPropertyList(NoderInfo.TABLE_NAME);
		for (ExtendProperty ex : exPropertyList) {
			exPropertyMap
					.put(ex.getPropertyName(), ex.getEntityClassProperty());
		}
	}
 */
	@Autowired
	NoderVersionInfoDao noderVersionDao ;
	@Autowired
	ParamDao paramDao;

	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Transactional
	public Page<NoderVersionInfo> getNoderVersionInfoPageByParams(final Page<NoderVersionInfo> page,
			Map<String, String> params) {
		return noderVersionDao.getNoderVersionInfoPageByParams(page, params) ;
	}
	
	@Transactional
	public boolean auditRegulation(NoderVersionInfo noderVersionInfo) {
		if(noderVersionInfo == null){
			return false ;
		}
		noderVersionInfo.setCheckTime(new Date()) ;
//		if(noderVersionInfo.getRelayVersion() == 0) {
//			noderVersionInfo.setRelayVersion(new Integer(null)) ;
//		}
		noderVersionDao.copyUpdate(noderVersionInfo);
		return true ;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean saveNoderinalInfo(NoderVersionInfo noderVersionInfo) {

//		NoderVersionInfo existedNoderVersionInfo = NoderVersionInfoDao
//				.getByNoderIp(NoderVersionInfo.getNoderIP());
//		if (existedNoderVersionInfo != null)
//			throw new AppException(
//					MessageKeyConstants.TERM_EXISTED_TERMINAL_NETADDR,
//					"The noder address has already existed. Please change the noder ip and submit again. ");

//		String termStrSelectInOtherNoder = NoderVersionInfoDao.checkTermIsSelectInOtherNoder(NoderVersionInfo.getId(), NoderVersionInfo.getDevice());
//		if(termStrSelectInOtherNoder!=null && termStrSelectInOtherNoder!=""){
//			throw new AppPlaceHolderException(MessageKeyConstants.TERM_IS_SELECT_IN_OTHER_NODER, "The terminal [%s] is seleced in other noder. can not choose again. ", termStrSelectInOtherNoder);
//		}
		if(noderVersionInfo == null){
			return false;
		}
		noderVersionInfo.setCreateTime(new Date()) ;
//		if(noderVersionInfo.getRelayVersion() == 0) {
//			noderVersionInfo.setRelayVersion(new Integer(null)) ;
//		}
		if (noderVersionInfo.getId() == null) {
			noderVersionInfo.setStatus("00") ;
			noderVersionDao.save(noderVersionInfo);
		} else {
			noderVersionDao.copyUpdate(noderVersionInfo);
		}
		//同步SeNTServer
		//syncSendToSentServerRightNow(1);
		return true;
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
			if(!deleteNoderVersionInfo(id)){
				return false;
			}
		}

		return true;
	}
	
	public String batchDeleteByStringResult(Collection<String> ids) {
		if (ids == null || ids.size() == 0)
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
					"No record is selected. ");

		for (String id : ids) {
			if(!deleteNoderVersionInfo(id)){
				return "删除【"+noderVersionDao.get(id).getPackageName()+"】升级包失败";
			}
		}

		return "success";
	}

	/**
	 * 删除 终端基础信息 <br>
	 * 
	 * delete terminal basal information
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteNoderVersionInfo(String id) {
		validateId(id);
		if(!deleteNoderVersionFile(id)){
			return false;
		}
		noderVersionDao.delete(id);
		//同步SeNTServer
		//syncSendToSentServerRightNow(1);
		return true;
	}
	
	
	/**
	 * 删除更新包
	 * @param noderVersionId   待删除的节点机更新包ID
	 * @return
	 */
	public boolean deleteNoderVersionFile(String noderVersionId){
		NoderVersionInfo noderVersionInfo = noderVersionDao.get(noderVersionId);
		String filePath = getZipPathForImportNoderUpdatePackage()+noderVersionInfo.getPackageName();
		File packageFile = new File(filePath);
		if(packageFile.exists()){
			return packageFile.delete();
		}else{
			return true;
		}
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

	
//	public Page<NoderVersionInfo> getNoderVersionInfoPageByParams(final Page<NoderVersionInfo> page,
//	Map<String, String> params) {
//if (params.get("orgId") == null || params.get("orgId") == "") {
//	params.remove("orgId");
//	params.put("orgId", params.get("userOrgid"));
//}
//Page pageResult = NoderVersionInfoDao.getNoderVersionInfoPageByParams(page, params);
//List<NoderVersionInfo> NoderVersionInfos = pageResult.getResult() ;
//for(NoderVersionInfo NoderVersionInfo : NoderVersionInfos) {
//	OrgInfo oi = orgInfoDao.getByOrgCode(NoderVersionInfo.getOrgCode()) ;
//	if(oi != null) {
//		NoderVersionInfo.setOrgName(oi.getOrgName()) ;
//	}
//}
//return pageResult;
//}
	
	
//	@Autowired
//	NoderVersionInfoDao NoderVersionInfoDao;
//
//	@Autowired
//	TermModelDao terminalModelDao;
//
//	@Autowired
//	TermBrandDao terminalBrandDao;
//
//	@Autowired
//	TermTypeDao terminalTypeDao;
//
//	@Autowired
//	SysDatadirService sysDatadirService;
//
//	@Autowired
//	OrgInfoDao orgInfoDao;
//
//	@Autowired
//	AreaDao areaDao;
//	
//	@Autowired
//	TermModelService termModelService;
//	@Autowired
//	TermBrandService termBrandService;
//	@Autowired
//	TermTypeService termTypeService;
//	@Autowired
//	AreaService areaService;
//	@Autowired
//	ParamDao paramDao;
//
//	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
//	private static SimpleDateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
//	public String exportNoderVersionInfo(Map<String, String> params) {
//		if(params.get("orgId")==null || params.get("orgId")==""){
//			params.remove("orgId");
//			params.put("orgId", params.get("userOrgid"));
//		}
//		Boolean isPrintTemplate = (params.get("isPrintTemplate").equals("0"));
//		List terList = new ArrayList();
//		if(!isPrintTemplate){
//			terList = NoderVersionInfoDao.getNoderVersionInfoPageByParams(params);
//		}
//		
//		ArrayList<Object[]> dataList = new ArrayList<Object[]>();
//		HttpServletRequest request = FlexContext.getHttpRequest();
//
//		String fileName = UUID.randomUUID() + "Noder.xls";
//		String filePath = request.getSession().getServletContext().getRealPath(
//				"")
//				+ File.separator + "exportFile" + File.separator + fileName;// 导出文件路径
//		String modelName = request.getSession().getServletContext()
//				.getRealPath("")
//				+ File.separator
//				+ "exportFile"
//				+ File.separator + "Noder1.xls";// 文件模板路径
//		
//		Object[] row;
//		List<OrgInfo> orgInfos = orgInfoDao.getAll();
//		List<Area> areas = areaService.getAllArea();
//		for (int i = 0; i < terList.size(); i++) {
//			row = new Object[8];
//			NoderVersionInfo termInfo = (NoderVersionInfo) terList.get(i);
//			row[0] = termInfo.getTermCode();
//			for (OrgInfo orgInfo : orgInfos) {
//				if(orgInfo.getId().equals(termInfo.getOrgId())) {
//					row[1] = orgInfo.getOrgName();
//					break;
//				}
//			}
//			// row[1] = termInfo.getOrgId();
//			row[2] = termInfo.getNetAddr();
//			
//			for (Area area : areas) {
//				if (area.getId().equals(termInfo.getAreaId())) {
//					row[3] = area.getAreaName();
//					break;
//				}
//				
//			}
//			if("2".equals(termInfo.getRunningStatus())){
//				row[4] = "离线";
//			}else{
//				row[4] = "0".equals(termInfo.getRunningStatus())?"正常":"故障";
//			}
//			row[5] = termInfo.getStatusTime()==null?"":TIMEFORMAT.format(termInfo.getStatusTime());
//			row[6] = termInfo.getParameter()==null?"":termInfo.getParameter();
//			row[7] = termInfo.getDevice()==null?"":termInfo.getDevice();
//			dataList.add(row);
//		}
//		if(dataList==null || dataList.size()==0){
//			// 没有数据就给出提示，不能导出
//			return "noData";
//		}
//		String fileUrl = POIUtils.makeExcelFile(dataList, modelName, filePath);
//		return fileName;
//	}
	
//	public String makeExcelFile(ArrayList dataList, String modelName,
//			String filePath) {
//		HSSFWorkbook templatewb = null;
//		int perSize = 7000;
//		try {
//			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
//					modelName));
//			templatewb = new HSSFWorkbook(fs);
//		} catch (Exception ex) {
//			logger.error("", ex);
//			return null;
//		}
//		try {
//			int sheetNo = dataList.size() % perSize > 0 ? dataList.size()
//					/ perSize + 1 : dataList.size() / perSize;
//			for (int sheet = 0; sheet < sheetNo; sheet++) {
//				HSSFSheet tosheet = templatewb.getSheetAt(sheet);
//
//				// data row
//				int size = dataList.size();
//				HSSFRow templateRow = tosheet.getRow(1);
//				HSSFCellStyle[] styles = new HSSFCellStyle[templateRow
//						.getPhysicalNumberOfCells()];
//				for (int i = 0; i < templateRow.getPhysicalNumberOfCells(); i++) {
//					styles[i] = templateRow.getCell(i).getCellStyle();
//				}
//				int rowSize = (sheet + 1) * perSize > size ? size : (sheet + 1)
//						* perSize;
//				for (int rowId = sheet * perSize; rowId < rowSize; rowId++) {
//
//					Object[] valueList = (Object[]) dataList.get(rowId);
//					HSSFRow hssfRow = tosheet.createRow(rowId + 2);
//					for (int columnId = 0; columnId < (0 + valueList.length); columnId++) {
//						String dataValue = String.valueOf(valueList[columnId]);
//
//						HSSFCell cell = hssfRow.createCell(columnId);
//
//						cell.setCellValue(dataValue);
//
//					}
//				}
//			}
//			// write data to new file
//			OutputStream os = new FileOutputStream(new File(filePath));
//			templatewb.write(os);
//			os.flush();
//			os.close();
//		} catch (OutOfMemoryError e) {
//			logger.error("Data Exceeded!", e);
//			return null;
//		} catch (Exception ex) {
//			logger.error("", ex);
//			return null;
//		}
//		return filePath;
//
//	}
	
	/**
	 * 保存 终端基础信息 <br>
	 * 
	 * save terminal basal information
	 * 
	 * @param NoderVersionInfo
	 * @return
	 */
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
//	public boolean saveNoderinalInfo(NoderVersionInfo NoderVersionInfo) {
//
//		NoderVersionInfo existedNoderVersionInfo = NoderVersionInfoDao
//				.getByNoderIp(NoderVersionInfo.getNoderIP());
//		if (existedNoderVersionInfo != null)
//			throw new AppException(
//					MessageKeyConstants.TERM_EXISTED_TERMINAL_NETADDR,
//					"The noder address has already existed. Please change the noder ip and submit again. ");
//
//		String termStrSelectInOtherNoder = NoderVersionInfoDao.checkTermIsSelectInOtherNoder(NoderVersionInfo.getId(), NoderVersionInfo.getDevice());
//		if(termStrSelectInOtherNoder!=null && termStrSelectInOtherNoder!=""){
//			throw new AppPlaceHolderException(MessageKeyConstants.TERM_IS_SELECT_IN_OTHER_NODER, "The terminal [%s] is seleced in other noder. can not choose again. ", termStrSelectInOtherNoder);
//		}
//		if (NoderVersionInfo.getId() == null) {
//			int version = 0;
//			NoderVersionInfo.setVersion(version);
//			NoderVersionInfoDao.save(NoderVersionInfo);
//		} else {
//			NoderVersionInfoDao.copyUpdate(NoderVersionInfo);
//		}
//		//同步SeNTServer
//		syncSendToSentServerRightNow(1);
//		return true;
//	}

	/**
	 * 删除 终端基础信息 <br>
	 * 
	 * delete terminal basal information
	 * 
	 * @param id
	 * @return
	 */
//	public boolean deleteNoderVersionInfo(String id) {
//		validateId(id);
//		NoderVersionInfoDao.delete(id);
//		//同步SeNTServer
//		syncSendToSentServerRightNow(1);
//		return true;
//	}

	/**
	 * 校验id是否为空 <br>
	 * 
	 * check whether is it a empty id
	 * 
	 * @param id
	 */
//	private void validateId(String id) {
//		if (!StringUtils.hasText(id))
//			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
//					"No record is selected. ");
//	}

	
	/**
	 * 更新终端基础信息 <br>
	 * 
	 * update terminal basal information
	 * 
	 * @param NoderVersionInfo
	 * @return
	 */
//	public boolean updateNoderinalInfo(NoderVersionInfo NoderVersionInfo) {
//		String newId = NoderVersionInfo.getId();
//		validateId(newId);
//
//		NoderVersionInfo existedNoderVersionInfo = NoderVersionInfoDao.getByNoderIp(NoderVersionInfo.getNoderIP()) ;
//
//		if (existedNoderVersionInfo != null) {
//			if (!newId.equals(existedNoderVersionInfo.getId()))
//				throw new AppException(
//						MessageKeyConstants.TERM_EXISTED_TERMINAL_TERM_CODE,
//						"The terminal Id has already existed. Please change the terminal Id and submit again. ");
//		}

//		NoderVersionInfo.setOrgId(orgInfoDao.getByOrgCode(NoderVersionInfo.getTermCode()).getId());
//		String termStrSelectInOtherNoder = NoderVersionInfoDao.checkTermIsSelectInOtherNoder(NoderVersionInfo.getId(), NoderVersionInfo.getDevice());
//		if(termStrSelectInOtherNoder!=null && termStrSelectInOtherNoder!=""){
//			throw new AppPlaceHolderException(MessageKeyConstants.TERM_IS_SELECT_IN_OTHER_NODER, "The terminal [%s] is seleced in other noder. can not choose again. ", termStrSelectInOtherNoder);
//		}
////		String version = "v_" + Long.toString(System.currentTimeMillis());
////		NoderVersionInfo.setInfoVersion(version);
//		
//		NoderVersionInfoDao.copyUpdate(NoderVersionInfo);
//		//同步SeNTServer
//		syncSendToSentServerRightNow(1);
//
//		return true;
//	}

	/**
	 * 根据终端编号查找分页的终端数据<br>
	 * 
	 * get 1 page of terminal by terminal and page information
	 * 
	 * @param page
	 * @param termCode
	 * @return
	 */
//	public Page<NoderVersionInfo> getNoderVersionInfoPage(final Page<NoderVersionInfo> page,
//			String termCode) {
//		return NoderVersionInfoDao.getByTermCodeFuzzily(page, termCode);
//	}
//

//
//	public List getTermModelList(String status, String status1) {
//		List<TermModel> termModels = terminalModelDao
//				.find("from TermModel tm where tm.status = 'Y' ");
//
//		return termModels;
//	}

	/**
	 * 
	 * @param file
	 *            文件字节
	 */
//	@Transactional(propagation = Propagation.NOT_SUPPORTED)
//	public String importNoderVersionInfoExcel(byte[] file) {
//		StringBuffer errBuf = new StringBuffer(); // 错误信息
//
//		List<NoderVersionInfoVO> importList = new ArrayList<NoderVersionInfoVO>();
//
//		InputStream is = new ByteArrayInputStream(file);
//
//		try {
//			HSSFWorkbook wb = new HSSFWorkbook(is);
//			importList = ImportExcelUtil.importExcel(wb, 0, NoderVersionInfoVO.class);
//		} catch (Exception e) {
//			logger.error("", e);
//			return "excel内容格式错误,导入失败,请检查!";
////			throw new AppException(MessageKeyConstants.TERM_IMPORT_EXCEL_ERROR,
////					"Import Excel error!");
//		}
//
//		// 做检查
//		// 检查重复
//		Set<String> idSet = new HashSet<String>();
//		Set<String> ipSet = new HashSet<String>();
//		String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
//		for (NoderVersionInfoVO obj : importList) {
//			if(obj.getOrgCode() == null || obj.getOrgCode().trim().length() <= 0){
//				return "所属机构号必须输入";
//			} else if (!idSet.contains(obj.getOrgCode())) {
//				idSet.add(obj.getOrgCode());
//			} else {
//				errBuf.append("所属机构号【" + obj.getOrgCode() + "】重复\r\n");
//			}
//			
//			//判断ip地址是否与正则表达式匹配     
//			if(obj.getNetAddr() == null || obj.getNetAddr().trim().length() <= 0){
//				return "终端IP必须输入";
//			} else if(!obj.getNetAddr().matches(regex)){
//				errBuf.append("终端IP【" + obj.getNetAddr() + "】格式错误\r\n");
//				continue;
//			} else if (!ipSet.contains(obj.getNetAddr())) {
//				ipSet.add(obj.getNetAddr());
//			} else {
//				errBuf.append("终端IP【" + obj.getNetAddr() + "】重复\r\n");
//				continue;
//			}
//			
//			NoderVersionInfo existedNoderVersionInfo2 = NoderVersionInfoDao.findUniqueBy("netAddr",
//					obj.getNetAddr());
//			if (existedNoderVersionInfo2 != null){
//				errBuf.append("终端IP【" + obj.getNetAddr() + "】已存在\r\n");
//			}
//		}
//		if (errBuf.length() > 0)
//			return errBuf.toString();
//
//		// 先检查机构号
//		List<OrgInfo> orgList = orgInfoDao.getAll();
//		Map<String, String> orgCodeMap = new HashMap<String, String>();
//		for (OrgInfo orgInfo : orgList) {
//			orgCodeMap.put(orgInfo.getOrgCode(), orgInfo.getId());
//		}
//
//		for (NoderVersionInfoVO ternInfo : importList) {
//			if (ternInfo.getOrgCode() == null
//					|| ternInfo.getOrgCode().trim().length() <= 0) {
//				return "所属机构号必须输入";
//			}
//			if (!orgCodeMap.keySet().contains(ternInfo.getOrgCode())) {
//				errBuf.append("所属机构号【"
//						+ ternInfo.getOrgCode() + "】不存在\r\n");
//			}
//		}
//
//		if (errBuf.length() > 0) {
//			return errBuf.toString();
//		}
//
//		// 检查区域
//		List<Area> areaList = areaDao.getAll();
//
//		Map<String, Area> areaMap = new HashMap<String, Area>();
//		for (Area area : areaList) {
//			areaMap.put(area.getAreaName(), area);
//		}
//		for (NoderVersionInfoVO obj : importList) {
//			if (obj.getAreaName() == null
//					|| obj.getAreaName().trim().length() <= 0) {
//				return "所属区域必须输入";
//			}
//			if (!areaMap.containsKey(obj.getAreaName())) {
//				errBuf.append("所属区域【"
//						+ obj.getAreaName() + "】不存在\r\n");
//			}
//		}
//
//		if (errBuf.length() > 0) {
//			return errBuf.toString();
//		}
//		
//		for (NoderVersionInfoVO obj : importList) {
//			NoderVersionInfo info = NoderVersionInfoDao.getByTermCode(obj
//					.getOrgCode());
//			String termStrSelectInOtherNoder = NoderVersionInfoDao.checkTermIsSelectInOtherNoder(info==null?null:info.getId(), obj.getDevice());
//			if(termStrSelectInOtherNoder!=null && termStrSelectInOtherNoder!=""){
//				errBuf.append("设备信息【"
//						+ obj.getDevice() + "】有误,请检查\r\n");
//			}
//
//		}
//
//		if (errBuf.length() > 0) {
//			return errBuf.toString();
//		}
//
//		List<NoderVersionInfo> list = new ArrayList<NoderVersionInfo>();
//
//		for (NoderVersionInfoVO termInfo : importList) {
//			NoderVersionInfo info = NoderVersionInfoDao.getByTermCode(termInfo
//					.getOrgCode());
//			if (info == null) {
//				info = new NoderVersionInfo();
//			}
//			// 复制属性
//			info.setTermCode(termInfo.getOrgCode());
//			info.setNetAddr(termInfo.getNetAddr());
//			info.setAreaId(areaMap.get(termInfo.getAreaName()).getId());
//			//info.setRunningStatus(termInfo.getRunningStatus());
//			info.setDevice(termInfo.getDevice());
//			info.setParameter(termInfo.getParameter());
//			info.setMachineType(TermInfoConsts.MACHINE_TYPE_NODER);
//
//
//
//			
//			if (errBuf.length() > 0)
//				return errBuf.toString();
//
//			info.setOrgId(orgCodeMap.get(termInfo.getOrgCode()));
//			// 实际加入添加列表
//			list.add(info);
//		}
//
//		for (NoderVersionInfo obj : list) {
//			try {
//				saveNoderinalInfo(obj);
//			} catch (Exception ex) {
//				// 保存出错需要继续处理其他的记录
//				logger.error("The termial with termCode is "
//						+ obj.getTermCode() + " import error!", ex);
//			}
//		}
//
//		return "";
//	}

	/**
	 * 根据当前语言获取表单或module的基础数据<br>
	 * 
	 * get init datas by language
	 * 
	 * @param language
	 * @return
	 */
	public Map<String, Object> getNoderVersionInfoFormInitDatas(String language) {
		System.out
				.println("NoderVersionInfoService.getNoderVersionInfoFormInitDatas()");
		Map<String, Object> formInitDatas = new HashMap<String, Object>();

		int newVersion = noderVersionDao.getNewVersionNum() ;
		List<Integer> versions = noderVersionDao.getVersionList() ;
		
		formInitDatas.put("newVersion", newVersion) ;
		formInitDatas.put("versionList", versions) ; 
//		// get Term Model List from valid TermModel(status = 'Y')
//		List<TermModel> termModels = terminalModelDao
//				.find(" from TermModel tm ");
//		formInitDatas.put("modelList", termModels);
//
//		// get Term Brand List from valid TermBrand(status = 'Y')
//		List<TermBrand> termBrands = terminalBrandDao
//				.find("from TermBrand tb ");
//		formInitDatas.put("brandList", termBrands);
//
//		// get Term Type List from valid TermType(status = 'Y')
//		List<TermType> termTypes = terminalTypeDao.find("from TermType tt ");
//		formInitDatas.put("typeList", termTypes);
//
//		// get serviceType List from datadir
//		List<Object[]> serviceTypeList = sysDatadirService
//				.getDatadirChildrenByPath(AppConstants.SERVICE_TYPE_PATH,
//						language);
//		formInitDatas.put("serviceTypeList", serviceTypeList);
//
//		// get instType List from datadir
//		List instTypeList = sysDatadirService.getDatadirChildrenByPath(
//				AppConstants.INST_TYPE_PATH, language);
//		formInitDatas.put("instTypeList", instTypeList);
//
//		// get layType List from datadir
//		List layTypeList = sysDatadirService.getDatadirChildrenByPath(
//				AppConstants.LAY_TYPE_PATH, language);
//		formInitDatas.put("layTypeList", layTypeList);
//		
//		// get machineType List from datadir
//		List machineTypeList = sysDatadirService.getDatadirChildrenByPath(
//				AppConstants.MACHINE_TYPE_PATH, language);
//		formInitDatas.put("machineTypeList", machineTypeList);

		// get isVideoWatch List from datadir
		// List yesOrNo = sysDatadirService.getDatadirChildrenByPath(
		// AppConstants.YES_OR_NO,
		// language);
		// formInitDatas.put("yesOrNo", yesOrNo);

		return formInitDatas;
	}
//
//	/**
//	 * 根据当前语言获取表单或module的基础数据<br>
//	 * 
//	 * get init datas by language
//	 * 
//	 * @param language
//	 * @return
//	 */
//	public Map<String, Object> getNoderVersionInfoInitDatas(String language) {
//		Map<String, Object> formInitDatas = new HashMap<String, Object>();
//
//		// get serviceType List from datadir
//		List<Object[]> serviceTypeList = sysDatadirService
//				.getDatadirChildrenByPath(AppConstants.SERVICE_TYPE_PATH,
//						language);
//		formInitDatas.put("serviceTypeList", serviceTypeList);
//
//		// get instType List from datadir
//		List instTypeList = sysDatadirService.getDatadirChildrenByPath(
//				AppConstants.INST_TYPE_PATH, language);
//		formInitDatas.put("instTypeList", instTypeList);
//
//		// get layType List from datadir
//		List layTypeList = sysDatadirService.getDatadirChildrenByPath(
//				AppConstants.LAY_TYPE_PATH, language);
//		formInitDatas.put("layTypeList", layTypeList);
//
//		// get isVideoWatch List from datadir
//		// List yesOrNo = sysDatadirService.getDatadirChildrenByPath(
//		// AppConstants.YES_OR_NO,
//		// language);
//		// formInitDatas.put("yesOrNo", yesOrNo);
//
//		formInitDatas.putAll(getTermBaseInfoDatas());
//
//		return formInitDatas;
//	}
//
//	/**
//	 * 获取终端品牌，型号，类型信息
//	 * 
//	 * @return
//	 */
//	public Map<String, Object> getTermBaseInfoDatas() {
//		Map<String, Object> formInitDatas = new HashMap<String, Object>();
//		// get Term Model List from valid TermModel(status = 'Y')
//		List<TermModel> termModels = terminalModelDao
//				.find(" from TermModel tm where tm.status = 'Y' and "
//						+ "tm.brand in ( from TermBrand tb where tb.status = 'Y') and "
//						+ "tm.type in ( from TermType tt where tt.status = 'Y') ");
//		formInitDatas.put("modelList", termModels);
//
//		// get Term Brand List from valid TermBrand(status = 'Y')
//		List<TermBrand> termBrands = terminalBrandDao
//				.find("from TermBrand tb where tb.status = 'Y' ");
//		formInitDatas.put("brandList", termBrands);
//
//		// get Term Type List from valid TermType(status = 'Y')
//		List<TermType> termTypes = terminalTypeDao
//				.find("from TermType tt where tt.status = 'Y' ");
//		formInitDatas.put("typeList", termTypes);
//		return formInitDatas;
//	}
//
////	private boolean validateNoderVersionInfo(NoderVersionInfo NoderVersionInfo) {
////		if (NoderVersionInfo == null)
////			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
////					"The Input is null. Please check and submit again. ");
////
////		if (!StringUtils.hasText(NoderVersionInfo.getTermCode()))
////			throw new AppException(
////					MessageKeyConstants.TERM_TERMINAL_TERM_CODE_NOT_NULL,
////					"Terminal ID can not be left empty. Please input terminal ID and submit again.");
////		return true;
////
////	}
//
//	/**
//	 * 
//	 */
//	public boolean isExistsByTermCode(String termCode) {
//		String hql = " select 1 from NoderVersionInfo t where t.termCode=?";
//		Integer r = NoderVersionInfoDao.findFirst(hql, termCode);
//		if (r == null) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//
//	/**
//	 * 
//	 */
//	public List<NoderVersionInfo> getNoderVersionInfoListByTermCodes(String termCodes) {
//		return NoderVersionInfoDao.getNoderVersionInfoListByTermCodes(termCodes);
//	}
//
//	//根据冠字号记录，查询终端设备
//	public NoderVersionInfo getNoderVersionInfoById(Map<String,Object> para) {
//		
//		String id = (String)para.get("p_termid");
//		//NoderVersionInfo termInfo = NoderVersionInfoDao.get(id);
//		String hql = "from NoderVersionInfo t where t.termCode=?";
//		List<NoderVersionInfo> infoLst = NoderVersionInfoDao.find(hql, new Object[]{id});
//		if(infoLst.size()==1){
//			return infoLst.get(0);
//		}else{
//			return null;
//		}
//	}
	
	/**
	 * 根据终端号获取所属的机构名称和PathCode
	 * 
	 * @param termCode
	 * @return
	 */
//	public String getOrgPathAndNameByTermCode(String termCode){
//		NoderVersionInfo termInfo = NoderVersionInfoDao.getByTermCode(termCode);
//		if(termInfo != null){
//			OrgInfo orgInfo = orgInfoDao.get(termInfo.getOrgId());
//			if(orgInfo != null){
//				return orgInfo.getOrgName() + "," + orgInfo.getPathCode();
//			}
//		}
//		return AppConstants.ORG_CHINA_ORGNAME + "," + AppConstants.ORG_CHINA_PATHCODE;// 默认返回
//	}
	
	
//	public void syncSendToSentServerRightNow(int synchType) {
//		S2005Msg smsg = new S2005Msg();
//		String messageNo = String.valueOf(new Date().getTime())
//				.substring(1, 13);
//		smsg.setType(17);
//		smsg.setMessageno(Integer.parseInt(messageNo.substring(0, 9)));
//		smsg.setDevidLen(0);
//		smsg.setLength(4);
//		smsg.setSynchInfoLen(0);
//		smsg.setSynchType(synchType);
//
//		byte[] sendpack = smsg.packMessage();
//
//		Transfer transfer = new Transfer();
//		transfer.initByService(paramDao);
//		SyncThread syncThread= new SyncThread();
//		syncThread.transfer = transfer;
//		syncThread.sendpack = sendpack;
//		syncThread.start();
//
//	}
//	
//	 class SyncThread extends Thread{
//         private Transfer transfer;  
//         private byte[] sendpack;
//
//		    public void run(){ 
//		    	try {
//					transfer.sendPack(sendpack);
//				} catch (IOException e) {
//					logger.error("", e);
//				}
//		    }
//	}
	private String getZipPathForImportNoderUpdatePackage(){
    	if(StringUtil.isBlank(StrideZipFsnContentUtil.STRIDE_PATH)){
			ParamDao paramDao = SpringContextHolder.getBean("paramDao");
			String temp = paramDao.getValueByPathWithException("param.sent.fsnPath.fsnRootPath.pathForNoderUpdate");
			StrideZipFsnContentUtil.STRIDE_PATH = StringUtil.isBlank(temp)?StrideZipFsnContentUtil.STRIDE_PATH_DEFUALT:temp;
			StrideZipFsnContentUtil.STRIDE_PATH = StrideZipFsnContentUtil.STRIDE_PATH.endsWith(File.separator) ? StrideZipFsnContentUtil.STRIDE_PATH : StrideZipFsnContentUtil.STRIDE_PATH + File.separator;
//			ZipUtil.buildFile(StrideZipFsnContentUtil.STRIDE_PATH, true);
		}
		return StrideZipFsnContentUtil.STRIDE_PATH;
    }

}
