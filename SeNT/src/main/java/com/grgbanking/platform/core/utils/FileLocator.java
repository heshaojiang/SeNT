/**
 * 文件名：FileLocator.java
 * 创建日期： 2012-5-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import com.grgbanking.platform.core.exception.SysException;

/**
 * 查找文件.
 * 
 * @author yrliang
 * 
 */
public class FileLocator {

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：getConfFile(从根路径中加载配置文件) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 getConfFile(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param fileName
	 *            file name
	 * @return String
	 * @Exception 异常对象 <br>
	 */
	public String getConfFile(String fileName) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = getClass().getClassLoader();
		}
		URL confURL = classLoader.getResource(fileName);
		if (confURL == null) {
			confURL = classLoader.getResource("META-INF/" + fileName);
		}
		if (confURL == null) {
			throw new SysException(" in classpath can't  locate file: " + fileName);
		} else {
			File file1 = new File(confURL.getFile());
			if (file1.isFile()) {
				return confURL.getFile();
			} else {
				throw new SysException(" it is not a file: " + confURL.getFile());
			}
		}
	}

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：getConfStream(从根路径中获得读取文件的输入流) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 getConfStream(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param fileName
	 *            file name
	 * @return InputStream
	 * @Exception 异常对象 <br>
	 */
	public InputStream getConfStream(String fileName) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = this.getClass().getClassLoader();
		}
		InputStream stream = classLoader.getResourceAsStream(fileName);
		if (stream == null) {
			stream = classLoader.getResourceAsStream("META-INF/" + fileName);
		}
		if (stream == null) {
			throw new SysException("PropsUtil error: cann't find config file:-->" + fileName);
		}
		return stream;
	}

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：getURL(根据classpath相对路径获取绝对路径URL) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 getURL(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param location
	 * @return
	 * @throws SysException
	 *             URL
	 * @Exception 异常对象 <br>
	 */
	public URL getURL(String location) {
		String fullLocation = location;

		URL url = null;

		try {
			url = new URL(fullLocation);
		} catch (java.net.MalformedURLException e) {
			throw new SysException("file address error!", e);
		}
		if (url == null) {
			throw new SysException(new Throwable("read config file error!"));
		}

		return url;
	}

	/**
	 * 
	 * 日期：2011-6-30<br>
	 * 版本：V1.0<br>
	 * 描述：loadResource(根据classpath相对路径获取文件流) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-6-30 上午11:36:47 <br>
	 * 创建人 yt<br>
	 * ===============================================<br>
	 * 修改日期：2011-6-30<br>
	 * 修改人 yt<br>
	 * 修改描述 loadResource(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param location
	 * @return
	 * @throws SysException
	 *             InputStream
	 * @Exception 异常对象 <br>
	 */
	public InputStream loadResource(String location) {
		URL url = getURL(location);

		try {
			return url.openStream();
		} catch (java.io.IOException e) {
			throw new SysException("load file error!", e);
		}

	}
}
