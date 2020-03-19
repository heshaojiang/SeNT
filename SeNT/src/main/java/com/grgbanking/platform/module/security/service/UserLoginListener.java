/** 
 * 
 * Copyright:   Copyright (c) 2011 
 * Company:     GRGBanking
 * @author:     VZ
 * Create at:   03 Jun 2011
 * 
 * Modification History: 
 * Date         Author      Description 
 * -----------  ---------   ---------------------------------------- 
 * 03 Jun 2011	VZ			Initial Create
 */

package com.grgbanking.platform.module.security.service;

/**
 * User Login Listener<br>
 * 用户登录监听器.
 * 
 * @author vinson
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.Authentication;
import org.springframework.security.BadCredentialsException;
import org.springframework.security.context.SecurityContextImpl;
import org.springframework.security.event.authentication.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.event.authentication.AuthenticationFailureDisabledEvent;
import org.springframework.security.event.authentication.AuthenticationSuccessEvent;
import org.springframework.security.ui.WebAuthenticationDetails;
import org.springframework.security.ui.session.HttpSessionDestroyedEvent;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.security.service.Des;
import com.grgbanking.platform.core.security.vo.Loginer;
import com.grgbanking.platform.core.utils.AppCoreConstants;
import com.grgbanking.platform.module.log.entity.LoginLog;
import com.grgbanking.platform.module.log.service.LoginLogService;
import com.grgbanking.platform.module.param.service.ParamService;
import com.grgbanking.platform.module.security.entity.User;

/**
 * 用户登录监听类
 * 
 * @author yrliang
 */
@Transactional
public class UserLoginListener implements ApplicationListener
{
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	
	/**
	 * Constants: Login Exception Messages
	 */
	private static final String USER_NOT_FOUND = "userNameNotFound";
	private static final String WRONG_PASSWORD = "wrongPassword";
	private static final String ACCOUNT_LOCKED = "accountIsLocked";
	//private static final String ACCOUNT_LOGIN_LOCKED = "accountLoginLocked";

	
	
	// Max Login Fail Count. System will lock the user account if user login
	// fail for mare than the MAX_LOGIN_FAIL_COUNT
	private int maxLoginFailCount = 5;
	private String strMaxLoginFailCount;

	
	
	private ServletContext servletContext;
	private UserService userService;
	private LoginLogService loginLogService;

	
	
	
	@Autowired
	public void setParamService(ParamService paramService)
	{
		strMaxLoginFailCount = paramService.getValueByPath(AppConstants.MAX_LOGIN_FAIL_COUNT);
		try
		{
			maxLoginFailCount = Integer.parseInt(strMaxLoginFailCount);
		}
		catch (NumberFormatException e)
		{
			logger.error("parameter [{}] setting error!", AppConstants.MAX_LOGIN_FAIL_COUNT);
		}
		if (servletContext != null)
		{
			servletContext.setAttribute(AppConstants.MAX_LOGIN_FAIL_COUNT, strMaxLoginFailCount);
		}
	}

	
	public void setServletContext(ServletContext servletContext)
	{
		this.servletContext = servletContext;
		if (strMaxLoginFailCount != null)
		{
			servletContext.setAttribute(AppConstants.MAX_LOGIN_FAIL_COUNT, strMaxLoginFailCount);
		}
	}

	
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	
	public void setLoginLogService(LoginLogService loginLogService)
	{
		this.loginLogService = loginLogService;
	}

	
	/**
	 * Lister the user login event, lock user account when input wrong password
	 * for three times
	 */
	public void onApplicationEvent(ApplicationEvent event)
	{
		if (event instanceof AuthenticationFailureBadCredentialsEvent)
		{
			AuthenticationFailureBadCredentialsEvent authEvent = (AuthenticationFailureBadCredentialsEvent) event;
			Authentication authentication = (Authentication) authEvent.getSource();

			String username = (String) authentication.getPrincipal();
			Des desObj = new Des();
			username = desObj.strDec(username, "0123456789", null, null);
			Exception ex = ((AuthenticationFailureBadCredentialsEvent) event).getException();
			// Handle for the case of user name not found
			if (!(ex instanceof UsernameNotFoundException))
			{
				addCount(username);
			}

			WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) authentication.getDetails();
			LoginLog loginLog = new LoginLog();
			loginLog.setUserId(username);
			loginLog.setResult(AppCoreConstants.LOGIN_FAIL);
			loginLog.setHostIp(webAuthenticationDetails.getRemoteAddress());
			if (ex instanceof UsernameNotFoundException)
			{
				loginLog.setNote(USER_NOT_FOUND);
			}
			else if (ex instanceof BadCredentialsException)
			{
				Loginer loginer = (Loginer) authEvent.getException().getExtraInformation();
				loginLog.setUserName((String) loginer.getUserInfo().get(AppCoreConstants.USER_NAME));
				loginLog.setNote(WRONG_PASSWORD);
			}
			loginLogService.newLoginLog(loginLog);
		}
		else if (event instanceof AuthenticationFailureDisabledEvent)
		{
			// Handle for the case of user is locked
			AuthenticationFailureDisabledEvent authEvent = (AuthenticationFailureDisabledEvent) event;
			Authentication authentication = (Authentication) authEvent.getSource();
			String username = (String) authentication.getPrincipal();

			Des desObj = new Des();
			username = desObj.strDec(username, "0123456789", null, null);
			WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) authentication.getDetails();
			Loginer loginer = (Loginer) authEvent.getException().getExtraInformation();

