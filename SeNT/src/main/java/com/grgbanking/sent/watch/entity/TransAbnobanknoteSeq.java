package com.grgbanking.sent.watch.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 异常交易冠字号码
 * @author 广电运通
 * @version 1.0
 * V_TRANS_ALL_BANKNOTE_SEQ
 * **/
@SuppressWarnings("serial")
@Entity
@Table(name = "TRANS_ABNOBANKNOTE_SEQ")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class TransAbnobanknoteSeq extends BaseEntity {

	private String tranId;
	private String noteFlag;
	private String noteType;
	private String termid;
	private String journalNo;
	private String sequence;
	private String currency;
	private String denomination;
	private String seriaNo;
	private String pictureName;
	private String termType;
	private String tranDate;
	private String versioNum;
	private String tranMonthday;
	private String pathcode;	//机构的pathCode
	private String imageType;
	
	// { 额外的属性
	private byte[] imageArr;
	private String fullUrl;
	private Integer width;
	private Integer height;
	// } 额外的属性

	public TransAbnobanknoteSeq(){
		
	}
	public TransAbnobanknoteSeq(String id,String tranId,String noteFlag,String noteType,String currency,String denomination,
			String seriaNo,String pictureName,String tranDate,String tranMonthday){
		super.setId(id);
		this.tranId=tranId;
		this.noteFlag=noteFlag;
		this.noteType=noteType;
		this.currency=currency;
		this.seriaNo=seriaNo;
		this.pictureName=pictureName;
		this.tranMonthday=tranMonthday;
		this.tranDate=tranDate;
		this.denomination=denomination;
		
	}
	
	
	@Column(name = "C_IMAGE_TYPE")
	public String getImageType()
	{
		return imageType;
	}
	public void setImageType(String imageType)
	{
		this.imageType = imageType;
	}
	/**
	 * @return String
	 */
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
	 * 校验结果 
	 * @return checkResult </br >
	 */

	

	/**
	 * 关联ID
	 * 
	 * @return tranId</br>
	 */
	@Column(name = "C_TRAN_ID")
	public String getTranId() {
		return tranId;
	}
	 @Column(name = "C_TERM_TYPE")
	public String getTermType() {
		return termType;
	}
	public void setTermType(String termType) {
		this.termType = termType;
	}
	 @Column(name = "C_TRANS_DATE")
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	 @Column(name = "C_VERSION_NUM")
	public String getVersioNum() {
		return versioNum;
	}
	public void setVersioNum(String versioNum) {
		this.versioNum = versioNum;
	}
	  
	 @Column(name = "C_TRAN_MONTHDAY")
	public String getTranMonthday() {
		return tranMonthday;
	}
	public void setTranMonthday(String tranMonthday) {
		this.tranMonthday = tranMonthday;
	}
	/**
	 * @param tranId
	 *            关联ID</br>
	 */

	public void setTranId(String tranId) {
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
	 * ATM终端号
	 * 
	 * @return termid</br>
	 */

	@Column(name = "C_TERMID")
	public String getTermid() {
		return termid;
	}

	/**
	 * @param termid
	 *            ATM终端号</br>
	 */

	public void setTermid(String termid) {
		this.termid = termid;
	}

	/**
	 * 流水号
	 * 
	 * @return journalNo</br>
	 */

	@Column(name = "C_JOURNAL_NO")
	public String getJournalNo() {
		return journalNo;
	}

	/**
	 * @param journalNo
	 *            流水号</br>
	 */

	public void setJournalNo(String journalNo) {
		this.journalNo = journalNo;
	}
	/**
	 * 序号
	 * @return sequence</br>
	 **/
	@Column(name = "I_SEQUENCE")
	public String getSequence() {
		return sequence;
	}
	/**
	 * @param sequence  序号</br>
	 **/
	public void setSequence(String sequence) {
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
	
	////////////////
	
	@Transient
	public byte[] getImageArr()
	{
		return imageArr;
	}
	public void setImageArr(byte[] imageArr)
	{
		this.imageArr = imageArr;
	}
	
	@Transient
	public String getFullUrl()
	{
		return fullUrl;
	}
	public void setFullUrl(String fullUrl)
	{
		this.fullUrl = fullUrl;
	}
	
	@Transient
	public Integer getWidth()
	{
		return width;
	}
	public void setWidth(Integer width)
	{
		this.width = width;
	}
	
	@Transient
	public Integer getHeight()
	{
		return height;
	}
	public void setHeight(Integer height)
	{
		this.height = height;
	}

	//////////////////
	
}
