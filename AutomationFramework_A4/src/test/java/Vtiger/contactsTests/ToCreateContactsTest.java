package Vtiger.contactsTests;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Viger.Generic.Utility.ExcelFileUtility;
import Viger.Generic.Utility.VtigerBaseClass;
import Vtiger.ObjectRepository.VtigerContactInfoPagePOMclass;
import Vtiger.ObjectRepository.VtigerContactsPagePOMClass;
import Vtiger.ObjectRepository.VtigerCreateContactsPagePOMclass;
import Vtiger.ObjectRepository.VtigerHomePagePOMClass;

@Listeners(Viger.Generic.Utility.LIstenersImplementation.class)
public class ToCreateContactsTest extends VtigerBaseClass {
    
	@Test(groups= "system")
	public void toCreateContactTest() throws EncryptedDocumentException, IOException {
		Reporter.log("TEST SCRIPT IS EXECUTING .....", true);
		VtigerHomePagePOMClass hp = new VtigerHomePagePOMClass(driver);
		hp.getContanctlinks().click();

		VtigerContactsPagePOMClass cp = new VtigerContactsPagePOMClass(driver);
		cp.getContactsImageLink().click();

		Random r = new Random();
		int RANDOM = r.nextInt(1000);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 0, 1);

		VtigerCreateContactsPagePOMclass ccp = new VtigerCreateContactsPagePOMclass(driver);

		ccp.getLastnameLink().sendKeys(LASTNAME + RANDOM);

		ccp.getSaveButtonLink().click();
		//to puposefully fail the test script
       // Assert.fail();
		
		VtigerContactInfoPagePOMclass cip = new VtigerContactInfoPagePOMclass(driver);
		String Text = cip.getContactTextInformationLink().getText();

		// ASSERTION
		Assert.assertTrue(Text.contains(LASTNAME));
		Reporter.log(LASTNAME+"....passed",true);

	}
}
