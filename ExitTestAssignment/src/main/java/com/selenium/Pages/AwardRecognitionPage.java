package com.selenium.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AwardRecognitionPage   {

	public WebDriver driver;

	// using Pagefactory concept
	public AwardRecognitionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Here we are declaring the locator for each test cases
	@FindBy(how = How.XPATH, using = "//*[@id=\"awards_div\"]/section/div/div[2]/div[2]/a/div/div[1]/img")
	public WebElement MostTrustBrand;
	
	public void ClickBrand() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		MostTrustBrand.click();
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Leave a comment')]")
	public WebElement LeaveComment;
	
	public void ClickLeaveComment() {
		LeaveComment.click();
	}
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='comment']")
	public WebElement AddComment;
	
	public void AddComment(String Comment) {
		AddComment.sendKeys(Comment);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	public WebElement Email;
	
	public void EnterMail(String Mail) {
		Email.sendKeys(Mail);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"author\"]")
	public WebElement Name;
	
	public void EnterName(String UserName) {
		Name.sendKeys(UserName);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='comment-submit']")
	public WebElement PostComment;
	
	public void ClickPostComment( ) {
		PostComment.click();
	}
	
	
	
	
}
	
