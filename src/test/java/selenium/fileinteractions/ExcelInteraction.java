package selenium.fileinteractions;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import com.google.common.collect.Iterators;

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
	

	public String getValueUsingRowCol(String ExcelName, String SheetName, int Row, int Col) {
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
	

	public void addValueUsingRowCol(String ExcelName, String SheetName, int Row, int Col, String ExcelValue) {
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
	
	
	public Map<String, String> getValuesUsingTestCaseName(String ExcelName, String SheetName, String TestCaseName) {
		InitializeExcelSheet(ExcelName, SheetName);
		Iterator<Row> totalrows = sheet.rowIterator();
		Row firstrow = totalrows.next();    //this will bring focus on to the first row of excel sheet
		
		//Now try to get all columns names in the first row. And search in which column TestCase header is present
		Iterator<Cell> firstrowvalues = firstrow.cellIterator();
		
		int testflag = 0;
		int testcasecolumnnumber=0;
		Map<String, String> TestCaseValues = new LinkedHashMap<String, String>();
		List<String> sheetcolnames = new ArrayList<String>();
		
		while(firstrowvalues.hasNext()) {
			Cell cellValue = firstrowvalues.next();
			TestCaseValues.put(cellValue.getStringCellValue(), "");		//Saving all the column headers in map with empty string						
			sheetcolnames.add(cellValue.getStringCellValue());			//Saving all the column headers in list
			
			if((testcasecolumnnumber==0) && (cellValue.getStringCellValue().equalsIgnoreCase("TestCase"))) {
				testcasecolumnnumber=testflag;		//Taking 'TestCase' column number
			}
			testflag++;
		}		
		
		firstrowvalues = firstrow.cellIterator();
		int CellCount = Iterators.size(firstrowvalues);
		if(testcasecolumnnumber>=CellCount) {
			assertTrue("No 'TestCase' Column In Excel", false);
		}
		
		int rownumber=0;
		totalrows = sheet.rowIterator();	//We are making row focus back to first row (index=0)  
		while(totalrows.hasNext()) {
			Row rowvalue = totalrows.next();
			if(rowvalue.getCell(testcasecolumnnumber).getStringCellValue().equalsIgnoreCase(TestCaseName)) {
				break;
			}
			rownumber++;
		}

		Iterator<Cell> requiredrowvalues = sheet.getRow(rownumber).cellIterator();
		
		int flag = 0;
		while(requiredrowvalues.hasNext()) {
			Cell requiredcellvalue = requiredrowvalues.next();
			if(requiredcellvalue.getCellType() == CellType.STRING) {
				TestCaseValues.replace(sheetcolnames.get(flag), requiredcellvalue.getStringCellValue());		//This will add value in respective column
			} else {
				double requiredcellnumvalue = requiredcellvalue.getNumericCellValue();
				TestCaseValues.replace(sheetcolnames.get(flag), String.valueOf(requiredcellnumvalue));
			}
			flag++;
		}
		
		CloseExcel();
		return TestCaseValues;
	}

	
	public static void main(String Args[]) {
		ExcelInteraction obj = new ExcelInteraction();
		//The below method gives all values for that particular test case
		Map<String, String> RowValues = obj.getValuesUsingTestCaseName("Data", "Testing", "TC3");
		
		System.out.println("TestCase Values - "+RowValues);
		System.out.println("Value - "+RowValues.get("Password"));		//Provide column name to get value
	}
	
}
