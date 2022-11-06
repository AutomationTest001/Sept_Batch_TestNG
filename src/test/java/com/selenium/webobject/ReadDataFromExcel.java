package com.selenium.webobject;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static void main(String[] args) throws Exception {

		DataFormatter df = new DataFormatter();

		FileInputStream fi = new FileInputStream(".\\TestData\\FDCal.xlsx");// open .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(fi); // open workbook of .xlsx file = fi
		XSSFSheet sht = wb.getSheetAt(0);
		XSSFRow row = sht.getRow(2);
		XSSFCell cellValue = row.getCell(1);

		// System.out.println(df.formatCellValue(cellValue));

		int rowCount = sht.getLastRowNum();

		System.out.println(rowCount);
		
		row=sht.getRow(2);
		cellValue=row.createCell(5);

		cellValue.setCellValue("PASS");

        //To write into Excel File
		FileOutputStream outputStream = new FileOutputStream(".\\TestData\\FDCal.xlsx");
		wb.write(outputStream);

		wb.close();
		fi.close();

	}

}
