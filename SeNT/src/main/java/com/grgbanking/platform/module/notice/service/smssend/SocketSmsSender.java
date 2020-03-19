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

/**
 * @author yrliang
 * 
 */
public abstract class SocketSmsSender extends AbstractSmsSender {
	/** 服务器ip */
	protected String serverIP;
	/** 服务器port */
	protected int serverPort;

	public SocketSmsSender() {
		super();

		serverIP = setting.getServerIP();
		try {
			serverPort = Integer.parseInt(setting.getServerPort());
		} catch (NumberFormatException ex) {
			logger.error("TCP Socket Server port setting error!", ex);
		}
	}
}
