/**
 * 文件名：TermInfo.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;
import com.grgbanking.platform.core.utils.ReflectionUtils;
import com.grgbanking.platform.module.term.service.TermInfoService;

/**
 * 节点机版本信息实体 <br>
 * 
 * entity of node machine version information
 * 
 * @author 
 * 
 */
@Entity
// Table definition
@Table(name = "NODER_VERSION_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class NoderVersionInfo extends BaseEntity {
	/** 表名 */
	public static final String TABLE_NAME = "NODER_VERSION_INFO";
	
	private int version ;
	
	private String packageName ;
	
	private int relayVersion ;
	
	private String orgCode ;
	
	private String status ;  //00-初始状态，等待审核; 01-审核通过; 02-审核失败
	
	private Date createTime ;
	
	private String createUserId ;
	
	private Date checkTime ;
	
	private String checkUserId ;
	
	private String checkNotice ;
	
	private String remark ;
	
	/* c_noder_type : 0 地市server,1 网点节点机,2 柜面节点机, 3节点机管理端 */
	private String noderType;
	
	/////
	private String orgName;
	
	private String createUserCode;
	
	private String checkUserCode;
	
	
	@Column(name="I_VERSION")
	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	@Column(name="C_PACKAGE_NAME")
	public String getPackageName() {
		return packageName;
	}



	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	@Column(name="I_RELAY_VERSION")
	public int getRelayVersion() {
		return relayVersion;
	}



	public void setRelayVersion(int relayVersion) {
		this.relayVersion = relayVersion;
	}


	@Column(name="C_ORGCODE")
	public String getOrgCode() {
		return orgCode;
	}


	
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}


	@Column(name="C_STATUS")
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="D_CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	@Column(name="C_CREATE_USERID")
	public String getCreateUserId() {
		return createUserId;
	}



	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}


	@Column(name="D_CHECK_TIME")
	public Date getCheckTime() {
		return checkTime;
	}



	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}


	@Column(name="C_CHECK_USERID")
	public String getCheckUserId() {
		return checkUserId;
	}



	public void setCheckUserId(String checkUserId) {
		this.checkUserId = checkUserId;
	}


	@Column(name="C_CHECK_NOTICE")
	public String getCheckNotice() {
		return checkNotice;
	}



	public void setCheckNotice(String checkNotice) {
		this.checkNotice = checkNotice;
	}


	@Column(name="C_REMARK")
	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Transient
	public String getOrgName() {
		return orgName;
	}



	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	@Transient
	public String getCreateUserCode() {
		return createUserCode;
	}



	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}


	@Transient
	public String getCheckUserCode() {
		return checkUserCode;
	}



	public void setCheckUserCode(String checkUserCode) {
		this.checkUserCode = checkUserCode;
	}



	public static String getTableName() {
		return TABLE_NAME;
	}


	@Column(name="c_noder_type")
	public String getNoderType() {
		return noderType;
	}



	public void setNoderType(String noderType) {
		this.noderType = noderType;
	}
	
	
	
}
