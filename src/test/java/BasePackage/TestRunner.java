package BasePackage;

import java.util.ArrayList;
import java.util.HashMap;

import com.relevantcodes.extentreports.LogStatus;

import CoreComponents.ReusableLibrary;
import SupportingComponents.ExtentReportRunner;
import SupportingComponents.WebDriverFactory;
import TestCases.TCLoginPage;
import Utilities.ExcelDriver;
import Utilities.FileHandling;

public class TestRunner extends ReusableLibrary {

	public static HashMap<String,String> testParms;
	public static ArrayList<Object> dataTableContent;
	public static String dataTablePath;
		
	public static void runTest(HashMap<String,HashMap<String,String>> runDetails){
		
			
		for(String testID:runDetails.keySet()) {
			testParms = runDetails.get(testID);
			dataTablePath = System.getProperty("user.dir")+"\\src\\resources\\java\\DataTables\\"+testParms.get("Test Scenario")+".xlsx";
			if(FileHandling.isFileAvailable(dataTablePath)) { //To check if the DataTable is available 
				dataTableContent = ExcelDriver.getDataTableContent(dataTablePath, testID);
				keywords = (ArrayList<String>) dataTableContent.get(0);
				testData = (HashMap<String, String>) dataTableContent.get(1);
				if(!keywords.isEmpty()&&!testData.isEmpty()) {
					
					
					invokeBusineFlow(keywords,testParms);
				}else {
					extTestLogger.log(LogStatus.FAIL, "Businesflow or Test data is not defined for "+testID);
				}
			}
		}
		
	}
	
	public static void invokeBusineFlow(ArrayList<String> keywords,HashMap<String,String> testParms) {
		testSetup(testParms);	
		
		TCLoginPage obj = new TCLoginPage();
		obj.validateLoginFunctionality();
		
		/*
		 * try { Class c=
		 * Class.forName("src.test.java.TestPages."+testParms.get("Test Scenario"));
		 * Object obj = c.getDeclaredConstructor(null).newInstance(null); } catch
		 * (ReflectiveOperationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		testTearDown();
	}
	
	public static void testSetup(HashMap<String,String> testParms) {
		ExtentReportRunner.setUpReport(testParms.get("Test Scenario"),testParms.get("Test Case ID"));
		WebDriverFactory.setDriverInstance(testParms.get("Browser Name"));
	}
	
	public static void testTearDown() {
		ExtentReportRunner.endReport();
		driver.quit();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRunner.runTest(ExcelDriver.getRunDetails());
		
	}
}
