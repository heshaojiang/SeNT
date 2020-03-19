/**
 * 文件名：PdfPTableBean.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils.pdf;

import java.awt.Color;
import java.util.List;

import com.itextpdf.text.pdf.PdfPTable;

/**
 * Pdf处理
 * 
 * @author yrliang
 */
@SuppressWarnings( { "rawtypes", "unchecked" })
public class PdfPTableBean {

	private int columns; // 列
	private float width = 100; // 宽度1－100 ,%为单位
	private float borderWidth = 1; // 边框宽度
	private Color borderColor = Color.BLACK; // 边框颜色
	private float cellSpacing; // cell 外边距
	private float cellPadding = 1; // cell 内边距
	private int alignMent = PdfPTable.ALIGN_CENTER; // 对齐方式
	private List<String> thList; // 表头
	private List<List> bodyList; // 表体

	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * @param columns
	 *            the columns to set
	 */
	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return the borderWidth
	 */
	public float getBorderWidth() {
		return borderWidth;
	}

	/**
	 * @param borderWidth
	 *            the borderWidth to set
	 */
	public void setBorderWidth(float borderWidth) {
		this.borderWidth = borderWidth;
	}

	/**
	 * @return the borderColor
	 */
	public Color getBorderColor() {
		return borderColor;
	}

	/**
	 * @param borderColor
	 *            the borderColor to set
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	/**
	 * @return the cellSpacing
	 */
	public float getCellSpacing() {
		return cellSpacing;
	}

	/**
	 * @param cellSpacing
	 *            the cellSpacing to set
	 */
	public void setCellSpacing(float cellSpacing) {
		this.cellSpacing = cellSpacing;
	}

	/**
	 * @return the cellPadding
	 */
	public float getCellPadding() {
		return cellPadding;
	}

	/**
	 * @param cellPadding
	 *            the cellPadding to set
	 */
	public void setCellPadding(float cellPadding) {
		this.cellPadding = cellPadding;
	}

	/**
	 * @return the alignMent
	 */
	public int getAlignMent() {
		return alignMent;
	}

	/**
	 * @param alignMent
	 *            the alignMent to set
	 */
	public void setAlignMent(int alignMent) {
		this.alignMent = alignMent;
	}

	/**
	 * @return the thList
	 */
	public List<String> getThList() {
		return thList;
	}

	/**
	 * @param thList
	 *            the thList to set
	 */
	public void setThList(List<String> thList) {
		this.thList = thList;
	}

	/**
	 * @return the bodyList
	 */
	public List<List> getBodyList() {
		return bodyList;
	}

	/**
	 * @param bodyList
	 *            the bodyList to set
	 */
	public void setBodyList(List<List> bodyList) {
		this.bodyList = bodyList;
	}
}