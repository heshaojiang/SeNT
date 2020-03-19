package com.grgbanking.sent.watch.entity;
	/**
	 *  终端异常分析
	 *  由终端编号和次数组成的实体
	 */
 
public class TmlAnalyse {
	private String termid;
	private Long count;
	/**
	 *Constructor  unUsedField
	 */
	public TmlAnalyse() {
	}

	 /**
	  * 终端编号
	  * @return termid
	  */
	public String getTermid() {
		return termid;
	}

	/**
	 *@param termid 终端编号 
	 */ 
	public void setTermid(String termid) {
		this.termid = termid;
	}
	/**
	 * 次数
	 * @return count 次数
	 */

	public Long getCount() {
		return count;
	}
    /**
     * @param count 次数 
     */
	public void setCount(Long count) {
		this.count = count;
	}
}
