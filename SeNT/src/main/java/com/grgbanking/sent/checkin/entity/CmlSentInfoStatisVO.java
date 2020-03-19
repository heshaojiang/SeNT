package com.grgbanking.sent.checkin.entity;


import javax.persistence.Entity;

import com.grgbanking.platform.core.entity.BaseEntity;

@Entity
public class CmlSentInfoStatisVO extends BaseEntity {

	private int noteType;	//钞票类型
	private int queryResult;	//查询结果
	private int queryCount;	//结果数量
	private boolean registerOrNot;	//该冠字号是否登记
	/*
	 * add by whxing 
	 * 描述：用于人民币冠字号检索登记中，新增功能检索冠字号信息需要字段
	 */
	private String recordDate;//记录时间 
	
	
	public boolean isRegisterOrNot() {
		return registerOrNot;
	}
	public void setRegisterOrNot(boolean registerOrNot) {
		this.registerOrNot = registerOrNot;
	}
	public int getNoteType() {
		return noteType;
	}
	public void setNoteType(int noteType) {
		this.noteType = noteType;
	}
	public int getQueryResult() {
		return queryResult;
	}
	public void setQueryResult(int queryResult) {
		this.queryResult = queryResult;
	}
	public int getQueryCount() {
		return queryCount;
	}
	public void setQueryCount(int queryCount) {
		this.queryCount = queryCount;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	
}
