package com.ProjecNetbanking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Utilities {
	
	
	public static final int IMPLCIT_WAIT_TIME=10;
	
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String TimeStamp=(date.toString().replace(" ", "_").replace(":", "_"));
	    return "sangitha"+TimeStamp+"@gmail.com";
		
		
		
	}
	
public static Object[][] getTestDataFromExcel(String sheetName) {
	File excelfile= new File("./src/main/java/com/Project/testdata/ninjaprojrctframework.xlsx");
	XSSFWorkbook workbook = null;
	try {

	FileInputStream fisExcel=new FileInputStream(excelfile);
	workbook= new XSSFWorkbook(fisExcel);
	}catch(Throwable e) {
		e.printStackTrace();
	}

	XSSFSheet sheet = workbook.getSheet(sheetName);
	
	
	int rows= sheet.getLastRowNum();
	int cols= sheet.getRow(0).getLastCellNum();
	
	Object [][] data =new Object[rows][cols];
	
	for (int i=0; i<rows; i++) {
		XSSFRow row=sheet.getRow(i+1);
		
		for (int j=0; j<cols; j++) {
	 	XSSFCell cell = row.getCell(j);
		 
		 CellType	cellType = cell.getCellType();
		 
		 switch(cellType) {
		 
		 case STRING:
			 data[i][j]=cell.getStringCellValue();
			 break;
			 
		 case NUMERIC:
			 data[i][j]=Integer.toString((int)cell.getNumericCellValue());
			break;
			
		case BOOLEAN:
			data[i][j]=cell.getBooleanCellValue();
			break;
			
		}
		 }
		 
		 
		 }
	
			
		
		
   return data;
}
public static String captureScreenshot(WebDriver driver,String testName) {

File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String destinationScreenshot=(".\\Screenshots\\"+testName);
try {
	FileHandler.copy(srcScreenshot,new File(destinationScreenshot));
} catch (IOException e) {
	
	e.printStackTrace();
}

return destinationScreenshot;
}



}


