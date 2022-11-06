package com.selenium.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;

public class Code_For_Screenshot_10 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();		 
		   w=new ChromeDriver();
		w.manage().window().maximize();
		
	}

	@Test
	public void Code_For_Screenshot() throws Exception {
			
		w.get("https://www.google.com/");
		
	   Thread.sleep(2000);
	   
	     TakesScreenshot ts=(TakesScreenshot)w;
	     File f=ts.getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(f, new File(".\\Screenshot\\GoogleSearchPage.png"));
	     
	     File f1=w.findElement(By.cssSelector("div.k1zIA.rSk4se")).getScreenshotAs(OutputType.FILE);
	     FileHandler.copy(f1, new File(".\\Screenshot\\GoogleSearchPage1.png"));
		
        
		/*
		  
		 * For FileUtils add dependencies in pom.xml.
		 
		  <dependency>
		  
		   <groupId>commons-io</groupId>
		 <artifactId>commons-io</artifactId> 
		 <version>2.6</version>
		 
		    </dependency>
		 
		 
		 * 
		 */

	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
