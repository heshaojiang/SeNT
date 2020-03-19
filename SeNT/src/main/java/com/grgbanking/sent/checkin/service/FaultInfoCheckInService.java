package com.grgbanking.sent.checkin.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.entity.SysDatadir;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.sent.checkin.dao.FaultInfoCheckInDao;
import com.grgbanking.sent.checkin.dao.SmsSerialDoubtRecordDao;
import com.grgbanking.sent.checkin.entity.FaultInfoCheckIn;
import com.grgbanking.sent.checkin.entity.SmsSerialDoubtRecord;
import com.grgbanking.sent.checkin.entity.SmsSerialStatis;
import com.grgbanking.sent.transmgr.service.ServiceValidateHelper;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.POIUtils;
import com.grgbanking.sent.utils.StringUtil;

import flex.messaging.FlexContext;

@SuppressWarnings("unchecked")
@Service
@Transactional
public class FaultInfoCheckInService extends BaseService {

	@Autowired
	FaultInfoCheckInDao infoCheckInDao;
	@Autowired
	SmsSerialDoubtRecordDao smsSerialDoubtRecordDao;

	@Autowired
	OrgInfoDao orgInfoDao;

	@Autowired
	SysDatadirService sysDatadirService;

	public void addCheckInInfo(Map<String, Object> parameter) {
		FaultInfoCheckIn info = new FaultInfoCheckIn();

		info.setOrgCode(StringUtil.trim(parameter.get("orgCode")));
		info.setOrgName(StringUtil.trim(parameter.get("orgName")));
		info.setOrgPathCode(StringUtil.trim(parameter.get("orgPathCode")));
		info.setRecorderCode(StringUtil.trim(parameter.get("recorderCode")));
		info.setApplyDate(StringUtil.trim(parameter.get("applyDate")).replace(
				"-", ""));
		info.setQuerySeriaNo(StringUtil.trim(parameter.get("querySeriaNo")));
		info.setQueryResult(StringUtil.trim(parameter.get("queryResult")));
		info.setClientName(StringUtil.trim(parameter.get("clientName")));
		info.setClientPhone(StringUtil.trim(parameter.get("clientPhone")));
		info.setAgentName(StringUtil.trim(parameter.get("agentName")));
		info.setAgentPhone(StringUtil.trim(parameter.get("agentPhone")));
		info.setCertificateType(StringUtil.parseToInteger(String
				.valueOf(parameter.get("certificateType")),
				"wrong Integer value of certificateType[%s]"));
		info.setCertificateTypeOthers(StringUtil.trim(parameter
				.get("certificateTypeOthers")));
		info.setCertificateNo(StringUtil.trim(parameter.get("certificateNo")));
		info.setWithdrawalDate(StringUtil.trim(parameter.get("withdrawalDate"))
				.replace("-", ""));
		info
				.setWithdrawalBank(StringUtil.trim(parameter
						.get("withdrawalBank")));
		info.setWithdrawalType(StringUtil.parseToInteger(String
				.valueOf(parameter.get("withdrawalType")),
				"wrong Integer value of withdrawalType[%s]"));
		info.setWithdrawalBranchName(StringUtil.trim(parameter
				.get("withdrawalBranchName")));
		info.setWithdrawalWindow(StringUtil.trim(parameter
				.get("withdrawalWindow")));
		info.setAtmType(StringUtil.parseToInteger(String.valueOf(parameter
				.get("atmType")), "wrong Integer value of atmType[%s]"));
		info.setAtmAddress(StringUtil.trim(parameter.get("atmAddress")));

		ServiceValidateHelper.validateCommonTime(info.getApplyDate(),
				"yyyyMMdd",
				MessageKeyConstants.FICI_APPLY_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_APPLY_TIME_FORMAT_WRONG);
		ServiceValidateHelper.validateCommonTime(info.getWithdrawalDate(),
				"yyyyMMdd",
				MessageKeyConstants.FICI_WITHDRAWAL_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_WITHDRAWAL_TIME_FORMAT_WRONG);

		infoCheckInDao.saveNew(info);
	}

