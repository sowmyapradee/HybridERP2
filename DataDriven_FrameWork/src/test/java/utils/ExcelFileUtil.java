package utils;

import java.awt.image.IndexColorModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {
	XSSFWorkbook wb;
    public ExcelFileUtil(String ExcelPath) throws IOException {
    	FileInputStream fi = new FileInputStream(ExcelPath);
    	wb = new XSSFWorkbook(fi); 	
    }
    
    public int countRow(String SheetName) {
      return wb.getSheet(SheetName).getLastRowNum();
    }
	 
    public String getData(String SheetName,int row,int col) {
    	String data;
    	if(wb.getSheet(SheetName).getRow(row).getCell(col).getCellType()== CellType.NUMERIC) {   		
    	 int cellDate = (int) wb.getSheet(SheetName).getRow(row).getCell(col).getNumericCellValue();
    	 data = String.valueOf(cellDate);
    }
    	else {
    		data = wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
    	}
    	return(data);
    }
    
    public void createData(String SheetName, int row, int col, String ExcelWrite, String Status) throws Throwable {
    	wb.getSheet(SheetName).getRow(row).createCell(col).setCellValue(Status);
    	if(Status.equalsIgnoreCase("PASS"))
    	{
    		XSSFCellStyle style = wb.createCellStyle();
    		XSSFFont font = wb.createFont();
    		font.setColor(IndexedColors.BLUE.getIndex());
    		font.setBold(true);
    		style.setFont(font);
    		wb.getSheet(SheetName).getRow(row).getCell(col).getCellStyle(style);
    	}
    	else
    	{
    			XSSFCellStyle style = wb.createCellStyle();
        		XSSFFont font = wb.createFont();
        		font.setColor(IndexedColors.RED.getIndex());
        		font.setBold(true);
        		style.setFont(font);
        		wb.getSheet(SheetName).getRow(row).getCell(col).getCellStyle(style);
   
    	}
        FileOutputStream fo = new FileOutputStream(ExcelWrite);
        wb.write(fo);
    }

}
