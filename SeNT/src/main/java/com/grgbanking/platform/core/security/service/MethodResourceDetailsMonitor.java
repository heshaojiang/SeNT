/**
 * 文件名：MethodResourceDetailsMonitor.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.intercept.method.DelegatingMethodDefinitionSource;
import org.springframework.security.intercept.method.MethodDefinitionSource;

/**
 * Spring启动时负责初始化方法ResourceDetails.
 * 
 * @author yrliang
 * 
 */
public class MethodResourceDetailsMonitor implements InitializingBean {
	private DelegatingMethodDefinitionSource delegatingMethodDefinitionSource;
	private MethodResourceDetailsBuilder resourceDetailsBuilder;

	/**
	 * @throws Exception
	 *             异常
	 */
	public void afterPropertiesSet() throws Exception {
		// if (delegatingMethodDefinitionSource != null) {
		MethodDefinitionSource source = resourceDetailsBuilder.createMethodSource();
		List<MethodDefinitionSource> sources = new ArrayList<MethodDefinitionSource>();
		sources.add(source);

		// sources.add(new SecuredMethodDefinitionSource());
		// sources.add(new Jsr250MethodDefinitionSource());
		delegatingMethodDefinitionSource.setMethodDefinitionSources(sources);
		// }
	}

	/**
	 * @param delegatingMethodDefinitionSource
	 *            DelegatingMethodDefinitionSource
	 */
	public void setDelegatingMethodDefinitionSource(DelegatingMethodDefinitionSource delegatingMethodDefinitionSource) {
		this.delegatingMethodDefinitionSource = delegatingMethodDefinitionSource;
	}

	/**
	 * 
	 * @param resourceDetailsBuilder
	 *            MethodResourceDetailsBuilder
	 */
	public void setResourceDetailsBuilder(MethodResourceDetailsBuilder resourceDetailsBuilder) {
		this.resourceDetailsBuilder = resourceDetailsBuilder;
	}

}
