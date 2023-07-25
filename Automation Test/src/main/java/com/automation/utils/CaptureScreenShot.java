package com.automation.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShot {

	public class CaptureScreenshot {
	    public void takeScreenshot(WebDriver driver, String testcaseName) {
	        // Chụp ảnh màn hình
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	        // Đường dẫn và tên file ảnh
	        String screenshotPath = "./ScreenShots" + testcaseName + ".png";

	        try {
	            // Sao chép file ảnh vào thư mục đích
	            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
	            System.out.println("Chụp ảnh màn hình thành công: " + screenshotPath);
	        } catch (IOException e) {
	            System.out.println("Lỗi khi chụp ảnh màn hình: " + e.getMessage());
	        }
	    }
	}

}
