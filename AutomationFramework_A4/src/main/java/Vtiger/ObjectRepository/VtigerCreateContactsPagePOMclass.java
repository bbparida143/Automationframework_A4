package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCreateContactsPagePOMclass {
	
	public VtigerCreateContactsPagePOMclass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement LastnameLink;
	
	public WebElement getLastnameLink() {
		return LastnameLink;
	}

	@FindBy(xpath = "(//input[contains(@value,'Save')])[2]")
	private WebElement SaveButtonLink;

	public WebElement getSaveButtonLink() {
		return SaveButtonLink;
	}
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement OrgSelectButtonLink;

	public WebElement getOrgSelectButtonLink() {
		return OrgSelectButtonLink;
	}
}
