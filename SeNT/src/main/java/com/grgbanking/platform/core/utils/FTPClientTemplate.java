/**
 * 文件名：FTPClientTemplate.java
 * 创建日期： 2012-5-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FTP客户端
 * 
 * @author summersun_ym
 * @version $Id: FTPClientTemplate.java 2010-11-22 上午12:54:47 $
 */
public class FTPClientTemplate {
	/** DOT */
	public static final String STR_DOT = ".";
	/** SLASH */
	public static final String STR_SLASH = "/";
	// ---------------------------------------------------------------------
	// Instance data
	// ---------------------------------------------------------------------
	/** logger */
	protected final Logger log = LoggerFactory.getLogger(FTPClientTemplate.class);

	private String host;
	private int port;
	private String username;
	private String password;

	private boolean binaryTransfer = true;
	private boolean passiveMode = true;
	private String encoding = "UTF-8";
	private int clientTimeout = 3000;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBinaryTransfer() {
		return binaryTransfer;
	}

	public void setBinaryTransfer(boolean binaryTransfer) {
		this.binaryTransfer = binaryTransfer;
	}

	public boolean isPassiveMode() {
		return passiveMode;
	}

	public void setPassiveMode(boolean passiveMode) {
		this.passiveMode = passiveMode;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public int getClientTimeout() {
		return clientTimeout;
	}

	public void setClientTimeout(int clientTimeout) {
		this.clientTimeout = clientTimeout;
	}

	// ---------------------------------------------------------------------
	// private method
	// ---------------------------------------------------------------------
	/**
	 * 返回一个FTPClient实例
	 * 
	 * @return FTPClient
	 * @throws Exception
	 *             异常
	 */
	public FTPClient getFTPClient() throws Exception {
		FTPClient ftpClient = new FTPClient(); // 构造一个FtpClient实例
		ftpClient.setControlEncoding(encoding); // 设置字符集

		connect(ftpClient); // 连接到ftp服务器

		// 设置为passive模式
		if (passiveMode) {
			ftpClient.enterLocalPassiveMode();
		}
		setFileType(ftpClient); // 设置文件传输类型

		try {
			ftpClient.setSoTimeout(clientTimeout);
		} catch (SocketException e) {
			throw new Exception("Set timeout error.", e);
		}

		return ftpClient;
	}

	/**
	 * 设置文件传输类型
	 * 
	 * @throws Exception
	 * @throws IOException
	 */
	private void setFileType(FTPClient ftpClient) throws Exception {
		try {
			if (binaryTransfer) {
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			} else {
				ftpClient.setFileType(FTPClient.ASCII_FILE_TYPE);
			}
		} catch (IOException e) {
			throw new Exception("Could not to set file type.", e);
		}
	}

	/**
	 * 连接到ftp服务器
	 * 
	 * @param ftpClient
	 *            FTPClient
	 * @return 连接成功返回true，否则返回false
	 * @throws Exception
	 *             异常
	 */
	public boolean connect(FTPClient ftpClient) throws Exception {
		try {
			ftpClient.connect(host, port);

			// 连接后检测返回码来校验连接是否成功
			int reply = ftpClient.getReplyCode();

			if (FTPReply.isPositiveCompletion(reply)) {
				// 登陆到ftp服务器
				if (ftpClient.login(username, password)) {
					setFileType(ftpClient);
					return true;
				}
			} else {
				ftpClient.disconnect();
				throw new Exception("FTP server refused connection.");
			}
		} catch (IOException e) {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect(); // 断开连接
				} catch (IOException e1) {
					throw new Exception("Could not disconnect from server.", e);
				}
			}
			throw new Exception("Could not connect to server.", e);
		}
		return false;
	}

	/**
	 * 断开ftp连接
	 * 
	 * @throws Exception
	 */
	private void disconnect(FTPClient ftpClient) throws Exception {
		try {
			ftpClient.logout();
			if (ftpClient.isConnected()) {
				ftpClient.disconnect();
			}
		} catch (IOException e) {
			throw new Exception("Could not disconnect from server.", e);
		}
	}

	// ---------------------------------------------------------------------
	// public method
	// ---------------------------------------------------------------------
	/**
	 * 上传一个本地文件到远程指定文件
	 * 
	 * @param serverFile
	 *            服务器端文件名(包括完整路径)
	 * @param localFile
	 *            本地文件名(包括完整路径)
	 * @return 成功时，返回true，失败返回false
	 * @throws Exception
	 *             异常
	 */
	public boolean put(String serverFile, String localFile) throws Exception {
		return put(serverFile, localFile, false);
	}

	/**
	 * 上传一个本地文件到远程指定文件
	 * 
	 * @param serverFile
	 *            服务器端文件名(包括完整路径)
	 * @param localFile
	 *            本地文件名(包括完整路径)
	 * @param delFile
	 *            成功后是否删除文件
	 * @return 成功时，返回true，失败返回false
	 * @throws Exception
	 *             异常
	 */
	public boolean put(String serverFile, String localFile, boolean delFile) throws Exception {
		FTPClient ftpClient = null;
		InputStream input = null;
		try {
			ftpClient = getFTPClient();
			// 处理传输
			input = new FileInputStream(localFile);
			boolean result = ftpClient.storeFile(serverFile, input);
			log.debug("put " + localFile);
			return result;
		} catch (FileNotFoundException e) {
			throw new Exception("local file not found.", e);
		} catch (IOException e) {
			throw new Exception("Could not put file to server.", e);
		} finally {
			if (input != null) {
				input.close();
			}
			if (delFile) {
				(new File(localFile)).delete();
			}
			log.debug("delete " + localFile);
			if (ftpClient != null) {
				disconnect(ftpClient); // 断开连接
			}
		}
	}

	/**
	 * 下载一个远程文件到本地的指定文件
	 * 
	 * @param serverFile
	 *            服务器端文件名(包括完整路径)
	 * @param localFile
	 *            本地文件名(包括完整路径)
	 * @return 成功时，返回true，失败返回false
	 * @throws Exception
	 *             异常
	 */
	public boolean get(String serverFile, String localFile) throws Exception {
		return get(serverFile, localFile, false);
	}

	/**
	 * 下载一个远程文件到本地的指定文件
	 * 
	 * @param ftpClient
	 *            FTPClient
	 * @param serverFile
	 *            服务器端文件名(包括完整路径)
	 * @param localFile
	 *            本地文件名(包括完整路径)
	 * @return 成功时，返回true，失败返回false
	 * @throws Exception
	 *             异常
	 * 
	 */
	public boolean get(FTPClient ftpClient, String serverFile, String localFile) throws Exception {
		return get(ftpClient, serverFile, localFile, false);
	}

	/**
	 * 下载一个远程文件到本地的指定文件
	 * 
	 * @param serverFile
	 *            服务器端文件名(包括完整路径)
	 * @param localFile
	 *            本地文件名(包括完整路径)
	 * @param delFile
	 *            删除文件
	 * @return 成功时，返回true，失败返回false
	 * @throws Exception
	 *             异常
	 */
	public boolean get(String serverFile, String localFile, boolean delFile) throws Exception {
		OutputStream output = null;
		try {
			String dir = localFile.substring(0, localFile.lastIndexOf("/"));

			File loc = new File(dir);
			loc.mkdirs();

			output = new FileOutputStream(localFile);
			return get(serverFile, output, delFile);
		} catch (FileNotFoundException e) {
			throw new Exception("local file not found.", e);
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				throw new Exception("Couldn't close FileOutputStream.", e);
			}
		}
	}

	/**
	 * 下载一个远程文件到本地的指定文件
	 * 
	 * @param ftpClient
	 *            FTPClient
	 * @param serverFile
	 *            服务器端文件名(包括完整路径)
	 * @param localFile
	 *            本地文件名(包括完整路径)
	 * @param delFile
	 *            删除文件
	 * @return 成功时，返回true，失败返回false
	 * @throws Exception
	 *             异常
	 */
	public boolean get(FTPClient ftpClient, String serverFile, String localFile, boolean delFile) throws Exception {
		OutputStream output = null;
		try {
			String dir = localFile.substring(0, localFile.lastIndexOf("/"));

			File loc = new File(dir);
			loc.mkdirs();

			output = new FileOutputStream(localFile);
			return get(ftpClient, serverFile, output, delFile);
		} catch (FileNotFoundException e) {
			throw new Exception("local file not found.", e);
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				throw new Exception("Couldn't close FileOutputStream.", e);
			}
		}
	}

	/**
	 * 下载一个远程文件到指定的流 处理完后记得关闭流
	 * 
	 * @param serverFile
	 *            服务端文件
	 * @param output
	 *            输出流
	 * @return 是否成功
	 * @throws Exception
	 *             异常
	 */
	public boolean get(String serverFile, OutputStream output) throws Exception {
		return get(serverFile, output, false);
	}

	/**
	 * 下载一个远程文件到指定的流 处理完后记得关闭流
	 * 
	 * @param serverFile
	 *            服务器文件
	 * @param output
	 *            输出流
	 * @param delFile
	 *            删除文件
	 * @return 成功
	 * @throws Exception
	 *             异常
	 */
	public boolean get(String serverFile, OutputStream output, boolean delFile) throws Exception {
		FTPClient ftpClient = null;
		try {
			ftpClient = getFTPClient();
			// 处理传输
			ftpClient.retrieveFile(serverFile, output);
			if (delFile) { // 删除远程文件
				ftpClient.deleteFile(serverFile);
			}
			return true;
		} catch (IOException e) {
			throw new Exception("Couldn't get file from server.", e);
		} finally {
			if (ftpClient != null) {
				disconnect(ftpClient); // 断开连接
			}
		}
	}

	/**
	 * 下载一个远程文件到指定的流 处理完后记得关闭流
	 * 
	 * @param ftpClient
	 *            FTPClient
	 * @param serverFile
	 *            服务器文件
	 * @param output
	 *            输出流
	 * @param delFile
	 *            删除文件
	 * @return 成功
	 * @throws Exception
	 *             异常
	 */
	public boolean get(FTPClient ftpClient, String serverFile, OutputStream output, boolean delFile) throws Exception {
		try {
			boolean result = false;
			// 处理传输
			result = ftpClient.retrieveFile(serverFile, output);
			if (result) {
				if (delFile) { // 删除远程文件
					result = ftpClient.deleteFile(serverFile);
				}
			}

			return result;
		} catch (IOException e) {
			throw new Exception("Couldn't get file from server.", e);
		}
	}

	/**
	 * 从ftp服务器上删除一个文件
	 * 
	 * @param delFile
	 *            删除文件
	 * @return 成功
	 * @throws Exception
	 *             异常
	 */
	public boolean delete(String delFile) throws Exception {
		FTPClient ftpClient = null;
		try {
			ftpClient = getFTPClient();
			ftpClient.deleteFile(delFile);
			return true;
		} catch (IOException e) {
			throw new Exception("Couldn't delete file from server.", e);
		} finally {
			if (ftpClient != null) {
				disconnect(ftpClient); // 断开连接
			}
		}
	}

	/**
	 * 批量删除
	 * 
	 * @param delFiles
	 *            删除文件
	 * @return 成功
	 * @throws Exception
	 *             异常
	 */
	public boolean delete(String[] delFiles) throws Exception {
		FTPClient ftpClient = null;
		try {
			ftpClient = getFTPClient();
			for (String s : delFiles) {
				ftpClient.deleteFile(s);
			}
			return true;
		} catch (IOException e) {
			throw new Exception("Couldn't delete file from server.", e);
		} finally {
			if (ftpClient != null) {
				disconnect(ftpClient); // 断开连接
			}
		}
	}

	/**
	 * 列出远程默认目录下所有的文件
	 * 
	 * @return 远程默认目录下所有文件名的列表，目录不存在或者目录下没有文件时返回0长度的数组
	 * @throws Exception
	 *             异常
	 */
	public String[] listNames() throws Exception {
		return listNames(null);
	}

	/**
	 * 列出远程目录下所有的文件
	 * 
	 * @param remotePath
	 *            远程目录名
	 * @return 远程目录下所有文件名的列表，目录不存在或者目录下没有文件时返回0长度的数组
	 * @throws Exception
	 *             异常
	 */
	public String[] listNames(String remotePath) throws Exception {
		FTPClient ftpClient = null;
		try {
			ftpClient = getFTPClient();
			String[] listNames = ftpClient.listNames(remotePath);
			return listNames;
		} catch (IOException e) {
			throw new Exception("列出远程目录下所有的文件时出现异常", e);
		} finally {
			if (ftpClient != null) {
				disconnect(ftpClient); // 断开连接
			}
		}
	}

	/**
	 * 列出指定父目录下面所以子目录里面所有文件路径，并保存起来
	 * 
	 * @param ftpClient
	 *            ： FTP客户端
	 * @param path
	 *            ：父目录
	 * @param downloadedFilePaths
	 *            下载文件路径
	 * @throws Exception
	 *             异常
	 */
	public List<String> listEngine(FTPClient ftpClient, String path, List<String> downloadedFilePaths) throws Exception {
		try {
			List<String> fileList = new ArrayList<String>();

			FTPListParseEngine engine = ftpClient.initiateListParsing(path);

			while (engine.hasNext()) {
				FTPFile[] files = engine.getNext(1);

				if (files[0].getName().startsWith(STR_DOT)) {
					continue;
				}

				String filePath = new StringBuffer(path).append(files[0].getName()).toString();
				if (files[0].isDirectory()) {

					fileList.addAll(listEngine(ftpClient, new StringBuffer(filePath).append(STR_SLASH).toString(),
							downloadedFilePaths));
					continue;
				}

				if (!downloadedFilePaths.contains(filePath)) {
					fileList.add(filePath);
				}
			}

			return fileList;
		} catch (IOException e) {
			throw new Exception("列出远程目录下所有的文件时出现异常", e);
		}
	}

	public static void main(String[] args) throws Exception {
		final FTPClientTemplate ftp = new FTPClientTemplate();
		ftp.setHost("10.1.3.69");
		ftp.setPort(21);
		ftp.setUsername("feelej");
		ftp.setPassword("feelej");
		ftp.setBinaryTransfer(true);
		ftp.setPassiveMode(true);
		ftp.setEncoding("utf-8");

		String filePath = "upload//text1.java";
		final FTPClient ftpClient = ftp.getFTPClient();
		ftp.put(filePath, "C:\\Users\\SONY\\Desktop\\Constants.java");
		ftpClient.disconnect();
	}

}