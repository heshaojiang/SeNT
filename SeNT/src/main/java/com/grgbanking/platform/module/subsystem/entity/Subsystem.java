/**
 * 文件名：OperLog.java <br>
 * 包名：com.grgbanking.platform.module.log.entity <br>
 * 版本信息：V1.0  <br>
 * 日期：Jun 15, 2011  <br>
 * Copyright GRGBanking Corporation 2011<br>
 * 版权所有 GRGBanking
 *
 * Modification History: 
 * Date         Author      Description 
 * -----------  ---------   ---------------------------------------- 
 * Jun 15, 2011		VZ			Initial Create
 */

package com.grgbanking.platform.module.subsystem.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * sub system entiy<br>
 * 操作日志实体类
 * 
 * @author yt
 * 
 */
@Entity
@Table(name = "SYS_SUBSYSTEM")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class Subsystem extends BaseEntity {
	private String sysCode;
	private String sysName;
	private Character status;
	private String mainVersion;
	private String buildVersion;
	private String note;

	@Column(name = "C_SYS_CODE", length = 50)
	public String getSysCode() {
		return this.sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	@Column(name = "C_SYS_NAME", length = 200)
	public String getSysName() {
		return this.sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	@Column(name = "C_STATUS", length = 1)
	public Character getStatus() {
		return this.status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	@Column(name = "C_MAIN_VERSION", length = 50)
	public String getMainVersion() {
		return this.mainVersion;
	}

	public void setMainVersion(String mainVersion) {
		this.mainVersion = mainVersion;
	}

	@Column(name = "C_BUILD_VERSION", length = 20)
	public String getBuildVersion() {
		return this.buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	@Column(name = "C_NOTE", length = 200)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
