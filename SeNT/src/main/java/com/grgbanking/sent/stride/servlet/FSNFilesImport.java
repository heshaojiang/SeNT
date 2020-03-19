package com.grgbanking.sent.stride.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.common.Constants.AppConstants;
import com.grgbanking.sent.stride.service.StrideImportRecordsService;
import com.grgbanking.sent.stride.utils.StrideZipFsnContent;
import com.grgbanking.sent.stride.utils.StrideZipFsnContentUtil;
import com.grgbanking.sent.stride.utils.ZipUtil;
import com.grgbanking.sent.utils.StringUtil;

public class FSNFilesImport extends HttpServlet {
	protected Logger logger = LoggerFactory.getLogger(FSNFilesImport.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -2286690038194515052L;
	
	// 定义文件的上传路径 
    //private String uploadPath = "/home/feel/SeNT/FsnfileUpload/stride/"; // /home/feel/SeNT/FsnfileUpload/stride/
    // 限制文件的上传大小 
    private int maxPostSize = 1000 * 1024 * 1024;  //最大100M
    public FSNFilesImport() { 
        super(); 
    } 
    public void destroy() { 
        super.destroy(); 
    } 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); 
        //保存文件到服务器中 
        DiskFileItemFactory factory = new DiskFileItemFactory(); 
        factory.setSizeThreshold(4096); 
        ServletFileUpload upload = new ServletFileUpload(factory); 
        upload.setHeaderEncoding("utf-8");
        upload.setSizeMax(maxPostSize); 
        
        try { 
           List fileItems = upload.parseRequest(request); 
           Iterator iter = fileItems.iterator(); 
           String path = getZipPath();
           while (iter.hasNext()) { 
               FileItem item = (FileItem) iter.next(); 
               if (!item.isFormField()) { 
                   String name = item.getName();
                   String temp = name.substring(name.lastIndexOf(".")+1);
                   if(temp==null || "".equals(temp) || !"zip".equals(temp.toLowerCase()))
                	   continue;
                   logger.info(name); 
                   try { 
                       item.write(new File(path + name)); 
                       List<StrideZipFsnContent> contentItem = StrideZipFsnContentUtil.importZip(name);
                       StrideImportRecordsService importService = SpringContextHolder.getBean("strideImportRecordsService");
                       importService.saveImport(contentItem);
                       response.getWriter().write("完成");
                   } catch (Exception e) { 
                       e.printStackTrace(); 
                       response.getWriter().write(e.getMessage());
                   } 
               } 
           } 
       } catch (FileUploadException e) { 
           e.printStackTrace(); 
           response.getWriter().write(e.getMessage());
           logger.info(e.getMessage() + "结束"); 
       } 
   } 
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException { 
	   processRequest(request, response); 
   } 
   /** *//** 
    * Handles the HTTP <code>POST</code> method. 
    * @param request servlet request 
    * @param response servlet response 
    */ 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if (null != type && type.equals("importNoderUpdatePackage")) {
			logger.debug("导入节点机升级包");
			importNoderUpdatePackage(request, response);
		} else {
			processRequest(request, response);

		}
	}
	
	 protected void importNoderUpdatePackage(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException { 
	        //保存文件到服务器中 
	        DiskFileItemFactory factory = new DiskFileItemFactory(); 
	        factory.setSizeThreshold(4096); 
	        ServletFileUpload upload = new ServletFileUpload(factory); 
	        upload.setHeaderEncoding("utf-8");
	        upload.setSizeMax(maxPostSize); 
	        
	        try { 
	           List fileItems = upload.parseRequest(request); 
	           Iterator iter = fileItems.iterator(); 
	           String path = getZipPathForImportNoderUpdatePackage();
	           while (iter.hasNext()) { 
	               FileItem item = (FileItem) iter.next(); 
	               if (!item.isFormField()) { 
	                   String name = item.getName();
	                   String temp = name.substring(name.lastIndexOf(".")+1);
	                   if(temp==null || "".equals(temp) || !"zip".equals(temp.toLowerCase()))
	                	   continue;
	                   try { 
	                       item.write(new File(path + name)); 
	                   } catch (Exception e) { 
	                       logger.error("上传失败", e);
	                       response.getWriter().write("上传失败");
	                   } 
	               } 
	           } 
	       } catch (FileUploadException e) { 
	    	   logger.error("上传失败", e);
               response.getWriter().write("上传失败");
	       } 
	 }

    /** *//** 
     * Returns a short description of the servlet. 
     */ 
    public String getServletInfo() { 
        return "Short description"; 
    } 
    
    private String getZipPath(){
    	if(StringUtil.isBlank(StrideZipFsnContentUtil.STRIDE_PATH)){
			ParamDao paramDao = SpringContextHolder.getBean("paramDao");
			String temp = paramDao.getValueByPathWithException(AppConstants.FSN_STRIDE_PATH);
			StrideZipFsnContentUtil.STRIDE_PATH = StringUtil.isBlank(temp)?StrideZipFsnContentUtil.STRIDE_PATH_DEFUALT:temp;
			StrideZipFsnContentUtil.STRIDE_PATH = StrideZipFsnContentUtil.STRIDE_PATH.endsWith(File.separator) ? StrideZipFsnContentUtil.STRIDE_PATH : StrideZipFsnContentUtil.STRIDE_PATH + File.separator;
			ZipUtil.buildFile(StrideZipFsnContentUtil.STRIDE_PATH, true);
		}
		return StrideZipFsnContentUtil.STRIDE_PATH;
    }
    
    private String getZipPathForImportNoderUpdatePackage(){
    	if(StringUtil.isBlank(StrideZipFsnContentUtil.STRIDE_PATH)){
			ParamDao paramDao = SpringContextHolder.getBean("paramDao");
			String temp = paramDao.getValueByPathWithException("param.sent.fsnPath.fsnRootPath.pathForNoderUpdate");
			StrideZipFsnContentUtil.STRIDE_PATH = StringUtil.isBlank(temp)?StrideZipFsnContentUtil.STRIDE_PATH_DEFUALT:temp;
			StrideZipFsnContentUtil.STRIDE_PATH = StrideZipFsnContentUtil.STRIDE_PATH.endsWith(File.separator) ? StrideZipFsnContentUtil.STRIDE_PATH : StrideZipFsnContentUtil.STRIDE_PATH + File.separator;
			ZipUtil.buildFile(StrideZipFsnContentUtil.STRIDE_PATH, true);
		}
		return StrideZipFsnContentUtil.STRIDE_PATH;
    }
	

}
