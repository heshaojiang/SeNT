/**
 * 文件名：BlackRegulationConstants.java
 * 创建日期： 2014-6-30
 * Copyright (c) 2014 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间：
 *   修改人：
 *   生成版本：
 *   修改内容：
*/
package com.grgbanking.sent.rule.constants;

/**
 * 黑名单规则常量
 * 
 * @author hjyi
 *
 */
public class BlackRegulationConstants {
	
	/**
	 * 规则状态--申请中
	 * */
	public static final int RULESTATUS_APPLY = 1;
	
	/**
	 * 规则状态--已通过
	 * */
	public static final int RULESTATUS_PASS = 2;
	
	/**
	 * 规则状态--已拒绝
	 * */
	public static final int RULESTATUS_REFUSE = 3;
	
	/**
	 * 规则状态--删除中
	 * */
	public static final int RULESTATUS_DELETE = 4;

	/**
	 * 下发状态--待下发
	 */
	public static final int DELIVERSTATUS_READY = 1;
	
	/**
	 * 下发状态--已下发
	 */
	public static final int DELIVERSTATUS_SUCCESS = 2;
	
}
