package com.grgbanking.sent.transmgr.service;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.DateUtils;
import com.grgbanking.platform.core.utils.FileUtil;
import com.grgbanking.platform.core.utils.SpringService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.entity.TermInfo;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.stride.utils.ZipUtil;
import com.grgbanking.sent.transmgr.dao.CmlImprecordsDao;
import com.grgbanking.sent.transmgr.entity.CmlImprecords;
import com.grgbanking.sent.transmgr.entity.CmlImprecordsDetail;
import com.grgbanking.sent.transmgr.entity.CmlSentInfo;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;
import com.grgbanking.sent.utils.crhUtil.GenCrh;

/**
 *
 */
@Service
@Transactional
public class CmlImprecordsService extends BaseService {
	
	private static final String UNDERLINE = "_";
	private static final String LINEENDING  =  "\r\n";//"0x0D0X0A";
	private static final String GH_LINECONTENTTEMPLATE = "%s,%s,%s,%s,%s,%s"+LINEENDING;

	@Autowired
	CmlImprecordsDao cmlImprecordsDao;

	@Autowired
	TermInfoDao termInfoDao;

	@Autowired
	ParamDao paramDao;
 
	@Autowired
	SpringService springService;

	@Autowired
	OrgInfoDao orgInfoDao;

	@Autowired
	CmlSentInfoService cmlSentInfoService;

	/**
	 * 根据patchCode查找对应的机构名称
	 * */
	public String findOrgNameByPathCode(String pathCode) {
		String hql = " select orgName from OrgInfo where pathCode='" + pathCode
				+ "'";
		String orgName = null;
		List<String> li = cmlImprecordsDao.find(hql);
		try {
			if (li.size() > 0) {
				orgName = li.get(0);
			}
		} catch (NullPointerException e) {
			orgName = null;
			logger.error("", e);
		}
		return orgName;
	}

