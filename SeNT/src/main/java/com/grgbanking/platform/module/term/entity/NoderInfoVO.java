package com.grgbanking.platform.module.term.entity;

import java.util.Date;


public class NoderInfoVO {

private String orgCode ;
	
	private int version ;
	
	private String noderIP ;
	
	private String runningStatus ;  // 0 - �� �� 1 - ����
	
	private Date statusTime;   //״̬����ʱ��
	
	private String parameter ;
	
	private String device ;
	
	private String installDir ;
	
	private String midLevelIP ;

	private String orgName ;
	
	private String noderType;

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNoderIP() {
		return noderIP;
	}

	public void setNoderIP(String noderIP) {
		this.noderIP = noderIP;
	}

	public String getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(String runningStatus) {
		this.runningStatus = runningStatus;
	}

	public Date getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getInstallDir() {
		return installDir;
	}

	public void setInstallDir(String installDir) {
		this.installDir = installDir;
	}

	public String getMidLevelIP() {
		return midLevelIP;
	}

	public void setMidLevelIP(String midLevelIP) {
		this.midLevelIP = midLevelIP;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getNoderType() {
		return noderType;
	}

	public void setNoderType(String noderType) {
		this.noderType = noderType;
	}
	
	
}
