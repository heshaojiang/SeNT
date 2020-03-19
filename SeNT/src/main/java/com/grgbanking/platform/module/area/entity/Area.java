/**
 * 文件名：Area.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.area.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.utils.ReflectionUtils;
import com.grgbanking.platform.module.area.service.AreaService;

/**
 * Area Management<br>
 * 区域实体
 * 
 * @author hyuan
 * 
 */

@Entity
@Table(name = Area.TABLE_NAME)
public class Area {
	/** 区域表名 */
	public static final String TABLE_NAME = "ORG_AREA";
	private String id;

	private String parentId;

	private String areaName;

	private int order;
	private String note;
	private String level;
	private String status;

	private String shortName;
	private String pathCode;

	private String f1;
	private String f2;
	private String f3;
	private String f4;
	private String f5;

	/**
	 * 主键
	 */
	@Id
	@Column(name = "C_ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 父id
	 */
	@Column(name = "C_PARENTID")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 区域名称
	 */
	@Column(name = "C_NAME")
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 排序编号
	 */
	@Column(name = "I_ORDER")
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * 备注
	 */
	@Column(name = "C_NOTE")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 树结构层级
	 */
	@Column(name = "C_LEVEL")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * 状态:启动/禁用
	 */
	@Column(name = "C_STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the shortName
	 */
	@Column(name = "C_SHORTNAME")
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName
	 *            the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the pathCode
	 */
	@Column(name = "C_PATHCODE")
	public String getPathCode() {
		return pathCode;
	}

	/**
	 * @param pathCode
	 *            the pathCode to set
	 */
	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}

	@Column(name = "F1")
	public String getF1() {
		return f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	@Column(name = "F2")
	public String getF2() {
		return f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	@Column(name = "F3")
	public String getF3() {
		return f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	}

	@Column(name = "F4")
	public String getF4() {
		return f4;
	}

	public void setF4(String f4) {
		this.f4 = f4;
	}

	@Column(name = "F5")
	public String getF5() {
		return f5;
	}

	public void setF5(String f5) {
		this.f5 = f5;
	}

	public String getExPropertyValue(String propertyName) {
		String entityClassProperty = AreaService.exPropertyMap.get(propertyName);

		Object value = ReflectionUtils.getFieldValue(this, entityClassProperty);
		if (value == null) {
			return null;
		}
		return value.toString();
	}
}
