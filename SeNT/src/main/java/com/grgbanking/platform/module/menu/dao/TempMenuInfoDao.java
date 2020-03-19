/**
 * 文件名：TempMenuInfoDao.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.menu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.i18n.dao.TempSysI18nDao;
import com.grgbanking.platform.module.i18n.entity.TempSysI18n;
import com.grgbanking.platform.module.menu.entity.TempMenuInfo;

/**
 * 临时菜单Dao
 * 
 * @author yrliang
 */
@Repository
public class TempMenuInfoDao extends BaseDao<TempMenuInfo> {

	@Autowired
	private TempSysI18nDao tempSysI18nDao;

	/**
	 * get Root Menu<br>
	 * 查询原始的根节点菜单
	 * 
	 * @param
	 * @return
	 */
	public TempMenuInfo getRootMenuInit(String language) {
		List<TempMenuInfo> list = super.find("from TempMenuInfo m where m.parentId = '0'");
		TempSysI18n sysI18n = tempSysI18nDao.getSysI18n(list.get(0).getId(), language);
		if (sysI18n != null) {
			list.get(0).setI18nName(sysI18n.getName());
		}
		return list.get(0);
	}

	/**
	 * get All Menu Except Root Menu<br>
	 * 查询原始的除根节点之外的所有菜单
	 * 
	 * @param
	 * @return
	 */
	public List<TempMenuInfo> getAllMenusExceptRootMenuInit(String lauguage) {
		List<TempMenuInfo> list = super
				.find("from TempMenuInfo m where m.parentId != '0' order by m.order asc");
		List<TempSysI18n> i18nList = tempSysI18nDao.findBy("language", lauguage);
		for (TempMenuInfo menu : list) {
			for (TempSysI18n i18n : i18nList) {
				if (i18n.getReferenceid() != null && i18n.getName() != null) {
					if (i18n.getReferenceid().equals(menu.getId())) {
						menu.setI18nName(i18n.getName());
					}
				}
			}
		}
		return list;
	}
}
