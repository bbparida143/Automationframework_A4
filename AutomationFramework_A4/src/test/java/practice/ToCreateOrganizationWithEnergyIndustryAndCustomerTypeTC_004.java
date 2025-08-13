package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ToCreateOrganizationWithEnergyIndustryAndCustomerTypeTC_004 {

	public static void main(String[] args) {
		// STEP-1 : TO LAUNCH THE BROWSER
		WebDriver driver = new ChromeDriver();
		System.out.println("browser got launched successfully");
		driver.manage().window().maximize();
		System.out.println("browser got maximized successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// STEP-2 : TO NAVIGATE TO THE APPLICATION AND LOGIN WITH VALID CREDENTIALS
		driver.get("http://localhost:8888/");
		System.out.println("application got opened successfully");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("Manoj@1809");
		driver.findElement(By.id("submitButton")).click();

		boolean homeText = driver.findElement(By.partialLinkText("Home")).isDisplayed();
		if (homeText == true) {
			System.out.println("login Successfull..");

		} else {
			System.out.println("login failed..");
		}

		// STEP-3 : NAVIGATRE TO ORGANIZATION LINK
		driver.findElement(By.linkText("Organizations")).click();
		boolean organizationText = driver.findElement(By.linkText("Organizations")).isDisplayed();
		if (organizationText == true) {
			System.out.println("Organisations link is working as expected.");
		} else {
			System.out.println("Oraganisation link is not wokring as expected.");
		}

		// STEP-4 : TO CLICK ON 'CREATE ORAGANIZATION LOOKUP PAGE' LINK
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		String text = driver.findElement(By.xpath("//span[text()='Creating New Organization']")).getText();
		if (text.contains("Creating New Organization")) {
			System.out.println("Create organization lookup image page is opening successfully.");
		} else {
			System.out.println("create organization lookup image link is not wokring. ");
		}

		// STEP-5 : TO CREATE ORGANISATION WITH MANDATORY FIELDS
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("dspiders");

		// STEP-6 : TO SELECT "CHEMICALS" FROM THE INDUSTRY DROPDOWN
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select ref = new Select(industryDropDown);
		ref.selectByValue("Energy");
		System.out.println("ENERGY Industry was selected from industry dropdown");
		// STEP-7 : TO SELECT "CUSTOMER" TYPE from type dropdown
		WebElement typeDropDown = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select ref1 = new Select(typeDropDown);
		ref1.selectByValue("Customer");
		System.out.println("CUSTOMER type selected from type dropdown successfully.");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println("organization creation is successfull..");

		// STEP-7 : TO SAVE AND VERIFY THE CREATED ORGANIZATION
		String textField = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"))
				.getText();
		if (textField.contains("cspiders")) {
			System.out.println(
					"Organization created successfully with mandatory fields are accepted, verified and saved");
		} else {
			System.out.println("Oraganization creation failed..");
		}
		// STEP-8 : TO LOGOUT OF THE APPLICATION
		WebElement element = driver.findElement(By.xpath("//IMG[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successfull....");

		// STEP-9 : TO CLOSE THE BROWSER
		System.out.println("browser got closed successfully....");
		driver.quit();

	}

}
