/**
 * 文件名：MsgTemplate.java
 * 创建日期： 2012-5-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间， 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.msgtemplate;

//encoding = GBK

//import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grgbanking.platform.core.exception.SysException;

/**
 * @author yaojun 2010-01-28
 * 
 */
public class MsgTemplate {
	private static Logger s_oLog = LoggerFactory.getLogger(MsgTemplate.class);

	/**
	 * 
	 * @param clazz
	 *            Class
	 * @param msgObj
	 *            Object
	 * @param template
	 *            模板
	 * @param args
	 *            参数
	 * @return 字符串
	 */
	public static String phase(Class clazz, Object msgObj, String template, Object... args) {
		if (args == null) {
			args = new Object[] {};
		}

		PhaseResult pr = phase(clazz.getName(), msgObj, template, args);
		if (!pr.success) {
			s_oLog.error("msg content phase error!");
			throw new SysException(pr.errorinfo);
		}

		return pr.outcome;
	}

	/**
	 * 处理$开头的非预定义变量 和
	 * 
	 * @param rt
	 *            分析结果
	 * @param c
	 *            类
	 * @param classObj
	 *            包含各种信息的一个对象实例，其字段可以被模板引用并组合
	 * @param var
	 *            待处理变量
	 * @param sb_outcome
	 *            临时输出结果
	 * @return 是否能继续执行
	 */
	private static boolean processVar(PhaseResult rt, Class c, Object classObj, String var, List<String> sb_outcome) {
		try {
			// 可能会有：号分隔，需先拆分
			String[] field_strs = var.trim().substring(1).split(":", 2);
			String fieldname = field_strs[0];

			String methodname = "get" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
			Method mtd = c.getMethod(methodname, (Class[]) null);
			Object field_rst = mtd.invoke(classObj, (Object[]) null);

			if (field_rst != null) {
				// 如果是时间变量，则检查后面跟的格式字符串
				if (Date.class.isInstance(field_rst)) {
					if (field_strs.length == 2) {
						// 检查时间格式字符串是否是用“”括起来了
						String var_strs_1 = field_strs[1];
						if (field_strs[1].startsWith("\"") && field_strs[1].endsWith("\"")) {
							var_strs_1 = field_strs[1].substring(1, field_strs[1].length() - 1);
						}
						SimpleDateFormat formatter = new SimpleDateFormat(var_strs_1);
						sb_outcome.add(formatter.format((Date) field_rst));

					} else {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						sb_outcome.add(formatter.format((Date) field_rst));
					}
				} else {// 不是时间变量

					StringBuffer tag = new StringBuffer("");
					// 检查是否需要左补空格
					// add by liaijun 20101110
					// 内容：field_strs.length>=2&&
					if (field_strs.length >= 2 && field_strs[1].startsWith("L")) {
						int padlen = Integer.parseInt(field_strs[1].substring(1));
						int fieldlen = ((String) field_rst).length();
						if (padlen >= fieldlen) {
							for (int idx = 0; idx < padlen - fieldlen; idx++) {
								tag.append(" ");
							}
							sb_outcome.add(tag.toString()
									+ field_rst.toString());
						} else {
							rt.success = false;
							rt.errorinfo = "(6.1)args is invalid!";
							s_oLog.debug(rt.errorinfo);
							return false;
						}
					}
					// 检查是否需要右补空格
					// add by liaijun 20101110
					// 内容：field_strs.length>=2&&
					else if (field_strs.length >= 2 && field_strs[1].startsWith("R")) {
						int padlen = Integer.parseInt(field_strs[1].substring(1));
						int fieldlen = ((String) field_rst).length();
						if (padlen >= fieldlen) {
							for (int idx = 0; idx < padlen - fieldlen; idx++) {
								tag.append(" ");
							}
							sb_outcome.add(field_rst.toString()
									+ tag.toString());
						} else {
							rt.success = false;
							rt.errorinfo = "(6.2)args is invalid!";
							s_oLog.debug(rt.errorinfo);
							return false;
						}
					} else {
						sb_outcome.add(field_rst.toString());
					}
				}
			}
		} catch (NoSuchMethodException e) {
			rt.errorinfo = "(7)no such field get method!";
			s_oLog.debug(rt.errorinfo, e);
			return false;
		} catch (Exception e2) {
			rt.errorinfo = "(8)no such field get method!";
			s_oLog.debug(rt.errorinfo, e2);
			return false;
		}

		return true;
	}

