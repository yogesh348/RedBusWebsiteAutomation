package com.selenium.Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.Pages.BusHirePage;

import Utils.ReadExcel;

public class BusHireTest extends BaseTest {
	public final static Logger logger = Logger.getLogger(BusHireTest.class);

	@DataProvider(name = "BusHireOutstation")
	public Object[][] BusHireOutstation() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("ExcelPath"), "BusHireOutstation");
		return arrayObject;
	}

	@DataProvider(name = "BusHireLocal")
	public Object[][] BusHireLocal() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("ExcelPath"), "BusHireLocal");
		return arrayObject;
	}

	@DataProvider(name = "BusHireAirPot")
	public Object[][] BusHireAirPot() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("ExcelPath"), "BusHireAirPot");
		return arrayObject;
	}

	@Test(dataProvider = "BusHireOutstation")
	public void OutstationType(String Source, String Destination, String NoOfPassenger, String Status)
			throws InterruptedException {
		extentTest = extent.startTest("Woking on Outstation journey Type");
		logger.info("Select The Oustation Journey Type");
		BusHirePage Hire = new BusHirePage(driver);
		if (Status.equals("Yes")) {
			logger.info("Click On BusHire");
			Hire.ClickRedBus();
			logger.info("Click On Outstation journey");
			Hire.ClickOutstation();
			logger.info("Enter the Source Location");
			logger.info("Enter the Destination Location");
			Hire.EnterSource(Source);
			Hire.EnterDestination(Destination);
			logger.info("Click On Date");
			Hire.ClickFromDate();
			logger.info("Select the Date and press ok");
			Hire.ClickTillDate();
			logger.info("Enter Max Passenger");
			Hire.EnterMaxPassenger(NoOfPassenger);
			logger.info("Click On procced");
			Hire.ClickProceed();
			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Fill Contact Details')]")).getText(),
					"Fill Contact Details");
			logger.info("Successfully move to Next Page");
		}

	}

	@Test(dataProvider = "BusHireLocal")
	public void LocalType(String Source, String NoOfPassenger,String Status) throws InterruptedException {
		extentTest = extent.startTest("Woking on Local journey Type");
		logger.info("Select The Local Journey Type");
		BusHirePage Hire = new BusHirePage(driver);
		if (Status.equals("Yes")) {
			logger.info("Click on Red BusHire");
			Hire.ClickRedBus();
			logger.info("Click on Journey Type");
			Hire.clickLocal();
			logger.info("Enter the Source Location");
			Hire.EnterLocalSource(Source);
			logger.info("Select the Date");
			Hire.ClickWhenDate();
			logger.info("Enter No of passenger");
			Hire.EnterMaxPassenger(NoOfPassenger);
			logger.info("Click on Proceed");
			Hire.ClickLocalProceed();
			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Fill Contact Details')]")).getText(),
					"Fill Contact Details");
			logger.info("Succesfully Move to Next Page");
		}
	}

	@Test(dataProvider = "BusHireAirPot")
	public void AirPortType(String Source, String NoOfPassenger,String Status) throws InterruptedException {
		logger.info("Select The AirPotType Journey Type");
		extentTest = extent.startTest("Woking on AirPot journey Type");
		BusHirePage Hire = new BusHirePage(driver);
		if (Status.equals("Yes")) {
			logger.info("Click on RedBusHire");
			Hire.ClickRedBus();
			logger.info("Select The AirPot Journey Type");
			Hire.ClickAirPot();
			logger.info("Select The City");
			Hire.SelectCity(Source);
			logger.info("Select The Date");
			Thread.sleep(2000);
			Hire.EnterDate();
			logger.info("Enter No of Passenger");
			Hire.EnterMaxPassenger(NoOfPassenger);
			logger.info("Select The Local Journey Type");
			Hire.ClickAirPotProceed();
			Assert.assertEquals(
					driver.findElement(By.xpath("//div[contains(text(),'Fill Contact Details')]")).getText(),
					"Fill Contact Details");
			logger.info("Succesfully Move to Next Page");
		}
	}
}
