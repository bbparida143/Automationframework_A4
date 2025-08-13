package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToSelectOrganisationFromOrganisationsDropDownTC_005 {

	public static void main(String[] args) {
		// STEP-1 : TO LAUNCH THE BROWSER
		WebDriver driver = new ChromeDriver();
		System.out.println("browser got launched successfully");
		driver.manage().window().maximize();
		System.out.println("browser got maximized successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// STEP-2 : LOGIN TO APPLICATION WITH VALID CREDENTIALS
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

		// STEP-3 : NAVIGATE TO CONTACTS LINK
		driver.findElement(By.linkText("Contacts")).click();
		boolean ContactText = driver.findElement(By.linkText("Contacts")).isDisplayed();
		if (ContactText == true) {
			System.out.println("Contacts link is opening..");

		} else {
			System.out.println("contacts link is not working ..");
		}

		// STEP-4 : CLICK ON CREATE CONTACT LOOK UP IMAGE
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String originalText = "Creating New Contact";
		String actualText = driver.findElement(By.xpath("//span[text()='Creating New Contact']")).getText();
		if (originalText.equalsIgnoreCase(actualText)) {
			System.out.println("Contact lookup page is opening successfully..");
		} else {
			System.out.println("contacts lookup page is not opeing..");
		}

		// STEP-5 : CREATE CONTACT WITH MANDATORY FIELDS
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kushwaha");

		// STEP-6 : TO SELECT THE ORGANISATION FROM ORAGISATIONS
		String parentId = driver.getWindowHandle();

		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		Set<String> allId = driver.getWindowHandles();
		allId.remove(parentId);
		String id1 = "";
		for (String id : allId) {
			id1 = id;
		}
		driver.switchTo().window(id1);
		driver.findElement(By.linkText("bspiders")).click();
		driver.switchTo().window(parentId);
		System.out.println("Organisation selected successfully from organisation link..");

		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		// STEP-6 : TO SAVE AND VERIFY THE CREDENTIALS
		String lastname = driver.findElement(By.xpath("//span[contains(text(),' kushwaha  -  Contact Information')]"))
				.getText();
		if (lastname.contains("kushwaha")) {
			System.out.println("mandatory fields accepted, saved and verified successfully..");
		} else {
			System.out.println("mandatory fields not accepted...");
		}
		// STEP-7 : TO LOGOUT OF THE APPLICATION
		WebElement element = driver.findElement(By.xpath("//IMG[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successfull....");

		// STEP-8 : TO CLOSE THE BROWSER
		System.out.println("browser got closed successfully....");
		driver.quit();

	}

}
