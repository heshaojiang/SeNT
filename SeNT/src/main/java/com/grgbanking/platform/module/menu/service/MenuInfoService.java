package com.grgbanking.platform.module.menu.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.XmlUtil;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.dao.TempSysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;
import com.grgbanking.platform.module.i18n.entity.TempSysI18n;
import com.grgbanking.platform.module.menu.dao.ButtonDao;
import com.grgbanking.platform.module.menu.dao.MenuInfoDao;
import com.grgbanking.platform.module.menu.dao.TempMenuInfoDao;
import com.grgbanking.platform.module.menu.entity.Button;
import com.grgbanking.platform.module.menu.entity.MenuInfo;
import com.grgbanking.platform.module.menu.entity.TempMenuInfo;
import com.grgbanking.platform.module.notice.dao.NoticeInfoDao;
import com.grgbanking.platform.module.security.dao.PrivilegeDao;
import com.grgbanking.platform.module.security.entity.Privilege;
import com.grgbanking.sent.utils.StringUtil;

/**
 * 菜单信息服务类
 * 
 * @author yrliang
 */
@Service
@Transactional
public class MenuInfoService extends BaseService
{

	/**
	 * 注册持久化信息类
	 */
	@Autowired
	private MenuInfoDao menuInfoDao;
	
	@Autowired
	private TempMenuInfoDao tempMenuInfoDao;
	
	@Autowired
	private ButtonDao buttonDao;
	
	@Autowired
	private PrivilegeDao priviDao;
	
	@Autowired
	private SysI18nDao sysI18nDao;
	
	@Autowired
	private TempSysI18nDao tempSysI18nDao;
	
	@Autowired
	@Qualifier("noticeInfoDao1")
	private NoticeInfoDao noticeInfoDao;
	
	@Autowired
	private ButtonService buttonService;
	
	/**
	 * get Menu Tree<br>
	 * 查询菜单的树结构
	 * 
	 * @param
	 * @return String
	 */
	@Transactional(readOnly = true)
	public String getMenuTree(String language)
	{
		MenuInfo root = menuInfoDao.getRootMenu(language);
		List<MenuInfo> menus = menuInfoDao.getAllMenusExceptRootMenu(language);
		String[] fields = { "id", "level", "order", "menuURL", "rootURL", "iconURL", "visible" };
		String str = XmlUtil.genreatorTreeXml(root, "id", "i18nName", "parentId", fields, menus);
		return str;
	}

	/**
	 * get Menu Tree With Language<br>
	 * 查询菜单的所在语言的树结构
	 * 
	 * @param
	 * @return String
	 */
	@Transactional(readOnly = true)
	public String getMenuTreeWithLanguage(String[] languages)
	{
		MenuInfo root = menuInfoDao.getRootMenuWithoutLanguage();
		List<MenuInfo> menus = menuInfoDao.getAllMenusExceptRootMenuWithoutLanguage();
		List<SysI18n> sysI18ns = sysI18nDao.getAll();
		String[] fields = { "id", "level", "order", "menuURL", "rootURL", "iconURL", "visible" };
		String str = XmlUtil.genreatorTreeXmlWithLanguage(root, "id", "i18nName", "parentId", fields, menus, sysI18ns, languages);
		return str;
	}

	/**
	 * get init Menu<br>
	 * 查询原始的菜单
	 * 
	 * @param
	 * @return
	 */
	@Transactional(readOnly = true)
	public String getExtensionMenu(String language)
	{
		TempMenuInfo root = tempMenuInfoDao.getRootMenuInit(language);
		List<TempMenuInfo> menus = tempMenuInfoDao.getAllMenusExceptRootMenuInit(language);
		String[] fields = { "id", "level", "order", "menuURL", "rootURL", "iconURL", "visible" };
		String str = XmlUtil.genreatorTreeXml(root, "id", "i18nName", "parentId", fields, menus);
		return str;
	}

