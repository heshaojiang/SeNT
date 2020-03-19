package com.grgbanking.sent.transmgr.service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.service.OrgInfoService;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.service.TermInfoService;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlSentInfo;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * @author ������?�?�?�?
 *
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class TransBankNoteSeqAllService extends BaseService{
	final int num3=3;
	final int subLength=13;

	//��ȡ�ַ�ĳ���?�?�?�?
	final int str0=0;
	final int str1=1;
	final int str8=8;
	final int str13=13;
	final int str14=14;
	//�ַ�Ŀ�ʼλ��?�?�?�?
	final int star0=0;
	final int star1=1;
	final int star2=2;
	final int star3=3;
	final int star4=4;
	final int star5=5;
	final int star6=6;
	final int star7=7;
	final int star8=8;
	final int star9=9;
	final int star10=10;
	@Autowired
  CmlSentInfoDao cmlSentInfoDao;
	@Autowired
	CmlSentInfoService cmlSentInfoService;
	@Autowired
	TranInfoService tranInfoService;
	@Autowired
	ParamDao paramDao;
    
	@Autowired
	OrgInfoService orgInfoService;
	@Autowired
	TermInfoService termInfoService;
	@Autowired
	OrgInfoDao orgInfoDao;
	
	/**
     * ����һ�� TransBanknoteSeq���?�?�?�?
     * @param obj TransBanknoteSeqʵ��
     * @return boolean
     */ 
	public boolean addTransBankNoteSeqAll(CmlSentInfo obj) {
		boolean flag = false;
		try {
			cmlSentInfoDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("", e);
		}
		return flag;
	}
	
	/**
	 * ɾ��һ�� TransBanknoteSeq���?�?�?�?
	 * @param obj TransBanknoteSeqʵ��
	 * @return boolean
	 */ 
	public boolean deleteTransBankNoteSeqAll(CmlSentInfo obj) {
		boolean flag = false;
		try {
			cmlSentInfoDao.delete(obj.getId());
			flag = true;
		} catch (AppException e) {	
			logger.error("", e);
		}
		return flag;
	}

	/**
	 * @return String ʱ�䷶Χ
	 * ��ù��ֺ�ȫ��׷�ٵ�ʱ�䷶�?�?�?�?
	 * */
	public String getInitParamMap(){
		 return paramDao.getValueByPath((AppConstants.SENT_ALLDAY));
	}
	
	
	@Transactional(readOnly = true)
	public Page getTransBankNoteSeqAllPage(Map<String,Object> parameter)
	{
		Page page = (Page)parameter.get("page");
		Map<String,Object> condition = (Map)parameter.get("condition");
		
		String startTime       = (String)condition.get("startTime");
		String endTime         = (String)condition.get("endTime");
		String seriaNo         = (String)condition.get("seriaNo");
		String termId          = (String)condition.get("termId");
		String pathCode        = (String)condition.get("pathCode");
		String noteType        = (String)condition.get("noteType");
		String termType        = (String)condition.get("termType");
		
		
		int day = Integer.parseInt(paramDao.getValueByPath(AppConstants.SENT_ALLDAY));
		
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
		
		String hql = 	" select new CmlSentInfo(" +
							" trans.id," +
							" trans.tranId," +
							" trans.seriaNo," +
							" trans.currency," +
							" trans.denomination," +
							" trans.noteType," +
							" trans.tranDate," +
							" trans.termid," +
							" trans.imageType," +
							" trans.termType," +
							" trans.tranMonthday," +
							" trans.barcodeFlowNum," +
							" trans.pathcode," +
							" trans.noteFlag," +
							" trans.versionNum" +
						" )" +
						" from CmlSentInfo trans" +
						" where trans.tranDate >= '"+DateUtil.parseToString(dStartTime, "yyyyMMddHHmmss")+"'" +
						" and trans.tranDate <= '"+DateUtil.parseToString(dEndTime, "yyyyMMddHHmmss")+"'";
		
		if( seriaNo!=null && !seriaNo.equals(""))
		{
			if( DBDialectHelper.isOracle() )
			{
				hql+=" and trans.seriaNo like '"+seriaNo+"%'";
			}
			else
			{
				hql+=" and trans.seriaNo like '"+seriaNo+"%'";
			}
		}
		if( termId!=null && !"".equals(termId) )
		{
			hql+=" and trans.termid= '"+termId+"'";
		}
		if( pathCode!=null && !pathCode.equals("") )
		{
			hql += " and  trans.pathcode like '" + pathCode + "%'";
		}
		if( null!=noteType && !noteType.equals("") )
		{
			hql += " and trans.noteType =  '" + noteType + "'";
		}
		if( StringUtil.isNotBlank(termType) )
		{
			hql += " and trans.termType =  '" + termType + "'";
		}

		hql += "  order by trans.tranDate desc";
		

		Page pageObject = new Page();
		pageObject = cmlSentInfoDao.findPage(page, hql);
		List<CmlSentInfo> list = new ArrayList<CmlSentInfo>();
		List<CmlSentInfo> li = new ArrayList<CmlSentInfo>();
		li = pageObject.getResult();
		String orgName = null;
		String termTypeName = null;
		for (int i = 0; i < li.size(); i++)
		{
			CmlSentInfo cml = li.get(i);
			termTypeName = cmlSentInfoService.findTermTypeName(cml.getTermId());
			cml.setTypeName(termTypeName);// 终端类型名称赋值
			orgName = tranInfoService.findOrgName(cml.getPathcode());// 机构名称赋值
			cml.setPathcode(orgName);
			list.add(cml);
		}
		pageObject.setResult(list);

		return pageObject;
	}
  
		
	/**
	 * 根据冠字号码交易id查询该笔交易的所有冠字号码信�?
	 */
	@Transactional(readOnly = true)
	public Page getTransAllBanknoteSeqByTranId(Page page, String tranId, String transMonthday)
	{
		String sql = 	" select trans" +
						" from CmlSentInfo trans" +
						" where 1=1" +
						" and trans.tranId = ?";
		Page pageObject = new Page();
		pageObject = cmlSentInfoDao.findPage(page, sql, tranId);
		return pageObject;
	}
}

