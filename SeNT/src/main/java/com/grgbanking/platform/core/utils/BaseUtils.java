package com.grgbanking.platform.core.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.spring.SpringContextHolder;
import com.grgbanking.platform.module.datadir.entity.SysDatadir;
import com.grgbanking.platform.module.param.service.ParamService;

/**
 * 文件名：MapAdapter.java 创建日期： 2012-2-8 Copyright (c) 2011-2011 广电运通 All rights
 * reserved.
 * 
 * 修改记录： 1.修改时间， 修改人： 修改内容：
 */
public class BaseUtils {

	/**
	 * <Description> 该方法服务于由Hibernate查询出来的Object结果，不能判断其属于那种数值类型
	 * 
	 * @param obj
	 *            对象
	 * @return int
	 */
	public static int getIntValue(Object obj) {
		int i = 0;
		if (obj instanceof Long) {
			Long k = (Long) obj;
			i = k.intValue();
		} else if (obj instanceof Integer) {
			Integer k = (Integer) obj;
			i = k;
		} else if (obj instanceof Double) {
			Double k = (Double) obj;
			i = k.intValue();
		} else if (obj instanceof BigDecimal) {
			BigDecimal k = (BigDecimal) obj;
			i = k.intValue();
		} else if (obj instanceof String) {
			i = Integer.parseInt((String) obj);
		}

		return i;
	}

	/**
	 * <Description>: 该方法把一个String类型的集合生成一个( str1, str2, str3)的字符串
	 * 
	 * @param list
	 *            列表
	 * @return String
	 */
	public static String stringToInSQL(List<String> list) {
		String param = " (";
		for (int i = 0; i < list.size(); i++) {
			param += " '" + list.get(i) + "' ";
			if (i < list.size() - 1) {
				param += ", ";
			}
		}
		param += ") ";

		return param;
	}

	/**
	 * <Description>:把数据字典查出来的结果封装成可以供combox读取的数据源
	 * 
	 * @param list
	 *            数据源列表
	 * @return List<Map<String, String>>
	 */
	public static List<Map<String, String>> getSysDataDirList(
			List<SysDatadir> list) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for (SysDatadir objs : list) {
			Map<String, String> listMap = new HashMap<String, String>();
			listMap.put("key", objs.getKey());
			listMap.put("value", objs.getValue());
			result.add(listMap);
		}
		return result;
	}

	/**
	 * <Description>:把数据字典查出来的结果封装成可以供combox读取的数据源
	 * 
	 * @param list
	 *            获取币种信息数据源列表
	 * @return List<Map<String, String>>
	 */
	public static List<Map<String, String>> getSysDataDirFundTypeList(
			List<SysDatadir> list) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for (SysDatadir objs : list) {
			Map<String, String> listMap = new HashMap<String, String>();
			listMap.put("key", objs.getKey());
			listMap.put("value", objs.getValue());
			result.add(listMap);
		}
		return result;
	}

	/**
	 * <Description>:把数据字典查出来的结果封装成可以供后台读取的数据源
	 * 
	 * @param list
	 *            数据源
	 * @return Map<String, String>
	 */
	public static Map<String, String> getSysDataDirMap(List<SysDatadir> list) {
		Map<String, String> tempMap = new HashMap<String, String>();
		for (SysDatadir objs : list) {
			tempMap.put(objs.getKey(), objs.getValue());
		}
		return tempMap;
	}

	/**
	 * <Description>:传入一个金额值，返回一个已经配置好的最小面额单位的值
	 * 
	 * @param match
	 *            金额值
	 * @return String
	 */
	public static String getCurrentDenomination(Object match) {
		if (match == null)
			return "";
		Double d = null;
		Integer i = null;
		if (match instanceof Double) {
			d = (Double) match;
		} else if (match instanceof Integer) {
			i = (Integer) match;
		} else if (match instanceof String) {
			i = Integer.parseInt((String) match);
		}

		ParamService service = SpringContextHolder.getBean("paramService");
		String denomination = service.getValueByPath(AppConstants.DENOMINATION);
		int deno = Integer.parseInt(denomination);
		String str = "1";
		String format = "#0";
		for (int j = 0; j < deno; j++) {
			str += "0";
			if (j == 0) {
				format += ".#";
			} else {
				format += "#";
			}
		}
		int denominator = Integer.parseInt(str); // 分母
		DecimalFormat formater = new DecimalFormat(format);
		if (d != null) {
			double dR = d / denominator;
			return formater.format(dR);
		} else if (i != null) {
			int iR = i / denominator;
			return formater.format(iR);
		}
		return "";
	}

	/**
	 * 
	 * @param args
	 *            参数
	 */
	public static void main(String[] args) {
		BaseUtils b = new BaseUtils();
		Integer i = 121;

	}

	/**
	 * <Description>:传入一个金额值，返回一个已经配置好的最小面额单位的值
	 * 
	 * @param match
	 *            金额值
	 * @return String
	 */
	public static String getFormatMoney(Object match) {
		if (match == null)
			return "";
		Double d = null;
		Long i = null;
		Long l = null;
		if (match instanceof Double) {
			d = (Double) match;
		} else if (match instanceof Integer) {
			i = (Long) match;
		} else if (match instanceof String) {
			l = Long.parseLong((String) match);
		}

		ParamService service = SpringContextHolder.getBean("paramService");
		String denomination = service.getValueByPath(AppConstants.DENOMINATION);
		int deno = Integer.parseInt(denomination);
		String str = "1";
		String format = "#0";
		for (int j = 0; j < deno; j++) {
			str += "0";
			if (j == 0) {
				format += ".#";
			} else {
				format += "#";
			}
		}
		int denominator = Integer.parseInt(str); // 分母
		DecimalFormat formater = new DecimalFormat(format);
		if (d != null) {
			double dR = d / denominator;
			return formater.format(dR);
		} else if (i != null)
			return formater.format(i / denominator);
		else if (l != null)
			return formater.format(l / denominator);
		return "";
	}
}
