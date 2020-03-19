/**
 * 文件名：TermInfo.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.term.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.grgbanking.platform.core.entity.BaseEntity;
import com.grgbanking.platform.core.utils.ReflectionUtils;
import com.grgbanking.platform.module.term.service.TermInfoService;

/**
 * 终端基础信息实体 <br>
 * 
 * entity of terminal basal information
 * 
 * @author Jonas
 * 
 */
@Entity
// Table definition
@Table(name = "TML_INFO")
@AttributeOverride(name = "id", column = @Column(name = "C_ID"))
@SuppressWarnings("serial")
public class TermInfo extends BaseEntity {
	/** 表名 */
	public static final String TABLE_NAME = "TML_INFO";
	private String termCode;

	private String termSEQ;

	private String counterCode;

	private String termType;

	private String brand;

	private String model;

	private String orgId;

	private String areaId;

	private String netAddr;

	private Date instDate;

	private Date activeDate;

	private String termAddr;

	private String serviceType;

	private String instType;

	private String layType;
	
	private String machineType;

	private String busiBeginTime;

	private String busiEndTime;

	private Integer netPort;

	private Integer saveBox;

	private Integer cwdBox;

	private Date servStartDate;

	private Date servEndDate;

	private Integer servYears;

	private String isVideoWatch;

	private String isUPS;

	private String isInterATM;

	private String softVersion;

	private String spVersion;

	private String termName;

	private String connServer;

	private String connProcotol;

	private String connLine;

	private String vip;

	private String interventionLevle;

	private String post;

	private Double x;

	private Double y;

	private String status;

	private Long cashLackNum;

	private Long cashFullNum;

	private Long coinCashLackNum;

	private Long coinCashFullNum;
	
	private String tellerIp ;
	
	private String device ;

	/**
	 * @return the coinCashLackNum
	 */
	@Column(name = "I_COINCASHLACKNUM")
	public Long getCoinCashLackNum() {
		return coinCashLackNum;
	}

	/**
	 * @param coinCashLackNum
	 *            the coinCashLackNum to set
	 */
	public void setCoinCashLackNum(Long coinCashLackNum) {
		this.coinCashLackNum = coinCashLackNum;
	}

	/**
	 * @return the coinCashFullNum
	 */
	@Column(name = "I_COINCASHFULLNUM")
	public Long getCoinCashFullNum() {
		return coinCashFullNum;
	}

	/**
	 * @param coinCashFullNum
	 *            the coinCashFullNum to set
	 */
	public void setCoinCashFullNum(Long coinCashFullNum) {
		this.coinCashFullNum = coinCashFullNum;
	}

	private String secOnePort;

	private String f1;
	private String f2;
	private String f3;
	private String f4;
	private String f5;
	private String f6;
	private String f7;
	private String f8;
	private String f9;
	private String f10;

	/**
	 * 终端编号 <br>
	 * 
	 * terminal code
	 */

