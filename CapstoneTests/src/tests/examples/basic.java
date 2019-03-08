package tests.examples;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationFramework.OpenChrome;

public class basic {
	
	static WebDriver driver;
	
	/**
	 * run before class, does things that are required before any test is run
	 */
	@BeforeClass
	public static void setup()
	{
		//opens chrome before tests are run
		driver = OpenChrome.open();
	}
	
	/**
	 * run before every test
	 * put things here that need to happen before every test
	 * e.g. be on a certain page, make sure a textbox is clear etc.
	 */
	@Before
	public void redirectBeforeTest()
	{
		//goes back to this page before every test
		 driver.get("http://toolsqa.com/automation-practice-form/");
	}
	
	/**
	 * tests a page title is correct
	 */
	@Test
	public void testTitleCheck()
	{
		//checks if page title is what it should be
		Assert.assertEquals("Demo Form for practicing Selenium Automation", driver.getTitle());
	}
	
	/**
	 * tests an element has correct text
	 */
	@Test
	public void testElementCheck()
	{
		//gets linkt by xpath
		//can also get by id or by css
		WebElement element = driver.findElement(By.xpath("//*[contains(@title, 'Automation Practice Table')]"));
		
		//checks if element text is what it should be
		Assert.assertEquals("Link Test", element.getText());
	}
	
	/**
	 * tests you can click a link
	 */
	@Test
	public void testClicking()
	{
		//gets link and clicks it
		//can also find element and set to a WebElement and .click later
		driver.findElement(By.xpath("//*[contains(@title, 'Automation Practice Table')]")).click();
		
		//checks title of new page is correct
		Assert.assertEquals("Demo Table for practicing Selenium Automation", driver.getTitle());
	}
	
	/**
	 * tests inputting info in a text box
	 */
	@Test
	public void testTextbox()
	{
		//gets textbox by xpath
		WebElement element = driver.findElement(By.xpath("//*[contains(@name, 'firstname')]"));
		
		//inputs a value in the textbox
		element.sendKeys("Kyle");
		
		//checks value was inputted correctly
		Assert.assertEquals("Kyle", element.getAttribute("value"));
		
		//clears the textbox
		element.clear();
		
		//checks textbox was cleared
		Assert.assertEquals("", element.getText());

	}

	/**
	 * done after every test is complete
	 * use this to close chrome
	 * use @after tag for things that need to happen after every test
	 */
	@AfterClass
	public static void finish()
	{
		//closes chromedriver
		driver.quit();
	}
}
