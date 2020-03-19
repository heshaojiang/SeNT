package com.grgbanking.platform.core.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.grgbanking.platform.core.spring.SpringContextHolder;

public class DBDialectHelper
{
	
	private static String dialect = "";
	private static boolean isOracle = false;
	private static boolean isDB2 = false;
	private static boolean isMySql = false;
	
	static
	{
		ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
		LocalSessionFactoryBean sf = (LocalSessionFactoryBean) applicationContext.getBean("&sessionFactory");
	
		String hibernateDialect = sf.getHibernateProperties().getProperty("hibernate.dialect").toLowerCase();
		if( hibernateDialect.contains("oracle") ) 
		{		
			dialect = "Oracle";
			isOracle = true;
		}
		else if( hibernateDialect.contains("db2") )
		{
			dialect = "DB2";
			isDB2 = true;
		}
		else if( hibernateDialect.contains("mysql") )
		{
			dialect = "MySql";
			isMySql = true;
		}
	}
	
	public static String getDialect()
	{
		return dialect;
	}

	public static boolean isOracle()
	{
		return isOracle;
	}

	public static boolean isDB2()
	{
		return isDB2;
	}

	public static boolean isMySql()
	{
		return isMySql;
	}
}
