/**
 * 文件名：BankBranceInventoryService.java
 * 创建日期： 2014-09-26
 * Copyright (c)  广电运通
 * All rights reserved.
 */
package com.grgbanking.sent.transmgr.entity;

/**
 * 现金清分统计报表的数据持久类
 * @author zzhui1
 *
 */
public class CmlStatisticRecord {

	/** 所属机构名称 */
	private String orgName;
	
	/** 所有的完整钞金额数 */
	private String sumCashAmountFull;
	
	/** 所有的残旧钞金额数 */
	private String sumCashAmountOld;

	/** 清分机清分的100/50币种的完整钞金额数 */
	private String sumCash100AmountFull;
	
	/** 清分机清分的20/10币种的完整钞金额数 */
	private String sumCash20AmountFull;
	
	/** 清分机清分的5/1币种的完整钞金额数 */
	private String sumCash5AmountFull;
	
	/** 清分机清分的100/50币种的残旧钞金额数 */
	private String sumCash100AmountOld;
	
	/** 清分机清分的20/10币种的残旧钞金额数 */
	private String sumCash20AmountOld;
	
	/** 清分机清分的5/1币种的残旧钞金额数 */
	private String sumCash5AmountOld;
	
	/** 清分机清分的完整钞金额总数 */
	private String sumDistrCashAmountFull;
	
	/** 清分机清分的残旧钞金额总数 */
	private String sumDistrCashAmountOld;
	
	/**
	 * @return 清分机清分的完整钞金额总数 
	 */
	public String getSumDistrCashAmountFull() {
		return sumDistrCashAmountFull;
	}

	/**
	 * @param 清分机清分的完整钞金额总数 的设定
	 */
	public void setSumDistrCashAmountFull(String sumDistrCashAmountFull) {
		this.sumDistrCashAmountFull = sumDistrCashAmountFull;
	}

	/**
	 * @return 清分机清分的残旧钞金额总数
	 */
	public String getSumDistrCashAmountOld() {
		return sumDistrCashAmountOld;
	}

	/**
	 * @param 清分机清分的残旧钞金额总数的设定
	 */
	public void setSumDistrCashAmountOld(String sumDistrCashAmountOld) {
		this.sumDistrCashAmountOld = sumDistrCashAmountOld;
	}

	/**
	 * @return 所有的完整钞金额数
	 */
	public String getSumCashAmountFull() {
		return sumCashAmountFull;
	}

	/**
	 * @param 所有的完整钞金额数的设定
	 */
	public void setSumCashAmountFull(String sumCashAmountFull) {
		this.sumCashAmountFull = sumCashAmountFull;
	}

	/**
	 * @return 所有的残旧钞金额数 
	 */
	public String getSumCashAmountOld() {
		return sumCashAmountOld;
	}

	/**
	 * @return 所属机构名称 
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param 所属机构名称 的设定
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	/**
	 * @param 所有的残旧钞金额数 的设定
	 */
	public void setSumCashAmountOld(String sumCashAmountOld) {
		this.sumCashAmountOld = sumCashAmountOld;
	}

	/**
	 * @return 清分机清分的100/50币种的完整钞金额数 
	 */
	public String getSumCash100AmountFull() {
		return sumCash100AmountFull;
	}

	/**
	 * @param 清分机清分的100/50币种的完整钞金额数 的设定
	 */
	public void setSumCash100AmountFull(String sumCash100AmountFull) {
		this.sumCash100AmountFull = sumCash100AmountFull;
	}

	/**
	 * @return 清分机清分的20/10币种的完整钞金额数
	 */
	public String getSumCash20AmountFull() {
		return sumCash20AmountFull;
	}

	/**
	 * @param 清分机清分的20/10币种的完整钞金额数 的设定
	 */
	public void setSumCash20AmountFull(String sumCash20AmountFull) {
		this.sumCash20AmountFull = sumCash20AmountFull;
	}

	/**
	 * @return 清分机清分的5/1币种的完整钞金额数 
	 */
	public String getSumCash5AmountFull() {
		return sumCash5AmountFull;
	}

	/**
	 * @param 清分机清分的5/1币种的完整钞金额数 的设定
	 */
	public void setSumCash5AmountFull(String sumCash5AmountFull) {
		this.sumCash5AmountFull = sumCash5AmountFull;
	}

	/**
	 * @return 清分机清分的100/50币种的残旧钞金额数 
	 */
	public String getSumCash100AmountOld() {
		return sumCash100AmountOld;
	}

	/**
	 * @param 清分机清分的100/50币种的残旧钞金额数 的设定
	 */
	public void setSumCash100AmountOld(String sumCash100AmountOld) {
		this.sumCash100AmountOld = sumCash100AmountOld;
	}

	/**
	 * @return 清分机清分的20/10币种的残旧钞金额数 
	 */
	public String getSumCash20AmountOld() {
		return sumCash20AmountOld;
	}

	/**
	 * @param 清分机清分的20/10币种的残旧钞金额数 的设定
	 */
	public void setSumCash20AmountOld(String sumCash20AmountOld) {
		this.sumCash20AmountOld = sumCash20AmountOld;
	}

	/**
	 * @return 清分机清分的5/1币种的残旧钞金额数
	 */
	public String getSumCash5AmountOld() {
		return sumCash5AmountOld;
	}

	/**
	 * @param 清分机清分的5/1币种的残旧钞金额数的设定
	 */
	public void setSumCash5AmountOld(String sumCash5AmountOld) {
		this.sumCash5AmountOld = sumCash5AmountOld;
	}
}
