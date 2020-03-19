package com.grgbanking.sent.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

public class StringUtil
{

	public static Integer parseToInteger(String value, String errorMessage)
	{
		try
		{
			return Integer.valueOf(value);
		}
		catch( NumberFormatException e )
		{
			errorMessage = String.format(errorMessage, value);
			throw new NumberFormatException(errorMessage);
		}
	}
	
	/**
	 * 
	 */
	public static String trim(Object obj)
	{
		return trim(String.valueOf(obj), "");
	}
	
	/**
	 * 
	 */
	public static String trim(String str)
	{
		return trim(str, "");
	}
	
	/**
	 * 
	 */
	public static String trim(String str, String defaultValue)
	{
		if( str==null )
		{
			return defaultValue;
		}
		else
		{
			return str.trim();
		}
	}
	
	/**
	 * 
	 */
	public static boolean isBlank(String str)
	{
		return StringUtils.isBlank(str);
	}
	
	/**
	 * 
	 */
	public static boolean isNotBlank(String str)
	{
		return StringUtils.isNotBlank(str);
	}
	
	/**
	 * 
	 */
	public static boolean isInteger(String str)
	{
		if( str==null )
		{
			return false;
		}
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
	 * 生成一个部分字符重复出现的字符串, 例如：
	 * 
	 * 		generateMultiPartString("?", 3, ", ")
	 *  
	 * 生成结果为： "?, ?, ?"
	 * 
	 * @param str: 重复出现的那部份
	 * @param len：重复出现的次数
	 * @param sep：分隔符
	 * @return
	 */
	public static String generateMultiPartString(String str, int len, String sep)
	{
		StringBuilder sb = new StringBuilder();
		for( int i=0; i<len; i++ )
		{
			if( i!=0 )
			{
				sb.append(sep);
			}
			sb.append(str);
		}
		return sb.toString();
	}
	
	/**
	 * 将输入的字符串转为unicode编码格式:
	 * 中文 -》 \u4E2D\u6587
	 */
	public static String toUnicode(String str)
	{
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			short d = (short) chars[i];
			if (d > 0xff)
			{
				sb.append("\\u" + Integer.toHexString(d).toUpperCase());
			}
			else
			{
				sb.append((char) d);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 
	 */
	public static String[] splitTrim(String str, String sep)
	{
		if( str==null || str.length()==0 )
		{
			return new String[0];
		}
		List<String> list = new ArrayList<String>();
		String[] arr = str.split(sep);
		for( String s : arr )
		{
			s = trim(s);
			if( s.length()!=0 )
			{
				list.add(s);
			}
		}
		return list.toArray(new String[0]);
	}
	
	/**
	 * 
	 */
	public static String generateUUID()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 
	 */
	public static void main(String[] args)
	{
		System.out.println(generateMultiPartString("?", 3, ", "));
	}
}
