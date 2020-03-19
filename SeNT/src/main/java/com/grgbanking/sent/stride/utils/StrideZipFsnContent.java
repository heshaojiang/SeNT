package com.grgbanking.sent.stride.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.sent.utils.StringUtil;



public class StrideZipFsnContent {
	protected static Logger logger = LoggerFactory.getLogger(StrideZipFsnContent.class);
	//记录日期 14
	private String tranTime;
	//报送银行编码 14
	private String bankCode;
	//生成网点编码 14
	private String fromCode;
	//业务类型 1
	private String businessType;
	//记录数 3
	private int count = 0;
	//是否现金清分中心 1
	private String cashType;
	//版本格式 1
	private int version = 0;
	//包（袋、箱）号 10 
	private String bagCode;
	//币种标志4
	private String currency;
	//保留字段 10
	private String reserve;
	//GZH文件中所包括的FSN文件的捆号集合
	private List<String> bundles = new ArrayList<String>();
	//zip文件名
	private String fileName;
	//父zip文件名
	private String parentFileName;
	
	public StrideZipFsnContent(){
		
	}
	
	public StrideZipFsnContent(String tranTime, String bankCode,
			String fromCode, String businessType, int count, String cashType,
			int version, String bagCode, String currency, String reserve) {
		this.tranTime = tranTime;
		this.bankCode = bankCode;
		this.fromCode = fromCode;
		this.businessType = businessType;
		this.count = count;
		this.cashType = cashType;
		this.version = version;
		this.bagCode = bagCode;
		this.currency = currency;
		this.reserve = reserve;
	}
	
	
	public String getTranTime() {
		return StringUtil.isBlank(this.tranTime)?"0":this.tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getBankCode() {
		return StringUtil.isBlank(this.bankCode)?"0":this.bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getFromCode() {
		return StringUtil.isBlank(this.fromCode)?"0":this.fromCode;
	}
	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}
	public String getBusinessType() {
		return StringUtil.isBlank(this.businessType)?"0":this.businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCashType() {
		return StringUtil.isBlank(this.cashType)?"0":this.cashType;
	}
	public void setCashType(String cashType) {
		this.cashType = cashType;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getBagCode() {
		return StringUtil.isBlank(this.bagCode)?"0":this.bagCode;
	}
	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}
	public String getCurrency() {
		return StringUtil.isBlank(this.currency)?"0":this.currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getReserve() {
		return StringUtil.isBlank(this.reserve)?"0":this.reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public static String POINT = ":";
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(getTranTime()).append(POINT);
		sb.append(getBankCode()).append(POINT);
		sb.append(getFromCode()).append(POINT);
		sb.append(getBusinessType()).append(POINT);
		sb.append(getCount()).append(POINT);
		sb.append(getCashType()).append(POINT);
		sb.append(getVersion()).append(POINT);
		sb.append(getBagCode()).append(POINT);
		sb.append(getCurrency()).append(POINT);
		sb.append(getReserve());
		return sb.toString();
	}


	public List<String> getBundles() {
		return bundles;
	}


	public void setBundles(List<String> bundles) {
		this.bundles = bundles;
	}

	public String getFileName() {
		return StringUtil.isNotBlank(fileName)?fileName:this.bankCode+"_"+this.bagCode+"_"+this.tranTime+".zip";
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getParentFileName() {
		return parentFileName;
	}

	public void setParentFileName(String parentFileName) {
		this.parentFileName = parentFileName;
	}
	
}
