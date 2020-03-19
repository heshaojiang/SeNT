/**
 * 文件名：NoticeInfo.java
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
@Table(name = "NOTICE_INFO")
public class NoticeInfo extends BaseEntity {

	private String noticeType;
	private String title;
	private String content;
	private String sender;
	private Date sendTime;
	private String recipient;
	private String status;
	private String noticeMethod;

	private String note;
	private String dispatchId;
	private String email;
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "C_CREATE_TIME")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the noticeMethod
	 */
	@Column(name = "C_NOTICE_METHOD")
	public String getNoticeMethod() {
		return noticeMethod;
	}

	/**
	 * @param noticeMethod
	 *            the noticeMethod to set
	 */
	public void setNoticeMethod(String noticeMethod) {
		this.noticeMethod = noticeMethod;
	}

	/**
	 * @return the noticeType
	 */
	@Column(name = "C_NOTICE_TYPE")
	public String getNoticeType() {
		return noticeType;
	}

	/**
	 * @param noticeType
	 *            the noticeType to set
	 */
	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	@Column(name = "C_TITLE", length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "C_CONTENT", length = 1000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "C_SENDER", length = 100)
	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "D_SEND_TIME")
	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "C_RECIPIENT", length = 2000)
	public String getRecipient() {
		return this.recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	@Column(name = "C_STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "C_NOTE", length = 200)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "C_DISPATCH_ID", length = 32)
	public String getDispatchId() {
		return this.dispatchId;
	}

	public void setDispatchId(String dispatchId) {
		this.dispatchId = dispatchId;
	}

	@Column(name = "C_EMAIL", length = 2000)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
