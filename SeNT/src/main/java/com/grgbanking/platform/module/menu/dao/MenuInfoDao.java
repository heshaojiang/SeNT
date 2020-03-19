/**
 * 文件名：MenuInfoDao.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.menu.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;
import com.grgbanking.platform.module.menu.entity.MenuInfo;

/**
 * 菜单Dao
 * 
 * @author yrliang
 */
@Repository
public class MenuInfoDao extends BaseDao<MenuInfo>
{
	private static final String QUERY_MENU_IDS_BY_USER = 	" select distinct p.menuId" +
															" from Privilege p, UserInfo v, User u" +
															" where p.id = v.priviId" +
															" and u.id = v.userId" +
															" and u.userCode = ? ";

	@Autowired
	private SysI18nDao sysI18nDao;
	
	/**
	 * 
	 */
	public Page<MenuInfo> findPageByParentId(Page<MenuInfo> page, String parentId)
	{
		StringBuffer hql = new StringBuffer(
				" select m" +
				" from MenuInfo m" +
				" where m.parentId = ?" +
				" order by m.order asc"
				);
		return this.findPage(page, hql.toString(), parentId);
	}
	
	/**
	 * 
	 */
	public MenuInfo findByParentIdAndKey(String parentId, String language, String name)
	{
		StringBuffer hql = new StringBuffer(
				" select m" +
				" from MenuInfo m, SysI18n b" +
				" where m.id = b.referenceid" +
				" and m.parentId = ?" +
				" and b.language = ?" +
				" and b.name = ?"
				);
		return this.findFirst(hql.toString(), new Object[] { parentId, language, name });
	}

	/**
	 * Check the menu name has existed or not<br>
	 * 检查按钮名称是否已经存在(新增时检查)
	 * 
	 * @param
	 * @return boolean
	 */
	public boolean isMenuNameExisted(String parentId, String i18nName, String language)
	{
		StringBuffer hql = new StringBuffer(
				" select count(b)" +
				" from MenuInfo m, SysI18n b" +
				" where m.id = b.referenceid" +
				" and m.parentId = ?" +
				" and b.language = ?" +
				" and b.name = ?"
				);
		Long count = this.findUnique(hql.toString(), new Object[] { parentId, language, i18nName });
		if( count > 0 )
		{
			return true;
		}
		return false;
	}

	/**
	 * Check the menu name has existed or not except myself<br>
	 * 检查按钮名称除本身外是否已经存在(更新时检查)
	 * 
	 * @param
	 * @return boolean
	 */
	public boolean isMenuNameExistedeExceptCurrent(String currentMenuId, String parentId, String i18nName, String language)
	{
		StringBuffer hql = new StringBuffer(
				" select count(b)" +
				" from MenuInfo m, SysI18n b" +
				" where m.id = b.referenceid" +
				" and m.id<>?" +
				" and m.parentId = ?" +
				" and b.name = ?" +
				" and b.language = ?"
				);
		Long count = this.findUnique(hql.toString(), new Object[] { currentMenuId, parentId, i18nName, language });
		if (count > 0)
		{
			return true;
		}
		return false;
	}

	/**
	 * get All Menus Except Root Menu by current lauguage<br>
	 * 查询除根节点之外的当前语言所有菜单
	 * 
	 * @param lauguage
	 * @return List
	 */
	public List<MenuInfo> getAllMenusExceptRootMenu(String lauguage)
	{
		List<MenuInfo> list = this.find("from MenuInfo m where m.parentId != '0' order by m.order asc");
		List<SysI18n> i18nList = sysI18nDao.findBy("language", lauguage);
		for (MenuInfo menu : list)
		{
			for (SysI18n i18n : i18nList)
			{
				if (i18n.getReferenceid() != null && i18n.getName() != null)
				{
					if (i18n.getReferenceid().equals(menu.getId()))
					{
						menu.setI18nName(i18n.getName());
					}
				}
			}
		}
		return list;
	}

	/**
	 * get All Menus Except Root Menu all lauguage<br>
	 * 查询除根节点之外的所有语言所有菜单
	 * 
	 * @param
	 * @return List
	 */
	public List<MenuInfo> getAllMenusExceptRootMenuWithoutLanguage()
	{
		return super.find("from MenuInfo m where m.parentId != '0' order by m.order asc");
	}

	/**
	 * get Root Menu<br>
	 * 查询根节点菜单
	 * 
	 * @param language
	 * @return MenuInfo
	 */
	public MenuInfo getRootMenu(String language)
	{
		List<MenuInfo> list = super.find("from MenuInfo m where m.parentId = '0'");
		SysI18n sysI18n = sysI18nDao.getSysI18n(list.get(0).getId(), language);
		if (sysI18n != null)
		{
			list.get(0).setI18nName(sysI18n.getName());
		}
		return list.get(0);
	}

	public MenuInfo getRootMenuWithoutLanguage()
	{
		return super.findUnique("from MenuInfo m where m.parentId = '0'");
	}

	/**
	 * save<br>
	 * 保存
	 * 
	 * @param
	 * @return
	 */
	@Override
	public void save(MenuInfo entity)
	{
		if (null != entity && !"".equals(entity))
		{
			super.save(entity);
		}
	}

	/**
	 * save as New<br>
	 * 保存新菜单
	 * 
	 * @param
	 * @return
	 */
	@Override
	public Serializable saveNew(MenuInfo entity)
	{
		return super.saveNew(entity);
	}

	/**
	 * delete<br>
	 * 删除
	 * 
	 * @param
	 * @return
	 */
	@Override
	public void delete(MenuInfo entity)
	{
		if (null != entity && !"".equals(entity))
		{
			super.delete(entity);
		}
	}

	/**
	 * Get Menu Ids By User<br>
	 * 根据当前的用户权限查询有权限的菜单
	 * 
	 * @param
	 * @return
	 */
	public Collection<String> getMenuIdsByUser(String userCode)
	{
		return super.find(QUERY_MENU_IDS_BY_USER, userCode);
	}

	public Integer getMaxOrderValue(String parentId)
	{
		Integer maxOrder = findUnique("select max(m.order) from MenuInfo m where m.parentId = ? ", parentId);
		return maxOrder==null?0:maxOrder+1;
	}
}
