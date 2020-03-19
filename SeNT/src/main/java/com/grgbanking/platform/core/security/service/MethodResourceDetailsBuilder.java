/**
 * 文件名：MethodResourceDetailsBuilder.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.ConfigAttributeEditor;
import org.springframework.security.intercept.method.MapBasedMethodDefinitionSource;
import org.springframework.security.intercept.method.MethodDefinitionSource;
import org.springframework.stereotype.Component;

import com.grgbanking.platform.core.security.service.interfaces.IMethodResourceDetailsService;

/**
 * 创建MethodDefinitionSource.
 * 
 * @author yrliang
 * 
 */
@Component
public class MethodResourceDetailsBuilder {
	@Autowired
	private IMethodResourceDetailsService resourceDetailsService;

	/**
	 * 创建MethodDefinitionSource.
	 * 
	 * @return 方法定义来源
	 */
	public MethodDefinitionSource createMethodSource() {
		return new MapBasedMethodDefinitionSource(this.buildMethodMap());

	}

	protected Map<String, ConfigAttributeDefinition> buildMethodMap() {
		Map<String, ConfigAttributeDefinition> methodMap = null;
		methodMap = new LinkedHashMap<String, ConfigAttributeDefinition>();

		ConfigAttributeEditor editor = new ConfigAttributeEditor();
		Map<String, String> resourceMap = resourceDetailsService.getMethodMap();

		for (Map.Entry<String, String> entry : resourceMap.entrySet()) {
			editor.setAsText(entry.getValue());
			methodMap.put(entry.getKey(), (ConfigAttributeDefinition) editor.getValue());
		}

		return methodMap;
	}
}