	/**
	 * get Menu Tree By User<br>
	 * 根据用户查询菜单树
	 * 
	 * @param
	 * @return
	 */
	@Transactional(readOnly = true)
	public String getMenuTreeByUser(String userCode, String language)
	{
		String result = null;

		MenuInfo root = menuInfoDao.getRootMenu(language);

		List<MenuInfo> menus = menuInfoDao.getAllMenusExceptRootMenu(language);
		Collection<String> menuIds = menuInfoDao.getMenuIdsByUser(userCode);

		if (menus != null && menus.size() > 0)
		{
			for (Iterator<MenuInfo> it = menus.iterator(); it.hasNext();)
			{
				MenuInfo menu = it.next();
				if (!menuIds.contains(menu.getId()))
				{
					it.remove();
				}
			}

			String[] fields = { "id", "level", "order", "menuURL", "rootURL", "iconURL", "visible" };
			result = XmlUtil.genreatorTreeXml(root, "id", "i18nName", "parentId", fields, menus);
		}

		return result;
	}

	/**
	 * get Menu Page<br>
	 * 分页查询某节点下的所有菜单
	 * 
	 * @param
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<MenuInfo> getMenuPage2(final Page<MenuInfo> page, String parentId, String language)
	{
		page.setOrderBy("order");
		Page<MenuInfo> pageMenu = menuInfoDao.findPageByParentId(page, parentId);
		List<SysI18n> i18nList = sysI18nDao.findBy("language", language);
		for( MenuInfo menu : pageMenu.getResult() )
		{
			for( SysI18n i18n : i18nList )
			{
				if( i18n.getReferenceid() != null && i18n.getName() != null )
				{
					if( i18n.getReferenceid().equals(menu.getId()) )
					{
						menu.setI18nName(i18n.getName());
					}
				}
			}
		}
		return pageMenu;
	}

	/**
	 * save Menu<br>
	 * 保存
	 * 
	 * @param
	 * @return
	 */
	public void save(MenuInfo entity, String language)
	{
		if (this.isMenuNameExisted(entity, language))
		{
			throw new AppException(MessageKeyConstants.MENU_EXISTED_MENU_NAME, "The menu name has already existed. Please change the menu name and submit again. ");
		}

		menuInfoDao.save(entity);
		if( priviDao.getPrivilegesByMenuId(entity.getId()).isEmpty() )
		{
			Privilege pri = new Privilege();
			pri.setMenuId(entity.getId());
			priviDao.save(pri);
		}
		
		SysI18n sysI18n = new SysI18n();
		SysI18n existsSysI18n = sysI18nDao.getSysI18n(entity.getId(), language);
		if( existsSysI18n!=null )
		{
			existsSysI18n.setLanguage(language);
			existsSysI18n.setName(entity.getI18nName());
			existsSysI18n.setReferenceid(entity.getId());
			sysI18nDao.save(existsSysI18n);
		}
		else
		{
			sysI18n.setLanguage(language);
			sysI18n.setName(entity.getI18nName());
			sysI18n.setReferenceid(entity.getId());
			sysI18nDao.save(sysI18n);
		}
	}

