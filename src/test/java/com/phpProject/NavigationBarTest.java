package com.phpProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Homepage;

public class NavigationBarTest extends BaseClass {
	private static Logger log = LogManager.getLogger(BaseClass.class.getName());
	Homepage hom;
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = intializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		hom = new Homepage(driver);
	}
	@Test
	public void navigationTest() throws IOException{
		log.info("navigation test started");
		Assert.assertTrue(hom.getNavigationBar().isDisplayed());
		log.info("navigation tested");
	}
	
	@Test
	public void searchTest() throws IOException{
		log.info("search text test started");
		Assert.assertEquals(hom.getSearchText().getAttribute("innerText"), "Be a Booker and experience the world");
		log.info("search text tested");
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}

}