	public void updateCheckInInfo(Map<String, Object> parameter) {
		FaultInfoCheckIn info = new FaultInfoCheckIn();

		info.setId(StringUtil.trim(parameter.get("id")));
		info.setOrgCode(StringUtil.trim(parameter.get("orgCode")));
		info.setOrgName(StringUtil.trim(parameter.get("orgName")));
		info.setOrgPathCode(StringUtil.trim(parameter.get("orgPathCode")));
		info.setRecorderCode(StringUtil.trim(parameter.get("recorderCode")));
		info.setApplyDate(StringUtil.trim(parameter.get("applyDate")).replace(
				"-", ""));
		info.setQuerySeriaNo(StringUtil.trim(parameter.get("querySeriaNo")));
		info.setQueryResult(StringUtil.trim(parameter.get("queryResult")));
		info.setClientName(StringUtil.trim(parameter.get("clientName")));
		info.setClientPhone(StringUtil.trim(parameter.get("clientPhone")));
		info.setAgentName(StringUtil.trim(parameter.get("agentName")));
		info.setAgentPhone(StringUtil.trim(parameter.get("agentPhone")));
		info.setCertificateType(StringUtil.parseToInteger(String
				.valueOf(parameter.get("certificateType")),
				"wrong Integer value of certificateType"));
		info.setCertificateTypeOthers(StringUtil.trim(parameter
				.get("certificateTypeOthers")));
		info.setCertificateNo(StringUtil.trim(parameter.get("certificateNo")));
		info.setWithdrawalDate(StringUtil.trim(parameter.get("withdrawalDate"))
				.replace("-", ""));
		info
				.setWithdrawalBank(StringUtil.trim(parameter
						.get("withdrawalBank")));
		info.setWithdrawalType(StringUtil.parseToInteger(String
				.valueOf(parameter.get("withdrawalType")),
				"wrong Integer value of withdrawalType"));
		info.setWithdrawalBranchName(StringUtil.trim(parameter
				.get("withdrawalBranchName")));
		info.setWithdrawalWindow(StringUtil.trim(parameter
				.get("withdrawalWindow")));
		info.setAtmType(StringUtil.parseToInteger(String.valueOf(parameter
				.get("atmType")), "wrong Integer value of atmType"));
		info.setAtmAddress(StringUtil.trim(parameter.get("atmAddress")));

		ServiceValidateHelper.validateCommonTime(info.getApplyDate(),
				"yyyyMMdd",
				MessageKeyConstants.FICI_APPLY_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_APPLY_TIME_FORMAT_WRONG);
		ServiceValidateHelper.validateCommonTime(info.getWithdrawalDate(),
				"yyyyMMdd",
				MessageKeyConstants.FICI_WITHDRAWAL_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_WITHDRAWAL_TIME_FORMAT_WRONG);

		infoCheckInDao.update(info);
	}

	public Page<FaultInfoCheckIn> queryFaultCheckInInfoPage(
			Map<String, Object> parameter) {
		Page<FaultInfoCheckIn> page = (Page) parameter.get("page");
		Map<String, Object> condition = (Map) parameter.get("condition");

		String startTime = StringUtil.trim(condition.get("startTime")).replace(
				"-", "");
		String endTime = StringUtil.trim(condition.get("endTime")).replace("-",
				"");

		ServiceValidateHelper.validateQueryStartTime(startTime, "yyyyMMdd");
		ServiceValidateHelper.validateQueryEndTime(endTime, "yyyyMMdd");

		condition.put("startTime", startTime);
		condition.put("endTime", endTime);

		page = infoCheckInDao.queryFaultCheckInInfoPage(page, condition);
		return page;
	}

	public boolean deleteFaultCheckInInfos(String[] idArr) {
		for (String id : idArr) {
			infoCheckInDao.delete(id);
		}
		return true;
	}

	// ================涉假信息登记重构===================
	/**
	 *	涉假信息登记 以及再登记
	 * @param parameter
	 * @throws Exception
	 */
	public void addSerialInfo(Map<String, Object> parameter) throws Exception {
		SmsSerialDoubtRecord info = new SmsSerialDoubtRecord();
		this.setInfoByParameter(info, parameter);
		
		smsSerialDoubtRecordDao.saveNew(info);
	}
	/**
	 * 涉假信息编辑
	 * @param parameter
	 * @throws Exception
	 */
	public void updateSerialInfo(Map<String, Object> parameter)
			throws Exception {

    	SmsSerialDoubtRecord info = smsSerialDoubtRecordDao.get(StringUtil.trim(parameter.get("id")));

//		info.setId(StringUtil.trim(parameter.get("id")));

		this.setInfoByParameter(info, parameter);
		
		SmsSerialDoubtRecord infoAgain = smsSerialDoubtRecordDao.queryAgainByseriaNO(info.getSeriaNO());
		
		if(infoAgain!=null){
			infoAgain.setDepositBank(info.getDepositBank());
			infoAgain.setDepositDate(info.getDepositDate());
			infoAgain.setCounterPosition(info.getCounterPosition());
			infoAgain.setAddress(info.getAddress());
			infoAgain.setNotePayType(info.getNotePayType());
			smsSerialDoubtRecordDao.update(infoAgain);
		}
		smsSerialDoubtRecordDao.update(info);
	}

