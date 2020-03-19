/**
 * 文件名：ExPropertyService.java
 * 创建日期： 2012-4-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.exproperty.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.exproperty.dao.ExtendPropertyDao;
import com.grgbanking.platform.module.exproperty.entity.ExtendProperty;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;

/**
 * @author yrliang
 * 
 */
@Service
@Transactional
public class ExPropertyService extends BaseService {

	@Autowired
	ExtendPropertyDao exPropertyDao;

	@Autowired
	SysI18nDao sysI18nDao;

	public Page<ExtendProperty> getPageByTableName(final Page<ExtendProperty> page, String tableName, String language) {

		Map<String, Object> propertyFilterMap = new HashMap<String, Object>();
		propertyFilterMap.put("EQS_table", tableName); // tableName属性是字符类型，按其值过滤
		// propertyFilterMap.put("EQS_status", AppCoreConstants.YES);
		// page.setOrder(Page.ASC);
		page.setOrderBy("order");
		Page<ExtendProperty> returnPage = exPropertyDao.findPageNew(page, propertyFilterMap);

		List<SysI18n> i18nList = sysI18nDao.findBy("language", language);
		for (ExtendProperty btn : returnPage.getResult()) {
			for (SysI18n i18n : i18nList) {
				if (i18n.getReferenceid() != null && i18n.getName() != null) {
					if (i18n.getReferenceid().equals(btn.getId())) {
						btn.setI18nName(i18n.getName());
					}
				}
			}
		}
		return returnPage;

	}

	public void save(ExtendProperty entity, String language) {
		exPropertyDao.copyUpdate(entity);

		SysI18n i18n = new SysI18n();
		SysI18n existsSysI18n = sysI18nDao.getSysI18n(entity.getId(), language);
		if (existsSysI18n != null) {
			existsSysI18n.setLanguage(language);
			existsSysI18n.setName(entity.getI18nName());
			existsSysI18n.setReferenceid(entity.getId());
			sysI18nDao.save(existsSysI18n);
		} else {
			i18n.setLanguage(language);
			i18n.setName(entity.getI18nName());
			i18n.setReferenceid(entity.getId());
			sysI18nDao.save(i18n);
		}
	}

	public List<ExtendProperty> getExtendPropertyList(String tableName) {
		return exPropertyDao.findBy("table", tableName);
	}
}
