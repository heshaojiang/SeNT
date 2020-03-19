package com.grgbanking.sent.transmgr.dao;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.sent.transmgr.entity.AtmTranInfo;

@Repository
public class AtmTranInfoDao extends BaseDao<AtmTranInfo>
{
	
	

	public AtmTranInfo getById(String id)
	{
		return this.get(id);
	}
	
	
}
