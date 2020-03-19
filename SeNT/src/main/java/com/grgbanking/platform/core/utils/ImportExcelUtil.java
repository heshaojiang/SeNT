/**
 * 文件名：ImportExcelUtil.java
 * 创建日期： 2012-6-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yrliang
 * 
 */
public class ImportExcelUtil {
	private static Logger logger = LoggerFactory.getLogger(FTPClientTemplate.class);

	/**
	 * 从excel动态导入数据，本工具类只读取原始数据，导入后的处理由调用者再编码处理
	 * 
	 * @param <T>
	 *            泛型参数对象
	 * @param wb
	 *            workbook
	 * @param sheetNo
	 *            sheetno
	 * @param clazz
	 *            类名
	 * @throws Exception
	 *             异常
	 * @return 导出列表
	 */
	public static <T> List<T> importExcel(HSSFWorkbook wb, int sheetNo, Class<T> clazz) throws Exception
	{
		List<T> list = new ArrayList<T>();
		//
		HSSFSheet sheet = wb.getSheetAt(0);
		// 读取首行
		HSSFRow firstRow = sheet.getRow(0);
		HSSFRow titleRow = sheet.getRow(0);

		short cols = firstRow.getLastCellNum();
		// 保存set方法名
		String[] fields = new String[cols];
		String[] titles = new String[cols];

		HSSFCell cell = null;
		String value = null;
		for( short i = 0 ; i < cols ; i++ )
		{
			cell = firstRow.getCell(i);
			value = cell.getStringCellValue();
			fields[i] = "set" + value.substring(0, 1).toUpperCase() + value.substring(1);

			cell = titleRow.getCell(i);
			titles[i] = cell.getStringCellValue();
		}

		//
		Method[] classMethods = clazz.getMethods();
		Method[] methods = new Method[cols];
		// 保存对应set方法的输入类型
		Class[] paramTypes = new Class[cols];
		// 保存对应列的日期格式
		String[] formats = new String[cols];
		// 从类中读取对应方法和输入参数
		for( short i = 0 ; i < cols ; i++ )
		{
			boolean isFound = false;
			for( int j = 0 ; j < classMethods.length ; j++ )
			{
				if( classMethods[j].getName().equals(fields[i]) )
				{
					methods[i] = classMethods[j];
					paramTypes[i] = methods[i].getParameterTypes()[0];
					isFound = true;
					break;
				}
			}
			if( isFound == false )
				throw new Exception("column: '" + titles[i] + "' is not existed in obejct");
		}

		//如将有内容的一行excel清空，此方法也会计算空行，导致生成的对象各个属性都为null，从而导入报错。所以需要判断是否是空行
		int rows = sheet.getPhysicalNumberOfRows();

		for( int i = 2 ; i < rows ; i++ )
		{
			boolean blankRow = true; //用于判断所读取行的内容是否全空
			
			firstRow = sheet.getRow(i);
			T obj = clazz.newInstance();
			for( short j = 0 ; j < cols ; j++ )
			{
				cell = firstRow.getCell(j);
				if( cell != null )
				{
					switch (cell.getCellType())
					{
					case HSSFCell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_NUMERIC:
						if( HSSFDateUtil.isCellDateFormatted(cell) )
						{
							Date date = cell.getDateCellValue();
							String format = cell.getCellStyle().getDataFormatString();
							format = format.replace("hh", "HH");
							formats[j] = format;
							DateFormat df = new SimpleDateFormat(format);
							value = df.format(date);
							break;
						}

						if( paramTypes[j] != Float.class && paramTypes[j] != Double.class )
						{
							DecimalFormat df = new DecimalFormat("0");
							value = df.format(cell.getNumericCellValue());
						}
						else
						{
							value = String.valueOf(cell.getNumericCellValue());
						}
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						value = String.valueOf(cell.getBooleanCellValue());
						break;
					default:
						value = "";
					}

					value = value.trim();
					if(value != "") //有一列内容不为空，此行就不属于空行
						blankRow = false;
					
					setValue(methods[j], paramTypes[j], obj, value, formats[j]);
				}
			}
			if(!blankRow)
				list.add(obj);
		}
		return list;
	}

	private static void setValue(Method method, Class paramType, Object obj, String value, String dateFormat) throws Exception
	{
		if( value.length() > 0 )
		{
			if( paramType.isPrimitive() )
			{
				if( paramType.getName().equals("int") )
				{
					BigDecimal bd = new BigDecimal(value);
					method.invoke(obj, bd.intValue());
				}
				else if( paramType.getName().equals("long") )
				{
					BigDecimal bd = new BigDecimal(value);
					method.invoke(obj, bd.longValue());
				}
				else if( paramType.getName().equals("byte") )
				{
					method.invoke(obj, value.getBytes()[0]);
				}
				else if( paramType.getName().equals("char") )
				{
					method.invoke(obj, value.charAt(0));
				}
				else if( paramType.getName().equals("short") )
				{
					BigDecimal bd = new BigDecimal(value);
					method.invoke(obj, bd.shortValue());
				}
				else if( paramType.getName().equals("float") )
				{
					method.invoke(obj, Float.valueOf(value).floatValue());
				}
				else if( paramType.getName().equals("double") )
				{
					method.invoke(obj, Double.valueOf(value).doubleValue());
				}
			}
			else
			{
				if( paramType.equals(String.class) )
				{
					method.invoke(obj, value);
				}
				else if( paramType.equals(Integer.class) )
				{
					method.invoke(obj, Integer.valueOf(value));
				}
				else if( paramType.equals(Long.class) )
				{
					BigDecimal bd = new BigDecimal(value);
					method.invoke(obj, Long.valueOf(bd.longValue()));
				}
				else if( paramType.equals(Byte.class) )
				{
					method.invoke(obj, Byte.valueOf(value));
				}
				else if( paramType.equals(Short.class) )
				{
					method.invoke(obj, Short.valueOf(value));
				}
				else if( paramType.equals(Float.class) )
				{
					method.invoke(obj, Float.valueOf(value));
				}
				else if( paramType.equals(Double.class) )
				{
					method.invoke(obj, Double.valueOf(value));
				}
				else if( paramType.equals(BigDecimal.class) )
				{
					method.invoke(obj, new BigDecimal(value));
				}
				else if( paramType.equals(Date.class) )
				{
					DateFormat df = new SimpleDateFormat(dateFormat);
					method.invoke(obj, df.parse(value));
				}
				else if( paramType.isArray() )
				{
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		class MyObject {
			public String name;
			public String sex;
			public int age;
			public BigDecimal salary;
			public String addr;
			public Long zip;

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getSex() {
				return sex;
			}

			public void setSex(String sex) {
				this.sex = sex;
			}

			public int getAge() {
				return age;
			}

			public void setAge(int age) {
				this.age = age;
			}

			public BigDecimal getSalary() {
				return salary;
			}

			public void setSalary(BigDecimal salary) {
				this.salary = salary;
			}

			public String getAddr() {
				return addr;
			}

			public void setAddr(String addr) {
				this.addr = addr;
			}

			public Long getZip() {
				return zip;
			}

			public void setZip(Long zip) {
				this.zip = zip;
			}

		}

		File file = new File("C:\\Users\\SONY\\Desktop\\导入excel\\a.xls");
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		List<MyObject> list = importExcel(wb, 0, MyObject.class);
		for(Object obj : list) {
			logger.warn(obj.toString());
		}
	}

}
