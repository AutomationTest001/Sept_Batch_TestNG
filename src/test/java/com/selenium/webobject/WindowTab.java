package com.selenium.webobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTab {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();		 
		WebDriver  w=new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://demo.automationtesting.in/Register.html");		
		
		w.findElement(By.id("imagesrc")).sendKeys("C:\\Users\\Lenovo\\eclipse-workspace\\selenium-testng-project\\Screenshot\\SeleniumHomePage.png");
		
		
		

	}

}
