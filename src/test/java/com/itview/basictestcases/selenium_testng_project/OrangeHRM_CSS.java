package com.itview.basictestcases.selenium_testng_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_CSS {

	public static void main(String[] args) throws Exception{
		
		
	//	WebDriverManager.chromedriver().setup();
		WebDriver w=new ChromeDriver(); 
		
		w.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(2000);

		w.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		w.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");		
		w.findElement(By.cssSelector("button[type='submit']")).click();
		
		Thread.sleep(2000);
		
		w.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
		
		Thread.sleep(2000);
		
		w.findElement(By.cssSelector("a.oxd-userdropdown-link")).click();
		
		w.quit();
		
		

	}

}
