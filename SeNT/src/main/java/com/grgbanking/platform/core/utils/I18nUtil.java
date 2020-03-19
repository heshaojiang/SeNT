/**
 * 文件名：I18nUtil.java
 * 创建日期： 2012-5-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.grgbanking.platform.core.spring.SpringContextHolder;

/**
 * 国际化服务，Spring容器启动后才能使用.
 * 
 * @author yrliang
 * 
 */
@Service
public class I18nUtil {
	private static Logger logger = LoggerFactory.getLogger(I18nUtil.class);

	/** get i18n message by key */
	public static String getMessage(String key, Object... objects) {

		return getMessage(key, Locale.getDefault(), objects);

	}

	/** get i18n message by local and key */
	public static String getMessage(String key, Locale locale,
			Object... objects) {
		return SpringContextHolder.getApplicationContext().getMessage(key,
				objects, locale);

	}
}
