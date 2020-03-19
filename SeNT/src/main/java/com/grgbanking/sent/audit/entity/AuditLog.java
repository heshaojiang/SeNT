package com.grgbanking.sent.audit.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;



/**
 * 审核日志信息
 * @author 广电运通
 * @version 1.0
 */

@SuppressWarnings("serial")
@Entity
// @Table(name = "AUDIT_LOG")
@Table(name = "AUDIT_LOG")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))

public class AuditLog extends BaseEntity {
	// private String id;
	private String applyId;
	private String userid;
	private String username;
	private Date applayDate;
	/**
	 * 申请时间
	 * @return Date
	 * */
	@Column(name = "D_APPLAY_DATE")
	public Date getApplayDate() {
		return applayDate;
	}
    /**
     * @param applayDate 申请时间
     * */
	public void setApplayDate(Date applayDate) {
		this.applayDate = applayDate;
	}
	
//	public Timestamp getApplayDate() {
//		return applayDate;
//	}
//
//	public void setApplayDate(Timestamp applayDate) {
//		this.applayDate = applayDate;
//	}
	private String orgid;
	private String applyType;
	private String applyStatus;
	private String applyResult;
	private String applyNote;

	// public AuditLog(String id, String applyId, String userid, String
	// username,
	// Date applayDate, String orgid, String applyType,
	// String applyStatus, String applyResult, String applyNote) {
	// this.id = id;
	// this.applyId = applyId;
	// this.userid = userid;
	// this.username = username;
	// this.applayDate = applayDate;
	// this.orgid = orgid;
	// this.applyType = applyType;
	// this.applyStatus = applyStatus;
	// this.applyResult = applyResult;
	// this.applyNote = applyNote;
	// }
	/**
	 * Constructors for unUsedField
	 * **/
	public AuditLog() {
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
	 * 申请编号
	 * @return applyId              
	 */
	@Column(name = "C_APPLY_ID")
	public String getApplyId() {
		return applyId;
	}

	/**
	 * @param applyId 申请编号
	 *            
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	/**
	 * 审批人ID
	 * @return userid 			
	 */

	@Column(name = "C_USERID")
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid 审批人id           
	 */

	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 
	 * @return  username        
	 */
	@Column(name = "C_USERNAME")
	public String getUsername() {
		return username;
	}

	 /**
	  * 
	  */
	public void setUsername(String username) {
		this.username = username;
	}
// 
//	 /**
//	  * 审批时间
//	  * @return applayDate      
//	  */
//	@Column(name = "D_APPLAY_DATE")
//	public Date getApplayDate() {
//		return applayDate;
//	}
// 
//	 /**
//	  * @param applayDate  审批时间     
//	  */
//	public void setApplayDate(Date applayDate) {
//		this.applayDate = applayDate;
//	}

	 /**
	  * 机构
	  * @return orgid
	  */
	@Column(name = "C_ORGID")
	public String getOrgid() {
		return orgid;
	}
	/**
	 * @param orgid 机构          
	 */

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	/**
	 * 申请类型
	 * @return applyType
	 */

	@Column(name = "C_APPLY_TYPE")
	public String getApplyType() {
		return applyType;
	}
     /**
      * @param applyType 申请类型        
      */ 
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
 
	/**
	 * 
	 */ 
	@Column(name = "C_APPLY_STATUS")
	public String getApplyStatus() {
		return applyStatus;
	}
	/**
	 * 
	 */
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	/**
	 * 审批结果
	 * @return applyResult
	 */

	@Column(name = "C_APPLY_RESULT")
	public String getApplyResult() {
		return applyResult;
	}
    /**
     * @param applyResult 审批结果
     */
	public void setApplyResult(String applyResult) {
		this.applyResult = applyResult;
	}
	/**
	 * 审批说明
	 * @return applyNote       
	 */
  
	@Column(name = "C_APPLY_NOTE")
	public String getApplyNote() {
		return applyNote;
	}
    /**
     * @param applyNote 审批说明
     */
	public void setApplyNote(String applyNote) {
		this.applyNote = applyNote;
	}
}
