package com.grgbanking.sent.transmgr.service;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.sent.transmgr.dao.CmlNoteflowInfoMgrDao;


@Service
@Transactional
public class CmlNoteflowInfoMgrService extends BaseService
{
	
	@Autowired
	private CmlNoteflowInfoMgrDao cmlNoteflowInfoMgrDao;
	
	@Autowired
	private OrgInfoDao orgInfoDao;

	/**
	 * 获取流转信息报表分页
	 * @param page
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String,Object> getCmlNoteflowInfoMgrPage(Page page, Map condition)
	{
		String orgId = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		Map<String,Object> result = cmlNoteflowInfoMgrDao.getCmlNoteflowInfoMgrPage(page, condition);
		return result;
	}
	
	/**
	 * 获取网点流转情况统计分页
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String,Object> getCmlNoteflowSituationReportPage(Map<String, Object> parameter)
	{
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		String orgId = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		Map<String,Object> result = cmlNoteflowInfoMgrDao.getCmlNoteflowSituationReportPage(parameter);
		return result;
	}
	
	/**
	 * 获取ATM配钞统计分页
	 * @param parameter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Map<String,Object> getCmlNoteflowATMAddCashReportPage(Map<String, Object> parameter)
	{
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		String orgId = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		Map<String,Object> result = cmlNoteflowInfoMgrDao.getCmlNoteflowATMAddCashReportPage(parameter);
		return result;
	}	
}
