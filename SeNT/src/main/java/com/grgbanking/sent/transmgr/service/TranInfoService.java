package com.grgbanking.sent.transmgr.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.checkin.entity.SmsSerialDoubtRecord;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.dao.TranInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlSentInfo;
import com.grgbanking.sent.transmgr.entity.TranInfo;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 *������Ϣ
 * @author �����̈́1�7�1�7
 * @version :1.0 </br>
 **/
@SuppressWarnings("unchecked")
@Service
@Transactional
public class TranInfoService extends BaseService 
{
	@Autowired
	private TranInfoDao tranInfoDao;
	
	@Autowired
	private ParamDao paramDao;
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	/**
	 * ��ʼ������?
	 * @return String 
	 * */
	public String getInitParamMap(){
		 return paramDao.getValueByPath((AppConstants.TRANS_DAY));
	}
	
	/**
     * ������Ϣ
     * @param obj TranInfo???
     * @return boolean
     */ 
	public boolean addTranInfo(TranInfo obj) {
		boolean flag = false;
		try {
			tranInfoDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
		
			logger.error("",e);
		}
		return flag;
	}
	 /**
     * ������Ϣ
     * @param obj TranInfo����ʵ��
     * @return boolean
     */ 
	public boolean deleteTranInfo(TranInfo obj) {
		boolean flag = false;
		try {
			tranInfoDao.delete(obj.getId());
			flag = true;
		} catch (AppException e) {
			
			logger.error("",e);
		}
		return flag;
	}
	/**
     * ������Ϣ
     * @param obj TranInfo
     * @return boolean
     */ 
	public boolean updateTranInfo(TranInfo obj) {
		boolean flag = false;
		try {
			tranInfoDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
		
			logger.error("",e);
			throw new NullPointerException();
		}
		return flag;
	}
	/**
     *���� ��Ϣ
     * @param obj ����ʵ��
     * @return list 
     */ 
	@Transactional(readOnly = true)
	public List getTranInfoList(Object[] obj) {
		String sql = "  from TranInfo ";
		return tranInfoDao.find(sql);
	}
	/**
     *����ʵ��
     * @param id ���ױ�ￄ1�7�1�7
     * @return list 
     */ 
	@Transactional(readOnly = true)
	public TranInfo getTranInfoObject(String id) {
		TranInfo cml = null;
		String orgName=null;
		try{
		String sql = "from TranInfo tranInfo where tranInfo.id='"+id+"'";
		List<TranInfo> list = tranInfoDao.find(sql);
		if(list.size()>0){
			cml = list.get(0);
			orgName=findOrgName(cml.getPathcode());//查询机构
			cml.setTransOrgid(orgName);
		}
		}
		catch(NullPointerException e){
			cml=null;
		    logger.error("", e);
			
		}
		return cml;
	}
	/**
	 * 查询机构名称
	 * */
	@Transactional(readOnly = true)
	public String findOrgName(String pathCode){
		String hql=" from OrgInfo o where o.pathCode = '"+pathCode+"'";
		String orgName=null;
		List<OrgInfo> list=new ArrayList<OrgInfo>();
		list=orgInfoDao.find(hql);
		if(list.size()>0){
			orgName=list.get(0).getOrgName();
		}
		return orgName;
	}
	
	
	/**
	 * @throws ParseException 
     */ 
	@Transactional(readOnly = true)
	public Page getTranInfoPage(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		Map<Object, String> condition = (Map)parameter.get("condition");
		
		String startTime = StringUtil.trim(condition.get("startTime"));
		String endTime = StringUtil.trim(condition.get("endTime"));
		String transResult = StringUtil.trim(condition.get("transResult"));
		String accountNo = StringUtil.trim(condition.get("accountNo"));
		String journalNo = StringUtil.trim(condition.get("journalNo"));
		String termId = StringUtil.trim(condition.get("termId"));
		String pathCode = StringUtil.trim(condition.get("pathCode"));
		String flag=(String)condition.get("flag");
		
		int day = Integer.parseInt(paramDao.getValueByPath(AppConstants.TRANS_DAY));
		
		if( StringUtil.isBlank(startTime) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL, "查询开始时间不能为空!");
		}
		
		
		
