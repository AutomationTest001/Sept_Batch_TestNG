package com.itview.testcases;

import org.testng.annotations.Test;

import com.itview.pageobject.CreditCard_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CreditCard_Test {
	
	CreditCard_PageObj creditCard=new CreditCard_PageObj();

  
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  creditCard.openBrowser(creditCard.readFromPropertiesFiles("browser"));
	  creditCard.call_CreditCard_PageObj();
	  
  }
  
  @Test(priority = 0,description = "Test Case to verify outstanding amount for 40K")
  public void outstanding_20000() throws Exception {
	  
	  creditCard.openApplication(creditCard.readFromPropertiesFiles("url_creditCard"));
	  creditCard.handleClickEvent(creditCard.no_Thanks_Window);
	  
	  creditCard.waitForSec(2);
	  
	  creditCard.handleTextBox(creditCard.outstandingAmt, "40000");
	  creditCard.handleTextBox(creditCard.paymentPlan, "4000");
	  creditCard.handleTextBox(creditCard.monthlyInterest, "6");
	  
	  creditCard.handleClickEvent(creditCard.SubmitLink);
	  
	  creditCard.waitForSec(2);
	  
	  String totalAmt=creditCard.totalPaymentCalculated.getText();
	  
	  System.out.println("Total Payment : "+totalAmt);
	  
	  Assert.assertEquals(totalAmt, "62,923.96");
	  
	  creditCard.waitForSec(2);
  }

  @AfterTest
  public void afterTest() {
	  
	  creditCard.closeBrowser();
  }

}
