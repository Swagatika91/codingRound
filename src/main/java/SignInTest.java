import com.cleartrip.genericLibraries.Browser;
import com.cleartrip.objectRepository.FlightPage;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {

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
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() { 
        flightPage.navigateToFrameSignInWindow();
        driver.switchTo().frame("modal_window");
        driver.findElement(By.id("signInButton")).click();
        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
    }
    
    @AfterClass
	public void configurationAfterRunningClass()
	{
		driver.quit();
	}

}
