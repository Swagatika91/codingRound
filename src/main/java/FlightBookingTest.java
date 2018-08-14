import com.cleartrip.genericLibraries.Browser;
import com.cleartrip.genericLibraries.CommonMethods;
import com.cleartrip.objectRepository.FlightPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class FlightBookingTest {
	/**
	 * 
	 * author Swagatika
	 * 
	 */

	/* Declaring object*/
	WebDriver driver ;
	FlightPage flightPage;

	@BeforeClass
	public void ConfigurationBeforeRunningClass()
	{
		/* Initializing the elements*/
		Reporter.log("launch browser");
		driver = Browser.getBrowser();
		flightPage = PageFactory.initElements(driver, FlightPage.class);
	}

	@BeforeMethod
	public void configurationBeforeRunningMethod()
	{
		Reporter.log("Navigating to homepage of Application");
		flightPage.navigateToFlightPage();
	}    

	@Test
	public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {
		CommonMethods cm=new CommonMethods();
		Reporter.log("Entering various details to search flights");
		flightPage.fromJourneySchedule();
		cm.waitFor(2000);
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();
		flightPage.toJourneySchedule();
		cm.waitFor(2000);
		Reporter.log("Selecting the first item from the destination auto complete list");
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();
		flightPage.deptDate.click();
		Reporter.log("All fields filled in. Now clicking on search");
		flightPage.btnFlightSearch.click();
		cm.waitFor(5000);
		Reporter.log("Verify that result appears for the provided journey search");
		
		Assert.assertTrue(cm.isElementPresent(By.xpath("//div[@class = 'searchSummary']")));
	}
	
	@AfterClass
	public void configurationAfterRunningClass()
	{
		driver.quit();
	}
	
}
