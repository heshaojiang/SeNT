/**
 * 文件名：MessageException.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.exception;

/**
 * 
 * @author yrliang
 * 
 */
@SuppressWarnings("serial")
@Deprecated
public class MessageException extends RuntimeException {
	/** 错误级别 */
	protected int level;
	/** 错误代码 */
	protected String errorCode;
	/** 错误消息 */
	protected String errorMessage;

	/**
	 * 构造函数
	 */
	public MessageException() {
	}

	/**
	 * @return 错误消息
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            错误消息
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		StringBuffer strexc = new StringBuffer();

		strexc.append(this.getClass().getName());
		strexc.append(":[errCode=").append(getErrorCode());
		strexc.append(", message=").append(getErrorMessage());
		strexc.append("]");

		return strexc.toString();
	}

	/**
	 * 
	 * @return level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * 
	 * @param level
	 *            level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 
	 * @return errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * 
	 * @param errorCode
	 *            errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
