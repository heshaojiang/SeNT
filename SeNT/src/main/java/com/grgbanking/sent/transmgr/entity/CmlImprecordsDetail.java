package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;


public class CmlImprecordsDetail
{
	private String id;
	private String orgName;
	private String termId;
	private String fileName;
	private String oldFileName;
	private String operaterId;
	private String operateStatus;
	private String seriaimgFlag;
	private BigDecimal seriaNum;
	private String operaterDate;
	private String pathcode;
	private Integer resovimpRecords;
	private String tranDate;
	
	private String orgCode;
	private String getImageFlag ;
	private String sourceIp ;
	private String uploadFlag ;
	private String finacialCode;
	
	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	private String jourNo;
	public String getOrgName()
	{
		return orgName;
	}

	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTermId()
	{
		return termId;
	}

	public void setTermId(String termId)
	{
		this.termId = termId;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getOperaterId()
	{
		return operaterId;
	}

	public void setOperaterId(String operaterId)
	{
		this.operaterId = operaterId;
	}

	public String getOperateStatus()
	{
		return operateStatus;
	}

	public void setOperateStatus(String operateStatus)
	{
		this.operateStatus = operateStatus;
	}

	public String getSeriaimgFlag()
	{
		return seriaimgFlag;
	}

	public void setSeriaimgFlag(String seriaimgFlag)
	{
		this.seriaimgFlag = seriaimgFlag;
	}

	public BigDecimal getSeriaNum()
	{
		return seriaNum;
	}

	public void setSeriaNum(BigDecimal seriaNum)
	{
		this.seriaNum = seriaNum;
	}

	public String getOperaterDate()
	{
		return operaterDate;
	}

	public void setOperaterDate(String operaterDate)
	{
		this.operaterDate = operaterDate;
	}

	public String getPathcode()
	{
		return pathcode;
	}

	public void setPathcode(String pathcode)
	{
		this.pathcode = pathcode;
	}

	public Integer getResovimpRecords()
	{
		return resovimpRecords;
	}

	public void setResovimpRecords(Integer resovimpRecords)
	{
		this.resovimpRecords = resovimpRecords;
	}

	

	public String getJourNo()
	{
		return jourNo;
	}

	public void setJourNo(String jourNo)
	{
		this.jourNo = jourNo;
	}



	public String getOldFileName() {
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getGetImageFlag() {
		return getImageFlag;
	}

	public void setGetImageFlag(String getImageFlag) {
		this.getImageFlag = getImageFlag;
	}

	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getUploadFlag() {
		return uploadFlag;
	}

	public void setUploadFlag(String uploadFlag) {
		this.uploadFlag = uploadFlag;
	}

	public void setFinacialCode(String finacialCode) {
		this.finacialCode = finacialCode;
	}

	public String getFinacialCode() {
		return finacialCode;
	}
	
	
}
