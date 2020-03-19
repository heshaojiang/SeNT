package com.grgbanking.sent.audit.entity;

import java.util.Date;


/**
 * @author yt
 *
 */

public class AuditLogDetail {

	private String id;

	private int repeatnum;
	private String reguStatus;
	private String regulation;
	private String username;
	private Date applayDate;
	private String orgid;
	private String applyType;
	private String applyStatus;
	private String createname;
	private String applyNote;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the repeatnum
	 */
	public int getRepeatnum() {
		return repeatnum;
	}
	/**
	 * @param repeatnum the repeatnum to set
	 */
	public void setRepeatnum(int repeatnum) {
		this.repeatnum = repeatnum;
	}
	/**
	 * @return the reguStatus
	 */
	public String getReguStatus() {
		return reguStatus;
	}
	/**
	 * @param reguStatus the reguStatus to set
	 */
	public void setReguStatus(String reguStatus) {
		this.reguStatus = reguStatus;
	}
	/**
	 * @return the regulation
	 */
	public String getRegulation() {
		return regulation;
	}
	/**
	 * @param regulation the regulation to set
	 */
	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the applayDate
	 */
	public Date getApplayDate() {
		return applayDate;
	}
	/**
	 * @param applayDate the applayDate to set
	 */
	public void setApplayDate(Date applayDate) {
		this.applayDate = applayDate;
	}
	/**
	 * @return the orgid
	 */
	public String getOrgid() {
		return orgid;
	}
	/**
	 * @param orgid the orgid to set
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	/**
	 * @return the applyType
	 */
	public String getApplyType() {
		return applyType;
	}
	/**
	 * @param applyType the applyType to set
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	/**
	 * @return the applyStatus
	 */
	public String getApplyStatus() {
		return applyStatus;
	}
	/**
	 * @param applyStatus the applyStatus to set
	 */
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	/**
	 * return the createname
	 */
	public String getCreatename() {
		return createname;
	}
	/**
	 * @param createname
	 */
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	/**
	 * return 审核批注
	 */
	public String getApplyNote() {
		return applyNote;
	}
	/**
	 * @param applyNote 审核批注
	 */
	public void setApplyNote(String applyNote) {
		this.applyNote = applyNote;
	}


}
