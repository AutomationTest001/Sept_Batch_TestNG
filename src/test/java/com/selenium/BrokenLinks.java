package com.selenium;

import java.io.IOException;
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

	static WebDriver w = null;

	public static void main(String[] args) {
	// TODO Auto-generated method stub

	String homePage = "https://www.google.com/";
	String url = "";
	HttpURLConnection huc = null;
	int respCode = 200;
	w = new ChromeDriver();
	w.manage().window().maximize();
	w.get(homePage);
	
	List<WebElement> links = w.findElements(By.tagName("a"));
	Iterator<WebElement> it = links.iterator();
	
	while(it.hasNext()){
		url = it.next().getAttribute("href");
		try {
		huc = (HttpURLConnection)(new URL(url).openConnection());
		huc.setRequestMethod("HEAD");
		huc.connect();		
		respCode = huc.getResponseCode();
		if(respCode >= 400){
		System.out.println(url+" is a broken link "+respCode);
		}
		else{
//		System.out.println(url+" is a valid link");
		}

		} catch (MalformedURLException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}

		w.quit();

		}
		}