package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;

public class TotalInfo
{
	public BigDecimal totalAll = new BigDecimal(0);
	
	public BigDecimal totalDistByBunch = new BigDecimal(0);
	public BigDecimal totalDistByWholeBox = new BigDecimal(0);
	public BigDecimal totalDistByKXCashbox = new BigDecimal(0);
	public BigDecimal totalDistByCashbag = new BigDecimal(0);
	public BigDecimal totalDistOffBank = new BigDecimal(0);
	public BigDecimal totalDistAtBranch = new BigDecimal(0);
	
	public BigDecimal getTotalAll()
	{
		return totalAll;
	}
	public void setTotalAll(BigDecimal totalAll)
	{
		this.totalAll = totalAll;
	}
	public BigDecimal getTotalDistByBunch()
	{
		return totalDistByBunch;
	}
	public void setTotalDistByBunch(BigDecimal totalDistByBunch)
	{
		this.totalDistByBunch = totalDistByBunch;
	}
	public BigDecimal getTotalDistByWholeBox()
	{
		return totalDistByWholeBox;
	}
	public void setTotalDistByWholeBox(BigDecimal totalDistByWholeBox)
	{
		this.totalDistByWholeBox = totalDistByWholeBox;
	}
	public BigDecimal getTotalDistByKXCashbox()
	{
		return totalDistByKXCashbox;
	}
	public void setTotalDistByKXCashbox(BigDecimal totalDistByKXCashbox)
	{
		this.totalDistByKXCashbox = totalDistByKXCashbox;
	}
	public BigDecimal getTotalDistByCashbag()
	{
		return totalDistByCashbag;
	}
	public void setTotalDistByCashbag(BigDecimal totalDistByCashbag)
	{
		this.totalDistByCashbag = totalDistByCashbag;
	}
	public BigDecimal getTotalDistAtBranch()
	{
		return totalDistAtBranch;
	}
	public void setTotalDistAtBranch(BigDecimal totalDistAtBranch)
	{
		this.totalDistAtBranch = totalDistAtBranch;
	}
	public BigDecimal getTotalDistOffBank()
	{
		return totalDistOffBank;
	}
	public void setTotalDistOffBank(BigDecimal totalDistOffBank)
	{
		this.totalDistOffBank = totalDistOffBank;
	}
	
}
