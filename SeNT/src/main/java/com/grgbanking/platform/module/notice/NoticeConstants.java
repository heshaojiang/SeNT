/**
 * 文件名：NoticeConstants.java
 * 创建日期： 2012-5-8
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice;

/**
 * @author yrliang
 * 
 */
public class NoticeConstants {
	/** 信息通知和短信发送状态：待发送 */
	public static final String STATUS_WAIT = "0";
	/** 信息通知和短信发送状态：部分成功 */
	public static final String STATUS_SUCCESS_SOME = "1";
	/** 信息通知和短信发送状态：发送成功 */
	public static final String STATUS_SUCCESS = "2";
	/** 信息通知和短信发送状态：发送失败 */
	public static final String STATUS_FAIL = "3";

	/** 信息通知方式：短信 */
	public static final String NOTICE_METHOD_SMS = "0";
	/** 信息通知方式：邮件 */
	public static final String NOTICE_METHOD_EMAIL = "1";
	/** 信息通知方式：站内信 */
	public static final String NOTICE_METHOD_SITEMSG = "2";

	/** 站内信未发布状态 */
	public static final Character SITEMSG_UNPUBLISHED = '0';
	/** 站内信已发布状态 */
	public static final Character SITEMSG_PUBLISHED = '1';

	/** gsm */
	public static final String SMS_SEND_METHOD_GSM = "gsm";
	/** ftp */
	public static final String SMS_SEND_METHOD_FTP = "ftp";
	/** tcp */
	public static final String SMS_SEND_METHOD_TCP = "tcp";
	/** udp */
	public static final String SMS_SEND_METHOD_UDP = "udp";
	/** db */
	public static final String SMS_SEND_METHOD_DB = "db";

	/** ORACCLE */
	public static final String SMS_SEND_DBTYPE_ORACLE = "oracle";
	/** DB2 */
	public static final String SMS_SEND_DBTYPE_DB2 = "db2";
	/** SQLSERVER */
	public static final String SMS_SEND_DBTYPE_SQLSERVER = "sqlserver";
	/** SYBASE */
	public static final String SMS_SEND_DBTYPE_SYBASE = "sybase";
	/** MYSQL */
	public static final String SMS_SEND_DBTYPE_MYSQL = "mysql";

	/** ORACCLE驱动 */
	public static final String SMS_DBDRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
	/** DB2驱动 */
	public static final String SMS_DBDRIVER_DB2 = "com.ibm.db2.jcc.DB2Driver";
	/** SQLSERVER驱动 */
	public static final String SMS_DBDRIVER_SQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	/** SYBASE驱动 */
	public static final String SMS_DBDRIVER_SYBASE = "com.sybase.jdbc4.jdbc.SybDriver";
	/** MYSQL驱动 */
	public static final String SMS_DBDRIVER_MYSQL = "com.mysql.jdbc.Driver";

	/** ORACCLE连接字符串 */
	public static final String CONNECTION_STR_ORACLE = "jdbc:oracle:thin:@{ip}:{port}:{sid}";
	/** DB2连接字符串 */
	public static final String CONNECTION_STR_DB2 = "jdbc:db2://{ip}:{port}/{sid}";
	/** SQLSERVER连接字符串 */
	public static final String CONNECTION_STR_SQLSERVER = "{ip}:{port};databaseName={sid}";
	/** SYBASE连接字符串 */
	public static final String CONNECTION_STR_SYBASE = "jdbc:sybase:Tds:{ip}:{port}/{sid}?charset={encoding}";
	/** MYSQL连接字符串 */
	public static final String CONNECTION_STR_MYSQL = "jdbc:mysql://{ip}:{port}/{sid}";

}
