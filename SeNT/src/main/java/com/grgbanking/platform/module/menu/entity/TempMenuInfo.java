/**
 * 文件名：TempMenuInfo.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.menu.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 临时菜单实体
 * 
 * @author yrliang
 */
@Entity
// Table definition
@Table(name = "MENU_INFO_ALL")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
// Cache using default setting
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
public class TempMenuInfo extends BaseEntity {

	private String menuURL;
	private String rootURL;
	private String parentId;
	private Integer order;
	private String iconURL;
	private String level;
	private String i18nName = "";

	/**
	 * 国际化名称
	 */
	@Transient
	public String getI18nName() {
		return i18nName;
	}

	public void setI18nName(String i18nName) {
		this.i18nName = i18nName;
	}

	/**
	 * 菜单URL
	 */
	@Column(name = "C_MENUURL")
	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	/**
	 * 菜单顺序
	 */
	@Column(name = "I_ORDER")
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * 图标URL
	 */
	@Column(name = "C_ICONURL")
	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	/**
	 * 层次标志
	 */
	@Column(name = "C_LEVEL")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * 父菜单ID
	 */
	@Column(name = "C_PARENTID")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * Flex根路径
	 */
	@Column(name = "C_ROOTURL")
	public String getRootURL() {
		return rootURL;
	}

	public void setRootURL(String rootURL) {
		this.rootURL = rootURL;
	}
}
