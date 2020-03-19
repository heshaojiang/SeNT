package com.grgbanking.sent.stride.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
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

public class FSNFilesExport extends HttpServlet {
	protected Logger logger = LoggerFactory.getLogger(FSNFilesExport.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -2286690038194515052L;
	
    final int byteSize = 1024;
    public FSNFilesExport() { 
        super(); 
    } 
    public void destroy() { 
        super.destroy(); 
    } 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) { 
        response.setContentType("text/html;charset=UTF-8"); 
		response.reset();// 必须调用，否则IE出现的三个选择中的“打开”会提示找不到文件
		ServletContext ctx = this.getServletContext();
		//id_file,id_file
		String files = request.getParameter("files");
		String date = request.getParameter("date");
		if(StringUtil.isBlank(files))return;
		
		InputStream is = null;
		OutputStream output = null;
		File file = null;
		try{
			String[] idFiles = files.split(",");
			String[] fs = new String[idFiles.length];
			String[] ids = new String[idFiles.length];
			for (int i = 0; i < idFiles.length; i++) {
				String[] s = idFiles[i].split(";");
				ids[i] = s[0];
				fs[i] = s[1];
			}
			String filePath = "";
			if(fs.length>1){
				filePath = StrideZipFsnContentUtil.downLoadZip(fs,date);
			}else{
				if(StringUtil.isBlank(fs[0]))return;
				String[] temp = fs[0].split("_");
				if(temp.length<2)return;
				filePath = getZipPathTemp()+fs[0].split("_")[1]+File.separator+fs[0];
			}
			if(StringUtil.isBlank(filePath))return;
			String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);
			StrideImportRecordsService importService = SpringContextHolder.getBean("strideImportRecordsService");
			importService.saveZipDownLoad(fileName, ids);
			file = new File(filePath);
			is = new FileInputStream(file);
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			output = response.getOutputStream();
			byte[] b = new byte[byteSize];
			int i = 0;
			while ((i = is.read(b)) > 0){
				output.write(b, 0, i);
			}
			output.flush();
			is.close();
			output.close();
			if(file.canWrite()){
				File parentFile = file.getParentFile();
				String name = file.getName();
				String parentName = parentFile.getName();
//				file.delete();
				//下载单个zip文件时,把父目录也删除
				if(name.split("_")[1].equals(parentName)){
					parentFile.delete();
				}
			}
		}catch( IOException e ){
			logger.error("下载异常", e);
			throw new RuntimeException(e);
		}finally{
			try{
				if( is != null ){
					is.close();
				}
				if( output != null ){
					output.close();
				}
			}catch( IOException e ){
				logger.error("", e);
			}
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
   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        processRequest(request, response); 
    } 
    /** *//** 
     * Returns a short description of the servlet. 
     */ 
    public String getServletInfo() { 
        return "Short description"; 
    } 
    
    private String getZipPathTemp(){
    	if(StringUtil.isBlank(StrideZipFsnContentUtil.STRIDE_PATH_TEMP)){
			ParamDao paramDao = SpringContextHolder.getBean("paramDao");
			String temp = paramDao.getValueByPathWithException(AppConstants.FSN_STRIDE_PATHTEMP_FOR_ZIP);
			StrideZipFsnContentUtil.STRIDE_PATH_TEMP = StringUtil.isBlank(temp)?StrideZipFsnContentUtil.STRIDE_PATH_TEMP_DEFUALT:temp;
			StrideZipFsnContentUtil.STRIDE_PATH_TEMP = StrideZipFsnContentUtil.STRIDE_PATH_TEMP.endsWith(File.separator) ? StrideZipFsnContentUtil.STRIDE_PATH_TEMP : StrideZipFsnContentUtil.STRIDE_PATH_TEMP + File.separator;
			ZipUtil.buildFile(StrideZipFsnContentUtil.STRIDE_PATH_TEMP, true);
		}
		return StrideZipFsnContentUtil.STRIDE_PATH_TEMP;
    }
	

}
