package com.grgbanking.platform.module.navigator.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

@Entity
// Table definition
@Table(name = "SYS_MODULE")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
// Cache using default setting
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
public class SysModule extends BaseEntity {

	private String menuId;

	private String status;

	private String moduleName;

	/**
	 * 一级菜单对应的名称
	 * 
	 * @return
	 */
	@Transient
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String p_moduleName) {
		moduleName = p_moduleName;
	}

	/**
	 * 一级菜单ID
	 * 
	 * @return
	 */
	@Column(name = "C_MENU_ID")
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String p_menuId) {
		menuId = p_menuId;
	}

	/**
	 * 一级菜单的状态（Y：启用 N：禁用）
	 * 
	 * @return
	 */
	@Column(name = "C_STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String p_status) {
		status = p_status;
	}
}
