package com.grgbanking.platform.module.navigator.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.navigator.entity.SysFunction;

@Repository
public class SysFunctionDao extends BaseDao<SysFunction> {

	/**
	 * 根据模块ID获取
	 * 
	 * @param p_id
	 * @return
	 */
	public List<SysFunction> getFunctionByModuleId(String p_id) {
		StringBuffer sql = new StringBuffer(
				" from SysFunction s where s.moduleId = ? ");
		return find(sql.toString(), p_id);
	}
}
