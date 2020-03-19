/**
 * 文件名：GrpRoleDao.java
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
import com.grgbanking.platform.module.security.entity.GrpRole;

/**
 * user group and role relationship Dao<br>
 * 用户组角色关系管理Dao
 * 
 * @author vinson
 * 
 */
@Repository
public class GrpRoleDao extends BaseDao<GrpRole> {
	private static final String DELETE_BY_ROLE_ID = "delete from GrpRole gr where gr.roleId = ? ";
	private static final String DELETE_BY_GRP_ID = "delete from GrpRole gr where gr.grpId = ? ";
	private static final String QUERY_ASSIGNED_ROLES = "select r.id, r.roleName "
			+ "from Role r, GrpRole gr where r.id = gr.roleId and r.status = 'Y' and gr.grpId = ? ";
	private static final String QUERY_UNASSIGNED_ROLES = "select r.id, r.roleName "
			+ "from Role r where r.status = 'Y' and r.id not in ( select gr.roleId from GrpRole gr where gr.grpId = ? ) ";

	private static final String QUERY_ASSIGNED_GROUPS = "select g.id, g.grpName "
			+ "from Group g, GrpRole gr where g.id = gr.grpId and g.status = 'Y' and gr.roleId = ? ";
	private static final String QUERY_UNASSIGNED_GROUPS = "select g.id, g.grpName "
			+ "from Group g where g.status = 'Y' and g.id not in ( select gr.grpId from GrpRole gr where gr.roleId = ? ) ";

	/**
	 * Get the Group Role Detail by Primary Key
	 * 
	 * @param id
	 * @return
	 */
	public GrpRole getByKey(String id) {
		return super.get(id);
	}

	/**
	 * Get the assigned Role list by Group Id
	 * 
	 * @param grpId
	 * @return
	 */
	@SuppressWarnings(value = "unchecked")
	public Collection getAssignedRoles(String grpId) {
		return super.find(QUERY_ASSIGNED_ROLES, grpId);
	}

	/**
	 * Get the unassigned Role list by Group Id
	 * 
	 * @param grpId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection getUnassignedRoles(String grpId) {
		return super.find(QUERY_UNASSIGNED_ROLES, grpId);
	}

	/**
	 * Get the assigned Group list by Role Id
	 * 
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings(value = "unchecked")
	public Collection getAssignedGroups(String roleId) {
		return super.find(QUERY_ASSIGNED_GROUPS, roleId);
	}

	/**
	 * Get the unassigned Group list by Role Id
	 * 
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings(value = "unchecked")
	public Collection getUnassignedGroups(String roleId) {
		return super.find(QUERY_UNASSIGNED_GROUPS, roleId);
	}

	/**
	 * Delete the Group Role relationship by role id
	 * 
	 * @param roleId
	 */
	public void deleteByRoleId(String roleId) {
		Query query = super.createQuery(DELETE_BY_ROLE_ID, roleId);
		query.executeUpdate();
	}

	/**
	 * Delete the Group Role relationship by group id
	 * 
	 * @param grpId
	 *            - group id
	 */
	public void deleteByGrpId(String grpId) {
		Query query = super.createQuery(DELETE_BY_GRP_ID, grpId);
		query.executeUpdate();
	}
}
