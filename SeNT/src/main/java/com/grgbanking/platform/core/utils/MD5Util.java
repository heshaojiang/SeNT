/**
 * 文件名：MD5Util.java
 * 创建日期： 2012-6-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.security.service.UserInfo4Flex;

/**
 * MD5加密工具类.
 * 
 * @author yrliang
 */
public class MD5Util {
	private static Logger logger = LoggerFactory.getLogger(UserInfo4Flex.class);

	/**
	 * 字符串MD5加密.
	 * 
	 * @param s
	 * @return
	 */
	public static String stringToMD5(String str) {

		try {
			byte[] strTemp = str.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			return toHexString(mdTemp.digest());
		} catch (NoSuchAlgorithmException e) {
			logger.error("加密算法出错!", e);
			return null;
		}
	}

	/**
	 * 根据文件名获得文件MD5.
	 * 
	 * @param fileName
	 *            file name
	 * @return
	 */
	public static String fileNameToMD5(String fileName) {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fileName);
			return streamToMD5(inputStream);
		} catch (FileNotFoundException e) {
			logger.error("file not foun!", e);
			return null;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("", e);
				}
			}
		}
	}

	/**
	 * 根据输入流获得文件MD5.
	 * 
	 * @param inputStream
	 * @return
	 */
	public static String streamToMD5(InputStream inputStream) {
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[1024];
			int numRead = 0;
			while ((numRead = inputStream.read(buffer)) > 0) {
				mdTemp.update(buffer, 0, numRead);
			}
			return toHexString(mdTemp.digest());
		} catch (NoSuchAlgorithmException e) {
			logger.error("加密异常", e);
		} catch (IOException e) {
			logger.error("加密异常", e);
		}

		return null;
	}

	private static String toHexString(byte[] md) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < md.length; i++) {
			if ((md[i] & 0xff) < 0x10) {
				sb.append("0");
			}

			sb.append(Long.toString(md[i] & 0xff, 16));
		}
		return sb.toString();
	}

	// public static void main(String[] args) {
	// // 字符串加密
	// logger.info(MD5Util.stringToMD5("admin"));
	// // 文件加密
	// logger.info(MD5Util.fileNameToMD5("f://imp.log"));
	// }
}
