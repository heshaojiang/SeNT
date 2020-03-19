/**
 * 文件名：UserRoleDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */

package com.grgbanking.platform.module.security.dao;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.security.entity.User;
import com.grgbanking.platform.module.security.entity.UserRole;

/**
 * user and role relationship Dao<br>
 * 用户和角色关系管理Dao
 * 
 * @author vinson
 * 
 */
@Repository
public class UserRoleDao extends BaseDao<UserRole> {
	private static final String DELETE_BY_USER_ID = "delete from UserRole ur where ur.userId = ? ";
	private static final String DELETE_BY_ROLE_ID = "delete from UserRole ur where ur.roleId = ? ";
	private static final String QUERY_ASSIGNED_USERS = "select u.id, u.userName "
			+ "from User u, UserRole ur where u.id = ur.userId and u.status = 'Y' and ur.roleId = ? ";
	private static final String QUERY_UNASSIGNED_USERS = "select u.id, u.userName "
			+ "from User u where u.status = 'Y' and u.id not in ( select ur.userId from UserRole ur where ur.roleId = ?) ";

	private static final String QUERY_ASSIGNED_ROLES = "select r.id, r.roleName "
			+ "from Role r, UserRole ur where r.id = ur.roleId and r.status = 'Y' and ur.userId = ? ";
	private static final String QUERY_UNASSIGNED_ROLES = "select r.id, r.roleName "
			+ "from Role r where r.status = 'Y' and r.id not in ( select ur.roleId from UserRole ur where ur.userId = ?) ";

	@Autowired
	OrgInfoDao orgInfoDao;
	
	@Autowired
	UserDao userDao;
	
	
	/**
	 * Get the User Role Detail by Primary Key
	 * 
	 * @param id
	 * @return
	 */
	public UserRole getByKey(String id) {
		return super.get(id);
	}

	/**
	 * Get the assigned Role List by User Id
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getAssignedRoles(String userId) {
		User user = userDao.getByKey(userId);
		String f1 = user.getF1();
		String addSql = "";
		if (f1 != null) {
			if (f1.equals("1")) {
				addSql = " and r.roleLevel in ('1','2','3','4','5')";
			} else if (f1.equals("2")) {
				addSql = " and r.roleLevel in ('2','3','4','5')";
			} else if (f1.equals("3")) {
				addSql = " and r.roleLevel in ('3','4','5')";
			} else if (f1.equals("4")) {
				addSql = " and r.roleLevel in ('4','5')";
			} else if (f1.equals("5")) {
				addSql = " and r.roleLevel in ('5')";
			} else {
				addSql = " and r.roleLevel in ('6')";
			}
		} else {
			addSql = " and r.roleLevel in ('6')";
		}
		
		return super.find(QUERY_ASSIGNED_ROLES + addSql, userId);
	}

	/**
	 * Get the unassigned Role List by User Id
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getUnassignedRoles(String userId) {
		User user = userDao.getByKey(userId);
		String f1 = user.getF1();
		String addSql = "";
		if (f1 != null) {
			if (f1.equals("1")) {
				addSql = " and r.roleLevel in ('1','2','3','4','5')";
			} else if (f1.equals("2")) {
				addSql = " and r.roleLevel in ('2','3','4','5')";
			} else if (f1.equals("3")) {
				addSql = " and r.roleLevel in ('3','4','5')";
			} else if (f1.equals("4")) {
				addSql = " and r.roleLevel in ('4','5')";
			} else if (f1.equals("5")) {
				addSql = " and r.roleLevel in ('5')";
			} else {
				addSql = " and r.roleLevel in ('6')";
			}
		} else {
			addSql = " and r.roleLevel in ('6')";
		}
		
		return super.find(QUERY_UNASSIGNED_ROLES + addSql, userId);
	}

	/**
	 * Get the assigned Role List by User Id
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getAssignedRoles(String userId, String orgId) {
		String sql = "select r.id, r.roleName "
				+ "from Role r, UserRole ur where r.id = ur.roleId and r.status = 'Y' and ur.userId = ? "
				+ " and (select o.pathCode from OrgInfo o where o.id = r.orgId ) like ? ";
			
		
		
		return super.find(sql, userId, orgInfoDao.getPathCodeById(orgId) + "%");
	}
	
	/**
	 * Get the unassigned Role List by User Id
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getUnassignedRoles(String userId, String orgId) {
		String sql =  "select r.id, r.roleName "
				+ "from Role r where r.status = 'Y' and r.id not in ( select ur.roleId from UserRole ur where ur.userId = ?) "
				+ " and (select o.pathCode from OrgInfo o where o.id = r.orgId ) like ? ";
		return super.find(sql, userId, orgInfoDao.getPathCodeById(orgId) + "%");
	}
	
	
	
	/**
	 * Get the assigned User List by Role Id
	 * 
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getAssignedUsers(String roleId) {
		return super.find(QUERY_ASSIGNED_USERS, roleId);
	}

	/**
	 * Get the unassigned User List by Role Id
	 * 
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getUnassignedUsers(String roleId) {
		return super.find(QUERY_UNASSIGNED_USERS, roleId);
	}

	/**
	 * Delete the User Role relationship by user id
	 * 
	 * @param userId
	 */
	public void deleteByUserId(String userId) {
		Query query = super.createQuery(DELETE_BY_USER_ID, userId);
		query.executeUpdate();
	}

	/**
	 * Delete the User Role relationship by role id
	 * 
	 * @param roleId
	 */
	public void deleteByRoleId(String roleId) {
		Query query = super.createQuery(DELETE_BY_ROLE_ID, roleId);
		query.executeUpdate();
	}
}
