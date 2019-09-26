package CoreComponents;

import java.util.HashMap;

import SupportingComponents.ExcelDriver;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,HashMap<String,String>> dataTable;
		ExcelDriver excObj = new ExcelDriver();
		dataTable = excObj.getExcelData("Run Manager.xlsx", 0);
		System.out.println(dataTable.size());
	}

}
