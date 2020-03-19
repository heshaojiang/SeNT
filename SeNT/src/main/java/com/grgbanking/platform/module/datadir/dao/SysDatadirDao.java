/**
 * 文件名：SysDatadirDao.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.datadir.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.utils.SqlHelper;
import com.grgbanking.platform.module.datadir.entity.SysDatadir;
import com.grgbanking.platform.module.i18n.dao.SysI18nDao;
import com.grgbanking.platform.module.i18n.entity.SysI18n;

/**
 * SYS_DATADIR entity Dao<br>
 * 数据字典管理Dao,是基础的DAO类
 * 
 * @author lzyang
 * 
 */
@Repository
public class SysDatadirDao extends BaseDao<SysDatadir> {

	@Autowired
	private SysI18nDao sysI18nDao;
	// --------------------------------------------------------------------------------
	// /**
	// * 项目间分隔符
	// */
	// public static final String ITEM_SEPARATOR = ".";
	//
	// /**
	// * 根目录路径
	// */
	// public static final String ROOT = "\\";
	//
	// /**
	// * 最顶层项目的父ID
	// */
	// public static final String TOP_PARENT_ID = "0";

	/**
	 * 最顶层项目的ID
	 */
	public static final String TOP_ID = "1";

	// --------------------------------------------------------------------------------
	/**
	 * get subs by parent id<br>
	 * 返回父ID符合要求的直属子项目集合
	 * 
	 * @parentId 父项目ID
	 */
	public List<SysDatadir> queryChildList(String parentId)
	{
		StringBuffer hql = new StringBuffer("FROM SysDatadir  dir WHERE dir.parentid=? ORDER BY dir.order asc");
		List<SysDatadir> childList = this.find(hql.toString(), parentId);
		return childList;
	}

	/**
	 * get subs by parent id and language<br>
	 * 返回父ID符合要求的直属子项目集合, 并取得国际化语言 <br>
	 * 
	 * @param parentId
	 * @param language
	 * @return List
	 */
	public List queryChildList(String parentId, String language) {
		// String hql =
		// "FROM SysDatadir  dir WHERE dir.parentid=? ORDER BY dir.order asc";
		StringBuffer hql = new StringBuffer(
				"select new SysDatadir(dir.id, dir.parentid, dir.key, si.name, dir.order, dir.noteEn, dir.status) "
						+ "FROM SysDatadir dir, SysI18n si WHERE dir.id = si.referenceid and dir.parentid=? and si.language = ? ORDER BY dir.order asc");
		List childList = this.find(hql.toString(), parentId, language);
		return childList;
	}

	/**
	 * get subs by path<br>
	 * 根据该项目的全路径识别该项目ID，并返回该项目下属子节点 如果该路径不存在，返回空的列表对象
	 */
	public List queryChildByPath(String path) {
		if (path.equals(AppConstants.ROOT))
			return queryChildList(AppConstants.TOP_PARENT_ID);

		SysDatadir dir = findByPath(path);
		if (dir == null)
			return new ArrayList(0);

		return queryChildList(dir.getId());
	}

	/**
	 * get subs by path and language<br>
	 * 根据该项目的全路径识别该项目ID，并返回该项目下属子节点 如果该路径不存在，返回空的列表对象
	 * 
	 * @param path
	 * @param language
	 * @return List
	 */
	public List queryChildByPath(String path, String language) {
		if (path.equals(AppConstants.ROOT))
			return queryChildList(AppConstants.TOP_PARENT_ID);

		SysDatadir dir = findByPath(path);
		if (dir == null)
			return new ArrayList(0);

		return queryChildList(dir.getId(), language);
	}

	/**
	 * get map but path, 'value' is key of map, 'note' is value of map<br>
	 * 根据路径返回value note对照表 以value为Map的key, note为Map的值
	 */
	public Map getChildValueMap(String path) {
		HashMap childMap = new HashMap();
		List childList = queryChildByPath(path);
		Iterator itr = childList.iterator();
		while (itr.hasNext()) {
			SysDatadir dir = (SysDatadir) itr.next();
			childMap.put(dir.getValue(), dir.getNoteEn());
		}
		return childMap;
	}