		if( StringUtil.isBlank(endTime) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL, "查询结束时间不能为空!");
		}
		
		
		Date dStartTime = null;
		Date dEndTime = null;
		try
		{
			dStartTime = DateUtil.parseToDate(startTime, "yyyy-MM-dd HH:mm:ss");
			dEndTime = DateUtil.parseToDate(endTime, "yyyy-MM-dd HH:mm:ss");
		}
		catch (ParseException e)
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG, "查询时间格式不正确["+e.getMessage()+"]");
		}
		
		if( Math.abs(dEndTime.getTime() - dStartTime.getTime()) >= DateUtil.MILLISECOND_PER_DAY*day )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_PLEASE_SELECT_QUERY_DATE_WITHIN, "请选择[%s]天以内的时间进行查询!", day);
		}
		
		//转化为两位的月份
		String mothStart_ = dStartTime.getMonth()<9?"0"+(dStartTime.getMonth()+1):(dStartTime.getMonth()+1)+"";
		String mothEnd_ = dEndTime.getMonth()<9?"0"+(dEndTime.getMonth()+1):(dEndTime.getMonth()+1)+"";
		//转化为两位的日期　统一格式
		String dayStart = dStartTime.getDate()<=9?"0"+dStartTime.getDate():dStartTime.getDate()+"";
		String dayEnd = dEndTime.getDate()<=9?"0"+dEndTime.getDate():dEndTime.getDate()+"";
		StringBuffer sb = new StringBuffer("");
		//拼接sql,分为跨年与不跨年
		if(dStartTime.getYear() == dEndTime.getYear())
		{
		sb.append("   trans.partMonthday>='").append(mothStart_).append(dayStart);
		sb.append("' and trans.partMonthday<='").append(mothEnd_).append(dayEnd).append("'");
		}else if(dStartTime.getYear() < dEndTime.getYear()){
		sb.append("   ( trans.partMonthday>='").append(mothStart_).append(dayStart);
		sb.append("' or trans.partMonthday<='").append(mothEnd_).append(dayEnd).append("')");
		}else
		{
		throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG, "查询时间格式不正确：结束时间大于开始时间");
		}

		List<Object> sqlParams = new ArrayList<Object>();

		String hql = 	" select new TranInfo(" +
							" trans.id," +
							" trans.transCode," +
							" trans.accountNo," +
							" trans.transResult," +
							" trans.transNotenum," +
							" trans.blackNotenum," +
							" trans.callbackNotenum," +
							" trans.termId," +
							" trans.tranTime," +
							" trans.repeatNotenum," +
							" trans.uploadStatus," +
							" trans.transAmt," +
							" trans.journalNo,"+
							"trans.transOrgid,"+
							"trans.statisAtm"+
						" )" +
						" from TranInfo trans" +
						" where "+sb.toString()+" and trans.tranTime >= ?" +
						" and trans.tranTime <= ?";
		
		sqlParams.add(DateUtil.parseToString(dStartTime, "yyyyMMddHHmmss"));
		sqlParams.add(DateUtil.parseToString(dEndTime, "yyyyMMddHHmmss"));
		
		if( StringUtil.isNotBlank(pathCode) )
		{
			if(null == flag || flag.equals("true")){
				hql += " and trans.pathcode like ?";
				sqlParams.add(pathCode + "%");
			}else{
				hql += " and trans.pathcode = ?";
				sqlParams.add(pathCode + "");	
			}
		}

		if( StringUtil.isNotBlank(transResult) )
		{
			hql += " and trans.transResult = ?";
			sqlParams.add(transResult);
		}

		if( StringUtil.isNotBlank(termId) )
		{
			hql += " and trans.termId = ?";
			sqlParams.add(termId);
		}

		if( StringUtil.isNotBlank(accountNo) )
		{
			hql += " and trans.accountNo = ?";
			sqlParams.add(accountNo);
		}

		if( StringUtil.isNotBlank(journalNo) )
		{
			hql += " and trans.journalNo = ?";
			sqlParams.add(journalNo);
		}
		
		hql += " order by trans.tranDate desc";

		Page page2 = new Page();
		page2 = tranInfoDao.findPage(page, hql, sqlParams.toArray());

		//this.encryptAccountForTrans(page2.getResult());
		return page2;
	}
	
	/**
	 * 设置交易的帐号加＊号显示
	 */
	private void encryptAccountForTrans(List<TranInfo> list) {

		for (TranInfo tranInfo : list) {
			if(tranInfo!=null && tranInfo.getAccountNo()!=null && tranInfo.getAccountNo().length()>3){
				tranInfo.setAccountNo(tranInfo.getAccountNo().substring(0, tranInfo.getAccountNo().length()-4)+"***"+tranInfo.getAccountNo().substring(tranInfo.getAccountNo().length()-1));
			}
		}
	}
	
	/**
	 * 分页显示交易监控信息
	 * 
	 * @param page
	 *            page
	 * @param trans
	 *            TransHourInfo
	 * @param beginDateString
	 *            开始时间
	 * @param endDateString
	 *            结束时间
	 * @return page
	 */
	@Transactional(readOnly = true)
	public Page getTransHourInfoPage(Map parameter)
	{
		Page page     = (Page)parameter.get("page");
		Map condition = (Map)parameter.get("condition");
		
		String startTime       = (String)condition.get("startTime");
		String endTime         = (String)condition.get("endTime");
		String orgId           = (String)condition.get("orgId");
		String transResult     = (String)condition.get("transResult");
		String termId          = (String)condition.get("termId");
		String accountNo       = (String)condition.get("accountNo");
		String journalNo       = (String)condition.get("journalNo");
		
		int day = Integer.parseInt(paramDao.getValueByPath(AppConstants.TRANS_DAY));
		
		String hql = " select new TranInfo(trans.id, trans.tranCode,trans.accountNo,trans.transResult,trans.transNotenum,trans.blackNotenum,trans.callbackNotenum,trans.termId,trans.tranDate,trans.repeatNotenum,trans.uploadStatus,trans.journalNo,trans.transAmt,trans.transOrgid) from TranInfo trans where 1=1";
		if( StringUtils.isBlank(startTime)==false )
		{
			startTime = DateUtil.dateFormatTohms(startTime);
		}
		else
		{
			startTime = DateUtil.getTimeYYYYMMDDHHMMSSString(DateUtil.dateIncreaseByDay(new Date(), -day));
		}
		
		if( StringUtils.isBlank(endTime)==false )
		{
			endTime = DateUtil.dateFormatTohms(endTime);
		}
		else
		{
			endTime = DateUtil.getTimeYYYYMMDDHHMMSSString(new Date());
		}
		
		List<Object> parameterList = new ArrayList<Object>();

		if( StringUtils.isBlank(orgId)==false )
		{
			hql += " and trans.pathcode like ?";
			parameterList.add(orgInfoDao.getPathCodeById(orgId));
		}
		if( StringUtils.isBlank(startTime)==false )
		{
			hql += " and trans.tranDate >= ?";
			parameterList.add(startTime);
		}
		if( StringUtils.isBlank(endTime)==false )
		{
			hql += " and trans.tranDate <= ?";
			parameterList.add(endTime);
		}
		if( StringUtils.isBlank(transResult)==false )
		{
			hql += " and trans.transResult = ?";
			parameterList.add(transResult);
		}
		if( StringUtils.isBlank(termId)==false )
		{
			hql += " and trans.termId = ?";
			parameterList.add(termId);
		}
		if( StringUtils.isBlank(accountNo)==false )
		{
			hql += " and trans.accountNo = ?";
			parameterList.add(accountNo);
		}
		if( StringUtils.isBlank(journalNo)==false )
		{
			hql += " and trans.journalNo = ?";
			parameterList.add(journalNo);
		}

		hql += " order by trans.tranDate desc";
		
		// 时间判断
		Page page2 = new Page();
		page2 = tranInfoDao.findPage(page, hql, parameterList.toArray());
		List<TranInfo> tranInfoList = new ArrayList<TranInfo>();
		List<TranInfo> list = page2.getResult();
		for (int i = 0; i < list.size(); i++)
		{
			TranInfo tranInfo = list.get(i);
			String orgName = findOrgName(tranInfo.getTransOrgid());
			tranInfo.setTransOrgid(orgName);
			tranInfoList.add(tranInfo);
		}
		page2.setResult(tranInfoList);

		return page2;
	}
	
}
