/**
 * 文件名：SystemInfoService.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.common;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.AppCoreConstants;
import com.grgbanking.platform.module.exproperty.dao.ExtendPropertyDao;
import com.grgbanking.platform.module.exproperty.entity.ExtendProperty;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;
import com.grgbanking.platform.module.menu.dao.ButtonDao;
import com.grgbanking.platform.module.menu.entity.Button;
import com.grgbanking.platform.module.param.dao.ParamDao;

/**
 * flex前端获取后台一些全局信息的服务类
 * 
 * @author yt
 * 
 */

@Service
@Transactional
public class SystemInfoService extends BaseService {

	@Autowired
	ParamDao paramDao;

	@Autowired
	ButtonDao btnDao;

	@Autowired
	SysI18nDao sysI18nDao;

	@Autowired
	ExtendPropertyDao extendPropertyDao;

	/**
	 * 
	 * 日期：Oct 11, 2011<br>
	 * 版本：V1.0<br>
	 * 描述：getServerTime <br>
	 * 提供给前台定时调用，同步前台与后台的时间，并且可以用作刷新session，<br/>
	 * 避免当前后台长时间无交互时，后台session超时 <br/>
	 * ===============================================<br>
	 * 创建日期：Apr 21, 2011 12:06:29 AM <br>
	 * 创建人 HHQuan<br>
	 * ===============================================<br>
	 * 
	 * @return Date
	 */
	public Date getServerTime() {
		return new Date();
	}

	/**
	 * 
	 * 日期：Mar 15, 2012<br>
	 * 版本：V1.0<br>
	 * 描述：getValidateTypes <br>
	 * 从参数中获取验证类型 ===============================================<br>
	 * 创建日期：Mar 15, 2012 10:55:29 AM <br>
	 * 创建人 HHQuan<br>
	 * ===============================================<br>
	 * 
	 * @return Map
	 */
	public Map getValidateTypes() {
		return paramDao.getChildMap(AppConstants.VALIDATE_TYPES_PATH);
	}

	/**
	 * 
	 * 日期：Apr 9, 2012<br>
	 * 版本：V1.0<br>
	 * 描述：getButtonList <br>
	 * 获取所有按钮类型 ===============================================<br>
	 * 创建日期：Apr 9, 2012 9:48:29 AM <br>
	 * 创建人 HHQuan<br>
	 * ===============================================<br>
	 * 
	 * @return List
	 */
	public List<Button> getButtonList(String language) {
		List<Button> btnList = btnDao.getAll();
		List<SysI18n> i18nList = sysI18nDao.findBy("language", language);
		for (Button btn : btnList) {
			for (SysI18n i18n : i18nList) {
				if (i18n.getReferenceid() != null && i18n.getName() != null) {
					if (i18n.getReferenceid().equals(btn.getId())) {
						btn.setI18nName(i18n.getName());
					}
				}
			}
		}
		return btnList;
	}

	/**
	 * 获取所有扩展字段条目
	 * 
	 * @return
	 */
	public List<ExtendProperty> getAllExtendProperties(String language) {
		List<ExtendProperty> extPropList = extendPropertyDao.findBy("status", AppCoreConstants.YES);
		List<SysI18n> i18nList = sysI18nDao.findBy("language", language);
		for (ExtendProperty extProp : extPropList) {
			for (SysI18n i18n : i18nList) {
				if (i18n.getReferenceid() != null && i18n.getName() != null) {
					if (i18n.getReferenceid().equals(extProp.getId())) {
						extProp.setI18nName(i18n.getName());
					}
				}
			}
		}
		return extPropList;
	}
}
