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
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.module.notice.vo.SmsVo;

/**
 * @author yrliang
 * 
 */
public class UDPSocketSmsSender extends SocketSmsSender {
	private static Logger logger = LoggerFactory.getLogger(UDPSocketSmsSender.class);

	public void sender(List<SmsVo> list) {
		DatagramSocket socket = null;
		InetAddress addr = null;
		try {
			socket = new DatagramSocket();
			addr = InetAddress.getByName(super.serverIP);
			for(SmsVo sms : list) {
				//String newStr = new String(super.getContent(sms).getBytes(), setting.getEncoding());
				byte[] bytes = getContent(sms).getBytes(setting.getEncoding());
				DatagramPacket packet = new DatagramPacket(bytes, bytes.length, addr, super.serverPort);
				try {
					socket.send(packet);
					sms.setSucc(true);
				} catch(IOException e) {
					logger.error("Send message error, io error!", e);
				} catch(Exception e) {
					logger.error("Send message error, error!", e);
				}
			}
		} catch (SocketException e) {
			logger.error("Send message error, Socket Exception!", e);
		} catch (UnknownHostException ex) {
			logger.error("Send message error, TCP socket SMS server host can not be unknown!", ex);
		} catch (IOException ex) {
			logger.error("Send message error, io error!", ex);
		} catch (Exception ex) {
			logger.error("Send message error, io error!", ex);
		} finally {
			if(socket != null) {
				socket.close();
			}
		}

		return;
	}
}
