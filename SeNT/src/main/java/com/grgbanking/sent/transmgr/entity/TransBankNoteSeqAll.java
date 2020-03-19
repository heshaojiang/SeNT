package com.grgbanking.sent.transmgr.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * @author 广电运�1�7�1�7
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_SENT_ALL_SEQ")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class TransBankNoteSeqAll extends BaseEntity {
	private String checkResult;
	private String createDate;
	private String tranId;
	private String noteFlag;
	private String noteType;
	// private String id;
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
	private String transYear;
	private String tranTime;
	// 版本
	private String versionNum;
	// 分行叄1�7
	private String provinceOrgId;
	// 交易月份
	private String tranMonthday;
	// 交易旄1�7
	private String typeFlag;
	private String seriaimgFlag;
	
	public TransBankNoteSeqAll(){
		   
	   }
	   public TransBankNoteSeqAll(String id,String tranId,String seriaNo,String currency,String denomination,String termId ,String noteType ,String seriaimgFlag,String transYear,String tranMonthday ,String tranTime,String termType){
		   super.setId(id);
		  this.tranId=tranId;
		  this.seriaNo=seriaNo;
		  this.currency=currency;
		  this.denomination=denomination;
		  this.termId=termId;
		  this.noteType=noteType;
		  this.seriaimgFlag=seriaimgFlag;
		  this.transYear=transYear;
		  this.tranMonthday=tranMonthday;
		  this.tranTime=tranTime;
		  this.termType=termType;
	   }
	/**
	 * @param urlFilename the urlFilename to set
	 */

	/**
	 * @return the seriaimgFlag
	 */
	@Column(name = "C_SERIAIMG_FLAG")
	public String getSeriaimgFlag() {
		return seriaimgFlag;
	}
	/**
	 * @param seriaimgFlag the seriaimgFlag to set
	 */
	public void setSeriaimgFlag(String seriaimgFlag) {
		this.seriaimgFlag = seriaimgFlag;
	}
	//"" as ""
	/**
	 * @return the typeFlag
	 */
	@Column(name = "C_TYPE_FLAG")
	public String getTypeFlag() {
		return typeFlag;
	}
	/**
	 * @param typeFlag the typeFlag to set
	 */
	public void setTypeFlag(String typeFlag) {
		this.typeFlag = typeFlag;
	}
	//
	/**
	 * @return the transYear
	 */
	@Column(name = "C_TRANS_YEAR")
	public String getTransYear() {
		return transYear;
	}
	/**
	 * @param transYear the transYear to set
	 */
	public void setTransYear(String transYear) {
		this.transYear = transYear;
	}
	/**
	 * @return the tranMonthday
	 */
	@Column(name = "C_TRAN_MONTHDAY")
	public String getTranMonthday() {
		return tranMonthday;
	}
	/**
	 * @param tranMonthday the tranMonthday to set
	 */
	public void setTranMonthday(String tranMonthday) {
		this.tranMonthday = tranMonthday;
	}

	// 终端类型
	private String termType;
	private String isType;
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
	@Column(name = "C_IS_TYPE")
	public String getIsType() {
		return isType;
	}
	/**
	 * @param isType 区分的类垄1�7
	 * */
	
	public void setIsType(String isType) {
		this.isType = isType;
	}
	

	/**
	 * @return String
	 * */
	 @Column(name = "C_TERM_TYPE")
	public String getTermType() {
		return termType;
	}

	/**
	 * @param termType
	 * 终端类型
	 * 
	 * */
	public void setTermType(String termType) {
		this.termType = termType;
	}

	/**
	 * 版本
	 * 
	 * @return versionNum</br>
	 **/
	@Column(name = "C_VERSION_NUM")
	public String getVersionNum() {
		return this.versionNum;
	}

	/**
	 * @param versionNum
	 *            版本</br>
	 **/
	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}

	/**
	 * 分行叄1�7
	 * 
	 * @return provinceOrgId</br>
	 **/
	@Column(name = "C_PROVINCE_ORGID")
	public String getProvinceOrgId() {
		return this.provinceOrgId;
	}

	/**
	 * @param provinceOrgId
	 *            分行叄1�7/br>
	 **/
	public void setProvinceOrgId(String provinceOrgId) {
		this.provinceOrgId = provinceOrgId;
	}

	

	/**
	 * 校验结果
	 * 
	 * @return checkResult </br >
	 */

	@Column(name = "C_CHECK_RESULT")
	public String getCheckResult() {
		return checkResult;
	}

	/**
	 * @param checkResult
	 *            校验结果</br>
	 * 
	 */

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	/**
	 * 保存时间
	 * 
	 * @return createDate</br>
	 */
	@Column(name = "C_CREATE_DATE")
	public String getCreateDate() {
		return createDate;
	}

	/**
	 *@param createDate
	 *            保存时间</br>
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * 关联ID
	 * 
	 * @return tranId</br>
	 **/

	@Column(name = "C_TRAN_ID")
	public String getTranId() {
		return this.tranId;
	}

	/**
	 * @param tranId
	 *            关联ID</br>
	 **/
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	/**
	 * 纸币标识
	 * 
	 * @return noteFlag</br>
	 **/
	@Column(name = "C_NOTE_FLAG")
	public String getNoteFlag() {
		return this.noteFlag;
	}

	/**
	 * @param noteFlag
	 *            纸币标识</br>
	 **/
	public void setNoteFlag(String noteFlag) {
		this.noteFlag = noteFlag;
	}

	/**
	 * 纸币类别
	 * 
	 * @return noteType</br>
	 **/
	@Column(name = "C_NOTE_TYPE")
	public String getNoteType() {
		return this.noteType;
	}

	/**
	 * @param noteType
	 *            纸币类别</br>
	 **/
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}

	// @Id
	// @Column(name = "C_ID", unique = true, nullable = false)
	// public String getId() {
	// return id;
	// }
	//
	// public void setId(String id) {
	// this.id = id;
	// }

	/**
	 * ATM终端叄1�7
	 * 
	 * @return termid</br>
	 */

	
	

	/**
	 * 流水叄1�7
	 * 
	 * @return journalNo</br>
	 */

	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo() {
		return journalNo;
	}
	@Column(name = "C_TERM_ID")
	public String getTermId() {
		return termId;
	}
	public void setTermId(String termId) {
		this.termId = termId;
	}
	/**
	 * @param journalNo
	 *            流水叄1�7/br>
	 */

	public void setJournalNo(String journalNo) {
		this.journalNo = journalNo;
	}

	/**
	 * 序号
	 * 
	 * @return sequence</br>
	 **/
	@Column(name = "I_SEQUENCE")
	public Integer getSequence() {
		return this.sequence;
	}

	/**
	 * @param sequence
	 *            序号</br>
	 **/
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * 币种
	 * 
	 * @return currency</br>
	 **/
	@Column(name = "C_CURRENCY")
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * @param currency
	 *            币种</br>
	 **/
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 面额
	 * 
	 * @return denomination </br>
	 **/
	@Column(name = "C_DENOMINATION")
	public String getDenomination() {
		return this.denomination;
	}

	/**
	 * @param denomination
	 *            面额</br>
	 **/
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	/**
	 * 钞箱ID
	 * 
	 * @return cashBoxId</br>
	 **/
	@Column(name = "C_CASH_BOX_ID")
	public String getCashBoxId() {
		return this.cashBoxId;
	}

	/**
	 * @param cashBoxId
	 *            钞箱ID</br>
	 **/
	public void setCashBoxId(String cashBoxId) {
		this.cashBoxId = cashBoxId;
	}

	/**
	 * 纸币冠字号码
	 * 
	 * @return seriaNo</br>
	 **/
	@Column(name = "C_SERIA_NO")
	public String getSeriaNo() {
		return this.seriaNo;
	}

	/**
	 * @param seriaNo
	 *            纸币冠字号码</br>
	 **/
	public void setSeriaNo(String seriaNo) {
		this.seriaNo = seriaNo;
	}

	/**
	 * 图片各1�7
	 * 
	 * @return pictureName</br>
	 **/
	@Column(name = "C_PICTURE_NAME")
	public String getPictureName() {
		return this.pictureName;
	}

	/**
	 *@param pictureName
	 *            图片各1�7/br>
	 **/
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	/**
	 * 校验砄1�7
	 * 
	 * @return verifyNo</br>
	 **/
	@Column(name = "C_VERIFY_NO")
	public String getVerifyNo() {
		return this.verifyNo;
	}

	/**
	 * @param verifyNo
	 *            校验砄1�7/br>
	 **/
	public void setVerifyNo(String verifyNo) {
		this.verifyNo = verifyNo;
	}

	/**
	 *图片路径
	 * 
	 * @return urlName</br>
	 **/

	@Column(name = "C_URL_NAME")
	public String getUrlName() {
		return this.urlName;
	}

	/**
	 *@param urlName
	 *            图片路径</br>
	 **/
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	

	/**
	 * 时间
	 * 
	 * @return tranTime</br>
	 **/
	@Column(name = "C_TRANS_TIME")
	public String getTranTime() {
		return this.tranTime;
	}

	/**
	 * @param tranTime
	 *            时间</br>
	 **/
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
}
