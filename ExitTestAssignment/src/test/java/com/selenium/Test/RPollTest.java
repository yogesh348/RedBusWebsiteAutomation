package com.selenium.Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.Pages.RPollPage;

public class RPollTest extends BaseTest {
	public final static Logger logger = Logger.getLogger(RPollTest.class);

	//Method For Playing YouTube Video in RPoll
	@Test
	public void Play() throws InterruptedException {
		extentTest = extent.startTest("Playing video in RpollPage");
		logger.info("Playing a video in Rpoll");
		RPollPage Roll = new RPollPage(driver);
		logger.info("Click on RPoll");
		Roll.ClickRpoll();
		logger.info("Switching a Frame");
		Roll.Switch();
		logger.info("Click on Youtube Video");
		Roll.ClickPlay();
		logger.info("Successfully Play the Video");
	}

	//Method For Switching Slide Bar in RPoll
	@Test
	public void Switch() throws InterruptedException {
		extentTest = extent.startTest("Switch the sliding Bar");
		logger.info("Switching from Find Ride To Offer Ride");
		RPollPage Roll = new RPollPage(driver);
		logger.info("Click on RPoll");
		Roll.ClickRpoll();
		logger.info("Switching From Find Ride To Offer Ride");
		Roll.SwitchIcon();
		Assert.assertEquals(driver
				.findElement(By.xpath("//*[@id=\"howItWorks\"]/div/div/div[2]/div[2]/div/div/div[2]/div")).getText(),
				"Rs 1000/- EXTRA for 20 seats given every week");
		logger.info("SuccessFully Switch");

	}
}
