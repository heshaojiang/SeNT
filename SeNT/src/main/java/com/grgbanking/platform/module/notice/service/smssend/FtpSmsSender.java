/**
 * 文件名：FtpSmsSender.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service.smssend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;

import com.grgbanking.platform.core.msgtemplate.MsgTemplate;
import com.grgbanking.platform.core.utils.FTPClientTemplate;
import com.grgbanking.platform.module.notice.vo.SmsVo;

/**
 * @author yrliang
 * 
 */
public class FtpSmsSender extends AbstractSmsSender {
	private String ftpDir;
	private String ftpFileName;
	private FTPClientTemplate ftp = new FTPClientTemplate();
	private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");

	public FtpSmsSender() {
		super();

		ftp.setHost(setting.getServerIP());
		ftp.setPort(Integer.parseInt(setting.getServerPort()));
		ftp.setUsername(setting.getUser());
		ftp.setPassword(setting.getPassword());
		ftp.setEncoding(setting.getEncoding());

		ftp.setBinaryTransfer(true);
		ftp.setPassiveMode(true);

		ftpDir = setting.getFtpDir();
		ftpFileName = setting.getFtpFileName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.grgbanking.platform.module.notice.service.interfaces.ISmsSender#sender
	 * ()
	 */
	public void sender(List<SmsVo> list) {
		String fileName = getFileName(list.get(0));
		//		String fileContent = super.getContent(smsVo);
		String localFile = createTempFile(fileName, list);
		if (localFile == null)
			return;
		FTPClient ftpClient = null;
		try {
			ftpClient = ftp.getFTPClient();
			boolean result = ftp.put(ftpDir + FTPClientTemplate.STR_SLASH + fileName, localFile);
			if(result) {
				for(SmsVo sms : list) {
					sms.setSucc(true);
				}
			}
		} catch (IOException e) {
			logger.error("FTP transport error!", e);

		} catch (Exception e) {
			logger.error("FTP transport error!", e);

		} finally {
			File file = new File(localFile);
			if (file.exists()) {
				file.delete();
			}
			if(ftpClient != null && ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch(IOException ioe) {

				}
			}
		}

		return;
	}

	private String createTempFile(String fileName, List<SmsVo> list) {
		FileOutputStream outStream;
		try {
			File dir = new File("temp");
			if(!dir.exists()) {
				dir.mkdir();
			}
			File file = new File("temp/" + fileName);
			if(!file.exists()) {
				file.createNewFile();
			}
			outStream = new FileOutputStream(file);
			for(SmsVo sms : list) {
				String fileContent = super.getContent(sms) + "\r\n";
				//String newStr = new String(fileContent.getBytes(CHARSET_UNICODE), setting.getEncoding());
				outStream.write(fileContent.getBytes(setting.getEncoding()));
			}

			outStream.close();
			return file.getAbsolutePath();
		} catch (IOException e) {
			logger.error("FTP transport error!", e);
		}

		return null;
	}

	private String getFileName(SmsVo smsVo) {
		return MsgTemplate.phase(SmsVo.class, smsVo, ftpFileName);
	}

}
