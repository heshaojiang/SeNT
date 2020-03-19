package com.grgbanking.sent.watch.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;


/**
 * @author 广电运通
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TRANS_BANKNOTE_SEQ_HIS")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class TransBanknoteSeqHis extends BaseEntity{
	private String checkResult;
	private String createDate;
	private String tranId;
	private String noteFlag;
	private String noteType;
//	private String id;
	private String termid;
	private String journalNo;
	private Integer sequence;
	private String currency;
	private String denomination;
	private String cashBoxId;
	private String seriaNo;
	private String pictureName;
	private String verifyNo;
	private String urlName;
/*	private String transDate;*/
	private String tranTime;

	//版本
	private String versionNum;
	//分行号
	private String provinceOrgId;
	//交易月份
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
	
	//终端类型
	 private String termType;
	//机构的pathCode
		private String pathcode;
		/**
		 * @return String
		 * */
		@Column(name = "C_PATHCODE")
		public String getPathcode() {
			return pathcode;
		}
		/**
		 * @param pathcode 机构的pathcode
		 * */
		public void setPathcode(String pathcode) {
			this.pathcode = pathcode;
		}
	 /**
	  * @return String
	  * */
	 @Column(name = "C_TERM_TYPE")
	public String getTermType() {
		return termType;
	}
	/**
	 * @param termType 终端类型
	 * 
	 * */
	public void setTermType(String termType) {
		this.termType = termType;
	}
	/**
	 * 版本
	 * @return versionNum</br>
	 **/
	@Column(name = "C_VERSION_NUM")
	public String getVersionNum(){
		return this.versionNum;
	}
	/**
	 * @param versionNum 版本</br>
	 **/
	public void setVersionNum(String versionNum){
		this.versionNum = versionNum;
	}
	
	/**
	 * 分行号
	 * @return  provinceOrgId</br>
	 **/
	@Column(name = "C_PROVINCE_ORGID")
	public String getProvinceOrgId(){
		return this.provinceOrgId;
	}
	/**
	 * @param   provinceOrgId 分行号</br>
	 **/
	public void setProvinceOrgId(String provinceOrgId){
		this.provinceOrgId = provinceOrgId;
	}
	
	/**

	/**
	 * 校验结果 
	 * @return checkResult </br >
	 */

	@Column(name = "C_CHECK_RESULT")
	public String getCheckResult() {
		return checkResult;
	}

	/**
	 * @param checkResult   校验结果</br>
	 *        
	 */

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
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
	 * 关联ID
	 * @return tranId</br>
	 **/
	
	@Column(name = "C_TRAN_ID")
	public String getTranId(){
		return this.tranId;
	}
	/**
	 * @param  tranId 关联ID</br>
	 **/
	public void setTranId(String tranId){
		this.tranId = tranId;
	}
	/**
	 * 纸币标识
	 * @return noteFlag</br>
	 **/
	@Column(name = "C_NOTE_FLAG")
	public String getNoteFlag(){
		return this.noteFlag;
	} 
	/**
	 * @param  noteFlag 纸币标识</br>
	 **/
	public void setNoteFlag(String noteFlag){
		this.noteFlag = noteFlag;
	}

	/**
	 * 纸币类别
	 * @return  noteType</br>
	 **/
	@Column(name = "C_NOTE_TYPE")
	public String getNoteType(){
		return this.noteType;
	}
	/**
	 *  @param noteType  纸币类别</br>
	 **/
	public void setNoteType(String noteType){
		this.noteType = noteType;
	}

//	@Id
//	@Column(name = "C_ID", unique = true, nullable = false)
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

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
	 * 序号
	 * @return sequence</br>
	 **/
	@Column(name = "I_SEQUENCE")
	public Integer getSequence() {
		return this.sequence;
	}
	/**
	 * @param sequence  序号</br>
	 **/
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	/**
	 * 币种
	 * @return currency</br>
	 **/
	@Column(name = "C_CURRENCY")
	public String getCurrency(){
		return this.currency;
	}
	/**
	 * @param currency 币种</br>
	 **/
	public void setCurrency(String currency){
		this.currency = currency;
	}


	/**
	 * 面额
	 * @return denomination </br>
	 **/
	@Column(name = "C_DENOMINATION")
	public String getDenomination(){
		return this.denomination;
	}
	/**
	 * @param denomination 面额</br>
	 **/ 
	public void setDenomination(String denomination){
		this.denomination = denomination;
	}
	/**
	 * 钞箱ID
	 * @return cashBoxId</br>
	 **/
	@Column(name = "C_CASH_BOX_ID")
	public String getCashBoxId(){
		return this.cashBoxId;
	}
	/**
	 * @param cashBoxId 钞箱ID</br>
	 **/
	public void setCashBoxId(String cashBoxId){
		this.cashBoxId = cashBoxId;
	}

	/**
	 * 纸币冠字号码
	 * @return seriaNo</br>
	 **/
	@Column(name = "C_SERIA_NO")
	public String getSeriaNo(){
		return this.seriaNo;
	}
	
	/**
	 * @param seriaNo 纸币冠字号码</br>
	 **/
	public void setSeriaNo(String seriaNo){
		this.seriaNo = seriaNo;
	}

	/**
	 * 图片名
	 * @return pictureName</br>
	 **/
	@Column(name = "C_PICTURE_NAME")
	public String getPictureName(){
		return this.pictureName;
	}
	/**
	 *@param  pictureName 图片名</br>
	 **/
	public void setPictureName(String pictureName){
		this.pictureName = pictureName;
	}

	/**
	 * 校验码
	 * @return verifyNo</br>
	 **/
	@Column(name = "C_VERIFY_NO")
	public String getVerifyNo(){
		return this.verifyNo;
	}
	/**
	 * @param  verifyNo 校验码</br>
	 **/ 
	public void setVerifyNo(String verifyNo){
		this.verifyNo = verifyNo;
	}
	/**
	 *图片路径
	 *@return  urlName</br>
	 **/
	
	@Column(name = "C_URL_NAME")
	public String getUrlName(){
		return this.urlName;
	}
	/**
	 *@param  urlName 图片路径</br>
	 **/
	public void setUrlName(String urlName){
		this.urlName = urlName;
	}

	/**
	 * 时间
	 * @return  tranTime</br>
	 **/
	@Column(name = "C_TRANS_TIME")
	public String getTranTime(){
		return this.tranTime;
	}
	/**
	 * @param tranTime 时间</br>
	 **/
	public void setTranTime(String tranTime){
		this.tranTime = tranTime;
	}
}
