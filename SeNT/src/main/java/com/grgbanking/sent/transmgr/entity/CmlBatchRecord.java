package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;


@SuppressWarnings("serial")
@Entity
@Table(name="CML_BATCH_RECORD")
@AttributeOverride(name="id", column=@Column(name = "C_ID"))
public class CmlBatchRecord extends BaseEntity
{
	// { 数据库对应的属性
	private Integer tranType;
	private String tranId;
	private String termCode;		
	private String beginTime;	
	private String endTime;		
	private BigDecimal totalCount;	
	private BigDecimal totalAmount;		
	private String fileName;		
	private String pathCode;
	// }
	
	// { 额外属性
	private String pathCodeName;
	private String pathCodeFullName;
	private String bankName;
	private String bankFullName;
	// }
	
	
	
	
	/////////////////////////
	
	@Column(name="C_TRAN_TYPE")
	public Integer getTranType()
	{
		return tranType;
	}
	public void setTranType(Integer tranType)
	{
		this.tranType = tranType;
	}
	
	@Column(name="C_TRAN_ID")
	public String getTranId()
	{
		return tranId;
	}
	public void setTranId(String tranId)
	{
		this.tranId = tranId;
	}
	
	@Column(name="C_TERM_CODE")
	public String getTermCode()
	{
		return termCode;
	}
	public void setTermCode(String termId)
	{
		this.termCode = termId;
	}
	
	@Column(name="C_BEGIN_TIME")
	public String getBeginTime()
	{
		return beginTime;
	}
	public void setBeginTime(String beginTime)
	{
		this.beginTime = beginTime;
	}
	
	@Column(name="C_END_TIME")
	public String getEndTime()
	{
		return endTime;
	}
	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}
	
	@Column(name="I_TOTAL_COUNT")
	public BigDecimal getTotalCount()
	{
		return totalCount;
	}
	public void setTotalCount(BigDecimal totalCount)
	{
		this.totalCount = totalCount;
	}
	
	@Column(name="I_TOTAL_AMT")
	public BigDecimal getTotalAmount()
	{
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount)
	{
		this.totalAmount = totalAmount;
	}
	
	@Column(name="C_FILE_NAME")
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	@Column(name="C_PATHCODE")
	public String getPathCode()
	{
		return pathCode;
	}
	public void setPathCode(String pathCode)
	{
		this.pathCode = pathCode;
	}
		

	
	/////////////////////
	
	@Transient
	public String getPathCodeName()
	{
		return pathCodeName;
	}
	public void setPathCodeName(String pathCodeName)
	{
		this.pathCodeName = pathCodeName;
	}
	
	@Transient
	public String getPathCodeFullName()
	{
		return pathCodeFullName;
	}
	public void setPathCodeFullName(String pathCodeFullName)
	{
		this.pathCodeFullName = pathCodeFullName;
	}
	
	@Transient
	public String getBankName()
	{
		return bankName;
	}
	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}
	
	@Transient
	public String getBankFullName()
	{
		return bankFullName;
	}
	public void setBankFullName(String bankFullName)
	{
		this.bankFullName = bankFullName;
	}	
	
	///////////////////////////
	
}

