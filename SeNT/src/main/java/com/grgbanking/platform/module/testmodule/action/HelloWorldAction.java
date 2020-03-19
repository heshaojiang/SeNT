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
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.struts2.Struts2Utils;
import com.grgbanking.platform.core.utils.ReflectionUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author yrliang
 * 
 */
public class HelloWorldAction extends ActionSupport {
	private static Logger logger = LoggerFactory.getLogger(Hello.class);

	// http://localhost:8080/platform/services/TestService?wsdl
	private static final String WSDL_SUFFIX = "?wsdl";
	private static String servicesUrl = "http://localhost:8080/platform/services/";
	private static String serviceName = "TestService";

	@Override
	public String execute() {
		HttpServletResponse response = Struts2Utils.getResponse();
		try {
			response.getOutputStream().println("Hello World!");
		} catch (IOException e) {
			logger.error("", e);
		}

		return null;
	}

	public String getTermInfo() throws Exception {
		logger.info(System.getProperty("java.endorsed.dirs"));

		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		org.apache.cxf.endpoint.Client client = dcf.createClient(servicesUrl + serviceName + WSDL_SUFFIX);
		Object[] res = client.invoke("getTermInfo", new Object[] { "41050733" });

		HttpServletResponse response = Struts2Utils.getResponse();
		try {
			Object ip = ReflectionUtils.getFieldValue(res[0], "netAddr");
			response.getOutputStream().println("ip = " + ip);

			response.getOutputStream().println("<br>");

			Object termCode = ReflectionUtils.getFieldValue(res[0], "termCode");
			response.getOutputStream().println("termCode = " + termCode);
		} catch (IOException e) {
			logger.error("", e);
		}

		return null;
	}

	public String getList() throws Exception {
		logger.info(System.getProperty("java.endorsed.dirs"));

		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		org.apache.cxf.endpoint.Client client = dcf.createClient(servicesUrl + serviceName + WSDL_SUFFIX);
		Object[] res = client.invoke("getList", new Object[] {});

		HttpServletResponse response = Struts2Utils.getResponse();
		try {
			response.getOutputStream().println("" + res[0]);
		} catch (IOException e) {
			logger.error("", e);
		}

		return null;
	}

	public String getMap() throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		org.apache.cxf.endpoint.Client client = dcf.createClient(servicesUrl + serviceName + WSDL_SUFFIX);
		Object[] res = client.invoke("getMap", new Object[] {});

		HttpServletResponse response = Struts2Utils.getResponse();
		try {
			List list = (List) ReflectionUtils.invokeMethod(res[0], "getEntries", null, null);
			for (Object obj : list) {
				String key = (String) ReflectionUtils.getFieldValue(obj, "key");
				Object value = ReflectionUtils.getFieldValue(obj, "value");
				response.getOutputStream().println("key = " + key);
				response.getOutputStream().println(", ");
				response.getOutputStream().println("value = " + value);
				response.getOutputStream().println("<br>");

			}
		} catch (IOException e) {
			logger.error("", e);
		}

		return null;
	}

	public String getTermInfoList() throws Exception {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		org.apache.cxf.endpoint.Client client = dcf.createClient(servicesUrl + serviceName + WSDL_SUFFIX);
		Object[] res = client.invoke("getTermInfoList", new Object[] { "41050733" });

		List list = (List) res[0];
		HttpServletResponse response = Struts2Utils.getResponse();
		try {
			for (Object obj : list) {
				Object ip = ReflectionUtils.getFieldValue(obj, "netAddr");
				response.getOutputStream().println("ip = " + ip);

				response.getOutputStream().println("<br>");

				Object termCode = ReflectionUtils.getFieldValue(obj, "termCode");
				response.getOutputStream().println("termCode = " + termCode);
				response.getOutputStream().println("<br><br>");
			}
		} catch (IOException e) {
			logger.error("", e);
		}

		return null;
	}

}
