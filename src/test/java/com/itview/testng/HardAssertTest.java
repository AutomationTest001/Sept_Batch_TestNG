package com.itview.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssertTest {
	
	  WebDriver w;
		
	  @BeforeTest
	  public void preCondition_openBrowser() {
		  
		   WebDriverManager.chromedriver().setup();
		   w=new ChromeDriver(); 		
	  }
	  
	  @Test(priority = 0,description = "verify Login functionality using 'Admin' user",groups="Login")
	  public void loginAdmin() throws Exception {  
			
				w.get("http://altoromutual.com:8080/login.jsp");				
				String currentPageTitle=w.getTitle();
				String currentPageURL=w.getCurrentUrl();				
				String loginPageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
				WebElement imageLoginPage=w.findElement(By.xpath("//*[@id=\"HyperLink1\"]/img"));
				
						
				Assert.assertEquals(currentPageTitle, "Altoro Mutual");
				Assert.assertEquals(currentPageURL, "http://altoromutual.com:8080/login.jsp");
				Assert.assertTrue(loginPageLabel.contains("Login"), "Login page lebel doesn't contains 'Login'");
				Assert.assertTrue(imageLoginPage.isDisplayed(), "Login Image not present");
				
				
				w.findElement(By.id("uid")).sendKeys("admin");
				w.findElement(By.id("passw")).sendKeys("admin");
				w.findElement(By.name("btnSubmit")).click();
			
		 }
	  
	  @Test(priority = 1,description = "verify Logout functionality using 'Admin' user",groups="Login",dependsOnMethods = "loginAdmin")
	  public void logoutAdmin() throws Exception {  
		  
			Thread.sleep(3000); 
			
			String currentPageTitle=w.getTitle();
			String homePageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
			
			Assert.assertEquals(currentPageTitle, "Altoro Mutual");
			Assert.assertTrue(homePageLabel.contains("Admin"), "Home page lebel doesn't contains 'Admin'");
			
			
			w.findElement(By.linkText("Sign Off")).click();
	  
	  }
 

  @AfterTest
  public void postCondition_closeBrowser() {
	  
	  w.quit();
	  
  }

}
