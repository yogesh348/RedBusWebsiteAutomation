package com.selenium.Test;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.Pages.HomePage;

import Utils.ReadExcel;

public class HomeTest extends BaseTest {
	public final static Logger logger = Logger.getLogger(HomeTest.class);

	//-----------Passing Data From Excel---------------
	@DataProvider(name = "ManageBooking")
	public Object[][] HomePageData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("ExcelPath"), "ManageBooking");
		return arrayObject;
	}

	//Method for Change the Country
	@Test
	public void changeCountry() throws InterruptedException {
		extentTest = extent.startTest("Open the Contact us Page And Click On Help&Support");
		HomePage Page = new HomePage(driver);
		logger.info("Select a Country");
		logger.info("New Window Open with That Redbus Site");
		Page.ChooseCountry();
		//Switching a Window
		String currentHandle = driver.getWindowHandle();
		Set<String> handless = driver.getWindowHandles();
		for (String actual : handless) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
				logger.info("Window Switch Successfully");

			}
		}
		Assert.assertEquals(driver.getTitle(), "Compra Pasajes de Bus Online - redBus Colombia");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.redbus.co/");
		logger.info("New Site Open Based On Choosen Country");

	}

	//Creating a Method For Invalid ManageBooking
	@Test(dataProvider = "ManageBooking")
	public void InvalidManageBooking(String TicketNumber, String Email, String Status) {
		HomePage Page = new HomePage(driver);
		extentTest = extent.startTest("Invalid detail in ManageBooking");
		logger.info("Search Ticket Based On Invalid Data");
		if (Status.equals("Yes")) {
			logger.info("Click On ManageBooking");
			Page.ManageBooking();
			logger.info("Select Show My Ticket");
			Page.ClickShowTicket();
			logger.info("Enter Invalid Ticket No");
			Page.EnterTickerNo(TicketNumber);
			logger.info("Enter Invalid Email");
			Page.EnterEmail(Email);
			logger.info("Click Submit");
			Page.ClickSubmit();
			logger.info("Assertion error");
			Assert.assertEquals(driver.findElement(By.xpath("//span[@id='nf_error']")).getText(),
					"Something went wrong, please try again later");
		}
	}

	//Creating a Method For RPoll Help to Chat with ChatBot
	@Test
	public void RPollHelp() throws InterruptedException {
		extentTest = extent.startTest("Wokring in RpollHelp");
		logger.info("Opening the help Page");
		HomePage Bot = new HomePage(driver);
		logger.info("Click on help Page");
		Bot.ClickHelp();
		logger.info("Switching the window");
		String currentHandle = driver.getWindowHandle();
		Set<String> handless = driver.getWindowHandles();
		for (String actual : handless) {
			if (!actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);
				logger.info("Click on Close icon");
				Bot.ClickClose();
				logger.info("Click on Chat");
				Bot.ClickChat();
				logger.info("Perfoming the Action");
				Bot.ClickSearch();
				Assert.assertEquals(
						driver.findElement(By.xpath("//*[@id=\"chatdiv\"]/div[12]/div/div[1]/div/span")).getText(),
						"We are glad to know that. Thank you for chatting with redBus. Have a wonderful day!");
			}
		}
		logger.info("Closing the Help Page");
	}

	//Method For Contact Page
	@Test
	public void ContactUs() throws InterruptedException {
		extentTest = extent.startTest("Open the Contact us Page And Click On Help&Support");
		HomePage contact = new HomePage(driver);
		logger.info("Click On contact us Page");
		logger.info("Click on Help&Support");
		contact.ClickContactUs();
		//Switching a Window
		String currentHandle = driver.getWindowHandle();
		Set<String> handless = driver.getWindowHandles();
		for (String actual : handless) {
			if (actual.equalsIgnoreCase(currentHandle)) {
				driver.switchTo().window(actual);

			}
		}
		logger.info("Closing Contact us Page");
	}
}
