/**
 * 文件名：GsmSmsSender.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service.smssend;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.module.notice.vo.SmsVo;

/**
 * @author yrliang
 * 
 */
public class TCPSocketSmsSender extends SocketSmsSender {
	private static Logger logger = LoggerFactory.getLogger(TCPSocketSmsSender.class);

	public void sender(List<SmsVo> list) {

		Socket socket = null;
		PrintStream bw = null;
		try {

			//bw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), setting.getEncoding())), false);
			//bw.write(super.getContent(sms));
			for(SmsVo sms : list) {
				//String newStr = new String(super.getContent(sms).getBytes(),setting.getEncoding());
				try {
					socket = new Socket(serverIP, serverPort);
					bw = new PrintStream(socket.getOutputStream(), false, setting.getEncoding());
					bw.println(super.getContent(sms));
					bw.flush();
					sms.setSucc(true);
				} catch(UnknownHostException ex) {
					logger.error("Send message error, TCP socket SMS server host can not be unknown!", ex);
				} catch(IOException e) {
					logger.error("Send message error, io error!", e);
				} catch(Exception e) {
					logger.error("Send message error, error!", e);
				} finally {
					try {
						bw.close();
						if(!socket.isClosed()) {
							socket.close();
						}
					} catch(IOException e) {

					}
				}
			}
		} catch(Exception e) {
			logger.error("Send message error, error!", e);
		}

	}

}
