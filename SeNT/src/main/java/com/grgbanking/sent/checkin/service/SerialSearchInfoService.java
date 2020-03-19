package com.grgbanking.sent.checkin.service;
/**
 * @author whxing
 * 人民币冠字号检索登记service
 */
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
import com.grgbanking.sent.checkin.dao.SerialSearchInfoDao;
import com.grgbanking.sent.checkin.entity.SerialSearchInfo;
import com.grgbanking.sent.transmgr.service.ServiceValidateHelper;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

import flex.messaging.FlexContext;
@SuppressWarnings("unchecked")
@Service
@Transactional
public class SerialSearchInfoService extends BaseService {
	@Autowired
	SerialSearchInfoDao serialSearchInfoDao;
	
	@Autowired
	SysDatadirService sysDatadirService;
	/**
	 * 根据条件查询登记冠字号的信息
	 * @param parameter
	 * @return page
	 * @throws Exception
	 */
	public Page<SerialSearchInfo> querySerialSearchInfoPage(
		Map<String, Object> parameter) throws Exception
		{
			Page<SerialSearchInfo> page = (Page) parameter.get("page");
			Map<String, Object> condition = (Map) parameter.get("condition");
	
			String serialNo = StringUtil.trim(condition.get("serialNo"));
			String startTime = StringUtil.trim(condition.get("startTime")).replace(
					"-", "");
			String endTime = StringUtil.trim(condition.get("endTime")).replace("-",
					"");
			ServiceValidateHelper.validateQueryStartTime(startTime, "yyyyMMdd");
			ServiceValidateHelper.validateQueryEndTime(endTime, "yyyyMMdd");
			condition.put("serialNo", serialNo);
			condition.put("startTime", startTime);
			condition.put("endTime", endTime);
			page =serialSearchInfoDao.querySerialSearchInfoPage(page,
					condition);
			return page;
		}
	/**
	 * 新增冠字号检索登记
	 * @param parameter
	 */
	public void addSerialSearchInfo(Map<String, Object> parameter) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date recordDate = null;
		if(""!=parameter.get("recordDate")){
		String recordDateStr = StringUtil.trim(parameter.get("recordDate"));
		recordDate = sdf.parse(recordDateStr);
		//检验日期是否符合给定"yyyy-MM-dd HH:mm:ss"格式插入数据库，并抛出异常
		ServiceValidateHelper.validateCommonTime(recordDateStr,"yyyy-MM-dd HH:mm:ss",
				MessageKeyConstants.FICI_RECORD_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_RECORD_TIME_FORMAT_WRONG);
		}
		String searchDateStr = StringUtil.trim(parameter.get("searchDate"))
				.replace("-", "");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		Date searchDate = sdf1.parse(searchDateStr);

		SerialSearchInfo info = new SerialSearchInfo();

		info.setNoteRecordType(StringUtil.trim(parameter.get("noteRecordType")));
		info.setNoteType(StringUtil.trim(parameter.get("noteType")));
		info.setOperatorName(StringUtil.trim(parameter.get("operatorName")));
		info.setRecordDate(recordDate);
		info.setSearchDate(searchDate);
		info.setSerialCount(Integer.parseInt(StringUtil.trim(parameter
				.get("serialCount"))));
		info.setSerialResult(Integer.parseInt(StringUtil.trim(parameter
				.get("serialResult"))));
		info.setSerialKeeper(StringUtil.trim(parameter.get("serialKeeper")));
		info.setSerialNo(StringUtil.trim(parameter.get("serialNo")));
		
		ServiceValidateHelper.validateCommonTime(searchDateStr, "yyyyMMdd",
				MessageKeyConstants.FICI_SEARCH_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_SEARCH_TIME_FORMAT_WRONG);

