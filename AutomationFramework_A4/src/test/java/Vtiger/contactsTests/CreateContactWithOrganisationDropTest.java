 package Vtiger.contactsTests;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Viger.Generic.Utility.ExcelFileUtility;
import Viger.Generic.Utility.JavaFileUtility;
import Viger.Generic.Utility.VtigerBaseClass;
import Viger.Generic.Utility.WebDriverUtility;
import Vtiger.ObjectRepository.VtigerContactInfoPagePOMclass;
import Vtiger.ObjectRepository.VtigerContactsPagePOMClass;
import Vtiger.ObjectRepository.VtigerCreateContactsPagePOMclass;
import Vtiger.ObjectRepository.VtigerHomePagePOMClass;

@Listeners(Viger.Generic.Utility.LIstenersImplementation.class)
public class CreateContactWithOrganisationDropTest extends VtigerBaseClass {
	@Test(groups = "regression")
	public void toCreateContactBySelectingOrganisation() throws EncryptedDocumentException, IOException {

		VtigerHomePagePOMClass hp = new VtigerHomePagePOMClass(driver);
		hp.getContanctlinks().click();

		VtigerContactsPagePOMClass cp = new VtigerContactsPagePOMClass(driver);
		cp.getContactsImageLink().click();

		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaFileUtility jutil = new JavaFileUtility();
		int RANDOM = jutil.toGetRandomNumber();
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);

		VtigerCreateContactsPagePOMclass ccp = new VtigerCreateContactsPagePOMclass(driver);
		ccp.getLastnameLink().sendKeys(LASTNAME + RANDOM);
		
		String parentID = driver.getWindowHandle();

		ccp.getOrgSelectButtonLink().click();
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toSwitchDriverToChildWindow(driver);

	
		/*
		 ccp.getOrgSelectButtonLink().click();
		Set<String> allID = driver.getWindowHandles();
		allID.remove(parentID);
		String id1 = null;
		for (String id : allID) {
			id1 = id;
			driver.switchTo().window(id1);
*/
	
			
		
		driver.findElement(By.id("3")).click();
		
		
		
         driver.switchTo().window(parentID);
		Reporter.log("Organisation selected successfully from organisation", true);

		ccp.getSaveButtonLink().click();

		VtigerContactInfoPagePOMclass cip = new VtigerContactInfoPagePOMclass(driver);
		String TEXT = cip.getContactTextInformationLink().getText();

		Assert.assertTrue(TEXT.contains(LASTNAME));
		Reporter.log(LASTNAME + ".....passed");

	}

	}
