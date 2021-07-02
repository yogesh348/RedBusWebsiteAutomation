package com.selenium.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBusPage {
	WebDriver driver;

	// using Pagefactory concept
	public SearchBusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// -----------Here we are declaring the locator for each test cases------------
	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	public WebElement Source;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div[1]/div/ul")
	public WebElement SelectSource;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div[2]/div/ul")
	public WebElement SelectDestination;

	@FindBy(how = How.XPATH, using = "//input[@id='dest']")
	public WebElement Destination;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'16')]")
	public WebElement Date;

	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[3]")
	public WebElement ChangeDate;

	@FindBy(how = How.ID, using = "search_btn")
	public WebElement SearchButton;

	@FindBy(how = How.LINK_TEXT, using = "Blog")
	public WebElement Blog;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search-2\"]/form/label/input")
	public WebElement SearchPost;

	@FindBy(how = How.XPATH, using = "//body/div[@id='page']/div[@id='content']/div[1]/aside[1]/section[1]/form[1]/input[1]")
	public WebElement SubmitSearch;

	@FindBy(how = How.XPATH, using = "//*[@id=\"post-305\"]/div[2]/div/a")
	public WebElement ReadMore;

	@FindBy(how = How.XPATH, using = "//span[@id='togglebtn']")
	public WebElement Toggle;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Modify')]")
	public WebElement Modify;

	@FindBy(how = How.XPATH, using = "//input[@id='onward_cal']")
	public WebElement Calender;

	@FindBy(how = How.XPATH, using = "//*[@id=\"rb-calmiddle\"]/ul[2]/li[32]")
	public WebElement ModifyDate;

	@FindBy(how = How.XPATH, using = "//*[@id=\"fixer\"]/section/div/div[4]/button")
	public WebElement Search;

	@FindBy(how = How.XPATH, using = "//span[@id='switchButton']")
	public WebElement Switch;

	// Method for Enter the Source
	public void EnterSource(String Src) {
		Source.sendKeys(Src);
		WebElement waitElement1 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='src']")));
		SelectSource.click();
	}

	// Method for Enter the Destination
	public void EnterDestination(String Dest) {
		Destination.sendKeys(Dest);
		WebElement waitElement1 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='src']")));
		SelectDestination.click();
	}

	// Method for Click on Date
	public void ClickDate() {
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		WebElement waitElement1 = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.className("rb-calendar")));
		String MonthValue = driver.findElement(By.className("monthTitle")).getText();
		String Month = MonthValue.split(" ")[0].trim();
		String year = MonthValue.split(" ")[1].trim();
		while (!(Month.equals("July") && year.equals("2021"))) {
			ChangeDate.click();
			MonthValue = driver.findElement(By.className("monthTitle")).getText();
			Month = MonthValue.split(" ")[0].trim();
			year = MonthValue.split(" ")[1].trim();
		}
		Date.click();
		SearchButton.click();
	}

	// Method for Click On Search
	public void ClickSearch() {
		SearchButton.click();
	}

	// Method for Click On Blog
	public void ClickBlog() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Blog.click();
		String currentParent = driver.getWindowHandle();
		Set<String> next_tab = driver.getWindowHandles();
		for (String window : next_tab) {
			if (!window.equalsIgnoreCase(currentParent)) {
				driver.switchTo().window(window);
			}
		}
	}

	// Method for Search Post
	public void SearchPost(String Post) {
		SearchPost.sendKeys(Post);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"search-2\"]/form/input"));
		js.executeScript("arguments[0].click()", checkbox);
		ReadMore.click();

	}

	// Method for Switch Toggle
	public void ClickToggle() {
		Toggle.click();
	}

	// Method for Modify the result
	public void ClickModify() {
		Modify.click();
	}

	// Method for Switch Button
	public void SwitchButton() {
		Switch.click();
	}

	// Method for Click Calender
	public void ClickCalender() {
		Calender.click();
		ModifyDate.click();
		Search.click();

	}
}
