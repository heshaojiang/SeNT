/**
 * 文件名：ReportConditionDao.java
 * 创建日期： 2012-5-28
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.datareport.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.grgbanking.platform.core.dao.BaseDao;
import com.grgbanking.platform.core.dao.DBDialectHelper;
import com.grgbanking.platform.core.dao.Page;

import flex.messaging.FlexContext;

/**
 * @author yrliang
 * 
 */
@Repository
public class DataReportInfoDao extends BaseDao<Object> {
	
	private final String SQL_REPLACE_STR_STARTTIME = "'starttime'";
	private final String SQL_REPLACE_STR_ENDTIME = "'endtime'";
	private final String SQL_REPLACE_STR_PATHCODE = "'pathcode'";

	@SuppressWarnings("unchecked")
	public Map<String, List<?>> queryDataReport(Map condition) {
		
		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");
		String pathCode = (String) condition.get("pathCode");
		String module = (String) condition.get("module");
		
		
		// startTime
		if( StringUtils.isBlank(startTime) )
		{
			throw new IllegalArgumentException("startTime cannot be null.");
		}
		startTime = startTime.replace("-", "")+"000000";
		
		// endTime
		if( StringUtils.isBlank(endTime) )
		{
			throw new IllegalArgumentException("endTime cannot be null.");
		}
		endTime = endTime.replace("-", "")+"240000";

		Session session = this.getSessionFactory().openSession();
		Connection cnn = session.connection();
		ResultSet rs = null;
		Map<String, List<?>> rsMap = new HashMap<String, List<?>>();
		rsMap.put("colunmsNames", null);
		rsMap.put("dataList", null);
		// 动态列
		List<String> colunmsNames = new ArrayList<String>();
		// 显示名称
		List<String> displayNames = new ArrayList<String>();

		List<Map> records = new ArrayList<Map>();

		try {
			String queryStr = getQueryStrByModule(module);
			queryStr = queryStr.replaceAll(SQL_REPLACE_STR_STARTTIME, "'"+startTime+"'").replaceAll(SQL_REPLACE_STR_ENDTIME, "'"+endTime+"'").replaceAll(SQL_REPLACE_STR_PATHCODE, "'"+pathCode+"'");
			System.out.println(queryStr);
			Statement stmt = cnn.createStatement();
			rs = stmt.executeQuery(queryStr);
			

			ResultSetMetaData metaData = rs.getMetaData();
		
			for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
				colunmsNames.add(metaData.getColumnName(i).toString());
				displayNames.add(metaData.getColumnLabel(i).toString());
			}
			rsMap.put("colunmsNames", displayNames);
			
			int fieldCount = metaData.getColumnCount();
			while (rs.next()) {
				Map valueMap = new LinkedHashMap();
				for (int i = 1; i <= fieldCount; i++) {
					String fieldClassName = metaData.getColumnClassName(i);
					String fieldName = metaData.getColumnLabel(i);
					this._recordMappingToMap(fieldClassName, fieldName, rs,
							valueMap);
				}
				records.add(valueMap);
			}

			List<Object> listEntity = new ArrayList<Object>();
			// 动态数据
			List<String> colunmsNamesArr = (List<String>) rsMap
					.get("colunmsNames");
			for (int i = 0; i < records.size(); i++) {
				Map sourceData = records.get(i);
				Map<String, String> map = new HashMap<String, String>();
				for (int j = 0; j < colunmsNamesArr.size(); j++) {
					map
							.put(colunmsNamesArr.get(j),
									sourceData.get(colunmsNamesArr.get(j)
											.toLowerCase()) == null ? ""
											: sourceData.get(
													colunmsNamesArr.get(j)
															.toLowerCase())
													.toString());
				}
				listEntity.add(map);
			}
			rs.close();
			rsMap.put("dataList", listEntity);
			session.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("", e);
			try {
				cnn.rollback();
				cnn.close();
				session.close();
			} catch (SQLException ee) {
				logger.error("", ee);
			}

		}
		return rsMap;

	}
	
	public String exportDataReport(Map condition) {
		//HttpServletResponse res = FlexContext.getHttpResponse();
		HttpServletRequest req = FlexContext.getHttpRequest();
		HSSFWorkbook hssf = new HSSFWorkbook();
		String filename = "DataReport.xls";
		FileOutputStream fileOut = null;
		
		
		String startTime = (String) condition.get("startTime");
		String endTime = (String) condition.get("endTime");
		String pathCode = (String) condition.get("orgId");
		String module = (String) condition.get("module");
		
		
		// startTime
		if( StringUtils.isBlank(startTime) )
		{
			throw new IllegalArgumentException("startTime cannot be null.");
		}
		startTime = startTime.replace("-", "")+"000000";
		
		// endTime
		if( StringUtils.isBlank(endTime) )
		{
			throw new IllegalArgumentException("endTime cannot be null.");
		}
		endTime = endTime.replace("-", "")+"240000";

		Session session = this.getSessionFactory().openSession();
		Connection cnn = session.connection();
		ResultSet rs = null;
		Map<String, List<?>> rsMap = new HashMap<String, List<?>>();
		rsMap.put("colunmsNames", null);
		rsMap.put("dataList", null);
		// 动态列
		List<String> colunmsNames = new ArrayList<String>();
		// 显示名称
		List<String> displayNames = new ArrayList<String>();

		List<Map> records = new ArrayList<Map>();
		
		try {
			
			HSSFSheet sheet = hssf.createSheet();
			int rowNum = 0;
			
			String queryStr = getQueryStrByModule(module);
			queryStr = queryStr.replaceAll(SQL_REPLACE_STR_STARTTIME, "'"+startTime+"'").replaceAll(SQL_REPLACE_STR_ENDTIME, "'"+endTime+"'").replaceAll(SQL_REPLACE_STR_PATHCODE, "'"+pathCode+"'");
			System.out.println(queryStr);
			Statement stmt = cnn.createStatement();
			rs = stmt.executeQuery(queryStr);
			

			ResultSetMetaData metaData = rs.getMetaData();
			
			HSSFRow row = sheet.createRow(rowNum);
			rowNum++;
			for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
				HSSFCell cell = row.createCell(i-1);
				cell.setCellValue(metaData.getColumnLabel(i).toString());
			}
			
			int fieldCount = metaData.getColumnCount();
			while (rs.next()) {
				HSSFRow row2 = sheet.createRow(rowNum);
				
				for (int i = 1; i <= fieldCount; i++) {
					HSSFCell cell = row2.createCell(i-1);
					String fieldClassName = metaData.getColumnClassName(i);
					String fieldName = metaData.getColumnLabel(i);
					cell.setCellValue(rs.getString(fieldName));
				}
				rowNum++;
			}
			
		
			String filePath = req.getSession().getServletContext().getRealPath("/")+File.separator+"exportFile"+File.separator+filename;
			fileOut = new FileOutputStream(filePath);
			hssf.write(fileOut);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				fileOut.close();
				fileOut.flush();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		//System.out.println("filename:"+filename);
		return filename;
		
	}

	/**
	 * 将ResultSet结果集中的记录映射到Map对象中.
	 * 
	 * @param fieldClassName
	 *            是JDBC API中的类型名称,
	 * @param fieldName
	 *            是字段名，
	 * @param rs
	 *            是一个ResultSet查询结果集,
	 * @param fieldValue
	 *            Map对象,用于存贮一条记录.
	 * @throws SQLException
	 */
	private void _recordMappingToMap(String fieldClassName, String fieldName,
			ResultSet rs, Map fieldValue) throws SQLException {
		fieldName = fieldName.toLowerCase();

		// 优先规则：常用类型靠前

		if (fieldClassName.equals("java.lang.String")) {
			String s = rs.getString(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.lang.Integer")) {
			int s = rs.getInt(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);// 早期jdk需要包装，jdk1.5后不需要包装
			}
		} else if (fieldClassName.equals("java.lang.Long")) {
			long s = rs.getLong(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.lang.Boolean")) {
			boolean s = rs.getBoolean(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.lang.Short")) {
			short s = rs.getShort(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.lang.Float")) {
			float s = rs.getFloat(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.lang.Double")) {
			double s = rs.getDouble(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.sql.Timestamp")) {
			java.sql.Timestamp s = rs.getTimestamp(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.sql.Date")
				|| fieldClassName.equals("java.util.Date")) {
			java.util.Date s = rs.getDate(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.sql.Time")) {
			java.sql.Time s = rs.getTime(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.lang.Byte")) {
			byte s = rs.getByte(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, new Byte(s));
			}
		} else if (fieldClassName.equals("[B")
				|| fieldClassName.equals("byte[]")) {
			// byte[]出现在SQL Server中
			byte[] s = rs.getBytes(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.math.BigDecimal")) {
			BigDecimal s = rs.getBigDecimal(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.lang.Object")
				|| fieldClassName.equals("oracle.sql.STRUCT")) {
			Object s = rs.getObject(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.sql.Array")
				|| fieldClassName.equals("oracle.sql.ARRAY")) {
			java.sql.Array s = rs.getArray(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.sql.Clob")) {
			java.sql.Clob s = rs.getClob(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else if (fieldClassName.equals("java.sql.Blob")) {
			java.sql.Blob s = rs.getBlob(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		} else {// 对于其它任何未知类型的处理
			Object s = rs.getObject(fieldName);
			if (rs.wasNull()) {
				fieldValue.put(fieldName, null);
			} else {
				fieldValue.put(fieldName, s);
			}
		}
	}

	public String getQueryStrByModule(String module) {
		Session session = this.getSessionFactory().openSession();
		Connection cnn = session.connection();
		String queryStr = "";
		ResultSet rs = null;
		String database = "oracle";

		if (DBDialectHelper.isMySql()) {
			database = "mysql";
		}
		try {
			String getNoteflowAmtSql = "select dr.c_querystr from data_report dr where dr.c_report_module='"
					+ module
					+ "' and dr.c_database='"
					+ database
					+ "' and dr.c_status=1 and dr.c_type=1";
			Statement stmt = cnn.createStatement();
			rs = stmt.executeQuery(getNoteflowAmtSql);

			while (rs.next()) {
				queryStr = rs.getString(1);

			}
			if (!cnn.getAutoCommit()) {
				cnn.commit();
			}
		} catch (SQLException e) {
			logger.error("", e);
			try {
				cnn.rollback();
				cnn.close();
				session.close();
			} catch (SQLException ee) {
				logger.error("", ee);
			}

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (cnn != null) {
				try {
					cnn.close();
				} catch (SQLException e) {
				}
			}
			if (session != null) {
				session.close();

			}
		}
		return queryStr;
	}

}
