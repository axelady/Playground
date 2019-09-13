package ww.sophiemiron;

//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WWFindStudioResultPage {
	WebDriver driver;
	
	// Locators
	@FindBy(id="meetingSearch") WebElement wwSearch;
	@FindBy(className="location__name") List<WebElement> wwLocations;
	@FindBy(className="location__distance") List<WebElement> wwdistances;	
	
	// Constructor
	public WWFindStudioResultPage (WebDriver driver) {
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
	public void clickFindStudio() {
		wwSearch.sendKeys(Keys.RETURN);
	}
	public String getLocation(int n) {
		return wwLocations.get(n).getText();
	}
	public String getDistance(int n) {
		return wwdistances.get(n).getText();
	}
	public void clickLocation(int n) {
		wwLocations.get(n).click();
	}
}
