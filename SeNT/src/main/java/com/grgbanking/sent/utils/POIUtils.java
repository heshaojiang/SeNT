package com.grgbanking.sent.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class POIUtils {

	public static void createExcel() {
		try {
			/** Excel 文件要存放的位置，假定在D盘下 */
			String outputFile = "D:\\test.xls";

			// 创建新的Excel 工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 在Excel工作簿中建一工作表，其名为缺省值
			// 如要新建一名为"效益指标"的工作表，其语句为：
			HSSFSheet sheet = workbook.createSheet("效益指标");
			// HSSFSheet sheet = workbook.createSheet();
			// 在索引0的位置创建行（最顶端的行）
			HSSFRow row = sheet.createRow((short) 0);
			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell = row.createCell((short) 0);
			// 定义单元格为字符串类型
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 在单元格中输入一些内容
			cell.setCellValue("增加值");
			// 新建一输出文件流
			FileOutputStream fOut = new FileOutputStream(outputFile);
			// 把相应的Excel 工作簿存盘
			workbook.write(fOut);
			fOut.flush();
			// 操作结束，关闭文件
			fOut.close();
			System.out.println("文件生成...");
		} catch (Exception e) {
			System.out.println("已运行 xlCreate() : " + e);
		}

	}

	public static String makeExcelFile(List<Object[]> dataList, String modelName,
			String filePath) {
		HSSFWorkbook templatewb = null;
		int perSize = 10000;
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					modelName));
			templatewb = new HSSFWorkbook(fs);
		
//			int sheetNo = dataList.size() % perSize > 0 ? dataList.size()
//					/ perSize + 1 : dataList.size() / perSize;
			int sheetNo = dataList.size() / perSize + 1;
			for (int sheet = 0; sheet < sheetNo; sheet++) {
				
				HSSFSheet tosheet = null;
				try {// 超过默认标签数时，程序自动创建
					tosheet = templatewb.getSheetAt(sheet);
				} catch (Exception e) {
					tosheet = templatewb.createSheet("sheet" + (sheet + 1));
				}

				// data row
				int size = dataList.size();
//				HSSFRow templateRow = tosheet.getRow(1);
//				HSSFCellStyle[] styles = new HSSFCellStyle[templateRow
//						.getPhysicalNumberOfCells()];
//				for (int i = 0; i < templateRow.getPhysicalNumberOfCells(); i++) {
//					styles[i] = templateRow.getCell(i).getCellStyle();
//				}
				
				int rowSize = (sheet + 1) * perSize > size ? size : (sheet + 1) * perSize;
				
				for (int rowId = sheet * perSize; rowId < rowSize; rowId++) {

					Object[] valueList = (Object[]) dataList.get(rowId);
					
					int rowNum = 0;
					if(sheet==0){
						rowNum = rowId + 2;
					}else{
						rowNum = rowId - perSize*sheet;
					}
					HSSFRow hssfRow = tosheet.createRow(rowNum);
					for (int columnId = 0; columnId < valueList.length; columnId++) {
						
						String dataValue = String.valueOf(valueList[columnId]);
						HSSFCell cell = hssfRow.createCell(columnId);
						cell.setCellValue(dataValue);
					}
				}
			}
			// write data to new file
			OutputStream os = new FileOutputStream(new File(filePath));
			templatewb.write(os);
			os.flush();
			os.close();
		} catch (OutOfMemoryError e) {
			// logger.error("Data Exceeded!", e);
			return null;
		} catch (Exception ex) {
			// logger.error("", ex);
			return null;
		}
		return filePath;
	}
}
