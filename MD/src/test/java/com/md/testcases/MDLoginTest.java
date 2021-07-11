package com.md.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.md.base.BaseClass;
import com.md.dataprovider.DataProviders;
import com.md.pageobjects.MDLoginPage;
import com.md.utility.Log;

public class MDLoginTest extends BaseClass {
	MDLoginPage logpage_obj;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@Test(groups = "Smoke")
	public void VerifyTitle() {
		Log.startTestCase("VerifyTitle");
		logpage_obj = new MDLoginPage();
		Log.info("Login page getMDtitle");
		String v_A_title = logpage_obj.getMDtitle();
		String v_E_title = "Login";
		Log.info("Login page getMDtitle Assert check");
		Assert.assertEquals(v_A_title, v_E_title);
		Log.endTestCase("VerifyTitle");
	}

	@Test(groups = "Sanity")
	public void VerifyLogo() {
		Log.startTestCase("VerifyLogo");
		logpage_obj = new MDLoginPage();
		Log.info("Login page validateLogo");
		boolean v_logo = logpage_obj.validateLogo();
		Log.info("Login page Logo Assert  check");
		Assert.assertTrue(v_logo);
		Log.endTestCase("VerifyLogo");
	}

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups ="Regression")
	public void verifyLogin(String uname, String pwd) {
		Log.startTestCase("verifyLogin");
		logpage_obj = new MDLoginPage();
		Log.info("User name and password set");
		// logpage_obj.MDlogin(prop.getProperty("username"),
		// prop.getProperty("password"));
		logpage_obj.MDlogin(uname, pwd);
		Log.endTestCase("verifyLogin");
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
