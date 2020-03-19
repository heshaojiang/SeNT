package com.grgbanking.platform.module.term.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * @file com.grgbanking.platform.module.term.entity.TmlDataBackup.java
 * @Description: 
 * @version 1.0
 * @author Norman_chang
 * @since 2014-6-18 上午10:00:13
*/
@Entity
// Table definition
@Table(name = "TML_DATA_BACKUP")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class TmlDataBackup extends BaseEntity {

	private String path;
	
	private String createDate;
	
	private String comm;

	@Column(name = "C_PATH")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Column(name = "C_CREATE_DATE")
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Column(name = "C_COMM")
	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}
}
