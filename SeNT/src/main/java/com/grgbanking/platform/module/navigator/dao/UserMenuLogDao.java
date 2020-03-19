package com.grgbanking.platform.module.navigator.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.navigator.entity.UserMenuLog;

@Repository
public class UserMenuLogDao extends BaseDao<UserMenuLog> {

	/**
	 * 记录用户使用菜单情况
	 * 
	 * @param p_menuId
	 * @param p_userId
	 * @return
	 */
	public boolean recodeUseMenuLog(String p_menuId, String p_userId) {
		StringBuffer hql = new StringBuffer(
				" from UserMenuLog u where u.userId = ? and u.menuId = ? ");
		List<UserMenuLog> ls = super.find(hql.toString(), p_userId, p_menuId);
		UserMenuLog entity = null;
		if (!ls.isEmpty()) {
			entity = ls.get(0);
			entity.setClickedCount(entity.getClickedCount() + 1);
			super.copyUpdate(entity);
		} else {
			entity = new UserMenuLog();
			entity.setMenuId(p_menuId);
			entity.setUserId(p_userId);
			entity.setClickedCount(1);
			super.saveNew(entity);
		}
		return true;
	}
}
