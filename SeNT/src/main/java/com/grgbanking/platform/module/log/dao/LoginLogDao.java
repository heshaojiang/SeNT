/**
 * 文件名：LoginLogDao.java
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
import com.grgbanking.platform.module.log.entity.LoginLog;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.security.dao.UserDao;
import com.grgbanking.platform.module.security.entity.User;

/**
 * login log dao<br>
 * 登录日志Dao
 * 
 * @author yt
 * 
 */
@Repository
public class LoginLogDao extends BaseDao<LoginLog>
{
	private static final String QUERY_BY_USER_ID_FUZZILY = " from LoginLog ll where ll.userId like '%'||?||'%' ";
	
//	private static final String QUERY_CURR_USER_LOGIN_TIME = "select max(ll.loginTime) from LoginLog ll "
//			+ "where ll.result = 'Success' and ll.userId = ? and ll.hostIp = ? ";
	
	private static final String QUERY_CURR_USER_LOGIN_LOG = " from LoginLog ll "
			+ "where ll.result = 'Success' and ll.userId = ? and ll.hostIp = ? and ll.loginTime = ?";
	
	private static final String HQL_DELETE_LOGINLOG = "delete from LoginLog where loginTime<=? ";

	@Autowired
	UserDao userDao;

	@Autowired
	OrgInfoDao orgInfoDao;

	/**
	 * Get the Login Log by page object and userId <br>
	 * 根据分页对象和用户id，进行分页查询
	 * 
	 * @param page
	 * @param userId
	 * @return Page<LoginLog>
	 */
	public Page<LoginLog> getByUserIdFuzzily(Page<LoginLog> page, String userId) {
		return super.findPage(page, QUERY_BY_USER_ID_FUZZILY, userId);
	}

	/**
	 * Get the current login user's login log<br>
	 * 根据用户代码，客户机ip，登录时间，查找登录日志
	 * 
	 * @param userId
	 * @param hostIp
	 * @param maxLoginTime
	 * @return LoginLog
	 */
	public LoginLog getCurrUserLoginLog(String userId, String hostIp, Date loginTime) {
		return super.findUnique(QUERY_CURR_USER_LOGIN_LOG, userId, hostIp, loginTime);
	}

//	/**
//	 * Get the current login user's login time <br>
//	 * 根据用户代码，客户机ip，查找用户最近登录时间
//	 * 
//	 * @param userId
//	 * @param hostIp
//	 * @return Date
//	 */
//	public Date getCurrUserLoginTime(String userId, String hostIp) {
//		return super.findUnique(QUERY_CURR_USER_LOGIN_TIME, userId, hostIp);
//	}

	/**
	 * 
	 * query login log by page object and filter <br>
	 * 根据分页对象和过滤条件查询登录日志
	 * 
	 * @param page
	 * @param cond
	 * @return Page<LoginLog>
	 * @Exception 异常对象 <br>
	 */
	public Page<LoginLog> searchLoginLog(final Page<LoginLog> page, Map<String, Object> cond)
	{
		StringBuffer hql = new StringBuffer(" from LoginLog ll ");

		List<Object> params = new ArrayList<Object>();
		hql.append(WHERE);
		for( String key : cond.keySet() )
		{
			Object value = cond.get(key);
			if( value == null )
			{
				continue;
			}
			if( key.equals("currentUserId") )
			{
				User currentUser = userDao.get(value.toString());
				OrgInfo orgInfo = orgInfoDao.get(currentUser.getOrgId());
				hql.append(" ((select u.orgId from User u where u.userCode = ll.userId) is null " + "or (select o.id from OrgInfo o where o.id = (" + "  select u.orgId from User u where u.userCode = ll.userId)) like ?) and ");
				params.add(orgInfo.getId() + "%");
			}
			if( key.equals("userId") )
			{
				hql.append(" ll.userId like ? and ");
				params.add("%" + (String) value + "%");
			}
			if( key.equals("logTimeStart") )
			{
				// SimpleDateFormat sdf = new SimpleDateFormat(
				// "yyyy-MM-dd HH:mm:ss");
				hql.append(" ll.loginTime >=? and ");
				params.add(value);
			}
			if( key.equals("logTimeEnd") )
			{
				hql.append(" ll.loginTime <=? and ");
				params.add(value);
			}
		}
		if( hql.toString().endsWith(WHERE) )
		{
			hql.delete(hql.length() - WHERE.length(), hql.length());
		}
		else
		{
			hql.delete(hql.length() - 4, hql.length());
		}
		hql.append(" order by ll.loginTime desc");
		return super.findPage(page, hql.toString(), params.toArray());
	}

	/**
	 * delete login log before some date<br>
	 * 删除某个日期之前的登录日志
	 * 
	 * @param date
	 */
	public void deleteBeforeDate(Date date) {
		this.executeUpdate(HQL_DELETE_LOGINLOG, new Object[] { date });
	}
}
