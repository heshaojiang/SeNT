/**
 * 文件名：NoticeTask.java
 * 创建日期： 2012-4-23
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.grgbanking.platform.core.utils.Mail;
import com.grgbanking.platform.module.notice.NoticeConstants;
import com.grgbanking.platform.module.notice.entity.NoticeInfo;
import com.grgbanking.platform.module.notice.service.EmailSettingService;
import com.grgbanking.platform.module.notice.service.NoticeInfoService;

/**
 * @author yrliang
 * 
 */
public class EmailSendTask {
	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	@Qualifier("noticeInfoService1")
	NoticeInfoService noticeInfoService;

	@Autowired
	EmailSettingService emailSettingService;

	private static boolean RUNNING = false;

	/**
	 * 执行发送邮件任务
	 */
	public void execute() {
		if(RUNNING)
			return;

		try {
			RUNNING = true;
			logger.info("now run EmailSendTask...");

			List<NoticeInfo> list = noticeInfoService.getEmailNoticeByWait();

			for(NoticeInfo notice : list) {
				// 创建邮件对象
				Mail mail = new Mail();
				emailSettingService.setForMail(mail);

				if(notice.getEmail() == null) {
					continue;
				}
				String[] arrs = notice.getEmail().split(",");
				for(String oneMail : arrs) {
					mail.addTo(oneMail); // 收件人邮箱
				}
				// mail.addCc("yrliang@grgbanking.com");
				// mail.addBcc("zhli1@grgbanking.com");
				mail.setSubject(notice.getTitle()); // 邮件主题
				mail.setContent(notice.getContent()); // 邮件正文

				StringBuilder infoBuilder = new StringBuilder();
				boolean success = mail.send(infoBuilder); // 发送

				if(success) {
					noticeInfoService.updateNoticeStatus(notice.getId(), NoticeConstants.STATUS_SUCCESS);
				} else {
					logger.error(infoBuilder.toString());
					noticeInfoService.updateNoticeStatus(notice.getId(), NoticeConstants.STATUS_FAIL);
				}

			}
		} catch(Exception e) {

		} finally {
			RUNNING = false;
		}
	}
}
