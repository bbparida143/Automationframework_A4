package Vtiger.OrganiationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Viger.Generic.Utility.ExcelFileUtility;
import Viger.Generic.Utility.JavaFileUtility;
import Viger.Generic.Utility.VtigerBaseClass;
import Viger.Generic.Utility.WebDriverUtility;
import Vtiger.ObjectRepository.VtigerCreateOrganisationPagePOMclass;
import Vtiger.ObjectRepository.VtigerHomePagePOMClass;
import Vtiger.ObjectRepository.VtigerOrgInfoPagePOMclass;
import Vtiger.ObjectRepository.VtigerOrganisationPagePOMclass;
@Listeners(Viger.Generic.Utility.LIstenersImplementation.class)
public class CreateOrganisationWithIndustryAndTypeDropDownTest extends VtigerBaseClass {
	
	@Test(groups = "regression")
	public void toCreateOrganisationWithIndustryAndType() throws EncryptedDocumentException, IOException {
		
		VtigerHomePagePOMClass hp = new VtigerHomePagePOMClass(driver);
		hp.getOrganisationLink().click();
		
		VtigerOrganisationPagePOMclass op = new VtigerOrganisationPagePOMclass(driver);
		op.getOrganisationButtonLink().click();
		
		VtigerCreateOrganisationPagePOMclass cop = new VtigerCreateOrganisationPagePOMclass(driver);
		ExcelFileUtility eutil= new ExcelFileUtility();
	    JavaFileUtility jutil = new JavaFileUtility();
	    int RANDOM = jutil.toGetRandomNumber();
		String ORGNAME = eutil.toReadDataFromExcelFile("organisation", 1, 2);
		cop.getOrgNameLink().sendKeys(ORGNAME+RANDOM);
		
		 WebElement industryDrop = cop.getIndustryDropDownlink(); 
		  WebElement typeDrop = cop.getTypeDropDownLink();
		 WebDriverUtility wutil = new WebDriverUtility();
		 wutil.toHandleDropDown(industryDrop, 3);
		 wutil.toHandleDropDown(typeDrop, 5);
		 
		 cop.getSavebuttonLink().click();
		  
		 VtigerOrgInfoPagePOMclass oip = new VtigerOrgInfoPagePOMclass(driver);
		String TEXT = oip.getOrgHeaderText().getText();
		
		Assert.assertTrue(TEXT.contains(ORGNAME));
		Reporter.log(ORGNAME+".....PASSED");
		 
		 
		
				
		
	}

}
