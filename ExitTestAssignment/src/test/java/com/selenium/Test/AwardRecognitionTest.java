package com.selenium.Test;

import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.Pages.AwardRecognitionPage;

import Utils.ReadExcel;

public class AwardRecognitionTest extends BaseTest {
	public final static Logger logger = Logger.getLogger(AwardRecognitionTest.class);

	@DataProvider(name = "Awardrecognition")
	public Object[][] HomePageData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("ExcelPath"), "Awardrecognition");
		return arrayObject;
	}

	@Test(dataProvider = "Awardrecognition")
	public void TrustedBrand(String Comment, String Mail, String Name,String Status) throws InterruptedException {
		extentTest = extent.startTest("Add Comment to Trusted Brand");
		AwardRecognitionPage Award = new AwardRecognitionPage(driver);
		logger.info("Adding a Comment");
		logger.info("Click On Most Trusted Brand");
		if (Status.equals("Yes")) {
			Award.ClickBrand();
			logger.info("Switching the window");
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String actual : handles) {
				if (!actual.equalsIgnoreCase(currentHandle)) {
					driver.switchTo().window(actual);
					logger.info("Click on Leave Comment");
					Award.ClickLeaveComment();
					logger.info("Adding a Comment");
					Award.AddComment(Comment);
					logger.info("Adding a Mail");
					Award.EnterMail(Mail);
					logger.info("Adding a Name");
					Award.EnterName(Name);
					logger.info("Clicking on PostComment");
					Award.ClickPostComment();
					Assert.assertEquals(driver.getTitle(), "The Brand Trust Report India Study");
				}
			}
		}
		logger.info("SuccessFully move to next page");
	}
}
