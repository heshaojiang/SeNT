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
import com.grgbanking.sent.audit.dao.AuditInfoDao;
import com.grgbanking.sent.audit.dao.AuditLogDao;
import com.grgbanking.sent.audit.entity.AuditBlackDetail;
import com.grgbanking.sent.audit.entity.AuditInfo;
import com.grgbanking.sent.audit.entity.AuditInfoDetail;
import com.grgbanking.sent.audit.entity.AuditLog;
import com.grgbanking.sent.rule.constants.BlackRegulationConstants;
import com.grgbanking.sent.rule.dao.BlackRegulationDao;
import com.grgbanking.sent.rule.dao.RegulationDeliverDao;
import com.grgbanking.sent.rule.dao.RepeatRegulationDao;
import com.grgbanking.sent.rule.entity.BlackRegulation;
import com.grgbanking.sent.rule.entity.RegulationDeliver;
import com.grgbanking.sent.rule.entity.RepeatRegulation;
import com.grgbanking.sent.utils.DateUtil;

/**
 * 审核信息
 * 
 * @author 广电运通
 * @version :1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class AuditInfoService extends BaseService {
	@Autowired
	private AuditInfoDao auditInfoDao;
	@Autowired
	private AuditLogDao auditLogDao;
	@Autowired
	private BlackRegulationDao blackRegulationDao;
	@Autowired
	private RegulationDeliverDao regulationDeliverDao;
	@Autowired
	private RepeatRegulationDao repeatRegulationDao;
	final int no2 = 2;
	final int no3 = 3;
	final int no4 = 4;
	final int no5 = 5;
	final int no6 = 6;
	final int no7 = 7;
	final int no8 = 8;
	final int no9 = 9;
	final int no10 = 10;
	final int no11 = 11;
	final int no12 = 12;

	/**
	 *增加一条审核信息
	 * 
	 * @param obj
	 *            AuditInfo
	 * @return boolean</br>
	 **/
	public boolean addAuditInfo(AuditInfo obj) {
		boolean flag = false;
		try {
			auditInfoDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("", e);
		}
		return flag;
	}

	/**
	 * 删除一条审核信息
	 * 
	 * @param obj
	 *            AuditInfo
	 * @return boolean</br>
	 **/

	public boolean deleteAuditInfo(AuditInfo obj) {
		boolean flag = false;
		try {
			auditInfoDao.delete(obj.getId());
			flag = true;
		} catch (AppException e) {
			logger.error("", e);
		}
		return flag;
	}

	/**
	 * 更新审核信息
	 * 
	 * @param obj
	 *            AuditInfo
	 * @return boolean</br>
	 **/
	public boolean updateAuditInfo(AuditInfo obj) {
		boolean flag = false;
		try {
			auditInfoDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {

			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}

	/**
	 * 审核
	 * 
	 * @param obj
	 *            审核日志
	 * 
	 * @return boolean</br>
	 **/
	public boolean audit(AuditLog obj) {
		boolean flag = false;
		try {
			auditInfoDao.get(obj.getId());
			flag = true;
		} catch (AppException e) {

			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}

	/**
	 * 申核流程信息
	 * 
	 * @param applyId
	 *            申请编号
	 *@return AuditLog</br>
	 **/
	@Transactional(readOnly = true)
	public AuditLog getAuditLog(String applyId) {
		AuditLog auditLog = null;
		String hql = "from AuditLog where applyId='" + applyId + "'";
		List<AuditLog> list = auditLogDao.find(hql);
		if (list.size() > 0) {
			auditLog = list.get(0);
		}
		return auditLog;
	}

	/**
	 * @return boolean
	 * @param obj
	 *            审核日志信息
	 * */
	public boolean addAuditLog(AuditLog obj) {
		boolean flag = false;
		try {
			AuditLog auditInfo = getAuditLog(obj.getApplyId());
			if (auditInfo != null && !auditInfo.equals("")) {
				obj.setId(auditInfo.getId());
				auditLogDao.copyUpdate(obj);
				flag = true;
			}
		} catch (AppException e) {

			logger.error("", e);

			flag = false;
			throw new NullPointerException();
		}
		return flag;
	}

	/**
	 * @param obj
	 *            审核信息
	 * 
	 * @param obj2
	 *            申请日志
	 * @param obj3
	 *            黑名单规则
	 * 
	 * @return boolean 是否成功
	 */
	public boolean audit(AuditInfo obj, AuditLog obj2, BlackRegulation obj3) {
		boolean flag = false;
		try {
			auditInfoDao.copyUpdate(obj);
			// auditInfoDao.addObject(obj2);
			auditInfoDao.get(obj.getId());
			auditInfoDao.saveNew(auditInfoDao.get(obj.getId()));
			// auditLogDao.saveNew(obj2);
			blackRegulationDao.copyUpdate(obj3);
			flag = true;
		} catch (AppException e) {

			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}

	/**
	 * 更新申请信息
	 * 
	 * @param applyId
	 *            ������
	 * @return boolean
	 */
	public boolean updateRepeatRegulationStatus(String applyId) {
		boolean flag = false;
		try {
			RepeatRegulation repeat = repeatRegulationDao.get(applyId);
			repeat.setRegulationStatus("9");
			repeat.setReguStatus("9");
			// repeatRegulationDao.copyUpdate(repeat);

			flag = true;
		} catch (AppException e) {
			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}

	/**
	 * 重号规则信息
	 * 
	 * @param applyId
	 *            申请编号
	 * @return RepeatRegulation
	 */
	@Transactional(readOnly = true)
	public RepeatRegulation getRepeatRegulation(String applyId) {
		RepeatRegulation repeat = new RepeatRegulation();
		String hql = " from RepeatRegulation r where r.id='" + applyId + "'";
		List<RepeatRegulation> list = repeatRegulationDao.find(hql);
		if (list.size() > 0) {
			repeat = list.get(0);
		}
		return repeat;
	}

	/**
	 * 根据规则名查找对应的黑名单规则信息
	 * 
	 * @param applyId
	 *            规则名
	 * @return BlackRegulation
	 */
	@Transactional(readOnly = true)
	public BlackRegulation getBlackRegulationByRegulation(String applyId) {
		BlackRegulation black = new BlackRegulation();
		String hql = " from BlackRegulation b where  b.regulation='" + applyId + "'";
		List<BlackRegulation> list = blackRegulationDao.find(hql);
		if (null != list && list.size() > 0) {
			black = list.get(0);
		}
		return black;
	}

	/**
	 * 申请信息
	 * 
	 * @param applyId
	 *            申请编号
	 *@return AuditInfo</br>
	 **/
	@Transactional(readOnly = true)
	public AuditInfo getAuditInfo(String applyId) {
		AuditInfo auditInfo = null;
		String hql = "from AuditInfo where applyId='" + applyId + "'";
		List<AuditInfo> list = auditLogDao.find(hql);
		if (list.size() > 0) {
			auditInfo = list.get(0);
		}
		return auditInfo;
	}

	/**
	 * 分页显示申请信息
	 * 
	 * @return Page
	 * @param page
	 *            分页对象
	 * @param obj
	 *            申请信息
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * */
	@Transactional(readOnly = true)
	public Page getBlackAuditInfoPage(Page page, String beginDate, String endDate) {
		String sql = "select b.id,b.regulation,b.applyId,o.orgName,b.applyDate,b.ruleStatus from BlackRegulation b,OrgInfo o " +
						"where b.applyOrgId=o.id and (b.ruleStatus=" + BlackRegulationConstants.RULESTATUS_APPLY + " or b.ruleStatus=" 
							+ BlackRegulationConstants.RULESTATUS_DELETE + ")";
		if (beginDate != null && !beginDate.equals("")) {
			sql += " and b.applyDate>=" + SqlUtil.sqlStrToDate(beginDate, "yyyy-MM-dd HH24:mi:ss");
		}
		if (endDate != null && !endDate.equals("")) {
			sql += " and b.applyDate<=" + SqlUtil.sqlStrToDate(endDate, "yyyy-MM-dd HH24:mi:ss");
		}
		sql += " order by b.applyDate desc";
		Page pageObject = auditInfoDao.findPage(page, sql);
		List resulTemp = pageObject.getResult();
		
		List<AuditBlackDetail> result = new ArrayList<AuditBlackDetail>();
		for (Object auditObject : resulTemp) {
			AuditBlackDetail black = new AuditBlackDetail();
			Object[] arr = (Object[]) auditObject;
			black.setId((String) arr[0]);
			black.setRegulation((String) arr[1]);
			black.setApplyId((String) arr[2]);
			black.setApplyOrgName((String)arr[3]);
			black.setApplyDate((Date) arr[4]);
			black.setRuleStatus((Integer) arr[5]);
			result.add(black);
		}
		pageObject.setResult(result);
		return pageObject;
	}

	/**
	 * 分页显示申请信息
	 * 
	 * @return Page
	 * @param page
	 *            分页对象
	 * @param obj
	 *            申请信息
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * */
	@Transactional(readOnly = true)
	public Page getRepeatAuditInfoPage(Page page, AuditInfo obj,
			String beginDate, String endDate) {
		String sql = " select a.applyName,a.applayDate,a.applytyp,o.orgName,a.applyId from AuditInfo a ,OrgInfo o where "
				+ "(a.applyId in"
				+ "(select repeat.id from RepeatRegulation repeat where repeat.regulationStatus='0')) and a.orgId=o.id";

		// if (obj.getApplytyp() != null && !obj.getApplytyp().equals("")) {
		// sql += " and a.applytyp='" + obj.getApplytyp() + "'";
		// }
		// if (obj.getAuditStatus() != null && !obj.getAuditStatus().equals(""))
		// {
		// sql += " and a.auditStatus='" + obj.getAuditStatus() + "'";
		// }
		if (beginDate != null && !beginDate.equals("")) {
			beginDate = DateUtil.dateFormatTohms(beginDate);

		}
		if (endDate != null && !endDate.equals("")) {
			endDate = DateUtil.dateFormatTohms(endDate);

		}
		if (beginDate != null && !beginDate.equals("")) {
			sql += " and a.applayDate>='" + beginDate + "'";
		}
		if (endDate != null && !endDate.equals("")) {
			sql += " and a.applayDate<='" + endDate + "'";
		}
		sql += " order by a.applayDate desc";
		Page pageObject = auditInfoDao.findPage(page, sql);
		List resulTemp = page.getResult();
		List<AuditInfoDetail> result = new ArrayList<AuditInfoDetail>();

		for (Object auditObject : resulTemp) {
			AuditInfoDetail audit = new AuditInfoDetail();
			Object[] arr = (Object[]) auditObject;
			audit.setUsername((String) arr[0]);
			audit.setApplayDate((String) arr[1]);
			audit.setApplyType((String) arr[2]);
			audit.setOrgName((String) arr[3]);
			audit.setApplyId((String) arr[4]);
			result.add(audit);
		}
		page.setResult(result);
		return pageObject;
	}

	/**
	 * @param obj
	 *            Object[]
	 * 
	 * @return list
	 * 
	 * **/
	@Transactional(readOnly = true)
	public List getAuditInfoList(Object[] obj) {
		String sql = "  from AuditInfo ";
		return auditInfoDao.find(sql);
	}

	/**
	 * @param id
	 *            String
	 * @return AuditInfo
	 * **/
	@Transactional(readOnly = true)
	public AuditInfo getAuditInfoObject(String id) {
		return (AuditInfo) auditInfoDao.get(id);
	}

	/**
	 * 分页
	 * 
	 * @param list
	 *            List
	 * @param page
	 *            Page
	 * @return Page
	 */
	@Transactional(readOnly = true)
	public Page getPageList(List list, Page page) {
		return auditInfoDao.getPageList(list, page);
	}

	/*
	 * 如果结束流程,根据申请id更新重号规则和黑名单规则的状态为 1�7��1�7�过, 更新下发状�1�7�为 1�7�待下发〄1�7
	 */
	// public void updateRuleStatus(String applyId, String flowName,
	// String regulationStatus, String reguStatus) {
	// try {
	// //String hql = "";
	//
	// if (flowName != null && flowName.equals("blacklist_apply")) {
	// updateBlackRegulationByApplyId(applyId, regulationStatus, reguStatus);
	// } else if (flowName != null && flowName.equals("repeat_apply")) {
	// updateRepeatRegulationByApplyId(applyId, regulationStatus, reguStatus);
	// }
	//
	// } catch (Exception e) {
	// logger.error("",e);
	// }
	// }

	public Long getVersion(){
		String hql = "from RegulationDeliver where version is not null order by version desc";
		List<RegulationDeliver> list = regulationDeliverDao.find(hql);
		if (list != null && list.size() > 0) {
			RegulationDeliver r = list.get(0);
			String version = r.getVersion().split("_")[1];
			return Long.parseLong(version);
		}
		return new Long(1000000000);
	}
	
	/**
	 * �����غŹ�����Ϣ
	 * 
	 * @param applyId
	 *            ������
	 * 
	 * @param regulationStatus
	 *            ����״̬
	 * 
	 * @param reguStatus
	 *            �����·�״̬
	 * 
	 * @return boolean
	 */
	public boolean updateRepeatRegulationByApplyId(String applyId,
			String regulationStatus, String reguStatus) {
		boolean flag = false;
		try {
			RepeatRegulation repeatRegulation = null;
			AuditLog auditLog = null;
			List<RepeatRegulation> list = repeatRegulationDao
					.find(" from RepeatRegulation t where t.id ='" + applyId
							+ "'");
			List<AuditLog> auditLogList = regulationDeliverDao
					.find(" from AuditLog log where log.applyId ='" + applyId
							+ "'");
			// List li=regulationDeliverDao.find(
			// " from RegulationDeliver r where r.applyId ='" + applyId
			// + "'");
			// �޸Ķ�Ӧ�������־��Ϣ
			if (auditLogList != null && auditLogList.size() > 0) {
				auditLog = (AuditLog) auditLogList.get(0);
				auditLog.setApplyStatus("9");
				auditLogDao.copyUpdate(auditLog);
				flag = true;
			}
			// 更新规则下发终端信息
			// if (li != null && li.size() > 0) {
			// regulationDeliver = (RegulationDeliver) li.get(0);
			// String str_version = "v_" +
			// Long.toString(System.currentTimeMillis());
			// regulationDeliver.setVersion(str_version);
			// regulationDeliverDao.copyUpdate(regulationDeliver);
			// flag = true;
			// }
			// �޸��غŹ�����Ϣ
			if (list != null && list.size() > 0) {
				repeatRegulation = (RepeatRegulation) list.get(0);
				repeatRegulation.setRegulationStatus(regulationStatus);
				repeatRegulation.setReguStatus(reguStatus);
				repeatRegulation.setReversionDate(new Date());
				repeatRegulationDao.copyUpdate(repeatRegulation);

				flag = true;
			}
			return flag;
		} catch (AppException e) {

			logger.error("", e);
			return flag;
		}
	}

	/**
	 * ��������ŵõ������־�б�
	 * 
	 * @param applyId
	 *            ������
	 *@return list< AuditLog></br>
	 * **/
	@Transactional(readOnly = true)
	public List<AuditLog> getAuditLogByApplyId(String applyId) {
		String hql = " from AuditLog where applyId='" + applyId + "'";
		List<AuditLog> li = auditLogDao.find(hql);
		hql += " order by applayDate ";
		return li;
	}
	
	/**
	 * 审核黑名单
	 * 
	 * @param black
	 * @param auditResult
	 * @return
	 */
	public boolean auditBlackRegulation(BlackRegulation black, String auditResult, String rejectReason){
		/*
		 * 审核通过:如果申请中的把状态变为通过，如果删除中，就直接把记录删除；审核不通过:如果申请中的就把状态变为已拒绝，如果是删除中的，则变为已通过，即该记录变回原来已通过的。
		 */
		BlackRegulation instance = blackRegulationDao.get(black.getId());
		if(auditResult.equals("Y")){// 审核通过
			if(instance.getRuleStatus() == BlackRegulationConstants.RULESTATUS_APPLY){
				instance.setRuleStatus(BlackRegulationConstants.RULESTATUS_PASS);
				instance.setRejectReason(null);
			} else if(instance.getRuleStatus() == BlackRegulationConstants.RULESTATUS_DELETE) {
				blackRegulationDao.delete(instance);
				return true;
			}
		} else {// 拒回
			if(instance.getRuleStatus() == BlackRegulationConstants.RULESTATUS_APPLY)
				instance.setRuleStatus(BlackRegulationConstants.RULESTATUS_REFUSE);
			else if(instance.getRuleStatus() == BlackRegulationConstants.RULESTATUS_DELETE)
				instance.setRuleStatus(BlackRegulationConstants.RULESTATUS_PASS);
			instance.setRejectReason(rejectReason);
		}
		instance.setAuditId(black.getAuditId());
		instance.setAuditDate(black.getAuditDate());
		blackRegulationDao.copyUpdate(instance);
		return true;
	}
	
}
