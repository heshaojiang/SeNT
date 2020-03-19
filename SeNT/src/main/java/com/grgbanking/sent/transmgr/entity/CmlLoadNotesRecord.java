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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import org.hibernate.annotations.GenericGenerator;


@SuppressWarnings("serial")
@Entity
@Table(name="CML_LOAD_NOTES_RECORD")
@AttributeOverride(name="id", column=@Column(name = "C_ID"))
public class CmlLoadNotesRecord implements Serializable
{
	
	/** 日志对象 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	// { 数据库字段
	
	public String id;
//	public String tranId;
	public String termCode;     
	public String operatorCode;     
	public String tranTime;
	public BigDecimal tranCount;  
	
	
	public BigDecimal tranAmount; 
	public String atmCode;     
	public String cashboxCode;     
	public Integer type;
	public Integer operType;
	public String pathCode;
	//private String tranMonthday;
	private String partMonthday;
	public String tdReserve;
	public String reserve1;
	public String tranDate;
	public String tdLoadNotesId;
	// } 数据库字段
	
	// { 额外属性
	public String orgCode;
	public String pathCodeName;
	public String pathCodeFullName;
	public String bankName;
	public String bankFullName;
	private String finacialCode;
	// } 额外属性
	
	
//	@Column(name="C_TRAN_ID")
//	public String getTranId()
//	{
//		return tranId;
//	}
//	public void setTranId(String tranId)
//	{
//		this.tranId = tranId;
//	}
	
	
	//////////////////////////
	
	
	
	@Column(name="C_ID")
	@Id 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name=" C_TD_OPERATOR_ID")
	public String getOperatorCode()
	{
		return operatorCode;
	}

	public void setOperatorCode(String userId)
	{
		this.operatorCode = userId;
	}
	
	@Column(name="C_TERM_ID")
	public String getTermCode()
	{
		return termCode;
	}
	public void setTermCode(String termCode)
	{
		this.termCode = termCode;
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

	@Column(name="I_TRAN_COUNT")
	public BigDecimal getTranCount()
	{
		return tranCount;
	}
	public void setTranCount(BigDecimal tranCount)
	{
		this.tranCount = tranCount;
	}
	
	@Column(name="I_STATIS_AMT")
	public BigDecimal getTranAmount()
	{
		return tranAmount;
	}

	@Column(name="C_TD_RESERVE")
	public String getTdReserve() {
		return tdReserve;
	}
	public void setTdReserve(String tdReserve) {
		this.tdReserve = tdReserve;
	}
	@Column(name="C_RESERVE1")
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	@Column(name="C_TRAN_DATE")
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public void setTranAmount(BigDecimal tranAmount)
	{
		this.tranAmount = tranAmount;
	}
	

	@Column(name="C_TD_ATM_ID")
	public String getAtmCode()
	{
		return atmCode;
	}
	public void setAtmCode(String atmId)
	{
		this.atmCode = atmId;
	}
	

	@Column(name="C_TD_CASHBOX_ID")
	public String getCashboxCode()
	{
		return cashboxCode;
	}
	public void setCashboxCode(String cashboxId)
	{
		this.cashboxCode = cashboxId;
	}
	

	@Column(name="I_TYPE")
	public Integer getType()
	{
		return type;
	}
	public void setType(Integer type)
	{
		this.type = type;
	}
	
	@Column(name="I_OPER_TYPE")
	public Integer getOperType()
	{
		return operType;
	}
	public void setOperType(Integer operType)
	{
		this.operType = operType;
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
	
	@Column(name="C_TD_LOADNOTES_ID")
	public String getTdLoadNotesId() {
		return tdLoadNotesId;
	}

	public void setTdLoadNotesId(String tdLoadNotesId) {
		this.tdLoadNotesId = tdLoadNotesId;
	}
	
	
	////////////////
	
	
	

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