	/**
	 * 涉假信息登记与编辑代码复用部分
	 * @param info
	 * @param parameter
	 * @throws Exception
	 */
	private void setInfoByParameter(SmsSerialDoubtRecord info,Map<String, Object> parameter) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String applyDateStr = StringUtil.trim(parameter.get("applyDate"))
				.replace("-", "");
		String depositDateStr = StringUtil.trim(parameter.get("depositDate"))
				.replace("-", "");
		Date applyDate = sdf.parse(applyDateStr);
		Date depositDate = null ;
		if(depositDateStr.length()>1){
			depositDate = sdf.parse(depositDateStr);
		}
		
		info.setApplyDate(applyDate);
		info.setDepositDate(depositDate);
		
		info.setOrgCode(StringUtil.trim(parameter.get("orgCode")));
		info.setOrgName(StringUtil.trim(parameter.get("orgName")));
		info.setOrgPathCode(StringUtil.trim(parameter.get("orgPathCode")));
		info.setOperatorId(StringUtil.trim(parameter.get("operatorId")));
		info.setCheckId(StringUtil.trim(parameter.get("checkId")));
		info.setApplyName(StringUtil.trim(parameter.get("applyName")));
		info.setApplyPhone(StringUtil.trim(parameter.get("applyPhone")));
		info.setSeriaNO(StringUtil.trim(parameter.get("seriaNO")));
		info.setSerialCount(Integer.parseInt(StringUtil.trim(parameter
				.get("serialCount"))));
		info.setSerialResult(Integer.parseInt(StringUtil.trim(parameter
				.get("serialResult"))));
		info.setIdentType(Integer.parseInt(StringUtil.trim(parameter
				.get("identType"))));
		info.setIdentNO(StringUtil.trim(parameter.get("identNO")));
		info.setDepositBank(StringUtil.trim(parameter.get("depositBank")));
		info.setNoteType(StringUtil.trim(parameter.get("noteType")));
		info.setNotePayType(StringUtil.trim(parameter.get("notePayType")));
		
		info.setCounterPosition(StringUtil.trim(parameter.get("counterPosition")));
		info.setAddress(StringUtil.trim(parameter.get("address")));
		info.setApplyCardType(StringUtil.trim(parameter.get("applycardType")));
		
