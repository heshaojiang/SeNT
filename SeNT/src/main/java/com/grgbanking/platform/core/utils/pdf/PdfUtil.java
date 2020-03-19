/**
 * 文件名：PdfUtil.java
 * 创建日期： 2012-5-18
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils.pdf;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author yrliang Pdf处理
 */
@SuppressWarnings( { "rawtypes", "unchecked" })
public class PdfUtil {
	/** 日志对象 */
	protected static Logger logger = LoggerFactory.getLogger(PdfUtil.class);

	/**
	 * 导出PDF文档(最基本方法)到物理地址
	 * 
	 * @param content
	 *            需要显示的数据集合 ,集合中一定要放置符合javabean风格的类的对象。
	 * @param pdfPath
	 *            导出pdf文档路径
	 */
	public static void exportPdf(String content, String pdfPath) {
		Document document = null;
		OutputStream out = null;
		try {
			// 1.建立com.itextpdf.text.Document对象的实例
			document = new Document();
			// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
			out = new FileOutputStream(pdfPath);
			PdfWriter.getInstance(document, out);
			// 3.打开文档
			document.open();
			// 4.向文档中添加内容
			document.add(new Paragraph(content)); // 会中文乱码
		} catch (FileNotFoundException e) {
			logger.error("Can not found file: {}!", pdfPath);
		} catch (DocumentException e) {
			logger.error("Export pdf error!", e);
		} finally {
			document.close();// 5.关闭文档
			try {
				out.close();
			} catch (IOException e) {
				logger.error("Close output stream error!", e);
			}
		}
	}

	/**
	 * 导出一段话的pdf到物理地址
	 * 
	 * @param para
	 * @param pdfPath
	 */
	public static void exportPdf(Paragraph para, String pdfPath,
			boolean vertical) {
		Document doc = null;
		OutputStream out = null;

		try {
			// 1.建立com.itextpdf.text.Document对象的实例
			doc = buildDoc(vertical);
			// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
			out = new FileOutputStream(pdfPath);
			PdfWriter.getInstance(doc, out);
			// 3.打开文档
			doc.open();
			// 4.向文档中添加内容
			doc.add(para);
		} catch (FileNotFoundException e) {
			logger.error("Export pdf error!", e);
		} catch (DocumentException e) {
			logger.error("Export pdf error!", e);
		} finally {
			close(doc, out);// 5.关闭
		}
	}

	/**
	 * 导出PDF到物理地址
	 * 
	 * @param doc
	 *            Document
	 * @param element
	 *            Element
	 * @param pdfPath
	 *            pdfPath
	 */
	public static void exportPdf(Document doc, Element element, String pdfPath) {
		OutputStream out = null;

		try {
			// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
			out = new FileOutputStream(pdfPath);
			PdfWriter.getInstance(doc, out);
			// 3.打开文档
			doc.open();
			// 4.向文档中添加内容
			doc.add(element);
		} catch (FileNotFoundException e) {
			logger.error("Export pdf error!", e);
		} catch (DocumentException e) {
			logger.error("Export pdf error!", e);
		} finally {
			close(doc, out);
		}

	}