			LoginLog loginLog = new LoginLog();
			loginLog.setUserId(username);
			loginLog.setUserName((String) loginer.getUserInfo().get(AppCoreConstants.USER_NAME));
			loginLog.setResult(AppCoreConstants.LOGIN_FAIL);
			loginLog.setHostIp(webAuthenticationDetails.getRemoteAddress());
			loginLog.setNote(ACCOUNT_LOCKED);

			loginLogService.newLoginLog(loginLog);
		}
		else if (event instanceof AuthenticationSuccessEvent)
		{
			// Handle for the case of user is login successfull
			AuthenticationSuccessEvent authEvent = (AuthenticationSuccessEvent) event;
			Authentication authentication = (Authentication) authEvent.getSource();
			Loginer loginer = (Loginer) authentication.getPrincipal();
			String username = loginer.getUsername();

			cleanCount(username);

			WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) authentication.getDetails();
			String clientIp = webAuthenticationDetails.getRemoteAddress();
			boolean locked = false;
			User baseInfo = (User) (loginer.getUserInfo().get(AppConstants.USER_BASE_INFO));
			if (baseInfo.getIp() != null && baseInfo.getIp().trim().length() > 0 && !baseInfo.getIp().equals(clientIp))
			{
				locked = true;
			}
			loginer.getUserInfo().put(AppCoreConstants.LOCKED_WITH_IP, locked);
			LoginLog loginLog = new LoginLog();
			loginLog.setUserId(username);
			loginLog.setUserName((String) loginer.getUserInfo().get(AppCoreConstants.USER_NAME));
			loginLog.setResult(AppCoreConstants.LOGIN_SUCCESS);
			loginLog.setHostIp(clientIp);
			if (locked)
			{
				loginLog.setResult(AppCoreConstants.LOGIN_FAIL);
			}
			loginLogService.newLoginLog(loginLog);
			loginer.getUserInfo().put(AppCoreConstants.LOGIN_LOG, loginLog);
			
			// 缓存用户登录账号
			Map<String, String> map = getLoginUserMap();
			map.put(username, "logined");
		}
		else if (event instanceof HttpSessionDestroyedEvent)
		{
			HttpSessionDestroyedEvent destroyedEvent = (HttpSessionDestroyedEvent) event;
			SecurityContextImpl securityContext = (SecurityContextImpl) destroyedEvent.getSession().getAttribute(AppCoreConstants.SPRING_SECURITY_CONTEXT);
			if (securityContext != null)
			{
				Loginer loginer = (Loginer) securityContext.getAuthentication().getPrincipal();
				//WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) securityContext.getAuthentication().getDetails();
				
				LoginLog loginLog = (LoginLog)loginer.getUserInfo().get(AppCoreConstants.LOGIN_LOG);
				loginLog.setLogoutTime(new Date());
				loginLogService.save(loginLog);
				//loginLogService.updateLogoutTime(loginLog);

				// 从缓存移除用户登录账号
				Map<String, String> map = getLoginUserMap();
				map.remove(loginer.getUsername());
			}

		}
	}

	/**
	 * 日期：2011-6-2<br>
	 * 版本：V1.0<br>
	 * 描述：addCount(Add the user login failure count number, when user login fail
	 * for three time, system will lock the user account) <br>
	 * 主要方法：<br>
	 * ===============================================<br>
	 * 创建日期：2011-6-2 下午01:46:50 <br>
	 * 创建人 Vinson<br>
	 * ===============================================<br>
	 * 修改日期：2011-6-2<br>
	 * 修改人 Vinson<br>
	 * 修改描述 addCount(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param username
	 *            void
	 * @Exception 异常对象 <br>
	 */
	private void addCount(String username)
	{
		// Default is not locked
		int loginFailCount = userService.incrementLoginFailCount(username);
		// when user login fail count bigger then the MAX_LOGIN_FAIL_COUNT_NO,
		// the user will be locked
		if (loginFailCount >= maxLoginFailCount)
		{
			userService.disableUserByUserCode(username);
		}
	}

	/**
	 * 日期：2011-6-2<br>
	 * 版本：V1.0<br>
	 * 描述：cleanCount(Clean the user login failure count when login success) <br>
	 * 主要方法：<br>
	 * ===============================================<br>
	 * 创建日期：2011-6-2 下午01:48:34 <br>
	 * 创建人 Vinson<br>
	 * ===============================================<br>
	 * 修改日期：2011-6-2<br>
	 * 修改人 Vinson<br>
	 * 修改描述 cleanCount(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param username
	 *            void
	 * @Exception 异常对象 <br>
	 */
	private void cleanCount(String username)
	{
		userService.clearLoginFailCount(username);
	}

