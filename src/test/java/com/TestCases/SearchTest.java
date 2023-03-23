package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ProjectNetbanking.Base.BaseClass;
import com.ProjectNetbanking.pageObject.HomePage;
import com.ProjectNetbanking.pageObject.Searchpagee;

public class SearchTest extends BaseClass{
	Searchpagee searchpage;
	
	public SearchTest () {
		super();
	}
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void Setup() {
		
		driver=intializeBrowserandOpenURL(prop.getProperty("browserName"));
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	@Test (priority = 1)
public void verifySearchWithValidProduct() {
	HomePage homePage=new HomePage(driver);
	homePage.validProductSearch(dataprop.getProperty("validProduct"));
	searchpage=homePage.clickOnSearchButtonn();
	
		
	Assert.assertTrue(searchpage.dispalyvalidProductHpProduct(),"valid product");
}
@Test (priority = 2)
public void verifySearchWithInvalidProduct() {
	HomePage homePage=new HomePage(driver);
    homePage.validProductSearch(dataprop.getProperty("invalidProduct"));
    searchpage=homePage.clickOnSearchButtonn();
	
    
	String actualwar=searchpage.noProductMessageText();
	String expectedwar=(dataprop.getProperty("invalidProductWarning"));
	Assert.assertEquals(actualwar,expectedwar, "warning message not shown" );
	
}
@Test(priority = 3,dependsOnMethods={"verifySearchWithInvalidProduct"})
public void verifySearchwithAnyProduct() {
	HomePage homePage=new HomePage(driver);
	searchpage=homePage.clickOnSearchButtonn();
	 	    
		String actualwar=searchpage.noProductMessageText();
		String expectedwar=(dataprop.getProperty("invalidProductWarning"));
		Assert.assertEquals(actualwar,expectedwar, "warning message not shown" );
}
}
