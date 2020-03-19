/**
 * 文件名：ExPropertyService.java
 * 创建日期： 2012-4-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.template.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.msg.dao.MsgEventDefDao;
import com.grgbanking.platform.module.msg.entity.MsgEventDef;
import com.grgbanking.platform.module.template.dao.ContentTemplateDao;
import com.grgbanking.platform.module.template.entity.ContentTemplate;

/**
 * @author yrliang
 * 
 */
@Service
@Transactional
public class ContentTemplateService extends BaseService {
	@Autowired
	ContentTemplateDao contentTemplateDao;

	@Autowired
	MsgEventDefDao msgEventDefDao;

	/**
	 * 根据模板类型查询
	 * 
	 * @param page
	 * @param type
	 * @return
	 */
	public Page<ContentTemplate> getPageByType(final Page<ContentTemplate> page, String type) {

		Map<String, Object> propertyFilterMap = new HashMap<String, Object>();
		propertyFilterMap.put("EQS_type", type); // tableName属性是字符类型，按其值过滤
		// page.setOrder(Page.ASC);
		Page<ContentTemplate> returnPage = contentTemplateDao.findPageNew(page, propertyFilterMap);

		return returnPage;

	}

	/**
	 * 保存模板
	 * 
	 * @param page
	 * @param userId
	 * @return
	 */
	public void save(ContentTemplate entity) {
		contentTemplateDao.save(entity);
	}

	/**
	 * 删除模板
	 * 
	 * @param ids
	 */
	public String delete(String[] ids) {
		String errorIds = "";
		for (String id : ids) {
			// 是否存在该模板
			ContentTemplate ct = contentTemplateDao.get(id);
			if (ct == null) {
				errorIds += id + ",";
				continue;
			}
			// 该模板是否已用于事件定义
			List<MsgEventDef> ls = msgEventDefDao
					.findMsgEventByTemplateId(id);
			if (ls.size() > 0) {
				errorIds += id + ",";
				continue;
			}
			contentTemplateDao.delete(id);
		}
		if (!"".equals(errorIds)) {
			errorIds = errorIds.substring(0, errorIds.length() - 1);
		}
		return errorIds;
	}

}
