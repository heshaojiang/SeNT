package com.grgbanking.sent.rule.dao;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.sent.rule.entity.RegulationDeliver;
/**
 * 规则下发表终端明细DAO继承BaseDao
 * @author 广电运通
 * @version 1.0
 */
@Repository
public class RegulationDeliverDao extends BaseDao<RegulationDeliver>
{
	
	
	public RegulationDeliver getByApplyId(String applyId)
	{
		String hql = " from RegulationDeliver o where o.applyId=?";
		return this.findFirst(hql, applyId);
	}
	
}
