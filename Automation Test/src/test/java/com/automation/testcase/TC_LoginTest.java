package com.automation.testcase;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.PropertiesFileUtils;

public class TC_LoginTest extends DriverInstance {
	static PropertiesFileUtils pfu = new PropertiesFileUtils();
	
	@Test(dataProvider = "Excel")
	public void testcase(String email, String password) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pfu.getProperty("icon_login")))));
		

		driver.findElement(By.xpath(pfu.getProperty("icon_login"))).click();		
		

		Thread.sleep(2000);
		
		
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		loginPage.enteremail(email);
		loginPage.enterpass(password);
		loginPage.clickLogin();
		

		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(pfu.getProperty("icon_logout"))))).click();
		Thread.sleep(2000);
			
	}
	
	
	@DataProvider(name ="Excel")
	public Object[][] testDataGenerator() throws IOException {
		
		FileInputStream file = new FileInputStream("./data/assignment2_data_test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet Loginsheet = workbook.getSheet("Login");
		int numberofRowData = Loginsheet.getPhysicalNumberOfRows();
		
		Object [][] data = new Object[numberofRowData][2];
		
		for(int i=0;i<numberofRowData;i++) {
			XSSFRow row = Loginsheet.getRow(i);
			XSSFCell email = row.getCell(0);
			XSSFCell password = row.getCell(1);
			data[i][0] = email.getStringCellValue();
			data[i][1] = password.getStringCellValue();
		}	
		
		return data;
	}


					
	
	
	
	
	
	

	
	
	
	
	
	
	

}
