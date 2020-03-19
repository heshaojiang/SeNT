/**
 * 文件名：Param.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.param.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * Param 参数实体类
 * 
 * @author yrliang
 */
@Entity
@Table(name = "SYS_PARAM")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class Param extends BaseEntity {

	private String parentid;
	private String key;
	private String value;
	private String note; // display by english
	private String status;
	private String encryptStatus;

	public Param() {
	}

	/**
	 * 父id
	 */
	@Column(name = "C_PARENTID")
	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	/**
	 * 参数key
	 */
	@Column(name = "C_KEY")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 参数值
	 */
	@Column(name = "C_VALUE")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 备注
	 */
	@Column(name = "C_NOTE")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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
	 * 加密状态:Y加密/1不加密
	 */
	@Column(name = "C_ENCRYPT_STATUS")
	public String getEncryptStatus() {
		return encryptStatus;
	}

	public void setEncryptStatus(String encryptStatus) {
		this.encryptStatus = encryptStatus;
	}

}
