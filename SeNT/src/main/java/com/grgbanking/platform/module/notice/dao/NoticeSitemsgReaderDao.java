/**
 * 文件名：NoticeSitemsgReaderDao.java
 * 创建日期： 2012-4-28
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.notice.entity.NoticeSitemsgReader;

/**
 * @author yrliang
 * 
 */
@Repository
public class NoticeSitemsgReaderDao extends BaseDao<NoticeSitemsgReader> {
	String QUERY_BY_USERID_AND_SITEMSGID = "from NoticeSitemsgReader where readerId=? and sitemsgId=?";

	public NoticeSitemsgReader findByUserAndSitemsg(String userId, String siteMsgId) {
		NoticeSitemsgReader reader = findUnique(QUERY_BY_USERID_AND_SITEMSGID, new Object[] { userId, siteMsgId });

		return reader;
	}

	public long countReaderBySitemsg(String siteMsgId) {
		Long count = findUnique("select count(r) from NoticeSitemsgReader r where r.sitemsgId=?", siteMsgId);

		return count;
	}

	public List<NoticeSitemsgReader> findReaderBySitemsg(String siteMsgId) {
		return find("select new NoticeSitemsgReader(r.id, r.sitemsgId, r.readerId, r.readTime, u.userName) "
				+ "from NoticeSitemsgReader r, User u where r.readerId=u.id and r.sitemsgId=?", siteMsgId);
	}

}
