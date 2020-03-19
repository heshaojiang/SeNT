/**
 * 文件名：AuditBlackDetail.java
 * 创建日期： 2014-7-8
 * Copyright (c) 2014 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间：
 *   修改人：
 *   生成版本：
 *   修改内容：
*/
package com.grgbanking.sent.audit.entity;

import java.util.Date;

/**
 * @author hjyi
 *
 */
public class AuditBlackDetail {
	
	private String id;
	private String applyId;
	private String applyOrgName;
	private String regulation;
	private Date applyDate;
	private int ruleStatus;
	
	/**
	 * 
	 */
	public String getId() {
		return id;
	}
	/**
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 */
	public String getApplyId() {
		return applyId;
	}
	/**
	 * 
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	/**
	 * 
	 */
	public String getApplyOrgName() {
		return applyOrgName;
	}
	/**
	 * 
	 */
	public void setApplyOrgName(String applyOrgName) {
		this.applyOrgName = applyOrgName;
	}
	/**
	 * 
	 */
	public String getRegulation() {
		return regulation;
	}
	/**
	 * 
	 */
	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}
	/**
	 * 
	 */
	public Date getApplyDate() {
		return applyDate;
	}
	/**
	 * 
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	/**
	 * 
	 */
	public int getRuleStatus() {
		return ruleStatus;
	}
	/**
	 * 
	 */
	public void setRuleStatus(int ruleStatus) {
		this.ruleStatus = ruleStatus;
	}
	
}
