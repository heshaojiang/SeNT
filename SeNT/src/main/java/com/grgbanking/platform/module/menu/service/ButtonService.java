package com.grgbanking.platform.module.menu.service;

import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;
import com.grgbanking.platform.module.menu.dao.ButtonDao;
import com.grgbanking.platform.module.menu.entity.Button;
import com.grgbanking.platform.module.security.dao.PrivilegeDao;
import com.grgbanking.platform.module.security.entity.Privilege;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 按钮服务类
 * 
 * @author yrliang
 */
@Service
@Transactional
public class ButtonService extends BaseService
{
	@Autowired
	private ButtonDao buttonDao;
	
	@Autowired
	private SysI18nDao sysI18nDao;
	
	@Autowired
	private PrivilegeDao priviDao;

	/**
	 * get Button by key<br>
	 * 根据主健查询按钮
	 * 
	 * @param
	 * @return
	 */
	public Button getButton(String id) {
		return buttonDao.getByKey(id);
	}

//	/**
//	 * get Button Page<br>
//	 * 分页查询所有按钮
//	 * 
//	 * @param
//	 * @return
//	 */
//	public Page<Button> getButtonPage(final Page<Button> page, Map<String, String> propertyFilterMap, String language) {
//		if (propertyFilterMap == null) {
//			propertyFilterMap = new HashMap<String, String>();
//		}
//		page.setOrderBy("order");
//		Page<Button> pageButtons = buttonDao.findPage(page, propertyFilterMap);
//		List<SysI18n> i18nList = sysI18nDao.findBy("language", language);
//		for (Button btn : pageButtons.getResult()) {
//			for (SysI18n i18n : i18nList) {
//				if (i18n.getReferenceid() != null && i18n.getName() != null) {
//					if (i18n.getReferenceid().equals(btn.getId())) {
//						btn.setI18nName(i18n.getName());
//					}
//				}
//			}
//		}
//		return pageButtons;
//	}

	/**
	 * get Buttons By Name<br>
	 * 根据名称查询按钮
	 * 
	 * @param
	 * @return
	 */
	public Page<Button> getButtonsByName(final Page<Button> page, String subSystem, String i18nName, String language,
			final Map<String, String> filterParamMap) {

		Object[] objs = new Object[] {};
		if (subSystem == null) {
			subSystem = "";
		}
		if (i18nName == null) {
			i18nName = "";
		}

		String hql = "select b from SysI18n s,Button b where 1=1 and (b.subSystem like '%' || ? || '%' or b.subSystem is null) "
				+ "and s.referenceid = b.id and s.name like '%' || ? || '%' and s.language = '" + language + "'";
		hql += " order by b.subSystem, b.order";

		objs = new Object[] { subSystem, i18nName };
		Page<Button> pagebtn = buttonDao.findPage(page, hql, objs);
		for (Button btn : pagebtn.getResult()) {
			btn.setI18nName(sysI18nDao.getSysI18n(btn.getId(), language).getName());
		}
		return pagebtn;

	}

	/**
	 * save Button<br>
	 * 保存按钮
	 * 
	 * @param
	 * @return
	 */
	public void save(Button entity, String language)
	{
		if( !this.checkButtonName(entity, language) )
		{
			throw new AppException(MessageKeyConstants.MENU_EXISTED_BUTTON_NAME, "The button name has already existed. Please change the button name and submit again. ");
		}

		buttonDao.save(entity);
		SysI18n i18n = new SysI18n();
		SysI18n existsSysI18n = sysI18nDao.getSysI18n(entity.getId(), language);
		if( existsSysI18n != null )
		{
			existsSysI18n.setLanguage(language);
			existsSysI18n.setName(entity.getI18nName());
			existsSysI18n.setReferenceid(entity.getId());
			sysI18nDao.save(existsSysI18n);
		}
		else
		{
			i18n.setLanguage(language);
			i18n.setName(entity.getI18nName());
			i18n.setReferenceid(entity.getId());
			sysI18nDao.save(i18n);
		}
	}

