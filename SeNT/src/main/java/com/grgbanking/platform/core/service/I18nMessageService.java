/**
 * 文件名：I18nMessageService.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.service;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.grgbanking.platform.core.spring.RegexPropertyMessageResources;

/**
 * 国际化服务，Spring容器启动后才能使用.
 * 
 * @author yrliang
 * 
 */
@Service
public class I18nMessageService implements ApplicationContextAware {
	private static Logger logger = LoggerFactory
			.getLogger(I18nMessageService.class);

	@Autowired
	RegexPropertyMessageResources msgResource;

	private ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
	 * 
	 * @param applicationContext
	 *            应用上下文
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * get i18n message by key
	 * 
	 * @param key
	 *            关键字
	 * @param objects
	 *            参数数组
	 * @return 国际化消息
	 */
	public String getMessage(String key, Object... objects) {
		return getMessage(key, Locale.getDefault(), objects);

	}

	/**
	 * get i18n message by local and key
	 * 
	 * @param key
	 *            关键字
	 * @param objects
	 *            参数数组
	 * @param locale
	 *            本地语言
	 * @return 国际化消息
	 */
	public String getMessage(String key, Locale locale, Object... objects) {
		// return applicationContext.getMessage(key, objects, locale);
		return msgResource.getMessage(key, objects, locale);
	}
}
