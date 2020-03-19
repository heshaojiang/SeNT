/**
 * 文件名：OperLogDao.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.log.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.log.entity.OperLog;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.entity.User;

/**
 * operation log dao<br>
 * 操作日志管理Dao
 * 
 * @author yrliang
 */
@Repository
@SuppressWarnings( { "unchecked" })
public class OperLogDao extends BaseDao<OperLog> {
	private static final String QUERY_BY_USER_ID_FUZZILY = " from OperLog where userId like '%'||?||'%' ";
	private static final String HQL_DELETE_OPERLOG = "delete from OperLog where logTime<=? ";

	@Autowired
	UserDao userDao;

	@Autowired
	OrgInfoDao orgInfoDao;

	/**
	 * query the login logs by user id and page object<br>
	 * 根据登录用户代码，分页查询登录日志
	 * 
	 * @param page
	 * @param userId
	 * @return Page<OperLog>
	 */
	public Page<OperLog> getByUserIdFuzzily(Page<OperLog> page, String userId) {
		return super.findPage(page, QUERY_BY_USER_ID_FUZZILY, userId);
	}

	/**
	 * 
	 * query the login logs by page object, filter and language <br>
	 * 根据过滤条件和语言分页查询登录日志
	 * 
	 * @param page
	 * @param userId
	 * @return Page<OperLog>
	 */
	public Page getByParams(Page page, Map<String, Object> cond, String language) {
		StringBuffer hql = new StringBuffer(
				"select new map(o as o,s as m) from OperLog o, SysI18n s where o.menuName = s.referenceid and s.language = ? and ");

		List<Object> params = new ArrayList<Object>();
		params.add(language);
		for (String key : cond.keySet()) {
			Object value = cond.get(key);
			if (value == null) {
				continue;
			}
			if (key.equals("currentUserId")) {
				User currentUser = userDao.get(value.toString());
				OrgInfo orgInfo = orgInfoDao.get(currentUser.getOrgId());
				hql.append(" (select o2.id from OrgInfo o2 "
						+ "where o2.id = ("
						+ "  select u.orgId from User u where u.userCode = o.userId"
						+ ")) like ? and ");
				params.add(orgInfo.getId() + "%");
			}
			if (key.equals("userId")) {
				hql.append(" o.userId like ? and ");
				params.add("%" + (String) value + "%");
			}
			if (key.equals("logTimeStart")) {
				hql.append(" o.logTime >= ? and ");
				params.add(value);
			}
			if (key.equals("logTimeEnd")) {
				hql.append(" o.logTime <= ? and ");
				params.add(value);
			}
		}
		hql.delete(hql.length() - 4, hql.length());
		hql.append(" order by o.logTime desc");
		return super.findPage(page, hql.toString(), params.toArray());
	}

	/**
	 * delete operation log before some date<br>
	 * 删除某个日期之前的操作日志
	 * 
	 * @param date
	 */
	public void deleteBeforeDate(Date date) {
		this.executeUpdate(HQL_DELETE_OPERLOG, new Object[] { date });
	}
}
