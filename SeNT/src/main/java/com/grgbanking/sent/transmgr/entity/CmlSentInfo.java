package com.grgbanking.sent.transmgr.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 清分纸币冠字号码
 * 
 * @author 广电运通
 * @version :1.0 </br>
 **/

@SuppressWarnings("serial")
@Entity
@Table(name = "CML_SENT_INFOS_2")
@AttributeOverride(name = "id", column = @Column(name = "I_ID"))
public class CmlSentInfo extends BaseEntity
{
	// { 跟数据库对应的属性
	private String tranId;
	private String termId;
	private String journalNo;
	private String imageType;
	private Integer sequence;
	//private String fileName;
	private String barcodeFlowNum;
	private String denomination;
	private String noteFlag;
	private String noteType;
	private String currency;
	private String versionNum;
	private String seriaNo;
	private String errorCode;
	private String reserve;
	private String tranDate;
	private String tranMonthday;
	private String termType;
	private String pathcode;
	private String machinesno;
	private String type ;
	private String machineType ;
	private String moneyType ;
	// } 跟数据库对应的属性
	
	// { 额外的属性
	private String orgName;
	private String orgFullName;
	private String typeName;
	private String businessTypeDesc;
	private byte[] imageArr;
	private String fullUrl;
	private String fromTableName;
	private Integer width;
	private Integer height;
	private boolean registerInDoubtRecord;
	private String currentBank;
	private String orgNameFinanceCode;
	// } 额外的属性

	public CmlSentInfo()
	{

	}
	
	public String getCurrentBank() {
		return currentBank;
	}

	public void setCurrentBank(String currentBank) {
		this.currentBank = currentBank;
	}

	@Column(name = "C_MACHINESNO")
	public String getMachinesno()
	{
		return machinesno;
	}

	public void setMachinesno(String machinesno)
	{
		this.machinesno = machinesno;
	}

	@Column(name = "C_IMAGE_TYPE")
	public String getImageType()
	{
		return imageType;
	}

	public void setImageType(String imageType)
	{
		this.imageType = imageType;
	}

	

	@Column(name = "C_NOTE_FLAG")
	public String getNoteFlag()
	{
		return noteFlag;
	}

	public void setNoteFlag(String noteFlag)
	{
		this.noteFlag = noteFlag;
	}

	@Column(name = "C_TRAN_DATE")
	public String getTranDate()
	{
		return tranDate;
	}

	public void setTranDate(String tranDate)
	{
		this.tranDate = tranDate;
	}

	@Column(name = "C_PATHCODE")
	public String getPathcode()
	{
		return pathcode;
	}

	public void setPathcode(String pathcode)
	{
		this.pathcode = pathcode;
	}

	@Column(name = "C_BARCODE_FLOWNUM")
	public String getBarcodeFlowNum()
	{
		return barcodeFlowNum;
	}

	public void setBarcodeFlowNum(String barcodeFlowNum)
	{
		this.barcodeFlowNum = barcodeFlowNum;
	}



	@Column(name = "C_TRAN_ID")
	public String getTranId()
	{
		return tranId;
	}

	public void setTranId(String tranId)
	{
		this.tranId = tranId;
	}

	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo()
	{
		return journalNo;
	}

	public void setJournalNo(String journalNo)
	{
		this.journalNo = journalNo;
	}

	@Column(name = "I_SEQUENCE")
	public Integer getSequence()
	{
		return sequence;
	}

	public void setSequence(Integer sequence)
	{
		this.sequence = sequence;
	}

	@Column(name = "C_NOTE_TYPE")
	public String getNoteType()
	{
		return noteType;
	}

	public void setNoteType(String noteType)
	{
		this.noteType = noteType;
	}

	@Column(name = "C_CURRENCY")
	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	@Column(name = "C_DENOMINATION")
	public String getDenomination()
	{
		return denomination;
	}

	public void setDenomination(String denomination)
	{
		this.denomination = denomination;
	}

	@Column(name = "C_VERSION_NUM")
	public String getVersionNum()
	{
		return versionNum;
	}

	public void setVersionNum(String versionNum)
	{
		this.versionNum = versionNum;
	}

	@Column(name = "C_SERIA_NO")
	public String getSeriaNo()
	{
		return seriaNo;
	}

	public void setSeriaNo(String seriaNo)
	{
		this.seriaNo = seriaNo;
	}

