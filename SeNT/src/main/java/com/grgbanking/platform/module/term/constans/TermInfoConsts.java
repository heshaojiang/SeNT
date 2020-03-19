package com.grgbanking.platform.module.term.constans;

public class TermInfoConsts {
	
	public static final String MACHINE_TYPE_CLEARING  = "0";	// 清分机
	public static final String MACHINE_TYPE_ATM_CKQK  = "1";	// 存取款一体机
	public static final String MACHINE_TYPE_ATM_QK  = "2";	// 取款机
	public static final String MACHINE_TYPE_COUNTER  = "3";	// A类点钞机
	public static final String MACHINE_TYPE_NODER  = "4";	// 节点机
	public static final String NODER_PACKAGE_SAVE_PATH = "param.sent.NoderPackagePath.noderPackageBasePath" ;
	public static final String NODER_STATUS = "SysDatadirMgr.javapt.term.runningStatus" ;
	public static final String NODER_TYPE = "SysDatadirMgr.javapt.term.noderType" ;
	
	public static final String NODER_FILE_TYPE = "SysDatadirMgr.javapt.term.noderFileType" ;//节点机文件类型
	public static final String NODER_FILE_STATUS = "SysDatadirMgr.javapt.term.noderFileStatus" ;//节点机文件状态
	
	
	/** 节点机文件获取状态-初始化 */
	public static final String NODER_FILE_STATUS_INIT = "0";
	/** 节点机文件获取状态-成功 */
	public static final String NODER_FILE_STATUS_SUCCESS = "1";
	/** 节点机文件获取状态-失败 */
	public static final String NODER_FILE_STATUS_FAILED = "2";
	
	/** 节点机文件类型-文件 */
	public static final String NODER_FILE_TYPE_FILE = "1";
	/** 节点机文件类型-日志文件 */
	public static final String NODER_FILE_TYPE_LOG = "2";
	/** 节点机文件类型-文件夹 */
	public static final String NODER_FILE_TYPE_FOLDER = "3";
	
	/** 节点机类型-地市server */
	public static final String NODER_TYPE_SERVER = "0";
	/** 节点机类型-网点节点机 */
	public static final String NODER_TYPE_BRANCH = "1";
	/** 节点机类型-柜面节点机 */
	public static final String NODER_TYPE_COUNTER = "2";
	/** 节点机类型-节点机管理端 */
	public static final String NODER_TYPE_MANAGER = "3";
	
}
