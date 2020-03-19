package com.grgbanking.platform.module.navigator.dao;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.navigator.entity.UserFunction;

@Repository
public class UserFunctionDao extends BaseDao<UserFunction> {

	/**
	 * 根据模块ID批量删除记录
	 * 
	 * @param p_moduleId
	 * @return
	 */
	public boolean batchDeleteByModuleId(String p_moduleId) {
		StringBuffer hql = new StringBuffer(
				"delete from UserFunction u where u.userModuleId = ?");
		super.executeUpdate(hql.toString(), p_moduleId);
		return true;
	}
}
