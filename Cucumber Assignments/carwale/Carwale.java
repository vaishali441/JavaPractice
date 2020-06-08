package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Carwale extends BaseClass {
	
	WebDriverWait wait;
	
	@Given("Go to carwale")
	public void go_to_carwale() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		/*
		 * DesiredCapabilities cap = new DesiredCapabilities();
		 * cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
		 * UnexpectedAlertBehaviour.DISMISS); options.merge(cap);
		 */
	   driver = new ChromeDriver();
	   driver.get("https://www.carwale.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("Click on Used")
	public void click_on_Used() throws InterruptedException {
	    driver.findElement(By.xpath("//li[@class = 'welcome-box__search-item js-welcome-box__list-item']")).click();
	    Thread.sleep(2000);
	}

	@Given("Select the City as Chennai")
	public void select_the_City_as_Chennai() throws InterruptedException {
	  wait = new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("usedCarsList")))).sendKeys("Chennai");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[@cityname = 'chennai,tamilnadu']")).click();
	}

	@Given("Select budget and Click Search")
	public void select_budget_and_Click_Search() throws InterruptedException {
		WebElement minlist = driver.findElementById("minPriceList");
		List<WebElement> minLists = minlist.findElements(By.tagName("li"));
		for(WebElement ele : minLists)
		{
			if(ele.getAttribute("data-min-price").equalsIgnoreCase("8"))
			{
				ele.click();
			}
		}
		
		WebElement maxlist = driver.findElementById("maxPriceList");
	List<WebElement> maxLists = maxlist.findElements(By.tagName("li"));
	for(WebElement ele1 :maxLists)
	{
		if(ele1.getAttribute("data-max-price").equalsIgnoreCase("12"))
		{
			ele1.click();
		}
	}
	
	driver.findElementById("btnFindCar").click();
		 
	}

	@Given("Select Cars with Photos under Only Show Cars With")
	public void select_Cars_with_Photos_under_Only_Show_Cars_With() throws InterruptedException {
	   driver.findElementByXPath("//li[@name = 'CarsWithPhotos']").click();
	   Thread.sleep(3000);
	}

	@Given("Select Manufacturer as Hyundai")
	public void select_Manufacturer() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name = 'search']")).sendKeys("Hyundai");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,300)");
	 driver.findElementByXPath("//li[@data-manufacture-en='Hyundai']").click();
	}

	@Given("Select Fuel Type as Petrol")
	public void select_Fuel_Type_as_Petrol() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElementByXPath("(//h3[@class = 'sub-values'])[6]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//li[@name = 'Petrol']").click();
		Thread.sleep(1000);
	}

	@Given("Select Best Match")
	public void select_Best_Match_as() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-300)");
		Select s = new Select(driver.findElementByXPath("//select[@id = 'sort']"));
		s.selectByValue("2");
	}

	@Given("Validate the Cars are listed with KMs Low to High")
	public void validate_the_Cars_are_listed_with_KMs_Low_to_High() {
		List<WebElement> kmelements = driver.findElements(By.xpath("//span[@class = 'slkms vehicle-data__item']"));
		for(WebElement ele: kmelements)
		{
			System.out.println(ele.getText());
		}
		driver.findElementByXPath("(//a[@class = 'nomoreTips cur-pointer'])[1]").click();
	}

	@Given("Add the least KM ran car to Wishlist")
	public void add_the_least_KM_ran_car_to_Wishlist() {
		driver.findElementByXPath("(//span[@class = 'shortlist-icon--inactive shortlist'])[1]").click();
	}

	@Given("Go to Wishlist and Click on More Details")
	public void go_to_Wishlist_and_Click_on_More_Details() throws InterruptedException {
		//driver.findElementByXPath("//button[@aria-label = 'close']").click();
		driver.findElementByXPath("//li[@class = 'action-box shortlistBtn']").click();
		driver.findElementByPartialLinkText("More details »").click();
	}

	@When("Print all the details under Overview in the Same way as displayed in application")
	public void print_all_the_details_under_Overview_in_the_Same_way_as_displayed_in_application() {
		List<String> Allwin = new ArrayList<>( driver.getWindowHandles());
		  driver.switchTo().window(Allwin.get(1));
		  WebElement panel =
		  driver.findElementByXPath("//div[@class = 'cw-tabs-panel']");
		  List<WebElement> overview =
		  panel.findElements(By.xpath("//div[@class = 'equal-width text-light-grey']")); 
		  for(WebElement ele : overview) 
		  { System.out.println(ele.getText());
		  }
		 
	}

	@Then("Close the browser.")
	public void close_the_browser() {
		driver.quit();
	}



}
