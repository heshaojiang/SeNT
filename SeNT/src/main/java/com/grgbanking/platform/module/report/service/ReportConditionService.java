/**
 * 文件名：ReportConditionService.java
 * 创建日期： 2012-5-28
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.report.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.report.dao.ReportConditionDao;
import com.grgbanking.platform.module.report.entity.ReportCondition;

/**
 * @author yrliang
 * 
 */
@Service
@Transactional
public class ReportConditionService extends BaseService {
	@Autowired
	ReportConditionDao dao;

	/**
	 * 根据模板类型查询
	 * 
	 * @param page
	 * @param type
	 * @return
	 */
	public Page<ReportCondition> getPage(final Page<ReportCondition> page) {

		Map<String, Object> propertyFilterMap = new HashMap<String, Object>();
		// page.setOrder(Page.ASC);
		Page<ReportCondition> returnPage = dao.findPageNew(page, propertyFilterMap);

		return returnPage;

	}

	/**
	 * 保存模板
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */

	public void save(ReportCondition entity) {
		dao.save(entity);
	}

	/**
	 * 删除模板
	 * 
	 * @param ids
	 */
	public void delete(String[] ids) {
		for (String id : ids) {
			dao.delete(id);
		}
	}
}
