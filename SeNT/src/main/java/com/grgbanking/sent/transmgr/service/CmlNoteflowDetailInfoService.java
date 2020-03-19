package com.grgbanking.sent.transmgr.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.exception.AppPlaceHolderException;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.security.vo.Loginer;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.cashbox.dao.BoxInfoDao;
import com.grgbanking.platform.module.cashbox.entity.BoxInfo;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.term.dao.TermInfoDao;
import com.grgbanking.platform.module.term.entity.TermInfo;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.constants.BoxInfoConsts;
import com.grgbanking.sent.transmgr.constants.CmlNoteflowDetailInfoConsts;
import com.grgbanking.sent.transmgr.constants.CmlNoteflowInfoConsts;
import com.grgbanking.sent.transmgr.dao.BarcodeInCashboxDao;
import com.grgbanking.sent.transmgr.dao.CmlCounterRecordDao;
import com.grgbanking.sent.transmgr.dao.CmlLoadNotesRecordDao;
import com.grgbanking.sent.transmgr.dao.CmlNoteflowDetailInfoDao;
import com.grgbanking.sent.transmgr.dao.CmlNoteflowInfoDao;
import com.grgbanking.sent.transmgr.entity.BarcodeInCashbox;
import com.grgbanking.sent.transmgr.entity.CmlCounterRecord;
import com.grgbanking.sent.transmgr.entity.CmlLoadNotesRecord;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowDetailInfo;
import com.grgbanking.sent.transmgr.entity.CmlNoteflowInfo;
import com.grgbanking.sent.utils.ArrayUtil;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.StringUtil;


@Service
@Transactional
public class CmlNoteflowDetailInfoService extends BaseService
{
	
	@Autowired
	private CmlNoteflowDetailInfoDao cmlNoteflowDetailInfoDao;
	
	
	@Autowired
	CmlNoteflowInfoDao cmlNoteflowInfoDao;
	
	
	@Autowired
	BoxInfoDao boxInfoDao;
	
	@Autowired
	BarcodeInCashboxDao barcodeInCashboxDao;
	
	
	@Autowired
	OrgInfoDao orgInfoDao;
	
	
	@Autowired
	TermInfoDao termInfoDao;
	
	@Autowired
	private ParamDao paramDao;
	
	@Autowired
	private CmlLoadNotesRecordDao cmlLoadNotesRecordDao;
	
