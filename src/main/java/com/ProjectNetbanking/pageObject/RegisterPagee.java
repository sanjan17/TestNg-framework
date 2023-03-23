package com.ProjectNetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPagee {
	WebDriver driver;
	
	@FindBy(name="firstname")
    private	WebElement firstNameField;
	
	@FindBy(name="lastname")
	private WebElement lastNameField;
	
	@FindBy(name="email")
	private WebElement enterEmailField;
	
	@FindBy(name="telephone")
	private WebElement enterTelephoneField;
	
    @FindBy(name="password")
	private WebElement enterPasswordField;
    
    @FindBy(name="confirm")
    private WebElement enterConfirmPassword;
    
    @FindBy(name="newsletter")
    private WebElement clickOnNewsLetter;
    
    @FindBy(name="agree")
    private WebElement privacyPolicy;
    
    @FindBy(xpath="//input[@type='submit']")
    private WebElement clickOnSubmitButton;
    
    @FindBy(xpath="//input[@name='newsletter'][@value='1']")
   private WebElement yesNewLetterOption;
    
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
    private WebElement duplicatEmailAddressWarning;
    
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
    private WebElement privacyPolicyWarning;
    
    @FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    private WebElement firstNameWarning;
    
    
    @FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    private WebElement lastNameWarning;
    
    
    @FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
    private WebElement emailWarningMessage;
    
    
    @FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    private WebElement telePhoneWarning;
    
    @FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
    private WebElement passwordWarningMessage;
    
    
    public RegisterPagee(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    	
    }
    
    
   public void enterFirstNameField(String firstName) {
	   firstNameField.sendKeys(firstName);
   }
   
   public void enterLastNameField(String lastName) {
	   lastNameField.sendKeys(lastName);
	   
   }
   public void enterEmailField(String emailField) {
	   enterEmailField.sendKeys(emailField); 
   }
   
   public void enterTelephoneField(String telephonrField ) {
	   enterTelephoneField.sendKeys(telephonrField);  
   }
   
   public void enterPasswordField(String passwordField) {
	   enterPasswordField.sendKeys(passwordField);
   }
   
   public void confirmPasswordField(String confirmPassword) {
	   enterConfirmPassword.sendKeys(confirmPassword); 
   }
   
   public void clickOnNewletter() {
	   clickOnNewsLetter.click();
	   
   }
  
   public void clickOnprivacyPolicy() {
	   privacyPolicy.click();
   }
   
   public AccountSuccesspage clickOnSubmitButton() {
	   clickOnSubmitButton.click(); 
	   return new AccountSuccesspage(driver);
   }
   
  public void selectyesNewLetterOption() {
	  yesNewLetterOption.click();
  }
  
  public String retriveDuplicateEmailAddressWarning() {
	String duplicatwar= duplicatEmailAddressWarning.getText();
	return duplicatwar;
  }
   
  public String privacyPolicyWarningMessage() {
	 String privacypolicywarningmessages= privacyPolicyWarning.getText();
	 return privacypolicywarningmessages;
  }
  
  public String firstNameWarningMessage() {
String	firstNameWarningText=  firstNameWarning.getText();
	return firstNameWarningText ; 
  }
  
  public String lastNameWarning() {
	String lastNamewarningText= lastNameWarning.getText();
	return lastNamewarningText;
	  
  }
  
 public String emailWarningMessages() {
	String emailWarningText= emailWarningMessage.getText();
	return emailWarningText;
 }
  
 public String telephoneWarningmessage() {
	String telephonewarningtext= telePhoneWarning.getText();
	return telephonewarningtext;
 }
  
 public String passwordWarningMessages () {
String	passwordwarningtext= passwordWarningMessage.getText();
return passwordwarningtext;
	 
 }
  
  
  
  
  
  
  
  
  
  
}
