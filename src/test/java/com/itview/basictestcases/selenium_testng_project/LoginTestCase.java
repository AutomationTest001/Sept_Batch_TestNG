package com.itview.basictestcases.selenium_testng_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase {

	public static void main(String[] args)throws Exception {
		
		//interfaceName instance=new implementClass();
		
		WebDriverManager.chromedriver().setup();
		WebDriver w=new ChromeDriver(); // open blank chrome browser
		
	//	Step 1 : Open application with url
		
		w.get("http://altoromutual.com:8080/login.jsp");
				
	//	Step 2 : Enter username
				
		w.findElement(By.id("uid")).sendKeys("admin");
		
	//	Step 3 : Enter Password
		
		w.findElement(By.id("passw")).sendKeys("admin");
		
	//	Step 4: Click login
		
		w.findElement(By.name("btnSubmit")).click();
		
	//	Step 5: Click Logout
		
		Thread.sleep(3000); // 3000 millisec = 3 sec		
		w.findElement(By.linkText("Sign Off")).click();
		
	//	Step 6 : Close 
		
		w.quit();
		
		System.out.println("Admin test cases passed !!!");
	}

}
