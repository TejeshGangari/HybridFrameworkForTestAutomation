package CoreComponents;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

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
	public ExtentReports report;
	public ExtentTest extTest;
	public DataTableReader dataTable;
	
	public ReusableLibrary() {
		
	}
}
