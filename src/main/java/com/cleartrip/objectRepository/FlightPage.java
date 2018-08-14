package com.cleartrip.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cleartrip.genericLibraries.Browser;
import com.cleartrip.genericLibraries.Constants;

public class FlightPage {
	
	@FindBy(id = "OneWay")
	WebElement radioOneWay;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	public WebElement deptDate;
	
	@FindBy(id = "SearchBtn")
	public WebElement btnFlightSearch;
	
	@FindBy(id = "FromTag")
	WebElement txtFromPlace;
	
	@FindBy(id = "ToTag")
	WebElement txtToPlace;
	
	@FindBy(linkText = "Your trips")
    private WebElement btnYourTrips;
	
	@FindBy(id = "SignIn")
    private WebElement btnSignIn;
	
	@FindBy(id = "modal_window")
    WebElement authFrame;
	
	@FindBy(linkText = "signInButton")
    private WebElement btnFrameSignIn;
	
	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;
	
	public void navigateToFlightPage()
	{
		Browser.driver.get(Constants.url);
		Browser.driver.manage().window().maximize();
	}
	
	public void performActionFlightPage()
	{
		hotelLink.click();
	}
	
	public void navigateToFrameSignInWindow()
	{
		btnYourTrips.click();
		btnSignIn.click();
	}
	
	public void fromJourneySchedule()
	{
		radioOneWay.click();
        txtFromPlace.clear();
		txtFromPlace.sendKeys("Bangalore");
	}
	
	public void toJourneySchedule()
	{
		txtToPlace.clear();
		txtToPlace.sendKeys("Delhi");
	}   
}
