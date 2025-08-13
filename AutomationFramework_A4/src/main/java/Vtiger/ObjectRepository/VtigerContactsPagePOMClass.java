package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerContactsPagePOMClass {

	public VtigerContactsPagePOMClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement ContactsImageLink;
	


	public WebElement getContactsImageLink() {
		return ContactsImageLink;
	}

}
