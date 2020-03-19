package com.grgbanking.sent.transmgr.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.SysException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.thread.ThreadLocalHelper;
import com.grgbanking.platform.module.datadir.dao.SysDatadirDao;
import com.grgbanking.platform.module.datadir.entity.SysDatadir;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.param.service.ParamService;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.sent.checkin.dao.SmsSerialDoubtRecordDao;
import com.grgbanking.sent.checkin.entity.CmlSentInfoStatisVO;
import com.grgbanking.sent.checkin.entity.SmsSerialDoubtRecord;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.constants.CmlNoteflowDetailInfoConsts;
import com.grgbanking.sent.transmgr.constants.CmlSentInfoConsts;
import com.grgbanking.sent.transmgr.dao.AtmTranInfoDao;
import com.grgbanking.sent.transmgr.dao.CmlCounterRecordDao;
import com.grgbanking.sent.transmgr.dao.CmlImprecordsDao;
import com.grgbanking.sent.transmgr.dao.CmlLoadNotesRecordDao;
import com.grgbanking.sent.transmgr.dao.CmlNoteflowDetailInfoDao;
import com.grgbanking.sent.transmgr.dao.CmlNoteflowInfoDao;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoDao;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoJDBCDao;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoJDBCForMySqlDao;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoJDBCForOracleDao;
import com.grgbanking.sent.transmgr.dao.CmlTaskInfoDao;
import com.grgbanking.sent.transmgr.entity.AtmTranInfo;
import com.grgbanking.sent.transmgr.entity.CmlCounterRecord;
import com.grgbanking.sent.transmgr.entity.CmlImprecords;
import com.grgbanking.sent.transmgr.entity.CmlLoadNotesRecord;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowDetailInfo;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowInfo;
import com.grgbanking.sent.transmgr.entity.CmlSentInfo;
import com.grgbanking.sent.transmgr.entity.CmlTaskInfo;
import com.grgbanking.sent.transmgr.entity.TranDetailInfo;
import com.grgbanking.sent.utils.CSVFileUtil;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.ImpFsnContent;
import com.grgbanking.sent.utils.ImpFsnTitle;
import com.grgbanking.sent.utils.POIUtils;
import com.grgbanking.sent.utils.R2002Msg;
import com.grgbanking.sent.utils.RequestFsnImg;
import com.grgbanking.sent.utils.ResultBMP;
import com.grgbanking.sent.utils.S2002Msg;
import com.grgbanking.sent.utils.StreamUtil;
import com.grgbanking.sent.utils.StringUtil;
import com.grgbanking.sent.utils.Transfer;

import flex.messaging.FlexContext;

/**
 * 
 */
@SuppressWarnings("unchecked")
@Service
public class CmlSentInfoService extends BaseService {

	@Autowired
	private CmlSentInfoDao cmlSentInfoDao;

	@Autowired
	private CmlImprecordsDao cmlImpRecordsDao;

	@Autowired
	SysDatadirService sysDataDirService ;
	
	@Autowired
	private CmlTaskInfoDao cmlTaskInfoDao;
	@Autowired
	private CmlTaskInfoService cmlTaskInfoService;
	@Autowired
	private AtmTranInfoDao atmTranInfoDao;
	@Autowired
	private AtmTranInfoService atmTranInfoService;
	@Autowired
	private CmlImprecordsService cmlImprecordsService;
	@Autowired
	private CmlLoadNotesRecordService cmlLoadNotesRecordService;
	@Autowired
	private CmlCounterRecordDao cmlCounterRecordDao;
	@Autowired
	private CmlCounterRecordService cmlCounterRecordService;

	@Autowired
	private TermInfoDao terminalInfoDao;
	@Autowired
	private CmlNoteflowInfoDao cmlNoteflowInfoDao;
	
	@Autowired
	ParamService paramService;

	// @Autowired
	// private CmlSentInfoHisDao cmlSentInfoHisDao;

	// @Autowired
	// private CmlSentTaskInfoDao cmlSentTaskInfoDao;

	// @Autowired
	// private TranInfoService tranInfoService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private OrgInfoDao orgInfoDao;

	@Autowired
	private ParamDao paramDao;

	@Autowired
	private CmlImprecordsDao cmlImprecordsDao;

	@Autowired
	private Transfer transfer;

	@Autowired
	private CmlNoteflowDetailInfoDao cmlNoteflowDetailInfoDao;

	@Autowired
	private SysDatadirService sysDatadirService;

	// @Autowired
	// private TermTypeDao termTypeDao;

	@Autowired
	private TermInfoDao termInfoDao;

	@Autowired
	private CmlLoadNotesRecordDao cmlLoadNotesRecordDao;

	@Autowired
	private SmsSerialDoubtRecordDao smsSerialDoubtRecordDao;

	@Autowired
	SysDatadirDao sysDatadirDao;
	final int str0 = 0;
	final int str1 = 1;
	final int str8 = 8;
	final int str13 = 13;
	final int str14 = 14;
	final int star0 = 0;
	final int star1 = 1;
	final int star2 = 2;
	final int star3 = 3;
	final int star4 = 4;
	final int star5 = 5;
	final int star6 = 6;
	final int star7 = 7;
	final int star8 = 8;
	final int star9 = 9;
	final int star10 = 10;
	final int subLength = 13;
	
	private int retCode;
	/**
	 * 获取对应的DAO
	 */
	public synchronized CmlSentInfoJDBCDao getCmlSentInfoJDBCDao() {
		// 获取线程内唯一的CmlSentInfoJDBCDao对象
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = (CmlSentInfoJDBCDao) ThreadLocalHelper
				.get(CmlSentInfoJDBCDao.class);
		if (cmlSentInfoJDBCDao == null) {
			if (DBDialectHelper.isOracle()) {
				cmlSentInfoJDBCDao = new CmlSentInfoJDBCForOracleDao();
			} else if (DBDialectHelper.isMySql()) {
				cmlSentInfoJDBCDao = new CmlSentInfoJDBCForMySqlDao();
			} else {
				throw new SysException("wrong db dialect: "
						+ DBDialectHelper.getDialect());
			}
			ThreadLocalHelper.put(CmlSentInfoJDBCDao.class, cmlSentInfoJDBCDao);
		}
		return cmlSentInfoJDBCDao;
	}

	/**
	 * 
	 */
	@Transactional(readOnly = true)
	public Page getCmlSentInfoPage(Map<String, Object> parameter) {
		logger.info("CmlSentInfoService.getCmlSentInfoPage()");

		Map<String, Object> condition = (Map<String, Object>) parameter
				.get("condition");

		// 判断时间合法性
		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");

		Date dStartTime = ServiceValidateHelper.validateQueryStartTime(
				startTime, "yyyy-MM-dd");
		Date dEndTime = ServiceValidateHelper.validateQueryEndTime(endTime,
				"yyyy-MM-dd");

		int days = Integer.parseInt(paramDao
				.getValueByPath(AppConstants.CML_TRANSDAY));
		ServiceValidateHelper
				.validateQueryTimeRange(dStartTime, dEndTime, days);

		// 设置查询最大天数和最大条数
		int queryMaxDays = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_TRANSDAY);
		int queryMaxRows = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_QUERY_MAX_ROWS);
		condition.put("queryMaxDays", queryMaxDays);
		condition.put("queryMaxRows", queryMaxRows);

		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		Page<CmlSentInfo> page = cmlSentInfoJDBCDao
				.getCmlSentInfoPage(parameter);

		this.fetchInfoForCmlSentInfoList(page.getResult());
		return page;
	}

	/**
	 * 新建方法实现数据库真分页，提升查询性能
	 * 
	 * @Description:
	 * @param parameter
	 * @return
	 * @author Norman_chang
	 * @since 2014-7-2 上午11:00:37
	 */
	@Transactional(readOnly = true)
	public Page getCmlSentInfoForPage(Map<String, Object> parameter) {
		logger.info("CmlSentInfoService.getCmlSentInfoPage()");

		Map<String, Object> condition = (Map<String, Object>) parameter
				.get("condition");

		// 判断时间合法性
		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");

		Date dStartTime = ServiceValidateHelper.validateQueryStartTime(
				startTime, "yyyy-MM-dd");
		Date dEndTime = ServiceValidateHelper.validateQueryEndTime(endTime,
				"yyyy-MM-dd");

		int days = Integer.parseInt(paramDao
				.getValueByPath(AppConstants.CML_TRANSDAY));
		ServiceValidateHelper
				.validateQueryTimeRange(dStartTime, dEndTime, days);
		
		String isFuzzyQuery = (String) condition.get("isFuzzyQuery");
		if("true".equals(isFuzzyQuery)){
			int daysForFuzzyQuery = Integer.parseInt(paramDao
					.getValueByPath(AppConstants.SENT_ALLDAY_FOR_FUZZY_QUERY)==null?"1":paramDao
							.getValueByPath(AppConstants.SENT_ALLDAY_FOR_FUZZY_QUERY));
			ServiceValidateHelper
			.validateQueryTimeRangeForFuzzyQuery(dStartTime, dEndTime, daysForFuzzyQuery);
		}

		int queryMaxDays = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_TRANSDAY);
		int queryMaxRows = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_QUERY_MAX_ROWS);
		condition.put("queryMaxDays", queryMaxDays);
		condition.put("queryMaxRows", queryMaxRows);

