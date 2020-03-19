package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "ATM_TRAN_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class AtmTranInfo extends BaseEntity

{
	
	private String transCode;
	private String transOrgid;
	private String termId;
    private BigDecimal statisAtm;//统计金额
    private String tranDate;
	private String accountNo;
	private String journalNo;
	private BigDecimal transAtm;
	private String uploadStatus;
	
	/** �����ֶ� */
	private BigDecimal transNotenum; // 
	private BigDecimal blackNotenum; // 
	private BigDecimal callbackNotenum;// 
	private String transResult; // 
	private BigDecimal repeatNotenum; // 
	private String reserve1;
	  private String tdReserve;
	//���pathCode
	private String pathcode;
	private String partMonthday;

	// 扩展的属性 {
	private String transOrgCode;
	private String transOrgName;
	private String transOrgFullName;
	private String termTypeDesc;
	private String finacialCode;
	@Transient
	public String getTransOrgCode() {
		return transOrgCode;
	}
	public void setTransOrgCode(String transOrgCode) {
		this.transOrgCode = transOrgCode;
	}
	@Transient
	public String getTransOrgName() {
		return transOrgName;
	}
	public void setTransOrgName(String transOrgName) {
		this.transOrgName = transOrgName;
	}
	@Transient
	public String getTransOrgFullName() {
		return transOrgFullName;
	}
	public void setTransOrgFullName(String transOrgFullName) {
		this.transOrgFullName = transOrgFullName;
	}
	@Transient
	public String getTermTypeDesc() {
		return termTypeDesc;
	}
	public void setTermTypeDesc(String termTypeDesc) {
		this.termTypeDesc = termTypeDesc;
	}
	@Transient
	public String getFinacialCode() {
		return finacialCode;
	}
	public void setFinacialCode(String finacialCode) {
		this.finacialCode = finacialCode;
	}
	  
	 /**
	 ** @param statisAtm 交易总金额
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
	public BigDecimal getTransAtm() {
		return transAtm;
	}
	public void setTransAtm(BigDecimal transAtm) {
		this.transAtm = transAtm;
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
		 *   </br>
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
