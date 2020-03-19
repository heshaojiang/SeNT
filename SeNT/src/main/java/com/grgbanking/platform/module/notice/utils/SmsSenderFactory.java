/**
 * 文件名：SmsSenderFactory.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.utils;

import java.util.HashMap;
import java.util.Map;

import com.grgbanking.platform.module.notice.NoticeConstants;
import com.grgbanking.platform.module.notice.service.smssend.AbstractSmsSender;
import com.grgbanking.platform.module.notice.service.smssend.DBSmsSender;
import com.grgbanking.platform.module.notice.service.smssend.FtpSmsSender;
import com.grgbanking.platform.module.notice.service.smssend.GsmSmsSender;
import com.grgbanking.platform.module.notice.service.smssend.TCPSocketSmsSender;
import com.grgbanking.platform.module.notice.service.smssend.UDPSocketSmsSender;

/**
 * @author yrliang
 * 
 */
public class SmsSenderFactory {
	private static SmsSenderFactory instance = null;

	private Map<String, AbstractSmsSender> smsSenderMap = new HashMap<String, AbstractSmsSender>();

	SmsSenderFactory() {
		smsSenderMap.put(NoticeConstants.SMS_SEND_METHOD_FTP, new FtpSmsSender());
		smsSenderMap.put(NoticeConstants.SMS_SEND_METHOD_TCP, new TCPSocketSmsSender());
		smsSenderMap.put(NoticeConstants.SMS_SEND_METHOD_UDP, new UDPSocketSmsSender());
		smsSenderMap.put(NoticeConstants.SMS_SEND_METHOD_DB, new DBSmsSender());
		smsSenderMap.put(NoticeConstants.SMS_SEND_METHOD_GSM, new GsmSmsSender());
	}

	public static SmsSenderFactory getInstance() {
		if(instance == null) {
			instance = new SmsSenderFactory();
		}
		return instance;
	}

	public AbstractSmsSender getSmsSender(String sendMethod) {
		return smsSenderMap.get(sendMethod);
	}
}
