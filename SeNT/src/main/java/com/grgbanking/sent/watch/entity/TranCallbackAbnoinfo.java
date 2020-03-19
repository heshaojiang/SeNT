package com.grgbanking.sent.watch.entity;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 回收异常交易监控
 * @author hail
 * @version 1.0
 */

@SuppressWarnings({"serial"})
@Entity
@Table(name = "TRAN_CALLBACK_ABNOINFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class TranCallbackAbnoinfo extends BaseEntity{

//  private String id;
  private String tranId;
  private String transOrgid;
  private String termid;
  private String transDate;
  private String transTime;
  private String accountNo;
  private String journalNo;
  private Integer transAmt;
  private String transResult;
  private Integer transNotenum;
  private Integer blackNotenum;
  private Integer repeatNotenum;
  private Integer callbackNotenum;
  private String reserve1;
  private String reserve2;
  private String reserve3;
  private String abnoCallbackType;
  private Integer outCount;
  private Integer inCount;
  private String note;
  private String createDate;
  private Date anyDate;
  private String transCode;

//       this.id = id;
//       this.tranId = tranId;
//       this.transOrgid = transOrgid;
//       this.termid = termid;
//       this.transDate = transDate;
//       this.transTime = transTime;
//       this.accountNo = accountNo;
//       this.journalNo = journalNo;
//       this.transAmt = transAmt;
//       this.transResult = transResult;
//       this.transNotenum = transNotenum;
//       this.blackNotenum = blackNotenum;
//       this.repeatNotenum = repeatNotenum;
//       this.callbackNotenum = callbackNotenum;
//       this.reserve1 = reserve1;
//       this.reserve2 = reserve2;
//       this.reserve3 = reserve3;
//       this.abnoCallbackType = abnoCallbackType;
//       this.outCount = outCount;
//       this.inCount = inCount;
//       this.note = note;
//       this.createDate = createDate;
//       this.anyDate = anyDate;
//       this.transCode = transCode;
//  }
  /**
	 * Constructors 
	 */
  public  TranCallbackAbnoinfo(){
 }
//  @Id
//  @GeneratedValue(generator = "system-uuid")
//  @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
//  @Column(name = "C_ID", unique = true, nullable = false)
//  public String getId() {
//    return id;
//  }
//  public void setId(String id){
//    this.id = id;
//  }
	/**
	 *  关联ID
	 *  @return tranId</br>
	 */
	@Column(name = "C_TRAN_ID")
	public String getTranId() {
		return tranId;
	}
	/**
	 *  @param tranId 关联ID</br>
	 */

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	
	/**
	 *  交易码
	 *  @return transCode</br>
	 */
	@Column(name = "C_TRANS_CODE")
	public String getTransCode() {
		return transCode;
	}
	/**
	 *  @param transCode 交易码</br>
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	/**
	 *  交易机构
	 *  @return transOrgid</br>
	 */

	@Column(name = "C_TRANS_ORGID")
	public String getTransOrgid() {
		return transOrgid;
	}
	/**
	 *  @param transOrgid 交易机构</br>
	 */
	public void setTransOrgid(String transOrgid) {
		this.transOrgid = transOrgid;
	}
	/**
	 *  ATM终端号
	 *  @return termid</br>
	 */

	@Column(name = "C_TERMID")
	public String getTermid() {
		return termid;
	}
	/**
	 *  @param termid ATM终端号</br>
	 */

	public void setTermid(String termid) {
		this.termid = termid;
	}
	
	/**
	 *  交易日期
	 *  @return transDate</br>
	 */

	@Column(name = "C_TRANS_DATE")
	public String getTransDate() {
		return transDate;
	}
	/**
	 *  @param transDate 交易日期</br>
	 */
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	/**
	 *  交易时间
	 *  @return transTime</br>
	 */

	@Column(name = "C_TRANS_TIME")
	public String getTransTime() {
		return transTime;
	}
	/** 
	 *  @param transTime 交易时间</br>
	 */

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	/**
	 *  银行卡号
	 *  @return accountNo</br>
	 */
	@Column(name = "C_ACCOUNT_NO")
	public String getAccountNo() {
		return accountNo;
	}
	/** 
	 *  @param accountNo 银行卡号</br>
	 */

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 *  流水号
	 *  @return journalNo</br>
	 */

	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo() {
		return journalNo;
	}
	/** 
	 *  @param journalNo  流水号</br>
	 */

	public void setJournalNo(String journalNo) {
		this.journalNo = journalNo;
	}

	/**
	 *  交易金额
	 *  @return transAmt</br>
	 */
	@Column(name = "I_TRANS_AMT")
	public Integer getTransAmt() {
		return transAmt;
	}
	/** 
	 *  @param transAmt   交易金额</br>
	 */

	public void setTransAmt(Integer transAmt) {
		this.transAmt = transAmt;
	}
	/**
	 *  交易结果
	 *  @return transResult</br>
	 */

	@Column(name = "C_TRAN_RESULT")
	public String getTransResult() {
		return transResult;
	}
	/** 
	 *  @param transResult   交易结果</br>
	 */
	public void setTransResult(String transResult) {
		this.transResult = transResult;
	}
	/**
	 *  交易张数
	 *  @return transNotenum</br>
	 */
	@Column(name = "I_TRANS_NOTENUM")
	public Integer getTransNotenum() {
		return transNotenum;
	}
	/**
	 *  @param transNotenum   交易张数</br>
	 */
	public void setTransNotenum(Integer transNotenum) {
		this.transNotenum = transNotenum;
	}
	/**
	 *  黑名单张数
	 *  @return blackNotenum</br>
	 */
	@Column(name = "I_BLACK_NOTENUM")
	public Integer getBlackNotenum() {
		return blackNotenum;
	}
	/**
	 *  @param blackNotenum   黑名单张数</br>
	 */
	public void setBlackNotenum(Integer blackNotenum) {
		this.blackNotenum = blackNotenum;
	}	
	/**
	 *  重号张数
	 *  @return repeatNotenum</br>
	 */

	@Column(name = "I_REPEAT_NOTENUM")
	public Integer getRepeatNotenum() {
		return repeatNotenum;
	}
	/**
	 *  @param repeatNotenum  重号张数</br>
	 */
	public void setRepeatNotenum(Integer repeatNotenum) {
		this.repeatNotenum = repeatNotenum;
	}
	/**
	 *  回收张数
	 *  @return callbackNotenum</br>
	 */

	@Column(name = "I_CALLBACK_NOTENUM")
	public Integer getCallbackNotenum() {
		return callbackNotenum;
	}
	/**
	 *  @param callbackNotenum  回收张数</br>
	 */
	public void setCallbackNotenum(Integer callbackNotenum) {
		this.callbackNotenum = callbackNotenum;
	}
	/**
	 *  扩展1
	 *  @return reserve1</br>
	 */
	@Column(name = "C_RESERVE1")
	public String getReserve1() {
		return reserve1;
	}
	/**
	 *  @param reserve1 扩展1</br>
	 */
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	/**
	 *  扩展2
	 *  @return reserve2</br>
	 */
	@Column(name = "C_RESERVE2")
	public String getReserve2() {
		return reserve2;
	}
	/**
	 *  @param reserve2 扩展2</br>
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	/**
	 *  扩展3
	 *  @return reserve3</br>
	 */
	@Column(name = "C_RESERVE3")
	public String getReserve3() {
		return reserve3;
	}
	/**
	 *  @param reserve3 扩展3</br>
	 */
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	
	/**
	 * 备注
	 *  @return note</br>
	 */

	@Column(name = "C_NOTE")
	public String getNote() {
		return note;
	}
	/**
	 *  @param note 备注</br>
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 保存时间
	 *  @return createDate</br>
	 */
	@Column(name = "C_CREATE_DATE")
	public String getCreateDate() {
		return createDate;
	}
	/**
	 *@param createDate 保存时间</br>
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * 分析时间
	 *  @return anyDate</br>
	 */

	@Column(name = "D_ANY_DATE")
	public Date getAnyDate() {
		return anyDate;
	}
	/**
	 *@param anyDate 分析时间</br>
	 */

	public void setAnyDate(Date anyDate) {
		this.anyDate = anyDate;
	}
	
	/**
	 *  异常回收类型
	 *  @return abnoCallbackType</br>
	 */
	@Column(name = "C_ABNO_CALLBACK_TYPE")
	public String getAbnoCallbackType() {
		return abnoCallbackType;
	}
	/**
	 *	@param abnoCallbackType 异常回收类型</br>
	 */

	public void setAbnoCallbackType(String abnoCallbackType) {
		this.abnoCallbackType = abnoCallbackType;
	}
	/**
	 *  出钞纸币张数
	 *  @return outCount</br>
	 */
	@Column(name = "I_OUT_COUNT")
	public Integer getOutCount() {
		return outCount;
	}
	/**
	 *	@param outCount 出钞纸币张数</br>
	 */

	public void setOutCount(Integer outCount) {
		this.outCount = outCount;
	}
	/**
	 *  回收纸币张数
	 *  @return inCount</br>
	 */
	@Column(name = "I_IN_COUNT"  )
	public Integer getInCount() {
		return inCount;
	}
	/**
	 *	@param inCount 回收纸币张数</br>
	 */
	public void setInCount(Integer inCount) {
		this.inCount = inCount;
	}
	
	
	
}
