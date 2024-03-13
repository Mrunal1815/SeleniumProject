package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.WebDriverUtil;

public class OrganizationInfoPage extends WebDriverUtil{
	
//	Identify the oragnization name tf
	@FindBy(name="accountname")
	private WebElement orgNameTf;
	
//	Identify the group radio button
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement groupRadioBtn;
	
//	Identify the dropdown
	@FindBy(name = "assigned_group_id")
	private WebElement dropDown;
	
//	Identify the save button
	@FindBy(xpath ="(//input[@name='button'])[1]")
	private WebElement saveBtn ;
	
	
	public OrganizationInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getOrgNameTf() {
		return orgNameTf;
	}

	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void orgInfo(String orgName, String groupNm) {
//		Enter the org name
		orgNameTf.sendKeys(orgName);
		
//		Click on group radio button
		groupRadioBtn.click();
		
//		select support group from dropdown
		handleDropdown(dropDown, groupNm);      		// call method handleDropdown(webElement, TargetedWebEle) from WebDriverUtil class 
		
//		click on save button
		saveBtn.click();
	}
	
}
