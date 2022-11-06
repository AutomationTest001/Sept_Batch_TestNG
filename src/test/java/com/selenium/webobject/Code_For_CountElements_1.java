package com.selenium.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_CountElements_1 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();
		   w=new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test(priority = 0, description = "Test case to Count WebElements ")
	public void CountWebElement() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);

		// Count number of radio button on web page.
		
		List<WebElement> radioButton=w.findElements(By.name("radiooptions"));
		System.out.println(" Count  of radio button : "+radioButton.size());
		
		
		// Count number of checkBox on web page.
		
		List<WebElement> checkBox=w.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(" Count  of checkBox : "+checkBox.size());
		
		// Count number of drop down on web page.
		
		List<WebElement> dropDownList=w.findElements(By.tagName("select"));
		System.out.println(" Count  of dropDownList : "+dropDownList.size());
		
		// Count number of links on web page.
		
		List<WebElement> links=w.findElements(By.tagName("a"));
		System.out.println(" Count  of links : "+links.size());
		
	}

	@AfterTest
	public void afterTest() {

		//w.quit();
	}

}
