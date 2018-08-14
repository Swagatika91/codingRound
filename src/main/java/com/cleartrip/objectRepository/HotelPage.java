package com.cleartrip.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import com.cleartrip.genericLibraries.CommonMethods;

public class HotelPage  {
	
	WebDriver driver;

	@FindBy(id = "Tags")
	WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(id = "CheckInDate")
	private WebElement datePickerIn;

	@FindBy(id = "CheckOutDate")
	private WebElement datePickerOut;

	public void enterDetailsForHotel()
	{
		localityTextBox.sendKeys("Lalbagh Botanical Garden, Bangalore, Karnataka, India");  
	}

	public void selectCheckInAndCheckOutDate()
	{
		CommonMethods com = new CommonMethods();
		datePickerIn.click();
		com.selectDateFromInCalendar();
		datePickerOut.click();
		com.selectDateFromOutCalendar();
	}

	public void enterOccupantsDetailsAndClickSearch()
	{
		if(localityTextBox.isDisplayed())
		{
		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		}
		searchButton.click();
	}
}
