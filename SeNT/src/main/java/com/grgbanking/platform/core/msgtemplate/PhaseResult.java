/**
 * 文件名：PhaseResult.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.msgtemplate;

//encoding = GBK

/**
 * @author yaojun
 * 
 */
public class PhaseResult {

	/**
	 * true=解析成功；false=解析遇到异常，可查看errorinfo字段了解失败原因
	 */
	public Boolean success = false;

	/**
	 * 相关信息
	 */
	public String errorinfo = "";

	/**
	 * 模板生成结果
	 */
	public String outcome = "";

	/**
	 * 构造函数
	 */
	public PhaseResult() {
		this.success = false;
		this.errorinfo = "";
		this.outcome = "";
	}

}
