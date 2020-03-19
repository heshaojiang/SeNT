/**
 * 文件名：ParamDao.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.param.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.grgbanking.exception.ParamException;
import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.utils.SqlHelper;
import com.grgbanking.platform.module.param.entity.Param;

/**
 * 参数管理Dao,是基础的DAO类
 * 
 * @author zhli1
 * 
 */
@Repository
public class ParamDao extends BaseDao<Param> {

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
	/** exist */
	public static final String EXIST = "1";
	/** not exist */
	public static final String NOT_EXIST = "0";

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
	public List queryChildList(String parentId) {
		StringBuffer hql = new StringBuffer(
				"FROM Param  dir WHERE dir.parentid=?");
		List childList = this.find(hql.toString(), parentId);
		return childList;
	}

	// -----------------------------------------------------------------------------
	/**
	 * get subs by path<br>
	 * 根据该项目的全路径识别该项目ID，并返回该项目下属子节点 如果该路径不存在，返回空的列表对象
	 */
	public List queryChildByPath(String path) {
		if (path.equals(AppConstants.ROOT))
			return queryChildList(AppConstants.TOP_PARENT_ID);

		Param dir = findByPath(path);
		if (dir == null)
			return new ArrayList(0);

		return queryChildList(dir.getId());
	}

	// --------------------------------------------------------------------------------
	/**
	 * get map but path, 'key' is key of map, 'value' is value of map<br>
	 * 根据路径返回value note对照表 以value为Map的key, note为Map的值
	 */
	public Map getChildMap(String path) {
		HashMap childMap = new HashMap();
		List childList = queryChildByPath(path);
		Iterator itr = childList.iterator();
		while (itr.hasNext()) {
			Param dir = (Param) itr.next();
			childMap.put(dir.getKey(), dir.getValue());
		}
		return childMap;
	}

	// --------------------------------------------------------------------------------
	/**
	 * get map but path, 'value' is key of map, 'note' is value of map<br>
	 * 根据路径返回value note对照表 以value为Map的key, note为Map的值
	 */
	public Map getChildValueMap(String path) {
		HashMap childMap = new HashMap();
		List childList = queryChildByPath(path);
		Iterator itr = childList.iterator();
		while (itr.hasNext()) {
			Param dir = (Param) itr.next();
			childMap.put(dir.getValue(), dir.getNote());
		}
		return childMap;
	}

	// --------------------------------------------------------------------------------
	/**
	 * get map but path, 'key' is key of map, 'note' is value of map<br>
	 * 根据路径返回keys note对照表 以keys为Map的key, note为Map的值
	 */
	public Map getChildKeysMap(String path) {
		HashMap childMap = new HashMap();
		List childList = queryChildByPath(path);
		Iterator itr = childList.iterator();
		while (itr.hasNext()) {
			Param dir = (Param) itr.next();
			childMap.put(dir.getKey(), dir.getNote());
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
			Param dir = (Param) itr.next();
			childMap.put(dir.getNote(), dir.getValue());
		}
		return childMap;
	}

	// --------------------------------------------------------------------------------
	/**
	 * 
	 * get Param by path<br>
	 * 根据路径返回项目信息
	 * 
	 * @path:从父节点一直到该项目的关键字排列，项目关键字间用ITEM_SEPARATOR分隔
	 */
	public Param findByPath(String path) {

		String[] nodes = StringUtils.split(path, AppConstants.ITEM_SEPARATOR);
		StringBuffer hql = new StringBuffer(
				"FROM Param  dir WHERE dir.parentid=? and dir.key=?");
		// TOP_PARENT_ID最顶层那一个不算
		Object[] params = new Object[] { AppConstants.TOP_PARENT_ID, null };
		Param dir = null;
		for (int i = 0; i < nodes.length; i++) {
			params[1] = nodes[i];
			List list = find(hql.toString(), params);
			if (list.isEmpty())
				return null;
			dir = (Param) list.get(0);
			if (dir == null)
				return null;
			params[0] = dir.getId();
		}
		return dir;
	}
	
