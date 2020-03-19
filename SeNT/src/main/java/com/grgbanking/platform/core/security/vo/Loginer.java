/**
 * 文件名：Loginer.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.vo;

import java.util.Map;

import org.springframework.security.GrantedAuthority;

/**
 * 覆盖SpringSecurity的User, 添加其他用户信息.
 * 
 * @author yrliang
 * 
 */
@SuppressWarnings("serial")
public class Loginer extends org.springframework.security.userdetails.User
{
	
	public static final String USER_INFO_ORG_ID = "orgId";
	
	
	private Map<String, Object> userInfo;

	/**
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param enabled
	 *            启用
	 * @param accountNonExpired
	 *            账号非过期
	 * @param credentialsNonExpired
	 *            密码非过期
	 * @param accountNonLocked
	 *            账号锁定
	 * @param authorities
	 *            权限
	 */
	public Loginer(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, GrantedAuthority[] authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// setAccountNonLocked(accountNonLocked);
	}

	/** @return 用户信息 */
	public Map<String, Object> getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo
	 *            用户信息
	 */
	public void setUserInfo(Map<String, Object> userInfo) {
		this.userInfo = userInfo;
	}

}
