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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.notice.NoticeConstants;
import com.grgbanking.platform.module.notice.dao.NoticeInfoDao;
import com.grgbanking.platform.module.notice.dao.NoticeInfoSmsDao;
import com.grgbanking.platform.module.notice.dao.NoticeSitemsgDao;
import com.grgbanking.platform.module.notice.dao.NoticeSitemsgReaderDao;
import com.grgbanking.platform.module.notice.entity.NoticeInfo;
import com.grgbanking.platform.module.notice.entity.NoticeInfoSms;
import com.grgbanking.platform.module.notice.entity.NoticeSitemsg;
import com.grgbanking.platform.module.notice.entity.NoticeSitemsgReader;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.entity.User;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * @author yrliang
 * 
 */
@Service("noticeInfoService1")
@Transactional
public class NoticeInfoService extends BaseService {
	@Autowired
	OrgInfoDao orgInfoDao;

	@Autowired
	@Qualifier("noticeInfoDao1")
	NoticeInfoDao noticeInfoDao;

	@Autowired
	NoticeInfoSmsDao smsDao;

	@Autowired
	NoticeSitemsgDao siteMsgDao;

	@Autowired
	NoticeSitemsgReaderDao readerDao;

	@Autowired
	UserDao userDao;

	public Page<NoticeInfo> getPageData(final Page<NoticeInfo> page, String noticeType, String noticeMethod,
			String status, String key, Date startTime, Date endTime) {

		Map<String, Object> propertyFilterMap = new HashMap<String, Object>();
		propertyFilterMap.put("EQS_noticeType", noticeType); // noticeType属性是字符类型，按其值过滤
		propertyFilterMap.put("EQS_noticeMethod", noticeMethod);
		propertyFilterMap.put("EQS_status", status);
		propertyFilterMap.put("GED_sendTime", startTime);
		propertyFilterMap.put("LED_sendTime", endTime);
		propertyFilterMap.put("LIKES_title_OR_content_OR_note_OR_sender_OR_recipient", key);
		page.setOrder(Page.DESC);
		page.setOrderBy("sendTime");
		Page<NoticeInfo> returnPage = noticeInfoDao.findPageNew(page, propertyFilterMap);

		// 所有机构
		List<OrgInfo> orgInfoListTemp = orgInfoDao.getAll();
		Map<String, String> map = new HashMap<String, String>();
		for (OrgInfo orgInfo : orgInfoListTemp) {
			map.put(orgInfo.getId(), orgInfo.getOrgName());
		}

		for (NoticeInfo info : returnPage.getResult()) {
			String orgName = map.get(info.getNote());
			if (orgName != null) {
				info.setNote(orgName);
			}
		}
		return returnPage;

	}

	public NoticeInfo getNoticeInfo(String noticeId) {
		return noticeInfoDao.get(noticeId);
	}

	public List<NoticeInfo> getEmailNoticeByWait() {
		return noticeInfoDao.findEmailNoticeByWait();
	}

	public void updateNoticeStatus(String noticeId, String status) {
		NoticeInfo notice = noticeInfoDao.get(noticeId);
		notice.setStatus(status);
	}

	/**
	 * 发送给系统内的人，接受者为选定人员
	 * 
	 * @param title标题
	 * @param content内容
	 * @param sender发送者
	 * @param sendDate发送日期
	 * @param orgId用户机构的Id
	 * @param noticeMethod通知方式
	 * @param noticeType通知类型
	 * @param note备注
	 * @param dispatchId工单id
	 */
	public void sendNoticeToOrg(String title, String content, String sender, Date sendTime, String orgId,
			String noticeMethod, String noticeType, String note, String dispatchId) {

		List<User> list = userDao.findBy("orgId", orgId);
		String userIds = "";
		for (Object obj : list) {
			User user = (User) obj;
			userIds += user.getId();
		}
		sendNotice(title, content, sender, sendTime, userIds, noticeMethod, noticeType, note, dispatchId);
	}

	/**
	 * 发送给系统内的人，接受者为选定人员
	 * 
	 * @param title标题
	 * @param content内容
	 * @param sender发送者
	 * @param sendDate发送日期
	 * @param userIds用户Id拼接字符串
	 * @param noticeMethod通知方式
	 * @param noticeType通知类型
	 * @param note备注
	 * @param dispatchId工单id
	 */
	public void sendNotice(String title, String content, String sender, Date sendTime, String userIds,
			String noticeMethods, String noticeType, String note, String dispatchId) {
		sendNotice(title, content, sender, sendTime, userIds.split(","), noticeMethods.split(","), noticeType, note,
				dispatchId);
	}

