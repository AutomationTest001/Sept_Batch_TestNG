package com.selenium.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();

		w.manage().window().maximize();
	}

	@Test
	public void domObject() throws InterruptedException {

		w.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		w.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
        Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[5]/div/div/div/div")).click();
	
		JavascriptExecutor js=(JavascriptExecutor)w;
		js.executeScript("arguments[0].click();", w.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[5]/div/div/div/div")));
	
	}

	@AfterTest
	public void afterTest() {
	}

}
