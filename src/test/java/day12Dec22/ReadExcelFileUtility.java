package day12Dec22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileUtility {
	
	static Object[][] getData(String filename,String sheetN)
	{Object[][] data=null;
	try
	{
	FileInputStream fis=new FileInputStream(filename);
	String sheetname=sheetN;
	XSSFWorkbook workbook =new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet(sheetname);
	
	int row=sheet.getLastRowNum();
	int col=sheet.getRow(0).getLastCellNum();
	
	System.out.println("Row = "+row);
	System.out.println("Col = "+col);
	data=new Object[row][col];
	
	for(int i=1;i<=row;i++)
	{
		for(int j=0;j<col;j++)
			data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
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
	return data;
}
	

	public static void main(String[] args) {
		String filename=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Data.xlsx";
		String sheetname="Sheet1";
		
		Object[][] newData=getData(filename,sheetname);
		
		System.out.println("---------------------------------------------------");
		for(int r=0;r<newData.length;r++)
		{
			for(int c=0;c<newData[r].length;c++)
				System.out.print(newData[r][c]+"\t");
			System.out.println();
		}

	}

}
