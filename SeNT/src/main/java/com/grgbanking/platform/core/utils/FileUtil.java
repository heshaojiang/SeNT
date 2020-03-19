/**
 * 文件名：FileUtil.java
 * 创建日期： 2012-5-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.sent.utils.StreamUtil;

/**
 * @author yrliang
 * 
 */
public class FileUtil
{
	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);
	public static void main(String args[]) throws IOException
	{
/*		// 源文件夹
		String url1 = "D:/user/test/";
		// 目标文件夹
		String url2 = "D:/user/testcopy/";
		// 创建目标文件夹
		(new File(url2)).mkdirs();
		// 获取源文件夹当前下的文件或目录
		File[] file = (new File(url1)).listFiles();
		for( int i = 0 ; i < file.length ; i++ )
		{
			if( file[i].isFile() )
			{
				// 复制文件
				String type = file[i].getName().substring(file[i].getName().lastIndexOf(".") + 1);

				if( type.equalsIgnoreCase("txt") )
				{
					copyFile(file[i], new File(url2 + file[i].getName()), AppCoreConstants.UTF8, AppCoreConstants.GBK);
				}
				else
				{
					copyFile(file[i], new File(url2 + file[i].getName()));
				}
			}
			if( file[i].isDirectory() )
			{
				// 复制目录
				String sourceDir = url1 + File.separator + file[i].getName();
				String targetDir = url2 + File.separator + file[i].getName();
				copyDirectiory(sourceDir, targetDir);
			}
		}*/
		
		String LINEENDING  =  "\r\n";//"0x0D0X0A";
		String GH_LINECONTENTTEMPLATE = "%s,%s,%s,%s,%s,%s"+LINEENDING;
		String out = "E:/tmp.txt";
		File outFile = new File(out);
		
		String machinesno = "BOC15/GRG/CM40012345678";
		String trandatetime = "20160203144314";
		char f = 0;
		String sNO = "I3Q6626947".replace("?", "_").replace("*", "_");
		String currency = "CNY";//币种
		String versionNum = "3"; //版别 版别目前有1999、2005两种，无法识别用9999表示
		String denom = "50";//币值
		denom = StringUtils.leftPad(denom, 3, "0");//币值 纸币面值，不足3位前端补零，如100，050，020，010

		String contentLine = String.format(GH_LINECONTENTTEMPLATE, machinesno,
				trandatetime,sNO,currency,versionNum,denom);
		
		writeStringToFile(outFile, contentLine, true);
		writeStringToFile(outFile, contentLine, true);
		
	}

	// 复制文件
	public static void copyFile(File sourceFile, File targetFile) throws IOException
	{
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try
		{
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1)
			{
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		}
		finally
		{
			// 关闭流
			if( inBuff != null )
			{
				inBuff.close();
			}
			if( outBuff != null )
			{
				outBuff.close();
			}
		}
	}

	// 复制文件夹
	public static void copyDirectiory(String sourceDir, String targetDir) throws IOException
	{
		// 新建目标目录
		(new File(targetDir)).mkdirs();
		// 获取源文件夹当前下的文件或目录
		File[] file = (new File(sourceDir)).listFiles();
		for( int i = 0 ; i < file.length ; i++ )
		{
			if( file[i].isFile() )
			{
				// 源文件
				File sourceFile = file[i];
				// 目标文件
				File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
				copyFile(sourceFile, targetFile);
			}
			if( file[i].isDirectory() )
			{
				// 准备复制的源文件夹
				String dir1 = sourceDir + "/" + file[i].getName();
				// 准备复制的目标文件夹
				String dir2 = targetDir + "/" + file[i].getName();
				copyDirectiory(dir1, dir2);
			}
		}
	}

	/**
	 * 
	 * @param srcFileName
	 *            源文件
	 * @param destFileName
	 *            目标文件
	 * @param srcCoding
	 *            源文件字符集
	 * @param destCoding
	 *            目标文件字符集
	 * @throws IOException
	 *             IO异常
	 */
	public static void copyFile(File srcFileName, File destFileName, String srcCoding, String destCoding) throws IOException
	{// 把文件转换为GBK文件
		BufferedReader br = null;
		BufferedWriter bw = null;
		try
		{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFileName), srcCoding));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFileName), destCoding));
			char[] cbuf = new char[1024 * 5];
			int len = cbuf.length;
			int off = 0;
			int ret = 0;
			while ((ret = br.read(cbuf, off, len)) > 0)
			{
				off += ret;
				len -= ret;
			}
			bw.write(cbuf, 0, off);
			bw.flush();
		}
		finally
		{
			if( br != null )
			{
				br.close();
			}
			if( bw != null )
			{
				bw.close();
			}
		}
	}

	/**
	 * 
	 * @param filepath
	 *            file path
	 * @throws IOException
	 */
	public static void del(String filepath) throws IOException
	{
		File f = new File(filepath);// 定义文件路径
		if( f.exists() && f.isDirectory() )
		{	// 判断是文件还是目录
			if( f.listFiles().length == 0 )
			{	// 若目录下没有文件则直接删除
				f.delete();
			}
			else
			{	// 若有则把文件放进数组，并判断是否有下级目录
				File delFile[] = f.listFiles();
				int i = f.listFiles().length;
				for( int j = 0 ; j < i ; j++ )
				{
					if( delFile[j].isDirectory() )
					{
						del(delFile[j].getAbsolutePath());// 递归调用del方法并取得子目录路径
					}
					delFile[j].delete();// 删除文件
				}
			}
		}
	}

	
	public static byte[] getFileContent(File file) throws IOException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
			byte[] buf = new byte[1024];
			while( true )
			{
				int len = fis.read(buf);
				if( len==-1 )
				{
					break;
				}
				bos.write(buf, 0, len);
			}
		}
		finally
		{
			StreamUtil.close(fis);
		}
		
		return bos.toByteArray();
	}
	
	public static void writeStringToFile(File file, String data, boolean appended)throws IOException{
		
		FileOutputStream fouts = new FileOutputStream(file, appended);
		try {
		  fouts.write(data.getBytes());
		} finally {
			try {
				if (fouts != null) {
					fouts.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				logger.error(e.getMessage(),e);
				
			}
			
		}
		
	}
	
}
