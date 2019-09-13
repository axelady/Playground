package ww.sophiemiron;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WWHomePage {
	WebDriver driver;
	
	// Page URL
	private static String PAGE_URL="https://www.weightwatchers.com/us/";
	   
	// Locators
//	@FindBy(className="find-a-meeting") WebElement wwStudio;
	@FindBy(id="ela-menu-visitor-desktop-supplementa_find-a-studio") WebElement wwStudio;


	// Constructor
	public WWHomePage (WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}
	
	// Gets <Title> from page source
	public String getTitle() {
		return driver.getTitle();
	}
	public void clickFindStudio() {
		wwStudio.click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.urlContains("find-a-meeting"));
	}
}
