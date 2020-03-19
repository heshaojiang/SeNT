/**
 * 文件名：NoticeInfoDao.java
 * 创建日期： 2012-3-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.notice.entity.NoticeInfo;
import com.grgbanking.platform.module.notice.entity.NoticeSitemsg;

/**
 * @author yrliang <br>
 *         扩展属性配置Dao
 */
@Repository("noticeInfoDao1")
public class NoticeInfoDao extends BaseDao<NoticeInfo> {

	/**
	 * 排名数
	 * 
	 */
	private final int LIMIT = 4;
	/** 查询待发送的邮件通知 */
	public List<NoticeInfo> findEmailNoticeByWait() {
		List<NoticeInfo> list = find("from NoticeInfo where noticeMethod='1' and sendTime<=? and status='0'",
				new Date());

		return list;
	}

	public List<NoticeSitemsg> getNoticeTop3List(String userId) {
		StringBuffer queryStrReceivedMsg = new StringBuffer(
				"select new NoticeSitemsg(msg.id, msg.content, msg.sender, msg.publishTime, u.userName, r.readTime) "
						+ "from NoticeSitemsg msg, NoticeSitemsgReader r, User u "
						+ "where msg.status='1' and msg.id=r.sitemsgId and msg.sender=u.id and r.readerId=:userId  order by msg.publishTime desc  ");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		List<NoticeSitemsg> list = find(queryStrReceivedMsg.toString(), map);
		int limit = LIMIT;
		if (list.size() < limit) {
			limit = list.size();
		}
		return list.subList(0, limit);
	}

	public Object getNoticeMsgCount(String userId) {
		StringBuffer sql = new StringBuffer(
				"select new NoticeSitemsg(msg.id, msg.content, msg.sender, msg.publishTime, u.userName, r.readTime) "
						+ "from NoticeSitemsg msg, NoticeSitemsgReader r, User u "
						+ "where msg.status='1' and msg.id=r.sitemsgId and msg.sender=u.id and r.readerId=:userId "
						+ " order by msg.publishTime desc ");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		List<NoticeSitemsg> list = find(sql.toString(), map);
		Object result = new Integer(list.size());
		return result;
	}
}
