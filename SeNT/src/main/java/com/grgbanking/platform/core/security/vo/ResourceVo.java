/**
 * 文件名：ResourceVo.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.vo;

/**
 * 受保护的资源.
 * 
 * @author yrliang
 */
public class ResourceVo {
	// -- resourceType常量 --//
	/** url TYPE */
	public static final String URL_TYPE = "url";
	/** method TYPE */
	public static final String METHOD_TYPE = "method";
	/** menu TYPE */
	public static final String MENU_TYPE = "menu";
	/** button TYPE */
	public static final String BUTTON_TYPE = "button";

	private String resourceType;
	private String value;
	private String authNames;

	/**
	 * @return 资源类型.
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @param resourceType
	 *            资源类型
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * @return 资源标识.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            资源标识
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return 资源对应角色名 ","分隔.
	 */
	public String getAuthNames() {
		return authNames;
	}

	/**
	 * @param authNames
	 *            资源对应角色名 ","分隔.
	 */
	public void setAuthNames(String authNames) {
		this.authNames = authNames;
	}

}
