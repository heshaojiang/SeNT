package com.grgbanking.sent.transmgr.entity;

public class CashIncomePayStatisticReportVO {
	
	private String bank;//银行
	private String incomeCount;//收入金额
	private String cashPayCount;//现金付出金额
	private String sorterBig;//清分机100、50
	private String sorterMiddle;//清分机20、10
	private String sorterSmall;//清分机5、1
	private String sorterCount;//清分机合计金额
	private String byHandBig;//手工100、50
	private String byHandMiddle;//手工20、10
	private String byHandSmall;//手工5、1
	private String byHandCount;//手工清分合计金额
	
	
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getIncomeCount() {
		return incomeCount;
	}
	public void setIncomeCount(String incomeCount) {
		this.incomeCount = incomeCount;
	}
	public String getCashPayCount() {
		return cashPayCount;
	}
	public void setCashPayCount(String cashPayCount) {
		this.cashPayCount = cashPayCount;
	}
	public String getSorterBig() {
		return sorterBig;
	}
	public void setSorterBig(String sorterBig) {
		this.sorterBig = sorterBig;
	}
	public String getSorterMiddle() {
		return sorterMiddle;
	}
	public void setSorterMiddle(String sorterMiddle) {
		this.sorterMiddle = sorterMiddle;
	}
	public String getSorterSmall() {
		return sorterSmall;
	}
	public void setSorterSmall(String sorterSmall) {
		this.sorterSmall = sorterSmall;
	}
	public String getSorterCount() {
		return sorterCount;
	}
	public void setSorterCount(String sorterCount) {
		this.sorterCount = sorterCount;
	}
	public String getByHandBig() {
		return byHandBig;
	}
	public void setByHandBig(String byHandBig) {
		this.byHandBig = byHandBig;
	}
	public String getByHandMiddle() {
		return byHandMiddle;
	}
	public void setByHandMiddle(String byHandMiddle) {
		this.byHandMiddle = byHandMiddle;
	}
	public String getByHandSmall() {
		return byHandSmall;
	}
	public void setByHandSmall(String byHandSmall) {
		this.byHandSmall = byHandSmall;
	}
	public String getByHandCount() {
		return byHandCount;
	}
	public void setByHandCount(String byHandCount) {
		this.byHandCount = byHandCount;
	}
	
	
	

}
