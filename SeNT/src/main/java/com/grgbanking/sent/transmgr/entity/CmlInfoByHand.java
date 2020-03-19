package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;



/**
 * 网点库存限额表
 * 
 * @author ligang
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CML_INFO_BYHAND")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class CmlInfoByHand extends BaseEntity{
	/** 币种 */
	private String currency;
	/**100元张数 */
	private BigDecimal hundredCount;
	/** 50元张数 */
	private BigDecimal fiftyCount;
	/** 20元张数 */
	private BigDecimal twentyCount;
	/** 10元张数 */
	private BigDecimal tenCount;
	/** 5元张数 */
	private BigDecimal fiveCount;
	/** 1元张数 */
	private BigDecimal oneCount;
	/** 操作人*/
	private String tdOperator;
	/** 数据权限控制 */
	private String pathCode;
	/** 交易时间 */
	private String tranTime;
	/** 交易类型 */
	private String tranType;
	/** 机构Id */
	private String orgid;
	
	@Column(name = "C_ORGID")
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	
	@Column(name = "C_CURRENCY")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Column(name = "I_HUNDRED_COUNT")
	public BigDecimal getHundredCount() {
		return hundredCount;
	}
	public void setHundredCount(BigDecimal hundredCount) {
		this.hundredCount = hundredCount;
	}
	
	@Column(name = "I_FIFTY_COUNT")
	public BigDecimal getFiftyCount() {
		return fiftyCount;
	}
	public void setFiftyCount(BigDecimal fiftyCount) {
		this.fiftyCount = fiftyCount;
	}
	
	@Column(name = "I_TWENTY_COUNT")
	public BigDecimal getTwentyCount() {
		return twentyCount;
	}
	public void setTwentyCount(BigDecimal twentyCount) {
		this.twentyCount = twentyCount;
	}
	@Column(name = "I_TEN_COUNT")
	public BigDecimal getTenCount() {
		return tenCount;
	}
	public void setTenCount(BigDecimal tenCount) {
		this.tenCount = tenCount;
	}
	@Column(name = "I_FIVE_COUNT")
	public BigDecimal getFiveCount() {
		return fiveCount;
	}
	public void setFiveCount(BigDecimal fiveCount) {
		this.fiveCount = fiveCount;
	}
	
	@Column(name = "I_ONE_COUNT")
	public BigDecimal getOneCount() {
		return oneCount;
	}
	public void setOneCount(BigDecimal oneCount) {
		this.oneCount = oneCount;
	}
	@Column(name = "C_TD_OPERATOR")
	public String getTdOperator() {
		return tdOperator;
	}
	public void setTdOperator(String tdOperator) {
		this.tdOperator = tdOperator;
	}
	@Column(name = "C_PATHCODE")
	public String getPathCode() {
		return pathCode;
	}
	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}
	@Column(name = "C_TRAN_TIME")
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	@Column(name = "C_TRAN_TYPE")
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	

}