	/**
	 * check menu name has existed or not<br>
	 * 检查菜单名称是否已经存在
	 * 
	 * @param
	 * @return
	 */
	private boolean isMenuNameExisted(MenuInfo menu, String language)
	{
		if( menu.getId() == null )
		{
			if( menuInfoDao.isMenuNameExisted(menu.getParentId(), menu.getI18nName(), language) )
			{
				return true;
			}
		}
		else
		{
			if( menuInfoDao.isMenuNameExistedeExceptCurrent(menu.getId(), menu.getParentId(), menu.getI18nName(), language) )
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * update menu<br>
	 * 修改菜单
	 * 
	 * @param
	 * @return
	 */
	public void update(MenuInfo entity, String language) {
		menuInfoDao.copyUpdate(entity);
		if (priviDao.getPrivilegesByMenuId(entity.getId()).isEmpty()) {
			Privilege pri = new Privilege();
			pri.setMenuId(entity.getId());
			priviDao.save(pri);
		}
		SysI18n sysI18n = new SysI18n();
		SysI18n existsSysI18n = sysI18nDao.getSysI18n(entity.getId(), language);
		if (existsSysI18n != null) {
			existsSysI18n.setLanguage(language);
			existsSysI18n.setName(entity.getI18nName());
			existsSysI18n.setReferenceid(entity.getId());
			sysI18nDao.copyUpdate(existsSysI18n);
		} else {
			sysI18n.setLanguage(language);
			sysI18n.setName(entity.getI18nName());
			sysI18n.setReferenceid(entity.getId());
			sysI18nDao.save(sysI18n);
		}
	}

	/**
	 * batch Update menu<br>
	 * 批量修改菜单
	 * 
	 * @param
	 * @return
	 */
	public void batchUpdate(List<MenuInfo> menuInfos, String language) {
		for (MenuInfo menuInfo : menuInfos) {
			update(menuInfo, language);
		}
	}

	/**
	 * delete menu<br>
	 * 删除菜单
	 * 
	 * @param
	 * @return
	 */
	public void delete(MenuInfo entity) {
		menuInfoDao.delete(entity);
	}

	/**
	 * delete Selected Buttons<br>
	 * 删除所选的按钮
	 * 
	 * @param
	 * @return
	 */
	public String deleteSelected(String[] args, String language) {
		if (null != args && args.length > 0) {
			String undeleteItems = "";
			for (String arg : args) {
				// 有子项的菜单不删除
				if (menuInfoDao.findBy(AppConstants.PARENT_ID, arg).size() > 0) {
					undeleteItems += sysI18nDao.getName(arg, language) + "、";
					continue;
				}
				MenuInfo mInfo = menuInfoDao.get(arg);
				menuInfoDao.delete(mInfo);
				List<SysI18n> i18nList = sysI18nDao.findBy(AppConstants.REFERENCE_ID, arg);
				if (i18nList != null) {
					for (SysI18n list : i18nList) {
						sysI18nDao.delete(list);
					}
				}
				Collection<Privilege> priList = priviDao.getPrivilegesByMenuId(mInfo.getId());
				if (priList != null) {
					for (Privilege pri : priList) {
						priviDao.delete(pri);
					}
				}

			}
			if (undeleteItems != "")
				return undeleteItems.substring(0, undeleteItems.length() - 1);
		}
		return null;
	}

	/**
	 * get Buttons of this menu<br>
	 * 查询所属菜单的按钮
	 * 
	 * @param
	 * @return
	 */
	public List<Button> getMenuButtons(String menuId, String language) {
		List<Button> allButton = buttonDao.getAll("order", true);
		List<Privilege> ownerButtons = priviDao.findBy("menuId", menuId);
		if (allButton.size() > 0) {
			for (Button butn : allButton) {
				for (Privilege privi : ownerButtons) {
					if (butn.getId().equals(privi.getButtonId())) {
						butn.setChecked(true);
					}
				}
				if (sysI18nDao.getSysI18n(butn.getId(), language) != null) {
					butn.setI18nName(sysI18nDao.getSysI18n(butn.getId(), language).getName());
				} else {
					butn.setI18nName("No Name!");
				}
			}
		}
		return allButton;
	}

	/**
	 * save buttons of this menu<br>
	 * 保存所属菜单的按钮
	 * 
	 * @param
	 * @return
	 */
	public void setMenuButtonsSave(String menuId, List<Button> selectedList, List<Button> disSelectedList)
	{
		for (Button btn : disSelectedList)
		{
			Privilege pri = priviDao.getPrivilegesByMenuIdAndButtonId(menuId, btn.getId());
			priviDao.delete(pri);
		}
		for (Button btn : selectedList)
		{
			Privilege pri = priviDao.getPrivilegesByMenuIdAndButtonId(menuId, btn.getId());
			if( pri==null )
			{
				Privilege privi = new Privilege();
				privi.setMenuId(menuId);
				privi.setButtonId(btn.getId());
				priviDao.save(privi);
			}
		}
	}

	/**
	 * get Menu Max Order Value<br>
	 * 得到当前层次的下一步菜单顺序号
	 * 
	 * @param
	 * @return
	 */
	public Integer getMaxOrderValue(String parentId) {
		return menuInfoDao.getMaxOrderValue(parentId);
	}

	/**
	 * merge Menu<br>
	 * 合并菜单
	 * 
	 * @param
	 * @return
	 */
	public boolean mergeMenu(List<Map<String, String>> p_addedItems) {
		Map<String, String> map1 = new HashMap<String, String>();
		int i = 0;
		while (!p_addedItems.isEmpty()) {
			if (i >= p_addedItems.size()) {
				i = 0;
			}
			Map<String, String> map = p_addedItems.get(i);
			String id = map.get("id");
			String newId = map.get("nid");
			String pid = map.get("pid");
			MenuInfo menuInfo = menuInfoDao.get(pid);
			boolean saveFlag = false;
			if (menuInfo != null) {
				saveFlag = true;
			} else if (map1.containsKey(pid)) {
				saveFlag = true;
				pid = map1.get(pid);
			}
			if (saveFlag) {
				menuInfo = new MenuInfo();
				TempMenuInfo menuInfoInit = tempMenuInfoDao.get(id);
				BeanUtils.copyProperties(menuInfoInit, menuInfo);
				menuInfo.setId(null);
				menuInfo.setParentId(pid);
				String nid = (String) menuInfoDao.saveNew(menuInfo);
				if (!map1.containsKey(newId)) {
					map1.put(newId, nid);
				}
				// create privilege
				if (priviDao.getPrivilegesByMenuId(nid).isEmpty()) {
					Privilege pri = new Privilege();
					pri.setMenuId(nid);
					priviDao.save(pri);
				}
				// create i18n record start
				List<TempSysI18n> list = tempSysI18nDao.getTempSysI18n(id);
				for (TempSysI18n tmpSysI18n : list) {
					SysI18n sysI18n = new SysI18n();
					BeanUtils.copyProperties(tmpSysI18n, sysI18n);
					sysI18n.setId(null);
					sysI18n.setReferenceid(nid);
					sysI18nDao.save(sysI18n);
				}
				// update i18n record end
				p_addedItems.remove(i);
			} else {
				i++;
			}
		}
		return true;
	}

	public String getMessageNum(String userId)
	{
		String megNum = String.valueOf((Integer) noticeInfoDao.getNoticeMsgCount(userId));
		return megNum;
	}
	
	/**
	 * 添加数据库中不存在的系统参数，但不会修改
	 */
	@Transactional
	public void recursiveAddSysMenu(Element node)
	{
		String name     = StringUtil.trim(node.attributeValue("name"));
		String menuURL  = StringUtil.trim(node.attributeValue("menuURL"));
		String iconURL  = StringUtil.trim(node.attributeValue("iconURL"));
		String level    = StringUtil.trim(node.attributeValue("level"));
		String rootURL  = StringUtil.trim(node.attributeValue("rootURL"));
		String note     = StringUtil.trim(node.attributeValue("note"));
		String visible  = StringUtil.trim(node.attributeValue("visible"));
		String order    = StringUtil.trim(node.attributeValue("order"));
		String language = StringUtil.trim(node.attributeValue("language"));
		String parentId = StringUtil.trim(node.attributeValue("parentId"));
		
		if( StringUtil.isBlank(name) )
		{
			return ;
		}
		if( StringUtil.isBlank(parentId) )
		{
			parentId = "0";
		}
		
		MenuInfo menuInfo = menuInfoDao.findByParentIdAndKey(parentId, language, name);
		// 如果找不到根节点，那么直接退出
		if( parentId.equals("0") && menuInfo==null )
		{
			return ;
		}
		// 
		if( menuInfo==null )
		{
			// 数据库中没有这个节点，添加进数据库
			menuInfo = new MenuInfo();
			menuInfo.setParentId(parentId);
			menuInfo.setMenuURL(menuURL);
			menuInfo.setOrder(Integer.valueOf(order));
			menuInfo.setIconURL(iconURL);
			menuInfo.setLevel(level);
			menuInfo.setRootURL(rootURL);
			menuInfo.setNote(note);
			menuInfo.setVisible(visible);
			
			menuInfoDao.saveNew(menuInfo);
			
			// 增加一个菜单与空按钮的关联
			Privilege emptyPriv = new Privilege();
			emptyPriv.setMenuId(menuInfo.getId());
			priviDao.save(emptyPriv);
			
			// 判断是否增加成功
			if( menuInfo.getId()!=null )
			{
				// 保存成功以后、保存i18n
				sysI18nDao.save(menuInfo.getId(), language, name);
			}
		}
		
		// 处理子节点
		handleChildrenNode(node, menuInfo.getId());
	}
	
	
	@SuppressWarnings("unchecked")
	private void handleChildrenNode(Element node, String parentMenuId)
	{
		if( StringUtil.isBlank(parentMenuId) )
		{
			return ;
		}
		// 继续处理子节点
		Iterator<Element> btnIter = node.elementIterator("button");
		while( btnIter.hasNext() )
		{
			Element childElement = btnIter.next();
			childElement.addAttribute("parentId", parentMenuId);
			buttonService.saveNewButton(childElement);
		}
		
		Iterator<Element> menuIter = node.elementIterator("menu");
		while( menuIter.hasNext() )
		{
			Element childElement = menuIter.next();
			childElement.addAttribute("parentId", parentMenuId);
			recursiveAddSysMenu(childElement);
		}
	}
}
