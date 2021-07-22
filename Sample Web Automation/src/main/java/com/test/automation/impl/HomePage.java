package com.test.automation.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage {

		By displayedPopUp = By.cssSelector("[data-testid='SubscriptionPrompt-true']");
		By notDisplayedPopUp = By.cssSelector("[data-testid='SubscriptionPrompt-false']");

	    public HomePage(WebDriver driver){
	    }
}
