/**
 * 文件名：AuditConstants.java
 * 创建日期： 2014-6-30
 * Copyright (c) 2014 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间：
 *   修改人：
 *   生成版本：
 *   修改内容：
*/
package com.grgbanking.sent.audit.constants;

/**
 * 审核操作常量
 * 
 * @author hjyi
 *
 */
public class AuditConstants {

	/**
	 * 审核状态--拒绝
	 */
	public static final String AUDIT_REFUSE = "0";
	
	/**
	 * 审核状态--申请
	 */
	public static final String AUDIT_APPLY = "1";
	
	/**
	 * 审核状态--取消
	 */
	public static final String AUDIT_CANCEL = "8";
	
	/**
	 * 审核状态--通过
	 */
	public static final String AUDIT_PASS = "9";
	
}
