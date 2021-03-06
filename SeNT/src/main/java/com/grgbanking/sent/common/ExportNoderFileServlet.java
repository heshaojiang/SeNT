package com.grgbanking.sent.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

public class ExportNoderFileServlet extends HttpServlet{
	
	private static Logger logger = LoggerFactory.getLogger(DownloadServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 321020920349039611L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.reset();// 必须调用，否则IE出现的三个选择中的“打开”会提示找不到文件

		// response.setContentType("text/html; charset=UTF-8");
		// request.setCharacterEncoding("UTF-8");
		String language = request.getParameter("language");
		ServletContext ctx = this.getServletContext();
		WebApplicationContext wac = (WebApplicationContext) ctx
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		String filePath = request.getParameter("filePath");
		String fileName = getFileName(filePath);
		File outFile = new File(filePath);
		InputStream is = new FileInputStream(outFile);

		// String encodingName = new String(fileName.getBytes("GB2312"),
		// "ISO8859_1");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		response.addHeader("Content-Length", "" + outFile.length());
		response.setContentType("application/octet-stream");
		ServletOutputStream output = null;
		try {
			output = response.getOutputStream();
			byte[] b = new byte[2048];
			int i = 0;

			while((i = is.read(b, 0, b.length)) != -1) {
				output.write(b, 0, i);
			}
//			is.close();
			output.flush();
//			output.close();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			// 模板文件不给于删除
			//if (flag != null && flag.equals("0")) {
			//	outFile.delete();
			//}
			if(is != null){
				is.close();
			}
			if(output!=null){
				output.flush();
				output.close();
			}
		}

	}
	
	public String getFileName(String filePath){
		// windows分隔符 /
		// linux分隔符 \
		String[] contents = null;
		if ("\\".equals(System.getProperties().getProperty("file.separator"))) {
			contents = filePath.split("\\\\");
			//System.out.println("windows");
		} else {
			contents = filePath.split("/");
			//System.out.println("linux"); 
		}
		return contents[contents.length-1];
	}
	
}
