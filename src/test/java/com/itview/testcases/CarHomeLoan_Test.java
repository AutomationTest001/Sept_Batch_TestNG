package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.CarHomeLoan_PageObj;


import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CarHomeLoan_Test {
	
	CarHomeLoan_PageObj carHomeLoan=new CarHomeLoan_PageObj();
  
  @BeforeTest
  public void openBrowserCode() throws Exception {	  
	  carHomeLoan.openBrowser(carHomeLoan.readFromPropertiesFiles("browser"));
	  carHomeLoan.call_CarHomeLoan_PageObj();
	  
  }  
  @Test(priority = 0,description = "Test Case to verify car home loan emi value for 2 lakh")
  public void test_2lakh() throws Exception {
	  
	  carHomeLoan.openApplication(carHomeLoan.readFromPropertiesFiles("url_carHomeLoan"));
	  
	  carHomeLoan.handleClickEvent(carHomeLoan.no_Thanks_Window);
	  
	  carHomeLoan.waitForSec(2);
	  
	  carHomeLoan.handleTextBox(carHomeLoan.carhomeLoan_InputBox, "200000");
	  
	  carHomeLoan.handleTextBox(carHomeLoan.loan_period_InputBox, "10");
	  
	  carHomeLoan.handleDropDown(carHomeLoan.emi_start_from_DropDowm, "From next month after disbursement");
	
	  carHomeLoan.handleTextBox(carHomeLoan.interest_rate_InputBox, "7");
	  
	  carHomeLoan.handleTextBox(carHomeLoan.upfront_charges_InputBox, "8000");
	  
	  carHomeLoan.handleClickEvent(carHomeLoan.submit_Btn);
	  
	  carHomeLoan.waitForSec(2);
	  
	  String print_EMIValue=carHomeLoan.emi_Value.getText();
	  
	  System.out.println("EMI : "+print_EMIValue);
	  
	  Assert.assertEquals(print_EMIValue, "2,376.46");
	  
	  carHomeLoan.waitForSec(3);
	  
  }

  @AfterTest
  public void closeBrowserCode() {
	  
	  carHomeLoan.closeBrowser();
  }

}
