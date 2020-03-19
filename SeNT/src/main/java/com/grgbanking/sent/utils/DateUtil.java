package com.grgbanking.sent.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TimeZone;

import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.utils.BeanCommonUtils;




/**时间转换
 * BaseMessage
 * @author 广电运通
 * @version :1.0 </br>
 */
public class DateUtil
{

	//public static final SimpleDateFormat sdf_yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
	private static Logger logger = LoggerFactory.getLogger(BeanCommonUtils.class);
	
	
	public static final long MILLISECOND_PER_DAY = 1000*60*60*24;

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
		if (fromDate == null || fromDate.trim().length() == 0){
			return false;
		}
		if (toDate == null || toDate.trim().length() == 0){
			return false;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date begin = null;
		Date end = null;
		try {
			begin = format.parse(fromDate);
			end = format.parse(toDate);
			if (begin.after(end)){
				return false;
			}
			dates[0] = format.format(begin);
			dates[1] = format.format(end);
		} catch (ParseException e) {
            logger.error("",e);
			return false;
		}
		return true;
	}

	/**
	 * @param tsp tsp
	 * @return String
	 */
	public static String getTimeString(Timestamp tsp) {
		if (tsp == null){
			return "";
		}
		return getTimeString(new Date(tsp.getTime()));
	}