	/**
	 * 处理$开头的非预定义变量 和
	 * 
	 * @param rt
	 *            分析结果
	 * @param var
	 *            待处理变量
	 * @param sb_outcome
	 *            临时输出结果
	 * @return 是否能继续执行
	 */
	private static boolean processPreVar(PhaseResult rt, String var, List<String> sb_outcome) {
		// 再判断预定义变量类型
		try {
			String[] var_strs = var.trim().split(":", 2);
			String varname = var_strs[0];
			String methodname = "get" + varname.substring(0, 1).toUpperCase() + varname.substring(1);
			Object var_rst = null;
			Method mtd = null;
			PredefVars prevars = new PredefVars();
			if (var_strs.length > 1) {
				mtd = PredefVars.class.getMethod(methodname, new Class[] { String.class });
				var_rst = mtd.invoke(prevars, new Object[] { var_strs[1] });
			} else {
				mtd = PredefVars.class.getMethod(methodname, (Class[]) null);
				var_rst = mtd.invoke(prevars, (Object[]) null);
			}
			if (var_rst != null) {
				sb_outcome.add(var_rst.toString());
			}
		} catch (NoSuchMethodException e) {
			rt.errorinfo = "(10)no such predefined variable!";
			s_oLog.debug(rt.errorinfo, e);
			return false;
		} catch (Exception e2) {
			rt.errorinfo = "(11)prevar method invoke failed!";
			s_oLog.debug(rt.errorinfo, e2);
			return false;
		}

		return true;
	}

	/**
	 * 根据模板以及传入数据生成字符串
	 * 
	 * @param className
	 *            classObj 类名
	 * @param classObj
	 *            包含各种信息的一个对象实例，其字段可以被模板引用并组合
	 * @param template
	 *            模板，详细说明请参考文档
	 * @param args
	 *            传入的额外参数，可以在模版中以{0},{1},...的形式进行引用
	 */
	private static PhaseResult phase(String className, Object classObj, String template, Object[] args) {
		s_oLog.debug("[MsgTemplate] Phase start:");
		PhaseResult rt = new PhaseResult();
		StringBuilder sb = new StringBuilder();// 保存异常信息；

		Class c = null;
		// 查找className指定的类
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
			sb.append("(1)class not found;");
			rt.errorinfo = sb.toString();
			s_oLog.debug("[MsgTemplate]", e);
			s_oLog.debug("[MsgTemplate] errorinfo:" + rt.errorinfo);
			return rt;// 没找到，返回
		}

		// 判断classObj是否为空或者不是className所指定的类
		if (classObj != null && !(c.isInstance(classObj))) {// classObj为空不必返回，可继续判断args
			sb.append("(3)classObj is not type of className;");
			rt.errorinfo = sb.toString();
			s_oLog.debug("[MsgTemplate] errorinfo:" + rt.errorinfo);
			return rt;
		}
		// 如果传进来的args和classObj都是空，则模版中只处理预定义变量
		Boolean onlyPrevars = false;
		// 检查args是否为空
		if (args == null && classObj == null) {
			sb.append("(4)classObj is null, args is null;");
			s_oLog.debug("[MsgTemplate] errorinfo:" + rt.errorinfo);
			onlyPrevars = true;
		}

		// 前面的检查过程已确保classObj要么为空，要么可以转化为className所指定的类

		// =========开始解析模板=========

		// 拆分模板

		List<String> variables = new ArrayList<String>();
		String regex = "\\{[^}]+\\}";
		Matcher m1 = Pattern.compile(regex).matcher(template);
		while (m1.find()) {
			variables.add(m1.group());
		}
		// String[] items = template.split(regex);
		List<String> sb_outcome = new ArrayList<String>();
		for (String s : variables) {
			s = s.substring(1, s.length() - 1);
			if (s != null && s.trim().length() > 0) {
				// 判断模板变量的类型
				if (s.startsWith("\"")) {
					if (s.endsWith("\"")) {
						sb_outcome.add(s.substring(1, s.length() - 1));
					} else {
						sb.append("(5)unmatched \"s, do you forget to write another double quote?");
						s_oLog.debug("[MsgTemplate] errorinfo:" + s + "  forget to write another double quote?");
					}
				} else if (!onlyPrevars && s.startsWith("$")) {
					if (!processVar(rt, c, classObj, s, sb_outcome))
						return rt;
				} else {
					// 先判断是否是{0},{1},{2}。。。类型的
					int arg_idx = -1;
					try {
						arg_idx = Integer.parseInt(s.trim());
					} catch (NumberFormatException e) {
						// NumberFormatException is ignored
						s_oLog.warn("NumberFormatException is ignored");
					}
					if (arg_idx > -1) {
						if (args.length > arg_idx) {
							sb_outcome.add(args[arg_idx].toString());
						} else {
							sb.append("(9)args index out of range;");
							rt.success = false;
							rt.errorinfo = sb.toString();
							s_oLog.debug("[MsgTemplate] errorinfo:" + rt.errorinfo);
							return rt;
						}
					} else {
						if (!processPreVar(rt, s, sb_outcome))
							return rt;
					}
				}
			}
		}

		for (String value : sb_outcome) {
			template = template.replaceFirst(regex, value);
		}
		rt.errorinfo = sb.toString();
		rt.outcome = template;
		rt.success = true;

		return rt;
	}

}
