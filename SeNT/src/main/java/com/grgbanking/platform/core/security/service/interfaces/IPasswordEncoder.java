/**
 * 文件名：PasswordEncoder.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service.interfaces;

/**
 * 字符串加密接口.
 * 
 * @author yrliang
 */
public interface IPasswordEncoder {
	/**
	 * 
	 * @param text
	 *            待加密字符
	 * @return 加密后字符
	 */
	String encrypt(String text);
}
