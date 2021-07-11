package com.md.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.md.actiondriver.Action;
import com.md.base.BaseClass;

public class MDLoginPage extends BaseClass {

	//WebDriver driver;
	Action action= new Action();
	// Get MD user name text box element
	@FindBy(id = "userName")
	private WebElement md_username;
	// Get MD password text box element
	@FindBy(id = "password")
	private WebElement md_pwd;
	// Login button
	@FindBy(xpath = "//button")
	private WebElement md_loginBtn;
	// Logo of MD file
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]")
	private WebElement md_logo;

//initalize the page factory elements
	public MDLoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

//Get the MD logo
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), md_logo);
		
	}

//get the MD title 
	public String getMDtitle() {
		
		String MDtitle = getDriver().getTitle();
		return MDtitle;
	}
// login action 
	public MDHomePage MDlogin(String uname, String pwd) {
		
		Action.type(md_username, uname);
		Action.type(md_pwd, pwd);
		Action.click(getDriver(), md_loginBtn);
		System.out.println("logged");
		return new MDHomePage();
	}
}
