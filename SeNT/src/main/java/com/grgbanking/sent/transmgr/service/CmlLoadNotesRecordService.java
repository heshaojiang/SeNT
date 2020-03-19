package com.grgbanking.sent.transmgr.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.dao.CmlLoadNotesRecordDao;
import com.grgbanking.sent.transmgr.entity.CmlLoadNotesRecord;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;


@Service
@Transactional
public class CmlLoadNotesRecordService extends BaseService
{
	@Autowired
	private CmlLoadNotesRecordDao cmlLoadNotesRecordDao;
	
	
	@Autowired
	private ParamDao paramDao;
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlLoadNotesRecord> queryCmlLoadNotesRecordPage(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		
		String startTime = (String)condition.get("startTime");
		String endTime   = (String)condition.get("endTime");
		
		int days = paramDao.getIntegerValueByPathWithException(AppConstants.CML_TRANSDAY);
		
		Date dStartTime = ServiceValidateHelper.validateQueryStartTime(startTime, "yyyy-MM-dd HH:mm:ss");
		Date dEndTime   = ServiceValidateHelper.validateQueryStartTime(endTime,   "yyyy-MM-dd HH:mm:ss");
		ServiceValidateHelper.validateQueryTimeRange(dStartTime, dEndTime, days);
		
		condition.put("startTime", DateUtil.parseToString(dStartTime, "yyyyMMddHHmmss"));
		condition.put("endTime",   DateUtil.parseToString(dEndTime,   "yyyyMMddHHmmss"));
		
		Page<CmlLoadNotesRecord> page2 = cmlLoadNotesRecordDao.getCmlLoadNotesRecordPage(page, condition);
		return page2;
	}
	
	
	@Transactional(readOnly = true)
	public CmlLoadNotesRecord getCmlLoadNotesRecordDetailById(String id)
	{
		if( id==null )
		{
			return null;
		}
		CmlLoadNotesRecord cmlLoadNotesRecord = cmlLoadNotesRecordDao.get(id);
		if( cmlLoadNotesRecord==null )
		{
			return cmlLoadNotesRecord;
		}
		
		String pathCode = cmlLoadNotesRecord.getPathCode();
		if( pathCode==null )
		{
			return cmlLoadNotesRecord;
		}
		
		OrgInfo orgInfo = orgInfoDao.getByPathCode(pathCode);
		if( orgInfo==null )
		{
			return cmlLoadNotesRecord;
		}
		cmlLoadNotesRecord.setOrgCode(orgInfo.getOrgCode());
		cmlLoadNotesRecord.setPathCodeName(orgInfo.getOrgName());
		cmlLoadNotesRecord.setPathCodeFullName(orgInfo.getOrgFullName());
		cmlLoadNotesRecord.setFinacialCode(orgInfo.getFinacialCode());
		OrgInfo bankInfo = null;
		if( pathCode.length()<=15 )
		{
			//return cmlLoadNotesRecord;
			bankInfo = orgInfo;
		}
		else
		{
			bankInfo = orgInfoDao.getByPathCode(pathCode.substring(0, 15));
		}
		//OrgInfo bankInfo = orgInfoDao.getByPathCode(pathCode.substring(0, 15));
		if( bankInfo==null )
		{
			return cmlLoadNotesRecord;
		}
		cmlLoadNotesRecord.setBankName(bankInfo.getOrgName());
		cmlLoadNotesRecord.setBankFullName(bankInfo.getOrgFullName());
		return cmlLoadNotesRecord;
	}
	
	
//	@Transactional(readOnly = true)
//	public CmlLoadNotesRecord getCmlLoadNotesRecordDetailByTranId(String tranId)
//	{
//		CmlLoadNotesRecord cmlLoadNotesRecord = cmlLoadNotesRecordDao.getByTranId(tranId);
//		if( cmlLoadNotesRecord==null )
//		{
//			return cmlLoadNotesRecord;
//		}
//		
//		String pathCode = cmlLoadNotesRecord.getPathCode();
//		if( pathCode==null )
//		{
//			return cmlLoadNotesRecord;
//		}
//		
//		OrgInfo orgInfo = orgInfoDao.getByPathCode(pathCode);
//		if( orgInfo==null )
//		{
//			return cmlLoadNotesRecord;
//		}
//		cmlLoadNotesRecord.setPathCodeName(orgInfo.getOrgName());
//		cmlLoadNotesRecord.setPathCodeFullName(orgInfo.getOrgFullName());
//		
//		if( pathCode.length()<=15 )
//		{
//			return cmlLoadNotesRecord;
//		}
//		
//		OrgInfo bankInfo = orgInfoDao.getByPathCode(pathCode.substring(0, 15));
//		if( bankInfo==null )
//		{
//			return cmlLoadNotesRecord;
//		}
//		cmlLoadNotesRecord.setBankName(bankInfo.getOrgName());
//		cmlLoadNotesRecord.setBankFullName(bankInfo.getOrgFullName());
//		return cmlLoadNotesRecord;
//	}
}

















