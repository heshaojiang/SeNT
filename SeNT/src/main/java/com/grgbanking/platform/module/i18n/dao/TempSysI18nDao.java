/**
 * 文件名：TempSysI18nDao.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.i18n.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.i18n.entity.TempSysI18n;

/**
 * TEMP_MENU_I18N Dao<br>
 * 临时菜单国际化语言表Dao
 * 
 * @author yt
 * 
 */
@Repository
public class TempSysI18nDao extends BaseDao<TempSysI18n> {

	/**
	 * get menu i18n name by reference id and language<br>
	 * 根据临时菜单表的主键id和语言，得到菜单的国际化名称
	 * 
	 * @param refid
	 * @param language
	 * @return
	 */
	public TempSysI18n getSysI18n(String refid, String language) {
		TempSysI18n obj = this.findUnique("from TempSysI18n where referenceid=? and language=?", new Object[] { refid,
				language });

		return obj;
	}

	/**
	 * get TEMP_MENU_I18N entity by temp menu reference id and language<br>
	 * 根据临时菜单表的主键id和语言，得到TEMP_MENU_I18N实体
	 * 
	 * @param refid
	 * @param language
	 * @return
	 */
	public List<TempSysI18n> getTempSysI18n(String refid) {
		List<TempSysI18n> list = this.find("from TempSysI18n where referenceid=?", new Object[] { refid });

		return list;
	}
}
