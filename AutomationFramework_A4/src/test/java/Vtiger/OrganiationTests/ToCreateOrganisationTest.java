package Vtiger.OrganiationTests;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Viger.Generic.Utility.ExcelFileUtility;
import Viger.Generic.Utility.VtigerBaseClass;
import Vtiger.ObjectRepository.VtigerCreateOrganisationPagePOMclass;
import Vtiger.ObjectRepository.VtigerHomePagePOMClass;
import Vtiger.ObjectRepository.VtigerOrgInfoPagePOMclass;

public class ToCreateOrganisationTest extends VtigerBaseClass {
	@Test
	public void toCreateOrganisation() throws EncryptedDocumentException, IOException {
		Reporter.log("TEST SCRIPT IS EXECUTING .....", true);
		VtigerHomePagePOMClass hp = new VtigerHomePagePOMClass(driver);
		hp.getOrganisationLink().click();

		VtigerCreateOrganisationPagePOMclass co = new VtigerCreateOrganisationPagePOMclass(driver);
		

		Random r = new Random();
		int RANDOM = r.nextInt(1000);
	
		ExcelFileUtility eutil = new ExcelFileUtility();
		String ORGANISATION = eutil.toReadDataFromExcelFile("organisation", 0, 1);
		co.getOrgNameLink().sendKeys(ORGANISATION+RANDOM );
		
		VtigerOrgInfoPagePOMclass oip = new VtigerOrgInfoPagePOMclass(driver);
//		String Text = oip.getOrgHeaderText().getText();
//		if (Text.contains(ORGANISATION)) {
//			Reporter.log(ORGANISATION+"....passed");
//			
//		}else {
//			Reporter.log(ORGANISATION+"....failed");
//		}

	}

}
