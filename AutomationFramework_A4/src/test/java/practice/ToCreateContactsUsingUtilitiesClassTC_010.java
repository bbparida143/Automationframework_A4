package practice;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Viger.Generic.Utility.ExcelFileUtility;
import Viger.Generic.Utility.PropertyFileUtility;
import Viger.Generic.Utility.WebDriverUtility;

public class ToCreateContactsUsingUtilitiesClassTC_010 {

	public static void main(String[] args) throws IOException {

		// OBJECTS OF ALL UTILITY CLASSES
		ExcelFileUtility eutil = new ExcelFileUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();

		// TO READ DATA
		// FROM PROPERTY FILE
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");

		// FROM EXCEL FILE
		String LASTNAME = eutil.toReadDataFromExcelFile("contacts", 1, 2);

		// TEST SCRIPT
		// STEP-1 : TO LAUNCH AN EMPTY BROWSER( ALSO DOING CROSS BROWSER TESTING )
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("CHROME BROWSER GOT LAUNCHED SUCCESSFULLY.");
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println("EDGE BROWSER GOT LAUNCHED SUCCESSFULLY.");

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("FIREFOX BROWSER GOT LAUNCHED SUCCESSFULLY.");

		}

		wutil.toMaximize(driver); // maximize the browser
		wutil.toGiveImplicitWait(driver); // to give implicit wait

		// STEP-2 : TO LOGIN TO THE APPLICATION WITH VALID CREDENTIALS
		driver.get(URL);
		System.out.println("URL IS OPENING AS EXPECTED");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		System.out.println("Username is accepting");
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		System.out.println("password is accepting");
		driver.findElement(By.id("submitButton")).click();

		// STEP-3 : NAVIGATE TO CONTACTS LINK AND CONTACTS LOOKUP IMAGE
		Random r = new Random();
		int random = r.nextInt(1000);

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME + random);
		String contactText = driver.findElement(By.xpath("//span[text()='Creating New Contact']")).getText();
		if (contactText.contains("Creating New Contact")) {
			System.out.println("contact link opening as expected");
		} else {
			System.out.println("Contacts link not working as expected");
		}

		// STEP-4 : TO VERIFY AND VALIDATE IT
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		String contactText1 = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
		if (contactText1.contains("Contact Information")) {
			System.out.println("CONTACT CREATION SUCCESSFULL");
		} else {
			System.out.println("contact creation failed");
		}

		// STEP-5 : TO LOGOUT FROM THE APPLICATION
		WebElement element = (driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		wutil.toMouseOver(driver, element);

		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successful");

		// STEP-6 : TO CLOSE THE BROWSER
		System.out.println("Browser got closed successfully");
		driver.quit();

	}

}
