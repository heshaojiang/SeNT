package com.grgbanking.sent.transmgr.service;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.sent.transmgr.dao.CmlNoteflowInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowInfo;


@Service
@Transactional
public class CmlNoteflowInfoService extends BaseService
{
	
	@Autowired
	private CmlNoteflowInfoDao cmlNoteflowInfoDao;
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	
	@Transactional(readOnly = true)
	public CmlNoteflowInfo getCmlNoteflowInfoByID(String id)
	{
		CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao.get(id);
		return cmlNoteflowInfo;
	}
	
	@Transactional(readOnly = true)
	public CmlNoteflowInfo getCmlNoteflowInfoByBarcodeFlowNum(String barcodeFlowNum)
	{
		CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
		return cmlNoteflowInfo;
	}
	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlNoteflowInfo> getCmlNoteflowInfoPage(Page page, Map condition)
	{
		String orgId = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		Page<CmlNoteflowInfo> page2 = cmlNoteflowInfoDao.queryCmlNoteflowInfoPage(page, condition);
		return page2;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlNoteflowInfo> getCmlNoteflowInfoPageByTJ(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		String termId = (String)parameter.get("termId");
		String journalNo = (String)parameter.get("journalNo");
		
		Page<CmlNoteflowInfo> page2 = cmlNoteflowInfoDao.getCmlNoteflowInfoPageByTJ(page, termId, journalNo);
		return page2;
	}
	
}
