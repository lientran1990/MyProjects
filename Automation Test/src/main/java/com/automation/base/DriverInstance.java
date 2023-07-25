package com.automation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.automation.utils.PropertiesFileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {

    protected WebDriver driver;
	
	@BeforeClass
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(PropertiesFileUtils.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void finish() {
		driver.close();
	}
}

	
