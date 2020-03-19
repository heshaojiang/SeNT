package com.grgbanking.sent.audit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.SqlUtil;
import com.grgbanking.sent.audit.dao.AuditLogDao;
import com.grgbanking.sent.audit.entity.AuditInfo;
import com.grgbanking.sent.audit.entity.AuditLog;
import com.grgbanking.sent.audit.entity.AuditLogDetail;
import com.grgbanking.sent.rule.dao.BlackRegulationDao;
import com.grgbanking.sent.rule.dao.RegulationDeliverDao;
import com.grgbanking.sent.rule.dao.RepeatRegulationDao;
import com.grgbanking.sent.rule.entity.BlackRegulation;
import com.grgbanking.sent.rule.entity.RegulationDeliver;
import com.grgbanking.sent.rule.entity.RepeatRegulation;


/**
 * �1�7�1�7�1�7�1�7�1�7�0�4
 * @author �1�7�1�7�1�7�1�7�1�7�0�0
 * @version :1.0 </br>
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class AuditLogService extends BaseService {
	@Autowired
	AuditLogDao auditLogDao;
    @Autowired
    BlackRegulationDao blackRegulationDao;
    @Autowired
    RepeatRegulationDao repeatRegulationDao;
    @Autowired
    RegulationDeliverDao regulationDeliverDao;

	/**
	 * �1�7�1�7�1�7�1�7�1�7�0�4
	 * add new AuditLog
	 * @param obj  AuditLog
	 * @return boolean </br>
	 * **/
	public boolean addAuditLog(AuditLog obj) {
		boolean flag = false;
		try {
			auditLogDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("",e);
		}
		return flag;
	}
	/**
     * �1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�7�0�1�1�7�1�7�1�8�0�1�1�7�1�7�1�7�1�7�1�7�0�4
     * @param applyId �1�7�1�7�1�7�1�7�1�7�1�7
     * @return RepeatRegulation
     */ 
	@Transactional(readOnly = true)
	public RepeatRegulation getRepeatRegulation(String applyId) {
		RepeatRegulation repeat=new RepeatRegulation();
		String hql = " from RepeatRegulation r where r.id='"+applyId+"'";
		List<RepeatRegulation> list = repeatRegulationDao.find(hql);
		if(list.size()>0){
			repeat= list.get(0);
		}
		return repeat;
	}
	/**
	 * 根据规则名查找对应的黑名单规则信息
	 */
	@Transactional(readOnly = true)
	public BlackRegulation getBlackRegulationByRegulation(String applyId) {
		BlackRegulation  black=new BlackRegulation();
		String hql = " from BlackRegulation b where  b.regulation='"+applyId+"'";
		List<BlackRegulation> list = blackRegulationDao.find(hql);
		if(null!=list&&list.size()>0){
			black= list.get(0);
			}
		return black;
	}
	/**
	 * �1�7�1�7�1�7�1�7�1�7�0�4
	 * delete AuditLog
	 * @param obj  AuditLog
	 * @return boolean </br>
	 * **/
	public boolean deleteAuditLog(AuditLog obj) {
		boolean flag = false;
		try {
			auditLogDao.delete(obj.getId());
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
		}
		return flag;
	}
	/**
	 * �1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�4
	 * update AuditLog
	 * @param obj  AuditLog
	 * @return boolean</br>
	 * **/
	public boolean updateAuditLog(AuditLog obj) {
		boolean flag = false;
		try {
			auditLogDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}

    /**
     *@param  obj �1�7�0�1�1�7�1�7�1�7�1�7�1�7�1�7�0�4�1�7�҄1�7
     *@return  list< AuditLog></br>
     * **/
	@Transactional(readOnly = true)
	public List getAuditLogList(String obj) {

		String sql = "  from AuditLog  where applyId='" + obj + "'";
		return auditLogDao.find(sql);
	}
	 /**
	 * �1�7�0�1�1�7�1�7�1�7�1�7�1�7�1�7�0�4
     *@param id �1�7�1�7�1�7 �1�7�1�7�1�7
     *@return AuditLog</br>
     * **/
	@Transactional(readOnly = true)
	public AuditLog getAuditLogObject(String id) {
		return (AuditLog) auditLogDao.get(id);
	}
	/**
	 * �1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�7�0�1�1�7�1�7�1�7�1�7�1�7�1�7�0�4�1�7�҄1�7
     *@param  applyId �1�7�1�7�1�7�1�7�1�7�1�7
     *@return  list< AuditLog></br>
     * **/
	@Transactional(readOnly = true)
	public List<AuditLog> getAuditLogByApplyId(String applyId) {
		String hql = " from AuditLog where applyId='" + applyId + "'";
		List<AuditLog> li=auditLogDao.find(hql);
		hql += " order by applayDate ";
		return li;
	}
	 /**
     *@param  applyId  �1�7�1�7�1�7�1�7�1�7�1�7
     *@return  list< AuditLog></br>
     * **/
	@Transactional(readOnly = true)
	public List<AuditInfo> getAuditInfoByApplyId(String applyId){
		String hql = "from AuditInfo where applyId='"+applyId+"'";
		return auditLogDao.find(hql);
	}
	 /**
     *@param  applyId �1�7�1�7�1�7�1�7�1�7�1�7
     *@return  AuditInfo</br>
     * **/
	@Transactional(readOnly = true)
	public AuditInfo getAuditInfo(String applyId)
	{
		AuditInfo auditInfo = null;
		String orgName = null;
		String hql = "from AuditInfo where applyId='" + applyId + "'";
		List<AuditInfo> list = auditLogDao.find(hql);
		if (list.size() > 0)
		{
			auditInfo = list.get(0);
			orgName = findOrgName(auditInfo.getOrgId());
			auditInfo.setOrgId(orgName);
		}
		return auditInfo;
	}
	
	
	public String findOrgName(String orgCode)
	{

		String hql = " select orgName from OrgInfo where id='" + orgCode + "'";
		String orgName = null;
		List<String> li = auditLogDao.find(hql);
		try
		{
			if (li.size() > 0)
			{
				orgName = li.get(0);
			}
		}
		catch (NullPointerException e)
		{
			orgName = null;
			logger.error("", e);
		}
		return orgName;
	}
	
	 /**
     *@param  applyId �1�7�1�7�1�7�1�7�1�7�1�7
     *@return  AuditInfo</br>
     * **/
	@Transactional(readOnly = true)
	public AuditLog getAuditLog(String applyId){
		AuditLog auditLog = null;
		String hql = "from AuditLog where applyId='"+applyId+"'";
		List<AuditLog> list = auditLogDao.find(hql);
		if(list.size()>0){
		auditLog = list.get(0);
		}
		return auditLog;
	}
	 
	
	@Transactional(readOnly = true)
	public Page getRepeatAuditLogPage(Page page, AuditLog obj, String beginDate, String endDate)
	{
		String hql = 	" select" +
							" r.id," +
							" auditLog.applayDate," +
							" auditLog.applyType," +
							" auditLog.orgid," +
							" auditLog.applyStatus," +
							" auditLog.username," +
							" r.repeatnum" +
						" from AuditLog auditLog ," +
						" RepeatRegulation r" +
						" where auditLog.applyType= '2'" +
						" and r.id=auditLog.applyId ";

		if (obj.getApplyStatus() != null && !obj.getApplyStatus().equals(""))
		{
			hql += " and auditLog.applyStatus= '" + obj.getApplyStatus() + "' ";
		}
		if (beginDate != null && !beginDate.equals(""))
		{
			hql += " and auditLog.applayDate>= " + SqlUtil.sqlStrToDate(beginDate, "yyyy-MM-dd HH24:mi:ss");
		}
		if (endDate != null && !endDate.equals(""))
		{
			hql += " and auditLog.applayDate<= " + SqlUtil.sqlStrToDate(endDate, "yyyy-MM-dd HH24:mi:ss");
		}
		if (obj.getId() != null && !obj.getId().equals(""))
		{
			hql += " and auditLog.id like '%" + obj.getId() + "%'";
			hql += " and auditLog.applayDate =(select max(b.applayDate) from AuditLog b where b.id = '" + obj.getId() + "' ";
		}
	
		hql += " order by auditLog.applayDate desc";

		Page p = auditLogDao.findPage(page, hql);
		List resultTmp = page.getResult();
		List<AuditLogDetail> li = new ArrayList<AuditLogDetail>();

		for (Object o : resultTmp)
		{
			AuditLogDetail audit = new AuditLogDetail();
			Object[] arr = (Object[]) o;
			audit.setId((String) arr[0]);
			audit.setApplayDate((Date) arr[1]);
			audit.setApplyType((String) arr[2]);
			audit.setOrgid((String) arr[3]);
			audit.setApplyStatus((String) arr[4]);
			audit.setUsername((String) arr[5]);
			audit.setRepeatnum((Integer) arr[6]);
			li.add(audit);
		}
		page.setResult(li);
		return p;
	}
	
	 /**
	 * 加载规则下发明细
	 * 
     *@return  Page<AuditInfo></br>
     * **/
	@Transactional(readOnly = true)
	public Page getBlackAuditLogPage(Page page,int deliverStatus,String beginDate,String endDate) {
		String hql = " from BlackRegulationDeliver b where 1=1";
	
		if (beginDate != null && !beginDate.equals("")) {
			hql+=" and b.createDate>= " + SqlUtil.sqlStrToDate(beginDate, "yyyy-MM-dd HH24:mi:ss");
		}
		if (endDate != null && !endDate.equals("")) {
			hql+=" and b.createDate<= " + SqlUtil.sqlStrToDate(endDate, "yyyy-MM-dd HH24:mi:ss");
		}
		if(deliverStatus != 0){
			hql+=" and b.status=" + deliverStatus;
		}
		
		hql+= " order by b.termId desc" ;
		Page p=blackRegulationDao.findPage(page, hql.toString());
		
		return p;
	}
	/**
     * ��� ATM�ն˱�š��������͡�״̬ ��ѯRegulationDeliver�����ʾ 
     * @param  page pageʵ�� 
     * @param regulationDeliver RegulationDeliverʵ��
     * @return Page
     */
	@Transactional(readOnly = true)
	public Page getRegulationDeliverPage(Page page, RegulationDeliver regulationDeliver) {
		String sql = " from RegulationDeliver r where 1=1 ";
		String termid = regulationDeliver.getTermid();
		String type = regulationDeliver.getType();
		String status = regulationDeliver.getStatus();
		if (termid != null && !"".equals(termid)) {
			sql += "and r.termid ='" + termid + "' ";
		}
		if (type != null && !"".equals(type)) {
			sql += "and r.type='" + type + "' ";
		}
		if (status != null && !"".equals(status)) {
			sql += "and r.status = '" + status + "' ";
		}
		sql += "order by r.date desc ";
		Page p=regulationDeliverDao.findPage(page, sql);
		List<RegulationDeliver> list = p.getResult();
		for(RegulationDeliver li : list){
			li.setStatus(li.getStatus().trim());
			li.setType(li.getType().trim());
			
		}
		p.setResult(list);
		
		return p;
	}
}
