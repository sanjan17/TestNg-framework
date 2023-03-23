package com.ProjectNetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpagee {
	WebDriver driver;
	
	
	@FindBy(linkText="HP LP3065")
	private WebElement validProduct;
	
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductPage;
	
	
	public Searchpagee(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean dispalyvalidProductHpProduct() {
	boolean validStatus=validProduct.isDisplayed();
	return validStatus;
	}
	
	public String noProductMessageText() {
	String	noproductTexts=noProductPage.getText();
	return noproductTexts;
	}

}
