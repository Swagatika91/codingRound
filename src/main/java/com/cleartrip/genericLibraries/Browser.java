package com.cleartrip.genericLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.sun.org.apache.bcel.internal.classfile.Constant;

public class Browser {

	public static WebDriver driver;
	
	public static WebDriver getBrowser(){
		if(Constants.browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Documents\\GitHub\\codingRound\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(Constants.browser.equals("firefox")){
			driver = new FirefoxDriver();
		}else if(Constants.browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\resources\\IEDriverSerevr.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
}

