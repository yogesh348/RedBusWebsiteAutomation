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

	// Here we are declaring the locator for each test cases
	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	public WebElement Profile;

	public void UserProfile() {
		Profile.click();
	}

	@FindBy(how = How.ID, using = "signInLink")
	public WebElement SignIn;

	public void ClickSignIn() {
		SignIn.click();
	}

	@FindBy(how = How.CLASS_NAME, using = "IP")
	public WebElement MobileNo;

	public void InputNo(String Number) {
		MobileNo.sendKeys(Number);
	}

	@FindBy(how = How.ID, using = "selectedPhCode")
	public WebElement Phncode;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'United States')]")
	public WebElement Code;

	public void SeletePhCode() {
		Phncode.click();
		Code.click();
	}

	public void Switch() {
		WebElement framet = driver.findElement(By.className("modalIframe"));
		driver.switchTo().frame(framet);
	}

	@FindBy(how = How.ID, using = "g_id_onload")
	public WebElement SignInGoogle;

	public void ClickSignin() {
		WebElement waitElement1 = (new WebDriverWait(driver, 20)).until(
				ExpectedConditions.presenceOfElementLocated(By.id("g_id_onload")));
		SignInGoogle.click();
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
	public WebElement Next;

	public void ClickNext() {
		Next.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"passwordNext\"]/div/button/span")
	public WebElement PassNext;

	public void ClickNextPas() {
		PassNext.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"identifierId\"]")
	public WebElement UserName;

	public void EnterUserName(String Name) {
		UserName.sendKeys(Name);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	public WebElement Password;

	public void EnterPassword(String Pass) {
		Password.sendKeys(Pass);
	}

	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement closeIcon;

	public void ClickClose() {
		closeIcon.click();
	}
}