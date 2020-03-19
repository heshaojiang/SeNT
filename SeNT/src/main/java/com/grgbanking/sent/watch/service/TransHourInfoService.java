package com.grgbanking.sent.watch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.transmgr.dao.TranInfoDao;
import com.grgbanking.sent.transmgr.entity.TranInfo;
import com.grgbanking.sent.transmgr.service.TranInfoService;
import com.grgbanking.sent.watch.entity.TransHourInfo;
/**
 * 交易监控信息
 * 
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("unchecked")
@Service
@Transactional
public class TransHourInfoService extends BaseService {
	@Autowired
	TranInfoDao tranInfoDao;
	
	@Autowired
	OrgInfoDao orgInfoDao;
	@Autowired
	private ParamDao paramDao;
	@Autowired
	TranInfoService tranInfoService;
	/**
	 *新增一条交易监控信息
	 * 
	 * @param obj
	 *            TransHourInfo 交易监控对象
	 * @return boolean
	 */
	public boolean addTransHourInfo(TranInfo obj) {
		boolean flag = false;
		try {
			tranInfoDao.saveNew(obj);
			flag = true;
		} catch (AppException e) {
			flag = false;
			logger.error("", e);
		}
		return flag;
	}

	/**
	 * 交易监控对象
	 * 
	 * @param obj
	 *            TransHourInfo
	 * @return boolean
	 */
	public boolean deleteTransHourInfo(TransHourInfo obj) {
		boolean flag = false;
		try {
			tranInfoDao.delete(obj.getId());
			flag = true;
		} catch (AppException e) {
			logger.error("", e);
		}
		return flag;
	}

	/**
	 * 交易监控对象
	 * 
	 * @param obj
	 *            TransHourInfoʵ��
	 * @return boolean
	 */
	public boolean updateTransHourInfo(TranInfo obj) {
		boolean flag = false;
		try {
			tranInfoDao.copyUpdate(obj);
			flag = true;
		} catch (AppException e) {
			logger.error("", e);
			throw new NullPointerException();
		}
		return flag;
	}


	/**
	 *TransHourInfo 交易监控时间
	 * 
	 * @param id
	 *            编号
	 * @return TransHourInfo
	 */
	@Transactional(readOnly = true)
	public TranInfo getTransHourInfoObject(String id) {
		return (TranInfo) tranInfoDao.get(id);
	}

	/**
	 * 交易监控列表
	 * 
	 * @param journalNo
	 *            流水号
	 * @return List<TransHourInfo>
	 */
	@Transactional(readOnly = true)
	public List<TranInfo> getTransHourInfoByJournalNo(String journalNo) {
		String sql = " from TranInfo as t where t.c_td_journal_no='" + journalNo
				+ "'";
		return tranInfoDao.find(sql);	
	}
}