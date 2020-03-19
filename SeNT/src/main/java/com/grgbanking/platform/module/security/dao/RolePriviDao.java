/**
 * 文件名：RolePriviDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */

package com.grgbanking.platform.module.security.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.security.entity.RolePrivi;

/**
 * role and privilege relationship Dao<br>
 * 角色和权限关系管理Dao
 * 
 * @author vinson
 * 
 */
@Repository
public class RolePriviDao extends BaseDao<RolePrivi> {
	private static final String DELETE_BY_ROLE_ID = "delete from RolePrivi rp where rp.roleId = ? ";

	/**
	 * Get the Role Privilege Detail by Primary Key
	 * 
	 * @param id
	 * @return
	 */
	public RolePrivi getByKey(String id) {
		return super.get(id);
	}

	/**
	 * Get the Role list by Privilege Id
	 * 
	 * @param privilegeId
	 * @return
	 */
	public Collection<String> getRolesByPriviId(String privilegeId) {
		List<RolePrivi> rolePriviList = super.findBy(AppConstants.PRIVILEGE_ID, privilegeId);
		List<String> roleList = new ArrayList<String>();

		for (Iterator<RolePrivi> it = rolePriviList.iterator(); it.hasNext();) {
			RolePrivi rolePrivi = (RolePrivi) it.next();
			String role = rolePrivi.getRoleId();

			if (!roleList.contains(role)) {
				roleList.add(role);
			}
		}

		return roleList;
	}

	/**
	 * Get the Privilege list by Role Id
	 * 
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" })
	public Collection<String> getPrivisByRoleId(String roleId) {
		List rolePriviList = super.findBy(AppConstants.ROLE_ID, roleId);
		List priviList = new ArrayList();

		for (Iterator it = rolePriviList.iterator(); it.hasNext();) {
			RolePrivi rolePrivi = (RolePrivi) it.next();
			String privilege = rolePrivi.getPriviId();

			if (!priviList.contains(privilege)) {
				priviList.add(privilege);
			}
		}

		return priviList;
	}

	/**
	 * Delete the Role Privilege relationship by role id
	 * 
	 * @param roleId
	 */
	public void deleteByRoleId(String roleId) {
		Query query = super.createQuery(DELETE_BY_ROLE_ID, roleId);
		query.executeUpdate();
	}
}
