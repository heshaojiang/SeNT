package com.grgbanking.sent.transmgr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.sent.transmgr.entity.BarcodeInCashbox;

/**
 * 
 * @author 广电运通
 */
@Repository
public class BarcodeInCashboxDao extends BaseDao<BarcodeInCashbox>
{
	
	/**
	 * 
	 */
	public void deleteByBoxNum(String boxNum)
	{
		String hql = " delete BarcodeInCashbox bic where bic.boxNum=?";
		this.executeUpdate(hql, boxNum);
	}
	
	/**
	 * 
	 */
	public void deleteByBarcodeFlowNum(String barcodeFlowNum)
	{
		String hql = " delete BarcodeInCashbox bic where bic.barcodeFlowNum=?";
		this.executeUpdate(hql, barcodeFlowNum);
	}
	
	/**
	 * 
	 */
	public void addNew(String boxNum, String barcodeFlowNum)
	{
		BarcodeInCashbox bic = new BarcodeInCashbox();
		bic.setBoxNum(boxNum);
		bic.setBarcodeFlowNum(barcodeFlowNum);
		this.saveNew(bic);
	}
	
	/**
	 * 
	 */
	public List<BarcodeInCashbox> findByBoxNum(String boxNum)
	{
		String hql = " from BarcodeInCashbox bic where bic.boxNum = ?";
		return this.find(hql, boxNum);
	}
	
	/**
	 * 
	 */
	public BarcodeInCashbox findByBarcodeFlowNum(String barcodeFlowNum)
	{
		String hql = " from BarcodeInCashbox bic where bic.barcodeFlowNum = ?";
		return this.findFirst(hql, barcodeFlowNum);
	}
	
}
