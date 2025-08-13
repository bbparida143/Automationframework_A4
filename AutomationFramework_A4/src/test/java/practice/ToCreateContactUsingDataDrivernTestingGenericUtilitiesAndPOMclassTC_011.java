package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Viger.Generic.Utility.ExcelFileUtility;
import Viger.Generic.Utility.PropertyFileUtility;
import Viger.Generic.Utility.WebDriverUtility;
import Vtiger.ObjectRepository.VtigerContactInfoPagePOMclass;
import Vtiger.ObjectRepository.VtigerContactsPagePOMClass;
import Vtiger.ObjectRepository.VtigerCreateContactsPagePOMclass;
import Vtiger.ObjectRepository.VtigerHomePagePOMClass;
import Vtiger.ObjectRepository.VtigerLoginPagePOMClass;

public class ToCreateContactUsingDataDrivernTestingGenericUtilitiesAndPOMclassTC_011 {

	public static void main(String[] args) throws IOException {

		// TO READ DATA
		PropertyFileUtility putil = new PropertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		// FROM PROPERTY FILE
		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		// FROM EXCEL FILE
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);

		// TO PERFORM COMMON ACTIONS
		WebDriverUtility wutil = new WebDriverUtility();

		// TEST SCRIPT
		// STEP-1 : TO LAUNCH AN EMPTY BROWSER( ALSO DOING CROSS BROWSER TESTING )
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("CHROME BROWSER GOT LAUNCHED SUCCESSFULLY.");
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println("EDGE BROWSER GOT LAUNCHED SUCCESSFULLY.");

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("FIREFOX BROWSER GOT LAUNCHED SUCCESSFULLY.");

		}

		wutil.toMaximize(driver);
		wutil.toGiveImplicitWait(driver);

		// STEP-2 : TO LOGIN TO THE APPLICATION WITH VALID CREDENTIALS
		// create object for LOGINPAGE POM CLASS
		VtigerLoginPagePOMClass lp = new VtigerLoginPagePOMClass(driver);
		driver.get(URL);
		System.out.println("URL IS OPENING AS EXPECTED");

		lp.getLoginTextFieldLink().sendKeys(USERNAME);
		System.out.println("USERNAME IS ACCEPTING");
		lp.getPasswordTextFieldLink().sendKeys(PASSWORD);
		System.out.println("PASSWORD IS ACCEPTING");
		lp.getLoginButtonLink().click();
		System.out.println("LOGIN SUCCESSFUL..........");

		// STEP-3 : TO CLICK ON CONTACTS LINK
		// CREATE AN OBJECT OF HOMEPAGE POM CLASS
		System.out.println("HOME PAGE IS OPENING AS EXPECTED");
		VtigerHomePagePOMClass hp = new VtigerHomePagePOMClass(driver);
		hp.getContanctlinks().click();
		System.out.println("CONTACTS LINK IS OPENING");

		// STEP-4 : TO CREATE CONTACTS
		// CREATE AN OBJECT OF CONTACTS PAGE POM CLASS
		VtigerContactsPagePOMClass cp = new VtigerContactsPagePOMClass(driver);
		cp.getContactsImageLink().click();
		// CREATE AN OBJECT OF CREATECONTACTS PAGE
		VtigerCreateContactsPagePOMclass cc = new VtigerCreateContactsPagePOMclass(driver);
		cc.getLastnameLink().sendKeys(LASTNAME);
		cc.getSaveButtonLink().click();

		// STEP-5 : TO VALIDATE
		// CREATE AN OBJECT OF CONTACTSINFOPAGE
		VtigerContactInfoPagePOMclass cip = new VtigerContactInfoPagePOMclass(driver);
		String lastnameText = cip.getContactTextInformationLink().getText();
		if (lastnameText.contains("Contact Information")) {
			System.out.println(LASTNAME + "....passed");

		} else {
			System.out.println(LASTNAME + ".....failed");
		}

		// STEP-6 : TO LOGOUT
		WebElement adminLink = cip.getAdministratorLink();
		wutil.toMouseOver(driver, adminLink);
		cip.getSignOutLink().click();
		System.out.println("SIGN OUT SUCCESSFULLY.........");

		driver.quit();

	}
}
