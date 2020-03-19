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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.grgbanking.platform.module.notice.NoticeConstants;
import com.grgbanking.platform.module.notice.entity.NoticeInfo;
import com.grgbanking.platform.module.notice.entity.NoticeInfoSms;
import com.grgbanking.platform.module.notice.service.NoticeInfoService;
import com.grgbanking.platform.module.notice.service.NoticeInfoSmsService;
import com.grgbanking.platform.module.notice.service.SmsSettingService;
import com.grgbanking.platform.module.notice.service.smssend.AbstractSmsSender;
import com.grgbanking.platform.module.notice.service.smssend.ISmsSender;
import com.grgbanking.platform.module.notice.utils.SmsSenderFactory;
import com.grgbanking.platform.module.notice.vo.SmsVo;

public class SmsSendTask {
	private static Log logger = LogFactory.getLog(SmsSendTask.class);
	
	private static ConcurrentLinkedQueue<NoticeInfoSms> smsLinkedQueue = new ConcurrentLinkedQueue<NoticeInfoSms>();

	private static boolean RUNNING = false;

	public SmsSendTask() {
	}

	@Autowired
	@Qualifier("noticeInfoService1")
	NoticeInfoService noticeInfoService;

	@Autowired
	NoticeInfoSmsService noticeInfoSmsService;

	@Autowired
	SmsSettingService smsSettingService;

	private String sendMethod;

	private ISmsSender smsSender;

	private AbstractSmsSender getSmsSender() {
		if (sendMethod == null) {
			sendMethod = smsSettingService.getSendMethodSetting();
		}
		return SmsSenderFactory.getInstance().getSmsSender(sendMethod);
	}

	/**
	 * 执行
	 */
	public void execute() {
		if(RUNNING)
			return;

		try {
			RUNNING = true;

			logger.info("now run SmsSendTask...");
			smsSender = getSmsSender();

			// 定义为none，则取不到，直接返回
			if(smsSender == null)
				return;

			Map<String, NoticeInfo> map = new HashMap<String, NoticeInfo>();
			Set<String> set = new HashSet<String>();
			List<NoticeInfoSms> list = noticeInfoSmsService.getSmsOfWaitStatus();
			for(NoticeInfoSms sms : list) {
				if(!smsLinkedQueue.contains(sms)) {
					smsLinkedQueue.add(sms);
				}
			}

			List<SmsVo> smsList = new ArrayList<SmsVo>();
			while(smsLinkedQueue.size() > 0) {
				NoticeInfoSms sms = smsLinkedQueue.poll();
				if(sms != null) {
					NoticeInfo notice = map.get(sms.getNoticeId());
					if(notice == null) {
						notice = noticeInfoService.getNoticeInfo(sms.getNoticeId());
						if(notice == null) { // 找不到，标记短信失败
							noticeInfoSmsService.updateSmsStatus(sms.getId(), NoticeConstants.STATUS_FAIL);
							continue;
						} else {
							map.put(notice.getId(), notice);
						}
					}
					SmsVo smsVo = new SmsVo();
					smsVo.setMobile(sms.getMobile());
					smsVo.setContent(notice.getContent());
					smsVo.setSendTime(sms.getSendTime());
					smsVo.setTitle(notice.getTitle());
					smsVo.setNote(notice.getNote());
					smsVo.setSmsID(sms.getId());
					smsVo.setNoticeID(notice.getId());
					
					if(sms.getSendTime() == null) {
						smsVo.setSendTime(new Date());
					}

					smsList.add(smsVo);
				}
			}
			if(smsList.size() > 0) {
				smsSender.sender(smsList);
			}

			if(smsList.size() > 0) {
				for(SmsVo vo : smsList) {
					if(vo.getSucc()) {
						noticeInfoSmsService.updateSmsStatus(vo.getSmsID(), NoticeConstants.STATUS_SUCCESS);
					} else {
						noticeInfoSmsService.updateSmsStatus(vo.getSmsID(), NoticeConstants.STATUS_FAIL);
					}
					set.add(vo.getNoticeID());
				}

				for(String noticeId : set) {
					long count = noticeInfoSmsService.countSmsByNotice(noticeId);
					long countSuccess = noticeInfoSmsService.countSuccessSmsByNotice(noticeId);
					if(countSuccess > 0 && countSuccess == count) {
						// 更新信息通知状态为发送成功
						noticeInfoService.updateNoticeStatus(noticeId, NoticeConstants.STATUS_SUCCESS);
						continue;
					}
					if(countSuccess > 0 && countSuccess < count) {
						// 更新信息通知状态为部分成功
						noticeInfoService.updateNoticeStatus(noticeId, NoticeConstants.STATUS_SUCCESS_SOME);
						continue;
					}
					long countFail = noticeInfoSmsService.countFailSmsByNotice(noticeId);
					if(countSuccess == 0 && countFail > 0) {
						// 更新信息通知状态为发送失败
						noticeInfoService.updateNoticeStatus(noticeId, NoticeConstants.STATUS_FAIL);
					}
	
				}
			}
		} catch(Exception e) {

		} finally {
			RUNNING = false;
		}
	}
}
