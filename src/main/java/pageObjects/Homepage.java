package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
	private WebDriver driver;
	public Homepage(WebDriver driverarg) throws IOException {
		this.driver = driverarg;
		
	}
	private By signin = By.id("current_account");
	private By navigationBar = By.id("cross-product-bar");
	private By searchText = By.cssSelector(".sb-searchbox__title-text");
	private By defaultGuests=By.cssSelector(".xp__guests__count");
	
	public WebElement getSignin() {
		return driver.findElement(signin);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar);
	}
	public WebElement getSearchText() {
		return driver.findElement(searchText);
	}
	
	public WebElement getDefaultGuests() {
		return driver.findElement(defaultGuests);
	}
	

}
