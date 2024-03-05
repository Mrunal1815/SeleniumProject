package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void handleDropdown(WebElement element, String targetedElement) {
		Select s = new Select(element);
		s.selectByVisibleText(targetedElement);
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}
	
	public void switchControlToWindow(WebDriver driver, String expectedURL) {
		Set<String> ids = driver.getWindowHandles();
		
		for (String a : ids) {
			String actualURL= driver.switchTo().window(a).getCurrentUrl();
		
			if (actualURL.contains(expectedURL)) {
				break;
			}
		}   
		
	}
	
	public File screenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File tempFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./Screenshot/"+screenshotName+".png");
		FileUtils.copyFile(tempFile, destinationFile);
		return destinationFile;
	}
}