//		List<SysDatadir> CRHFK_List = sysDataDirService.getDatadirChildrenByPath("SysDatadirMgr.sent.transMgr.CRHFK","zh_CN");
//	    List<SysDatadir> CRHSK_List = sysDataDirService.getDatadirChildrenByPath("SysDatadirMgr.sent.transMgr.CRHSK","zh_CN");
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		Page<CmlSentInfo> page = cmlSentInfoJDBCDao
				.getCmlSentInfoForPage(parameter);

		this.fetchInfoForCmlSentInfoList(page.getResult());
		return page;
	}
	
	
	/**
	 * 新建方法实现数据库真分页，提升查询性能
	 * 
	 * @Description:
	 * @param parameter
	 * @return
	 * @author Norman_chang
	 * @since 2014-7-2 上午11:00:37
	 */
	@Transactional(readOnly = true)
	public String checkResultIsOutOfRange(Map<String, Object> parameter) {
		logger.info("CmlSentInfoService.checkResultIsOutOfRange()");

		Map<String, Object> condition = (Map<String, Object>) parameter
				.get("condition");
		
		String outOfResultRangeTips = "";

		// 判断查询结果是否超出或达到最大查询结果
		int totalCount = (Integer) condition.get("totalCount");
		int queryMaxRows = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_QUERY_MAX_ROWS);


		if(totalCount==queryMaxRows){
			outOfResultRangeTips = "查询结果数据已超出范围,系统只显示前"+queryMaxRows+"条,请缩小查询条件.";
		}
		return outOfResultRangeTips;
	}                                                                                             

	/**
	 * 
	 */
	@Transactional(readOnly = true)
	public Page getTranInfoPage(Map<String, Object> parameter) {
		
		Page<CmlSentInfo> parameterPage = (Page) parameter.get("page");
		//保存页面中的页码和每页数
		int realPageSize = parameterPage.getPageSize();
		int realPageNo = parameterPage.getPageNo();
		//这样设置是为了获取此冠字号的全部记录
		parameterPage.setPageNo(1);
		parameterPage.setPageSize(1000);
		parameter.put("page", parameterPage);
		
		Page<CmlSentInfo> page = getCmlSentInfoPage(parameter);
		List<CmlSentInfo> infoLst = page.getResult();
		// 去掉重复项(实际不存在这种情况)
		// removeDuplicateWithOrder(infoLst);
		List<TranDetailInfo> resultLst = new ArrayList<TranDetailInfo>();
		
		int pageNo = 0;
		// for (CmlSentInfo info : infoLst) {
		for (int i = 0; i < infoLst.size(); i++) {
			CmlSentInfo info = infoLst.get(i);
			String tranId = info.getTranId();
			if (CmlSentInfoConsts.TERM_TYPE_CML_TASK_INFO.equals(info
					.getTermType())) {// 清分交易
				CmlTaskInfo infoTmp = cmlTaskInfoService
						.getCmlTaskInfoDetailById(tranId);
				if(infoTmp==null) continue;
				TranDetailInfo ti = new TranDetailInfo();
				ti.setTranDate(info.getTranDate());// 交易时间
				ti.setTermId(infoTmp.getTermId());
				ti.setOrgName(infoTmp.getPathCodeName());
				ti.setTranType(info.getTermType());
				ti.setOperatorCode(infoTmp.getTdOperatorId());
				ti.setTranCount(infoTmp.getTranCount());
				ti.setTranAmount(infoTmp.getStatisAmt());//
				ti.setOperType(infoTmp.getRotoCashType());// SysDatadirMgr.sent.cmlMgr

				resultLst.add(ti);
				pageNo++;
			} else if (CmlSentInfoConsts.TERM_TYPE_ATM_TRAN_INFO.equals(info
					.getTermType())) {// ATM交易
				AtmTranInfo infoTmp = atmTranInfoService
						.getAtmTranInfoDetailById(tranId);
				if(infoTmp==null) continue;
				TranDetailInfo ti = new TranDetailInfo();
				ti.setTranDate(info.getTranDate());// 交易时间
				ti.setTermId(infoTmp.getTermId());
				ti.setOrgName(infoTmp.getTransOrgName());
				ti.setTranType(info.getTermType());
				ti.setOperatorCode(infoTmp.getTermId());// ?
				ti.setTranCount(BigDecimal.valueOf(infoTmp.getTransNotenum()
						.longValue()));
				ti.setTranAmount(BigDecimal.valueOf(infoTmp.getStatisAtm()
						.longValue()));//
				ti.setOperType(infoTmp.getTransCode());

				resultLst.add(ti);
				pageNo++;
			} else if (CmlSentInfoConsts.TERM_TYPE_CML_IMPORT_RECORD
					.equals(info.getTermType())) {// 导入交易（手动导入）
				CmlImprecords infoTmp = cmlImprecordsService
						.getCmlImpRecordsDetailById(tranId);
				if(infoTmp==null) continue;
				TranDetailInfo ti = new TranDetailInfo();
				// ti.setTranDate(infoTmp.getOperaterDate());infoTmp.getOperaterDate()是导入日期
				ti.setTranDate(info.getTranDate());// 交易时间
				ti.setTermId(infoTmp.getTermId());
				ti.setOrgName(infoTmp.getPathCodeName());
				ti.setTranType(info.getTermType());
				ti.setOperatorCode(infoTmp.getOperaterId());
				ti.setTranCount(infoTmp.getSeriaNum());
				ti.setTranAmount(BigDecimal.valueOf(0));// 没办法知道
				ti.setOperType(infoTmp.getOperateStatus());// ?

				resultLst.add(ti);
				pageNo++;
			} else if (CmlSentInfoConsts.TERM_TYPE_CML_FLOWNUM_RECORD
					.equals(info.getTermType())) {// 现金流转交易
				CmlNoteflowInfo infoTmp = cmlNoteflowInfoDao.get(tranId);
				if(infoTmp==null) continue;
				TranDetailInfo ti = new TranDetailInfo();
				ti.setTranDate(info.getTranDate()); // 交易时间
				ti.setTermId(infoTmp.getTermId());
				String pathCodeName = orgInfoDao.getByPathCode(
						infoTmp.getPathCode()).getOrgName();
				ti.setOrgName(pathCodeName);
				ti.setTranType(info.getTermType());
				ti.setOperatorCode(infoTmp.getTdOperatorId());
				ti.setTranCount(BigDecimal.valueOf(infoTmp.getNoteCount()));
				ti.setTranAmount(BigDecimal.valueOf(infoTmp.getStatisAmt()
						.longValue()));// 统计金额
				ti.setOperType(infoTmp.getFlowStage());

				resultLst.add(ti);
				pageNo++;
			} else if (CmlSentInfoConsts.TERM_TYPE_CML_LOAD_NOTES_RECORD
					.equals(info.getTermType())) {// ATM加钞/清机交易
				CmlLoadNotesRecord infoTmp = cmlLoadNotesRecordService
						.getCmlLoadNotesRecordDetailById(tranId);
				if(infoTmp==null) continue;
				TranDetailInfo ti = new TranDetailInfo();
				ti.setTranDate(info.getTranDate());// 交易时间
				ti.setTermId(infoTmp.getTermCode());
				ti.setOrgName(infoTmp.getPathCodeName());
				ti.setTranType(info.getTermType());
				ti.setOperatorCode(infoTmp.getOperatorCode());
				ti.setTranCount(infoTmp.getTranCount());
				ti.setTranAmount(infoTmp.getTranAmount());
				ti.setOperType(infoTmp.getOperType() + "");// ?

				resultLst.add(ti);
				pageNo++;
			} else if (CmlSentInfoConsts.TERM_TYPE_CML_COUNTER_RECORD
					.equals(info.getTermType())) {// 柜面交易
				CmlCounterRecord infoTmp = cmlCounterRecordService
						.getCmlCounterRecordDetailById(tranId);
				if(infoTmp==null) continue;
				TranDetailInfo ti = new TranDetailInfo();
				ti.setTranDate(info.getTranDate());// 交易时间
				ti.setTermId(infoTmp.getTermId());
				ti.setOrgName(infoTmp.getPathCodeName());
				ti.setTranType(info.getTermType());
				ti.setOperatorCode(infoTmp.getTdOperatorId());
				ti.setTranCount(infoTmp.getTranCount());
				ti.setTranAmount(infoTmp.getStatisAtm());
				ti.setOperType(infoTmp.getBusinessType() + "");// ?

				resultLst.add(ti);
				pageNo++;
			}
		}
		
		//根据页面的页码和每页数决定返回的结果集
		int begin = (realPageNo - 1) * realPageSize;
		int end = realPageNo * realPageSize;
		end = end > resultLst.size() ? resultLst.size() : end;
		List<TranDetailInfo> realResultLst = new ArrayList<TranDetailInfo>();
		for(int i = begin; i < end; i++){
			realResultLst.add(resultLst.get(i));
		}
		
		Page p = new Page();
		p.setAutoCount(page.isAutoCount());
		p.setOrder(page.getOrder());
		p.setOrderBy(page.getOrderBy());
		p.setPageNo(realPageNo);
		p.setPageSize(realPageSize);
		p.setTotalCount(pageNo);
		p.setResult(realResultLst);
		return p;
	}

	/**
	 * 
	 */
	public CmlSentInfo getCmlSentInfosByIdFromTable(Map parameter) {
		String tableName = (String) parameter.get("tableName");
		String id = (String) parameter.get("id");

		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		CmlSentInfo cmlSentInfo = cmlSentInfoJDBCDao
				.getCmlSentInfosByIdFromTable(id, tableName);
		// 业务类型
		// cmlSentInfo.setBusinessTypeDesc(getCmlSentFlowBusinessTypeById(id,
		// tableName));
		String businessTypeDesc = getCmlSentInfoBusinessType(cmlSentInfo);
		cmlSentInfo.setBusinessTypeDesc(businessTypeDesc);

		OrgInfo orgInfo = orgInfoDao.getByPathCode(cmlSentInfo.getPathcode());
		cmlSentInfo.setOrgName(orgInfo.getOrgName());
		cmlSentInfo.setOrgFullName(orgInfo.getOrgFullName());
		cmlSentInfo.setOrgNameFinanceCode(orgInfo.getFinacialCode());
		// 得到当前银行名称
		cmlSentInfo.setCurrentBank(paramDao
				.getValueByPathWithException(AppConstants.CURRENT_BANK));

		/*原来的方法*/
//		fetchSerialNoImagesForOneP(cmlSentInfo);
		
		/*二次获取图像的处理方法*/
		List<CmlSentInfo> cmlSentInfoList = new ArrayList<CmlSentInfo>();
		cmlSentInfoList.add(cmlSentInfo);
		fetchSerialNoImagesForListP(cmlSentInfoList);
		
		return cmlSentInfo;
	}

	// 冠字号对应交易的业务类型
	public String getCmlSentInfoBusinessType(CmlSentInfo info) {

		try{
		if (info.getTermType().equals("4")) {// atm加钞交易
			CmlLoadNotesRecord tranObj = cmlLoadNotesRecordDao.get(info
					.getTranId());

			// 获取数据字典的数据
			// 加钞的atm类型
			List<SysDatadir> busTypeList = sysDatadirService
					.getDatadirChildrenByPath(
							AppConstants.ADDCASHBUSINESS_PATH, "zh_CN");
			// Map<String, String> atmTypeMap = new HashMap<String, String>();
			for (SysDatadir obj : busTypeList) {
				// atmTypeMap.put(obj.getKey(), obj.getValue());
				if (obj.getKey().equals(tranObj.getType() + "")) {
					return obj.getValue();
				}
			}
		} else if (info.getTermType().equals("0")) {// 清分交易
			CmlTaskInfo tranObj = cmlTaskInfoDao.get(info.getTranId());

			// 获取数据字典的数据
			// 清分类型
			List<SysDatadir> busTypeList = sysDatadirService
					.getDatadirChildrenByPath(
							AppConstants.CLEARINGTRANBUSINESS_PATH, "zh_CN");
			// Map<String, String> atmTypeMap = new HashMap<String, String>();
			for (SysDatadir obj : busTypeList) {
				// atmTypeMap.put(obj.getKey(), obj.getValue());
				if (obj.getKey().equals(tranObj.getRotoCashType())) {
					return obj.getValue();
				}
			}
		} else if (info.getTermType().equals("1")) {// ATM交易
			AtmTranInfo tranObj = atmTranInfoDao.get(info.getTranId());

			// 获取数据字典的数据
			// 交易类型
			List<SysDatadir> busTypeList = sysDatadirService
					.getDatadirChildrenByPath(
							AppConstants.ATMTRANBUSINESS_PATH, "zh_CN");
			// Map<String, String> atmTypeMap = new HashMap<String, String>();
			for (SysDatadir obj : busTypeList) {
				// atmTypeMap.put(obj.getKey(), obj.getValue());
				if (obj.getKey().equals(tranObj.getTransCode())) {
					return obj.getValue();
				}
			}
		} else if (info.getTermType().equals("5")) {// 柜面交易
			CmlCounterRecord tranObj = cmlCounterRecordDao
					.get(info.getTranId());

			// 获取数据字典的数据
			// 交易类型
			List<SysDatadir> busTypeList = sysDatadirService
					.getDatadirChildrenByPath(
							AppConstants.COUNTERBUSINESS_PATH, "zh_CN");
			// Map<String, String> atmTypeMap = new HashMap<String, String>();
			for (SysDatadir obj : busTypeList) {
				// atmTypeMap.put(obj.getKey(), obj.getValue());
				if (obj.getKey().equals(tranObj.getBusinessType() + "")) {
					return obj.getValue();
				}
			}
		} else if (info.getTermType().equals("2")) {// 手动导入
			return "清分";
		} else if (info.getTermType().equals("3")) {// 现金流转
			return "现金流转";
		}
		}catch(NullPointerException e){
			return "暂无(文件解析中)";
		}
		return "暂无";
	}

	/**
	 * 
	 * @param list
	 *            List
	 * @param page
	 *            Page
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getPageList(List list, Page page) {
		return cmlTaskInfoDao.getPageList(list, page);
	}

	/**
	 * 
	 */
	public String getInitCmlParamMap() {
		return paramDao.getValueByPath((AppConstants.CML_TRANSDAY));
	}

	// /**
	// * 根据id查询对应的交易详
	// *
	// * @param p_taskId
	// */
	// @Transactional(readOnly = true)
	// public CmlTaskInfo getCmlTaskById(CmlSentInfo s)
	// {
	// CmlTaskInfo cti = new CmlTaskInfo();
	// String hql = null;
	// try
	// {
	//
	// // 查询流转条码，行号，网点名，业务类型
	// hql = "select c.tmlNum,c.operatorId,c.bindStart," +
	// "c.totalMoney,c.rotoCashType,n.barcode1,n.barcode2 from CmlTaskInfo c,CmlSentInfo cml,CmlNoteflowDetailInfo n"
	// + " where c.id=cml.tranId ";
	//
	// if( null != s.getBarcodeFlowNum() && !s.getBarcodeFlowNum().equals("") )
	// {
	// hql += " and n.barcodeFlowNum='" + s.getBarcodeFlowNum() + "'";
	// }
	// if( null != s.getTranId() && !s.getTranId().equals("") )
	// {
	// hql += " and c.id='" + s.getTranId() + "'";
	// }
	// // substring(0,'"+cml.getPathcode().length()-1+"')
	// // logger.info(hql);
	// // cti = cmlTaskInfoDao.get(id);
	// List li = cmlTaskInfoDao.find(hql);
	// if( li.size() > 0 )
	// {
	// Object[] obj = (Object[]) li.get(0);
	// if( li.size() > 0 )
	// {
	// if( StringUtils.isNotBlank(obj[0].toString()) )
	// {
	// cti.setTmlNum(obj[0].toString());
	// }
	// if( StringUtils.isNotBlank(obj[1].toString()) )
	// {
	//
	// cti.setOperatorId(obj[1].toString());
	// }
	// else
	// {
	// obj[1] = "";
	// cti.setOperatorId(obj[1].toString());
	//
	// }
	// if( StringUtils.isNotBlank(obj[2].toString()) )
	// {
	//
	// cti.setBindStart((Date) obj[2]);
	// }
	//
	// if( StringUtils.isNotBlank(obj[3].toString()) )
	// {
	//
	// cti.setTotalMoney(Float.parseFloat(obj[3].toString()));
	// }
	//
	// if( StringUtils.isNotBlank(obj[4].toString()) )
	// {
	// cti.setRotoCashType(obj[4].toString());
	// }
	//
	// if( null != obj[5] && !obj[5].equals("") )
	// {
	// cti.setBoxNum(obj[5].toString());
	// }
	// else
	// {
	// cti.setBoxNum(null);
	// }
	// if( null != obj[6] && !obj[6].equals("") )
	// {
	// cti.setAtmNum(obj[6].toString());
	// }
	// else
	// {
	// cti.setAtmNum(null);
	//
	// }
	// }
	// }
	// }
	// catch( IllegalArgumentException e )
	// {
	//
	// cti = null;
	// logger.error("", e);
	// }
	// return cti;
	// }

	// /**
	// * ???id????????????_1?7
	// *
	// * @param id
	// * ???
	// *@return ??????
	// */
	// @Transactional(readOnly = true)
	// public CmlSentTaskInfo getCmlSentTaskInfo(String id) {
	// return (CmlSentTaskInfo) cmlSentTaskInfoDao.get(id);
	// }

	// @Transactional(readOnly = true)
	// public CmlImprecords getCmlImprecords(String id) {
	// String name = cmlSentInfoDao.get(id).getFileName();
	// CmlImprecords cmlImprecords = new CmlImprecords();
	// try {
	// cmlImprecords = cmlImprecordsDao
	// .findCmlRCmlImprecordsByFileName(name);
	// } catch (AppException e) {
	//
	// }
	// return cmlImprecords;
	// }

	/**
	 * 
	 * 
	 * @param id
	 * 
	 *@return CmlSentInfo
	 */
	@Transactional(readOnly = true)
	public CmlSentInfo getCmlSentObject(String id) {
		return (CmlSentInfo) cmlSentInfoDao.get(id);
	}

	@Transactional(readOnly = true)
	public List<CmlSentInfo> getCmlSentInfosByTranId(String tranId) {
		List<CmlSentInfo> list = new ArrayList<CmlSentInfo>();
		try {
			String hql = " from CmlSentInfo c where c.tranId=?";
			list = cmlSentInfoDao.find(hql, tranId);
		} catch (NullPointerException e) {
			list = null;
			logger.error("", e);
		}
		return list;
	}

	/**
	 * 
	 */
	@Transactional(readOnly = true)
	public List<CmlSentInfo> getCmlSentInfosById(String id) {
		List<CmlSentInfo> list = new ArrayList<CmlSentInfo>();

		String hql = " from CmlSentInfo c where c.id='" + id + "'";
		list = cmlSentInfoDao.find(hql);

		fetchSerialNoImagesForList(list);

		return list;
	}

	public boolean updateCmlInfo(CmlSentInfo obj) {
		boolean flag = false;
		try {
			cmlSentInfoDao.copyUpdate(obj);
			flag = true;
		} catch (NullPointerException e) {
			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}

	public Map<String, Object> getCmlImgParmPath() {
		Map<String, Object> picPathMap = new HashMap<String, Object>();
		String imagePath = paramDao
				.getValueByPathWithException(AppConstants.IMAGE_PATH);
		String fsnPath = paramDao
				.getValueByPathWithException(AppConstants.FSN_PICPATH);
		picPathMap.put("imagePath", imagePath);
		picPathMap.put("fsnPath", fsnPath);
		return picPathMap;
	}

	/**
	 * 查看冠字号码的图像
	 * 
	 * @return List
	 */
	// public List getCmlSentPic(String ids, String montharr) {
	// String fsnPath = paramDao
	// .getValueByPathWithException(AppConstants.FSN_PICPATH);
	// if (fsnPath == null) {
	// throw new ParamException(AppConstants.FSN_PICPATH);
	// }
	//
	// fsnPath = fsnPath.replace("\\", "/");
	// if (fsnPath.endsWith("/") == false) {
	// fsnPath += "/";
	// }
	//
	// // 获得配置的记录数
	// int iCmlSentRecords = paramDao
	// .getIntegerValueByPathWithException(AppConstants.CMLSENT_RECORDS);
	// if (iCmlSentRecords <= 0) {
	// throw new SimpleAppException("参数[" + AppConstants.CMLSENT_RECORDS
	// + "]必须大于0");
	// }
	//
	// List<CmlSentInfo> list = new ArrayList<CmlSentInfo>();
	//
	// String[] arrStr = ids.split(",");
	//
	// for (int i = 0; i < arrStr.length; i++) {
	// String id = arrStr[i];
	// if (StringUtil.isBlank(id)) {
	// continue;
	// }
	//
	// String hql = " from CmlSentInfo cml where cml.id='" + id + "'";
	// CmlSentInfo cml = cmlSentInfoDao.findFirst(hql);
	// if (cml == null) {
	// continue;
	// }
	// list.add(cml);
	//
	// if (cml.getImageType().equals("3"))// 其他厂商的机器，暂时定为类型3，参考ATM
	// {
	// generateImageByMessage(cml, "image type is [3]", 200, 20);
	// continue;
	// }
	//
	// // 20130528_00000001_0528162101_CNY_0.FSN
	// // 文件名称从0开始，
	// if (cml.getSequence() == 0) {
	// generateImageByMessage(cml, "Sequence is [0]", 200, 20);
	// continue;
	// }
	//
	// // 正常情况
	// String tranDate = cml.getTranDate();
	// String yyyyMMdd = tranDate.substring(0, 8);
	//
	// int fsnSeq = cml.getSequence() - 1; // 从0开始
	// int fileIndex = fsnSeq / iCmlSentRecords;
	// String fileName = yyyyMMdd + "_" + cml.getTermid() + "_"
	// + cml.getJournalNo() + "_" + "CNY" + "_" + fileIndex
	// + ".FSN";
	// int fsnItemSeq = fsnSeq % iCmlSentRecords;
	//
	// File fsnFile = new File(fsnPath + yyyyMMdd + "/" + fileName);
	// if (fsnFile.exists() == false) {
	// logger.error("FSN file doesn't exist: ["
	// + fsnFile.getAbsolutePath() + "]");
	// generateImageByMessage(cml, "FSN file doesn't exist.", 200, 20);
	// continue;
	// }
	//
	// InputStream fsnIn = null;
	// try {
	// fsnIn = new FileInputStream(fsnFile);
	//
	// ByteArrayOutputStream imageOut = new ByteArrayOutputStream();
	// new ResultBMP(fsnIn, imageOut, fsnItemSeq);
	//
	// byte[] imageBytes = imageOut.toByteArray();
	// ByteArrayInputStream imageIn = new ByteArrayInputStream(
	// imageBytes, 0, imageBytes.length);
	// ByteArrayOutputStream jpgOut = new ByteArrayOutputStream();
	//
	// ImageIO.write(ImageIO.read(imageIn), "jpg", jpgOut);
	// cml.setImageArr(jpgOut.toByteArray());
	// } catch (Exception e) {
	// logger.error("No image at FSN[" + fsnItemSeq + "]: ["
	// + fsnFile.getAbsolutePath() + "]");
	// generateImageByMessage(cml, "No image at FSN[" + fsnItemSeq
	// + "]", 200, 20);
	// logger.error("读取fsn图片文件失败", e);
	// } finally {
	// StreamUtil.close(fsnIn);
	// }
	// }
	//
	// return list;
	//
	// }

	public void generateImageByMessage(CmlSentInfo cml, String message,
			int width, int height) {
		try {
			ByteArrayOutputStream errorImageOut = new ByteArrayOutputStream();
			BufferedImage img = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			Font font = new Font("TimesRoman", Font.PLAIN, height - 4);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString(message, 5, height - 4);
			g.dispose();
			ImageIO.write(img, "jpg", errorImageOut);
			cml.setImageArr(errorImageOut.toByteArray());
		} catch (IOException e) {
			logger.error("", e);
		}
	}

	/**
	 * 
	 */
	public void fetchSerialNoImagesForPage(Page<CmlSentInfo> page) {
		fetchSerialNoImagesForList(page.getResult());
	}

	/**
	 * 
	 */
	public void fetchSerialNoImagesForList(List<CmlSentInfo> seqList) {
		String imagePath = paramDao
				.getValueByPathWithException(AppConstants.IMAGE_PATH); // 获取atm图片的主目录
		String fsnPath = paramDao
				.getValueByPathWithException(AppConstants.FSN_PICPATH); // 获取fsn的主目录
		int cmlSentRecords = paramDao
				.getIntegerValueByPathWithException(AppConstants.CMLSENT_RECORDS); // 获得单个文件内的记录数

		boolean isConnectFail = false;
		for (CmlSentInfo cmlSentInfo : seqList) {
			String imageType = cmlSentInfo.getImageType();
			if ("0".equals(imageType)) {
				generateImageForMessage(cmlSentInfo, "No image.", 320, 32);
			} else if ("3".equals(imageType)) {
				// 3表示atm还没有查看过图片，需要后台提取
				// 其它厂商的机器，暂时定为类型3，做法与atm类似
				try {
					if (isConnectFail == false) {
						// 发消息到SeNTServer获取atm冠字号图片
						fetchAtmImageFile(cmlSentInfo, imagePath);
					}
				} catch (IOException e) {
					logger.error("获取ATM图片失败", e);
					isConnectFail = true;
				}
				// 
				if (isConnectFail) {
					generateImageForMessage(cmlSentInfo,
							"IOException: connect server fail.", 320, 32);
				}
			}
			// else if ("4".equals(imageType)) {
			// // 直接拼接url
			// if (StringUtil.isBlank(cmlSentInfo.getFileName())) {
			// generateImageForMessage(cmlSentInfo, "File name is empty.",
			// 320, 32);
			// } else {
			// cmlSentInfo.setFullUrl(concatImageFullUrl(imagePath,
			// cmlSentInfo.getFileName()));
			// }
			// } else if ("2".equals(imageType) || "46".equals(imageType)) {
			// // 从fsn文件获取图片
			// fetchFsnImageData(cmlSentInfo, fsnPath, cmlSentRecords);
			// } else {
			// // 错误的情况
			// generateImageForMessage(cmlSentInfo, "wrong image type ["
			// + imageType + "].", 320, 32);
			// }
		}
	}

	// public void fetchSerialNoImagesForOne(CmlSentInfo cmlSentInfo) {
	// String imageType = cmlSentInfo.getImageType();
	// if ("0".equals(imageType)) {
	// generateImageForMessage(cmlSentInfo, "No image.", 320, 32);
	// } else if ("3".equals(imageType)) {
	// // 3表示atm还没有查看过图片，需要后台提取
	// // 其它厂商的机器，暂时定为类型3，做法与atm类似
	// try {
	// // 发消息到SeNTServer获取atm冠字号图片
	// String imagePath = paramDao
	// .getValueByPath(AppConstants.IMAGE_PATH); // 获取atm图片的主目录
	// fetchAtmImageFile(cmlSentInfo, imagePath);
	// } catch (IOException e) {
	// logger.error("获取ATM图片失败", e);
	// generateImageForMessage(cmlSentInfo,
	// "IOException: connect server fail.", 320, 32);
	// }
	// } else if ("4".equals(imageType)) {
	// // 直接拼接图片的url: 用于atm获取图片
	// String imagePath = paramDao.getValueByPath(AppConstants.IMAGE_PATH); //
	// 获取atm图片的主目录
	// cmlSentInfo.setFullUrl(concatImageFullUrl(imagePath, cmlSentInfo
	// .getFileName()));
	// } else if ("2".equals(imageType) || "46".equals(imageType)) {
	// // 从fsn文件获取图片
	// String fsnPath = paramDao
	// .getValueByPathWithException(AppConstants.FSN_PICPATH); // 获取fsn的主目录
	// int cmlSentRecords = paramDao
	// .getIntegerValueByPathWithException(AppConstants.CMLSENT_RECORDS); //
	// 获得单个文件内的记录数
	// fetchFsnImageData(cmlSentInfo, fsnPath, cmlSentRecords);
	// } else {
	// // 错误的情况
	// generateImageForMessage(cmlSentInfo, "wrong image type ["
	// + imageType + "].", 320, 32);
	// }
	//
	// }

	/**
	 * 获取冠字号图片
	 */
	public void fetchSerialNoImagesForPageP(Page<CmlSentInfo> page) {
		fetchSerialNoImagesForListP(page.getResult());
	}

	/**
	 * 远程请求获取含有冠字号图像的FSN文件处理
	 * @return 远程通讯返回码
	 */
	public int requestImageFsn(CmlSentInfo cmlSentInfo,Map<String,String> mapTranId){
		String tranId = cmlSentInfo.getTranId();
		String imageType = cmlSentInfo.getImageType();
		
		//如果tranId字典中尚未存在当前的tranId，则需要进行处理，否则仅获取字典对应的值即可。
		if(!mapTranId.containsKey(tranId)){
			//imagetype为45没图像，则进行处理
			if(CmlSentInfoConsts.NO_FSNIMG_CODE.equals(imageType)){
				try{
					//1.进行发送请求
					RequestFsnImg request = new RequestFsnImg();
					retCode = request.requestFsnImgNT(21, tranId,transfer);
					logger.info("远程获取返回码："+retCode);
					
					//2.如果返回码是处理中，则等待轮询数据库状态
					if(CmlSentInfoConsts.REQUEST_IMG_RETCODE_STILL_DOING==retCode){
						//等待次数
						int times = Integer.parseInt(paramService.getValueByPath(AppConstants.SENT_IMG_TIMES));
						//等待秒数
						int sleepTime = Integer.parseInt(paramService.getValueByPath(AppConstants.SENT_IMG_SLEEPTIME));
						
						for(int i = 0;i<=times;i++){
							String status = getStatus(tranId);
							logger.info("状态："+status);
							if(CmlSentInfoConsts.STILL_DOING.equals(status)){
								//如果最后一次仍然是处理中状态，则直接返回超时状态，并退出轮询
								if(i==times){
									retCode = CmlSentInfoConsts.REQUEST_IMG_RETCODE_OUTTIME;
									break;
								}
								//如果不是最后一次，而且状态为处理中，则休眠一段时间
								Thread.sleep(sleepTime);
							}else if(CmlSentInfoConsts.DONE.equals(status)){
								retCode = CmlSentInfoConsts.REQUEST_IMG_RETCODE_FINISH;
								break;
							}else{
								retCode = CmlSentInfoConsts.REQUEST_IMG_RETCODE_FAILE;
								break;
							}
						}
					}
				}catch(IOException e){
					logger.error("遇到IO异常："+e.getLocalizedMessage());
					retCode = CmlSentInfoConsts.REQUEST_IMG_RETCODE_IOERR;
				}catch(Exception e){
					logger.error("遇到异常："+e.getLocalizedMessage());
					retCode = CmlSentInfoConsts.REQUEST_IMG_RETCODE_FAILE;
				}
			}
			logger.info("tranId:"+tranId+"--远程返回码："+retCode);
			mapTranId.put(tranId, retCode+"");
		}else{
			retCode = Integer.parseInt(mapTranId.get(tranId));
		}
		
		return retCode;
	}
	
	/**
	 * 获取冠字号图片
	 */
	public void fetchSerialNoImagesForListP(List<CmlSentInfo> seqList) {
		/*原来处理方法*/
//		for (CmlSentInfo cmlSentInfo : seqList) {
//			fetchSerialNoImagesForOneP(cmlSentInfo);
//		}
		//获取是否需要远程请求获取冠字号图像标识 0-需要  1-不需要
		String isRequestFsnImg = paramService.getValueByPath(AppConstants.IS_REQUEST_FSN_IMG);
		
		Map<String,String> mapTranId = new HashMap<String,String>();
		
		/*二次获取图像的处理方法*/
		for (CmlSentInfo cmlSentInfo : seqList) {
			//默认请求返回码成功
			retCode = CmlSentInfoConsts.REQUEST_IMG_RETCODE_SUCCESS;
			
			//需要远程请求获取FSN图像文件
			if(CmlSentInfoConsts.NEED.equals(isRequestFsnImg)){
				retCode = requestImageFsn(cmlSentInfo,mapTranId);
			}
			
			fetchSerialNoImagesForOneP(cmlSentInfo);
		}
	}

	/**
	 *获取冠字号图片（专业版）
	 */
	public void fetchSerialNoImagesForOneP(CmlSentInfo cmlSentInfo) {
		String imageType = cmlSentInfo.getImageType();
		//返回码如果不是超时，IO异常，成功或者已上传完成几个状态，统一规定为失败状态
		
		if(retCode == CmlSentInfoConsts.REQUEST_IMG_RETCODE_IOERR){
			generateImageForMessage(cmlSentInfo, "REQUEST IMG IOERR", 320, 32);
			return;
		}else if(retCode == CmlSentInfoConsts.REQUEST_IMG_RETCODE_OUTTIME){
			generateImageForMessage(cmlSentInfo, "REQUEST IMG OUTTIME", 320, 32);
			return;
		}else if(retCode != CmlSentInfoConsts.REQUEST_IMG_RETCODE_SUCCESS 
				&& retCode != CmlSentInfoConsts.REQUEST_IMG_RETCODE_FINISH){
			generateImageForMessage(cmlSentInfo, "REQUEST IMG FAILE", 320, 32);
			return;
		}
		
		if ("0".equals(imageType)||"45".equals(imageType)) {
			generateImageForMessage(cmlSentInfo, "No image.", 320, 32);
		} else {
			CmlImprecords impRecord = cmlImpRecordsDao.get(cmlSentInfo
					.getTranId());
			if (impRecord == null) {
				// 冠字号在上传表中没找到记录
				generateImageForMessage(cmlSentInfo,
						"Exception: can not found impRecord.", 320, 32);
			} else {
				// FSN是否包含图片文件序列（木有）
				// impRecord.getSeriaimgFlag();
				// 从fsn文件获取图片
				String fsnPath = paramDao
						.getValueByPathWithException(AppConstants.FSN_PICPATH); // 获取fsn的主目录
				int cmlSentRecords = paramDao
						.getIntegerValueByPathWithException(AppConstants.CMLSENT_RECORDS); // 获得单个文件内的记录数

				fsnPath = fsnPath.replace("\\", "/");
				if (fsnPath.endsWith("/") == false) {
					fsnPath = fsnPath + "/";
				}

				String yyyyMMdd = impRecord.getTranDate();// 清分年月日
				String termId = impRecord.getTermId();// 终端编号
				String fileName = impRecord.getFileName();// 文件名称
				fsnPath += yyyyMMdd + "/";
				fsnPath += termId + "/";
				fsnPath += fileName;

				// fsn文件名直接取
				int innerSequence = cmlSentInfo.getSequence();
				File fsnFile = new File(fsnPath);
				InputStream fsnIn = null;
				try {
					if (fsnFile.exists() == false) {
						logger.info("FSN文件不存在[" + fsnFile.getAbsolutePath()
								+ "]");
						generateImageForMessage(cmlSentInfo,
								"FSN file not exists.", 320, 32);
						return;
					}
					fsnIn = new FileInputStream(fsnFile);
					ByteArrayOutputStream imageOut = new ByteArrayOutputStream();
					new ResultBMP(fsnIn, imageOut, innerSequence);

					byte[] imageBytes = imageOut.toByteArray();
					ByteArrayInputStream imageIn = new ByteArrayInputStream(
							imageBytes, 0, imageBytes.length);
					ByteArrayOutputStream jpgOut = new ByteArrayOutputStream();

					ImageIO.write(ImageIO.read(imageIn), "jpg", jpgOut);
					cmlSentInfo.setImageArr(jpgOut.toByteArray());
					// cml.setWidth(160);
					// cml.setHeight(20);
					return;
				} catch (Exception e) {
					generateImageForMessage(
							cmlSentInfo,
							"Exception:No image in FSN[" + innerSequence + "].",
							320, 32);
					return;
				} finally {
					if (fsnIn != null) {
						StreamUtil.close(fsnIn);
					}
				}
			}
		}
	}

	/**
	 * 获取清分冠字号的图片数据
	 */
	// private void fetchFsnImageData(CmlSentInfo cml, String fsnPath,
	// int cmlSentRecords) {
	// String imageType = cml.getImageType();
	// String tranDate = cml.getTranDate();
	// String journalNo = cml.getJournalNo();
	// String termId = cml.getTermid();
	//
	// fsnPath = fsnPath.replace("\\", "/");
	// if (fsnPath.endsWith("/") == false) {
	// fsnPath = fsnPath + "/";
	// }
	//
	// String yyyyMMdd = tranDate.substring(0, 8);
	// int innerSequence = 0;
	// File fsnFile = null;
	// if ("2".equals(imageType)) {
	// // fsn文件名通过计算得出
	// // 文件名称从0开始，
	// int sequence = cml.getSequence();
	// if (sequence == 0)// 0为非正常
	// {
	// generateImageForMessage(cml, "sequence is 0.", 320, 32);
	// return;
	// }
	// sequence = sequence - 1;
	// innerSequence = (sequence % cmlSentRecords); // sequence从0开始
	// int fileOrder = sequence / cmlSentRecords;
	// String fileName = yyyyMMdd + "_" + termId + "_" + journalNo + "_"
	// + "CNY" + "_" + fileOrder + ".FSN"; //
	// 20130528_00000001_0528162101_CNY_0.FSN
	// fsnFile = new File(fsnPath + yyyyMMdd + "/" + fileName);
	// } else if ("46".equals(imageType)) {
	// // fsn文件名直接取
	// innerSequence = cml.getSequence();
	// // fsnFile = new File(fsnPath + yyyyMMdd + "/" + cml.getFileName());
	// fsnFile = new File(fsnPath + "/" + cml.getFileName());
	// } else {
	// generateImageForMessage(cml, "wrong image type [" + imageType
	// + "].", 320, 32);
	// return;
	// }
	//
	// InputStream fsnIn = null;
	// try {
	// if (fsnFile.exists() == false) {
	// logger.info("FSN文件不存在[" + fsnFile.getAbsolutePath() + "]");
	// generateImageForMessage(cml, "FSN file not exists.", 320, 32);
	// return;
	// }
	// fsnIn = new FileInputStream(fsnFile);
	// ByteArrayOutputStream imageOut = new ByteArrayOutputStream();
	// new ResultBMP(fsnIn, imageOut, innerSequence);
	//
	// byte[] imageBytes = imageOut.toByteArray();
	// ByteArrayInputStream imageIn = new ByteArrayInputStream(imageBytes,
	// 0, imageBytes.length);
	// ByteArrayOutputStream jpgOut = new ByteArrayOutputStream();
	//
	// ImageIO.write(ImageIO.read(imageIn), "jpg", jpgOut);
	// cml.setImageArr(jpgOut.toByteArray());
	// // cml.setWidth(160);
	// // cml.setHeight(20);
	// return;
	// } catch (Exception e) {
	// generateImageForMessage(cml, "No image in FSN[" + innerSequence
	// + "].", 320, 32);
	// return;
	// } finally {
	// if (fsnIn != null) {
	// StreamUtil.close(fsnIn);
	// }
	// }
	// }

	/**
	 * 发送消息到SeNTServer获取ATM的图片
	 */
	private void fetchAtmImageFile(CmlSentInfo cmlSentInfo, String imagePath)
			throws IOException {
		String imgType = cmlSentInfo.getImageType();

		// 3表示atm还没有查看过图片，需要后台提取
		// 其它厂商的机器，暂时定为类型3，做法与atm类似
		if ("3".equals(imgType) == false) {
			generateImageForMessage(cmlSentInfo, "Wrong image type[" + imgType
					+ "].", 320, 32);
			return;
		}

		String messageNo = String.valueOf(new Date().getTime()).substring(1,
				subLength);
		R2002Msg rmsg = getReturnPack(cmlSentInfo, messageNo);
		if (rmsg == null) {
			generateImageForMessage(cmlSentInfo, "Return message is null.",
					320, 32);
			return;
		}

		if (StringUtil.trim(rmsg.getRetcode()).equals("0") == false) // 0表示成功
		{
			generateImageForMessage(cmlSentInfo, "Return code is ["
					+ rmsg.getRetcode() + "].", 320, 32);
			return;
		}

		if (rmsg.getMessageno().equals(messageNo) == false) {
			generateImageForMessage(cmlSentInfo, "Message No is ["
					+ rmsg.getMessageno() + "].", 320, 32);
			return;
		}

		String returnPicPath = rmsg.getFilepath();
		if (StringUtil.isBlank(returnPicPath)) {
			generateImageForMessage(cmlSentInfo, "Wrong Picturn Path ["
					+ returnPicPath + "].", 320, 32);
			return;
		}

		cmlSentInfo.setFullUrl(concatImageFullUrl(imagePath, returnPicPath));
		// cmlSentInfo.setFileName(returnPicPath);
		cmlSentInfo.setImageType("4");

		return;
	}

	public String concatImageFullUrl(String imagePath, String fileName) {
		fileName = fileName.replace("\\", "/");
		if (fileName.startsWith("/")) {
			fileName = fileName.substring(1);
		}

		imagePath = imagePath.replace("\\", "/");
		if (imagePath.endsWith("/") == false) {
			imagePath += "/";
		}
		return imagePath + fileName;
	}

	/**
	 * 
	 */
	public void generateImageForMessage(CmlSentInfo cmlSentInfo,
			String message, int width, int height) {
		try {
			if (StringUtil.isBlank(message)) {
				message = "No Image.";
			}
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			BufferedImage img = new BufferedImage(width, height,
					BufferedImage.TYPE_3BYTE_BGR);
			Graphics g = img.getGraphics();
			Font font = new Font("TimesRoman", Font.PLAIN, 16);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString(message, 5, 16);
			g.dispose();
			ImageIO.write(img, "jpg", out);

			cmlSentInfo.setImageArr(out.toByteArray());
			cmlSentInfo.setWidth(width);
			cmlSentInfo.setHeight(height);
		} catch (IOException e) {
			throw new SysException(e);
		}
	}

	public R2002Msg getReturnPack(CmlSentInfo seq, String messageNo)
			throws IOException {
		S2002Msg smsg = new S2002Msg();

		smsg.setCheckcode("00");
		// smsg.setDevid(seq.getTermid());
		smsg.setMessageno(messageNo);

		// String picName = seq.getFileName();
		String tranDate = seq.getTranDate().substring(0, 8);

		// smsg.setPicturename(tranDate + "/" + picName);

		byte[] returnpack = null;
		byte[] sendpack = smsg.packMessage();

		transfer.init();
		returnpack = transfer.sendPack(sendpack);

		if (returnpack == null) {
			return null;
		} else {
			R2002Msg rmsg = new R2002Msg();
			rmsg.unpackMessage(returnpack);
			return rmsg;
		}
	}

	// public void fetchFsnCmlSentInfoImageForPage( Page<CmlSentInfo> page )
	// {
	// fetchFsnCmlSentInfoImageForList(page.getResult());
	// }

	// public void fetchFsnCmlSentInfoImageForList( List<CmlSentInfo> list )
	// {
	// String fsnPath =
	// paramDao.getValueByPathWithException(AppConstants.FSN_PICPATH);
	// int iCmlSentRecords =
	// paramDao.getIntegerValueByPathWithException(AppConstants.CMLSENT_RECORDS);
	// if( iCmlSentRecords<=0 )
	// {
	// throw new ParamException(AppConstants.CMLSENT_RECORDS);
	// }
	//		
	// for( CmlSentInfo cmlSentInfo : list )
	// {
	// fetchFsnCmlSentInfoImage(cmlSentInfo, fsnPath, iCmlSentRecords);
	// }
	// }

	// public void fetchFsnCmlSentInfoImage(CmlSentInfo cmlSentInfo, String
	// fsnPath, int iCmlSentRecords)
	// {
	// if( cmlSentInfo.getImageType().equals("3") )// 其他厂商的机器，暂时定为类型3，参考ATM
	// {
	// return ;
	// }
	//		
	// String tranDate = cmlSentInfo.getTranDate();
	// String yyyyMMdd = tranDate.substring(0, 8);
	// int fsnItemSeq = 0;
	// String fileName = null;
	// File fsnFile = null;
	// if( "2".equals(cmlSentInfo.getImageType()) )
	// {
	// // 根据算法计算fsn的文件名
	// int fsnSeq = cmlSentInfo.getSequence() - 1; // 数据库的从1开始，fsn的从0开始
	// int fileIndex = fsnSeq / iCmlSentRecords;
	// fsnItemSeq = fsnSeq % iCmlSentRecords;
	// fileName = yyyyMMdd + "_" + cmlSentInfo.getTermid() + "_" +
	// cmlSentInfo.getJournalNo() + "_" + "CNY" + "_" + fileIndex + ".FSN";
	//			
	// fsnFile = new File(fsnPath + yyyyMMdd + "/" + fileName);
	// }
	// else if( "46".equals(cmlSentInfo.getImageType()) )
	// {
	// // 直接获取fsn文件名
	// fsnItemSeq = cmlSentInfo.getSequence(); // 数据库的从0开始，fsn的从0开始
	// fileName = cmlSentInfo.getFileName();
	// fsnFile = new File(fsnPath + yyyyMMdd + "/" + fileName);
	// }
	// else
	// {
	// // 错误的情况
	// logger.error("Wrong image type ["+cmlSentInfo.getImageType()+"], cml id:["+cmlSentInfo.getId()+"]");
	// generateImageByMessage(cmlSentInfo,
	// "Wrong image type ["+cmlSentInfo.getImageType()+"]", 200, 20);
	// return ;
	// }
	//		
	//		
	// // 20130822_00000001_0822091830_CNY_0.FSN
	// if( fsnFile.exists()==false )
	// {
	// logger.error("FSN file doesn't exists: ["+fsnFile.getAbsolutePath()+"]");
	// generateImageByMessage(cmlSentInfo, "FSN file doesn't exists.", 200, 20);
	// return ;
	// }
	//		
	// InputStream fsnIn = null;
	// try
	// {
	// fsnIn = new FileInputStream(fsnFile);
	//			
	// ByteArrayOutputStream imageOut = new ByteArrayOutputStream();
	// new ResultBMP(fsnIn, imageOut, fsnItemSeq);
	//			
	// byte[] imageBytes = imageOut.toByteArray();
	// ByteArrayInputStream imageIn = new ByteArrayInputStream(imageBytes, 0,
	// imageBytes.length);
	// ByteArrayOutputStream jpgOut = new ByteArrayOutputStream();
	//
	// ImageIO.write(ImageIO.read(imageIn), "jpg", jpgOut);
	// cmlSentInfo.setImageArr(jpgOut.toByteArray());
	// }
	// catch (Exception e)
	// {
	// logger.error("Fetch image at FSN["+fsnItemSeq+"] failed: ["+fsnFile.getAbsolutePath()+"]");
	// generateImageByMessage(cmlSentInfo,
	// "Fetch image at FSN["+fsnItemSeq+"] failed.", 200, 20);
	// logger.error("读取fsn图片文件失败", e);
	// }
	// finally
	// {
	// StreamUtil.close(fsnIn);
	// }
	//	
	// }

	/**
	 * // * 查看图片（直接查看，其他厂商类型 imageType=3） // *
	 */
	// @Transactional(readOnly = true)
	// public findPicName
	/**
	 *查看导入fsn文件的图牄1�7
	 * */
	// @Transactional(readOnly = true)
	// public List<CmlSentInfo> impCmlsentInfoPic(String ids, String montharr) {
	// final String fsnPath = paramDao
	// .getValueByPath(AppConstants.FSN_PICPATH);
	// List<CmlSentInfo> list = new ArrayList<CmlSentInfo>();
	// String[] arrStr = ids.split(",");
	//
	// String[] arrMonth = montharr.split(",");
	//
	// for (int i = 0; i < arrStr.length; i++) {
	// CmlSentInfo cml = new CmlSentInfo();
	// Lock lock = new ReentrantLock();
	// lock.lock();
	// ByteArrayOutputStream out = new ByteArrayOutputStream();
	// try {
	// String id = arrStr[i];
	//
	// String month = arrMonth[i];
	// if (id == "") {
	// continue;
	// }
	//
	// if (month == "") {
	// continue;
	// }
	//
	// String hql = " from CmlSentInfo cml where  cml.tranMonthday='"
	// + month + "' and cml.termType='" + 0 + "' and cml.id='"
	// + id + "'";
	// List<CmlSentInfo> seqList = cmlSentInfoDao.find(hql);
	// if (seqList.size() > 0) {
	// cml = seqList.get(0);
	//
	// }
	// String tranDate = cml.getTranDate();
	// String fileDir = tranDate.substring(0, 8);
	// try {
	// File f = new File(fsnPath + fileDir + File.separator
	// + cml.getFileName());
	//
	// if (!f.exists()) {
	//
	// BufferedImage img = new BufferedImage(360, 60,
	// BufferedImage.TYPE_INT_ARGB);
	// Graphics g = img.getGraphics();
	// Font f1 = new Font("TimesRoman", Font.BOLD, 40);
	// g.setFont(f1);
	// g.setColor(Color.WHITE);
	// g.drawString("NO File to Number", 20, 50);
	// g.dispose();
	// ImageIO.write(img, "jpg", out);
	// cml.setImageArr(out.toByteArray());
	// list.add(cml);
	// continue;
	// }
	// // ResultBMP map = new ResultBMP(new
	// //
	// FileInputStream("d:\\20130628_00000002_CNY.FSN"),out,cml.getSerialSnseq());
	// new ResultBMP(new FileInputStream(fsnPath + fileDir
	// + File.separator + cml.getFileName()), out, cml
	// .getSequence());
	//
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// byte[] temp = out.toByteArray();
	// ByteArrayInputStream in = new ByteArrayInputStream(temp, 0,
	// temp.length);
	// try {
	// ByteArrayOutputStream temp2 = new ByteArrayOutputStream();
	// // temp2= new ByteOutputStream();
	// // FileOutputStream out2= new
	// // FileOutputStream("d:\\"+i+".jpg");
	//
	// if (null != in) {
	// ImageIO.write(ImageIO.read(in), "jpg", temp2);
	// }
	// // ImageIO.write(ImageIO.read(in), "jpg", out2);
	// cml.setImageArr(temp2.toByteArray());
	// temp2.close();
	// temp2.flush();
	// // out2.flush();
	// // out2.close();
	//
	// } catch (IOException e) {
	//
	// }
	//
	// list.add(cml);
	// } finally {
	//
	// try {
	// out.flush();
	// out.close();
	// } catch (IOException e) {
	//
	// }
	//
	// lock.unlock();
	// }
	// }
	//
	// return list;
	// }

	public CmlImprecords getCmlImprecorsByTaskId(String tranId) {
		List<CmlImprecords> cmlImprecordsList = new ArrayList<CmlImprecords>();
		CmlImprecords cmlImprecords = new CmlImprecords();
		try {

			String hql = "from CmlImprecords  c where c.taskId='" + tranId
					+ "'";
			cmlImprecordsList = cmlSentInfoDao.find(hql);

			if (cmlImprecordsList.size() > 0) {
				cmlImprecords = cmlImprecordsList.get(0);
				String userId = cmlImprecords.getOperaterId();
				String userName = findUserNameByUserId(userId);
				cmlImprecords.setOperaterId(userName);
			}
		} catch (NullPointerException e) {
			cmlImprecords = null;
			logger.error("", e);

		}
		return cmlImprecords;
	}

	public String findUserNameByUserId(String userId) {

		List<User> userList = new ArrayList<User>();
		User user = new User();
		String userNameString = null;
		try {
			String hqlString = "from User u where u.userCode='" + userId + "'";

			userList = userDao.find(hqlString);
			if (userList.size() > 0) {
				user = userList.get(0);
				userNameString = user.getUserName();
			}
		} catch (NullPointerException e) {
			userNameString = null;
		}
		return userNameString;
	}

	public String exportSentInfo(CmlSentInfo cml, String beginDateString,
			String endDateString, String fuzzyCount) throws SecurityException,
			NoSuchFieldException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, IOException {
		List values = new ArrayList();
		StringBuffer hql = new StringBuffer(
				"from CmlSentInfo  trans where 1=1 ");
		int days = Integer.parseInt(paramDao
				.getValueByPath(AppConstants.CML_TRANSDAY));
		int falg = Integer.parseInt(paramDao
				.getValueByPath(AppConstants.Can_QXZX));

		if (cml.getPathcode() != null && !cml.getPathcode().equals("")) {

			hql.append(" and  ( trans.pathcode like  ? ");
			values.add(orgInfoDao.getPathCodeById(cml.getPathcode()) + "%");
			if (falg == 0) {
				String qfzxPathcode = paramDao
						.getValueByPath(AppConstants.QFZX_PATHCODE);
				if (null != qfzxPathcode) {
					hql.append("  or   trans.pathcode  = ?  ");
					values.add(qfzxPathcode);
				}

			}
			if (beginDateString != null && !beginDateString.equals("")) {
				beginDateString = DateUtil.dateFormatTohms(beginDateString);
			} else {
				beginDateString = DateUtil.getTimeYYYYMMDDHHMMSSString(DateUtil
						.dateIncreaseByDay(new Date(), -days));
			}

			if (endDateString != null && !endDateString.equals("")) {
				endDateString = DateUtil.dateFormatTohms(endDateString);
			} else {
				endDateString = DateUtil
						.getTimeYYYYMMDDHHMMSSString(new Date());
			}

			if (beginDateString != null && !beginDateString.equals("")) {
				hql.append(" and trans.tranDate >='" + beginDateString + "'");
			}
			if (endDateString != null && !endDateString.equals("")) {
				hql.append(" and trans.tranDate <='" + endDateString + "'");
			}
			if (cml.getSeriaNo() != null && !cml.getSeriaNo().equals("")
					&& fuzzyCount != null) {
				// delete by hail 2011-2-13
				// sql += " where trans.seriaNo like '%" + trans.getSeriaNo() +
				// "%'";
				// add by hail 2011-2-13
				char seriaNo[];
				String seriaNoStr = cml.getSeriaNo();
				final int maxseriaNoStrlength = 10;
				if (cml.getSeriaNo().length() < maxseriaNoStrlength) {
					int lengthSub = 0;
					lengthSub = maxseriaNoStrlength - seriaNoStr.length();

					for (int i = 0; i < lengthSub; i++) {
						seriaNoStr += "0";
					}
				}
				seriaNo = seriaNoStr.toCharArray();
				final int num9 = 9;
				final int num8 = 8;
				final int num7 = 7;
				final int num6 = 6;
				final int num5 = 5;
				final int num4 = 4;
				final int num3 = 3;
				hql.append(" and ((case when  substr(trans.seriaNo,10,1)='"
						+ seriaNo[num9] + "' then 1 else 0 end)+"
						+ "(case when  substr(trans.seriaNo,9,1)='"
						+ seriaNo[num8] + "' then 1 else 0 end)+"
						+ "(case when  substr(trans.seriaNo,8,1)='"
						+ seriaNo[num7] + "' then 1 else 0 end)+"
						+ "(case when  substr(trans.seriaNo,7,1)='"
						+ seriaNo[num6] + "' then 1 else 0 end)+"
						+ "(case when  substr(trans.seriaNo,6,1)='"
						+ seriaNo[num5] + "' then 1 else 0 end)+"
						+ "(case when  substr(trans.seriaNo,5,1)='"
						+ seriaNo[num4] + "' then 1 else 0 end)+"
						+ "(case when  substr(trans.seriaNo,4,1)='"
						+ seriaNo[num3] + "' then 1 else 0 end)+"
						+ "(case when  substr(trans.seriaNo,3,1)='"
						+ seriaNo[2] + "' then 1 else 0 end)+"
						+ "(case when  substr(trans.seriaNo,2,1)='"
						+ seriaNo[1] + "' then 1 else 0 end)+"
						+ "(case when  substr(trans.seriaNo,1,1)='"
						+ seriaNo[0] + "' then 1 else 0 end) )>=" + fuzzyCount);

			}

			if (null != cml.getNoteType()
					&& !"".equals(cml.getNoteType().trim())) {
				hql.append(" and trans.noteType =  ? ");
				values.add(cml.getNoteType());

			}

			if (cml.getSeriaNo() != null && !cml.getSeriaNo().equals("")
					&& fuzzyCount == null) {
				// ?????
				hql.append(" and trans.seriaNo = ? ");
				values.add(cml.getSeriaNo());

			}
			// ??????????1?7??????1?7
			if (cml.getTermId() != null && !"".equals(cml.getTermId())) {

				hql.append(" and trans.termid = ? ");
				values.add(cml.getTermId());

			}

			hql.append(" ) ");

			logger.info(orgInfoDao.getPathCodeById(cml.getPathcode()));

		}
		/*
		 * if (cml.getPathcode() != null && !cml.getPathcode().equals("")) {
		 * 
		 * hql.append(" and trans.pathcode like  ? ");
		 * logger.info(cml.getPathcode()); values.add(cml.getPathcode().trim() +
		 * "%'");
		 * 
		 * }
		 */
		hql.append(" order by trans.tranDate desc");

		List<CmlSentInfo> list = new ArrayList<CmlSentInfo>();
		list = cmlSentInfoDao.find(hql.toString(), values.toArray());

		String fileName = "";
		HttpServletRequest req = FlexContext.getHttpRequest();
		final String filepath = "/report/reportCmlSent.xls";
		HSSFWorkbook templatewb = null;
		String realPath = req.getSession().getServletContext().getRealPath("")
				+ filepath;
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					realPath));
			templatewb = new HSSFWorkbook(fs, true);
		} catch (IOException ex) {
			logger.error("", ex);
		}
		fileName = "exportCmlSentForTask" + ".xls";
		String filePath = req.getSession().getServletContext().getRealPath("")
				+ File.separator + "exportFile" + File.separator + fileName;
		HSSFSheet sheet = templatewb.getSheetAt(0);
		String[] fields = { "seriaNo", "currency", "denomination", "tranDate" };

		for (int rowid = 0; rowid < list.size(); rowid++) {

			CmlSentInfo cml1 = list.get(rowid);
			Class<? extends CmlSentInfo> bean = cml1.getClass();
			Row row = sheet.createRow(rowid + 1);

			for (int column = 1; column < fields.length + 1; column++) {

				String value = "";
				String field = fields[column - 1];
				Field field2 = bean.getDeclaredField(field);
				String name = field2.getName();
				String prefix = name.substring(0, 1);
				name = "get" + prefix.toUpperCase() + name.substring(1);
				Method method = bean.getDeclaredMethod(name);
				Object obj1 = method.invoke(cml1);
				if (obj1 instanceof Date) {
					value = obj1.toString().substring(0,
							obj1.toString().lastIndexOf("."));

					/*
					 * } else if (obj1 instanceof Integer) {
					 * java.text.DecimalFormat df = new
					 * java.text.DecimalFormat("###,##0.00"); value =
					 * df.format(obj1);
					 */
				} else if (null == obj1) {
					value = "\\";
				} else {
					value = obj1.toString();
				}
				Cell label1 = row.createCell(column);
				label1.setCellValue(value);
			}
			Cell laCel2 = row.createCell(0);
			laCel2.setCellValue(String.valueOf(rowid + 1));
		}

		OutputStream out = new FileOutputStream(new File(filePath));
		templatewb.write(out);
		out.flush();
		out.close();
		return fileName;

	}

	/**
	 * @param data
	 *            数据
	 * @param vo
	 *            CmlTaskInfos
	 * @param devMode
	 *            设备型号
	 * @return List<CmlImpRecords>
	 * 
	 */

	public boolean impCSV(byte[] datas, String oldName, String devModel,
			String pathcode) {
		boolean flag = false;

		boolean f = false;
		CmlImprecords cmlImpRecords = new CmlImprecords();
		try {
			String date = DateUtil.getDateString(new Date());

			cmlImpRecords.setOperaterDate(date);

			// String filePath =
			// cmlImpRecordsDao.CreatefilePath(vo.getTmlNum());
			// String newName
			// =cmlImpRecordsDao.GenertoryFileName(vo.getTmlNum(),
			// vo.getTaskNum(), oldName, 0);
			// String url = cmlImpRecordsDao.upload(datas,filePath,oldName);
			// cmlImpRecords.setNewName(newName);
			cmlImpRecords.setFileName(oldName);
			// cmlImpRecords.setFileDir(url);

			// url =
			// FlexContext.getServletContext().getRealPath(File.separator+url);

			if (null == devModel) {
				cmlImpRecords.setOperateStatus("5");

				return saveCmlImpRecords(cmlImpRecords);
			}
			if (devModel.trim().equals("CM2000")) {
				flag = addALlCmlSentInfosByCM2000(datas, cmlImpRecords
						.getFileName(), pathcode);
			} else if (devModel.trim().equals("UW500")) {
				flag = addALlCmlSentInfosByUW500(datas, pathcode);
			} else if (devModel.trim().equals("CM400")) {
				flag = addALlCmlSentInfosByCM400(datas, pathcode);
			} else {
				flag = false;

			}

			if (flag) {
				cmlImpRecords.setOperateStatus("0");

			} else {
				// 上传失败
				cmlImpRecords.setOperateStatus("5");
			}
			f = saveCmlImpRecords(cmlImpRecords);
		} catch (NullPointerException e) {
			f = false;
			logger.error("", e);
		}
		return f;
	}

	/**
	 * 保存文件记录
	 * */
	public boolean saveCmlImpRecords(CmlImprecords cmlImpRecords) {
		boolean flag = false;
		try {
			cmlImpRecordsDao.saveNew(cmlImpRecords);
			flag = true;
		} catch (Exception e) {
			flag = false;
			logger.info("", e);
		}
		return flag;
	}

	/**
	 * 此文件是否存在
	 * */
	public boolean isExist(String oldName) {
		boolean flag = false;
		String hql = " from CmlImprecords imp where imp.fileName='" + oldName
				+ "'";
		List<CmlImprecords> listImp = new ArrayList<CmlImprecords>();
		listImp = cmlImprecordsDao.find(hql);
		if (listImp.size() > 0) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

	// private static final Integer[] checkModCM2000= {8,1,0,4,1,1,10,11,1};
	// 
	// private static final Integer[] checkModUW500= {3,1,4,10,0,3};
	//
	// private static final Integer[] checkModCM400 =
	// {8,0,2,1,1,10,0,0,9,0,1,0,0,0,0,0,0,0,14,0,1,4};

	public void addObjectByImport(CmlSentInfo cmlSentInfos) throws SQLException {
		cmlSentInfoDao.save(cmlSentInfos);
	}

	/**
	 * CM2000
	 */
	@Transactional
	public boolean addALlCmlSentInfosByCM2000(byte[] datas, String fileName,
			String pathcode) {
		boolean falg = false;
		ByteArrayInputStream in = null;

		try {
			// String sourceOrg= cmlTaskInfos.getOrgId();
			// String taskId =cmlTaskInfos.getTaskNum();
			// String tmlNum = cmlTaskInfos.getTmlNum();
			//					
			// String Tid = cmlTaskInfos.getId();
			Date dd = new Date();
			String s = DateUtil.getyyyyMMddDate(dd).substring(0, 4);
			String transDate = s + fileName.substring(1, 5);
			in = new ByteArrayInputStream(datas);
			List l = parseCsvForInputStream(in);
			for (int i = 1; i < l.size(); i++) {
				String[] temp = (String[]) l.get(i);
				CmlSentInfo cmlSentInfos = new CmlSentInfo();
				cmlSentInfos.setPathcode(orgInfoDao.getPathCodeById(pathcode));
				// cmlSentInfos.setImpFlag("0");
				// cmlSentInfos.setTermId(tmlNum);
				// cmlSentInfos.setOrgId(pathcode);
				// cmlSentInfos.setMoneyType(temp[8]);
				// cmlSentInfos.setImpFlag("0");
				cmlSentInfos.setNoteType(temp[4]);
				cmlSentInfos.setDenomination(temp[3]);
				// cmlSentInfos.setTranId(Tid);
				cmlSentInfos.setSeriaNo(temp[6]);
				cmlSentInfos.setTranDate(transDate);
				cmlSentInfos.setTranMonthday(transDate.substring(4, 8));
				// cmlSentInfos.setTransTime(temp[0].replace(":", ""));
				// cmlSentInfos.setMoneyType(temp[1]);
				// cmlSentInfos.setCreateDate(DateUtil.getyyyyMMddDate(new
				// Date()));
				falg = saveCMl(cmlSentInfos);

			}

		} catch (Exception e) {
			falg = false;
		}
		return falg;
	}

	public static List parseCsvForInputStream(InputStream in) {

		List count = new ArrayList();
		String[] str = {};
		com.csvreader.CsvReader reader = null;
		try {
			reader = new com.csvreader.CsvReader(in, ',', Charset
					.forName("GBK"));

			while (reader.readRecord()) {
				str = reader.getValues();
				if (str != null && str.length > 0) {
					if (str[0] != null && !"".equals(str[0].trim())) {
						count.add(str);
					}
				}
			}

			return count;

		} catch (Exception e) {
			e.printStackTrace();

			return null;

		} finally {
			reader.close();
		}
	}

	/**
	 * UW500解析方式
	 */
	public synchronized boolean addALlCmlSentInfosByUW500(byte[] datas,
			String pathcode) {
		ByteArrayInputStream in = null;
		boolean falg = false;
		try {
			in = new ByteArrayInputStream(datas);
			List l = parseCsvForInputStream(in);
			String[] tempTime = (String[]) l.get(0);
			String[] result = tempTime[0].split(" ");
			String setTranTime = result[1].replace(":", "") + "00";
			String setTranDate = result[0].replace("-", "");
			String result1 = "";
			if (setTranDate.length() == 7) {
				result1 = setTranDate.substring(0, 4) + "0"
						+ setTranDate.substring(4, 7);
			} else {
				result1 = setTranDate;
			}
			for (int i = 2; i < l.size(); i++) {
				String[] temp = (String[]) l.get(i);

				CmlSentInfo cmlSentInfos = new CmlSentInfo();
				// cmlSentInfos.setMoneyType("0");
				cmlSentInfos.setPathcode(orgInfoDao.getPathCodeById(pathcode));
				// cmlSentInfos.setTermId(tmlNum);
				// cmlSentInfos.setImpFlag("0");
				// cmlSentInfos.setOrgId(pathcode);

				// cmlSentInfos.setImpFlag("0");
				cmlSentInfos.setSeriaNo(temp[3]);
				cmlSentInfos.setDenomination(temp[2].substring(0, temp[2]
						.length() - 1));
				// mlSentInfos.setTranId(Tid);

				// cmlSentInfos.setTransYear(result1.substring(0,4));
				cmlSentInfos.setTranMonthday(result1.substring(4, 8));
				cmlSentInfos.setTranDate(setTranTime);
				// cmlSentInfos.setUrlName(temp[5]);
				// cmlSentInfos.setCreateDate(DateUtil.getyyyyMMddDate(new
				// Date()));
				falg = saveCMl(cmlSentInfos);
			}
		} catch (Exception e) {
			falg = false;
		}
		return falg;

	}

	@Transactional
	public synchronized boolean addALlCmlSentInfosByCM400(byte[] datas,
			String pathCode) {
		boolean falg = false;
		ByteArrayInputStream in = null;
		try {
			in = new ByteArrayInputStream(datas);
			List l = parseCsvForInputStream(in);
			for (int i = 1; i < l.size(); i++) {
				String[] temp = (String[]) l.get(i);
				CmlSentInfo cmlSentInfos = new CmlSentInfo();
				cmlSentInfos.setPathcode(orgInfoDao.getPathCodeById(pathCode));

				cmlSentInfos.setTranDate(temp[0].toString());
				cmlSentInfos.setDenomination("0" + temp[2]);
				cmlSentInfos.setSeriaNo(temp[5]);
				cmlSentInfos.setTermId(temp[8]);
				cmlSentInfos.setJournalNo(temp[9]);
				cmlSentInfos.setNoteFlag(temp[11]);
				cmlSentInfos.setNoteType(temp[12]);
				cmlSentInfos.setCurrency(temp[13]);
				// cmlSentInfos.setFileName(temp[15]);
				if (!"".equals(temp[18])) {
					cmlSentInfos.setTranMonthday(temp[18].substring(4, 8));

					falg = saveCMl(cmlSentInfos);

				}
			}

		} catch (Exception e) {
			falg = false;
		}
		return falg;

	}

	/**
	 * 判断是否存在冠子号码
	 * 
	 * @param tranid
	 *            tranid
	 * @return boolean
	 **/
	// public boolean getObjByTaskNum(String tranid) {
	// String sql = " select count(*)  from CmlSentInfos where tranId = '" +
	// tranid + "'";
	// return Integer.parseInt(cmlSentInfoDao.findUnique(sql).toString()) > 0 ?
	// true
	// : false;
	//
	// }
	public void save(CmlSentInfo cmlSentInfos) {
		cmlSentInfoDao.save(cmlSentInfos);

	}

	public boolean saveCMl(CmlSentInfo cmlSentInfos) {
		boolean flag = false;
		try {
			cmlSentInfoDao.saveNew(cmlSentInfos);
			flag = true;
		} catch (NullPointerException e) {
			flag = false;
			logger.error("", e);
		}
		return flag;
	}

	/**
	 * @param checkL
	 *            模板字段朄1�7大长庄1�7
	 * @param entity
	 *            用来比较的解析数捄1�7
	 * @return boolean
	 * 
	 * */
	public boolean checkMod(Integer[] checkL, String[] entity) {
		boolean result = false;
		if (checkL.length == entity.length) {
			for (int i = 0; i < checkL.length; i++) {
				if (checkL[i] == entity[i].trim().length()) {
					result = true;
				} else {
					result = false;
					break;

				}
			}
		}
		return result;
	}

	/**
	 * 加载冠字号码信息衄1�7
	 */
	public Page loadCmlImp(Page page) {
		String str = ".csv";
		String hql = " from CmlImprecords imp where 1=1 and imp.fileName like '%"
				+ str + "' order by imp.operaterDate desc";
		Page page2 = cmlSentInfoDao.findPage(page, hql);
		return page2;
	}

	/**
	 * 根据业务流转码获取冠字号列表
	 * 
	 * @param parameter
	 * @return
	 */
	public Page getCmlSentInfosPageByFlowNum(Map parameter) {

		System.out.println("CmlSentInfoService.getCmlSentInfosPageByFlowNum()");

		Map<String, Object> condition = (Map<String, Object>) parameter
				.get("condition");

		int queryMaxDays = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_TRANSDAY);
		int queryMaxRows = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_QUERY_MAX_ROWS);
		condition.put("queryMaxDays", queryMaxDays);
		condition.put("queryMaxRows", queryMaxRows);

		// 将流转码查询条件转换为交易ID查询
		String barcodeFlowNum = StringUtil.trim((String) condition
				.get("barcodeFlowNum"));
		if (barcodeFlowNum != null && barcodeFlowNum != "") {
			String tranIds = "";
			String[] barcodeFlowNums = barcodeFlowNum.split(",");
			for (int i = 0; i < barcodeFlowNums.length; i++) {
				CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao
						.getByBarcodeFlowNum(barcodeFlowNums[i]);

				// 判断该流转条码是否存在
				if (cmlNoteflowInfo != null) {
					tranIds = tranIds + cmlNoteflowInfo.getId() + ",";
				}
			}
			if (tranIds != null && tranIds != "") {
				condition.put("tranId", tranIds);
			}
		}

		// 将二次查询的流转码查询条件转换为交易ID查询
		String barcodeFlowNumForSecondQuery = StringUtil
				.trim((String) condition.get("barcodeFlowNumForSecondQuery"));
		if (barcodeFlowNumForSecondQuery != null
				&& barcodeFlowNumForSecondQuery != "") {
			String tranIds = "";
			String[] barcodeFlowNums = barcodeFlowNumForSecondQuery.split(",");
			for (int i = 0; i < barcodeFlowNums.length; i++) {
				CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao
						.getByBarcodeFlowNum(barcodeFlowNums[i]);

				// 判断该流转条码是否存在
				if (cmlNoteflowInfo != null) {
					tranIds = tranIds + cmlNoteflowInfo.getId() + ",";
				} else {
					Page<CmlSentInfo> page = (Page) parameter.get("page");
					page.setTotalCount(0);
					return page;
				}
			}
			if (tranIds != null && tranIds != "") {
				condition.put("tranIdForSecondQuery", tranIds);
			}
		}

		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		Page<CmlSentInfo> cmlSentInfosPage = cmlSentInfoJDBCDao
				.getCmlSentInfoPageFromTodayAndMMDDTable(parameter);

		fetchSerialNoImagesForPageP(cmlSentInfosPage);

		return cmlSentInfosPage;
	}

	/**
	 * 根据业务流转码获取冠字号列表（不分页）
	 * 
	 * @param parameter
	 * @return
	 */
	public Page getCmlSentInfosNoPageByFlowNum(Map parameter) {

		// 把pageSize设置的大一些，就可以重用分页的方法
		return null;
	}

	/**
	 * 根据流转号码查找对应的流转信息
	 * */
	public Page findNoteflowInfosByBarCodeFlowNun(Page page,
			String barcodeFlowNum) {
		String hql = " from CmlNoteflowDetailInfo cml where cml.barcodeFlowNum='"
				+ barcodeFlowNum + "'";
		Page page2 = new Page();
		page2 = cmlNoteflowDetailInfoDao.findPage(page, hql);
		return page2;
	}

	/**
	 * 根据终端型号取终端类型
	 * */
	public String findTermTypeName(String termId) {
		String hql = "select y.typeName from TermInfo t,TermType y where t.termCode='"
				+ termId + "' and t.termType=y.id ";
		String typeName = null;
		List list = new ArrayList();
		list = terminalInfoDao.find(hql);
		if (list.size() > 0) {
			typeName = list.get(0).toString();
		}
		return typeName;
	}

	/**
	 *???id?????????? ??????????
	 * 
	 * @param id
	 *            ????????1?7
	 *@return int
	 * */
	public int findCmlSentSeq(String id) {
		CmlSentInfo seq = getCmlSentObject(id);

		if (seq == null) {
			return 1;
		} else {
			return 2;
		}
	}

	/**
	 * ?????
	 * 
	 * @param seqInfoList
	 *            ???????????锟��������
	 * @return List
	 * */
	@Transactional(readOnly = true)
	public List<CmlSentInfo> trimCmlSentTaskInfo(List<CmlSentInfo> seqInfoList) {
		for (int i = 0; i < seqInfoList.size(); i++) {

			if (seqInfoList.get(i).getNoteType() != null) {
				seqInfoList.get(i).setNoteType(
						seqInfoList.get(i).getNoteType().trim());
			}
			if (seqInfoList.get(i).getNoteFlag() != null) {
				seqInfoList.get(i).setNoteFlag(
						seqInfoList.get(i).getNoteFlag().trim());
			}
			if (seqInfoList.get(i).getCurrency() != null) {
				seqInfoList.get(i).setCurrency(
						seqInfoList.get(i).getCurrency().trim());
			}

		}
		return seqInfoList;
	}

	/***
	 * 清分机自动上传bmp图片，其他厂商机器。
	 */
	public List getCmlPicByAuto(String ids, String montharr) {
		List<CmlSentInfo> seqInfoList = new ArrayList<CmlSentInfo>();
		String[] arrStr = ids.split(",");

		String[] arrmonth = montharr.split(",");
		try {
			for (int i = 0; i < arrStr.length; i++) {
				CmlSentInfo seqInfo = new CmlSentInfo();
				String id = arrStr[i];

				String month = arrmonth[i];
				if (id == "") {
					continue;
				}

				if (month == "") {
					continue;
				}
				String hql = " from CmlSentInfo cml where cml.tranMonthday='"
						+ month + "' and cml.id='" + id + "'";
				List<CmlSentInfo> seqList = cmlSentInfoDao.find(hql);
				if (seqList.size() > 0) {
					seqInfo = seqList.get(0);
				}

				seqInfoList.add(seqInfo);
			}

			trimCmlSentTaskInfo(seqInfoList);
		} catch (NullPointerException e) {
			seqInfoList = null;
			logger.error("", e);

		}

		return seqInfoList;
	}

	// public CmlSentInfo getCmlSentInfoDetailById(String id)
	// {
	// CmlSentInfo cmlSentInfo = cmlSentInfoDao.get(id);
	//		
	// cmlSentInfo.setBusinessTypeDesc(getCmlSentFlowBusinessTypeById(id));
	//		
	// fetchSerialNoImagesForOne(cmlSentInfo);
	//		
	// return cmlSentInfo;
	// }

	/**
	 * 获取ATM交易信息是否可以打印开关
	 */
	public String getAtmTranPrintSwitch(String param){
		String printSwitch = paramDao.getValueByPath(AppConstants.PRINT_SWITCH);
		if(printSwitch == null)
			return "off";
		return printSwitch;
	}
	
	/**
	 * 根据tranId分页获取冠字号信息
	 */
	public Page<CmlSentInfo> getCmlSentInfoPageByTranId(
			Map<String, Object> parameter) {
		// Page page = (Page)parameter.get("page");
		// String tranId = (String)parameter.get("tranId");
		//		
		// page = cmlSentInfoDao.getPageByTranId(page, tranId);

		Map<String, Object> condition = (Map<String, Object>) parameter
				.get("condition");

		// 获取冠字号的查询条件
		int queryMaxDays = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_TRANSDAY);
		int queryMaxRows = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_QUERY_MAX_ROWS);
		condition.put("queryMaxDays", queryMaxDays);
		condition.put("queryMaxRows", queryMaxRows);

		// 将流转码查询条件转换为交易ID查询
		String barcodeFlowNum = StringUtil.trim((String) condition
				.get("barcodeFlowNum"));
		if (barcodeFlowNum != null && barcodeFlowNum != "") {
			String tranIds = "";
			String[] barcodeFlowNums = barcodeFlowNum.split(",");
			for (int i = 0; i < barcodeFlowNums.length; i++) {
				CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao
						.getByBarcodeFlowNum(barcodeFlowNums[i]);

				// 判断该流转条码是否存在
				if (cmlNoteflowInfo != null) {
					tranIds = tranIds + cmlNoteflowInfo.getId() + ",";
				}
			}
			if (tranIds != null && tranIds != "") {
				condition.put("tranId", tranIds);
			}
		}

		// 将二次查询的流转码查询条件转换为交易ID查询
		String barcodeFlowNumForSecondQuery = StringUtil
				.trim((String) condition.get("barcodeFlowNumForSecondQuery"));
		if (barcodeFlowNumForSecondQuery != null
				&& barcodeFlowNumForSecondQuery != "") {
			String tranIds = "";
			String[] barcodeFlowNums = barcodeFlowNumForSecondQuery.split(",");
			for (int i = 0; i < barcodeFlowNums.length; i++) {
				CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao
						.getByBarcodeFlowNum(barcodeFlowNums[i]);

				// 判断该流转条码是否存在
				if (cmlNoteflowInfo != null) {
					tranIds = tranIds + cmlNoteflowInfo.getId() + ",";
				} else {
					Page<CmlSentInfo> page = (Page) parameter.get("page");
					page.setTotalCount(0);
					return page;
				}
			}
			if (tranIds != null && tranIds != "") {
				condition.put("tranIdForSecondQuery", tranIds);
			}
		}

		// 柜面大额取款取所有关联的交易ID
		String tdReserve = StringUtil.trim((String) condition.get("tdReserve"));
		if (tdReserve != null && tdReserve != "") {
			String tranIds = "";
			String[] barcodeFlowNums = tdReserve.split(";");
			for (int i = 0; i < barcodeFlowNums.length; i++) {
				CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao
						.getByBarcodeFlowNum(barcodeFlowNums[i]);

				// 判断该流转条码是否存在
				if (cmlNoteflowInfo != null) {
					tranIds = tranIds + cmlNoteflowInfo.getId() + ",";
				}
			}
			if (tranIds != null && tranIds != "") {
				condition.put("tranId", tranIds);
			}
		}
		// 获取冠字号的列表
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		Page<CmlSentInfo> cmlSentInfosPage = cmlSentInfoJDBCDao
				.getCmlSentInfoPageFromTodayAndMMDDTable(parameter);

		fetchSerialNoImagesForPageP(cmlSentInfosPage);

		return cmlSentInfosPage;
	}
	
	/**
	 * 根据tranId获取全部冠字号信息
	 */
	public List<CmlSentInfo> getAllCmlSentInfoByTranId(
			Map<String, Object> condition) {

		int queryMaxRows = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_QUERY_MAX_ROWS);
		condition.put("queryMaxRows", queryMaxRows);

		// 获取冠字号的列表
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		List<CmlSentInfo> cmlSentInfosPage = cmlSentInfoJDBCDao
				.getAllCmlSentInfoFromTodayAndMMDDTable(condition);

		fetchSerialNoImagesForListP(cmlSentInfosPage);

		return cmlSentInfosPage;
	}

	/**
	 * 根据tranId获取全部冠字号信息(去重，无查询最大值限制)
	 */
	public List<CmlSentInfo> getCmlSentInfosByTranIDAndTableName(String tranID,String tableName) {

		// int queryMaxRows = paramDao
		// .getIntegerValueByPathWithException(AppConstants.CML_QUERY_MAX_ROWS);
		// condition.put("queryMaxRows", queryMaxRows);

		// 获取冠字号的列表
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		List<CmlSentInfo> cmlSentInfosPage = cmlSentInfoJDBCDao
				.getCmlSentInfosByTranIDAndTableName(tranID, tableName);
		// fetchSerialNoImagesForListP(cmlSentInfosPage);

		return cmlSentInfosPage;
	}

	/**
	 * 根据tranId获取全部冠字号信息(去重，无查询最大值限制)
	 */
	public List<CmlSentInfo> getCmlSentInfosByTranIDAndTableName1(String tranID,String tableName) {

		// int queryMaxRows = paramDao
		// .getIntegerValueByPathWithException(AppConstants.CML_QUERY_MAX_ROWS);
		// condition.put("queryMaxRows", queryMaxRows);

		// 获取冠字号的列表
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		List<CmlSentInfo> cmlSentInfosPage = cmlSentInfoJDBCDao
				.getCmlSentInfosByTranIDAndTableName(tranID, tableName);
		// fetchSerialNoImagesForListP(cmlSentInfosPage);

		return cmlSentInfosPage;
	}
	
	
	
	public String expCmlSentInfoFSN(Map condition) {
		// 根据条件获取要导出的记录
		List<CmlSentInfo> cml = getCmlSentInfoByParameter(condition);
		String fileName = null;

		// 如果有记录设置文件内容
		if (cml.size() > 0) {
			// 写文件
			FileOutputStream fileOutputStream = null;
			try {
				fileName = "CNYGZHM.FSN";
				HttpServletRequest req = FlexContext.getHttpRequest();
				String filePath = req.getSession().getServletContext()
						.getRealPath("")
						+ "/exportFile/" + fileName;
				fileOutputStream = new FileOutputStream(new File(filePath));

				// 文件头部
				ImpFsnTitle impTitle = new ImpFsnTitle(fileOutputStream);
				impTitle.writeIntArr16(impTitle.HEAD_START);
				impTitle.writeIntArr16(impTitle.HEAD_STRING);
				impTitle.writeInt32(cml.size());// 文件记录总数
				impTitle.writeIntArr16(impTitle.HEAD_END);

				// 文件内容
				ImpFsnContent fsn = new ImpFsnContent(fileOutputStream);
				fsn.expFsn(cml); // 将记录写入FSN

			} catch (IOException e) {
				logger.error("", e);
			} finally {
				StreamUtil.close(fileOutputStream);
			}
		} else {
			// 没有数据就给出提示，不能导出
			fileName = "noData";
		}
		return fileName;
	}

	@Transactional(readOnly = true)
	private List<CmlSentInfo> getCmlSentInfoByParameter(
			Map<String, Object> condition) {
		logger.info("CmlSentInfoService.getCmlSentInfoPage()");

		// 判断时间合法性
		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");

		Date dStartTime = ServiceValidateHelper.validateQueryStartTime(
				startTime, "yyyy-MM-dd");
		Date dEndTime = ServiceValidateHelper.validateQueryEndTime(endTime,
				"yyyy-MM-dd");

		int days = Integer.parseInt(paramDao
				.getValueByPath(AppConstants.CML_TRANSDAY));
		ServiceValidateHelper
				.validateQueryTimeRange(dStartTime, dEndTime, days);

		// 设置查询最大天数和最大条数
		int queryMaxDays = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_TRANSDAY);
		int queryMaxRows = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_SEQ_EXPORT_MAX_ROWS);
		condition.put("queryMaxDays", queryMaxDays);
		condition.put("queryMaxRows", queryMaxRows);

		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		List<CmlSentInfo> list = cmlSentInfoJDBCDao
				.getCmlSentInfoList(condition);

		return list;
	}

	public String expCmlSentInfoCSV(Map<String, Object> condition) {
		List<CmlSentInfo> cmlSentInfos = getCmlSentInfoByParameter(condition);

		String fileName = null;
		if (cmlSentInfos.size() == 0) {
			fileName = "noData";
		} else {
			Map exportMap = getExportCmlSentInfoDataCSV(cmlSentInfos);

			List exportList = (List) exportMap.get("content");
			LinkedHashMap title = (LinkedHashMap) exportMap.get("title");
			fileName = "expGZHMListCSV.csv";
			CSVFileUtil csvFile = new CSVFileUtil();
			try {
				fileName = csvFile.createCSVFile(exportList, title, fileName);
			} catch (IOException e) {
				logger.error("", e);
			}
		}
		return fileName;
	}

	private Map getExportCmlSentInfoDataCSV(List<CmlSentInfo> list) {
		Map<String, Object> map = new HashMap();

		if (list == null || list.size() == 0) {
			map.put("isNull", new ArrayList());
		}

		List expList = new ArrayList();

		// 获取数据字典的数据
		// 清分纸币类型
		List<SysDatadir> moneyTypeList = sysDatadirService
				.getDatadirChildrenByPath(AppConstants.MONEY_TYPE_PATH, "zh_CN");
		Map<String, String> moneyTypeMap = new HashMap<String, String>();
		for (SysDatadir obj : moneyTypeList) {
			moneyTypeMap.put(obj.getKey(), obj.getValue());
		}

		// 纸币币种
		List<SysDatadir> currencyList = sysDatadirService
				.getDatadirChildrenByPath(AppConstants.CURRENCY_PATH, "zh_CN");
		Map<String, String> currencyMap = new HashMap<String, String>();
		for (SysDatadir obj : currencyList) {
			currencyMap.put(obj.getKey(), obj.getValue());
		}

		// 纸币版别
		List<SysDatadir> versionNumList = sysDatadirService
				.getDatadirChildrenByPath(AppConstants.VERSION_NUM_PATH,
						"zh_CN");
		Map<String, String> versionNumMap = new HashMap<String, String>();
		for (SysDatadir obj : versionNumList) {
			versionNumMap.put(obj.getKey(), obj.getValue());
		}

		// 设备类型
		List<SysDatadir> termTypeList = sysDatadirService
				.getDatadirChildrenByPath(AppConstants.TERMTYPE_PATH, "zh_CN");
		Map<String, String> termTypeMap = new HashMap<String, String>();
		for (SysDatadir obj : termTypeList) {
			termTypeMap.put(obj.getKey(), obj.getValue());
		}

		// 业务类型
		List<SysDatadir> tranTypeList = sysDatadirService
				.getDatadirChildrenByPath(AppConstants.TRANTYPE_PATH, "zh_CN");
		Map<String, String> tranTypeMap = new HashMap<String, String>();
		for (SysDatadir obj : tranTypeList) {
			tranTypeMap.put(obj.getKey(), obj.getValue());
		}
		// 设备类别
		List<SysDatadir> devTypeList = sysDatadirService
		.getDatadirChildrenByPath(AppConstants.DEVICETYPE_PATH, "zh_CN");
       Map<String, String> devTypeMap = new HashMap<String, String>();
       for (SysDatadir obj : devTypeList) {
    	   devTypeMap.put(obj.getKey(), obj.getValue());
       }
		// 钞票类别
       List<SysDatadir> cashTypeList = sysDatadirService
		.getDatadirChildrenByPath(AppConstants.CASHTYPE_PATH, "zh_CN");
      Map<String, String> cashTypeMap = new HashMap<String, String>();
      for (SysDatadir obj : cashTypeList) {
    	  cashTypeMap.put(obj.getKey(), obj.getValue());
      }
       
		// 机构信息 Map<orgid,OrgInfo>
		List<OrgInfo> orgInfoList = orgInfoDao.getAll();
		Map<String, OrgInfo> orgInfoMap = new HashMap<String, OrgInfo>();
		for (OrgInfo org : orgInfoList) {
			orgInfoMap.put(org.getPathCode(), org);
		}

		int rowIndex = 1;
		for (CmlSentInfo info : list) {
			Map newInfo = new LinkedHashMap();
			newInfo.put("no", rowIndex++);
			newInfo.put("seriaNo", info.getSeriaNo() != null ? "\t"
					+ info.getSeriaNo() : "");

			// 对于与数据字典相关的map，除了判断从数据库取出的字段值是否为空外，还要判断从数据字典能否取到对应的值
			if (info.getNoteType() != null) {
				String noteType = moneyTypeMap.get(info.getNoteType());
				newInfo.put("noteType", "\t"
						+ (noteType == null ? info.getNoteType() : noteType));
			} else {
				newInfo.put("noteType", "");
			}

			// 判断钞票币种
			if (info.getCurrency() != null) {
				String currency = currencyMap.get(info.getCurrency());
				newInfo.put("currency", "\t"
						+ (currency == null ? info.getCurrency() : currency));
			} else {
				newInfo.put("currency", "");
			}

			newInfo.put("denomination", info.getDenomination() == null ? ""
					: "\t" + info.getDenomination());
			newInfo.put("termid", info.getTermId() == null ? "" : "\t"
					+ info.getTermId());
			newInfo.put("machineNo", info.getMachinesno() == null ? "" : "\t"
					+ info.getMachinesno());

			// 判断机构号、机构名称、金融机构代码
			if (info.getPathcode() != null) {
				OrgInfo orgInfo = orgInfoMap.get(info.getPathcode());
				String orgCode = "";
				// String orgName = "";
				if (orgInfo != null) {
					orgCode = orgInfoMap.get(info.getPathcode()).getOrgCode();
					// orgName =
					// orgInfoMap.get(info.getPathcode()).getOrgName();
				}
				newInfo.put("orgCode", orgCode == null ? "" : "\t" + orgCode);
			} else {
				newInfo.put("orgCode", "");
				newInfo.put("finOrgCode", "");
			}
			// 判断版别
			if (info.getVersionNum() != null) {
				String versionNum = versionNumMap.get(info.getVersionNum());
				newInfo.put("versionNum", "\t"
						+ (versionNum == null ? info.getVersionNum()
								: versionNum));
			} else {
				newInfo.put("versionNum", "");
			}
			// 判断设备类型
			if (info.getTermType() != null) {
				String termType = termTypeMap.get(info.getTermType());
				newInfo.put("termType", "\t"
						+ (termType == null ? info.getTermType() : termType));
			} else {
				newInfo.put("termType", "");
			}

			newInfo.put("tranDate", info.getTranDate() == null ? "" : "\t"
					+ DateUtil.getTimeString(info.getTranDate()));
			String devType = info.getType() == null ? "" : info.getType() ;
			newInfo.put("type", devType) ;
			String cashType = info.getMoneyType() == null ? "" : cashTypeMap.get(info.getMoneyType()) ;
			newInfo.put("moneyType", cashType == null ? "" : cashType) ;
			expList.add(newInfo);
		}

		LinkedHashMap title = new LinkedHashMap();
		title.put("no", "序号");
		title.put("seriaNo", "冠字号码");
		title.put("noteType", "钞票类别");
		title.put("currency", "币种");
		title.put("denomination", "面额");
		title.put("termid", "设备编号");
		title.put("machineNo", "机具编号");
		title.put("orgCode", "机构号");
		title.put("versionNum", "版别");
		// title.put("termType", "设备类型");
		// 导出的标题由"设备类型"修改为"业务类型"
		title.put("termType", "业务类型");
		title.put("tranDate", "交易时间");
		title.put("type", "机型") ;
		title.put("moneyType", "钞票类别") ;
		
		map.put("title", title);
		map.put("content", expList);
		return map;
	}

	/**
	 * 获取冠字号所属的业务类型： 步骤： 获取C_TERM_TYPE if(清分机 ){ 获取流转信息 if(ATM加钞、在行ATM加钞){
	 * 设备的类型名称 }else if(支付柜员){ 柜面交易 }else{ "" } }else if(ATM){ 设备的类型名称 }else
	 * if(加钞/清机交易){ C_TYPE字段进行判断 }else if(柜面交易){ 柜面交易 }else if(导入){ "" }
	 */
	public String getCmlSentFlowBusinessTypeById(String sentId, String tableName) {
		String msgCounter = "柜面交易";
		String msgOther = "暂无";

		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		CmlSentInfo cmlSentInfo = cmlSentInfoJDBCDao
				.getCmlSentInfosByIdFromTable(sentId, tableName);

		if (cmlSentInfo == null) {
			return msgOther;
		}
		// 清分机, 获取流转信息
		if (CmlSentInfoConsts.TERM_TYPE_CML_TASK_INFO.equals(cmlSentInfo
				.getTermType())) {
			String barcodeFlowNum = cmlSentInfo.getBarcodeFlowNum();
			if (StringUtil.isBlank(barcodeFlowNum)) {
				return msgOther;
			}
			CmlNoteflowDetailInfo cmlNoteflowDetailInfo = cmlNoteflowDetailInfoDao
					.getOneCmlNoteflowDetailInfoByBFNAndFSS(
							barcodeFlowNum,
							new String[] {
									CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_ADD_CASH, // ATM加钞
									CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_ATM_ADD_CASH, // 在行ATM加钞
									CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_LARGE_WITHDRAWAL, // 网点大额取款
									CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_PAY_TO_COUNTER, // 交付给柜面
							});
			if (cmlNoteflowDetailInfo == null) {
				return msgOther;
			}
			// ATM加钞、在行ATM加钞
			if (CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_ADD_CASH
					.equals(cmlNoteflowDetailInfo.getFlowStage())
					|| // ATM加钞
					CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_ATM_ADD_CASH
							.equals(cmlNoteflowDetailInfo.getFlowStage())) // 在行ATM加钞
			{
				// barcode1是钞箱号
				// barcode2是atm号
				return termInfoDao
						.getTermTypeNameByTermCode(cmlNoteflowDetailInfo
								.getBarcode2());
			}
			// 网点大额取款、交付给柜面
			if (CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_LARGE_WITHDRAWAL
					.equals(cmlNoteflowDetailInfo.getFlowStage())
					|| // 网点大额取款
					CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_PAY_TO_COUNTER
							.equals(cmlNoteflowDetailInfo.getFlowStage())) // 交付给柜面
			{
				return msgCounter;
			}
			return msgOther;
		}
		// atm
		else if (CmlSentInfoConsts.TERM_TYPE_ATM_TRAN_INFO.equals(cmlSentInfo
				.getTermType())) {
			return termInfoDao.getTermTypeNameByTermCode(cmlSentInfo
					.getTermId());
		}
		// 加钞/清机交易
		else if (CmlSentInfoConsts.TERM_TYPE_CML_LOAD_NOTES_RECORD
				.equals(cmlSentInfo.getTermType())) {
			CmlLoadNotesRecord cmlLoadNotesRecord = cmlLoadNotesRecordDao
					.get(cmlSentInfo.getTranId());
			switch (cmlLoadNotesRecord.type) {
			case 1:
				return "取款机";
			case 2:
				return "存取款一体机";
			case 3:
				return "柜面交易";
			}
			return msgOther;
		}
		// 柜面交易
		else if (CmlSentInfoConsts.TERM_TYPE_CML_COUNTER_RECORD
				.equals(cmlSentInfo.getTermType())) {
			return msgCounter; // 柜面交易
		}
		// 其它
		return msgOther;
	}

	// ////////////////

	/**
	 * 设置冠字号相关属性（所属机构、是否涉假登记）
	 */
	private void fetchInfoForCmlSentInfoList(List<CmlSentInfo> list) {
		Map<String, OrgInfo> orgInfoCache = new HashMap<String, OrgInfo>();

		for (CmlSentInfo cml : list) {
			// 所属机构
			String pathCode = cml.getPathcode();
			OrgInfo orgInfo = null;
			if (StringUtil.isNotBlank(pathCode)) {
				if (orgInfoCache.containsKey(pathCode)) {
					orgInfo = orgInfoCache.get(pathCode);
				} else {
					orgInfo = orgInfoDao.getByPathCode(pathCode);
					orgInfoCache.put(pathCode, orgInfo);
				}
			}
			if (orgInfo != null) {
				cml.setOrgName(orgInfo.getOrgName());
				cml.setOrgFullName(orgInfo.getOrgFullName());
			}

			// 是否涉假登记
			SmsSerialDoubtRecord record = smsSerialDoubtRecordDao
					.queryByseriaNO(cml.getSeriaNo());
			if (record == null) {
				cml.setRegisterInDoubtRecord(false);
			} else {
				cml.setRegisterInDoubtRecord(true);
			}
		}
	}

	/**
	 * 根据冠字号码和表名获得冠字号列表
	 * 
	 * @param parameter
	 * @return
	 */
	public List<CmlSentInfo> getCmlSentInfoByNOAndTableName(Map parameter) {

		String serialNO = (String) parameter.get("serialNo");
		String tranDate = (String) parameter.get("tranDate");
		String tableName = "cml_sent_infos_his_";
		tableName += tranDate.substring(5, 7) + tranDate.substring(8, 10);
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		List<CmlSentInfo> infosLst = cmlSentInfoJDBCDao
				.getCmlSentInfosByNOAndTableName(serialNO, tableName);

		return infosLst;
	}

	/**
	 * 根据冠字号码和表名获得冠字号查询结果(CmlSentInfoStatisVO)
	 * 
	 * @param parameter
	 * @return
	 */
	public CmlSentInfoStatisVO getCmlSentInfoStatisVOByNOAndTableName(
			Map parameter) {

		String serialNO = (String) parameter.get("serialNo");
		String tranDate = (String) parameter.get("tranDate");
		String tableName = "cml_sent_infos_his_";
		tableName += tranDate.substring(5, 7) + tranDate.substring(8, 10);
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		List<CmlSentInfo> infosLst = cmlSentInfoJDBCDao
				.getCmlSentInfosByNOAndTableName(serialNO, tableName);

		CmlSentInfoStatisVO vo = new CmlSentInfoStatisVO();
		int noteType = 111;// 查询无果
		if (infosLst.size() > 0) {
			for (CmlSentInfo info : infosLst) {// 有0则取0
				if (info.getNoteType().equals("0")) {
					noteType = 0;
					break;
				}
			}
			if (noteType != 0) {// 无0有1则取1
				for (CmlSentInfo info : infosLst) {
					if (info.getNoteType().equals("1")) {
						noteType = 1;
						break;
					}
				}
			}
			if (noteType == 111) {// 无0无1则取其他
				noteType = Integer.parseInt(infosLst.get(0).getNoteType());
			}
			vo.setNoteType(noteType);
			vo.setQueryResult(1);
		} else {
			vo.setNoteType(noteType);
			vo.setQueryResult(0);
		}
		vo.setQueryCount(infosLst.size());
		
		// 是否涉假登记
		SmsSerialDoubtRecord record = smsSerialDoubtRecordDao
				.queryByseriaNO(serialNO);
		if (record == null) {
			vo.setRegisterOrNot(false);
		} else {
			vo.setRegisterOrNot(true);
		}
		
		return vo;
	}

	// exportCmlSentInfoExcelByCondition
	public String exportCmlSentInfoExcelByCondition(Map<String, Object> params)
			throws Exception {

		Map<String, Object> condition = (Map) params.get("condition");

		// 设置查询最大天数和最大条数
		int queryMaxDays = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_TRANSDAY);
		int queryMaxRows = paramDao
				.getIntegerValueByPathWithException(AppConstants.CML_SEQ_EXPORT_MAX_ROWS);
		
		String queryAll = StringUtil.trim((String) condition
				.get("queryAll"));
		if("true".equals(queryAll)){
			//是否查询全部--将queryMaxRows设到很大的值
			queryMaxRows = queryMaxRows * 100;
		}
		
		condition.put("queryMaxDays", queryMaxDays);
		condition.put("queryMaxRows", queryMaxRows);
		
		//导出时，需要查询符合条件全部记录，不分页
		//（为了重用分页的方法，pageSize设置成可以导出的最大数）
		Page page = (Page) params.get("page");
		page.setPageSize(queryMaxRows);
		
		// 将流转码查询条件转换为交易ID查询
		String barcodeFlowNum = StringUtil.trim((String) condition
				.get("barcodeFlowNum"));
		if (barcodeFlowNum != null && barcodeFlowNum != "") {
			String tranIds = "";
			String[] barcodeFlowNums = barcodeFlowNum.split(",");
			for (int i = 0; i < barcodeFlowNums.length; i++) {
				CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao
						.getByBarcodeFlowNum(barcodeFlowNums[i]);

				// 判断该流转条码是否存在
				if (cmlNoteflowInfo != null) {
					tranIds = tranIds + cmlNoteflowInfo.getId() + ",";
				}
			}
			if (tranIds != null && tranIds != "") {
				condition.put("tranId", tranIds);
			}
		}

		// 将二次查询的流转码查询条件转换为交易ID查询
		String barcodeFlowNumForSecondQuery = StringUtil
				.trim((String) condition.get("barcodeFlowNumForSecondQuery"));
		if (barcodeFlowNumForSecondQuery != null
				&& barcodeFlowNumForSecondQuery != "") {
			String tranIds = "";
			String[] barcodeFlowNums = barcodeFlowNumForSecondQuery.split(",");
			for (int i = 0; i < barcodeFlowNums.length; i++) {
				CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao
						.getByBarcodeFlowNum(barcodeFlowNums[i]);

				// 判断该流转条码是否存在
				if (cmlNoteflowInfo != null) {
					tranIds = tranIds + cmlNoteflowInfo.getId() + ",";
				} else {
					tranIds = "null";
				}
			}
			if (tranIds != null && tranIds != "") {
				condition.put("tranIdForSecondQuery", tranIds);
			}
		}

		// 柜面大额取款取所有关联的交易ID
		String tdReserve = StringUtil.trim((String) condition.get("tdReserve"));
		if (tdReserve != null && tdReserve != "") {
			String tranIds = "";
			String[] barcodeFlowNums = tdReserve.split(";");
			for (int i = 0; i < barcodeFlowNums.length; i++) {
				CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao
						.getByBarcodeFlowNum(barcodeFlowNums[i]);

				// 判断该流转条码是否存在
				if (cmlNoteflowInfo != null) {
					tranIds = tranIds + cmlNoteflowInfo.getId() + ",";
				}
			}
			if (tranIds != null && tranIds != "") {
				condition.put("tranId", tranIds);
			}
		}

		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		Page<CmlSentInfo> cmlSentInfosPage = cmlSentInfoJDBCDao
				.getCmlSentInfoPageFromTodayAndMMDDTable(params);
		List<CmlSentInfo> sentLst = cmlSentInfosPage.getResult();

		ArrayList<Object[]> dataList = new ArrayList<Object[]>();
		HttpServletRequest request = FlexContext.getHttpRequest();

		String fileName = UUID.randomUUID() + "GZHMTemplate.xls";
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ File.separator + "exportFile" + File.separator + fileName;// 导出文件路径
		String modelName = request.getSession().getServletContext()
				.getRealPath("")
				+ File.separator
				+ "exportFile"
				+ File.separator
				+ "GZHMTemplate.xls";// 文件模板路径

		Object[] row;
		// List<OrgInfo> orgInfos = orgInfoDao.getAll();
		// List<TermModel> termModels = termModelService.getAllTermModel();
		// List<TermBrand> termBrands = termBrandService.getAllTermBrand();
		// List<TermType> termTypes = termTypeService.getAllTermType();
		// List<Area> areas = areaService.getAllArea();
		List noteType_dirLst = sysDatadirService.getDatadirChildrenByPath("SysDatadirMgr.sent.transMgr.noteType","zh_CN");
		List currency_dirLst = sysDatadirService.getDatadirChildrenByPath("SysDatadirMgr.sent.cmlMgr.currency","zh_CN");
		List versionNum_dirLst = sysDatadirService.getDatadirChildrenByPath("SysDatadirMgr.sent.cmlMgr.versionNum","zh_CN");
		List termType_dirLst = sysDatadirService.getDatadirChildrenByPath("SysDatadirMgr.sent.cmlMgr.termType","zh_CN");
		for (int i = 0; i < sentLst.size(); i++) {
			row = new Object[11];
			CmlSentInfo record = (CmlSentInfo) sentLst.get(i);
			row[0] = i + 1;
			row[1] = record.getSeriaNo();
			//row[2] = record.getNoteType();//			
			for(Object dir:noteType_dirLst){
				SysDatadir dataDir = (SysDatadir)dir;
				if(dataDir.getKey().equals(record.getNoteType())){
					row[2] = dataDir.getValue();
					break;
				}
			}
			//row[3] = record.getCurrency();//			
			for(Object dir:currency_dirLst){
				SysDatadir dataDir = (SysDatadir)dir;
				if(dataDir.getKey().equals(record.getCurrency())){
					row[3] = dataDir.getValue();
					break;
				}
			}
			row[4] = record.getDenomination();
			row[5] = record.getTermId();
			row[6] = record.getMachinesno();
			row[7] = record.getPathcode();
			// 判断机构号、机构名称、金融机构代码
//			String orgCode = "";
//			if (record.getPathcode() != null) {
//				OrgInfo orgInfo = orgInfoDao.getByPathCode(record.getPathcode());
//				if (orgInfo != null) {
//					orgCode = orgInfo.getOrgCode();
//				}
//			}
//			row[7] = orgCode;	
			//row[8] = record.getVersionNum();//			
			for(Object dir:versionNum_dirLst){
				SysDatadir dataDir = (SysDatadir)dir;
				if(dataDir.getKey().equals(record.getVersionNum())){
					row[8] = dataDir.getValue();
					break;
				}
			}
			//row[9] = record.getTermType();//			
			for(Object dir:termType_dirLst){
				SysDatadir dataDir = (SysDatadir)dir;
				if(dataDir.getKey().equals(record.getTermType())){
					row[9] = dataDir.getValue();
					break;
				}
			}
			row[10] = DateUtil.getTimeString(record.getTranDate());

			dataList.add(row);
		}
		String fileUrl = POIUtils.makeExcelFile(dataList, modelName, filePath);
		return fileName;
	}
	
	/**
	 * 根据冠字号码和表名获得冠字号查询结果(CmlSentInfoStatisVO)
	 * 再登记模块中
	 * @param parameter
	 * @return
	 */
	public Map<String,Object> getCmlSentInfoStatisVOByNOAndTableNameAgain(
			Map parameter) {
		String serialNO = (String) parameter.get("serialNo");
		String test = (String) parameter.get("test"); //编辑时冠字号码有没有改变。“true”为改变
		CmlSentInfoStatisVO vo = new CmlSentInfoStatisVO();

		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		// 涉假登记记录信息
		List<SmsSerialDoubtRecord> record = smsSerialDoubtRecordDao
				.queryListByseriaNO(serialNO);
		
		//如无涉假登记信息或者涉假登记信息超过两个，则不能继续再登记。
		if (test==null&&(record==null||record.size()!=1)) {
			vo.setRegisterOrNot(false);
			if(record==null){
				vo.setQueryCount(0);
			}else{
				vo.setQueryCount(record.size());//记录登记表中已登记该条冠字号码信息数量。
			}
			dataMap.put("vo", vo);
			return dataMap;
		} else {
			vo.setRegisterOrNot(true);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		String tranDate = sdf.format(record.get(0).getDepositDate());
		
		String tableName = "cml_sent_infos_his_";
		tableName += tranDate;//.substring(5, 7) + tranDate.substring(8, 10);
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		List<CmlSentInfo> infosLst = cmlSentInfoJDBCDao
				.getCmlSentInfosByNOAndTableName(serialNO, tableName);

		int noteType = 111;// 查询无果
		if (infosLst.size() > 0) {
			for (CmlSentInfo info : infosLst) {// 有0则取0
				if (info.getNoteType().equals("0")) {
					noteType = 0;
					break;
				}
			}
			if (noteType != 0) {// 无0有1则取1
				for (CmlSentInfo info : infosLst) {
					if (info.getNoteType().equals("1")) {
						noteType = 1;
						break;
					}
				}
			}
			if (noteType == 111) {// 无0无1则取其他
				noteType = Integer.parseInt(infosLst.get(0).getNoteType());
			}
			vo.setNoteType(noteType);
			vo.setQueryResult(1);
		} else {
			vo.setNoteType(noteType);
			vo.setQueryResult(0);
		}
		vo.setQueryCount(infosLst.size());
		dataMap.put("vo", vo);
		dataMap.put("data", record.get(0));
		return dataMap;
	}
	
	/**
	 * 季度(90天)冠字号搜索，获取相同冠字号号码的总数量，和最靠近当前时间的冠字号信息
	 * 
	 * @Description:
	 * @param parameter
	 * @return CmlSentInfoStatisVO
	 * @author whxing
	 * @since 2014-9-16 上午10:35:37
	 */
	@Transactional(readOnly = true)
	public CmlSentInfoStatisVO  getCmlSentSearchInfoForVO(Map<String, Object> parameter) {
		logger.info("CmlSentInfoService.getCmlSentSearchInfoForVO()");
		CmlSentInfoStatisVO cmlSentInfoStatisVO = new CmlSentInfoStatisVO();
		//SysDatadir sysDatadir = new SysDatadir();
		//sysDatadir = sysDatadirService.getDatadirByPath("SysDatadirMgr.sent.ruleMgr.serialSearch.queryDays","zh_CN");
		String daysDiff = paramDao.getValueByPath(AppConstants.SERIAL_SEARCH_QUERY_DAYS);
		parameter.put("daysDiff", daysDiff);
		
		CmlSentInfoJDBCDao cmlSentInfoJDBCDao = getCmlSentInfoJDBCDao();
		cmlSentInfoStatisVO = cmlSentInfoJDBCDao.getCmlSentSearchInfoForVO(parameter);

		return cmlSentInfoStatisVO;
	}
	
	// 根据交易码transcode获取备注信息
	@Transactional(readOnly = true)
	public String getDataDictNodeByKey(String key) {
		if (!key.equals(null)) {
			String note = sysDatadirDao.getNoteEnByKey(key);
			return note;
		} else {
			return " ";
		}
	}

	@Transactional(readOnly = true)
	public String getStatus(String tradeId) throws Exception{
		String status =  cmlSentInfoDao.getStatus(tradeId);
		//0代表过度状态    需要等待，
		//空/null代表初始  不需要等待， 
		//1代表已上传处理  不需要等待  也无需发起获取FSN文件请求处理
		return status;
		
	}

}