	/**
	 * 
	 */
	public Param findByParentIdAndKey(String parentId, String key)
	{
		String hql = "from Param dir where dir.parentid = ? and dir.key = ?";
		List<Param> list = this.find(hql, parentId, key);
		if( list.size()==0 )
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	// --------------------------------------------------------------------------------
	/**
	 * get value by path<br>
	 * 根据路径返回该项目值
	 */
	public String getValueByPath(String path)
	{
		Param param = findByPath(path);
		if (param == null)
			return null;
		return param.getValue();
	}
	
	/**
	 * get value by path<br>
	 * 根据路径返回该项目值
	 */
	public String getValueByPathWithException(String path)
	{
		Param param = findByPath(path);
		if( param==null )
		{
			throw new ParamException(path);
		}
		return param.getValue();
	}
	
	public Integer getIntegerValueByPathWithException(String path)
	{
		Param param = findByPath(path);
		if( param==null )
		{
			throw new ParamException(path);
		}
		try
		{
			String value = param.getValue();
			return Integer.parseInt(value);
		}
		catch (NumberFormatException e)
		{
			throw new ParamException(path);
		}
	}

	// --------------------------------------------------------------------------------
	/**
	 * get Param by id<br>
	 * 根据主键找对象
	 * 
	 * @id 项目主键
	 */
	public Param findById(String id) {
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
	 * get root node<br>
	 * 查询顶级节点
	 * 
	 * @param
	 * @return param
	 * @Exception 异常对象 <br>
	 */
	public Param getRoot() {
		List<Param> list = find("from Param m where m.parentid ='0'");
		return list.get(0);
	}

	/**
	 * 
	 * get all Param except root<br>
	 * 得到出根节点之外的所有Param的list
	 * 
	 * @param
	 * @return List<param>
	 * @Exception 异常对象 <br>
	 */
	public List<Param> getAllparamExceptRoot() {
		List<Param> list = super.find("from Param m where m.parentid !='0'");
		return list;
	}

	// --------------------------------------------------------------------------------
	/**
	 * check if a Param has already existed<br>
	 * 查找参数对象是否已经存在
	 * 
	 * @parentId
	 * @key
	 */
	public String checkParamExist(Param p)
	{
		StringBuffer hql = new StringBuffer("");
		List<Param> list = null;
		if( p.getId() == null )
		{
			hql.append("from Param dir where dir.parentid = ? and dir.key = ?");
			list = find(hql.toString(), p.getParentid(), p.getKey());
		}
		else
		{
			hql.append("from Param dir where dir.parentid = ? and dir.key = ? and dir.id <> ?");
			list = find(hql.toString(), p.getParentid(), p.getKey(), p.getId());
		}
		if( list.isEmpty() )
			return NOT_EXIST;
		return EXIST;
	}

	// --------------------------------------------------------------------------------

	// -----------------------------------------------------------------------
	/**
	 * get subs count number by parent id<br>
	 * 取得子节点数目
	 */
	public long getChildCount(String parentId) {
		StringBuffer hql = new StringBuffer(
				"select count(*) FROM Param  dir WHERE dir.parentid=?");
		List list = this.find(hql.toString(), parentId);
		if (list.isEmpty())
			return 0;
		if (list.get(0) == null)
			return 0;
		return ((Long) list.get(0)).longValue();
	}

	// --------------------------------------------------------------------------------
	/**
	 * get Param and all sub Param by id<br>
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
			Param dir = (Param) itr.next();
			sbfIds.append(",").append(queryIdList(dir.getId()));
		}
		return sbfIds.toString();
	}

	// -----------------------------------------------------------------------
	/**
	 * save a new Param or update a existed Param<br>
	 * 新增或修改一个Param
	 */
	public void saveParam(Param param) {
		this.save(param);
	}

	// --------------------------------------------------------------------------------
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
			StringBuffer hql = new StringBuffer("delete FROM Param as dir WHERE " + SqlHelper.fitStrInCondition("dir.id", aryDelIds));
			iCount += this.executeUpdate(hql.toString());
		}
		return iCount;
	}

	// -------------------------------------------------------------------------------
	/**
	 * get path by id<br>
	 * 返回该项目的关键字路径
	 */
	public String getPath(String itemId)
	{
		ArrayList aryPath = new ArrayList();
		Param param = findById(itemId);
		while (param != null)
		{
			aryPath.add(param.getKey());
			if (param.getParentid().equals(AppConstants.TOP_PARENT_ID))
			{
				break;
			}
			param = findById(param.getParentid());
		}

		int iSize = aryPath.size();
		if( iSize==0 )
		{
			return "";
		}

		StringBuffer sbfPath = new StringBuffer();
		for (int i = iSize - 1; i > 0; i--)
		{
			sbfPath.append(aryPath.get(i));
			sbfPath.append(AppConstants.ITEM_SEPARATOR);
		}
		sbfPath.append(aryPath.get(0));
		return sbfPath.toString();
	}

	// -----------------------------------------------------------------------
	/**
	 * get full path by id<br>
	 * 返回业 务定义->交易类型 这样的路径名
	 */
	public String findPathNote(String itemId) {
		ArrayList aryPath = new ArrayList();
		Param param = findById(itemId);
		while (param != null) {
			aryPath.add(param);
			if (param.getParentid().equals(AppConstants.TOP_PARENT_ID)) {
				break;
			}
			param = findById(param.getParentid());
		}
		int iSize = aryPath.size();
		if (iSize == 0)
		 return AppConstants.ROOT;

		StringBuffer sbfPath = new StringBuffer();
		for (int i = iSize - 1; i > 0; i--) {
			param = (Param) aryPath.get(i);
			sbfPath.append(param.getNote());
			sbfPath.append("->");
		}
		param = (Param) aryPath.get(0);
		sbfPath.append(param.getNote());
		return sbfPath.toString();
	}

	/**
	 * get Param list by path<br>
	 * 得到到FLex ComboBox 组件的下拉列数据源
	 * 
	 */
	public List getComboBoxPath(String path, String beforeOption) {

		List list = queryChildByPath(path);
		if (beforeOption != null && !beforeOption.equals("")) {
			Param param = new Param();
			param.setValue("");
			param.setId("");
			param.setKey("");
			param.setNote(beforeOption);
			list.add(0, param);
		}

		return list;

	}
}