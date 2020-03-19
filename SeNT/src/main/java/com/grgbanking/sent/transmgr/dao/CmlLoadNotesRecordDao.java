package com.grgbanking.sent.transmgr.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.sent.transmgr.entity.CmlLoadNotesRecord;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 
 * @author 广电运通
 */
@Repository
public class CmlLoadNotesRecordDao extends BaseDao<CmlLoadNotesRecord>
{
	

	public Page<CmlLoadNotesRecord> getCmlLoadNotesRecordPage(Page<CmlLoadNotesRecord> page, Map<String, Object> condition)
	{
		String startTime    = (String)condition.get("startTime");
		String endTime      = (String)condition.get("endTime");
		String atmCode      = (String)condition.get("atmCode");
		String operatorCode = (String)condition.get("operatorCode");
		String pathCode     = (String)condition.get("pathCode");
		String flag=(String)condition.get("flag");
		
		
		//判断开始时间不能为空
		if( StringUtil.isBlank(startTime) )
		{
		throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_START_TIME_CANNOT_BE_NULL, "查询开始时间不能为空!");
		}
		//结束时间不能为空
		if( StringUtil.isBlank(endTime) )
		{
		throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_END_TIME_CANNOT_BE_NULL, "查询结束时间不能为空!");
		}
		//定义开始与结束时间
		Date dStartTime = null;
		Date dEndTime = null;
		try
		{
		dStartTime = DateUtil.parseToDate(startTime, "yyyyMMddHHmmss");
		dEndTime = DateUtil.parseToDate(endTime, "yyyyMMddHHmmss");
		}
		catch (Exception e)
		{
		throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG, "查询时间格式不正确["+e.getMessage()+"]");
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
		sb.append("   clnr.partMonthday>='").append(mothStart_).append(dayStart);
		sb.append("' and clnr.partMonthday<='").append(mothEnd_).append(dayEnd).append("'");
		}else if(dStartTime.getYear() < dEndTime.getYear()){
		sb.append("   ( clnr.partMonthday>='").append(mothStart_).append(dayStart);
		sb.append("' or clnr.partMonthday<='").append(mothEnd_).append(dayEnd).append("')");
		}else
		{
		throw new AppPlaceHolderException(MessageKeyConstants.TRANS_MGR_QUERY_TIME_FORMAT_WRONG, "查询时间格式不正确：结束时间大于开始时间");
		}
		String hql = "select clnr from CmlLoadNotesRecord clnr where "+sb.toString();
		
		//String hql = "select clnr from CmlLoadNotesRecord clnr where 1=1";
		List<Object> sqlParams = new ArrayList<Object>();
		
		if( StringUtil.isNotBlank(startTime) )
		{
			hql += " and clnr.tranTime >= ?";
			sqlParams.add(startTime);
		}
		if( StringUtil.isNotBlank(endTime) )
		{
			hql += " and clnr.tranTime <= ?";
			sqlParams.add(endTime);
		}
		if( StringUtil.isNotBlank(atmCode) )
		{
			hql += " and clnr.atmCode = ?";
			sqlParams.add(atmCode);
		}
		if( StringUtil.isNotBlank(operatorCode) )
		{
			hql += " and clnr.operatorCode = ?";
			sqlParams.add(operatorCode);
		}
		if( StringUtil.isNotBlank(pathCode) )
		{
			if(null == flag || flag.equals("true")){
				hql += " and clnr.pathCode like ?";
				sqlParams.add(pathCode+"%");
			}else{
				hql += " and clnr.pathCode = ?";
				sqlParams.add(pathCode+"");
			}
		}
		
		hql += " order by clnr.tranTime desc";
		
		return this.findPage(page, hql, sqlParams.toArray());
	}
	
	
	public CmlLoadNotesRecord getByTranId(String tranId)
	{
		String hql = "select clnr from CmlLoadNotesRecord clnr where clnr.tranId=?";
		return this.findFirst(hql, tranId);
	}
}