		serialSearchInfoDao.saveNew(info);
	}
	
	/**
	 * 更新冠字号检索登记数据
	 * @param parameter
	 * @throws Exception
	 */
	public void updateSerialSearchInfo(Map<String, Object> parameter)
	throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date recordDate = null;
		if(""!=parameter.get("recordDate")){
			String recordDateStr = StringUtil.trim(parameter.get("recordDate"));
			recordDate = sdf.parse(recordDateStr);
			ServiceValidateHelper.validateCommonTime(recordDateStr, "yyyy-MM-dd HH:mm:ss",
					MessageKeyConstants.FICI_RECORD_TIME_CANNOT_BE_BLANK,
					MessageKeyConstants.FICI_RECORD_TIME_FORMAT_WRONG);
			}
		String searchDateStr = StringUtil.trim(parameter.get("searchDate"))
				.replace("-", "");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		Date searchDate = sdf1.parse(searchDateStr);

		SerialSearchInfo info = new SerialSearchInfo();
		info.setId(StringUtil.trim(parameter.get("id")));
		info.setNoteRecordType(StringUtil.trim(parameter.get("noteRecordType")));
		info.setNoteType(StringUtil.trim(parameter.get("noteType")));
		info.setOperatorName(StringUtil.trim(parameter.get("operatorName")));
		info.setRecordDate(recordDate);
		info.setSearchDate(searchDate);
		info.setSerialCount(Integer.parseInt(StringUtil.trim(parameter
				.get("serialCount"))));
		info.setSerialResult(Integer.parseInt(StringUtil.trim(parameter
				.get("serialResult"))));
		info.setSerialKeeper(StringUtil.trim(parameter.get("serialKeeper")));
		info.setSerialNo(StringUtil.trim(parameter.get("serialNo")));
		ServiceValidateHelper.validateCommonTime(searchDateStr, "yyyyMMdd",
				MessageKeyConstants.FICI_SEARCH_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_SEARCH_TIME_FORMAT_WRONG);

		serialSearchInfoDao.update(info);
}
	/**
	 * 删除
	 * @param idArr
	 * @return
	 */
	public boolean deleteSerialSearchInfos(String[] idArr) {
		for (String id : idArr) {
			serialSearchInfoDao.delete(id);
		}
		return true;
	}
	/**
	 * 导出Excel
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String exportExcelSerialSearchInfo(Map<String, Object> params) throws Exception {
		
		Page<SerialSearchInfo> page = (Page) params.get("page");
		page = querySerialSearchInfoPage(params);
		List<SerialSearchInfo> terList = page.getResult();
		
		List<Object[]> dataList = new ArrayList<Object[]>();
		HttpServletRequest request = FlexContext.getHttpRequest();

		String fileName = UUID.randomUUID() + "SerialSearchInfoTemplate.xls";
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ File.separator + "exportFile" + File.separator + fileName;// 导出文件路径
		String modelName = request.getSession().getServletContext()
				.getRealPath("")
				+ File.separator
				+ "exportFile"
				+ File.separator + "SerialSearchInfoTemplate.xls";// 文件模板路径
		
		Object[] row;
		for (int i = 0; i < terList.size(); i++) {
			row = new Object[8];
			SerialSearchInfo record = (SerialSearchInfo) terList.get(i);
			row[0] =DateUtil.getDateString(record.getSearchDate());
			row[1] = record.getOperatorName();
			row[2] = record.getSerialKeeper();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String RecordDate = null;
			if(record.getRecordDate()!=null){
				RecordDate = sdf.format(record.getRecordDate());
			}
			else{
				RecordDate = "";
			}
			if(Integer.parseInt(record.getNoteRecordType())!=0){
				row[3] = "柜面渠道";
			}
			else {
				row[3] = "自助设备渠道";
			}
			
			row[4] = RecordDate;
			row[5] = record.getSerialNo();
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
		String fileUrl = makeExcelFile(dataList, modelName, filePath);
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
				try {// 超过默认标签数时，程序自动创建
					tosheet = templatewb.getSheetAt(sheet);
				} catch (Exception e) {
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
						rowNum = rowId + 4;
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
}
