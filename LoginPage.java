package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	

//	Identify User name tf
	@FindBy(name ="user_name")
	private WebElement userTf;
	
//	Identify password tf
	@FindBy(name = "user_password")
	private WebElement passTF;
	
//	Identify login button
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	

//	create getters for all webelement
	public WebElement getUserTf() {
		return userTf;
	}

	public WebElement getPassTF() {
		return passTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
//	Create a constructor -- to initialize the webelement
	public LoginPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
//	Create a method 
	public void login(String userNm, String password) {
		userTf.sendKeys(userNm);
		passTF.sendKeys(password);
		loginBtn.click();
	}
}
