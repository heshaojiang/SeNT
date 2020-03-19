/**
 * 文件名：UploadStateConsts.java
 * 创建日期： 2014-7-17
 * Copyright (c) 2014 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间：
 *   修改人：
 *   生成版本：
 *   修改内容：
*/
package com.grgbanking.sent.transmgr.constants;

/**
 * @author hjyi
 *
 */
public class UploadStateConsts {

	/**
	 * 上传状态-上传未完成
	 */
	public static final String UPLOAD_UNFINISH = "1";
	
   public static final String AUTO_TASK_FAIL = "1" ;  // 自动上报任务执行失败
	
	public static final String AUTO_TASK_SUCCESS = "0" ;  // 自动上报任务执行成功
	
	public static final String TASK_UNDO = "0" ;  // 手动上报任务未执行
	
	public static final String TASK_SUCCESS = "1" ;  // 手动上报任务执行成功
	
	public static final String TASK_FAIL = "2" ;  // 手动上报任务执行失败
	
	public static final String EXECUTE_TASK_AUTO = "0" ;  // 自动执行文件导出任务
	
	public static final String EXECUTE_TASK_BY_HAND = "1" ; // 手动执行文件导出任务
	
	public static final String REMOTE_ORG_TASK = "0" ;      // 异地机构任务
	
    public static final String LOCALE_ORG_TASK = "1" ;      // 本机机构任务
    
    public static final String AUTO_UPLOAD = "1" ;          // 自动上报人行文件
    
    public static final String NO_AUTO_UPLOAD = "0" ;          // 不自动上报人行文件
    
    public static final String AUTO_UPLOAD_STATUS_0 = "0" ;      // 未自动上报
    
    public static final String AUTO_UPLOAD_STATUS_1 = "1" ;            // 自动上报成功
    
    public static final String AUTO_UPLOAD_STATUS_2 = "2" ;            // 自动上报失败

    
}