		info.setApplyCardNo(StringUtil.trim(parameter.get("applyCardNo")));
//		info.setAgentName(StringUtil.trim(parameter.get("agentName")));
//		info.setAgentPhone(StringUtil.trim(parameter.get("agentPhone")));
//		info.setAgentCardType(StringUtil.trim(parameter.get("agentCardType")));
//		info.setAgentCardNo(StringUtil.trim(parameter.get("agentCardNo")));
		info.setApplyType(Integer.parseInt(StringUtil.trim(parameter.get("applyType"))));
		info.setRegistionType(Integer.parseInt(StringUtil.trim(parameter.get("registionType"))));
		
		
		ServiceValidateHelper.validateCommonTime(applyDateStr, "yyyyMMdd",
				MessageKeyConstants.FICI_APPLY_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_APPLY_TIME_FORMAT_WRONG);
		if(info.getApplyType()==0){
			ServiceValidateHelper.validateCommonTime(depositDateStr, "yyyyMMdd",
					MessageKeyConstants.FICI_WITHDRAWAL_TIME_CANNOT_BE_BLANK,
					MessageKeyConstants.FICI_WITHDRAWAL_TIME_FORMAT_WRONG);
		}
	}
	
	public Page<SmsSerialDoubtRecord> querySerialInfoPage(
			Map<String, Object> parameter) throws Exception {
		Page<SmsSerialDoubtRecord> page = (Page) parameter.get("page");
		Map<String, Object> condition = (Map) parameter.get("condition");

		String startTime = StringUtil.trim(condition.get("startTime")).replace(
				"-", "");
		String endTime = StringUtil.trim(condition.get("endTime")).replace("-",
				"");
		ServiceValidateHelper.validateQueryStartTime(startTime, "yyyyMMdd");
		ServiceValidateHelper.validateQueryEndTime(endTime, "yyyyMMdd");
		// Date stDate = new Date(StringUtil.trim(parameter.get("startTime")));
		// Date etDate = new Date(StringUtil.trim(parameter.get("endTime")));

		condition.put("startTime", startTime);
		condition.put("endTime", endTime);

		page = smsSerialDoubtRecordDao.queryFaultCheckInInfoPage(page,
				condition);
		return page;
	}

	public boolean deleteSerialInfos(String[] idArr) {
		for (String id : idArr) {
			smsSerialDoubtRecordDao.delete(id);
		}
		return true;
	}
	
	public String exportExcelFaultInfo(Map<String, Object> params) throws Exception {

		Page<SmsSerialDoubtRecord> page = (Page) params.get("page");
		Map<String, Object> condition = (Map) params.get("condition");

		String startTime = StringUtil.trim(condition.get("startTime")).replace(
				"-", "");
		String endTime = StringUtil.trim(condition.get("endTime")).replace("-",
				"");
		ServiceValidateHelper.validateQueryStartTime(startTime, "yyyyMMdd");
		ServiceValidateHelper.validateQueryEndTime(endTime, "yyyyMMdd");
		// Date stDate = new Date(StringUtil.trim(parameter.get("startTime")));
		// Date etDate = new Date(StringUtil.trim(parameter.get("endTime")));

		condition.put("startTime", startTime);
		condition.put("endTime", endTime);
		
		//Boolean isPrintTemplate = (params.get("isPrintTemplate").equals("0"));
		//List terList = smsSerialDoubtRecordDao.getFaultInfoPageByParams(params);
//		if(!isPrintTemplate){
//			terList = terminalInfoDao.getTermInfoPageByParams(params);
//		}
		page = smsSerialDoubtRecordDao.queryFaultCheckInInfoPage(page,
				condition);
		List<SmsSerialDoubtRecord> terList = page.getResult();
		
		List<Object[]> dataList = new ArrayList<Object[]>();
		HttpServletRequest request = FlexContext.getHttpRequest();

		String fileName = UUID.randomUUID() + "FaultInfoTemplate.xls";
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ File.separator + "exportFile" + File.separator + fileName;// 导出文件路径
		String modelName = request.getSession().getServletContext()
				.getRealPath("")
				+ File.separator
				+ "exportFile"
				+ File.separator + "FaultInfoTemplate.xls";// 文件模板路径
		
		Object[] row;
//		List<OrgInfo> orgInfos = orgInfoDao.getAll();
//		List<TermModel> termModels = termModelService.getAllTermModel();
//		List<TermBrand> termBrands = termBrandService.getAllTermBrand();
//		List<TermType> termTypes = termTypeService.getAllTermType();
//		List<Area> areas = areaService.getAllArea();
		for (int i = 0; i < terList.size(); i++) {
			row = new Object[8];
			SmsSerialDoubtRecord record = (SmsSerialDoubtRecord) terList.get(i);
			row[0] = //(record.getApplyName()==null||record.getApplyName().equals("null"))?record.getAgentName():
				record.getApplyName();
			row[1] = DateUtil.getDateString(record.getApplyDate());
			row[2] = DateUtil.getDateString(record.getDepositDate());
			row[3] = record.getOperatorId();
			row[4] = record.getCheckId();
			row[5] = record.getSeriaNO();
			row[6] = record.getSerialCount();
			
			List dirLst = sysDatadirService.getDatadirChildrenByPath("SysDatadirMgr.sent.ruleMgr.cmlQueryResult","zh_CN");
			for(Object dir:dirLst){
				SysDatadir dataDir = (SysDatadir)dir;
				if(dataDir.getKey().equals(record.getSerialResult()+"")){
					row[7] = dataDir.getValue();					
					break;
				}
			}
			if(record.getSerialResult() == 1){//已查到
				dirLst = sysDatadirService.getDatadirChildrenByPath("SysDatadirMgr.sent.transMgr.noteType","zh_CN");
				for(Object dir:dirLst){
					SysDatadir dataDir = (SysDatadir)dir;
					if(dataDir.getKey().equals(record.getNoteType())){
						row[7] = row[7].toString() + "," + dataDir.getValue();
						break;
					}
				}
			}	
			
			dataList.add(row);
		}
		String fileUrl = POIUtils.makeExcelFile(dataList, modelName, filePath);
		return fileName;
	}
	
	public static String makeExcelFile(List<Object[]> dataList, String modelName,
			String filePath) {
		HSSFWorkbook templatewb = null;
		int perSize = 10000;
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					modelName));
			templatewb = new HSSFWorkbook(fs);
		
