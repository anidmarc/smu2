package com.smu.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.smu.qa.base.base;

public class Login extends base{

	@FindBy(id="username")
	protected WebElement Username;
	
	@FindBy(id="login-submit")
	WebElement NextButton;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//button[@id='login-submit']")
	WebElement Login;
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	public void loginuser(String un, String pass) {
		Username.sendKeys(un);
		NextButton.click();
		Password.sendKeys(pass);
		Login.click();
	}
}
