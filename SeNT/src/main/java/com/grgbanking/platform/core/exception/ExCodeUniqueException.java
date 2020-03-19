/**
 * 文件名：ExCodeUniqueException.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.exception;

/**
 * 异常代码、抛出异常的类名、抛出异常的方法必须唯一异常
 * 
 * @author yrliang
 * 
 */
@Deprecated
public class ExCodeUniqueException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 构造函数
	 * 
	 * @param message
	 *            写出
	 */
	public ExCodeUniqueException(String message) {
		super(message);
	}

	/**
	 * 构造函数
	 */
	public ExCodeUniqueException() {
		super();
	}

}
