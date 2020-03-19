package com.grgbanking.sent.rule.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.security.dao.GroupDao;
import com.grgbanking.platform.module.security.dao.UserGrpDao;
import com.grgbanking.platform.module.security.entity.Group;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.sent.audit.dao.AuditInfoDao;
import com.grgbanking.sent.audit.dao.AuditLogDao;
import com.grgbanking.sent.audit.entity.AuditInfo;
import com.grgbanking.sent.audit.entity.AuditLog;
import com.grgbanking.sent.rule.constants.BlackRegulationConstants;
import com.grgbanking.sent.rule.dao.BlackRegulationDao;
import com.grgbanking.sent.rule.dao.BlackRegulationDeliverDao;
import com.grgbanking.sent.rule.dao.RegulationDeliverDao;
import com.grgbanking.sent.rule.dao.RepeatRegulationDao;
import com.grgbanking.sent.rule.entity.BlackRegulation;
import com.grgbanking.sent.rule.entity.BlackRegulationDeliver;
import com.grgbanking.sent.rule.entity.RegulationDeliver;
import com.grgbanking.sent.rule.entity.RepeatRegulation;
import com.grgbanking.sent.utils.R2001Msg;
import com.grgbanking.sent.utils.S2001Msg;
import com.grgbanking.sent.utils.S2005Msg;
import com.grgbanking.sent.utils.Transfer;