	@Column(name = "C_TRAN_MONTHDAY")
	public String getTranMonthday()
	{
		return tranMonthday;
	}

	public void setTranMonthday(String tranMonthday)
	{
		this.tranMonthday = tranMonthday;
	}

	@Column(name = "C_ERROR_CODE")
	public String getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	@Column(name = "C_RESERVE")
	public String getReserve()
	{
		return reserve;
	}

	public void setReserve(String reserve)
	{
		this.reserve = reserve;
	}

	@Column(name = "C_TERM_TYPE")
	public String getTermType()
	{
		return termType;
	}

	public void setTermType(String termType)
	{
		this.termType = termType;
	}

	@Column(name="C_TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="C_MACHINE_TYPE")
	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	@Column(name="C_MONEY_TYPE")
	public String getMoneyType() {
		return moneyType;
	}

	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	public CmlSentInfo(String id, String tranId, String seriaNo, String currency, String denomination, String noteType, String tranDate, String termId, String imageType, String termType,
			String tranMonthday, String barcodeFlowNum)
	{
		this.tranId = tranId;
		this.seriaNo = seriaNo;
		this.currency = currency;
		this.denomination = denomination;
		this.noteType = noteType;
		this.tranDate = tranDate;
		this.termId = termId;
		this.imageType = imageType;
		this.termType = termType;
		this.barcodeFlowNum = barcodeFlowNum;
		this.tranMonthday = tranMonthday;
		super.setId(id);
	}

	public CmlSentInfo(String id, String tranId, String seriaNo, String currency, String denomination, String noteType, String tranDate, String termId, String imageType, String termType,
			String tranMonthday, String barcodeFlowNum, String pathcode, String noteFlag, String versionNum)
	{
		this.tranId = tranId;
		this.seriaNo = seriaNo;
		this.currency = currency;
		this.denomination = denomination;
		this.noteType = noteType;
		this.tranDate = tranDate;
		this.termId = termId;
		this.imageType = imageType;
		this.termType = termType;
		this.barcodeFlowNum = barcodeFlowNum;
		this.tranMonthday = tranMonthday;
		this.pathcode = pathcode;
		this.noteFlag = noteFlag;
		this.versionNum = versionNum;
		super.setId(id);
	}
	

	@Column(name = "C_TERM_ID")
	public String getTermId() {
		return termId;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	@Transient
	public String getFullUrl()
	{
		return fullUrl;
	}

	public void setFullUrl(String fullUrl)
	{
		this.fullUrl = fullUrl;
	}

	@Transient
	public Integer getWidth()
	{
		return width;
	}

	public void setWidth(Integer width)
	{
		this.width = width;
	}

	@Transient
	public Integer getHeight()
	{
		return height;
	}

	public void setHeight(Integer height)
	{
		this.height = height;
	}
	
	@Transient
	public String getBusinessTypeDesc()
	{
		return businessTypeDesc;
	}

	public void setBusinessTypeDesc(String businessTypeDesc)
	{
		this.businessTypeDesc = businessTypeDesc;
	}

	@Transient
	public byte[] getImageArr()
	{
		return imageArr;
	}
	
	public void setImageArr(byte[] imageArr)
	{
		this.imageArr = imageArr;
	}
	
	@Transient
	public String getTypeName()
	{
		return typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}
	
	@Transient
	public String getFromTableName()
	{
		return fromTableName;
	}

	public void setFromTableName(String fromTableName)
	{
		this.fromTableName = fromTableName;
	}

	@Transient
	public String getOrgName()
	{
		return orgName;
	}

	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}

	@Transient
	public String getOrgFullName()
	{
		return orgFullName;
	}

	public void setOrgFullName(String orgFullName)
	{
		this.orgFullName = orgFullName;
	}
	
	/**
	 * 是否在涉假信息中登记
	 */
	public boolean isRegisterInDoubtRecord() {
		return registerInDoubtRecord;
	}
	
	/**
	 * 是否在涉假信息中登记
	 */
	public void setRegisterInDoubtRecord(boolean registerInDoubtRecord) {
		this.registerInDoubtRecord = registerInDoubtRecord;
	}

	@Transient
	public String getOrgNameFinanceCode() {
		return orgNameFinanceCode;
	}

	public void setOrgNameFinanceCode(String orgNameFinanceCode) {
		this.orgNameFinanceCode = orgNameFinanceCode;
	}
	
	
	
}
