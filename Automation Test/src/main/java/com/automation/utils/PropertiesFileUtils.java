package com.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtils {
	static String configPath = "./configuration/configs.properties";
	static Properties ppt = new Properties();
	
	public static String getProperty(String key) {
		String value = "";
		FileInputStream fis;
		try {
			fis = new FileInputStream(configPath);
			ppt.load(fis);
			value = ppt.getProperty(key);
			return value;
		}catch(Exception e) {
			System.out.println("Xảy ra lỗi trong quá trình lấy dữ liệu");
		}
		return value;
	}

}
