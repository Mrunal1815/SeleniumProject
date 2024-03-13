package BasicPOM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationInfoPage;
import POM.OrganizationsPage;

public class BasePage {

	public static WebDriver d;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
//		To get data from property file
		PropertyFileUtil util = new PropertyFileUtil();
		
		String browser = util.getDataFromPropertyFile("browser");
		String url = util.getDataFromPropertyFile("Url");
		String userNm = util.getDataFromPropertyFile("Username");
		String passwd = util.getDataFromPropertyFile("Password");
		
//		To read data from excel file.
		ExcelUtil excelUtil = new ExcelUtil();
		
		String orgName = excelUtil.getDataFromExcel("Organizations", 0, 1);
		String groupNm = excelUtil.getDataFromExcel("Organizations", 1, 1);

		
//		To launch the browser
		if (browser.equalsIgnoreCase("Chrome")) {
			d = new ChromeDriver();
		} else if(browser.equals("Edge")){
			d = new EdgeDriver();
		} else {
			d = new FirefoxDriver();
		}
		
		d.manage().window().maximize();
		
		d.get(url);
		
//		Create object of LoginPage 
		LoginPage loginPage = new LoginPage(d);
		
//		To initialize webelements call method initElements(driver ref, pagename)
//		PageFactory.initElements(d, loginPage);
//		insted of that we created parameterized constuctors in each page.
		
//		Login into app		
		loginPage.login(userNm , passwd);
		
// 		click on organizations 
		
		HomePage homePage = new HomePage(d);
		homePage.clickOnOrg();
		
		OrganizationsPage organizationsPage= new OrganizationsPage(d);
		
		organizationsPage.getCreateOrg().click();
		organizationsPage.clickOnPlus();

		OrganizationInfoPage infoPage = new OrganizationInfoPage(d);
		
		JavaUtil javaUtil = new JavaUtil();
				
		infoPage.orgInfo(orgName+javaUtil.getRandomNumber(), groupNm);           //call method to enter data

		Thread.sleep(2000);	
		homePage.logout(d);
				
	}
}
