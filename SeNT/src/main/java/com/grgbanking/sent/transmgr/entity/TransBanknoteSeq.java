package com.grgbanking.sent.transmgr.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * ʵʱ������ͼ
 * @author �����ͨ
 * @version :1.0 </br>
 **/

@SuppressWarnings("serial")
@Entity
@Table(name = "TRANS_BANKNOTE_SEQ")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class TransBanknoteSeq extends BaseEntity {
	
	private String checkResult;
	private String tranId;
	private String noteFlag;
	private String noteType;
	private String createDate;

	private String termId;
	private String journalNo;
	private Integer sequence;
	private String currency;
	private String denomination;
	private String cashBoxId;
	private String seriaNo;
	private String pictureName;
	private String verifyNo;
	private String urlName;

	private String tranTime;

	//�汾
	private String versionNum;
	//���к�
	private String provinceOrgId;
/*	//�����·�
	private Integer tranMonth;
	//������
	private Integer tranDay;*/
	//�ն�����
	 private String termType;
	//���pathCode
	private String pathcode;
	private String transYear;
	private String tranMonthDay;	
		@Column(name="C_TRANS_YEAR")
		public String getTransYear() {
			return transYear;
		}
		public void setTransYear(String transYear) {
			this.transYear = transYear;
		}
		
		@Column(name="C_TRAN_MONTHDAY")
		public String getTranMonthDay() {
			return tranMonthDay;
		}
		public void setTranMonthDay(String tranMonthDay) {
			this.tranMonthDay = tranMonthDay;
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
	 /**
	  * @return String
	  **/
	 @Column(name = "C_TERM_TYPE")
	public String getTermType() {
		return termType;
	}
	/**
	 * @param termType �ն�����
	 * 
	 * */
	public void setTermType(String termType) {
		this.termType = termType;
	}
	/**
	 * ATM���
	 * @return termId</br>
	 **/
	@Column(name = "C_TERM_ID")
	public String getTermId(){
		return this.termId;
	}
	/**
	 *@param termId  ATM���</br>
	 **/
	public void setTermId(String termId){
		this.termId = termId;
	}
	
	/**
	 * ��ˮ��
	 * @return journalNo</br>
	 **/
	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo(){
		return this.journalNo;
	}
	/**
	 * @param journalNo ��ˮ��</br>
	 **/
	public void setJournalNo(String journalNo){
		this.journalNo = journalNo;
	}
	
	/**
	 * ���
	 * @return sequence</br>
	 **/
	@Column(name = "I_SEQUENCE")
	public Integer getSequence(){
		return this.sequence;
	}
	/**
	 * @param sequence  ���</br>
	 **/
	public void setSequence(Integer sequence){
		this.sequence = sequence;
	}
	
	/**
	 * ����
	 * @return currency</br>
	 **/
	@Column(name = "C_CURRENCY")
	public String getCurrency(){
		return this.currency;
	}
	/**
	 * @param currency ����</br>
	 **/
	public void setCurrency(String currency){
		this.currency = currency;
	}
	/**
	 * ���
	 * @return denomination </br>
	 **/
	@Column(name = "C_DENOMINATION")
	public String getDenomination(){
		return this.denomination;
	}
	/**
	 * @param denomination ���</br>
	 **/ 
	public void setDenomination(String denomination){
		this.denomination = denomination;
	}
	/**
	 * ����ID
	 * @return cashBoxId</br>
	 **/
	@Column(name = "C_CASH_BOX_ID")
	public String getCashBoxId(){
		return this.cashBoxId;
	}
	/**
	 * @param cashBoxId ����ID</br>
	 **/
	public void setCashBoxId(String cashBoxId){
		this.cashBoxId = cashBoxId;
	}
	
	/**
	 * ֽ�ҹ��ֺ���
	 * @return seriaNo</br>
	 **/
	@Column(name = "C_SERIA_NO")
	public String getSeriaNo(){
		return this.seriaNo;
	}
	
	/**
	 * @param seriaNo ֽ�ҹ��ֺ���</br>
	 **/
	public void setSeriaNo(String seriaNo){
		this.seriaNo = seriaNo;
	}
	/**
	 * ͼƬ��
	 * @return pictureName</br>
	 **/
	@Column(name = "C_PICTURE_NAME")
	public String getPictureName(){
		return this.pictureName;
	}
	/**
	 *@param  pictureName ͼƬ��</br>
	 **/
	public void setPictureName(String pictureName){
		this.pictureName = pictureName;
	}
	/**
	 * У����
	 * @return verifyNo</br>
	 **/
	@Column(name = "C_VERIFY_NO")
	public String getVerifyNo(){
		return this.verifyNo;
	}
	/**
	 * @param  verifyNo У����</br>
	 **/ 
	public void setVerifyNo(String verifyNo){
		this.verifyNo = verifyNo;
	}
	/**
	 *ͼƬ·��
	 *@return  urlName</br>
	 **/
	
	@Column(name = "C_URL_NAME")
	public String getUrlName(){
		return this.urlName;
	}
	/**
	 *@param  urlName ͼƬ·��</br>
	 **/
	public void setUrlName(String urlName){
		this.urlName = urlName;
	}
	/**
	 * ʱ��
	 * @return  tranTime</br>
	 **/
	@Column(name = "C_TRANS_TIME")
	public String getTranTime(){
		return this.tranTime;
	}
	/**
	 * @param tranTime ʱ��</br>
	 **/
	public void setTranTime(String tranTime){
		this.tranTime = tranTime;
	}
	/**
	 *  У����
	 *  @return checkResult</br>
	 **/
	@Column(name = "C_CHECK_RESULT")
	public String getCheckResult(){
		return this.checkResult;
	}
	/**
	 * @param  checkResult У����</br>
	 **/
	public void setCheckResult(String checkResult){
		this.checkResult = checkResult;
	}
	
	/**
	 * ����ʱ��
	 * @return  createDate</br>
	 **/
	@Column(name = "C_CREATE_DATE")
	public String getCreateDate(){
		return this.createDate;
	}
	/**
	 * @param createDate ����ʱ��</br>
	 **/
	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}
	/**
	 * ��jID
	 * @return tranId</br>
	 **/
	
	@Column(name = "C_TRAN_ID")
	public String getTranId(){
		return this.tranId;
	}
	/**
	 * @param  tranId ��jID</br>
	 **/
	public void setTranId(String tranId){
		this.tranId = tranId;
	}
	/**
	 * ֽ�ұ�ʶ
	 * @return noteFlag</br>
	 **/
	@Column(name = "C_NOTE_FLAG")
	public String getNoteFlag(){
		return this.noteFlag;
	} 
	/**
	 * @param  noteFlag ֽ�ұ�ʶ</br>
	 **/
	public void setNoteFlag(String noteFlag){
		this.noteFlag = noteFlag;
	}
	/**
	 * ֽ�����
	 * @return  noteType</br>
	 **/
	@Column(name = "C_NOTE_TYPE")
	public String getNoteType(){
		return this.noteType;
	}
	/**
	 *  @param noteType  ֽ�����</br>
	 **/
	public void setNoteType(String noteType){
		this.noteType = noteType;
	}
	
	
	/**
	 * ���к�
	 * @return  provinceOrgId</br>
	 **/
	@Column(name = "C_PROVINCE_ORGID")
	public String getProvinceOrgId(){
		return this.provinceOrgId;
	}
	/**
	 * @param   provinceOrgId ���к�</br>
	 **/
	public void setProvinceOrgId(String provinceOrgId){
		this.provinceOrgId = provinceOrgId;
	}
	
	/**
	 * �汾
	 * @return versionNum</br>
	 **/
	@Column(name = "C_VERSION_NUM")
	public String getVersionNum(){
		return this.versionNum;
	}
	/**
	 * @param versionNum �汾</br>
	 **/
	public void setVersionNum(String versionNum){
		this.versionNum = versionNum;
	}
	

	
}

