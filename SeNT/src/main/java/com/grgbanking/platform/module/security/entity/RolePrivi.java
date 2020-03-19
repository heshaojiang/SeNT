/**
 * 文件名：RolePrivi.java
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
 * role and privilege relationship<br>
 * 角色和权限关系
 * 
 * @author vinson
 * 
 */
@Entity
// Table definition
@Table(name = "USR_ROLEPRIVI")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class RolePrivi extends BaseEntity {
	private String roleId;
	private String priviId;

	@Column(name = "C_ROLEID")
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "C_PRIVIID")
	public String getPriviId() {
		return priviId;
	}

	public void setPriviId(String priviId) {
		this.priviId = priviId;
	}
}
