package com.grgbanking.sent.rule.service;

import java.io.Serializable;
import java.net.ConnectException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.exception.SysException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.security.dao.UserGrpDao;
import com.grgbanking.platform.module.security.entity.UserGrp;
import com.grgbanking.sent.audit.dao.AuditInfoDao;
import com.grgbanking.sent.audit.dao.AuditLogDao;
import com.grgbanking.sent.audit.entity.AuditInfo;
import com.grgbanking.sent.audit.entity.AuditLog;
import com.grgbanking.sent.rule.dao.BlackRegulationDao;
import com.grgbanking.sent.rule.dao.RegulationDeliverDao;
import com.grgbanking.sent.rule.dao.RepeatRegulationDao;
import com.grgbanking.sent.rule.entity.BlackRegulation;
import com.grgbanking.sent.rule.entity.RegulationDeliver;
import com.grgbanking.sent.rule.entity.RepeatRegulation;
import com.grgbanking.sent.utils.R2001Msg;
import com.grgbanking.sent.utils.S2001Msg;
import com.grgbanking.sent.utils.Transfer;

/**
 * 重号规则Service继承BaseService
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class RepeatRegulationService extends BaseService {
	@Autowired
	private RepeatRegulationDao repeatRegulationDao;
    @Autowired
    BlackRegulationDao blackRegulationDao;
    @Autowired
    RegulationDeliverDao regulationDeliverDao;
	@Autowired
	private UserGrpDao usrUsrgrpDao;

	@Autowired
	private AuditInfoDao auditInfoDao;

	@Autowired
	private AuditLogDao auditLogDao;
   @Autowired
   Transfer transfer;

   /**
    * 新增一个重号规则数据
    * @param  obj RepeatRegulation实体 
    * @return boolean
    */
	public boolean addRepeatRegulation(RepeatRegulation obj) {
		boolean flag = false;
		try {
			repeatRegulationDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("",e);
		}
		return flag;
	}
	 /**
     * 删除一个重号规则数据，实际上是对其状态进行更改
     * @param  obj RepeatRegulation实体 
     * @return boolean
     */
	public boolean deleteRepeatRegulation(RepeatRegulation obj) {
		boolean flag = false;
		obj.setRegulationStatus("10");
		try {
			repeatRegulationDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
		}
		return flag;
	}
	/**
     *  更新一个重号规则数据
     * @param  obj RepeatRegulation实体 
     * @return boolean
     */
	public boolean updateRepeatRegulation(RepeatRegulation obj) {
		boolean flag = false;
		try {
			repeatRegulationDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}
	
	/**
	 * 添加一个重号规则实体后并 查看它的具体信息
	 * @param  obj RepeatRegulation实体 
     * @return RepeatRegulation
	 */
	public RepeatRegulation getNewObject(RepeatRegulation obj){
		RepeatRegulation repeat=new RepeatRegulation();
		try{
			obj.setCreateDate(new Date());	 
			Serializable id=repeatRegulationDao.saveNew(obj);	
			repeat=repeatRegulationDao.get(id);
		}
		catch (AppException e) {
			logger.error("",e);
		}	
		return repeat;
	}
	
	/**
	 * 根据业务人员、规则下发状态进行查询RepeatRegulation数据并显示
	 * @param page page实体
	 * @param obj RepeatRegulation实体
	 * @param createName 业务人员
	 * @return page
	 */
	@Transactional(readOnly = true)
	public Page getRepeatRegulationPage(Page page, RepeatRegulation obj, String createName)
	{
		String sql = "  from RepeatRegulation o where o.createName='" + createName + "' and o.regulationStatus!='10' ";
		if( obj.getReguStatus() != null && !obj.getReguStatus().equals("") )
		{
			sql += " and o.reguStatus = '" + obj.getReguStatus() + "'";
		}
		else if( obj.getReguStatus() != null && obj.getReguStatus().equals("") )
		{
		}
		sql += "order by o.createDate desc";

		Page p = repeatRegulationDao.findPage(page, sql);
		List<RepeatRegulation> list = p.getResult();
		for( RepeatRegulation li : list )
		{
			li.setReguStatus(li.getReguStatus().trim());
		}
		p.setResult(list);

		return p;
	}
	/**
     *  按条件查询RepeatRegulation数据
     *  @param obj 查询条件
     *  @return List
     */
	@Transactional(readOnly = true)
	public List getRepeatRegulationList(Object[] obj) {
		String sql = "  from RepeatRegulation ";
		return repeatRegulationDao.find(sql);
	}
	 /**
     *  查询RepeatRegulation数据
     *  @return List
     */

	@Transactional(readOnly = true)
	public List<RepeatRegulation> getRepeatRegulationList() {
		String sql = "  from RepeatRegulation ";
		return repeatRegulationDao.find(sql);
	}

	/**
	 * 得到最新审核通过的重号规则
	 * 
	 * @author Yondy Chow
	 * @return List<RepeatRegulation>
	 */
	@Transactional(readOnly = true)
	public List<RepeatRegulation> getLastRepeatRegulationList() {
		String sql = " from RepeatRegulation o where o.regulationStatus='9' order by o.reversionDate";
		return repeatRegulationDao.find(sql);
	}
	/**
     *  按主键id查询RepeatRegulation数据
     *  @param id 主键id
     *  @return List
     */
	@Transactional(readOnly = true)
	public RepeatRegulation getRepeatRegulationObject(String id) {
		return (RepeatRegulation) repeatRegulationDao.get(id);
	}
	/**
	 * 获取用户和用户组数据
	 * @param grpCode 组名称
	 * @return Collection<User
	 */
	@Transactional(readOnly = true)
	public List<UserGrp> getSysUserGroupList(String grpCode) {
		String sql = " from UsrUsrgrp  usrUsrgrp where usrUsrgrp.grpcode='"
				+ grpCode + "'";
		return usrUsrgrpDao.find(sql);
	}
	 /**
     * 根据申请编号查询RepeatRegulation数据
     * @param applyIds 申请编号
     * @return    List<RepeatRegulation>
     */ 
	@Transactional(readOnly = true)
	public List<RepeatRegulation> getRepeatRegulationByApplyId(String applyIds) {
		String hql = " from RepeatRegulation repeatRegulation where repeatRegulation.applyId='"
				+ applyIds + "'";
		return repeatRegulationDao.find(hql);
	}
	/**
     * 根据申请编号查询RepeatRegulation数据
     * @param applyId 申请编号
     * @return    RepeatRegulation
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
	 * 增加一个重号审核流程及审核信息表
	 * @param obj2 AuditInfo实体
	 * @param obj3 AuditLog实体
	 * @return boolean
	 */
	public boolean addAuditRepeatRegulation(
			AuditInfo obj2, AuditLog obj3) {
		boolean flag = false;
		try {
			//repeatRegulationDao.saveNew(obj);
			auditInfoDao.saveNew(obj2);
			auditLogDao.saveNew(obj3);
			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("",e);
		}
		return flag;
	}
	/**
	 * 重号规则审核拒回后更新状态
	 * @param applyId 申请编号
	 * @return boolean
	 */
	public boolean updateRepeatRegulationStatus(String applyId)
	{
		boolean flag = false;
		try
		{
			RepeatRegulation repeat = repeatRegulationDao.get(applyId);
			repeat.setRegulationStatus("9");
			repeat.setReguStatus("9");
			repeatRegulationDao.copyUpdate(repeat);
			flag = true;
		}
		catch( AppException e )
		{
			logger.error("", e);
			throw new SysException(e);
		}
		return flag;
	}
	
	
	/**
	 * 规则下发详情
	 * @param applyId 申请编号
	 * @return List<RegulationDeliver>
	 */
	@Transactional(readOnly = true)
	public List<RegulationDeliver> getRegulationDeliverNewListByApplyId(String applyId) {
			
		String sql = " from RegulationDeliver o where o.applyId='" + applyId
				+ "'";
		List<RegulationDeliver> li=regulationDeliverDao.find(sql);
		return li;
	}
	
	/**
	 * 根据申请编号得到黑名单规则信息
	 * @param applyId 申请编号
	 * @return BlackRegulation
	 */
	@Transactional(readOnly = true)
	public BlackRegulation getBlackRegulation(String applyId) {
		BlackRegulation  black=null;
		String hql = " from BlackRegulation " +
				"b where  b.id='"+applyId+"'";
		List<BlackRegulation> list = blackRegulationDao.find(hql);
		if(null!=list&&list.size()>0){
			black= list.get(0);
			}
		return black;
	}
	/**
	 * 
	 * @param termid 终端编号
	 * @return  List<RegulationDeliver>
	 */
	@Transactional(readOnly = true)
	public List<RegulationDeliver> getRegulationDeliverListByTermid(String termid){
			
		String sql = " from RegulationDeliver o where o.termid='" + termid
				+ "' and o.version!=null order by o.version desc";
		return regulationDeliverDao.find(sql);
	}
	
	/**
	 * 规则下发详情
	 * @param obj 规则下发详情
	 * @return boolean
	 */
	public boolean updateRegulationDeliver(RegulationDeliver obj) {
		boolean flag = false;
		try {
			regulationDeliverDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}
	
	/**
	 * 
	 * @param applyId 申请编号
	 * @return   List<RegulationDeliver>
	 */
	@Transactional(readOnly = true)
	public List<RegulationDeliver> getRegulationDeliverListByApplyId(String applyId) {
			
		String sql = " from RegulationDeliver o where o.applyId='" + applyId
				+ "' and o.version != null";
		List<RegulationDeliver> li=regulationDeliverDao.find(sql);
		return li;
	}
	/**
	 * 根据申请编号得到重号规则
	 * @param applyIds 申请编号
	 * @return RepeatRegulation
	 */
	public RepeatRegulation getRepeatRegulationByApplyId2(String applyIds){
		RepeatRegulation obj=null;
		String hql = " from RepeatRegulation repeatRegulation where repeatRegulation.id='"+ applyIds + "'";
		List<RepeatRegulation> list= repeatRegulationDao.find(hql);
		if(null!=list&&list.size()>0){
			obj=list.get(0);
		}
		return obj;
	}
	/**
	 * 根系黑名单规则
	 * @param obj 黑名单规则
	 * @return boolean
	 */
	public boolean updateBlackRegulation(BlackRegulation obj) {
		boolean flag = false;
		try {
			
			blackRegulationDao.copyUpdate(obj);
			
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}
	

	/**
	 * 发送报文
	 * */
	private R2001Msg getReturnPack(String messageNo) throws Exception {
		S2001Msg smsg = new S2001Msg();
		smsg.setMessageno(messageNo);
		// String time = DateUtil.sdf_yyyyMMddHHmmss.format(new Date());
		// smsg.setTxdate(time.substring(0, 8));
		// smsg.setTxtime(time.substring(8));

		byte[] returnpack = null;
		byte[] sendpack = smsg.packMessage();

		// 初始化
		//Transfer Transfer = new Transfer();
		transfer.init();
		returnpack = transfer.sendPack(sendpack);

		if (returnpack == null) {
			return null;
		} else {
			R2001Msg rmsg = new R2001Msg();
			rmsg.unpackMessage(returnpack);
			return rmsg;
		}
	}
	
	/**
	 * 撤销规则
	 * @param str_applyId 申请编号
	 * @return int  
	 * @throws Exception 
	 */
	public int cancleRegu(String str_applyId)  throws Exception{
		
		int flag=1;
		final  int  a = 3;
		final int b  =13;
		//向STS发送的消息编号
		String messageNo = (System.currentTimeMillis() + "").substring(1,b); 
		try {R2001Msg rmsg = new R2001Msg();
			rmsg = getReturnPack(messageNo);
		if (rmsg != null){
		}else {
				flag=a;
				return a;}
} catch (ConnectException e) {
			flag=a;
			return flag;
	} catch (AppException e) {
			logger.error("", e);
		}
	final int c  = 4;        
	return c;
	}
	/**
	 * 批量 增加规则下发详情信息
	 * @param regList 规则详情列表
	 * @return boolean
	 */
	public boolean batchAddRegulationDeliver(List<RegulationDeliver> regList){
		for(RegulationDeliver reg : regList){
			regulationDeliverDao.saveNew(reg);
		}
		return true;
	}
}


