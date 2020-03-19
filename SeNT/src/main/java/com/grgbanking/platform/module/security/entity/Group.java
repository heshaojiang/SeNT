/**
 * 文件名：Group.java
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
 * user group entity<br>
 * 用户组实体
 * 
 * @author vinson
 * 
 */
@Entity
// Table definition
@Table(name = "USR_GROUP")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class Group extends BaseEntity {
	private String grpName;
	private String grpNote;
	private String status;

	@Column(name = "C_GRPNAME")
	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	@Column(name = "C_GRPNOTE")
	public String getGrpNote() {
		return grpNote;
	}

	public void setGrpNote(String grpNote) {
		this.grpNote = grpNote;
	}

	@Column(name = "C_STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
