package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {
	
	static public FileInputStream fi;
	static public XSSFWorkbook wb;
	static public XSSFSheet sheet;
	static public Row row;
	static public HashMap<String,HashMap<String,String>> dataTable = new HashMap<String,HashMap<String,String>>();
	static public String testID;
	static public boolean isTestIDEmpty = false;
	
	public static HashMap<String,HashMap<String,String>> getRunDetails(){
		
		String execFlag;
		HashMap<String,String> map = new HashMap<String, String>();
		
		wb = FileHandling.getWorkBook(System.getProperty("user.dir")+"\\Run Manager.xlsx");
		
		sheet = wb.getSheetAt(0); //Getting the Run Manager details from the first sheet
		int rowCount = sheet.getLastRowNum();
		for(int i=1;i<=rowCount;i++) {
			row = sheet.getRow(i);
			int colCount = row.getLastCellNum();
			for(int j=0;j<colCount;j++) {
				execFlag = sheet.getRow(i).getCell(3).getStringCellValue();
				testID = sheet.getRow(i).getCell(1).getStringCellValue();
				if(!testID.isEmpty()) {
					if(execFlag.equalsIgnoreCase("YES")) {						
						map.put(sheet.getRow(0).getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
					}else {
						break;
					}
				}else {
					isTestIDEmpty = true;
					break;
				}
			}
			if(!isTestIDEmpty) {
				if(!map.isEmpty()) {
					HashMap<String,String> temp = new HashMap<String,String>();
					temp.putAll(map);
					map.clear();
					dataTable.put(testID, temp);
				}else {
					continue;
				}
			}else {
				break;
			}
		}
		
		return dataTable;
	}
	
	
	public static ArrayList<Object> getDataTableContent(String filePath,String testID){
		XSSFSheet bfSheet,tdSheet;
		HashMap<String,String> testData = new HashMap<String, String>();
		String bfTestID,tdTestID;
		Row row;
		Cell cell;
		String cellValue;
		List<String> keywords = new ArrayList<String>();
		ArrayList<Object> dataTable = new ArrayList<Object>();
		
		wb = FileHandling.getWorkBook(filePath);
		bfSheet = wb.getSheetAt(0); //Index 0 is for BusinessFlow sheet
		tdSheet = wb.getSheetAt(1); //Index 1 is for Test data sheet
		
		//Block for reading BusinessFlow data
		int bfRowCount = bfSheet.getLastRowNum();
		for(int i=1;i<=bfRowCount;i++) {
			row = bfSheet.getRow(i);
			bfTestID = row.getCell(0).getStringCellValue();
			if(!bfTestID.isEmpty()) {
				if(bfTestID.equals(testID)) {
					int bfColCount = row.getLastCellNum();
					for(int j=1;j<bfColCount;j++) {
						cellValue = row.getCell(j).getStringCellValue();
						keywords.add(cellValue);
					}
				}
			}else {
				break;
			}
		}
		
		//Block for reading Test data
		int tdRowCount = tdSheet.getLastRowNum();
		for(int i=1;i<=tdRowCount;i++) {
			row = tdSheet.getRow(i);
			tdTestID = row.getCell(0).getStringCellValue();
			if(!tdTestID.isEmpty()) {
				if(tdTestID.equals(testID)) {
					int tdColCount = row.getLastCellNum();
					for(int j=1;j<tdColCount;j++) {
						cellValue = row.getCell(j).getStringCellValue();
						testData.put(tdSheet.getRow(0).getCell(j).getStringCellValue(), cellValue);
					}
				}
			}else {
				break;
			}
		}
		
		dataTable.add(keywords);
		dataTable.add(testData);
		
		return dataTable;
	}
	 
}
