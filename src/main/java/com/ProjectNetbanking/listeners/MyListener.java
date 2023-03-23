package com.ProjectNetbanking.listeners;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ProjecNetbanking.utils.ExtentReporters;
import com.ProjecNetbanking.utils.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListener implements  ITestListener{
	ExtentReports extentreport;
	ExtentTest extenttest;

    public void onStart(ITestContext context) {
    extentreport = ExtentReporters.generateExtentReport();
    
	}
	
	
	public void onTestStart(ITestResult result) {
		
		extenttest = extentreport.createTest(result.getName());
		extenttest.log(Status.INFO,result.getName()+" Startes Excuting");
		
	
	}

	public void onTestSuccess(ITestResult result) {
		
		extenttest.log(Status.PASS, result.getName()+"  get successfully excecuted");
		
		
	}

	public void onTestFailure(ITestResult result) {
		result.getName();
		
	WebDriver driver=null;
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Throwable e) {
		
		e.printStackTrace();
	}
		String destinationScreenshot=Utilities.captureScreenshot(driver, result.getName());
		
		extenttest.addScreenCaptureFromPath(destinationScreenshot);
		extenttest.log(Status.INFO, result.getThrowable());
		extenttest.log(Status.FAIL, result.getName()+"  got failed");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		extenttest.log(Status.INFO,result.getThrowable());
		extenttest.log(Status.SKIP,result.getName()+" got skipped");
		
		
	}

	

	public void onFinish(ITestContext context) {
		extentreport.flush();
		
		String pathofExtentreport=System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReportfile=new File(pathofExtentreport);
		try {
			Desktop.getDesktop().browse(extentReportfile.toURI());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	
	
	
	
}
