package exceldataLibrary;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig
{
	XSSFWorkbook book;
	
	XSSFSheet sheet;
	
	public ExcelDataConfig(String excelPath)
	{
		try
		{
			File src=new File(excelPath);
			FileInputStream fs=new FileInputStream(src);
			book=new XSSFWorkbook(fs);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetNumber, int row, int column)
	{
		sheet=book.getSheetAt(sheetNumber);
		
		String data=sheet.getRow(row).getCell(column).getStringCellValue();
		return data;//this method helps use to read data from excel
	}
	
	public int getRowCount(int sheetIndex)
	{
		int row=book.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		
		return row;
	}
}
