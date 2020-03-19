/**
 * 文件名：ReportExcelExtend.java
 * 创建日期： 2012-6-4
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改人：
 *   修改内容：
 */
package com.grgbanking.platform.core.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description：excel导出from模板<br>
 * 
 * @author Jonas.zhang Create Time：2011-9-22
 * @version 1.0
 */
@SuppressWarnings( { "rawtypes", "unchecked" })
public class ReportExcelExtend {
	/** 日志对象 */
	protected static Logger logger = LoggerFactory.getLogger(ReportExcelExtend.class);

	/**
	 * 获取excel模板
	 * 
	 * @param modelName
	 *            模板路径
	 * @return HSSFWorkbook 返回模板excel
	 * @throws Exception
	 */
	public HSSFWorkbook initExcelModel(String modelName) throws Exception {
		HSSFWorkbook templatewb = null;
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(modelName));
		templatewb = new HSSFWorkbook(fs);
		return templatewb;
	}

	/**
	 * 报表插入title/也可用于插入其他字段，如日期等
	 * 
	 * @param templatewb
	 *            报表模板workbook，来自InitExcelModel函数返回值
	 * @param sheet
	 *            工作表序列-从0开始
	 * @param title
	 *            报表标题
	 * @param titlestylerow
	 *            报表模板标题样式行，若为-1则无样式-从0开始
	 * @param titlestylecolume
	 *            报表模板标题样式列，从0开始
	 * @param i
	 *            行-从0开始
	 * @param j
	 *            列-从0开始
	 * @return HSSFWorkbook 返回模板excel
	 * @throws Exception
	 */
	public HSSFWorkbook insertExcelTitle(HSSFWorkbook templatewb, int sheet, int titlestylerow, int titlestylecolume,
			String title, int i, int j) throws Exception {

			HSSFSheet templateSheet = templatewb.getSheetAt(sheet);
			if (titlestylerow == -1) {
				HSSFRow hssfRow = templateSheet.createRow(i);
				HSSFCell cell = hssfRow.createCell(j);
				cell.setCellValue(title);
			} else {
				HSSFRow templateRow = templateSheet.getRow(titlestylerow);
				HSSFCell templateCelldate = templateRow.getCell(titlestylecolume);
				HSSFRow hssfRow = templateSheet.createRow(i);
				HSSFCell cell = hssfRow.createCell(j);
				cell.setCellStyle(templateCelldate.getCellStyle());
				cell.setCellValue(title);
		}
		return templatewb;
	}

	/**
	 * 报表更新title/也可用于更新其他字段，如日期等
	 * 
	 * @param templatewb
	 *            报表模板workbook，来自InitExcelModel函数返回值
	 * @param sheet
	 *            工作表序列-从0开始
	 * @param title
	 *            报表标题
	 * @param i
	 *            行-从0开始-注意模板该行已有相应的style，否则请使用insert
	 * @param j
	 *            列-从0开始-注意模板该列已有相应的style，否则请使用insert
	 * @return HSSFWorkbook 返回模板excel
	 * @throws Exception
	 */
	public HSSFWorkbook updateExcelTitle(HSSFWorkbook templatewb, int sheet, String title, int i, int j)
 throws Exception {
			HSSFSheet templateSheet = templatewb.getSheetAt(sheet);
			HSSFRow templateRow = templateSheet.getRow(i);
			HSSFCell templateCelldate = templateRow.getCell(j);
			templateCelldate.setCellValue(title);

		return templatewb;
	}

	/**
	 * 新sheet中插入列表栏
	 * 
	 * @param rowspecify
	 *            列表说明栏行数，在新sheet的data值上将自动复制columespecify做为列表说明栏
	 *            若columespecify为-1，则不自动插入列表说明栏，请使用InsertExcelTitle自行插入列表说明栏
	 * @param columespecify
	 *            列表说明栏起始列-列数应和数据列数和样式列数相等
	 */
	public HSSFWorkbook insertColumeSpecify(HSSFWorkbook templatewb, int stylesheet, int tosheet, int rowspecify,
 int columespecify,
			int i, int j) {
			HSSFSheet templateSheet = templatewb.getSheetAt(stylesheet);
			HSSFRow templateRow = templateSheet.getRow(rowspecify);
			HSSFSheet sheet = templatewb.getSheetAt(0);
			if (tosheet != 0) {
				sheet = templatewb.createSheet("sheet" + String.valueOf(tosheet + 1));
			}
			for (int columnId = j; columnId < (j + templateRow.getPhysicalNumberOfCells()); columnId++) {
				HSSFCell templateCell = templateRow.getCell((columnId - j));
				HSSFRow hssfRow = sheet.createRow(i);
				HSSFCell cell = hssfRow.createCell(columnId);
				cell.setCellStyle(templateCell.getCellStyle());
				cell.setCellValue(templateCell.getStringCellValue());
		}
		return templatewb;
	}

	public HSSFCellStyle[] getDataCellStyle(HSSFWorkbook templatewb, int stylesheet, int stylerow, int stylecolume) {
		HSSFSheet templateSheet = templatewb.getSheetAt(stylesheet);
		HSSFRow templateRow = templateSheet.getRow(stylerow);
		HSSFCellStyle[] styles = new HSSFCellStyle[templateRow.getPhysicalNumberOfCells()];
		for (int i = stylecolume; i < templateRow.getPhysicalNumberOfCells(); i++) {
			styles[i] = templateRow.getCell(i).getCellStyle();
		}
		return styles;
	}

	public HSSFCellStyle[] getDataCellStyleAddcash(HSSFWorkbook templatewb, int stylesheet, int stylerow,
			int stylecolume) {
		HSSFSheet templateSheet = templatewb.getSheetAt(stylesheet);
		HSSFRow templateRow = templateSheet.getRow(stylerow);
		HSSFCellStyle[] styles = new HSSFCellStyle[templateRow.getPhysicalNumberOfCells()];
		for (int i = stylecolume; i < templateRow.getPhysicalNumberOfCells(); i++) {
			styles[i] = templateRow.getCell(i).getCellStyle();
		}
		return styles;
	}

	/**
	 * 报表更新data
	 * 
	 * @param templatewb
	 *            报表模板workbook，来自InitExcelModel函数返回值
	 * @param sheet
	 *            工作表序列-从0开始-注意此工作表已存在
	 * @param styles
	 *            数据列表样式，来自getDataCellStyle函数返回值
	 * @param stylerow
	 *            样式数据行-数据栏在样式工作表中的行数
	 * @param stylecolume
	 *            样式数据列-数据栏在样式工作表中的起始列数，注意样式列数应与数据列数相等
	 * @param dataList
	 *            数据list
	 * @param i
	 *            行-从0开始
	 * @param j
	 *            列-从0开始
	 * @return HSSFWorkbook 返回模板excel
	 * @throws Exception
	 */
	public HSSFWorkbook updateExcelData(HSSFWorkbook templatewb, HSSFCellStyle[] styles, int sheet, List dataList,
			int i, int j) throws Exception {
		try {
			HSSFSheet tosheet = templatewb.getSheetAt(sheet);
			int size = dataList.size();
			if (size > 30000) {
				size = 30000 - i;
			}
			for (int rowId = 1; rowId <= size; rowId++) {
				Object[] valueList = (Object[]) dataList.get(rowId - 1);
				for (int columnId = j; columnId < (j + valueList.length); columnId++) {
					// String dataValue = String.valueOf(valueList[columnId]);
					HSSFRow hssfRow = tosheet.createRow(rowId + i - 1);
					Object dataValue = valueList[columnId];
					HSSFCell cell = hssfRow.createCell(columnId);
					cell.setCellStyle(styles[columnId - j]);
					if (dataValue instanceof Long) {
						cell.setCellValue((Long) dataValue);
					} else if (dataValue instanceof Double) {
						cell.setCellValue((Double) dataValue);
					} else if (dataValue instanceof Date) {
						cell.setCellValue((Date) dataValue);
					} else if (dataValue == null) {
						cell.setCellValue("");
					} else {
						cell.setCellValue(String.valueOf(dataValue));
					}
				}
			}
		} catch (OutOfMemoryError e) {
			logger.error("Data exceeded error!", e);
		}
		return templatewb;
	}

	/**
	 * add by : zyding
	 * 
	 * @param templatewb
	 *            HSSFWorkbook
	 * @param styles
	 *            HSSFCellStyle[]
	 * @param sheet
	 *            int
	 * @param dataList
	 *            List
	 * @param i
	 *            int
	 * @param j
	 *            int
	 * @return HSSFWorkbook
	 * @throws Exception
	 */
	public HSSFWorkbook updateExcelDataAddcash(HSSFWorkbook templatewb, HSSFCellStyle[] styles, int sheet,
			List dataList, int i, int j) throws Exception {
		try {
			HSSFSheet tosheet = templatewb.getSheetAt(sheet);
			int size = dataList.size();
			if (size > 30000) {
				size = 30000 - i;
			}
			for (int rowId = 1; rowId <= size; rowId++) {
				Object[] valueList = (Object[]) dataList.get(rowId - 1);
				HSSFRow hssfRow = tosheet.createRow(rowId + i - 1);
				for (int columnId = j; columnId < (j + valueList.length); columnId++) {
					String dataValue = String.valueOf(valueList[columnId]);
					hssfRow.setHeightInPoints(25); // 设置行高
					HSSFCell cell = hssfRow.createCell(columnId);
					cell.setCellStyle(styles[columnId - j]);
					if (valueList[columnId] != null && valueList[columnId] instanceof Integer) {
						cell.setCellValue(Long.valueOf(dataValue));
					} else {
						cell.setCellValue(dataValue);
					}
				}
			}
		} catch (OutOfMemoryError e) {
			logger.error("Data exceeded error!", e);
		}
		return templatewb;
	}

	/**
	 * 输出excel
	 * 
	 * @param templatewb
	 *            workbook
	 * @param os
	 *            输出文件流
	 */
	public void outputExcel(HSSFWorkbook templatewb, OutputStream os) {

		try {
			templatewb.write(os);
			os.flush();
			os.close();
		} catch (IOException e) {
			logger.error("output Excel error!", e);
		}
	}

	/**
	 * 输出excel
	 * 
	 * @param templatewb
	 *            workbook
	 * @param outputfile
	 *            输出文件路径
	 */
	public void outputExcelFile(HSSFWorkbook templatewb, String outputfile) {

		try {
			FileOutputStream fOut = new FileOutputStream(outputfile);
			templatewb.write(fOut);
			fOut.flush();
			fOut.close();
		} catch (FileNotFoundException e) {
			logger.error("output Excel file error!", e);
		} catch (IOException e) {
			logger.error("output Excel file error!", e);
		}
	}

	/**
	 * 根据现有需求封装的输出标准excel报表函数，若有特殊要求，请重写该函数
	 * 注意，模板建立时请至少建立六个或以上空白sheet，其中第一个sheet要包含如下格式：
	 * 第一行，标题行，设置好相应的样式，包括字体、颜色、有无边框、几列合并等 第二行，制表日期，设置好相应的样式 第三行，列表栏，设置好相应的样式
	 * 第四行，数据样式栏，设置好相应的样式，导出数据后，此行会被填充值，以后的数据行将复制此行的样式
	 * 
	 * @param modelName
	 *            模板路径
	 * @param outputFile
	 *            输出文件路径
	 * @param dataList
	 *            数据list
	 * @param startLine
	 *            数据起始行-注意模板的该起始行已有样式，且该起始行的上一行已有列表说明栏，默认从第0列开始插数据
	 * @param title
	 *            标题内容
	 * @param titlerow
	 *            标题行-注意模板的标题行已有样式，默认从第0列开始插数据
	 * @param date
	 *            制表日期
	 * @param daterow
	 *            日期行-注意模板的日期行已有样式，默认从第2列开始插数据
	 * @throws Exception
	 */
	public HSSFWorkbook createStandardExcelFromModel(String modelName, OutputStream os, List dataList, int startLine,
			String title, int titlerow, String date, int daterow) throws Exception {
		HSSFWorkbook templatewb = this.initExcelModel(modelName);
		templatewb = this.updateExcelTitle(templatewb, 0, title, titlerow, 0);
		templatewb = this.updateExcelTitle(templatewb, 0, date, daterow, 2);
		List templist = dataList;
		int sheetnum = dataList.size() / 30000;
		if (sheetnum * 30000 < dataList.size()) {
			sheetnum += 1;
		}
		if (sheetnum != 0) {
			HSSFCellStyle[] styles = this.getDataCellStyle(templatewb, 0, startLine, 0);
			for (int m = 0; m < sheetnum; m++) {
				if (m > 1) {
					for (int n = 0; n < 30000; n++) {
						templist.remove(0);
					}
					templatewb = this.insertColumeSpecify(templatewb, 0, m, 2, 0, 0, 0);
					if (templatewb == null) {
						break;
					}
					templatewb = this.updateExcelData(templatewb, styles, m, templist, 1, 0);
					if (templatewb == null) {
						break;
					}
				} else if (m == 1) {
					for (int n = 0; n < 30000 - startLine; n++) {
						templist.remove(0);
					}
					templatewb = this.insertColumeSpecify(templatewb, 0, m, 2, 0, 0, 0);
					if (templatewb == null) {
						break;
					}
					templatewb = this.updateExcelData(templatewb, styles, m, templist, 1, 0);
					if (templatewb == null) {
						break;
					}
				} else {
					templatewb = this.updateExcelData(templatewb, styles, 0, templist, startLine, 0);
					if (templatewb == null) {
						break;
					}
				}
			}
			if (templatewb != null) {
				for (int m = sheetnum; m < templatewb.getNumberOfSheets(); m++) {
					templatewb.removeSheetAt(sheetnum);
				}
			} else {
				templatewb = this.initExcelModel(modelName);
				for (int i = 1; i < templatewb.getSheetAt(0).getPhysicalNumberOfRows(); i++) {
					HSSFRow hssfRow = templatewb.getSheetAt(0).getRow(i);
					if (hssfRow != null) {
						templatewb.getSheetAt(0).removeRow(hssfRow);
					}
				}
				templatewb.getSheetAt(0).removeMergedRegion(0);
				templatewb = this.insertExcelTitle(templatewb, 0, -1, 0,
						"数据超出限制，请缩小导出范围！", 0, 0);
			}
		}
		return templatewb;
	}

	/**
	 * 根据现有需求封装的输出标准excel报表函数，若有特殊要求，请重写该函数
	 * 注意，模板建立时请至少建立六个或以上空白sheet，其中第一个sheet要包含如下格式：
	 * 第一行，标题行，设置好相应的样式，包括字体、颜色、有无边框、几列合并等 第二行，制表日期，设置好相应的样式 第三行，列表栏，设置好相应的样式
	 * 第四行，数据样式栏，设置好相应的样式，导出数据后，此行会被填充值，以后的数据行将复制此行的样式
	 * 
	 * @param modelName
	 *            模板路径
	 * @param outputFile
	 *            输出文件路径
	 * @param dataList
	 *            数据list
	 * @param startLine
	 *            数据起始行-注意模板的该起始行已有样式，且该起始行的上一行已有列表说明栏，默认从第0列开始插数据
	 * @throws Exception
	 */
	public HSSFWorkbook createStandardExcelFromModel(String modelName, OutputStream os, List dataList, int startLine)
			throws Exception {
		HSSFWorkbook templatewb = this.initExcelModel(modelName);
		// templatewb = this.UpdateExcelTitle(templatewb, 0, title, titlerow,
		// 0);
		// templatewb = this.UpdateExcelTitle(templatewb, 0, date, daterow, 2);
		List templist = dataList;
		int sheetnum = dataList.size() / 30000;
		if (sheetnum * 30000 < dataList.size()) {
			sheetnum += 1;
		}
		if (sheetnum != 0) {
			HSSFCellStyle[] styles = this.getDataCellStyle(templatewb, 0, startLine, 0);
			for (int m = 0; m < sheetnum; m++) {
				if (m > 1) {
					for (int n = 0; n < 30000; n++) {
						templist.remove(0);
					}
					templatewb = this.insertColumeSpecify(templatewb, 0, m, 2, 0, 0, 0);
					if (templatewb == null) {
						break;
					}
					templatewb = this.updateExcelDataAddcash(templatewb, styles, m, templist, 1, 0);
					if (templatewb == null) {
						break;
					}
				} else if (m == 1) {
					for (int n = 0; n < 30000 - startLine; n++) {
						templist.remove(0);
					}
					templatewb = this.insertColumeSpecify(templatewb, 0, m, 2, 0, 0, 0);
					if (templatewb == null) {
						break;
					}
					templatewb = this.updateExcelDataAddcash(templatewb, styles, m, templist, 1, 0);
					if (templatewb == null) {
						break;
					}
				} else {
					templatewb = this.updateExcelDataAddcash(templatewb, styles, 0, templist, startLine, 0);
					if (templatewb == null) {
						break;
					}
				}
			}
			if (templatewb != null) {
				for (int m = sheetnum; m < templatewb.getNumberOfSheets(); m++) {
					templatewb.removeSheetAt(sheetnum);
				}
			} else {
				templatewb = this.initExcelModel(modelName);
				for (int i = 1; i < templatewb.getSheetAt(0).getPhysicalNumberOfRows(); i++) {
					HSSFRow hssfRow = templatewb.getSheetAt(0).getRow(i);
					if (hssfRow != null) {
						templatewb.getSheetAt(0).removeRow(hssfRow);
					}
				}
				templatewb.getSheetAt(0).removeMergedRegion(0);
				templatewb = this.insertExcelTitle(templatewb, 0, -1, 0,
						"数据超出限制，请缩小导出范围！", 0, 0);
			}
		}
		return templatewb;
	}

	/**
	 * 根据现有需求封装的输出标准excel报表函数2，若有特殊要求，请重写该函数
	 * 注意，模板建立时请至少建立六个或以上空白sheet，其中第一个sheet要包含如下格式：
	 * 第一行，标题行，设置好相应的样式，包括字体、颜色、有无边框、几列合并等 第二行，制表日期，设置好相应的样式 第三行，列表栏，设置好相应的样式
	 * 第四行，数据样式栏，设置好相应的样式，导出数据后，此行会被填充值，以后的数据行将复制此行的样式
	 * 
	 * @param modelName
	 *            模板路径
	 * @param outputFile
	 *            输出文件路径
	 * @param dataList
	 *            数据list
	 * @param startLine
	 *            数据起始行-注意模板的该起始行已有样式，且该起始行的上一行已有列表说明栏，默认从第0列开始插数据
	 * @param title
	 *            标题内容
	 * @param titlerow
	 *            标题行-注意模板的标题行已有样式，默认从第0列开始插数据
	 * @param date
	 *            制表日期
	 * @param daterow
	 *            日期行-注意模板的日期行已有样式，默认从第2列开始插数据
	 * @param othercontent
	 *            制表日期后需要加入新的信息
	 * @param other
	 *            加入的列
	 * @throws Exception
	 */
	public HSSFWorkbook createStandardExcelFromModel(String modelName, OutputStream os, List dataList, int startLine,
			String title, int titlerow, String date, int daterow, String othercontent, int other) throws Exception {
		HSSFWorkbook templatewb = this.initExcelModel(modelName);
		templatewb = this.updateExcelTitle(templatewb, 0, title, titlerow, 0);
		templatewb = this.updateExcelTitle(templatewb, 0, date, daterow, 2);
		templatewb = this.updateExcelTitle(templatewb, 0, othercontent, daterow, other);
		List templist = dataList;
		int sheetnum = dataList.size() / 30000;
		if (sheetnum * 30000 < dataList.size()) {
			sheetnum += 1;
		}
		if (sheetnum != 0) {
			HSSFCellStyle[] styles = this.getDataCellStyle(templatewb, 0, startLine, 0);
			for (int m = 0; m < sheetnum; m++) {
				if (m > 1) {
					for (int n = 0; n < 30000; n++) {
						templist.remove(0);
					}
					templatewb = this.insertColumeSpecify(templatewb, 0, m, 2, 0, 0, 0);
					if (templatewb == null) {
						break;
					}
					templatewb = this.updateExcelData(templatewb, styles, m, templist, 1, 0);
					if (templatewb == null) {
						break;
					}
				} else if (m == 1) {
					for (int n = 0; n < 30000 - startLine; n++) {
						templist.remove(0);
					}
					templatewb = this.insertColumeSpecify(templatewb, 0, m, 2, 0, 0, 0);
					if (templatewb == null) {
						break;
					}
					templatewb = this.updateExcelData(templatewb, styles, m, templist, 1, 0);
					if (templatewb == null) {
						break;
					}
				} else {
					templatewb = this.updateExcelData(templatewb, styles, 0, templist, startLine, 0);
					if (templatewb == null) {
						break;
					}
				}
			}
			if (templatewb != null) {
				for (int m = sheetnum; m < templatewb.getNumberOfSheets(); m++) {
					templatewb.removeSheetAt(sheetnum);
				}
			} else {
				templatewb = this.initExcelModel(modelName);
				for (int i = 1; i < templatewb.getSheetAt(0).getPhysicalNumberOfRows(); i++) {
					HSSFRow hssfRow = templatewb.getSheetAt(0).getRow(i);
					if (hssfRow != null) {
						templatewb.getSheetAt(0).removeRow(hssfRow);
					}
				}
				templatewb.getSheetAt(0).removeMergedRegion(0);
				templatewb = this.insertExcelTitle(templatewb, 0, -1, 0,
						"数据超出限制，请缩小导出范围！", 0, 0);
			}
		}
		return templatewb;
	}
}
