package com.grgbanking.sent.checkin.entity;
/**
 * @author whxing
 * 人民币人民币冠字号码检索登记表实体
 * SerialSearchInfo
 */
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;
@SuppressWarnings("serial")
@Entity
@Table(name="SMS_SERIAL_SEARCH_RECORD")
@AttributeOverride(name="id", column=@Column(name="C_ID"))

public class SerialSearchInfo extends BaseEntity {

	//检索时间
	private Date searchDate;
	//检索人
	private String operatorName;
	//冠字号码保管人
	private String serialKeeper;
	//冠字号记录渠道
	private String noteRecordType;
	//记录时间
	private Date recordDate;
	//冠字号
	private String serialNo;
	//相同冠字数量
	private int serialCount; 
	//检索结果
	private String noteType;
	//冠字号查询结果
	private int serialResult;
	
	/**
	 * 检索时间
	 * @return
	 */
	@Column(name="D_SEARCH_DATE")
	public Date getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(Date searchDate) {
		this.searchDate = searchDate;
	}
	/**
	 * 检索人
	 * @return
	 */
	@Column(name="C_OPERATOR_NAME")
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	/**
	 *   冠字号码保管人
	 * @return
	 */
	@Column(name="C_SERIAL_KEEPER")
	public String getSerialKeeper() {
		return serialKeeper;
	}
	public void setSerialKeeper(String serialKeeper) {
		this.serialKeeper = serialKeeper;
	}
	/**
	 * 冠字号记录渠道
	 * @return
	 */
	@Column(name="I_NOTE_RECORDTYPE")
	public String getNoteRecordType() {
		return noteRecordType;
	}
	public void setNoteRecordType(String noteRecordType) {
		this.noteRecordType = noteRecordType;
	}
	/**
	 * 记录时间
	 * @return
	 */
	@Column(name="D_RECORD_DATE")
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	/**
	 * 冠字号
	 * @return
	 */
	@Column(name="C_SERIA_NO")
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 相同冠字数量
	 * @return
	 */
	@Column(name="I_SERIAL_COUNT")
	public int getSerialCount() {
		return serialCount;
	}
	public void setSerialCount(int serialCount) {
		this.serialCount = serialCount;
	}
	/**
	 * 检索结果
	 * @return
	 */
	@Column(name="C_NOTE_TYPE")
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	/**
	 * 冠字号查询结果
	 * @return
	 */
	@Column(name="I_SERIAL_RESULT")
	public int getSerialResult() {
		return serialResult;
	}
	public void setSerialResult(int serialResult) {
		this.serialResult = serialResult;
	}
	
	
}
