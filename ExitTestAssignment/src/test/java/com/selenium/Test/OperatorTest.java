package com.selenium.Test;

import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.Pages.OperatorPage;

import Utils.ReadExcel;

public class OperatorTest extends BaseTest {
	public final static Logger logger = Logger.getLogger(OperatorTest.class);

	@DataProvider(name = "TopOperator")
	public Object[][] OperatorPageData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("ExcelPath"), "TopOperator");
		return arrayObject;
	}

	@Test(dataProvider = "TopOperator")
	public void TopOperator(String Source, String Destination, String Status) throws InterruptedException {
		extentTest = extent.startTest("SearchBus Based on Top Operator");
		logger.info("Searching Particular Operator");
		OperatorPage op = new OperatorPage(driver);
		if (Status.equals("Yes")) {
			logger.info("Searching Particular Operator");
			op.ClickOperator();
			logger.info("Enter Source Location");
			op.EnterSource(Source);
			logger.info("Enter Destination location");
			op.EnterDestination(Destination);
			logger.info("Select Onward Date");
			op.clickDate();
			logger.info("Search the Bus");
			op.ClickSearch();
			Assert.assertEquals(driver.getTitle(), "Search Bus Tickets");
			logger.info("Successfully Search the Bus");
		}
	}

	@Test
	public void SwitchOperatorDirectories() {
		extentTest = extent.startTest("Switching Operator Directory");
		OperatorPage op = new OperatorPage(driver);
		logger.info("Click on AllOperator");
		op.ClickAllOperator();
		logger.info("Switching to AcutalHandel");
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
				logger.info("Switch to page 2");
				op.SwitchPage();
				Assert.assertEquals(driver.getTitle(),
						"Find list of bus operators in India. Get more than 2000 bus operators information in redBus, India's largest bus booking site.");
			}
		}
		logger.info("SuccessFully move to Next Page");
	}
}
