package com.itview.extraconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTestCases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver w=new ChromeDriver();
		w.get("http://altoromutual.com:8080/login.jsp");

		w.findElement(By.id("passw")).sendKeys("admin");
		
		w.findElement(RelativeLocator.with(By.id("uid")).above(By.id("passw"))).sendKeys("test");
		
		
	}

}
