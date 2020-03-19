/**
 * 文件名：PredefVars.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.msgtemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//encoding = GBK
/**
 * @author yaojun
 */
public class PredefVars {
	private static Logger logger = LoggerFactory.getLogger(PredefVars.class);

	/**
	 * @return Vbar
	 */
	public String getVbar() {
		return "|";
	}

	/**
	 * @return Semicolon
	 */
	public String getSemicolon() {
		return ";";
	}

	/**
	 * @return Space
	 */
	public String getSpace() {
		return " ";
	}

	/**
	 * @return Tab
	 */
	public String getTab() {
		return "	";
	}

	/**
	 * @return Comma
	 */
	public String getComma() {
		return ",";
	}

	/**
	 * @return Hyphen
	 */
	public String getHyphen() {
		return "-";
	}

	/**
	 * @return Period
	 */
	public String getPeriod() {
		return ".";
	}

	/**
	 * @return Dot
	 */
	public String getDot() {
		return ".";
	}

	/**
	 * @return Apostrophe
	 */
	public String getApostrophe() {
		return "'";
	}

	/**
	 * @return Rmb
	 */
	public String getRmb() {
		return "��";
	}

	/**
	 * @return Usd
	 */
	public String getUsd() {
		return "$";
	}

	/**
	 * @return *
	 */
	public String getAsterisk() {
		return "*";
	}

	/**
	 * @return @
	 */
	public String getAt() {
		return "@";
	}

	/**
	 * @return Slash
	 */
	public String getSlash() {
		return "/";
	}

	/**
	 * @return Backslash
	 */
	public String getBackslash() {
		return "\\";
	}

	/**
	 * @return {
	 */
	public String getLeftbracket() {
		return "{";
	}

	/**
	 * @return Rightbracket
	 */
	public String getRightbracket() {
		return "}";
	}

	/**
	 * @return Cr
	 */
	public String getCr() {
		return "\r";
	}

	/**
	 * @return Newline
	 */
	public String getNewline() {
		return "\n";
	}

	/**
	 * @return #
	 */
	public String getNumbersign() {
		return "#";
	}

	/**
	 * @return #
	 */
	public String getHash() {
		return "#";
	}

	/**
	 * @return _
	 */
	public String getUnderscore() {
		return "_";
	}

	/**
	 * @return 0
	 */
	public String getZero() {
		return "0";
	}

	/**
	 * @return o
	 */
	public String getOh() {
		return "o";
	}

	/**
	 * @return Doublequote
	 */
	public String getDoublequote() {
		return "\"";
	}

	/**
	 * @return Now
	 */
	public String getNow() {
		Calendar now = new GregorianCalendar();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(now.getTime());
	}

	/**
	 * @param arg
	 *            参数
	 * @return Now
	 */
	public String getNow(String arg) {
		Calendar now = new GregorianCalendar();

		if (arg != null && !arg.equals("")) {
			String timeformatstr = arg;
			if (timeformatstr.startsWith("\"") && timeformatstr.endsWith("\"")) {
				timeformatstr = timeformatstr.substring(1, timeformatstr.length() - 1);
			}
			SimpleDateFormat formatter = new SimpleDateFormat(timeformatstr);

			return formatter.format(now.getTime());
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return formatter.format(now.getTime());
		}
	}

	/**
	 * @return Guid
	 */
	public String getGuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * @return Random
	 */
	public String getRandom() {
		Random r = new Random();
		return Integer.toString(r.nextInt(100000));
	}

	/**
	 * @param arg
	 *            参数
	 * @return Random
	 */
	public String getRandom(String arg) {
		Random r = new Random();
		String rt = Integer.toString(r.nextInt(100000));
		int padside = 0;// 1=left,2=right,0=not pad
		int padcount = 0;
		if (arg.startsWith("L")) {
			padside = 1;
		} else if (arg.startsWith("R")) {
			padside = 2;
		} else {
			padside = 0;
		}

		try {
			padcount = Integer.parseInt(arg.substring(1));
		} catch (NumberFormatException e) {
			logger.warn("Number Format error, {} is not number", arg);
		}
		padcount = padcount - rt.length();

		if (padcount > 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < padcount; i++) {
				sb.append("0");
			}

			switch (padside) {
			case 1:
				rt = sb.toString() + rt;
				break;
			case 2:
				rt = rt + sb.toString();
				break;
			default:
				break;
			}
		}

		return rt;
	}
}
