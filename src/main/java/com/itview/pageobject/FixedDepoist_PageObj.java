package com.itview.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedDepoist_PageObj extends TestBase{
	
	@FindBy(id="principal")
	public WebElement principalTxt;
	
	@FindBy(id="interest")
	public WebElement interestTxt;
	
	@FindBy(id="tenure")
	public WebElement tenureTxt;
	
	@FindBy(id="tenurePeriod")
	public WebElement tenurePeriodDropDown;
	
	@FindBy(id="frequency")
	public WebElement frequencyDropDown;
	
	@FindBy(xpath="//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")
	public WebElement calculateBtn;
	
	@FindBy(xpath="//*[@id=\"resp_matval\"]/strong")
	public WebElement maturityValue;
	
	
	@FindBy(id="wzrk-cancel")
	public WebElement no_Thanks_Window;
	
	public void call_FixedDepoist_PageObj() {		
		PageFactory.initElements(w, this); 
	}


}
