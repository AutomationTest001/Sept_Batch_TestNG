package com.itview.basictestcases.selenium_testng_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase_XPATH {

	public static void main(String[] args)throws Exception {
		
		//interfaceName instance=new implementClass();
		
		WebDriverManager.chromedriver().setup();
		WebDriver w=new ChromeDriver(); // open blank chrome browser
		
		
		w.get("http://altoromutual.com:8080/login.jsp");
		
		w.findElement(By.xpath("//input[@id='uid']")).sendKeys("tuser");
		w.findElement(By.xpath("//input[@id='passw']")).sendKeys("tuser");
		
		w.findElement(By.xpath("//input[@value='Login']")).click();
				
			
		w.quit();
		
		System.out.println("tuser test cases passed !!!");
	}

}