	@Autowired
	private CmlCounterRecordDao cmlCounterRecordDao;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlNoteflowDetailInfo> getCmlNoteflowDetailInfosPageByFlowNum(Map<String, Object> parameter)
	{
		Page page = (Page)parameter.get("page");
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		
		String barcodeFlowNum = StringUtil.trim(condition.get("barcodeFlowNum"));
		
		Page<CmlNoteflowDetailInfo> page2 = cmlNoteflowDetailInfoDao.getCmlNoteflowDetailInfosPageByFlowNum(page, barcodeFlowNum);
		if(page2 != null ){
			List<CmlNoteflowDetailInfo> flowLst = page2.getResult();
			for(CmlNoteflowDetailInfo info:flowLst){
				OrgInfo orgInfo = orgInfoDao.getByPathCode(info.pathCode);
				if(orgInfo!=null){
				info.setPathCode(orgInfo.getOrgName());
				}
				//大额取款屏蔽卡号
				if(info!=null && CmlNoteflowDetailInfoConsts.FLOW_STAGE_LARGE_WITHDRAW.equals(info.getFlowStage()) && info.getBarcode1()!=null && info.getBarcode1().length()>3){
					info.setBarcode1(info.getBarcode1().substring(0, info.getBarcode1().length()-4)+"***"+info.getBarcode1().substring(info.getBarcode1().length()-1));
				}
			}
		}
		
		return page2;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlNoteflowInfo> getCmlNoteflowDetailInfosInBoxInfoPageByFlowNum(Map<String, Object> parameter)
	{
		Page page = (Page)parameter.get("page");
		Map<String, Object> condition = (Map<String, Object>)parameter.get("condition");
		
		String barcodeFlowNum = StringUtil.trim(condition.get("barcodeFlowNum"));
		
		Page<CmlNoteflowInfo> page2 = cmlNoteflowInfoDao.getCmlNoteflowDetailInfosInBoxInfoPageByFlowNum(page, barcodeFlowNum);
		if(page2 != null ){
			List<CmlNoteflowInfo> flowLst = page2.getResult();
			for(CmlNoteflowInfo info:flowLst){
				OrgInfo orgInfo = orgInfoDao.getByPathCode(info.pathCode);
				info.setPathCode(orgInfo.getOrgName());
			}
		}
		
		return page2;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlNoteflowDetailInfo> getCashboxFlowInfoByBoxNum(Map<String, Object> parameter)
	{
		Page page = (Page)parameter.get("page");
		String boxNum = (String)parameter.get("boxNum");
		
		Page<CmlNoteflowDetailInfo> page2 = cmlNoteflowDetailInfoDao.getAllFlowDetailInfoByCashboxNum(page, boxNum);
		return page2;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlNoteflowDetailInfo> queryCmlNoteflowDetailInfoPage(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		Map condition = (Map)parameter.get("condition");
		
		String orgId = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		Page<CmlNoteflowDetailInfo> page2 = cmlNoteflowDetailInfoDao.queryCmlNoteflowDetailInfoPage(page, condition);
		return page2;
	}
	
	/**
	 * 获取条码长度
	 */
	public String getBarcodeFlowNumLength(String param){
		String barcodeFlowNumLength = paramDao.getValueByPath(AppConstants.BARCODE_FLOW_NUMBER_LENGTH);
		if(barcodeFlowNumLength == null)
			return "20";
		return barcodeFlowNumLength;
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlNoteflowDetailInfo> queryCmlNoteflowDetailInfoPageAndBoxInfo(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		Map condition = (Map)parameter.get("condition");
		
		String orgId = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		Page<CmlNoteflowDetailInfo> page2 = cmlNoteflowDetailInfoDao.queryCmlNoteflowDetailInfoPageAndBoxInfo(page, condition);
		return page2;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlNoteflowDetailInfo> queryATMAddCashInfoPage(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		Map condition = (Map)parameter.get("condition");
		
		String orgId = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		Page<CmlNoteflowDetailInfo> page2 = cmlNoteflowDetailInfoDao.queryATMAddCashInfoPage(page, condition);
		return page2;
	}
	
	
//	@SuppressWarnings("unchecked")
//	@Transactional(readOnly = true)
//	public Page<CmlNoteflowDetailInfo> queryCmlNoteflowDetailInfoPage(Page page, Map condition)
//	{
//		String orgId = (String)condition.get("orgId");
//		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
//		{
//			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
//		}
//		Page<CmlNoteflowDetailInfo> page2 = cmlNoteflowDetailInfoDao.queryCmlNoteflowDetailInfoPage(page, condition);
//		return page2;
//	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Page<CmlNoteflowDetailInfo> queryOperDetailInfoPage(Map parameter)
	{
		Page page = (Page)parameter.get("page");
		Map condition = (Map)parameter.get("condition");
		
		String orgId = (String)condition.get("orgId");
		if( StringUtils.isBlank(orgId)==false && condition.containsKey("pathCode")==false )
		{
			condition.put("pathCode", orgInfoDao.getPathCodeById(orgId));
		}
		
		Page<CmlNoteflowDetailInfo> page2 = cmlNoteflowDetailInfoDao.queryOperDetailInfoPage(page, condition);
		return page2;
	}
	
	/**
	 * 配钞
	 */
	@Transactional
	public Integer addMiltiCashDistribution(Map<Object, Object> data)
	{
		String flowStage = (String)data.get("flowStage");
		String cashboxNum = (String)data.get("cashboxNum");
		String[] barcodeFlowNumArr = ArrayUtil.toStringArray(data.get("barcodeFlowNumArr"));
		
		
		BoxInfo box = boxInfoDao.getByBoxNum(cashboxNum);
		if( box==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_IS_NOT_EXISTING, "钞箱[%s]不存在", cashboxNum);
		}
		
		// 判断钞箱的类型：ATM钞箱配钞
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_ATMBOX.equals(flowStage))
		{
			if( BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_CASHBOX, "[%s]不是ATM钞箱", cashboxNum);
			}
		}
		// 判断钞箱的类型：款箱钞袋配钞
		else if(CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_CASHBOX.equals(flowStage))
		{
			if( BoxInfoConsts.TYPE_BRANCH_KXCASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_KXCASHBOX, "[%s]不是款箱钞袋", cashboxNum);
			}
		}
		
		else
		{
			throw new IllegalArgumentException("wrong flowStage: "+flowStage);
		}
		
		if(!CmlNoteflowDetailInfoConsts.BOX_INFO_STATUS_ENBALE.equals(box.getBoxStatus())){
			
			throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_IS_NOT_ENABLE, "[%s]不是启用状态", cashboxNum);
		}
		Boolean isNotFlowing = CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_CASHBOX.equals(box.getUsageStatus())
		||CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_ATMBOX.equals(box.getUsageStatus())
		||CmlNoteflowDetailInfoConsts.BOX_INFO_INITIAL.equals(box.getUsageStatus());
		if(!isNotFlowing){
		throw new AppPlaceHolderException(MessageKeyConstants.CASHBOX_ISNOT_FLOWING, "钞箱[%s]不是初始状态或配钞状态", cashboxNum);
		}	
		
		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		for( String barcodeFlowNum : barcodeFlowNumArr )
		{
			CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
			
			// 判断该流转条码是否存在
			if( cmlNoteflowInfo==null )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
			}
			
			// 判断条码的状态
			if( CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED.equals(cmlNoteflowInfo.getBarcodeStatus()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_FINISHED_ALREADY, "流转条码[%s]状态已经结束", barcodeFlowNum);
			}
			if( CmlNoteflowInfoConsts.BARCODE_STATUS_ERROR.equals(cmlNoteflowInfo.getBarcodeStatus()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_ERROR, "流转条码[%s]状态是异常,请检查.", barcodeFlowNum);
			}
			
			// 判断条码是否在钞箱里面
			BarcodeInCashbox bic = barcodeInCashboxDao.findByBarcodeFlowNum(barcodeFlowNum);
			if( bic!=null )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_DIST_CASH_ALREADY, "流转条码[%s]已经配钞", barcodeFlowNum);
			}
			
			// 将条码放进钞箱
			barcodeInCashboxDao.addNew(cashboxNum, barcodeFlowNum);
			
			// 保存配钞的数据
			CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
			cnfd.setBarcodeFlowNum(barcodeFlowNum);
			cnfd.setBarcode1(cashboxNum);
			//cnfd.setBarcode2(cashboxNum);
			cnfd.setFlowStage(flowStage);
			cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);	// 流转未结束
			cnfd.setOperator(loginer.getUsername());
			cnfd.setDate(operDate);
			cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
			cmlNoteflowDetailInfoDao.saveNew(cnfd);
			
			// 修改对应流转主表的状态
			cmlNoteflowInfo.setFlowStage(flowStage);
			cmlNoteflowInfoDao.save(cmlNoteflowInfo);
			
			n++;
		}
		
		// 修改钞箱的状态
		box.setUsageStatus(flowStage);
		boxInfoDao.save(box);
		
		return n;
	}
	
	
	/**
	 * 在行ATM加钞
	 */
	@Transactional
	public Integer addMiltiAddCashAtBranch(Map<Object, Object> data)
	{
		String flowStage = (String)data.get("flowStage");
		String cashboxNum = (String)data.get("cashboxNum");
		String atmNum = (String)data.get("atmNum");
		String[] barcodeFlowNumArr = ArrayUtil.toStringArray(data.get("barcodeFlowNumArr"));
		
		BoxInfo box = boxInfoDao.getByBoxNum(cashboxNum);
		if( box==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_IS_NOT_EXISTING, "钞箱[%s]不存在", cashboxNum);
		}
		
		// 判断钞箱的类型：在行ATM加钞
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_ATM_ADD_CASH.equals(flowStage) )
		{
			if( BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_CASHBOX, "[%s]不是ATM钞箱", cashboxNum);
			}
			TermInfo termInfo = termInfoDao.getByTermCode(atmNum);
			if( termInfo==null )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_ATM_IS_NOT_EXISTING, "ATM[%s]不存在", atmNum);
			}
		}
		else
		{
			throw new IllegalArgumentException("wrong flowStage: "+flowStage);
		}
		
		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		for( String barcodeFlowNum : barcodeFlowNumArr )
		{
			CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
			
			// 判断该流转条码是否存在
			if( cmlNoteflowInfo==null )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
			}
			
			// 判断条码的状态
			if( CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED.equals(cmlNoteflowInfo.getBarcodeStatus()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_FINISHED_ALREADY, "流转条码[%s]状态已经结束", barcodeFlowNum);
			}
			
			// 保存配钞的数据
			CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
			cnfd.setBarcodeFlowNum(barcodeFlowNum);
			cnfd.setBarcode1(cashboxNum);
			cnfd.setBarcode2(atmNum);
			cnfd.setFlowStage(flowStage);
			cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转已结束
			cnfd.setOperator(loginer.getUsername());
			cnfd.setDate(operDate);
			cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
			cmlNoteflowDetailInfoDao.saveNew(cnfd);
			
			// 修改对应流转主表的状态
			cmlNoteflowInfo.setBarcodeStatus(CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED);
			cmlNoteflowInfo.setFlowStage(flowStage);
			cmlNoteflowInfoDao.save(cmlNoteflowInfo);
			
			n++;
		}
		
		// 修改钞箱的状态
		box.setUsageStatus(flowStage);
		boxInfoDao.save(box);
		
		return n;
	}
	
	/**
	 * 支付给柜员
	 */
	@Transactional
	public Integer addMiltiPayToCounter(Map<Object, Object> data)
	{
		String flowStage = (String)data.get("flowStage");
		String payToCounter = (String)data.get("payToCounter");
		String[] barcodeFlowNumArr = ArrayUtil.toStringArray(data.get("barcodeFlowNumArr"));
		
		// 判断所处阶段：支付给柜员
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_PAY_TO_COUNTER.equals(flowStage)==false )
		{
			throw new IllegalArgumentException("wrong flowStage: "+flowStage);
		}
		
		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		for( String barcodeFlowNum : barcodeFlowNumArr )
		{
			CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
			
			// 判断该流转条码是否存在
			if( cmlNoteflowInfo==null )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
			}
			
			// 判断条码的状态
			if( CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED.equals(cmlNoteflowInfo.getBarcodeStatus()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_FINISHED_ALREADY, "流转条码[%s]状态已经结束", barcodeFlowNum);
			}
			
			// 保存配钞的数据
			CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
			cnfd.setBarcodeFlowNum(barcodeFlowNum);
			cnfd.setBarcode1(payToCounter);
			cnfd.setFlowStage(flowStage);
			cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);	// 流转未结束，表示还可以转交给其它的柜员
			cnfd.setOperator(loginer.getUsername());
			cnfd.setDate(operDate);
			cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
			cmlNoteflowDetailInfoDao.saveNew(cnfd);
			
			// 修改对应流转主表的状态
			cmlNoteflowInfo.setBarcodeStatus(CmlNoteflowInfoConsts.BARCODE_STATUS_NORNAL);
			cmlNoteflowInfo.setFlowStage(flowStage);
			cmlNoteflowInfoDao.save(cmlNoteflowInfo);
			
			n++;
		}
		
		return n;
	}
	
	
	/**
	 * 增加多个ATM加钞 
	 */
	@Transactional
	public Integer addMiltiAtmAddCash(Map<Object, Object> data)
	{		
		String atmNum = (String)data.get("atmNum");
		String[] cashboxNumArr = ArrayUtil.toStringArray(data.get("cashboxNumArr"));
		
		TermInfo termInfo = termInfoDao.getByTermCode(atmNum);
		if( termInfo==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_ATM_IS_NOT_EXISTING, "ATM[%s]不存在", atmNum);
		}
		
		
		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		
		Integer n = 0;
		for( String cashboxNum : cashboxNumArr )
		{
			BoxInfo box = boxInfoDao.getByBoxNum(cashboxNum);
			if( box==null )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_IS_NOT_EXISTING, "钞箱[%s]不存在", cashboxNum);
			}
			if( BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_CASHBOX, "[%s]不是ATM钞箱", cashboxNum);
			}
			
			
			if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_CASHBOX.equals(box.getUsageStatus())|| CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_ADD_CASH.equals(box.getUsageStatus())|| CmlNoteflowDetailInfoConsts.BOX_INFO_INITIAL.equals(box.getUsageStatus()))
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_STATUS_IS_NOT_ATM_DELIVERY, "[%s]状态不是ATM钞箱配钞,出库或入库", cashboxNum);
			}
			
			String[] flowStages = {CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_ATMBOX};
			List<CmlNoteflowDetailInfo> noteflowDetailList = cmlNoteflowDetailInfoDao.getFlowDetailListByCashboxNumAndFlowStages(cashboxNum,flowStages);
			for( CmlNoteflowDetailInfo noteflowDetail : noteflowDetailList )
			{
				noteflowDetail.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转结束
				cmlNoteflowDetailInfoDao.save(noteflowDetail);
			}
			
			// 获取钞箱内的捆钞
			List<BarcodeInCashbox> bicList = barcodeInCashboxDao.findByBoxNum(cashboxNum);
			if( bicList.size()==0 )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_IS_NOT_FLOWING, "钞箱[%s]尚未配钞", cashboxNum);
			}
			
			// 插入数据库
			for( BarcodeInCashbox bic : bicList )
			{
				// 将捆钞加入atm
				CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
				cnfd.setBarcodeFlowNum(bic.getBarcodeFlowNum());
				cnfd.setBarcode1(bic.getBoxNum());
				cnfd.setBarcode2(atmNum);
				cnfd.setFlowStage(CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_ADD_CASH);	// ATM加钞
				cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转结束
				cnfd.setOperator(loginer.getUsername());
				cnfd.setDate(operDate);
				cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
				cmlNoteflowDetailInfoDao.saveNew(cnfd);
				
				// 修改这个流转号的所处阶段
				CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao.getByBarcodeFlowNum(bic.getBarcodeFlowNum());
				cmlNoteflowInfo.setBarcodeStatus(CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED);
				cmlNoteflowInfo.setFlowStage(CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_ADD_CASH);
				cmlNoteflowInfoDao.save(cmlNoteflowInfo);
				
				// 更新这个流转号的状态为已经结束
				cmlNoteflowDetailInfoDao.updateDetailStatusByBarcodeFlowNum(bic.getBarcodeFlowNum(), CmlNoteflowDetailInfoConsts.STATUS_FINISHED);
				
				
				// 添加"atm加钞交易"记录
				CmlLoadNotesRecord cmlLoadNotesRecord = new CmlLoadNotesRecord();
				// 设置交易的属性
				
				cmlLoadNotesRecord.setId(cmlNoteflowInfo.getId());//跟流转信息表的ID保持一致,才能找到FSN文件
				cmlLoadNotesRecord.setOperatorCode(loginer.getUsername());
				cmlLoadNotesRecord.setTranTime(cmlNoteflowInfo.getClearingDate());
				cmlLoadNotesRecord.setTranDate(cmlNoteflowInfo.getClearingDate().substring(0, 8));
				cmlLoadNotesRecord.setTranCount(new BigDecimal(cmlNoteflowInfo.getNoteCount()));
				cmlLoadNotesRecord.setTranAmount(cmlNoteflowInfo.getStatisAmt());
				cmlLoadNotesRecord.setAtmCode(atmNum);
				cmlLoadNotesRecord.setTermCode(atmNum);
				cmlLoadNotesRecord.setCashboxCode(cashboxNum);
				cmlLoadNotesRecord.setType(1);//没办法判断,跟SeNTServer一致，写死先
				cmlLoadNotesRecord.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
				cmlLoadNotesRecord.setOperType(0);//加钞
				cmlLoadNotesRecord.setPartMonthday(cmlNoteflowInfo.getClearingDate().substring(4, 8));//分区月日
				
				cmlLoadNotesRecordDao.saveNew(cmlLoadNotesRecord);
				
				
				
				
				n++;
			}
			
			// 修改钞箱的状态
			box.setUsageStatus(CmlNoteflowDetailInfoConsts.BOX_INFO_INITIAL);
			boxInfoDao.save(box);
			
			// 接收完以后可以认为捆钞已经不在钞箱里面了
			barcodeInCashboxDao.deleteByBoxNum(cashboxNum);
			
		}
		
			
		
		return n;
	}
	
	
	/**
	 * 钞箱配送（款箱配送、钞袋配送）
	 */
	@Transactional
	public Integer addMiltiCashBoxDelivery(Map<Object, Object> data)
	{
		String flowStage = (String)data.get("flowStage");
		String cashboxNum = (String)data.get("cashboxNum");
		
		
		if( cashboxNum==null )
		{
			throw new IllegalArgumentException("cashboxNum is null");
		}
		
		BoxInfo box = boxInfoDao.getByBoxNum(cashboxNum);
		if( box==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_IS_NOT_EXISTING, "钞箱[%s]不存在", cashboxNum);
		}
		
		// 如果是钞箱配送
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_CASH_BOX.equals(flowStage) )
		{
			// 先注释这个判断的功能，以后可能会加上
			if( BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_CASHBOX, "[%s]不是ATM钞箱", cashboxNum);
			}
		}
		// 如果是款箱配送
		else if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_KXCASH_BOX.equals(flowStage) )
		{
			// 先注释这个判断的功能，以后可能会加上
			if( BoxInfoConsts.TYPE_BRANCH_KXCASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_KXCASHBOX, "[%s]不是网点款箱", cashboxNum);
			}
		}
		
		// 如果是网点款箱上缴
		else if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_KXCASHBOX_RETURN.equals(flowStage) )
		{
			// 先注释这个判断的功能，以后可能会加上
			if( BoxInfoConsts.TYPE_BRANCH_KXCASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_KXCASHBOX, "[%s]不是网点款箱", cashboxNum);
			}
		}
		// 如果是atm钞箱回笼
		else if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_CASHBOX_RETURN.equals(flowStage) )
		{
			// 先注释这个判断的功能，以后可能会加上
			if( BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_CASHBOX, "[%s]不是ATM钞箱", cashboxNum);
			}
		}
		else
		{
			throw new RuntimeException("wrong flowStage: "+flowStage);
		}
		
		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		
		// 如果是钞箱配送、款箱配送、钞袋配送、网点款箱上缴(内有捆钞)
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_CASH_BOX.equals(flowStage) ||
			CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_KXCASH_BOX.equals(flowStage) ||
			CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_CASH_BAG.equals(flowStage) ||
			CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_KXCASHBOX_RETURN.equals(flowStage) )
		{
			//List<CmlNoteflowDetailInfo> noteflowDetailList = cmlNoteflowDetailInfoDao.getFlowingBunchesListByCashboxNum(cashboxNum);
			List<BarcodeInCashbox> bicList = barcodeInCashboxDao.findByBoxNum(cashboxNum);
			if( bicList.size()==0 )
			{
				if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_CASH_BOX.equals(flowStage) )
				{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_CONTAIN_NOT_FLOWNUM, "钞箱[%s]尚未配钞", cashboxNum);
				}
				else if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_KXCASH_BOX.equals(flowStage) )
				{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_KXCASHBOX_CONTAIN_NOT_FLOWNUM, "款箱[%s]尚未配钞", cashboxNum);
				}
				else if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_CASH_BAG.equals(flowStage) )
				{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBAG_CONTAIN_NOT_FLOWNUM, "钞袋[%s]尚未配钞", cashboxNum);
				}	
				else if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_KXCASHBOX_RETURN.equals(flowStage) )
				{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_KXCASHBOX_CONTAIN_NOT_FLOWNUM, "款箱[%s]尚未配钞", cashboxNum);
				}
				else
				{
					throw new RuntimeException("wrong flowStage: "+flowStage);
				}
			}
			
			
			for( BarcodeInCashbox bic : bicList )
			{
				String barcodeFlowNum = bic.getBarcodeFlowNum();
				
				if( cmlNoteflowInfoDao.isExistsByBarcodeFlowNum(barcodeFlowNum)==false )
				{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
				}

				// 保存钞箱配送的信息
				CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
				cnfd.setBarcodeFlowNum(barcodeFlowNum);
				cnfd.setBarcode1(cashboxNum);
				cnfd.setFlowStage(flowStage);
				cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);	// 流转未结束
				cnfd.setOperator(loginer.getUsername());
				cnfd.setDate(operDate);
				cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
				cmlNoteflowDetailInfoDao.saveNew(cnfd);
				
				// 更新流转主表的所处阶段
				CmlNoteflowInfo cnf = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
				cnf.setFlowStage(flowStage);
				cmlNoteflowInfoDao.save(cnf);
				
				// 如果是人行钞袋配送的话，一旦配送，流转即表完成
				if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_CASH_BAG.equals(flowStage) )
				{
					// 更新这个流转号的状态为已经结束
					cmlNoteflowDetailInfoDao.updateDetailStatusByBarcodeFlowNum(barcodeFlowNum, CmlNoteflowDetailInfoConsts.STATUS_FINISHED);
				}
				
				n++;
			}
		}
		else	// atm钞箱回笼(内无捆钞)
		{
			// 如果是atm钞箱回笼
			String atmNum = null;
			if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_ATM_CASHBOX_RETURN.equals(flowStage) )
			{
				// 获取atm加钞或者在行atm加钞的详细信息
				CmlNoteflowDetailInfo cmlNoteflowDetailInfo = cmlNoteflowDetailInfoDao.getOneFlowingLatestAddCashRecordByCashboxNum(cashboxNum);
				if( cmlNoteflowDetailInfo!=null )
				{
					atmNum = cmlNoteflowDetailInfo.getBarcode2();
				}
			}
			
			// 保存钞箱配送的信息
			CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
			cnfd.setBarcodeFlowNum(null);
			cnfd.setBarcode1(cashboxNum);
			cnfd.setBarcode2(atmNum);
			cnfd.setFlowStage(flowStage);
			cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);	// 流转未结束
			cnfd.setOperator(loginer.getUsername());
			cnfd.setDate(operDate);
			cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
			cmlNoteflowDetailInfoDao.saveNew(cnfd);
			
			n++;
		}
		
		// 修改钞箱的状态
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVERY_CASH_BAG.equals(flowStage) )
		{	// 如果是人行钞袋配送的话，一旦配送，流转即表完成，钞袋马上置为空闲
			box.setUsageStatus(BoxInfoConsts.USAGE_STATUS_FREE);
			boxInfoDao.save(box);
		}
		else
		{
			box.setUsageStatus(flowStage);
			boxInfoDao.save(box);
		}
		
		return n;
	}
	
	
	/**
	 * 出库管理（行内出库、同业出库）
	 */
	@Transactional
	public Integer addCashBoxOutOfBranch(Map<Object, Object> data)
	{
		String flowStage = (String)data.get("flowStage");
		String cashboxNum = (String)data.get("cashboxNum");
		String orgId = (String)data.get("orgid");
		
		if( cashboxNum==null )
		{
			throw new IllegalArgumentException("cashboxNum is null");
		}
		
		BoxInfo box = boxInfoDao.getByBoxNum(cashboxNum);
		if( box==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_IS_NOT_EXISTING, "钞箱[%s]不存在", cashboxNum);
		}else {
			Boolean isFundin = CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_INBANK.equals(box.getUsageStatus())
			||CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_FOROTHERBANK.equals(box.getUsageStatus())
			||CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_BYPBOC.equals(box.getUsageStatus());
			if(isFundin){
			throw new AppPlaceHolderException(MessageKeyConstants.CASHBOX_IS_FUNDIN, "钞箱[%s]已是出库状态", cashboxNum);
			}	
			
		}
		
		
