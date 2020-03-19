/**
 * 文件名：HibernateSessionUtil.java
 * 创建日期： 2012-2-23
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.spring;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import flex.messaging.FlexContext;

/**
 * 获取当前Hibernate Session
 * 
 * @author yrliang
 * 
 */
public class HibernateSessionUtil {

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：getCurrentSession(获取Hibernate Session) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 getCurrentSession(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @return Session
	 * @Exception 异常对象 <br>
	 */
	public static Session getCurrentSession() {
		ServletContext ctx = FlexContext.getServletContext();
		WebApplicationContext springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(ctx);
		SessionFactory sessionFactory = (SessionFactory) springContext.getBean("sessionFactory");
		Session session = SessionFactoryUtils.getSession(sessionFactory, false);
		return session;
	}
}
