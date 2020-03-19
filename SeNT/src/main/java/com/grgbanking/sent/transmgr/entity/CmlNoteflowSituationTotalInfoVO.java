/**
 * 文件名：CmlNoteflowSituationTotalInfoVO.java
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
 * 网点流转情况统计汇总结果VO
 * 
 * 
 * @author lwgang
 * 
 */
public class CmlNoteflowSituationTotalInfoVO {

	private BigDecimal allNoteCount = new BigDecimal(0);
	private BigDecimal allTotalNotes = new BigDecimal(0);
	
	public void setAllNoteCount(BigDecimal allNoteCount) {
		this.allNoteCount = allNoteCount;
	}
	public BigDecimal getAllNoteCount() {
		return allNoteCount;
	}
	public void setAllTotalNotes(BigDecimal allTotalNotes) {
		this.allTotalNotes = allTotalNotes;
	}
	public BigDecimal getAllTotalNotes() {
		return allTotalNotes;
	}
	
}
