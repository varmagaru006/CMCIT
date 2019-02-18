package com.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.qa.base.TestBase;
import com.qa.pageObjects.Agent_LandingPagePageObjects;
import com.qa.pageObjects.ConfigProperties;
import com.qa.pageObjects.User_AccountSummaryPageObjects;
import com.qa.pageObjects.User_LandingPageObjects;



public class User_VerifyLastFourDigits extends TestBase {

	User_LandingPageObjects User_LandingPage = null;
	User_AccountSummaryPageObjects User_AccountSummaryPage = null;

	//ConfigProperties conf= new ConfigProperties();
	
	@BeforeTest
	public void browseGmail()
	{
		initialization();
		WebDriver driver=getDriver();
		OpenURL("https://tacqa.credagility.com/security/login");
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
		User_LandingPage=PageFactory.initElements(driver,User_LandingPageObjects.class);
		User_AccountSummaryPage=PageFactory.initElements(driver,User_AccountSummaryPageObjects.class);

	}
	
	
	@Test
	public void usernameUITest() throws InterruptedException
	{
		
		try {
			System.out.println("hi-------------->>>>");
			//LandingPage.validateUserNameField();
			User_LandingPage.enterFirstName("Florian");
			User_LandingPage.enterLastName("Boutellier");
			User_LandingPage.enterLastFourDigits("1727");
			User_LandingPage.enterMonth("Dec");
			User_LandingPage.enterMonth("27");
			User_LandingPage.enterMonth("1992");
			User_LandingPage.clickOnLogin();
			Thread.sleep(10000);
			String last4DigitsExtracted=User_AccountSummaryPage.getLastFourDigits();
			Assert.assertEquals("-1727", last4DigitsExtracted);
			System.out.println("last4DigitsExtracted=="+last4DigitsExtracted);
			Thread.sleep(10000);
			User_AccountSummaryPage.LogoutFromUserPortal();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
}
