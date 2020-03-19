package com.grgbanking.sent.transmgr.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.entity.BaseEntity;


@SuppressWarnings("serial")
@Entity
@Table(name="BARCODE_IN_CASHBOX")
@AttributeOverride(name="id", column=@Column(name = "C_ID"))
public class BarcodeInCashbox extends BaseEntity
{
	// { 跟数据库列对应的属性
	public String boxNum;
	public String barcodeFlowNum;
	
	// } 跟数据库列对应的属性
	
	//////////////////////////////////
	
	@Column(name="C_BOX_NUM")
	public String getBoxNum()
	{
		return boxNum;
	}
	public void setBoxNum(String boxNum)
	{
		this.boxNum = boxNum;
	}
	
	@Column(name="C_BARCODE_FLOWNUM")
	public String getBarcodeFlowNum()
	{
		return barcodeFlowNum;
	}
	public void setBarcodeFlowNum(String barcodeFlowNum)
	{
		this.barcodeFlowNum = barcodeFlowNum;
	}
	
	////////////////////////////////////
	
	
	
}

