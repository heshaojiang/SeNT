package com.grgbanking.sent.watch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.sent.transmgr.dao.CmlSentInfoDao;
import com.grgbanking.sent.utils.DateUtil;
import com.grgbanking.sent.watch.dao.TransBanknoteSeqHourDao;
import com.grgbanking.sent.watch.entity.TransBanknoteSeqHour;
/**
 * 清分纸币冠字号码监控Service继承BaseService
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class TransBanknoteSeqHourService extends BaseService {
	@Autowired
	private TransBanknoteSeqHourDao transBanknoteSeqHourDao;
	@Autowired
    CmlSentInfoDao	cmlSentInfoDao;
	  /**
	    * 新增一条TransBanknoteSeqHour数据
	    * @param obj TransBanknoteSeqHour实体
	    * @return boolean
	    */
	public boolean addTransBanknoteSeqHour(TransBanknoteSeqHour obj) {
		boolean flag = false;
		try {
			transBanknoteSeqHourDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
			
			logger.error("", e);
		}
		return flag;
	}
	/**
	 *  根据删除一条  TransBanknoteSeqHour数据 
	 *  @param obj TransBanknoteSeqHour实体
	 *  @return boolean
	 */
	public boolean deleteTransBanknoteSeqHour(TransBanknoteSeqHour obj) {
		boolean flag = false;
		try {
			transBanknoteSeqHourDao.delete(obj.getId());
			flag = true;
		} catch (AppException e) {
			
			logger.error("", e);
		}
		return flag;
	}
	/**
	 * 更新一条  TransBanknoteSeqHour数据 
	 * @param obj TransBanknoteSeqHour实体
	 * @return boolean
	 */

	public boolean updateTransBanknoteSeqHour(TransBanknoteSeqHour obj) {
		boolean flag = false;
		try {
			transBanknoteSeqHourDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			
			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}
	/**
	 * 根据冠字号码查询TransBanknoteSeqHour集合进行显示
	 * @param page page实体
	 * @param trans  TransBanknoteSeqHour实体
	 * @param beginDateString 开始时间
	 * @param endDateString 结束时间
	 * @return Page
	 */

	@Transactional(readOnly = true)
	public Page getTransBanknoteSeqHourPage(Page page, TransBanknoteSeqHour trans, String beginDateString,
			String endDateString) {
		String sql = "  from TransBanknoteSeqHour as trans where 1=1";

		if (beginDateString != null && !beginDateString.equals("")) {
			beginDateString = DateUtil
					.dateFormatTohms(beginDateString);
			
		}

		if (endDateString != null && !endDateString.equals("")) {
			endDateString = DateUtil
					.dateFormatTohms(endDateString);
		}
		
		if (trans.getSeriaNo() != null && !trans.getSeriaNo().equals(""))
		{
			if( DBDialectHelper.isOracle() )
			{
				sql += " where trans.seriaNo like '" + trans.getSeriaNo().trim() + "%'";
			}
			else
			{
				sql += " where trans.seriaNo like '" + trans.getSeriaNo().trim() + "%'";
			}
		}
		if(trans.getTermid()!=null&&!"".equals(trans.getTermid())){
			
				sql += " and trans.termid='"+trans.getTermid()+"' ";
		
		}
		if (beginDateString != null && !beginDateString.equals("")) {
		/*	sql += " and trans.transDate||trans.tranTime>='" + beginDateString + "'";*/
		}
		if (endDateString != null && !endDateString.equals("")) {
			/*sql += " and trans.transDate||trans.transTime<='" + endDateString + "'";*/
		}
		sql += "  order by trans.transDate||trans.tranTime desc";

		return transBanknoteSeqHourDao.findPage(page, sql);
	}

	/**
	 * 根据条件进行查询TransBanknoteSeqHour
	 * @param obj 查询条件
	 * @return list
	 */
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqHourList(Object[] obj) {
		String sql = "  from TransBanknoteSeqHour ";
		return transBanknoteSeqHourDao.find(sql);
	}
	/**
	 * 查询关联id 和纸币标识为0的TransBanknoteSeqHour数据
	 * @param transid 关联ID
	 * @return list
	 */
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqHourIdListFlag1(String transid){
		String hql = " select t.id from TransBanknoteSeqHour t where t.tranId ='"+transid+"' and t.noteFlag ='0'";
		return transBanknoteSeqHourDao.find(hql);
	}
	/**
	 * 查询关联id 和纸币标识为1的TransBanknoteSeqHour数据
	 * @param transid 关联ID
	 * @return list
	 */
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqHourIdListFlag2(String transid){
		String hql = " select t.id from TransBanknoteSeqHour t where t.tranId ='"+transid+"' and t.noteFlag ='1' ";
		return transBanknoteSeqHourDao.find(hql);
	}
	/**
	 * 查询关联id 和纸币标识为4的TransBanknoteSeqHour数据
	 * @param transid 关联ID
	 * @return list
	 */
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqHourIdListFlag3(String transid){
		String hql = " select t.id from TransBanknoteSeqHour t where t.tranId ='"+transid+"' and t.noteFlag ='4' ";
		return transBanknoteSeqHourDao.find(hql);
	}
	/**
	 * 查询关联id 和纸币标识为5的TransBanknoteSeqHour数据
	 * @param transid 关联ID
	 * @return list
	 */
	@Transactional(readOnly = true)
	public List getTransBanknoteSeqHourIdListFlag4(String transid){
		String hql = " select t.id from TransBanknoteSeqHour t where t.tranId ='"+transid+"' and t.noteFlag ='5' ";
		return transBanknoteSeqHourDao.find(hql);
	}
	/**
	 * 根据ID查询相应的实体 
	 * @param id 主键
	 * @return  TransBanknoteSeqHour
	 */
	@Transactional(readOnly = true)
	public TransBanknoteSeqHour getTransBanknoteSeqHourObject(String id) {
		return (TransBanknoteSeqHour) transBanknoteSeqHourDao.get(id);
	}
     /**
      * 根据关联ID查询相应的 TransBanknoteSeqHour集合 
      * @param tranId 关联ID
      * @return List<TransBanknoteSeqHour>
      */
	@Transactional(readOnly = true)
	public Page getTransBanknoteSeqHourByTranId(Page page,String tranId,String transMonthDay) {
		String hql=" select new CmlSentInfo(trans.id,trans.tranId,trans.seriaNo,trans.currency,trans.denomination,trans.noteType, trans.tranDate,trans.termid,trans.imageType,trans.termType,trans.tranMonthday,trans.barcodeFlowNum) from  CmlSentInfo trans where trans.termType='"+1+"' and trans.tranMonthday='"+transMonthDay+"' and trans.tranId='"+tranId+"' order by trans.tranDate";
		// List<TransBanknoteSeqInfo> li=transBanknoteSeqInfoDao.find(sql);
			//logger.info(sql.toString() + "id = " + tranId );
		Page pageObject=new Page();
		pageObject=cmlSentInfoDao.findPage(page,hql);
		 return pageObject;
				
	}
    /**
     *  根据主键ID找到相应的图片路径
     *  @param id 主键ID
     *  @return picPath
     */
	public String getPicPath(String id) {
		return transBanknoteSeqHourDao.findPicPath(id);
	}

}

