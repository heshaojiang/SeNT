/**
 * 文件名：PasswordOverdueException.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.exception.extend;

import org.springframework.security.AuthenticationException;

/**
 * 密码过期异常
 * 
 * @author yrliang
 * @deprecated
 * 
 */
@Deprecated
@SuppressWarnings("serial")
public class PasswordOverdueException extends AuthenticationException {
	/**
	 * 改造函数
	 */
	public PasswordOverdueException() {
		super(null);
	}

	/**
	 * 改造函数
	 * 
	 * @param msg
	 *            提示消息
	 */
	public PasswordOverdueException(String msg) {
		super(msg);
	}

}
