package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 清分交易信息
 * 
 * @author 广电运通
 * @version 1.0
 * **/

@SuppressWarnings("serial")
@Entity
@Table(name = "CML_TASK_INFOS")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class CmlTaskInfo extends BaseEntity
{

	// { 跟数据库一一对应的属性
	private String termId;
	private BigDecimal beforeAmt;
	private Date bindStart;
	private Date bindEnd;	
	private String journalNo;
	private BigDecimal statisAmt;	
	private String transResult;
	private String rotoCashType;
	private String uploadFlag;
	private String tranDate;
	private String partMonthday;
	private String pathcode;
	private BigDecimal tranCount;
	
	private String reserve1;
	private String tdSourceOrgid;
	private String tdDestOrgid;
	private String tdOperatorId;
	private String tdReserve;
//
//	  C_ID              VARCHAR(32) NOT NULL,
//	  C_TERM_ID         VARCHAR(32),
//	  I_BEFORE_AMT      DECIMAL(20,0),
//	  D_BIND_START      DATETIME,
//	  D_BIND_END        DATETIME,
//	  C_JOURNAL_NO      VARCHAR(32),
//	  I_STATIS_AMT      DECIMAL(20,0),
//	  I_TRAN_COUNT      DECIMAL(8,0),
//	  C_TRAN_RESULT     VARCHAR(2),
//	  C_ROTOCASH_TYPE   VARCHAR(2),
//	  C_UPLOAD_FLAG     VARCHAR(2),
//	  C_TRAN_DATETIME       VARCHAR(8),
//	  C_PART_MONTHDAY   VARCHAR(4),
//	  C_PATHCODE        VARCHAR(64),
//	  C_RESERVE1        VARCHAR(32),
//	  C_TD_SOURCE_ORGID VARCHAR(32),
//	  C_TD_DEST_ORGID   VARCHAR(32),
//	  C_TD_OPERATOR_ID  VARCHAR(32),
//	  C_TD_RESERVE      VARCHAR(32)
	// } 跟数据库一一对应的属性
	
	// { 额外的属性
	private String atmNum;
	private String boxNum;
	private Integer boxCount;
	private String orgCode;
	private String pathCodeName;
	private String pathCodeFullName;
	private String bankName;
	private String bankFullName;
	private String finacialCode;
	
	// } 额外的属性


	@Column(name = "C_TRAN_DATE")
	public String getTranDate()
	{
		return tranDate;
	}

	public void setTranDate(String tranDate)
	{
		this.tranDate = tranDate;
	}

	@Column(name = "C_UPLOAD_FLAG")
	public String getUploadFlag()
	{
		return uploadFlag;
	}

	public void setUploadFlag(String uploadFlag)
	{
		this.uploadFlag = uploadFlag;
	}

	/**
	 * @return String
	 * */
	@Column(name = "C_PATHCODE")
	public String getPathcode()
	{
		return pathcode;
	}

	/**
	 * @param pathcode
	 *            机构的pathcode
	 * */
	public void setPathcode(String pathcode)
	{
		this.pathcode = pathcode;
	}

	/**
	 * 清分结果
	 * 
	 * @return transResult</br>
	 **/

	@Column(name = "C_TRAN_RESULT")
	public String getTransResult()
	{
		return this.transResult;
	}
	public void setTransResult(String transResult)
	{
		this.transResult = transResult;
	}
	
	@Column(name = "C_TD_RESERVE")
	public String getTdReserve() {
		return tdReserve;
	}
	public void setTdReserve(String tdReserve) {
		this.tdReserve = tdReserve;
	}

	@Column(name = "C_RESERVE1")
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	@Column(name = "C_TD_SOURCE_ORGID")
	public String getTdSourceOrgid() {
		return tdSourceOrgid;
	}
	public void setTdSourceOrgid(String tdSourceOrgid) {
		this.tdSourceOrgid = tdSourceOrgid;
	}
	@Column(name = "C_TD_DEST_ORGID")
	public String getTdDestOrgid() {
		return tdDestOrgid;
	}
	public void setTdDestOrgid(String tdDestOrgid) {
		this.tdDestOrgid = tdDestOrgid;
	}

	/**
	 * 终端编号
	 * 
	 * @return termId</br>
	 * **/
	@Column(name = "C_TERM_ID")
	public String getTermId()
	{
		return this.termId;
	}

	/**
	 * @param termId
	 *            终端编号</br>
	 **/
	public void setTermId(String termId)
	{
		this.termId = termId;
	}

	/**
	 * 预清分金额
	 * 
	 * @return beforeCount</br>
	 **/
	@Column(name = "I_BEFORE_AMT")
	public BigDecimal getBeforeAmt()
	{
		return this.beforeAmt;
	}

	/**
	 * @param beforeCount
	 *            预清分金额</br>
	 **/
	public void setBeforeAmt(BigDecimal beforeAmt)
	{
		this.beforeAmt = beforeAmt;
	}

	/**
	 * 绑定开始时间
	 * 
	 * @return bindStart </br>
	 **/
	@Column(name = "D_BIND_START")
	public Date getBindStart()
	{
		return this.bindStart;
	}

	/**
	 * @param bindStart
	 *            绑定开始时间</br>
	 **/
	public void setBindStart(Date bindStart)
	{
		this.bindStart = bindStart;
	}

	/**
	 * 结束时间
	 * 
	 * @return bindEnd </br>
	 **/
	@Column(name = "D_BIND_END")
	public Date getBindEnd()
	{
		return this.bindEnd;
	}

	/**
	 * @param bindEnd
	 *            结束时间</br>
	 **/
	public void setBindEnd(Date bindEnd)
	{
		this.bindEnd = bindEnd;
	}

	/**
	 * 清分员
	 * 
	 * @return operatorId </br>
	 **/
	@Column(name = "C_TD_OPERATOR_ID")
	public String getTdOperatorId()
	{
		return this.tdOperatorId;
	}

	/**
	 * @param operatorId
	 *            清分员</br>
	 **/
	public void setTdOperatorId(String tdOperatorId)
	{
		this.tdOperatorId = tdOperatorId;
	}

	/**
	 * 清分流水号
	 * 
	 * @return journalNo</br>
	 **/

	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo()
	{
		return this.journalNo;
	}

	/**
	 * @param journalNo
	 *            清分流水号</br>
	 **/
	public void setJournalNo(String journalNo)
	{
		this.journalNo = journalNo;
	}

	/**
	 * 统计金额
	 * 
	 * @return totalMoney</br>
	 **/
	@Column(name = "I_STATIS_AMT")
	public BigDecimal getStatisAmt()
	{
		return this.statisAmt;
	}

	/**
	 * 统计金额</br>
	 **/
	public void setStatisAmt(BigDecimal statisAmt)
	{
		this.statisAmt = statisAmt;
	}

	/**
	 * 清分类型
	 * 
	 * @return rotoCashType</br>
	 **/
	@Column(name = "C_ROTOCASH_TYPE")
	public String getRotoCashType()
	{
		return this.rotoCashType;
	}

	/**
	 * @param rotoCashType
	 *            清分类型</br>
	 **/
	public void setRotoCashType(String rotoCashType)
	{
		this.rotoCashType = rotoCashType;
	}

	//////////////////////////////////////////

	@Transient
	public String getAtmNum()
	{
		return atmNum;
	}

	public void setAtmNum(String atmNum)
	{
		this.atmNum = atmNum;
	}

	@Transient
	public String getBoxNum()
	{
		return boxNum;
	}

	public void setBoxNum(String boxNum)
	{
		this.boxNum = boxNum;
	}

	@Transient
	public Integer getBoxCount()
	{
		return boxCount;
	}

	public void setBoxCount(Integer boxCount)
	{
		this.boxCount = boxCount;
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
	public String getOrgCode()
	{
		return orgCode;
	}

	public void setOrgCode(String orgCode)
	{
		this.orgCode = orgCode;
	}

	@Column(name = "I_TRAN_COUNT")
	public BigDecimal getTranCount() {
		return tranCount;
	}

	public void setTranCount(BigDecimal tranCount) {
		this.tranCount = tranCount;
	}

	@Transient
	public String getFinacialCode() {
		return finacialCode;
	}

	public void setFinacialCode(String finacialCode) {
		this.finacialCode = finacialCode;
	}
	@Column(name = "C_PART_MONTHDAY")
	public String getPartMonthday() {
		return partMonthday;
	}

	public void setPartMonthday(String partMonthday) {
		this.partMonthday = partMonthday;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
