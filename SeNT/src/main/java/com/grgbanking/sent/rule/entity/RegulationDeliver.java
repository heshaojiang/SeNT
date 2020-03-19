package com.grgbanking.sent.rule.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 规则下发表终端明细
 * 
 * @author 广电运通
 * @version 1.0
 */

@SuppressWarnings("serial")
@Entity
// @Table(name = "REGULATION_DELIVER")
@Table(name = "REGULATION_DELIVER")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class RegulationDeliver extends BaseEntity {
	// private String id;
	private String termid;
	private String role;
	private String version;
	private String date;
	private String status;
	private String applyId;
	// 规则类型
	private String type;
	// 规则下发时间
	private String deliverDate;

	// 备份撤销前的规则
	private String note;

	/**
	 * 备注
	 * @return note</br>
	 */
	@Column(name = "C_NOTE")
	public String getNote() {
		return note;
	}

	/**
	 * @param note   备注</br>        
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 下发时间
	 * @return deliverDate</br>
	 */
	@Column(name = "C_DELIVER_DATE")
	public String getDeliverDate() {
		return deliverDate;
	}

	/**
	 * @param deliverDate 下发时间</br>        
	 */
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}

	// public RegulationDeliver(String id, String termid, String role,
	// String version, String date) {
	// this.id = id;
	// this.termid = termid;
	// this.role = role;
	// this.version = version;
	// this.date = date;
	// }
	/**
	 * Constructor
	 */
	public RegulationDeliver() {

	}

	// @Id
	// @GeneratedValue(generator = "system-uuid")
	// @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	// @Column(name = "C_ID", unique = true, nullable = false)
	// public String getId() {
	// return id;
	// }
	//
	// public void setId(String id) {
	// this.id = id;
	// }
	/**
	 * ATM终端编号
	 * @return termid</br>
	 */
	@Column(name = "C_TERM_ID")
	public String getTermid() {
		return termid;
	}
	/**
	 * @param termid ATM终端编号</br>        
	 */
	public void setTermid(String termid) {
		this.termid = termid;
	}
	/**
	 * 规则
	 * @return role</br>
	 */
	@Column(name = "C_ROLE")
	public String getRole() {
		return role;
	}
	/**
	 * @param role 规则</br>        
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 版本号
	 * @return version</br>
	 */
	@Column(name = "C_VERSION")
	public String getVersion() {
		return version;
	}
	/**
	 * @param version 版本号</br>        
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 产生时间
	 * @return date</br>
	 */
	@Column(name = "C_DATE")
	public String getDate() {
		return date;
	}
	/**
	 * @param date 产生时间</br>        
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * 状态
	 * @return status</br>
	 */
	@Column(name = "C_REGU_STATUS")
	public String getStatus() {
		return status;
	}
	/**
	 * 规则申请号
	 * @return applyId</br>
	 */
	@Column(name = "C_APPLY_ID")
	public String getApplyId() {
		return applyId;
	}
	/**
	 * 规则类型
	 * @return type</br>
	 */
	@Column(name = "C_REG_TYPE")
	public String getType() {
		return type;
	}
	/**
	 * @param status 状态</br>        
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param applyId 规则申请号</br>        
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	/**
	 * @param type 规则类型</br>        
	 */
	public void setType(String type) {
		this.type = type;
	}

}
