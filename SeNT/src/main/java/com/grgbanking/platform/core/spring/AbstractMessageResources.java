/**
 * 文件名：AbstractMessageResources.java
 * 创建日期： 2012-2-23
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.spring;

import java.util.Locale;

/**
 * @author yrliang
 * 
 */
public abstract class AbstractMessageResources {
	/**
	 * get i18n message by key
	 * 
	 * @param key
	 *            关键字
	 * @return 国际化消息
	 */
	public String getMessage(String key) {
		return getMessage(key, Locale.getDefault());
	}

	/**
	 * get i18n message by key
	 * 
	 * @param key
	 *            关键字
	 * @param param
	 *            参数
	 * @return 国际化消息
	 */
	public String getMessage(String key, Object param) {
		return getMessage(key, new Object[] { param }, null, Locale.getDefault());
	}

	/**
	 * get i18n message by key
	 * 
	 * @param key
	 *            关键字
	 * @param params
	 *            参数数组
	 * @return 国际化消息
	 */
	public String getMessage(String key, Object[] params) {
		return getMessage(key, params, Locale.getDefault());
	}

	/**
	 * get i18n message by local and key
	 * 
	 * @param key
	 *            关键字
	 * @param params
	 *            参数数组
	 * @param locale
	 *            本地语言
	 * @return 国际化消息
	 */
	public String getMessage(String key, Object[] params, Locale locale) {
		return getMessage(key, params, null, locale);
	}

	/**
	 * get i18n message by local and key
	 * 
	 * @param key
	 *            关键字
	 * @param locale
	 *            本地语言
	 * @return 国际化消息
	 */
	public String getMessage(String key, Locale locale) {
		return getMessage(key, null, null, locale);
	}

	/**
	 * get i18n message by local and key
	 * 
	 * @param key
	 *            关键字
	 * @param param
	 *            参数
	 * @param locale
	 *            本地语言
	 * @return 国际化消息
	 */
	public String getMessage(String key, Object param, Locale locale) {
		return getMessage(key, new Object[] { param }, null, locale);
	}

	/**
	 * get i18n message by local and key
	 * 
	 * @param key
	 *            关键字
	 * @param params
	 *            参数数组
	 * @param defaultMessage
	 *            缺省消息
	 * @param locale
	 *            本地语言
	 * @return 国际化消息
	 */
	public abstract String getMessage(String key, Object[] params, String defaultMessage, Locale locale);

}
