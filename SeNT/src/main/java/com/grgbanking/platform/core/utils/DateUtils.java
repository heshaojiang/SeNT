/**
 * 文件名：DateUtils.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期处理类
 * 
 * @author SONY
 */

public class DateUtils {
	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory
			.getLogger(BeanCommonUtils.class);

	// ------------------------------------------------------------------------------
	/**
	 * 检查日期是否满足"yyyy-MM-dd"的格式，且toDate不小于fromDate
	 * 
	 * @param fromDate
	 *            开始日期
	 * @param toDate
	 *            结束日期
	 * @param dates
	 *            用于返回处理后的开始，结束日期
	 * @return 日期格式正确，返回true，否则false
	 */
	public static boolean isValidDates(String fromDate, String toDate,
			String[] dates) {
		if (fromDate == null || fromDate.trim().length() == 0)
			return false;
		if (toDate == null || toDate.trim().length() == 0)
			return false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date begin = null;
		Date end = null;

		try {
			begin = format.parse(fromDate);
			end = format.parse(toDate);
			if (begin.after(end))
				return false;
			dates[0] = format.format(begin);
			dates[1] = format.format(end);
		} catch (ParseException e) {
			// 验证出现何种异常 都返回false
			return false;
		}
		return true;
	}

	// ------------------------------------------------------------------------------
	public static String getTimeString(Timestamp tsp) {
		if (tsp == null)
			return "";
		return getTimeString(new Date(tsp.getTime()));
	}

