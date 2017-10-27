package utils.load.dataSource;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class CopySheet {
	HSSFWorkbook sourceWorkBook, destinationWorkBook;
	HSSFSheet sourceSheet, destinationSheet;

	public void copySheet(String sourceFile, String destinationFile,
			String sourceSheetName) throws Exception {
		sourceWorkBook = new HSSFWorkbook(new FileInputStream(sourceFile));
		sourceSheet = sourceWorkBook.getSheet(sourceSheetName);
		destinationWorkBook = new HSSFWorkbook(new FileInputStream(
				destinationFile));
		destinationSheet = destinationWorkBook.getSheetAt(0);
		for (int i = 0; i <= sourceSheet.getLastRowNum(); i++) {
			copyRow(sourceSheet, destinationSheet, i, i);
		}
		FileOutputStream out = new FileOutputStream(destinationFile);
		destinationWorkBook.write(out);
		out.close();
	}

	private void copyRow(HSSFSheet sourceSheet, HSSFSheet destinationSheet,
			int sourceRowNum, int destinationRowNum) {
		// Get the source / new row
		HSSFRow newRow = destinationSheet.getRow(destinationRowNum);
		HSSFRow sourceRow = sourceSheet.getRow(sourceRowNum);
		if (newRow != null) {
			destinationSheet.removeRow(newRow);
		}
		newRow = destinationSheet.createRow(destinationRowNum);
		// Loop through source columns to add to new row
		for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
			// Grab a copy of the old/new cell
			HSSFCell oldCell = sourceRow.getCell(i);
			HSSFCell newCell = newRow.createCell(i);
			// If the old cell is null jump to next cell
			if (oldCell == null) {
				newCell = null;
				continue;
			}
			// If there is a cell comment, copy
			if (oldCell.getCellComment() != null) {
				newCell.setCellComment(oldCell.getCellComment());
			}
			// If there is a cell hyperlink, copy
			if (oldCell.getHyperlink() != null) {
				newCell.setHyperlink(oldCell.getHyperlink());
			}
			// Set the cell data type
			newCell.setCellType(oldCell.getCellType());
			// Set the cell data value
			switch (oldCell.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				newCell.setCellValue(oldCell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				newCell.setCellValue(oldCell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_ERROR:
				newCell.setCellErrorValue(oldCell.getErrorCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				newCell.setCellFormula(oldCell.getCellFormula());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				newCell.setCellValue(oldCell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				newCell.setCellValue(oldCell.getRichStringCellValue());
				break;
			}
		}
	}
}