//	/**
//	 * 日期：2011-6-2<br>
//	 * 版本：V1.0<br>
//	 * 描述：setLockUserMap(set the key value of lockUserMap) <br>
//	 * 主要方法：<br>
//	 * ===============================================<br>
//	 * 创建日期：2011-6-2 下午02:52:33 <br>
//	 * 创建人 Vinson<br>
//	 * ===============================================<br>
//	 * 修改日期：2011-6-2<br>
//	 * 修改人 Vinson<br>
//	 * 修改描述 setLockUserMap(这里用一句话描述这个方法修改原因和作用) <br>
//	 * ===============================================<br>
//	 * 
//	 * @param username
//	 * @param loginFailCount
//	 * @param isUserLocked
//	 * @param isUserExisted
//	 *            void
//	 * @Exception 异常对象 <br>
//	 */
//	@SuppressWarnings( { "unchecked", "rawtypes" })
//	private void setLockUserMap(String username, int loginFailCount, String isUserLocked, String isUserExisted)
//	{
//		Map<String, Object> lockUserMap = getLockUserMap();
//
//		lockUserMap.put(AppCoreConstants.USER_CODE, username);
//		lockUserMap.put(username, loginFailCount);
//		lockUserMap.put(AppCoreConstants.IS_USER_LOCKED, isUserLocked);
//		lockUserMap.put(AppCoreConstants.IS_USER_EXISTED, isUserExisted);
//	}
//
//	/**
//	 * 日期：2011-6-2<br>
//	 * 版本：V1.0<br>
//	 * 描述：getLockUserMap(The user Login information will be cached in the same
//	 * IE session. including: USER_CODE, IS_USER_LOCKED, USER_NOT_FOUND and
//	 * login failure count) <br>
//	 * 主要方法：<br>
//	 * ===============================================<br>
//	 * 创建日期：2011-6-2 下午01:49:23 <br>
//	 * 创建人 Vinson<br>
//	 * ===============================================<br>
//	 * 修改日期：2011-6-2<br>
//	 * 修改人 Vinson<br>
//	 * 修改描述 getLockUserMap(这里用一句话描述这个方法修改原因和作用) <br>
//	 * ===============================================<br>
//	 * 
//	 * @param
//	 * @return Map - LOCK_USER_MAP
//	 * @Exception 异常对象 <br>
//	 */
//	@SuppressWarnings("unchecked")
//	private Map<String, Object> getLockUserMap()
//	{
//		Map<String, Object> lockUserMap = (Map<String, Object>) servletContext.getAttribute(AppCoreConstants.LOCK_USER_MAP);
//
//		if (lockUserMap == null)
//		{
//			lockUserMap = new HashMap<String, Object>();
//			servletContext.setAttribute(AppCoreConstants.LOCK_USER_MAP, lockUserMap);
//		}
//
//		return lockUserMap;
//	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getLoginUserMap()
	{
		Map<String, String> lockUserMap = (Map<String, String>) servletContext.getAttribute(AppCoreConstants.LOGIN_USER_MAP);

		if (lockUserMap == null)
		{
			lockUserMap = new HashMap<String, String>();
			servletContext.setAttribute(AppCoreConstants.LOGIN_USER_MAP, lockUserMap);
		}

		return lockUserMap;
	}
}
