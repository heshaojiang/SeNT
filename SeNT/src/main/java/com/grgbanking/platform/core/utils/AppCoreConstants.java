/**
 * 文件名：AppCoreConstants.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

/**
 * This class is used to storing the Application Constants in order to improve
 * the coding reusability
 * 
 * @author SONY
 */
public class AppCoreConstants {
	/** 空字符串"" */
	public static final String EMPTY_STR = "";
	/** 字符串"Y" */
	public static final String YES = "Y";
	/** 字符串"N" */
	public static final String NO = "N";
	/** 字符串"Success" */
	public static final String LOGIN_SUCCESS = "1";
	/** 字符串"Fail" */
	public static final String LOGIN_FAIL = "0";

	/** 字符"Y" */
	public static final char YES_CHAR = 'Y';
	/** 字符"N" */
	public static final char NO_CHAR = 'N';

	/** UTF8 */
	public static final String UTF8 = "UTF-8";
	/** GBK */
	public static final String GBK = "GBK";

	/**
	 * Attribute key of ServletContext.
	 * <p/>
	 * LOCK_USER_MAP 包含了用户登录系统时的响应信息，包括: userCode userName loginFailCount
	 * isUserLocked isUserExisted
	 */
	public static final String LOCK_USER_MAP = "LOCK_USER_MAP";

	/**
	 * Attribute key of ServletContext.
	 * <p/>
	 * LOGIN_USER_MAP 登陆用户账号
	 */
	public static final String LOGIN_USER_MAP = "LOGIN_USER_MAP";

	/**
	 * Attribute key of ServletContext.
	 * <p/>
	 * LOGIN_USER_MAP 登陆用户账号
	 */
	public static final String PASSWORD_EXPIRED_USER_SET = "PASSWORD_EXPIRED_USER_SET";

	/** Key to indicate whether user is locked */
	public static final String IS_USER_LOCKED = "isUserLocked";
	/** Key to indicate whether user is existed */
	public static final String IS_USER_EXISTED = "isUserExisted";

	/** User Code field */
	public static final String USER_CODE = "userCode";
	/** User Name field */
	public static final String USER_NAME = "userName";
	/** LoginPwd field */
	public static final String LOGIN_PWD = "loginPwd";
	/** Default when create a new user and reset the user password */
	public static final String DEFAULT_PWD = "111111";
	/** defaultPassword field */
	public static final String DEFAULT_PWD_KEYNAME = "defaultPassword";
	/** Status field */
	public static final String STATUS = "status";

	/** multiOnline field */
	public static final String MULTI_ONLINE = "multiOnline";

	/** Status that is enabled */
	public static final String STATUS_ENABLE = "Y";
	/** Status that is disabled */
	public static final String STATUS_DISABLE = "N";
	/** Constant for SPRING_SECURITY_CONTEXT */
	public static final String SPRING_SECURITY_CONTEXT = "SPRING_SECURITY_CONTEXT";
	/** Constant for LOCKED_WITH_IP */
	public static final String LOCKED_WITH_IP = "LOCKED_WITH_IP";
	
	public static final String LOGIN_LOG = "LOGIN_LOG";
}
