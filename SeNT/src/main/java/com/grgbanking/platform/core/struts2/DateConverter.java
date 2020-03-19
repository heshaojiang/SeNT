/**
 * 文件名：DateConverter.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.struts2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 日期格式转换器
 * 
 * @author yrliang
 * 
 */
public class DateConverter extends StrutsTypeConverter {

	private static String DATE_TIME_FOMART_IE = "yyyy-MM-dd HH:mm:ss";

	private static String DATE_TIME_FOMART_FF = "yy/MM/dd hh:mm:ss";

	/**
	 * 重写父类方法
	 * 
	 * @param context
	 *            context
	 * @param values
	 *            值
	 * @param toClass
	 *            Calss
	 * @return Object
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {

		Date date = null;

		String dateString = null;

		if (values != null && values.length > 0) {

			dateString = values[0];

			if (dateString != null) {

				// 匹配IE浏览器

				SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FOMART_IE);

				try {

					date = format.parse(dateString);

				} catch (ParseException e) {

					date = null;

				}

				// 匹配Firefox浏览器

				if (date == null) {

					format = new SimpleDateFormat(DATE_TIME_FOMART_FF);

					try {

						date = format.parse(dateString);

					} catch (ParseException e) {

						date = null;

					}

				}

			}

		}

		return date;

	}

	/**
	 * 重写父类方法
	 * 
	 * @param context
	 *            上下文
	 * @param o
	 *            object
	 * @return String
	 */
	@Override
	public String convertToString(Map context, Object o) {

		// 格式化为date格式的字符串

		Date date = (Date) o;

		SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_FOMART_IE);
		String dateTimeString = format.format(date);

		return dateTimeString;

	}

}
