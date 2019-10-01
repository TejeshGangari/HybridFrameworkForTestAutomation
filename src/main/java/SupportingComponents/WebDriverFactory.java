package SupportingComponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CoreComponents.ReusableLibrary;

public class WebDriverFactory extends ReusableLibrary {
	
	public static final String chromeDriverPath = userDir+"\\src\\resources\\java\\Browser Drivers\\chromedriver.exe";
	
	
	public static void setDriverInstance(String browserName) {
		setDriverPath(browserName);
		switch(browserName) {
		case "CHROME":
			driver = new ChromeDriver();
			setDriverProperties();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			setDriverProperties();
			break;
		}
	}
	
	public static void setDriverPath(String browserName) {

		switch(browserName) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
	}
	
	public static void setDriverProperties() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
}
