package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerHomePagePOMClass {

	/**
	 * MANDATORY STEP PROVIDE A CONSTRUCTOR
	 */

	public VtigerHomePagePOMClass(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
 
	// TO STORE ELEMENTS

	@FindBy(linkText = "Contacts")
	private WebElement Contanctlinks;

	public WebElement getContanctlinks() {
		return Contanctlinks;
	}
	@ FindBy(linkText = "Organizations")
	private WebElement organisationLink;

	public WebElement getOrganisationLink() {
		return organisationLink;
	}
	


}
