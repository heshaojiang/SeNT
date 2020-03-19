package com.grgbanking.sent.transmgr.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;


@SuppressWarnings("serial")
@Entity
@Table(name="CML_NOTEFLOW_INFO")
@AttributeOverride(name="id", column=@Column(name = "C_ID"))
public class CmlNoteflowInfo extends BaseEntity
{
	
	public String  journalNo;
	public String  termId;
	public String  clearingDate;
	//public String  barcodeFlowNum;
	public Integer noteCount;
	//public Integer totalNotes;
	public BigDecimal statisAmt;
	public String  noteType;
	public String  barcodeStatus;
	public String  flowStage;
	public String  pathCode;

	public String  tdBarcodeFlownum;
	public String  tdOperatorId;
	public String  tdReserve;

	public CmlNoteflowInfo()
	{

	}
	

	@Column(name="C_JOURNAL_NO")
	public String getJournalNo()
	{
		return journalNo;
	}

	public void setJournalNo(String journalNo)
	{
		this.journalNo = journalNo;
	}

	@Column(name="C_TERM_ID")
	public String getTermId()
	{
		return termId;
	}

	public void setTermId(String termId)
	{
		this.termId = termId;
	}

	@Column(name="C_CLEARING_DATE")
	public String getClearingDate()
	{
		return clearingDate;
	}

	public void setClearingDate(String clearingDate)
	{
		this.clearingDate = clearingDate;
	}

	@Column(name="I_NOTECOUNT")
	public Integer getNoteCount()
	{
		return noteCount;
	}

	public void setNoteCount(Integer noteCount)
	{
		this.noteCount = noteCount;
	}

	@Column(name="C_NOTE_TYPE")
	public String getNoteType()
	{
		return noteType;
	}

	public void setNoteType(String noteType)
	{
		this.noteType = noteType;
	}

	@Column(name="C_BARCODE_STATUS")
	public String getBarcodeStatus()
	{
		return barcodeStatus;
	}

	public void setBarcodeStatus(String barcodeStatus)
	{
		this.barcodeStatus = barcodeStatus;
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

	@Column(name="C_PATHCODE")
	public String getPathCode()
	{
		return pathCode;
	}
	public void setPathCode(String pathCode)
	{
		this.pathCode = pathCode;
	}

	@Column(name="I_STATIS_AMT")
	public BigDecimal getStatisAmt() {
		return statisAmt;
	}


	public void setStatisAmt(BigDecimal statisAmt) {
		this.statisAmt = statisAmt;
	}

	@Column(name="C_TD_BARCODE_FLOWNUM")
	public String getTdBarcodeFlownum() {
		return tdBarcodeFlownum;
	}


	public void setTdBarcodeFlownum(String tdBarcodeFlownum) {
		this.tdBarcodeFlownum = tdBarcodeFlownum;
	}

	@Column(name="C_TD_OPERATOR_ID")
	public String getTdOperatorId() {
		return tdOperatorId;
	}


	public void setTdOperatorId(String tdOperatorId) {
		this.tdOperatorId = tdOperatorId;
	}

	@Column(name="C_TD_RESERVE")
	public String getTdReserve() {
		return tdReserve;
	}

	public void setTdReserve(String tdReserve) {
		this.tdReserve = tdReserve;
	}
	


	

	
}

