/**
 * 文件名：RecordNotFoundException.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.dao.exception;

import com.grgbanking.platform.core.exception.AppException;

/**
 * 记录未找到异常
 * 
 * @author yrliang
 * 
 */
@SuppressWarnings("serial")
public class RecordNotFoundException extends AppException {
	/**
	 * 
	 * @param msgKey
	 *            国际化消息key
	 * @param logMessage
	 *            输出到日志的消息
	 */
	public RecordNotFoundException(String msgKey, String logMessage) {
		super(msgKey, logMessage);
	}

}
