package com.itview.testcases;

import org.testng.annotations.Test;

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

public class DataDrivenExcel {
	
	WebDriver w;
	
	FileInputStream fi;     
    XSSFWorkbook wb;    
    XSSFSheet sht;    
    XSSFRow row;    
    XSSFCell principleCell,roiCell,tenureCell,frequencyCell,executionResult;
    DataFormatter df;


	@BeforeTest
	public void beforeTest() throws Exception {
		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.manage().window().maximize();
		
		fi=new FileInputStream(".\\TestData\\FDCal.xlsx");	
		wb=new XSSFWorkbook(fi); 
		sht=wb.getSheetAt(0);	
		
		df=new DataFormatter();
		
	}

	@Test
	public void dataDrivenTest() throws Exception {

		w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

		w.findElement(By.id("wzrk-cancel")).click();
		
		int rowCount=sht.getLastRowNum();

		for(int i=1;i<=rowCount;i++) // i = rows
			{
			
			row=sht.getRow(i);
		
		   principleCell=row.getCell(0);
		   roiCell=row.getCell(1);
		   tenureCell=row.getCell(2);
		   frequencyCell=row.getCell(3);
		   executionResult=row.createCell(5);

		w.findElement(By.id("principal")).clear();
		w.findElement(By.id("principal")).sendKeys(df.formatCellValue(principleCell).toString());

		w.findElement(By.name("interest")).clear();
		w.findElement(By.id("interest")).sendKeys(df.formatCellValue(roiCell).toString());

		w.findElement(By.id("tenure")).clear();
		w.findElement(By.id("tenure")).sendKeys(df.formatCellValue(tenureCell).toString());

		WebElement tenurePeriod = w.findElement(By.id("tenurePeriod"));
		Select sel_tenurePeriod = new Select(tenurePeriod);
		sel_tenurePeriod.selectByVisibleText("year(s)");

		WebElement frequency = w.findElement(By.id("frequency"));
		Select sel_frequency = new Select(frequency);
		sel_frequency.selectByVisibleText(frequencyCell.toString());

		w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
		
		Thread.sleep(2000);
		
		String maturityValue=w.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
		
		System.out.println("Maturity Value for : "+principleCell+" is = "+maturityValue);
		
		executionResult.setCellValue("Passed");
		
		 //To write into Excel File
		FileOutputStream fo = new FileOutputStream(".\\TestData\\FDCal.xlsx");
		wb.write(fo);
		
		
		
		}

	}

	@AfterTest
	public void afterTest() throws Exception {

	w.close();
	wb.close();
	fi.close();
	
	}

}
