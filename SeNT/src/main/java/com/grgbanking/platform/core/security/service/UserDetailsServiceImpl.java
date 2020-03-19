/**
 * 文件名：UserDetailsServiceImpl.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.security.service.interfaces.IUserService;
import com.grgbanking.platform.core.security.vo.Loginer;
import com.grgbanking.platform.core.service.I18nMessageService;
import com.grgbanking.platform.core.utils.AppCoreConstants;
import com.grgbanking.platform.core.utils.MD5Util;
import com.grgbanking.platform.module.security.service.UserLoginListener;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * 
 * @author yrliang
 */
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService
{

	private IUserService userService;

	@Autowired
	private I18nMessageService i18n;
	
	@Autowired
	private UserLoginListener loginListener;

	/**
	 * @param userService
	 *            IUserService
	 */
	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	private String defaultAuthority;

	/**
	 * 获取用户Details信息的回调函数.
	 * 
	 * @param userId
	 *            用户id
	 * @return UserDetails
	 */
	public UserDetails loadUserByUsername(String userId)
	{
		
		Des desObj = new Des();
		userId = desObj.strDec(userId, "0123456789", null, null);
		Map<String, Object> user = userService.getUserInfoByUserCode(userId);

		if( user==null || user.get(AppCoreConstants.USER_CODE)==null )
		{
			throw new UsernameNotFoundException(i18n.getMessage("UserDetailsServiceImpl.UsernameNotFound", new Object[] { userId }));
		}

		String userCode = (String) user.get(AppCoreConstants.USER_CODE);
		String password = (String) user.get(AppCoreConstants.LOGIN_PWD);
		GrantedAuthority[] grantedAuths = obtainGrantedAuthorities(user);

		// -- 示例中无以下属性, 暂时全部设为true. --//
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		// 账号已禁用
		if (AppCoreConstants.STATUS_DISABLE.equals(user.get(AppCoreConstants.STATUS)))
		{
			enabled = false;
		}

		// 账号已过期
		if (AppCoreConstants.YES.equals(user.get(AppConstants.ACCOUNT_EXPIRED)))
		{
			accountNonExpired = false;
		}

		 //是否支持同时登陆
		 if (AppCoreConstants.STATUS_DISABLE.equals(user
		 .get(AppCoreConstants.MULTI_ONLINE)))
		 {
		 Map map = (Map) loginListener.getLoginUserMap();
		 if (map.containsKey(userCode)) {
		 accountNonLocked = false;
		 }
		 }
		 else
		 {
		 accountNonLocked = true;
		 }
		String newPassword = MD5Util.stringToMD5(password);
		Loginer userdetail = new Loginer(userCode, newPassword, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		if (password.equals(MD5Util.stringToMD5(AppCoreConstants.DEFAULT_PWD)))
		{
			user.put(AppCoreConstants.DEFAULT_PWD_KEYNAME, true);
		}
		// 设置用户基本信息，供业务使用，清空密码
		user.remove(AppCoreConstants.LOGIN_PWD);
		userdetail.setUserInfo(user);

		return userdetail;
	}

	/**
	 * 获得用户所有角色的权限集合.
	 */
	private GrantedAuthority[] obtainGrantedAuthorities(Map<String, Object> user)
	{
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) user.get("authNameList");

		if (list != null)
		{
			for (String authName : list)
			{
				authSet.add(new GrantedAuthorityImpl(authName));
			}
		}

		if (defaultAuthority != null)
		{
			authSet.add(new GrantedAuthorityImpl(defaultAuthority));
		}
		return authSet.toArray(new GrantedAuthority[authSet.size()]);
	}

	/**
	 * @return 缺省权限
	 */
	public String getDefaultAuthority()
	{
		return defaultAuthority;
	}

	/**
	 * @param defaultAuthority
	 *            缺省权限
	 */
	public void setDefaultAuthority(String defaultAuthority)
	{
		this.defaultAuthority = defaultAuthority;
	}

}
