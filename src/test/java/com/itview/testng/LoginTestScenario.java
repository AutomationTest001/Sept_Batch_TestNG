package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTestScenario {
	
  WebDriver w;
	
  @BeforeTest
  public void preCondition_openBrowser() {
	  
	   WebDriverManager.chromedriver().setup();
	   w=new ChromeDriver(); 		
  }
  
  @Test(priority = 0,description = "verify Login functionality using 'Admin' user",groups="Login",invocationCount = 1)
  public void loginAdmin() throws Exception {  
		
			w.get("http://altoromutual.com:8080/login.jsp");	
			w.findElement(By.id("uid")).sendKeys("admin");
			w.findElement(By.id("passw")).sendKeys("admin");
			w.findElement(By.name("btnSubmit")).click();
			Thread.sleep(3000); 		
			w.findElement(By.linkText("Sign Off")).click();
	  
	 }
    
  @Test(priority = 1,description = "verify Login functionality using 'tuser' user",dependsOnMethods = "loginAdmin",groups="Login",enabled = true)
  public void loginTestUser() throws Exception{  
		
			w.get("http://altoromutual.com:8080/login.jsp");	
			w.findElement(By.id("uid")).sendKeys("tuser");
			w.findElement(By.id("passw")).sendKeys("tuser");
			w.findElement(By.name("btnSubmit")).click();
			Thread.sleep(3000); 		
			w.findElement(By.linkText("Sign Off")).click();
	}

  @Test(priority = 2,description = "verify Login functionality using 'invalid' user",dependsOnMethods = "loginAdmin",groups="Login")
  public void loginInvalidUser() throws Exception{  
		
			w.get("http://altoromutual.com:8080/login.jsp");	
			w.findElement(By.id("uid")).sendKeys("invalid");
			w.findElement(By.id("passw")).sendKeys("tuser");
			w.findElement(By.name("btnSubmit")).click();
	}

  @AfterTest
  public void postCondition_closeBrowser() {
	  
	  w.quit();
  }
}
