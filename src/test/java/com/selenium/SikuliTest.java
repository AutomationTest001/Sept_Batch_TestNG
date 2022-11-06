package com.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SikuliTest {

	public static void main(String[] args) throws Exception {

		String projectPath = System.getProperty("user.dir");

		String filepath = projectPath + "\\SikuliImg\\";
		String uploadFilePath = projectPath + "\\SikuliImg\\";

		Screen s = new Screen();
		Pattern fileInputTextBox = new Pattern(filepath + "FileTextBox.PNG");
		Pattern openButton = new Pattern(filepath + "OpenButton.PNG");

		WebDriverManager.chromedriver().setup();
		WebDriver w = new ChromeDriver();
		w.manage().window().maximize();
		w.get("https://demo.automationtesting.in/Register.html");
		
		Thread.sleep(2000);

		Actions actions = new Actions(w);        
		WebElement uploadPhotoBtn = w.findElement(By.xpath("//*[@id=\"imagesrc\"]"));
		actions.moveToElement(uploadPhotoBtn).click().build().perform();
    
		Thread.sleep(2000);

		s.wait(fileInputTextBox, 20);
		s.type(fileInputTextBox, uploadFilePath + "TestNG.pdf");
		s.click(openButton);

		// Close the browser
		Thread.sleep(2000);

	     w.close();

	}
}