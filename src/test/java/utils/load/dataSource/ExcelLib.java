package utils.load.dataSource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	String excelPath = "src/test/resources/NCTestDataSheet.xls";

	public String getExcelData(String sheetName, int rowNum, int colNum)
			throws InvalidFormatException, IOException {

		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell c = row.getCell(colNum);
		c.setCellType(Cell.CELL_TYPE_STRING);
		String data = c.getStringCellValue();
		data = data.toString();
		return data;
	}

	public String getDateExcelData(String sheetName, int rowNum, int colNum)
			throws InvalidFormatException, IOException {

		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell c = row.getCell(colNum);
		DataFormatter fmt = new DataFormatter();
		String data = fmt.formatCellValue(c);
		return data;
	}

	public Row getRow(String sheetName, int rowNum)
			throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		return row;
	}

	public int getRowCount(String sheetName) throws InvalidFormatException,
			IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}

	public void setExcelData(String sheetName, int rowNum, int colNum,
			String data) throws InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		if (row == null) {
			sh.createRow(rowNum);
		}
		Cell cel = row.getCell(colNum, Row.CREATE_NULL_AS_BLANK);
		if (cel == null) {
			cel = row.createCell(colNum);
		}
		cel.setCellType(Cell.CELL_TYPE_STRING);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
	}

}
