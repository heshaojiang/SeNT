package com.grgbanking.sent.transmgr.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.math.BigDecimal;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;


@SuppressWarnings("serial")
@Entity
@Table(name="CML_NOTEFLOW_DETAIL_INFO")
@AttributeOverride(name="id", column=@Column(name = "C_ID"))
public class CmlNoteflowDetailInfo extends BaseEntity
{
	// { 跟数据库列对应的属性
	public String barcodeFlowNum;                   	                
	public String barcode1;     	              	        
	public String barcode2;     	              	        
	public String flowStage;         	          	    
	public String status;       	              	    
	public String operator;     	              	        
	public String date;         	          	    
	public String pathCode;
	public String receivePathCode;
	// } 跟数据库列对应的属性
	
	public CmlNoteflowDetailInfo()
	{
		
	}
	
	public CmlNoteflowDetailInfo(CmlNoteflowDetailInfo data)
	{
		this.barcodeFlowNum = data.barcodeFlowNum;
		this.barcode1       = data.barcode1;
		this.barcode2       = data.barcode2;
		this.flowStage      = data.flowStage;
		this.status         = data.status;
		this.operator       = data.operator;
		this.date           = data.date;
		this.pathCode       = data.pathCode;
		this.receivePathCode= data.receivePathCode;
	}
	
	
	public CmlNoteflowDetailInfo(CmlNoteflowDetailInfo data, 
			String baseFlowStage, 
			String termId, 
			String journalNo,
			String clearingDate,
			BigDecimal statisAmt)
	{
		this(data);
		this.baseFlowStage = baseFlowStage;
		this.termId = termId;
		this.journalNo = journalNo;
		this.clearingDate = clearingDate;
		this.statisAmt = statisAmt;
	}
	
	public CmlNoteflowDetailInfo(	String barcodeFlowNum,      
									String barcode1,     	   
									String barcode2,     	   
									String flowStage,         	   
									String status,       	   
									String operator,     	   
									String date,         	   
									String pathCode            
									//String followType
									)
	{
		this.barcodeFlowNum = barcodeFlowNum;
		this.barcode1       = barcode1;
		this.barcode2       = barcode2;
		this.flowStage      = flowStage;
		this.status         = status;
		this.operator       = operator;
		this.date           = date;
		this.pathCode       = pathCode;
		//this.followType     = followType;
	}
	
	public CmlNoteflowDetailInfo(CmlNoteflowDetailInfoExt data)
	{
		this.barcodeFlowNum = data.getBarcodeFlowNum();
		this.barcode1       = data.getBarcode1();
		this.barcode2       = data.getBarcode2();
		this.flowStage      = data.getFlowStage();
		this.status         = data.getStatus();
		this.operator       = data.getOperator();
		this.date           = data.getDate();
		this.pathCode       = data.getPathCode();
		// 扩展属性
		this.journalNo     = data.getJournalNo(); 
		this.termId        = data.getTermId(); 
		this.clearingDate  = data.getClearingDate(); 
		this.noteCount     = data.getNoteCount();
		this.statisAmt    = data.getStatisAmt(); 
		this.noteType      = data.getNoteType();
		this.barcodeStatus = data.getBarcodeStatus();
		this.baseFlowStage = data.getBaseFlowStage();
	}
	
//	public CmlNoteflowDetailInfo(String orgid,
//			String boxNum,
//			String boxStatus,
//			String atmModel,
//			String atmBoxTypes,
//			String boxType,
//			String usageStatus,
//			//String type,
//			String date,
//			String operator)
//	{
//		this.orgid = orgid;
//		this.boxNum = boxNum;
//		this.boxStatus = boxStatus;
//		this.atmModel = atmModel;
//		this.atmBoxTypes = atmBoxTypes;
//		this.boxType = boxType;
//		this.usageStatus = usageStatus;
//		//this.type = type;
//		this.date = date;
//		this.operator = operator;
//	}
	
	@Column(name="C_BARCODE_FLOWNUM")
	public String getBarcodeFlowNum()
	{
		return barcodeFlowNum;
	}
	public void setBarcodeFlowNum(String barcodeFlowNum)
	{
		this.barcodeFlowNum = barcodeFlowNum;
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
	public String  journalNo;
	public String  termId;
	public String  clearingDate;
	public Integer noteCount;
	public BigDecimal statisAmt;
	public String  noteType;
	public String  barcodeStatus;
	public String  baseFlowStage;
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
		return journalNo;
	}

	public void setJournalNo(String journalNo)
	{
		this.journalNo = journalNo;
	}

	@Transient
	public String getTermId()
	{
		return termId;
	}

	public void setTermId(String termId)
	{
		this.termId = termId;
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

	@Transient
	public Integer getNoteCount()
	{
		return noteCount;
	}

	public void setNoteCount(Integer noteCount)
	{
		this.noteCount = noteCount;
	}

	@Transient
	public BigDecimal getStatisAmt()
	{
		return statisAmt;
	}

	public void setTotalNotes(BigDecimal statisAmt)
	{
		this.statisAmt = statisAmt;
	}

	@Transient
	public String getNoteType()
	{
		return noteType;
	}

	public void setNoteType(String noteType)
	{
		this.noteType = noteType;
	}

	@Transient
	public String getBarcodeStatus()
	{
		return barcodeStatus;
	}

	public void setBarcodeStatus(String barcodeStatus)
	{
		this.barcodeStatus = barcodeStatus;
	}

	@Transient
	public String getBaseFlowStage()
	{
		return baseFlowStage;
	}

	public void setBaseFlowStage(String baseFlowStage)
	{
		this.baseFlowStage = baseFlowStage;
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

