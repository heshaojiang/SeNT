/**
 * 文件名：SqlHelper.java
 * 创建日期： 2012-6-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.util.List;

import com.grgbanking.platform.core.dao.DBDialectHelper;

/**
 * 根据参数组织要执行的sql语句
 * 
 * @author SONY
 */
public class SqlHelper {
	/**
	 * 
	 * sql中in(可以包含的最大字段取值个数
	 */
	private static final int MAX_IN_NUMBERS = 255;

	// ------------------------------------------------------------------------------
	/**
	 * 根据字符型字段值组织sql的in条件语句
	 * 
	 * @param fieldName
	 *            字段名
	 * @param values
	 *            字段条件取值
	 * @return sql语句
	 */
	public static final String fitStrInCondition(String fieldName, String[] values)
	{
		StringBuffer sbf = new StringBuffer();
		if( values == null || values.length == 0 )
		{
			sbf.append(fieldName).append(" in ('')");
			return "(" + sbf.toString() + ")";
		}
		int row = values.length / MAX_IN_NUMBERS;
		int remain = values.length % MAX_IN_NUMBERS;
		int index = 0;
		for( int i = 1 ; i <= row ; i++ )
		{
			sbf.append(fieldName).append(" in(");
			for( int j = 1 ; j < MAX_IN_NUMBERS ; j++ )
			{
				sbf.append("'").append(values[index++].trim()).append("',");
			}
			sbf.append("'").append(values[index++].trim()).append("')");
			if( row > 1 && i < row )
			{
				sbf.append(" or ");
			}
		}
		if( remain > 0 )
		{
			if( row > 0 )
			{
				sbf.append(" or ");
			}
			sbf.append(fieldName).append(" in(");
			for( int i = 1 ; i < remain ; i++ )
			{
				sbf.append("'").append(values[index++].trim()).append("',");
			}
			sbf.append("'").append(values[index++].trim()).append("')");
		}
		if( values.length < MAX_IN_NUMBERS )
		{
			return sbf.toString();
		}
		return "(" + sbf.toString() + ")";
	}

	// ------------------------------------------------------------------------------
	/**
	 * 根据数字型字段值组织sql的in条件语句
	 * 
	 * @param fieldName
	 *            字段名
	 * @param values
	 *            字段条件取值,字符串形式的数字
	 * @return sql语句
	 */
	public static final String fitNumInCondition(String fieldName, String[] values) {
		StringBuffer sbf = new StringBuffer();
		if (values == null || values.length == 0) {
			sbf.append(fieldName).append(" in ('')");
			return "(" + sbf.toString() + ")";
		}
		int row = values.length / MAX_IN_NUMBERS;
		int remain = values.length % MAX_IN_NUMBERS;
		int index = 0;
		for (int i = 1; i <= row; i++) {
			sbf.append(fieldName).append(" in(");
			for (int j = 1; j < MAX_IN_NUMBERS; j++) {
				sbf.append(values[index++]).append(",");
			}
			sbf.append(values[index++]).append(")");
			if (row > 1 && i < row) {
				sbf.append(" or ");
			}
		}
		if (remain > 0) {
			if (row > 0) {
				sbf.append(" or ");
			}
			sbf.append(fieldName).append(" in(");
			for (int i = 1; i < remain; i++) {
				sbf.append(values[index++]).append(",");
			}
			sbf.append(values[index++]).append(")");
		}
		if (values.length < MAX_IN_NUMBERS) {
			return sbf.toString();
		}
		return "(" + sbf.toString() + ")";
	}

	// ------------------------------------------------------------------------------
	/**
	 * 于组装PreparedStatement的in
	 * 
	 * @param fieldName
	 *            field Name
	 * @param values
	 *            values
	 * @param parameters
	 *            parameters
	 * @return sql String
	 */
	public static final String fitInCondition(String fieldName, Object[] values, List parameters) {
		StringBuffer sbf = new StringBuffer();
		if (values == null || values.length == 0) {
			sbf.append(fieldName).append(" in ('')");
			return "(" + sbf.toString() + ")";
		}
		int row = values.length / MAX_IN_NUMBERS;
		int remain = values.length % MAX_IN_NUMBERS;
		int index = 0;
		for (int i = 1; i <= row; i++) {
			sbf.append(fieldName).append(" in(");
			for (int j = 1; j < MAX_IN_NUMBERS; j++) {
				sbf.append("?,");
				parameters.add(values[index++]);
			}
			parameters.add(values[index++]);
			sbf.append("?)");

			if (row > 1 && i < row) {
				sbf.append(" or ");
			}
		}
		if (remain > 0) {
			if (row > 0) {
				sbf.append(" or ");
			}
			sbf.append(fieldName).append(" in(");
			for (int i = 1; i < remain; i++) {
				sbf.append("?,");
				parameters.add(values[index++]);
			}
			parameters.add(values[index++]);
			sbf.append("?)");
		}
		if (values.length < MAX_IN_NUMBERS) {
			return sbf.toString();
		}
		return "(" + sbf.toString() + ")";
	}

	// ------------------------------------------------------------------------------

	public static final String fitStrInCondition(String fieldName, List<String> values) {
		StringBuffer sbf = new StringBuffer();
		if (values == null || values.size() == 0) {
			sbf.append(fieldName).append(" in ('')");
			return "(" + sbf.toString() + ")";
		}
		int row = values.size() / MAX_IN_NUMBERS;
		int remain = values.size() % MAX_IN_NUMBERS;
		int index = 0;
		for (int i = 1; i <= row; i++) {
			sbf.append(fieldName).append(" in(");
			for (int j = 1; j < MAX_IN_NUMBERS; j++) {
				sbf.append("'").append(values.get(index++)).append("',");
			}
			sbf.append("'").append(values.get(index++)).append("')");
			if (row > 1 && i < row) {
				sbf.append(" or ");
			}
		}
		if (remain > 0) {
			if (row > 0) {
				sbf.append(" or ");
			}
			sbf.append(fieldName).append(" in(");
			for (int i = 1; i < remain; i++) {
				sbf.append("'").append(values.get(index++)).append("',");
			}
			sbf.append("'").append(values.get(index++)).append("')");
		}
		if (values.size() < MAX_IN_NUMBERS) {
			return sbf.toString();
		}
		return "(" + sbf.toString() + ")";
	}


//	public static String limitCondition(int rows)
//	{
//		if( DBDialectHelper.isMySql() )
//		{
//			return " limit "+rows;
//		}
//		else
//		{
//			return "";
//		}
//	}
	
	public static String limitRows(String sql, int rows)
	{
		if( DBDialectHelper.isOracle() )
		{
			return "select * from ( "+sql+" ) where rownum <= "+rows;
		}
		else
		{
			return sql + " limit "+rows;
		}
	}
}
