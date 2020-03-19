/**
 * 文件名：AppConstants.java
 * 创建日期： 2012-2-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.common.Constants;

/**
 * User: Vinson Date: 6/17/11 Time: 3:20 PM To change this template use File |
 * Settings | File Templates.
 * 
 * @author yrliang
 */

public class AppConstants {
	/** 平台用户 SCHEMA */
	public static final String SCHEMA_NAME = "FEELVIEW";
	/** 报表导出最大记录条数 **/
	public static final int EXPORT_MAX_SIZE = 10000;
	// Common Constants
	/** Meaningless primary key */
	public static final String ID = "id";
	/** The action type when user login */
	public static final String ACTION_TYPE_LOGIN = "I";
	/** The action type when user logout */
	public static final String ACTION_TYPE_LOGOUT = "O";
	/** Fields' name of entities */
	public static final String NOTE = "note";
	/** Fields' name of entities */
	public static final String LEVEL = "level";
	/** Fields' name of entities */
	public static final String LEVEL_CODE = "levelCode";
	/** Fields' name of entities */
	public static final String ORDER = "order";
	/** Fields' name of entities */
	public static final String GRP_NAME = "grpName";
	/** Fields' name of entities */
	public static final String ROLE_ID = "roleId";
	/** Fields' name of entities */
	public static final String ROLE_NAME = "roleName";
	/** Fields' name of entities */
	public static final String ROLE_LEVEL = "roleLevel";
	/** Fields' name of entities */
	public static final String PRIVILEGE_ID = "priviId";
	/** Fields' name of entities */
	public static final String REFERENCE_ID = "referenceid";
	/** Fields' name of entities */
	public static final String MENU_ID = "menuId";
	/** Fields' name of entities */
	public static final String BUTTON_ID = "buttonId";
	/** Fields' name of entities */
	public static final String AREA_NAME = "areaName";
	/** Fields' name of entities */
	public static final String C_ORGNAME = "orgName";
	/** Fields' name of entities */
	public static final String ORG_CODE = "orgCode";
	/** Fields' name of entities */
	public static final String PATH_CODE = "pathCode";

	/** parentId */
	public static final String PARENT_ID = "parentId";
	/** Fields' name of entities */
	public static final String CHILD_ID = "childId";
	/** Fields' name of entities */
	public static final String PARENT_NAME = "parentName";
	/** Fields' name of entities */
	public static final String CHILD_NAME = "childName";

	/** Fields' name of VO */
	public static final String SELECTED = "selected";
	/** Fields' name of VO */
	public static final String IS_BUTTON = "isButton";

	/** Fields' name of entities */
	public static final String CARD_ID = "cardId";
	/** Fields' name of entities */
	public static final String TERMINAL_TYPE = "type";
	/** Fields' name of entities */
	public static final String TERMINAL_BRANDNAME = "brandName";
	/** Fields' name of entities */
	public static final String TERMINAL_MODELNAME = "modelName";
	/** Fields' name of entities */
	public static final String TERMINAL_TERMCODE = "termCode";

	public static final String NODER_IP = "noderIP" ;
	
	/** Key name of priviMap use in UserService */
	public static final String PRIVI_BUTTONS = "priviButtons";
	/** Key name of priviMap use in UserService */
	public static final String PRIVI_ICONS = "priviIcons";
	/** Key name of priviMap use in UserService */
	public static final String PRIVI_PRIVIS = "privileges";

	/** 登录用户信息UserInfo Map的key，对应value是用户基本信息 */
	public static final String USER_BASE_INFO = "userBaseInfo";
	/** 登录用户信息UserInfo Map的key，对应value是用户机构id */
	public static final String ORG_ID = "orgId";
	/** 登录用户信息UserInfo Map的key，对应value是用户机构name */
	public static final String ORG_NAME = "orgName";
	/** 登录用户信息UserInfo Map的key，对应value是用户机构name */
	public static final String ORG_FULL_NAME = "orgFullName";
	/** 登录用户信息UserInfo Map的key，对应value是用户父机构id */
	public static final String ORG_PARENT_ID = "orgParentId";
	/** 登录用户信息UserInfo Map的key，对应value是用户机构权限控制pathCode */
	public static final String ORG_PATH_CODE = "orgPathCode";
	/** 登录用户信息UserInfo Map的key，对应value是用户机构金融机构代码finacialCode */
	public static final String ORG_FINACIAL_CODE = "finacialCode";
	/** 登录用户信息UserInfo Map的key，对应value是系统超时时间 */
	public static final String FLEX_TIMEOUT = "flexTimeOut";
	/** 登录用户信息UserInfo Map的key，对应value是账号是否过期标志 */
	public static final String ACCOUNT_EXPIRED = "accountExpired";
	/** 登录用户信息UserInfo Map的key，对应value密码过期提醒提前天数 */
	public static final String PASSWORD_REMIND_DAYS = "passwordRemindDays";
	/** 登录用户信息UserInfo Map的key，对应value是登录出错的次数 */
	public static final String LOGIN_FAIL_COUNT = "loginFailCount";