//			int sheetNo = dataList.size() % perSize > 0 ? dataList.size()
//					/ perSize + 1 : dataList.size() / perSize;
			int sheetNo = dataList.size() / perSize + 1;
			for (int sheet = 0; sheet < sheetNo; sheet++) {
				
				HSSFSheet tosheet = null;
				if (sheet < 3) {//默认下标签有三个，超过时自己创建
					tosheet = templatewb.getSheetAt(sheet);
				} else {
					tosheet = templatewb.createSheet("sheet" + (sheet + 1));
				}

				// data row
				int size = dataList.size();
//				HSSFRow templateRow = tosheet.getRow(1);
//				HSSFCellStyle[] styles = new HSSFCellStyle[templateRow
//						.getPhysicalNumberOfCells()];
//				for (int i = 0; i < templateRow.getPhysicalNumberOfCells(); i++) {
//					styles[i] = templateRow.getCell(i).getCellStyle();
//				}
				
				int rowSize = (sheet + 1) * perSize > size ? size : (sheet + 1) * perSize;
				
				for (int rowId = sheet * perSize; rowId < rowSize; rowId++) {

					Object[] valueList = (Object[]) dataList.get(rowId);
					
					int rowNum = 0;
					if(sheet==0){
						rowNum = rowId + 3;
					}else{
						rowNum = rowId - perSize*sheet;
					}
					HSSFRow hssfRow = tosheet.createRow(rowNum);
					for (int columnId = 0; columnId < valueList.length; columnId++) {
						
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
			// logger.error("Data Exceeded!", e);
			return null;
		} catch (Exception ex) {
			// logger.error("", ex);
			return null;
		}
		return filePath;
	}

	public Page querySerialStatisPage(
			Map<String, Object> parameter) throws Exception {
		Page page = (Page) parameter.get("page");
		Map<String, Object> condition = (Map) parameter.get("condition");

		String startTime = StringUtil.trim(condition.get("startTime")).replace(
				"-", "");
		String endTime = StringUtil.trim(condition.get("endTime")).replace("-",
				"");
		ServiceValidateHelper.validateQueryStartTime(startTime, "yyyyMMdd");
		ServiceValidateHelper.validateQueryEndTime(endTime, "yyyyMMdd");
		// Date stDate = new Date(StringUtil.trim(parameter.get("startTime")));
		// Date etDate = new Date(StringUtil.trim(parameter.get("endTime")));

		//condition.put("startTime", startTime);
		//condition.put("endTime", endTime);

		page = smsSerialDoubtRecordDao.querySerialStatisPage(page,
				condition);
		return page;
	}

	public String exportExcelFaultInfoStatis(Map<String, Object> params) throws Exception {

		Page page = (Page) params.get("page");
		Map<String, Object> condition = (Map) params.get("condition");

		String startTime = StringUtil.trim(condition.get("startTime")).replace(
				"-", "");
		String endTime = StringUtil.trim(condition.get("endTime")).replace("-",
				"");
		ServiceValidateHelper.validateQueryStartTime(startTime, "yyyyMMdd");
		ServiceValidateHelper.validateQueryEndTime(endTime, "yyyyMMdd");
		// Date stDate = new Date(StringUtil.trim(parameter.get("startTime")));
		// Date etDate = new Date(StringUtil.trim(parameter.get("endTime")));

		//condition.put("startTime", startTime);
		//condition.put("endTime", endTime);
		
		page = smsSerialDoubtRecordDao.querySerialStatisPage(page,
				condition);
		List<SmsSerialStatis> terList = page.getResult();
		
		ArrayList<Object[]> dataList = new ArrayList<Object[]>();
		HttpServletRequest request = FlexContext.getHttpRequest();

		String fileName = UUID.randomUUID() + "FaultInfoStatisTemplatePay.xls";
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ File.separator + "exportFile" + File.separator + fileName;// 导出文件路径
		String modelName = request.getSession().getServletContext()
				.getRealPath("")
				+ File.separator
				+ "exportFile"
				+ File.separator + "FaultInfoStatisTemplatePay.xls";// 文件模板路径
		
		Object[] row;
		//List<OrgInfo> orgInfos = orgInfoDao.getAll();
//		List<TermModel> termModels = termModelService.getAllTermModel();
//		List<TermBrand> termBrands = termBrandService.getAllTermBrand();
//		List<TermType> termTypes = termTypeService.getAllTermType();
//		List<Area> areas = areaService.getAllArea();
		for (int i = 0; i < terList.size(); i++) {
			row = new Object[5];
			SmsSerialStatis record = (SmsSerialStatis) terList.get(i);
			row[0] = i + 1;
			row[1] = record.getsOrgName();
			row[2] = record.getsQueryCount();
			row[3] = record.getHasPaid1();
			row[4] = record.getHasPaid2();
			
			dataList.add(row);
		}
		String fileUrl = POIUtils.makeExcelFile(dataList, modelName, filePath);
		return fileName;
	}
}
