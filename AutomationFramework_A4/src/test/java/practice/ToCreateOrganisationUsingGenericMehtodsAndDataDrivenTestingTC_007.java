package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import Viger.Generic.Utility.ExcelFileUtility;
import Viger.Generic.Utility.PropertyFileUtility;

public class ToCreateOrganisationUsingGenericMehtodsAndDataDrivenTestingTC_007{

	public static void main(String[] args) throws IOException {

		
		//TO READ DATA 
		//property file
		PropertyFileUtility putil = new PropertyFileUtility();
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		
		//excel file
		ExcelFileUtility eutil = new ExcelFileUtility();
		String ORGNAME = eutil.toReadDataFromExcelFile("organisation", 1, 2);
		
		
		//SCRIPT
		// STEP-1 : TO LAUNCH THE BROWSER
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();	
			System.out.println("chrome browser got launched successfully");
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println("edge browser got launched successfully");
		}
		
		driver.manage().window().maximize();
		System.out.println("browser got maximized successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//STEP-2 : TO NAVIGATE TO THE APPLICATION AND LOGIN WITH VALID CREDENTIALS
		driver.get(URL);
		System.out.println("application got opened successfully");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		boolean homeText = driver.findElement(By.partialLinkText("Home")).isDisplayed();
		if(homeText==true) {
			System.out.println("login Successfull..");
			
		}else {
			System.out.println("login failed..");
		}
		
		//STEP-3 : NAVIGATRE TO ORGANIZATION LINK
		driver.findElement(By.linkText("Organizations")).click();
		boolean organizationText = driver.findElement(By.linkText("Organizations")).isDisplayed();
		if(organizationText==true)
		{
			System.out.println("Organisations link is working as expected.");
			}
		else
		{
			System.out.println("Oraganisation link is not wokring as expected.");
		}
		
		//STEP-4 : TO CLICK ON 'CREATE ORAGANIZATION LOOKUP PAGE' LINK
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		String text = driver.findElement(By.xpath("//span[text()='Creating New Organization']")).getText();
		if(text.contains("Creating New Organization")) {
			System.out.println("Create organization lookup image page is opening successfully.");
		}
		else
		{
			System.out.println("create organization lookup image link is not wokring. ");
		}
		
		//STEP-5 : TO CREATE ORGANISATION WITH MANDATORY FIELDS
		Random r = new Random();
		int random = r.nextInt(1000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME+random);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println("organization creation is successfull..");
		
		//STEP-6 : TO SAVE AND VERIFY THE CREATED ORGANIZATION 
		String textField = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();
		if(textField.contains("wipro")){
			System.out.println("Organization created successfully with mandatory fields are accepted, verified and saved");
			}
		else
		{
			System.out.println("Oraganization creation failed..");
		}
		//STEP-6 : TO LOGOUT OF THE APPLICATION
		WebElement element = driver.findElement(By.xpath("//IMG[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
        driver.findElement(By.linkText("Sign Out")).click();
        System.out.println("logout successfull....");
        
        //STEP-7 : TO CLOSE THE BROWSER
        System.out.println("browser got closed successfully....");
        driver.quit();
		
	}

}
