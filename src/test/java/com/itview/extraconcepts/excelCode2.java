package com.itview.extraconcepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelCode2 {

	public static void main(String[] args) throws Exception {
		
	DataFormatter df=new DataFormatter();

      FileInputStream fi=new FileInputStream(".\\TestData\\FDCal.xlsx");      
      XSSFWorkbook wb=new XSSFWorkbook(fi);
      
      XSSFSheet sht=wb.getSheetAt(0);
      
      XSSFRow row=sht.getRow(0);
      
      XSSFCell cell=row.getCell(0);
      
      System.out.println(cell);
      
      
      
      
		
	}

}
