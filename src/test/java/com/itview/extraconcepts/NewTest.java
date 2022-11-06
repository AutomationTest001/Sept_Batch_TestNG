package com.itview.extraconcepts;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class NewTest {

	WebDriver w;
	DataFormatter df=new DataFormatter();

	
	FileInputStream fi;     
    XSSFWorkbook wb;    
    XSSFSheet sht;    
    XSSFRow row;    
    XSSFCell principleCell,roiCell,tenureCell,frequencyCell;
    
    

	@BeforeTest
	public void beforeTest() throws Exception {
		
		 fi=new FileInputStream(".\\TestData\\FDCal.xlsx");      
	       wb=new XSSFWorkbook(fi);
	      
	       sht=wb.getSheetAt(0);
	      	      
	      
		
		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.manage().window().maximize();
	}

	@Test
	public void dataDrivenCode() throws Exception {
	
		w.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		w.findElement(By.id("wzrk-cancel")).click();

		
		int rowsCount=sht.getLastRowNum();
		
		for(int i=1;i<=rowsCount;i++)
		{
			row=sht.getRow(i);
			
			principleCell=row.getCell(0);
			roiCell=row.getCell(1);
			tenureCell=row.getCell(2);
			frequencyCell=row.getCell(3);

			
	    w.findElement(By.id("principal")).clear();
	    w.findElement(By.id("principal")).sendKeys(df.formatCellValue(principleCell).toString());

	    w.findElement(By.name("interest")).clear();
	    w.findElement(By.id("interest")).sendKeys(df.formatCellValue(roiCell).toString());

	    w.findElement(By.id("tenure")).clear();
	    w.findElement(By.id("tenure")).sendKeys(df.formatCellValue(tenureCell).toString());

	    WebElement tenurePeriod=w.findElement(By.id("tenurePeriod"));
        Select sel_tenurePeriod=new Select(tenurePeriod);
        sel_tenurePeriod.selectByVisibleText("year(s)");
        
	    
        WebElement frequency=w.findElement(By.id("frequency"));
        Select sel_frequency=new Select(frequency);
        sel_frequency.selectByVisibleText("Simple Interest");
	    
	
        w.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
        
        Thread.sleep(1000);
        
        XSSFCell cell = sht.getRow(i).createCell(5);          
        cell.setCellValue("PASS");
   

//To write into Excel File
FileOutputStream outputStream = new FileOutputStream(".\\TestData\\FDCal.xlsx");
wb.write(outputStream);

        
		}
	}

	@AfterTest
	public void afterTest() {

	//	w.close();
	}

}
