package com.grgbanking.sent.transmgr.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.transmgr.entity.CmlBatchRecord;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 
 * @author 广电运通
 */
@Repository
public class CmlBatchRecordDao extends BaseDao<CmlBatchRecord>
{
	
	public Page<CmlBatchRecord> queryCmlBatchRecordPage(Page<CmlBatchRecord> page, Map<String, Object> condition)
	{
		String startTime = (String)condition.get("startTime");
		String endTime   = (String)condition.get("endTime");
		String termCode  = (String)condition.get("termCode");
		String pathCode  = (String)condition.get("pathCode");
		
		String hql = "select cbr from CmlBatchRecord cbr where 1=1";
		List<Object> sqlParams = new ArrayList<Object>();
		
		if( StringUtil.isNotBlank(startTime) )
		{
			hql += " and cbr.beginTime >= ?";
			sqlParams.add(startTime);
		}
		if( StringUtil.isNotBlank(endTime) )
		{
			hql += " and cbr.beginTime <= ?";
			sqlParams.add(endTime);
		}
		if( StringUtil.isNotBlank(termCode) )
		{
			hql += " and cbr.termCode like ?";
			sqlParams.add(termCode);
		}
		if( StringUtil.isNotBlank(pathCode) )
		{
			hql += " and cbr.pathCode like ?";
			sqlParams.add(pathCode+"%");
		}
		
		return this.findPage(page, hql, sqlParams.toArray());
	}
	
	
	/**
	 * 查询还没有绑定到交易的批次
	 */
	public Page<CmlBatchRecord> queryNotBoundTranCmlBatchRecordPage(Page<CmlBatchRecord> page, Map<String, Object> condition)
	{
		String startTime = (String)condition.get("startTime");
		String endTime   = (String)condition.get("endTime");
		String termCode  = (String)condition.get("termCode");
		String pathCode  = (String)condition.get("pathCode");
		
		String hql = 	" select cbr from CmlBatchRecord cbr" +
						" where cbr.tranId is null";
		List<Object> sqlParams = new ArrayList<Object>();
		
		if( StringUtil.isNotBlank(startTime) )
		{
			hql += " and cbr.beginTime >= ?";
			sqlParams.add(startTime);
		}
		if( StringUtil.isNotBlank(endTime) )
		{
			hql += " and cbr.beginTime <= ?";
			sqlParams.add(endTime);
		}
		if( StringUtil.isNotBlank(termCode) )
		{
			hql += " and cbr.termCode like ?";
			sqlParams.add(termCode);
		}
		if( StringUtil.isNotBlank(pathCode) )
		{
			hql += " and cbr.pathCode like ?";
			sqlParams.add(pathCode+"%");
		}
		
		hql += " order by cbr.beginTime desc";
		
		return this.findPage(page, hql, sqlParams.toArray());
	}

	public Page<CmlBatchRecord> getCmlBatchRecordPageByTranId(Page<CmlBatchRecord> page, String tranId)
	{
		String hql = 	" select cbr from CmlBatchRecord cbr" +
						" where cbr.tranId = ?";
		return this.findPage(page, hql, tranId);
	}
}
