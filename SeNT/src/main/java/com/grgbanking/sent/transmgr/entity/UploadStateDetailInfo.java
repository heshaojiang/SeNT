/**
 * 文件名：UploadStateDetailInfo.java
 * 创建日期： 2014-7-17
 * Copyright (c) 2014 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间：
 *   修改人：
 *   生成版本：
 *   修改内容：
 */
package com.grgbanking.sent.transmgr.entity;

/**
 * 网点上传情况结果类
 * 
 * @author hjyi
 * 
 */
public class UploadStateDetailInfo {

	/**
	 * 终端编号
	 */
	private String termId;

	/**
	 * 机构编号
	 */
	private String orgId;

	/**
	 * 机构名称
	 */
	private String orgName;
	
	/**
	 * 成功数
	 */
	private int successCount;

	/**
	 * 不成功数
	 */
	private int failureCount;

	/**
	 * 终端编号
	 */
	public String getTermId() {
		return termId;
	}

	/**
	 * 终端编号
	 */
	public void setTermId(String termId) {
		this.termId = termId;
	}

	/**
	 * 机构编号
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * 机构编号
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * 机构名称
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * 机构名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * 成功数
	 */
	public int getSuccessCount() {
		return successCount;
	}

	/**
	 * 成功数
	 */
	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	/**
	 * 不成功数
	 */
	public int getFailureCount() {
		return failureCount;
	}

	/**
	 * 不成功数
	 */
	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}

}
