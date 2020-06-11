package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Ajio extends BaseClass {
	@Given("Go to Ajio")
	public void go_to_Ajio() {
		ChromeOptions options = new  ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com/shop/women");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Given("WomenCategory_kurtas")
	public void womencategory_kurtas() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[@title = 'WOMEN']")).perform();
		//Thread.sleep(2000);
		driver.findElementByXPath("(//a[@title = 'Kurtas'])[2]").click();
	}

	@Given("Brand Ajio")
	public void brand_Ajio() throws InterruptedException {
		driver.findElementByXPath("(//div[@class ='facet-head '])[2]").click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.findElementByXPath("(//div[@class = 'facet-linkhead'])[7]").click();
		Thread.sleep(3000);
		
	}

	@Given("ajio results")
	public void ajio_results() {
		List<WebElement> brands = driver.findElementsByXPath("//div[@class = 'brand']");
		for(WebElement brand : brands)
		{
			if(!brand.getText().equalsIgnoreCase("AJIO"))
            {
	           System.out.println("**************ALERT  - NOT AJIO******************* " + brand.getText());
            }
		}
	}

	@Given("sort result as discount")
	public void sort_result_as_discount() throws InterruptedException {
		Select s = new Select(driver.findElementByTagName("Select"));
		s.selectByValue("discount-desc");
		Thread.sleep(2000);
	}

	@Given("Select color and Add to Bag")
	public void select_color_and_Add_to_Bag() {
		
		  driver.findElementByXPath("(//div[@class = 'imgHolder'])[1]").click(); 
		  Set<String> winhandles= driver.getWindowHandles();
		  List<String> listhandles = new ArrayList<>(winhandles);
		  driver.switchTo().window(listhandles.get(1));
		  driver.findElementByXPath("//img[@title = 'sea-green']").click();
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,300)");
		  driver.findElementByXPath("//span[text() = 'ADD TO BAG']").click();
	}

	@Given("Verify error message")
	public void verify_error_message() {
		String errmsg = driver.findElementByXPath("//span[@class = 'edd-pincode-msg-details']").getText();
		System.out.println("Error message: " + errmsg);
	}

	@Given("select size and add to bag")
	public void select_size_and_add_to_bag() throws InterruptedException {
		driver.findElement(By.xpath("//div[text() = 'M']")).click();
		driver.findElementByXPath("//span[text() = 'ADD TO BAG']").click();
		Thread.sleep(6000);
	}

	@Given("enter pincode")
	public void enter_pincode() throws InterruptedException {
		driver.findElementByXPath("//span[text() = 'Enter Pin-code To Know Estimated Delivery Date']").click();
		Thread.sleep(2000);
		driver.findElementByName("pincode").sendKeys("603103");
		
	}

	@Given("confirm pincode")
	public void confirm_pincode() throws InterruptedException {
		driver.findElementByClassName("edd-pincode-modal-submit-btn").click();
		Thread.sleep(2000);
	}

	@When("Print message and go to bag")
	public void print_message_and_go_to_bag() throws InterruptedException {
		String message = driver.findElementByClassName("edd-message-success-container").getText();
		System.out.println("*********message***** " + message);
		driver.findElementByClassName("btn-cart").click();
		Thread.sleep(4000);
	}

	@Then("Proceed to Shipping and close browser")
	public void proceed_to_Shipping_and_close_browser() throws InterruptedException {
	//	JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,300)");
		driver.findElementByXPath("//button[text() = 'Proceed to shipping']").click();
		Thread.sleep(3000);
		driver.quit();;
	}



}
