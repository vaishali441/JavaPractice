package Jun29_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Trivago {
	
	@Test
	public void runTrivago() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Go to https://www.trivago.com/
		driver.get("https://www.trivago.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		
		
	    //Type Agra in Destination and select Agra, Uttar Pradesh.
		driver.findElementByXPath("//input[@type= 'search']").sendKeys("Agra ");
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text() = 'City - Uttar Pradesh, India']").click();
		
		driver.findElementByXPath("//button[text() = 'OK']").click();
		
		//Choose May 15 as check in and May 30 as check out
		driver.findElementByXPath("//time[@datetime='2020-07-15']").click();
		driver.findElementByXPath("//time[@datetime='2020-07-30']").click();
		
		// Select Room as Family Room
		//driver.findElementByXPath("//span[text() = 'Family rooms']").click();
		
		 //Choose Number of Adults 2, Childern 1 and set Child's Age as 4
		driver.findElementByXPath("//input[@id = 'children-input']/following-sibling::button").click();
		Thread.sleep(4000);
		Select s = new Select(driver.findElementByName("mf-select-children-age-0"));
		s.selectByValue("4");
		
		//Click Confirm button and click Search
		driver.findElementByXPath("(//button[text() = 'Apply'])[1]").click();
		
		// Select Accommodation type as Hotels only and choose 4 stars
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//span[text() = 'All types']")).perform();
		builder.click(driver.findElementByXPath("//label[text() = 'Hotel']")).perform();
		builder.click(driver.findElementByXPath("//span[text() = '4-star hotels']")).perform();
		builder.click(driver.findElementByXPath("//button[text() = 'Done']")).perform();
		
		// Select Guest rating as Very Good
		builder.moveToElement(driver.findElementByXPath("//span[text() = 'All']")).perform();
		builder.click(driver.findElementByXPath("//span[text() = 'Very good']")).perform();
		
		// Set Hotel Location as Agra Fort and click Done
		builder.moveToElement(driver.findElementByXPath("//span[text() = 'City center']")).perform();
		Select s1 = new Select(driver.findElementById("pois"));
		s1.selectByVisibleText("Agra Fort");
		builder.click(driver.findElementByXPath("//button[text() = 'Done']")).perform();
		
		// In more Filters, select Air conditioning, Restaurant and WiFi and click Done
		builder.moveToElement(driver.findElementByXPath("//button[@title = 'Select']")).perform();
		builder.click(driver.findElementByXPath("//label[text() = 'Air conditioning']")).perform();
		builder.click(driver.findElementByXPath("//label[text() = 'Restaurant']")).perform();
		builder.click(driver.findElementByXPath("//label[text() = 'Free WiFi']")).perform();
		builder.click(driver.findElementByXPath("//button[text() = 'Done']")).perform();
		
		// Sort the result as Rating & Recommended
		Select s2 = new Select(driver.findElementById("mf-select-sortby"));
		s2.selectByValue("7");
		
		// Print the Hotel name, Rating, Number of Reviews and Click View Deal
		String hotel_name = driver.findElementByXPath("(//span[@data-qa = 'item-name'])[1]").getText();
		String rating = driver.findElementByXPath("(//span[@itemprop=\"ratingValue\"])[1]").getText();
		String review = driver.findElementByXPath("(//span[@class='details-paragraph details-paragraph--rating'])[1]").getText();
		System.out.println(hotel_name + "-----" + rating + "----" + review);
		driver.manage().deleteAllCookies();
		driver.findElementByXPath("(//button[@data-qa='champion-deal'])[1]").click();
		
		// Print the URL of the Page
		Set<String> winhans = driver.getWindowHandles();
		List<String> lwinhans = new ArrayList<>(winhans);
		driver.switchTo().window(lwinhans.get(1));
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		// Print the Price of the Room and click Choose Your Room
		//Thread.sleep(4000);
		//driver.findElementByClassName("modal-mask-closeBtn").click();
		String roomprice = driver.findElementByXPath("(//div[contains(@class , 'bui-price-display')]/div[2]//div/div)[1]").getText();
		System.out.println(roomprice);
		driver.findElementByXPath("(//span[@class='bui-button__text'])[1]").click();
		
		// Click Reserve and I'll Reserve
		Thread.sleep(3000);
		//driver.findElementByXPath("//button[@class='cta widget-modaloverlay-close']").click();
		driver.findElementByXPath("(//td[@class ='submitButton']/a)[1]").click();
		
		// Close the browser
		driver.quit();
	}

}
