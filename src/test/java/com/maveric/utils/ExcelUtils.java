package com.maveric.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Data");
		XSSFRow row = sh.createRow(0);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(123);
		cell = row.createCell(1);
		cell.setCellValue("133");
		row = sh.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue(true);
		wb.write(new FileOutputStream("src/test/resources/data/TestData.xlsx"));
		wb.close();
		}

}
