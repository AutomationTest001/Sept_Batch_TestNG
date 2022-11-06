package com.itview.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SoftAssertTest {
	
	  WebDriver w;
	  SoftAssert  sft;
		
	  @BeforeTest
	  public void preCondition_openBrowser() {
		  
		   WebDriverManager.chromedriver().setup();
		   w=new ChromeDriver(); 		
	  }
	  
	  @Test(priority = 0,description = "verify Login functionality using 'Admin' user",groups="Login")
	  public void loginAdmin() throws Exception {  
			
		  sft=new SoftAssert();
		  
				w.get("http://altoromutual.com:8080/login.jsp");	
				
				String currentPageTitle=w.getTitle();
				String currentPageURL=w.getCurrentUrl();				
				String loginPageLabel=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1")).getText();
				
				WebElement imageLoginPage=w.findElement(By.xpath("//*[@id=\"HyperLink1\"]/img"));
				
						
				sft.assertEquals(currentPageTitle, "Altoro Mutual");
				sft.assertEquals(currentPageURL, "http://altoromutual.com:8080/login.jsp");
				sft.assertTrue(loginPageLabel.contains("Login"), "Login page lebel doesn't contains 'Login'");
				sft.assertTrue(imageLoginPage.isDisplayed(), "Login Image not present");
				
				
				w.findElement(By.id("uid")).sendKeys("admin");
				w.findElement(By.id("passw")).sendKeys("admin");
				w.findElement(By.name("btnSubmit")).click();
			
				sft.assertAll();
		 }
	  
	  @Test(priority = 1,description = "verify Logout functionality using 'Admin' user",groups="Login",dependsOnMethods = "loginAdmin")
	  public void logoutAdmin() throws Exception {  
		  
		  sft=new SoftAssert();
		  
			Thread.sleep(3000); 
			
			String currentPageTitle=w.getTitle();
			String homePageLabel=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1")).getText();
			
			sft.assertEquals(currentPageTitle, "Altoro Mutual");
			sft.assertTrue(homePageLabel.contains("Admin"), "Home page lebel doesn't contains 'Admin'");
			
			
			w.findElement(By.linkText("Sign Off")).click();
			
			sft.assertAll();
	  
	  }
 

  @AfterTest
  public void postCondition_closeBrowser() {
	  
	  w.quit();
	  
  }

}
