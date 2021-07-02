package com.selenium.Test;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.Pages.RedBusCarePage;

import Utils.ReadExcel;

public class RedBusCareTest extends BaseTest {
	public final static Logger logger = Logger.getLogger(RedBusCareTest.class);


	//-----------Passing Data From Excel---------------
	@DataProvider(name = "CareFund")
	public Object[][] CarePageData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(
				"C:\\Users\\yougeshghildiyal\\eclipse-workspace\\ExitTestAssignment\\TestData\\TestData.xlsx",
				"CareFund");
		return arrayObject;
	}

	//Method for RedBus Cares
	@Test(dataProvider = "CareFund")
	public void RedBusCare(String Name, String Email, String PhoneNo, String Status) throws InterruptedException {
		extentTest = extent.startTest("RedBus Care Page ");
		logger.info("Filling detail in RedBus CarePage");
		RedBusCarePage Care = new RedBusCarePage(driver);
		if (Status.equals("Yes")) {
			logger.info("Clicking on RedBus Care");
			Care.ClickCare();
			//Switching a Window
			logger.info("Switching to Actual Window");
			String currentParent = driver.getWindowHandle();
			Set<String> next_tab = driver.getWindowHandles();
			for (String window : next_tab) {
				if (!window.equalsIgnoreCase(currentParent)) {
					driver.switchTo().window(window);
					logger.info("Select the amount");
					Care.SelectAmount();
					logger.info("Enter Name,Mail And PhNo of User");
					Care.EnterDetail(Name, Email, PhoneNo);
					Assert.assertEquals(driver.findElement(By.className("font_bd")).getText(), "redBus Cares");
				}
			}
		}
		logger.info("Successfull Submit the Details");
	}
}
