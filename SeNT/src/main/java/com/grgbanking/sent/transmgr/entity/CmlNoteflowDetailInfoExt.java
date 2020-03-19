package com.grgbanking.sent.transmgr.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.math.BigDecimal;


import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;


@SuppressWarnings("serial")
@Entity
@Table(name="CML_NOTEFLOW_DETAIL_INFO")
@AttributeOverride(name="id", column=@Column(name = "C_ID"))
public class CmlNoteflowDetailInfoExt extends BaseEntity
{
	// { 跟数据库列对应的属性
	public CmlNoteflowInfo cmlNoteflowInfo;                   	                
	public String barcode1;     	              	        
	public String barcode2;     	              	        
	public String flowStage;         	          	    
	public String status;       	              	    
	public String operator;     	              	        
	public String date;         	          	    
	public String pathCode;
	public String receivePathCode;
	// } 跟数据库列对应的属性
	
	public CmlNoteflowDetailInfoExt()
	{
	}
	
	public CmlNoteflowDetailInfoExt(CmlNoteflowDetailInfoExt data)
	{
		this.cmlNoteflowInfo = data.cmlNoteflowInfo;
		this.barcode1       = data.barcode1;
		this.barcode2       = data.barcode2;
		this.flowStage      = data.flowStage;
		this.status         = data.status;
		this.operator       = data.operator;
		this.date           = data.date;
		this.pathCode       = data.pathCode;
		this.receivePathCode= data.receivePathCode;
	}
	
	public CmlNoteflowDetailInfoExt(CmlNoteflowDetailInfoExt data,String clearingDate)
	{
		this(data);
		this.clearingDate = clearingDate;
	}
	
	@ManyToOne(optional=false) 
	@JoinColumn(name="C_BARCODE_FLOWNUM", referencedColumnName="C_TD_BARCODE_FLOWNUM", nullable=true, updatable=false)
	public CmlNoteflowInfo getCmlNoteflowInfo()
	{
		return cmlNoteflowInfo;
	}

	public void setCmlNoteflowInfo(CmlNoteflowInfo cmlNoteflowInfo)
	{
		this.cmlNoteflowInfo = cmlNoteflowInfo;
	}
	
	@Column(name="C_BARCODE1")
	public String getBarcode1()
	{
		return barcode1;
	}
	public void setBarcode1(String barcode1)
	{
		this.barcode1 = barcode1;
	}
	
	@Column(name="C_BARCODE2")
	public String getBarcode2()
	{
		return barcode2;
	}
	public void setBarcode2(String barcode2)
	{
		this.barcode2 = barcode2;
	}
	
	@Column(name="C_FLOW_STAGE")
	public String getFlowStage()
	{
		return flowStage;
	}

	public void setFlowStage(String flowStage)
	{
		this.flowStage = flowStage;
	}
	
	@Column(name="C_STATUS")
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	@Column(name="C_OPERATOR")
	public String getOperator()
	{
		return operator;
	}
	public void setOperator(String operator)
	{
		this.operator = operator;
	}
	
	@Column(name="C_DATE")
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	
	@Column(name="C_PATHCODE")
	public String getPathCode()
	{
		return pathCode;
	}
	public void setPathCode(String pathCode)
	{
		this.pathCode = pathCode;
	}
	
	@Transient
	public String getClearingDate()
	{
		return clearingDate;
	}

	public void setClearingDate(String clearingDate)
	{
		this.clearingDate = clearingDate;
	}
	
	@Column(name="C_RECEIVE_PATHCODE")
	public String getReceivePathCode()
	{
		return receivePathCode;
	}
	public void setReceivePathCode(String receivePathCode)
	{
		this.receivePathCode = receivePathCode;
	}
	

	
	//////////////////////////////////////////
	
