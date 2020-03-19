/**
 * 文件名：ResponseHeaderFilter.java
 * 创建日期： 2012-6-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 为Response设置Expires等Header的Filter.
 * 
 * @author calvin
 */
public class ResponseHeaderFilter implements Filter {

	private FilterConfig fc;

	/**
	 * 设置Filter在web.xml中定义的所有参数到Response.
	 * 
	 * @param req
	 *            请求
	 * @param res
	 *            响应
	 * @param chain
	 *            chain
	 * @throws IOException
	 *             IOException
	 * @throws ServletException
	 *             ServletException
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		HttpServletResponse response = (HttpServletResponse) res;

		// set the provided HTTP response parameters
		for (Enumeration e = fc.getInitParameterNames(); e.hasMoreElements();) {
			String headerName = (String) e.nextElement();
			response.addHeader(headerName, fc.getInitParameter(headerName));
		}

		// pass the request/response on
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 * @param filterConfig
	 *            config
	 */
	public void init(FilterConfig filterConfig) {
		this.fc = filterConfig;
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}
}
