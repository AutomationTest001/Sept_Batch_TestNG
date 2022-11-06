package com.itview.extraconcepts;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws Exception{


		WebDriverManager.chromedriver().setup();		
		WebDriver w=new ChromeDriver();
		w.get("https://www.google.com/");
		
		List<WebElement> links=w.findElements(By.tagName("a"));
		System.out.println(" Count  of links on Google Search Page: "+links.size());

		Iterator<WebElement> it=links.iterator();	
		
		String href;
		int responseCode;
		
		while(it.hasNext()) {
			
			href=it.next().getAttribute("href");			
			//System.out.println(href);
			
			try {
			HttpURLConnection huc = (HttpURLConnection)(new URL(href).openConnection());
			
			huc.setRequestMethod("HEAD");
			huc.connect();
			
			responseCode=huc.getResponseCode();
			
			if(responseCode >= 400) {
				
				System.out.println(href + " : Broken Links | Status Code : "+responseCode);
			}
			}
			catch(MalformedURLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
	}

}
