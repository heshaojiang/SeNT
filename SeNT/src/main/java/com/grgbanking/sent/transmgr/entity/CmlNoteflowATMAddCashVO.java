/**
 * 文件名：CmlNoteflowATMaddCashVO.java
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
 * 网点Atm配钞统计VO
 * 
 * 
 * @author lwgang
 * 
 */
public class CmlNoteflowATMAddCashVO {

	private String pathCode;
	private String termId;
	private String addDate;

	private BigDecimal addCashAtBranchAmount = new BigDecimal(0);

	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}

	public String getPathCode() {
		return pathCode;
	}

	public void setTermId(String termId) {
		this.termId = termId;
	}

	public String getTermId() {
		return termId;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddCashAtBranchAmount(BigDecimal addCashAtBranchAmount) {
		this.addCashAtBranchAmount = addCashAtBranchAmount;
	}

	public BigDecimal getAddCashAtBranchAmount() {
		return addCashAtBranchAmount;
	}
}
