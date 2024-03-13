package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class HomePage extends WebDriverUtil {

//	Identify the Organization
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement org;
	
//	Identify the contacts 
	@FindBy(xpath ="//a[text()='Contacts']")
	private WebElement contacts;
	
//	Identify the image
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement img;
	
//	Identify the signout
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOut;
	
//	Create getters

	public WebElement getOrg() {
		return org;
	}

	public WebElement getContact() {
		return contacts;
	}

	public WebElement getImg() {
		return img;
	}

	public WebElement getSignOut() {
		return signOut;
	}

//	To initialize the webelement
	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
//	click on orgnization
	public void clickOnOrg() {
		org.click();
	}
	
//	logout
	public void logout(WebDriver d) {
//		To mouse hover on image
		mouseHover(d, img);
		
//		click on signout
		signOut.click();
	}
}
