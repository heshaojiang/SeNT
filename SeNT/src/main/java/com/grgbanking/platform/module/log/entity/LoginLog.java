/**
 * 文件名：LoginLog.java
 * 创建日期： 2012-3-31
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.log.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * login log entiy<br>
 * 登录日志实体类
 * 
 * @author yt
 * 
 */
@Entity
@Table(name = "SYS_LOGIN_LOG")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class LoginLog extends BaseEntity {
	private String userId;
	private String userName;
	private String hostIp;
	private Date loginTime;
	private Date logoutTime;
	private String result;
	private String note;

	/**
	 * 用户代码
	 */
	@Column(name = "C_USERCODE")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 用户名称
	 */
	@Column(name = "C_USERNAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 客户机ip地址
	 */
	@Column(name = "C_HOST_IP")
	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	/**
	 * 登录时间
	 */
	@Column(name = "D_LOGINTIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * 登出时间
	 */
	@Column(name = "D_LOGOUTTIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	/**
	 * 登录结果
	 */
	@Column(name = "C_RESULT")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 失败时的原因
	 */
	@Column(name = "C_NOTE")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
