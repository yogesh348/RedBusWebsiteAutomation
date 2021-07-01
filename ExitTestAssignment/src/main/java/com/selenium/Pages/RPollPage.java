package com.selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RPollPage {

	public WebDriver driver;

	// using Pagefactory concept
	public RPollPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Here we are declaring the locator for each test cases
	@FindBy(how = How.XPATH, using = "//a[@id='cars']")
	public WebElement RPoll;

	public void ClickRpoll() {
		RPoll.click();
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"movie_player\"]/div[4]/button")
	public WebElement Plays;

	public void ClickPlay() {
		WebElement waitElement1 = (new WebDriverWait(driver, 20)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"movie_player\"]/div[4]/button")));
		Plays.click();
	}

	@FindBy(how = How.XPATH, using = " //span[contains(text(),'Offer Ride')]")
	public WebElement Switch;

	public void SwitchIcon() {
		WebElement waitElement1 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //span[contains(text(),'Offer Ride')]")));
		Switch.click();
	}

	public void Switch() {
		WebElement framet = driver.findElement(By.xpath("//*[@id=\"aboutRpool\"]/div/div[1]/div[2]/div/div/iframe"));
		driver.switchTo().frame(framet);
	}

}
