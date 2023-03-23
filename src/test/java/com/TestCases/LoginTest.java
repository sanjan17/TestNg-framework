package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ProjecNetbanking.utils.Utilities;
import com.ProjectNetbanking.Base.BaseClass;
import com.ProjectNetbanking.pageObject.AccountPage;
import com.ProjectNetbanking.pageObject.HomePage;
import com.ProjectNetbanking.pageObject.LoginPagee;

public class LoginTest extends BaseClass {
	LoginPagee LoginPagee;
	
	public LoginTest() {
		super();
	}
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver=intializeBrowserandOpenURL(prop.getProperty("browserName"));
		HomePage homepage =new HomePage(driver);
		LoginPagee =homepage.NavigationTOLoginPage();
	}

	@AfterMethod
	public void tearDown() { 
		
		driver.quit();
	}

	
	@Test(priority = 1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCerdentials(String email,String password) {
	
	
		LoginPagee.enterEmailAddress(email);
		LoginPagee.enterPassword(password);
		AccountPage accountpage = LoginPagee.clickOnLoginButton();
	
	Assert.assertTrue(accountpage.DisplayStatusOfAccountInformation());
	
	}
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		Object[][] data= Utilities.getTestDataFromExcel("Login");
		return data;
		
	}
	
	
	
	@Test(priority = 2)
	public void verifyLoginWithInValidCrendtials() {
		
		LoginPagee.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		LoginPagee.enterPassword(dataprop.getProperty("invalidPassword"));
		LoginPagee.clickOnLoginButton();
	
		
		String actual=LoginPagee.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expected=(dataprop.getProperty("emailPasswordNoMatch"));
		Assert.assertEquals(actual,expected);
	
		
	
	}
	@Test(priority = 3)
	public void verifyLoginWithInValidEmailandValidPassword() {
		LoginPagee.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		LoginPagee.enterPassword(prop.getProperty("validPassword"));
		LoginPagee.clickOnLoginButton();
		

		String actual=LoginPagee.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expected=(dataprop.getProperty("emailPasswordNoMatch"));
		Assert.assertEquals(actual,expected);
	
		
	
	}
	@Test(priority = 4)
	public void verifyLoginWithInPasswordandValidEmail() {
		
		LoginPagee.enterEmailAddress(prop.getProperty("validEmail"));
		LoginPagee.enterPassword(dataprop.getProperty("invalidPassword"));
		LoginPagee.clickOnLoginButton();
		
		
		String actual=LoginPagee.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expected=(dataprop.getProperty("emailPasswordNoMatch"));
		Assert.assertEquals(actual,expected);
	
	
	}
	@Test(priority = 5)
	public void verifyLoginWithInValidCredtials() {
		
		// instead of space we removed and just clicking loging buttton
		
		LoginPagee.clickOnLoginButton();
		
		String actual=LoginPagee.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expected=(dataprop.getProperty("emailPasswordNoMatch"));
		Assert.assertEquals(actual,expected);
	
		
	}
	
	

}