	/**
	 * 发送给系统内的人，接受者为选定人员
	 * 
	 * @param notice
	 */
	@SuppressWarnings("unchecked")
	public void sendNotice(String title, String content, String sender, Date sendTime, String[] userIds,
			String[] noticeMethods, String noticeType, String note, String dispatchId) {
		List list = userDao.findByIds(Arrays.asList(userIds)); // 取得用户信息

		for (String noticeMethod : noticeMethods) { // 遍历每种发送方式
			String recipient = "";
			for (Object obj : list) {
				User user = (User) obj;
				recipient = recipient + "," + user.getUserName(); // 多个接受者用逗号分开
			}
			if (recipient.startsWith(",")) {
				recipient = recipient.substring(1);
			}

			NoticeInfo notice = new NoticeInfo();
			notice.setTitle(title);
			notice.setContent(content);
			notice.setSender(sender);
			notice.setSendTime(sendTime);
			notice.setRecipient(recipient);
			notice.setNoticeMethod(noticeMethod);
			notice.setNoticeType(noticeType);
			notice.setNote(note);
			notice.setDispatchId(dispatchId);

			notice.setCreateTime(new Date());
			notice.setStatus(NoticeConstants.STATUS_WAIT);

			if (noticeMethod.equals(NoticeConstants.NOTICE_METHOD_EMAIL)) { // 保存Email发件地址
				String email = "";
				for (Object obj : list) {
					User user = (User) obj;
					email = email + "," + user.getEmail(); // 多个接受者用逗号分开
				}
				if (email.startsWith(",")) {
					email = email.substring(1);
				}

				notice.setEmail(email);
			}
			noticeInfoDao.saveNew(notice); // 保存通知记录，状态待发送

			if (noticeMethod.equals(NoticeConstants.NOTICE_METHOD_SMS)) { // 生成短信记录
				for (Object obj : list) {
					User user = (User) obj;

					NoticeInfoSms sms = new NoticeInfoSms();
					sms.setNoticeId(notice.getId());
					sms.setMobile(user.getMobile());
					sms.setStatus(NoticeConstants.STATUS_WAIT);
					sms.setSendTime(sendTime);

					smsDao.save(sms);
				}
			}

			if (noticeMethod.equals(NoticeConstants.NOTICE_METHOD_SITEMSG)) { // 生成站内信记录
				NoticeSitemsg siteMsg = new NoticeSitemsg();
				siteMsg.setNoticeId(notice.getId());
				siteMsg.setContent(content);
				siteMsg.setCreateTime(new Date());
				siteMsg.setPublishTime(sendTime);
				siteMsg.setSender(sender);
				siteMsg.setStatus(NoticeConstants.SITEMSG_UNPUBLISHED);

				siteMsgDao.save(siteMsg);
				for (Object obj : list) {
					User user = (User) obj;
					NoticeSitemsgReader reader = new NoticeSitemsgReader();
					reader.setReaderId(user.getId());
					reader.setSitemsgId(siteMsg.getId());

					readerDao.save(reader);
				}
			}
		}
	}

	/**
	 * 发送给系统外的人，直接发送到手机号码
	 * 
	 * @param notice
	 */
	public void sendSms(String title, String content, String sender, Date sendTime, String mobiles, String note) {
		NoticeInfo notice = new NoticeInfo();
		notice.setCreateTime(new Date());
		notice.setTitle(title);
		notice.setContent(content);
		notice.setSender(sender);
		notice.setSendTime(sendTime);
		notice.setRecipient(mobiles);
		notice.setNoticeType("0");

		notice.setNoticeMethod(NoticeConstants.NOTICE_METHOD_SMS);
		notice.setStatus(NoticeConstants.STATUS_WAIT);

		String noticeId = String.valueOf(noticeInfoDao.saveNew(notice));

		String[] arrMobile = mobiles.split(",");
		for (String mobile : arrMobile) {
			NoticeInfoSms sms = new NoticeInfoSms();
			sms.setMobile(mobile.trim());
			sms.setNoticeId(noticeId);
			sms.setSendTime(sendTime);
			sms.setStatus(NoticeConstants.STATUS_WAIT);
			smsDao.saveNew(sms);
		}

	}
}
