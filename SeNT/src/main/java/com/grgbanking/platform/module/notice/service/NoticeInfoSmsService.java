/**
 * 文件名：ExPropertyService.java
 * 创建日期： 2012-4-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.notice.dao.NoticeInfoSmsDao;
import com.grgbanking.platform.module.notice.entity.NoticeInfoSms;

/**
 * @author yrliang
 * 
 */
@Service
@Transactional
public class NoticeInfoSmsService extends BaseService {

	@Autowired
	NoticeInfoSmsDao smsDao;

	public List<NoticeInfoSms> getSmsOfWaitStatus() {
		return smsDao.findSmsByWait();
	}

	public void updateSmsStatus(String smsId, String status) {
		NoticeInfoSms sms = smsDao.get(smsId);
		sms.setStatus(status);
	}

	public Long countSmsByNotice(String noticeId) {
		return smsDao.countSmsByNotice(noticeId);
	}

	public Long countWaitSmsByNotice(String noticeId) {
		return smsDao.countWaitSmsByNotice(noticeId);
	}

	public Long countSuccessSmsByNotice(String noticeId) {
		return smsDao.countSuccessSmsByNotice(noticeId);
	}

	public Long countFailSmsByNotice(String noticeId) {
		return smsDao.countFailSmsByNotice(noticeId);
	}
}
