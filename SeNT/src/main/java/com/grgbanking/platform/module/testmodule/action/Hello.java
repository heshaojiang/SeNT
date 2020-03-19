/**
 * 文件名：HelloWorld.java
 * 创建日期： 2012-2-21
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间：
 *   修改人：
 *   生成版本：
 *   修改内容：
 */
package com.grgbanking.platform.module.testmodule.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.core.struts2.Struts2Utils;
import com.grgbanking.platform.module.term.entity.TermInfo;
import com.grgbanking.platform.module.testmodule.ws.ITestService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author yrliang
 * 
 */
public class Hello extends ActionSupport {
	private static Logger logger = LoggerFactory.getLogger(Hello.class);

	// @Autowired
	// @Qualifier("testServiceClient")
	// ITestService client;

	@Override
	public String execute() {
		// 静态客户端访问
		ITestService client = SpringContextHolder.getBean("testServiceClient");

		logger.info("{}", client.getList());
		logger.info("{}", client.getMap());

		TermInfo termInfo = client.getTermInfo("8a81da8e34e53fc30134e548cb070003");
		logger.info("{}", termInfo.getTermCode());
		logger.info("{}", client.getTermInfoList("8a81da8e34e53fc30134e548cb070003"));

		HttpServletResponse response = Struts2Utils.getResponse();
		try {
			response.getOutputStream().println("Hello World!");
		} catch (IOException e) {
			logger.error("", e);
		}

		return null;
	}
}
