package handson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MethodCreationOfExcel {
	static XSSFSheet sh;
	static XSSFWorkbook wb;
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		// TODO Auto-generated method stub
		setExcel("TestData", "Data");
		addData(1,1,"123");
		addData(1,2,"hema");
		addData(1,3,"wari");
		System.out.println(readData(1,1));
		System.out.println(readData(1,2));
		wb.write(new FileOutputStream("src/test/resources/data/TestData.xlsx"));
		wb.close();
		}
	public static void setExcel(String workbook, String sheet) throws FileNotFoundException, IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("src/test/resources/data/"+workbook+".xlsx"));
		sh = wb.getSheet(sheet);
	}
	public static void addData(int row_count, int col_count, Object data)
	{
		XSSFRow row = null;
		if(sh.getRow(row_count-1)==null)
		{
		 row = sh.createRow(row_count-1);
		}
	else 
	{
		row = sh.getRow(row_count-1);
		}
	XSSFCell cell = row.createCell(col_count-1);
	cell.setCellValue(data.toString());
	}
	public static String readData(int row_count, int col_count)
	{
		Object data = null;
		XSSFRow row = sh.getRow(row_count-1);
		XSSFCell cell = row.getCell(col_count-1);
		try
		{
			data = cell.getNumericCellValue();
		}
		catch(Exception e)
		{
			if(e.getMessage().contains("STRING"))
			{
				data = cell.getStringCellValue();
			}
				else if(e.getMessage().contains("BOOLEAN"))
				data = cell.getBooleanCellValue();
		}
		return data.toString();
	}
	public static void saveExcel(String workbook) throws FileNotFoundException, IOException
	{
		wb.write(new FileOutputStream("src/test/resources/data/"+workbook+".xlsx"));	
	}
	public static Object[][] dataProvider(String workbook, String sheet) throws FileNotFoundException, IOException
	{
		setExcel(workbook,sheet);
		int i=0,j=0;
		while(readData(i,1)!=null)
		{
			i++;
		}
		while(readData(1,j)!=null)
		{
			j++;
		}
		Object[][] data = new Object[i-1][j-1];
		for(int a=0;a<i;a++)
		{
			for(int b=0;b<j;b++)
			{
				data[a][b] = readData(a+1,b+1);
			}
		}
		return data;
	}
	
}
