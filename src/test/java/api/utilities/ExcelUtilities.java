package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	

	String path;
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle cellStyle;

	ExcelUtilities(String path) {
		this.path = path;

	}

	public int getRowCount(String sheetName) throws IOException {

		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;

	}

	public int getCellCount(String sheetName,int rowNum) throws IOException {

		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;

	}
	
	public String getCellData(String sheetName,int rowNum,int cellNum) throws IOException {

		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
		data=formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardlessof the cell type
		}
		catch (Exception e) {
			
			data="";
		}
		
		workbook.close();
		fis.close();
		return data;

	}
	public void setCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {

		
		File xlfile = new File(path);
		if(!xlfile.exists()) {
			
			workbook = new XSSFWorkbook();
			fos= new  FileOutputStream(path);
			workbook.write(fos);
		}
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		
		if(workbook.getSheetIndex(sheetName)==-1) 
			workbook.createSheet(sheetName);
		
		sheet = workbook.getSheet(sheetName);
		
		
		if(sheet.getRow(rowNum)==null) 
			row = 	sheet.createRow(rowNum);
		
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fos= new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	public void fillGreenColor(String sheetName, int rowNum, int cellNum) throws IOException {

		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		cellStyle = workbook.createCellStyle();
		cellStyle.setFillForegroundColor(IndexedColors.GREEN.index);
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cellStyle);
		
		fos= new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}
	public void fillRedColor(String sheetName, int rowNum, int cellNum) throws IOException {

		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		cellStyle = workbook.createCellStyle();
		cellStyle.setFillForegroundColor(IndexedColors.RED.index);
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(cellStyle);
		
		fos= new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fis.close();
		fos.close();
	}



}
