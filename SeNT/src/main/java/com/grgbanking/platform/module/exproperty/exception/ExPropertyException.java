/**
 * 文件名：ExPropertyException.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.exproperty.exception;

import com.grgbanking.platform.core.exception.SysException;

/**
 * @author yrliang <br>
 *         扩展属性相关异常
 */
public class ExPropertyException extends SysException {
	public ExPropertyException(String message) {
		super(message);
	}

	public ExPropertyException(String message, Exception ex) {
		super(message, ex);
	}
}
