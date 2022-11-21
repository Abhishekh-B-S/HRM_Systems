package practicePackage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.hrm.hr.genericutility.IPath_Constants;

public class DataProviderClassSeperate {
	@DataProvider
	public Object[][] readMultipleData() throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPath_Constants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
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
