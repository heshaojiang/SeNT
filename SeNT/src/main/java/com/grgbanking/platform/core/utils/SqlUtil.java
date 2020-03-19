package com.grgbanking.platform.core.utils;

public class SqlUtil {

	public static String databaseType = PropertiesUtils.queryDatabaseType();

	/**
	 * 不同数据库类型的字符串连接实现
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public String sqlStrConcat(String str1, String str2) {
		if ("oracle".equals(databaseType))
			return "concat(" + str1 + ",'" + str2 + "')";
		else if ("sybase".equals(databaseType))
			return str1 + " || '" + str2 + "'";
		else if ("mysql".equals(databaseType))
			return "concat(" + str1 + ",'" + str2 + "')";
		else if ("db2".equals(databaseType))
			return str1 + " || '" + str2 + "'";
		else if ("sqlserver".equals(databaseType))
			return "convert(varchar," + str1 + ") + convert(varchar,'" + str2 + "')";
		else if ("informix".equals(databaseType))
			return str1 + " || '" + str2 + "'";
		else
			return "";
	}

	/**
	 * 不同数据库类型的to_date实现
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String sqlStrToDate(String str1, String str2) {
		if ("oracle".equals(databaseType))
			return "to_date('" + str1 + "','" + str2 + "')";
		else if ("sybase".equals(databaseType))
			return "'" + str1 + "'";
		else if ("mysql".equals(databaseType))
			return "DATE_FORMAT('"
					+ str1
					+ "','"
					+ str2.replace("yyyy", "%Y").replace("yy", "%Y").replace("MM", "%m").replace("mm", "%m")
						.replace("dd", "%d").replace("HH24", "%H").replace("hh24", "%H").replace("mi", "%i")
							.replace("ss", "%s") + "')";
		else if ("db2".equals(databaseType))
			return "to_date('" + str1 + "','" + str2 + "')";
		else if ("sqlserver".equals(databaseType))
			return "CONVERT(datetime,'" + str1 + "',120)";
		else if ("informix".equals(databaseType))
			return "to_date('"
					+ str1
					+ "','"
					+ str2.replace("yyyy", "%Y").replace("yy", "%Y").replace("mm", "%m").replace("dd", "%d").replace(
							"hh24", "%H").replace("mi", "%M").replace("ss", "%S") + "')";
		else
			return "";
	}

	public static void main(String[] args) {
		
		String afterTime = SqlUtil.sqlStrToDate("2014-07-14", "yyyy-MM-dd");
		System.out.println(afterTime);
	}
}
