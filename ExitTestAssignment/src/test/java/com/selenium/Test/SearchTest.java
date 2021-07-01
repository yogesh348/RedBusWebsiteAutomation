package com.selenium.Test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.Pages.SearchBusPage;

import Utils.ReadExcel;

public class SearchTest extends BaseTest {
	public final static Logger logger = Logger.getLogger(SearchTest.class);

	@DataProvider(name = "SearchBus")
	public Object[][] validSearchBus() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(
				prop.getProperty("ExcelPath"),
				"SearchBus");
		return arrayObject;
	}

	@DataProvider(name = "InvalidSearchBus")
	public Object[][] InvalidSearchBus() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(
				prop.getProperty("ExcelPath"),
				"InvalidSearchBus");
		return arrayObject;
	}

	@Test(dataProvider = "SearchBus")
	public void SearchBus(String City1, String City2, String Status) throws InterruptedException {
		extentTest = extent.startTest("Searching the Bus Based on Location");
		logger.info("Searching  Bus");
		SearchBusPage Search = new SearchBusPage(driver);
		if (Status.equals("Yes")) {
			logger.info("Enter the Source City ");
			Search.EnterSource(City1);
			logger.info("Enter the Destination City");
			Search.EnterDestination(City2);
			logger.info("Click On Date");
			Search.ClickDate();
			Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "Delhi to Chandigarh Bus Tickets Booking, Save upto 25% - redBus");
			logger.info("Successfull Search Bus Based On City");
		}
	}

	@Test(dataProvider = "InvalidSearchBus")
	public void InvalidSearchBus(String City1, String City2, String Status) throws InterruptedException {
		extentTest = extent.startTest("SearchBus with InValid Credentials");
		logger.info("Searching Bus Based On invalid Credential");
		SearchBusPage Search = new SearchBusPage(driver);
		if (Status.equals("Yes")) {
			logger.info("Enter Source City");
			Search.EnterSource(City1);
			logger.info("Enter Destination City");
			Search.EnterDestination(City2);
			logger.info("Leave the datedirectly click on search");
			Search.ClickSearch();
			Assert.assertEquals(driver.getTitle(), "Delhi to Chandigarh Bus Tickets Booking, Save upto 25% - redBus");
			logger.info("Getting Assertion Error");
		}
	}

	@Test
	public void Blog() throws InterruptedException {
		extentTest = extent.startTest("Searching Detail");
		SearchBusPage Search = new SearchBusPage(driver);
		logger.info("Click On Blog");
		Search.ClickBlog();
		logger.info("Search Particular Post");
		Search.SearchPost(prop.getProperty("Search"));
		Assert.assertEquals(driver.getTitle(), "Second Wave of Covid-19 - Is it safe to travel by bus? - redBus Blog");
		logger.info("SuccessFully Search ");
	}

	@Test(dataProvider = "SearchBus")
	public void ChangeTogglebar(String City1, String City2, String Status) throws InterruptedException {
		extentTest = extent.startTest("Switching the ToggleBar");
		if (Status.equals("Yes")) {
			SearchBusPage Search = new SearchBusPage(driver);
			logger.info("Enter Source City");
			Search.EnterSource(City1);
			logger.info("Enter Destination City");
			Search.EnterDestination(City2);
			logger.info("Switch the ToggleBar");
			Search.ClickToggle();
			logger.info("Select the Date");
			Search.ClickDate();
			logger.info("Click Search Buses");
			Thread.sleep(1000);
			Assert.assertEquals(driver.getTitle(), "Chandigarh to Delhi Bus Tickets Booking, Save upto 25% - redBus");
			logger.info("Successfully Search the Bus");
		}
	}

	@Test(dataProvider = "SearchBus")
	public void Modifyresult(String City1, String City2, String Status) throws InterruptedException {
		extentTest = extent.startTest("Modify the Result of SearchBus");
		SearchBusPage Search = new SearchBusPage(driver);
		if (Status.equals("Yes")) {
			logger.info("Enter Source City");
			Search.EnterSource(City1);
			logger.info("Enter Destination City");
			Search.EnterDestination(City2);
			logger.info("Select the Date");
			logger.info("Click Search Buses");
			Search.ClickDate();
			logger.info("Click On Modify");
			Search.ClickModify();
			logger.info("Switch the ToggleBar");
			Search.SwitchButton();
			logger.info("Select date And Search");
			Search.ClickCalender();
			Thread.sleep(1000);
			Assert.assertEquals(driver.getTitle(), "Chandigarh to Delhi Bus Tickets Booking, Save upto 25% - redBus");
			logger.info("Click On Blog");
			logger.info("Successfully Modify the result");
		}
	}
}
