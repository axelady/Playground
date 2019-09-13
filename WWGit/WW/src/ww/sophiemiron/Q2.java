/**
 * 
 */
package ww.sophiemiron;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


/**
 * @author Sophie Miron
 *
 */
public class Q2 {

	/**
	 * @param args
	 */

	WebDriver ffDriver;
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		ffDriver = new FirefoxDriver();
		ffDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void wwTest() {
		String failmessage, expected, actual;
		// POM Pages we will be using
		WWHomePage wwHP;
		WWFindStudioPage wwFSP;
		WWFindStudioResultPage wwFRP;
		WWStudioPage wwSP;
		
//		1. Navigate to https://www.weightwatchers.com/us/
		wwHP = new WWHomePage(ffDriver);
		
//  	2. Verify loaded page title matches “WW (Weight Watchers): Weight Loss & Wellness Help”
		failmessage = "The title of the home page was not correct";
		expected = "WW (Weight Watchers): Weight Loss & Wellness Help";
		actual = wwHP.getTitle();
		assertEquals(failmessage, expected, actual);

		
//		3. On the right corner of the page, click on “Find a Studio”
		wwHP.clickFindStudio();
		wwFSP = new WWFindStudioPage(ffDriver);
		
//		4. Verify loaded page title contains “Find WW Studios & Meetings Near You | WW USA”
		failmessage = "The title of the Find A Studio page was not correct";
		expected = "Find A Meeting | WW USA"; // TODO: getTitle() returns meta property="og:title" , not <title>
		//expected = "Find WW Studios & Meetings Near You | WW USA";
		actual = wwFSP.getTitle();
		//System.out.println(actual);
		assertTrue(failmessage, actual.contains(expected));

//		5. In the search field, search for meetings for zip code: 10011
		wwFSP.setFindStudio("10011");
		wwFSP.clickFindStudio();
		wwFRP = new WWFindStudioResultPage(ffDriver);
		
//		6. Print the title of the first result and the distance (located on the right of location title/name)
		String firstLocation = wwFRP.getLocation(0);
		String firstDistance = wwFRP.getDistance(0);
		System.out.println(firstLocation);
		System.out.println(firstDistance);
		
//		7. Click on the first search result and then, verify displayed location name/title matches with the name of the first searched result that was clicked.
		wwFRP.clickLocation(0);
		wwSP = new WWStudioPage(ffDriver);
		failmessage = "The location name does not match the location name clicked.";
		assertEquals(failmessage, firstLocation, wwSP.getLocation());

//		8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
		wwSP.printTodaysHours();

//		9. Create a method to print the number of meeting the each person(under the scheduled time) has a particular day of the week
//		e.g. printMeetings("Sun")
//		Output should be:
//		Person A  3
//		Person B  1
		System.out.println("\r\nSun");
		wwSP.printMeetings("Sun");
		System.out.println("\r\nMon");
		wwSP.printMeetings("Mon");
		System.out.println("\r\nTue");
		wwSP.printMeetings("Tue");
		System.out.println("\r\nWed");
		wwSP.printMeetings("Wed");
		System.out.println("\r\nThu");
		wwSP.printMeetings("Thu");
		System.out.println("\r\nFri");
		wwSP.printMeetings("Fri");
		System.out.println("\r\nSat");
		wwSP.printMeetings("Sat");
	}
	
	@After
	public void finish() {
	//	ffDriver.close();
	}

}
