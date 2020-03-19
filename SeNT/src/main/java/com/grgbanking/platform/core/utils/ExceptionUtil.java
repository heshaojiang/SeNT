/**
 * 文件名：ExceptionUtil.java
 * 创建日期： 2012-5-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常堆栈处理异常类.
 * 
 * @author yrliang
 * 
 */
public class ExceptionUtil {
	/**
	 * 把异常堆栈的信息输出到StringBuffer后.
	 * 
	 * @param e
	 *            需要处理的异常
	 * @return 异常堆栈转换成StringBuffer
	 */
	public static StringBuffer bufferExceptionTrace(Throwable e) {
		if (e != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return sw.getBuffer();
		}
		return null;
	}

	/**
	 * 获得堆栈信息.
	 * 
	 * @param e
	 *            需要处理的异常
	 * @return 异常堆栈转换成String
	 */
	public static String getExceptionTrace(Throwable e) {
		return bufferExceptionTrace(e).toString();
	}
}
