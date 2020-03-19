
package com.grgbanking.sent.stride.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.core.entity.BaseEntity;


@Entity
@Table(name = "cml_stride_import_records")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class StrideImportRecords extends BaseEntity {

										
	/* cOperateStatus */
	private String operateStatus;
					
	/* cOperaterId */
	private String operaterId;
					
	/* cBagCode */
	private String bagCode;
					
	/* cUploadTime */
	private String uploadTime;
					
	/* iParentId */
	private String parentId;
					
	/* iFsnCount */
	private int fsnCount;
					
	/* iBagCount */
	private Integer bagCount;
					
	/* cPathcode */
	private String pathcode;
	
	private String fileName;
	
	private String partMonthday;
	
	private String bankCode;//报送银行
	private String fromCode;//生成网点
	
	//非数据库对应
	private String orgId;
	
	private List<StrideImportRecords> children = null;
	private String orgName;
	
	@Column(name = "C_OPERATE_STATUS")
	public String getOperateStatus() {
		return operateStatus;
	}

	public void setOperateStatus(String operateStatus) {
		this.operateStatus = operateStatus;
	}
	@Column(name = "C_OPERATER_ID")
	public String getOperaterId() {
		return operaterId;
	}

	public void setOperaterId(String operaterId) {
		this.operaterId = operaterId;
	}
	@Column(name = "C_BAG_CODE")
	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}
	@Column(name = "C_UPLOAD_TIME")
	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	@Column(name = "C_PARENT_ID")
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Column(name = "I_FSN_COUNT")
	public int getFsnCount() {
		return fsnCount;
	}

	public void setFsnCount(int fsnCount) {
		this.fsnCount += fsnCount;
	}
	@Column(name = "I_BAG_COUNT")
	public Integer getBagCount() {
		return bagCount;
	}

	public void setBagCount(Integer bagCount) {
		this.bagCount = bagCount;
	}
	@Column(name = "C_PATHCODE")
	public String getPathcode() {
		return pathcode;
	}

	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}
	@Column(name = "C_PART_MONTHDAY")
	public String getPartMonthday() {
		return partMonthday;
	}
	public void setPartMonthday(String partMonthday) {
		this.partMonthday = partMonthday;
	}
	
	@Column(name="C_FILE_NAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Transient
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	@Transient
	public List<StrideImportRecords> getChildren() {
		return children;
	}

	public void setChildren(List<StrideImportRecords> children) {
		this.children = children;
	}
	@Transient
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Transient
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	@Transient
	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}
	
			
	
												
			
	

	
	

}