	/**
	 * check Button Name has existed or not<br>
	 * 检查按钮名称是否已经存在
	 * 
	 * @param
	 * @return boolean
	 */
	public boolean checkButtonName(Button btn, String language)
	{
		String hql = null;
		List<SysI18n> list = null;
		if (btn.getId() == null)
		{
			hql = 	" select b" +
					" from Button a, SysI18n b" +
					" where a.id=b.referenceid" +
					" and b.name = ?" +
					" and b.language = ?";
			list = sysI18nDao.find(hql, btn.getI18nName(), language);
		}
		else
		{
			hql = 	" select b" +
					" from Button a, SysI18n b" +
					" where a.id=b.referenceid" +
					" and b.name = ?" +
					" and b.language = ?" +
					" and b.referenceid <> ?";
			list = sysI18nDao.find(hql, btn.getI18nName(), language, btn.getId());
		}
		if (list.isEmpty())
		{
			return true;
		}
		return false;
	}

	/**
	 * delete Selected Buttons<br>
	 * 删除所选择的按钮
	 * 
	 * @param
	 * @return
	 */
	public int deleteSelect(String[] args, String language) {
		Assert.notEmpty(args, "args can not be empty");
		Assert.notNull(language, "language can not be null");
		int count = 0;
		if (null != args && args.length > 0) {
			for (String arg : args) {
				Button button = buttonDao.getByKey(arg);
				if ("0".equals(buttonDao.checkDeleteButton(button))) {
					count += 1;
				}
			}
			if (count == args.length) {
				for (String arg : args) {
					Button button = buttonDao.getByKey(arg);
					if ("0".equals(buttonDao.checkDeleteButton(button))) {
						buttonDao.delete(button);
						List<SysI18n> i18nList = sysI18nDao.findBy(AppConstants.REFERENCE_ID, button.getId());
						if (i18nList != null) {
							for (SysI18n one : i18nList) {
								sysI18nDao.delete(one);
							}
						}
					}
				}
			}

		}
		return args.length - count;
	}

	/**
	 * get Button<br>
	 * 根据当前语言和主健查询按钮
	 * 
	 * @param
	 * @return
	 */
	public Button getButtonItem(String id, String language) {
		Button button = buttonDao.get(id);

		String name = sysI18nDao.getName(id, language);
		button.setI18nName(name);
		return button;

	}

	/**
	 * get Button Max Order Value<br>
	 * 得到下一个按钮顺序号
	 * 
	 * @param
	 * @return
	 */
	public Integer getMaxOrderValue() {
		Integer maxOrder = buttonDao
				.findUnique("select max(m.order) from Button m ");
		if (maxOrder != null)
			return maxOrder+1;
		else
			return null;
	}
	
	
	
	/**
	 * save Button<br>
	 * 保存按钮
	 * 
	 * @param
	 * @return
	 */
	public Button saveNewButton(Element node)
	{
		String name        = StringUtil.trim(node.attributeValue("name"));
		String noteEnglish = StringUtil.trim(node.attributeValue("noteEnglish"));
		String buttonType  = StringUtil.trim(node.attributeValue("buttonType"));
		String subSystem   = StringUtil.trim(node.attributeValue("subSystem"));
		String iconURL     = StringUtil.trim(node.attributeValue("iconURL"));
		String order       = StringUtil.trim(node.attributeValue("order"));
		String language    = StringUtil.trim(node.attributeValue("language"));
		String parentId    = StringUtil.trim(node.attributeValue("parentId"));
		
		// 查找按钮是否已经存在
		Button button = buttonDao.findByNameAndLanguage(name, language);
		if( button==null )
		{
			// 不存在，则添加一个按钮
			button = new Button();
			button.setI18nName(name);
			button.setButtonCode(noteEnglish);
			button.setButtonType(buttonType);
			button.setSubSystem(subSystem);
			button.setIconURL(iconURL);
			button.setOrder(Integer.valueOf(order));
			
			buttonDao.saveNew(button);
			
			// 保存成功以后、保存i18n
			sysI18nDao.save(button.getId(), language, name);
		}
		
		// 菜单、按钮都存在的情况下
		if( StringUtil.isNotBlank(parentId) && StringUtil.isNotBlank(button.getId()) )
		{
			// 查找菜单按钮是否已经有关联（权限）
			Privilege priv = priviDao.getPrivilegesByMenuIdAndButtonId(parentId, button.getId());
			if( priv==null )
			{
				// 没有关联则增加一个菜单与按钮的关联
				priv = new Privilege();
				priv.setMenuId(parentId);
				priv.setButtonId(button.getId());
				priviDao.save(priv);
			}
		}
		
		return button;
	}

}