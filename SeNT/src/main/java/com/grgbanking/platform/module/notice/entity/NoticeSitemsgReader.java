/**
 * 文件名：NoticeSitemsgReader.java
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
@Table(name = "NOTICE_SITEMSG_READER")
public class NoticeSitemsgReader extends BaseEntity {
	private String sitemsgId;
	private String readerId;
	private Date readTime;

	private String readerName; // 瞬态属性：阅读者名字

	public NoticeSitemsgReader() {

	}

	public NoticeSitemsgReader(String id, String sitemsgId, String readerId, Date readTime, String readerName) {
		this.setId(id);
		this.sitemsgId = sitemsgId;
		this.readerId = readerId;
		this.readTime = readTime;

		this.readerName = readerName;
	}

	/**
	 * @return the readerName
	 */
	@Transient
	public String getReaderName() {
		return readerName;
	}

	/**
	 * @param readerName
	 *            the readerName to set
	 */
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	@Column(name = "C_SITEMSG_ID", length = 32)
	public String getSitemsgId() {
		return this.sitemsgId;
	}

	public void setSitemsgId(String sitemsgId) {
		this.sitemsgId = sitemsgId;
	}

	@Column(name = "C_READER_ID", length = 32)
	public String getReaderId() {
		return this.readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "D_READ_TIME")
	public Date getReadTime() {
		return this.readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
}
