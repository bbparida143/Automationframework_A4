package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerContactInfoPagePOMclass {
	public VtigerContactInfoPagePOMclass(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLink;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;

	@FindBy(xpath = "//span[contains(text(),'Contact Information')]")
	private WebElement ContactTextInformationLink;

	public WebElement getAdministratorLink() {
		return AdministratorLink;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public WebElement getContactTextInformationLink() {
		return ContactTextInformationLink;
	}

}
