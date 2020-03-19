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
@Table(name = "USR_MENU_LOG")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
// Cache using default setting
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
public class UserMenuLog extends BaseEntity {

	private String userId;

	private String menuId;

	private int clickedCount;

	/**
	 * 用户ID
	 * 
	 * @return
	 */
	@Column(name = "C_USERID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String p_userId) {
		userId = p_userId;
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

	/**
	 * 点击次数
	 * 
	 * @return
	 */
	@Column(name = "I_CLICKED_COUNT")
	public int getClickedCount() {
		return clickedCount;
	}

	public void setClickedCount(int p_clickedCount) {
		clickedCount = p_clickedCount;
	}
}
