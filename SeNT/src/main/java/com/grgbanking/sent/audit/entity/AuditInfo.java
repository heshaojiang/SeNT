package com.grgbanking.sent.audit.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 审核流程
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
// @Table(name = "AUDIT_INFO")
@Table(name = "AUDIT_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class AuditInfo extends BaseEntity {
	private String auditStatus;
	private String orgId;
	private String applyName;
	private String applayDate;
	private String applytyp;
	// private String id;
	private String applyId;

	// public AuditInfo(String auditStatus, String orgId, String applyName,
	// String applayDate, String applytyp, String id, String applyId) {
	// this.auditStatus = auditStatus;
	// this.orgId = orgId;
	// this.applyName = applyName;
	// this.applayDate = applayDate;
	// this.applytyp = applytyp;
	// this.id = id;
	// this.applyId = applyId;
	// }

	

	/**
	 * Constructors for unUsedField
	 */
	public AuditInfo() {

	}

	/**
	 * 审核状态
	 * @return auditStatus
	 */
	@Column(name = "C_AUDIT_STATUS")
	public String getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @param auditStatus 审核状态         
	 */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * 申请机构
	 * @return orgId 
	 **/
	@Column(name = "C_ORG_ID")
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId 申请机构          
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * 	申请人
	 *	@return applyName
	 */

	@Column(name = "C_APPLY_NAME")
	public String getApplyName() {
		return applyName;
	}

	/**
	 * @param applyName 申请人          
	 */

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	/**
	 * 申请时间
	 * @return applyDate
	 */
	@Column(name = "C_APPLAY_DATE")
	public String getApplayDate() {
		return applayDate;
	}

	/**
	 * @param applayDate 申请时间
	 */
	public void setApplayDate(String applayDate) {
		this.applayDate = applayDate;
	}

	/**
	 * 申请类型
	 * @return applytyp             
	 */
	@Column(name = "C_APPLYTYP")
	public String getApplytyp() {
		return applytyp;
	}

	/**
	 * @param applytyp 申请类型
	 */
	public void setApplytyp(String applytyp) {
		this.applytyp = applytyp;
	}

	

	/**
	 * 申请编号
	 * @return applyId 
	 */
	
	@Column(name = "C_APPLY_ID")
	public String getApplyId() {
		return applyId;
	}

	/**
	 * @param applyId 申请编号
	 */

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
}
