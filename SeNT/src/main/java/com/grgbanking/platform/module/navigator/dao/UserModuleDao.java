package com.grgbanking.platform.module.navigator.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.navigator.entity.UserModule;

@Repository
public class UserModuleDao extends BaseDao<UserModule> {

	/**
	 * 根据用户ID获取相关模块
	 * 
	 * @param p_userId
	 * @return
	 */
	public List<UserModule> getModuleByUser(String p_userId) {
		StringBuffer hql = new StringBuffer(
				" from UserModule u where u.userId = ? order by u.order asc");
		return super.find(hql.toString(), p_userId);
	}

	/**
	 * 根据用户和模组ID
	 * 
	 * @param p_userId
	 * @param p_moduleId
	 * @return
	 */
	public List<UserModule> getRepeatRecodes(String p_userId, String p_moduleId) {
		StringBuffer hql = new StringBuffer(
				" from UserModule u where u.userId = ? and u.moduleId = ? order by u.order desc");
		return super.find(hql.toString(), p_userId, p_moduleId);
	}
}
