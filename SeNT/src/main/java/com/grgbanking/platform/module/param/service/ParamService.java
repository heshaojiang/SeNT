/**
 * 文件名：ParamService.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.param.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.core.utils.AESUtil;
import com.grgbanking.platform.core.utils.AppCoreConstants;
import com.grgbanking.platform.core.utils.XmlUtil;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.platform.module.param.entity.Param;
import com.grgbanking.sent.utils.StringUtil;

/**
 * Parameter Management service<br>
 * 参数管理服务类.
 * 
 * @author zhli
 */
@Service
// ParamService中许多方法需要修改Param的value属性，因此设置为不支持事物
@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
public class ParamService extends BaseService {

	public static ParamService getInstance() {
		ParamService paramService = SpringContextHolder.getBean("paramService");
		return paramService;
	}

	@Autowired
	private ParamDao paramDao;

	/**
	 * get all parameter objects<br>
	 * 得到所有参数对象列表
	 * 
	 * @return List
	 */
	public List<Param> getAllparamList() {
		List<Param> list = paramDao.getAll("order", true);
		for (Param param : list) {
			paramDao.getSession().setReadOnly(param, true);
			if (AppCoreConstants.YES.equals(param.getEncryptStatus())) {
				String value = AESUtil.decrypt(param.getValue()); // 进行解密
				param.setValue(value);
			}
		}

		return list;
	}

	/**
	 * 
	 * get parameter tree xml by language <br>
	 * 得到某个语种的参数树xml
	 * 
	 * @return String
	 */
	public String getParamTree() {
		Param root = paramDao.getRoot();
		List<Param> param = paramDao.getAllparamExceptRoot();
		String[] fields = { "id", "key", "note" };
		String str = XmlUtil.genreatorTreeXml(root, "id", "key", "parentid",
				fields, param);
		return str;
	}

	/**
	 * 
	 * get parameter object by id<br>
	 * 根据id得到参数对象
	 * 
	 * @param id
	 * @return Param
	 */
	public Param getParamById(String id) {
		Param param = paramDao.findById(id);
		paramDao.getSession().setReadOnly(param, true);
		if (AppCoreConstants.YES.equals(param.getEncryptStatus())) {
			String value = AESUtil.decrypt(param.getValue()); // 进行解密
			param.setValue(value);
		}

		return param;
	}

	/**
	 * 
	 * get sub list by parent id<br>
	 * 根据父id查询子参数对象列表
	 * 
	 * @param id
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<Param> getParamChildlist(String id) {

		List<Param> list = paramDao.queryChildList(id);

		for (Param param : list) {
			paramDao.getSession().setReadOnly(param, true);
			if (AppCoreConstants.YES.equals(param.getEncryptStatus())) {
				String value = AESUtil.decrypt(param.getValue()); // 进行解密
				param.setValue(value);
			}
		}

		return list;

	}

	/**
	 * 
	 * get page object including parameter objects by page object、filter and
	 * parent id<br>
	 * 根据分页对象、过滤条件和父id对参数进行分页查询
	 * 
	 * @param page
	 * @param filterParamMap
	 * @param parentId
	 * @return Page<Param>
	 */
	public Page<Param> getParamPage(Page<Param> page, Map<String, String> propertyFilterMap, String parentId)
	{
		if( propertyFilterMap == null )
		{
			propertyFilterMap = new HashMap<String, String>();
		}
		propertyFilterMap.put("EQS_parentid", parentId);
		Page<Param> pageParam = paramDao.findPage(page, propertyFilterMap);
		for( Param param : pageParam.getResult() )
		{
			paramDao.getSession().setReadOnly(param, true);
			if( AppCoreConstants.YES.equals(param.getEncryptStatus()) )
			{
				try
				{
					String value = AESUtil.decrypt(param.getValue()); // 进行解密
					param.setValue(value);
				}
				catch( Exception e )
				{
					// 确保不抛出异常，只做记录
					logger.error(e.getMessage(), e);
				}
			}
		}
		return pageParam;
	}

