/**
 * 文件名：ExceptionMessageTransfer.java
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

import com.grgbanking.platform.core.exception.IMessage;
import com.grgbanking.platform.core.exception.SysException;

/**
 * 拦截系统异常记录日志，此通知必须在最后执行.
 * 
 * @author yrliang
 * 
 */
// @Aspect
// @Order(1)
@SuppressWarnings("unchecked")
public class ExceptionMessageTransfer {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Set<String> noCatchedExceptions = new HashSet<String>();

	// @Pointcut("execution(* com.grgbanking..service.*.*(..)) ")
	// public void serviceOperation() {
	// }
	//
	// @Pointcut("execution(* com.grgbanking.platform.core.exception.*.*(..))")
	// public void exceptionHandler() {
	// }
	//
	// @Pointcut("serviceOperation() || exceptionHandler()")
	// public void toHandleOperation() {
	// }
	/**
	 * @return 异常集合
	 */
	public Set<String> getNoCatchedExceptions() {
		return noCatchedExceptions;
	}

	/**
	 * 设置无需拦截的异常类名
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
	// @AfterThrowing(value = "toHandleOperation()", throwing = "ex")
	public void handle(JoinPoint joinPoint, Throwable ex) {
		/*
		 * 过滤无需处理的异常
		 */
		for (String exClassName : noCatchedExceptions) {
			try {
				Class clazz = Class.forName(exClassName);
				if (clazz.isAssignableFrom(ex.getClass())) {
					return; // 类似Clazz obj = ex;
				}
			} catch (ClassNotFoundException e1) {
				logger.error("applicationContext-exception: propertity noCatchedExceptions setting error", e1);
			}
		}

		// 转换成系统异常抛出
		if (ex instanceof IMessage) {
			return;
		}
		logger.debug("the original exception wrapped into sysexception!");
		throw new SysException("not handlered exception!!", ex);
	}

}
