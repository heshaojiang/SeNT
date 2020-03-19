package com.grgbanking.sent.transmgr.entity;

public class BankSNMarkReport {
	
	private String drawTermCount;
	private String drawAndDepositTermCount;
	private String counterTermCount;
	
	private String currentBank;
	public String getDrawTermCount() {
		return drawTermCount;
	}
	public void setDrawTermCount(String drawTermCount) {
		this.drawTermCount = drawTermCount;
	}
	public String getDrawAndDepositTermCount() {
		return drawAndDepositTermCount;
	}
	public void setDrawAndDepositTermCount(String drawAndDepositTermCount) {
		this.drawAndDepositTermCount = drawAndDepositTermCount;
	}
	public String getCounterTermCount() {
		return counterTermCount;
	}
	public void setCounterTermCount(String counterTermCount) {
		this.counterTermCount = counterTermCount;
	}
	public String getCurrentBank() {
		return currentBank;
	}
	public void setCurrentBank(String currentBank) {
		this.currentBank = currentBank;
	}
	
	
	
	

}
