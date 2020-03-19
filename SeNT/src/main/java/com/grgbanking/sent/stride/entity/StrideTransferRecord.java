
package com.grgbanking.sent.stride.entity;


import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.core.entity.BaseEntity;
import com.grgbanking.sent.stride.utils.StrideZipFsnContent;


@Entity
@Table(name = "cml_stride_transfer_record")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class StrideTransferRecord extends BaseEntity {

										
	/* cBagCode */
	private String bagCode;
					
	/* cFromCode */
	private String fromCode;
					
	/* cCashType */
	private String cashType;
					
	/* cPathcode */
	private String pathcode;
					
	/* cTranTime */
	private String tranTime;
					
	/* cCurrency */
	private String currency;
					
	/* iTdTranAmt */
	private BigDecimal tdTranAmt;
					
	/* cTranDate */
	private String tranDate;
					
	/* cBusinessType */
	private String businessType;
					
	/* iCount */
	private Integer count;
					
	/* cBankCode */
	private String bankCode;
					
	/* iVersion */
	private Integer version;
					
	/* cReserve */
	private String reserve;
	
	private String partMonthday;
	
	private boolean selected;
	
	private String fromOrgName ;
	
	public StrideTransferRecord(){
		
	}
	
	

	public StrideTransferRecord(StrideZipFsnContent content,String pathCode) {
		super();
		this.bagCode = content.getBagCode();
		this.fromCode = content.getFromCode();
		this.cashType = content.getCashType();
		this.tranTime = content.getTranTime();
		this.currency = content.getCurrency();
		this.businessType = content.getBusinessType();
		this.count = content.getCount();
		this.bankCode = content.getBankCode();
		this.version = content.getVersion();
		this.reserve = content.getReserve();
		this.pathcode = pathCode;
		this.tranDate = content.getTranTime().substring(0, 8);
		this.partMonthday = content.getTranTime().substring(4, 8);
	}



	@Column(name = "C_BAG_CODE")
	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}
	@Column(name = "C_FROM_CODE")
	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}
	@Column(name = "C_CASH_TYPE")
	public String getCashType() {
		return cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}
	@Column(name = "C_PATHCODE")
	public String getPathcode() {
		return pathcode;
	}

	public void setPathcode(String pathcode) {
		this.pathcode = pathcode;
	}
	@Column(name = "C_TRAN_TIME")
	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	@Column(name = "C_CURRENCY")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Column(name = "I_TD_TRAN_AMT")
	public BigDecimal getTdTranAmt() {
		return tdTranAmt;
	}

	public void setTdTranAmt(BigDecimal tdTranAmt) {
		this.tdTranAmt = tdTranAmt;
	}
	@Column(name = "C_TRAN_DATE")
	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	@Column(name = "C_BUSINESS_TYPE")
	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	@Column(name = "I_COUNT")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	@Column(name = "C_BANK_CODE")
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	@Column(name = "I_VERSION")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	@Column(name = "C_RESERVE")
	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	@Column(name = "C_PART_MONTHDAY")
	public String getPartMonthday() {
		return partMonthday;
	}

	public void setPartMonthday(String partMonthday) {
		this.partMonthday = partMonthday;
	}


	@Transient
	public boolean isSelected() {
		return selected;
	}



	public void setSelected(boolean selected) {
		this.selected = selected;
	}



	@Transient
	public String getFromOrgName() {
		return fromOrgName;
	}



	public void setFromOrgName(String fromOrgName) {
		this.fromOrgName = fromOrgName;
	}
			
	
												
	

}
