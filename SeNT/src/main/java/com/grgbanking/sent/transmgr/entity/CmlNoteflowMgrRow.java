package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;


public class CmlNoteflowMgrRow {

	public String iDate;
	
	public BigDecimal noteCount = new BigDecimal(0);
	public BigDecimal totalNotes = new BigDecimal(0);
	
	public BigDecimal cashboxByBunchAmount = new BigDecimal(0);
	public BigDecimal cashboxByWholeBoxAmount = new BigDecimal(0);
	public BigDecimal kxcashboxAmount = new BigDecimal(0);
	public BigDecimal cashbagAmount = new BigDecimal(0);
	public BigDecimal addCashOffBankAmount = new BigDecimal(0);
	public BigDecimal addCashAtBranchAmount = new BigDecimal(0);
	
	public String getiDate()
	{
		return iDate;
	}
	public void setiDate(String iDate)
	{
		this.iDate = iDate;
	}
	public BigDecimal getNoteCount()
	{
		return noteCount;
	}
	public void setNoteCount(BigDecimal noteCount)
	{
		this.noteCount = noteCount;
	}
	public BigDecimal getTotalNotes()
	{
		return totalNotes;
	}
	public void setTotalNotes(BigDecimal totalNotes)
	{
		this.totalNotes = totalNotes;
	}
	public BigDecimal getCashboxByBunchAmount()
	{
		return cashboxByBunchAmount;
	}
	public void setCashboxByBunchAmount(BigDecimal cashboxByBunchAmount)
	{
		this.cashboxByBunchAmount = cashboxByBunchAmount;
	}
	public BigDecimal getCashboxByWholeBoxAmount()
	{
		return cashboxByWholeBoxAmount;
	}
	public void setCashboxByWholeBoxAmount(BigDecimal cashboxByWholeBoxAmount)
	{
		this.cashboxByWholeBoxAmount = cashboxByWholeBoxAmount;
	}
	public BigDecimal getKxcashboxAmount()
	{
		return kxcashboxAmount;
	}
	public void setKxcashboxAmount(BigDecimal kxcashboxAmount)
	{
		this.kxcashboxAmount = kxcashboxAmount;
	}
	public BigDecimal getCashbagAmount()
	{
		return cashbagAmount;
	}
	public void setCashbagAmount(BigDecimal cashbagAmount)
	{
		this.cashbagAmount = cashbagAmount;
	}
	public BigDecimal getAddCashAtBranchAmount()
	{
		return addCashAtBranchAmount;
	}
	public void setAddCashAtBranchAmount(BigDecimal addCashAtBranchAmount)
	{
		this.addCashAtBranchAmount = addCashAtBranchAmount;
	}
	public BigDecimal getAddCashOffBankAmount()
	{
		return addCashOffBankAmount;
	}
	public void setAddCashOffBankAmount(BigDecimal addCashOffBankAmount)
	{
		this.addCashOffBankAmount = addCashOffBankAmount;
	}
	
	
	
	

	
	
}
