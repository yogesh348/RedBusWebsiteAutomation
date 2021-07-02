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

	//----------------------------Here we are declaring the locator for each test cases----------------------
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'colombia')]")
	public WebElement Country;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'SRS Travels')]")
	public WebElement Operator;

	@FindBy(how = How.XPATH, using = "//input[@id='txtOnwardCalendar']")
	public WebElement Calender;

	@FindBy(how = How.XPATH, using = " //a[@id='redBus Bus Hire']")
	public WebElement BusHire;

	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	public WebElement Profile;

	@FindBy(how = How.XPATH, using = "	//div[contains(text(),'Manage Booking')]")
	public WebElement Booking;

	@FindBy(how = How.XPATH, using = "//*[@id=\"hmb\"]/div[2]/ul/li[4]/span/span")
	public WebElement ShowTicket;

	@FindBy(how = How.ID, using = "searchTicketTIN")
	public WebElement TicketNo;

	@FindBy(how = How.ID, using = "searchTicketEmail")
	public WebElement Email;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ticketSearch\"]")
	public WebElement Submit;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help')]")
	public WebElement Help;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement closeIcon;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'New bus booking help')]")
	public WebElement Chat;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Careers')]")
	public WebElement Blog;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Availability of buses')]")
	public WebElement Availabel;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'No, thanks')]")
	public WebElement NO;

	@FindBy(how = How.XPATH, using = "//*[@id=\"suggestion-block\"]/div/div[2]")
	public WebElement AgainNO;

	@FindBy(how = How.XPATH, using = "	//div[contains(text(),'😊 Good')]")
	public WebElement FeedBack;

	@FindBy(how = How.LINK_TEXT, using = "Contact Us")
	public WebElement ContactUs;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
	public WebElement Support;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement close;

	//Method for Select the Country
	public void ChooseCountry() {
		Country.click();
	}

	//Method for Choose The Operator
	public void ChooseOperator() {
		Operator.click();
	}

	//Method for Select the Calender
	public void SelectCalender() {
		Calender.click();
	}

	//Method for Click on RedBus
	public void ClickRedBus() {
		BusHire.click();
	}

	//Method for Click on User Profile
	public void ClickUserProfile() {
		Profile.click();
	}

	//Method for Click on ManageBooking
	public void ManageBooking() {
		Booking.click();
	}

	//Method for Click on  Show Ticket
	public void ClickShowTicket() {
		ShowTicket.click();
	}

	//Method for Enter the TicketNo
	public void EnterTickerNo(String Number) {
		TicketNo.sendKeys(Number);
	}

	//Method for User Enter the Email
	public void EnterEmail(String UserMail) {
		Email.sendKeys(UserMail);
	}

	//Method for Click on Submit
	public void ClickSubmit() {
		Submit.click();
	}

	//Method for Click On Help 
	public void ClickHelp() {
		Help.click();
	}

	//Method for Click on Close
	public void ClickClose() {
		closeIcon.click();
		driver.switchTo().frame(0);
	}

	//Method for Click on Chat
	public void ClickChat() {
		Chat.click();
	}

	//Method for Click on Blog
	public void ClickBlog() throws InterruptedException {
		Thread.sleep(10000);
		Blog.click();
	}

	//Method for Click on Search 
	public void ClickSearch() {
		Availabel.click();
		NO.click();
		AgainNO.click();
		FeedBack.click();

	}

	// Method for Click On ContactUs 
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

	//Method for Click On Close Icon
	public void Close() {
		close.click();
	}
}
