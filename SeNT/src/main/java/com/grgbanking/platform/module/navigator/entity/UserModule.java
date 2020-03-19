package com.grgbanking.platform.module.navigator.entity;

import java.util.List;

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
@Table(name = "SYS_USER_MODULE")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
// Cache using default setting
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("serial")
public class UserModule extends BaseEntity {

	private String userId;

	private String moduleId;

	private int order;

	private String moduleName;

	private List<UserFunction> children;

	/**
	 * 子模块列表
	 * 
	 * @return
	 */
	@Transient
	public List<UserFunction> getChildren() {
		return children;
	}

	public void setChildren(List<UserFunction> p_children) {
		children = p_children;
	}

	/**
	 * 一级菜单名称
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
	 * 模块ID
	 * 
	 * @return
	 */
	@Column(name = "C_MODULE_ID")
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String p_moduleId) {
		moduleId = p_moduleId;
	}

	/**
	 * 排序
	 * 
	 * @return
	 */
	@Column(name = "I_ORDER")
	public int getOrder() {
		return order;
	}

	public void setOrder(int p_order) {
		order = p_order;
	}
}
