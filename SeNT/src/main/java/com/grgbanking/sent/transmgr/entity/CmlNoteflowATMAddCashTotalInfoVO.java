/**
 * 文件名：CmlNoteflowATMaddCashTotalInfoVO.java
 * 创建日期： 2013-11-08
 * Copyright (c) 2013 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.sent.transmgr.entity;

import java.math.BigDecimal;

/**
 * 网点Atm配钞统计汇总VO
 * 
 * 
 * @author lwgang
 * 
 */
public class CmlNoteflowATMAddCashTotalInfoVO {
	
	private BigDecimal allAddCashAtBranchAmount = new BigDecimal(0);

	public void setAllAddCashAtBranchAmount(BigDecimal allAddCashAtBranchAmount) {
		this.allAddCashAtBranchAmount = allAddCashAtBranchAmount;
	}

	public BigDecimal getAllAddCashAtBranchAmount() {
		return allAddCashAtBranchAmount;
	}

}
