package CoreComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * 
 * @author Tejesh Gangari
 * Desc: This class holds all the reusable instances across the framework
 *
 */
public class ReusableLibrary {
	
	public static String userDir = System.getProperty("user.dir");
	static public WebDriver driver;
	static public Properties prop;
	static public ExtentReports extReport;
	static public ExtentTest extTestLogger;	
	public static ArrayList<String> keywords = new ArrayList<String>();
	public static HashMap<String, String> testData = new HashMap<String, String>();
	public static FileInputStream fi;
	
	public ReusableLibrary() {
		try {
			fi = new FileInputStream(new File(userDir+"\\src\\resources\\java\\GlobalSettings.properties"));
			prop.load(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
