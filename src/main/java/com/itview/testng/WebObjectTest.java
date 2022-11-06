package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class WebObjectTest {
	
	WebDriver w;

	@BeforeTest
	public void beforeTest() {
		
		 WebDriverManager.chromedriver().setup();
		   w=new ChromeDriver();
	}

	@Test(priority = 0,description = "Test case to handle text field")
	public void handleTextField() {
		
		w.get("https://demo.automationtesting.in/Register.html");
		
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Steve");
		
		w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Jones");
	
	
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("121/B-1 Sample Address");
	
	}
	
	@Test(priority = 1,description = "Test case to handle radiobutton and checkbox")
	public void handleRadiobuttonCheckbox() {
		
		w.findElement(By.cssSelector("input[value='FeMale']")).click();
		
		w.findElement(By.id("checkbox1")).click();
		w.findElement(By.id("checkbox3")).click();
		
	}
	
	@Test(priority = 2,description = "Test case to handle DropDown List")
	public void handleDropDownList() {
		
		WebElement skillsDropDown=w.findElement(By.id("Skills"));	
		
		Select sel=new Select(skillsDropDown);
		//sel.selectByIndex(9);
		//sel.selectByValue("APIs");
		sel.selectByVisibleText("Java");
		
		WebElement months=w.findElement(By.cssSelector("select[ng-model='monthbox']"));		
		Select selMonth=new Select(months);
		
		List<WebElement> monthsValue=selMonth.getOptions();
		
		/*
		for(int i=0;i<monthsValue.size();i++) {
		  
		System.out.println(monthsValue.get(i).getText()); }
		 */
		
		Iterator<WebElement> iterator=monthsValue.iterator();
		
		while(iterator.hasNext()) {
			
			System.out.println(iterator.next().getText());
		}
		
		
		
	}

	@AfterTest
	public void afterTest() {
	}

}
