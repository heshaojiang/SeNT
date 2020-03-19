/**
 * 文件名：Button.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.cashserial.entity;

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
 * 按钮实体
 * 
 * @author yrliang
 */
@Entity
// Table definition
@Table(name = "MENU_BUTTON")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
// Cache using default setting
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
public class SelectDayButton extends BaseEntity {
	// private String buttonCode;
	/** button */
	public static String BUTTON_TYPE = "button";
	/** icon */
	public static String ICON_TYPE = "icon";
	/** icon */
	public static String PRIVI_TYPE = "privilege";
	private String buttonCode;
	private Boolean checked = false;
	private String i18nName = "";
	private String buttonType;
	private Integer order;
	private String subSystem;
	// Icon型按钮的图标URL
	private String iconURL;

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
	 * 顺序号
	 */
	@Column(name = "I_ORDER")
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * 按钮类型
	 */
	@Column(name = "C_BUTTONTYPE")
	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

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
	 * 检查标志
	 */
	@Transient
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	/**
	 * 英文说明
	 */
	@Column(name = "C_NOTE_EN")
	public String getButtonCode() {
		return buttonCode;
	}

	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}

	/**
	 * 子系统
	 */
	@Column(name = "C_SUBSYSTEM")
	public String getSubSystem() {
		return subSystem;
	}

	public void setSubSystem(String subSystem) {
		this.subSystem = subSystem;
	}
}
