package com.grgbanking.sent.transmgr.entity;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;


@SuppressWarnings("serial")
@Entity
@Table(name="CML_COUNTER_RECORD")
@AttributeOverride(name="id", column=@Column(name = "C_ID"))
public class CmlCounterRecord implements Serializable
{

	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	// { 数据库对应的属性
	//private String tranId;
	public String id;
	private String termId;
	private String cardId; 
	
	private String tdOperatorId;                                                                      
	private String tdJournalNo; 
        
	private String tranTime;
	private BigDecimal tranCount;  
	private BigDecimal  statisAtm;                                                                                                                                   
	private Integer businessType;   
	private String pathCode;

	private String tranDate;
	private String partMonthday;
	private String  reserve1;
	private BigDecimal tdTranAtm;
	private String tdAccountNo;    
	private String tdTransCode;
	private String tdReserve;
	// } 数据库对应的属性
	

	// { 额外的属性
	private String orgCode;
	private String pathCodeName;
	private String pathCodeFullName;
	private String bankName;
	private String bankFullName;
	private String finacialCode;
	
	
	@Column(name="C_ID")
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="C_CARD_ID")
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	@Column(name="C_RESERVE1")
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	// } 额外的属性
	@Column(name="I_TD_TRAN_AMT")
	public BigDecimal getTdTranAtm() {
		return tdTranAtm;
	}
	public void setTdTranAtm(BigDecimal tdTranAtm) {
		this.tdTranAtm = tdTranAtm;
	}
	@Column(name="I_STATIS_AMT")
	public BigDecimal getStatisAtm() {
		return statisAtm;
	}
	public void setStatisAtm(BigDecimal statisAtm) {
		this.statisAtm = statisAtm;
	}
	
	@Column(name="C_TD_RESERVE")
	public String getTdReserve() {
		return tdReserve;
	}
	public void setTdReserve(String tdReserve) {
		this.tdReserve = tdReserve;
	}
	@Column(name="C_TD_OPERATOR_ID")
	public String getTdOperatorId() {
		return tdOperatorId;
	}
	public void setTdOperatorId(String tdOperatorId) {
		this.tdOperatorId = tdOperatorId;
	}

	
//	@Column(name="C_TRAN_ID")
//	public String getTranId()
//	{
//		return tranId;
//	}
//	public void setTranId(String tranId)
//	{
//		this.tranId = tranId;
//	}
	
	
	@Column(name="C_TRAN_DATE")
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	
	@Column(name="C_TERM_ID")
	public String getTermId()
	{
		return termId;
	}
	public void setTermId(String termId)
	{
		this.termId = termId;
	}
	@Column(name="C_TD_ACCOUNT_NO")  
	public String getTdAccountNo() {
		return tdAccountNo;
	}
	public void setTdAccountNo(String tdAccountNo) {
		this.tdAccountNo = tdAccountNo;
	}
	@Column(name="C_TD_JOURNAL_NO")  
	public String getTdJournalNo() {
		return tdJournalNo;
	}
	public void setTdJournalNo(String tdJournalNo) {
		this.tdJournalNo = tdJournalNo;
	}
	
	
	
	@Column(name="C_TRAN_TIME")
	public String getTranTime()
	{
		return tranTime;
	}
	public void setTranTime(String tranTime)
	{
		this.tranTime = tranTime;
	}
	
	@Column(name="I_BUSINESS_TYPE")
	public Integer getBusinessType()
	{
		return businessType;
	}
	@Column(name="I_TRAN_COUNT")
	public BigDecimal getTranCount() {
		return tranCount;
	}
	public void setTranCount(BigDecimal tranCount) {
		this.tranCount = tranCount;
	}
	public void setBusinessType(Integer businessType)
	{
		this.businessType = businessType;
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
	@Column(name="C_TD_TRANSCODE")
	public String getTdTransCode() {
		return tdTransCode;
	}
	public void setTdTransCode(String tdTransCode) {
		this.tdTransCode = tdTransCode;
	}

	
	////////////////////
	
	
	@Transient
	public String getOrgCode()
	{
		return orgCode;
	}
	public void setOrgCode(String orgCode)
	{
		this.orgCode = orgCode;
	}
	
	
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
	
	@Transient
	public String getFinacialCode() {
		return finacialCode;
	}
	public void setFinacialCode(String finacialCode) {
		this.finacialCode = finacialCode;
	}

	
	@Column(name="C_PART_MONTHDAY")
	public String getPartMonthday() {
		return partMonthday;
	}
	public void setPartMonthday(String partMonthday) {
		this.partMonthday = partMonthday;
	}
	
	
	@Override
	public int hashCode() {
		if (id == null)
			return -1;
		return id.hashCode();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof BaseEntity))
			return false;

		BaseEntity other = (BaseEntity) obj;
		return getId().equals(other.getId());
	}

	@Override
	public String toString() {
		final String error = this.getClass().toString() + " :[id = " + this.getId() + "] toString Error: ";

		try {
			Map map = PropertyUtils.describe(this);
			ToStringBuilder tsb = new ToStringBuilder(this,
					ToStringStyle.MULTI_LINE_STYLE, null);

				for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
				Map.Entry me = (Map.Entry) it.next();

					if ("class".equals(me.getKey())) {
					continue;
				}

					if (me.getValue() == null) {
					tsb.append((String) me.getKey(), "null");
				} else {
					tsb.append((String) me.getKey(), logEntity(me.getValue()));
				}
				}
			return tsb.toString();
		} catch (IllegalAccessException e) {
			logger.error(e.toString());
			return error + e;
		} catch (InvocationTargetException e) {
			logger.error(e.toString());
			return error + e;
		} catch (NoSuchMethodException e) {
			logger.error(e.toString());
			return error + e;
			}


	}

	private String logEntity(Object obj) {
		Assert.notNull(obj, "object that be logged can not be null");
		if (obj instanceof BaseEntity)
			return obj.getClass().getName() + "[id=" + ((BaseEntity) obj).getId() + "]";

		if (obj instanceof Collection) {
			StringBuffer sb = new StringBuffer("[");
			for (Iterator it = ((Collection) obj).iterator(); it.hasNext();) {
				Object o = it.next();
				sb.append("").append(o.getClass().getSimpleName());
				if (o instanceof BaseEntity) {
					sb.append("#").append("id=").append(((BaseEntity) o).getId()).append(";");
				} else {
					sb.append(";");
				}
			}
			sb.append("]");

			return sb.toString();
		}

		return obj.toString();
	}

	
}

