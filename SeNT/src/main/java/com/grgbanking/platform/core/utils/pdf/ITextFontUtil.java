/**
 * 文件名：ITextFontUtil.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils.pdf;

import java.awt.Color;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

/**
 * 
 * @author yrliang PDF字体处理
 */
public class ITextFontUtil {
	/** 日志对象 */
	protected static Logger logger = LoggerFactory
			.getLogger(ITextFontUtil.class);
	/**
	 * 新建一个字体,iText的方法 STSongStd-Light 是字体，在iTextAsian.jar 中以property为后缀
	 * UniGB-UCS2-H 是编码，在iTextAsian.jar 中以cmap为后缀 H 代表文字版式是 横版， 相应的 V 代表竖版
	 */
	private static String CHINA_FONT_SONGTI = "STSongStd-Light"; // 宋体
	private static String ENCODE_GB = "UniGB-UCS2-H"; // 中文编码GB（横版）

	/**
	 * 取得基本字体
	 * 
	 * @param font
	 *            font
	 * @param encode
	 *            encode
	 * @return BaseFont
	 */
	public static BaseFont getBaseFont(String font, String encode) {
		BaseFont bfChinese = null;

		try {
			bfChinese = BaseFont.createFont(font, encode, false);
		} catch (DocumentException e) {
			logger.error("create font error!", e);
		} catch (IOException e) {
			logger.error("create font error!", e);
		}

		return bfChinese;
	}

	/**
	 * 取得具体字体
	 * 
	 * @param baseFont
	 *            基本字体
	 * @param fontSize
	 *            字体大小 ，如12
	 * @param fontStyle
	 *            字体样式， 如com.lowagie.text.Font.BOLD(粗）， Font.ITALIC（斜），
	 *            Font.BOLDITALIC（粗斜）,Font.NORMAL(普通)
	 * @param color
	 *            字体颜色 ,如：java.awt.Color.BLACK ,Color.BLUE
	 * @return
	 */
	public static Font getFont(BaseFont baseFont, float fontSize,
			int fontStyle, Color color) {
		Font font = new Font(baseFont, fontSize, fontStyle,
				new BaseColor(color));
		return font;
	}

	/**
	 * 取得中文基本字体（横向）
	 * 
	 * @return
	 */
	public static BaseFont getCnBaseFont() {
		return getBaseFont(CHINA_FONT_SONGTI, ENCODE_GB);
	}

	/**
	 * 取得正常字体
	 * 
	 * @param fontSize
	 *            字体大小 ，如12
	 * @param color
	 *            字体颜色 ，如Color.BLACK
	 * @return
	 */
	public static Font getCnFont(float fontSize, Color color) {
		BaseFont bfCn = getCnBaseFont();
		Font boldFont = getFont(bfCn, fontSize, Font.NORMAL, color);
		return boldFont;
	}

	/**
	 * 取得加粗字体
	 * 
	 * @param fontSize
	 *            字体大小 ，如12
	 * @param color
	 *            字体颜色 ，如Color.BLACK
	 * @return
	 */
	public static Font getCnBoldFont(float fontSize, Color color) {
		BaseFont bfCn = getCnBaseFont();
		Font boldFont = getFont(bfCn, fontSize, Font.BOLD, color);
		return boldFont;
	}

	/**
	 * 取得斜体
	 * 
	 * @param fontSize
	 *            字体大小 ，如12
	 * @param color
	 *            字体颜色 ，如Color.BLACK
	 * @return
	 */
	public static Font getCnItalicFont(float fontSize, Color color) {
		BaseFont bfCn = getCnBaseFont();
		Font boldFont = getFont(bfCn, fontSize, Font.ITALIC, color);
		return boldFont;
	}

	/**
	 * 取得粗斜体
	 * 
	 * @param fontSize
	 *            字体大小 ，如12
	 * @param color
	 *            字体颜色 ，如Color.BLACK
	 * @return
	 */
	public static Font getCnBoldItalicFont(float fontSize, Color color) {
		BaseFont bfCn = getCnBaseFont();
		Font boldFont = getFont(bfCn, fontSize, Font.BOLDITALIC, color);
		return boldFont;
	}

	/**
	 * 取得下划线字体
	 * 
	 * @param fontSize
	 *            字体大小 ，如12
	 * @param color
	 *            字体颜色 ，如Color.BLACK
	 * @return
	 */
	public static Font getCnUnderlineFont(float fontSize, Color color) {
		BaseFont bfCn = getCnBaseFont();
		Font boldFont = getFont(bfCn, fontSize, Font.UNDERLINE, color);
		return boldFont;
	}

}
