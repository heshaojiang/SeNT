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
import com.grgbanking.platform.module.menu.entity.MenuInfo;

@Entity
// Table definition
@Table(name = "SYS_USER_FUNCTION")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
// Cache using default setting
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
public class UserFunction extends BaseEntity {

	private String userModuleId;

	private String menuId;

	private MenuInfo menuInfo;

	/**
	 * 菜单信息
	 * 
	 * @return
	 */
	@Transient
	public MenuInfo getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(MenuInfo p_menuInfo) {
		menuInfo = p_menuInfo;
	}

	/**
	 * 模组ID
	 * 
	 * @return
	 */
	@Column(name = "C_USER_MODULE_ID")
	public String getUserModuleId() {
		return userModuleId;
	}

	public void setUserModuleId(String p_userModuleId) {
		userModuleId = p_userModuleId;
	}

	/**
	 * 菜单ID
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
}
