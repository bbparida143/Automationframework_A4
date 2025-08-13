package Viger.Generic.Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * this method is used to maximize the browser
	 * 
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();

	}

	/**
	 * this method is used to minimize the browser
	 * 
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * this method is used to give implicit wait this method will wait for elements
	 * to get loaded in the web page
	 * 
	 * @param driver
	 */

	public void toGiveImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	/**
	 * this method is used to give explicit wait this method will wait until the
	 * elements to be clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void toGiveExplicitWaitElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this method is used to give explicit wait this method will provide wait until
	 * the element will be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void toGiveExplicitWaitElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method is used to handle the dropdown using index value
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandleDropDown(WebElement element, int index) {
		Select ref = new Select(element);
		ref.selectByIndex(index);
	}

	/**
	 * this method is used to handle the dropdown using value
	 * 
	 * @param element
	 * @param value
	 */
	public void toHandleDropDown(WebElement element, String value) {
		Select ref = new Select(element);
		ref.selectByValue(value);
	}

	/**
	 * this method is used to handle dropdown using visible text
	 * 
	 * @param visibleText
	 * @param element
	 */
	public void toHandleDropDown(String visibleText, WebElement element) {
		Select ref = new Select(element);
		ref.selectByVisibleText(visibleText);
	}

	/**
	 * this method is used to handle iframe using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleIframe(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * this method is used to handle iframe using ID or name
	 * 
	 * @param driver
	 * @param id_name
	 */
	public void toHandleIframe(WebDriver driver, String id_name) {
		driver.switchTo().frame(id_name);
	}

	/**
	 * this method is used to handle iframe using WebElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toHandleIframe(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method is used to switch back from iframe to immediate parent frame
	 * 
	 * @param driver
	 */
	public void toSwitchBackfromiframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to switch back from iframe to main frame
	 * 
	 * @param driver
	 */
	public void toSwitchBackFromiframe(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method is used to perform mouse over action on web page
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseOver(WebDriver driver, WebElement element) {
		Actions ref = new Actions(driver);
		ref.moveToElement(element).perform();
	}

	/**
	 * this method is used to perform right click on web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions ref = new Actions(driver);
		ref.contextClick().perform();
	}

	/**
	 * this mehtod is used to perform double click on webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void toDoubleClick(WebDriver driver, WebElement element) {
		Actions ref = new Actions(driver);
		ref.doubleClick().perform();
	}

	/**
	 * this method is used to perform the drag and drop actions on webelement
	 * 
	 * @param driver
	 * @param src
	 * @param tar
	 */
	public void toDragAndDrop(WebDriver driver, WebElement src, WebElement tar) {
		Actions ref = new Actions(driver);
		ref.dragAndDrop(src, tar).perform();
	}

	/**
	 * this method is used to handle the ALERT popup by accepting or click on OK
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopUpByAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method is used to handle the alert popup by clicking on cancel or
	 * dismiss
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopUpByDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method is used to capture the text present in the alert
	 * 
	 * @param driver
	 * @return
	 */
	public String toHandleAlertPopUpByCapturingText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return text;
	}

	/**
	 * this method is used to switch the driver control to child windows
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void toSwitchTheDriverControlToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			String windowTitle = driver.switchTo().window(id).getTitle();
			if (windowTitle.contains(partialWindowTitle)) {
				break;
			}
		}

	}

	/**
	 * this method is used to take screenshot of entire web page
	 * 
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public void toTakeScreenshotOfWebPage(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./errorshots/"+ screenshotName +".png");
		FileHandler.copy(temp, perm);

	}
	/**
	 * this method is used to switchin to the child window
	 * @param driver
	 */
	public void toSwitchDriverToChildWindow(WebDriver driver) {
		String ParentId = driver.getWindowHandle();
		Set<String> AllIds = driver.getWindowHandles();
		AllIds.remove(ParentId);
		String ID1= null;
		for(String Id:AllIds) {
			ID1=Id;
			driver.switchTo().window(ID1);
		}
		
		
		
	}
	/**
	 * this method is used to Switch back to the parent window
	 * @param driver
	 */
	public void toSwitchBackToTheParentWindow(WebDriver driver) {
		String ParentID = driver.getWindowHandle();
		driver.switchTo().window(ParentID);
	}

}