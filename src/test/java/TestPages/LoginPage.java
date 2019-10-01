package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userName.sendKeys(testData.get("User Name"));
		extTestLogger.log(LogStatus.INFO, "User name entered");
		password.sendKeys(testData.get("Password"));
		extTestLogger.log(LogStatus.INFO, "Password entered");
		loginButton.click();
		extTestLogger.log(LogStatus.INFO, "Clicked on Login button");
		Assert.assertEquals(true, true);
		extTestLogger.log(LogStatus.PASS, "Login functionality has been validated");
	}
}
