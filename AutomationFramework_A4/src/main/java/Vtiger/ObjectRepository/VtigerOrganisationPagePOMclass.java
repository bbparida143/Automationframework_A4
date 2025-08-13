package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrganisationPagePOMclass {

	public VtigerOrganisationPagePOMclass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement organisationButtonLink;

	public WebElement getOrganisationButtonLink() {
		return organisationButtonLink;
	}

   
		
	
}
