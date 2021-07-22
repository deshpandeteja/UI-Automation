package com.test.automation.impl;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Webdriver
{

	static WebDriver driver;
	static HomePage homePage;
	static WebDriverWait wait;


	@BeforeClass
	public static void setup()
	{
	
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		wait=new WebDriverWait(driver, 10);

		driver.get("https://www.afr.com/policy/foreign-affairs/capability-edge-and-keeping-south-china-sea-open-crucial--christopher-pyne-20180924-h15rq9");

	}

	@Test
	public void verifySubscriptionPopUp()  
	{
		//Checking subscription pop-up is found.
		Boolean verifyPopUpDisplayed = driver.findElement(homePage.displayedPopUp).isDisplayed();
		assertTrue(verifyPopUpDisplayed);
		System.out.println("Subscription Popup found.");

		//Scrolling down to bottom.
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.notDisplayedPopUp));

		//Checking pop-up disappears in 10 secs.
		Boolean verifyPopUpNotDisplayed = driver.findElement(homePage.notDisplayedPopUp).isDisplayed();
		assertTrue(verifyPopUpNotDisplayed);
		System.out.println("Subscription Popup disappread after 10 second");
		
	}
	
	@AfterClass
	public static void close() {
		System.out.println("Closing the driver.");
		driver.close();
	}
}