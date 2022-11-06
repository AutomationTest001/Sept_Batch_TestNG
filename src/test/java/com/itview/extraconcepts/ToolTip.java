package com.itview.extraconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) throws Exception{


		WebDriverManager.chromedriver().setup();		
		WebDriver w=new ChromeDriver();
		w.get("https://www.google.com/");
		
		WebElement googleSeachText=w.findElement(By.name("q"));
		
		String googleSeachText_tooltip=googleSeachText.getAttribute("title");
		
		System.out.println("ToolTip Text : "+googleSeachText_tooltip);
		
		w.close();

	}

}
