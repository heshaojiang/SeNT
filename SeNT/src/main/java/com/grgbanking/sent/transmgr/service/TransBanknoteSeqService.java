package com.grgbanking.sent.transmgr.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.transmgr.dao.TransBanknoteSeqDao;
import com.grgbanking.sent.transmgr.entity.TransBanknoteSeq;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.watch.dao.TranAbnoinfoSeqDao;
import com.grgbanking.sent.watch.entity.TranAbnoinfoSeq;

/**
 * ʵʱ����Service �̳й�����BaseService��
 * @author �����ͨ
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class TransBanknoteSeqService extends BaseService {
	@Autowired
	private TransBanknoteSeqDao transBanknoteSeqDao;
	
	@Autowired
	TranAbnoinfoSeqDao tranAbnoinfoSepDao;
	/**
     * ����һ�� TransBanknoteSeq���
     * @param obj TransBanknoteSeqʵ��
     * @return boolean
     */ 
	public boolean addTransBanknoteSeq(TransBanknoteSeq obj) {
		boolean flag = false;
		try {
			transBanknoteSeqDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
			
			logger.error("",e);
		}
		return flag;
	}
	/**
     * ɾ��һ�� TransBanknoteSeq���
     * @param obj TransBanknoteSeqʵ��
     * @return boolean
     */ 
	public boolean deleteTransBanknoteSeq(TransBanknoteSeq obj) {
		boolean flag = false;
		try {
			transBanknoteSeqDao.delete(obj
					.getId());
			flag = true;
		} catch (AppException e) {	
			logger.error("",e);
		}
		return flag;
	}
	/**
     * ����һ�� TransBanknoteSeq���
     * @param obj TransBanknoteSeqʵ��
     * @return boolean
     */ 
	public boolean updateTransBanknoteSeq(TransBanknoteSeq obj) {
		boolean flag = false;
		try {
			transBanknoteSeqDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}

	/**
     * ��ѯTransBanknoteSeq�����ʾ
     * @param page pageʵ��
     * @param obj TransBanknoteSeqʵ��
     * @return page 
     */ 
	@Transactional(readOnly = true)
	public Page getTransBanknoteSeqPage(Page page, TransBanknoteSeq obj)
	{
		String sql = "  from TransBanknoteSeq ";
		return transBanknoteSeqDao.findPage(page, sql);
	}
	/**
     * ��ѯTransBanknoteSeq�����ʾ
     * @param obj ����
     * @return List 
     */ 
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqList(Object[] obj) {
		String sql = "  from TransBanknoteSeq ";
		return transBanknoteSeqDao.find(sql);
	}
	/**
     * �������ID��ѯTransBanknoteSeq���
     * @param id id����
     * @return TransBanknoteSeq 
     */ 
	@Transactional(readOnly = true)
	public TransBanknoteSeq getTransBanknoteSeqObject(String id) {
		return (TransBanknoteSeq) transBanknoteSeqDao.get(id);
	}
	/**
     * ��ݹ���ID��ֽ�ұ�ʶΪ0 �����
     * @param transid ����ID
     * @return list 
     */ 
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqIdListFlag1(String transid){
		String hql = " select t.id from TransBanknoteSeq t where t.tranId ='"+transid+"' and t.noteFlag ='0'";
		return transBanknoteSeqDao.find(hql);
	}
	/**
     * ��ݹ���ID��ֽ�ұ�ʶΪ1 �����
     * @param transid ����ID
     * @return list 
     */ 
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqIdListFlag2(String transid){
		String hql = " select t.id from TransBanknoteSeq t where t.tranId ='"+transid+"' and t.noteFlag ='1' ";
		return transBanknoteSeqDao.find(hql);
	}
	/**
     * ��ݹ���ID��ֽ�ұ�ʶΪ4 �����
     * @param transid ����ID
     * @return list 
     */ 
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqIdListFlag3(String transid){
		String hql = " select t.id from TransBanknoteSeq t where t.tranId ='"+transid+"' and t.noteFlag ='4' ";
		return transBanknoteSeqDao.find(hql);
	}
	/**
     * ��ݹ���ID��ֽ�ұ�ʶΪ5 �����
     * @param transid ����ID
     * @return list 
     */
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqIdListFlag4(String transid){
		String hql = " select t.id from TransBanknoteSeq t where t.tranId ='"+transid+"' and t.noteFlag ='5' ";
		return transBanknoteSeqDao.find(hql);
	}
	/**
     * ��ѯTransBanknoteSeq�����ʾ
     * @param page pageʵ��
     * @param trans  TransBanknoteSeqʵ��
     * @param beginDateString ��ʼʱ��
     * @param endDateString ����ʱ��
     * @return page 
     */
	@Transactional(readOnly = true)
	public Page getTransBanknoteSeqPage(Page page, TransBanknoteSeq trans, String beginDateString, String endDateString)
	{
		String sql = "  from TransBanknoteSeq as trans where 1=1";
		
		if (beginDateString != null && !beginDateString.equals(""))
		{
			beginDateString = DateUtil.dateFormatTohms(beginDateString);
		}
		if (endDateString != null && !endDateString.equals(""))
		{
			endDateString = DateUtil.dateFormatTohms(endDateString);
		}
		if (trans.getSeriaNo() != null && !trans.getSeriaNo().equals(""))
		{
			if( DBDialectHelper.isOracle() )
			{
				sql += " and trans.seriaNo like '"+trans.getSeriaNo()+"%' ";
			}
			else
			{
				sql += " and trans.seriaNo like '"+trans.getSeriaNo()+"%' ";
			}
		}
		if(trans.getTermId()!=null&&!"".equals(trans.getTermId()))
		{
			sql += " and trans.termId ='"+trans.getTermId()+"' ";
		}
		if (beginDateString != null && !beginDateString.equals(""))
		{
			sql += " and trans.transDate||trans.tranTime>='" + beginDateString + "'";
		}
		if (endDateString != null && !endDateString.equals(""))
		{
			sql += " and trans.transDate||trans.tranTime<='" + endDateString + "'";
		}
		
		sql += "  order by trans.transDate desc";

		return transBanknoteSeqDao.findPage(page, sql);
	}
	
	/**
	 *  @param tranId ����Id
	 *  @return List<TransBanknoteSeq>
	 */
	@Transactional(readOnly = true)
	public Page getTransBanknoteSeqByTranId(Page page,String tranId,String transYear,String transMonthday)
	{
		String sql = " from TransBanknoteSeq  t where t.transYear='"+transYear+"' and t.tranMonthDay='"+transMonthday+"' and t.tranId='" + tranId + "'";
		Page pageObject = transBanknoteSeqDao.findPage(page,sql);
		return pageObject;
	}
	
	/**
	 * @param transid ����Id
	 * @param flag ֽ�ұ�ʶ
	 * @return List
	 */
	@Transactional(readOnly = true)
	public List getTranAbnoinfoSeqIdList(String transid,int flag){
		String hql = " select t.id from TranAbnoinfoSeq t where t.tranId =? and t.noteFlag = ? ";
		return transBanknoteSeqDao.find(hql,new Object[]{transid,String.valueOf(flag)});
	}
	/**
	 * ���ID��ȡ�쳣�������кŶ���
	 * @param id  ����
	 * @return TranAbnoinfoSeq
	 */
	@Transactional(readOnly = true)
	public TranAbnoinfoSeq getTranAbnoinfoSeq(String id) {
		return tranAbnoinfoSepDao.get(id);
	}
	

	 }

