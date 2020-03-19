/**
 * 文件名：RoleDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.security.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.security.entity.Role;
import com.grgbanking.platform.module.security.entity.RolePriviInfo;

/**
 * role entity Dao<br>
 * 角色管理Dao
 * 
 * @author vinson
 * 
 */
@Repository
public class RoleDao extends BaseDao<Role> {
	private static final String QUERY_ROLE_PRIVI_INFO = " from RolePriviInfo rpi where rpi.language = ? ";
	private static final String QUERY_ROOT = " from RolePriviInfo rpi where rpi.parentId ='0' and rpi.language = ? ";

	/**
	 * Get the Role Detail by Primary Key
	 * 
	 * @param id
	 * @return
	 */
	public Role getByKey(String id) {
		return super.get(id);
	}

	/**
	 * Get the Role Detail by Role Name
	 * 
	 * @param roleName
	 * @return
	 */
	public Role getByRoleName(String roleName) {
		return super.findUniqueBy(AppConstants.ROLE_NAME, roleName);
	}

	/**
	 * Get the Role Detail list by Role Level
	 * 
	 * @param roleLevel
	 * @return
	 */
	public Collection<Role> getRolesByRoleLevel(String roleLevel) {
		return super.findBy(AppConstants.ROLE_LEVEL, roleLevel);
	}

	/**
	 * 
	 * 日期：2011-5-4<br>
	 * 版本：V1.0<br>
	 * 描述：checkAddRole(这里用一句话描述这个方法的作用) <br>
	 * 主要方法：<br>
	 * TODO(这里描述这个方法适用条件 – 可选) <br>
	 * TODO(这里描述这个方法的执行流程 – 可选) <br>
	 * TODO(这里描述这个方法的使用方法 – 可选) <br>
	 * TODO(这里描述这个方法的注意事项 – 可选) <br>
	 * ===============================================<br>
	 * 创建日期：2011-5-4 下午01:30:27 <br>
	 * 创建人 haoyuan<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-4<br>
	 * 修改人 haoyuan<br>
	 * 修改描述 checkAddRole(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param role
	 * @return String
	 * @Exception 异常对象 <br>
	 */
	public String checkAddRole(Role role) {
		StringBuffer hql = new StringBuffer("");
		List<Role> list = null;
		if (role.getId() == null) {
			hql.append("from Role r where r.roleName = ?");
			list = this.find(hql.toString(), role.getRoleName());
		} else {
			hql.append("from Role r where r.roleName = ? and r.id <> ?");
			list = this.find(hql.toString(), role.getRoleName(), role.getId());
		}
		if (list.isEmpty())
			return "0";
		return "1";
	}

	/**
	 * VZ 20110510 Get all the records in the view for Role Privilege
	 * Configuration.
	 * 
	 * @return RolePriviInfo Collection
	 */
	public List<RolePriviInfo> getRolePriviInfo(String language) {
		return super.find(QUERY_ROLE_PRIVI_INFO, language);
	}

	/**
	 * VZ 20110510 Get the root node of the Role Privilege Info
	 * 
	 * @param language
	 * @return
	 */
	public RolePriviInfo getRoot(String language) {
		RolePriviInfo rolePriviInfo = null;
		List<RolePriviInfo> list = super.find(QUERY_ROOT, language);
		if (list != null && list.size() > 0) {
			rolePriviInfo = list.get(0);
		}

		return rolePriviInfo;
	}
}
