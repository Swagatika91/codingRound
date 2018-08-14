package com.cleartrip.genericLibraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods {

	WebDriver driver;
	
	

	public void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
	}

	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void selectDateFromInCalendar()
	{
		List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td"));
		for(WebElement ele:allDates)
		{
			String date=ele.getText();
			if(date.equalsIgnoreCase(Constants.checkInDate))
			{
				ele.click();
				break;
			}
		}
	}

	public void selectDateFromOutCalendar()
	{
		List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td"));
		for(WebElement ele:allDates)
		{
			String date=ele.getText();
			if(date.equalsIgnoreCase(Constants.checkOutDate))
			{
				ele.click();
				break;
			}
		}
	}
}



