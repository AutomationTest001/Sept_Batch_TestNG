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

public class WindowAuth {

	public static void main(String[] args) {

		String homePage = "https://www.google.com/";

		WebDriver w = new ChromeDriver();
		
		String username="admin";
		String password="admin";
		
		String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";

		w.get(URL);

		
	//	w.quit();

	}
}