	/**
	 * 
	 * save or update a parameter object<br>
	 * 新增或修改一个参数对象
	 * 
	 * @param param
	 *            void
	 */
	@Transactional
	public void saveparam(Param param)
	{
		String lg = paramDao.checkParamExist(param);
		if( ParamDao.EXIST.equals(lg) )
		{
			throw new AppException(MessageKeyConstants.EXIST_KEY, "The Parameter Key has already existed. Please change a new Key and submit again. ");
		}
		if( AppCoreConstants.YES.equals(param.getEncryptStatus()) )
		{
			String value = AESUtil.encrypt(param.getValue()); // 进行加密
			param.setValue(value);
		}
		paramDao.save(param);
	}
	
	@Transactional
	public void addNewParam(Param param)
	{
		paramDao.save(param);
	}

	/**
	 * 
	 * delete parameter objects by selected ids<br>
	 * 删除多个参数项目，参数的ID 放在数组里
	 * 
	 * @param args
	 *            void
	 */
	@Transactional
	public void deleteSelected(String[] args) {
		if (null != args && args.length > 0) {
			for (String arg : args) {
				this.deleteParamList(arg);
			}
		}
	}

	/**
	 * 
	 * delete a parameter object<br>
	 * 删除一个参数对象
	 * 
	 * @param param
	 * @return long
	 */
	@Transactional
	public long deleteParam(Param param) {

		param = paramDao.findById(param.getId());
		if (param == null)
		    return -1;

		return this.deleteParamList(param.getId());

	}

	/**
	 * 
	 * delete parameter objects by ids<br>
	 * 删除多个参数项目 listid 多个项目ID用","分开
	 * 
	 * @param listid
	 * @return long
	 */
	@Transactional
	public long deleteParamList(String listid) {
		return paramDao.delAll(listid);

	}

	/**
	 * get parameter object by id<br>
	 * 根据项目的ID查找参数对象
	 * 
	 * @param id
	 */
	public Param getParamItem(String id) {
		Param param = paramDao.get(id);
		paramDao.getSession().setReadOnly(param, true);
		String value = param.getValue();
		if (AppCoreConstants.YES.equals(param.getEncryptStatus())) {
			value = AESUtil.decrypt(value); // 进行解密
			param.setValue(value);
		}

		return param;
	}

	/**
	 * get path by id<br>
	 * 返回该项目的关键字路径
	 */
	public String getKeyPath(String itemId) {
		return paramDao.getPath(itemId);
	}

	/**
	 * get value by path<br>
	 * 根据路径返回该项目值
	 */
	public String getValueByPath(String path) {
		Param param = paramDao.findByPath(path);
		if (param == null)
		    return null;
		paramDao.getSession().setReadOnly(param, true);
		String value = param.getValue();
		if (AppCoreConstants.YES.equals(param.getEncryptStatus())) {
			value = AESUtil.decrypt(value); // 进行解密
		}

		return value;
	}

	public Param getParamByPath(String fullPath) {
		Param param = paramDao.findByPath(fullPath);
		paramDao.getSession().setReadOnly(param, true);
		String value = param.getValue();
		if (AppCoreConstants.YES.equals(param.getEncryptStatus())) {
			value = AESUtil.decrypt(value); // 进行解密
		}
		param.setValue(value);

		return param;
	}

	/**
	 * get multiple param by the request pathList and language<br>
	 * 根据参数路径集合，得到多个参数
	 * 
	 * @param pathList
	 * @return Map
	 */
	public Map getMultiParamByPaths(Collection<String> pathList)
	{
		Map result = new HashMap();

		if (pathList != null && pathList.size() > 0)
		{
			for (String path : pathList)
			{
				result.put(path, getParamByPath(path)); // 值已解密
			}
		}

		return result;
	}

