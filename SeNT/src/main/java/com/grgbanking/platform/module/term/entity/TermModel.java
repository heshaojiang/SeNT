/**
 * 文件名：TermModel.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 终端型号 <br>
 * 
 * entity of terminal model
 * 
 * @author Jonas
 * 
 */
@Entity
// Table definition
@Table(name = "TML_MODEL")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class TermModel extends BaseEntity
{

	// 数据库对应的字段 {
	private String modelName;
	//private String brandId;
	//private String typeId;
	private String journalPath;
	private String status;
	// 数据库对应的字段 }
	
	// 表关联对象 {
	private TermBrand brand;
	private TermType type;
	// 表关联对象 }
	
	@Column(name = "C_JOURNAL_PATH")
	public String getJournalPath()
	{
		return journalPath;
	}
	
	public void setJournalPath(String journalPath)
	{
		this.journalPath = journalPath;
	}
	
	/**
	 * 型号名称 <br>
	 * model name
	 */
	@Column(name = "C_MODELNAME")
	public String getModelName()
	{
		return modelName;
	}

	public void setModelName(String modelName)
	{
		this.modelName = modelName;
	}
	
	/**
	 * 状态：启用/禁用（Y/N） <br>
	 * 
	 * status: Y/N
	 * 
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
	
	///////////////
	
	/**
	 * @return
	 */
	@ManyToOne(targetEntity=TermBrand.class, optional=true) 
	@JoinColumn(name="C_BRANDID", referencedColumnName="C_ID", nullable=true, updatable=true)
	@NotFound(action=NotFoundAction.IGNORE)
	public TermBrand getBrand()
	{
		return brand;
	}
	
	public void setBrand(TermBrand brand)
	{
		this.brand = brand;
	}
	
	/**
	 * 
	 */
	@Transient
	public String getBrandId()
	{
		if( brand==null )
		{
			return null;
		}
		else
		{
			return brand.getId();
		}
	}

	public void setBrandId(String brandId)
	{
		TermBrand brand = new TermBrand();
		brand.setId(brandId);
		this.setBrand(brand);
	}
	
	/**
	 * 
	 */
	@Transient
	public String getBrandName()
	{
		if( brand==null )
		{
			return null;
		}
		else
		{
			return brand.getBrandName();
		}
	}

	public void setBrandName(String brandName)
	{
	}

	///////////////////////
	
	/**
	 * @return
	 */
	@ManyToOne(targetEntity=TermType.class, optional=true) 
	@JoinColumn(name="C_TYPEID", referencedColumnName="C_ID", nullable=true, updatable=true)
	@NotFound(action=NotFoundAction.IGNORE)
	public TermType getType()
	{
		return type;
	}

	public void setType(TermType type)
	{
		this.type = type;
	}
	
	/**
	 * type.getId();
	 */
	@Transient
	public String getTypeId()
	{
		return (type==null) ? null : type.getId();
	}

	public void setTypeId(String typeId)
	{
		TermType termType = new TermType();
		termType.setId(typeId);
		this.type = termType;
	}
	
	/**
	 * type.getTypeName();
	 */
	@Transient
	public String getTypeName()
	{
		return (type==null) ? null : type.getTypeName();
	}

	public void setTypeName(String typeId)
	{
	}

	///////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}







