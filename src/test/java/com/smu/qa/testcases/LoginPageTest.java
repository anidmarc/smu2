package com.smu.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.smu.qa.base.base;
import com.smu.qa.pages.LoginPage;

public class LoginPageTest extends base{

	LoginPage lu;
	
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		lu = new LoginPage();	
	}
	
	@Test
	public void LoginPageTitleTest() {
	String LoginPageTitle =	lu.validateLoginPageTitle();
	Assert.assertEquals(LoginPageTitle, prop.get("LoginPageTitle"));
	}
	
	@Test
	public void LoginPageLogo() {
	boolean flag = lu.validateLoginPageLogo();
	Assert.assertTrue(flag, "Logo is wrong");
	}
	
	@Test
	public void RememberUsernameCheckBox() {
	boolean flag =	lu.validateRemeberUserameCheckBox();
	Assert.assertTrue(flag, "Checkbox is not selected");
	}
	
	@Test
	public void userlogin() {
		lu.loginuser(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