	@Transactional(readOnly = true)
	public Page getCmlImprecoredsPage(Page page, CmlImprecords cmlImprecords,
			String beginDateString, String endDateString) {

		// 判断开始时间不能为空
		if (StringUtil.isBlank(beginDateString)) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL,
					"查询开始时间不能为空!");
		}
		// 结束时间不能为空
		if (StringUtil.isBlank(endDateString)) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL,
					"查询结束时间不能为空!");
		}
		// 定义开始与结束时间
		Date dStartTime = null;
		Date dEndTime = null;
		try {
			dStartTime = DateUtil.parseToDate(beginDateString,
					"yyyy-MM-dd HH:mm:ss");
			dEndTime = DateUtil.parseToDate(endDateString,
					"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG,
					"查询时间格式不正确[" + e.getMessage() + "]");
		}

		// 转化为两位的月份
		String mothStart_ = dStartTime.getMonth() < 9 ? "0"
				+ (dStartTime.getMonth() + 1) : (dStartTime.getMonth() + 1)
				+ "";
		String mothEnd_ = dEndTime.getMonth() < 9 ? "0"
				+ (dEndTime.getMonth() + 1) : (dEndTime.getMonth() + 1) + "";

		// 转化为两位的日期　统一格式
		String dayStart = dStartTime.getDate() <= 9 ? "0"
				+ dStartTime.getDate() : dStartTime.getDate() + "";
		String dayEnd = dEndTime.getDate() <= 9 ? "0" + dEndTime.getDate()
				: dEndTime.getDate() + "";

		StringBuffer sb = new StringBuffer("");
		// 拼接sql,分为跨年与不跨年
		if (dStartTime.getYear() == dEndTime.getYear()) {
			sb.append("   cml.partMonthday>='").append(mothStart_)
					.append(dayStart);
			sb.append("' and cml.partMonthday<='").append(mothEnd_)
					.append(dayEnd).append("'");
		} else if (dStartTime.getYear() < dEndTime.getYear()) {
			sb.append("   ( cml.partMonthday>='").append(mothStart_)
					.append(dayStart);
			sb.append("' or cml.partMonthday<='").append(mothEnd_)
					.append(dayEnd).append("')");
		} else {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG,
					"查询时间格式不正确：结束时间大于开始时间");
		}

		String hql = " select" + " cml.id," + " cml.fileName,"
				+ " cml.operateStatus," + " cml.operaterId," + " cml.termId,"
				+ " cml.seriaimgFlag," + " cml.seriaNum,"
				+ " cml.operaterDate," + " cml.pathcode,"
				+ " o.orgName,cml.oldFileName"
				+ " from CmlImprecords cml, OrgInfo o" + " where "
				+ sb.toString() + " and cml.operateStatus is not null"
				+ " and o.pathCode = cml.pathcode"
				+ " and cml.operaterId is not null";

		List<Object> parameterList = new ArrayList<Object>();

		int days = Integer.parseInt(paramDao
				.getValueByPath(AppConstants.CML_TRANSDAY));

		String termId = null;
		String operateStatus = null;
		String pathCode = null;

		// 准备数据
		if (cmlImprecords != null) {
			termId = StringUtil.trim(cmlImprecords.getTermId());
			operateStatus = StringUtil.trim(cmlImprecords.getOperateStatus());
			pathCode = StringUtil.trim(cmlImprecords.getPathcode());
		}

		// termId
		if (StringUtil.isNotBlank(termId)) {
			hql += " and cml.termId = ?";
			parameterList.add(termId);
		}
		if (StringUtil.isNotBlank(operateStatus)) {
			hql += " and  cml.operateStatus =? ";
			parameterList.add(operateStatus);
		}

		// operateStatus
		/*
		 * if( StringUtil.isInteger(operateStatus) ) { switch
		 * (Integer.parseInt(operateStatus)) { case 0: hql +=
		 * " and  cml.operateStatus = '0' "; break; case 2: hql +=
		 * " and cml.operateStatus = '2' "; break; case 4: String[] sockerError
		 * = { "3", "4" }; hql +=
		 * " and cml.operateStatus in ( "+StringUtil.generateMultiPartString
		 * ("?", sockerError.length, ", ")+" )";
		 * CollectionsUtil.addAll(parameterList, sockerError); break; case 5:
		 * String[] upError = { "5", "6", "7", "8", "9", "10", "11", "12", "13"
		 * }; hql +=
		 * " and cml.operateStatus in ( "+StringUtil.generateMultiPartString
		 * ("?", upError.length, ", ")+" )";
		 * CollectionsUtil.addAll(parameterList, upError); break; default:
		 * break; }
		 * 
		 * }
		 */

		// 开始时间
		if (StringUtil.isNotBlank(beginDateString)) {
			beginDateString = DateUtil.dateFormatTohms(beginDateString);
		} else {
			beginDateString = DateUtil.getTimeYYYYMMDDHHMMSSString(DateUtil
					.dateIncreaseByDay(new Date(), -days));
		}
		hql += " and cml.operaterDate>=?";
		parameterList.add(beginDateString);

		// 结束时间
		if (StringUtil.isNotBlank(endDateString)) {
			endDateString = DateUtil.dateFormatTohms(endDateString);
		} else {
			endDateString = DateUtil.getTimeYYYYMMDDHHMMSSString(new Date());
		}
		hql += " and cml.operaterDate<=?";
		parameterList.add(endDateString);

		// pathCode
		if (StringUtil.isNotBlank(pathCode)) {
			hql += " and cml.pathcode like ?";
			parameterList.add(orgInfoDao.getPathCodeById(cmlImprecords
					.getPathcode()) + "%");
		}

		hql += " order by cml.operaterDate desc";

		// 结果
		Page p = cmlImprecordsDao.findPage(page, hql, parameterList.toArray());
		List resultTmp = p.getResult();
		List<CmlImprecordsDetail> list = new ArrayList<CmlImprecordsDetail>();
		for (Object row : resultTmp) {
			CmlImprecordsDetail cml = new CmlImprecordsDetail();

			Object[] rowArr = (Object[]) row;
			if (rowArr[0] != null)
				cml.setId(String.valueOf(rowArr[0]));
			if (rowArr[1] != null)
				cml.setFileName(String.valueOf(rowArr[1]));
			if (rowArr[10] != null)
				cml.setOldFileName(String.valueOf(rowArr[10]));
			if (rowArr[2] != null)
				cml.setOperateStatus(String.valueOf(rowArr[2]));
			if (rowArr[3] != null)
				cml.setOperaterId(String.valueOf(rowArr[3]));
			if (rowArr[4] != null)
				cml.setTermId(String.valueOf(rowArr[4]));
			if (rowArr[5] != null)
				cml.setSeriaimgFlag(String.valueOf(rowArr[5]));
			try {
				if (rowArr[6] != null)
					cml.setSeriaNum(BigDecimal.valueOf(Double
							.parseDouble(rowArr[6].toString())));
			} catch (NumberFormatException e) {
				cml.setSeriaNum(BigDecimal.valueOf(0));
			}
			if (rowArr[7] != null)
				cml.setOperaterDate(String.valueOf(rowArr[7]));
			if (rowArr[8] != null)
				cml.setPathcode(String.valueOf(rowArr[8]));
			if (rowArr[9] != null)
				cml.setOrgName(String.valueOf(rowArr[9]));

			list.add(cml);
		}

		p.setResult(list);

		return p;
	}
	
	/**
	 * 下载上传记录对应的FSN文件
	 * 
	 * @param condition 条件
	 * @return 文件路径和文件名
	 */
	@Transactional(readOnly = true)
	public String downloadFSN(Map<String, Object> condition) {
		logger.debug("java:下载上传记录对应的FSN文件");
//		String fileName = (String) condition.get("fileName");
		String id = (String) condition.get("id");
		CmlImprecords  cmlImprecords = cmlImprecordsDao.get(id);
		String fileName = cmlImprecords.getFileName();
		logger.debug("FSN文件名字：" + fileName);
		String fsnPath = paramDao.getValueByPath("param.sent.fsnPath.fsnRootPath.fsnPath");
		logger.debug("FSN文件服务器路径：" + fsnPath);
		//CmlImprecords cmlImprecords = cmlImprecordsDao.findCmlRCmlImprecordsByFileName2(fileName);
		logger.debug("FSN文件交易日期：" + cmlImprecords.getTranDate() + "；终端编号：" + cmlImprecords.getTermId());
		File file = new File(fsnPath + File.separator + cmlImprecords.getTranDate() + 
				File.separator + cmlImprecords.getTermId() + File.separator + fileName);
		logger.debug("FSN文件路径：" + file.toString());
		if (file.exists()) {
			return file.toString();
		} else {
			file = new File(fsnPath + File.separator + "errfile" + File.separator + fileName);
			logger.debug("FSN格式有误，文件路径：" + file.toString());
			if (file.exists()) {
				return file.toString();
			} else {
				file = new File(fsnPath + File.separator + "errfile" + File.separator + cmlImprecords.getTranDate() + 
						File.separator + fileName);
				logger.debug("FSN格式有误，文件路径：" + file.toString());
				if (file.exists()) {
					return file.toString();
				} else {
					file = new File(fsnPath + File.separator + "errfile" + File.separator + cmlImprecords.getTranDate() + 
							File.separator + cmlImprecords.getTermId() + File.separator + fileName);
					logger.debug("FSN格式有误，文件路径：" + file.toString());
					if (file.exists()) {
						return file.toString();
					}  else {
						return "noData";
					}
				}
			}
		}
	}
	/**
	 * 
	 */
	@Transactional(readOnly = true)
	public Page getCmlImprecordsInfoPage(Map parameter) {
		Page page = (Page) parameter.get("page");
		Map<String, Object> condition = (Map) parameter.get("condition");

		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");
		String termNum = (String) condition.get("termNum");
		String uploadStatus = (String) condition.get("uploadStatus");
		String pathCode = (String) condition.get("pathCode");
		String oldNameForCondition = (String) condition.get("oldNameForCondition");
		String operaterId = (String)condition.get("personForUpload");
		String flag=(String)condition.get("flag");
		
		int day = Integer.parseInt(paramDao
				.getValueByPath(AppConstants.CML_TRANSDAY));

		if (StringUtil.isBlank(startTime)) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL,
					"查询开始时间不能为空!");
		}

		if (StringUtil.isBlank(endTime)) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL,
					"查询结束时间不能为空!");
		}

		Date dStartTime = null;
		Date dEndTime = null;
		try {
			dStartTime = DateUtil.parseToDate(startTime, "yyyy-MM-dd HH:mm:ss");
			dEndTime = DateUtil.parseToDate(endTime, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG,
					"查询时间格式不正确[" + e.getMessage() + "]");
		}

		if (Math.abs(dEndTime.getTime() - dStartTime.getTime()) >= DateUtil.MILLISECOND_PER_DAY
				* day) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_PLEASE_SELECT_QUERY_DATE_WITHIN,
					"请选择[%s]天以内的时间进行查询!", day);
		}

		// 转化为两位的月份
		String mothStart_ = dStartTime.getMonth() < 9 ? "0"
				+ (dStartTime.getMonth() + 1) : (dStartTime.getMonth() + 1)
				+ "";
		String mothEnd_ = dEndTime.getMonth() < 9 ? "0"
				+ (dEndTime.getMonth() + 1) : (dEndTime.getMonth() + 1) + "";

		// 转化为两位的日期　统一格式
		String dayStart = dStartTime.getDate() <= 9 ? "0"
				+ dStartTime.getDate() : dStartTime.getDate() + "";
		String dayEnd = dEndTime.getDate() <= 9 ? "0" + dEndTime.getDate()
				: dEndTime.getDate() + "";

		StringBuffer sb = new StringBuffer("");
		// 拼接sql,分为跨年与不跨年
		if (dStartTime.getYear() == dEndTime.getYear()) {
			sb.append("   cml.partMonthday>='").append(mothStart_)
					.append(dayStart);
			sb.append("' and cml.partMonthday<='").append(mothEnd_)
					.append(dayEnd).append("'");
		} else if (dStartTime.getYear() < dEndTime.getYear()) {
			sb.append("   ( cml.partMonthday>='").append(mothStart_)
					.append(dayStart);
			sb.append("' or cml.partMonthday<='").append(mothEnd_)
					.append(dayEnd).append("')");
		} else {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG,
					"查询时间格式不正确：结束时间大于开始时间");
		}

		String sql = " select " + " cml," + " o.orgName," + " o.orgCode"
				+ " from CmlImprecords cml," + "  OrgInfo o" + " where "
				+ sb.toString() + " and o.pathCode = cml.pathcode"
				+ " and cml.operaterId is not null"
				+ " and cml.operaterDate>='"
				+ DateUtil.parseToString(dStartTime, "yyyyMMddHHmmss") + "'"
				+ " and cml.operaterDate<='"
				+ DateUtil.parseToString(dEndTime, "yyyyMMddHHmmss") + "'";

		if (StringUtil.isNotBlank(termNum)) {
			sql += " and cml.termId ='" + termNum + "'";
		}

		if (StringUtil.isNotBlank(uploadStatus)) {
			sql += " and  cml.operateStatus = '" + uploadStatus + "' ";
		}
		
		if (StringUtil.isNotBlank(oldNameForCondition)) {
			sql += " and  cml.oldFileName like '%" + StringUtil.trim(oldNameForCondition) + "%' ";
		}

		if (StringUtil.isNotBlank(operaterId)) {
			sql += " and  cml.operaterId like '%" + StringUtil.trim(operaterId) + "%' ";
		}
		
		/*
		 * int[] upError = { 5, 6, 7, 8, 9, 10, 11, 12, 13 }; int[] sockerError
		 * = { 3, 4 };
		 * 
		 * if( StringUtil.isNotBlank(uploadStatus) ) { switch
		 * (Integer.parseInt(uploadStatus)) { case 0: sql +=
		 * " and  cml.operateStatus = '0' "; break; case 4: sql +=
		 * " and cml.operateStatus in ( "; for (int j = 0; j <
		 * sockerError.length; j++) { String temp = j == 0 ? "'" +
		 * sockerError[j] + "'" : ",'" + sockerError[j] + "'"; sql += temp; }
		 * sql += " )  "; break; case 5: sql += " and cml.operateStatus in ( ";
		 * for (int j = 0; j < upError.length; j++) { String temp = j == 0 ? "'"
		 * + upError[j] + "'" : ",'" + upError[j] + "'"; sql += temp; } sql +=
		 * " )  "; break; case 2: sql += " and cml.operateStatus = '2' ";
		 * 
		 * break; default: break; } }
		 */

		if (StringUtil.isNotBlank(pathCode)) {
			System.out.println(flag);
			if(null == flag || flag.equals("true")){
				sql += " and cml.pathcode like '" + pathCode + "%'";
			}else{
				sql += " and cml.pathcode = '" + pathCode + "'";
			}
		}

		sql += " order by cml.operaterDate  desc";

		page = cmlImprecordsDao.findPage(page, sql);
		List resultTmp = page.getResult();
		List li = new ArrayList<CmlImprecordsDetail>();

		for (Object row : resultTmp) {
			Object[] arrValues = (Object[]) row;

			CmlImprecords cmlImprecords = (CmlImprecords) arrValues[0];
			String orgName = (String) arrValues[1];
			String orgCode = (String) arrValues[2];

			CmlImprecordsDetail cml = new CmlImprecordsDetail();
			cml.setId(cmlImprecords.getId());
			cml.setTermId(cmlImprecords.getTermId());
			cml.setFileName(encryptAccountForFileName(cmlImprecords
					.getFileName()));
			cml.setOperateStatus(cmlImprecords.getOperateStatus());
			cml.setOperaterId(cmlImprecords.getOperaterId());
			cml.setSeriaimgFlag(cmlImprecords.getSeriaimgFlag());
			cml.setSeriaNum(cmlImprecords.getSeriaNum());
			cml.setOperaterDate(cmlImprecords.getOperaterDate());
			cml.setPathcode(cmlImprecords.getPathcode());
			cml.setResovimpRecords(cmlImprecords.getResovimpRecords());
			cml.setTranDate(cmlImprecords.getTranDate());
			cml.setOrgName(orgName);
			cml.setOldFileName(encryptAccountForFileName(cmlImprecords
					.getOldFileName()));
			cml.setOrgCode(orgCode);

			li.add(cml);
		}

		page.setResult(li);
		return page;
	}

	/**
	 * 上报人行：按条件上传
	 * @throws IOException 
	 */
	@Transactional(readOnly = true)
	public Map<String, String> upPersonByDayFunc(Map parameter) throws IOException {
		Page page = (Page) parameter.get("page");
		Map<String, Object> condition = (Map) parameter.get("condition");

		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");
		String termNum = (String) condition.get("termNum");
		String uploadStatus = (String) condition.get("uploadStatus");
		String pathCode = (String) condition.get("pathCode");

		int day = Integer.parseInt(paramDao
				.getValueByPath(AppConstants.CML_TRANSDAY));

		if (StringUtil.isBlank(startTime)) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL,
					"查询开始时间不能为空!");
		}

		if (StringUtil.isBlank(endTime)) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL,
					"查询结束时间不能为空!");
		}

		Date dStartTime = null;
		Date dEndTime = null;
		try {
			dStartTime = DateUtil.parseToDate(startTime, "yyyy-MM-dd HH:mm:ss");
			dEndTime = DateUtil.parseToDate(endTime, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG,
					"查询时间格式不正确[" + e.getMessage() + "]");
		}

		if (Math.abs(dEndTime.getTime() - dStartTime.getTime()) >= DateUtil.MILLISECOND_PER_DAY
				* day) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_PLEASE_SELECT_QUERY_DATE_WITHIN,
					"请选择[%s]天以内的时间进行查询!", day);
		}

		// 转化为两位的月份
		String mothStart_ = dStartTime.getMonth() < 9 ? "0"
				+ (dStartTime.getMonth() + 1) : (dStartTime.getMonth() + 1)
				+ "";
		String mothEnd_ = dEndTime.getMonth() < 9 ? "0"
				+ (dEndTime.getMonth() + 1) : (dEndTime.getMonth() + 1) + "";

		// 转化为两位的日期　统一格式
		String dayStart = dStartTime.getDate() <= 9 ? "0"
				+ dStartTime.getDate() : dStartTime.getDate() + "";
		String dayEnd = dEndTime.getDate() <= 9 ? "0" + dEndTime.getDate()
				: dEndTime.getDate() + "";

		StringBuffer sb = new StringBuffer("");
		// 拼接sql,分为跨年与不跨年
		if (dStartTime.getYear() == dEndTime.getYear()) {
			sb.append("   cml.partMonthday>='").append(mothStart_)
					.append(dayStart);
			sb.append("' and cml.partMonthday<='").append(mothEnd_)
					.append(dayEnd).append("'");
		} else if (dStartTime.getYear() < dEndTime.getYear()) {
			sb.append("   ( cml.partMonthday>='").append(mothStart_)
					.append(dayStart);
			sb.append("' or cml.partMonthday<='").append(mothEnd_)
					.append(dayEnd).append("')");
		} else {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG,
					"查询时间格式不正确：结束时间大于开始时间");
		}

		String sql = " select " + " cml," + " o.orgName," + " o.orgCode"
				+ " from CmlImprecords cml," + "  OrgInfo o" + " where "
				+ sb.toString() + " and o.pathCode = cml.pathcode"
				+ " and cml.operaterId is not null"
				+ " and cml.operaterDate>='"
				+ DateUtil.parseToString(dStartTime, "yyyyMMddHHmmss") + "'"
				+ " and cml.operaterDate<='"
				+ DateUtil.parseToString(dEndTime, "yyyyMMddHHmmss") + "'";

		if (StringUtil.isNotBlank(termNum)) {
			sql += " and cml.termId ='" + termNum + "'";
		}
		if (StringUtil.isNotBlank(uploadStatus)) {
			sql += " and  cml.operateStatus = '" + uploadStatus + "' ";
		}
		if (StringUtil.isNotBlank(pathCode)) {
			sql += " and cml.pathcode like '" + pathCode + "%'";
		}
		sql += " order by cml.operaterDate  desc";
