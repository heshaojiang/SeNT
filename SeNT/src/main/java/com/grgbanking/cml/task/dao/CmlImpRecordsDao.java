package com.grgbanking.cml.task.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Repository;

import com.grgbanking.cml.task.entity.CmlImpRecords;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.utils.DateUtil;

import flex.messaging.FlexContext;
@Repository

public class CmlImpRecordsDao  extends BaseDao<CmlImpRecords>{
	
	
	
	/**
	 * @param tmlNum 设备编号
	 * @return realPath 文件路径
	 */
		public String CreatefilePath(String tmlNum) {

			Date d1 = new Date();
			String dd = DateUtil.getyyyyMMddDate(d1);
			String Path = "doc" + File.separator + dd.substring(2, 4)
					+ File.separator + dd.substring(4, 6) + File.separator
					+ dd.substring(6, 8) + File.separator + tmlNum + File.separator;
			String realPath =File.separator + Path;
			return realPath;
		}

		/**
		 * @param tmlNum 设备编号 
		 * @param taskNum 任务编号 
		 * @param oldName 原来的名字
		 * @param i 多文件上传时用
		 * @param String  文件名
		 * 
		 */
		
		public synchronized String GenertoryFileName(String tmlNum, String taskNum,
				String oldName, int i) {
			
			String begin = "";
			String end = "";
			String ss = "";
			String ex = FilenameUtils.getExtension(oldName);
			String sql = " select max(newName) from  CmlImpRecords where newName like '"
					+ taskNum + "_" + tmlNum + "_%'";
		
			String name = findUnique(sql);

			if (null != name && !"".equals(name.trim())) {
			String	qian = name;
				begin = qian.substring(0, qian.lastIndexOf('_') + 1);
				end = qian.substring((qian.lastIndexOf('_') + 1), qian
						.lastIndexOf('.') == -1 ? qian.length() : qian
						.lastIndexOf('.'));
				end = 1 + end;

				end = (String.valueOf((Integer.parseInt(end) + 1 + i)))
						.substring(end.indexOf('1') + 1);

				ss = begin + end + "." + ex;
			} else {
				StringBuffer s = new StringBuffer(taskNum + "_" + tmlNum + "_");

				for (int k = 0; k < 4; k++) {
					int u = (k == 3 ? 1+i : 0);
					s.append(u);
				}
				ss = s.toString() + "." + ex;
			}

			logger.info("filename" + ss);
			return ss;

		}
		
		
		/**
		 *   解析工具类 
		
		 *   		 */
		
		public static List parseCsv(String filePath)
		{
			throw new RuntimeException("*****************************");
//			List count = new ArrayList();
//			String[] str = {};
//			CsvReader reader = null;
//			try {
//				reader = new CsvReader(filePath, ',', Charset.forName("GBK"));
//				while (reader.readRecord()) {
//					str = reader.getValues();
//					if (str != null && str.length > 0) {
//						if (str[0] != null && !"".equals(str[0].trim())) {
//							count.add(str);
//						}
//					}
//				}
//			
//				return count;
//
//			} catch (Exception e) {
//			
//			
//				return null;
//
//			} finally {
//				reader.close();
//			}
		}
		
	
		/**
		 *上传文件 
		 */
		
		public static String upload(byte[] is,String filePath,  String oldFileName ,String newName)
			 {
	
			String url = "";
			  FileOutputStream fo = null;
	
			try {
				// 获取文件上传的真实路径
				String realPath =FlexContext.getServletContext().getRealPath(File.separator+filePath);
				File tempFile = new File(realPath + File.separator);
				if (!tempFile.exists()) {
					tempFile.mkdirs();
				}
			
	
			 fo= new FileOutputStream(realPath +File.separator +oldFileName);
			 	fo.write(is);
			
				url = filePath + File.separator + oldFileName ;
			
			} catch (IOException e) {
	
			}finally{
				try {
				
					fo.flush();
					fo.close();
				} catch (IOException e2) {
					
					// TODO: handle exception
				}
			
				
				
			}

			return url;

		}

		/**
		 * @param page page实体
		 * @param taskNum 任务编号
		 * @param fileName 文件名称
		 * @param beginTime 开始时间
		 * @param endTime 结束时间
		 * @return Page<CmlImpRecords>
		 */
		public Page<CmlImpRecords> findCmlImpRecordsPageForTask(
				Page<CmlImpRecords> page, String taskNum, String fileName,
				String beginTime, String endTime) {
			List<String> args = new ArrayList<String>();
			StringBuffer hql = new StringBuffer(" from CmlImpRecords cml where 1=1 ");
			if(null == taskNum ||"".equals(taskNum)){
				 return null;
				
			}
			if( null != taskNum){
				 if(!"".equals(taskNum.trim())){
					 hql.append(" and  cml.taskId = ? ");
					 args.add(taskNum);
					 
				 }
				
			}
			if(null != fileName){
				if(!"".equals(fileName.trim())){
					hql.append(" and cml.oldName like ? ");
					args.add("%"+fileName+"%");
					
				}
			}
			if(null != beginTime){
				if(!"".equals(beginTime)){
					
					hql.append(" and cml.impDate >= to_date( ? ,'yyyy-MM-dd')");
					args.add(beginTime);
				}
				
			}
			if(null!= endTime){
				 if(!"".equals(endTime)){
					 hql.append(" and cml.impDate <= to_date(? ,'yyyy-MM-dd')" );
					 args.add(endTime);
					 
				 }
				
			}
			
			
	
			return findPage(page, hql.toString(), args.toArray());
		}
		
		
		/**
		 * 更新导入结果 
		 */
		
	/*	public boolean updateCmlRecords(CmlTaskInfos cmlTaskInfos,CmlImpRecords cmlImpRecords){
			
			
			
			
			 
			
		}*/
		
}
