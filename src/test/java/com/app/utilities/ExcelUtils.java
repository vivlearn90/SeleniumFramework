package com.app.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String file, String sheetName) throws IOException {
		fi = new FileInputStream(file);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;

	}

	public static int getCellCount(String file, String sheetName, int rowNum) throws IOException {

		fi = new FileInputStream(file);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		return cellCount;
	}

	public static String getCellData(String file, String sheetName, int rowNum, int colNum) throws IOException {

		fi = new FileInputStream(file);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;

		try {
			DataFormatter df = new DataFormatter();
			String cellValue = df.formatCellValue(cell);
			return cellValue;
		} catch (Exception e) {
			data = "";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook.close();
		fi.close();
		return data;

	}

	public static void setCellData(String file, String sheetName, int rowNum, int colNum, String data)
			throws IOException {

		fi = new FileInputStream(file);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(colNum);
		cell.setCellValue(data);
		fo = new FileOutputStream(file);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();

	}

}
