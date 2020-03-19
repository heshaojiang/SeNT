/**
 * 文件名：ContentTemplateDao.java
 * 创建日期： 2012-5-14
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.template.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.template.entity.ContentTemplate;

/**
 * @author yrliang
 * 
 */
@Repository
public class ContentTemplateDao extends BaseDao<ContentTemplate> {
	public List<ContentTemplate> getContentTemplate() {

		StringBuffer hql = new StringBuffer(
				" from ContentTemplate mt where type='accidentNoticeTemplate'");
		return super.find(hql.toString());
	}
}
