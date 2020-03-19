/**
 * 文件名：FlexClientData.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.vo;

import java.util.Map;

/**
 * 客户端依赖用户信息.
 * 
 * @author yrliang
 * 
 */
@Deprecated
public class FlexClientData {
	private Map<String, Object> userInfo;
	private String userResources; // 用户授权访问的资源
	private String authResources; // 受权限控制的资源, 只有这些资源需要验证权限

	/**
	 * @return 用户信息
	 */
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

	/**
	 * @return 用户资源
	 */
	public String getUserResources() {
		return userResources;
	}

	/**
	 * @param userResources
	 *            用户资源
	 */
	public void setUserResources(String userResources) {
		this.userResources = userResources;
	}

	/**
	 * @return 权限资源
	 */
	public String getAuthResources() {
		return authResources;
	}

	/**
	 * @param authResources
	 *            权限资源
	 */
	public void setAuthResources(String authResources) {
		this.authResources = authResources;
	}

}
