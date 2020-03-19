/**
 * 文件名：NoticeSitemsg.java
 * 创建日期： 2012-4-28
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
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * @author yrliang
 * 
 */
@Entity
@Table(name = "NOTICE_SITEMSG")
public class NoticeSitemsg extends BaseEntity {
	private String noticeId;
	private String content;
	private String sender; // 发送者id
	private String senderName; // 发送者名称，瞬态属性

	private Date publishTime;
	private Date createTime;

	/* 发件人删除标记 */
	private Character deleteTag;
	private Character status;

	/* 用户发现时暂存收件人，瞬态属性 */
	private String[] userIds;

	/* 阅读时间，用于接受列表显示，瞬态属性 */
	private Date readTime;

	/* 接收人名称，用逗号隔开名字，用于发送列表显示，瞬态属性 */
	private String recipient;

	public NoticeSitemsg() {

	}

	/*
	 * 收到的消息构造函数
	 */
	public NoticeSitemsg(String id, String content, Date publishTime) {
		this.setId(id);
		this.content = content;
		this.publishTime = publishTime;
	}

	/*
	 * 收到的消息构造函数
	 */
	public NoticeSitemsg(String id, String content, String sender, Date publishTime, String senderName, Date readTime) {
		this.setId(id);
		this.content = content;
		this.sender = sender;
		this.publishTime = publishTime;

		this.senderName = senderName;
		this.readTime = readTime;
	}

	/**
	 * @return the recipient
	 */
	@Transient
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient
	 *            the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * @return the senderName
	 */
	@Transient
	public String getSenderName() {
		return senderName;
	}

	/**
	 * @param senderName
	 *            the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * 
	 * @return the readTime
	 */
	@Transient
	public Date getReadTime() {
		return readTime;
	}

	/**
	 * @param readTime
	 *            the readTime to set
	 */
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

	/**
	 * @return the userIds
	 */
	@Transient
	public String[] getUserIds() {
		return userIds;
	}

	/**
	 * @param userIds
	 *            the userIds to set
	 */
	public void setUserIds(String[] userIds) {
		this.userIds = userIds;
	}

	/**
	 * @return the createTime
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "D_CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "C_NOTICE_ID", length = 32)
	public String getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	@Column(name = "C_CONTENT", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "C_SENDER", length = 50)
	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "D_PUBLISH_TIME")
	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "C_DELETE_TAG", length = 1)
	public Character getDeleteTag() {
		return this.deleteTag;
	}

	public void setDeleteTag(Character deleteTag) {
		this.deleteTag = deleteTag;
	}

	@Column(name = "C_STATUS", length = 1)
	public Character getStatus() {
		return this.status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}
}
