package TestPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import CoreComponents.ReusableLibrary;

public class LoginPage extends ReusableLibrary{
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void loginToApp() {
		driver.get(prop.getProperty("ApplicationURL"));
		userName.sendKeys(testData.get("User Name"));
		extTestLogger.log(LogStatus.INFO, "User name entered");
		password.sendKeys(testData.get("Password"));
		loginButton.click();
	}
}
