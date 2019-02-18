package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.base.TestBase;

public class Agent_LandingPagePageObjects extends TestBase  {
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement username_input_user;
	
	@FindBy(xpath="//input[@placeholder='Password']") 
	public WebElement password_input_user;
	
	@FindBy(xpath="//div[text()='Enter an email or phone number']")
	private WebElement emptyUsernameValidation;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='valid-user']")
	private WebElement LandingPageErrorMessagePlaceholder;

	@FindBy(xpath="//em[@id='queueViewMenuCombo-btnWrap']")
	private WebElement userMenuAfterLogin;
	
	@FindBy(id="logoutBtn-itemEl")
	private WebElement LogoutHyperlink;
	
	@FindBy(id="queueViewMenuCombo-btnEl")
	private WebElement WelcomeUsername;
	
	public void validateUserNameField(){
		Assert.assertEquals(username_input_user.getAttribute("placeholder"), "Username");
	}
	
	public void enterUsename(String userName){
		username_input_user.sendKeys(userName);
		password_input_user.click();
	}
	public void validatePasswordField(){
		Assert.assertEquals(password_input_user.getAttribute("placeholder"), "Password");
	}
	
	public void enterPassword(String password){
		password_input_user.sendKeys(password);
	}
	
	public void loginButtonClick(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		LoginButton.click();
	}
	
	public void verifySuccessfulLogin(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(WelcomeUsername));
		Assert.assertEquals(WelcomeUsername.getText(), "Ram Datla");
	}
	
	public void clickLogout(WebDriver driver) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(userMenuAfterLogin));
		userMenuAfterLogin.click();
		Thread.sleep(2000);
		LogoutHyperlink.click();

	}
	
	public void verifyLogout(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(username_input_user));
		Assert.assertEquals(username_input_user.getAttribute("placeholder"), "Username");

	}
}