	/** 清楚DAYS_CLEAN_LOGINLOG天前登录日志 */
	public static final int DAYS_CLEAN_LOGINLOG = 180;
	/** 清楚DAYS_CLEAN_LOGINLOG天前操作日志 */
	public static final int DAYS_CLEAN_OPERLOG = 180;

	/** 数据字典用户角色管理->职位级别的path */
	public static final String USERPOSLEVELMANAGER_PATH = "SysDatadirMgr.javapt.userRoleManager.posLevel";
	/** 数据字典户角色管理->岗位级别的path */
	public static final String USERPOSTYPEMANAGER_PATH = "SysDatadirMgr.javapt.userRoleManager.posType";
	/** 数据字典户角色管理->角色级别的path */
	public static final String USERROLEMANAGER_PATH = "SysDatadirMgr.javapt.userRoleManager.roleLevel";

	/** 数据字典终端管理->布放模式的path */
	public static final String SERVICE_TYPE_PATH = "SysDatadirMgr.javapt.term.serviceType";
	/** 数据字典终端管理->安装方式的path */
	public static final String INST_TYPE_PATH = "SysDatadirMgr.javapt.term.instType";
	/** 数据字典终端管理->设立形式的path */
	public static final String LAY_TYPE_PATH = "SysDatadirMgr.javapt.term.layType";
	/** 数据字典终端管理->机具类型的path */
	public static final String MACHINE_TYPE_PATH = "SysDatadirMgr.javapt.term.machineType";
	/** 数据字典终端管理->是或否 */
	public static final String YES_OR_NO = "SysDatadirMgr.javapt.common.yesOrNo";
	/** 数据字典终端管理->是否视频监控的path */
	public static final String ISVIDEO_WATCH_PATH = "SysDatadirMgr.javapt.term.isVideoWatch";
	/** 数据字典终端管理->是否安装UPS的path */
	public static final String IS_UPS_PATH = "SysDatadirMgr.javapt.term.isUPS";
	/** 数据字典终端管理->是否受理国际卡的path */
	public static final String IS_INTERATM_PATH = "SysDatadirMgr.javapt.term.isInterATM";
	/** 报停状态路径 **/
	public static final String STOP_FLAG_PATH = "SysDatadirMgr.feelview.asset.repStopStatues";
	/** 报停原因路径 **/
	public static final String STOP_REASON_PATH = "SysDatadirMgr.feelview.asset.stopReason";

	/** 参数 验证类型 **/
	public static final String VALIDATE_TYPES_PATH = "param.javapt.validateTypes";

	/** 参数 系统超时时间 path */
	public static final String FLEX_TIMEOUT_PATH = "param.javapt.loginAndPassword.FlexTimeouts";
	/** 参数 密码有效期 path */
	public static final String PASSWORD_VALID_DAYS_PATH = "param.javapt.loginAndPassword.PasswordValidDays";
	/** 参数 密码提前提醒天数 path */
	public static final String PASSWORD_REMIND_DAYS_PATH = "param.javapt.loginAndPassword.PasswordRemindDays";
	/** 锁定密码的登录失败次数 path */
	public static final String MAX_LOGIN_FAIL_COUNT = "param.javapt.loginAndPassword.MaxLoginFailCount";

	/** 定期清理登录日志的间隔天数 path */
	public static final String INTERVALS_CLEAN_LOGINLOG = "param.javapt.systemLog.IntervalsCleanLoginlog";
	/** 定期清理操作日志的间隔天数 path */
	public static final String INTERVALS_CLEAN_OPERLOG = "param.javapt.systemLog.IntervalsCleanOperlog";