	/**
	 * 导出pdf到物理地址
	 * 
	 * @param doc
	 *            Document
	 * @param pdfBean
	 *            PdfBean
	 */
	public static void exprotPdf(Document doc, PdfBean pdfBean) {
		OutputStream out = null;

		try {
			// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
			out = new FileOutputStream(pdfBean.getFileName());
			PdfWriter writer = gerPdfWriter(doc, out);
			doc = setPdfProperty(doc, pdfBean); // 设置属性

			// 加密处理
			if (pdfBean.isEncryptFlag()) {
				List permissionList = pdfBean.getPermissionList();
				if (permissionList != null && permissionList.size() > 0) {
					int allPermission = 0;
					for (Iterator it = permissionList.iterator(); it.hasNext();) {
						int permission = (Integer) it.next();
						allPermission = allPermission | permission; // 有或运算来累加权限
					}
					writer = encrypt(writer, pdfBean.getUserPsw(), pdfBean
							.getOwnerPsw(), allPermission);
				}
			}
			// 3.打开文档
			doc.open();

			// 4.向文档中添加内容
			List elementList = pdfBean.getElementList();
			if (elementList != null && !elementList.isEmpty()) {
				for (Iterator it = elementList.iterator(); it.hasNext();) {
					Element element = (Element) it.next();
					doc.add(element);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("Export pdf error!", e);
		} catch (DocumentException e) {
			logger.error("Export pdf error!", e);
		} finally {
			close(doc, out);// 5.关闭
		}
	}

	/**
	 * 导出pdf到url*
	 * 
	 * @param doc
	 *            Document
	 * @param pdfBean
	 *            PdfBean
	 * @param response
	 *            HttpServletResponse
	 */
	public static void exprotPdfToUrl(Document doc, PdfBean pdfBean,
			HttpServletResponse response) {
		ByteArrayOutputStream bao = null;
		ServletOutputStream out = null;

		try {
			// 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
			bao = new ByteArrayOutputStream();
			PdfWriter writer = gerPdfWriter(doc, bao);
			doc = setPdfProperty(doc, pdfBean); // 设置属性
			// 加密处理
			if (pdfBean.isEncryptFlag()) {
				List permissionList = pdfBean.getPermissionList();
				if (permissionList != null && permissionList.size() > 0) {
					int allPermission = 0;
					for (Iterator it = permissionList.iterator(); it.hasNext();) {
						int permission = (Integer) it.next();
						allPermission = allPermission | permission; // 有或运算来累加权限
					}
					writer = encrypt(writer, pdfBean.getUserPsw(), pdfBean
							.getOwnerPsw(), allPermission);
				}
			}
			// 3.打开文档
			doc.open();
			// 4.向文档中添加内容
			List elementList = pdfBean.getElementList();
			if (elementList != null && !elementList.isEmpty()) {
				for (Iterator it = elementList.iterator(); it.hasNext();) {
					Element element = (Element) it.next();
					doc.add(element);
				}
			}
			doc.close(); // 关闭document

			// response设置
			response.setContentType("application/pdf");

			/* =====添加下面一段，点击提示“另存为”，否则直接在浏览器中打开 start ===== */
			// response.setHeader("Content-Disposition",
			// "attachment;filename=\"temp.pdf\"");
			// response.setHeader("Cache-Control",
			// "must-revalidate, post-check=0, pre-check=0");
			// response.setHeader("Pragma", "public");
			// response.setDateHeader("Expires", (System.currentTimeMillis() +
			// 1000));
			/* ====添加下面一段，点击提示“另存为”，否则直接在浏览器中打开 end ====== */
			response.setContentLength(bao.size());
			out = response.getOutputStream();
			bao.writeTo(out);
			out.flush();
		} catch (DocumentException e) {
			logger.error("Export pdf error!", e);
		} catch (IOException e) {
			logger.error("Export pdf error!", e);
		} finally {
			try {
				bao.close();
				out.close();
			} catch (IOException e) {
				logger.error("Export pdf error!", e);
			}

		}
	}

	/**
	 * 块，PDF中，最小的单位
	 * 
	 * @param content
	 *            内容
	 * @param font
	 *            字体
	 * @return Chunk
	 */
	public static Chunk getChunk(String content, Font font) {
		Chunk chunk = new Chunk(content, font);
		return chunk;
	}

	/**
	 * 短句
	 * 
	 * @param content
	 *            内容
	 * @param font
	 *            字体
	 * @return Phrase
	 */
	public static Phrase getPhrase(String content, Font font) {
		Phrase phrase = new Phrase(content, font);
		return phrase;
	}

	/**
	 * 设置字段
	 * 
	 * @param content
	 *            内容
	 * @param font
	 *            字体
	 * @return Paragraph
	 */
	public static Paragraph getPara(String content, Font font) {
		Paragraph para = new Paragraph(content, font);
		return para;
	}

	/**
	 * 设定锚点（超链接）
	 * 
	 * @param content
	 *            内容
	 * @param font
	 *            字体
	 * @param url
	 *            ,如http://www.baidu.com 或者 #aim
	 * @return Anchor
	 */
	public static Anchor getAnchor(String content, Font font, String url) {
		Anchor anchor = new Anchor(content, font);
		anchor.setReference(url);
		return anchor;
	}

	/**
	 * 设定列表
	 * 
	 * @param list
	 *            数据
	 * @param numbered
	 *            true 数字列表， false 图标列表
	 * @param symbolIndent
	 *            缩进 true-20 false-10
	 * @param font
	 *            字体
	 * @return List
	 */
	public static com.itextpdf.text.List getPdfList(List list,
			boolean numbered, float symbolIndent, Font font) {
		com.itextpdf.text.List pdfList = new com.itextpdf.text.List(numbered,
				symbolIndent);
		ListItem li = null;
		if (list != null && !list.isEmpty()) {
			for (Iterator it = list.iterator(); it.hasNext();) {
				li = new ListItem(it.next().toString(), font);
				pdfList.add(li);
			}
		}
		return pdfList;
	}

	/**
	 * 设定注释(以右下角有顶点坐标（0,0)
	 * 
	 * @param title
	 *            名称
	 * @param text
	 *            内容
	 * @param x
	 *            lower left x pdf页面，下端，距左边多少px， 如100， （x, y)相当于（100， 0）
	 * @param y
	 *            upper right y
	 * @return Annotation
	 */
	public static Annotation getAnnotation(String title, String text, float x,
			float y) {
		Annotation anno = new Annotation(title, text, x, 0f, 0f, y);
		return anno;
	}

	/**
	 * url注释(一个块内有url链接）
	 * 
	 * @param url
	 *            链接
	 * @param llx
	 *            x
	 * @param lly
	 *            y
	 * @param urx
	 *            x
	 * @param ury
	 *            y
	 * @return Annotation
	 */
	public static Annotation getAnnotationUrl(float llx, float lly, float urx,
			float ury, String url) {
		Annotation anno = new Annotation(llx, lly, urx, ury, url);
		return anno;
	}

	/**
	 * 取得章（页），A Chapter is a special Section ，继承了Section 多new 几个，就几页
	 * 
	 * @param content
	 *            内容
	 * @param font
	 *            字体
	 * @param numberDepth
	 *            depth
	 * @return Chapter
	 */
	public static Chapter getChapter(String content, Font font, int numberDepth) {
		Paragraph p = getPara(content, font);
		Chapter chapter = new Chapter(p, numberDepth);
		return chapter;
	}

	/**
	 * 区域(包含其他区域，段落，列表，表格） A Section is a part of a Document containing other
	 * Sections, Paragraphs, List and/or PdfPTables
	 * 
	 * @param chapter
	 *            chapter
	 * @param content
	 *            内容
	 * @param font
	 *            字体
	 * @param numberDepth
	 *            注若为0, 就不显示层级数
	 * @return Section
	 */
	public static Section getSection(Chapter chapter, String content,
			Font font, int numberDepth) {
		Paragraph p = getPara(content, font);
		Section s = chapter.addSection(p, numberDepth);
		return s;
	}

	/**
	 * 区域(包含其他区域，段落，列表，表格） A Section is a part of a Document containing other
	 * Sections, Paragraphs, List and/or PdfPTables
	 * 
	 * @param content
	 *            内容
	 * @param font
	 *            字体
	 * @param numberDepth
	 *            ，注若为0, 就不显示层级数
	 * @return Section
	 */
	public static Section getSection(Section section, String content,
			Font font, int numberDepth) {
		Paragraph p = getPara(content, font);
		Section s = section.addSection(p, numberDepth);
		return s;
	}

	/**
	 * 设置图片对象
	 * 
	 * @param imgPath
	 *            图片物理地址
	 * @param alignMent
	 *            对齐方式 Image.RIGHT, MIDDLE, LEFT ,TEXTWRAP(环绕）, UNDERLYING(背景）
	 *            或以用｜并在一起用，如Image.RIGHT | Image.UNDERLYING
	 * @param absoluteX
	 *            横坐标
	 * @param absoluteY
	 *            纵坐标
	 * @return Image
	 */
	public static Image getImage(String imgPath, int alignMent,
			float absoluteX, float absoluteY) {
		Image img = null;

		try {
			img = Image.getInstance(imgPath);// 取得图片对象
			// 设置与文字对齐方式
			img.setAlignment(alignMent);// Image.RIGHT, MIDDLE, LEFT
			// ,TEXTWRAP(环绕）, UNDERLYING(背景）
			if (absoluteX != -1 && absoluteY != -1) {// 戓x, y均不等于－1
				img.setAbsolutePosition(absoluteX, absoluteY);// 设置绝对位置
			}
		} catch (BadElementException e) {
			logger.error("create image object error!", e);
		} catch (MalformedURLException e) {
			logger.error("create image object error!", e);
		} catch (IOException e) {
			logger.error("create image object error!", e);
		}
		return img;
	}

	/**
	 * 
	 * @return PdfPTable
	 */
	public static PdfPTable getPdfPTable() {
		PdfPTable table = null;
		float[] fl = { (float) 4.0, (float) 3.0 };
		table = new PdfPTable(fl);
		// .setsetsetAutoFillEmptyCells(true);没数据的cell为空table
		table.getDefaultCell().setPhrase(new Phrase(""));
		// table.addCell("a1", new Point(2, 2));
		// table.addCell("b1", new Point(4, 3));
		return table;
	}

	/**
	 * 
	 * @param tableBean
	 *            PdfPTableBean
	 * @param thFont
	 *            Font
	 * @param bodyFont
	 *            Font
	 * @return PdfPTable
	 */
	public static PdfPTable getPdfPTable(PdfPTableBean tableBean, Font thFont,
			Font bodyFont) {
		PdfPTable table = null;

		try {
			table = new PdfPTable(tableBean.getColumns()); // 生成table对象
			float[] fl = new float[tableBean.getColumns()];
			for (int i = 0; i < fl.length; i++) {
				fl[i] = tableBean.getWidth();
			}
			table.setWidths(fl); // 宽度
			table.getDefaultCell().setBorderWidth(tableBean.getBorderWidth()); // 边框宽度
			table.getDefaultCell().setBorderColor(
					new BaseColor(tableBean.getBorderColor())); // 边框color
			table.getDefaultCell().setPadding(tableBean.getCellPadding()); // 单元格内边距
			table.setSpacingBefore(tableBean.getCellSpacing()); // 单元格外边距
			table.getDefaultCell().setHorizontalAlignment(
					tableBean.getAlignMent()); // table对齐方式
			// 增加表头
			table = getPdfPTableTh(table, tableBean.getThList(), thFont);
			// 增加表数据
			table = getPdfPTableBody(table, tableBean.getBodyList(), bodyFont);
			// table.setLastHeaderRow(2);// 设置跨页时，表头还在
		} catch (DocumentException e) {
			logger.error("create pdf table error!", e);
			}

		return table;
	}

	/**
	 * 封装表头th
	 * 
	 * @param table
	 *            table
	 * @param thList
	 *            th
	 * @param cnBoldFont
	 *            字体
	 * @return PdfPTable
	 */
	public static PdfPTable getPdfPTableTh(PdfPTable table,
			List<String> thList, Font cnBoldFont) {
		PdfPCell cell = null;

		if (thList != null && !thList.isEmpty()) {
				for (Iterator it = thList.iterator(); it.hasNext();) {
					String thName = (String) it.next();
					// Chunk thChunk = getChunk(thName, cnBoldFont);
					cell = new PdfPCell(new Phrase(thName, cnBoldFont));
				cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);// 横向距中
					cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
				cell.setBackgroundColor(new BaseColor(239, 219, 150)); // 背景#EFDB96
				// 土黄色
					table.addCell(cell);
				// cell.getTable().setHeaderRows(1); // 设为头部
				// cell.setHeader(true); // 设为头部
				}
			}
		 
		return table;
	}

	/**
	 * 
	 * @param table
	 *            PdfPTable
	 * @param bodyList
	 *            List<List>
	 * @param cnFont
	 *            Font
	 * @return PdfPTable
	 */
	public static PdfPTable getPdfPTableBody(PdfPTable table,
			List<List> bodyList, Font cnFont) {
		PdfPCell cell = null;

			if (bodyList != null && !bodyList.isEmpty()) {
				int i = 1;
				for (Iterator it = bodyList.iterator(); it.hasNext(); i++) {
					List rowList = (List) it.next();
					if (rowList != null && !rowList.isEmpty()) {
						for (Iterator it2 = rowList.iterator(); it2.hasNext();) {
							String cellContent = (String) it2.next();
							Paragraph tdPara = new Paragraph(cellContent,
									cnFont);
							cell = new PdfPCell(tdPara);
						cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);// 横向距中
							// cell.setVerticalAlignment(PdfPCell.ALIGN_TOP);
							if (i % 2 == 0) {
								cell.setBackgroundColor(new BaseColor(
new Color(
									240, 240, 240))); // 背景
								// #F0F0F0
							}
							table.addCell(cell);
						}
					}
				}
			}

		return table;
	}

