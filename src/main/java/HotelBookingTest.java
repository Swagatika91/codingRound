import com.cleartrip.genericLibraries.Browser;
import com.cleartrip.genericLibraries.CommonMethods;
import com.cleartrip.objectRepository.FlightPage;
import com.cleartrip.objectRepository.HotelPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelBookingTest {

	/**
	 * 
	 * author Swagatika
	 * 
	 */


	/* Declaring the objects*/
	WebDriver driver ;
	FlightPage flightPage;
	HotelPage hotelPage;

	@BeforeClass
	public void configurationBeforeRunningClass()
	{
		/* Initializing the elements*/

		Reporter.log("launch browser");
		driver = Browser.getBrowser();
		hotelPage = PageFactory.initElements(driver, HotelPage.class);
		flightPage = PageFactory.initElements(driver, FlightPage.class);
	}

	@BeforeMethod
	public void configurationBeforeRunningMethod()
	{
		Reporter.log("Navigating to homepage of Application");
		flightPage.navigateToFlightPage();
	}

	@Test
	public void shouldBeAbleToSearchForHotels() throws InterruptedException {
		CommonMethods com = new CommonMethods();

		Reporter.log("Navigated to homepage sucessfully and perform various actions");
		flightPage.performActionFlightPage();
		hotelPage.enterDetailsForHotel();
		com.waitFor(2000);
		WebElement destinationOptions = driver.findElement(By.id("ui-id-1"));	
		destinationOptions.click();
		hotelPage.selectCheckInAndCheckOutDate();
		hotelPage.enterOccupantsDetailsAndClickSearch();
	}

	@AfterClass
	public void configurationAfterRunningClass()
	{
		driver.quit();
	}


}
