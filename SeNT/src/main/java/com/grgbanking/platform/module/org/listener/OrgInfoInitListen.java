package com.grgbanking.platform.module.org.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.module.org.service.OrgInfoService;

public class OrgInfoInitListen implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		OrgInfoService orgInfoService = SpringContextHolder.getBean("orgInfoService");
		String orgInfoEnableTreeXmlStr = orgInfoService.initEnabledOrgTree("0000100001");
		event.getServletContext().setAttribute("orgInfoEnableTreeXmlStr", orgInfoEnableTreeXmlStr);
	}

}
