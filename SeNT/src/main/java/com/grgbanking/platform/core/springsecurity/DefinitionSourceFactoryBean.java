/**
 * 文件名：DefinitionSourceFactoryBean.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.springsecurity;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.ConfigAttributeEditor;
import org.springframework.security.intercept.web.DefaultFilterInvocationDefinitionSource;
import org.springframework.security.intercept.web.FilterInvocationDefinitionSource;
import org.springframework.security.intercept.web.RequestKey;
import org.springframework.security.util.AntUrlPathMatcher;
import org.springframework.security.util.UrlMatcher;

/**
 * DefinitionSource工厂.
 * 
 * 由注入的resourceDetailService读取在数据库或其它地方中定义的URL-授权关系, 提供LinkedHashMap<String,
 * String>形式的URL及授权关系定义， 并最终转为SpringSecurity所需的LinkedHashMap<RequestKey,
 * ConfigAttributeDefinition>形式的定义.
 * 
 * @see org.springframework.security.intercept.web.DefaultFilterInvocationDefinitionSource
 * @see IResourceDetailsService
 * 
 * @author calvin
 */
public class DefinitionSourceFactoryBean implements FactoryBean {

	private IResourceDetailsService resourceDetailsService;

	/**
	 * @param resourceDetailsService
	 *            IResourceDetailsService
	 */
	public void setResourceDetailsService(IResourceDetailsService resourceDetailsService) {
		this.resourceDetailsService = resourceDetailsService;
	}

	/**
	 * 返回注入了AntStyle的URLMatcher和ResourceDetailService提供的RequestMap的DefaultFilterInvocationDefinitionSource
	 * .
	 * 
	 * @return Object
	 * @throws Exception
	 *             异常
	 */
	public Object getObject() throws Exception {
		LinkedHashMap<RequestKey, ConfigAttributeDefinition> requestMap = buildRequestMap();
		UrlMatcher matcher = getUrlMatcher();
		DefaultFilterInvocationDefinitionSource definitionSource = new DefaultFilterInvocationDefinitionSource(matcher,
				requestMap);
		return definitionSource;
	}

	/**
	 * @see FactoryBean#getObjectType()
	 * @return Class
	 */
	@SuppressWarnings("unchecked")
	public Class getObjectType() {
		return FilterInvocationDefinitionSource.class;
	}

	/**
	 * @see FactoryBean#isSingleton()
	 * @return 是否单例
	 */
	public boolean isSingleton() {
		return true;
	}

	/**
	 * 提供Ant Style的URLMatcher.
	 */
	protected UrlMatcher getUrlMatcher() {
		return new AntUrlPathMatcher();
	}

	/**
	 * 将resourceDetailService提供LinkedHashMap<String, String>形式的URL及授权关系定义
	 * 转化为DefaultFilterInvocationDefinitionSource需要的LinkedHashMap<RequestKey,
	 * ConfigAttributeDefinition>形式.
	 */
	protected LinkedHashMap<RequestKey, ConfigAttributeDefinition> buildRequestMap() {
		LinkedHashMap<String, String> srcMap = resourceDetailsService.getRequestMap();
		LinkedHashMap<RequestKey, ConfigAttributeDefinition> distMap = new LinkedHashMap<RequestKey, ConfigAttributeDefinition>();
		ConfigAttributeEditor editor = new ConfigAttributeEditor();

		for (Map.Entry<String, String> entry : srcMap.entrySet()) {
			RequestKey key = new RequestKey(entry.getKey(), null);
			if (StringUtils.isNotBlank(entry.getValue())) {
				editor.setAsText(entry.getValue());
				distMap.put(key, (ConfigAttributeDefinition) editor.getValue());
			} else {
				distMap.put(key, ConfigAttributeDefinition.NO_ATTRIBUTES);
			}
		}

		return distMap;
	}
}
