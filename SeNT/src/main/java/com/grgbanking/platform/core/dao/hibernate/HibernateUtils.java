/**
 * 文件名：HibernateUtils.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.dao.hibernate;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.util.WebUtils;

import com.grgbanking.platform.core.dao.PropertyFilter;

/**
 * Hibernate针对Web应用的Utils函数集合.
 * 
 * @author calvin
 */
public class HibernateUtils {

	/** 日志对象 */
	private static Logger logger = LoggerFactory
			.getLogger(HibernateUtils.class);

	private HibernateUtils() {
	}

	/**
	 * 根据对象ID集合,整理合并集合.默认对象主键的名称名为"id".
	 * 
	 * @param <T>
	 *            实体类型
	 * @param <ID>
	 *            主键类型
	 * @param srcObjects
	 *            源对象集合
	 * @param checkedIds
	 *            对象id
	 * @param clazz
	 *            类型
	 */
	public static <T, ID> void mergeByCheckedIds(
			final Collection<T> srcObjects, final Collection<ID> checkedIds,
			final Class<T> clazz) {
		mergeByCheckedIds(srcObjects, checkedIds, clazz, "id");
	}

	/**
	 * 根据对象ID集合,整理合并集合.
	 * 
	 * 页面发送变更后的子对象id列表时,删除原来的子对象集合再根据页面id列表创建一个全新的集合这种看似最简单的做法是不行的.
	 * 因此采用如此的整合算法：在源集合中删除id不在目标集合中的对象,根据目标集合中的id创建对象并添加到源集合中. 因为新建对象只有ID被赋值,
	 * 因此本函数不适合于cascade-save-or-update的情形.
	 * 
	 * @param <T>
	 *            实体类型
	 * @param <ID>
	 *            主键类型
	 * @param srcObjects
	 *            源集合,元素为对象.
	 * @param checkedIds
	 *            目标集合,元素为ID.
	 * @param clazz
	 *            集合中对象的类型
	 * @param idName
	 *            对象主键的名称
	 */
	public static <T, ID> void mergeByCheckedIds(
			final Collection<T> srcObjects, final Collection<ID> checkedIds,
			final Class<T> clazz, final String idName) {

		// 参数校验
		Assert.notNull(srcObjects, "scrObjects不能为空");
		Assert.hasText(idName, "idName不能为空");
		Assert.notNull(clazz, "clazz不能为空");

		// 目标集合为空,删除源集合中所有对象后直接返回.
		if (checkedIds == null) {
			srcObjects.clear();
			return;
		}

		// 遍历源集合,如果其id不在目标ID集合中的对象,进行删除.
		// 同时,在目标集合中删除已在源集合中的id,使得目标集合中剩下的id均为源集合中没有的ID.
		Iterator<T> srcIterator = srcObjects.iterator();

		try {
			while (srcIterator.hasNext()) {
				T element = srcIterator.next();
				Object id;
				id = PropertyUtils.getProperty(element, idName);

				if (!checkedIds.contains(id)) {
					srcIterator.remove();
				} else {
					checkedIds.remove(id);
				}
			}

			// ID集合目前剩余的id均不在源集合中,创建对象,为id属性赋值并添加到源集合中.
			for (ID id : checkedIds) {
				T obj = clazz.newInstance();
				PropertyUtils.setProperty(obj, idName, id);
				srcObjects.add(obj);
			}
		} catch (IllegalAccessException e) {
			logger.error("IllegalAccess", e);
		} catch (InvocationTargetException e) {
			logger.error("InvocationTarget", e);
		} catch (NoSuchMethodException e) {
			logger.error("NoSuchMethod", e);
		} catch (InstantiationException e) {
			logger.error("Instantiation", e);
		}

	}

	/**
	 * 根据按PropertyFilter命名规则的Request参数,创建PropertyFilter列表.
	 * 默认Filter属性名前缀为filter_.
	 * 
	 * @param request
	 *            httpRequest
	 * @return 过滤条件
	 * @see #buildPropertyFilters(HttpServletRequest, String)
	 */
	public static List<PropertyFilter> buildPropertyFilters(
			final HttpServletRequest request) {
		return buildPropertyFilters(request, "filter_");
	}

	/**
	 * 根据按PropertyFilter命名规则的Request参数,创建PropertyFilter列表.
	 * PropertyFilter命名规则为Filter属性前缀_比较类型_属性名. eg. filter_EQUAL_name
	 * filter_LIKE_name_OR_email
	 * 
	 * @param request
	 *            httpRequest
	 * @param filterPrefix
	 *            过滤前缀
	 * @return 返回值
	 */
	@SuppressWarnings("unchecked")
	public static List<PropertyFilter> buildPropertyFilters(
			final HttpServletRequest request, final String filterPrefix) {
		List<PropertyFilter> filterList = new ArrayList<PropertyFilter>();

		// 从request中获取含属性前缀名的参数,构造去除前缀名后的参数Map.
		Map<String, String> filterParamMap = WebUtils
				.getParametersStartingWith(request, filterPrefix);

		// 分析参数Map,构造PropertyFilter列表
		for (Map.Entry<String, String> entry : filterParamMap.entrySet()) {
			String filterName = entry.getKey();
			String value = entry.getValue();
			// 如果value值为空,则忽略此filter.
			boolean omit = StringUtils.isBlank(value);
			if (!omit) {
				PropertyFilter filter = new PropertyFilter(filterName, value);
				filterList.add(filter);
			}
		}
		return filterList;
	}
}
