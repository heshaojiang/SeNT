package com.grgbanking.sent.transmgr.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.sent.transmgr.entity.AtmTranInfo;
import com.grgbanking.sent.transmgr.entity.CmlImprecords;
import com.grgbanking.sent.transmgr.entity.CmlImprecordsDetail;
import com.grgbanking.sent.utils.DateUtil;

import flex.messaging.FlexContext;

/**
 * @author 骞跨數杩愰????
 * 
 */

	@Repository
	public class CmlImprecordsDao extends BaseDao<CmlImprecords> {

		@Transactional(readOnly = true)
		public CmlImprecords findCmlRCmlImprecordsByFileName(String name) {
			CmlImprecords cmlImprecords = new CmlImprecords();
			if (null != name && !"".equals(name.trim())) {
	/*
				StringBuffer hql = new StringBuffer(
						" from  CmlImprecords  cml where cml.newName = ?  and  cml.operaterStatus = 0 ");*/
				String[] args = new String[1];
				args[0] = name;
				try {
					cmlImprecords  = findUniqueBy("newName", name);
				
				} catch (NullPointerException e) {
					logger.error("", e);
					// TODO: handle exception
				}

			}
			return cmlImprecords;

		}
		
		@Transactional(readOnly = true)
		public CmlImprecords findCmlRCmlImprecordsByFileName2(String name) {
			CmlImprecords cmlImprecords = new CmlImprecords();
			if (null != name && !"".equals(name.trim())) {
	/*
				StringBuffer hql = new StringBuffer(
						" from  CmlImprecords  cml where cml.newName = ?  and  cml.operaterStatus = 0 ");*/
				String[] args = new String[1];
				args[0] = name;
				try {
					cmlImprecords  = findUniqueBy("fileName", name);
				
				} catch (NullPointerException e) {
					logger.error("", e);
					// TODO: handle exception
				}

			}
			return cmlImprecords;

		}
		
		/**
		 * @param list 一个集合
		 * @param page 一个page实体
		 * @return page
		 */
		@SuppressWarnings("unchecked")
		public Page getPageList(List list, Page page) {
			int recordCount = list.size();
			int pageNum = page.getPageNo();
			int pageSize = page.getPageSize();
			page.setTotalCount(list.size());
			if (recordCount > 0) {
				int beginRecordNumOfPage = (pageNum - 1) * pageSize;
				// 为什么是beginRecordNumOfPage + pageSize而不是beginRecordNumOfPage +
				// pageSize - 1?
				// 请看List中subList说明：Returns a view of the portion of this list
				// between the specified fromIndex, inclusive, and toIndex,
				// exclusive
				int endRecordNumOfPage = beginRecordNumOfPage + pageSize;
				if (endRecordNumOfPage >= recordCount) {
					endRecordNumOfPage = recordCount;
				}
				page.setResult(list.subList(beginRecordNumOfPage,
						endRecordNumOfPage));

			}
			return page;

		}
		
		
		/**
		 * @param tmlNum 设备编号
		 * @return realPath 文件路径
		 */
			public String CreatefilePath(String termId) {

				Date d1 = new Date();
				String dd = DateUtil.getyyyyMMddDate(d1);
				String Path = "doc" + File.separator + dd.substring(2, 4)
						+ File.separator + dd.substring(4, 6) + File.separator
						+ dd.substring(6, 8) + File.separator + termId + File.separator;
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
			
			public synchronized String GenertoryFileName(String termId, String taskNum,
					String oldName, int i) {
				
				String begin = "";
				String end = "";
				String ss = "";
				String ex = FilenameUtils.getExtension(oldName);
				String sql = " select max(newName) from  CmlImpRecords where newName like '"
						+ taskNum + "_" + termId + "_%'";
			
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
					StringBuffer s = new StringBuffer(taskNum + "_" + termId + "_");

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
			
			public static List parseCsv(String filePath) {
				throw new RuntimeException("*****************************");
//				List count = new ArrayList();
//				String[] str = {};
//				CsvReader reader = null;
//				try {
//					reader = new CsvReader(filePath, ',', Charset.forName("GBK"));
//					while (reader.readRecord()) {
//						str = reader.getValues();
//						if (str != null && str.length > 0) {
//							if (str[0] != null && !"".equals(str[0].trim())) {
//								count.add(str);
//							}
//						}
//					}
//				
//					return count;
//
//				} catch (Exception e) {
//				
//				
//					return null;
//
//				} finally {
//					reader.close();
//				}
			}
			
		
			/**
			 *上传文件 
			 */
			
			public static String upload(byte[] is,String filePath,  String oldFileName,
					String newFileName) {
		
				String url = "";
				  FileOutputStream fo = null;
		
				try {
					// 获取文件上传的真实路径
					String realPath =FlexContext.getServletContext().getRealPath(File.separator+filePath);
					File tempFile = new File(realPath + File.separator);
					if (!tempFile.exists()) {
						tempFile.mkdirs();
					}
				
		
				 fo= new FileOutputStream(realPath +File.separator +newFileName);
				 	fo.write(is);
				
					url = filePath + File.separator + newFileName ;
				
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
		/*	public Page<CmlImpRecords> findCmlImpRecordsPageForTask(
					Page<CmlImpRecords> page,  String fileName,
					String beginTime, String endTime) {
				List<String> args = new ArrayList<String>();
				StringBuffer hql = new StringBuffer(" from CmlImpRecords cml where 1=1 ");
				
				
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
			}*/
			
			public CmlImprecords getById(String id)
			{
				return this.get(id);
			}
			
}
