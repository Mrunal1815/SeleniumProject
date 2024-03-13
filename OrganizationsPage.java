package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

//	identify create organization--(+)
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrg;

	public WebElement getCreateOrg() {
		return createOrg;
	}

	public OrganizationsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void clickOnPlus() {
//		click on +
		createOrg.click();
	}
	
}
