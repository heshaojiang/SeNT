package com.grgbanking.platform.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//yaojun 2012-04-25
public class PropertiesUtils {

	private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

	public static Properties Systemroperties;
	public static Properties ApplicationProperties;

	static
	{
		InputStream in = new PropertiesUtils().getClass().getResourceAsStream("/system.properties");
		Systemroperties = new Properties();

		try
		{
			Systemroperties.load(in);
		}
		catch (IOException e)
		{
			logger.warn(e.getMessage());
		}
		
		InputStream in2 = new PropertiesUtils().getClass().getResourceAsStream("/jdbc.properties");
		ApplicationProperties = new Properties();
		try
		{
			ApplicationProperties.load(in2);
		}
		catch (IOException e2)
		{
			logger.warn(e2.getMessage());
		}
	}

	public static String queryDatabaseType()
	{
		String jdbcdriver = ApplicationProperties.getProperty("jdbc.driver");
		if (jdbcdriver.indexOf("oracle") > -1)
			return "oracle";
		else if (jdbcdriver.indexOf("sybase") > -1)
			return "sybase";
		else if (jdbcdriver.indexOf("mysql") > -1)
			return "mysql";
		else if (jdbcdriver.indexOf("ibm.db2") > -1)
			return "db2";
		else if (jdbcdriver.indexOf("sqlserver") > -1)
			return "sqlserver";
		else if (jdbcdriver.indexOf("informix") > -1)
			return "informix";
		else
			return "";
	}
}
