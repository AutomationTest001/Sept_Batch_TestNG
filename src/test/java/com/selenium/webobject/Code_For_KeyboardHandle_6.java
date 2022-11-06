package com.selenium.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_KeyboardHandle_6 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		WebDriverManager.chromedriver().setup();		 
		   w=new ChromeDriver();
		w.manage().window().maximize();	
	}

	@Test
	public void Code_For_KeyboardHandle_Test() throws Exception {
		
		Actions a=new Actions(w);
		
		w.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		w.findElement(By.id("firstName")).clear();		
		w.findElement(By.id("firstName")).sendKeys("JonesP");	
		
		Thread.sleep(2000);
		
		a.sendKeys(Keys.BACK_SPACE).build().perform();
		
		Thread.sleep(2000);
		
		a.sendKeys(Keys.TAB).build().perform();
		
		Thread.sleep(2000);

		
		w.findElement(By.name("lastName")).clear();
		w.findElement(By.name("lastName")).sendKeys("Smith");		
		
		a.sendKeys(Keys.TAB).build().perform();
		
		Thread.sleep(2000);

		
		a.sendKeys(Keys.TAB).build().perform();
		
		Thread.sleep(2000);


		a.sendKeys(Keys.TAB).build().perform();


		
		Thread.sleep(2000);
		a.sendKeys(Keys.ENTER).build().perform();	
		
		
		
	}

	@AfterTest
	public void afterTest() {
	}

}
