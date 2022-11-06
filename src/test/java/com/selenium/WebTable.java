package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	
	public static void main(String args[]) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver w=new ChromeDriver();
		
		w.get("https://blazedemo.com/");
		
		WebElement departureCity=w.findElement(By.name("fromPort"));
		WebElement destinationCity=w.findElement(By.name("toPort"));

		
	    Select departure=new Select(departureCity);	
	    departure.selectByVisibleText("Paris");
	    
	    Select destination=new Select(destinationCity);	
	    destination.selectByVisibleText("London");
	    
	    w.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();
	    
	    Thread.sleep(2000);
	
	    //United Airlines	
	    
	    List<WebElement> table_rows=w.findElements(By.xpath("/html/body/div[2]/table/tbody/tr"));
	
	    for(int i=0;i<table_rows.size();i++) {
	    	
	    	List<WebElement> table_columns=table_rows.get(i).findElements(By.tagName("td"));
	    	
	    	for(int j=0;j<table_columns.size();j++) {
	    		
	    		String columns_value=table_columns.get(j).getText();
	    		
	    		if(columns_value.equals("United Airlines")) {
	    			
	    			String flightNumber=table_columns.get(1).getText();
	    			String price=table_columns.get(5).getText();
	    			
	    			System.out.println(flightNumber+" "+price);
	    		}
	    		
	    	}
	    	
	    }
	}

}
