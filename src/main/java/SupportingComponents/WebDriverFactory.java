package SupportingComponents;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CoreComponents.ReusableLibrary;

public class WebDriverFactory extends ReusableLibrary {
	
	public static final String chromeDriverPath = userDir+"\\src\\resource\\java\\Browser Drivers\\Chrome.exe";
	
	
	public static void setDriverInstance(String browserName) {
		setDriverPath(browserName);
		switch(browserName) {
		case "CHROME":
			driver = new ChromeDriver();
		case "FIREFOX":
			driver = new FirefoxDriver();
		}
	}
	
	public static void setDriverPath(String browserName) {

		switch(browserName) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
	}
}
