package com.grgbanking.platform.module.navigator.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

@Entity
// Table definition
@Table(name = "SYS_MODULE_FUNCTION")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
// Cache using default setting
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
public class SysFunction extends BaseEntity {

	private String moduleId;

	private String menuId;

	@Column(name = "C_MODULE_ID")
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String p_moduleId) {
		moduleId = p_moduleId;
	}

	@Column(name = "C_MENU_ID")
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String p_menuId) {
		menuId = p_menuId;
	}
}
