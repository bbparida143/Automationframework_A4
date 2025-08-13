package practice;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Viger.Generic.Utility.ExcelFileUtility;
import Viger.Generic.Utility.PropertyFileUtility;
import Viger.Generic.Utility.WebDriverUtility;
import Vtiger.ObjectRepository.VtigerCreateOrganisationPagePOMclass;
import Vtiger.ObjectRepository.VtigerHomePagePOMClass;
import Vtiger.ObjectRepository.VtigerLoginPagePOMClass;
import Vtiger.ObjectRepository.VtigerOrgInfoPagePOMclass;
import Vtiger.ObjectRepository.VtigerOrganisationPagePOMclass;

public class ToCreateOrgByUsingDDTAndGenericUtilitiesAndPOMCLASSTC_012 {

	public static void main(String[] args) throws IOException {

		/**
		 * TO READ DATA FROM PROPERTY FILE
		 */
		PropertyFileUtility putil = new PropertyFileUtility();
		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		// FROM EXCEL FILE
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);
		String ORGNAME = eutil.toReadDataFromExcelFile("organisation", 1, 2);

		// STEP-1 : TO LAUNCH
		WebDriver driver = null;
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
			System.out.println("CHROME DRIVER GOT LAUNCHED.....");
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
			System.out.println("EDGE DRIVER GOT LAUNCHED......");

		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();

		}

		/**
		 * TO USE COMMON METHODS CREATE AN OBJECT OF WEBDRIVER UTILITY
		 */

		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toMaximize(driver);
		wutil.toGiveImplicitWait(driver);

		/**
		 * STEP-2 FOR LOGIN CREATE AN OBJECT OF LOGINPAGE POM CLASS
		 */
		VtigerLoginPagePOMClass lp = new VtigerLoginPagePOMClass(driver);
		driver.get(URL);
		System.out.println("APPLICATION GOT LAUNCHED .....");
		lp.getLoginTextFieldLink().sendKeys(USERNAME);
		lp.getPasswordTextFieldLink().sendKeys(PASSWORD);
		lp.getLoginButtonLink().click();

		/**
		 * STEP-3 FOR HOMEPAGE NAVIGATE TO ORGANISATON LINK CREATE AN OBJECT OF HOMEPAGE
		 * 
		 */
		VtigerHomePagePOMClass hp = new VtigerHomePagePOMClass(driver);
		hp.getOrganisationLink().click();
		System.out.println("ORGANISATION LINK IS OPENING SUCCESSFULLY....");

		/**
		 * STEP-4 FOR ORGANISATION PAGE CREATE AN OBJECT OF ORGANISATION PAGE POM CLASS
		 * 
		 */
		VtigerOrganisationPagePOMclass op = new VtigerOrganisationPagePOMclass(driver);
		op.getOrganisationButtonLink().click();

		/**
		 * STEP-5 FOR CREATE ORGANNIATION PAGE CREATE AN OBJECT FOR CREATEORGANISATION
		 * PAGE POM CLASS
		 */
		Random r = new Random();
		int random = r.nextInt(1000);
		String NewOrgName = ORGNAME + random;
		VtigerCreateOrganisationPagePOMclass cop = new VtigerCreateOrganisationPagePOMclass(driver);
		cop.getOrgNameLink().sendKeys(NewOrgName);
		cop.getSavebuttonLink().click();

		/**
		 * STEP-6 TO SAVE AND VALIDATE CREATE AN OBJECT OF ORGANISATION INFO PAGE POM
		 * CLASS
		 */
		VtigerOrgInfoPagePOMclass oip = new VtigerOrgInfoPagePOMclass(driver);

		String OrgInfoText = oip.getOrgHeaderText().getText();
		if (OrgInfoText.contains(ORGNAME)) {
			System.out.println(NewOrgName + ".......passed");

		} else {
			System.out.println(NewOrgName + ".....failed");

		}

		WebElement AdminLinkk = oip.getAdministratorLink();
		wutil.toMouseOver(driver, AdminLinkk);

		/**
		 * STEP-7 : LOGOUT TO CLOSE THE BROWSER
		 * 
		 */
		oip.getSignOutButtonLink().click();
		System.out.println("SIGN OUT SUCCESSFULLY  ");
		System.out.println("BROWSER GOT CLOSED SUCCESSFULLY......... ");
		driver.quit();
	}

}
