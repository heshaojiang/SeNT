/**
 * 文件名：AppException.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.utils.AppCoreConstants;

/**
 * 
 * @author yrliang 应用异常，必须传入国际化消息对应的i18nKey
 */
@SuppressWarnings( { "serial" })
public class AppException extends RuntimeException implements IMessage {
	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private String msgKey;

	/**
	 * return i18n message key
	 * 
	 * @return 消息
	 */
	public String getMsgKey() {
		return msgKey;
	}

	/**
	 * 构造方法
	 * 
	 * @param msgKey
	 *            i18n message key
	 * @param logMessage
	 *            log message
	 */
	public AppException(String msgKey, String logMessage) {
		super(logMessage);
		this.msgKey = msgKey;
		if (msgKey == null || msgKey.trim().equals(AppCoreConstants.EMPTY_STR)) {
			logger.error("Message key can not be null!!");
		}
	}

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

	/*
	 * public AppException(String msgKey, String logMessage, Throwable cause) {
	 * super(logMessage, cause); this.msgKey = msgKey; if (msgKey == null ||
	 * msgKey.trim().equals(AppCoreConstants.EMPTY_STR)) {
	 * logger.error("Message key can not be null!!"); } }
	 */
}
