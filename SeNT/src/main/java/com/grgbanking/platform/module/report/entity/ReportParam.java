/**
 * 文件名：ReportParam.java
 * 创建日期： 2012-5-29
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
@Table(name = "REPORT_PARAM")
public class ReportParam extends BaseEntity {
	private String reportId;
	private String paramName;
	private String datatype;
	private String defaultValue;
	private String inputType;
	private String method;
	private String paramDatatype;
	private String remark;
	private String service;

	@Column(name = "C_REPORT_ID", length = 32)
	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	@Column(name = "C_PARAM_NAME", length = 20)
	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Column(name = "C_DATATYPE", length = 10)
	public String getDatatype() {
		return this.datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	@Column(name = "C_DEFAULT_VALUE", length = 100)
	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Column(name = "C_INPUT_TYPE", length = 50)
	public String getInputType() {
		return this.inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	@Column(name = "C_METHOD", length = 100)
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
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

	@Column(name = "C_SERVICE", length = 50)
	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}
}
