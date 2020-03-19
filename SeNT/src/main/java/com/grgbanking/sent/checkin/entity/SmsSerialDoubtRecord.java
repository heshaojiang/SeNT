package com.grgbanking.sent.checkin.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name="SMS_SERIAL_DOUBT_RECORD")
@AttributeOverride(name="id", column=@Column(name="C_ID"))
public class SmsSerialDoubtRecord extends BaseEntity {

	private String orgCode;	//机构号
	private String orgName;	//机构名
	private String orgPathCode;	//机构权限
	private String operatorId;	//登录人ID
	private String checkId;	//复核人
	private String applyName;	//申请人姓名
	private String applyPhone;	//申请人电话
	private Date applyDate;	//申请日期
	private String seriaNO;	//冠字号码
	private int serialCount;	//冠字查询数量
	private int serialResult;	//冠字查询结果
	private int identType;	//证明资料类型
	private String identNO;	//证明资料号码
	private Date depositDate;	//取款日期
	private String depositBank;	//取款行

	private String noteType;	//钞票类别
	private String notePayType;	//支付渠道
	
	private String counterPosition;		//柜面位置
	private String address;				//地址
	private int applyType;				//申请类型
	private String applyCardType;		//申请人有效证件类型
	private String applyCardNo;			//申请人有效证件号码
//	private String agentName;			//代理申请人姓名
//	private String agentPhone;			//代理申请人电话
//	private String agentCardType;		//代理申请人有效证件类型
//	private String agentCardNo;			//代理申请人有效证件号码
	private int registionType;		//登记类型
	
	@Column(name="C_ORG_CODE")
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	@Column(name="C_ORG_NAME")
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Column(name="C_ORG_PATHCODE")
	public String getOrgPathCode() {
		return orgPathCode;
	}
	public void setOrgPathCode(String orgPathCode) {
		this.orgPathCode = orgPathCode;
	}
	@Column(name="C_OPERATOR_ID")
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	@Column(name="C_CHECK_ID")
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	@Column(name="C_APPLY_NAME")
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	@Column(name="C_APPLY_PHONE")
	public String getApplyPhone() {
		return applyPhone;
	}
	public void setApplyPhone(String applyPhone) {
		this.applyPhone = applyPhone;
	}
	@Column(name="D_APPLY_DATE")
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	@Column(name="C_SERIA_NO")
	public String getSeriaNO() {
		return seriaNO;
	}
	public void setSeriaNO(String seriaNO) {
		this.seriaNO = seriaNO;
	}
	@Column(name="I_SERIAL_COUNT")
	public int getSerialCount() {
		return serialCount;
	}
	public void setSerialCount(int serialCount) {
		this.serialCount = serialCount;
	}
	@Column(name="I_SERIAL_RESULT")
	public int getSerialResult() {
		return serialResult;
	}
	public void setSerialResult(int serialResult) {
		this.serialResult = serialResult;
	}
	@Column(name="I_IDENT_TYPE")
	public int getIdentType() {
		return identType;
	}
	public void setIdentType(int identType) {
		this.identType = identType;
	}
	@Column(name="C_IDENT_NO")
	public String getIdentNO() {
		return identNO;
	}
	public void setIdentNO(String identNO) {
		this.identNO = identNO;
	}
	@Column(name="C_DEPOSIT_DATE")
	public Date getDepositDate() {
		return depositDate;
	}
	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}
	@Column(name="C_DEPOSIT_BANK")
	public String getDepositBank() {
		return depositBank;
	}
	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}
	@Column(name="C_NOTE_TYPE")
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	@Column(name="I_NOTE_PAYTYPE")
	public String getNotePayType() {
		return notePayType;
	}
	public void setNotePayType(String notePayType) {
		this.notePayType = notePayType;
	}
	
	@Column(name="C_COUNTER_POSITION")
	public String getCounterPosition() {
		return counterPosition;
	}
	public void setCounterPosition(String counterPosition) {
		this.counterPosition = counterPosition;
	}
	
	@Column(name="C_ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="I_APPLY_TYPE")
	public int getApplyType() {
		return applyType;
	}
	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}
	
	@Column(name="C_APPLY_CARDTYPE")
	public String getApplyCardType() {
		return applyCardType;
	}
	public void setApplyCardType(String applyCardType) {
		this.applyCardType = applyCardType;
	}
	
	@Column(name="C_APPLY_CARDNO")
	public String getApplyCardNo() {
		return applyCardNo;
	}
	public void setApplyCardNo(String applyCardNo) {
		this.applyCardNo = applyCardNo;
	}
	
	/*@Column(name="C_AGENT_NAME")
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
	@Column(name="C_AGENT_PHONE")
	public String getAgentPhone() {
		return agentPhone;
	}
	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}
	
	@Column(name="C_AGENT_CARDTYPE")
	public String getAgentCardType() {
		return agentCardType;
	}
	public void setAgentCardType(String agentCardType) {
		this.agentCardType = agentCardType;
	}
	
	@Column(name="C_AGENT_CARDNO")
	public String getAgentCardNo() {
		return agentCardNo;
	}
	public void setAgentCardNo(String agentCardNo) {
		this.agentCardNo = agentCardNo;
	}*/
	
	@Column(name="I_REGISTRATION_TYPE")
	public int getRegistionType() {
		return registionType;
	}
	public void setRegistionType(int registionType) {
		this.registionType = registionType;
	}
	
}
