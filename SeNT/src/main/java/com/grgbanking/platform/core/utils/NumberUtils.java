/**
 * 文件名：NumberUtils.java
 * 创建日期： 2012-6-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 处理int的类
 * 
 * @author SONY
 */
public class NumberUtils {
	/**
	 * 将单位数的数字转换为双位数（在前面加零）
	 * 
	 * @param single
	 *            单位数
	 * @return 双位数， 如果参数不是单位数返回为null
	 */
	public static String single2Double(int single) {
		if (single > 9)
			return new Integer(single).toString();
		String monthStr = "";
		if (single < 10) {
			monthStr += "0";
		}
		monthStr += new Integer(single).toString();
		return monthStr;
	}

	/**
	 * 验证字符串是否为Double
	 * 
	 */
	public static boolean checkDoublue(String tmp) {
		if (tmp != null && tmp.length() > 1) {
			char[] ar = tmp.toCharArray();
			for (int i = 0; i < ar.length; i++) {
				if ((ar[i] < '0' || ar[i] > '9') && ar[i] != '.')
					return false;
			}
			return true;
		} else
			return false;
	}

	/**
	 * 四舍五入方法，返回double
	 * 
	 * @param int i ,返回小数点后几位数
	 */
	public static double getRound(double lsource, int i) {
		double iRound;
		BigDecimal deSource = new BigDecimal(lsource);
		iRound = deSource.setScale(i, BigDecimal.ROUND_HALF_UP).doubleValue();
		return iRound;
	}

	public static String getFormatMoney(double d) {
		BigDecimal a = new BigDecimal(d);
		a = a.divide(new BigDecimal(100)).setScale(2);
			DecimalFormat df = new DecimalFormat("#,###.##");
		return df.format(a.doubleValue()).toString();
	}

	public static double getCurrentFormatMoney(double d) {
		BigDecimal a = new BigDecimal(d);
		a = a.divide(new BigDecimal(100)).setScale(2);
		return a.doubleValue();
	}

	/**
	 * 隐藏帐号（偶数5-8位，奇数4-7位）
	 * 
	 * @param account
	 * @return
	 */
	public static String encryptAccount(String account) {
		String n_account = "";
		if (account.length() % 2 == 0) {
			n_account = account.replaceFirst("(\\w+)(\\w{4})(\\w{4})",
					"$1****$3");
		} else {
			n_account = account.replaceFirst("(\\w+)(\\w{4})(\\w{3})",
					"$1****$3");
		}
		return n_account;
	}
}
