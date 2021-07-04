package com.selenium.Test;

import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.Pages.LoginPage;

import Utils.ReadExcel;

public class LoginTest extends BaseTest {
	public final static Logger logger = Logger.getLogger(LoginTest.class);

	// -----------Passing Data From Excel---------------
	@DataProvider(name = "ValidLogin")
	public Object[][] validloginData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("ExcelPath"), "ValidLogin");
		return arrayObject;
	}

	@DataProvider(name = "InValidLogin")
	public Object[][] InvalidloginData() throws Exception {

		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("ExcelPath"), "InValidLogin");
		return arrayObject;
	}

	// Method For User Enter Vaild Detail in Login
	@Test(dataProvider = "ValidLogin")
	public void ValidLogin(String Email, String Password, String Status) throws InterruptedException {
		extentTest = extent.startTest("Login with Valid Credentials");
		LoginPage login = new LoginPage(driver);
		if (Status.equals("Yes")) {
			logger.info("Click On User Profile");
			login.UserProfile();
			logger.info("Click On SignIn");
			login.ClickSignIn();
			login.Switch();
			logger.info("Then Click On Google SignIn Button");
			login.ClickSignin();
			// Switching a Window
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String actual : handles) {
				if (!actual.equalsIgnoreCase(currentHandle)) {
					driver.switchTo().window(actual);
					logger.info("Enter Valid Email");
					login.EnterUserName(Email);
					login.ClickNext();
					logger.info("Enter Valid Password");
					login.EnterPassword(Password);
					logger.info("Then Click Next");
					login.ClickNextPas();
					Thread.sleep(5000);// Using a Thread For Finding Element
					driver.switchTo().window(currentHandle);
				}
			}
			login.ClickClose();
			driver.navigate().refresh();
			Assert.assertEquals(driver.getTitle(),
					"Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India");
			logger.info("User SuccessFully Login to the apllication");
		}
	}

	// Method For User Enter InVaild Detail in Login
	@Test(dataProvider = "InValidLogin")
	public void IN_ValidLogin(String Email, String Password, String Status) throws InterruptedException {
		extentTest = extent.startTest("Login with InValid Credentials");
		LoginPage login = new LoginPage(driver);
		if (Status.equals("Yes")) {
			logger.info("Click On User Profile");
			login.UserProfile();
			logger.info("Click On SignIn");
			login.ClickSignIn();
			login.Switch();
			logger.info("Then Click On Google SignIn Button");
			login.ClickSignin();
			// Switching a Window
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String actual : handles) {
				if (!actual.equalsIgnoreCase(currentHandle)) {
					driver.switchTo().window(actual);
					driver.switchTo().window(actual);
					logger.info("Enter Valid Email");
					login.EnterUserName(Email);
					login.ClickNext();
					logger.info("Enter InValid Password");
					login.EnterPassword(Password);
					driver.navigate().refresh();
					login.ClickNext();
					logger.info("Then Click Next");
					logger.info("User Not Login to the apllication");
					Assert.assertEquals(driver.getTitle(),
							" Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India ");
				}
			}
		}
	}
}
