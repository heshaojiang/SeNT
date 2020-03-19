package com.grgbanking.sent.transmgr.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.sent.transmgr.dao.AtmTranInfoDao;
import com.grgbanking.sent.transmgr.entity.AtmTranInfo;

/**
 * 
 */
@Service
@Transactional
public class AtmTranInfoService extends BaseService
{

	@Autowired
	private AtmTranInfoDao atmTranInfoDao;
	
	@Autowired
	private TermInfoDao termInfoDao;
	
	
	@Autowired
	private OrgInfoDao orgInfoDao;
	
	public AtmTranInfo getAtmTranInfoDetailById(String id)
	{
		AtmTranInfo atmTranInfo = atmTranInfoDao.getById(id);
		if( atmTranInfo==null )
		{
			return atmTranInfo;
		}

		atmTranInfo.setTermTypeDesc(termInfoDao.getTermTypeNameByTermCode(atmTranInfo.getTermId()));
		
		//OrgInfo orgInfo = orgInfoDao.get(atmTranInfo.getTransOrgid());
		List<OrgInfo> orgItem = orgInfoDao.findBy("orgCode", atmTranInfo.getTransOrgid());
		if( orgItem == null || orgItem.isEmpty() ){
			return atmTranInfo;
		}
		OrgInfo orgInfo = orgItem.get(0);
		atmTranInfo.setTransOrgCode(orgInfo.getOrgCode());
		
		if(atmTranInfo.getTransAtm()==null){
			atmTranInfo.setTransAtm(new BigDecimal(0));
		}
		atmTranInfo.setTransOrgName(orgInfo.getOrgName());
		atmTranInfo.setTransOrgFullName(orgInfo.getOrgFullName());
		atmTranInfo.setFinacialCode(orgInfo.getFinacialCode());
		if(atmTranInfo!=null && atmTranInfo.getAccountNo()!=null && atmTranInfo.getAccountNo().length()>3){
			atmTranInfo.setAccountNo(atmTranInfo.getAccountNo().substring(0, atmTranInfo.getAccountNo().length()-4)+"***"+atmTranInfo.getAccountNo().substring(atmTranInfo.getAccountNo().length()-1));
		}
		
		return atmTranInfo;
	}
	
}


















