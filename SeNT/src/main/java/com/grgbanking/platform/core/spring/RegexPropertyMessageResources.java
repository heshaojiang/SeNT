/**
 * 文件名：RegexPropertyMessageResources.java
 * 创建日期： 2012-2-23
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.spring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * 解析通配符方式的路径，加载国际化资源文件
 * 
 * @author yrliang
 * 
 */
public class RegexPropertyMessageResources extends AbstractMessageResources {
	private static Logger logger = LoggerFactory.getLogger(RegexPropertyMessageResources.class);

	/** 属性文件后缀名 */
	public static String PROPERTY_POSTFIX = ".properties";
	// 加载属性资源文件
	// private ResourceBundleMessageSource resourceBundleMessageSource = new
	// ResourceBundleMessageSource();
	private ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
	// 支持通配符匹配　
	private PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

	/**
	 * 构造函数
	 */
	public RegexPropertyMessageResources() {

	}

	/**
	 * 构造函数
	 * 
	 * @param baseName
	 *            baseName
	 */
	public RegexPropertyMessageResources(String baseName) {
		setBaseNames(new String[] { baseName });
	}

	/**
	 * 构造函数
	 * 
	 * @param baseNames
	 *            baseNames
	 */
	public RegexPropertyMessageResources(String[] baseNames) {
		setBaseNames(baseNames);
	}

	/**
	 * 匹配一个路径
	 * 
	 * @param baseName
	 *            baseName
	 */
	public void setBaseName(String baseName) {
		setBaseNames(new String[] { baseName });
	}

	/**
	 * 匹配多个路径
	 * 
	 * @param baseNames
	 *            baseNames
	 */
	public void setBaseNames(String[] baseNames) {
		List<String> baseNameList = new ArrayList<String>();
		for (String baseName : baseNames) {
			Resource[] resources;
			try {
				resources = patternResolver.getResources(baseName); // 通过通配符取得到所有对应的source
				for (Resource resource : resources) {
					String fileName = resource.getURL().getPath();
					fileName = fileName.substring(fileName.indexOf("classes") + 7);

					// 除掉后的.properties后缀，因为直接用ResourceBundleMessageSource，是不用加后缀的
					baseNameList.add(fileName.substring(0, fileName.indexOf(PROPERTY_POSTFIX)));
					logger.info("Add i18n properties file: [{}]", resource.getDescription());
				}
			} catch (IOException e) {
				logger.error("Can not resolver path: [{}]", baseName);
			}

		}
		this.resourceBundleMessageSource.setBasenames(baseNameList.toArray(new String[baseNameList.size()]));
	}

	// 取得属性对应的信息
	@Override
	public String getMessage(String key, Object[] params, String defaultMessage, Locale locale) {
		return this.resourceBundleMessageSource.getMessage(key, params, defaultMessage, locale);
	}

}
