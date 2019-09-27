package CoreComponents;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import SupportingComponents.DataTableReader;

/**
 * 
 * @author Tejesh Gangari
 * Desc: This class holds all the reusable instances across the framework
 *
 */
public class ReusableLibrary {

	public WebDriver driver;
	public Properties prop;
	public ExtentReports extReport;
	public ExtentTest extTestLogger;
	public DataTableReader dataTable;
	
	public ReusableLibrary() {
		
	}
}
