package com.grgbanking.sent.rule.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;


/**
 * 黑名单规则下发表记录
 * @author 广电运通
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "RULE_BLACKLIST_DELIVER")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class BlackRegulationDeliver extends BaseEntity {
	private String termId;
	private String ruleVersion;
	private int status;
	private Date createDate;
	private String operatorId;
	private Date deliverDate;

	/**
	 * ATM终端编号
	 */
	@Column(name = "C_TERM_ID")
	public String getTermId() {
		return termId;
	}
	/**
	 * ATM终端编号
	 */
	public void setTermId(String termId) {
		this.termId = termId;
	}
	
	/**
	 * 规则版本
	 */
	@Column(name = "C_RULE_VERSION")
	public String getRuleVersion() {
		return ruleVersion;
	}
	/**
	 * 规则版本
	 */
	public void setRuleVersion(String ruleVersion) {
		this.ruleVersion = ruleVersion;
	}
	
	/**
	 * 下发状态
	 */
	@Column(name = "I_STATUS")
	public int getStatus() {
		return status;
	}
	/**
	 * 下发状态
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * 创建时间
	 */
	@Column(name = "D_CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * 业务人员
	 */
	@Column(name = "C_OPERATOR_NO")
	public String getOperatorId() {
		return operatorId;
	}
	/**
	 * 业务人员
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	
	/**
	 * 下发时间
	 */
	@Column(name = "D_DELIVER_DATE")
	public Date getDeliverDate() {
		return deliverDate;
	}
	/**
	 * 下发时间
	 */
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	
}
