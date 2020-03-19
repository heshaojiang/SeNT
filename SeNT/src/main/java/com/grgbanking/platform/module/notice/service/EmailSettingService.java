/**
 * 文件名：NoticeTask.java
 * 创建日期： 2012-4-23
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.utils.Mail;
import com.grgbanking.platform.module.param.service.ParamService;

/**
 * @author yrliang
 * 
 */
@Service
@Transactional(readOnly = true)
public class EmailSettingService {

	@Autowired
	ParamService paramService;

	public Mail setForMail(Mail mail) {
		String serverName = paramService.getValueByPath(AppConstants.EMAIL_SETTING_SERVERNAME_PATH);
		String user = paramService.getValueByPath(AppConstants.EMAIL_SETTING_USER_PATH);
		String password = paramService.getValueByPath(AppConstants.EMAIL_SETTING_PASSWORD_PATH);
		String from = paramService.getValueByPath(AppConstants.EMAIL_SETTING_FROM_PATH);

		mail.setHost(serverName); // 邮件服务器地址
		mail.setUser(user); // 用户名
		mail.setPassword(password); // 密码
		mail.setFrom(from); // 发件人邮箱

		return mail;
	}
}
