package com.grgbanking.cml.report.entity;


import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;
/**
 * ��ֽ�����Ϣ
 * @author �����ͨ
 * @version 1.0
 * **/

@SuppressWarnings("serial")
@Entity
@Table(name = "CML_REPORT")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class CmlReport extends BaseEntity {
	private String connId;
	private String transResult;
	private String orgId;
	private String tmlNum;
	private String sourceOrg;
	private String boxNum;
	private String barInfo;
	private float beforeCount;
	private Date bindStart;
	private Date bindEnd;
	private String operatorId;
	private String journalNo;
	private String taskNum;
	private float totalMoney;
	private String rotoCashType;
	private float atmMoney;
	private float passMoney;
	private float stubbedMoney;
	private float shadinessMoney;
	private float trailMoney;
	private float falseCoinMoney;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private Date operateDate;
	private String memo;
	private float version05;
	private float version99;
	@Column(name = "C_CONN_ID")
	public String getConnId() {
		return connId;
	}
	public void setConnId(String connId) {
		this.connId = connId;
	}
	@Column(name = "C_TRANS_RESULT")
	public String getTransResult() {
		return transResult;
	}
	public void setTransResult(String transResult) {
		this.transResult = transResult;
	}
	@Column(name = "C_ORG_ID")
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	@Column(name = "C_TML_NUM")
	public String getTmlNum() {
		return tmlNum;
	}
	public void setTmlNum(String tmlNum) {
		this.tmlNum = tmlNum;
	}
	@Column(name = "C_SOURCE_ORG")
	public String getSourceOrg() {
		return sourceOrg;
	}
	public void setSourceOrg(String sourceOrg) {
		this.sourceOrg = sourceOrg;
	}
	@Column(name = "C_BOX_NUM")
	public String getBoxNum() {
		return boxNum;
	}
	public void setBoxNum(String boxNum) {
		this.boxNum = boxNum;
	}
	@Column(name = "C_BAR_INFO")
	public String getBarInfo() {
		return barInfo;
	}
	public void setBarInfo(String barInfo) {
		this.barInfo = barInfo;
	}
//	@Column(name = "I_BEFORE_COUNT")
//	public float getBeforeCount() {
//		return beforeCount;
//	}
//	public void setBeforeCount(float beforeCount) {
//		this.beforeCount = beforeCount;
//	}
	@Column(name = "D_BIND_START")
	public Date getBindStart() {
		return bindStart;
	}
	public void setBindStart(Date bindStart) {
		this.bindStart = bindStart;
	}
	@Column(name = "D_BIND_END")
	public Date getBindEnd() {
		return bindEnd;
	}
	public void setBindEnd(Date bindEnd) {
		this.bindEnd = bindEnd;
	}
	@Column(name = "C_OPERATOR_ID")
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo() {
		return journalNo;
	}
	public void setJournalNo(String journalNo) {
		this.journalNo = journalNo;
	}
	@Column(name = "C_TASK_NUM")
	public String getTaskNum() {
		return taskNum;
	}
	public void setTaskNum(String taskNum) {
		this.taskNum = taskNum;
	}
	@Column(name = "I_TATAL_MONEY")
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	@Column(name = "C_ROTOCASH_TYPE")
	public String getRotoCashType() {
		return rotoCashType;
	}
	public void setRotoCashType(String rotoCashType) {
		this.rotoCashType = rotoCashType;
	}
	@Column(name = "I_ATM_MONEY")
	public float getAtmMoney() {
		return atmMoney;
	}
	public void setAtmMoney(float atmMoney) {
		this.atmMoney = atmMoney;
	}
	@Column(name = "I_PASS_MONEY")
	public float getPassMoney() {
		return passMoney;
	}

	public void setPassMoney(float passMoney) {
		this.passMoney = passMoney;
	}
	@Column(name = "I_STUBBED_MONEY")
	public float getStubbedMoney() {
		return stubbedMoney;
	}
	public void setStubbedMoney(float stubbedMoney) {
		this.stubbedMoney = stubbedMoney;
	}
	@Column(name = "I_SHADINESS_MONEY")
	public float getShadinessMoney() {
		return shadinessMoney;
	}
	public void setShadinessMoney(float shadinessMoney) {
		this.shadinessMoney = shadinessMoney;
	}
	@Column(name = "I_TRAIL_MONEY")
	public float getTrailMoney() {
		return trailMoney;
	}
	public void setTrailMoney(float trailMoney) {
		this.trailMoney = trailMoney;
	}
	@Column(name = "I_FALSECOIN_MONEY")
	public float getFalseCoinMoney() {
		return falseCoinMoney;
	}
	public void setFalseCoinMoney(float falseCoinMoney) {
		this.falseCoinMoney = falseCoinMoney;
	}
	@Column(name = "C_RESERVE1")
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	@Column(name = "C_RESERVE2")
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	@Column(name = "C_RESERVE3")
	public String getReserve3() {
		return reserve3;
	}
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	@Column(name = "D_OPERATE_DATE")
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	@Column(name = "C_MEMO")
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Column(name = "I_VERSION05")

	public float getVersion05() {
		return version05;
	}
	public void setVersion05(float version05) {
		this.version05 = version05;
	}
	
	@Column(name = "I_VERSION99")
	public float getVersion99() {
		return version99;
	}
	public void setVersion99(float version99) {
		this.version99 = version99;
	}
	@Column(name = "i_before_count")
	public float getBeforeCount() {
		return beforeCount;
	}
	public void setBeforeCount(float beforeCount) {
		this.beforeCount = beforeCount;
	}
	@Override
	public String toString() {
		return "CmlReport [atmMoney=" + atmMoney + ", barInfo=" + barInfo
				+ ", beforeCount=" + beforeCount + ", bindEnd=" + bindEnd
				+ ", bindStart=" + bindStart + ", boxNum=" + boxNum
				+ ", connId=" + connId + ", falseCoinMoney=" + falseCoinMoney
				+ ", journalNo=" + journalNo + ", memo=" + memo
				+ ", operateDate=" + operateDate + ", operatorId=" + operatorId
				+ ", orgId=" + orgId + ", passMoney=" + passMoney
				+ ", reserve1=" + reserve1 + ", reserve2=" + reserve2
				+ ", reserve3=" + reserve3 + ", rotoCashType=" + rotoCashType
				+ ", shadinessMoney=" + shadinessMoney + ", sourceOrg="
				+ sourceOrg + ", stubbedMoney=" + stubbedMoney + ", taskNum="
				+ taskNum + ", tmlNum=" + tmlNum + ", totalMoney=" + totalMoney
				+ ", trailMoney=" + trailMoney + ", transResult=" + transResult
				+ ", version05=" + version05 + ", version99=" + version99 + "]";
	}
	
}
