package com.itview.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarHomeLoan_PageObj extends TestBase {	
	
	
	//WebElement carhome_loan=w.findElement(By.id("carhome_loan"));
	
//	w.findElement(By.id("carhome_loan")) -> @FindBy(id="elementId") 
//	 WebElement carhome_loan             -> WebElement element;
	
	@FindBy(id="carhome_loan")
	public WebElement carhomeLoan_InputBox;	
	
	@FindBy(id="loan_period")
	public WebElement loan_period_InputBox;
	
	@FindBy(css="select.custselect")
	public WebElement emi_start_from_DropDowm;	
	
	@FindBy(id="interest_rate")
	public WebElement interest_rate_InputBox;
	
	@FindBy(id="upfront_charges")
	public WebElement upfront_charges_InputBox;
	
	@FindBy(linkText="Submit")
	public WebElement submit_Btn;
	
	@FindBy(id="reset_btn")
	public WebElement reset_Btn;	
	
	@FindBy(id="total_payment")
	public WebElement totalPayment_Value;
	
	@FindBy(id="interest_charges")
	public WebElement interestCharges_Value;
	
	@FindBy(id="emi")
	public WebElement emi_Value;
	
	@FindBy(id="wzrk-cancel")
	public WebElement no_Thanks_Window;
	
	public void call_CarHomeLoan_PageObj() {
		
		PageFactory.initElements(w, this);
	}
	
}
