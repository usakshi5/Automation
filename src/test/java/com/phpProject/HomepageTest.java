package com.phpProject;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import database.JDBCConnection;
import pageObjects.Homepage;
import pageObjects.LoginPage;

public class HomepageTest extends BaseClass {
	private static Logger log = LogManager.getLogger(BaseClass.class.getName());
	Homepage hom;
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = intializeDriver();
		log.info("Navigated to home page");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void loginTest() throws IOException, InterruptedException, SQLException {
		hom = new Homepage(driver);
		hom.getSignin().click();
		JDBCConnection conn = new JDBCConnection();
		LoginPage login = new LoginPage(driver);
		//login.getUsername().sendKeys(prop.getProperty("username"));
		login.getUsername().sendKeys(conn.getUserDetails()[0][0]);
		login.getNext().click();
		//login.getPassword().sendKeys(prop.getProperty("password"));
		login.getPassword().sendKeys(conn.getUserDetails()[0][1]);
		login.submit().click();
		log.info("Signed in");
		//Thread.sleep(9000);
		login.account().click();
		login.signout().click();
		log.info("Signed out");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}

}
