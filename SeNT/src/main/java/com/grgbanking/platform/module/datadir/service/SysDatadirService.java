/**
 * 文件名：SysDatadirService.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.datadir.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.XmlUtil;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.dao.SysDatadirDao;
import com.grgbanking.platform.module.datadir.entity.SysDatadir;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;
import com.grgbanking.sent.utils.StringUtil;

/**
 * SysDatadir Management service<br>
 * 数据字典管理服务类.
 * 
 * @author lzyang
 */
@Service
@Transactional
public class SysDatadirService extends BaseService {
	@Autowired
	private SysDatadirDao sysDatadirDao;

	@Autowired
	private SysI18nDao sysI18nDao;

	/**
	 * get all SysDatadir<br>
	 * 得到所有SysDatadir列表
	 * 
	 * @return List
	 */
	public List getAllDatadirList() {
		return this.sysDatadirDao.getAll("order", true);
	}

	/**
	 * 
	 * get SysDatadir tree xml by language <br>
	 * 得到某个语种的数据字典树xml
	 * 
	 * @return String
	 */
	public String getDataDirTree(String language) {
		SysDatadir root = sysDatadirDao.getRoot(language);
		List<SysDatadir> dataDir = sysDatadirDao.getAllSysDatadirExceptRoot(language);
		String[] fields = { "id", "key", "order", "noteEn", "status" };
		String str = XmlUtil.genreatorTreeXml(root, "id", "value", "parentid", fields, dataDir);
		return str;
	}

	/**
	 * 
	 * get SysDatadir by id<br>
	 * 根据id得到SysDatadir
	 * 
	 * @param id
	 * @return SysDatadir
	 */
	@Transactional(readOnly = true)
	public SysDatadir getSysDatadirById(String id) {

		return sysDatadirDao.findById(id);

	}

	/**
	 * 
	 * get sub list by parent id<br>
	 * 根据父id查询子数据字典项
	 * 
	 * @param id
	 * @return List
	 */
	@Transactional(readOnly = true)
	public List<SysDatadir> getDatadirChildlist(String id)
	{
		return sysDatadirDao.queryChildList(id);
	}

	/**
	 * 
	 * get SysDatadir by page object、filter and parent id<br>
	 * 根据分页对象、过滤条件和父id对数据字典进行分页查询
	 * 
	 * @param page
	 * @param filterParamMap
	 * @param parentId
	 * @return Page<SysDatadir>
	 */
	public Page<SysDatadir> getDataDirPage(final Page<SysDatadir> page, Map<String, String> propertyFilterMap,
			String parentId, String language) {
		if (propertyFilterMap == null) {
			propertyFilterMap = new HashMap<String, String>();
		}
		propertyFilterMap.put("EQS_parentid", parentId);

		// page.setOrder(Page.ASC);
		page.setOrderBy("order");
		Page<SysDatadir> pagedir = sysDatadirDao.findPage(page, propertyFilterMap);

		List<SysI18n> i18nList = sysI18nDao.findBy("language", language);
		for (SysDatadir dir : pagedir.getResult()) {
			for (SysI18n i18n : i18nList) {
				if (i18n.getReferenceid() != null && i18n.getName() != null) {
					if (i18n.getReferenceid().equals(dir.getId())) {
						dir.setValue(i18n.getName());
					}
				}
			}
		}
		return pagedir;
	}

	/**
	 * 
	 * save or update a SysDatadir<br>
	 * 新增或修改一个SysDatadir
	 * 
	 * @param sysDatadir
	 *            void
	 */
	public void saveSysDatadir(SysDatadir sysDatadir)
	{
		sysDatadirDao.saveSysDatadir(sysDatadir);
	}

