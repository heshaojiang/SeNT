/**
 * 文件名：FtpSmsSender.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.notice.service.smssend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.grgbanking.platform.core.msgtemplate.MsgTemplate;
import com.grgbanking.platform.module.notice.NoticeConstants;
import com.grgbanking.platform.module.notice.vo.SmsVo;

/**
 * @author yrliang
 * 
 */
public class DBSmsSender extends AbstractSmsSender {
	private static boolean LOADED = false;

	public String replace(String str, Map<String, String> map) {
		String regex = "\\{[^}]+\\}";
		Matcher m1 = Pattern.compile(regex).matcher(str);
		List<String> variables = new ArrayList<String>();
		while (m1.find()) {
			variables.add(m1.group());
		}

		for (String key : variables) {
			str = str.replaceFirst(regex, map.get(key.substring(1, key.length() - 1)));
		}

		return str;
	}

	static {
		try {
			Class.forName(NoticeConstants.SMS_DBDRIVER_ORACLE);
		} catch(ClassNotFoundException ex) {
			logger.error("无法加载Oracle数据库的驱动程序", ex);
		}

		try {
			Class.forName(NoticeConstants.SMS_DBDRIVER_DB2);
		} catch(ClassNotFoundException ex) {
			logger.error("无法加载DB2数据库的驱动程序", ex);
		}

		try {
			Class.forName(NoticeConstants.SMS_DBDRIVER_SQLSERVER);
		} catch(ClassNotFoundException ex) {
			logger.error("无法加载SQLSERVER数据库的驱动程序", ex);
		}

		try {
			Class.forName(NoticeConstants.SMS_DBDRIVER_SYBASE);
		} catch(ClassNotFoundException ex) {
			logger.error("无法加载SYBASE数据库的驱动程序", ex);
		}

		try {
			Class.forName(NoticeConstants.SMS_DBDRIVER_MYSQL);
		} catch(ClassNotFoundException ex) {
			logger.error("无法加载MYSQL数据库的驱动程序", ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.grgbanking.platform.module.notice.service.interfaces.ISmsSender#sender
	 * ()
	 */
	public void sender(List<SmsVo> list) {

		Connection conn = null;
		Statement st = null;
		try {
			conn = DriverManager.getConnection(getUrl(), setting.getUser(), setting.getPassword());
			conn.setAutoCommit(false);
			String sql = setting.getSql();
			st = conn.createStatement();
			for(SmsVo sms : list) {
				try {
					//String content = new String(super.getContent(sms).getBytes(CHARSET_UNICODE), setting.getEncoding());
					//sms.setContent(super.getContent(sms));
					//String actualSql = MsgTemplate.phase(SmsVo.class, sms, sql);
					//actualSql = new String(super.getContent(sms).getBytes(CHARSET_UNICODE), setting.getEncoding());
					st.execute(MsgTemplate.phase(SmsVo.class, sms, sql));
					conn.commit();
					sms.setSucc(true);
				} catch(Exception ex) {
					conn.rollback();
					logger.error("Send sms error by db type!", ex);
				}
			}

			//			logger.info("Sending sms, sql=" + sql);
			//			st.execute(sql);

		} catch (SQLException ex) {
			logger.error("Send sms error by db type!", ex);
		} finally {
			try {
				if(st != null) {
					st.close();
				}
			} catch(SQLException e) {

			}

			try {
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {

			}
		}

	}

	public static void main(String[] args) {
		String sql = "insert into sms_test values('{mobile}', '{content}')";
		// sql.replace(":[?]+[\0,]", newChar)
		List<String> variables = new ArrayList<String>();
		String regex = "\\{[^}]+\\}";
		Matcher m1 = Pattern.compile(regex).matcher(sql);
		while (m1.find()) {
			variables.add(m1.group());
		}

		List<String> values = new ArrayList<String>();
		values.add("13712345678");
		values.add("haha!");

		for (int i = 0; i < variables.size(); i++) {
			sql = sql.replaceFirst(regex, values.get(i));

			// sql = sql.replaceFirst("\\{" + s.substring(1, s.length() - 1) +
			// "\\}", values.get(i));
		}

	}

	//	private void loadDriver() {
	//		String driverClassName = null;
	//		if (NoticeConstants.SMS_SEND_DBTYPE_ORACLE.equals(setting.getDbType())) {
	//			driverClassName = NoticeConstants.SMS_DBDRIVER_ORACLE;
	//			try {
	//				Class.forName(driverClassName);
	//			} catch(ClassNotFoundException ex) {
	//				logger.error("无法加载数据库的驱动程序", ex);
	//			}
	//		}
	//
	//		if (NoticeConstants.SMS_SEND_DBTYPE_DB2.equals(setting.getDbType())) {
	//			driverClassName = NoticeConstants.SMS_DBDRIVER_DB2;
	//			try {
	//				Class.forName(driverClassName);
	//			} catch(ClassNotFoundException ex) {
	//				logger.error("无法加载数据库的驱动程序", ex);
	//			}
	//		}
	//
	//		if (NoticeConstants.SMS_SEND_DBTYPE_SQLSERVER.equals(setting.getDbType())) {
	//			driverClassName = NoticeConstants.SMS_DBDRIVER_SQLSERVER;
	//			try {
	//				Class.forName(driverClassName);
	//			} catch(ClassNotFoundException ex) {
	//				logger.error("无法加载数据库的驱动程序", ex);
	//			}
	//		}
	//
	//		if (NoticeConstants.SMS_SEND_DBTYPE_SYBASE.equals(setting.getDbType())) {
	//			driverClassName = NoticeConstants.SMS_DBDRIVER_SYBASE;
	//			try {
	//				Class.forName(driverClassName);
	//			} catch(ClassNotFoundException ex) {
	//				logger.error("无法加载数据库的驱动程序", ex);
	//			}
	//		}
	//
	//		if (NoticeConstants.SMS_SEND_DBTYPE_SYBASE.equals(setting.getDbType())) {
	//			driverClassName = NoticeConstants.SMS_DBDRIVER_MYSQL;
	//			try {
	//				Class.forName(driverClassName);
	//			} catch(ClassNotFoundException ex) {
	//				logger.error("无法加载数据库的驱动程序", ex);
	//			}
	//		}
	//	}

	private String getUrl() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ip", setting.getServerIP());
		map.put("port", setting.getServerPort());
		map.put("sid", setting.getDbSid());
		map.put("encoding", setting.getEncoding());

		if (NoticeConstants.SMS_SEND_DBTYPE_ORACLE.equals(setting.getDbType()))
			return replace(NoticeConstants.CONNECTION_STR_ORACLE, map);

		if (NoticeConstants.SMS_SEND_DBTYPE_DB2.equals(setting.getDbType()))
			return replace(NoticeConstants.CONNECTION_STR_DB2, map);

		if (NoticeConstants.SMS_SEND_DBTYPE_SQLSERVER.equals(setting.getDbType()))
			return replace(NoticeConstants.CONNECTION_STR_SQLSERVER, map);

		if (NoticeConstants.SMS_SEND_DBTYPE_SYBASE.equals(setting.getDbType()))
			return replace(NoticeConstants.CONNECTION_STR_SYBASE, map);

		if(NoticeConstants.SMS_SEND_DBTYPE_MYSQL.equals(setting.getDbType()))
			return replace(NoticeConstants.CONNECTION_STR_MYSQL, map);

		return null;
	}
}
