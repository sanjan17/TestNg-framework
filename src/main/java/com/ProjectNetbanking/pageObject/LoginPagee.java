package com.ProjectNetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagee {
	WebDriver driver;
	
	@FindBy(name="email")
	private WebElement emailAddressField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement clickLoginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailPasswordnotMatchindWarning;
	
	public LoginPagee(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
		
	}
	
	public AccountPage clickOnLoginButton() {
		clickLoginButton.click();
		return new AccountPage(driver);
		
	}
	
	
	
	
	public String retrieveEmailPasswordNotMatchingWarningMessageText() {
		String warningText=emailPasswordnotMatchindWarning.getText();
		return warningText;
	}

}
