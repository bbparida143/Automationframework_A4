package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrgInfoPagePOMclass {
 public VtigerOrgInfoPagePOMclass(WebDriver driver) {
	 PageFactory.initElements(driver, this);
	 
 }
 
 @FindBy(xpath = "//span[contains(text(),'Organization Information')]")
 private WebElement orgHeaderText;
 
 @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
 private WebElement administratorLink;
 
 @FindBy(linkText = "Sign Out")
 private WebElement SignOutButtonLink;

public WebElement getOrgHeaderText() {
	return orgHeaderText;
}

public WebElement getAdministratorLink() {
	return administratorLink;
}

public WebElement getSignOutButtonLink() {
	return SignOutButtonLink;
}
 
}
