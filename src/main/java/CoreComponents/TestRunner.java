package CoreComponents;

import java.util.ArrayList;
import java.util.HashMap;

import com.relevantcodes.extentreports.LogStatus;

import SupportingComponents.ExcelDriver;
import SupportingComponents.ExtentReportRunner;
import SupportingComponents.FileHandling;
import SupportingComponents.WebDriverFactory;

public class TestRunner extends ReusableLibrary {

	public static HashMap<String,String> testParms;
	public static ArrayList<Object> dataTableContent;
	public static String dataTablePath;
	
	
	public static void runTest(HashMap<String,HashMap<String,String>> runDetails){
		
			
		for(String testID:runDetails.keySet()) {
			ExtentReportRunner.setUpReport(testID);
			testParms = runDetails.get(testID);
			dataTablePath = System.getProperty("user.dir")+"\\src\\resources\\java\\DataTables\\"+testParms.get("Test Scenario");
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
		
		try {
			Class<?> c= Class.forName(testParms.get("Test Scenario"));
			Object obj = c.getDeclaredConstructor(null).newInstance(null);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void testSetup(HashMap<String,String> testParms) {
		WebDriverFactory.setDriverInstance(testParms.get("Browser Name"));
	}
	
}
