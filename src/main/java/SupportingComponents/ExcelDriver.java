package SupportingComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {
	
	public FileInputStream fi;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public Row row;
	public HashMap<String,HashMap<String,String>> dataTable = new HashMap<String,HashMap<String,String>>();
	public String testID;
	public boolean isTestIDEmpty = false;
	
	public HashMap<String,HashMap<String,String>> getExcelData(String workbookName,int sheetIndex){
		
		String execFlag;
		HashMap<String,String> map = new HashMap<String, String>();
		
		/*
		 *  ClassLoader cl =
		 * getClass().getClassLoader();
		 * File file = new File(cl.getResource(workbookName).getFile());
		 */
		File file = new File(System.getProperty("user.dir")+"\\Run Manager.xlsx");
		
		try {
			fi = new FileInputStream(file);
			wb = new XSSFWorkbook(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = wb.getSheetAt(sheetIndex);
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
}
