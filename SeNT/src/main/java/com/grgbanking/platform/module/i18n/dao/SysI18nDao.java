/**
 * 文件名：SysI18nDao.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.i18n.dao;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;

/**
 * sys_i18n Dao<br>
 * 国际化语言表Dao
 * 
 * @author yt
 * 
 */
@Repository
public class SysI18nDao extends BaseDao<SysI18n> {

	/**
	 * get i18n string by reference id and language<br>
	 * 根据引用表的主键id和语言，得到国际化资源串
	 * 
	 * @param refid
	 * @param language
	 * @return
	 */
	public String getName(String refid, String language)
	{
		SysI18n obj = this.findUnique("from SysI18n where referenceid=? and language=?", new Object[] { refid, language });
		return obj == null ? "" : obj.getName();
	}

	/**
	 * get sys_i18n entity by reference id and language<br>
	 * 根据引用表的主键id和语言，得到sys_i18n实体
	 * 
	 * @param refid
	 * @param language
	 * @return
	 */
	public SysI18n getSysI18n(String refid, String language)
	{
		SysI18n obj = this.findFirst("from SysI18n where referenceid=? and language=?", new Object[] { refid, language });
		return obj;
	}
	
	public void save(String referenceId, String language, String name)
	{
		SysI18n sysI18n = this.getSysI18n(referenceId, language);
		if (sysI18n == null)
		{
			sysI18n = new SysI18n();
			sysI18n.setLanguage(language);
			sysI18n.setName(name);
			sysI18n.setReferenceid(referenceId);
		}
		else
		{
			sysI18n.setName(name);
		}
		this.save(sysI18n);
	}
}
