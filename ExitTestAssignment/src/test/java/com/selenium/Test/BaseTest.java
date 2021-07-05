package com.selenium.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.DockerRemoteDriver;
import Utils.ScreenShots;

public class BaseTest {
	static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static File file = new File(".\\Resources\\config.properties");
	public static FileInputStream fis = null;
	public static Properties prop = new Properties();
	public final static Logger logger = Logger.getLogger(BaseTest.class);

	static {
		try {
			fis = new FileInputStream(file);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method For Creating Extent Report
	@BeforeSuite
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\ExtentReport.html");
	}

	// Method For Taking A ScreenShot
	@AfterMethod
	public void attachScreenshot(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshotPath = ScreenShots.takeScreenShot(driver, result.getName());
			System.out.println(screenshotPath);
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}
		extent.endTest(extentTest);
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

	// Initializing the Browser
	@BeforeMethod
	public static void intializeWebdriver() throws MalformedURLException {
		if (prop.getProperty("Docker").equalsIgnoreCase("Docker")) {
			driver = DockerRemoteDriver.setUp();
		} else {
			if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
				boolean isHeadlessMode = Boolean.parseBoolean(prop.getProperty("headless"));
				if (isHeadlessMode) {
					// To open Chrome Driver in Headless mode
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--headless");
					options.addArguments("window-size=1920,1080");
					options.addArguments("user-agent=whatever you want");
					driver = new ChromeDriver(options);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} else {
					driver = new ChromeDriver(); // To open Chrome Driver
				}
			} else if (prop.getProperty("browserName").equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", ".\\Driver\\msedgedriver.exe");
				driver = new EdgeDriver(); // To open Edge Driver
			} else if (prop.getProperty("browserName").equalsIgnoreCase("gecko")) {
				System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
				boolean isHeadlessMode = Boolean.parseBoolean(prop.getProperty("headless"));
				if (isHeadlessMode) {
					// To open Chrome Driver in Headless mode
					FirefoxOptions options = new FirefoxOptions();
					options.addArguments("--headless");
					options.addArguments("window-size=1920,1080");
					options.addArguments("user-agent=whatever you want");
					driver = new FirefoxDriver(options);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				} else {
					driver = new FirefoxDriver(); // To open Chrome Driver
				}
			}

			// Implicit Wait
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWaitTimeout")),
					TimeUnit.SECONDS);
		}
	}

	// Method For Opening Chrome Browser
	@BeforeMethod
	public static void openBrowser() {
		logger.info("Launching Chrome Browser");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	// Closing a Browser
	@AfterMethod
	public static void closeBrowser() {
		driver.quit();
		logger.info("Quite Chrome Browser");
		logger.info("-------------------------------------------------------------------------");
	}
}
