package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		WebDriver w = new EdgeDriver();
		w.manage().window().maximize();
		w.get("https://demo.automationtesting.in/Register.html");
		
		Thread.sleep(3000);

		//w.findElement(By.xpath("//*[@id=\"imagesrc\"]")).click();
		
		Actions actions = new Actions(w);        
		WebElement uploadPhotoBtn = w.findElement(By.xpath("//*[@id=\"imagesrc\"]"));
		actions.moveToElement(uploadPhotoBtn).click().build().perform();

	}

}
