/**
 * 文件名：ReportCondition.java
 * 创建日期： 2012-5-28
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * @author yrliang
 * 
 */
@Entity
// Table definition
@Table(name = "REPORT_CONDITION")
public class ReportCondition extends BaseEntity {
	private String name;
	private String control;
	private String service;
	private String method;
	private String paramDatatype;
	private String remark;
	private String key;
	private String label;

	/**
	 * @return the key
	 */
	@Column(name = "C_KEY")
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the label
	 */
	@Column(name = "C_LABEL")
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "C_NAME", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "C_CONTROL", length = 50)
	public String getControl() {
		return this.control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	@Column(name = "C_METHOD", length = 100)
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the service
	 */
	@Column(name = "C_SERVICE")
	public String getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	@Column(name = "C_PARAM_DATATYPE", length = 100)
	public String getParamDatatype() {
		return this.paramDatatype;
	}

	public void setParamDatatype(String paramDatatype) {
		this.paramDatatype = paramDatatype;
	}

	@Column(name = "C_REMARK", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