/*		// 款箱钞袋
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_INBANK.equals(flowStage) ||
				CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_FOROTHERBANK.equals(flowStage) ||
				CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_BYPBOC.equals(flowStage) )
			{
			if( BoxInfoConsts.TYPE_BRANCH_KXCASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_KXCASHBOX, "[%s]不是款箱钞袋", cashboxNum);
			}
			
			if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_CASHBOX.equals(box.getUsageStatus())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_KXCASHBOX, "[%s]状态不是款箱钞袋配钞", cashboxNum);
			}
		}*/

		
		OrgInfo oi = null;
		if(!StringUtils.isBlank(orgId)){
			oi = this.orgInfoDao.getByOrgCode(orgId);
		if( oi==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.BOX_CODE_NOT_EXIST, "机构代码[%s]不存在", orgId);
		}
		}
		
		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		String operDate2 = DateUtil.parseToString(new Date(System.currentTimeMillis() + 1000), "yyyyMMddHHmmss");
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		
		// 如果是行内出库，同业出库，人行出库
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_INBANK.equals(flowStage) ||
			CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_FOROTHERBANK.equals(flowStage) ||
			CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_BYPBOC.equals(flowStage) )
		{
			
			String[] flowStages = { CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_CASHBOX,//款箱钞袋配钞
									CmlNoteflowDetailInfoConsts.FLOW_STAGE_DIST_BY_ATMBOX,//ATM钞箱配钞
									CmlNoteflowDetailInfoConsts.FLOW_STAGE_HANG_NEI,// 行内入库
									CmlNoteflowDetailInfoConsts.FLOW_STAGE_TONG_YE,// 同业入库
									CmlNoteflowDetailInfoConsts.FLOW_STAGE_REN_HANG};// 人行入库
			List<CmlNoteflowDetailInfo> noteflowDetailList = cmlNoteflowDetailInfoDao.getFlowDetailListByCashboxNumAndFlowStages(cashboxNum,flowStages);
			for( CmlNoteflowDetailInfo noteflowDetail : noteflowDetailList )
			{
				noteflowDetail.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转结束
				cmlNoteflowDetailInfoDao.save(noteflowDetail);
			}
			List<BarcodeInCashbox> bicList = barcodeInCashboxDao.findByBoxNum(cashboxNum);
			if( bicList.size()==0 )
			{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_CONTAIN_NOT_FLOWNUM, "钞箱[%s]尚未配钞", cashboxNum);
			}
			
			
			for( BarcodeInCashbox bic : bicList )
			{
				String barcodeFlowNum = bic.getBarcodeFlowNum();
				
				if( cmlNoteflowInfoDao.isExistsByBarcodeFlowNum(barcodeFlowNum)==false )
				{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
				}

				// 保存钞箱配送的信息
				CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
				cnfd.setBarcodeFlowNum(barcodeFlowNum);
				cnfd.setBarcode1(cashboxNum);
				cnfd.setFlowStage(flowStage);
				cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);	// 流转未结束
				cnfd.setOperator(loginer.getUsername());
				cnfd.setDate(operDate);
				cnfd.setReceivePathCode(orgId);
				cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
				
				//填入库机构的话把出库状态设成已完成.
				if(oi!=null){ 
					cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转结束
				}
				cmlNoteflowDetailInfoDao.saveNew(cnfd);
				
				// 更新流转主表的所处阶段
				CmlNoteflowInfo cnf = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
				cnf.setFlowStage(flowStage);
				cmlNoteflowInfoDao.save(cnf);
				
				/*if(oi!=null){ 
					
					// 保存钞箱配送的信息
					CmlNoteflowDetailInfo cnfd2 = new CmlNoteflowDetailInfo();
					cnfd2.setBarcodeFlowNum(barcodeFlowNum);
					cnfd2.setBarcode1(cashboxNum);
					cnfd2.setFlowStage(CmlNoteflowDetailInfoConsts.FLOW_STAGE_HANG_NEI);
					cnfd2.setStatus(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);	// 流转未结束
					cnfd2.setOperator(loginer.getUsername());
					cnfd2.setDate(operDate2);
					cnfd2.setReceivePathCode(orgId);
					cnfd2.setPathCode(oi.getPathCode());
					cmlNoteflowDetailInfoDao.saveNew(cnfd2);
					
					// 更新流转主表的所处阶段
					CmlNoteflowInfo cnf2 = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
					cnf.setFlowStage(CmlNoteflowDetailInfoConsts.FLOW_STAGE_HANG_NEI);
					cmlNoteflowInfoDao.save(cnf2);
					
				}*/
				n++;
			}
		}
		
		// 修改钞箱的状态
		if( oi!=null )
		{	// 如果出库机构不为空并存在，则自动入库，流程结束.
//			box.setUsageStatus(CmlNoteflowDetailInfoConsts.FLOW_STAGE_HANG_NEI);
//			boxInfoDao.save(box);
		}
		else
		{
//			box.setUsageStatus(flowStage);
//			boxInfoDao.save(box);
		}
		
		box.setUsageStatus(flowStage);
		boxInfoDao.save(box);
		
		return n;
	}
	
	
	/**
	 * 款箱接收扫描
	 */
	@Transactional
	public Integer addMiltiCashBoxReception(Map<Object, Object> data)
	{
		String flowStage = (String)data.get("flowStage");
		String cashboxNum = (String)data.get("cashboxNum");
		
		
		if( cashboxNum==null )
		{
			throw new RuntimeException("cashboxNum is null");
		}
		
		BoxInfo box = boxInfoDao.getByBoxNum(cashboxNum);
		if( box==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_IS_NOT_EXISTING, "钞箱[%s]不存在", cashboxNum);
		}
		
		// 网点款箱接收(在网点接收清分中心配送过来的款箱)
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_RECEIVE_KXCASHBOX.equals(flowStage) )
		{
			if( BoxInfoConsts.TYPE_BRANCH_KXCASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_KXCASHBOX, "[%s]不是网点款箱", cashboxNum);
			}
		}
		// 清分中心atm钞箱回笼接收
		else if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_CC_RECEIVE_CASHBOX.equals(flowStage) )
		{
			if( BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_CASHBOX, "[%s]不是ATM钞箱", cashboxNum);
			}
		}
		// 网点款箱回笼接收(在清分中心接收网点配送过来的款箱)
		else if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_CC_RECEIVE_KXCASHBOX.equals(flowStage) )
		{
			if( BoxInfoConsts.TYPE_BRANCH_KXCASH_BOX.equals(box.getBoxType())==false )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_IS_NOT_KXCASHBOX, "[%s]不是网点款箱", cashboxNum);
			}
		}
	
		else
		{
			throw new RuntimeException("wrong flowStage: "+flowStage);
		}
		
		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		
		// 网点款箱接收、清分中心网点款箱回笼接收 需要保存款箱内每一个捆钞的状态
		if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_RECEIVE_KXCASHBOX.equals(flowStage) ||
			CmlNoteflowDetailInfoConsts.FLOW_STAGE_CC_RECEIVE_KXCASHBOX.equals(flowStage) )
		{
			// 获取款箱内的捆钞
			List<BarcodeInCashbox> bicList = barcodeInCashboxDao.findByBoxNum(cashboxNum);
			if( bicList.size()==0 )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_KXCASHBOX_CONTAIN_NOT_FLOWNUM, "款箱[%s]内没有捆钞", cashboxNum);
			}
			
			for( BarcodeInCashbox bic : bicList )
			{
				String barcodeFlowNum = bic.getBarcodeFlowNum();
				
				// 判断流转条码是否存在
				if( cmlNoteflowInfoDao.isExistsByBarcodeFlowNum(barcodeFlowNum)==false )
				{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
				}

				// 保存钞箱接收的信息
				CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
				cnfd.setBarcodeFlowNum(barcodeFlowNum);
				cnfd.setBarcode1(cashboxNum);
				cnfd.setFlowStage(flowStage);
				cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);	// 流转未结束，因为还可以再次流转
				cnfd.setOperator(loginer.getUsername());
				cnfd.setDate(operDate);
				cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
				cmlNoteflowDetailInfoDao.saveNew(cnfd);
				
				// 更新流转主表的所处阶段
				CmlNoteflowInfo cnf = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
				cnf.setFlowStage(flowStage);
				cmlNoteflowInfoDao.save(cnf);
				
				// 更新这个流转号的状态为已经结束
				//cmlNoteflowDetailInfoDao.updateDetailStatusByBarcodeFlowNum(noteflowDetailInfo.getBarcodeFlowNum(), CmlNoteflowDetailInfoConsts.STATUS_FINISHED);
				
				n++;
			}
			
			// 删除这个钞箱内的捆钞条码
			barcodeInCashboxDao.deleteByBoxNum(cashboxNum);
		}
		// 清分中心atm钞箱回笼接收、清分中心人行钞袋回笼接收
		else if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_CC_RECEIVE_CASHBOX.equals(flowStage) ||
				 CmlNoteflowDetailInfoConsts.FLOW_STAGE_CC_RECEIVE_CASHBAG.equals(flowStage))
		{
			// 获取“回笼的那个钞箱”
			CmlNoteflowDetailInfo cnfd0 = cmlNoteflowDetailInfoDao.getReturningCashboxBox(cashboxNum);
			if( cnfd0!=null )
			{
				cnfd0.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);
				cmlNoteflowDetailInfoDao.save(cnfd0);
			}
			
			// 保存钞箱配送的信息
			CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
			cnfd.setBarcodeFlowNum(null);
			cnfd.setBarcode1(cashboxNum);
			cnfd.setFlowStage(flowStage);
			cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转已结束
			cnfd.setOperator(loginer.getUsername());
			cnfd.setDate(operDate);
			cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
			cmlNoteflowDetailInfoDao.saveNew(cnfd);
			
			n++;
		}
		else
		{
			throw new RuntimeException("代码应该跑不到这里来");
		}
		
		// 修改钞箱的状态
		box.setUsageStatus(BoxInfoConsts.USAGE_STATUS_FREE);
		boxInfoDao.save(box);
		
		return n;
	}
	
	/**
	 * 行内入库（hzzeng）
	 */
	@Transactional
	public Integer addMiltiCashBox_financeIn(Map<Object, Object> data)
	{
		String flowStage = (String)data.get("flowStage");
		String cashboxNum = (String)data.get("cashboxNum");
		String finishFlowFlag = (String)data.get("finishFlowFlag");
		
		boolean isFinishFlow = "0".equals(finishFlowFlag);
		
		BoxInfo box = boxInfoDao.getByBoxNum(cashboxNum);

		
		//钞箱号不存在
		if( box==null )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_CASHBOX_IS_NOT_EXISTING, "钞箱[%s]不存在", cashboxNum);
		}//钞箱号不处于行内、同行、人行出库状态
		else {
			Boolean isFundOut = CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_INBANK.equals(box.getUsageStatus())
			||CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_FOROTHERBANK.equals(box.getUsageStatus())
			||CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_BYPBOC.equals(box.getUsageStatus());
			if(!isFundOut){
			throw new AppPlaceHolderException(MessageKeyConstants.CASHBOX_ISNOT_FUNDOUT, "钞箱[%s]不在出库状态", cashboxNum);
			}		
		}
		
		//入库后的状态，不处于行内、同行、人行入库状态
		if(!CmlNoteflowDetailInfoConsts.FLOW_STAGE_HANG_NEI.equals(flowStage)&&
		   !CmlNoteflowDetailInfoConsts.FLOW_STAGE_TONG_YE.equals(flowStage)&&
		   !CmlNoteflowDetailInfoConsts.FLOW_STAGE_REN_HANG.equals(flowStage))
		{
			throw new RuntimeException("wrong flowStage: "+flowStage);
		}
		
		// 获取款箱钞袋内的捆钞
		List<BarcodeInCashbox> bicLists = barcodeInCashboxDao.findByBoxNum(cashboxNum);
		if( bicLists.size()==0 )
		{
			throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_KXCASHBOX_CONTAIN_NOT_FLOWNUM, "款箱[%s]内没有捆钞", cashboxNum);
		}
		
		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		//if(BoxInfoConsts.TYPE_BRANCH_KXCASH_BOX.equals(box.getBoxType())){//款箱钞袋
		
		String[] flowStages = {CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_INBANK,CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_FOROTHERBANK,CmlNoteflowDetailInfoConsts.FLOW_STAGE_DELIVER_BY_CASH_BOX_BYPBOC};
		List<CmlNoteflowDetailInfo> noteflowDetailList = cmlNoteflowDetailInfoDao.getFlowDetailListByCashboxNumAndFlowStages(cashboxNum,flowStages);
		for( CmlNoteflowDetailInfo noteflowDetail : noteflowDetailList )
		{
			noteflowDetail.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转结束
			cmlNoteflowDetailInfoDao.save(noteflowDetail);
		}
		
			
			for( BarcodeInCashbox bic : bicLists )
			{
				String barcodeFlowNum = bic.getBarcodeFlowNum();
				
				// 判断流转条码是否存在
				if( cmlNoteflowInfoDao.isExistsByBarcodeFlowNum(barcodeFlowNum)==false )
				{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
				}

				// 新增流转详情信息
				CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
				cnfd.setBarcodeFlowNum(barcodeFlowNum);
				cnfd.setBarcode1(cashboxNum);
				//cnfd.setBarcode2(cashboxNum);
				cnfd.setFlowStage(flowStage);
				// 流转未结束，因为还可以再次流转
				if(isFinishFlow){
					cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);
				}else{
				cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);
				}
				cnfd.setOperator(loginer.getUsername());
				cnfd.setDate(operDate);
				cnfd.setReceivePathCode(orgInfoDao.getOrgCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
				cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
				cmlNoteflowDetailInfoDao.saveNew(cnfd);
				
				// 更新流转主表的所处阶段
				CmlNoteflowInfo cnf = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
				if(isFinishFlow){
					cnf.setBarcodeStatus(CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED);
				}
				cnf.setFlowStage(flowStage);
				
				cmlNoteflowInfoDao.save(cnf);
				
				// 更新这个流转号的状态为已经结束
				//cmlNoteflowDetailInfoDao.updateDetailStatusByBarcodeFlowNum(noteflowDetailInfo.getBarcodeFlowNum(), CmlNoteflowDetailInfoConsts.STATUS_FINISHED);
				
				n++;
			}
			
			// 删除这个钞箱内的捆钞条码
			if(isFinishFlow){
			barcodeInCashboxDao.deleteByBoxNum(cashboxNum);
			}
			
		/*}else if(BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(box.getBoxType())){// ATM钞箱
			
			if(bicLists.size()==1){
				String barcodeFlowNum = bicLists.get(0).getBarcodeFlowNum();
				
				// 判断流转条码是否存在
				if( cmlNoteflowInfoDao.isExistsByBarcodeFlowNum(barcodeFlowNum)==false )
				{
					throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
				}
				
				// 保存钞箱接收的信息
				CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
				cnfd.setBarcodeFlowNum(barcodeFlowNum);
				cnfd.setBarcode1(cashboxNum);
				cnfd.setFlowStage(flowStage);
				cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转未结束，因为还可以再次流转
				cnfd.setOperator(loginer.getUsername());
				cnfd.setDate(operDate);
				cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
				cmlNoteflowDetailInfoDao.saveNew(cnfd);
				
				// 更新流转主表的所处阶段
				CmlNoteflowInfo cnf = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
				cnf.setFlowStage(flowStage);
				cmlNoteflowInfoDao.save(cnf);	
				
				n++;
				
				// 删除这个钞箱内的捆钞条码
				barcodeInCashboxDao.deleteByBoxNum(cashboxNum);		
			}else{
				throw new RuntimeException("代码应该跑不到这里来");
			}			
		}*/	
		
		// 修改钞箱的状态:空闲
			if(isFinishFlow){
				box.setUsageStatus(BoxInfoConsts.USAGE_STATUS_FREE);
				boxInfoDao.save(box);
			}else{
				box.setUsageStatus(flowStage);
				boxInfoDao.save(box);
			}
		
		return n;
	}
	
	
	/**
	 * 增加多个大额取款
	 */
	@Transactional
	public Integer addMiltiLargeWithdrawal(Map<Object, Object> data)
	{
		String cardNum = (String)data.get("cardNum");
		String[] barcodeFlowNumArr = ArrayUtil.toStringArray(data.get("barcodeFlowNumArr"));
		
		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		
		// 获取登录的用户信息
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		for( String barcodeFlowNum : barcodeFlowNumArr )
		{
			CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
			if( cmlNoteflowInfo==null )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
			}
			// 判断条码的状态
			if( CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED.equals(cmlNoteflowInfo.getBarcodeStatus()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_FINISHED_ALREADY, "流转条码[%s]状态已经结束", barcodeFlowNum);
			}
			// 大额取款
			if( CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_LARGE_WITHDRAWAL.equals(cmlNoteflowInfo.getFlowStage()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_PAID_ALREADY, "流转条码[%s]已经支付", barcodeFlowNum);
			}
			
			// 保存
			CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
			cnfd.setBarcodeFlowNum(barcodeFlowNum);
			cnfd.setBarcode1(cardNum);
			cnfd.setFlowStage(CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_LARGE_WITHDRAWAL);
			cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转结束
			cnfd.setOperator(loginer.getUsername());
			cnfd.setDate(operDate);
			cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
			cmlNoteflowDetailInfoDao.saveNew(cnfd);
			
			// 修改流转主表的状态
			cmlNoteflowInfo.setBarcodeStatus(CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED);
			cmlNoteflowInfo.setFlowStage(CmlNoteflowDetailInfoConsts.FLOW_STAGE_BRANCH_LARGE_WITHDRAWAL);
			cmlNoteflowInfoDao.save(cmlNoteflowInfo);
			
			// 更新流转困钞的状态为已结束
			cmlNoteflowDetailInfoDao.updateDetailStatusByBarcodeFlowNum(barcodeFlowNum, CmlNoteflowDetailInfoConsts.STATUS_FINISHED);
			
			n++;
		}
		
		return n;
	}
	
	/**
	 * 大额取款
	 */
	@Transactional
	public Integer distributionForLargeWithDraw(Map<Object, Object> data)
	{
		String flowStage = (String)data.get("flowStage");
		String accountNo = (String)data.get("accountNo");
		String[] barcodeFlowNumArr = ArrayUtil.toStringArray(data.get("barcodeFlowNumArr"));
		

		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		StringBuffer sb = new StringBuffer();
		BigDecimal statisAmt = new BigDecimal(0);
		Integer noteCount = 0;
		
		
		
		for( String barcodeFlowNum : barcodeFlowNumArr )
		{
			CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
			
			// 判断该流转条码是否存在
			if( cmlNoteflowInfo==null )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
			}
			
			// 判断条码的状态
			if( CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED.equals(cmlNoteflowInfo.getBarcodeStatus()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_FINISHED_ALREADY, "流转条码[%s]状态已经结束", barcodeFlowNum);
			}
			if( CmlNoteflowInfoConsts.BARCODE_STATUS_ERROR.equals(cmlNoteflowInfo.getBarcodeStatus()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_ERROR, "流转条码[%s]状态是异常,请检查.", barcodeFlowNum);
			}
			
			// 判断条码是否在钞箱里面
			BarcodeInCashbox bic = barcodeInCashboxDao.findByBarcodeFlowNum(barcodeFlowNum);
			if( bic!=null )
			{
				BoxInfo box = boxInfoDao.getByBoxNum(bic.getBoxNum());
				if( box!=null )
				{
					if( BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(box.getBoxType())==true )
					{
						throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_DIST_CASH_IN_ATM_BOX, "流转码[%s]已配钞在ATM钞箱中,不能进行大额取款操作", barcodeFlowNum);
					}				
				}
				
				barcodeInCashboxDao.deleteByBarcodeFlowNum(barcodeFlowNum);
				List<BarcodeInCashbox> bicList = barcodeInCashboxDao.findByBoxNum(bic.getBoxNum());
				if( bicList==null || bicList.size()==0 )
				{
					// 修改钞箱的状态
					box.setUsageStatus(BoxInfoConsts.USAGE_STATUS_FREE);
					boxInfoDao.save(box);
				}
			}
			
			
			// 保存配钞的数据
			CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
			cnfd.setBarcodeFlowNum(barcodeFlowNum);
			cnfd.setBarcode1(accountNo);
			//cnfd.setBarcode2(cashboxNum);
			cnfd.setFlowStage(flowStage);
			cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_FINISHED);	// 流转结束
			cnfd.setOperator(loginer.getUsername());
			cnfd.setDate(operDate);
			cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
			cmlNoteflowDetailInfoDao.saveNew(cnfd);
			
			// 修改对应流转主表的状态
			cmlNoteflowInfo.setFlowStage(flowStage);
			cmlNoteflowInfo.setBarcodeStatus(CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED);
			cmlNoteflowInfoDao.save(cmlNoteflowInfo);
			
			sb.append(barcodeFlowNum+";");
			statisAmt = statisAmt.add(cmlNoteflowInfo.getStatisAmt());
			noteCount += cmlNoteflowInfo.getNoteCount();
			
			n++;
		}
		
		// 添加"柜面付款交易"记录
		CmlCounterRecord cmlCounterRecord = new CmlCounterRecord();
		// 设置交易的属性
		
		String tranId = UUID.randomUUID().toString().replace("-", "");
		
		cmlCounterRecord.setId(tranId);
		cmlCounterRecord.setTermId("");  //终端ID cmlNoteflowInfo.getTermId()
		cmlCounterRecord.setTranTime(operDate);
		cmlCounterRecord.setTranCount(new BigDecimal(noteCount));
		cmlCounterRecord.setStatisAtm(statisAmt);
		cmlCounterRecord.setBusinessType(3);
		cmlCounterRecord.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
		cmlCounterRecord.setTranDate(operDate.substring(0, 8));
		cmlCounterRecord.setPartMonthday(operDate.substring(4, 8));//分区月日
		cmlCounterRecord.setTdAccountNo(accountNo);
		cmlCounterRecord.setTdTranAtm(statisAmt);
		cmlCounterRecord.setTdOperatorId(loginer.getUsername());
		cmlCounterRecord.setTdTransCode("GMFK");
		cmlCounterRecord.setTdReserve(sb.toString());
		
		cmlCounterRecordDao.saveNew(cmlCounterRecord);
		
		
		return n;
	}
	
	
	/**
	 * 发放柜员
	 */
	@Transactional
	public Integer distributionForDistributeCounter(Map<Object, Object> data)
	{
		String flowStage = (String)data.get("flowStage");
		String accountNo = (String)data.get("accountNo");
		String[] barcodeFlowNumArr = ArrayUtil.toStringArray(data.get("barcodeFlowNumArr"));
		

		String operDate = DateUtil.parseToString(new Date(), "yyyyMMddHHmmss");
		
		Loginer loginer = (Loginer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> userInfo = loginer.getUserInfo();
		
		Integer n = 0;
		for( String barcodeFlowNum : barcodeFlowNumArr )
		{
			CmlNoteflowInfo cmlNoteflowInfo = cmlNoteflowInfoDao.getByBarcodeFlowNum(barcodeFlowNum);
			
			// 判断该流转条码是否存在
			if( cmlNoteflowInfo==null )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_NOT_EXISTS, "流转条码[%s]不存在", barcodeFlowNum);
			}
			
			// 判断条码的状态
			if( CmlNoteflowInfoConsts.BARCODE_STATUS_FINISHED.equals(cmlNoteflowInfo.getBarcodeStatus()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_FINISHED_ALREADY, "流转条码[%s]状态已经结束", barcodeFlowNum);
			}
			if( CmlNoteflowInfoConsts.BARCODE_STATUS_ERROR.equals(cmlNoteflowInfo.getBarcodeStatus()) )
			{
				throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_ERROR, "流转条码[%s]状态是异常,请检查.", barcodeFlowNum);
			}
			
			// 判断条码是否在钞箱里面
			BarcodeInCashbox bic = barcodeInCashboxDao.findByBarcodeFlowNum(barcodeFlowNum);
			if( bic!=null )
			{
				BoxInfo box = boxInfoDao.getByBoxNum(bic.getBoxNum());
				if( box!=null )
				{
					if( BoxInfoConsts.TYPE_ATM_CASH_BOX.equals(box.getBoxType())==true )
					{
						throw new AppPlaceHolderException(MessageKeyConstants.CML_MGR_FLOWNUM_DIST_CASH_IN_ATM_BOX, "流转码[%s]已配钞在ATM钞箱中,不能进行其他操作", barcodeFlowNum);
					}				
				}
				
				barcodeInCashboxDao.deleteByBarcodeFlowNum(barcodeFlowNum);
				List<BarcodeInCashbox> bicList = barcodeInCashboxDao.findByBoxNum(bic.getBoxNum());
				if( bicList==null || bicList.size()==0 )
				{
					// 修改钞箱的状态
					box.setUsageStatus(BoxInfoConsts.USAGE_STATUS_FREE);
					boxInfoDao.save(box);
				}
			}
			
			
			// 保存配钞的数据
			CmlNoteflowDetailInfo cnfd = new CmlNoteflowDetailInfo();
			cnfd.setBarcodeFlowNum(barcodeFlowNum);
			cnfd.setBarcode1(accountNo);
			//cnfd.setBarcode2(cashboxNum);
			cnfd.setFlowStage(flowStage);
			cnfd.setStatus(CmlNoteflowDetailInfoConsts.STATUS_NOT_FINISHED);	// 流转未结束
			cnfd.setOperator(loginer.getUsername());
			cnfd.setDate(operDate);
			cnfd.setPathCode(orgInfoDao.getPathCodeById(userInfo.get(Loginer.USER_INFO_ORG_ID)));
			cmlNoteflowDetailInfoDao.saveNew(cnfd);
			
			// 修改对应流转主表的状态
			cmlNoteflowInfo.setFlowStage(flowStage);
			cmlNoteflowInfoDao.save(cmlNoteflowInfo);
			
			n++;
		}
		
		
		return n;
	}
	
	
	
}