	/**
	 * get map but path, 'key' is key of map, 'note' is value of map<br>
	 * 根据路径返回keys note对照表 以keys为Map的key, note为Map的值
	 */
	public Map getChildKeysMap(String path) {
		HashMap childMap = new HashMap();
		List childList = queryChildByPath(path);
		Iterator itr = childList.iterator();
		while (itr.hasNext()) {
			SysDatadir dir = (SysDatadir) itr.next();
			childMap.put(dir.getKey(), dir.getNoteEn());
		}
		return childMap;
	}

	/**
	 * get map but path, 'noteEn' is key of map, 'value' is value of map<br>
	 * 根据路径返回note,value对照表 以note为Map的key, value为Map的值
	 */
	public Map getChildNoteMap(String path) {
		HashMap childMap = new HashMap();
		List childList = queryChildByPath(path);
		Iterator itr = childList.iterator();
		while (itr.hasNext()) {
			SysDatadir dir = (SysDatadir) itr.next();
			childMap.put(dir.getNoteEn(), dir.getValue());
		}
		return childMap;
	}

	/**
	 * get SysDatadir by path<br>
	 * 根据路径返回项目信息
	 * 
	 * @param path
	 *            :从父节点一直到该项目的关键字排列，项目关键字间用ITEM_SEPARATOR分隔
	 */
	public SysDatadir findByPath(String path) {

		String[] nodes = StringUtils.split(path, AppConstants.ITEM_SEPARATOR);
		StringBuffer hql = new StringBuffer(
				"FROM SysDatadir  dir WHERE dir.parentid=? and dir.key=?");
		// TOP_PARENT_ID最顶层那一个不算
		Object[] params = new Object[] { AppConstants.TOP_PARENT_ID, null };
		SysDatadir dir = null;
		for (int i = 0; i < nodes.length; i++) {
			params[1] = nodes[i];
			List list = find(hql.toString(), params);
			if (list.isEmpty())
				return null;
			dir = (SysDatadir) list.get(0);
			if (dir == null)
				return null;
			params[0] = dir.getId();
		}
		return dir;
	}

	/**
	 * get value by path<br>
	 * 根据路径返回该项目值
	 */
	public String getValueByPath(String path) {
		SysDatadir dir = findByPath(path);
		if (dir == null)
			return null;
		return dir.getValue();
	}

	/**
	 * get SysDatadir by id<br>
	 * 根据主键找对象
	 * 
	 * @id 项目主键
	 */
	public SysDatadir findById(String id) {
		if (id.equals(AppConstants.TOP_PARENT_ID))
			return null;
		try {
			return this.get(id);
		} catch (HibernateException ex) {
			logger.error("can not found param entity by id", ex);
			return null;
		}
	}

	/**
	 * 
	 * get root SysDatadir by language<br>
	 * 根据语言查询顶级节点
	 * 
	 * @param language
	 * @return SysDatadir
	 */
	public SysDatadir getRoot(String language) {
		List<SysDatadir> list = find("from SysDatadir m where m.parentid ='0'");
		SysI18n sysI18n = sysI18nDao.getSysI18n(list.get(0).getId(), language);
		if (sysI18n != null) {
			list.get(0).setValue(sysI18n.getName());
		}
		return list.get(0);
	}

