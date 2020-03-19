package com.grgbanking.sent.checkin.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.checkin.entity.FaultInfoCheckIn;
import com.grgbanking.sent.utils.StringUtil;

@Repository
public class FaultInfoCheckInDao extends BaseDao<FaultInfoCheckIn>
{
	
	public Page<FaultInfoCheckIn> queryFaultCheckInInfoPage(Page<FaultInfoCheckIn> page, Map<String, Object> condition)
	{
		String startTime = StringUtil.trim(condition.get("startTime"));
		String endTime   = StringUtil.trim(condition.get("endTime"));
		String pathCode  = StringUtil.trim(condition.get("pathCode"));
		
		String hql = " select fici from FaultInfoCheckIn fici where 1=1";
		List<Object> parameterList = new ArrayList<Object>();
		
		// startTime
		if( StringUtil.isNotBlank(startTime) )
		{
			hql += " and fici.applyDate >= ?";
			parameterList.add(startTime);
		}
		// endTime
		if( StringUtil.isNotBlank(endTime) )
		{
			hql += " and fici.applyDate <= ?";
			parameterList.add(endTime+"240000");
		}
		// pathCode
		if( StringUtil.isNotBlank(pathCode) )
		{
			hql += " and fici.orgPathCode like ?";
			parameterList.add(pathCode+"%");
		}
		hql += " order by fici.applyDate desc";
		
		return this.findPage(page, hql, parameterList.toArray());
	}
	
	
}