	/** 短信参数设置 **/
	public static final String SMS_SETTING_PATH = "param.javapt.smsSetting";
	/** 短信发送方式 */
	public static final String SMS_SETTING_SENDMETHOD_PATH = "param.javapt.smsSetting.sendMethod";
	/** 编码 */
	public static final String SMS_SETTING_ENCODING_PATH = "param.javapt.smsSetting.encoding";
	/** 串口号 */
	public static final String SMS_SETTING_COMPORT_PATH = "param.javapt.smsSetting.comPort";
	/** 串口速率 */
	public static final String SMS_SETTING_COMBAUD_PATH = "param.javapt.smsSetting.comBaud";
	/** 内容模板 */
	public static final String SMS_SETTING_CONTENT_TEMPLATE_PATH = "param.javapt.smsSetting.contentTemplate";

	/** 服务器IP */
	public static final String SMS_SETTING_SERVERIP_PATH = "param.javapt.smsSetting.serverIP";
	/** 服务器port */
	public static final String SMS_SETTING_SERVERPORT_PATH = "param.javapt.smsSetting.serverPort";
	/** 服务器账号 */
	public static final String SMS_SETTING_USER_PATH = "param.javapt.smsSetting.user";
	/** 服务器密码 */
	public static final String SMS_SETTING_PASSWORD_PATH = "param.javapt.smsSetting.password";
	/** FTP目录 */
	public static final String SMS_SETTING_FTPDIR_PATH = "param.javapt.smsSetting.ftpDir";
	/** FTP文件名 */
	public static final String SMS_SETTING_FTP_FILENAME_PATH = "param.javapt.smsSetting.ftpFileName";
	/** 数据库类型 */
	public static final String SMS_SETTING_DBTYPE_PATH = "param.javapt.smsSetting.dbType";
	/** 数据库sid */
	public static final String SMS_SETTING_DBSID_PATH = "param.javapt.smsSetting.dbSid";
	/** sql语句模板 */
	public static final String SMS_SETTING_SQLTEMPLATE_PATH = "param.javapt.smsSetting.sql";

	/** 邮件参数设置 */
	public static final String EMAIL_SETTING_PATH = "param.javapt.emailSetting";
	/** 邮件服务器 */
	public static final String EMAIL_SETTING_SERVERNAME_PATH = "param.javapt.emailSetting.serverName";
	/** 邮件 账号 */
	public static final String EMAIL_SETTING_USER_PATH = "param.javapt.emailSetting.user";
	/** 邮件 账号密码 **/
	public static final String EMAIL_SETTING_PASSWORD_PATH = "param.javapt.emailSetting.password";
	/** 发件箱 **/
	public static final String EMAIL_SETTING_FROM_PATH = "param.javapt.emailSetting.from";

	/** 机构层级路径长度 */
	public static final String ORG_LEVELCODE_LENGTH_PATH = "param.javapt.orgManager.levelCodeLength";

	/** 币种最小面值的配置符,系统只保存到分, 如： 中国显示元，则需要把金额除两位 */
	public static final String DENOMINATION = "param.feelview.system.denomination";
	/**
	 * 项目间分隔符
	 */
	public static final String ITEM_SEPARATOR = ".";

	/**
	 * 根目录路径
	 */
	public static final String ROOT = "\\";

	/**
	 * 最顶层项目的父ID
	 */
	public static final String TOP_PARENT_ID = "0";

	/** 数据字典币种管理->币种path */
	public static final String FUND_TYPE_PATH = "SysDatadirMgr.javapt.tradeChange.currency";

	/** 数据字典卡种管理->卡种path */
	public static final String CARD_TYPE_PATH = "systemManager.cardManager.cardType.debitCard";
	
	/** */
	public static final String BOX_TYPE="SysDatadirMgr.sent.boxMgr";
	
	public static final String BOX_TYPE_ATM = "1";
	
	public static final String BOX_TYPE_BRANCH = "2";
	
	/** 中国机构名称 */
	public static final String ORG_CHINA_ORGNAME = "中国机构";
	
	/** 中国机构pathcode */
	public static final String ORG_CHINA_PATHCODE = "0000100001";

//	
//	/** 机构权限控制标志 */
//	public static final String ORG_PRIVILEGE_FILTER_FLAG_PATH = "param.javapt.orgManager.orgPrivilegeFilterFlag";
//	
//	/** 机构权限根机构ID */
//	public static final String ORG_PRIVILEGE_ROOT_ID_PATH = "param.javapt.orgManager.orgPrivilegeRootID";
//	
//	/**  */
//	public static final String ENABLE_OR_DISABLE = "SysDatadirMgr.javapt.common.enableOrDisable";
}
