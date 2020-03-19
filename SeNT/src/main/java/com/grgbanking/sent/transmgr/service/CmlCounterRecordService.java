package com.grgbanking.sent.transmgr.service;

import java.util.Date;
import java.util.List;
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
import com.grgbanking.sent.transmgr.dao.CmlCounterRecordDao;
import com.grgbanking.sent.transmgr.entity.CmlCounterRecord;
import com.grgbanking.sent.transmgr.entity.TranInfo;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;


@Service
@Transactional
public class CmlCounterRecordService extends BaseService
{
	@Autowired
	private CmlCounterRecordDao cmlCounterRecordDao;
	
	
	@Autowired
	private ParamDao paramDao;
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlCounterRecord> queryCmlCounterRecordPage(Map parameter)
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
		
		Page<CmlCounterRecord> page2 = cmlCounterRecordDao.queryCmlCounterRecordPage(page, condition);
		//this.encryptAccountForCmlCounterRecord(page2.getResult());
		return page2;
	}
	
	/**
	 * 设置交易的帐号加＊号显示
	 */
	private void encryptAccountForCmlCounterRecord(List<CmlCounterRecord> list) {

		for (CmlCounterRecord counterRecord : list) {
			if(counterRecord!=null && counterRecord.getTdAccountNo()!=null && counterRecord.getTdAccountNo().length()>3){
				counterRecord.setTdAccountNo(counterRecord.getTdAccountNo().substring(0, counterRecord.getTdAccountNo().length()-4)+"***"+counterRecord.getTdAccountNo().substring(counterRecord.getTdAccountNo().length()-1));
			}
		}
	}
	
	
	@Transactional(readOnly = true)
	public CmlCounterRecord getCmlCounterRecordDetailById(String id)
	{
		if( id==null )
		{
			return null;
		}
		CmlCounterRecord cmlCounterRecord = cmlCounterRecordDao.get(id);
		if( cmlCounterRecord==null )
		{
			return cmlCounterRecord;
		}
		
		String pathCode = cmlCounterRecord.getPathCode();
		if( pathCode==null )
		{
			return cmlCounterRecord;
		}
		
		OrgInfo orgInfo = orgInfoDao.getByPathCode(pathCode);
		if( orgInfo==null )
		{
			return cmlCounterRecord;
		}
		cmlCounterRecord.setOrgCode(orgInfo.getOrgCode());
		cmlCounterRecord.setPathCodeName(orgInfo.getOrgName());
		cmlCounterRecord.setPathCodeFullName(orgInfo.getOrgFullName());
		cmlCounterRecord.setFinacialCode(orgInfo.getFinacialCode());
		OrgInfo bankInfo = null;
		if( pathCode.length()<=15 )
		{
			//return cmlCounterRecord;
			bankInfo = orgInfo;
		}
		else
		{
			bankInfo = orgInfoDao.getByPathCode(pathCode.substring(0, 15));
		}
		//OrgInfo bankInfo = orgInfoDao.getByPathCode(pathCode.substring(0, 15));
		if( bankInfo==null )
		{
			return cmlCounterRecord;
		}
		cmlCounterRecord.setBankName(bankInfo.getOrgName());
		cmlCounterRecord.setBankFullName(bankInfo.getOrgFullName());
		
		if(cmlCounterRecord!=null && cmlCounterRecord.getTdAccountNo()!=null && cmlCounterRecord.getTdAccountNo().length()>3){
			cmlCounterRecord.setTdAccountNo(cmlCounterRecord.getTdAccountNo().substring(0, cmlCounterRecord.getTdAccountNo().length()-4)+"***"+cmlCounterRecord.getTdAccountNo().substring(cmlCounterRecord.getTdAccountNo().length()-1));
		}
		
		return cmlCounterRecord;
	}
	
//	@Transactional(readOnly = true)
//	public CmlCounterRecord getCmlCounterRecordDetailByTranId(String tranId)
//	{
//		CmlCounterRecord cmlCounterRecord = cmlCounterRecordDao.getByTranId(tranId);
//		if( cmlCounterRecord==null )
//		{
//			return cmlCounterRecord;
//		}
//		
//		String pathCode = cmlCounterRecord.getPathCode();
//		if( pathCode==null )
//		{
//			return cmlCounterRecord;
//		}
//		
//		OrgInfo orgInfo = orgInfoDao.getByPathCode(pathCode);
//		if( orgInfo==null )
//		{
//			return cmlCounterRecord;
//		}
//		cmlCounterRecord.setPathCodeName(orgInfo.getOrgName());
//		cmlCounterRecord.setPathCodeFullName(orgInfo.getOrgFullName());
//		
//		if( pathCode.length()<=15 )
//		{
//			return cmlCounterRecord;
//		}
//		
//		OrgInfo bankInfo = orgInfoDao.getByPathCode(pathCode.substring(0, 15));
//		if( bankInfo==null )
//		{
//			return cmlCounterRecord;
//		}
//		cmlCounterRecord.setBankName(bankInfo.getOrgName());
//		cmlCounterRecord.setBankFullName(bankInfo.getOrgFullName());
//		return cmlCounterRecord;
//	}
}

















