package com.grgbanking.sent.transmgr.service;
import java.io.IOException;
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
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.param.entity.Param;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoDao;
import com.grgbanking.sent.transmgr.entity.CmlSentInfo;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.utils.R2002Msg;
import com.grgbanking.sent.utils.S2002Msg;
import com.grgbanking.sent.utils.StringUtil;
import com.grgbanking.sent.utils.Transfer;


/**
 * TransBanknoteSeqFuzzyService �̳й�����BaseService��
 * @author ������?�?�?�?
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class TransBanknoteSeqFuzzyService extends BaseService {
	final int num3=3;
	final int num4=4;
	final int num5=5;
	final int subLength=13;
	
	@Autowired
	CmlSentInfoDao cmlSentInfoDao;
	
	@Autowired
	 ParamDao paramDao;
	@Autowired
	CmlSentInfoService cmlSentInfoService;
    @Autowired
    TranInfoService tranInfoService;
	
	@Autowired
	Transfer transfer;
	@Autowired
	OrgInfoDao orgInfoDao;
	/**
     * ����һ�� TransBanknoteSeq���?�?�?�?
     * @param obj TransBanknoteSeqʵ��
     * @return boolean
     */ 
	public boolean addTransBanknoteSeq(CmlSentInfo obj) {
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
     * ����һ�� TransBanknoteSeq���?�?�?�?
     * @param obj TransBanknoteSeqʵ��
     * @return boolean
     */ 

	public boolean addTransBanknoteSeqHour(CmlSentInfo obj) {
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
	public boolean deleteTransBanknoteSeq(CmlSentInfo obj) {
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
     * ����һ�� TransBanknoteSeq���?�?�?�?
     * @param obj TransBanknoteSeqʵ��
     * @return boolean
     */ 
	public boolean updateTransBanknoteSeq(CmlSentInfo obj) {
		boolean flag = false;
		try {
			cmlSentInfoDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}

	/**
     * ����һ�� TransBanknoteSeqHis���?�?�?�?
     * @param obj TransBanknoteSeqHisʵ��
     * @return boolean
     */ 
	public boolean updateTransBanknoteSeqHis(CmlSentInfo obj) {
		boolean flag = false;
		try {
			cmlSentInfoDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}
	
	/**
     * ����һ�� TransBanknoteSeqHour���?�?�?�?
     * @param obj TransBanknoteSeqHourʵ��
     * @return boolean
     */ 
	public boolean updateTransBanknoteSeqHour(CmlSentInfo obj) {
		boolean flag = false;
		try {
			cmlSentInfoDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}




	/**
     * ��ѯTransBanknoteSeq������?�?�?�?
     * @param page pageʵ��
     * @param trans  TransBanknoteSeqʵ��
     * @param beginDateString ��ʼʱ��
     * @param endDateString ����ʱ��
     * @param fuzzyCount ƥ������
     * @return Page 
     */ 
	@Transactional(readOnly = true)
	public Page getTransBanknoteSeqPage(Map<String,Object> parameter)
	{
		Page page                    = (Page)parameter.get("page");
		
		Map<String,Object> condition = (Map)parameter.get("condition");
		String startTime             = StringUtil.trim((String)condition.get("startTime"));
		String endTime               = StringUtil.trim((String)condition.get("endTime"));
		String seriaNo               = StringUtil.trim((String)condition.get("seriaNo"));
		String termId                = StringUtil.trim((String)condition.get("termId"));
		String pathCode              = StringUtil.trim((String)condition.get("pathCode"));
		String noteType              = StringUtil.trim((String)condition.get("noteType"));
		
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
						" where trans.termType='1'" +
						" and trans.tranDate >= '"+DateUtil.parseToString(dStartTime, "yyyyMMddHHmmss")+"'" +
						" and trans.tranDate <= '"+DateUtil.parseToString(dEndTime, "yyyyMMddHHmmss")+"'";
		
		if( StringUtil.isNotBlank(seriaNo) )
		{
			if( DBDialectHelper.isOracle() )
			{
				hql += " and trans.seriaNo like '"+ seriaNo+"%'" ;
			}
			else
			{
				hql += " and trans.seriaNo like '"+ seriaNo+"%'" ;
			}
		}
		if( StringUtil.isNotBlank(pathCode) )
		{
			hql+=" and trans.pathcode like '"+pathCode+"%'" ;
		}
		if( StringUtil.isNotBlank(noteType) )
		{
			hql+=" and  trans.noteType = '"+noteType+"'";
		}
		if( StringUtil.isNotBlank(termId) )
		{
			hql+=" and trans.termid = '"+termId+"'" ;
		}
		
		hql+=" order by trans.tranDate desc" ;
	
		Page pageObject = new Page();

		pageObject = cmlSentInfoDao.findPage(page, hql);
		List<CmlSentInfo> list = new ArrayList<CmlSentInfo>();
		List<CmlSentInfo> li = pageObject.getResult();
		String orgName = null;
		String termTypeName = null;
		
		for (int i = 0; i < li.size(); i++)
		{
			CmlSentInfo cml = li.get(i);
			termTypeName = cmlSentInfoService.findTermTypeName(cml.getTermId());
			cml.setTypeName(termTypeName);	// 终端类型名称赋值
			
			orgName = tranInfoService.findOrgName(cml.getPathcode());// 机构名称赋值
			cml.setPathcode(orgName);
			list.add(cml);
		}
		
		pageObject.setResult(list);

		return pageObject;
		
	}
	
	/**
	 *  ��ݹ���ID ��ѯ TransBanknoteSeq���?�?�?�?
	 *  @param tranId ����Id
	 *  @return List<TransBanknoteSeq>
	 */
	@Transactional(readOnly = true)
	public Page getTransBanknoteSeqByTranId(Page page,String tranId,String transMonthday) {
		
		String hql=" select new CmlSentInfo(trans.id,trans.tranId,trans.seriaNo,trans.currency,trans.denomination,trans.noteType, trans.tranDate,trans.termid,trans.imageType,trans.termType,trans.tranMonthday,trans.barcodeFlowNum) from  CmlSentInfo trans where trans.termType='"+1+"' and trans.tranMonthday='"+transMonthday+"' and trans.tranId='"+tranId+"' order by trans.tranDate";
		// List<TransBanknoteSeqInfo> li=transBanknoteSeqInfoDao.find(sql);
			//logger.info(sql.toString() + "id = " + tranId );
		Page pageObject=new Page();
		pageObject=cmlSentInfoDao.findPage(page,hql);
		 return pageObject;
	}

	/**
     * �������ID��ѯTransBanknoteSeqInfo���?�?�?�?
     * @param id id����
     * @return TransBanknoteSeq 
     */ 
	@Transactional(readOnly = true)
	public CmlSentInfo getTransBanknoteSeqObject(String id) {
		return (CmlSentInfo) cmlSentInfoDao.get(id);
	}

   
	 
	
	public CmlSentInfo findBanknoteSeqById(String id)
	{
		CmlSentInfo seqInfo = new CmlSentInfo();
		boolean flag = false;
		// CmlSentInfo obj=new CmlSentInfo();
		seqInfo = getTransBanknoteSeqObject(id);
		String imgType = seqInfo.getImageType();
		try
		{
			if (imgType != null && imgType.equals("3"))
			{
				String messageNo = String.valueOf(new Date().getTime()).substring(1, subLength);
				R2002Msg rmsg = new R2002Msg();
				rmsg = getReturnPack(seqInfo, messageNo);
				if (rmsg != null)
				{
					if (rmsg.getMessageno().equals(messageNo))
					{
						String returnPicPath = rmsg.getFilepath();
						String checkResult = rmsg.getCheckresult().trim();
						// 格式00001042/20130618/183943_1180_1_005.bmp
						String filePathStr[] = null;
						int a = returnPicPath.indexOf("/");
						if (a != -1)
						{
							if (returnPicPath != null && !returnPicPath.equals(""))
							{
								//seqInfo.setFileName(returnPicPath);
								seqInfo.setImageType("4");
								flag = updateTransBanknoteSeq(seqInfo);// ������ݿ��¼
								seqInfo = getTransBankInfoVO(seqInfo);
								if (flag)
								{
									logger.info(seqInfo.getTermId());
								}
								else
								{
									try
									{
										logger.info(seqInfo.getTermId());
									}
									catch (AppException e)
									{
										logger.error("", e);
									}
								}
							}
							else
							{
								seqInfo = getTransBankInfoVO(seqInfo);
							}
						}
						else
						{
							seqInfo = getTransBankInfoVO(seqInfo);
						}
					}
					else
					{
						seqInfo = getTransBankInfoVO(seqInfo);

					}

				}

			}

			else
			{
				seqInfo = getTransBankInfoVO(seqInfo);

			}
		}
		catch (AppException e)
		{
			seqInfo = getTransBankInfoVO(seqInfo);
			logger.error("", e);

		}
		return seqInfo;
	}
	/**
	 *���id���Ҷ�Ӧ���� ���ֺ���Ϣ��
	 *@param id ���Ӻ�id
	 *@return int
	 * */
	
	 

	
	/**
	 * ���TransBanknoteSeq�õ�TransBanknoteSeqInfo
	 * @param seqNote ���ֺ����?�?�?�?
	 * @return TransBanknoteSeqInfo ��ͼ��ӳ�����?�?�?�?
	 * */
	@Transactional(readOnly = true)
	public CmlSentInfo getTransBankInfoVO(CmlSentInfo seqNote){
		String imgPath=getImgParmPath();
		String termID=seqNote.getTermId();
		String fileDir=seqNote.getTranDate().substring(0,8);
		CmlSentInfo seqInfo=new CmlSentInfo();
		seqInfo.setId(seqNote.getId());
		seqInfo.setSeriaNo(seqNote.getSeriaNo());
		//seqInfo.setFileName(imgPath+seqNote.getFileName());
		//seqInfo.setFileName(seqNote.getFileName());
		seqInfo.setDenomination(seqNote.getDenomination());
		seqInfo.setCurrency(seqNote.getCurrency());
		seqInfo.setNoteFlag(seqNote.getNoteFlag());
		seqInfo.setNoteType(seqNote.getNoteType());
		
		return seqInfo;
	}
	
	
	/**
	 * ȥ��ո�?�?�?�?
	 * @param seqInfoList ���ֺ�����Ϣ�б� 
	 * @return List
	 * */
	@Transactional(readOnly = true)
	public  List<CmlSentInfo> trimBanknoteSeqInfos(List<CmlSentInfo> seqInfoList)
	{
		for (int i = 0; i < seqInfoList.size(); i++)
		{
			if (seqInfoList.get(i).getNoteType() != null)
			{
				seqInfoList.get(i).setNoteType(seqInfoList.get(i).getNoteType().trim());
			}
			if (seqInfoList.get(i).getNoteFlag() != null)
			{
				seqInfoList.get(i).setNoteFlag(seqInfoList.get(i).getNoteFlag().trim());
			}
			if (seqInfoList.get(i).getCurrency() != null)
			{
				seqInfoList.get(i).setCurrency(seqInfoList.get(i).getCurrency().trim());
			}
		}
		return seqInfoList;
	}
	

	/**
	 * �鿴���׹��Ӻ����Ӧ��ͼ�?�?�?�?
	 * @param ids ���ID��ɵ��ַ�?�?�?�?
	 * @return List
	 */
	public List getTransBanknoteSeqById(String ids)
	{
		List<CmlSentInfo> seqInfoList = new ArrayList<CmlSentInfo>();
		String[] arrStr = ids.split(",");
		try
		{
			for (int i = 0; i < arrStr.length; i++)
			{
				CmlSentInfo seqInfo = new CmlSentInfo();
				String id = arrStr[i];
				if (id == "")
				{
					continue;
				}

				seqInfo = findBanknoteSeqById(id);

				seqInfoList.add(seqInfo);

			}
			trimBanknoteSeqInfos(seqInfoList);
		}
		catch (NullPointerException e)
		{
			logger.error("", e);
		}

		return seqInfoList;
	}
	 


	/**
	 * ���ͼƬ������·��?�?�?�?
	 * @return String ͼƬ��������·��
	 * */
	public String getImgParmPath(){
		return paramDao.getValueByPath(AppConstants.IMAGE_PATH);	
	}
	
	/**
	 * @return String ʱ�䷶Χ
	 * ��ü������ֺŵ�ʱ�䷶�?�?�?�?
	 * */
	public String getInitParamMap(){
		 return paramDao.getValueByPath((AppConstants.TRANS_DAY));
	}
	public List getInitForNoteType(){
		return paramDao.getComboBoxPath(AppConstants.NOTE_TYPE_LIST, null);
		
	}
	
	/**
	 * 
	 */
	public R2002Msg getReturnPack(CmlSentInfo seq, String messageNo)
	{
		S2002Msg smsg = new S2002Msg();

		smsg.setCheckcode("00");
		smsg.setDevid(seq.getTermId());
		smsg.setMessageno(messageNo);
		//String picName = seq.getFileName();
		String tranDate = seq.getTranDate().substring(0, 8);
		//smsg.setPicturename(tranDate + "/" + picName);// unux系统文件路径"/"

		byte[] returnpack = null;
		byte[] sendpack = smsg.packMessage();

		transfer.init();
		try
		{
			returnpack = transfer.sendPack(sendpack);
		}
		catch( IOException e )
		{
			logger.error("", e);
			returnpack = null;
		}

		if( returnpack == null )
		{
			return null;
		}
		else
		{
			R2002Msg rmsg = new R2002Msg();
			rmsg.unpackMessage(returnpack);
			return rmsg;
		}
	}
			

			
	public List getNoteFlag(){
	
		List<Param> result  =paramDao.queryChildList(AppConstants.NOTE_TYPE_LIST);
		for (int i = 0; i < result.size(); i++) {
			
			logger.info(result.get(i).getKey() + result.get(i).getValue());
			
		}
		return result;
	}		
}