package com.grgbanking.sent.transmgr.entity;

public class CashStatisticRecordReportVO {
	
	private String denomination;//面额
	
	private String collectQuarter;//季度集中清分
	private String collectAnnual;//年度集中清分
	private String collectPercent;//本期集中清分占比
	
	private String branchQuarter ;//季度网点清分
	private String branchAnnual ;//年度网点清分
	private String branchPercent;//本期网点清分占比
	
	private String clearingQuarter;//季度清分
	private String clearingAnnual;//年度清分
	private String clearingPercent;//本期清分占比
	
	private String byHandQuarter;//季度手工清分
	private String byHandAnnual;//年度手工清分
	private String byHandPercent;//本期手工清分占比
	
	private String allQuarter; //季度所有清分
	private String allAnnual;  //年度所有清分
	
	
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getCollectQuarter() {
		return collectQuarter;
	}
	public void setCollectQuarter(String collectQuarter) {
		this.collectQuarter = collectQuarter;
	}
	public String getCollectAnnual() {
		return collectAnnual;
	}
	public void setCollectAnnual(String collectAnnual) {
		this.collectAnnual = collectAnnual;
	}
	public String getBranchQuarter() {
		return branchQuarter;
	}
	public void setBranchQuarter(String branchQuarter) {
		this.branchQuarter = branchQuarter;
	}
	public String getBranchAnnual() {
		return branchAnnual;
	}
	public void setBranchAnnual(String branchAnnual) {
		this.branchAnnual = branchAnnual;
	}
	public String getByHandQuarter() {
		return byHandQuarter;
	}
	public void setByHandQuarter(String byHandQuarter) {
		this.byHandQuarter = byHandQuarter;
	}
	public String getByHandAnnual() {
		return byHandAnnual;
	}
	public void setByHandAnnual(String byHandAnnual) {
		this.byHandAnnual = byHandAnnual;
	}
	public String getCollectPercent() {
		return collectPercent;
	}
	public void setCollectPercent(String collectPercent) {
		this.collectPercent = collectPercent;
	}
	public String getBranchPercent() {
		return branchPercent;
	}
	public void setBranchPercent(String branchPercent) {
		this.branchPercent = branchPercent;
	}
	public String getClearingQuarter() {
		return clearingQuarter;
	}
	public void setClearingQuarter(String clearingQuarter) {
		this.clearingQuarter = clearingQuarter;
	}
	public String getClearingAnnual() {
		return clearingAnnual;
	}
	public void setClearingAnnual(String clearingAnnual) {
		this.clearingAnnual = clearingAnnual;
	}
	public String getClearingPercent() {
		return clearingPercent;
	}
	public void setClearingPercent(String clearingPercent) {
		this.clearingPercent = clearingPercent;
	}
	public String getByHandPercent() {
		return byHandPercent;
	}
	public void setByHandPercent(String byHandPercent) {
		this.byHandPercent = byHandPercent;
	}
	public String getAllQuarter() {
		return allQuarter;
	}
	public void setAllQuarter(String allQuarter) {
		this.allQuarter = allQuarter;
	}
	public String getAllAnnual() {
		return allAnnual;
	}
	public void setAllAnnual(String allAnnual) {
		this.allAnnual = allAnnual;
	}
	
	



}
