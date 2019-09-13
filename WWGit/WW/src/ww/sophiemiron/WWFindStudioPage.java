package ww.sophiemiron;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class WWFindStudioPage {
	WebDriver driver;
	
	// Locators
	@FindBy(id="meetingSearch") WebElement wwSearch;
	@FindBys({
		@FindBy(className="btn"),
		@FindBy(className="spice-translated")
		})
		WebElement wwSubmit;
	
	// Constructor
	public WWFindStudioPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Gets <Title> from page source
	public String getTitle() {
		return driver.getTitle();
	}
	public void setFindStudio(String location) {
		wwSearch.clear();
		wwSearch.sendKeys(location);
	}
	public  void clickFindStudio() {
		wwSearch.sendKeys(Keys.RETURN);
	}
}
