package com.grgbanking.sent.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.utils.StreamUtil;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 
 * @author Jonas
 * 
 */
public class FileDownloadServlet extends HttpServlet
{
	
	final int byteSize = 1024;
	
	/**
	 * 日志信息
	 */
	private static Logger logger = LoggerFactory.getLogger(FileDownloadServlet.class);

	private static final long serialVersionUID = 321020920349039602L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

		String del = StringUtil.trim(request.getParameter("del"));
		String filePath = request.getParameter("filePath");
		if(StringUtil.isNotBlank(filePath)){
			filePath = URLDecoder.decode(filePath,"UTF-8");
		}
		String fileName = StringUtil.trim(request.getParameter("fileName"));// 还原成原始字符串
		String pro = StringUtil.trim(request.getParameter("pro"));
		String type = StringUtil.trim(request.getParameter("type"));

		// windows分隔符 /
		// linux分隔符 \
		if ("\\".equals(System.getProperties().getProperty("file.separator"))) {
			fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
			if ("true".equals(pro)) {
				filePath = new String(filePath.getBytes("ISO-8859-1"), "UTF-8");
			} else {
				filePath = getServletContext().getRealPath("") + "/exportFile/"
						+ fileName;
			}
			//System.out.println("windows");
		} else {
			if ("true".equals(pro)) {
				// filePath = StringUtil.trim(request.getParameter("filePath"));
			} else {
				filePath = getServletContext().getRealPath("") + "/exportFile/"
						+ fileName;
			}
			//System.out.println("linux"); 
		}
		
		if (type != null && type.equals("downloadFsnFileForUpload")) { 
			filePath = fileName;
			del = "false";
		}
		
		if (type != null && type.equals("downloadNoderUpdatePackage")) {
			fileName = fileName.split(";")[0];
			filePath = getZipPathForImportNoderUpdatePackage() + fileName;
			del = "false";
		}
		

		//System.out.println(filePath);
		//System.out.println(fileName);
		File downloadFile = new File(filePath);
		
		logger.info("FileDownloadServlet.doPost() -> downloadFile = "
				+ downloadFile.getAbsolutePath());
		response.reset();// 必须调用，否则IE出现的三个选择中的“打开”会提示找不到文件
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ java.net.URLEncoder.encode(downloadFile.getName(), "UTF-8"));

		InputStream is = null;
		OutputStream output = null;
		try {
			is = new FileInputStream(downloadFile);
			output = response.getOutputStream();

			byte[] b = new byte[byteSize];
			int i = 0;

			while ((i = is.read(b)) >= 0) {
				output.write(b, 0, i);
			}
			output.flush();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			StreamUtil.close(is);
			StreamUtil.close(output);
		}

		if ("false".equals(del) == false) {
			downloadFile.delete();
		}
		
//		request.setCharacterEncoding("UTF-8");
//		String del      = StringUtil.trim(request.getParameter("del"));
//		String fileName = StringUtil.trim(request.getParameter("fileName"));
//		String filePath = getServletContext().getRealPath("") + "/exportFile/" + fileName;
//		
//		File downloadFile = new File(filePath);
//		logger.info("FileDownloadServlet.doPost() -> downloadFile = "+downloadFile.getAbsolutePath());
//		
//		response.reset();// 必须调用，否则IE出现的三个选择中的“打开”会提示找不到文件
//		response.setContentType("unknown");
//		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//		
//		InputStream is = null;
//		OutputStream output = null;
//		try
//		{
//			is = new FileInputStream(downloadFile);
//			output = response.getOutputStream();
//			
//			byte[] b = new byte[byteSize];
//			int i = 0;
//
//			while ((i = is.read(b)) >= 0)
//			{
//				output.write(b, 0, i);
//			}
//			output.flush();
//		}
//		catch (IOException e)
//		{
//			logger.error("", e);
//		}
//		finally
//		{
//			StreamUtil.close(is);
//			StreamUtil.close(output);
//		}
//		
//		if( "false".equals(del)==false )
//		{
//			downloadFile.delete();
//		}

	}
	
	 private String getZipPathForImportNoderUpdatePackage(){
				ParamDao paramDao = SpringContextHolder.getBean("paramDao");
				return paramDao.getValueByPathWithException("param.sent.fsnPath.fsnRootPath.pathForNoderUpdate");
	    }
}
