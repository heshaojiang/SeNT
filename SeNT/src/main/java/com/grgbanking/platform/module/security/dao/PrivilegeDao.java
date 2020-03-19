/**
 * 文件名：PrivilegeDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.security.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.security.entity.Privilege;

/**
 * privilege entity Dao<br>
 * 权限（菜单和按钮组合）管理Dao
 * 
 * @author vinson
 * 
 */
@Repository
public class PrivilegeDao extends BaseDao<Privilege> {

	/**
	 * Get the Privilege Detail by Primary key
	 * 
	 * @param id
	 * @return
	 */
	public Privilege getByKey(String id) {
		return super.get(id);
	}

	/**
	 * Get the Privilege Details by Menu Id
	 * 
	 * @param menuId
	 * @return
	 */
	public Collection<Privilege> getPrivilegesByMenuId(String menuId)
	{
		return super.findBy(AppConstants.MENU_ID, menuId);
	}

	/**
	 * Get the Privilege Details by Button Id
	 * 
	 * @param buttonId
	 * @return
	 */
	public Collection<Privilege> getPrivilegesByButtonId(String buttonId)
	{
		return super.findBy(AppConstants.BUTTON_ID, buttonId);
	}

	public Privilege getPrivilegesByMenuIdAndButtonId(String menuId, String buttonId)
	{
		StringBuffer hql = new StringBuffer(
				" from Privilege p" +
				" where p.menuId = ?" +
				" and p.buttonId = ?"
				);
		return super.findUnique(hql.toString(), menuId, buttonId);
	}
}
