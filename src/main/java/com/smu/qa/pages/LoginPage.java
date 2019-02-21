package com.smu.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.smu.qa.base.base;

public class LoginPage extends base {

	@FindBy(id="username")
	protected WebElement Username;
	
	@FindBy(id="login-submit")
	WebElement NextButton;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//button[@id='login-submit']")
	WebElement Login;
	
	@FindBy(xpath="//div[@class='navbar__brand logo-1']//img[contains(@alt,'Logo')]")
    WebElement LoginPageLogo;
	
	@FindBy(xpath="//div[@class='checkbox']/input[@name='save-username']")
	WebElement RememberUsernameBox;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginPageLogo() {
		return LoginPageLogo.isDisplayed();
	}
	
	public boolean validateRemeberUserameCheckBox() {
		return RememberUsernameBox.isSelected();
	}
	
	public DashboardPage loginuser(String un, String pass) {
		
		if(Username.isEnabled() && Username.isDisplayed()) {
		Username.sendKeys(un);
		}
		
		RememberUsernameBox.click();
		NextButton.click();
		Password.sendKeys(pass);
		Login.click();
		
		return new DashboardPage();
	}
}
