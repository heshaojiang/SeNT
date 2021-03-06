/**
 * 文件名：Md5PasswordEncoder.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service;

import org.springframework.stereotype.Component;

import com.grgbanking.platform.core.security.service.interfaces.IPasswordEncoder;
import com.grgbanking.platform.core.utils.MD5Util;

/**
 * MD5加密组件.
 * 
 * @author yrliang
 */
@Component
public class Md5PasswordEncoder implements IPasswordEncoder {

	/**
	 * 对文本进行md5加密
	 * 
	 * @param text
	 *            待加密字符
	 * @return 加密后字符
	 */
	public String encrypt(String text) {
		return MD5Util.stringToMD5(text);
	}

}
