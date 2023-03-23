package com.ProjectNetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//object
    @FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
    
    @FindBy(linkText="Login")
   private  WebElement loginOption;
    
    @FindBy(linkText="Register")
   private WebElement registerOption;
    
    @FindBy(xpath="//input[@class='form-control input-lg']")
    private WebElement searchValidProduct;
    
    @FindBy(xpath="//button[@type='button'and@class='btn btn-default btn-lg']")
    private WebElement clickOnSearchButton;
    
    public HomePage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);//this step is to initialies the webelement
    	
    }
  //Actions
    public void clickOnMyAccount() {
    	myAccountDropMenu.click();
    	
    }
    
    public LoginPagee selectLoginOption() {
    	loginOption.click();
    	return new LoginPagee(driver);
   
    }
    
    public LoginPagee NavigationTOLoginPage() {
    	myAccountDropMenu.click();
    	loginOption.click();
    	return new LoginPagee(driver);
    }
    
    
    public  RegisterPagee clickOnRegister() {
    	registerOption.click();
    	return new RegisterPagee(driver);
    }
    
    public void validProductSearch(String productText) {
    	searchValidProduct.sendKeys(productText);
    	
    }
  public Searchpagee clickOnSearchButtonn() {
	  clickOnSearchButton.click();
	  return new Searchpagee(driver);
  }
    
    
    
    
    
}
