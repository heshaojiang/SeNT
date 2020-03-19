/**
 * 文件名：ExceptionLogger.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.exception.handler;

import java.util.HashSet;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.utils.ExceptionUtil;

/**
 * 拦截系统异常记录日志.
 * 
 * @author yrliang
 * 
 */
@SuppressWarnings("unchecked")
public class ExceptionLogger {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Set<String> noCatchedExceptions = new HashSet<String>();

	/**
	 * 设置无需log的异常类名
	 * 
	 * @param noCatchedExceptions
	 *            例外异常
	 */
	public void setNoCatchedExceptions(Set<String> noCatchedExceptions) {
		this.noCatchedExceptions = noCatchedExceptions;
	}

	/**
	 * 捕获异常进行处理.
	 * 
	 * @param joinPoint
	 *            连接点
	 * @param ex
	 *            捕获的异常
	 */
	public void log(JoinPoint joinPoint, Throwable ex) {
		// 过滤不记录日志的异常
		for (String exClassName : noCatchedExceptions) {
			try {
				Class clazz = Class.forName(exClassName.trim());
				if (clazz.isAssignableFrom(ex.getClass())) {
					return; // 类似Clazz obj = ex;
				}
			} catch (ClassNotFoundException e1) {
				logger.error("applicationContext-exception: propertity noCatchedExceptions setting error", e1);
			}
		}

		// List<Object> args = java.util.Arrays.asList(joinPoint.getArgs());
		// String strArgs = args.toString();
		// Object[] objs = new Object[] { joinPoint.getSignature().getName(),
		// strArgs.substring(0, strArgs.length() - 1).substring(1) };
		// String message = "{}({}) execute error!!";
		Object[] objs = new Object[] { joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName() };
		String message = "{}.{}() execute error!!\r\n        StackTrace: ";
		StringBuffer buf = new StringBuffer(message).append(ExceptionUtil.bufferExceptionTrace(ex));
		logger.error(buf.toString(), objs, ex);
	}

}
