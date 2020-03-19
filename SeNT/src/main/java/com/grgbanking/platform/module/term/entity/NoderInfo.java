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
 * 节点机信息实体 <br>
 * 
 * entity of node machine information
 * 
 * @author 
 * 
 */
@Entity
// Table definition
@Table(name = "NODER_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class NoderInfo extends BaseEntity {
	/** 表名 */
	public static final String TABLE_NAME = "NODER_INFO";
	
	private String orgCode ;
	
	private int version ;
	
	private String noderIP ;
	
	private String runningStatus ;  // 0 - 正常 ； 1 - 故障
	
	private Date statusTime;   //状态更新时间
	
	private String parameter ;
	
	private String device ;
	
	private String installDir ;
	
	private String midLevelIP ;

	private String orgName ;
	
	private String infoVersion;
	
	private String noderType;//节点类型 0 地市server,1 标准版节点机,2 柜面节点机,3 节点机管理端
	
	@Column(name="C_INFO_VERSION")
	public String getInfoVersion() {
		return infoVersion;
	}

	public void setInfoVersion(String infoVersion) {
		this.infoVersion = infoVersion;
	}

	@Column(name="C_ORGCODE")
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name="I_VERSION")
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name="C_NODERIP")
	public String getNoderIP() {
		return noderIP;
	}

	public void setNoderIP(String noderIP) {
		this.noderIP = noderIP;
	}

	@Column(name="C_RUNNING_STATUS")
	public String getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(String runningStatus) {
		this.runningStatus = runningStatus;
	}

	@Column(name="C_STATUS_TIME")
	public Date getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}

	@Column(name="C_PARAMETER")
	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	@Column(name="C_DEVICE")
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Column(name="C_INSTALL_DIR")
	public String getInstallDir() {
		return installDir;
	}

	public void setInstallDir(String installDir) {
		this.installDir = installDir;
	}

	@Column(name="C_MIDLEVEL_IP")
	public String getMidLevelIP() {
		return midLevelIP;
	}

	public void setMidLevelIP(String midLevelIP) {
		this.midLevelIP = midLevelIP;
	}

	
	@Transient
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
	
	

//	public String getExPropertyValue(String propertyName) {
//		String entityClassProperty = TermInfoService.exPropertyMap.get(propertyName);
//
//		Object value = ReflectionUtils.getFieldValue(this, entityClassProperty);
//		if (value == null)
//			return null;
//		return value.toString();
//	}
}
