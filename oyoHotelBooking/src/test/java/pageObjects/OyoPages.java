package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OyoPages {

	private static WebElement element = null;

	public static WebElement textbox_location(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@id=\"autoComplete__home\"]"));
		return element;
	} 

	public static WebElement field_place(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@id=\"autoComplete__home\"]"));
		return element;
	} 

	public static WebElement search_button(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[@class=\"u-textCenter searchButton searchButton--home\"]"));
		return element;
	}
	
	public static WebElement booknow_button(WebDriver driver) {

		element = driver.findElement(By.xpath("(//button[@class='c-17di9jl d-greenButton'])[1]"));
		return element;
	}
	
	public static WebElement Verify_text(WebDriver driver) {

		element = driver.findElement(By.xpath("//span[text()='Enter your details']"));
		return element;
	}
}
