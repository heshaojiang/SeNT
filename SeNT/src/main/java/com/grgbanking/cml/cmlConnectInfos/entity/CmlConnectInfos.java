package com.grgbanking.cml.cmlConnectInfos.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "CML_CONNECT_INFOS")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class CmlConnectInfos extends BaseEntity {

	private String connNum;
	private BigDecimal connMoney;
	private String comeOrg;
	private String toOrg;
	private String outPerson;
	private String inPerson;
	private Date connDate;
	private Date operateDate;
	private String operatorId;
	private Integer moneyboxCount;
	private String flag;
	private String connAppeal;
	private BigDecimal noAllotMoney;
	private String connMemo;
	/**
	 * @return the connNum
	 */
	@Column(name = "C_CONN_NUM")
	public String getConnNum() {
		return connNum;
	}
	/**
	 * @param connNum the connNum to set
	 */
	public void setConnNum(String connNum) {
		this.connNum = connNum;
	}
	/**
	 * @return the connMoney
	 */
	
	@Column(name = "I_CONN_MONEY")
	public BigDecimal getConnMoney() {
		return connMoney;
	}
	/**
	 * @param connMoney the connMoney to set
	 */
	public void setConnMoney(BigDecimal connMoney) {
		this.connMoney = connMoney;
	}
	/**
	 * @return the comeOrg
	 */
	@Column(name = "C_COME_ORG")
	public String getComeOrg() {
		return comeOrg;
	}
	/**
	 * @param comeOrg the comeOrg to set
	 */
	public void setComeOrg(String comeOrg) {
		this.comeOrg = comeOrg;
	}
	/**
	 * @return the toOrg
	 */
	@Column(name = "C_TO_ORG")
	public String getToOrg() {
		return toOrg;
	}
	/**
	 * @param toOrg the toOrg to set
	 */
	public void setToOrg(String toOrg) {
		this.toOrg = toOrg;
	}
	/**
	 * @return the outPerson
	 */
	@Column(name = "C_OUT_PERSON")
	public String getOutPerson() {
		return outPerson;
	}
	/**
	 * @param outPerson the outPerson to set
	 */
	public void setOutPerson(String outPerson) {
		this.outPerson = outPerson;
	}
	/**
	 * @return the inPerson
	 */
	@Column(name = "C_IN_PERSON")
	public String getInPerson() {
		return inPerson;
	}
	/**
	 * @param inPerson the inPerson to set
	 */
	public void setInPerson(String inPerson) {
		this.inPerson = inPerson;
	}
	/**
	 * @return the connDate
	 */
	@Column(name = "D_CONN_DATE")
	public Date getConnDate() {
		return connDate;
	}
	/**
	 * @param connDate the connDate to set
	 */
	public void setConnDate(Date connDate) {
		this.connDate = connDate;
	}
	/**
	 * @return the operateDate
	 */
	@Column(name = "D_OPERATE_DATE")
	public Date getOperateDate() {
		return operateDate;
	}
	/**
	 * @param operateDate the operateDate to set
	 */
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	/**
	 * @return the operatorId
	 */
	@Column(name = "C_OPERATOR_ID")
	public String getOperatorId() {
		return operatorId;
	}
	/**
	 * @param operatorId the operatorId to set
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	/**
	 * @return the moneyboxCount
	 */
	@Column(name = "I_MONEYBOX_COUNT")
	public Integer getMoneyboxCount() {
		return moneyboxCount;
	}
	/**
	 * @param moneyboxCount the moneyboxCount to set
	 */
	public void setMoneyboxCount(Integer moneyboxCount) {
		this.moneyboxCount = moneyboxCount;
	}
	/**
	 * @return the flag
	 */
	@Column(name = "C_FLAG")
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return the connAppeal
	 */
	@Column(name = "C_CONN_APPEAL")
	public String getConnAppeal() {
		return connAppeal;
	}
	/**
	 * @param connAppeal the connAppeal to set
	 */
	public void setConnAppeal(String connAppeal) {
		this.connAppeal = connAppeal;
	}
	/**
	 * @return the noAllotMoney
	 */
	@Column(name = "I_NO_ALLOT_MONEY")
	public BigDecimal getNoAllotMoney() {
		return noAllotMoney;
	}
	/**
	 * @param noAllotMoney the noAllotMoney to set
	 */
	public void setNoAllotMoney(BigDecimal noAllotMoney) {
		this.noAllotMoney = noAllotMoney;
	}
	/**
	 * @return the connMemo
	 */
	@Column(name = "C_CONN_MEMO")
	public String getConnMemo() {
		return connMemo;
	}
	/**
	 * @param connMemo the connMemo to set
	 */
	public void setConnMemo(String connMemo) {
		this.connMemo = connMemo;
	}
	
}
