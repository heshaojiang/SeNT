/**
 * 文件名：OrgInfo.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.org.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;
import com.grgbanking.platform.core.utils.ReflectionUtils;
import com.grgbanking.platform.module.org.service.OrgInfoService;

/**
 * orgInfo Management<br>
 * 机构实体
 * 
 * @author hyuan
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ORG_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class OrgInfo extends BaseEntity
{
	/** 表名 */
	public static final String TABLE_NAME = "ORG_INFO";

	private String parentId;
	private String orgName;
	private String orgFullName;
	private String orgCode;
	private String contact;
	private String tel;
	private String address;
	private String status;
	private int order;
	private String note; // 2012.4.20新增
	private String level;
	private String pathCode;

	private String longPan;
	private String shortPan;
	private String loanPan;
	private String borrowPan;

	private String f1;
	private String f2;
	private String f3;
	private String f4;
	private String f5;

	private String label;
	
	private String finacialCode; // add by myl 2014.03.26

	/**
	 * @return the note
	 */
	@Column(name = "C_NOTE")
	public String getNote()
	{
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note)
	{
		this.note = note;
	}

	/**
	 * 父id
	 */
	@Column(name = "C_PARENTID")
	public String getParentId()
	{
		return parentId;
	}

	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}

	/**
	 * 机构名称
	 */
	@Column(name = "C_ORGNAME")
	public String getOrgName()
	{
		return orgName;
	}

	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}

	/**
	 * 机构全名
	 */
	@Column(name = "C_ORGFULLNAME")
	public String getOrgFullName()
	{
		return orgFullName;
	}

	public void setOrgFullName(String orgFullName)
	{
		this.orgFullName = orgFullName;
	}

	/**
	 * 联系方式
	 */
	@Column(name = "C_CONTACT")
	public String getContact()
	{
		return contact;
	}

	public void setContact(String contact)
	{
		this.contact = contact;
	}

	/**
	 * 联系电话
	 */
	@Column(name = "C_TEL")
	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	/**
	 * 联系地址
	 */
	@Column(name = "C_ADDRESS")
	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * 状态:启动/禁用
	 */
	@Column(name = "C_STATUS")
	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * 树结构层级
	 */
	@Column(name = "C_LEVEL")
	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	/**
	 * 机构代码
	 */
	@Column(name = "C_ORGCODE")
	public String getOrgCode()
	{
		return orgCode;
	}

	public void setOrgCode(String orgCode)
	{
		this.orgCode = orgCode;
	}

	/**
	 * 排序编号
	 */
	@Column(name = "I_ORDER")
	public int getOrder()
	{
		return order;
	}

	public void setOrder(int order)
	{
		this.order = order;
	}

	/**
	 * @return the pathCode
	 */
	@Column(name = "C_PATHCODE")
	public String getPathCode()
	{
		return pathCode;
	}

	/**
	 * @param pathCode
	 *            the pathCode to set
	 */
	public void setPathCode(String pathCode)
	{
		this.pathCode = pathCode;
	}

	/**
	 * @return the longPan
	 */
	@Column(name = "C_LONGPAN")
	public String getLongPan()
	{
		return longPan;
	}

	/**
	 * @param loadPan
	 *            the loadPan to set
	 */
	public void setLongPan(String longPan)
	{
		this.longPan = longPan;
	}

	/**
	 * @return the shortPan
	 */
	@Column(name = "C_SHORTPAN")
	public String getShortPan()
	{
		return shortPan;
	}

	/**
	 * @param shortPan
	 *            the shortPan to set
	 */
	public void setShortPan(String shortPan)
	{
		this.shortPan = shortPan;
	}

	/**
	 * @return the loanPan
	 */
	@Column(name = "C_LOANPAN")
	public String getLoanPan()
	{
		return loanPan;
	}

	/**
	 * @param loanPan
	 *            the loanPan to set
	 */
	public void setLoanPan(String loanPan)
	{
		this.loanPan = loanPan;
	}

	/**
	 * @return the borrowPan
	 */
	@Column(name = "C_BORROWPAN")
	public String getBorrowPan()
	{
		return borrowPan;
	}

	/**
	 * @param borrowPan
	 *            the borrowPan to set
	 */
	public void setBorrowPan(String borrowPan)
	{
		this.borrowPan = borrowPan;
	}

	@Column(name = "F1")
	public String getF1()
	{
		return this.f1;
	}

	public void setF1(String f1)
	{
		this.f1 = f1;
	}

	@Column(name = "F2")
	public String getF2()
	{
		return this.f2;
	}

	public void setF2(String f2)
	{
		this.f2 = f2;
	}

	@Column(name = "F3")
	public String getF3()
	{
		return this.f3;
	}

	public void setF3(String f3)
	{
		this.f3 = f3;
	}

	@Column(name = "F4")
	public String getF4()
	{
		return this.f4;
	}

	public void setF4(String f4)
	{
		this.f4 = f4;
	}

	@Column(name = "F5")
	public String getF5()
	{
		return this.f5;
	}

	public void setF5(String f5)
	{
		this.f5 = f5;
	}

	public String getExPropertyValue(String propertyName)
	{
		String entityClassProperty = OrgInfoService.exPropertyMap.get(propertyName);

		Object value = ReflectionUtils.getFieldValue(this, entityClassProperty);
		if( value == null )
			return null;
		return value.toString();
	}

	@Transient
	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	@Column(name = "C_FINACIALCODE")
	public String getFinacialCode() {
		return finacialCode;
	}

	public void setFinacialCode(String finacialCode) {
		this.finacialCode = finacialCode;
	}
	
}
