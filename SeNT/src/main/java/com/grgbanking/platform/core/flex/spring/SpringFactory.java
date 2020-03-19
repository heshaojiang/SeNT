/**
 * 文件名：SpringFactory.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.flex.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import flex.messaging.FactoryInstance;
import flex.messaging.FlexFactory;
import flex.messaging.config.ConfigMap;
import flex.messaging.services.ServiceException;

/**
 * 根据destination的id,将Flex的destination映射为Spring的Bean, 例如: 
 * <destination id="userService"> 
 * 		<properties> 
 * 			<factory>spring</factory>
 * 			<source>userService</source>
 * 		</properties>
 * 	</destination>
 * @author yrliang
 */
public class SpringFactory implements FlexFactory {
	private static final String SOURCE = "source";

	/**
	 * This method can be used to initialize the factory itself. It is called
	 * with configuration parameters from the factory tag which defines the id
	 * of the factory.
	 * 
	 * @param id
	 *            id
	 * @param configMap
	 *            配置地图
	 */
	public void initialize(String id, ConfigMap configMap) {

	}

	/**
	 * This method is called when we initialize the definition of an instance
	 * which will be looked up by this factory. It should validate that the
	 * properties supplied are valid to define an instance. Any valid properties
	 * used for this configuration must be accessed to avoid warnings about
	 * unused configuration elements. If your factory is only used for
	 * application scoped components, this method can simply return a factory
	 * instance which delegates the creation of the component to the
	 * FactoryInstance's lookup method.
	 * 
	 * @param id
	 *            id
	 * @param properties
	 *            配置属性
	 * @return FactoryInstance
	 */
	public FactoryInstance createFactoryInstance(String id, ConfigMap properties) {
		SpringFactoryInstance instance = new SpringFactoryInstance(this, id, properties);
		instance.setSource(properties.getPropertyAsString(SOURCE, instance.getId()));
		return instance;
	} // end method createFactoryInstance()

	/**
	 * Returns the instance specified by the source and properties arguments.
	 * For the factory, this may mean constructing a new instance, optionally
	 * registering it in some other name space such as the session or JNDI, and
	 * then returning it or it may mean creating a new instance and returning
	 * it. This method is called for each request to operate on the given item
	 * by the system so it should be relatively efficient.
	 * <p>
	 * If your factory does not support the scope property, it report an error
	 * if scope is supplied in the properties for this instance.
	 * 
	 * @param inst
	 *            工厂实例
	 * @return Object
	 */
	public Object lookup(FactoryInstance inst) {
		SpringFactoryInstance factoryInstance = (SpringFactoryInstance) inst;
		return factoryInstance.lookup();
	}

	/**
	 * Spring工厂实例，执行实际的查找动作.
	 * 
	 * @author yrliang
	 * 
	 */
	static class SpringFactoryInstance extends FactoryInstance {
		SpringFactoryInstance(SpringFactory factory, String id, ConfigMap properties) {
			super(factory, id, properties);
		}

		@Override
		public String toString() {
			return "SpringFactory instance for id=" + getId() + " source=" + getSource() + " scope=" + getScope();
		}

		@Override
		public Object lookup() {
			Logger logger = LoggerFactory.getLogger(SpringFactory.class);
			ApplicationContext appContext = WebApplicationContextUtils
					.getWebApplicationContext(flex.messaging.FlexContext.getServletConfig().getServletContext());
			String beanName = getSource();

			try {
				logger.debug("lookup(): bean id=" + beanName);

				// flex.messaging.FlexContext.getHttpRequest().getSession().getAttribute(arg0);
				return appContext.getBean(beanName);
			} catch (NoSuchBeanDefinitionException nexc) {
				ServiceException e = new ServiceException();
				String msg = "Spring service named '" + beanName + "' does not exist.";
				e.setMessage(msg);
				e.setRootCause(nexc);
				e.setDetails(msg);
				e.setCode("Server.Processing");
				logger.error("", nexc);
				throw e;
			} catch (BeansException bexc) {
				ServiceException e = new ServiceException();
				String msg = "Unable to create Spring service named '" + beanName + "' ";
				e.setMessage(msg);
				e.setRootCause(bexc);
				e.setDetails(msg);
				e.setCode("Server.Processing");
				logger.error("", bexc);
				throw e;
			}
		}
	}

}
