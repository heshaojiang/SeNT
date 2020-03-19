/**
 * 文件名：LoginLogService.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.log.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.log.dao.LoginLogDao;
import com.grgbanking.platform.module.log.entity.LoginLog;

/**
 * login log service<br>
 * 登录日志管理服务类
 * 
 * @author yrliang
 */
@Service
@Transactional
public class LoginLogService extends BaseService
{
	@Autowired
	LoginLogDao loginLogDao;
	
	
	public void save(LoginLog loginLog)
	{
		loginLogDao.save(loginLog);
	}

	/**
	 * save a new login log <br>
	 * 记录新增的登录日志
	 * 
	 * @param loginLog
	 * @return boolean
	 */
	public boolean newLoginLog(LoginLog loginLog)
	{
		validateLoginLog(AppConstants.ACTION_TYPE_LOGIN, loginLog);

		loginLog.setLoginTime(new Date());

		loginLogDao.save(loginLog);

		logger.info("{} doing login in", new Object[] { loginLog.getUserId() });
		return true;
	}

	/**
	 * query login log by page object and filter <br>
	 * 根据分页对象和查询条件，进行分页查询
	 * 
	 * @param page
	 * @param userId
	 * @return Page<LoginLog>
	 */
	public Page<LoginLog> searchLoginLog(final Page<LoginLog> page, Map<String, Object> cond) {
		return loginLogDao.searchLoginLog(page, cond);
	}

//	/**
//	 * Update the logout time when user logout <br>
//	 * 当用户登出时记录登出时间
//	 * 
//	 * @param loginLog
//	 * @return boolean
//	 */
//	public boolean updateLogoutTime(LoginLog loginLog)
//	{
//		validateLoginLog(AppConstants.ACTION_TYPE_LOGOUT, loginLog);
//
//		// Get the current login user's login
//		Date currUserLoginTime = loginLogDao.getCurrUserLoginTime(loginLog.getUserId(), loginLog.getHostIp());
//		if( currUserLoginTime == null )
//		{
//			return false;
//		}
//
//		logger.debug("currUserLoginTime:?", currUserLoginTime);
//		// Get the current login user's login log
//		LoginLog currUserLoginLog = loginLogDao.getCurrUserLoginLog(loginLog.getUserId(), loginLog.getHostIp(), currUserLoginTime);
//		if( currUserLoginLog == null )
//		{
//			throw new AppException(MessageKeyConstants.LOGIN_LOG_NOT_FOUND, "Can not found the login log of current user.");
//		}
//		// Update the logout time when user logout
//		currUserLoginLog.setLogoutTime(new Date());
//
//		logger.info("{} doing login out", new Object[] { loginLog.getUserId() });
//		return true;
//	}

	/**
	 * Delete the login log<br>
	 * 删除一条登录日志记录
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteLoginLog(String id) {
		validateId(id);

		loginLogDao.delete(id);

		return true;
	}

	/**
	 * House keeping: Batch delete login logs<br>
	 * 批量删除登录日志
	 * 
	 * @param ids
	 * @return
	 */
	public boolean batchDelete(Collection<String> ids) {
		if (ids == null || ids.size() == 0) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected.");
		}

		for (String id : ids) {
			deleteLoginLog(id);
		}

		return true;
	}

	/**
	 * House keeping: Batch delete login logs xx days ago<br>
	 * 删除最近天数的登录日志
	 * 
	 * @param days
	 *            最近天数
	 * @return
	 */
	public void batchDelete(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -days);
		loginLogDao.deleteBeforeDate(cal.getTime());

	}

	/**
	 * Validate the primary key
	 * 
	 * @param id
	 * @return
	 */
	private boolean validateId(String id) {
		if (!StringUtils.hasText(id)) {
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD, "No record is selected.");
		}

		return true;
	}

	/**
	 * 日期：Jun 15, 2011<br>
	 * 版本：V1.0<br>
	 * 描述：validateLoginLog(Validate the login log form) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：Jun 15, 2011 10:37:12 PM <br>
	 * 创建人 Vinson<br>
	 * ===============================================<br>
	 * 修改日期：Jun 15, 2011<br>
	 * 修改人 Vinson<br>
	 * 修改描述 validateLoginLog(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param loginLog
	 * @param actionType
	 * @return boolean
	 * @Exception 异常对象 <br>
	 */
	private boolean validateLoginLog(String actionType, LoginLog loginLog)
	{
		if( loginLog == null )
		{
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL, "The Input is null. Please check and submit again. ");
		}

		if( !StringUtils.hasText(loginLog.getUserId()) )
		{
			throw new AppException(MessageKeyConstants.LOG_USER_ID_NOT_NULL, "The User Id is null.");
		}

		if( !StringUtils.hasText(loginLog.getHostIp()) )
		{
			throw new AppException(MessageKeyConstants.LOG_HOST_IP_NOT_NULL, "The Host IP is null.");
		}

		// Validate only when insert a new login log when user login
		if( AppConstants.ACTION_TYPE_LOGIN.equals(actionType) )
		{
			if( !StringUtils.hasText(loginLog.getResult()) )
			{
				throw new AppException(MessageKeyConstants.LOGIN_RESULT_NOT_NULL, "The Login Result is null");
			}
		}

		return true;
	}
}
