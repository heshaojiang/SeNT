/**
 * 文件名：SysException.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.exception;

/**
 * 系统异常，需要记录错误日志，并通知开发或维护人员，此类异常无需抛到视图层，因为对于这类异常，客户无法处理. 由框架提供统一的错误提示消息
 * 
 * @author yrliang
 */
@SuppressWarnings( { "serial" })
public class SysException extends RuntimeException implements IMessage {

	/**
	 * @return key
	 */
	public String getMsgKey() {
		return CoreMessageKeyConstants.SYS_EXCEPTION;
	}

	/**
	 * 构造函数
	 */
	public SysException() {
		super();
	}

	/**
	 * 构造函数
	 * 
	 * @param message
	 *            消息
	 */
	public SysException(String message) {
		super(message);
	}

	/**
	 * 构造函数
	 * 
	 * @param cause
	 *            异常
	 */
	public SysException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造函数
	 * 
	 * @param message
	 *            消息
	 * @param cause
	 *            异常
	 */
	public SysException(String message, Throwable cause) {
		super(message, cause);
	}

}
