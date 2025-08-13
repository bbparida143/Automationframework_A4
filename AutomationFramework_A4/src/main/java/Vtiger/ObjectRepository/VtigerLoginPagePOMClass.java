package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPagePOMClass {

	/**
	 * MANDATORY STEP TO CREATE POM CLASS PROVIDE CONSTRUCTOR
	 */
	public VtigerLoginPagePOMClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// IDENTIFYING THE ELEMENTS( USING LOCATIORS)

	@FindBy(name = "user_name")
	private WebElement LoginTextFieldLink;

	@FindAll({ @FindBy(name = "user_password"), @FindBy(xpath = "//input[@type='password']") })
	private WebElement PasswordTextFieldLink;

	@FindBy(id = "submitButton")
	private WebElement LoginButtonLink;

	/**
	 * TO PROVIDE GETTERS
	 */

	public WebElement getLoginTextFieldLink() {
		return LoginTextFieldLink;
	}

	public WebElement getPasswordTextFieldLink() {
		return PasswordTextFieldLink;
	}

	public WebElement getLoginButtonLink() {
		return LoginButtonLink;
	}

}
