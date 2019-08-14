package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_write {
	
	public String read(int x, int y ,String file_path )
	{
		String result=null;
		try
		{
			File f = new File(file_path);
			FileInputStream  fis = new FileInputStream(f);
			XSSFWorkbook wb =  new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("Sheet1");
			XSSFRow row = sh.getRow(x);
			XSSFCell cell = row.getCell(y);
			result = cell.getStringCellValue();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("not reading");
		}
		
		return result;
	
	}
	public String read1(int x, int y ,String file_path )
	{
		String result=null;
		try
		{
			File f = new File(file_path);
			FileInputStream  fis = new FileInputStream(f);
			XSSFWorkbook wb =  new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("Sheet1");
			XSSFRow row = sh.getRow(x);
			XSSFCell cell = row.getCell(y);
			result = Integer.toString((int)(cell.getNumericCellValue()));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("not reading");
		}
		
		return result;
	
	}
	public String read2(int x, int y ,String file_path )
	{
		String result=null;
		try
		{
			File f = new File(file_path);
			FileInputStream  fis = new FileInputStream(f);
			XSSFWorkbook wb =  new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("Sheet1");
			XSSFRow row = sh.getRow(x);
			XSSFCell cell = row.getCell(y);
			result =Double.toString(cell.getNumericCellValue());
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("not reading");
		}
		
		return result;
	
	}
	
	

}