//		page = cmlImprecordsDao.findPage(page, sql);
//		List resultTmp = page.getResult();
		List resultTmp = cmlImprecordsDao.find(sql);
		List<CmlImprecordsDetail> li = new ArrayList<CmlImprecordsDetail>();
		for (Object row : resultTmp) {
			Object[] arrValues = (Object[]) row;

			CmlImprecords cmlImprecords = (CmlImprecords) arrValues[0];
			String orgName = (String) arrValues[1];
			String orgCode = (String) arrValues[2];

			CmlImprecordsDetail cml = new CmlImprecordsDetail();
			cml.setId(cmlImprecords.getId());
			cml.setTermId(cmlImprecords.getTermId());
			cml.setFileName(encryptAccountForFileName(cmlImprecords
					.getFileName()));
			cml.setOperateStatus(cmlImprecords.getOperateStatus());
			cml.setOperaterId(cmlImprecords.getOperaterId());
			cml.setSeriaimgFlag(cmlImprecords.getSeriaimgFlag());
			cml.setSeriaNum(cmlImprecords.getSeriaNum());
			cml.setOperaterDate(cmlImprecords.getOperaterDate());
			cml.setPathcode(cmlImprecords.getPathcode());
			cml.setResovimpRecords(cmlImprecords.getResovimpRecords());
			cml.setTranDate(cmlImprecords.getTranDate());
			cml.setOrgName(orgName);
			cml.setOldFileName(encryptAccountForFileName(cmlImprecords
					.getOldFileName()));
			cml.setOrgCode(orgCode);

			li.add(cml);
		}

		String uploadPocFormat = paramDao
		.getValueByPath("param.sent.SystemManager.uploadPocFormat");
		
		if (uploadPocFormat!=null && "GH".equalsIgnoreCase(uploadPocFormat)) {
			return formatGHZIPFile(li);
		}else{//原CRH格式
			return formatCRHFile(li);
		}
		
	}

	// 上报人行 :按交易
	public Map<String, String> upPersonByTranFunc(
			List<CmlImprecordsDetail> details) throws IOException {

		String uploadPocFormat = paramDao
		.getValueByPath("param.sent.SystemManager.uploadPocFormat");
		
		if (uploadPocFormat!=null && "GH".equalsIgnoreCase(uploadPocFormat)) {
			return formatGHZIPFile(details);
		}else{//原CRH格式
			return formatCRHFile(details);
		}
	}
	/**
	 * 产生随机的文件名
	 * @return
	 */
	private String getRandomName(){
		Random r=new Random();
		String result = DateUtil.getTimeYYYYMMDDHHMMSSString(new Date())+r.nextInt(100);
		return result;
	}

	// 根据接口规范生成CRH文件
	private Map<String, String> formatCRHFile(List<CmlImprecordsDetail> li) {

		String upBankCode = paramDao
				.getValueByPath("param.sent.SystemManager.currentBankCode");
		Map<String, String> dataMap = new HashMap<String, String>();
		// 在查询时间范围内的上传记录
		// 遍历上传记录，每笔交易对应CRH文件，保存到默认目录(/home/feel/SeNT/ImageUpload/UpPersonCRH/)
		// 遍历结束，将CRH文件打包ZIP文件下载
		String crhFilePath = paramDao
				.getValueByPath("param.sent.fsnPath.upPersonCrhPath");
		crhFilePath = crhFilePath + getRandomName()+File.separator;
		String[] fileDetails = null;
		String tranDateCrh = "";
		String orgCodeCrh = "";
		String businessTypeCrh = "";
		int seriaNumCrh = li.size();// 文件记录数
		String isClearCenterCrh = "F";
		String versionCrh = "1";
		String machineTypeCrh = "";
		String termTypeCrh = "";
		String termNumCrh = "";
		String busRelateInfoCrh = "";
		String reserveCrh = "";
		int index=0;
		for (CmlImprecordsDetail detail : li) {
			int dateIndex = 2;
			int typeIndex = 5;
			String tranFileName = detail.getFileName();
			fileDetails = tranFileName.split("_");
			String version = fileDetails[0];
			if("10".equals(version)){
				dateIndex = 1;
				typeIndex = 4;
			}
			tranDateCrh = fileDetails[dateIndex];// 记录日期 date
			// 报送银行编码 upBankCode
			orgCodeCrh = detail.getOrgCode();// 生成网点编码 orgCode
			businessTypeCrh = fileDetails[typeIndex];// 业务类型
			if ("ATMCK".equals(businessTypeCrh)
					|| "GMSK".equals(businessTypeCrh)) {
				businessTypeCrh = "1";
			} else if ("ATMQK".equals(businessTypeCrh)
					|| "GMFK".equals(businessTypeCrh)) {
				businessTypeCrh = "2";
			} else {
				businessTypeCrh = "3";
			}
			// 是否现金清分中心
			// 人民银行系统版本
			TermInfo tInfo = termInfoDao.getByTermCode(detail.getTermId());// 设备类别
			if (tInfo != null) {
				if ("0".equals(tInfo.getMachineType())) {
					machineTypeCrh = "1";
				} else if ("1".equals(tInfo.getMachineType())) {
					machineTypeCrh = "2";
				} else if ("2".equals(tInfo.getMachineType())) {
					machineTypeCrh = "4";
				} else if ("3".equals(tInfo.getMachineType())) {
					machineTypeCrh = "3";
				} else {
					machineTypeCrh = "0";
				}
			} else {
				machineTypeCrh = "0";
			}
			String termID = detail.getTermId();
			if(termID.length()<5){
				termID = "_____" + termID;
			}
			termTypeCrh = termID.substring(0, 5);// 机型
			termNumCrh = termID.substring(5);// 设备编号
			if ("1".equals(businessTypeCrh) || "2".equals(businessTypeCrh)) {// 业务关联信息
				busRelateInfoCrh = detail.getJourNo()==null?"0":detail.getJourNo();
			} else {
				busRelateInfoCrh = "0";
			}
			// 保留字段
			
			//20116-02-26:工程问题修复：常熟农商上传人行错误!
			if (tranDateCrh.length()<8) {
				logger.error("======该记录数据非法,跳过！！,tranDateCrh="+tranDateCrh+",tranFileName="+tranFileName);
				continue;
			}
			
			// 根据交易ID和时间查询交易冠字号(去重)
			List<CmlSentInfo> infoLst = cmlSentInfoService
					.getCmlSentInfosByTranIDAndTableName(detail.getId(),
							"CML_SENT_INFOS_HIS_" + tranDateCrh.substring(4, 8));
			seriaNumCrh = infoLst.size();//文件记录数->冠字号记录数
			// crh文件名
			String newCrhName = upBankCode + "_"
					+ termTypeCrh.replace("/", "-").replace("\\", "-") + "_"
					+ termNumCrh.replace("/", "-").replace("\\", "-") + "_"
					+ tranDateCrh +"_"+(index++) + ".CRH";
			// 写文件
			File f = new File(crhFilePath + newCrhName);
			// 判断目标文件所在的目录是否存在
			if (!f.getParentFile().exists()) {
				// 如果目标文件所在的目录不存在，则创建父目录
				System.out.println("目标文件所在目录不存在，准备创建它！");
				if (!f.getParentFile().mkdirs()) {
					System.out.println("创建目标文件所在目录失败！");
					dataMap.put("fileName", "noData");
					return dataMap;
				} else {
					System.out.println("目录创建成功！");
				}
			}
			FileOutputStream fos = null;
			try {
				// 创建输出流文件对象
				fos = new FileOutputStream(f);
				// 创建原始数据输出流对象
				DataOutputStream dataOut = new DataOutputStream(fos);
				GenCrh.genCrh(tranDateCrh, upBankCode, orgCodeCrh,
						businessTypeCrh, seriaNumCrh, isClearCenterCrh,
						versionCrh, machineTypeCrh, termTypeCrh, termNumCrh,
						busRelateInfoCrh, reserveCrh, dataOut, infoLst);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (li.size() == 0) {
			dataMap.put("fileName", "noData");
		} else {
			// 返回压缩文件路径
			String zipName = upBankCode + "_"
					+ DateUtil.getTimeYYYYMMDDHHMMSSString(new Date()) + ".ZIP";
			String zipPath = crhFilePath + zipName;

			// 压缩文件
			String[] fileTypes = { ".CRH" };
			try {
				ZipUtil.zip(zipPath, null, crhFilePath, fileTypes);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dataMap.put("fileName", zipName);
			dataMap.put("filePath", zipPath);
		}

		return dataMap;
	}
	// 20160217--根据(江苏)接口规范生成GH压缩文件
	private Map<String, String> formatGHZIPFile(List<CmlImprecordsDetail> li) throws IOException {
		
		String upBankCode = paramDao	//银行编码 直接向人民银行报送冠字号码文件的银行机构金融编码
		.getValueByPath("param.sent.SystemManager.currentBankCode");
		Map<String, String> dataMap = new HashMap<String, String>();
		// 在查询时间范围内的上传记录
		// 遍历上传记录，每笔交易对应CRH文件，保存到默认目录(/home/feel/SeNT/ImageUpload/UpPersonCRH/)
		// 遍历结束，将CRH文件打包ZIP文件下载
		String crhFilePath = paramDao
		.getValueByPath("param.sent.fsnPath.upPersonCrhPath");
		String[] fileDetails = null;
		String tranDateCrh = "";//记录日期 date
		String orgCodeCrh = "";//网点编码 生成冠字号码记录的银行分支机构金融编码
		String businessTypeCrh = "";//业务类型  柜员机配钞业务为PC 柜面存取款业务为GM*

		Map<String, List<CmlSentInfo>> cacheGHs = new HashMap<String, List<CmlSentInfo>>();
		for (CmlImprecordsDetail detail : li) {
			String ghKey = "";
			int dateIndex = 2;
			int typeIndex = 5;
			String tranFileName = detail.getFileName();
			fileDetails = tranFileName.split("_");
			String version = fileDetails[0];
			if("10".equals(version)){
				dateIndex = 1;
				typeIndex = 4;
			}
			tranDateCrh = fileDetails[dateIndex];// 记录日期 date
			// 报送银行编码 upBankCode
			orgCodeCrh = detail.getOrgCode();// 生成网点编码 orgCode
			businessTypeCrh = fileDetails[typeIndex];// 业务类型
/*			if ("ATMCK".equals(businessTypeCrh)
					|| "GMSK".equals(businessTypeCrh)) {
				businessTypeCrh = "1";
			} else if ("ATMQK".equals(businessTypeCrh)
					|| "GMFK".equals(businessTypeCrh)) {
				businessTypeCrh = "2";
			} else {
				businessTypeCrh = "3";
			}*/
			
			//柜员机配钞业务为PC  柜面存取款业务为GM*
			if (businessTypeCrh.toUpperCase().contains("GM")){
				businessTypeCrh = "GM";
			} else if (businessTypeCrh.toUpperCase().contains("ATM")){
				businessTypeCrh = "PC";
			} else {
				businessTypeCrh = "QT";//其他
			}
			

			
			// 是否现金清分中心
			// 人民银行系统版本
/*			TermInfo tInfo = termInfoDao.getByTermCode(detail.getTermId());// 设备类别
			if (tInfo != null) {
				if ("0".equals(tInfo.getMachineType())) {
					machineTypeCrh = "1";
				} else if ("1".equals(tInfo.getMachineType())) {
					machineTypeCrh = "2";
				} else if ("2".equals(tInfo.getMachineType())) {
					machineTypeCrh = "4";
				} else if ("3".equals(tInfo.getMachineType())) {
					machineTypeCrh = "3";
				} else {
					machineTypeCrh = "0";
				}
			} else {
				machineTypeCrh = "0";
			}
			String termID = detail.getTermId();
			if(termID.length()<5){
				termID = "_____" + termID;
			}
			termTypeCrh = termID.substring(0, 5);// 机型
			termNumCrh = termID.substring(5);// 设备编号
			if ("1".equals(businessTypeCrh) || "2".equals(businessTypeCrh)) {// 业务关联信息
				busRelateInfoCrh = detail.getJourNo()==null?"0":detail.getJourNo();
			} else {
				busRelateInfoCrh = "0";
			}
			// 保留字段
			

			seriaNumCrh = infoLst.size();//文件记录数->冠字号记录数
*/			
			// 根据交易ID和时间查询交易冠字号(去重)
			List<CmlSentInfo> infoLst = cmlSentInfoService
			.getCmlSentInfosByTranIDAndTableName(detail.getId(),
					"CML_SENT_INFOS_HIS_" + tranDateCrh.substring(4, 8));
			
			ghKey = tranDateCrh + UNDERLINE + upBankCode + UNDERLINE + orgCodeCrh + UNDERLINE + businessTypeCrh;
			if (cacheGHs.containsKey(ghKey)) {
				cacheGHs.get(ghKey).addAll(infoLst);
			}else{
				cacheGHs.put(ghKey, infoLst);
			}
		}
		
		//开始生成GH文件并压缩业务处理
		String today = DateUtils.toChar(new Date(), "yyyyMMdd");
		String ghFolderStr = today +  UNDERLINE + upBankCode; //生成日期_银行名称
		File ghFolder = new File(crhFilePath + ghFolderStr);
		if (ghFolder.exists()) {
			logger.info("冠字号码压缩文件夹已存在,删除原文件夹重建!"+ghFolder.getAbsolutePath());
			ghFolder.delete();
		}
		ghFolder.mkdirs();
		
		//cacheGHs
		Set<String> ghKeys = cacheGHs.keySet();
		logger.info("共有["+ghKeys.size()+"]个GZ文件待生产并压缩上报...");
		for (String ghkey : ghKeys) {
			//记录日期_银行编码_网点编码_业务类型_记录数_格式版本.GH
			List<CmlSentInfo> list = cacheGHs.get(ghkey);
			String ghName = String.format(ghkey + UNDERLINE +"%04d"+ UNDERLINE +"01.GH",
					list.size());
			
			File gzFile = new File(ghFolder, ghName);
//			char f = 0;
			StringBuffer lineCache = new StringBuffer();
			int i = 0;
			for (CmlSentInfo cmlSentInfo : list) {
				String machinesno = cmlSentInfo.getMachinesno();
				String trandatetime = cmlSentInfo.getTranDate();
				String sNO = cmlSentInfo.getSeriaNo().replace("?", "_").replace("*", "_");
				String currency = "CNY";//币种
				String versionNum = cmlSentInfo.getVersionNum(); //版别 版别目前有1999、2005两种，无法识别用9999表示
				String denom = cmlSentInfo.getDenomination();//币值
				denom = StringUtils.leftPad(denom, 3, "0");//币值 纸币面值，不足3位前端补零，如100，050，020，010
				//机具编号22 + 记录时间14 +	冠字号码10  +  币种3CNY + 版别4 + 币值3
				String contentLine = String.format(GH_LINECONTENTTEMPLATE, machinesno,
						trandatetime,sNO,currency,versionNum,denom);
				
				lineCache.append(contentLine);
				++i;
				if (i%2000==0) {//两千行作为一次缓冲
					
					FileUtil.writeStringToFile(gzFile, lineCache.toString(), true);
					lineCache.delete(0, lineCache.length());
					i=0;
				}
				
			}
			if (lineCache.length()>0) {
				FileUtil.writeStringToFile(gzFile, lineCache.toString(), true);
			}
		}
		
		//打包压缩
		File[] gzFiles = ghFolder.listFiles();
		if (gzFiles.length == 0) {
			dataMap.put("fileName", "noData");
		} else {
			
			// 返回压缩文件路径
			//压缩包文件名称
			String zipName = ghFolder.getName() +".zip";
			String zipPath = new File(ghFolder.getParent(), zipName).getAbsolutePath();
			
			// 压缩文件过滤
			String[] fileTypes = { ".GH" };
			try {
				ZipUtil.zip(zipPath, null, ghFolder.getAbsolutePath(), fileTypes);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dataMap.put("fileName", zipName);
			dataMap.put("filePath", zipPath);
		}
		
		return dataMap;
	}

	/**
	 * 设置交易的帐号加＊号显示
	 */
	private String encryptAccountForFileName(String fileName) {
		if (fileName != null && fileName != "") {
			String[] fileNameSplitArr = fileName.split("_");
			if ("11".equals(fileNameSplitArr[0])
					&& fileNameSplitArr.length == 7) {
				String tranType = fileNameSplitArr[5];
				if ("GMSK".equals(tranType) || "GMFK".equals(tranType)
						|| "ATMCK".equals(tranType) || "ATMQK".equals(tranType)
						|| "ATMXJQC".equals(tranType)) {
					String[] tranData = fileNameSplitArr[6].split("#");
					if (tranData.length >= 3 && tranData[0] != null
							&& tranData[0].length() > 3) {
						fileName = fileName.replace(
								"_" + tranData[0] + "#",
								"_"
										+ tranData[0].substring(0,
												tranData[0].length() - 4)
										+ "***"
										+ tranData[0].substring(tranData[0]
												.length() - 1) + "#");
					}
				}
			} else if ("10".equals(fileNameSplitArr[0])
					&& fileNameSplitArr.length == 8) {
				String tranType = fileNameSplitArr[4];
				if ("GMSK".equals(tranType) || "GMFK".equals(tranType)
						|| "ATMCK".equals(tranType) || "ATMQK".equals(tranType)
						|| "ATMXJQC".equals(tranType)) {
					if (fileNameSplitArr[5] != null
							&& fileNameSplitArr[5].length() > 3) {
						fileName = fileName.replace(
								"_" + fileNameSplitArr[5] + "_",
								"_"
										+ fileNameSplitArr[5]
												.substring(0,
														fileNameSplitArr[5]
																.length() - 4)
										+ "***"
										+ fileNameSplitArr[5]
												.substring(fileNameSplitArr[5]
														.length() - 1) + "_");
					}
				}
			}

		}
		return fileName;
	}

	public CmlImprecords addCmlImprecord(CmlImprecordsDetail obj) {
		String hql = " from CmlImprecords c where c.fileName='"
				+ obj.getFileName() + "'";
		CmlImprecords cml = cmlImprecordsDao.findFirst(hql);

		// if(找到)do
		if (cml != null) {
			return cml;
		}

		// 如果找不到
		CmlImprecords cmlImprecords = new CmlImprecords();

		// cmlImprecords.setId(obj.getId());
		cmlImprecords.setOperaterDate(obj.getOperaterDate());
		cmlImprecords.setFileName(obj.getFileName());
		cmlImprecords.setResovimpRecords(obj.getResovimpRecords());
		cmlImprecords.setJourNo(obj.getJourNo());
		cmlImprecords.setTermId(obj.getTermId());
		cmlImprecords.setTranDate(obj.getTranDate());
		cmlImprecords.setOperaterId(obj.getOperaterId());
		cmlImprecords.setOperateStatus(obj.getOperateStatus());
		cmlImprecords.setPathcode(obj.getPathcode());
		cmlImprecords.setSeriaimgFlag(obj.getSeriaimgFlag());
		cmlImprecords.setSeriaNum(obj.getSeriaNum());
		cmlImprecords.setTermId(obj.getTermId());

		cmlImprecordsDao.saveNew(cmlImprecords);

		return cmlImprecords;
	}

	/**
	 * @return
	 */
	public Map<String, Object> findServerInfo() {
		Map<String, Object> serverMap = new HashMap<String, Object>();
		try {
			String serverIp = paramDao
					.getValueByPath(AppConstants.FILEUPLOAD_SERVERIP);
			String serverPort = paramDao
					.getValueByPath(AppConstants.FILEUPLOAD_SERVERPORT);
			String fsnFilePath = paramDao
					.getValueByPath(AppConstants.IMAGE_PATH);

			serverMap.put("serverIp", serverIp);
			serverMap.put("serverPort", serverPort);
			serverMap.put("fsnPath", fsnFilePath);
		} catch (NullPointerException e) {
			logger.error("");
			serverMap = null;
		}
		return serverMap;
	}

	// /**
	// *
	// * 测试发现这个方法没有调到
	// */
	// public boolean updateUploadStatus(CmlImprecordsDetail cml)
	// {
	// boolean flag = false;
	//
	// String hql = "from CmlImprecords cml where cml.fileName='" +
	// cml.getFileName() + "'";
	// CmlImprecords cmle = cmlImprecordsDao.findFirst(hql);
	//
	// if( cmle!=null )
	// {
	// cmle.setTranMonthDay(cml.getTranMonthDay());
	// cmle.setTermId(cml.getTermId());
	// cmle.setOperaterDate(cml.getOperaterDate());
	// cmle.setOperaterId(cml.getOperaterId());
	// cmle.setOperateStatus(cml.getOperateStatus());
	// cmle.setJourNo(cml.getJourNo());
	// cmle.setPathcode(cml.getPathcode());
	// cmle.setSeriaimgFlag(cml.getSeriaimgFlag());
	// cmle.setSeriaNum(cml.getSeriaNum());
	//
	// cmlImprecordsDao.copyUpdate(cmle);
	//
	// flag = true;
	// }
	//
	// return flag;
	// }

	/**
	 * 
	 * �1�7�1�7�1�7�1�7�0�4�1�7id�1�7�1�7�1�7�1�7 name
	 * 
	 * */

	public String findUserName(String userCode) {
		String hql = " select userName from User where userCode ='" + userCode
				+ "'";
		String userName = null;
		List<String> li = cmlImprecordsDao.find(hql);
		try {
			if (li.size() > 0) {
				userName = li.get(0);
			}
		} catch (NullPointerException e) {
			userName = null;
			logger.error("", e);

		}

		return userName;
	}

	// public String findUserCode(String userName)
	// {
	// String hql = " select userCode from User where userName ='" + userName +
	// "'";
	// String userCode = null;
	// List<String> li = cmlImprecordsDao.find(hql);
	// try
	// {
	// if (li.size() > 0)
	// {
	// userCode = li.get(0);
	// }
	// }
	// catch (NullPointerException e)
	// {
	// userCode = null;
	// logger.error("", e);
	//
	// }
	//
	// return userCode;
	// }

	/**
	 * 
	 * �1�7�1�7�1�7�1�7�0�4�1�7id�1�7�1�7�1�7�1�7orgName
	 * 
	 * */

	public String findOrgName(String orgCode) {

		String hql = " select orgName from OrgInfo where id='" + orgCode + "'";
		String orgName = null;
		List<String> li = cmlImprecordsDao.find(hql);
		try {
			if (li.size() > 0) {
				orgName = li.get(0);
			}
		} catch (NullPointerException e) {
			orgName = null;
			logger.error("", e);
		}
		return orgName;
	}

	public String findOrgCode(String orgName) {
		String hql = " select o.id from OrgInfo o where o.orgName='" + orgName
				+ "'";
		String orgCode = null;
		List<String> li = orgInfoDao.find(hql);
		try {
			if (li.size() > 0) {
				orgCode = li.get(0);
			}
		} catch (NullPointerException e) {
			orgCode = null;
			logger.error("", e);
		}
		return orgCode;
	}

	/**
	 * �1�7�0�0�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�݄1�7�1�7fSn�0�0�0�2���1�7�1�7
	 * 
	 * */
	public String findFsnPic() {
		return paramDao.getValueByPath(AppConstants.IMAGE_PATH);
	}

	// /**
	// *
	// */
	// public String findTermCode(String termNo)
	// {
	// List<TermInfo> li = new ArrayList<TermInfo>();
	//
	// String hql = " from TermInfo t where t.termCode='" + termNo + "'";
	// String termNum = null;
	// li = cmlImprecordsDao.find(hql);
	// if (li.size() > 0)
	// {
	// termNum = li.get(0).getTermCode();
	// }
	// return termNum;
	// }

	// /**
	// *
	// */
	// public String findPathCode(String orgId)
	// {
	// System.out.println("CmlImprecordsService.findPathCode() ->>> orgId = "+orgId);
	// String pathCode = null;
	// OrgInfo o = new OrgInfo();
	// String orgCode = findOrgCode(orgId);
	// try
	// {
	// o = orgInfoDao.get(orgCode);
	// pathCode = (o.getPathCode());
	// }
	// catch (AppException e)
	// {
	// logger.error("", e);
	// pathCode = null;
	// }
	// return pathCode;
	// }

	@SuppressWarnings("unchecked")
	public Page getImprecordCmlSentInfoPage(Map parameter) {
		Page page = (Page) parameter.get("page");
		Map condition = (Map) parameter.get("condition");

		String tranId = (String) condition.get("tranId");

		String hql = " select cml" + " from CmlSentInfo cml"
				+ " where cml.tranId = ?" + " order by cml.tranDate desc";

		Object[] parameters = new Object[] { tranId };

		page = cmlImprecordsDao.findPage(page, hql, parameters);

		// cmlSentInfoService.fetchFsnCmlSentInfoImageForPage(page);
		cmlSentInfoService.fetchSerialNoImagesForPage(page);

		return page;
	}

	public static void main(String[] args) {
		String fileName = "20130824_00000001.CNY_FSN";
		String moth = fileName.substring(4, 8);
		System.out.println(moth + "ddddddddd");
	}

	/**
	 * ???List???Page
	 * 
	 * @param list
	 *            List
	 * @param page
	 *            Page
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getPageList(List list, Page page) {
		return cmlImprecordsDao.getPageList(list, page);
	}

	@Transactional(readOnly = true)
	public CmlImprecords getCmlImpRecordsDetailById(String id) {
		CmlImprecords cmlImprecords = cmlImprecordsDao.get(id);
		if (cmlImprecords == null) {
			return cmlImprecords;
		}

		cmlImprecords.setTermTypeDesc(termInfoDao
				.getTermTypeNameByTermCode(cmlImprecords.getTermId()));

		String pathCode = cmlImprecords.getPathcode();
		if (pathCode == null) {
			return cmlImprecords;
		}

		OrgInfo orgInfo = orgInfoDao.getByPathCode(pathCode);
		if (orgInfo == null) {
			return cmlImprecords;
		}
		cmlImprecords.setOrgCode(orgInfo.getOrgCode());
		cmlImprecords.setPathCodeName(orgInfo.getOrgName());
		cmlImprecords.setPathCodeFullName(orgInfo.getOrgFullName());
		cmlImprecords.setBankingOrgCode(orgInfo.getFinacialCode());// 金融机构代码
		OrgInfo bankInfo = null;
		if (pathCode.length() < 15) {
			// return cmlImprecords;
			bankInfo = orgInfo;
		} else {
			bankInfo = orgInfoDao.getByPathCode(pathCode.substring(0, 15));
			// bankInfo = orgInfoDao.getByPathCode(pathCode);
		}
		if (bankInfo == null) {
			return cmlImprecords;
		}
		cmlImprecords.setBankName(bankInfo.getOrgName());
		cmlImprecords.setBankFullName(bankInfo.getOrgFullName());

		return cmlImprecords;
	}

}
