/**
 * 文件名：RolePriviInfo.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */

package com.grgbanking.platform.module.security.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * role and privilege relationship information view<br>
 * 角色和权限关系信息视图
 * 
 * @author vinson
 * 
 */
@Entity
// Table definition
@Table(name = "V_USR_ROLEPRIVI_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_PRIVIID"))
@SuppressWarnings("serial")
public class RolePriviInfo extends BaseEntity {
	// private String priviId;
	private String parentId;
	private String parentName;
	private String childId;
	private String childName;
	private String language;
	private String isButton;
	private boolean selected;

	// @Column(name = "C_PRIVIID")
	// public String getPriviId() {
	// return priviId;
	// }
	//
	// public void setPriviId(String priviId) {
	// this.priviId = priviId;
	// }

	@Column(name = "C_PARENTID")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "C_PARENTNAME")
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Column(name = "C_CHILDID")
	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	@Column(name = "C_CHILDNAME")
	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@Column(name = "C_LANGUAGE")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "C_ISBUTTON")
	public String getIsButton() {
		return isButton;
	}

	public void setIsButton(String isButton) {
		this.isButton = isButton;
	}

	@Transient
	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
