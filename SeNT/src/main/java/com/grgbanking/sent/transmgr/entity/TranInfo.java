package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 
 * @author
 * @version :1.0 </br>
 **/

@SuppressWarnings("serial")
@Entity
// @Table(name = "TRAN_INFO", schema = AppConstants.SCHEMA_NAME)
@Table(name = "ATM_TRAN_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class TranInfo extends BaseEntity {

	private String transCode;
	private String transOrgid;
	private String termId;
	private BigDecimal statisAtm;// 统计金额
	private String tranDate;
	private String tranTime;
	private String accountNo;
	private String journalNo;
	private BigDecimal transAmt;
	private String uploadStatus;

	/** �����ֶ� */
	private BigDecimal transNotenum; // 
	private BigDecimal blackNotenum; // 
	private BigDecimal callbackNotenum;// 
	private String transResult; // 
	private BigDecimal repeatNotenum; // 
	private String reserve1;
	private String tdReserve;
	// ���pathCode
	private String pathcode;
	private String partMonthday;

	public TranInfo() {

	}

	public TranInfo(String id, String transCode, String accountNo,
			String transResult, BigDecimal transNotenum,
			BigDecimal blackNotenum, BigDecimal callbackNotenum, String termId,
			String tranTime, BigDecimal repeatNotenum, String uploadStatus,
			BigDecimal transAmt, String journalNo, String transOrgid,
			BigDecimal statisAtm) {
		super.setId(id);
		this.transCode = transCode;
		this.accountNo = accountNo;
		this.transResult = transResult;
		this.transNotenum = transNotenum;
		this.blackNotenum = blackNotenum;
		this.callbackNotenum = callbackNotenum;
		this.termId = termId;
		this.tranTime = tranTime;
		this.repeatNotenum = repeatNotenum;
		this.uploadStatus = uploadStatus;
		this.journalNo = journalNo;
		this.transAmt = transAmt;
		this.transOrgid = transOrgid;
		this.statisAtm = statisAtm;

	}

	public TranInfo(String id, String transCode, String accountNo,
			String transResult, BigDecimal transNotenum,
			BigDecimal blackNotenum, BigDecimal callbackNotenum, String termId,
			String tranTime, String tranMonthDay, BigDecimal repeatNotenum,
			String uploadStatus, BigDecimal transAmt, BigDecimal statisAtm) {
		super.setId(id);
		this.transCode = transCode;
		this.accountNo = accountNo;
		this.transResult = transResult;
		this.transNotenum = transNotenum;
		this.blackNotenum = blackNotenum;
		this.callbackNotenum = callbackNotenum;
		this.termId = termId;
		this.tranTime = tranTime;
		this.repeatNotenum = repeatNotenum;
		this.uploadStatus = uploadStatus;
		this.transAmt = transAmt;
		this.statisAtm = statisAtm;
	}

	/**
	 ** @param statisAtm
	 *            交易总金额
	 */
	@Column(name = "I_STATIS_AMT")
	public BigDecimal getStatisAtm() {
		return statisAtm;
	}

	public void setStatisAtm(BigDecimal statisAtm) {
		this.statisAtm = statisAtm;
	}

	@Column(name = "C_TRAN_RESULT")
	public String getTransResult() {
		return transResult;
	}

	public void setTransResult(String transResult) {
		this.transResult = transResult;
	}

	@Column(name = "I_TRAN_COUNT")
	public BigDecimal getTransNotenum() {
		return transNotenum;
	}

	public void setTransNotenum(BigDecimal transNotenum) {
		this.transNotenum = transNotenum;
	}

	@Column(name = "I_BLACK_COUNT")
	public BigDecimal getBlackNotenum() {
		return blackNotenum;
	}

	public void setBlackNotenum(BigDecimal blackNotenum) {
		this.blackNotenum = blackNotenum;
	}

	@Column(name = "I_REPEAT_COUNT")
	public BigDecimal getRepeatNotenum() {
		return repeatNotenum;
	}

	public void setRepeatNotenum(BigDecimal repeatNotenum) {
		this.repeatNotenum = repeatNotenum;
	}

	@Column(name = "I_CALLBACK_COUNT")
	public BigDecimal getCallbackNotenum() {
		return callbackNotenum;
	}

	public void setCallbackNotenum(BigDecimal CallbackNotenum) {
		this.callbackNotenum = callbackNotenum;
	}

	@Column(name = "C_TD_ACCOUNT_NO")
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@Column(name = "C_TD_JOURNAL_NO")
	public String getJournalNo() {
		return journalNo;
	}

	public void setJournalNo(String journalNo) {
		this.journalNo = journalNo;
	}

	@Column(name = "I_TD_TRAN_AMT")
	public BigDecimal getTransAmt() {
		return transAmt;
	}

	public void setTransAmt(BigDecimal transAmt) {
		this.transAmt = transAmt;
	}

	@Column(name = "C_TD_RESERVE")
	public String getTdReserve() {
		return tdReserve;
	}

	public void setTdReserve(String tdReserve) {
		this.tdReserve = tdReserve;
	}

	@Column(name = "C_TRAN_DATE")
	public String getTranDate() {

		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	@Column(name = "C_TRAN_TIME")
	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	@Column(name = "C_UPLOAD_STATUS")
	public String getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	/**
	 * @return String
	 * */
	@Column(name = "C_PATHCODE")
	public String getPathcode() {
		return pathcode;
	}

	/**
	 * @param pathcode
	 * */
	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}

	/**
	 * 
	 * 
	 * @return transCode
	 */
	@Column(name = "C_TRAN_CODE")
	public String getTransCode() {
		return transCode;
	}

	/**
	 * @param transCode
	 * 
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	/**
	 * 
	 * 
	 * @return transOrgid
	 */

	@Column(name = "C_TRAN_ORGID")
	public String getTransOrgid() {
		return transOrgid;
	}

	/**
	 * @param transOrgid
	 *            </br>
	 */
	public void setTransOrgid(String transOrgid) {
		this.transOrgid = transOrgid;
	}

	/**
	 * 
	 * 
	 * @return termid</br>
	 */

	@Column(name = "C_TERM_ID")
	public String getTermId() {
		return termId;
	}

	/**
	 * @param termid
	 * 
	 */

	public void setTermId(String termId) {
		this.termId = termId;
	}

	/**
	 * @param reserve1
	 * 
	 */
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	/**
	 * 
	 * 
	 * @return reserve1</br>
	 */
	@Column(name = "C_RESERVE1")
	public String getReserve1() {
		return reserve1;
	}

	@Column(name = "C_PART_MONTHDAY")
	public String getPartMonthday() {
		return partMonthday;
	}

	public void setPartMonthday(String partMonthday) {
		this.partMonthday = partMonthday;
	}

}