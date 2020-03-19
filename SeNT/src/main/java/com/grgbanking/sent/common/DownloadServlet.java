package com.grgbanking.sent.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Jonas
 * 
 */
public class DownloadServlet extends HttpServlet
{
	
	/**
	 * 记录日志
	 */
	private static Logger logger = LoggerFactory.getLogger(DownloadServlet.class);
	
	final int byteSize = 1024;
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 321020920349039601L;

	/**
	 * get请求
	 * 
	 * @param request
	 *            发送请求的参数
	 * @param response
	 *            处理请求的参数
	 * */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		doPost(request, response);
	}

	/**
	 * post请求
	 * 
	 * @param request
	 *            发送请求的参数
	 * @param response
	 *            处理请求的参数
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{

		response.reset();// 必须调用，否则IE出现的三个选择中的“打开”会提示找不到文件

		ServletContext ctx = this.getServletContext();
		String fileName = request.getParameter("fileName");
		String filePath = ctx.getRealPath("") + "/tempDir/download/" + fileName;
		
		InputStream is = null;
		OutputStream output = null;
		try
		{
			is = new FileInputStream(new File(filePath));

			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			output = response.getOutputStream();
			byte[] b = new byte[byteSize];

			int i = 0;

			while ((i = is.read(b)) > 0)
			{
				output.write(b, 0, i);
			}
			output.flush();
		}
		catch( IOException e )
		{
			logger.error("", e);
		}
		finally
		{
			try
			{
				if( is != null )
				{
					is.close();
					is = null;
				}
				if( output != null )
				{
					output.close();
					output = null;
				}
			}
			catch( IOException e )
			{
				logger.error("", e);
			}
		}

	}
}
