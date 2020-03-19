/**
 * 文件名：DeCompressUtil.java
 * 创建日期： 2012-5-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.innosystec.unrar.Archive;
import de.innosystec.unrar.rarfile.FileHeader;

/**
 * @author yrliang
 * 
 */
public class DeCompressUtil {
	private static Logger logger = LoggerFactory
			.getLogger(DeCompressUtil.class);

	/**
	 * 
	 * 解压zip格式压缩包
	 * 
	 * 对应的是ant.jar
	 */

	private static void unzip(String sourceZip, String destDir)
			throws Exception {

		Project p = new Project();

		Expand e = new Expand();

		e.setProject(p);

		e.setSrc(new File(sourceZip));

		e.setOverwrite(false);

		e.setDest(new File(destDir));

		/*
		 * 
		 * ant下的zip工具默认压缩编码为UTF-8编码，
		 * 
		 * 而winRAR软件压缩是用的windows默认的GBK或者GB2312编码
		 * 
		 * 所以解压缩时要制定编码格式
		 */

		e.setEncoding("gbk");

		e.execute();

	}

	/**
	 * 
	 * 解压rar格式压缩包。
	 * 
	 * 对应的是java-unrar-0.3.jar，但是java-unrar-0.3.jar又会用到commons-logging-1.1.1.jar
	 */

	private static void unrar(String sourceRar, String destDir)
			throws Exception {

		Archive a = null;

		FileOutputStream fos = null;

		try {

			a = new Archive(new File(sourceRar));

			FileHeader fh = a.nextFileHeader();

			while (fh != null) {

				if (!fh.isDirectory()) {

					// 1 根据不同的操作系统拿到相应的 destDirName 和 destFileName

					String compressFileName = fh.getFileNameString().trim();

					String destFileName = "";

					String destDirName = "";

					// 非windows系统

					if (File.separator.equals("/")) {

						destFileName = destDir
								+ compressFileName.replaceAll("\\\\", "/");

						destDirName = destFileName.substring(0, destFileName
								.lastIndexOf("/"));

						// windows系统

					} else {

						destFileName = destDir
								+ compressFileName.replaceAll("/", "\\\\");

						destDirName = destFileName.substring(0, destFileName
								.lastIndexOf("\\"));

					}

					// 2创建文件夹

					File dir = new File(destDirName);

					if (!dir.exists() || !dir.isDirectory()) {

						dir.mkdirs();

					}

					// 3解压缩文件

					fos = new FileOutputStream(new File(destFileName));

					a.extractFile(fh, fos);

					fos.close();

					fos = null;

				}

				fh = a.nextFileHeader();

			}

			a.close();

			a = null;

		} finally {

			if (fos != null) {
				fos.close();
				fos = null;
			}
			if (a != null) {
				a.close();
				a = null;
			}

		}

	}

	/**
	 * 
	 * 解压缩
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param destDir
	 *            目录
	 * @throws Exception
	 *             异常
	 */

	public static void deCompress(String sourceFile, String destDir)
			throws Exception {
		// 保证文件夹路径最后是"/"或者"\"
		char lastChar = destDir.charAt(destDir.length() - 1);
		if (lastChar != '/' && lastChar != '\\') {
			destDir += File.separator;
		}

		// 根据类型，进行相应的解压缩
		String type = sourceFile.substring(sourceFile.lastIndexOf(".") + 1);
		if (type.equals("zip")) {
			DeCompressUtil.unzip(sourceFile, destDir);
		} else if (type.equals("rar")) {
			DeCompressUtil.unrar(sourceFile, destDir);
		} else
			throw new Exception("只支持zip和rar格式的压缩包！");

	}

}
