package com.grgbanking.sent.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import flex.messaging.FlexContext;

public class CSVFileUtil {

	/**
	 * 生成CSV格式文件
	 * @param expData	待写入CSV文件的内容
	 * @param rowMapper	生成CSV文件的首行内容
	 * @param outPutPath	文件生成路径
	 * @param filename	文件名
	 * @return
	 */
	public String createCSVFile(List expData,LinkedHashMap rowMapper,
			String outPutPath,String filename)
	{
		File csvFile = null;
		BufferedWriter csvFileOutputStream = null;
		try{
			csvFile = new File(filename);
			File parent = csvFile.getParentFile();
			if(parent != null && !parent.exists())
			{
				parent.mkdirs();
			}
			csvFile.createNewFile();
			//使用GB2312编码格式正确识别分隔符","
			csvFileOutputStream = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(csvFile),"GB2312"),1024);
			//写入头部文件
			for(Iterator propertyIterator = rowMapper.entrySet().iterator();propertyIterator.hasNext();)
			{
				java.util.Map.Entry propertyEntry = (java.util.Map.Entry)propertyIterator.next();
				csvFileOutputStream.write("\""+propertyEntry.getValue().toString()+"\"");
				if(propertyIterator.hasNext())
				{
					csvFileOutputStream.write(",");
				}
			}
			csvFileOutputStream.newLine();
			//写入文件内容
			for(Iterator iterator = expData.iterator();iterator.hasNext();)
			{
				Map row = (Map)iterator.next();
				//System.out.println(row);
				for(Iterator propertyIterator = row.entrySet().iterator();propertyIterator.hasNext();)
				{
					Entry propertyEntry = (Entry) propertyIterator.next();
					//System.out.println(BeanUtils.getProperty(row,propertyEntry.getKey().toString()));
					csvFileOutputStream.write("\""+propertyEntry.getValue().toString()+"\"");
					if(propertyIterator.hasNext())
					{
						csvFileOutputStream.write(",");
					}
				}
				if(iterator.hasNext())
				{
					csvFileOutputStream.newLine();
				}
			}
			csvFileOutputStream.flush();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				csvFileOutputStream.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return filename;
	}
	
	/**
	 * 生成CSV格式文件
	 * @param expData	待写入CSV文件的内容
	 * @param rowMapper	生成CSV文件的首行内容
	 * @param filename	文件名
	 * @return
	 * @throws IOException 
	 */
	public String createCSVFile(List expData, LinkedHashMap rowMapper, String fileName) throws IOException
	{
		HttpServletRequest request = FlexContext.getHttpRequest();	
		//HttpServletResponse response = FlexContext.getHttpResponse();
		String filePath = request.getSession().getServletContext().getRealPath("") + "/exportFile/" + fileName;
		
		File csvFile = null;
		BufferedWriter csvFileOutputStream = null;
		try
		{
			csvFile = new File(filePath);
			File parent = csvFile.getParentFile();
			if( parent != null && !parent.exists() )
			{
				parent.mkdirs();
			}
			csvFile.createNewFile();
			//使用GB2312编码格式正确识别分隔符","
			csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile),"GB2312"),1024);
			//写入头部文件
			for(Iterator propertyIterator = rowMapper.entrySet().iterator();propertyIterator.hasNext();)
			{
				java.util.Map.Entry propertyEntry = (java.util.Map.Entry)propertyIterator.next();
				csvFileOutputStream.write("\""+propertyEntry.getValue().toString()+"\"");
				if(propertyIterator.hasNext())
				{
					csvFileOutputStream.write(",");
				}
			}
			csvFileOutputStream.newLine();
			//写入文件内容
			for(Iterator iterator = expData.iterator();iterator.hasNext();)
			{
				Map row = (Map)iterator.next();
				for(Iterator propertyIterator = row.entrySet().iterator();propertyIterator.hasNext();)
				{
					Entry propertyEntry = (Entry) propertyIterator.next();
					csvFileOutputStream.write("\""+propertyEntry.getValue().toString()+"\"");
					if(propertyIterator.hasNext())
					{
						csvFileOutputStream.write(",");
					}
				}
				if(iterator.hasNext())
				{
					csvFileOutputStream.newLine();
				}
			}
			csvFileOutputStream.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				csvFileOutputStream.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return fileName;
	}
	
	
}
