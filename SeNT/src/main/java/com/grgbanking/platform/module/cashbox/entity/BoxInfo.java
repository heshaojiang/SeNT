/**
 * 文件名：Box.java
 */
package com.grgbanking.platform.module.cashbox.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;


/**
 * 钞箱实体
 * @author zlmin3
 */
@SuppressWarnings("serial")
@Entity
@Table(name="BOX_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
public class BoxInfo extends BaseEntity
{
	private String orgid;
	private String boxNum;
	private String atmBoxTypes;
	private String atmModel;
	private String boxStatus;
	private String boxType;
	private String usageStatus;
	
	public BoxInfo(){
	}
	
	public BoxInfo(String id,String orgid,String boxNum,String boxStatus,String atmModel,String atmBoxTypes,String boxType,String usageStatus)
	{
		super.setId(id);
		this.orgid=orgid;
		this.boxNum=boxNum;
		this.atmModel=atmModel;
		this.atmBoxTypes=atmBoxTypes;
		this.boxStatus=boxStatus;
		this.boxType=boxType;
		this.usageStatus=usageStatus;
	}
	
	@Column(name="C_ORGID")
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	@Column(name="C_BOX_NUM")
	public String getBoxNum() {
		return boxNum;
	}
	public void setBoxNum(String boxNum) {
		this.boxNum = boxNum;
	}
	@Column(name="C_ATM_BOXTYPE")
	public String getAtmBoxTypes() {
		return atmBoxTypes;
	}

	public void setAtmBoxTypes(String atmBoxTypes) {
		this.atmBoxTypes = atmBoxTypes;
	}
	@Column(name="C_BOX_ATM")
	public String getAtmModel() {
		return atmModel;
	}

	public void setAtmModel(String atmModel) {
		this.atmModel = atmModel;
	}
	@Column(name="C_BOX_STATUS")
	public String getBoxStatus() {
		return boxStatus;
	}

	public void setBoxStatus(String boxStatus) {
		this.boxStatus = boxStatus;
	}
	
	@Column(name="C_TYPE")
	public String getBoxType() {
		return boxType;
	}

	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}
	
	@Column(name="C_USAGE_STATUS")
	public String getUsageStatus() {
		return usageStatus;
	}

	public void setUsageStatus(String usageStatus) {
		this.usageStatus = usageStatus;
	}
	
	/////////////////////////
	
	// 额外的属性
	private String orgName;
	private String orgFullName;

	@Transient
	public String getOrgName()
	{
		return orgName;
	}

	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}

	@Transient
	public String getOrgFullName()
	{
		return orgFullName;
	}

	public void setOrgFullName(String orgFullName)
	{
		this.orgFullName = orgFullName;
	}
	
	////////////////////
	
}
