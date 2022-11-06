package com.itview.pageobject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	String baseUrl = "https://www.moneycontrol.com/personal-finance/tools";
	WebDriver w;

	public void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			w = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			w = new EdgeDriver();
		} else {
			System.out.println("Please use chrome / firefox / edge for execution");
		}
		
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		w.manage().window().maximize();
	}

	public void closeBrowser() {
		w.quit();
	}

	public void openApplication(String pagePath) {

		w.get(baseUrl + "/" + pagePath);
	}

	public void handleTextBox(WebElement we, String value) {

		we.clear();
		we.sendKeys(value);

	}

	public void handleClickEvent(WebElement we) {

		we.click();
	}

	public void handleDropDown(WebElement we, String value) {		
		Select sel=new Select(we);
		sel.selectByVisibleText(value);
	}
	
	public void waitForSec(int sec) throws Exception {
		
		Thread.sleep(sec * 1000);
		
	}
	
	public String readFromPropertiesFiles(String Key) throws Exception {

		FileInputStream fi=new FileInputStream(".\\Configuration\\config.properties");
		
		Properties prop=new Properties();
		
		prop.load(fi);
		
		String returnValue=prop.getProperty(Key);
		
		fi.close();
		
		return returnValue;
	}
	

}
