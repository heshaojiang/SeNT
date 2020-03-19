/**
 * 文件名：TermType.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 终端类型<br>
 * 
 * entity of terminal type
 * 
 * @author Jonas
 * 
 */
@Entity
// Table definition
@Table(name = "TML_TYPE")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class TermType extends BaseEntity {

	private String type;

	private String typeName;

	private String status;

	private String code;

	/**
	 * 代码
	 * 
	 */
	@Column(name = "C_CODE")
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 终端类型<br>
	 * 
	 * terminal type
	 */
	@Column(name = "C_TERMTYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 型号名称<br>
	 * 
	 * type name
	 */
	@Column(name = "C_TYPENAME")
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 状态：启用/禁用（Y/N）<br>
	 * 
	 * status: Y/N
	 */
	@Column(name = "C_STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
