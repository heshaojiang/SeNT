/**
 * 文件名：NoticeSitemsgDao.java
 * 创建日期： 2012-4-28
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.notice.entity.NoticeSitemsg;

/**
 * @author yrliang
 * 
 */
@Repository
public class NoticeSitemsgDao extends BaseDao<NoticeSitemsg> {

	/**
	 * 根据接收者Id查询已发布的消息
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */
	public Page<NoticeSitemsg> findReceivedMsg(Page<NoticeSitemsg> page, String userId, String content, Date startTime,
			Date endTime) {
		StringBuffer queryStrReceivedMsg = new StringBuffer(
				"select new NoticeSitemsg(msg.id, msg.content, msg.sender, msg.publishTime, u.userName, r.readTime) "
				+ "from NoticeSitemsg msg, NoticeSitemsgReader r, User u "
						+ "where msg.status='1' and msg.id=r.sitemsgId and msg.sender=u.id and r.readerId=? and ");

		List<Object> params = new ArrayList<Object>();
		params.add(userId);

		if (content != null && !content.equals("")) {
			queryStrReceivedMsg.append(" msg.content like ? and ");
			params.add("%" + content + "%");

		}
		if (startTime != null) {
			queryStrReceivedMsg.append(" msg.publishTime>=? and ");
			params.add(startTime);
		}
		if (endTime != null) {
			queryStrReceivedMsg.append(" msg.publishTime<=? and ");
			params.add(endTime);
		}
		queryStrReceivedMsg.delete(queryStrReceivedMsg.length() - 4,
				queryStrReceivedMsg.length());
		queryStrReceivedMsg.append(" order by msg.publishTime desc ");
		return findPage(page, queryStrReceivedMsg.toString(), params.toArray());
	}

	/**
	 * 根据接收者Id查询已发布的消息
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */
	public Page<NoticeSitemsg> findSentMsg(Page<NoticeSitemsg> page, String userId, String content, Date startTime,
			Date endTime) {
		StringBuffer queryStrSentMsg = new StringBuffer(
				"from NoticeSitemsg where status='1' and deleteTag!='Y' and sender=? and ");

		List<Object> params = new ArrayList<Object>();
		params.add(userId);

		if (content != null && !content.equals("")) {
			queryStrSentMsg.append(" content like ? and ");
			params.add("%" + content + "%");

		}
		if (startTime != null) {
			queryStrSentMsg.append(" publishTime>=? and ");
			params.add(startTime);
		}
		if (endTime != null) {
			queryStrSentMsg.append(" publishTime<=? and ");
			params.add(endTime);
		}
		queryStrSentMsg.delete(queryStrSentMsg.length() - 4,
				queryStrSentMsg.length());
		queryStrSentMsg.append(" order by publishTime desc ");
		return findPage(page, queryStrSentMsg.toString(), params.toArray());
	}
}
