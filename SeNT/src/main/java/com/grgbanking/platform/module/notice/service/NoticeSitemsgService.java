/**
 * 文件名：NoticeSitemsgService.java
 * 创建日期： 2012-4-28
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.AppCoreConstants;
import com.grgbanking.platform.module.notice.NoticeConstants;
import com.grgbanking.platform.module.notice.dao.NoticeSitemsgDao;
import com.grgbanking.platform.module.notice.dao.NoticeSitemsgReaderDao;
import com.grgbanking.platform.module.notice.entity.NoticeSitemsg;
import com.grgbanking.platform.module.notice.entity.NoticeSitemsgReader;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.entity.User;

/**
 * @author yrliang
 * 
 */
@Service
@Transactional
public class NoticeSitemsgService extends BaseService {
	@Autowired
	NoticeSitemsgDao dao;

	@Autowired
	NoticeSitemsgReaderDao readerDao;

	@Autowired
	private UserDao userDao;

	/**
	 * 查询用户接收到的消息
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */
	public Page<NoticeSitemsg> getReceivedMsgByPage(final Page<NoticeSitemsg> page, String userId, String content,
			Date startTime, Date endTime) {
		// page.setOrder(Page.ASC);
		page.setOrderBy("publishTime");
		Page<NoticeSitemsg> returnPage = dao.findReceivedMsg(page, userId, content, startTime, endTime);
		return returnPage;
	}

	/**
	 * 查询用户接收到的消息
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */
	public Page<NoticeSitemsg> getSentMsgByPage(final Page<NoticeSitemsg> page, String userId, String content,
			Date startTime, Date endTime) {
		// page.setOrder(Page.ASC);
		page.setOrderBy("publishTime");
		Page<NoticeSitemsg> returnPage = dao.findSentMsg(page, userId, content, startTime, endTime);

		/* 组装接收人 */
		for (NoticeSitemsg msg : returnPage.getResult()) {
			List<NoticeSitemsgReader> list = readerDao.findReaderBySitemsg(msg.getId());
			String recipient = "";
			for (NoticeSitemsgReader reader : list) {
				recipient = recipient + "," + reader.getReaderName();
			}

			if (recipient.length() > 1) {
				msg.setRecipient(recipient.substring(1));
			}
		}
		return returnPage;
	}

	public void delReceivedMsgs(String userId, String[] siteMsgIds) {
		for (String siteMsgId : siteMsgIds) {
			/* 删除阅读人 */
			NoticeSitemsgReader reader = readerDao.findByUserAndSitemsg(userId, siteMsgId);
			readerDao.delete(reader);

			/* 如果所有阅读人都删除掉了，发件人也删除掉了， 则将通知的实际记录一起删掉 */
			long count = readerDao.countReaderBySitemsg(siteMsgId);
			NoticeSitemsg msg = dao.get(siteMsgId);
			if (count == 0 && msg.getDeleteTag().equals(AppCoreConstants.YES_CHAR)) {
				dao.delete(siteMsgId);
			}
		}
	}

	/* 删除发件记录 */
	public void delSentMsgs(String[] siteMsgIds) {
		for (String siteMsgId : siteMsgIds) {
			NoticeSitemsg msg = dao.get(siteMsgId);

			long count = readerDao.countReaderBySitemsg(siteMsgId);
			if (count == 0) {
				dao.delete(msg); // 不存在阅读人时删除发件记录
			} else {
				msg.setDeleteTag(AppCoreConstants.YES_CHAR); // 存在阅读人时标记为已删除
				dao.save(msg);
			}
		}
	}

	/**
	 * 加载用户信息
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */
	public List<User> loadRecipient() {
		return userDao.getAll();
	}

	/**
	 * 保存所写的信件
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */
	public void saveLetter(NoticeSitemsg entity) {
		entity.setCreateTime(new Date());
		entity.setPublishTime(new Date());
		entity.setStatus(NoticeConstants.SITEMSG_PUBLISHED);
		entity.setDeleteTag(AppCoreConstants.NO_CHAR);
		dao.save(entity);

		for (String userId : entity.getUserIds()) {
			NoticeSitemsgReader reader = new NoticeSitemsgReader();
			reader.setReaderId(userId);
			reader.setSitemsgId(entity.getId());
			readerDao.save(reader);
		}

	}

	public void markReaded(String userId, String siteMsgId) {
		NoticeSitemsgReader reader = readerDao.findByUserAndSitemsg(userId, siteMsgId);
		reader.setReadTime(new Date());
		readerDao.save(reader);
	}

	public List<NoticeSitemsgReader> loadDetail(String siteMsgId) {
		List<NoticeSitemsgReader> list = readerDao.findReaderBySitemsg(siteMsgId);
		return list;
	}
}
