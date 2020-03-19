/**
 * 文件名：BaseDao.java
 * 创建日期： 2012-4-23
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.notice.NoticeConstants;
import com.grgbanking.platform.module.notice.entity.NoticeInfoSms;

/**
 * @author yrliang
 * 
 */
@Repository
public class NoticeInfoSmsDao extends BaseDao<NoticeInfoSms> {

	public List<NoticeInfoSms> findSmsByWait() {
		List<NoticeInfoSms> list = find("from NoticeInfoSms where (sendTime is null or sendTime<=?) and status='" + NoticeConstants.STATUS_WAIT + "'", new Date());

		return list;
	}

	public long countSmsByNotice(String noticeId) {
		StringBuffer countHql = new StringBuffer(
				"select count(*) from NoticeInfoSms where noticeId = ?");

		Long count = findUnique(countHql.toString(), noticeId);
		return count;
	}

	public long countWaitSmsByNotice(String noticeId) {
		StringBuffer countHql = new StringBuffer(
				"select count(*) from NoticeInfoSms where status='0' and noticeId = ?");

		Long count = findUnique(countHql.toString(), noticeId);
		return count;
	}

	public long countSuccessSmsByNotice(String noticeId) {
		StringBuffer countHql = new StringBuffer(
				"select count(*) from NoticeInfoSms where status='2' and noticeId = ?");

		Long count = findUnique(countHql.toString(), noticeId);
		return count;
	}

	public Long countFailSmsByNotice(String noticeId) {
		StringBuffer countHql = new StringBuffer(
				"select count(*) from NoticeInfoSms where status='3' and noticeId = ?");

		Long count = findUnique(countHql.toString(), noticeId);
		return count;
	}
}
