package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginOrangeHRM {
	 WebDriver w;
		
	  @BeforeTest
	  public void preCondition_openBrowser() {
		  
		   WebDriverManager.chromedriver().setup();
		   w=new ChromeDriver(); 		
	  }
	  
	  @Test(priority = 0,description = "verify Login functionality using 'Admin' user for OrangeHRM")
	  public void loginAdminOrangeHRM() throws Exception {  
			
			w.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Thread.sleep(2000);
			w.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
			w.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");		
			w.findElement(By.cssSelector("button[type='submit']")).click();
			Thread.sleep(2000);
			w.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
			Thread.sleep(2000);
			w.findElement(By.cssSelector("a.oxd-userdropdown-link")).click();
		  
	  
	  }


  @AfterTest
  public void postCondition_closeBrowser() {
  
	  w.quit();
  }

}
