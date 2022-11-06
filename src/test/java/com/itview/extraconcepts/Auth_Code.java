package com.itview.extraconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Auth_Code {

	public static void main(String[] args) throws Exception{

		String username="admin";
		String password="admin";
		
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		WebDriverManager.chromedriver().setup();		
		WebDriver w=new ChromeDriver(options);
		
		//https://username:password@URL
		//w.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		w.get("https://expired.badssl.com/");
		

	}

}
