/**
 * 文件名：BankBranceInventoryList.java
 * 创建日期： 2014-09-26
 * Copyright (c)  广电运通
 * All rights reserved.
 */
package com.grgbanking.sent.transmgr.entity;

public class CmlInfoByHandList {
	/** ID */
	private String id;
	/** 币种 */
	private String currency;
	/** 100元张数 */
	private String hundredCount;
	/** 50元张数 */
	private String fiftyCount;
	/** 20元张数 */
	private String twentyCount;
	/** 10元张数 */
	private String tenCount;
	/** 5元张数 */
	private String fiveCount;
	/** 1元张数 */
	private String oneCount;
	/** 操作人*/
	private String tdOperator;
	/** 数据权限控制 */
	private String pathCode;
	/** 交易时间 */
	private String tranTime;
	/** 交易类型 */
	private String tranType;
	/** 机构名称 */
	private String orgName;
	/** 机构Id */
	private String orgid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getHundredCount() {
		return hundredCount;
	}
	public void setHundredCount(String hundredCount) {
		this.hundredCount = hundredCount;
	}
	public String getFiftyCount() {
		return fiftyCount;
	}
	public void setFiftyCount(String fiftyCount) {
		this.fiftyCount = fiftyCount;
	}
	public String getTwentyCount() {
		return twentyCount;
	}
	public void setTwentyCount(String twentyCount) {
		this.twentyCount = twentyCount;
	}
	public String getTenCount() {
		return tenCount;
	}
	public void setTenCount(String tenCount) {
		this.tenCount = tenCount;
	}
	public String getFiveCount() {
		return fiveCount;
	}
	public void setFiveCount(String fiveCount) {
		this.fiveCount = fiveCount;
	}
	public String getOneCount() {
		return oneCount;
	}
	public void setOneCount(String oneCount) {
		this.oneCount = oneCount;
	}
	public String getTdOperator() {
		return tdOperator;
	}
	public void setTdOperator(String tdOperator) {
		this.tdOperator = tdOperator;
	}
	public String getPathCode() {
		return pathCode;
	}
	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	

}
