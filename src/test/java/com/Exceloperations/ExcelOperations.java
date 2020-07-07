package com.Exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations 
{
public static String readData(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("C:\\TestData\\userdata.xlsx");
	       Workbook w1=WorkbookFactory.create(fis);
	       String s=w1.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		return s;	       
}
public static void writeData(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("C:\\TestData\\userdata.xlsx");
	       Workbook w1=WorkbookFactory.create(fis);
	       String s=w1.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	       FileOutputStream fos=new FileOutputStream("C:\\TestData\\userdata.xlsx");
	       w1.write(fos);	 
}
}
