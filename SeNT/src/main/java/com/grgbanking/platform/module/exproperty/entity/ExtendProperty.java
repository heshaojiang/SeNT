/**
 * 文件名：ExtendProperty.java
 * 创建日期： 2012-3-30
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.module.exproperty.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * @author yrliang <br>
 *         扩展属性配置实体
 * 
 */
@Entity
@Table(name = "SYS_EXTEND_PROPERTY")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class ExtendProperty extends BaseEntity {
	private String table;
	private String propertyName;
	private String fieldName;
	private String entityClassProperty;
	private String inputType;
	private String service;
	private String method;
	private String key;
	private String label;
	private String paramDatatype;
	private String checkType;
	private String inputRestrict;
	private String required = "N";
	private int max;
	private int min;
	private String status = "N";
	private Short order;
	private String note;
	private String listDisplay;
	private String i18nName;

	@Column(name = "C_TABLE", length = 20)
	public String getTable() {
		return this.table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@Column(name = "C_PROPERTY_NAME", length = 20)
	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Column(name = "C_FIELD_NAME", length = 20)
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the entityClassProperty
	 */
	@Column(name = "C_ENTITYCLASS_PROPERTY", length = 20)
	public String getEntityClassProperty() {
		return entityClassProperty;
	}

	/**
	 * @param entityClassProperty
	 *            the entityClassProperty to set
	 */
	public void setEntityClassProperty(String entityClassProperty) {
		this.entityClassProperty = entityClassProperty;
	}

	@Column(name = "C_INPUT_TYPE", length = 50)
	public String getInputType() {
		return this.inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	@Column(name = "C_SERVICE", length = 100)
	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Column(name = "C_METHOD", length = 100)
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(name = "C_KEY", length = 100)
	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "C_LABEL", length = 100)
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "C_PARAM_DATATYPE", length = 200)
	public String getParamDatatype() {
		return this.paramDatatype;
	}

	public void setParamDatatype(String paramDatatype) {
		this.paramDatatype = paramDatatype;
	}

	@Column(name = "C_CHECK_TYPE", length = 50)
	public String getCheckType() {
		return this.checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	@Column(name = "C_INPUT_RESTRICT", length = 100)
	public String getInputRestrict() {
		return this.inputRestrict;
	}

	public void setInputRestrict(String inputRestrict) {
		this.inputRestrict = inputRestrict;
	}

	@Column(name = "C_REQUIRED", length = 1)
	public String getRequired() {
		return this.required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	@Column(name = "I_MAX", precision = 1, scale = 0)
	public int getMax() {
		return this.max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Column(name = "I_MIN", precision = 1, scale = 0)
	public int getMin() {
		return this.min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	@Column(name = "C_STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "I_ORDER", precision = 3, scale = 0)
	public Short getOrder() {
		return this.order;
	}

	public void setOrder(Short order) {
		this.order = order;
	}

	@Column(name = "C_NOTE", length = 200)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "C_LISTDISPLAY", length = 1)
	public String getListDisplay() {
		return this.listDisplay;
	}

	public void setListDisplay(String listDisplay) {
		this.listDisplay = listDisplay;
	}

	@Transient
	public String getI18nName() {
		return this.i18nName;
	}

	public void setI18nName(String i18nName) {
		this.i18nName = i18nName;
	}
}
