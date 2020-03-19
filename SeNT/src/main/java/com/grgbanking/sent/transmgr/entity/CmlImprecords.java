package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * @author 广电运通
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CML_IMP_RECORDS")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class CmlImprecords extends BaseEntity
{
	// { 跟数据库一一对应的属性
	private String termId;
	private String jourNo;
	private String operaterDate;
	private String fileName;
	private String operaterId;
	private String operateStatus;
	private String seriaimgFlag;
	private BigDecimal seriaNum;
	private Integer resovimpRecords;
	private String tranDate;
	
	private String partMonthday;
	private String pathcode;
	private String oldFileName;
	private String getImageFlag ;
	private String sourceIp ;
	private String uploadFlag ;
	// } 跟数据库一一对应的属性
	
	// { 额外的属性
	private String orgCode;
	private String pathCodeName;
	private String pathCodeFullName;
	private String bankName;
	private String bankFullName;
	private String termTypeDesc;
	private String bankingOrgCode;
	// } 额外的属性

	@Column(name = "C_TRAN_DATE")
	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	@Transient
	public String getBankingOrgCode() {
		return bankingOrgCode;
	}

	public void setBankingOrgCode(String bankingOrgCode) {
		this.bankingOrgCode = bankingOrgCode;
	}

	@Column(name = "C_OPERATER_DATE")
	public String getOperaterDate()
	{
		return operaterDate;
	}

	public void setOperaterDate(String operaterDate)
	{
		this.operaterDate = operaterDate;
	}

	/**
	 * @return the sourceOrg
	 */

	/**
	 * @return the termId
	 * 
	 */
	@Column(name = "C_TERM_ID")
	public String getTermId()
	{
		return termId;
	}

	/**
	 * @param termId
	 *            the termId to set
	 */
	public void setTermId(String termId)
	{
		this.termId = termId;
	}

	@Column(name = "C_FILE_NAME")
	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	@Column(name = "C_OPERATE_STATUS")
	public String getOperateStatus()
	{
		return operateStatus;
	}

	public void setOperateStatus(String operateStatus)
	{
		this.operateStatus = operateStatus;
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

	@Column(name = "I_RESOVIMP_RECORDS")
	public Integer getResovimpRecords()
	{
		return resovimpRecords;
	}

	public void setResovimpRecords(Integer resovimpRecords)
	{
		this.resovimpRecords = resovimpRecords;
	}



	@Column(name = "C_JOURNO")
	public String getJourNo()
	{
		return jourNo;
	}

	public void setJourNo(String jourNo)
	{
		this.jourNo = jourNo;
	}

	/**
	 * @return the operaterId
	 */
	@Column(name = "C_OPERATER_ID")
	public String getOperaterId()
	{
		return operaterId;
	}

	/**
	 * @param operaterId
	 *            the operaterId to set
	 */
	public void setOperaterId(String operaterId)
	{
		this.operaterId = operaterId;
	}

	/**
	 * @return the seriaimgFlag
	 */
	@Column(name = "C_SERIAIMG_FLAG")
	public String getSeriaimgFlag()
	{
		return seriaimgFlag;
	}

	/**
	 * @param seriaimgFlag
	 *            the seriaimgFlag to set
	 */
	public void setSeriaimgFlag(String seriaimgFlag)
	{
		this.seriaimgFlag = seriaimgFlag;
	}

	/**
	 * @return the seriaNum
	 */
	@Column(name = "I_SERIA_NUM")
	public BigDecimal getSeriaNum()
	{
		return seriaNum;
	}

	/**
	 * @param seriaNum
	 *            the seriaNum to set
	 */
	public void setSeriaNum(BigDecimal seriaNum)
	{
		this.seriaNum = seriaNum;
	}
	
	
	@Transient
	public String getOrgCode()
	{
		return orgCode;
	}

	public void setOrgCode(String orgCode)
	{
		this.orgCode = orgCode;
	}

	@Transient
	public String getPathCodeName()
	{
		return pathCodeName;
	}

	public void setPathCodeName(String pathCodeName)
	{
		this.pathCodeName = pathCodeName;
	}

	@Transient
	public String getPathCodeFullName()
	{
		return pathCodeFullName;
	}

	public void setPathCodeFullName(String pathCodeFullName)
	{
		this.pathCodeFullName = pathCodeFullName;
	}

	@Transient
	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	@Transient
	public String getBankFullName()
	{
		return bankFullName;
	}

	public void setBankFullName(String bankFullName)
	{
		this.bankFullName = bankFullName;
	}

	@Transient
	public String getTermTypeDesc()
	{
		return termTypeDesc;
	}

	public void setTermTypeDesc(String termTypeDesc)
	{
		this.termTypeDesc = termTypeDesc;
	}

	@Column(name = "C_PART_MONTHDAY")
	public String getPartMonthday() {
		return partMonthday;
	}

	public void setPartMonthday(String partMonthday) {
		this.partMonthday = partMonthday;
	}
	
	@Column(name = "C_OLDFILE_NAME")
	public String getOldFileName() {
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

	@Column(name="C_GETIMAGE_FALG")
	public String getGetImageFlag() {
		return getImageFlag;
	}

	public void setGetImageFlag(String getImageFlag) {
		this.getImageFlag = getImageFlag;
	}

	@Column(name="C_SOURCE_IP")
	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	@Column(name="C_UPLOAD_FLAG")
	public String getUploadFlag() {
		return uploadFlag;
	}

	public void setUploadFlag(String uploadFlag) {
		this.uploadFlag = uploadFlag;
	}
}
