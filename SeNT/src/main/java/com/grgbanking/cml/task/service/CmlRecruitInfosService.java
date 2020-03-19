package com.grgbanking.cml.task.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.cml.task.dao.CmlSentInfosDao;
import com.grgbanking.cml.task.dao.CmlTaskInfosDao;
import com.grgbanking.cml.task.entity.CmlSentInfos;
import com.grgbanking.cml.task.entity.CmlTaskInfos;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.utils.DateUtil;

@Service
@Transactional
public class CmlRecruitInfosService extends BaseService{
	@Autowired
	private CmlTaskInfosDao cmlTaskInfosDao;
	
	@Autowired
	private CmlSentInfosDao cmlSentInfosDao;
	
	
	@Transactional(readOnly=true)
	public Page getBankNotes(Page page,String tranId,String seriaNo,String moneyType)
	{
		StringBuilder sb=new StringBuilder("from CmlSentInfos where 1=1");
		List list=new LinkedList();
		if(StringUtils.isNotBlank(tranId))
		{
			sb.append(" and tranId=?");
			list.add(tranId);
		}
		if(StringUtils.isNotBlank(seriaNo))
		{
			sb.append(" and seriaNo like ?");
			list.add("%"+seriaNo+"%");
		}
		if(StringUtils.isNotBlank(moneyType)&&!moneyType.equals("-1"))
		{
			sb.append(" and moneyType=?");
			list.add(moneyType);
		}
		return cmlSentInfosDao.findPage(page, sb.toString(), list.toArray());
	}
	
	@Transactional(readOnly=true)
	public Page getCmlRecruitInfos(Page page,String tmlNum,String operatorName,Date startTime,Date endTime)
	{
		StringBuilder sb=new StringBuilder("select a.tmlNum,b.userName,a.operateDate,a.beforeCount,a.passMoney,a.atmMoney,a.stubbedMoney,a.trailMoney,a.shadinessMoney,a.falseCoinMoney,a.totalMoney,a.id,a.boxNum from CmlTaskInfos a ,User b where a.operatorId=b.userCode ");
		List list=new LinkedList();
		
		if(StringUtils.isNotBlank(tmlNum))
		{
			sb.append(" and a.tmlNum like ? ");
			list.add("%"+tmlNum+"%");
		}
		if(StringUtils.isNotBlank(operatorName))
		{
			sb.append(" and b.userName like ?");
			list.add("%"+operatorName+"%");
		}

//		if(StringUtil.isBlank(cmlTaskInfos.getOrgId()))
//		{
//			sb.append(" and sourceOrg in ( select orgid from OrgInfo where level like ?)");
//			list.add(cmlTaskInfos.getOrgId());
//		}
		if(startTime!=null)
		{
			sb.append(" and a.operateDate>=?");
			list.add(startTime);
		}
		if(endTime!=null)
		{
			sb.append(" and a.operateDate<=?");
			list.add(endTime);
		}
		sb.append("");
		page=cmlTaskInfosDao.findPage(page, sb.toString(), list.toArray());
		List resultTmp=page.getResult();
		List<CmlTaskInfos> result=new LinkedList<CmlTaskInfos>();
		for (Object obj : resultTmp) {
			CmlTaskInfos cml=new CmlTaskInfos();
		Object []arr=(Object[]) obj;
			cml.setTmlNum((String) arr[0]);
			cml.setOperatorId((String) arr[1]);
			cml.setOperateDate((Date) arr[2]);
			cml.setBeforeCount((BigDecimal) arr[3]);
			cml.setPassMoney((BigDecimal) arr[4]);
			cml.setAtmMoney((BigDecimal) arr[5]);
			cml.setStubbedMoney((BigDecimal) arr[6]);
			cml.setTrailMoney((BigDecimal) arr[7]);
			cml.setShadinessMoney((BigDecimal) arr[8]);
			cml.setFalseCoinMoney((BigDecimal) arr[9]);
			cml.setTotalMoney((BigDecimal) arr[10]);
			cml.setId((String)arr[11]);
			cml.setBoxNum((String)arr[12]);
			result.add(cml);
		}
		page.setResult(result);
		return page;
	}
	
	@Transactional
	public void saveCmlTaskInfos(CmlTaskInfos cmlTaskInfos)
	{
		cmlTaskInfosDao.executeUpdate("update from CmlTaskInfos set passMoney=?,atmMoney=?,stubbedMoney=?,trailMoney=?,shadinessMoney=?,falseCoinMoney=?,memo=? where id=?",cmlTaskInfos.getPassMoney(),cmlTaskInfos.getAtmMoney(),cmlTaskInfos.getStubbedMoney(),cmlTaskInfos.getTrailMoney(),cmlTaskInfos.getShadinessMoney(),cmlTaskInfos.getFalseCoinMoney(),cmlTaskInfos.getMemo(),cmlTaskInfos.getId());
		cmlTaskInfosDao.executeUpdate("update from CmlTaskInfos set totalMoney=? where id=?", (cmlTaskInfos.getPassMoney().add(cmlTaskInfos.getAtmMoney()).add(cmlTaskInfos.getStubbedMoney()).add(cmlTaskInfos.getTrailMoney())).add(cmlTaskInfos.getShadinessMoney()).add(cmlTaskInfos.getFalseCoinMoney()),cmlTaskInfos.getId());
	}
	
	@Transactional
	public String delBankNote(String id)
	{
		try{
			cmlSentInfosDao.delete(id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "-1";
		}
		return "0";
	}
	
	@Transactional
	public String saveCmlSentInfos(CmlSentInfos cmlSentInfos,CmlTaskInfos cmlTaskInfos)
	{
		
		try{
			cmlSentInfos.setTranYear(DateUtil.toChars(Calendar
					.getInstance().getTime(), "yyyy"));
			cmlSentInfos.setTranYear(DateUtil.toChars(Calendar
					.getInstance().getTime(), "MMdd"));
			cmlSentInfos.setCreateDate(DateUtil.toChars(Calendar
					.getInstance().getTime(), "yyyyMMddHHmmss"));
			// 交易时间
			cmlSentInfos.setTranTime(DateUtil.toChars(Calendar
					.getInstance().getTime(), "HHmmss"));
			cmlSentInfos.setDenomination("0100");
			cmlSentInfos.setPathcode(cmlTaskInfos.getPathcode());
			cmlSentInfos.setTermId(cmlTaskInfos.getId());
			cmlSentInfos.setOrgId(cmlTaskInfos.getOrgId());
			cmlSentInfos.setTermId(cmlTaskInfos.getTmlNum());
		   logger.info(cmlSentInfos.toString());
			
			cmlSentInfosDao.save(cmlSentInfos);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "-1";
		}
		return "0";
	}
	
	@Transactional
	public String updateCmlSentInfos(CmlSentInfos cmlSentInfos)
	{
		try{
			cmlSentInfosDao.copyUpdate(cmlSentInfos);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "-1";
		}
		return "0";
	}

}
