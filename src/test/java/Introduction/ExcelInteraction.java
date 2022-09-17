package Introduction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

/**
 * @author Karthik Vemulapalli
 * This Class is about Excel Interaction commands
 */


public class ExcelInteraction {

	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private void InitializeExcelSheet(String ExcelName, String SheetName) {
		try {

			String CurrentDirectory = System.getProperty("user.dir");
			file = new File(CurrentDirectory + "\\src\\test\\resources\\Excel\\" + ExcelName + ".xlsx");

			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(SheetName);

		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Failed: ExcelSheet Intialization Exception");
		}
	}

	private void CloseExcel() {
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
			workbook.close();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Failed: ExcelSheet Close Exception");
		}
	}
	

	public String getExcelValue(String ExcelName, String SheetName, int Row, int Col) {
		String ExcelValue="";
		try {
			InitializeExcelSheet(ExcelName, SheetName);
			//Fetch value from Excel sheet
			ExcelValue = sheet.getRow(Row).getCell(Col).getStringCellValue();

			CloseExcel();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Failed: ExcelSheet GetValue Exception");
		}
		return ExcelValue;
	}

	public void updateExcelValue(String ExcelName, String SheetName, String ExcelValue, int Row, int Col) {
		try {
			InitializeExcelSheet(ExcelName, SheetName);
			//Provide values to excel sheet
			//If only Row is Active, we make Cell as Active and Assign Value to that
			sheet.getRow(Row).createCell(Col).setAsActiveCell();
			
			sheet.getRow(Row).getCell(Col).setCellValue(ExcelValue);
			//sheet.createRow(Row).createCell(Col).setCellValue(ExcelValue);
			CloseExcel();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Failed: ExcelSheet UpdateValue Exception");
		}
	}
	
}