	// 其它的附加属性
//	public String  journalNo;
//	public String  termId;
	public String  clearingDate;
	public String  barcodeFlowNum;
//	public Integer noteCount;
//	public Integer totalNotes;
//	public String  noteType;
//	public String  barcodeStatus;
//	public String  baseFlowStage;
//	
//	public String orgid;
//	public String boxNum;
//	public String atmModel;
//	public String atmBoxTypes;
//	public String boxStatus;
//	public String boxType;
//	public String usageStatus;
	
	
	@Transient
	public String getJournalNo()
	{
		if( this.cmlNoteflowInfo==null )
		{
			return null;
		}
		return this.cmlNoteflowInfo.getJournalNo();
	}

	public void setJournalNo(String journalNo)
	{
		throw new RuntimeException("unsupport method");
	}

	@Transient
	public String getTermId()
	{
		if( this.cmlNoteflowInfo==null )
		{
			return null;
		}
		return this.cmlNoteflowInfo.getTermId();
	}

	public void setTermId(String termId)
	{
		throw new RuntimeException("unsupport method");
	}


	@Transient
	public String getBarcodeFlowNum()
	{
		return this.barcodeFlowNum;
	}

	public void setBarcodeFlowNum(String barcodeFlowNum)
	{
		this.barcodeFlowNum = barcodeFlowNum;
	}

	@Transient
	public Integer getNoteCount()
	{
		if( this.cmlNoteflowInfo==null )
		{
			return null;
		}
		return this.cmlNoteflowInfo.getNoteCount();
	}

	public void setNoteCount(Integer noteCount)
	{
		this.cmlNoteflowInfo.noteCount = noteCount;
	}

	@Transient
	public BigDecimal getStatisAmt()
	{
		if( this.cmlNoteflowInfo==null )
		{
			return BigDecimal.valueOf(0);
		}
		return this.cmlNoteflowInfo.getStatisAmt();
	}

	public void setStatisAmt(BigDecimal statisAmt)
	{
		this.cmlNoteflowInfo.statisAmt = statisAmt;
	}

	@Transient
	public String getNoteType()
	{
		if( this.cmlNoteflowInfo==null )
		{
			return null;
		}
		return this.cmlNoteflowInfo.getNoteType();
	}

	public void setNoteType(String noteType)
	{
		throw new RuntimeException("unsupport method");
	}

	@Transient
	public String getBarcodeStatus()
	{
		if( this.cmlNoteflowInfo==null )
		{
			return null;
		}
		return this.cmlNoteflowInfo.getBarcodeStatus();
	}

	public void setBarcodeStatus(String barcodeStatus)
	{
		throw new RuntimeException("unsupport method");
	}

	@Transient
	public String getBaseFlowStage()
	{
		
		return this.flowStage;
//		if( this.cmlNoteflowInfo==null )
//		{
//			return null;
//		}
//		return this.cmlNoteflowInfo.getFlowStage();
	}

	public void setBaseFlowStage(String baseFlowStage)
	{
		throw new RuntimeException("unsupport method");
	}
	
//	@Transient
//	public String getOrgid() {
//		return orgid;
//	}
//
//	public void setOrgid(String orgid) {
//		this.orgid = orgid;
//	}
//	@Transient
//	public String getBoxNum() {
//		return boxNum;
//	}
//
//	public void setBoxNum(String boxNum) {
//		this.boxNum = boxNum;
//	}
//	@Transient
//	public String getAtmModel() {
//		return atmModel;
//	}
//
//	public void setAtmModel(String atmModel) {
//		this.atmModel = atmModel;
//	}
//	@Transient
//	public String getAtmBoxTypes() {
//		return atmBoxTypes;
//	}
//
//	public void setAtmBoxTypes(String atmBoxTypes) {
//		this.atmBoxTypes = atmBoxTypes;
//	}
//	@Transient
//	public String getBoxStatus() {
//		return boxStatus;
//	}
//
//	public void setBoxStatus(String boxStatus) {
//		this.boxStatus = boxStatus;
//	}
//	@Transient
//	public String getBoxType() {
//		return boxType;
//	}
//
//	public void setBoxType(String boxType) {
//		this.boxType = boxType;
//	}
//	@Transient
//	public String getUsageStatus() {
//		return usageStatus;
//	}
//
//	public void setUsageStatus(String usageStatus) {
//		this.usageStatus = usageStatus;
//	}
	
	////////////////////////////////////
	
	
	
}

