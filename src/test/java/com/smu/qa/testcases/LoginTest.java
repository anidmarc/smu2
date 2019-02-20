package com.smu.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.smu.qa.base.base;
import com.smu.qa.pages.Login;

public class LoginTest extends base{

	Login lu;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		lu = new Login();	
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
