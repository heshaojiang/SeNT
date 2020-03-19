package com.grgbanking.sent.watch.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 特殊冠字号码信息
 * @author hail
 * @version 1.0
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "TRAN_ESPECIINFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class TranEspeciinfo extends BaseEntity {

	// private String id;
	private String tranId;
	private String transCode;
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
	private String especiseq;
	private String cometype;
	private String result;
	private String sequence;
	private String currency;
	private String denomination;
	private String createDate;
	private Date anyDate;
	private String specialId;
	private String note;

	// public TranEspeciinfo ( String id, String tranId, String transCode,
	// String transOrgid, String termid, String transDate, String transTime,
	// String accountNo, String journalNo, Integer transAmt, String transResult,
	// Integer transNotenum, Integer blackNotenum, Integer repeatNotenum,
	// Integer callbackNotenum, String reserve1, String reserve2, String
	// reserve3, String especiseq, String cometype, String result, String
	// sequence, String currency, String denomination, String createDate, Date
	// anyDate ,String specialId,String note) {
	// this.id = id;
	// this.tranId = tranId;
	// this.transCode = transCode;
	// this.transOrgid = transOrgid;
	// this.termid = termid;
	// this.transDate = transDate;
	// this.transTime = transTime;
	// this.accountNo = accountNo;
	// this.journalNo = journalNo;
	// this.transAmt = transAmt;
	// this.transResult = transResult;
	// this.transNotenum = transNotenum;
	// this.blackNotenum = blackNotenum;
	// this.repeatNotenum = repeatNotenum;
	// this.callbackNotenum = callbackNotenum;
	// this.reserve1 = reserve1;
	// this.reserve2 = reserve2;
	// this.reserve3 = reserve3;
	// this.especiseq = especiseq;
	// this.cometype = cometype;
	// this.result = result;
	// this.sequence = sequence;
	// this.currency = currency;
	// this.denomination = denomination;
	// this.createDate = createDate;
	// this.anyDate = anyDate;
	// this.specialId=specialId;
	// this.note=note;
	// }
	/**
	 * Constructor
	 */
	public TranEspeciinfo() {
	
	}

	// @Id
	// @GeneratedValue(generator = "system-uuid")
	// @GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	// @Column(name = "C_ID", unique = true, nullable = false)
	// public String getId() {
	// return id;
	// }
	// public void setId(String id){
	// this.id = id;
	// }
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
	 *  特殊冠字号码规则
	 *  @return especiseq</br>
	 */
	@Column(name = "C_ESPECISEQ")
	public String getEspeciseq() {
		return especiseq;
	}
	/**
	 *  @param especiseq 特殊冠字号码规则</br>
	 */
	public void setEspeciseq(String especiseq) {
		this.especiseq = especiseq;
	}
	/**
	 *  来源类型
	 *  @return cometype</br>
	 */
	@Column(name = "C_COMETYPE")
	public String getCometype() {
		return cometype;
	}
	/**
	 *  @param cometype 来源类型</br>
	 */
	public void setCometype(String cometype) {
		this.cometype = cometype;
	}
	/**
	 *  原因
	 *  @return result</br>
	 */

	@Column(name = "C_RESULT")
	public String getResult() {
		return result;
	}
	/**
	 *  @param result 原因</br>
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 *  序号
	 *  @return sequence</br>
	 */

	@Column(name = "C_SEQUENCE")
	public String getSequence() {
		return sequence;
	}
	/**
	 *  @param sequence 序号</br>
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	/**
	 *  币种
	 *  @return currency</br>
	 */
	@Column(name = "C_CURRENCY")
	public String getCurrency() {
		return currency;
	}
	/**
	 *  @param currency  币种</br>
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 *  面额
	 *  @return denomination</br>
	 */

	@Column(name = "C_DENOMINATION")
	public String getDenomination() {
		return denomination;
	}
	/**
	 *  @param denomination  面额</br>
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	/**
	 *  保存时间
	 *  @return createDate</br>
	 */

	@Column(name = "C_CREATE_DATE")
	public String getCreateDate() {
		return createDate;
	}
	/**
	 *  @param createDate  保存时间</br>
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 *  分析时间
	 *  @return anyDate</br>
	 */
	@Column(name = "D_ANY_DATE")
	public Date getAnyDate() {
		return anyDate;
	}
	/**
	 *  @param anyDate 分析时间</br>
	 */

	public void setAnyDate(Date anyDate) {
		this.anyDate = anyDate;
	}
	/**
	 *  规则号ID
	 *  @return specialId</br>
	 */
	@Column(name = "C_SPECIAL_ID")
	public String getSpecialId() {
		return specialId;
	}
	/**
	 *  @param specialId 规则号ID</br>
	 */

	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}
	/**
	 *  备注
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

}
