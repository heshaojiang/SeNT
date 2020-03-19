package com.grgbanking.cml.task.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;



/**
 * 清分纸币冠字号码
 * @author 广电运通
 * @version :1.0 </br>
 **/

@SuppressWarnings("serial")
@Entity
@Table(name = "CML_SENT_INFOS_2")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class CmlSentInfos extends BaseEntity {
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
	private String tranYear;
	private String tranTime;
	private String checkResult;
	private String createDate;
	private String tranId;
	private String noteFlag;
	private String noteType;
	private String moneyType;
	private String impFlag;
	private String provinceOrgId;
	private String orgId;
	private String versionNum;
    private String tranMonthday;
	private Double seriaNum;
	private String errorCode;
	private String machineSno;
	private Double seriaSureNo;
	private Double seriaImgHeight;
	private Double seriaImgWidth;
	private String reserve;
	private String reserve2;
	private Integer serialSnseq;
	private String urlFilename;
	
	/**
	 * @return the tranMonthday
	 */
   
    @Column(name = " C_TRAN_MONTHDAY")
	public String getTranMonthday() {
		return tranMonthday;
	}
	/**
	 * @return the serialSnseq
	 */
    @Column(name = "I_SERIAL_SNSEQ")
	public Integer getSerialSnseq() {  
		return serialSnseq;
	}
	/**
	 * @param serialSnseq the serialSnseq to set
	 */
	public void setSerialSnseq(Integer serialSnseq) {
		this.serialSnseq = serialSnseq;
	}
	/**
	 * @return the urlFilename
	 */
	@Column(name = "C_URL_FILENAME")
	public String getUrlFilename() {
		return urlFilename;
	}
	/**
	 * @param urlFilename the urlFilename to set
	 */
	public void setUrlFilename(String urlFilename) {
		this.urlFilename = urlFilename;
	}
	/**
	 * @param tranMonthday the tranMonthday to set
	 */
	public void setTranMonthday(String tranMonthday) {
		this.tranMonthday = tranMonthday;
	}

	//机构的pathCode
	private String pathcode;
	/**
	 * @return the seriaNum
	 */


	
	//终端类型
	 private String termType;
	/**
	 * @return the seriaNum
	 */
	 @Column(name = "I_SERIA_NUM")
	public Double getSeriaNum() {
		return seriaNum;
	}
	/**
	 * @param seriaNum the seriaNum to set
	 */
	public void setSeriaNum(Double seriaNum) {
		this.seriaNum = seriaNum;
	}
	/**
	 * @return the errorCode
	 */
	@Column(name = "C_ERROR_CODE")
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the machineSno
	 */
	@Column(name = "C_MACHINE_SNO")
	public String getMachineSno() {
		return machineSno;
	}
	/**
	 * @param machineSno the machineSno to set
	 */
	public void setMachineSno(String machineSno) {
		this.machineSno = machineSno;
	}
	/**
	 * @return the seriaSureNo
	 */
	@Column(name = "I_SERIA_SURE_NO")
	public Double getSeriaSureNo() {
		return seriaSureNo;
	}
	/**
	 * @param seriaSureNo the seriaSureNo to set
	 */
	public void setSeriaSureNo(Double seriaSureNo) {
		this.seriaSureNo = seriaSureNo;
	}
	/**
	 * @return the tranYear
	 */
	@Column(name = "C_TRANS_YEAR")
	public String getTranYear() {
		return tranYear;
	}
	/**
	 * @param tranYear the tranYear to set
	 */
	public void setTranYear(String tranYear) {
		this.tranYear = tranYear;
	}
	/**
	 * @return the seriaImgHeight
	 */
	@Column(name = "I_SERIA_IMG_HEIGHT")
	public Double getSeriaImgHeight() {
		return seriaImgHeight;
	}
	/**
	 * @param seriaImgHeight the seriaImgHeight to set
	 */
	public void setSeriaImgHeight(Double seriaImgHeight) {
		this.seriaImgHeight = seriaImgHeight;
	}
	/**
	 * @return the seriaImgWidth
	 */
	@Column(name = "I_SERIA_IMG_WIDTH")
	public Double getSeriaImgWidth() {
		return seriaImgWidth;
	}
	/**
	 * @param seriaImgWidth the seriaImgWidth to set
	 */
	public void setSeriaImgWidth(Double seriaImgWidth) {
		this.seriaImgWidth = seriaImgWidth;
	}
	/**
	 * @return the reserve
	 */
	@Column(name = "C_RESERVE")
	public String getReserve() {
		return reserve;
	}
	/**
	 * @param reserve the reserve to set
	 */
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	/**
	 * @return the reserve2
	 */
	@Column(name = "C_RESERVE2")
	public String getReserve2() {
		return reserve2;
	}
	/**
	 * @param reserve2 the reserve2 to set
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
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
	 * ATM编号
	 * @return termId</br>
	 **/
	@Column(name = "C_TERMID")
	public String getTermId(){
		return this.termId;
	}
	/**
	 *@param termId  ATM编号</br>
	 **/
	public void setTermId(String termId){
		this.termId = termId;
	}
	
	/**
	 * 流水号
	 * @return journalNo</br>
	 **/
	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo(){
		return this.journalNo;
	}
	/**
	 * @param journalNo 流水号</br>
	 **/
	public void setJournalNo(String journalNo){
		this.journalNo = journalNo;
	}
	
	/**
	 * 序号
	 * @return sequence</br>
	 **/
	@Column(name = "I_SEQUENCE")
	public Integer getSequence(){
		return this.sequence;
	}
	/**
	 * @param sequence  序号</br>
	 **/
	public void setSequence(Integer sequence){
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
	/**
	 *  校验结果
	 *  @return checkResult</br>
	 **/
	@Column(name = "C_CHECK_RESULT")
	public String getCheckResult(){
		return this.checkResult;
	}
	/**
	 * @param  checkResult 校验结果</br>
	 **/
	public void setCheckResult(String checkResult){
		this.checkResult = checkResult;
	}
	
	/**
	 * 保存时间
	 * @return  createDate</br>
	 **/
	@Column(name = "C_CREATE_DATE")
	public String getCreateDate(){
		return this.createDate;
	}
	/**
	 * @param createDate 保存时间</br>
	 **/
	public void setCreateDate(String createDate){
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
	/**
	 * 清分类型
	 * @return moneyType</br>
	 **/
	@Column(name = "C_MONEY_TYPE")
	public String getMoneyType(){
		return this.moneyType;
	}
	/**
	 *  @param moneyType  清分类型</br>
	 **/
	public void setMoneyType(String moneyType){
		this.moneyType = moneyType;
	}
	/**
	 * 产生方式
	 * @return  impFlag</br>
	 **/
	@Column(name = "C_IMP_FLAG")
	public String getImpFlag(){
		return this.impFlag;
	}
	/**
	 * @param  impFlag 产生方式</br>
	 **/
	public void setImpFlag(String impFlag){
		this.impFlag = impFlag;
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
	 * 所属机构ID
	 * @return orgId</br>
	 **/
	@Column(name = "C_ORGID")
	public String getOrgId(){
		return this.orgId;
	}
	/**
	 * @param  orgId 所属机构ID</br>
	 **/
	public void setOrgId(String orgId){
		this.orgId = orgId;
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
	
	
}
