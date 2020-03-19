/**
 * 文件名：SpringSecurityUtils.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.springsecurity;

import java.util.Map;

import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.User;

import com.grgbanking.platform.core.security.vo.Loginer;
import com.grgbanking.platform.core.utils.AppCoreConstants;

/**
 * SpringSecurity的工具类.
 * 
 * @author calvin
 */
public class SpringSecurityUtils {

	/**
	 * 取得当前用户的登录名, 如果当前用户未登录则返回空字符串.
	 * 
	 * @return 用户名
	 */
	public static String getCurrentUserName() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth == null)
			return "";
		return auth.getName();
	}

	/**
	 * 取得当前用户, 返回值为SpringSecurity的User类及其子类, 如果当前用户未登录则返回null.
	 * 
	 * @param <T>
	 *            泛型参数对象
	 * @return 返回当前登录用户
	 */
	@SuppressWarnings("unchecked")
	public static <T extends User> T getCurrentUser()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if( principal == null || principal instanceof String )
			return null;
		return (T) principal;
	}

	/**
	 * 获取当前登录用户名称(userName)
	 * 
	 * @return 当前登录用户名称(userName)
	 */
	public static String getLoginUserName() {

		User currentUser = SpringSecurityUtils.getCurrentUser();

		if (null == currentUser)
			return null;

		Loginer loginer = (Loginer) currentUser;

		Map<String, Object> userInfo = loginer.getUserInfo();

		Object object = userInfo.get(AppCoreConstants.USER_NAME);

		return String.valueOf(object);

	}
}
