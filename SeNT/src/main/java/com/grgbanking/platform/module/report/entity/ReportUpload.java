/**
 * 文件名：ReportParam.java
 * 创建日期： 2012-5-29
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.report.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * @author yrliang
 * 
 */
@Entity
@Table(name = "REPORT_UPLOAD")
public class ReportUpload extends BaseEntity {
	private String reportId;
	private Date uploadtime;
	private String uploader;
	private String uploadfile;

	@Column(name = "C_REPORT_ID", length = 32)
	public String getReportId() {
		return this.reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "D_UPLOADTIME", length = 7)
	public Date getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	@Column(name = "C_UPLOADER", length = 20)
	public String getUploader() {
		return this.uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	@Column(name = "C_UPLOADFILE", length = 200)
	public String getUploadfile() {
		return this.uploadfile;
	}

	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}
}
