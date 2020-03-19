package com.grgbanking.platform.module.navigator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;
import com.grgbanking.platform.module.menu.dao.MenuInfoDao;
import com.grgbanking.platform.module.menu.entity.MenuInfo;
import com.grgbanking.platform.module.navigator.dao.SysFunctionDao;
import com.grgbanking.platform.module.navigator.dao.SysModuleDao;
import com.grgbanking.platform.module.navigator.dao.UserFunctionDao;
import com.grgbanking.platform.module.navigator.dao.UserMenuLogDao;
import com.grgbanking.platform.module.navigator.dao.UserModuleDao;
import com.grgbanking.platform.module.navigator.entity.SysFunction;
import com.grgbanking.platform.module.navigator.entity.SysModule;
import com.grgbanking.platform.module.navigator.entity.UserFunction;
import com.grgbanking.platform.module.navigator.entity.UserModule;

@Service
@Transactional
public class NavigatorService extends BaseService {

	@Autowired
	private SysModuleDao sysModuleDao;

	@Autowired
	private SysFunctionDao sysFunctionDao;

	@Autowired
	private UserModuleDao userModuleDao;

	@Autowired
	private UserFunctionDao userFunctionDao;

	@Autowired
	private MenuInfoDao menuInfoDao;

	@Autowired
	private SysI18nDao sysI18nDao;

	@Autowired
	private UserMenuLogDao userMenuLogDao;

	/**
	 * 保存用户选择的大模块
	 * 
	 * @param p_userModule
	 * @return
	 */
	public boolean saveUserModule(UserModule p_userModule) {
		List<UserModule> uls = userModuleDao.getRepeatRecodes(
				p_userModule.getUserId(),
				p_userModule.getModuleId());
		if (!uls.isEmpty())
			return false;
		String key = (String) userModuleDao.saveNew(p_userModule);
		List<SysFunction> ls = sysFunctionDao
				.getFunctionByModuleId(p_userModule.getModuleId());
		for (SysFunction obj : ls) {
			UserFunction entity = new UserFunction();
			entity.setUserModuleId(key);
			entity.setMenuId(obj.getMenuId());
			userFunctionDao.saveNew(entity);
		}
		return true;
	}

	/**
	 * 删除用户选中的模块
	 * 
	 * @param p_userModule
	 * @return
	 */
	public boolean delUserModule(UserModule p_userModule) {
		if (userFunctionDao.batchDeleteByModuleId(p_userModule.getId())) {
			userModuleDao.delete(p_userModule);
		} else
			return false;
		return true;
	}

	/**
	 * 获取全部大模块（共四个）
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<SysModule> getSysModuleList(String language) {
		List<SysModule> ls = sysModuleDao.getAll();
		for (SysModule s : ls) {
			SysI18n m = sysI18nDao.getSysI18n(s.getMenuId(), language);
			s.setModuleName(m.getName());
		}
		return ls;
	}

	/**
	 * 根据用户ID和语言获取导航树
	 * 
	 * @param userId
	 * @param language
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<UserModule> getNavigatorTreeByUser(String userId,
			String language) {
		List<UserModule> ls = userModuleDao.getModuleByUser(userId);
		for (UserModule u : ls) {
			SysModule s = sysModuleDao.findUniqueBy("id", u.getModuleId());
			SysI18n m = sysI18nDao.getSysI18n(s.getMenuId(), language);
			u.setModuleName(m.getName());
			u.setChildren(getUserFunctionList(u.getId(), language));
		}
		return ls;
	}

	/**
	 * 获取子模块
	 * 
	 * @param p_userModuleId
	 * @param language
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<UserFunction> getUserFunctionList(String p_userModuleId,
			String language) {
		List<UserFunction> ls = userFunctionDao.findBy("userModuleId",
				p_userModuleId);
		for (UserFunction u : ls) {
			MenuInfo m = menuInfoDao.get(u.getMenuId());
			SysI18n s = sysI18nDao.getSysI18n(m.getId(), language);
			m.setI18nName(s.getName());
			u.setMenuInfo(m);
		}
		return ls;
	}

	/**
	 * 记录用户打开菜单情况
	 * 
	 * @param p_menuId
	 * @param p_userId
	 * @return
	 */
	public boolean userMenuLog(String p_menuId, String p_userId) {
		return userMenuLogDao.recodeUseMenuLog(p_menuId, p_userId);
	}
}
