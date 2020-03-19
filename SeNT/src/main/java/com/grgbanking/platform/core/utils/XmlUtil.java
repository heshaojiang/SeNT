/**
 * 文件名：XmlUtil.java
 * 创建日期： 2012-6-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * XML工具类
 * 
 * @author yrliang
 * 
 */
public class XmlUtil
{

	private static Logger logger = LoggerFactory.getLogger(XmlUtil.class);
	private static StringBuffer sb;

	/**
	 * 格式化xml String
	 * 
	 * @param strBuffer
	 *            需要调用程序保证改参数的线程安全
	 * @return
	 */
	public static String formatXml(StringBuffer strBuffer)
	{
		SAXReader saxReader = new SAXReader();
		StringReader stringReader = new StringReader(strBuffer.toString());
		StringWriter stringWriter = new StringWriter();
		Document document;
		try
		{
			document = saxReader.read(stringReader);
			stringReader.close();
			OutputFormat format = MyOutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			XMLWriter xmlwriter = new XMLWriter(stringWriter, format);
			xmlwriter.write(document);
		}
		catch( DocumentException e )
		{
			logger.error("对象转换成XML形式字符串的过程中出现异常！\n" + strBuffer.toString(), e);
		}
		catch( IOException e )
		{
			logger.error("对象转换成XML形式字符串的过程中出现异常！\n" + strBuffer.toString(), e);
		}

		return stringWriter.toString();
	}

	/**
	 * 将对象转换成XML树 <node id="1" name="根节点"> <node id="2" name="系统管理"> <node
	 * id="4" name="权限管理"/> <node id="4" name="机构管理"/> </node> <node id="3"
	 * name="终端管理"/> </node>
	 * 
	 * @param obj
	 *            含有自身类型嵌套的对象
	 * @param idField
	 *            xml的id 对应field
	 * @param nameField
	 *            xml显示名 对应field
	 */
	public static synchronized String generateXmlTree(
			Object root, 
			String idField, 
			String nameField, 
			String subField,
			String parentField)
	{
		return generateXmlTree(root, idField, new String[] { nameField }, subField, parentField);
	}

	/**
	 * 将对象转换成XML树 <node id="1" name="根节点"> <node id="2" name="系统管理"> <node
	 * id="4" name="权限管理"/> <node id="4" name="机构管理"/> </node> <node id="3"
	 * name="终端管理"/> </node>
	 * 
	 * @param obj
	 *            含有自身类型嵌套的对象
	 * @param idField
	 *            xml的id 对应field
	 * @param nameField
	 *            xml显示名 对应field
	 */
	public static synchronized String generateXmlTree(
			Object root, 
			String idField, 
			String[] parsField, 
			String subField,
			String parentField)
	{
		sb = new StringBuffer();
		genNode(root, idField, parsField, subField, parentField); // 产生xml
		// string
		return formatXml(sb);
	}

	@SuppressWarnings("unchecked")
	private static void genNode(Object root, String idField, String[] pars, String subField, String parentField)
	{
		printBeginTag(root, idField, parentField, pars);

		Collection collection = (Collection) ReflectionUtils.getFieldValue(root, subField);
		for( Object obj : collection )
		{
			genNode(obj, idField, pars, subField, parentField);
		}

		printEndTag();
	}

	private static void printBeginTag(Object obj, String idField, String parentField, String[] pars)
	{
		Object parent = ReflectionUtils.getFieldValue(obj, parentField);
		Object parentid = "";
		if( parent != null )
		{
			parentid = ReflectionUtils.getFieldValue(parent, idField);
		}

		sb.append("<node id=\'");
		sb.append(ReflectionUtils.getFieldValue(obj, idField));
		sb.append("\' parent=\'");
		sb.append(parentid);
		sb.append("\' ");
		for( int i = 0 ; i < pars.length ; i++ )
		{
			sb.append(pars[i] + "=");
			sb.append("\'");
			Object fieldValue = ReflectionUtils.getFieldValue(obj, pars[i]);
			if( fieldValue instanceof String )
			{
				fieldValue = transformSpecChars((String) fieldValue);
			}
			sb.append(fieldValue);
			sb.append("\' ");
		}
		sb.append(" >");
	}

	private static void printEndTag()
	{
		sb.append("</node>");
	}

	/**
	 * 转换特殊字符，防止xml出错
	 * 
	 * @param p_str
	 * @return
	 */
	private static String transformSpecChars(String p_str)
	{
		String fieldValue = p_str.replaceAll("&", "&amp;");
		fieldValue = fieldValue.replaceAll("'", "&apos;");
		fieldValue = fieldValue.replaceAll("\"", "&quot;");
		fieldValue = fieldValue.replaceAll("<", "&lt;");
		fieldValue = fieldValue.replaceAll(">", "&gt;");
		return fieldValue;
	}

	/**
	 * 生成XMLTREE
	 * 
	 * @param node
	 * @param idFieldName
	 * @param parentFieldName
	 * @param parseFields
	 * @param subRootList
	 * @return
	 * @author syue
	 */
	public static String genreatorTreeXml(
			Object node, 
			String idFieldName, 
			String labelFieldName, 
			String parentFieldName, 
			String[] parseFields, 
			List subRootList)
	{
		Assert.notNull(idFieldName, "idFieldName can not be null");

		StringBuffer xmlBuffer = new StringBuffer("");
		genreatorTreeNode(xmlBuffer, node, idFieldName, labelFieldName, parentFieldName, parseFields, subRootList);
		String xml = formatXml(xmlBuffer);
		return xml;
	}

