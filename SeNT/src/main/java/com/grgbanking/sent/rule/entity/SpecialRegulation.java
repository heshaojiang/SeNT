package com.grgbanking.sent.rule.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;



/**
 * 特殊规则
 * @author hail
 * @version 1.0
 */

@SuppressWarnings("serial")
@Entity
//@Table(name = "SPECIAL_REGULATION")
@Table(name = "SPECIAL_REGULATION")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class SpecialRegulation extends BaseEntity {

//	private String id;
	private String applyId;
	private String orgid;
	private String moneyType;
	private String moneyDenomination;
	private String regulation;
	private String source;
	private String result;
	private String createDate;
	private String createName;
	private String specialType;

//	public SpecialRegulation(String id, String applyId, String orgid,
//			String moneyType, String moneyDenomination, String regulation,
//			String source, String result, String createDate, String createName,
//			String specialType) {
//		this.id = id;
//		this.applyId = applyId;
//		this.orgid = orgid;
//		this.moneyType = moneyType;
//		this.moneyDenomination = moneyDenomination;
//		this.regulation = regulation;
//		this.source = source;
//		this.result = result;
//		this.createDate = createDate;
//		this.createName = createName;
//		this.specialType = specialType;
//	}
	/**
	 * Constructor 
	 */

	public SpecialRegulation() {
	
	}

//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
//	@Column(name = "C_ID", unique = true, nullable = false)
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

	/**
	 *	申请编号
	 * @return applyId</br>
	 */
	@Column(name = "C_APPLY_ID")
	public String getApplyId() {
		return applyId;
	}
	/**
	 * @param applyId 申请编号 </br>     
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	/**
	 *	申请机构
	 * @return orgid</br>
	 */
	@Column(name = "C_ORGID")
	public String getOrgid() {
		return orgid;
	}
	/**
	 * @param orgid 申请机构 </br>     
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	/**
	 *	币种
	 * @return moneyType</br>
	 */
	@Column(name = "C_MONEY_TYPE")
	public String getMoneyType() {
		return moneyType;
	}
	/**
	 * @param moneyType 币种 </br>     
	 */
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}
	/**
	 *	面额
	 * @return moneyDenomination</br>
	 */
	@Column(name = "C_MONEY_DENOMINATION")
	public String getMoneyDenomination() {
		return moneyDenomination;
	}
	/**
	 * @param moneyDenomination 面额 </br>     
	 */
	public void setMoneyDenomination(String moneyDenomination) {
		this.moneyDenomination = moneyDenomination;
	}
	/**
	 *	规则
	 * @return regulation</br>
	 */
	@Column(name = "C_REGULATION")
	public String getRegulation() {
		return regulation;
	}
	/**
	 * @param regulation 规则 </br>     
	 */
	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}
	/**
	 *	来源
	 * @return source</br>
	 */
	@Column(name = "C_SOURCE")
	public String getSource() {
		return source;
	}
	/**
	 * @param source 来源 </br>     
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 *	原因
	 * @return result</br>
	 */
	@Column(name = "C_RESULT")
	public String getResult() {
		return result;
	}
	/**
	 * @param result 原因 </br>     
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 *	创建时间
	 * @return createDate</br>
	 */
	@Column(name = "C_CREATE_DATE")
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate 创建时间 </br>     
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 *	创建人员
	 * @return createName</br>
	 */
	@Column(name = "C_CREATE_NAME")
	public String getCreateName() {
		return createName;
	}
	/**
	 * @param createName 创建人员 </br>     
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	/**
	 *	特殊规则类型
	 * @return specialType</br>
	 */
	@Column(name = "C_SPECIAL_TYPE")
	public String getSpecialType() {
		return specialType;
	}
	/**
	 * @param specialType 特殊规则类型 </br>     
	 */
	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}
}
