package hRm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileLibrary {
	
	public String readDataFromExcelFile(String SheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(SheetName);
		Row rw=sheet.getRow(rowNo);
		Cell ce=rw.getCell(cellNo);
		String value=ce.getStringCellValue();
		return value;
	}
	
	
	
	
	public void writeDataIntoExcelFile(String sheetName, int rowNo, int cellNo, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowNo);
		Cell ce=rw.createCell(cellNo);
		ce.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantLibrary.excelFilePath);
		wb.write(fos);
		wb.close();
		System.out.println("Data written successfully");
		
	}
	
	
	public Object[][] readMutipleDataFromExcelFile(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRowNo=sh.getLastRowNum();
		int lastCellNo=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRowNo][lastCellNo];
		
		for(int i=0;i<lastRowNo;i++)
		{
			for(int j=0;j<lastCellNo;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	

}