	/**
	 * 生成国际化XMLTREE
	 * 
	 * @param node
	 * @param idFieldName
	 * @param parentFieldName
	 * @param parseFields
	 * @param subRootList
	 * @return
	 * @author syue
	 */
	public static String genreatorTreeXmlWithLanguage(
			Object node, 
			String idFieldName, 
			String labelFieldName,
			String parentFieldName, 
			String[] parseFields, 
			List subRootList, 
			List i18nList, 
			String[] languages)
	{
		StringBuffer xmlBuffer = new StringBuffer("");
		genreatorTreeNodeWithLanguage(xmlBuffer, node, idFieldName, labelFieldName, parentFieldName, parseFields, subRootList, i18nList, languages);
		String xml = formatXml(xmlBuffer);
		return xml;
	}

	/**
	 * 生成国际化TreeNode
	 * 
	 * @param xml
	 * @param node
	 * @param idFieldName
	 * @param parentFieldName
	 * @param parseFields
	 * @param subRootList
	 * @author syue
	 */
	private static void genreatorTreeNodeWithLanguage(
			StringBuffer xml, 
			Object node, 
			String idFieldName,
			String labelFieldName, 
			String parentFieldName, 
			String[] parseFields, 
			List subRootList, 
			List i18nList,
			String[] languages)
	{
		Assert.notNull(idFieldName, "idFieldName can not be null");

		xml.append("<node " + idFieldName + "='" + ReflectionUtils.getFieldValue(node, idFieldName) + "' ");

		xml.append(" label='" + ReflectionUtils.getFieldValue(node, labelFieldName) + "' ");
		for( String language : languages )
		{
			for( Object i18n : i18nList )
			{
				if( ReflectionUtils.getFieldValue(i18n, "referenceid").toString().equalsIgnoreCase(ReflectionUtils.getFieldValue(node, idFieldName).toString()) && ReflectionUtils.getFieldValue(i18n, "language").toString().equalsIgnoreCase(language) )
				{
					xml.append(" " + language + "='" + ReflectionUtils.getFieldValue(i18n, "name") + "' ");
				}

			}
		}

		for( String field : parseFields )
		{
			if( !idFieldName.equals(field) && idFieldName != null )
			{
				xml.append(field + "='" + ReflectionUtils.getFieldValue(node, field) + "' ");
			}
		}
		xml.append(">");
		List sublist = getSubNodeList(ReflectionUtils.getFieldValue(node, idFieldName).toString(), parentFieldName, subRootList);

		for( Object object : sublist )
		{
			genreatorTreeNodeWithLanguage(xml, object, idFieldName, labelFieldName, parentFieldName, parseFields, subRootList, i18nList, languages);
		}
		xml.append("</node>");

	}

	/**
	 * 生成TreeNode
	 * 
	 * @param xml
	 * @param node
	 * @param idFieldName
	 * @param parentFieldName
	 * @param parseFields
	 * @param subRootList
	 * @author syue
	 */
	private static void genreatorTreeNode(
			StringBuffer xml, 
			Object node, 
			String idFieldName,
			String labelFieldName,
			String parentFieldName, 
			String[] parseFields, 
			List subRootList)
	{

		Assert.notNull(idFieldName, "idFieldName can not be null!");

		xml.append("<node " + idFieldName + "='" + ReflectionUtils.getFieldValue(node, idFieldName) + "' ");

		Object labelValue = ReflectionUtils.getFieldValue(node, labelFieldName);
		if( labelValue instanceof String )
		{
			labelValue = transformSpecChars((String) labelValue);
		}
		xml.append(" label='" + labelValue + "' ");
		for( String field : parseFields )
		{
			if( !idFieldName.equals(field) && idFieldName != null )
			{
				Object fieldValue = ReflectionUtils.getFieldValue(node, field);
				if( fieldValue instanceof String )
				{
					fieldValue = transformSpecChars((String) fieldValue);
				}
				xml.append(field + "='" + fieldValue + "' ");
			}
		}
		xml.append(">");
		List sublist = getSubNodeList(ReflectionUtils.getFieldValue(node, idFieldName).toString(), parentFieldName, subRootList);

		for( Object object : sublist )
		{
			genreatorTreeNode(xml, object, idFieldName, labelFieldName, parentFieldName, parseFields, subRootList);
		}
		xml.append("</node>");

	}

	/**
	 * 生成根节点数组
	 * 
	 * @param parentFieldValue
	 * @param parentFieldName
	 * @param list
	 * @return
	 * @author syue
	 */
	private static List getSubNodeList(String parentFieldValue, String parentFieldName, List list)
	{
		List subList = new ArrayList();
		for( Object object : list )
		{
			Object obj = ReflectionUtils.getFieldValue(object, parentFieldName);
			obj = obj == null ? "" : obj.toString();
			if( obj.equals(parentFieldValue) )
			{
				subList.add(object);
			}
		}
		return subList;
	}
}

/**
 * XML格式化类
 * 
 * @author yrliang
 * 
 */
class MyOutputFormat extends OutputFormat
{
	public static OutputFormat createPrettyPrint()
	{
		OutputFormat format = new OutputFormat();
		format.setIndentSize(4);
		format.setNewlines(true);
		format.setTrimText(false);
		format.setPadText(true);

		return format;
	}
}