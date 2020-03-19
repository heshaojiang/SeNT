/**
 * 文件名：HibernateLazyLoadHandler.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.aop;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.collection.PersistentCollection;
import org.hibernate.proxy.HibernateProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.entity.BaseEntity;
import com.grgbanking.platform.core.utils.ReflectionUtils;

/**
 * 将Dao方法返回的实体中包含集合
 * 
 * @author yrliang
 * 
 */
@SuppressWarnings("unchecked")
public class HibernateLazyLoadHandler {
	/** 日志对象 */
	Logger logger = LoggerFactory.getLogger(this.getClass());

	// private boolean isEntity(Object obj) {
	// return obj.getClass().isAnnotationPresent(Entity.class) || obj instanceof
	// BaseEntity
	// || obj instanceof HibernateProxy;
	// }

	private boolean isEntity(Class type) {
		return type.isAnnotationPresent(Entity.class)
				|| type.isAssignableFrom(BaseEntity.class)
				|| type.isAssignableFrom(HibernateProxy.class);
	}

	/**
	 * 捕获异常进行处理.
	 * 
	 * @param joinPoint
	 *            连接点
	 * @param result
	 *            捕获的异常
	 */
	public void afterReturning(JoinPoint joinPoint, Object result) {

		MethodSignature methodSignature = (MethodSignature) joinPoint
				.getSignature();
		Method method = methodSignature.getMethod();
		if (method.isAnnotationPresent(Transactional.class)) {
			Transactional trans = method.getAnnotation(Transactional.class);
			// 只读事务，且不需要返回持久化集合
			// if (trans.readOnly() &&
			// !method.isAnnotationPresent(ReturnPersistCollection.class)) {
			if (trans.readOnly()) {
				logger.debug("processing {}.{}(args)", new Object[] {
						joinPoint.getTarget().getClass().getName(),
						method.getName() });
				if (result instanceof Page) { // 返回值是Page
					Page page = (Page) result;
					List list = page.getResult();
					checkCollection(list);
				} else if (result instanceof Collection) { // 返回值是集合
					Collection collection = (Collection) result;
					checkCollection(collection);
				} else { // 返回值是实体
					checkEntity(result);
				}
			}
		}

	}

	/**
	 * 对集合进行检查
	 * 
	 * @param c
	 *            待检查集合
	 */
	protected void checkCollection(Collection c) {
		for (Object obj : c) {
			checkEntity(obj);
		}
	}

	/**
	 * 对返回实体进行检查并处理
	 * 
	 * @param entity
	 *            待检查实体
	 */
	protected void checkEntity(Object entity) {
		if (entity == null)
			return;

		// 得到所有可访问属性描述信息
		PropertyDescriptor[] entityPds = BeanUtils
				.getPropertyDescriptors(entity.getClass());
		for (int i = 0; i < entityPds.length; i++) {
			PropertyDescriptor entityPd = entityPds[i];

			String fieldName = entityPd.getName();
			Field field = getDeclaredField(entity, fieldName);
			if (field == null) {
				continue; // 非声明字段，不可修改，返回
			}

			if (!field.getType().isPrimitive()
					&& !field.getType().isAssignableFrom(String.class)) {
				logger.debug("{} : {}", new Object[] { field.getName(),
						field.getType() });
			}
			if (Collection.class.isAssignableFrom(field.getType())) {
				// 属性是集合
				if (entityPd.getReadMethod() != null) {

					try {
						Object fieldValue = entityPd.getReadMethod().invoke(
								entity);
						// 且是PersistentCollection，将此集合置为null
						if (fieldValue instanceof PersistentCollection) {
							ReflectionUtils.setFieldValue(entity, fieldName,
									null);
							logger.info("set {}.{} = null", new Object[] {
									entity.getClass().getName(), fieldName });
						}
					} catch (IllegalArgumentException e) {
						logger
								.error(
										"Collection's readMethod reflection invoke error!",
										e);
					} catch (IllegalAccessException e) {
						logger
								.error(
										"Collection's readMethod reflection invoke error!",
										e);
					} catch (InvocationTargetException e) {
						logger
								.error(
										"Collection's readMethod reflection invoke error!",
										e);
					}

				}
			} else if (isEntity(field.getType())) {
				// 属性是关联Entity类型时，保留此属性的值，但需要检查该关联Entity本身是否还有关联其他Entity或集合

				try {
					Object fieldValue = entityPd.getReadMethod().invoke(entity);
					if (fieldValue != null) {
						checkEntity(fieldValue);
					}
				} catch (IllegalArgumentException e) {
					logger.error(
							"Entity's readMethod reflection invoke error!", e);
				} catch (IllegalAccessException e) {
					logger.error(
							"Entity's readMethod reflection invoke error!", e);
				} catch (InvocationTargetException e) {
					logger.error(
							"Entity's readMethod reflection invoke error!", e);
				}

			} else if ("handler".equals(fieldName)
					|| "hibernateLazyInitializer".equals(fieldName)) {
				logger.warn("发现代理对象，单个实体不允许延迟加载，请检查！");
			}
		}
	}

	/**
	 * 根据属性名返回类或父类中声明的Field对象
	 * 
	 * @param object
	 *            对象
	 * @param fieldName
	 *            字段名
	 * @return Field对象
	 */
	protected Field getDeclaredField(final Object object, final String fieldName) {
		Assert.notNull(object, "object不能为空");
		Assert.hasText(fieldName, "fieldName");
		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				// Field不在当前类定义,继续向上转型
				logger
						.debug("NoSuchFieldException will be ignored in this method!");
			}
		}
		return null;
	}

}
