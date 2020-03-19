package com.grgbanking.sent.checkin.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name="FAULT_INFO_CHECKIN")
@AttributeOverride(name="id", column=@Column(name="C_ID"))
public class FaultInfoCheckIn extends BaseEntity
{
	
	private String orgCode;
	private String orgName;
	private String orgPathCode;
	private String recorderCode;
	private String applyDate;
	private String querySeriaNo;
	private String queryResult;
	private String clientName;
	private String clientPhone;
	private String agentName;
	private String agentPhone;
	private Integer certificateType;
	private String certificateTypeOthers;
	private String certificateNo;
	private String withdrawalDate;
	private String withdrawalBank;
	private Integer withdrawalType;
	private String withdrawalBranchName;
	private String withdrawalWindow;
	private Integer atmType;
	private String atmAddress;
	
	//-----------------------------
	
	@Column(name="C_ORG_CODE")
	public String getOrgCode()
	{
		return orgCode;
	}
	public void setOrgCode(String orgCode)
	{
		this.orgCode = orgCode;
	}
	@Column(name="C_ORG_NAME")
	public String getOrgName()
	{
		return orgName;
	}
	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}
	
	@Column(name="C_ORG_PATHCODE")
	public String getOrgPathCode()
	{
		return orgPathCode;
	}
	public void setOrgPathCode(String orgPathCode)
	{
		this.orgPathCode = orgPathCode;
	}
	
	@Column(name="C_RECORDER_CODE")
	public String getRecorderCode()
	{
		return recorderCode;
	}
	public void setRecorderCode(String recorderCode)
	{
		this.recorderCode = recorderCode;
	}
	
	@Column(name="C_APPLY_DATE")
	public String getApplyDate()
	{
		return applyDate;
	}
	public void setApplyDate(String applyDate)
	{
		this.applyDate = applyDate;
	}
	
	@Column(name="C_QUERY_RESULT")
	public String getQueryResult()
	{
		return queryResult;
	}
	public void setQueryResult(String queryResult)
	{
		this.queryResult = queryResult;
	}
	
	@Column(name="C_QUERY_SERIA_NO")
	public String getQuerySeriaNo()
	{
		return querySeriaNo;
	}
	public void setQuerySeriaNo(String querySeriaNo)
	{
		this.querySeriaNo = querySeriaNo;
	}
	
	@Column(name="C_CLIENT_NAME")
	public String getClientName()
	{
		return clientName;
	}
	public void setClientName(String clientName)
	{
		this.clientName = clientName;
	}
	
	@Column(name="C_CLIENT_PHONE")
	public String getClientPhone()
	{
		return clientPhone;
	}
	public void setClientPhone(String clientPhone)
	{
		this.clientPhone = clientPhone;
	}
	
	@Column(name="C_AGENT_NAME")
	public String getAgentName()
	{
		return agentName;
	}
	public void setAgentName(String agentName)
	{
		this.agentName = agentName;
	}
	
	@Column(name="C_AGENT_PHONE")
	public String getAgentPhone()
	{
		return agentPhone;
	}
	public void setAgentPhone(String agentPhone)
	{
		this.agentPhone = agentPhone;
	}
	
	@Column(name="I_CERTIFICATE_TYPE")
	public Integer getCertificateType()
	{
		return certificateType;
	}
	public void setCertificateType(Integer certificateType)
	{
		this.certificateType = certificateType;
	}
	
	@Column(name="C_CERTIFICATE_TYPE_OTHERS")
	public String getCertificateTypeOthers()
	{
		return certificateTypeOthers;
	}
	public void setCertificateTypeOthers(String certificateTypeOthers)
	{
		this.certificateTypeOthers = certificateTypeOthers;
	}
	
	@Column(name="C_CERTIFICATE_NO")
	public String getCertificateNo()
	{
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo)
	{
		this.certificateNo = certificateNo;
	}
	
	@Column(name="C_WITHDRAWAL_DATE")
	public String getWithdrawalDate()
	{
		return withdrawalDate;
	}
	public void setWithdrawalDate(String withdrawalDate)
	{
		this.withdrawalDate = withdrawalDate;
	}
	
	@Column(name="C_WITHDRAWAL_BANK")
	public String getWithdrawalBank()
	{
		return withdrawalBank;
	}
	public void setWithdrawalBank(String withdrawalBank)
	{
		this.withdrawalBank = withdrawalBank;
	}
	
	@Column(name="I_WITHDRAWAL_TYPE")
	public Integer getWithdrawalType()
	{
		return withdrawalType;
	}
	public void setWithdrawalType(Integer withdrawalType)
	{
		this.withdrawalType = withdrawalType;
	}
	
	@Column(name="C_WITHDRAWAL_BRANCH_NAME")
	public String getWithdrawalBranchName()
	{
		return withdrawalBranchName;
	}
	public void setWithdrawalBranchName(String withdrawalBranchName)
	{
		this.withdrawalBranchName = withdrawalBranchName;
	}
	
	@Column(name="C_WITHDRAWAL_WINDOW")
	public String getWithdrawalWindow()
	{
		return withdrawalWindow;
	}
	public void setWithdrawalWindow(String winthdrawalWindow)
	{
		this.withdrawalWindow = winthdrawalWindow;
	}
	
	@Column(name="I_ATM_TYPE")
	public Integer getAtmType()
	{
		return atmType;
	}
	public void setAtmType(Integer atmType)
	{
		this.atmType = atmType;
	}
	
	@Column(name="C_ATM_ADDRESS")
	public String getAtmAddress()
	{
		return atmAddress;
	}
	public void setAtmAddress(String atmAddress)
	{
		this.atmAddress = atmAddress;
	}
	
	
	
	
	
}
