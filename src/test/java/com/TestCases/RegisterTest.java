package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ProjecNetbanking.utils.Utilities;
import com.ProjectNetbanking.Base.BaseClass;
import com.ProjectNetbanking.pageObject.AccountSuccesspage;
import com.ProjectNetbanking.pageObject.HomePage;
import com.ProjectNetbanking.pageObject.RegisterPagee;



public class RegisterTest extends BaseClass {
	RegisterPagee rigesterpage;
	AccountSuccesspage accountsucesspage;

	public RegisterTest () {
		super();
	}
public	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		
		driver=intializeBrowserandOpenURL(prop.getProperty("browserName"));
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		rigesterpage=homepage.clickOnRegister();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyRegisterwithManditatoryField() {
				
		rigesterpage.enterFirstNameField(dataprop.getProperty("firstName"));
		rigesterpage.enterLastNameField(dataprop.getProperty("lastName"));
		rigesterpage.enterEmailField(Utilities.generateEmailWithTimeStamp());
		rigesterpage.enterTelephoneField(dataprop.getProperty("telephone"));
		rigesterpage.enterPasswordField(prop.getProperty("validPassword"));
		rigesterpage.confirmPasswordField(prop.getProperty("validPassword"));
		rigesterpage.clickOnNewletter();
		rigesterpage.clickOnprivacyPolicy();
		accountsucesspage =rigesterpage.clickOnSubmitButton();
		
				
		String expected=accountsucesspage.retriveaccountSuccesspageHeading();
		String actual=(dataprop.getProperty("accountsuccesfulcreated"));
		Assert.assertEquals(expected, actual, "Page not success");
	
		
		
	}
	@Test(priority = 2)
public void verifyRegisterProvidingAllField() {
		
		
		rigesterpage.enterFirstNameField(dataprop.getProperty("firstName"));
		rigesterpage.enterLastNameField(dataprop.getProperty("lastName"));
		rigesterpage.enterEmailField(Utilities.generateEmailWithTimeStamp());
		rigesterpage.enterTelephoneField(dataprop.getProperty("telephone"));
		rigesterpage.enterPasswordField(prop.getProperty("validPassword"));
		rigesterpage.confirmPasswordField(prop.getProperty("validPassword"));
	    rigesterpage.selectyesNewLetterOption();
	    rigesterpage.clickOnprivacyPolicy();
	   accountsucesspage=rigesterpage.clickOnSubmitButton();
		
				
		String expected=accountsucesspage.retriveaccountSuccesspageHeading();
		String actual=(dataprop.getProperty("accountsuccesfulcreated"));
		Assert.assertEquals(expected, actual, "Page not success");
		
		
		
	}
	@Test(priority = 3)
	public void verifyExistingEmailAddress() {
		
		
		rigesterpage.enterFirstNameField(dataprop.getProperty("firstName"));
		rigesterpage.enterLastNameField(dataprop.getProperty("lastName"));
		rigesterpage.enterEmailField(prop.getProperty("validEmail"));
		rigesterpage.enterTelephoneField(dataprop.getProperty("telephone"));
		rigesterpage.enterPasswordField(prop.getProperty("validPassword"));
		rigesterpage.confirmPasswordField(prop.getProperty("validPassword"));
		rigesterpage.selectyesNewLetterOption();
		rigesterpage.clickOnprivacyPolicy();
		rigesterpage.clickOnSubmitButton();
		
		String expected=rigesterpage.retriveDuplicateEmailAddressWarning();
		String actualemailexist=(dataprop.getProperty("emailexistwarning"));
		Assert.assertEquals(expected, actualemailexist, "email waring not displayed");
		
		
		
	}
	@Test(priority = 4)
	public void verifyWithoutEntringMandetoryFileds() {
		
		rigesterpage.clickOnSubmitButton();
		
		String actual =rigesterpage.privacyPolicyWarningMessage();
		String expectedpolicy=(dataprop.getProperty("privacypolicywarning"));
		Assert.assertEquals(actual, expectedpolicy,"not showing waring message");
		
		String actualfirstname =rigesterpage.firstNameWarningMessage();
		String expectedfirstname=(dataprop.getProperty("firstNameWarning"));
		Assert.assertEquals(actualfirstname,expectedfirstname,"not showing waring message of firstname");
		
		String actuallastname =rigesterpage.lastNameWarning();
		String expectedlasttname=(dataprop.getProperty("lastNameWarning"));
		Assert.assertEquals(actuallastname,expectedlasttname,"not showing waring message of Lastname");
		
		String actualemail =rigesterpage.emailWarningMessages();
		String expectedemail=(dataprop.getProperty("emailWarning"));
		Assert.assertEquals(actualemail,expectedemail,"not showing waring message of email");
		
		String actualtelephone =rigesterpage.telephoneWarningmessage();
		String expectedtelephone=(dataprop.getProperty("telephoneWarning"));
		Assert.assertEquals(actualtelephone,expectedtelephone,"not showing waring message of telephone");
		
		String actualpwwsd =rigesterpage.passwordWarningMessages();
		String expectedpwwsd=(dataprop.getProperty("passwordWarningmessage"));
		Assert.assertEquals(actualpwwsd,expectedpwwsd,"not showing waring password");
		
		
		
	}
	
		
		
	}


