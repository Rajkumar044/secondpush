package org.adactin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Base111 {
	public void textBox(WebElement element,String box) {
		element.sendKeys(box);
	}
	public void btnClick(WebElement element) {
		element.click();
	}
	public void dropDown(WebElement element,int i) {
		element.click();
		Select select = new Select(element);
		select.selectByIndex(i);
		
}
	public static String getValueFromExcel(String pathName,String sheetName,int rowNo,int cellNo ) throws IOException {
		File file=new File(pathName);
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		String value="";
		if(cellType==1)
		{
		value = cell.getStringCellValue();	
		}
		else if (DateUtil.isCellDateFormatted(cell)) 
		{
		Date dateCellValue = cell.getDateCellValue();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		value = simpleDateFormat.format(dateCellValue);
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l=(long) numericCellValue;
			value = String.valueOf(l);
		}
		
		return value;
		
		}
	
}