	/**
	 *@return String
	 *@param  date date
	 */
	public static String getTimeString(java.util.Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date).trim();
	}
     /**
      *@return String
      *@param date date 
      */
	public static String stringYYYYMMDDHHMMSSTo(String date) {
		final int a=4;
		final int b=6;
		final int c=8;
		final int f=10;
		final int d=14;
		final int e=12;
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(date.substring(0, a));
		strBuffer.append("-");
		strBuffer.append(date.substring(a, b));
		strBuffer.append("-");
		strBuffer.append(date.substring(b, c));
		strBuffer.append(" ");
		strBuffer.append(date.substring(c, f));
		strBuffer.append(":");
		strBuffer.append(date.substring(f, e));
		strBuffer.append(":");
		strBuffer.append(date.substring(e, d));

		return strBuffer.toString();
	}
    /**
     * @param date date
     * @return String
     */
	public static String getTimeYYYYMMDDHHMMSSString(java.util.Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(date).trim();
	}

	/**
	 *@param date date
	 *@return String 
	 */
	public static String getDateString(java.util.Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date).trim();
	}

   /**to_char
    *@param tsp tsp
    *@param formatStr formatStr
    *@return String 
    */
	public static String dateFormatterS(Timestamp tsp, String formatStr) {
		if (tsp == null){
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
		 
		//String dateStr=toChars(new Date(tsp.getDate()), formatStr);
		return formatter.format(new Date(tsp.getTime())).trim();
		
	}
	
   /**
    *@param date date
    *@param formatStr 
    * @return String
    */
	public static String toChars(Date date,String formatStr){
			SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
	   return  formatter.format(date).trim();
	}

    /**to_timestamp
     *@param date date
     *@return Timestamp 
     */
	public static Timestamp timestamp(String date) {
		return new Timestamp(toDate(date).getTime());
	}
	 /**to_timestamp
     *@param date date
     *@return Timestamp 
     */
	public static Timestamp timestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	/**
	 *@param dateText dateText
	 *@param formatStr formatStr
	 *@return Date
	 */

//	public static Date stringToDate(String dateText, String formatStr) {
//		if (dateText == null) {
//			return null;
//		}
//		DateFormat df = null;
//		try {
//			if (formatStr == null) {
//				df = new SimpleDateFormat();
//			} else {
//				df = new SimpleDateFormat(formatStr);
//			}
//
//			df.setLenient(false);
//			return df.parse(dateText);
//		} catch (ParseException e) {
//			logger.error("",e);
//			return null;
//		}
//	}

	/**to_Date
	 * @return Date
	 * @param date date
	 */
	public static Date toDate(String date) {
		Calendar cd = Calendar.getInstance();
		final int strYear=1970;
		final int strMonth=0;
		final int strDay=1;
		StringTokenizer token = new StringTokenizer(date, "-/ :");
		if (token.hasMoreTokens()) {
			cd.set(Calendar.YEAR, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.YEAR, strYear);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.MONTH, Integer.parseInt(token.nextToken()) - 1);
		} else {
			cd.set(Calendar.MONTH, strMonth);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.DAY_OF_MONTH, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.DAY_OF_MONTH, strDay);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.HOUR_OF_DAY, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.HOUR_OF_DAY, strMonth);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.MINUTE, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.MINUTE, strMonth);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.SECOND, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.SECOND, strMonth);
		}
		if (token.hasMoreTokens()) {
			cd.set(Calendar.MILLISECOND, Integer.parseInt(token.nextToken()));
		} else {
			cd.set(Calendar.MILLISECOND, 0);
		}
		return cd.getTime();
	}

	/**
	 *@return String 
	 *@param selType selType 
	 */

	public static final String[] getDateRange(int selType) {
		String startDate = null;
		String endDate = null;
		final int a=1;
		final int b=3600;
		final int c=1000;
		final int d=24;
		final int e=3;
		final int f=5;
		final int g=7;
		final int h=8;
		final int o=10;
		final int j=12;
		Calendar cd = Calendar.getInstance();
		int year = cd.get(Calendar.YEAR);
		int month = cd.get(Calendar.MONTH) + a;
		Calendar cdTmp = Calendar.getInstance();
		int i;
		switch (selType) {
		case 1: 
			i = cd.get(Calendar.DAY_OF_WEEK) - a;
			cdTmp.setTime(new Date(cd.getTime().getTime() - i * b * d
					* c));
			startDate = cdTmp.get(Calendar.YEAR) + "-"
					+ (cdTmp.get(Calendar.MONTH) + a) + "-"
					+ cdTmp.get(Calendar.DAY_OF_MONTH);
			i = g - cd.get(Calendar.DAY_OF_WEEK);
			cdTmp.setTime(new Date(cd.getTime().getTime() + i * b * d
					* c));
			endDate = cdTmp.get(Calendar.YEAR) + "-"
					+ (cdTmp.get(Calendar.MONTH) + 1) + "-"
					+ cdTmp.get(Calendar.DAY_OF_MONTH);
			break;
		case 2: 
			startDate = year + "-" + month + "-01";
			switch (month) {
			case a:
			case e:
			case f:
			case g:
			case h:
			case o:
			case j:
				endDate = year + "-" + month + "-31";
				break;
			case 2:
				if (isLeapYear(year)){
					endDate = year + "-" + month + "-29";
				}
				else{
					endDate = year + "-" + month + "-28";
				}
				break;
				
			default:
				endDate = year + "-" + month + "-30";
			}
			break;
		case e: // 
			startDate = year + "-01-01";
			endDate = year + "-12-31";
			break;
		default:
			startDate = "2000-01-01";
			endDate = "2100-01-01";
		} 
		return new String[] { startDate, endDate };
	}

	/**
	 *@param dateText dateText
	 *@param formatStr formatStr
	 *@return Date
	 */
	
	public static Date stringToDate(String dateText, String formatStr) {
		if (dateText == null) {
			return null;
		}
		DateFormat df = null;
		try {
			if (formatStr == null) {
				df = new SimpleDateFormat();
			} else {
				df = new SimpleDateFormat(formatStr);
			}
	
			df.setLenient(false);
			return df.parse(dateText);
		} catch (ParseException e) {
			logger.error("",e);
			return null;
		}
	}

	// ------------------------------------------------------------------------------
	/**
	 *@param y y
	 * @return true or false
	 */
	public static final boolean isLeapYear(int y) {
		final int a=4;
		final int b=100;
		final int c=400;
		if (y % a == 0) {
			if (y % b == 0) {
				if (y % c == 0){
					return true;
				}
				else{
					return false;
					}
			} else {
				return true;
			} // else
		} // if
		return false;
	}
	
  /**
   * @return Date
   * @param date 时间
   * @param hours 根据小时
   */
	public static Date dateIncreaseByHour(Date date, int hours) {
		Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours);

		return cal.getTime();
	}

	/**
	 * 
	 * 
	 * @param date 时间
	 * @param days 天数
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByDay(Date date, int days) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	/**
	 * 
	 * 根据日历的规则，为给定的日历字段添加或减去指定的时间量。
	 * @param date 日历字段
	 * @param mnt 为字段添加的日期或时间量。
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByMonth(Date date, int mnt) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.MONTH, mnt);

		return cal.getTime();
	}

	/**
	 * 根据日历的规则，为给定的日历字段添加或减去指定的时间量。
	 * @param date 日历字段
	 * @param mnt 为字段添加的日期或时间量。
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByYear(Date date, int mnt) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.YEAR, mnt);

		return cal.getTime();
	}
	/**
	 * @param early 时间
	 * @return Date 时间
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
   * @return Date 时间
   * @param early 时间 
   * @param weeks 星期
   */
	public static final Date firstdateIncreaseByWeek(Date early, int weeks) {
		Date firstDate = getThisweekFirst(early);
		final int week=7;
		firstDate = dateIncreaseByDay(firstDate, weeks * week);
		return firstDate;
	}
	 /**
	  * @return 时间
	  * @param early 时间
	  * @param late 时间
	  */
	public static final int monthsIndays(Date early, Date late) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		final int month=12;
		c1.setTime(early);
		c2.setTime(late);
		int earlyYear = c1.get(Calendar.YEAR);
		int earlyMonth = c1.get(Calendar.MONTH);
		int lateYear = c2.get(Calendar.YEAR);
		int lateMonth = c2.get(Calendar.MONTH);
		int months = (lateYear - earlyYear) * month + lateMonth - earlyMonth + 1;
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
		final int week=7;
		c1.setTime(early);
		c2.setTime(late);
		int days = daysBetween(c1, c2) + 1;
		int earlyweek = c1.get(Calendar.DAY_OF_WEEK);
		int lateweek = c2.get(Calendar.DAY_OF_WEEK);
		int weeks = days / week;
		int weekst = days % week;
		if (weekst == 0) {
			return weeks;
		} else if (lateweek >= earlyweek) {
			return weeks + 1;
		} else {
			return weeks + 2;
		}
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
	 * @return the days between the two dates
	 */
	public static final int daysBetween(Date early, Date late) {

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(early);
		c2.setTime(late);

		return daysBetween(c1, c2);
	}

	/**
	 * Returns the days between two dates. Positive values indicate that the
	 * second date is after the first, and negative values indicate, well, the
	 * opposite.
	 * 
	 * @param early early
	 * @param late late
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
		final int a=100;
        final int b=2;
        final int d=4;
        final int e=4716;
        final int f=1;
        final float gst=1524.f;
        
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		int date=c.get(Calendar.DATE);
		int ast=year/a;
		int bst=ast/d;
		int cst=b-ast+bst;
		final float est = (int) (365.25f * (year + e));
		final float fst = (int) (30.6001f * (month + f));
	    final float jst = cst + date + est + fst - gst;

		return jst;
	}

	/**
	 * @return boolean
	 * @param year 年
	 */
	public static final boolean checkLeapYear(int year) {
		boolean isLeapYear = false;
		final int a=4;
		final int b=100;
		final int c=400;
		if (year % a == 0 && year % b != 0) {
			isLeapYear = true;
		}
		if (year % c == 0){
			isLeapYear = true;
		}
		else if (year % a != 0) {
			isLeapYear = false;
		}
		return isLeapYear;
	}

	/**
	 * @return 月
	 * @param month 月
	 * @param year 年
	 */
	public static final int checkMonth(int month, int year) {
		int dates = 0;
		final int monStr=12;
		final int a=1;
		final int b=3;
		final int c=5;
		final int d=7;
		final int e=10;
		final int f=12;
		final int g=8;
		final int h=31;
		final int i=28;
		final int j=29;
		final int k=30;
		final int o=4;
		final int p=6;
		final int q=9;
		final int r=11;
		final int s=2;
		
		if (month < dates || month > monStr) {

		}
		if (month == a || month == b || month == c || month == d || month == g
				|| month == e || month == f) {
			dates = h;
		}
		if (month == s && checkLeapYear(year)) {
			dates = j;
		}
		if (month == s && !checkLeapYear(year)) {
			dates = i;
		}
		if (month == o || month == p || month == q || month == r) {
			dates = k;
		}
		return dates;
	}
	
     /**to_TMdate
      * @return String类型的时间
      * @param date 时间
      */
	public static String dateFormat(String date) {
		String returnDate;
		date = date + "-";
		String[] str = date.split("-");
		int len = str.length;
		returnDate = str[0];
		if (len > 1) {
			for (int i = 1; i < len; i++) {
				returnDate = returnDate + str[i];
			}
		}

		return returnDate;
	}
    /**
     *to_TMdate1
     * @return  String类型的时间
     * @param date 时间
     */
	public static String tmDate(String date) {
		String returnDate;
		date = date + "-";
		String[] str = date.split("-");
		int len = str.length;
		returnDate = str[0];
		if (len > 1) {
			for (int i = 1; i < len; i++) {
				if (str[i].length() == 1) {
					str[i] = new String("0") + str[i];
				}
				returnDate = returnDate + str[i];
			}
		}

		return returnDate;
	}
	
    /**
     * to_TMNormalDate
     *@return String 类型的时间
     *@param date 时间
     */
	public static String tmNormalDate(String date) {
		String returnDate = "1111-11-11";
		final int a=8;
		final int b=0;
		final int c=4;
		final int d=6;
		if (date.length() >= a) {
			returnDate = date.substring(b,c) + "-" + date.substring(c,d)
					+ "-" + date.subSequence(d, a);
		}
		return returnDate;
	}
     /**
      *  to_TMNormalTime
      *  @param time 时间
      *  @return 时间
      */
	public static String tmNormalTime(String time) {
		String returnDate = "00:00:00";
		final int a=6;
		final int b=0;
		final int c=2;
		final int d=4;
		if ((time != null) && (time.length() >= a)) {
			returnDate = time.substring(b, c) + ":" + time.substring(c, d)
					+ ":" + time.subSequence(d, a);
		}
		return returnDate;
	}

	/**
	 * @param date
	 *            类型的时间
	 * @return 时间
	 */
	public static String getyyyyMMddDate(Date date)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(date);
	}
    /**stringyyy_mm_ddToyyyyMMdd
     * @return 时间
     * @param dateText date类型的时间
     */
	public static String dateFormatString(String dateText) {
		final int a=0;
		final int b=4;
		final int c=5;
		final int d=7;
		final int e=8;
		final int f=10;
		if (dateText == null){

			return null;
		}
		try {
			String date = "";
			if (dateText.length() >= f) {
				String year = dateText.substring(a, b);
				String month = dateText.substring(c, d);
				String day = dateText.substring(e, f);
				date = year + month + day;
			}
			return date;

		} catch(DataException e1){
			logger.error("", e1);
			return null;
		}
			
		
	}
   /**
    *@return String
    *@param dateText dateText
    * 
    */
	public static String dateTextFormatString(String dateText) {
		final int y=0;
		final int m=4;
		final int d=8;
		final int t=6;
		if (dateText == null){
			return null;
		}
		try {
			String date = "";
			if (dateText.length() >= d) {
				String year = dateText.substring(y, m);
				String month = dateText.substring(m, t);
				String day = dateText.substring(t, d);
				date = year + "-" + month + "-" + day;
			}
			return date;

		} catch (DataException e) {
		      logger.error("", e);
			 
			return null;
		}
	}
    /**
     * @param timeText 时间
     * @return 时间
     */
	public static String stringhhmmssTohhmmss(String timeText) {
		final int a=8;
		final int b=0;
		final int c=2;
		final int d=5;
		final int g=6;
		final int f=8;
		final int k=3;
		if (timeText == null){
			return null;
		}
		try {
			String time = "";
			if (timeText.length() >= a) {
				String hh = timeText.substring(b, c);
				String mm = timeText.substring(k, d);
				String ss = timeText.substring(g, f);
				time = hh + mm + ss;
			}
			return time;

		} catch (DataException e) {
         	logger.error("", e);
			
			return null;
		}
	}
    /**
     * string yyyy_MM_ddHH_mm_ss To yyyyMMddHHmmss
     *@param dateTimeText 时间
     *@return 时间 
     */
	public static String dateFormatTohms(String dateTimeText){
		final int a=0;
		final int b=4;
		final int c=5;
		final int d=7;
		final int o=8;
		final int f=10;
		final int j=11;
		final int k=13;
		final int g=14;
		final int h=16;
		final int i=17;
		final int p=19;
		if (dateTimeText == null){
			return null;
		}
		try {
			String datetime = "";
			if (dateTimeText.length() >= p) {
				String year = dateTimeText.substring(a, b);
				String month = dateTimeText.substring(c, d);
				String day = dateTimeText.substring(o, f);
				String hh = dateTimeText.substring(j, k);
				String mm = dateTimeText.substring(g, h);
				String ss = dateTimeText.substring(i, p);
				datetime = year + month + day + hh + mm + ss;
			}
			return datetime;

		} catch (NullPointerException e) {
		  logger.error("", e);
			
			return null;
		}
	}
	
	public static Date parseToDate(String dateString, String format) throws ParseException
	{
		return new SimpleDateFormat(format).parse(dateString);
	}
	
	public static Date parseToDate(String dateString) throws ParseException
	{
		return parseToDate(dateString, "yyyy-MM-dd HH:mm:ss.SSS");
	}
	
	public static String parseToString(Date date, String format)
	{
		return new SimpleDateFormat(format).format(date);
	}
	
	public static String parseToString(Date date)
	{
		return parseToString(date, "yyyy-MM-dd HH:mm:ss.SSS");
	}
	
	/**
	 * cut a date like '2013-08-08 17:22:33.444' to:
	 * '2013-08-08 17:22:33.000' when use Calendar.MILLISECOND as type parameter
	 * '2013-08-08 17:22:00.000' when use Calendar.SECOND as type parameter
	 * '2013-08-08 17:00:00.000' when use Calendar.MINUTE as type parameter
	 * '2013-08-08 12:00:00.000' when use Calendar.HOUR as type parameter
	 * '2013-08-08 00:00:00.000' when use Calendar.HOUR_OF_DAY as type parameter
	 * '2013-08-01 00:00:00.000' when use Calendar.DATE(or Calendar.DAY_OF_MONTH) as type parameter
	 * '2013-01-01 00:00:00.000' when use Calendar.MONTH as type parameter
	 * 
	 * @param date: 传入的日期
	 * @param type：
	 * 	Calendar.MILLISECOND
	 * 	Calendar.SECOND
	 * 	Calendar.MINUTE
	 * 	Calendar.HOUR
	 * 	Calendar.HOUR_OF_DAY
	 * 	Calendar.DATE
	 * 	Calendar.DAY_OF_MONTH
	 * 	Calendar.MONTH
	 * 
	 * @return
	 */
	public static Date cutDate(Date date, int type)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if( type==Calendar.MILLISECOND )
		{
			calendar.set(Calendar.MILLISECOND, 0);
		}
		else if( type==Calendar.SECOND )
		{
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
		}
		else if( type==Calendar.MINUTE )
		{
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
		}
		else if( type==Calendar.HOUR  )
		{
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.HOUR, 0);
		}
		else if( type==Calendar.HOUR_OF_DAY  )
		{
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
		}
		else if( type==Calendar.DATE )
		{
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DATE, 1);
		}
		else if( type==Calendar.MONTH  )
		{
			calendar.set(Calendar.MILLISECOND, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.DATE, 1);
			calendar.set(Calendar.MONTH, 0);
		}
		else if( type==Calendar.YEAR  )
		{
			throw new IllegalArgumentException("Parameter type can't be Calendar.YEAR.");
		}
		else
		{
			throw new IllegalArgumentException("Parameter type ("+type+") is not a valid value.");
		}
		return calendar.getTime();
	}
	
	public static Date addByDay(Date date, int num)
	{
		return new Date( date.getTime() + 1000*60*60*24 );
	}
	
	public static Date[] listDaysBetween(Date date1, Date date2, boolean includeBeginDay, boolean includeEndDay)
	{
		List<Date> list = new ArrayList<Date>();
		date1 = cutDate(date1, Calendar.HOUR_OF_DAY);
		date2 = cutDate(date2, Calendar.HOUR_OF_DAY);
		if( date1.getTime() > date2.getTime() )
		{
			throw new IllegalArgumentException("date1 cannot later than date2");
		}
		if( includeBeginDay )
		{
			list.add(date1);
		}
		Date day = addByDay(date1, 1);
		while( day.getTime()<date2.getTime() )
		{
			list.add(day);
			day = addByDay(day, 1);
		}
		if( includeEndDay && date2.getTime()>date1.getTime() )
		{
			list.add(date2);
		}
		return list.toArray(new Date[0]);
	}
	
	/**
	 * 获取格式化的日期字符串
	 * @param dateString 日期字符串格式：yyyyMMddHHmmss
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getTimeString(String dateString)
	{
		if(dateString==null )
		{
			return "";
		}
		if(dateString.length()<14 )
		{
			return dateString;
		}
		
		String yyyy = dateString.substring(0, 4);
		String mm = dateString.substring(4, 6);
		String dd = dateString.substring(6, 8);
		String hh = dateString.substring(8, 10);
		String mi = dateString.substring(10, 12);
		String ss = dateString.substring(12, 14);
		
		return yyyy + "-" + mm + "-" + dd + " " + hh + ":" + mi + ":" + ss;
	}

	public static int CalDaysBetween(Date early, Date late) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(early);

		long time1 = cal.getTimeInMillis();

		cal.setTime(late);

		long time2 = cal.getTimeInMillis();

		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	//dateFormatTohms
	public static void main(String[] args) throws ParseException
	{
		//dateFormatTohms();
		Date d1 = new Date();//parseToDate("2013-10-08", "yyyy-MM-dd");
		Date d2 = new Date();
		Date[] dates = listDaysBetween(d1, d2, true, true);
		for( Date date : dates )
		{
			System.out.println(parseToString(date));
		}
	}
}