	/**
	 * 
	 * get all SysDatadir except root<br>
	 * 得到出根节点之外的所有SysDatadir的list
	 * 
	 * @param lauguage
	 * @return List<SysDatadir>
	 */
	public List<SysDatadir> getAllSysDatadirExceptRoot(String lauguage) {
		List<SysDatadir> list = super
				.find("from SysDatadir m where m.parentid !='0' order by m.order asc");
		// for (SysDatadir dir : list) {
		// SysI18n sysI18n = sysI18nDao.getSysI18n(dir.getId(), lauguage);
		// if (sysI18n != null) {
		// dir.setValue(sysI18n.getName());
		// }
		// }
		List<SysI18n> i18nList = sysI18nDao.findBy("language", lauguage);
		for (SysDatadir dir : list) {
			for (SysI18n i18n : i18nList) {
				if (i18n.getReferenceid() != null && i18n.getName() != null) {
					if (i18n.getReferenceid().equals(dir.getId())) {
						dir.setValue(i18n.getName());
					}
				}
			}
		}
		return list;
	}

	// --------------------------------------------------------------------------------
	/**
	 * count by key(count can not large than 1, becuase there can not be two
	 * same key )<br>
	 * 计算同一父节点下具有相同key的节点数
	 * 
	 * @parentId
	 * @key
	 */
	public long countByKey(String parentId, String key) {
		StringBuffer hql = new StringBuffer(
				"select count(*) FROM SysDatadir  dir WHERE dir.parentid=? and dir.key=?");
		List list = this.find(hql.toString(), new Object[] { parentId, key });

		if (list.isEmpty())
			return 0;

		if (list.get(0) == null)
			return 0;

		return ((Long) list.get(0)).longValue();
	}

	/**
	 * get max id of sub SysDatadir by parent node id<br>
	 * 取得父节点目前子节点最大的序号
	 * 
	 * @parentId 父ID
	 */
	public long getMaxOrderNum(String parentId) {
		StringBuffer hql = new StringBuffer(
				"select max(dir.order) FROM SysDatadir dir WHERE dir.parentid=?");
		List list = this.find(hql.toString(), parentId);
		if (list.isEmpty())
			return 0;

		if (list.get(0) == null)
			return 0;
		return ((Long) list.get(0)).longValue();
	}

	/**
	 * count numbers of sub SysDatadir<br>
	 * 取得子节点数目
	 */
	public long getChildCount(String parentId) {
		StringBuffer hql = new StringBuffer(
				"select count(*) FROM SysDatadir  dir WHERE dir.parentid=?");
		List list = this.find(hql.toString(), parentId);
		if (list.isEmpty())
			return 0;
		if (list.get(0) == null)
			return 0;
		return ((Long) list.get(0)).longValue();
	}

	/**
	 * get SysDatadir and all sub SysDatadir by id<br>
	 * 返回当前项目ID和下属所有子项目ID，ID之间用,分隔
	 * 
	 * @itemId 要查询的项目ID
	 */
	public String queryIdList(String itemId) {

		StringBuffer sbfIds = new StringBuffer();
		sbfIds.append(itemId);
		List childList = queryChildList(itemId);
		Iterator itr = childList.iterator();
		while (itr.hasNext()) {
			SysDatadir dir = (SysDatadir) itr.next();
			sbfIds.append(",").append(queryIdList(dir.getId()));
		}
		return sbfIds.toString();
	}

	/**
	 * save a new SysDatadir or update a existed SysDatadir<br>
	 * 新增或修改一个SysDatadir
	 * 
	 * @return "0":存在相同KEY的兄弟节点 反回ID：新增成功
	 */
	public String saveSysDatadir(SysDatadir dataDir)
	{
		long iCount = countByKey(dataDir.getParentid(), dataDir.getKey());
		if (iCount > 0)
		{
			if (dataDir.getId() != null)
			{
				this.copyUpdate(dataDir);
			}
			else
			{
				this.save(dataDir);
			}
			return "0";
		}
		else
		{
			if (dataDir.getId() != null)
			{
				this.copyUpdate(dataDir);
			}
			else
			{
				this.save(dataDir);
			}
			return dataDir.getId();
		}
	}

