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

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.exception.SimpleAppException;
import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.utils.ImportExcelUtil;
import com.grgbanking.platform.module.area.dao.AreaDao;
import com.grgbanking.platform.module.area.service.AreaService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.entity.SysDatadir;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.constans.TermInfoConsts;
import com.grgbanking.platform.module.term.dao.NoderInfoDao;
import com.grgbanking.platform.module.term.dao.TermBrandDao;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.dao.TermModelDao;
import com.grgbanking.platform.module.term.dao.TermTypeDao;
import com.grgbanking.platform.module.term.entity.NoderInfo;
import com.grgbanking.platform.module.term.entity.NoderInfoVO;
import com.grgbanking.platform.module.term.entity.TermBrand;
import com.grgbanking.platform.module.term.entity.TermInfo;
import com.grgbanking.platform.module.term.entity.TermModel;
import com.grgbanking.platform.module.term.entity.TermType;
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
// "com.grgbanking.platform.module.term.service.wsinterface.INoderInfoService")
public class NoderInfoService {
	private static Logger logger = LoggerFactory
			.getLogger(NoderInfoService.class);
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
	NoderInfoDao noderInfoDao;
	
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
	private static SimpleDateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public String exportNoderInfo(Map<String, String> params) {
		if(params.get("orgId")==null || params.get("orgId")==""){
			params.remove("orgId");
			params.put("orgId", params.get("userOrgid"));
		}
		List<NoderInfo> terList = new ArrayList<NoderInfo>();
		terList = noderInfoDao.getNoderInfoListByParams(params);
		for(NoderInfo noderInfo : terList) {
			OrgInfo oi = orgInfoDao.getByOrgCode(noderInfo.getOrgCode()) ;
			if(oi != null) {
				noderInfo.setOrgName(oi.getOrgName()) ;
			}
		}
		
		ArrayList<Object[]> dataList = new ArrayList<Object[]>();
		HttpServletRequest request = FlexContext.getHttpRequest();

		String fileName = UUID.randomUUID() + "Noder.xls";
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ File.separator + "exportFile" + File.separator + fileName;// 导出文件路径
		String modelName = request.getSession().getServletContext()
				.getRealPath("")
				+ File.separator
				+ "exportFile"
				+ File.separator + "Noder1.xls";// 文件模板路径
		List<SysDatadir> statusDir= sysDatadirService.getDatadirChildrenByPath(TermInfoConsts.NODER_STATUS, "zh_CN") ;
		Map<String, String> statusMap = new HashMap<String,String>() ;
		for(SysDatadir dir : statusDir) {
			statusMap.put(dir.getKey(), dir.getValue()) ;
		}
		
		List<SysDatadir> noderTypeDir= sysDatadirService.getDatadirChildrenByPath(TermInfoConsts.NODER_TYPE, "zh_CN") ;
		Map<String, String> noderTypeMap = new HashMap<String,String>() ;
		for(SysDatadir dir : noderTypeDir) {
			noderTypeMap.put(dir.getKey(), dir.getValue()) ;
		}
		
		Object[] row;
		for (int i = 0; i < terList.size(); i++) {
			row = new Object[11];
			NoderInfo termInfo = (NoderInfo) terList.get(i);
			row[0] = termInfo.getOrgCode()==null?"":termInfo.getOrgCode();
			row[1] = termInfo.getOrgName()==null?"":termInfo.getOrgName() ;
			// row[1] = termInfo.getOrgId();
			String noderType = termInfo.getNoderType();
			if(noderType == null || noderType.trim().equals("")){
				noderType = "" ;
			}
			else {
				noderType = noderTypeMap.get(noderType) ;
			}
			row[2] = noderType;
			
			row[3] = termInfo.getVersion();
			row[4] = termInfo.getNoderIP()==null?"":termInfo.getNoderIP();
			if(termInfo.getRunningStatus() == null || termInfo.getRunningStatus().trim().equals("")){
				row[5] = "" ;
			}
			else {
				row[5] = statusMap.get(termInfo.getRunningStatus()) ;
			}
			
			row[6] = termInfo.getStatusTime()==null?"":TIMEFORMAT.format(termInfo.getStatusTime());
			row[7] = termInfo.getParameter()==null?"":termInfo.getParameter();
			row[8] = termInfo.getDevice()==null?"":termInfo.getDevice();
			row[9] = termInfo.getInstallDir()==null?"":termInfo.getInstallDir();
			row[10] = termInfo.getMidLevelIP() == null?"":termInfo.getMidLevelIP();
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
	 * @param noderInfo
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean saveNoderinalInfo(NoderInfo noderInfo) {
//		validatenoderInfo(noderInfo);

//		NoderInfo existednoderInfo = noderInfoDao
//				.getByNoderIp(noderInfo.getNoderIP());
//		if (existednoderInfo != null)
//			throw new AppException(
//					MessageKeyConstants.TERM_EXISTED_TERMINAL_NETADDR,
//					"The noder address has already existed. Please change the noder ip and submit again. ");

		List<SysDatadir> noderTypeDir= sysDatadirService.getDatadirChildrenByPath(TermInfoConsts.NODER_TYPE, "zh_CN") ;
		Map<String, String> noderTypeMap = new HashMap<String,String>() ;
		for(SysDatadir dir : noderTypeDir) {
			noderTypeMap.put(dir.getKey(), dir.getValue()) ;
		}
		
		boolean isExistNoderInfo = noderInfoDao.getByExistNoderIp(noderInfo.getNoderIP(), 
				noderInfo.getNoderType(), "");
		if(isExistNoderInfo){
//			throw new AppException(
//					MessageKeyConstants.TERM_EXISTED_TERMINAL_NETADDR,
//					"The noder address has already existed. Please change the noder ip and submit again. ");
			throw new SimpleAppException("节点机类型【"+noderTypeMap.get(noderInfo.getNoderType())+"】对应的终端IP【" + noderInfo.getNoderIP() + "】已存在\r\n");
		}
		
		String termStrSelectInOtherNoder = noderInfoDao.checkTermIsSelectInOtherNoder(noderInfo.getId(), noderInfo.getDevice());
		if(termStrSelectInOtherNoder!=null && termStrSelectInOtherNoder!=""){
			throw new AppPlaceHolderException(MessageKeyConstants.TERM_IS_SELECT_IN_OTHER_NODER, "The terminal [%s] is seleced in other noder. can not choose again. ", termStrSelectInOtherNoder);
		}
		if (noderInfo.getId() == null) {
			int version = 0;
			noderInfo.setVersion(version);
			noderInfoDao.save(noderInfo);
		} else {
			noderInfoDao.copyUpdate(noderInfo);
		}
		String version = "v_" + Long.toString(System.currentTimeMillis());
		noderInfo.setInfoVersion(version);
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
	public boolean deletenoderInfo(String id) {
		validateId(id);
		noderInfoDao.delete(id);
		//同步SeNTServer
		syncSendToSentServerRightNow(1);
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
			deletenoderInfo(id);
		}

		return true;
	}

	/**
	 * 更新终端基础信息 <br>
	 * 
	 * update terminal basal information
	 * 
	 * @param noderInfo
	 * @return
	 */
	public boolean updateNoderinalInfo(NoderInfo noderInfo) {
//		validatenoderInfo(noderInfo);
		String newId = noderInfo.getId();
		validateId(newId);

//		NoderInfo existednoderInfo = noderInfoDao.getByNoderIp(noderInfo.getNoderIP()) ;
//				.getByTermCode(noderInfo.getTermCode());

//		if (existednoderInfo != null) {
//			if (!newId.equals(existednoderInfo.getId()))
//				throw new AppException(
//						MessageKeyConstants.TERM_EXISTED_TERMINAL_TERM_CODE,
//						"The terminal Id has already existed. Please change the terminal Id and submit again. ");
//		}
		
		List<SysDatadir> noderTypeDir= sysDatadirService.getDatadirChildrenByPath(TermInfoConsts.NODER_TYPE, "zh_CN") ;
		Map<String, String> noderTypeMap = new HashMap<String,String>() ;
		for(SysDatadir dir : noderTypeDir) {
			noderTypeMap.put(dir.getKey(), dir.getValue()) ;
		}
		boolean isExistNoderInfo = noderInfoDao.getByExistNoderIp(noderInfo.getNoderIP(), 
				noderInfo.getNoderType(), noderInfo.getId());
		if(isExistNoderInfo){
//			throw new AppException(
//					MessageKeyConstants.TERM_EXISTED_TERMINAL_TERM_CODE,
//					"The terminal Id has already existed. Please change the terminal Id and submit again. ");
			throw new SimpleAppException("节点机类型【"+noderTypeMap.get(noderInfo.getNoderType())+"】对应的终端IP【" + noderInfo.getNoderIP() + "】已存在\r\n");
		}

//		noderInfo.setOrgId(orgInfoDao.getByOrgCode(noderInfo.getTermCode()).getId());
		String termStrSelectInOtherNoder = noderInfoDao.checkTermIsSelectInOtherNoder(noderInfo.getId(), noderInfo.getDevice());
		if(termStrSelectInOtherNoder!=null && termStrSelectInOtherNoder!=""){
			throw new AppPlaceHolderException(MessageKeyConstants.TERM_IS_SELECT_IN_OTHER_NODER, "The terminal [%s] is seleced in other noder. can not choose again. ", termStrSelectInOtherNoder);
		}
		String version = "v_" + Long.toString(System.currentTimeMillis());
		noderInfo.setInfoVersion(version);
		
		noderInfoDao.copyUpdate(noderInfo);
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
	public Page<NoderInfo> getNoderInfoPage(final Page<NoderInfo> page,
			String termCode) {
		return noderInfoDao.getByTermCodeFuzzily(page, termCode);
	}

	public Page<NoderInfo> getNoderInfoPageByParams(final Page<NoderInfo> page,
			Map<String, String> params) {
		if (params.get("orgId") == null || params.get("orgId") == "") {
			params.remove("orgId");
			params.put("orgId", params.get("userOrgid"));
		}
		Page pageResult = noderInfoDao.getNoderInfoPageByParams(page, params);
		List<NoderInfo> noderInfos = pageResult.getResult() ;
		for(NoderInfo noderInfo : noderInfos) {
			OrgInfo oi = orgInfoDao.getByOrgCode(noderInfo.getOrgCode()) ;
			if(oi != null) {
				noderInfo.setOrgName(oi.getOrgName()) ;
			}
		}
		return pageResult;
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
	public String importNoderInfoExcel(byte[] file) {
		StringBuffer errBuf = new StringBuffer(); // 错误信息

		List<NoderInfoVO> importList = new ArrayList<NoderInfoVO>();

		InputStream is = new ByteArrayInputStream(file);

		try {
			HSSFWorkbook wb = new HSSFWorkbook(is);
			importList = ImportExcelUtil.importExcel(wb, 0, NoderInfoVO.class);
		} catch (Exception e) {
			logger.error("", e);
			return "excel内容格式错误,导入失败,请检查!";
//			throw new AppException(MessageKeyConstants.TERM_IMPORT_EXCEL_ERROR,
//					"Import Excel error!");
		}

		// 做检查
		// 检查重复
		Set<String> idSet = new HashSet<String>();
		Set<String> ipSet = new HashSet<String>();
		List<SysDatadir> noderTypeDir= sysDatadirService.getDatadirChildrenByPath(TermInfoConsts.NODER_TYPE, "zh_CN") ;
		Map<String, String> noderTypeMap = new HashMap<String,String>() ;
		for(SysDatadir dir : noderTypeDir) {
			noderTypeMap.put(dir.getKey(), dir.getValue()) ;
		}
		
		String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		for (NoderInfoVO obj : importList) {
			if(obj.getOrgCode() == null || obj.getOrgCode().trim().length() <= 0){
				return "所属机构号必须输入";
			} else if (!idSet.contains(obj.getOrgCode())) {
				idSet.add(obj.getOrgCode());
			} else {
				errBuf.append("所属机构号【" + obj.getOrgCode() + "】重复\r\n");
			}
			
			if(obj.getNoderType() == null || obj.getNoderType().trim().length() <= 0){
				return "节点机类型必须输入";
			}else{
				obj.setNoderType(obj.getNoderType().split("-")[0]);
			}
			
			//判断ip地址是否与正则表达式匹配     
			if(obj.getNoderIP() == null || obj.getNoderIP().trim().length() <= 0){
				return "终端IP必须输入";
			} else if(!obj.getNoderIP().matches(regex)){
				errBuf.append("终端IP【" + obj.getNoderIP() + "】格式错误\r\n");
				continue;
			} else if (!ipSet.contains(obj.getNoderType()+"|"+obj.getNoderIP())) {
				ipSet.add(obj.getNoderType()+"|"+obj.getNoderIP());
			} else {
				errBuf.append("节点机类型【"+noderTypeMap.get(obj.getNoderType())+"】对应的终端IP【" + obj.getNoderIP() + "】重复\r\n");
				continue;
			}
			
//			NoderInfo existednoderInfo2 = noderInfoDao.findUniqueBy("noderIP",
//					obj.getNoderIP());
			boolean isExistNoderIp = noderInfoDao.getByExistNoderIp(obj.getNoderIP(), obj.getNoderType(), "");
//			if (existednoderInfo2 != null){
			if(isExistNoderIp){
				errBuf.append("节点机类型【"+noderTypeMap.get(obj.getNoderType())+"】对应的终端IP【" + obj.getNoderIP() + "】已存在\r\n");
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

		for (NoderInfoVO ternInfo : importList) {
			if (ternInfo.getOrgCode() == null
					|| ternInfo.getOrgCode().trim().length() <= 0) {
				return "所属机构号必须输入";
			}
			if (!orgCodeMap.keySet().contains(ternInfo.getOrgCode())) {
				errBuf.append("所属机构号【"
						+ ternInfo.getOrgCode() + "】不存在\r\n");
			}
		}

		if (errBuf.length() > 0) {
			return errBuf.toString();
		}

		
		for (NoderInfoVO obj : importList) {
//			NoderInfo info = noderInfoDao.getByTermCode(obj
//					.getOrgCode());
			TermInfo ti = terminalInfoDao.getByTermCode(obj.getDevice()) ;
			String termStrSelectInOtherNoder = noderInfoDao.checkTermIsSelectInOtherNoder(ti==null?null:ti.getId(), obj.getDevice());
			if(termStrSelectInOtherNoder!=null && termStrSelectInOtherNoder!=""){
				errBuf.append("设备信息【"
						+ obj.getDevice() + "】有误,请检查\r\n");
			}

		}

		if (errBuf.length() > 0) {
			return errBuf.toString();
		}

		for(NoderInfoVO obj : importList) {
			String parameter = obj.getParameter() ;
			if(parameter != null && !parameter.trim().equals("")) {
				String[] parameters = parameter.split(",") ;
				for(int i =0 ; i < parameters.length ; i ++) {
					if(parameters[i].startsWith("uploadtime")) {
						String[] uploadloadTimes = parameters[i].split(":");
					    if(uploadloadTimes.length != 4) {
					    	errBuf.append("节点机参数信息"+parameter+"有误，请检查\r\n") ;
					    	continue ;
					    }
					    else {
					    	
//					    	if(uploadloadTimes[2].split("-").length !=2) {
//					    		errBuf.append("节点机参数信息"+parameter+"有误，请检查\r\n") ;
//						    	continue ;
//					    	}
					    	if(!uploadloadTimes[2].matches("^\\d{2}-\\d{2}$")) {
					    		errBuf.append("节点机参数信息"+parameter+"有误，请检查\r\n") ;
						    	continue ;
					    	}
					    	if(!uploadloadTimes[1].matches("\\d{2}") || !uploadloadTimes[3].matches("\\d{2}")) {
					    		errBuf.append("节点机参数信息"+parameter+"有误，请检查\r\n") ;
						    	continue ;
					    	}
					    	
					    }
					}
					else if(parameters[i].startsWith("bandwidth")) {
						String[] bandwidthSet = parameters[i].split(":") ;
						if(bandwidthSet.length != 2 || !bandwidthSet[1].trim().matches("\\d{1,}")) {
							errBuf.append("节点机参数信息"+parameter+"有误，请检查\r\n") ;
					    	continue ;
						}
					}
					else {
						errBuf.append("节点机参数信息"+parameter+"有误，请检查\r\n") ;
					}
				}
			}
		}
		
		if (errBuf.length() > 0) {
			return errBuf.toString();
		}
		
		//中间层IP格式检查
		for (NoderInfoVO obj : importList) {
			String midIp = obj.getMidLevelIP() ;
			if(midIp != null &&!midIp.equals("")&&!midIp.matches(regex)) {
				errBuf.append("中间层IP"+obj.getMidLevelIP()+"格式错误，请检查\r\n") ;
			}
		}

		if (errBuf.length() > 0) {
			return errBuf.toString();
		}
		
		List<NoderInfo> list = new ArrayList<NoderInfo>();

		for (NoderInfoVO termInfo : importList) {
			NoderInfo info = new NoderInfo() ;
			info.setOrgCode(termInfo.getOrgCode()) ;
			info.setNoderIP(termInfo.getNoderIP()) ;
			info.setParameter(termInfo.getParameter()) ;
			info.setDevice(termInfo.getDevice()) ;
			info.setInstallDir(termInfo.getInstallDir()) ;
			info.setMidLevelIP(termInfo.getMidLevelIP()) ;
			info.setVersion(termInfo.getVersion()) ;
			
			if (errBuf.length() > 0)
				return errBuf.toString();
			// 实际加入添加列表
			list.add(info);
		}

		for (NoderInfo obj : list) {
			try {
				saveNoderinalInfo(obj);
			} catch (Exception ex) {
				// 保存出错需要继续处理其他的记录
				logger.error("The termial with termCode is "
						+ obj.getNoderIP() + " import error!", ex);
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
	public Map<String, Object> getNoderInfoFormInitDatas(String language) {
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
	public Map<String, Object> getNoderInfoInitDatas(String language) {
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

//	private boolean validatenoderInfo(NoderInfo noderInfo) {
//		if (noderInfo == null)
//			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
//					"The Input is null. Please check and submit again. ");
//
//		if (!StringUtils.hasText(noderInfo.getTermCode()))
//			throw new AppException(
//					MessageKeyConstants.TERM_TERMINAL_TERM_CODE_NOT_NULL,
//					"Terminal ID can not be left empty. Please input terminal ID and submit again.");
//		return true;
//
//	}

	/**
	 * 
	 */
	public boolean isExistsByTermCode(String termCode) {
		String hql = " select 1 from NoderInfo t where t.termCode=?";
		Integer r = noderInfoDao.findFirst(hql, termCode);
		if (r == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 */
	public List<NoderInfo> getNoderInfoListByTermCodes(String termCodes) {
		return noderInfoDao.getNoderInfoListByTermCodes(termCodes);
	}

	//根据冠字号记录，查询终端设备
	public NoderInfo getNoderInfoById(Map<String,Object> para) {
		
		String id = (String)para.get("p_termid");
		//NoderInfo termInfo = noderInfoDao.get(id);
		String hql = "from NoderInfo t where t.termCode=?";
		List<NoderInfo> infoLst = noderInfoDao.find(hql, new Object[]{id});
		if(infoLst.size()==1){
			return infoLst.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 判断节点机管理表中有无数据
	 */
	public boolean isNullNoderRecords(Map<String, Object> parameter) {
		
		//根据orgid获取org_code
		String orgid = (String)parameter.get("orgid");
		
		String orgcode = orgInfoDao.getOrgCodeById(orgid);
		
		return noderInfoDao.isExistingByOrgCode(orgcode);

	}
	
	/**
	 * 下载节点机程序
	 */
	public String dowanloadNode(Map<String, Object> parameter) {
		
		//根据orgid获取org_code
		String orgid = (String)parameter.get("orgid");
		
//		String clientIpStr = (String)parameter.get("clientIp");
		
		String orgcode = orgInfoDao.getOrgCodeById(orgid);
		
//		noderInfo.setVersion(0);
//		noderInfo.setOrgCode(orgcode);
//		if(clientIpStr == null){
//			noderInfo.setNoderIP("127.0.0.1");
//		}else{
//			noderInfo.setNoderIP(clientIpStr);
//		}
//		
//		noderInfoDao.save(noderInfo);
		
		return orgcode;
	}
	
	/**
	 * 根据终端号获取所属的机构名称和PathCode
	 * 
	 * @param termCode
	 * @return
	 */
//	public String getOrgPathAndNameByTermCode(String termCode){
//		NoderInfo termInfo = noderInfoDao.getByTermCode(termCode);
//		if(termInfo != null){
//			OrgInfo orgInfo = orgInfoDao.get(termInfo.getOrgId());
//			if(orgInfo != null){
//				return orgInfo.getOrgName() + "," + orgInfo.getPathCode();
//			}
//		}
//		return AppConstants.ORG_CHINA_ORGNAME + "," + AppConstants.ORG_CHINA_PATHCODE;// 默认返回
//	}
	
	
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
