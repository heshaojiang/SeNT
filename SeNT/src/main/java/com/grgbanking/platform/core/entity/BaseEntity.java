/**
 * 文件名：BaseEntity.java
 * 创建日期： 2012-6-12
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.entity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * 统一定义id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略. 子类可重载getId()函数重定义id的列名映射和生成策略.
 * 
 * @author yrliang
 */
// JPA 基类的标识
@MappedSuperclass
@SuppressWarnings( { "unchecked", "serial" })
public abstract class BaseEntity implements Serializable {
	// public static final String JAVAPT_SCHEMA = "JAVAPT";
	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private String id;

	/**
	 * 获得id
	 * 
	 * @return String
	 */
	// @Id标注在gettor上，决定了访问类型是property
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	@Column(name = "C_ID")
	public String getId() {
		return id;
	}

	/**
	 * 设置id
	 * 
	 * @param id
	 *            主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		if (id == null)
			return -1;
		return id.hashCode();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof BaseEntity))
			return false;

		BaseEntity other = (BaseEntity) obj;
		return getId().equals(other.getId());
	}

	@Override
	public String toString() {
		final String error = this.getClass().toString() + " :[id = " + this.getId() + "] toString Error: ";

		try {
			Map map = PropertyUtils.describe(this);
			ToStringBuilder tsb = new ToStringBuilder(this,
					ToStringStyle.MULTI_LINE_STYLE, null);

				for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
				Map.Entry me = (Map.Entry) it.next();

					if ("class".equals(me.getKey())) {
					continue;
				}

					if (me.getValue() == null) {
					tsb.append((String) me.getKey(), "null");
				} else {
					tsb.append((String) me.getKey(), logEntity(me.getValue()));
				}
				}
			return tsb.toString();
		} catch (IllegalAccessException e) {
			logger.error(e.toString());
			return error + e;
		} catch (InvocationTargetException e) {
			logger.error(e.toString());
			return error + e;
		} catch (NoSuchMethodException e) {
			logger.error(e.toString());
			return error + e;
			}


	}

	private String logEntity(Object obj) {
		Assert.notNull(obj, "object that be logged can not be null");
		if (obj instanceof BaseEntity)
			return obj.getClass().getName() + "[id=" + ((BaseEntity) obj).getId() + "]";

		if (obj instanceof Collection) {
			StringBuffer sb = new StringBuffer("[");
			for (Iterator it = ((Collection) obj).iterator(); it.hasNext();) {
				Object o = it.next();
				sb.append("").append(o.getClass().getSimpleName());
				if (o instanceof BaseEntity) {
					sb.append("#").append("id=").append(((BaseEntity) o).getId()).append(";");
				} else {
					sb.append(";");
				}
			}
			sb.append("]");

			return sb.toString();
		}

		return obj.toString();
	}

}