	/**
	 * delete all cascaded by ids<br>
	 * 删除ID对应的项目以及下属项目
	 * 
	 * @idList 以,分隔的id号集合
	 */
	public long delAll(String idList)
	{
		String[] aryIds = StringUtils.split(idList, ",");
		long iCount = 0;
		for (int i = 0; i < aryIds.length; i++)
		{
			String[] aryDelIds = StringUtils.split(queryIdList(aryIds[i]), ",");
			StringBuffer hql = new StringBuffer("delete FROM SysDatadir as dir WHERE " + SqlHelper.fitStrInCondition("dir.id", aryDelIds));
			iCount += this.executeUpdate(hql.toString());
		}
		return iCount;
	}

	/**
	 * get path by id<br>
	 * 返回该项目的关键字路径
	 */
	public String getPath(String itemId) {
		ArrayList aryPath = new ArrayList();
		SysDatadir dataDir = findById(itemId);
		while (dataDir != null) {

			aryPath.add(dataDir.getKey());
			if (dataDir.getParentid().equals(AppConstants.TOP_PARENT_ID)) {
				break;
			}

			dataDir = findById(dataDir.getParentid());
		}

		int iSize = aryPath.size();
		if (iSize == 0)
			return "";

		StringBuffer sbfPath = new StringBuffer();
		for (int i = iSize - 1; i > 0; i--) {
			sbfPath.append(aryPath.get(i));
			sbfPath.append(AppConstants.ITEM_SEPARATOR);
		}
		sbfPath.append(aryPath.get(0));
		return sbfPath.toString();
	}

	/**
	 * get full path by id<br>
	 * 返回业 务定义->交易类型 这样的路径名
	 */
	public String findPathNote(String itemId) {
		ArrayList aryPath = new ArrayList();
		SysDatadir dataDir = findById(itemId);
		while (dataDir != null) {
			aryPath.add(dataDir);
			if (dataDir.getParentid().equals(AppConstants.TOP_PARENT_ID)) {
				break;
			}
			dataDir = findById(dataDir.getParentid());
		}
		int iSize = aryPath.size();
		if (iSize == 0)
			return AppConstants.ROOT;// 没有父节点就反回ROOT

		StringBuffer sbfPath = new StringBuffer();
		for (int i = iSize - 1; i > 0; i--) {
			dataDir = (SysDatadir) aryPath.get(i);
			sbfPath.append(dataDir.getNoteEn());
			sbfPath.append("->");
		}
		dataDir = (SysDatadir) aryPath.get(0);
		sbfPath.append(dataDir.getNoteEn());
		return sbfPath.toString();
	}

	/**
	 * get SysDatadir list by path<br>
	 * 得到FLex ComboBox 组件的下拉列数据源
	 * 
	 */
	public List getComboBoxPath(String path, String beforeOption) {

		List list = queryChildByPath(path);
		if (beforeOption != null && !beforeOption.equals("")) {
			SysDatadir sysDatadir = new SysDatadir();
			sysDatadir.setValue("");
			sysDatadir.setId("");
			sysDatadir.setKey("");
			sysDatadir.setNoteEn(beforeOption);
			list.add(0, sysDatadir);
		}

		return list;

	}

	/**
	 * sort sub SysDatadir by ids <br>
	 * 对同一个结点下的项目进行重新排序
	 */
	public long reorderItems(String idList) {
		String[] childId = StringUtils.split(idList, ",");
		if (childId != null) {
			for (int i = 0; i < childId.length; i++) {
				SysDatadir dirinfo = findById(childId[i]);
				dirinfo.setOrder(i + 1);
				this.save(dirinfo);
			}
			return childId.length;
		} else
			return 0;
	}
	
	public String getNoteEnByKey(String path) {
		StringBuffer hql = new StringBuffer("from SysDatadir m where m.key=?");
		List<SysDatadir> list = this.find(hql.toString(), path);
		if (list == null || list.size() == 0) {
			return " ";
		} else {
			return list.get(0).getNoteEn();
		}
	}
}