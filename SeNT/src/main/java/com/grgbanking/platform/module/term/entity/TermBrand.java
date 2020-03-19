/**
 * 文件名：TermBrand.java
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
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;

/**
 * 终端品牌<br>
 * 
 * entity of terminal brand
 * 
 * @author Jonas
 * 
 */
@Entity
@Table(name = "TML_BRAND")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class TermBrand extends BaseEntity {

	private String brandName;

	private String companyName;

	private String companyAddress;

	private String status;

	private String code;

	/**
	 * 代码
	 * 
	 */
	@Column(name = "C_CODE")
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 品牌名称<br>
	 * 
	 * brand name
	 */
	@Column(name = "C_BRANDNAME")
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * 厂商名称《br>
	 * 
	 * company name
	 */
	@Column(name = "C_FACTNAME")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 厂商地址《br>
	 * 
	 * company address
	 */
	@Column(name = "C_FACTADDRESS")
	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * 状态：启用/禁用（Y/N）《br>
	 * 
	 * status: Y/N
	 */
	@Column(name = "C_STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
