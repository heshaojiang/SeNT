/**
 * 文件名：Privilege.java
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

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * privilege entity<br>
 * 权限（菜单和按钮组合）实体
 * 
 * @author vinson
 * 
 */
@Entity
// Table definition
@Table(name = "USR_PRIVILEGE")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class Privilege extends BaseEntity {
	private String menuId;
	private String buttonId;

	@Column(name = "C_MENUID")
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Column(name = "C_BUTTONID")
	public String getButtonId() {
		return buttonId;
	}

	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}
}