	@Column(name = "C_TERMCODE")
	public String getTermCode() {
		return termCode;
	}

	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}

	/**
	 * 设备序列号 <br>
	 * 
	 * terminal sequence
	 */
	@Column(name = "C_TERMSEQ")
	public String getTermSEQ() {
		return termSEQ;
	}

	public void setTermSEQ(String termSEQ) {
		this.termSEQ = termSEQ;
	}

	/**
	 * 柜员号 <br>
	 * 
	 * counter id
	 */
	@Column(name = "C_COUNTERCODE")
	public String getCounterCode() {
		return counterCode;
	}

	public void setCounterCode(String counterCode) {
		this.counterCode = counterCode;
	}

	/**
	 * 终端类型 <br>
	 * 
	 * terminal type
	 */
	@Column(name = "C_TERMTYPE")
	public String getTermType() {
		return termType;
	}

	public void setTermType(String termType) {
		this.termType = termType;
	}

	/**
	 * 终端品牌 <br>
	 * 
	 * brand
	 */
	@Column(name = "C_BRAND")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * 设备型号 <br>
	 * 
	 * model
	 */
	@Column(name = "C_MODEL")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * 所属机构 <br>
	 * 
	 * organization id
	 */
	@Column(name = "C_ORGID")
	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * 所属区域 <br>
	 * 
	 * area id
	 */
	@Column(name = "C_AREAID")
	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * 终端IP <br>
	 * 
	 * network address
	 */
	@Column(name = "C_NETADDR")
	public String getNetAddr() {
		return netAddr;
	}

	public void setNetAddr(String netAddr) {
		this.netAddr = netAddr;
	}

	/**
	 * 终端PORT <br>
	 * 
	 * port
	 */
	@Column(name = "I_NETPORT")
	public Integer getNetPort() {
		return netPort;
	}

	public void setNetPort(Integer netPort) {
		this.netPort = netPort;
	}

	/**
	 * 存款箱数量 <br>
	 * 
	 * number of save box
	 */
	@Column(name = "I_SAVEBOX")
	public Integer getSaveBox() {
		return saveBox;
	}

	public void setSaveBox(Integer saveBox) {
		this.saveBox = saveBox;
	}

	/**
	 * 取款箱数量 <br>
	 * 
	 * number of cwd box
	 */
	@Column(name = "I_CWDBOX")
	public Integer getCwdBox() {
		return cwdBox;
	}

	public void setCwdBox(Integer cwdBox) {
		this.cwdBox = cwdBox;
	}

	/**
	 * 安装日期 <br>
	 * 
	 * install date
	 */
	@Column(name = "D_INST_DATE")
	public Date getInstDate() {
		return instDate;
	}

	public void setInstDate(Date instDate) {
		this.instDate = instDate;
	}

	/**
	 * 开通时间 <br>
	 * 
	 * active date
	 */
	@Column(name = "D_ACTIVE_DATE")
	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	/**
	 * 维护开始日期 <br>
	 * 
	 * start servicing date
	 */
	@Column(name = "D_SERV_STARTDATE")
	public Date getServStartDate() {
		return servStartDate;
	}

	public void setServStartDate(Date servStartDate) {
		this.servStartDate = servStartDate;
	}

	/**
	 * 维护到期日期 <br>
	 * 
	 * end servicing date
	 */
	@Column(name = "D_SERV_ENDDATE")
	public Date getServEndDate() {
		return servEndDate;
	}

	public void setServEndDate(Date servEndDate) {
		this.servEndDate = servEndDate;
	}

	/**
	 * 维护年限 <br>
	 * 
	 * fixed number of years
	 */
	@Column(name = "I_SERV_YEARS")
	public Integer getServYears() {
		return servYears;
	}

	public void setServYears(Integer servYears) {
		this.servYears = servYears;
	}

	/**
	 * 安装地址 <br>
	 * 
	 * terminal address
	 */
	@Column(name = "C_TERMADDR")
	public String getTermAddr() {
		return termAddr;
	}

	public void setTermAddr(String termAddr) {
		this.termAddr = termAddr;
	}

	/**
	 * 布放模式:是/否 自助银行(数据字典) <br>
	 * 
	 * service type
	 */
	@Column(name = "C_SERVICETYPE")
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * 安装方式:穿墙式，大堂式(数据字典) <br>
	 * 
	 * install type
	 */
	@Column(name = "C_INST_TYPE")
	public String getInstType() {
		return instType;
	}

	public void setInstType(String instType) {
		this.instType = instType;
	}

	/**
	 * 设立形式:在行，离行(数据字典) <br>
	 * 
	 * lay type
	 */
	@Column(name = "C_LAY_TYPE")
	public String getLayType() {
		return layType;
	}

	public void setLayType(String layType) {
		this.layType = layType;
	}

	/**
	 * 是否视频监控:是，否(数据字典) <br>
	 * 
	 * whether does it have video watch
	 */
	@Column(name = "C_ISVIDEOWATCH")
	public String getIsVideoWatch() {
		return isVideoWatch;
	}

	public void setIsVideoWatch(String isVideoWatch) {
		this.isVideoWatch = isVideoWatch;
	}

	/**
	 * 是否安装UPS:是，否(数据字典) <br>
	 * 
	 * whether dose it have installed UPS
	 */
	@Column(name = "C_ISUPS")
	public String getIsUPS() {
		return isUPS;
	}

	public void setIsUPS(String isUPS) {
		this.isUPS = isUPS;
	}

	/**
	 * 是否受理国际卡:是，否(数据字典) <br>
	 * 
	 * whether is it a international ATM
	 */
	@Column(name = "C_ISINTERATM")
	public String getIsInterATM() {
		return isInterATM;
	}

	public void setIsInterATM(String isInterATM) {
		this.isInterATM = isInterATM;
	}

	/**
	 * 营业开始时间:是，否(数据字典) <br>
	 * 
	 * time of business begin
	 */
	@Column(name = "C_BUSIBEGINTIME")
	public String getBusiBeginTime() {
		return busiBeginTime;
	}

	public void setBusiBeginTime(String busiBeginTime) {
		this.busiBeginTime = busiBeginTime;
	}

	/**
	 * 营业结束时间 <br>
	 * 
	 * time of business end
	 */
	@Column(name = "C_BUSIENDTIME")
	public String getBusiEndTime() {
		return busiEndTime;
	}

	public void setBusiEndTime(String busiEndTime) {
		this.busiEndTime = busiEndTime;
	}

	/**
	 * ATMC版本号 <br>
	 * 
	 * ATMC version
	 */
	@Column(name = "C_SOFTVERSION")
	public String getSoftVersion() {
		return softVersion;
	}

	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}

	/**
	 * SP版本号 <br>
	 * 
	 * sp version
	 */
	@Column(name = "C_SPVERSION")
	public String getSpVersion() {
		return spVersion;
	}

	public void setSpVersion(String spVersion) {
		this.spVersion = spVersion;
	}
	
	@Column(name = "C_MACHINE_TYPE")
	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	@Column(name = "C_TERMNAME", length = 100)
	public String getTermName() {
		return this.termName;
	}

	public void setTermName(String termname) {
		this.termName = termname;
	}

	@Column(name = "C_CONNSERVER", length = 100)
	public String getConnserver() {
		return this.connServer;
	}

	public void setConnserver(String connserver) {
		this.connServer = connserver;
	}

	@Column(name = "C_CONNPROTOCOL", length = 10)
	public String getConnprotocol() {
		return this.connProcotol;
	}

	public void setConnprotocol(String connprotocol) {
		this.connProcotol = connprotocol;
	}

	@Column(name = "C_CONNLINE", length = 100)
	public String getConnline() {
		return this.connLine;
	}

	public void setConnline(String connline) {
		this.connLine = connline;
	}

	@Column(name = "C_VIP")
	public String getVip() {
		return this.vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	@Column(name = "C_INTERVENTIONLEVEL", length = 2)
	public String getInterventionlevel() {
		return this.interventionLevle;
	}

	public void setInterventionlevel(String interventionlevel) {
		this.interventionLevle = interventionlevel;
	}

	@Column(name = "C_POST", length = 100)
	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@Column(name = "I_X")
	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		if (x != null && x.isNaN()) {
			x = null;
		}
		this.x = x;
	}

	@Column(name = "I_Y")
	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		if (y != null && y.isNaN()) {
			y = null;
		}
		this.y = y;
	}

	@Column(name = "C_STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "I_CASHLACKNUM")
	public Long getCashLackNum() {
		return this.cashLackNum;
	}

	public void setCashLackNum(Long cashLackNum) {
		this.cashLackNum = cashLackNum;
	}

	@Column(name = "I_CASHFULLNUM")
	public Long getCashFullNum() {
		return this.cashFullNum;
	}

	public void setCashFullNum(Long cashFullNum) {
		this.cashFullNum = cashFullNum;
	}

	@Column(name = "C_SECONE_PORT", length = 100)
	public String getSeconePort() {
		return this.secOnePort;
	}

	public void setSeconePort(String seconePort) {
		this.secOnePort = seconePort;
	}

	@Column(name = "C_F1", length = 100)
	public String getF1() {
		return this.f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	@Column(name = "C_F2", length = 100)
	public String getF2() {
		return this.f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	@Column(name = "C_F3", length = 100)
	public String getF3() {
		return this.f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	}

	@Column(name = "C_F4", length = 100)
	public String getF4() {
		return this.f4;
	}

	public void setF4(String f4) {
		this.f4 = f4;
	}

	@Column(name = "C_F5", length = 100)
	public String getF5() {
		return this.f5;
	}

	public void setF5(String f5) {
		this.f5 = f5;
	}

	@Column(name = "C_F6", length = 100)
	public String getF6() {
		return this.f6;
	}

	public void setF6(String f6) {
		this.f6 = f6;
	}

	@Column(name = "C_F7", length = 100)
	public String getF7() {
		return this.f7;
	}

	public void setF7(String f7) {
		this.f7 = f7;
	}

	@Column(name = "C_F8", length = 100)
	public String getF8() {
		return this.f8;
	}

	public void setF8(String f8) {
		this.f8 = f8;
	}

	@Column(name = "C_F9", length = 500)
	public String getF9() {
		return this.f9;
	}

	public void setF9(String f9) {
		this.f9 = f9;
	}

	@Column(name = "C_F10", length = 1000)
	public String getF10() {
		return this.f10;
	}

	public void setF10(String f10) {
		this.f10 = f10;
	}

	@Column(name="C_TELLER_IP", length = 15)
	public String getTellerIp() {
		return tellerIp;
	}

	
	@Column(name="C_DEVICE")
	public String getDevice() {
		return device;
	}

	public void setTellerIp(String tellerIp) {
		this.tellerIp = tellerIp;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public static String getTableName() {
		return TABLE_NAME;
	}

	public String getExPropertyValue(String propertyName) {
		String entityClassProperty = TermInfoService.exPropertyMap.get(propertyName);

		Object value = ReflectionUtils.getFieldValue(this, entityClassProperty);
		if (value == null)
			return null;
		return value.toString();
	}
}
