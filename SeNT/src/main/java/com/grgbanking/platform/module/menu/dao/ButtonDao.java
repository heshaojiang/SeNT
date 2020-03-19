/**
 * 文件名：ButtonDao.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.menu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.module.menu.entity.Button;
import com.grgbanking.platform.module.security.entity.Privilege;

/**
 * 基础Dao
 * 
 * @author yrliang
 */
@Repository
public class ButtonDao extends BaseDao<Button>
{
	
	/**
	 * get Button by key<br>
	 * 根据主健查询按钮
	 * 
	 * @param id
	 * @return Button
	 */
	public Button getByKey(String id)
	{
		return super.get(id);
	}

	/**
	 * Check Button has be Deleted<br>
	 * 检查按钮是否已被删除
	 * 
	 * @param SelectDayButton
	 * @return "0" or "1"
	 */
	public String checkDeleteButton(Button btn)
	{
		StringBuffer hql = new StringBuffer("from Privilege b where b.buttonId = ?");
		List<Privilege> priviList = this.find(hql.toString(), btn.getId());
		if (priviList.isEmpty())
		{
			return "0";
		}
		else
		{
			return "1";
		}
	}
	
	public Button findByNameAndLanguage(String name, String language)
	{
		String hql = 	" select btn" +
						" from Button btn, SysI18n i18n" +
						" where btn.id = i18n.referenceid" +
						" and i18n.name = ?" +
						" and i18n.language = ?";
		return this.findFirst(hql, name, language);
	}

}
