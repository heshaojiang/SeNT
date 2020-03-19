package com.grgbanking.sent.rule.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;


/**
 * 黑名单规则
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "RULE_BLACKLIST")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class BlackRegulation extends BaseEntity {
	// private String id;
	private String applyId;
	private String applyOrgId;
	private Date applyDate;
	private Integer ruleType;
	private Integer ruleStatus;
	private String noteType;
	private String denomination;
	private String regulation;
	private Date auditDate;
	private String auditId;
	private String rejectReason;
	/**
	 * 申请人
	 */
	@Column(name = "C_APPLY_ID")
	public String getApplyId() {
		return applyId;
	}
	/**
	 * 申请人
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	/**
	 * 申请机构
	 */
	@Column(name = "C_APPLY_ORGID")
	public String getApplyOrgId() {
		return applyOrgId;
	}
	/**
	 * 申请机构
	 */
	public void setApplyOrgId(String applyOrgId) {
		this.applyOrgId = applyOrgId;
	}
	/**
	 * 申请时间
	 */
	@Column(name = "D_APPLY_DATE")
	public Date getApplyDate() {
		return applyDate;
	}
	/**
	 * 申请时间
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	/**
	 * 规则类型
	 */
	@Column(name = "I_RULE_TYPE")
	public Integer getRuleType() {
		return ruleType;
	}
	/**
	 * 规则类型
	 */
	public void setRuleType(Integer ruleType) {
		this.ruleType = ruleType;
	}
	/**
	 * 规则状态
	 */
	@Column(name = "I_RULE_STATUS")
	public Integer getRuleStatus() {
		return ruleStatus;
	}
	/**
	 * 规则状态
	 */
	public void setRuleStatus(Integer ruleStatus) {
		this.ruleStatus = ruleStatus;
	}
	/**
	 * 币种
	 */
	@Column(name = "C_NOTE_TYPE")
	public String getNoteType() {
		return noteType;
	}
	/**
	 * 币种
	 */
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	/**
	 * 面额
	 */
	@Column(name = "C_DENOMINATION")
	public String getDenomination() {
		return denomination;
	}
	/**
	 * 面额
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	/**
	 * 规则号码
	 */
	@Column(name = "C_SERIAL_NO")
	public String getRegulation() {
		return regulation;
	}
	/**
	 * 规则号码
	 */
	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}
	/**
	 * 审核时间
	 */
	@Column(name = "D_AUDIT_DATE")
	public Date getAuditDate() {
		return auditDate;
	}
	/**
	 * 审核时间
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	/**
	 * 审核人员
	 */
	@Column(name = "C_AUDIT_ID")
	public String getAuditId() {
		return auditId;
	}
	/**
	 * 审核人员
	 */
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	/**
	 * 拒审原因
	 */
	@Column(name = "C_REJECT_REASON")
	public String getRejectReason() {
		return rejectReason;
	}
	/**
	 * 拒审原因
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
}
