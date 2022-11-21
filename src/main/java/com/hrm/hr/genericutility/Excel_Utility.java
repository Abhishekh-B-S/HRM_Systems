package com.hrm.hr.genericutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Excel_Utility {
	
	/**
	 * This method is used to read the data from excel file
	 * @author ABHISHEK
	 * @param sheetname
	 * @param rowno
	 * @param colno
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */

	public String readDataFromExcelFile(String sheetname, int rowno, int colno) throws Throwable, Throwable{
		
		FileInputStream fi = new FileInputStream(IPath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		Row ro=sh.getRow(rowno);
		Cell ce=ro.getCell(colno);
		String value=ce.getStringCellValue();
		return value;
		
	}
	/**
	 * This method is used to write data into excel sheet
	 * @author ABHISHEK
	 * @param sheetname
	 * @param rowno
	 * @param colno
	 * @param data
	 * @throws Throwable
	 */
	
	
	public void writeDataFromExcelFile(String sheetname, int rowno, int colno ,String data) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		Row ro=sh.getRow(rowno);
		Cell ce=ro.getCell(colno);
		ce.setCellValue(data);
		FileOutputStream fo=new FileOutputStream(IPath_Constants.ExcelPath);
		wb.write(fo);
	}
	
	/**
	 * This method is used to get last row count
	 * @author ABHISHEK
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	
	public int getLastrowNo(String sheetname) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		int RowCount=sh.getLastRowNum();
		return RowCount;
		
	}
	
	/**
	 * This method is used to get last column count
	 * @author ABHISHEK
	 * @param sheetname
	 * @param rowno
	 * @return
	 * @throws Throwable
	 */
	
	public int getLastColoumnNo(String sheetname, int rowno) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		Row ro=sh.getRow(rowno);
		int ColCount=ro.getLastCellNum();
		return ColCount;
		
	}
	
	public void getList(String sheetname, WebDriver driver) throws Throwable, Throwable
	{
		FileInputStream fi=new FileInputStream(IPath_Constants.ExcelPath);//Add Employee Excel Sheet
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		int count=sh.getLastRowNum();
	for(int i=0; i<=count; i++)
	{
		String key=sh.getRow(i).getCell(0).getStringCellValue();
		String value=sh.getRow(i).getCell(1).getStringCellValue();
		/*if(key.equals("employee_companyid"))  if the text field not accepting duplicate data
		{
			value=value+"_"+getRandomNumber();
		}*/
		driver.findElement(By.name(key)).sendKeys(value);
	}
				
	}

	
	public Map<String,String> getList(String sheetname) throws Throwable 
	{
		FileInputStream fi = new FileInputStream(IPath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		int count=sh.getLastRowNum();
		Map<String, String> map=new HashMap<String,String>();
	for(int i=0; i<=count; i++)
	{
		String key=sh.getRow(i).getCell(2).getStringCellValue();
		String value=sh.getRow(i).getCell(5).getStringCellValue();
		map.put(key, value);
	}
	return map;
		
	}
	
	public Object[][] readMultipleData(String sheetname) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPath_Constants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetname);
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		for (int i=0; i<lastrow; i++)
		{
			for(int j=0; j<lastcell; j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
						
}
	
	
				

	
	



