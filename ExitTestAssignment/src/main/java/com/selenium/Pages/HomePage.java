package com.selenium.Pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	public WebDriver driver;

	// using Pagefactory concept
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Here we are declaring the locator for each test cases
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'colombia')]")
	public WebElement Country;

	public void ChooseCountry() {
		Country.click();
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'SRS Travels')]")
	public WebElement Operator;

	public void ChooseOperator() {
		Operator.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@id='txtOnwardCalendar']")
	public WebElement Calender;

	public void SelectCalender() {
		Calender.click();
	}

	@FindBy(how = How.XPATH, using = " //a[@id='redBus Bus Hire']")
	public WebElement BusHire;

	public void ClickRedBus() {
		BusHire.click();
	}

	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	public WebElement Profile;

	public void ClickUserProfile() {
		Profile.click();
	}

	@FindBy(how = How.XPATH, using = "	//div[contains(text(),'Manage Booking')]")
	public WebElement Booking;

	public void ManageBooking() {
		Booking.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"hmb\"]/div[2]/ul/li[4]/span/span")
	public WebElement ShowTicket;

	public void ClickShowTicket() {
		ShowTicket.click();
	}

	@FindBy(how = How.ID, using = "searchTicketTIN")
	public WebElement TicketNo;

	public void EnterTickerNo(String Number) {
		TicketNo.sendKeys(Number);
	}

	@FindBy(how = How.ID, using = "searchTicketEmail")
	public WebElement Email;

	public void EnterEmail(String UserMail) {
		Email.sendKeys(UserMail);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"ticketSearch\"]")
	public WebElement Submit;

	public void ClickSubmit() {
		Submit.click();
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help')]")
	public WebElement Help;

	public void ClickHelp() {
		Help.click();
	}

	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement closeIcon;

	public void ClickClose() {
		closeIcon.click();
		driver.switchTo().frame(0);
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'New bus booking help')]")
	public WebElement Chat;

	public void ClickChat() {
		Chat.click();
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Careers')]")
	public WebElement Blog;

	public void ClickBlog() throws InterruptedException {
		Thread.sleep(10000);
		Blog.click();
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Availability of buses')]")
	public WebElement Availabel;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'No, thanks')]")
	public WebElement NO;
	@FindBy(how = How.XPATH, using = "//*[@id=\"suggestion-block\"]/div/div[2]")
	public WebElement AgainNO;
	@FindBy(how = How.XPATH, using = "	//div[contains(text(),'😊 Good')]")
	public WebElement FeedBack;

	public void ClickSearch() {
		Availabel.click();
		NO.click();
		AgainNO.click();
		FeedBack.click();

	}
	// Here we are declaring the locator for each test cases
		@FindBy(how = How.LINK_TEXT, using = "Contact Us")
		public WebElement ContactUs;
		@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
		public WebElement Support;
		@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
		public WebElement close;

		public void ClickContactUs() {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			ContactUs.click();
			String currentParent = driver.getWindowHandle();
			Set<String> next_tab = driver.getWindowHandles();
			for (String window : next_tab) {
				if (!window.equalsIgnoreCase(currentParent)) {
					driver.switchTo().window(window);
					Support.click();
				}
			}
		}

		public void Close() {
			close.click();
		}
}
