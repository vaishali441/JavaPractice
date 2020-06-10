package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Trivago extends BaseClass
{
	@Given("Go to trivago")
	public void goToTrivago() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.trivago.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("Type Agra in Destination and select Agra, Uttar Pradesh")
	public void typeAgraInDestinationAndSelectAgraUttarPradesh() throws InterruptedException {
		driver.findElementByXPath("//input[@type = 'search']").sendKeys("Ag");
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[@class ='ssg-subtitle'])[1]").click();
		
	}

	@Given("choose checkin and checkout date")
	public void chooseCheckinAndCheckoutDate() throws InterruptedException {
		JavascriptExecutor js =( JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		driver.findElementByXPath("//table[@class = 'cal-month']/tbody/tr[3]/td[3]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//table[@class = 'cal-month']/tbody/tr[5]/td[3]").click();
		Thread.sleep(3000);
	}

  @Given("Select roomtype") 
   public void selectRoomtype() throws InterruptedException 
   { 
	   driver.findElementByXPath("(//span[@class = 'roomtype-btn__label'])[3]").click();
	   Thread.sleep(2000);
   }	 

	@Given("choose Adults_children")
	public void chooseAdults_children() throws InterruptedException {
		Select s = new Select(driver.findElementByXPath("//select[@id='select-num-adults-2']"));
		s.selectByValue("2");
		Thread.sleep(2000);
		Select schild = new Select(driver.findElementByXPath("//select[@id='select-num-children-2']"));
		schild.selectByValue("1");
		Thread.sleep(2000);
		Select schildage = new Select(driver.findElementByXPath("//select[@id='select-ages-children-2-3']"));
		schildage.selectByValue("4");
	}

	@Given("click confirm and search")
	public void clickConfirmAndSearch() throws InterruptedException {
		driver.findElementByXPath("(//span[@class = 'btn__text'])[2]").click();
		Thread.sleep(2000);
	}

	@Given("Select accomdation type")
	public void selectAccomdationType() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElementByXPath("(//span[@class='filter-value'])[1]").click();
		driver.findElementByXPath("//input[@value = 'Hotels only']").click();
		driver.findElementByXPath("//button[@title = '4-star hotels']").click();
		driver.findElementByXPath("//button[text() = 'Done']").click();
	}

	@Given("select guest rating")
	public void selectGuestRating() {
		driver.findElementByXPath("(//button[@class = 'filter-item filter-item--select js-toolbar-hover-button'])[2]").click();
		driver.findElementByXPath("//span[text() = 'Very good']").click();
		driver.findElementByXPath("(//button[@class = 'filter-item filter-item--select js-toolbar-hover-button'])[3]").click();
		Select s = new Select(driver.findElementByXPath("//select[@name = 'pois']"));
		s.selectByVisibleText("Agra Fort");
		driver.findElementByXPath("//button[text() = 'Done']").click();
	}

	@Given("select Airconditioning")
	public void selectAirconditioning() {
		driver.findElementByXPath("(//button[@class = 'filter-item filter-item--select js-toolbar-hover-button'])[4]").click();
		driver.findElementByXPath("//label[text() = 'Air conditioning']").click();
		driver.findElementByXPath("//label[text() = 'WiFi']").click();
		driver.findElementByXPath("//label[text() = 'Restaurant']").click();
		driver.findElementByXPath("//button[text() = 'Done']").click();
	}

	@Given("sort the results")
	public void sortTheResults() throws InterruptedException {
		Select s = new Select(driver.findElementByXPath("//select[@id = 'mf-select-sortby']"));
		s.selectByValue("7");
		Thread.sleep(3000);
	}

	@Given("Print hotelname and rating")
	public void printHotelnameAndRating() throws InterruptedException {
		String hotelname = driver.findElementByXPath("//span[@data-qa = 'item-name']").getAttribute("title");
		System.out.println(hotelname);
		String rating = driver.findElementByXPath("(//span[@itemprop = 'ratingValue'])[1]").getText();
		System.out.println(rating);
		String review = driver.findElementByXPath("(//span[@class = 'details-paragraph details-paragraph--rating'])[1]").getText();
		System.out.println(review);
		driver.findElementByXPath("(//span[@class ='accommodation-list__text--551fd'])[1]").click();
		Thread.sleep(4000);
	}

	@Given("print URL")
	public void printURL() {
		Set<String> winhandles =driver.getWindowHandles();
		List<String> list = new ArrayList<>(winhandles);
		String newwin = list.get(1);
		driver.switchTo().window(newwin);
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	@Given("print room price")
	public void printRoomPrice() {
		String roomprice = driver.findElementByXPath("//div[@class = 'price-start ']/strong").getText();
		System.out.println(roomprice);
	}

	@When("click reserve")
	public void clickReserve() {
	}

	@Then("close the browser")
	public void closeTheBrowser() {
	}

}
