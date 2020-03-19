package com.grgbanking.sent.transmgr.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.exception.SimpleAppException;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.security.vo.Loginer;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.constants.CmlBatchRecordConsts;
import com.grgbanking.sent.transmgr.constants.CmlSentInfoConsts;
import com.grgbanking.sent.transmgr.dao.CmlBatchRecordDao;
import com.grgbanking.sent.transmgr.dao.CmlCounterRecordDao;
import com.grgbanking.sent.transmgr.dao.CmlLoadNotesRecordDao;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlBatchRecord;
import com.grgbanking.sent.transmgr.entity.CmlCounterRecord;
import com.grgbanking.sent.transmgr.entity.CmlLoadNotesRecord;
import com.grgbanking.sent.utils.ArrayUtil;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;


@Service
@Transactional
public class CmlBatchRecordService extends BaseService
{
	
	@Autowired
	private CmlBatchRecordDao cmlBatchRecordDao;
	
	@Autowired
	private CmlLoadNotesRecordDao cmlLoadNotesRecordDao;
	
	@Autowired
	private CmlCounterRecordDao cmlCounterRecordDao;
	
	@Autowired
	private CmlSentInfoDao cmlSentInfoDao;
	
	
	@Autowired
	private ParamDao paramDao;
	
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	
	
