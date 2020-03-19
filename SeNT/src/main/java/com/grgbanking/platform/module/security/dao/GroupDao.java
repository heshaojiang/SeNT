/**
 * 文件名：GroupDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.security.dao;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.security.entity.Group;

/**
 * user group entity Dao<br>
 * 用户组管理Dao
 * 
 * @author vinson
 * 
 */
@Repository
public class GroupDao extends BaseDao<Group> {
	private static final String QUERY_BY_GRP_NAME_FUZZILY = " from Group g where g.grpName like '%'||?||'%' ";

	/**
	 * Get the Group detail by Primary Key
	 * 
	 * @param id
	 * @return
	 */
	public Group getByKey(String id) {
		return super.get(id);
	}

	/**
	 * Get the Group detail by Group Name
	 * 
	 * @param grpName
	 * @return
	 */
	public Group getByGrpName(String grpName) {
		return super.findUniqueBy(AppConstants.GRP_NAME, grpName);
	}

	/**
	 * Get the Page by group name fuzzily
	 * 
	 * @param page
	 * @param grpName
	 * @return
	 */
	public Page<Group> getByGrpNameFuzzily(Page<Group> page, String grpName) {
		if (grpName == null || grpName.trim().length() == 0) {
			return super.findPage(page);
		}
		return super.findPage(page, QUERY_BY_GRP_NAME_FUZZILY, grpName);
	}
}
