package CoreComponents;

import SupportingComponents.ExcelDriver;
import SupportingComponents.ExtentReportRunner;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TestRunner.runTest(ExcelDriver.getRunDetails());
		
	}

}
