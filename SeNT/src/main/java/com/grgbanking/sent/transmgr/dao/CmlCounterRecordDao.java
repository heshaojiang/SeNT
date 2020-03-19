package com.grgbanking.sent.transmgr.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.entity.SysDatadir;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.sent.transmgr.entity.CmlCounterRecord;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 
 * @author 广电运通
 */
@Repository
public class CmlCounterRecordDao extends BaseDao<CmlCounterRecord> {
	@Autowired
	SysDatadirService sysDataDirService;

	public Page<CmlCounterRecord> queryCmlCounterRecordPage(
			Page<CmlCounterRecord> page, Map<String, Object> condition) {
		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");
		String accountId = (String) condition.get("accountId");
		String idCard = (String) condition.get("idCard");
		String operatorCode = (String) condition.get("operatorCode");
		String pathCode = (String) condition.get("pathCode");
		String flag = (String) condition.get("flag");
		String journalNo = (String) condition.get("journalNo");

		// 判断开始时间不能为空
		if (StringUtil.isBlank(startTime)) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL,
					"查询开始时间不能为空!");
		}
		// 结束时间不能为空
		if (StringUtil.isBlank(endTime)) {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL,
					"查询结束时间不能为空!");
		}
		// 定义开始与结束时间
		Date dStartTime = null;
		Date dEndTime = null;
		try {
			dStartTime = DateUtil.parseToDate(startTime, "yyyyMMddHHmmss");
			dEndTime = DateUtil.parseToDate(endTime, "yyyyMMddHHmmss");
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
			sb.append("   ccr.partMonthday>='").append(mothStart_).append(
					dayStart);
			sb.append("' and ccr.partMonthday<='").append(mothEnd_).append(
					dayEnd).append("'");
		} else if (dStartTime.getYear() < dEndTime.getYear()) {
			sb.append("   ( ccr.partMonthday>='").append(mothStart_).append(
					dayStart);
			sb.append("' or ccr.partMonthday<='").append(mothEnd_).append(
					dayEnd).append("')");
		} else {
			throw new AppPlaceHolderException(
					MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG,
					"查询时间格式不正确：结束时间大于开始时间");
		}

		// String hql = "select ccr from CmlCounterRecord ccr where 1=1";
		String hql = "select ccr from CmlCounterRecord ccr where "
				+ sb.toString();
		List<Object> sqlParams = new ArrayList<Object>();

		if (StringUtil.isNotBlank(startTime)) {
			hql += " and ccr.tranTime >= ?";
			sqlParams.add(startTime);
		}
		if (StringUtil.isNotBlank(endTime)) {
			hql += " and ccr.tranTime <= ?";
			sqlParams.add(endTime);
		}
		if (StringUtil.isNotBlank(accountId)) {
			hql += " and ccr.tdAccountNo = ?";
			sqlParams.add(accountId);
		}
		if (StringUtil.isNotBlank(idCard)) {
			hql += " and ccr.cardId = ?";
			sqlParams.add(idCard);
		}
		if (StringUtil.isNotBlank(operatorCode)) {
			hql += " and ccr.tdOperatorId = ?";
			sqlParams.add(operatorCode);
		}
		if (StringUtil.isNotBlank(pathCode)) {
			if (null == flag || flag.equals("true")) {
				hql += " and ccr.pathCode like ?";
				sqlParams.add(pathCode + "%");
			} else {
				hql += " and ccr.pathCode = ?";
				sqlParams.add(pathCode + "");
			}
		}
		if (StringUtil.isNotBlank(journalNo)) {
			hql += " and ccr.tdJournalNo like ?";
			sqlParams.add(journalNo + "%");
		}

		hql += " order by ccr.tranTime desc";

		Page ccrPage = this.findPage(page, hql, sqlParams.toArray());
		List<CmlCounterRecord> ccrList = ccrPage.getResult();
		for (CmlCounterRecord ccr : ccrList) {
			if (ccr.getTdTransCode().equals("GMSK") || isSK(ccr.getTdTransCode())) {
				ccr.setCardId("收");
			} else if (ccr.getTdTransCode().equals("GMFK") || isFK(ccr.getTdTransCode())) {
				ccr.setCardId("付");
			} else {
				ccr.setCardId("未定义");
			}
		}
		// 更新结果页面
		ccrPage.setResult(ccrList);
		return ccrPage;
	}

	// 判断是否为柜面交易收款
	private boolean isSK(String trancode) {
		// TODO Auto-generated method stub
		List<SysDatadir> CRHSK_List = sysDataDirService
				.getDatadirChildrenByPath("SysDatadirMgr.sent.transMgr.CRHSK",
						"zh_CN");
		List<String> tranCodeList = new ArrayList<String>();
		for (SysDatadir dir : CRHSK_List) {
			tranCodeList.add(dir.getKey());
		}
		if (tranCodeList.size() > 0) {
			for (String tranCodeByList : tranCodeList) {
				if (trancode.equals(tranCodeByList)) {
					return true;
				}
			}
		}
		return false;
	}

	// 判断是否为柜面交易付款
	private boolean isFK(String trancode) {
		// TODO Auto-generated method stub
		List<SysDatadir> CRHFK_List = sysDataDirService
				.getDatadirChildrenByPath("SysDatadirMgr.sent.transMgr.CRHFK",
						"zh_CN");
		List<String> tranCodeList = new ArrayList<String>();
		for (SysDatadir dir : CRHFK_List) {
			tranCodeList.add(dir.getKey());
		}
		if (tranCodeList.size() > 0) {
			for (String tranCodeByList : tranCodeList) {
				if (trancode.equals(tranCodeByList)) {
					return true;
				}
			}
		}
		return false;
	}

	// public CmlCounterRecord getByTranId(String tranId)
	// {
	// String hql = "select ccr from CmlCounterRecord ccr where ccr.tranId=?";
	// return this.findFirst(hql, tranId);
	// }
}
