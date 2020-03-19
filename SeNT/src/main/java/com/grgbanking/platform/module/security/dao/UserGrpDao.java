/**
 * 文件名：UserGrpDao.java
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
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.security.entity.UserGrp;

/**
 * user and user group relationship Dao<br>
 * 用户和组关系管理Dao
 * 
 * @author vinson
 * 
 */
@Repository
public class UserGrpDao extends BaseDao<UserGrp> {
	private static final String DELETE_BY_USER_ID = "delete from UserGrp ug where ug.userId = ? ";
	private static final String DELETE_BY_GRP_ID = "delete from UserGrp ug where ug.grpId = ? ";
	private static final String QUERY_ASSIGNED_USERS = "select u.id, u.userName "
			+ "from User u, UserGrp ug where u.id = ug.userId and u.status = 'Y' and ug.grpId = ? ";
	private static final String QUERY_UNASSIGNED_USERS = "select u.id, u.userName "
			+ "from User u where u.status = 'Y' and u.id not in ( select ug.userId from UserGrp ug where ug.grpId = ? ) ";

	private static final String QUERY_ASSIGNED_GROUPS = "select g.id, g.grpName "
			+ "from Group g, UserGrp ug where g.id = ug.grpId and g.status = 'Y' and ug.userId = ? ";
	private static final String QUERY_UNASSIGNED_GROUPS = "select g.id, g.grpName "
			+ "from Group g where g.status = 'Y' and g.id not in ( select ug.grpId from UserGrp ug where ug.userId = ? ) ";

	/**
	 * Get the User Group Detail by Primary Key
	 * 
	 * @param id
	 * @return
	 */
	public UserGrp getByKey(String id) {
		return super.get(id);
	}

	/**
	 * Get the assigned Group List by User Id
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getAssignedGroups(String userId) {
		return super.find(QUERY_ASSIGNED_GROUPS, userId);
	}

	/**
	 * Get the unassigned Group List by User Id
	 * 
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getUnassignedGroups(String userId) {
		return super.find(QUERY_UNASSIGNED_GROUPS, userId);
	}

	/**
	 * Get the assigned User List by Group Id
	 * 
	 * @param grpId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getAssignedUsers(String grpId) {
		return super.find(QUERY_ASSIGNED_USERS, grpId);
	}

	/**
	 * Get the unassigned User List by Group Id
	 * 
	 * @param grpId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getUnassignedUsers(String grpId) {
		return super.find(QUERY_UNASSIGNED_USERS, grpId);
	}

	/**
	 * Delete the User Group relationship by user id
	 * 
	 * @param userId
	 */
	public void deleteByUserId(String userId) {
		Query query = super.createQuery(DELETE_BY_USER_ID, userId);
		query.executeUpdate();
	}

	/**
	 * Delete the User Group relationship by group id
	 * 
	 * @param grpId
	 *            - group id
	 */
	public void deleteByGrpId(String grpId) {
		Query query = super.createQuery(DELETE_BY_GRP_ID, grpId);
		query.executeUpdate();
	}

}
