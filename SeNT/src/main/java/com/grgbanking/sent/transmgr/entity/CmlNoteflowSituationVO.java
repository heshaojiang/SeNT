/**
 * 文件名：CmlNoteflowSituationVO.java
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
 * 网点流转情况统计VO
 * 
 * 
 * @author lwgang
 * 
 */
public class CmlNoteflowSituationVO {

	private String pathCode;
	private String clearingDate;

	private BigDecimal noteCount = new BigDecimal(0);
	private BigDecimal totalNotes = new BigDecimal(0);

	public void setPathCode(String pathCode) {
		this.pathCode = pathCode;
	}

	public String getPathCode() {
		return pathCode;
	}

	public void setClearingDate(String clearingDate) {
		this.clearingDate = clearingDate;
	}

	public String getClearingDate() {
		return clearingDate;
	}

	public BigDecimal getNoteCount() {
		return noteCount;
	}

	public void setNoteCount(BigDecimal noteCount) {
		this.noteCount = noteCount;
	}

	public BigDecimal getTotalNotes() {
		return totalNotes;
	}

	public void setTotalNotes(BigDecimal totalNotes) {
		this.totalNotes = totalNotes;
	}
}