	/**
	 * 创建doc ,true 是竖的pdf， false——横向pdf
	 * 
	 * @param vertical
	 *            vertical方向
	 * @return Document
	 */
	public static Document buildDoc(boolean vertical) {
		Document doc = null;
		if (vertical) {// 竖的，默认
			doc = new Document();
		} else {// 横向
			doc = new Document(PageSize.A4.rotate());
		}
		return doc;
	}

	/**
	 * 设置pdf属性信息（必须用在pdfwriter之后）
	 * 
	 * @param doc
	 *            Document
	 * @param pdfBean
	 *            PdfBean
	 * @return Document
	 */
	public static Document setPdfProperty(Document doc, PdfBean pdfBean) {
		if (pdfBean.getTitle() != null) {
			doc.addTitle(pdfBean.getTitle()); // 标题
		}
		if (pdfBean.getSubject() != null) {
			doc.addSubject(pdfBean.getSubject());// 主题
		}
		if (pdfBean.getAuthor() != null) {
			doc.addAuthor(pdfBean.getAuthor()); // 作者
		}
		if (pdfBean.getKeywords() != null) {
			doc.addKeywords(pdfBean.getKeywords()); // 关键词
		}
		if (pdfBean.getCreator() != null) {
			doc.addCreator(pdfBean.getCreator()); // 创建人
		}
		if (pdfBean.getTitle() != null) {
			doc.addTitle(pdfBean.getTitle()); // 标题
		}
		Map headerMap = pdfBean.getHeaderMap();
		if (headerMap != null) {
			for (Iterator it = headerMap.entrySet().iterator(); it.hasNext();) {
				Object key = it.next();
				Object val = headerMap.get(key);
				doc.addHeader(key.toString(), val.toString());
			}
		}
		FileOutputStream out;
		try {
			out = new FileOutputStream(pdfBean.getFileName());
			PdfWriter writer = gerPdfWriter(doc, out);
			HeaderFooter headerFooter = (HeaderFooter) writer.getPageEvent();
			Font font = ITextFontUtil.getCnFont(12, Color.BLACK); // 设置字体
			if (pdfBean.getHeader() != null) {// 报头

				if (headerFooter == null) {
					headerFooter = new HeaderFooter(new Phrase(pdfBean
							.getHeader(), font), false); // false表示，没有含有数字（页码）
				}
				headerFooter.setHeaderPos(Element.ALIGN_LEFT);// 居中
				// header.setBorder(Rectangle.NO_BORDER);//设置边界宽度,默认是1
			}
			if (pdfBean.getFooter() != null) {// 报尾

				if (headerFooter == null) {
					headerFooter = new HeaderFooter(new Phrase(pdfBean
							.getHeader() == null ? "" : pdfBean.getHeader(),
							font), true); // false表示，没有含有数字（页码）
				}
				headerFooter.setPageNumberVisible(true);
				headerFooter.setFooterPos(Element.ALIGN_CENTER);
			}
			writer.setPageEvent(headerFooter);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("Can not found file: {}!", pdfBean.getFileName());
		}
		return doc;
	}

