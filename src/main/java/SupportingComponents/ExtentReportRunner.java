package SupportingComponents;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import CoreComponents.ReusableLibrary;

public class ExtentReportRunner extends ReusableLibrary{

		
	
	  @BeforeMethod 
	public static void setUpReport(String scenarioName, String testName) {
		extReport = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\"+scenarioName+"\\"+testName+" "+getCurrentTimeStamp()+".html", true);
		extReport.addSystemInfo("Host Name", "InnoMind");
		extReport.addSystemInfo("Test Type", "Automation Testing");
		extReport.addSystemInfo("User", "Tejesh Gangari");
		extReport.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		extTestLogger = extReport.startTest(testName);
	}
	 
	
	
	@AfterMethod
	 public static void getResult(ITestResult result){
		 if(result.getStatus() == ITestResult.FAILURE){
			 extTestLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			 extTestLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		 }else if(result.getStatus() == ITestResult.SKIP){
			 extTestLogger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
	
	
	}
	
	public static void endReport() {
		extReport.endTest(extTestLogger);
		extReport.flush();
		extReport.close();
	}
	@Test
	public static String getCurrentTimeStamp() {
		return new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new Date());
	}
}
