/**
 * 文件名：BaseService.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础实体管理器，供继承.
 * 
 * @author yrliang
 * 
 */
public abstract class BaseService
{
	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

}
