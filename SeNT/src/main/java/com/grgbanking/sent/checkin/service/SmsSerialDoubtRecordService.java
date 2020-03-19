package com.grgbanking.sent.checkin.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.sent.checkin.dao.SmsSerialDoubtRecordDao;
import com.grgbanking.sent.checkin.entity.SmsSerialDoubtRecord;
import com.grgbanking.sent.transmgr.service.ServiceValidateHelper;
import com.grgbanking.sent.utils.StringUtil;

@SuppressWarnings("unchecked")
@Service
@Transactional
public class SmsSerialDoubtRecordService extends BaseService{
	
	@Autowired
	SmsSerialDoubtRecordDao smsSerialDoubtRecordDao ;
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	@Autowired
	SysDatadirService sysDatadirService;
	
	public void addCheckInInfo(Map<String, Object> parameter)
	{
		SmsSerialDoubtRecord info = new SmsSerialDoubtRecord();
		
		info.setOrgCode(StringUtil.trim(parameter.get("orgCode")));
		info.setOrgName(StringUtil.trim(parameter.get("orgName")));
		info.setOrgPathCode(StringUtil.trim(parameter.get("orgPathCode")));
		info.setOperatorId(StringUtil.trim(parameter.get("operatorId")));
		info.setCheckId(StringUtil.trim(parameter.get("checkId")));
		info.setApplyName(StringUtil.trim(parameter.get("applyName")));
		info.setApplyPhone(StringUtil.trim(parameter.get("applyPhone")));
		info.setApplyDate(new Date(StringUtil.trim(parameter.get("applyDate"))));
		info.setSeriaNO(StringUtil.trim(parameter.get("seriaNO")));
		info.setSerialCount(Integer.parseInt(StringUtil.trim(parameter.get("serialCount"))));
		info.setSerialResult(Integer.parseInt(StringUtil.trim(parameter.get("serialResult"))));
		info.setIdentType(Integer.parseInt(StringUtil.trim(parameter.get("identType"))));
		info.setIdentNO(StringUtil.trim(parameter.get("identNO")));
		info.setDepositDate(new Date(StringUtil.trim(parameter.get("depositDate"))));
		info.setDepositBank(StringUtil.trim(parameter.get("depositBank")));
		
		ServiceValidateHelper.validateCommonTime(info.getApplyDate().toString(), "yyyyMMdd",
				MessageKeyConstants.FICI_APPLY_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_APPLY_TIME_FORMAT_WRONG
		);
		ServiceValidateHelper.validateCommonTime(info.getDepositDate().toString(), "yyyyMMdd",
				MessageKeyConstants.FICI_WITHDRAWAL_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_WITHDRAWAL_TIME_FORMAT_WRONG
		);
		
		smsSerialDoubtRecordDao.saveNew(info);
	}
	
	public void updateCheckInInfo(Map<String,Object> parameter)
	{
		SmsSerialDoubtRecord info = new SmsSerialDoubtRecord();
		
		info.setId(StringUtil.trim(parameter.get("id")));
		info.setOrgCode(StringUtil.trim(parameter.get("orgCode")));
		info.setOrgName(StringUtil.trim(parameter.get("orgName")));
		info.setOrgPathCode(StringUtil.trim(parameter.get("orgPathCode")));
		info.setOperatorId(StringUtil.trim(parameter.get("operatorId")));
		info.setCheckId(StringUtil.trim(parameter.get("checkId")));
		info.setApplyName(StringUtil.trim(parameter.get("applyName")));
		info.setApplyPhone(StringUtil.trim(parameter.get("applyPhone")));
		info.setApplyDate(new Date(StringUtil.trim(parameter.get("applyDate"))));
		info.setSeriaNO(StringUtil.trim(parameter.get("seriaNO")));
		info.setSerialCount(Integer.parseInt(StringUtil.trim(parameter.get("serialCount"))));
		info.setSerialResult(Integer.parseInt(StringUtil.trim(parameter.get("serialResult"))));
		info.setIdentType(Integer.parseInt(StringUtil.trim(parameter.get("identType"))));
		info.setIdentNO(StringUtil.trim(parameter.get("identNO")));
		info.setDepositDate(new Date(StringUtil.trim(parameter.get("depositDate"))));
		info.setDepositBank(StringUtil.trim(parameter.get("depositBank")));
		
		ServiceValidateHelper.validateCommonTime(info.getApplyDate().toString(), "yyyyMMdd",
				MessageKeyConstants.FICI_APPLY_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_APPLY_TIME_FORMAT_WRONG
		);
		ServiceValidateHelper.validateCommonTime(info.getDepositDate().toString(), "yyyyMMdd",
				MessageKeyConstants.FICI_WITHDRAWAL_TIME_CANNOT_BE_BLANK,
				MessageKeyConstants.FICI_WITHDRAWAL_TIME_FORMAT_WRONG
		);
		
		smsSerialDoubtRecordDao.update(info);
	}
	
	
	public Page<SmsSerialDoubtRecord> queryFaultCheckInInfoPage(Map<String, Object> parameter) throws Exception
	{
		Page<SmsSerialDoubtRecord> page = (Page)parameter.get("page");
		Map<String,Object> condition = (Map)parameter.get("condition");
		
		String startTime = StringUtil.trim(condition.get("startTime")).replace("-", "");
		String endTime   = StringUtil.trim(condition.get("endTime")).replace("-", "");
		
		ServiceValidateHelper.validateQueryStartTime(startTime, "yyyyMMdd");
		ServiceValidateHelper.validateQueryEndTime(endTime,     "yyyyMMdd");
		
		condition.put("startTime", startTime);
		condition.put("endTime",   endTime);
		
		page = smsSerialDoubtRecordDao.queryFaultCheckInInfoPage(page, condition);
		return page;
	}
	
	
	
	public boolean deleteFaultCheckInInfos(String[] idArr)
	{
		for( String id : idArr )
		{
			smsSerialDoubtRecordDao.delete(id);
		}
		return true;
	}
	
	
}