	@Transactional(readOnly = true)
	public CmlBatchRecord getCmlBatchRecordDetailById(String id)
	{
		CmlBatchRecord cmlBatchRecord = cmlBatchRecordDao.get(id);
		if( cmlBatchRecord==null )
		{
			return cmlBatchRecord;
		}
		
		String pathCode = cmlBatchRecord.getPathCode();
		if( pathCode==null )
		{
			return cmlBatchRecord;
		}
		
		OrgInfo orgInfo = orgInfoDao.getByPathCode(pathCode);
		if( orgInfo==null )
		{
			return cmlBatchRecord;
		}
		cmlBatchRecord.setPathCodeName(orgInfo.getOrgName());
		cmlBatchRecord.setPathCodeFullName(orgInfo.getOrgFullName());
		
		if( pathCode.length()<=15 )
		{
			return cmlBatchRecord;
		}
		
		OrgInfo bankInfo = orgInfoDao.getByPathCode(pathCode.substring(0, 15));
		if( bankInfo==null )
		{
			return cmlBatchRecord;
		}
		cmlBatchRecord.setBankName(bankInfo.getOrgName());
		cmlBatchRecord.setBankFullName(bankInfo.getOrgFullName());
		return cmlBatchRecord;
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlBatchRecord> queryCmlBatchRecordPage(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		
		String startTime = (String)condition.get("startTime");
		String endTime   = (String)condition.get("endTime");
		
		int days = paramDao.getIntegerValueByPathWithException(AppConstants.CML_TRANSDAY);
		
		Date dStartTime = ServiceValidateHelper.validateQueryStartTime(startTime, "yyyy-MM-dd HH:mm:ss");
		Date dEndTime   = ServiceValidateHelper.validateQueryEndTime(endTime,     "yyyy-MM-dd HH:mm:ss");
		ServiceValidateHelper.validateQueryTimeRange(dStartTime, dEndTime, days);
		
		condition.put("startTime", DateUtil.parseToString(dStartTime, "yyyyMMddHHmmss"));
		condition.put("endTime",   DateUtil.parseToString(dEndTime,   "yyyyMMddHHmmss"));
		
		Page<CmlBatchRecord> page2 = cmlBatchRecordDao.queryCmlBatchRecordPage(page, condition);
		return page2;
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlBatchRecord> queryNotBoundTranCmlBatchRecordPage(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		
		String startTime = (String)condition.get("startTime");
		String endTime   = (String)condition.get("endTime");
		
		int days = paramDao.getIntegerValueByPathWithException(AppConstants.CML_TRANSDAY);
		
		Date dStartTime = ServiceValidateHelper.validateQueryStartTime(startTime, "yyyy-MM-dd HH:mm:ss");
		Date dEndTime   = ServiceValidateHelper.validateQueryEndTime(endTime,     "yyyy-MM-dd HH:mm:ss");
		ServiceValidateHelper.validateQueryTimeRange(dStartTime, dEndTime, days);
		
		condition.put("startTime", DateUtil.parseToString(dStartTime, "yyyyMMddHHmmss"));
		condition.put("endTime",   DateUtil.parseToString(dEndTime,   "yyyyMMddHHmmss"));
		
		Page<CmlBatchRecord> page2 = cmlBatchRecordDao.queryNotBoundTranCmlBatchRecordPage(page, condition);
		return page2;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Integer setCmlBatchRecordsToCmlLoadNotesRecord(Map parameter)
	{
		String[] batchIdArr = ArrayUtil.toStringArray(parameter.get("batchIdArr"));
		String atmNum       = StringUtil.trim((String)parameter.get("atmNum"));
		String cashBoxNum   = StringUtil.trim((String)parameter.get("cashBoxNum"));
		String tranTime     = StringUtil.trim((String)parameter.get("tranTime"));
		String type         = StringUtil.trim((String)parameter.get("type"));
		
		if( batchIdArr.length==0 )
		{
			throw new SimpleAppException("batchIdArr's length is 0.");
		}
		if( StringUtil.isBlank(atmNum) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.BATCH_MGR_PLEASE_INPUT_ATM_NUM, "请输入'ATM号'");
		}
//		if( StringUtil.isBlank(cashBoxNum) )
//		{
//			throw new AppPlaceHolderException(MessageKeyConstants.BATCH_MGR_PLEASE_INPUT_CASHBOX_NUM, "请输入'钞箱号'");
//		}
		if( StringUtil.isBlank(type) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.BATCH_MGR_PLEASE_SELECT_BUSINESS_TYPE, "请选择'业务类别'");
		}
		
		Integer iType = Integer.valueOf(type);
		
		Date dTranTime = ServiceValidateHelper.validateTranTime(tranTime, "yyyy-MM-dd HH:mm:ss");
		tranTime = DateUtil.parseToString(dTranTime, "yyyyMMddHHmmss");
		
		
		// 添加“atm加钞交易”记录
		CmlLoadNotesRecord cmlLoadNotesRecord = new CmlLoadNotesRecord();
		cmlLoadNotesRecordDao.saveNew(cmlLoadNotesRecord);	// 为了生成id
		
		BigDecimal totalAmount = BigDecimal.valueOf(0);
		int doneCnt = 0;
		for( String batchId : batchIdArr )
		{
			if( StringUtil.isBlank(batchId) )
			{
				continue;
			}
			
			CmlBatchRecord cmlBatchRecord = cmlBatchRecordDao.get(batchId);
			if( cmlBatchRecord==null )
			{
				continue;
			}
			if( StringUtil.isNotBlank(cmlBatchRecord.getTranId()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.BATCH_MGR_BATCH_BOUND_ALREADY, "batch[%s] bound already", batchId);
			}
			
			cmlBatchRecord.setTranType(CmlBatchRecordConsts.TRAN_TYPE_CML_LOAD_NOTES_RECORD);	// 加钞交易
			cmlBatchRecord.setTranId(cmlLoadNotesRecord.getId());
			
			if( cmlBatchRecord.getTotalAmount()!=null )
			{
				totalAmount = totalAmount.add(cmlBatchRecord.getTotalAmount());
			}
			
			// 修改冠字号的类别为“4”（加钞交易）
			cmlSentInfoDao.updateTermTypeByTranId(batchId, CmlSentInfoConsts.TERM_TYPE_CML_LOAD_NOTES_RECORD);
			
			doneCnt++;
		}
		
		if( doneCnt==0 )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.BATCH_MGR_BATCH_BOUND_FAIL, "bound fail");
		}
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		String userCode = (String)userInfo.get("userCode");
		String orgId    = (String)userInfo.get("orgId");
		String pathCode = orgInfoDao.getPathCodeById(orgId);
		
		// 修改交易的属性
		cmlLoadNotesRecord.setOperatorCode(userCode);
		cmlLoadNotesRecord.setTranTime(tranTime);
		cmlLoadNotesRecord.setTranAmount(totalAmount);
		cmlLoadNotesRecord.setAtmCode(atmNum);
		cmlLoadNotesRecord.setCashboxCode(cashBoxNum);
		cmlLoadNotesRecord.setType(iType);
		cmlLoadNotesRecord.setPathCode(pathCode);
		
