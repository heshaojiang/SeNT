package com.grgbanking.platform.module.term.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;

@Entity
//Table definition
@Table(name = "NODER_FILE")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class NoderFile extends BaseEntity {
	
	/** 表名 */
	public static final String TABLE_NAME = "NODER_FILE";
	
	private String noderId ;
	
	private String orgCode ;
	
	private String fileType ;
	
	private String tranData ;
	
	private Date operDate;
	
	private String fileName ;
	
	private String status;
	
	private String midLevelIp ;

	@Column(name="C_NODERID")
	public String getNoderId() {
		return noderId;
	}

	public void setNoderId(String noderId) {
		this.noderId = noderId;
	}

	@Column(name="C_ORGCODE")
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name="C_FILETYPE")
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Column(name="C_TRAN_DATA")
	public String getTranData() {
		return tranData;
	}

	public void setTranData(String tranData) {
		this.tranData = tranData;
	}

	@Column(name="D_OPERDATE")
	public Date getOperDate() {
		return operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	@Column(name="C_FILENAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="C_STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="C_MIDLEVEL_IP")
	public String getMidLevelIp() {
		return midLevelIp;
	}

	public void setMidLevelIp(String midLevelIp) {
		this.midLevelIp = midLevelIp;
	}
	
	

}
