/**
 * 文件名：ISmsSender.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service.smssend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.msgtemplate.MsgTemplate;
import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.module.notice.service.SmsSettingService;
import com.grgbanking.platform.module.notice.vo.SmsSettingVo;
import com.grgbanking.platform.module.notice.vo.SmsVo;

/**
 * @author yrliang
 * 
 */
public abstract class AbstractSmsSender implements ISmsSender {
	/** 日志对象 */
	protected static Logger logger = LoggerFactory.getLogger(AbstractSmsSender.class);

	protected Logger SMS_LOGGER = LoggerFactory.getLogger("smslib");

	/** 短信设置 */
	protected SmsSettingVo setting;

	protected static String CHARSET_UNICODE = "unicode";

	public AbstractSmsSender() {
		SmsSettingService smsSettingService = SpringContextHolder.getBean("smsSettingService");
		setting = smsSettingService.loadSmsSettingVo();
	}

	protected String getContent(SmsVo smsVo) {
		// String template =
		// "{numbersign}{hash}{comma}{comma}{comma}{$orgcode}{numbersign}{$termtype}{guid}{\"00000171\"}{$mobile:R21}{$note:R140}{random:L10}";
		String outcome = MsgTemplate.phase(SmsVo.class, smsVo, setting.getContentTemplate());
		return outcome;
		//		try {
		//			byte[] bytes = outcome.getBytes();
		//			String content = new String(bytes, setting.getEncoding());
		//			SMS_LOGGER.info("SMS content:" + content);
		//			return content;
		//		} catch (UnsupportedEncodingException ex) {
		//			logger.error("SMS content charset transfer error!", ex);
		//		}
		//
		//		return smsVo.getContent();
	}
}
