package practicePackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcelTest {

	public static void main(String[] args) throws Throwable, Throwable {
		
		//create object for physical file
		FileInputStream fi = new FileInputStream("src\\test\\resources\\TestData.xlsx");
		
		//create workbook
		Workbook wb = WorkbookFactory.create(fi);
		
		String Deptname=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	    System.out.println(Deptname);
	    String Branch = wb.getSheet("Sheet1").getRow(3).getCell(2).getStringCellValue();
	    System.out.println(Branch);
	    
	    FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
	    //modify
	    wb.getSheet("Sheet1").getRow(3).getCell(2).setCellValue("Mangalore");
	    wb.write(fos);
	    //newly add
	    wb.getSheet("Sheet1").createRow(9).createCell(9).setCellValue("Bangalore");
	    wb.write(fos);
	    
	    
		
	
		
		
		
		

	}

}
