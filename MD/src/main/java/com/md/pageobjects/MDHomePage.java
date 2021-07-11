package com.md.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.md.actiondriver.Action;
import com.md.base.BaseClass;

public class MDHomePage  extends BaseClass{
	
	@FindBy(xpath = "//label[text()='Current Status History Download']")
	WebElement home_text;
	
	public MDHomePage() {
		PageFactory.initElements(getDriver(), this);
	}
//Home page check text 
	public boolean HomePagetext() {
		return Action.isDisplayed(getDriver(), home_text);
	}
}
