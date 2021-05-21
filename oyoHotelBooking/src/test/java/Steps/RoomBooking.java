package Steps;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Properties.propertyConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.OyoPages;

public class RoomBooking {

	static WebDriver driver = null;

	@Given("User is on the Oyo Homepage")
	public void homepage() throws Exception {
		System.setProperty("webdriver.chrome.driver", propertyConfig.readProperty("driverPath"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(propertyConfig.readProperty("url"));
		Thread.sleep(5000);
	}

	@When("User provide the location and search")
	public void provide_location() throws Exception {
		OyoPages.textbox_location(driver).click();
		WebElement from = OyoPages.field_place(driver);
		from .sendKeys(propertyConfig.readProperty("location"));
		Thread.sleep(2000);
		from.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		from.sendKeys(Keys.ENTER);
		OyoPages.search_button(driver).click();
		Thread.sleep(2000);
	}

	@And ("User go to hotel listing page")
	public void hotel_listing() throws Exception {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,200)", ""); //scroll down
		Thread.sleep(3000);
		WebElement bookNow = OyoPages.booknow_button(driver);
		Thread.sleep(2000);
		String parent= driver.getWindowHandle();
		bookNow.click();
		Set<String> allWindows= driver.getWindowHandles();
		for(String child:allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
			}	
		}
	}

	@Then("User go to details page and verify title")
	public void payment_page() throws Exception {

		String text = OyoPages.Verify_text(driver).getText();
		System.out.println("Text is :" + text);
		Thread.sleep(5000);
		driver.quit();
	}

}