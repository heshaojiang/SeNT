package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;
import java.math.BigInteger;


public class TranDetailInfo {

	public String tranDate;	//交易时间
	public String termId;	//终端号
	public String orgName;	//机构名称
	public String tranType;	//交易类型
	public String operatorCode;	//操作员
	public BigDecimal tranCount;	//冠字号数
	public BigDecimal getTranCount() {
		return tranCount;
	}
	public void setTranCount(BigDecimal tranCount) {
		this.tranCount = tranCount;
	}
	public BigDecimal tranAmount;	//交易金额
	public String operType;	//业务类型
	
	
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getTermId() {
		return termId;
	}
	public void setTermId(String termId) {
		this.termId= termId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public BigDecimal getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(BigDecimal tranAmount) {
		this.tranAmount = tranAmount;
	}
	
	
	
}
