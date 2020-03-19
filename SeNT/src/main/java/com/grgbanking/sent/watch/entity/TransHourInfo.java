package com.grgbanking.sent.watch.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * ��ֽ�����Ϣ
 * @author ����˄1�71�1�77�1�71�1�77
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ATM_TRAN_INFO")
// @Table(name = "TRAN_INFO", schema = AppConstants.SCHEMA_NAME)
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class TransHourInfo extends BaseEntity {

	private String transCode;
	private String transOrgid;
	private String termid;

    private String tranDate;
	private String accountNo;
	private String journalNo;
	private Integer transAmt;
	private String uploadStatus;
	private String tranMonthday;
	/** �����ֶ� */
	private Integer transNotenum; // ��������
	private Integer blackNotenum; // �����Ŕ�1ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7	
	private Integer callbackNotenum;// ��������
	private String transResult; // ���׽�ￄ1�7
	private Integer repeatNotenum; // �غ�����
	private String reserve1;
	
	//���pathCode
	private String pathcode;
	private String partMonthday;
  public TransHourInfo(){
	  
  }
  public TransHourInfo(String id, String transCode,String accountNo,String transResult,Integer transNotenum,Integer blackNotenum,Integer callbackNotenum,String termid,String tranDate,String tranMonthDay,Integer repeatNotenum,String uploadStatus,String journalNo,int transAmt,String transOrgid){
	  super.setId(id);
	  this.transCode=transCode;
	  this.accountNo=accountNo;
	  this.transResult=transResult;
	  this.transNotenum=transNotenum;
	  this.repeatNotenum=repeatNotenum;
	  this.blackNotenum=blackNotenum;
	  this.termid=termid;
	  this.uploadStatus=uploadStatus;
	  this.tranDate=tranDate;
	  this.journalNo=journalNo;
	  this.transAmt=transAmt;
	  this.transOrgid=transOrgid;
	  
	
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
	
	@Column(name = "C_TRAN_MONTHDAY")
	public String getTranMonthday() {
		return tranMonthday;
	}
	public void setTranMonthday(String tranMonthday) {
		this.tranMonthday = tranMonthday;
	}
	/**
	 * @return String
	 * */
	@Column(name = "C_PATHCODE")
	public String getPathcode() {
		return pathcode;
	}
	/**
	 * @param pathcode ���pathcode
	 * */
	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}

	// �����ֶΣ�����ʱￄ1�7�1�7�1�7ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7
	private String createDate;

	// ���Ѕ�1ￄ1�7�1�7ￄ1�7�1�7ￄ1�7�1�7	
	private String provinceOrgId;



	/**
	 * ���Ѕ�1ￄ1�7�1�7
	 * 
	 * @return provinceOrgId</br>
	 **/
	@Column(name = "C_PROVINCE_ORGID")
	public String getProvinceOrgId() {
		return this.provinceOrgId;
	}

	/**
	 * @param provinceOrgId
	 *            ���Ѕ�1ￄ1�7�1�7/br>
	 **/
	public void setProvinceOrgId(String provinceOrgId) {
		this.provinceOrgId = provinceOrgId;
	}



	/**
	 * ��������
	 * 
	 * @return transNotenum</br>
	 */
	@Column(name = "I_TRANS_NOTENUM")
	public Integer getTransNotenum() {
		return transNotenum;
	}

	/**
	 * @param transNotenum
	 *            ��������</br>
	 */
	public void setTransNotenum(Integer transNotenum) {
		this.transNotenum = transNotenum;
	}

	/**
	 * �����Ŕ�1ￄ1�7�1�7
	 * 
	 * @return blackNotenum</br>
	 */
	@Column(name = "I_BLACK_NOTENUM")
	public Integer getBlackNotenum() {
		return blackNotenum;
	}

	/**
	 * @param blackNotenum
	 *            �����Ŕ�1ￄ1�7�1�7/br>
	 */
	public void setBlackNotenum(Integer blackNotenum) {
		this.blackNotenum = blackNotenum;
	}

	/**
	 * �غ�����
	 * 
	 * @return repeatNotenum</br>
	 */

	@Column(name = "I_REPEAT_NOTENUM")
	public Integer getRepeatNotenum() {
		return repeatNotenum;
	}

	/**
	 * @param repeatNotenum
	 *            �غ�����</br>
	 */
	public void setRepeatNotenum(Integer repeatNotenum) {
		this.repeatNotenum = repeatNotenum;
	}

	/**
	 * ��������
	 * 
	 * @return callbackNotenum</br>
	 */

	@Column(name = "I_CALLBACK_NOTENUM")
	public Integer getCallbackNotenum() {
		return callbackNotenum;
	}

	/**
	 * @param callbackNotenum
	 *            ��������</br>
	 */
	public void setCallbackNotenum(Integer callbackNotenum) {
		this.callbackNotenum = callbackNotenum;
	}

	/**
	 * ����ʱ��
	 * 
	 * @return createDate</br>
	 */
	@Column(name = "C_CREATE_DATE")
	public String getCreateDate() {
		return createDate;
	}

	/**
	 *@param createDate
	 *            ����ʱ��</br>
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * Constructor
	 */




	/**
	 * ���׳O1ￄ1�7�1�7
	 * 
	 * @return transCode</br>
	 */
	@Column(name = "C_TRANS_CODE")
	public String getTransCode() {
		return transCode;
	}
	
	/**
	 * @param transCode
	 *            ���׳O1ￄ1�7�1�7/br>
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	/**
	 * ���׻�
	 * 
	 * @return transOrgid</br>
	 */

	@Column(name = "C_TRANS_ORGID")
	public String getTransOrgid() {
		return transOrgid;
	}

	/**
	 * @param transOrgid
	 *            ���׻�</br>
	 */
	public void setTransOrgid(String transOrgid) {
		this.transOrgid = transOrgid;
	}

	/**
	 * ATM�ն˅�1ￄ1�7�1�7
	 * 
	 * @return termid</br>
	 */

	@Column(name = "C_TERMID")
	public String getTermid() {
		return termid;
	}

	/**
	 * @param termid
	 *            ATM�ն˅�1ￄ1�7�1�7/br>
	 */

	public void setTermid(String termid) {
		this.termid = termid;
	}


	/**
	 * ���п���
	 * 
	 * @return accountNo</br>
	 */
	@Column(name = "C_ACCOUNT_NO")
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            ���п���</br>
	 */

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * ��ˮ��1ￄ1�7�1�7
	 * 
	 * @return journalNo</br>
	 */

	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo() {
		return journalNo;
	}

	/**
	 * @param journalNo
	 *            ��ˮ��1ￄ1�7�1�7/br>
	 */

	public void setJournalNo(String journalNo) {
		this.journalNo = journalNo;
	}

	/**
	 * ���׽�ￄ1�7
	 * 
	 * @return transAmt</br>
	 */
	@Column(name = "I_TRANS_AMT")
	public Integer getTransAmt() {
		return transAmt;
	}

	/**
	 * @param transAmt
	 *            ���׽�ￄ1�7/br>
	 */

	public void setTransAmt(Integer transAmt) {
		this.transAmt = transAmt;
	}

	/**
	 * ���׽�ￄ1�7
	 * 
	 * @return transResult</br>
	 */

	@Column(name = "C_TRAN_RESULT")
	public String getTransResult() {
		return transResult;
	}

	/**
	 * @param transResult
	 *            ���׽�ￄ1�7/br>
	 */
	public void setTransResult(String transResult) {
		this.transResult = transResult;
	}

	/**
	 * @param reserve1
	 *            ��չ1</br>
	 */
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	/**
	 * ��չ1
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
