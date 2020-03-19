/**
 * 文件名：RegExpUtils.java
 * 创建日期： 2012-6-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

/**
 * This is a Util class for Regular Expression
 * 
 * @author SONY
 */
public class RegExpUtils {
	/**
	 * This method is used to parse the user id
	 * 
	 * <P>
	 * The user name should be construct with a-z, A-Z, 0-9 and _, and the
	 * length must larger than 3 and less than 32
	 * 
	 * @param userId
	 * @return
	 */
	public static boolean parseUserId(String userId) {
		String regex = "^[a-zA-Z0-9_.-]{3,32}$";

		return userId.matches(regex);
	}

	/**
	 * This method is used to parse the password.
	 * 
	 * <P>
	 * The password must at least be contain with one number 0-9, one character
	 * and the length must larger than 6 and less than 32
	 * 
	 * @param password
	 * @return
	 */
	public static boolean parsePassword(String password) {
		String regex = "(?=.*[0-9])(?=.*[a-zA-Z]).{6,20}";

		return password.matches(regex);
	}
}
