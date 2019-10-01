package TestCases;

import CoreComponents.ReusableLibrary;
import TestPages.LoginPage;

public class TCLoginPage extends ReusableLibrary{

	public LoginPage loginPageObj;
	
	public TCLoginPage() {
		super();
		loginPageObj = new LoginPage();
	}
	
	public void validateLoginFunctionality() {
		loginPageObj.loginToApp();
	}
}
