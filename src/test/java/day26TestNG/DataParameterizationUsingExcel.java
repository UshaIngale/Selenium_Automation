package day26TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataParameterizationUsingExcel {

	@Test(dataProvider = "getData")
	public void empData(Map<String, String> emp) {

		System.out.println(emp.get("Sr.No.") + " :: " + emp.get("EmpId") + " :: " + emp.get("EmpName") + " :: "
				+ emp.get("Salary"));// Sr.No. EmpId EmpName Salary

	}

	@DataProvider
	public Object[] getData() {
		Object[] data = null;
		String fileName = null;
		try {
			fileName = System.getProperty("user.dir") + "/src/test/resources/testdata/Data.xlsx";
			FileInputStream fis = new FileInputStream(fileName);
			String sheetName = "Sheet1";
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			int row = sheet.getLastRowNum();
			data = new Object[row];

			Map<String, String> m = null;

			String field1 = sheet.getRow(0).getCell(0).getStringCellValue();
			String field2 = sheet.getRow(0).getCell(1).getStringCellValue();
			String field3 = sheet.getRow(0).getCell(2).getStringCellValue();
			String field4 = sheet.getRow(0).getCell(3).getStringCellValue();

			for (int i = 1; i <=row; i++) {
				m = new HashMap<String, String>();
				m.put(field1, sheet.getRow(i).getCell(0).getStringCellValue());
				m.put(field2, sheet.getRow(i).getCell(1).getStringCellValue());
				m.put(field3, sheet.getRow(i).getCell(2).getStringCellValue());
				m.put(field4, sheet.getRow(i).getCell(3).getStringCellValue());
				data[i-1 ] = m;
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found " + fileName);
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return data;
	}

}