/**
 * 黑名单规则
 * 
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class BlackRegulationService extends BaseService {
	@Autowired
	BlackRegulationDao blackRegulationDao;
	@Autowired
	BlackRegulationDeliverDao blackRegulationDeliverDao;
	@Autowired
	RegulationDeliverDao regulationDeliverDao;
	@Autowired
	RepeatRegulationDao repeatRegulationDao;
	@Autowired
	AuditInfoDao auditInfoDao;
	@Autowired
	Transfer transfer;
	@Autowired
	AuditLogDao auditLogDao;

	@Autowired
	UserGrpDao userGrpDao;

	@Autowired
	GroupDao grpDao;
	
	@Autowired
	ParamDao paramDao;

	/**
	 * 分页显示黑名单规则
	 * 
	 * @param page
	 *            page
	 * @param obj
	 *            BlackRegulation
	 * @param createName
	 *            创建人
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getBlackRegulationPage(Page page, BlackRegulation obj) {
		String sql = " from BlackRegulation b where 1=1";
		if (obj.getRegulation() != null && !obj.getRegulation().equals("")) {
			sql += " and b.regulation like '%" + obj.getRegulation() + "%'";
		}

		if (obj.getRuleStatus() != 0) {
			sql += " and b.ruleStatus = " + obj.getRuleStatus();
		}
		
		sql += " order by b.applyDate desc";
		Page p = blackRegulationDao.findPage(page, sql);
		List<BlackRegulation> list = p.getResult();
		for (BlackRegulation li : list) {
			li.setRegulation(li.getRegulation().trim());
		}
		p.setResult(list);

		return p;
	}
	
	/**
	 * 新增黑名单规则
	 * 
	 * @param obj
	 *            BlackRegulation
	 * @return BlackRegulation
	 */
	public BlackRegulation addBlackRegulation(BlackRegulation obj) {
		BlackRegulation black = new BlackRegulation();
		try {
			if (isRegulationExisted(obj))
				return null;
			Serializable id = blackRegulationDao.saveNew(obj);
			black = blackRegulationDao.get(id);
		} catch (AppException e) {
			logger.error("", e);
		}

		return black;
	}
	
	/**
	 * 编辑黑名单规则
	 */
	public BlackRegulation editBlackRegulation(BlackRegulation obj) {
		if(isRegulationExisted(obj)){
			return null;
		}
		String id = obj.getId();
		BlackRegulation black = blackRegulationDao.get(id);
		try {
			obj.setAuditDate(null);
			obj.setAuditId(null);
			obj.setRejectReason(null);
			blackRegulationDao.copyUpdate(obj);
			black = blackRegulationDao.get(id);
		} catch (AppException e) {
			logger.error("", e);
		}

		return black;
	}
	
	/**
	 * 判断黑名单规则是否已存在
	 * 
	 * @param BlackRegulation
	 *            obj
	 * @return
	 */
	private boolean isRegulationExisted(BlackRegulation obj) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("regulation", obj.getRegulation());
		
		StringBuffer hql = new StringBuffer("from BlackRegulation b where b.regulation = :regulation");
		if(obj.getId() != null && obj.getId() != ""){// 编辑
			hql.append(" and b.id != :id");
			param.put("id", obj.getId());
		}
		List<BlackRegulation> result = blackRegulationDao.find(hql.toString(), param);
		if(result != null && result.size() > 0)
			return true;
		return false;
	}

	/**
	 * 删除黑名单规则
	 * 
	 * @param ids
	 *            规则ids
	 */
	public List<BlackRegulation> deleteBlackRegulation(Collection<String> ids) {
		List<BlackRegulation> result = new ArrayList<BlackRegulation>();
		/*
		 * 如果申请中和已拒绝的，就直接删除该记录。如果是通过，就变化删除中
		 */
		for (String id : ids) {
			BlackRegulation black = blackRegulationDao.get(id);
			if (black.getRuleStatus() == BlackRegulationConstants.RULESTATUS_APPLY || 
					black.getRuleStatus() == BlackRegulationConstants.RULESTATUS_REFUSE) {
				blackRegulationDao.delete(id);
				
			} else {
				black.setRuleStatus(BlackRegulationConstants.RULESTATUS_DELETE);
				black.setAuditDate(null);
				black.setAuditId(null);
				blackRegulationDao.copyUpdate(black);
				result.add(black);
			}
		}
		return result;
	}
	
	/**
	 * 添加终端下发记录
	 * @param termStr
	 * @return
	 */
	public boolean addBlackRegulationDeliver(String termStr, String operatorId){
		if(termStr == null || termStr == "")
			return false;
		
		//先清空 黑名单规则下发表记录
		String deleteHql = "delete from BlackRegulationDeliver";
		blackRegulationDeliverDao.executeUpdate(deleteHql);
		
		String version = "v_" + Long.toString(System.currentTimeMillis());
		String[] termArray = termStr.split(",");
		for(String termId : termArray){
			BlackRegulationDeliver deliver = new BlackRegulationDeliver();
			deliver.setTermId(termId);
			deliver.setRuleVersion(version);
			deliver.setCreateDate(new Date());
			deliver.setStatus(BlackRegulationConstants.DELIVERSTATUS_READY);
			deliver.setOperatorId(operatorId);
			blackRegulationDeliverDao.save(deliver);
		}
		return true;
	}
	
	/**
	 *新增规则审核信息
	 * 
	 * @param obj2
	 *            AuditInfo 申请信息
	 * @param obj3
	 *            AuditLog 审核日志
	 * @return boolean
	 */
	public boolean addAuditBlackRegulation(AuditInfo obj2, AuditLog obj3) {
		boolean flag = false;
		try {
			auditInfoDao.saveNew(obj2);
			auditLogDao.saveNew(obj3);
			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("", e);
		}
		return flag;
	}

	/**
	 * 黑名单规则
	 * 
	 * @param obj
	 *            BlackRegulation
	 * @return boolean
	 */
	public boolean updateBlackRegulation(BlackRegulation obj) {
		boolean flag = false;
		try {

			blackRegulationDao.copyUpdate(obj);

			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("", e);
			throw new NullPointerException();

		}
		return flag;
	}

	/**
	 * 黑名单规则̬
	 * 
	 * @param applyId
	 *            申请编号
	 * @return boolean
	 */
	public boolean updateBlackRegulationStatus(String applyId) {
		boolean flag = false;
		try {
			BlackRegulation black = blackRegulationDao.get(applyId);
			black.setRegulation("0");
			blackRegulationDao.copyUpdate(black);

			flag = true;
		} catch (AppException e) {
			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}

	/**
	 * 得到黑名单规则信息
	 * 
	 * @param obj
	 * 
	 * @return list
	 */
	@Transactional(readOnly = true)
	public List getBlackRegulationList(Object[] obj) {
		String sql = "  from BlackRegulation ";
		return blackRegulationDao.find(sql);
	}

	/**
	 * 黑名单列表
	 * 
	 * @return List<BlackRegulation>
	 */
	@Transactional(readOnly = true)
	public List<BlackRegulation> getBlackRegulationList() {
		String sql = " from BlackRegulation blackRegulation where blackRegulation.regulationStatus='9'";
		return blackRegulationDao.find(sql);
	}

	/**
	 * 得到黑名单规则信息
	 * 
	 * @param id
	 * @return BlackRegulation
	 */
	@Transactional(readOnly = true)
	public BlackRegulation getBlackRegulationObject(String id) {
		return (BlackRegulation) blackRegulationDao.get(id);
	}

	/**
	 * 得到黑名单规则
	 * 
	 * @param applyId
	 *            申请编号
	 * @return BlackRegulation
	 */
	@Transactional(readOnly = true)
	public BlackRegulation getBlackRegulation(String applyId) {
		BlackRegulation black = null;
		String hql = " from BlackRegulation " + "b where  b.id='" + applyId
				+ "'";
		List<BlackRegulation> list = blackRegulationDao.find(hql);
		if (null != list && list.size() > 0) {
			black = list.get(0);
		}
		return black;
	}

	/**
	 * 得到黑名单规则列表
	 * 
	 * @param applyIds
	 *            ������
	 * @return List<BlackRegulation>
	 */
	@Transactional(readOnly = true)
	public List<BlackRegulation> getBlackRegulationByApplyId(String applyIds) {
		String hql = " from BlackRegulation blackRegulation where blackRegulation.applyId='"
				+ applyIds + "'";
		List<BlackRegulation> li = blackRegulationDao.find(hql);
		return li;
	}

	/**
	 * 用户组信息
	 * 
	 * @param p_groupName
	 *            组名
	 * @return Collection<User
	 */
	@Transactional(readOnly = true)
	public Collection<User> getUsersByGroupName(String p_groupName) {
		Group grp = grpDao.getByGrpName(p_groupName);
		Collection assignedUserList = userGrpDao.getAssignedUsers(grp.getId());
		Collection assignedUserObjects = new ArrayList();
		// Construct the unassigned Role Object List
		constructUserObjects(assignedUserList, assignedUserObjects);
		return assignedUserObjects;
	}

	/**
	 * 
	 * 
	 * @param userList
	 * @param userObjects
	 */

	private void constructUserObjects(Collection userList,
			Collection userObjects) {
		if (userList != null) {
			for (Iterator it = userList.iterator(); it.hasNext();) {
				Object[] o = (Object[]) it.next();
				String id = (String) o[0];
				String userName = (String) o[1];

				User user = new User();
				user.setId(id);
				user.setUserName(userName);

				userObjects.add(user);
			}
		}
	}

	/**
	 * RegulationDeliver 终端信息
	 * 
	 * @param applyId
	 *            申请编号
	 * @return List<RegulationDeliver>
	 */
	@Transactional(readOnly = true)
	public List<RegulationDeliver> getRegulationDeliverNewListByApplyId(
			String applyId) {
		String sql = " from RegulationDeliver o where o.applyId='" + applyId
				+ "'";
		List<RegulationDeliver> li = regulationDeliverDao.find(sql);
		return li;
	}

	/**
	 * 规则下发明细列表
	 * 
	 * @param termid
	 *            终端编号
	 * @return List<RegulationDeliver>
	 */
	@Transactional(readOnly = true)
	public List<RegulationDeliver> getRegulationDeliverListByTermid(
			String termid) {

		String sql = " from RegulationDeliver o where o.termid='" + termid
				+ "' and o.version!=null order by o.version desc";
		return regulationDeliverDao.find(sql);
	}

	/**
	 * 更新规则下发详情
	 * 
	 * @param obj
	 *            RegulationDeliver
	 * @return boolean
	 */
	public boolean updateRegulationDeliver(RegulationDeliver obj) {
		boolean flag = false;
		try {
			regulationDeliverDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}

	/**
	 * 规则下发详情
	 * 
	 * @param applyId
	 *            申请编号
	 * @return List<RegulationDeliver>
	 */
	@Transactional(readOnly = true)
	public List<RegulationDeliver> getRegulationDeliverListByApplyId(
			String applyId) {
		String sql = " from RegulationDeliver o where o.applyId='" + applyId
				+ "' and o.version != null";
		List<RegulationDeliver> li = regulationDeliverDao.find(sql);
		return li;
	}

	/**
	 * 根据申请编号得到重号规则
	 * 
	 * @param applyIds
	 *            申请编号
	 * @return RepeatRegulation
	 */
	public RepeatRegulation getRepeatRegulationByApplyId2(String applyIds) {
		RepeatRegulation obj = null;
		String hql = " from RepeatRegulation repeatRegulation where repeatRegulation.id='"
				+ applyIds + "'";
		List<RepeatRegulation> list = repeatRegulationDao.find(hql);
		if (null != list && list.size() > 0) {
			obj = list.get(0);
		}
		return obj;
	}

	/**
	 * 更新重号规则
	 * 
	 * @param obj
	 *            RepeatRegulationʵ��
	 * @return boolean
	 */
	public boolean updateRepeatRegulation(RepeatRegulation obj) {
		boolean flag = false;
		try {
			repeatRegulationDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {

			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}


	/**
	 *发送报文
	 * 
	 * @param messageNo
	 *            信息编号
	 * */
	private R2001Msg getReturnPack(String messageNo) throws Exception {
		S2001Msg smsg = new S2001Msg();
		smsg.setMessageno(messageNo);

		byte[] returnpack = null;
		byte[] sendpack = smsg.packMessage();

		// 初始化

		transfer.initByService(paramDao);
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
	 * 
	 * @param str_applyId
	 *            申请编号
	 * @return int 1、2:请选择下发成功的规则3:撤销失败�4:撤销成功
	 * @throws Exception
	 */
	public int cancleRegu(String str_applyId) throws Exception {
		// 向STC端发送消息
		String messageNo = (System.currentTimeMillis() + "").substring(1, 13);
		try {
			R2001Msg rmsg = getReturnPack(messageNo);
			if (rmsg == null) {
				return 3;
			}
			return 4;
		} catch (Exception e) {
			logger.error("", e);
			return 3;
		}

	}

	/**
	 * 管理端与SeNTServer信息同步通信
	 * 
	 * @param synchType
	 * @return int 1成功 2失败
	 * @throws Exception
	 */
	public int syncSendToSentServer(int synchType) {
		// 向SentServer端发送消息
		try {
			int result = getReturnPackFor2005(synchType);
			if(result == 0 && synchType == 3){// 黑名单规则下发成功更新状态
				syncSuccessAndUpdate();
			}
			return result;
		} catch (Exception e) {
			logger.error("", e);
			return 2;
		}

	}

	public int getReturnPackFor2005(int synchType) {
		S2005Msg smsg = new S2005Msg();
		String messageNo = String.valueOf(new Date().getTime())
				.substring(1, 13);
		smsg.setType(17);
		smsg.setMessageno(Integer.parseInt(messageNo.substring(0, 9)));
		// smsg.setDevid("00000001");
		smsg.setDevidLen(0);
		smsg.setLength(4);
		smsg.setSynchInfoLen(0);
		smsg.setSynchType(synchType);
		// smsg.setSynchInfoStr("");

		byte[] returnpack = null;
		byte[] sendpack = smsg.packMessage();

		Transfer transfer = new Transfer();
		transfer.initByService(paramDao);
		try {
			returnpack = transfer.sendPack(sendpack);
		} catch (IOException e) {
			logger.error("", e);
			returnpack = null;
			return 2;
		}
		int retcode = bytesToInt(subBytes(returnpack, 14, 4));

		return retcode;

	}

	/**
	 * 截取字节数组
	 */
	protected byte[] subBytes(byte[] src, int begin, int count) {
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++)
			bs[i - begin] = src[i];
		return bs;
	}

	private int bytesToInt(byte[] bRefArr) {
		int iOutcome = 0;
		byte bLoop;

		for (int i = 0; i < bRefArr.length; i++) {
			bLoop = bRefArr[i];
			iOutcome += (bLoop & 0xFF) << (8 * i);
		}
		return iOutcome;
	}

	/**
	 * 规则同步成功后更新规则表审核状态(下发表由客户端下发成功后更新,本处无需做处理)<br>
	 * 新增：待新增(10)->已新增(12)<br>
	 * 更新:待更新(20)->已更新(22)<br>
	 * 删除：待删除(40)->已删除(42)
	 */
	public void syncSuccessAndUpdate() {
		try {
			// TODOHJY
		} catch (Exception e) {
			logger.error("同步成功后更新规则审核状态出错!");
		}
	}

}
