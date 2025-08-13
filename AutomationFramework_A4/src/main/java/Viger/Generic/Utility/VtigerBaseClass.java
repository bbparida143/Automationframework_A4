package Viger.Generic.Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Vtiger.ObjectRepository.VtigerContactInfoPagePOMclass;
import Vtiger.ObjectRepository.VtigerLoginPagePOMClass;

public class VtigerBaseClass {

	/**
	 * TO READ DATA
	 */
	PropertyFileUtility putil = new PropertyFileUtility();
	ExcelFileUtility eutil = new ExcelFileUtility();
	// TO PERFORM COMMON ACTIONS
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver driver1; // for listeners

	@BeforeSuite(groups = {"system", "regression"})
	public void beforeSuitConfiguration() {
		Reporter.log("......DATABASE CONNECTION ESTABLISHED SUCCESSFULLY.....", true);
		Reporter.log("Before suit is executing..",true);
	}
      
	// @Parameters("browserName")
	 //@BeforeTest
    //FOR CROSS BROWSER TESTING
	
	@BeforeClass(groups = {"system", "regression"})
	public void beforeClassConfiguration(/*String BROWSER1*/) throws IOException {
		// here we are reading browser from property file
		String BROWSER1 = putil.toReadDataFromPropertyFile("browser");
		if (BROWSER1.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			Reporter.log("chrome browser got launched ", true);
		} else if (BROWSER1.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			Reporter.log("edge browser got launched ", true);

		} else if (BROWSER1.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			Reporter.log("safari browser got launched ", true);

		}
		driver1= driver; // for  listeners

		wutil.toMaximize(driver);
		wutil.toGiveImplicitWait(driver);
		String URL = putil.toReadDataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("before class is executing....",true);
	}

	@BeforeMethod(groups = {"system", "regression"})
	public void beforeMethodConfiguration() throws IOException {
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		/**
		 * CREATE AN OBJECT OF VTIGERLOGINPAGE POM CLASS SO THAT WE CAN USE LOGINPAGE
		 * 
		 */

		VtigerLoginPagePOMClass lp = new VtigerLoginPagePOMClass(driver);
		lp.getLoginTextFieldLink().sendKeys(USERNAME);
		lp.getPasswordTextFieldLink().sendKeys(PASSWORD);
		lp.getLoginButtonLink().click();
		Reporter.log("HOME PAGE IS DISPLAYING.....", true);
		Reporter.log("before method is executing....",true);

	}

	@AfterMethod(groups = {"system", "regression"})
	public void afterMethodConfiguration() {
		/**
		 * CREATE AN OBJECT OF VTIGERHOMEPAGE TO ACCESS CONTACT'S MODULE ELEMENTS AND
		 * LOACTORS TO PERFORM COMMON ACTION USING WEBDRIVERUTILITY OBJECT
		 */
		VtigerContactInfoPagePOMclass cip = new VtigerContactInfoPagePOMclass(driver);

		WebElement adminlink = cip.getAdministratorLink();
		wutil.toMouseOver(driver, adminlink);
		cip.getSignOutLink().click();
		Reporter.log("SIGNED OUT SUCCESSFULLY......", true);
		Reporter.log("After method is executing.....",true);

	}

	@AfterClass(groups = {"system", "regression"})
	public void afterClassConfiguration() {
		Reporter.log("..........BROWSER GOT CLOSED SUCCESSFULLY........", true);
		Reporter.log("after class is executing.....",true);
		driver.quit();
	}

	// @AFTERTEST : POST CONDITIONS CAN BE SKIPPED HERE

	@AfterSuite(groups = {"system", "regression"})
	public void afterSuitConfiguration() {
		Reporter.log(".......DATABASE DISCONNECTED SUCCESSFULLY.......", true);
		Reporter.log("after suite is executing.....",true);
	}
}