package com.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OperatorPage {
	WebDriver driver;

	// using Pagefactory concept
	public OperatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//-----------------Here we are declaring the locator for test cases------------------------
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Bengal Tiger')]")
	public WebElement TopOperator;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtSource']")
	public WebElement Source;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"C120_suggestion-wrap\"]/li[1]/strong")
	public WebElement SelectSource;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtDestination']")
	public WebElement Destination;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"C120_suggestion-wrap\"]/li[5]/strong")
	public WebElement SelectDestination;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"rb-calmiddle\"]/ul[2]/li[26]")
	public WebElement Date;

	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[3]")
	public WebElement ChangeDate;

	@FindBy(how = How.XPATH, using = "//input[@id='txtOnwardCalendar']")
	public WebElement OnwardDate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[1]/div[3]/button")
	public WebElement SearchButton;

	@FindBy(how = How.ID, using = "txtOnwardCalendar")
	public WebElement dateOperator;

	@FindBy(how = How.XPATH, using = "//*[@id=\"rb-calmiddle\"]/ul[2]/li[33]/span")
	public WebElement dateNumber;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'All Operators >')]")
	public WebElement AllOperator;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'2')]")
	public WebElement Alphabet;

	public void ClickOperator() {
		WebElement waitElement1 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Bengal Tiger')]")));
		TopOperator.click();
	}

	public void EnterSource(String Src) {
		Source.sendKeys(Src);
//		WebElement waitElement1 = (new WebDriverWait(driver, 10))
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtSource']")));

		SelectSource.click();
	}

	public void EnterDestination(String Dest) {
		Destination.sendKeys(Dest);
		WebElement waitElement1 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='txtDestination']")));
		SelectDestination.click();
	}


	public void clickDate() {
		dateOperator.click();
		dateNumber.click();

	}

	public void ClickSearch() {
		SearchButton.click();
	}

	public void ClickAllOperator() {
		AllOperator.click();
	}


	public void SwitchPage() {
		Alphabet.click();
	}
}