	public Map<String, String> loadSmsSetting() {
		Map<String, String> map = new HashMap<String, String>();
		Param param = paramDao.findByPath(AppConstants.SMS_SETTING_PATH);
		List<Param> list = this.getParamChildlist(param.getId());
		for (Param p : list) {
			map.put(p.getKey(), p.getValue());
		}

		return map;
	}

	@Transactional
	public void saveSmsSetting(Map<String, String> map) {
		Set<String> set = map.keySet();
		for (String key : set) {
			Param param = paramDao.findByPath(AppConstants.SMS_SETTING_PATH + "." + key);
			if (param == null) {
				continue;
			}
			String value = map.get(key);
			if (AppCoreConstants.YES.equals(param.getEncryptStatus())) {
				value = AESUtil.encrypt(value); // 进行加密
			}
			param.setValue(value);

		}

	}

	public Map<String, String> loadEmailSetting() {
		Map<String, String> map = new HashMap<String, String>();
		Param param = paramDao.findByPath(AppConstants.EMAIL_SETTING_PATH);
		List<Param> list = this.getParamChildlist(param.getId()); // 此处已解密
		for (Param p : list) {
			map.put(p.getKey(), p.getValue());
		}

		return map;
	}

	@Transactional
	public void saveEmailSetting(Map<String, String> map) {
		Set<String> set = map.keySet();
		for (String key : set) {
			Param param = paramDao.findByPath(AppConstants.EMAIL_SETTING_PATH + "." + key);
			String value = map.get(key);
			if (AppCoreConstants.YES.equals(param.getEncryptStatus())) {
				value = AESUtil.encrypt(value); // 进行加密
			}
			param.setValue(value);

		}

	}
	
	@Transactional
	public Param findByParentIdAndKey(String parentId, String key)
	{
		return paramDao.findByParentIdAndKey(parentId, key);
	}
	
	/**
	 * 添加数据库中不存在的系统参数，但不会修改
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	public void recursiveAddSysParam(Element node)
	{
		String key           = StringUtil.trim(node.attributeValue("key"));
		String value         = StringUtil.trim(node.attributeValue("value"));
		String note          = StringUtil.trim(node.attributeValue("note"));
		String status        = StringUtil.trim(node.attributeValue("status"));
		String encryptStatus = StringUtil.trim(node.attributeValue("encryptStatus"));
		String parentId      = StringUtil.trim(node.attributeValue("parentId"));
		
		if( StringUtil.isBlank(key) )
		{
			return ;
		}
		if( StringUtil.isBlank(parentId) )
		{
			parentId = "0";
		}
		
		Param param = findByParentIdAndKey(parentId, key);
		// 如果找不到要节点，那么直接退出
		if( parentId.equals("0") && param==null )
		{
			return ;
		}
		// 
		if( param!=null )
		{
			// 数据库中已经存在，本节点不处理，只处理子节点
			Iterator<Element> iter = node.elementIterator("node");
			while( iter.hasNext() )
			{
				Element childElement = iter.next();
				childElement.addAttribute("parentId", param.getId());
				recursiveAddSysParam(childElement);
			}
		}
		else
		{
			// 数据库中没有这个节点，添加进数据库
			param = new Param();
			param.setKey(key);
			param.setValue(value);
			param.setParentid(parentId);
			param.setNote(note);
			param.setStatus(status);
			param.setEncryptStatus(encryptStatus);
			
			if( "Y".equals(encryptStatus) )
			{
				param.setValue(AESUtil.encrypt(param.getValue()));
			}
			
			paramDao.saveNew(param);
			
			// 判断是否增加成功
			if( param.getId()!=null )
			{
				// 继续处理子节点
				Iterator<Element> iter = node.elementIterator("node");
				while( iter.hasNext() )
				{
					Element childElement = iter.next();
					childElement.addAttribute("parentId", param.getId());
					recursiveAddSysParam(childElement);
				}
			}
		}
	}

}