	/**
	 * 
	 * save or update a SysDatadir and SysI18n<br>
	 * 新增或修改一个数据字典，同时修改其国际化语言
	 * 
	 * @param sysDatadir
	 * @param language
	 *            void
	 */
	public void saveSysDatadir(SysDatadir sysDatadir, String language)
	{
		// 判断父节点下是否已经存在key相同的子节点
		List<SysDatadir> sysDatadirList = getDatadirChildlist(sysDatadir.getParentid());
		for (SysDatadir sysDatadir2 : sysDatadirList)
		{
			// 新增的情况
			if (sysDatadir.getId() == null)
			{
				if (sysDatadir2.getKey().equals(sysDatadir.getKey()))
				{
					throw new AppException(MessageKeyConstants.DATA_DIR_EXISTED_KEY,  "The Datadir Key  has already existed. Please change the Datadir Key and submit again. ");
				}
			}
			// 修改的情况
			else
			{
				if (sysDatadir2.getKey().equals(sysDatadir.getKey()) && !sysDatadir2.getId().equals(sysDatadir.getId()))
				{
					throw new AppException(MessageKeyConstants.DATA_DIR_EXISTED_KEY, "The Datadir Key  has already existed. Please change the Datadir Key and submit again. ");
				}
			}
		}
		String id = sysDatadirDao.saveSysDatadir(sysDatadir);
		if (id.equals("0"))
		{
			id = sysDatadir.getId();
		}
		SysI18n sysI18n = sysI18nDao.getSysI18n(id, language);
		if (sysI18n == null)
		{
			sysI18n = new SysI18n();
			sysI18n.setLanguage(language);
			sysI18n.setName(sysDatadir.getValue());
			sysI18n.setReferenceid(id);
		}
		else
		{
			sysI18n.setName(sysDatadir.getValue());
		}
		sysI18nDao.save(sysI18n);
	}

	/**
	 * 
	 * delete SysDatadir by selected ids<br>
	 * 删除多个数据字典项目ID 放在数组里
	 * 
	 * @param args
	 *            void
	 */
	public void deleteSelected(String[] args) {
		if (null != args && args.length > 0) {
			for (String arg : args) {
				this.deleteSysDatadirList(arg);
			}
		}
	}

	/**
	 * 
	 * delete a SysDatadir<br>
	 * 删除一个数据字典
	 * 
	 * @param sysDatadir
	 * @return long
	 */
	public long deleteSysDatadir(SysDatadir sysDatadir) {

		sysDatadir = sysDatadirDao.findById(sysDatadir.getId());
		if (sysDatadir == null) {
			return -1;
		}

		return this.deleteSysDatadirList(sysDatadir.getId());

	}

	/**
	 * 
	 * delete SysDatadirs by ids<br>
	 * 删除多个数据字典项目 listid 多个项目ID用","分开
	 * 
	 * @param listid
	 * @return long
	 */
	public long deleteSysDatadirList(String listid) {
		String[] aryIds = StringUtils.split(listid, ",");
		for (int i = 0; i < aryIds.length; i++) {
			List<SysI18n> i18nList = sysI18nDao.findBy(AppConstants.REFERENCE_ID, aryIds[i]);
			if (i18nList != null) {
				for (SysI18n list : i18nList) {
					sysI18nDao.delete(list);
				}
			}

		}
		return sysDatadirDao.delAll(listid);

	}

	/**
	 * 
	 * sort SysDatadirs by ids<br>
	 * 根据项目的ID进行重新排序
	 * 
	 * @param idList
	 * @return long
	 */
	public long reorderItems(String idList) {
		return sysDatadirDao.reorderItems(idList);
	}

	/**
	 * get SysDatadirs by id and language<br>
	 * 根据项目的ID和语言查找
	 * 
	 * @param id
	 * @param language
	 */
	public SysDatadir getDataDirItem(String id, String language) {
		SysDatadir datadir = sysDatadirDao.get(id);

		String name = sysI18nDao.getName(id, language);
		datadir.setValue(name);
		return datadir;

	}

	/**
	 * get path by id<br>
	 * 根据id查找数据字典路径
	 * 
	 * @param itemId
	 * @return
	 */
	public String getKeyPath(String itemId) {
		return sysDatadirDao.getPath(itemId);
	}

