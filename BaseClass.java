package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public static  WebDriver d;

	WebDriverUtil driverUtil = new WebDriverUtil();
	PropertyFileUtil fileUtil = new PropertyFileUtil();
	
	@BeforeSuite
	public void beSuit() {
		System.out.println("Connect to Data Base");
	}
	
	@BeforeClass
	public void beClass() throws IOException {
		
		String url = fileUtil.getDataFromPropertyFile("Url");
		
	    d = new ChromeDriver();
		driverUtil.maximize(d);                                                 //to maximize the window
		driverUtil.implicitWait(d);												//to apply wait
//		initialization is only for take screenshot
		d.get(url);
	}
	
	@BeforeMethod
	public void beMethod() throws IOException {
//		@BeforeMethod is used to sign in into the application
		
		String usrnm = fileUtil.getDataFromPropertyFile("Username");			
		String passwd = fileUtil.getDataFromPropertyFile("Password");
		
		d.findElement(By.name("user_name")).sendKeys(usrnm);
		d.findElement(By.name("user_password")).sendKeys(passwd);
		d.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void aMethod() throws InterruptedException {
//		@AfterMethod is used to sign out from the application
		
		Thread.sleep(2000);
		WebElement icon = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driverUtil.mouseHover(d, icon);

		d.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
	
	@AfterClass
	public void aClass() {
//		@AfterClass is used to close the browser.
		
		d.quit();
	}
	
	@AfterSuite
	public void aSuit() {
		System.out.println("Disconnect from Data Base");
	}
}
