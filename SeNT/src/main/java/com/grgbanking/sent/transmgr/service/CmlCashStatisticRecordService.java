package com.grgbanking.sent.transmgr.service;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.sent.transmgr.dao.CashStatisticRecordReportDao;


@Service
@Transactional
public class CmlCashStatisticRecordService {
	
	@Autowired
	private OrgInfoDao orgInfoDao;
	@Autowired
	private CashStatisticRecordReportDao cashStatisticRecordReportDao;
	/**
	 * 获取网点流转情况统计分页
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String,Object> getCashStatisticRecordReport(Map<String, Object> parameter)
	{
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		String orgId = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		Map<String,Object> result = cashStatisticRecordReportDao.getCashStatisticRecordReport(parameter);
		return result;
	}

}
