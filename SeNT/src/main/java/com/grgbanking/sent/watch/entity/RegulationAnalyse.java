package com.grgbanking.sent.watch.entity;
	/**
	 *  黑名单规则分析
	 *  由黑名单名称和次数组成的实体
	 */
public class RegulationAnalyse {
	private String regulation;
	private Long count;
	/**
	 *Constructor  unUsedField
	 */

	public RegulationAnalyse() {
	}
 
	/**
	 *  黑名单规则
	 *  @return regulation
	 */
	public String getRegulation() {
		return regulation;
	}
     /**
      * @param regulation 黑名单规则
      */
	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}
    
	/**
	 * 次数
	 * @return count; 
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
