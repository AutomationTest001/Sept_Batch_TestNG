package com.itview.extraconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable_Code {

	public static void main(String[] args) throws Exception{

		WebDriverManager.chromedriver().setup();
		WebDriver w=new ChromeDriver();
		
		w.get("https://blazedemo.com/");
		
		WebElement departureCity=w.findElement(By.name("fromPort"));
		WebElement destinationCity=w.findElement(By.name("toPort"));

		
	    Select departure=new Select(departureCity);	
	    departure.selectByVisibleText("Paris");
	    
	    Select destination=new Select(destinationCity);	
	    destination.selectByVisibleText("London");


	    w.findElement(By.cssSelector("input[value='Find Flights']")).click();
	    
	    Thread.sleep(2000);
	    
	  List<WebElement> webtable_rows=w.findElements(By.xpath("/html/body/div[2]/table/tbody/tr"));
	   System.out.println("Rows present inside webtable : "+webtable_rows.size());
	   
	   for(int i=0;i<webtable_rows.size();i++) {
		   
		   List<WebElement> webtable_columns=webtable_rows.get(i).findElements(By.tagName("td"));
		   
		   for(int j=0;j<webtable_columns.size();j++) {
			   
			  // System.out.print(" "+webtable_columns.get(j).getText());			   
			   String columnsValue=webtable_columns.get(j).getText();
			   
			   if(columnsValue.equalsIgnoreCase("United Airlines")) {
				   
				   String flightNumber=webtable_columns.get(1).getText();
				   String flightPrice=webtable_columns.get(5).getText();
				   
				   System.out.println("FlightNumber : "+flightNumber);
				   System.out.println("FlightPrice : "+flightPrice);
			   }
			   
		   }
		   System.out.println();
	   }
	   
	}

}
