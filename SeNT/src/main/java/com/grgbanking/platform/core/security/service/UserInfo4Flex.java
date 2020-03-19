/**
 * 文件名：UserInfo4Flex.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.security.vo.Loginer;
import com.grgbanking.platform.core.springsecurity.SpringSecurityUtils;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;
import com.grgbanking.platform.module.menu.entity.Button;

/**
 * 初始化客户端，主要应用于Flex等C/S结构的应用.
 * 
 * @author yrliang
 * 
 */
@Service
public class UserInfo4Flex {

	@Autowired
	private SysI18nDao sysI18nDao;

	/**
	 * 获取客户端需要用到的相关信息
	 * 
	 * @param language
	 *            语言
	 * @return 保存在客户端的全局信息
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getUserInfo(String language)
	{
		Loginer loginer = SpringSecurityUtils.getCurrentUser();
		Map<String, Object> userInfoMap = loginer.getUserInfo();
		List<SysI18n> i18nList = sysI18nDao.findBy("language", language);
		setI18nName((Map<String, ArrayList<Button>>) userInfoMap.get(AppConstants.PRIVI_BUTTONS), i18nList);
		setI18nName((Map<String, ArrayList<Button>>) userInfoMap.get(AppConstants.PRIVI_ICONS), i18nList);
		return userInfoMap;
	}

	/**
	 * 
	 * 设置用户权限按钮文字
	 * 
	 * @param p_map
	 * @param p_i18nList
	 */
	private void setI18nName(Map<String, ArrayList<Button>> p_map, List<SysI18n> p_i18nList)
	{
		// 为权限按钮赋值
		Collection<ArrayList<Button>> c = p_map.values();
		Iterator<ArrayList<Button>> it = c.iterator();
		for( ; it.hasNext() ; )
		{
			ArrayList<Button> ls = it.next();
			for( Button btn : ls )
			{
				for( SysI18n i18n : p_i18nList )
				{
					if( i18n.getReferenceid() != null && i18n.getName() != null )
					{
						if( i18n.getReferenceid().equals(btn.getId()) )
						{
							btn.setI18nName(i18n.getName());
						}
					}
				}
			}
		}
	}

}
