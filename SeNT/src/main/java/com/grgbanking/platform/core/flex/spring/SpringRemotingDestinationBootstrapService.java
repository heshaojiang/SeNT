/**
 * 文件名：SpringRemotingDestinationBootstrapService.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.flex.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import flex.messaging.MessageDestination;
import flex.messaging.config.ConfigMap;
import flex.messaging.services.AbstractBootstrapService;
import flex.messaging.services.Service;
import flex.messaging.services.ServiceException;
import flex.messaging.services.remoting.RemotingDestination;

/**
 * 用于将spring applicationContext的bean自动导出为destination,以供flex客户端调用
 * SpringRemotingDestinationBootstrapService 自动导出包含"@Service标注及以FlexService结
 * 尾"的Spring Bean为RemotingDestination.
 * 
 * @author yrliang
 * 
 */
public class SpringRemotingDestinationBootstrapService extends
		AbstractBootstrapService {

	/** 后缀为FlexService的service将到处为destination */
	public static final String DEFAULT_INCLUDE_END_WITH_BEANS = "FlexService";
	private static Logger logger = LoggerFactory
			.getLogger(SpringRemotingDestinationBootstrapService.class);

	private String destChannel;
	private String destSecurityConstraint;
	private String destScope;
	private String destAdapter;
	private String destFactory;

	private String serviceId;

	private String includeEndsWithBeans;

	@Override
	/**
	 * 初始化入口
	 */
	public void initialize(String id, ConfigMap properties) {
		serviceId = properties.getPropertyAsString("service-id",
				"remoting-service");

		destFactory = properties.getPropertyAsString("dest-factory", "spring");
		destAdapter = properties.getProperty("dest-adapter");
		destScope = properties.getProperty("dest-scope");
		destSecurityConstraint = properties
				.getProperty("dest-security-constraint");
		destChannel = properties.getPropertyAsString("dest-channel", "my-amf");

		includeEndsWithBeans = properties.getPropertyAsString(
				"includeEndsWithBeans", DEFAULT_INCLUDE_END_WITH_BEANS);

		Service remotingService = broker.getService(serviceId);
		if (remotingService == null)
			throw createServiceException("not found Service with serviceId:"
					+ serviceId);

		createSpringDestinations(remotingService);
		// 创建数据推送频道
		// createPollingChannel(properties);
	}

	/**
	 * 创建数据推送频道
	 * 
	 * @param properties
	 */
	private void createPollingChannel(ConfigMap properties) {
		// create polling channel
		Service messageService = broker.getService("message-service");
		MessageDestination destination = (MessageDestination) messageService
				.createDestination("polling-channel");
		destination.addChannel("my-polling-amf");
		destination.addChannel("my-streaming-amf");
		try {
			destination.start(); // 启动destination
			logger.info("[polling service starting : polling-channel]");
		} catch (Exception e) {
			logger.error("Create polling channel error!", e);
		}
	}

	private ServiceException createServiceException(String message) {
		ServiceException ex = new ServiceException();
		ex.setMessage(message);
		return ex;
	}

	/**
	 * 将Spring的Service Name自动定义为destination
	 */
	private void createSpringDestinations(Service remotingService) {
		WebApplicationContext wac = WebApplicationContextUtils
				.getWebApplicationContext(broker.getServletContext());
		List<String> addedBeanNames = new ArrayList();
		for (String beanName : wac.getBeanDefinitionNames()) {
			Class type = wac.getType(beanName);

			// logger.debug("{}: {}", new Object[]{beanName, type.getName()});
			boolean isCreateSpringDestination = !type
					.isAnnotationPresent(com.grgbanking.platform.core.flex.NoneRemotingObject.class)
					|| beanName.endsWith(includeEndsWithBeans)
					|| isCreateDestination(beanName, type);

			if (isCreateSpringDestination) {
				createSpringDestination(remotingService, beanName);
				addedBeanNames.add(beanName);
			}
		}
		logger.info("[Auto Export Spring to RemotingDestination],beanNames={}",
				addedBeanNames);
	}

	protected boolean isCreateDestination(String beanName, Class type) {
		return false;
	}

	/*
	 * <!-- 动态生成的配置内容 --> <destination id="sampleVerbose"> <channels> <channel
	 * ref="my-secure-amf" /> </channels> <adapter ref="java-object" />
	 * <security> <security-constraint ref="sample-users" /> </security>
	 * <properties> <source>my.company.SampleService</source>
	 * <scope>session</scope> <factory>myJavaFactory</factory> </properties>
	 * </destination>
	 */
	protected void createSpringDestination(Service service, String destinationId) {
		RemotingDestination destination = (RemotingDestination) service
				.createDestination(destinationId);

		destination.setSource(destinationId);
		destination.setFactory(destFactory);

		if (destAdapter != null) {
			destination.createAdapter(destAdapter);
		}
		if (destScope != null) {
			destination.setScope(destScope);
		}
		if (destSecurityConstraint != null) {
			destination.setSecurityConstraint(destSecurityConstraint);
		}
		if (destChannel != null) {
			destination.addChannel(destChannel);
		}

		service.addDestination(destination);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
