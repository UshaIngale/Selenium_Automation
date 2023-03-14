package day12Dec22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) {
		try
		{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Data.xlsx");
		String sheetname="Sheet1";
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetname);
		
		int row=sheet.getLastRowNum();
		int col=sheet.getRow(0).getLastCellNum();
		
		System.out.println("Row = "+row);
		System.out.println("Col = "+col);
		
		Object[][] data=new Object[row][col];
		
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<col;j++)
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
		
		System.out.println("---------------------------------------------------");
		for(int r=0;r<data.length;r++)
		{
			for(int c=0;c<data[r].length;c++)
				System.out.print(data[r][c]+"\t");
			System.out.println();
		}
		}
		catch(FileNotFoundException f)
		{
			f.printStackTrace();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		
	}

}