	/**
	 * Get the Datadir by full key path, include the i18n * name <br>
	 * example:getDatadirByPath("SysDatadirMgr.javapt.orgAreaManage.orgLevel",
	 * "zh_CN"); <br>
	 * 根据全路径和言语得到数据字典对象
	 * 
	 * @param fullPath
	 * @param language
	 * @return SysDatadir
	 */
	public SysDatadir getDatadirByPath(String fullPath, String language) {
		if (StringUtils.isEmpty(fullPath) || StringUtils.isBlank(language)) {
			throw new AppException(MessageKeyConstants.DATA_DIR_FULL_PATH_NOT_NULL,
					"The Datadir Full Path can not be empty.");
		}

		SysDatadir datadir = sysDatadirDao.findByPath(fullPath);
		String name = sysI18nDao.getName(datadir.getId(), language);
		datadir.setValue(name);

		return datadir;
	}

	/**
	 * get the children under the key path and language<br>
	 * 根据全路径和言语得到数据字典列表
	 * 
	 * @param fullPath
	 * @param language
	 * @return List
	 */
	public List getDatadirChildrenByPath(String fullPath, String language)
	{
		if (StringUtils.isEmpty(fullPath) || StringUtils.isBlank(language))
		{
			throw new AppException(MessageKeyConstants.DATA_DIR_FULL_PATH_NOT_NULL, "The Datadir Full Path can not be empty.");
		}

		List datadirList = sysDatadirDao.queryChildByPath(fullPath, language);

		return datadirList;
	}

	/**
	 * get multiple datadir by the request pathList and language<br>
	 * 根据数据字字典路径集合和语种，得到多个数据字典
	 * 
	 * @param pathList
	 * @param language
	 * @return Map
	 */
	public Map getMultDatadirByPaths(Collection<String> pathList, String language) {
		Map result = new HashMap();

		if (pathList != null && pathList.size() > 0) {
			for (String path : pathList) {
				result.put(path, getDatadirChildrenByPath(path, language));
			}
		}

		return result;
	}
	
	/**
	 * 
	 */
	public SysDatadir findByParentIdAndKey(String parantId, String key)
	{
		String hql = 	" FROM SysDatadir dd" +
						" where dd.parentid=?" +
						" and dd.key=?";
		return sysDatadirDao.findFirst(hql, parantId, key);
	}
	
	/**
	 * 添加数据库中不存在的系统参数，但不会修改
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public void recursiveAddSysDataDir(Element node)
	{
		String key           = StringUtil.trim(node.attributeValue("key"));
		String name          = StringUtil.trim(node.attributeValue("name"));
		String noteEnglish   = StringUtil.trim(node.attributeValue("noteEnglish"));
		String status        = StringUtil.trim(node.attributeValue("status"));
		String language      = StringUtil.trim(node.attributeValue("language"));
		String order         = StringUtil.trim(node.attributeValue("order"));
		String parentId      = StringUtil.trim(node.attributeValue("parentId"));
		
		if( StringUtil.isBlank(key) )
		{
			return ;
		}
		if( StringUtil.isBlank(parentId) )
		{
			parentId = "0";
		}
		
		SysDatadir datadir = findByParentIdAndKey(parentId, key);
		// 如果找不到要节点，那么直接退出
		if( parentId.equals("0") && datadir==null )
		{
			return ;
		}
		// 
		if( datadir!=null )
		{
			// 数据库中已经存在，本节点不处理，只处理子节点
			Iterator<Element> iter = node.elementIterator("node");
			while( iter.hasNext() )
			{
				Element childElement = iter.next();
				childElement.addAttribute("parentId", datadir.getId());
				recursiveAddSysDataDir(childElement);
			}
		}
		else
		{
			// 数据库中没有这个节点，添加进数据库
			datadir = new SysDatadir();
			datadir.setKey(key);
			datadir.setParentid(parentId);
			datadir.setNoteEn(noteEnglish);
			datadir.setStatus(status);
			datadir.setOrder(Integer.valueOf(order));
			
			sysDatadirDao.saveNew(datadir);
			
			// 判断是否增加成功
			if( datadir.getId()!=null )
			{
				// 保存成功以后、保存i18n
				sysI18nDao.save(datadir.getId(), language, name);
				
				// 继续处理子节点
				Iterator<Element> iter = node.elementIterator("node");
				while( iter.hasNext() )
				{
					Element childElement = iter.next();
					childElement.addAttribute("parentId", datadir.getId());
					recursiveAddSysDataDir(childElement);
				}
			}
		}
	}
}
