package com.grgbanking.platform.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class SpringService implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		applicationContext = arg0;
	}

	public Object getBean(String name) {

		return applicationContext.getBean(name);
	}

	public String getHibernateDialect() {
		LocalSessionFactoryBean sf = (LocalSessionFactoryBean) applicationContext
				.getBean("&sessionFactory");
		// 可用用下边任意方法获取
		// sf.getConfiguration().getProperty("hibernate.dialect")
		return sf.getHibernateProperties().getProperty("hibernate.dialect");
	}

}
