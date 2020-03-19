package com.grgbanking.sent.checkin.entity;

import javax.persistence.Entity;
import com.grgbanking.platform.core.entity.BaseEntity;

@Entity
public class SmsSerialStatis extends BaseEntity {

	private String sOrgName;	//机构名称
	//private int sSerialResult;	//查询结果
	private int sQueryCount;	//涉假查询次数
	private int hasPaid1;	//已付出假币数
	private int hasPaid2;	//未付出假币数
	
	public String getsOrgName() {
		return sOrgName;
	}
	public void setsOrgName(String sOrgName) {
		this.sOrgName = sOrgName;
	}
//	public int getsSerialResult() {
//		return sSerialResult;
//	}
//	public void setsSerialResult(int sSerialResult) {
//		this.sSerialResult = sSerialResult;
//	}
	public int getsQueryCount() {
		return sQueryCount;
	}
	public void setsQueryCount(int sQueryCount) {
		this.sQueryCount = sQueryCount;
	}
	public int getHasPaid1() {
		return hasPaid1;
	}
	public void setHasPaid1(int hasPaid1) {
		this.hasPaid1 = hasPaid1;
	}
	public int getHasPaid2() {
		return hasPaid2;
	}
	public void setHasPaid2(int hasPaid2) {
		this.hasPaid2 = hasPaid2;
	}		
}
