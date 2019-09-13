package ww.sophiemiron;

import java.util.HashMap;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WWStudioPage {
	WebDriver driver;
	
	// Locators
	@FindBy(className="location__name") WebElement wwLocation;
	@FindBy(xpath="//div[@class='hours-list-item-wrapper hours-list--currentday']")
    WebElement wwToday;
//	List<WebElement> wwTodaysHours = wwToday.findElements(By.xpath(".//div[@ng-repeat='meeting in day.meetings']"));
	
	// Constructor
	public WWStudioPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Gets <Title> from page source
	public String getTitle() {
		return driver.getTitle();
	}

	public String getLocation() {
		return wwLocation.getText();
	}
	public void printTodaysHours() {
		System.out.println(wwToday.getText());	// also prints day of week.    
		/* Use wwTodaysHours element is a list to print just the hours
		 * for (WebElement i : wwTodaysHours) { System.out.println(i.getText()); }
		 */
	}
	public void printMeetings(String dayOfWeek) {
		String path = "//div[@class='schedule-detailed-day-label'][contains(text(),'" + dayOfWeek + "')]";
		WebElement wwMeetingDay   = driver.findElement(By.xpath(path));
		
		path = path + "//ancestor::div[@class='schedule-detailed-day']";
		WebElement wwDayBlock   = driver.findElement(By.xpath(path));
		List<WebElement> wwLeaders = wwDayBlock.findElements(By.xpath(".//div[@class=\"schedule-detailed-day-meetings-item-leader\"]"));
		
        Map<String, Integer> wwMeetingsPerPerson = new HashMap<>();
        String strLeader;
        
		for (WebElement leader : wwLeaders) {
			strLeader = leader.getText();
			Integer noMtgs = wwMeetingsPerPerson.get(strLeader);
			if (noMtgs == null) noMtgs = 1; else noMtgs++;
			wwMeetingsPerPerson.put(strLeader, noMtgs);
		}
		
		for (Map.Entry<String,Integer> entry : wwMeetingsPerPerson.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());	
		}

	}

	
}
