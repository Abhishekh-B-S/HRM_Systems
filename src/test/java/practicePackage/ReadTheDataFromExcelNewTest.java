package practicePackage;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public abstract class ReadTheDataFromExcelNewTest {

	public static void main(String[] args) throws Throwable {


		FileInputStream fis = new FileInputStream("./src/test/resources/ReadData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		int a=wb.getSheet("Sheet1").getLastRowNum();
		System.out.println(a);

		for (int i=1; i<=a; i++) {

			String branch = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			String cn = wb.getSheet("Sheet1").getRow(i).getCell(2).toString();		
			System.out.println(branch+"  "+cn);
		}

		FileOutputStream fos = new FileOutputStream("./src/test/resources/ReadData.xlsx");	
		String b[]= {"abc","ert","qwe","rrr","qaz"};
		for (int i=0; i<b.length; i++) {
			wb.getSheet("Sheet1").createRow(i).createCell(3).setCellValue(b[i]);
			wb.write(fos);
		}

	}

}