		return doneCnt;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Integer setCmlBatchRecordsToCmlCounterRecord(Map parameter)
	{
		String[] batchIdArr = ArrayUtil.toStringArray(parameter.get("batchIdArr"));
		String account      = StringUtil.trim((String)parameter.get("account"));
		String userCardId   = StringUtil.trim((String)parameter.get("userCardId"));
		String journalNo    = StringUtil.trim((String)parameter.get("journalNo"));
		String tranTime     = StringUtil.trim((String)parameter.get("tranTime"));
		String businessType = StringUtil.trim((String)parameter.get("businessType"));
		
		if( batchIdArr.length==0 )
		{
			throw new SimpleAppException("batchIdArr's length is 0.");
		}
		if( StringUtil.isBlank(account) && StringUtil.isBlank(userCardId) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.BATCH_MGR_PLEASE_INPUT_ACCOUNT_OR_ID_CARD, "请输入'帐号'或'身份证'");
		}
		if( StringUtil.isBlank(businessType) )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.BATCH_MGR_PLEASE_SELECT_BUSINESS_TYPE, "请选择'业务类型'");
		}
		
		Integer iBusinessType = Integer.valueOf(businessType);
		
		Date dTranTime = ServiceValidateHelper.validateTranTime(tranTime, "yyyy-MM-dd HH:mm:ss");
		tranTime = DateUtil.parseToString(dTranTime, "yyyyMMddHHmmss");
		
		// 添加“atm加钞交易”记录
		CmlCounterRecord cmlCounterRecord = new CmlCounterRecord();
		cmlCounterRecordDao.saveNew(cmlCounterRecord);	// 为了生成id
		
		BigDecimal totalAmount = BigDecimal.valueOf(0);
		int doneCnt = 0;
		for( String batchId : batchIdArr )
		{
			if( StringUtil.isBlank(batchId) )
			{
				continue;
			}
			
			CmlBatchRecord cmlBatchRecord = cmlBatchRecordDao.get(batchId);
			if( cmlBatchRecord==null )
			{
				continue;
			}
			if( StringUtil.isNotBlank(cmlBatchRecord.getTranId()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.BATCH_MGR_BATCH_BOUND_ALREADY, "batch[%s] bound already", batchId);
			}
			
			cmlBatchRecord.setTranType(CmlBatchRecordConsts.TRAN_TYPE_CML_COUNTER_RECORD);	// 柜面交易
			cmlBatchRecord.setTranId(cmlCounterRecord.getId());
			
			if( cmlBatchRecord.getTotalAmount()!=null )
			{
				totalAmount = totalAmount.add(cmlBatchRecord.getTotalAmount());
			}
			
			// 修改冠字号的类别为“5”（柜台交易）
			cmlSentInfoDao.updateTermTypeByTranId(batchId, CmlSentInfoConsts.TERM_TYPE_CML_COUNTER_RECORD);
			
			doneCnt++;
		}
		
		
		if( doneCnt==0 )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.BATCH_MGR_BATCH_BOUND_FAIL, "bound fail");
		}
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		String userCode = (String)userInfo.get("userCode");
		String orgId    = (String)userInfo.get("orgId");
		String pathCode = orgInfoDao.getPathCodeById(orgId);
		
		// 修改交易的属性
		cmlCounterRecord.setTdOperatorId(userCode);
		cmlCounterRecord.setTdAccountNo(account);
		cmlCounterRecord.setCardId(userCardId);
		cmlCounterRecord.setTdJournalNo(journalNo);
		cmlCounterRecord.setTranTime(tranTime);
		cmlCounterRecord.setStatisAtm(totalAmount);
		cmlCounterRecord.setBusinessType(iBusinessType);
		cmlCounterRecord.setPathCode(pathCode);
		
		return doneCnt;
	}
	
	
	@SuppressWarnings("unchecked")
	public Page<CmlBatchRecord> getCmlBatchRecordPageByTranId(Map parameter)
	{
		Page page     = (Page)parameter.get("page");
		String tranId = (String)parameter.get("tranId");
		return cmlBatchRecordDao.getCmlBatchRecordPageByTranId(page, tranId);
	}
}

















