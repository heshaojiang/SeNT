package com.grgbanking.sent.transmgr.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.constans.TermInfoConsts;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.entity.BankSNMarkReport;


@Service
@Transactional
public class BankSNMarkReportService extends BaseService{
	
	@Autowired
	TermInfoDao terminalInfoDao;
	
	@Autowired
	private ParamDao paramDao;
	
	@Autowired
	private OrgInfoDao orgInfoDao;
	
	/**
	 * 获取终端总数
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String,Object> getTermCountInfo(Map<String, Object> parameter)
	{
		Map<String, String> condition = (Map<String, String>)parameter.get("condition");
		String orgId = (String)condition.get("orgid");

		Map<String,Object> result = new HashMap<String,Object>();
		BankSNMarkReport bankSNMarkReport = new BankSNMarkReport();
		condition.put("machineType", TermInfoConsts.MACHINE_TYPE_ATM_QK);
		String drawTermCount = String.valueOf(terminalInfoDao.getTermSumListByParams(condition));
		condition.put("machineType", TermInfoConsts.MACHINE_TYPE_ATM_CKQK);
		String drawAndDepositTermCount = String.valueOf(terminalInfoDao.getTermSumListByParams(condition));
		condition.put("machineType", TermInfoConsts.MACHINE_TYPE_COUNTER);
		String counterTermCount = String.valueOf(terminalInfoDao.getTermSumListByParams(condition));
		
//		bankSNMarkReport.setDrawTermCount(count);
//		bankSNMarkReport.setCounterTermCount(count);
//		bankSNMarkReport.setDrawAndDepositTermCount(count);
//		// 得到当前银行名称
//		bankSNMarkReport.setCurrentBank(paramDao
//				.getValueByPathWithException(AppConstants.CURRENT_BANK));
		result.put("drawTermCount", drawTermCount);
		result.put("drawAndDepositTermCount", drawAndDepositTermCount);
		result.put("counterTermCount", counterTermCount);
		result.put("currentBank", orgInfoDao.get(orgId).getOrgName());
		
		
		return result;
	}

}
