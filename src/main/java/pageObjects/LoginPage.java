package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driverarg) throws IOException {
		this.driver = driverarg;
	}
	By username = By.id("username");
	By password = By.id("password");
	By submit = By.xpath("//button[@type='submit']");
	By account = By.id("current_account");
	By signout = By.xpath("//input[@value='Sign out']");
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	public WebElement getNext() {
		return driver.findElement(submit);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement submit() {
		return driver.findElement(submit);
	}
	public WebElement account() throws InterruptedException {
		//Thread.sleep(4000);
		//driver.navigate().refresh();
		return driver.findElement(account);
		
	}
	public WebElement signout() {
		return driver.findElement(signout);
	}

}
