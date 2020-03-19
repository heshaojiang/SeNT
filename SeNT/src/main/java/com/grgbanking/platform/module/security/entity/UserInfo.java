/**
 * 文件名：UserInfo.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */

package com.grgbanking.platform.module.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;

/**
 * user view<br>
 * 用户信息视图
 * 
 * @author vinson
 * 
 */
@Entity
// Table definition
@Table(name = "V_USR_USERINFO")
@SuppressWarnings("serial")
public class UserInfo implements Serializable {
	private String userId;
	private String priviId;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @GeneratedValue(generator = "paymentableGenerator")
	// @GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
	@Column(name = "C_USERID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "C_PRIVIID")
	public String getPriviId() {
		return priviId;
	}

	public void setPriviId(String priviId) {
		this.priviId = priviId;
	}
}
