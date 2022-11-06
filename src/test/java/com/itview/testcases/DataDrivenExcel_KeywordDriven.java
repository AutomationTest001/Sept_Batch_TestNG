package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.FixedDepoist_PageObj;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DataDrivenExcel_KeywordDriven {

	FixedDepoist_PageObj fd = new FixedDepoist_PageObj();

	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sht;
	XSSFRow row;
	XSSFCell principleCell, roiCell, tenureCell, frequencyCell, executionResult;
	DataFormatter df;

	@BeforeTest
	public void beforeTest() throws Exception {

		fd.openBrowser(fd.readFromPropertiesFiles("browser"));
		fd.call_FixedDepoist_PageObj();

		fi = new FileInputStream(".\\TestData\\FDCal.xlsx");
		wb = new XSSFWorkbook(fi);
		sht = wb.getSheetAt(0);

		df = new DataFormatter();

	}

	@Test
	public void dataDrivenTest() throws Exception {

		fd.openApplication(fd.readFromPropertiesFiles("url_fd"));

		fd.handleClickEvent(fd.no_Thanks_Window);

		fd.waitForSec(2);

		int rowCount = sht.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) // i = rows
		{

			row = sht.getRow(i);

			principleCell = row.getCell(0);
			roiCell = row.getCell(1);
			tenureCell = row.getCell(2);
			frequencyCell = row.getCell(3);
			executionResult = row.createCell(5);

			fd.handleTextBox(fd.principalTxt, df.formatCellValue(principleCell).toString());
			fd.handleTextBox(fd.interestTxt, df.formatCellValue(roiCell).toString());
			fd.handleTextBox(fd.tenureTxt, df.formatCellValue(tenureCell).toString());
			fd.handleDropDown(fd.tenurePeriodDropDown, "year(s)");
			fd.handleDropDown(fd.frequencyDropDown, frequencyCell.toString());
			fd.handleClickEvent(fd.calculateBtn);
			fd.waitForSec(3);

			String maturityValue = fd.maturityValue.getText();
			System.out.println("Maturity Value for : " + principleCell + " is = " + maturityValue);

			executionResult.setCellValue("Passed");

			// To write into Excel File
			FileOutputStream fo = new FileOutputStream(".\\TestData\\FDCal.xlsx");
			wb.write(fo);

		}

	}

	@AfterTest
	public void afterTest() throws Exception {

		fd.closeBrowser();
		wb.close();
		fi.close();

	}

}
