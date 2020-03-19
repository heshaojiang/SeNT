package com.grgbanking.sent.rule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.audit.dao.AuditInfoDao;
import com.grgbanking.sent.audit.entity.AuditInfo;
import com.grgbanking.sent.rule.constants.BlackRegulationConstants;
import com.grgbanking.sent.rule.dao.BlackRegulationDao;
import com.grgbanking.sent.rule.entity.BlackRegulation;

/**
 * 黑名单规则
 * @author 广电运通
 * @version 1.0
 */

@Service
@Transactional
public class NewBlackRegulationService extends BaseService {
@Autowired
AuditInfoDao auditInfoDao;
@Autowired
BlackRegulationDao blackRegulationDao;
    /**
     * @return int
     * 查询待审核的黑名单数量
     * */
	public int auditCount(){
		int num=0;
		try{
			String sql = "from BlackRegulation black where black.ruleStatus=" + BlackRegulationConstants.RULESTATUS_APPLY
							+ " or black.ruleStatus=" + BlackRegulationConstants.RULESTATUS_DELETE;
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
	
	public int reliverRegulationCount(String createName){
	 int num=0;
		try{
			String sql = " from BlackRegulation blackRegulation where blackRegulation.reguStatus='1' and " +
							"blackRegulation.createName = '" + createName + "'";
			List<BlackRegulation> li=blackRegulationDao.find(sql);
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
