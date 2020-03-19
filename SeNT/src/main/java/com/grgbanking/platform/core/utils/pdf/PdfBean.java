/**
 * 文件名：PdfBean.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils.pdf;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Element;

/**
 * @author Jonas
 * 
 */
@SuppressWarnings( { "rawtypes", "unchecked" })
public class PdfBean implements Serializable {

	private static final long serialVersionUID = -457346454899043721L; // implements
	// Serializable序列化，用于网络传输时，会用到。若是单机，就没用

	// pdf属性
	private String title;// 标题
	private String subject; // 主题
	private String keywords; // 关键词
	private String author; // 作者
	private String creator; // 创建人
	private Map headerMap;// 对于pdf文档无效，doc.addHeader()仅对html文档有效，用于添加文档的头信息

	// 最重要的
	private List<Element> elementList; // 元素List
	private String fileName;// pdf文件名

	// 页头和页尾
	private String header;// 页头
	private String footer;// 页尾

	// 以下是加密
	private boolean encryptFlag; // 是否加密;
	private String userPsw; // 用户密码 null 或 "" 不用密码
	private String ownerPsw; // 作者密码 null 或 "" 不用密码
	private List permissionList; // 权限列表 ,参考PdfWriter常量 如：ALLOW_COPY

	/**
	 * 构造函数
	 */
	public PdfBean() {

	}

	/**
	 * html时用到
	 * 
	 * @param headerMap
	 *            Map
	 */
	public PdfBean(Map headerMap) {
		headerMap.put("Expires", 0);
		this.headerMap = headerMap;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords
	 *            the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return the headerMap
	 */
	public Map getHeaderMap() {
		return headerMap;
	}

	/**
	 * @param headerMap
	 *            the headerMap to set
	 */
	public void setHeaderMap(Map headerMap) {
		this.headerMap = headerMap;
	}

	/**
	 * @return the elementList
	 */
	public List<Element> getElementList() {
		return elementList;
	}

	/**
	 * @param elementList
	 *            the elementList to set
	 */
	public void setElementList(List<Element> elementList) {
		this.elementList = elementList;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * @return the footer
	 */
	public String getFooter() {
		return footer;
	}

	/**
	 * @param footer
	 *            the footer to set
	 */
	public void setFooter(String footer) {
		this.footer = footer;
	}

	/**
	 * @return the encryptFlag
	 */
	public boolean isEncryptFlag() {
		return encryptFlag;
	}

	/**
	 * @param encryptFlag
	 *            the encryptFlag to set
	 */
	public void setEncryptFlag(boolean encryptFlag) {
		this.encryptFlag = encryptFlag;
	}

	/**
	 * @return the userPsw
	 */
	public String getUserPsw() {
		return userPsw;
	}

	/**
	 * @param userPsw
	 *            the userPsw to set
	 */
	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	/**
	 * @return the ownerPsw
	 */
	public String getOwnerPsw() {
		return ownerPsw;
	}

	/**
	 * @param ownerPsw
	 *            the ownerPsw to set
	 */
	public void setOwnerPsw(String ownerPsw) {
		this.ownerPsw = ownerPsw;
	}

	/**
	 * @return the permissionList
	 */
	public List getPermissionList() {
		return permissionList;
	}

	/**
	 * @param permissionList
	 *            the permissionList to set
	 */
	public void setPermissionList(List permissionList) {
		this.permissionList = permissionList;
	}
}
