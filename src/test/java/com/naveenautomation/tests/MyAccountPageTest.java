package com.naveenautomation.tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.testbase.TestBase;
import com.naveenautomation.utility.DataProviderUtils;

public class MyAccountPageTest extends TestBase {

	AccountLoginPage loginPage;
	MyAccountPage accountPage;

	@BeforeMethod
	public void launchBrowser() throws MalformedURLException {
		intialization();
		loginPage = new AccountLoginPage();
	}

	@Test (dataProvider = "validLoginData", dataProviderClass = DataProviderUtils.class)
	public void validateLogin(String username, String password) {
		accountPage = loginPage.submitCorrectLoginInfo(username, password);
		String myAccountText = accountPage.getMyAccountText();
		Assert.assertEquals(myAccountText, "My Account");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}