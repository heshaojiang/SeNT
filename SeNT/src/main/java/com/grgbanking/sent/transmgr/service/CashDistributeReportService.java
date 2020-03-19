/**
 * 文件名：CashDistributeReportService.java
 * 创建日期： 2014-09-30
 * Copyright (c)  广电运通
 * All rights reserved.
 */
package com.grgbanking.sent.transmgr.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.sent.transmgr.dao.CashDistributeReportDao;
import com.grgbanking.sent.transmgr.entity.CmlStatisticRecord;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 现金清分统计报表服务类
 * 
 * @author zzhui1
 * 
 */
@Service
@Transactional
public class CashDistributeReportService extends BaseService {
	/** 现金清分统计报表DAO */
	@Autowired
	CashDistributeReportDao cashDistributeReportDao;
	
	@Autowired
	private OrgInfoDao orgDao;

	/**
	 * 获取现金清分统计报表的数据
	 * 
	 * @param page
	 * @param conditions
	 *            查询条件
	 * @return 现金清分统计报表的数据
	 */
	public Page<CmlStatisticRecord> getCmlStatisticRecordReport(
			Page<CmlStatisticRecord> page, Map<String, String> conditions) {
		Page<CmlStatisticRecord> csrPage = new Page<CmlStatisticRecord>();
		List<CmlStatisticRecord> csrList = new ArrayList<CmlStatisticRecord>();
		//查询条件
		String pPathCode = (String) conditions.get("pathCode");
		String flag=(String)conditions.get("flag");
		
		String pBeginTime = DateUtil.dateFormatTohms(StringUtil.trim(conditions
				.get("startTime")));
		String pEndTime = DateUtil.dateFormatTohms(StringUtil.trim(conditions
				.get("endTime")));
		//查询各个银行机构所有交易类型的金额
		List tempList = cashDistributeReportDao.getCashAmountSummary(pPathCode,flag,
				pBeginTime, pEndTime);

		String pathCode = "";
		CmlStatisticRecord csr = new CmlStatisticRecord();
		List cashDistrubuteAmountList = new ArrayList();
		for (Object temp : tempList) {
			Object[] obj = (Object[]) temp;
			csr = new CmlStatisticRecord();
			//所有的完整钞金额数的设定 
			csr.setSumCashAmountFull(getSumAmount(obj[0]).toString());
			//所有的残旧钞金额数 的设定
			csr.setSumCashAmountOld(getSumAmount(obj[1]).toString());
			//机构名称
			csr.setOrgName(orgDao.getByPathCode(String.valueOf(obj[2])).getOrgName());
			pathCode = String.valueOf(obj[2]);
			//查询各个银行经过清分机清分的交易金额
			cashDistrubuteAmountList = cashDistributeReportDao
					.getCashDistrubuteAmount(pathCode, pBeginTime, pEndTime);
			int denomination = 0;
			//清分机清分过后的完整钞金额统计数据
			BigDecimal fullCash100AmountSum = new BigDecimal(0.0);
			BigDecimal fullCash20AmountSum = new BigDecimal(0.0);
			BigDecimal fullCash5AmountSum = new BigDecimal(0.0);
			//清分机清分过后的残旧钞金额统计数据
			BigDecimal oldCash100AmountSum = new BigDecimal(0.0);
			BigDecimal oldCash20AmountSum = new BigDecimal(0.0);
			BigDecimal oldCash5AmountSum = new BigDecimal(0.0);
			//清分机清分过后的完整钞金额统计数据总合计
			BigDecimal sumDistrCashAmountFull = new BigDecimal(0.0);
			//清分机清分过后的残旧钞金额统计数据总合计
			BigDecimal sumDistrCashAmountOld = new BigDecimal(0.0);
			for (Object distrubuteSum : cashDistrubuteAmountList) {
				Object[] objArr = (Object[]) distrubuteSum;
				//取得面额
				denomination = Integer.parseInt(StringUtil.trim(objArr[0]));
				switch (denomination) {
				case 100:
				case 50:
					fullCash100AmountSum = fullCash100AmountSum.add(getSumAmount(objArr[1]));
					oldCash100AmountSum = oldCash100AmountSum.add(getSumAmount(objArr[2]));
					break;
				case 20:
				case 10:
					fullCash20AmountSum = fullCash20AmountSum.add(getSumAmount(objArr[1]));
					oldCash20AmountSum = oldCash20AmountSum.add(getSumAmount(objArr[2]));
					break;
				case 5:
				case 1:
					fullCash5AmountSum = fullCash5AmountSum.add(getSumAmount(objArr[1]));
					oldCash5AmountSum = oldCash5AmountSum.add(getSumAmount(objArr[2]));
					break;
				default:
					break;
				}
			}
			sumDistrCashAmountFull = fullCash100AmountSum.add(
					fullCash20AmountSum).add(fullCash5AmountSum);
			sumDistrCashAmountOld = oldCash100AmountSum.add(oldCash20AmountSum)
					.add(oldCash5AmountSum);
			csr.setSumCash100AmountFull(String.valueOf(fullCash100AmountSum));
			csr.setSumCash20AmountFull(String.valueOf(fullCash20AmountSum));
			csr.setSumCash5AmountFull(String.valueOf(fullCash5AmountSum));
			csr.setSumCash100AmountOld(String.valueOf(oldCash100AmountSum));
			csr.setSumCash20AmountOld(String.valueOf(oldCash20AmountSum));
			csr.setSumCash5AmountOld(String.valueOf(oldCash5AmountSum));
			csr.setSumDistrCashAmountFull(String
					.valueOf(sumDistrCashAmountFull));
			csr.setSumDistrCashAmountOld(String.valueOf(sumDistrCashAmountOld));
			csrList.add(csr);
		}
		csrPage.setResult(csrList);
		csrPage.setPageSize(csrList.size());
		return csrPage;
	}

	/**
	 * 转化成金额类型的显示形式；如果为null则显示为0
	 * @param number
	 * @return 
	 */
	private BigDecimal getSumAmount(Object number) {
		BigDecimal returnNumber = new BigDecimal(0);
		if (number != null) {
			returnNumber = new BigDecimal(String.valueOf(number));
		}
		return returnNumber;
	}
}
