/**
 * 文件名：ConfigurableConstants.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 可用Properties文件配置的Constants基类.
 * 本类既保持了Constants的static和final(静态与不可修改)特性,又拥有了可用Properties文件配置的特征,
 * 主要是应用了Java语言中静态初始化代码的特性.
 * <p/>
 * 子类可如下编写
 * 
 * <pre>
 * public class Constants extends ConfigurableConstants {
 *  static {
 *    init("xxxx.properties");
 * }
 * <p/>
 * public final static String ERROR_BUNDLE_KEY = getProperty("constant.error_bundle_key", "errors"); }
 * </pre>
 * 
 * @author calvin
 */
public class ConfigurableConstants {
	/** 日志对象 */
	protected static Logger logger = LoggerFactory.getLogger(ConfigurableConstants.class);
	/** 属性对象 */
	protected static Properties p = new Properties();

	/**
	 * 静态读入属性文件到Properties p变量中.
	 */
	protected static void init(String propertyFileName) {
		InputStream in = null;
		try {
			in = ConfigurableConstants.class.getClassLoader().getResourceAsStream(propertyFileName);
			if (in != null) {
				p.load(in);
			}
		} catch (IOException e) {
			logger.error("load " + propertyFileName + " into Constants error!");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error("close " + propertyFileName + " error!");
				}
			}
		}
	}

	/**
	 * 封装了Properties类的getProperty函数,使p变量对子类透明.
	 * 
	 * @param key
	 *            property key.
	 * @param defaultValue
	 *            当使用property key在properties中取不到值时的默认值.
	 */
	protected static String getProperty(String key, String defaultValue) {
		return p.getProperty(key, defaultValue);
	}
}
