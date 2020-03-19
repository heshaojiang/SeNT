package com.grgbanking.sent.rule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.audit.dao.AuditInfoDao;
import com.grgbanking.sent.audit.entity.AuditInfo;
import com.grgbanking.sent.rule.dao.RepeatRegulationDao;
import com.grgbanking.sent.rule.entity.RepeatRegulation;

/**
 * @author 广电运通
 *
 */
@Service
@Transactional
public class NewRepeatRegulationService extends BaseService {
	@Autowired
	AuditInfoDao auditInfoDao;
	@Autowired
	RepeatRegulationDao repeatRegulationDao;
	 /**
     * @return int数量
     * */
	public int auditCount(){
		int num=0;
		try{
		String sql = " select a.applyName,a.applayDate,a.applytyp,o.orgName,a.applyId from AuditInfo a ,OrgInfo o where "
			+ " (a.applyId in"
			+ "(select repeat.id from RepeatRegulation repeat where repeat.regulationStatus='0')) and a.orgId=o.id";
		List<AuditInfo> li=auditInfoDao.find(sql);
		if(li==null){
			num=0;
		}
		else{
			num=li.size();
		}
		}
		catch (NullPointerException e) {
			num=0;
			logger.error("",e);
		}
		return num;
	}
	/**
	 * @return int
	 * 待下发的规则数量
	 * 规则下发状态为1表示为待下发
	 * */
	
	public int reliverRegulationCount(){
		int num=0;
		try{
		String sql = " from RepeatRegulation  repeatRegulation where repeatRegulation.reguStatus='1'";
		List<RepeatRegulation> li=repeatRegulationDao.find(sql);
		if(li==null){
			num=0;
		}
		else{
			num=li.size();
		}
		}
		catch(NullPointerException e){
			num=0;
			logger.error("",e);
		}
		return num;
	}
}
