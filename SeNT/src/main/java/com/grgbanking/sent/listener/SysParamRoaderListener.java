package com.grgbanking.sent.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.menu.service.MenuInfoService;
import com.grgbanking.platform.module.param.service.ParamService;
import com.grgbanking.sent.utils.StreamUtil;


public class SysParamRoaderListener implements ServletContextListener
{

	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	private ParamService paramService;
	
	private SysDatadirService sysDatadirService;
	
	private MenuInfoService menuInfoService;
	

	@Override
	public void contextInitialized(ServletContextEvent event)
	{
		logger.info("SysParamRoaderListener.contextInitialized");
		loadSysParam(event.getServletContext());
		loadSysDataDir(event.getServletContext());
		loadSysMenu(event.getServletContext());
	}
	
	/**
	 * 
	 */
	private void loadSysParam(ServletContext servletContext)
	{
		logger.info("SysParamRoaderListener.loadSysParam");
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		paramService = (ParamService)webApplicationContext.getBean("paramService");
		
		InputStream in = null;
		try
		{
			in = servletContext.getResourceAsStream("/META-INF/SysParam.xml");
			Document doc = new SAXReader().read(in);
			Element node = doc.getRootElement();
			paramService.recursiveAddSysParam(node);
		}
		catch(Exception e)
		{
			logger.error("", e);
		}
		finally
		{
			StreamUtil.close(in);
		}
	}
	
	/**
	 * 
	 */
	private void loadSysDataDir(ServletContext servletContext)
	{
		logger.info("SysParamRoaderListener.loadSysDataDir");
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		sysDatadirService = (SysDatadirService)webApplicationContext.getBean("sysDatadirService");
		
		InputStream in = null;
		try
		{
			in = servletContext.getResourceAsStream("/META-INF/SysDataDir.xml");
			Document doc = new SAXReader().read(in);
			Element node = doc.getRootElement();
			sysDatadirService.recursiveAddSysDataDir(node);
		}
		catch(Exception e)
		{
			logger.error("", e);
		}
		finally
		{
			StreamUtil.close(in);
		}
	}
	
	
	private void loadSysMenu(ServletContext servletContext)
	{
		logger.info("SysParamRoaderListener.loadSysMenu");
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		menuInfoService = (MenuInfoService)webApplicationContext.getBean("menuInfoService");
		
		InputStream in = null;
		try
		{
			in = servletContext.getResourceAsStream("/META-INF/SysMenu.xml");
			Document doc = new SAXReader().read(in);
			Element node = doc.getRootElement();
			menuInfoService.recursiveAddSysMenu(node);
		}
		catch(Exception e)
		{
			logger.error("", e);
		}
		finally
		{
			StreamUtil.close(in);
		}
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent event)
	{
		logger.info("SysParamRoaderListener.contextDestroyed");
	}

}
