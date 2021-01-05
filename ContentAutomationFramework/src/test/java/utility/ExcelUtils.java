package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import config.Constants;
import executionEngine.ConfigReader;
import executionEngine.DriverScript;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	static ConfigReader configReader;


	public static void setExcelFile(String Path) throws Exception {
		FileInputStream ExcelFile = new FileInputStream(Path);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
	}

	// This method is to read the test data from the Excel cell

	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception {
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}
	
	 public static boolean compareTwoCells(XSSFCell cell1, XSSFCell cell2) {
		 
		 
	        if((cell1 == null) && (cell2 == null)) {
	            return true;
	        } else if((cell1 == null) || (cell2 == null)) {
	            return false;
	        }
	       
	        boolean equalCells = false;
              if (cell1.getStringCellValue().equals(
	                            cell2.getStringCellValue())) {
	                        equalCells = true;
	                    }
	                           
	        return equalCells;
	    
	}

	// This method is to get the row count used of the excel sheet

	public static int getRowCount(String SheetName) {
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number = ExcelWSheet.getLastRowNum() + 1;
		return number;
	}

	// This method is to get the Row number of the test case

	public static int getRowContains(String sTestCaseName, int colNum, String SheetName) throws Exception {
		int i;
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int rowCount = ExcelUtils.getRowCount(SheetName);
		for (i = 0; i < rowCount; i++) {
			if (ExcelUtils.getCellData(i, colNum, SheetName).equalsIgnoreCase(sTestCaseName)) {
				break;
			}
		}
		return i;
	}

	// This method is to get the count of the test steps of test case

	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception {
		
		for (int i = iTestCaseStart; i <= ExcelUtils.getRowCount(SheetName); i++) {
			if (!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_WebPageName, SheetName))) {
				int number = i;
				return number;
			}
		}
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int number = ExcelWSheet.getLastRowNum() + 1;
		return number;
	}

	public static void setCellData(String Result,  int RowNum, int ColNum, String SheetName) throws Exception    {
	    try{
	 
	    ExcelWSheet = ExcelWBook.getSheet(SheetName);
	    XSSFRow Row = ExcelWSheet.getRow(RowNum);
	    Cell = Row.getCell(ColNum);
	    if (Cell == null) {
	    Cell = Row.createCell(ColNum);
	    Cell.setCellValue(Result);
	    } else {
	 Cell.setCellValue(Result);
	 }
	 // Constant variables Test Data path and Test Data file name
	 FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData);
	 ExcelWBook.write(fileOut);
	 //fileOut.flush();
	 fileOut.close();
	 ExcelWBook = new XSSFWorkbook(new FileInputStream(Constants.Path_TestData));
	 }catch(Exception e){
	 DriverScript.bResult = false;
	 }
	 }	


}
