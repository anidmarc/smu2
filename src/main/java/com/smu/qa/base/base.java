package com.smu.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.smu.qa.util.TestUtil;

public class base {

	public static WebDriver driver;
	public static Properties prop;
	
	public base() {
	
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\JAVA Practice\\SMU\\src\\main\\java\\com\\smu\\qa\\config\\config.properties") ;
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}

	public static void intialization() {
		String browerName = prop.getProperty("browser");
		
		if(browerName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aniruddha Dey\\Downloads\\Selenium driver\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aniruddha Dey\\Downloads\\Selenium driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitime, TimeUnit.SECONDS);	
		
		driver.get(prop.getProperty("url"));
	}
	
	
}
