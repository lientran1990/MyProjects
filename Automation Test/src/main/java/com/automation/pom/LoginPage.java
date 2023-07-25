package com.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.PropertiesFileUtils;

public class LoginPage {

	WebDriver mDriver;
	public LoginPage(WebDriver driver) {
		mDriver = driver;
		
	} 
	
	public void enteremail(String email) {			
		mDriver.findElement(By.xpath(PropertiesFileUtils.getProperty("login_email"))).sendKeys(email);	
		
	}	
	public void enterpass(String password) {
		mDriver.findElement(By.xpath(PropertiesFileUtils.getProperty("login_pass"))).sendKeys(password);
				
	}
	
	public void clickLogin() {
		mDriver.findElement(By.xpath(PropertiesFileUtils.getProperty("button_login"))).click();
	}

}
