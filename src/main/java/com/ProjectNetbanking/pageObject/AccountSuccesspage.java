package com.ProjectNetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesspage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountsuccesspageHeading;
	
	public AccountSuccesspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String retriveaccountSuccesspageHeading() {
	String	accountsuccesspagetext=accountsuccesspageHeading.getText();
	return accountsuccesspagetext;
	}

}