	/**
	 * 取得PdfWriter
	 * 
	 * @param doc
	 *            Document
	 * @param out
	 *            OutputStream
	 * @return PdfWriter
	 */
	public static PdfWriter gerPdfWriter(Document doc, OutputStream out) {
		PdfWriter writer = null;
		try {
			writer = PdfWriter.getInstance(doc, out);
		} catch (DocumentException e) {
			logger.error("Create PdfWriter error: {}!", e);
		}
		return writer;
	}

	/**
	 * pdf加密处理(bcprov-jdk15-139.jar 加密时用到)
	 * 
	 * @param writer
	 * @param userPsw
	 *            null或""，表示不用密码(读）
	 * @param ownerPsw
	 *            null或""，表示不用密码（写）
	 * @param permissions
	 *            ALLOW_SCREENREADERS 只读 PdfWriter.ALLOW_COPY 允许复制
	 *            PdfWriter.ALLOW_PRINTING 允许打印,其他叁考PdfWriter常量
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static PdfWriter encrypt(PdfWriter writer, String userPsw,
			String ownerPsw, int permissions) {
		try {
			writer.setEncryption(PdfWriter.STANDARD_ENCRYPTION_128, userPsw,
					ownerPsw, permissions);
		} catch (DocumentException e) {
			logger.error("set pdf encryption error!", e);
		}
		return writer;
	}

	/**
	 * 关闭doc,输出pdf内容
	 * 
	 * @param doc
	 *            Document
	 * @param out
	 *            OutputStream
	 */
	public static void close(Document doc, OutputStream out) {
		try {
			doc.close();// 关闭文档
			out.close();
		} catch (IOException e) {
			logger.error("close document error!", e);
		}
	}

}