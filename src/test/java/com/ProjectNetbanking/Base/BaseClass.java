package com.ProjectNetbanking.Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ProjecNetbanking.utils.Utilities;

public class BaseClass {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public  BaseClass()
	
	 {
		prop=new Properties();
		File propFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ProjectNetbanking\\config\\config.properties");
		
		dataprop=new Properties();
		File datapropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Project\\testdata\\testdata.properties");
		
		try {
		FileInputStream fis2=new FileInputStream(datapropFile);
		dataprop.load(fis2);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		try {
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
			
		}
		
	}
	
	public WebDriver intializeBrowserandOpenURL(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			DesiredCapabilities caps =new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			ChromeOptions options= new ChromeOptions();
			options.merge(caps);
			driver= new ChromeDriver(options);
		}
		else if(browserName.equals("edge"))
		{
			DesiredCapabilities caps =new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			EdgeOptions options= new EdgeOptions();
			options.merge(caps);
			driver= new EdgeDriver(options);
			
		}
			
		else if(browserName.equals("firefox"))
				{
			DesiredCapabilities caps =new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			FirefoxOptions options= new FirefoxOptions();
			options.merge(caps);
			driver= new FirefoxDriver(options);
				}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLCIT_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
