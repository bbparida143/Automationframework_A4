package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCreateOrganisationPagePOMclass {

	public VtigerCreateOrganisationPagePOMclass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement OrgNameLink;

	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement savebuttonLink;

	@FindBy(name = "industry")
	private WebElement industryDropDownlink;

	@FindBy(name = "accounttype")
	private WebElement TypeDropDownLink;

	public WebElement getIndustryDropDownlink() {
		return industryDropDownlink;
	}

	public WebElement getTypeDropDownLink() {
		return TypeDropDownLink;
	}

	public WebElement getOrgNameLink() {
		return OrgNameLink;
	}

	public WebElement getSavebuttonLink() {
		return savebuttonLink;
	}

}
