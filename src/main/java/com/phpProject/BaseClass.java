package com.phpProject;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	protected WebDriver driver = null;
	private String browserName =null;
	protected Properties prop;
	
	public Properties readConfigFile() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("config.properties");
		prop.load(file);	
		return prop;
	}
	public WebDriver intializeDriver() throws IOException {
		prop = readConfigFile();
		browserName =  prop.getProperty("browser");
		//browserName=System.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver\\chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver\\geckodriver.exe");

			driver = new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Uma Sakshi\\Documents\\Java\\chromedriver\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	}
	

}