	// ------------------------------------------------------------------------------
	public static String getTimeString(java.util.Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date).trim();
	}

	/*
	 * public static String getTimeString(java.sql.Date date) { SimpleDateFormat
	 * formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); return
	 * formatter.format(date).trim(); }
	 */
	// ------------------------------------------------------------------------------
	public static String getDateString(java.util.Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date).trim();
	}

	/*
	 * public static String getDateString(java.sql.Date date) { SimpleDateFormat
	 * formatter = new SimpleDateFormat("yyyy-MM-dd"); return
	 * formatter.format(date).trim(); }
	 */
	// ------------------------------------------------------------------------------
	public static String toChar(Timestamp tsp, String format) {
		if (tsp == null)
			return "";
		return toChar(new Date(tsp.getTime()), format);
	}

	// ------------------------------------------------------------------------------
	public static String toChar(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date).trim();
	}

	/*
	 * public static String to_char(java.sql.Date date, String format) {
	 * SimpleDateFormat formatter = new SimpleDateFormat(format); return
	 * formatter.format(date).trim(); }
	 */
	// ------------------------------------------------------------------------------
	public static Timestamp toTimestamp(String date) {
		return new Timestamp(toDate(date).getTime());
	}

	// ------------------------------------------------------------------------------
	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static Date stringToDate(String dateText, String format) {
		if (dateText == null)
			return null;
		DateFormat df = null;
		try {
			if (format == null) {
				df = new SimpleDateFormat();
			} else {
				df = new SimpleDateFormat(format);
			}

			// setLenient avoids allowing dates like 9/32/2001
			// which would otherwise parse to 10/2/2001
			df.setLenient(false);
			return df.parse(dateText);
		} catch (ParseException e) {
			return null;
		}
	}

	// ------------------------------------------------------------------------------
	public static Date toDate(String date) {
		Calendar cd = Calendar.getInstance();
		StringTokenizer token = new StringTokenizer(date, "-/ :");
		if (token.hasMoreTokens()) {
			cd.set(Calendar.YEAR, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.YEAR, 1970);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.MONTH, Integer.parseInt(token.nextToken()) - 1);
		} else {
			cd.set(Calendar.MONTH, 0);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.DAY_OF_MONTH, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.DAY_OF_MONTH, 1);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.HOUR_OF_DAY, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.HOUR_OF_DAY, 0);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.MINUTE, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.MINUTE, 0);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.SECOND, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.SECOND, 0);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.MILLISECOND, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.MILLISECOND, 0);
		}
		return cd.getTime();
	}

	// ------------------------------------------------------------------------------
	/**
	 * 返回本周，本月，本年时间范围的开始，结束日期，日期格式：yyyy-MM-dd
	 * 
	 * @param selType
	 *            1:本周 2：本月 3：本年
	 * @return 开始，结束日期字符数组
	 */
	public static final String[] getDateRange(int selType) {
		String startDate = null;
		String endDate = null;

		Calendar cd = Calendar.getInstance();
		int year = cd.get(Calendar.YEAR);
		int month = cd.get(Calendar.MONTH) + 1;
		Calendar cdTmp = Calendar.getInstance();
		int i;
		switch (selType) {
		case 1: // 本周
			i = cd.get(Calendar.DAY_OF_WEEK) - 1;
			cdTmp.setTime(new Date(cd.getTime().getTime() - i * 3600 * 24
					* 1000));
			startDate = cdTmp.get(Calendar.YEAR) + "-"
					+ (cdTmp.get(Calendar.MONTH) + 1) + "-"
					+ cdTmp.get(Calendar.DAY_OF_MONTH);
			i = 7 - cd.get(Calendar.DAY_OF_WEEK);
			cdTmp.setTime(new Date(cd.getTime().getTime() + i * 3600 * 24
					* 1000));
			endDate = cdTmp.get(Calendar.YEAR) + "-"
					+ (cdTmp.get(Calendar.MONTH) + 1) + "-"
					+ cdTmp.get(Calendar.DAY_OF_MONTH);
			break;
		case 2: // 本月
			startDate = year + "-" + month + "-01";
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				endDate = year + "-" + month + "-31";
				break;
			case 2:
				if (isLeapYear(year)) {
					endDate = year + "-" + month + "-29";
				} else {
					endDate = year + "-" + month + "-28";
				}
				break;
			default:
				endDate = year + "-" + month + "-30";
			}
			break;
		case 3: // 本年
			startDate = year + "-01-01";
			endDate = year + "-12-31";
			break;
		default:
			startDate = "2000-01-01";
			endDate = "2100-01-01";
		} // switch
		return new String[] { startDate, endDate };
	}

	// ------------------------------------------------------------------------------
	/**
	 * 判断是否闰年
	 * 
	 * @param y
	 *            年份
	 * @return true or false
	 */
	public static final boolean isLeapYear(int y) {
		if (y % 4 == 0) {
			if (y % 100 == 0) {
				if (y % 400 == 0)
					return true;
				else
					return false;
			} else
				return true;
		} // if
		return false;
	}

	// ------------------------------------------------------------------------------

	public static Date dateIncreaseByHour(Date date, int hours) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours);

		return cal.getTime();
	}

	/**
	 * 日期增加-按日增加
	 * 
	 * @param date
	 *            Date
	 * @param days
	 *            int
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByDay(Date date, int days) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	/**
	 * 日期增加-按月增加
	 * 
	 * @param date
	 *            Date
	 * @param mnt
	 *            month
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByMonth(Date date, int mnt) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.MONTH, mnt);

		return cal.getTime();
	}

	/**
	 * 日期增加-按年增加
	 * 
	 * @param date
	 *            Date
	 * @param mnt
	 *            Month
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByYear(Date date, int mnt) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.YEAR, mnt);

		return cal.getTime();
	}

	/**
	 * 获取本周的第一天(周日)
	 * 
	 * @param early
	 *            Date
	 * @return java.util.Date
	 */
	public static final Date getThisweekFirst(Date early) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(early);
		int week = c1.get(Calendar.DAY_OF_WEEK);
		int firstw = (-1) * (week - 1);
		Date weekFirst = dateIncreaseByDay(early, firstw);
		return weekFirst;
	}

	/**
	 * 按星期增加,获取该周的第一天(周日)
	 * 
	 * @param early
	 *            Date
	 * @param weeks
	 *            星期
	 * @return java.util.Date
	 */
	public static final Date firstdateIncreaseByWeek(Date early, int weeks) {
		Date firstDate = getThisweekFirst(early);
		firstDate = dateIncreaseByDay(firstDate, weeks * 7);
		return firstDate;
	}

	/**
	 * 获取两个日期间的月份间隔
	 * 
	 * @param early
	 *            early Date
	 * @param late
	 *            late Date
	 * @return int
	 */
	public static final int monthsIndays(Date early, Date late) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(early);
		c2.setTime(late);
		int earlyYear = c1.get(Calendar.YEAR);
		int earlyMonth = c1.get(Calendar.MONTH);
		int lateYear = c2.get(Calendar.YEAR);
		int lateMonth = c2.get(Calendar.MONTH);
		int months = (lateYear - earlyYear) * 12 + lateMonth - earlyMonth + 1;
		return months;
	}

	/**
	 * Returns the weeks between two dates.
	 * 
	 * @param early
	 *            the "first date"
	 * @param late
	 *            the "second date"
	 * @return the weeks between the two dates
	 */
	public static final int weeksIndays(Date early, Date late) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(early);
		c2.setTime(late);
		int days = daysBetween(c1, c2) + 1;
		int earlyweek = c1.get(Calendar.DAY_OF_WEEK);
		int lateweek = c2.get(Calendar.DAY_OF_WEEK);
		int weeks = days / 7;
		int weekst = days % 7;
		if (weekst == 0)
			return weeks;
		else if (lateweek >= earlyweek)
			return weeks + 1;
		else
			return weeks + 2;
	}

	/**
	 * Returns the days between two dates. Positive values indicate that the
	 * second date is after the first, and negative values indicate, well, the
	 * opposite. Relying on specific times is problematic.
	 * 
	 * @param early
	 *            the "first date"
	 * @param late
	 *            the "second date"
	 * @return the days between the two dates 原有方法计算2月28号至3月1号天数时有错误，多计算了两天
	 */
	public static final int daysBetween(Date early, Date late) {

		// Calendar c1 = Calendar.getInstance();
		// Calendar c2 = Calendar.getInstance();
		// c1.setTime(early);
		// c2.setTime(late);
		//
		// return daysBetween(c1, c2);
		String begin = getDateString(early).concat(" 00:00:00");
		String end = getDateString(late).concat(" 00:00:00");
		long l1 = Timestamp.valueOf(begin).getTime();
		long l2 = Timestamp.valueOf(end).getTime();
		int l = (int) ((l2 - l1) / (24 * 60 * 60 * 1000));
		int m = (int) ((l2 - l1) % (24 * 60 * 60 * 1000));
		if (m > 0) {
			l = l + 1;
		}
		return l;

	}

	public static final int sampleDaysBetween(Date early, Date late) {
		// (24 * 60 * 60 * 1000 = 86400000)
		int diffDateNum = (int) ((late.getTime() - early.getTime()) / 86400000);
		return diffDateNum;
	}

	/**
	 * Returns the days between two dates. Positive values indicate that the
	 * second date is after the first, and negative values indicate, well, the
	 * opposite.
	 * 
	 * @param early
	 *            early Calendar
	 * @param late
	 *            late Calendar
	 * @return the days between two dates.
	 */
	public static final int daysBetween(Calendar early, Calendar late) {
		return (int) (toJulian(late) - toJulian(early));
	}

	/**
	 * Return a Julian date based on the input parameter. This is based from
	 * calculations found at <a
	 * href="http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html">Julian Day
	 * Calculations (Gregorian Calendar)</a>, provided by Bill Jeffrys.
	 * 
	 * @param c
	 *            a calendar instance
	 * @return the julian day number
	 */
	public static final float toJulian(Calendar c) {

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		int century = year / 100;
		int temp1 = century / 4;
		int temp2 = 2 - century + temp1;
		float temp3 = (int) (365.25f * (year + 4716));
		float temp4 = (int) (30.6001f * (month + 1));
		float jd = temp2 + date + temp3 + temp4 - 1524.5f;

		return jd;
	}

	// =====================================================//
	// 截取字字符，从第一个开始，i为结束
	public static final String getString(int i, String str) {
		if (str.length() >= i)
			return str.substring(0, i);
		else
			return str;

	}

	// 返回两个时间差,返回格式是分钟
	public static final long getLongBetween(String flag, String time1,
			String time2) {

		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(time1);
			Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(time2);
			long ltime = date1.getTime() - date2.getTime() < 0 ? date2
					.getTime()
					- date1.getTime() : date1.getTime() - date2.getTime();
			if (flag.equals("s"))
				return ltime / 1000;// 返回秒
			else if (flag.equals("m"))
				return ltime / 60000;// 返回分钟
			else if (flag.equals("h"))
				return ltime / 3600000;// 返回小时
			else if (flag.equals("d"))
				return ltime / 86400000;// 返回天数
			else
				return 0;
		} catch (ParseException e) {
			logger.error("date format error!", e);
			return 0;
		}
	}

	public static String getDateTimeString(java.util.Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date).trim();
	}

	// 从日期中取得年
	public static int getYear(java.util.Date date) {
		String str_date = getDateString(date);
		String str[] = StringUtils.split(str_date, "-");
		String year = str[0];
		int y = Integer.parseInt(year);
		return y;
	}

	// 从日期中取得月份
	public static int getMonth(java.util.Date date) {
		String str_date = getDateString(date);
		String str[] = StringUtils.split(str_date, "-");
		String month = str[1];
		int m = Integer.parseInt(month);
		return m;
	}

	// 从日期中取得日
	public static int getDay(java.util.Date date) {
		String str_date = getDateString(date);
		String str[] = StringUtils.split(str_date, "-");
		String day = str[2];
		int d = Integer.parseInt(day);
		return d;
	}

	/**
	 * 获取某月的天数
	 * 
	 * @param baseDate
	 *            baseDate
	 * @return
	 */
	public static int getDays(String baseDate) {

		int count = -1;
		switch (Integer.parseInt(baseDate.substring(5, 7))) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			count = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			count = 30;
			break;
		case 2:
			if (Integer.parseInt(baseDate.substring(0, 4)) % 4 == 0) {
				count = 29;
			} else {
				count = 28;
			}
			if ((Integer.parseInt(baseDate.substring(0, 4)) % 100 == 0)
					& (Integer.parseInt(baseDate.substring(0, 4)) % 400 != 0)) {
				count = 28;
			}
			break;
		default:
			break;
		}
		return count;

	}

	/**
	 * 日期转换成字符串。转换后的格式为yyyyMMdd
	 * 
	 * @param date
	 * @return yyyyMMdd格式的字符串
	 */
	public static String dateToString1(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}

	/**
	 * 得到指定日期的起始时间 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayBeginDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 得到指定日期的结束时间 23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayEndDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
}
