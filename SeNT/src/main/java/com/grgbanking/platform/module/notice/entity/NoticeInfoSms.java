/**
 * 文件名：NoticeInfoSms.java
 * 创建日期： 2012-4-23
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.entity;

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
// Table definition
@Table(name = "NOTICE_INFO_SMS")
public class NoticeInfoSms extends BaseEntity {
	private String noticeId;
	private String mobile;
	private Date sendTime;
	private String status;

	@Column(name = "C_NOTICE_ID", length = 32)
	public String getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	@Column(name = "C_MOBILE", length = 32)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "D_SEND_TIME")
	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "C_STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		NoticeInfoSms o2 = (NoticeInfoSms) obj;
		if(o2.getId().equals(this.getId()))
			return true;
		else
			return false;
	}
}
