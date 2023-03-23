package com.ProjecNetbanking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporters {
	
	public static ExtentReports generateExtentReport() {
	ExtentReports extentReports=new ExtentReports();
	
	File extentReportFile=new File(".\\test-output\\ExtentReports\\extentReport.html");
	ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
	
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("Projectbanking  test Automation reports");
	sparkReporter.config().setDocumentTitle("TN Automation Report");
	sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	
	extentReports.attachReporter(sparkReporter);
	
	Properties configProp =new Properties();
	File file= new File(".\\com\\ProjectNetbanking\\config\\config.properties");
	
	try {
	FileInputStream fis =new FileInputStream(file);
	configProp.load(fis);
	}catch(Throwable e) {
		e.printStackTrace();
	}
	
   extentReports.setSystemInfo("Application URL",configProp.getProperty("url") );
   extentReports.setSystemInfo("Browser Name",configProp.getProperty("browserName"));
   extentReports.setSystemInfo("Email",configProp.getProperty("validEmail"));
   extentReports.setSystemInfo("Password",configProp.getProperty("validPassword"));
   extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
   extentReports.setSystemInfo("UserName", System.getProperty("user.name"));
   extentReports.setSystemInfo("java version", System.getProperty("java.version"));
   
   return extentReports;
}}
