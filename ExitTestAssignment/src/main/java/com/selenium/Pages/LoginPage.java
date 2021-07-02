package com.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;

	// using Pagefactory concept
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	//--------------------------Here we are declaring the locator for each test cases-------------------------
	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	public WebElement Profile;

	@FindBy(how = How.ID, using = "signInLink")
	public WebElement SignIn;

	@FindBy(how = How.CLASS_NAME, using = "IP")
	public WebElement MobileNo;

	@FindBy(how = How.ID, using = "selectedPhCode")
	public WebElement Phncode;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'United States')]")
	public WebElement Code;

	@FindBy(how = How.ID, using = "g_id_onload")
	public WebElement SignInGoogle;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
	public WebElement Next;

	@FindBy(how = How.XPATH, using = "//*[@id=\"identifierId\"]")
	public WebElement UserName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	public WebElement Password;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement closeIcon;

	//Method for Click on UserProfile
	public void UserProfile() {
		Profile.click();
	}

	//Method for Click on SignIn Button
	public void ClickSignIn() {
		SignIn.click();
	}

	//Method for Enter Mobile No
	public void InputNo(String Number) {
		MobileNo.sendKeys(Number);
	}

	//Method for Select the PinCode
	public void SeletePhCode() {
		Phncode.click();
		Code.click();
	}

	//Method for Switching the Frame
	public void Switch() {
		WebElement framet = driver.findElement(By.className("modalIframe"));
		driver.switchTo().frame(framet);
	}

	//Method for Click SignIn
	public void ClickSignin() {
		WebElement waitElement1 = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("g_id_onload")));
		SignInGoogle.click();
	}

	//Method for Click Next Button
	public void ClickNext() {
		Next.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"passwordNext\"]/div/button/span")
	public WebElement PassNext;

	//Method for Next Button
	public void ClickNextPas() {
		PassNext.click();
	}

	//Method for Enter UserName
	public void EnterUserName(String Name) {
		UserName.sendKeys(Name);
	}

	//Method for Enter Password
	public void EnterPassword(String Pass) {
		Password.sendKeys(Pass);
	}

	//Method for Click Close
	public void ClickClose() {
		closeIcon.click();
	}
}