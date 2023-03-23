package com.Project.testdata;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldemo {

	public static void main(String[] args) throws Exception {
		File excel= new File("./src/main/java/com/Project/testdata/ninjaprojrctframework.xlsx");
		System.out.println(excel.exists());
		FileInputStream fis=new FileInputStream(excel);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Login");
		

		int rows= sheet.getLastRowNum();
		int cols= sheet.getRow(0).getLastCellNum();
	
		
		for (int i=0; i<rows; i++) {
			
			
			for (int j=0; j<cols; j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
		 
			}
			/* CellType	cellType = cell.getCellType();
			 
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
				*/
			}
			 
			System.out.println(); 
			 
			 
		
		workbook.close()	;	
		fis.close();

	}

}
