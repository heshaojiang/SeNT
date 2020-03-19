/**
 * 文件名：HeaderFooter.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils.pdf;

import java.awt.Color;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

class HeaderFooter extends PdfPageEventHelper {

	private Phrase header;
	private Boolean pageNumberVisible = true;
	private String pageStr = "page";
	private Font headerFont;
	private Font footerFont;

	/**
	 * 头的内容是居左、居右、居中,0 是left,1是center,2是right
	 */
	private int headerAlign;
	/**
	 * 底部的内容是居左、居右、居中,0 是left,1是center,2是right
	 */
	private int footerAlign = 1;

	public HeaderFooter() {

	}

	public HeaderFooter(Phrase phrase, boolean pageNumberVisible) {
		// TODO Auto-generated constructor stub
		this.header = phrase;
		this.pageNumberVisible = pageNumberVisible;
	}

	public HeaderFooter(Phrase phrase, boolean pageNumberVisible, String pageStr) {
		// TODO Auto-generated constructor stub
		this.header = phrase;
		this.pageNumberVisible = pageNumberVisible;
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		Rectangle rect = writer.getBoxSize("art");
		if (rect == null) {
			rect = new Rectangle(56, 14, 559, 808);
			writer.setBoxSize("art", new Rectangle(56, 34, 559, 808));
		}
		if (header == null) {
			header = new Phrase("", headerFont);
		}
		switch (headerAlign) {
		case Element.ALIGN_LEFT:
			ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, header, rect.getLeft(), rect
					.getTop(), 0);
			break;
		case Element.ALIGN_CENTER:
			ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, header, rect.getLeft(), rect
					.getTop(), 0);
			break;
		case Element.ALIGN_RIGHT:
			ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, header, rect.getLeft(), rect
					.getTop(), 0);
			break;
		default:
			break;
		}

		if (pageNumberVisible) {
			switch (footerAlign) {
			case Element.ALIGN_LEFT:
				ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase(String.format(
						pageStr + " %d", writer.getPageNumber()), footerFont == null ? ITextFontUtil.getCnFont(12,
						Color.BLACK) : footerFont), (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);
				break;
			case Element.ALIGN_CENTER:
				ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(String.format(
						pageStr + " %d", writer.getPageNumber()), footerFont == null ? ITextFontUtil.getCnFont(12,
						Color.BLACK) : footerFont), (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);
				break;
			case Element.ALIGN_RIGHT:
				ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(String.format(
						pageStr + " %d", writer.getPageNumber()), footerFont == null ? ITextFontUtil.getCnFont(12,
						Color.BLACK) : footerFont), (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);
				break;
			default:
				break;
			}
		}
	}

	/**
	 * @return the phrase
	 */
	public Phrase getPhrase() {
		return header;
	}

	/**
	 * @param phrase
	 *            the phrase to set
	 */
	public void setPhrase(Phrase phrase) {
		this.header = phrase;
	}

	/**
	 * @return the pageNumberVisible
	 */
	public Boolean getPageNumberVisible() {
		return pageNumberVisible;
	}

	/**
	 * @param pageNumberVisible
	 *            the pageNumberVisible to set
	 */
	public void setPageNumberVisible(Boolean pageNumberVisible) {
		this.pageNumberVisible = pageNumberVisible;
	}

	/**
	 * @return the pageStr
	 */
	public String getPageStr() {
		return pageStr;
	}

	/**
	 * @param pageStr
	 *            the pageStr to set
	 */
	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}

	/**
	 * @return the headerPos
	 */
	public int getHeaderPos() {
		return headerAlign;
	}

	/**
	 * @param headerPos
	 *            the headerPos to set
	 */
	public void setHeaderPos(int headerPos) {
		this.headerAlign = headerPos;
	}

	public int getFooterPos() {
		return footerAlign;
	}

	public void setFooterPos(int footerPos) {
		this.footerAlign = footerPos;
	}

	/**
	 * @return the header
	 */
	public Phrase getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(Phrase header) {
		this.header = header;
	}

	/**
	 * @return the headerFont
	 */
	public Font getHeaderFont() {
		return headerFont;
	}

	/**
	 * @param headerFont
	 *            the headerFont to set
	 */
	public void setHeaderFont(Font headerFont) {
		this.headerFont = headerFont;
	}

	/**
	 * @return the footerFont
	 */
	public Font getFooterFont() {
		return footerFont;
	}

	/**
	 * @param footerFont
	 *            the footerFont to set
	 */
	public void setFooterFont(Font footerFont) {
		this.footerFont = footerFont;
	}
}