/**
 * 文件名：OperLog.java
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
 * operation log entiy<br>
 * 操作日志实体类
 * 
 * @author yt
 * 
 */
@Entity
@Table(name = "SYS_OPER_LOG")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class OperLog extends BaseEntity {
	private String userId;
	private String userName;
	private String hostIp;
	private Date logTime;
	private String menuName;
	private String operName;
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
	 * 操作时间
	 */
	@Column(name = "D_LOGTIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	/**
	 * 菜单名称
	 */
	@Column(name = "C_MENUNAME")
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * 操作名称
	 */
	@Column(name = "C_OPERNAME")
	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	/**
	 * 备注
	 */
	@Column(name = "C_NOTE")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
