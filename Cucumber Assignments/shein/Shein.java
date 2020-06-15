package steps;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shein extends BaseClass 
{
	WebDriverWait wait ;
	@Given("Go to shein")
	public void go_to_shein() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.DISMISS);
		options.merge(cap);
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("http://www.Shein.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByXPath("//div[@class = 'c-coupon-box']/i").click();
	}

	@Given("Hover on Clothing and jeans")
	public void hover_on_Clothing_and_jeans() throws InterruptedException {
		  Actions builder = new Actions(driver);
		  builder.moveToElement(driver.findElementByXPath("//span[text() = 'CLOTHING']")).perform(); 
		  Thread.sleep(2000);
		 builder.click(driver.findElementByXPath("(//a[contains(text(),'Jeans')])[1]")).perform();
		 Thread.sleep(4000);
	}

	@Given("Choose Black under Jeans product count")
	public void choose_Black_under_Jeans_product_count() throws InterruptedException {
		driver.findElementByXPath("//a[text() = 'Black']").click();
		Thread.sleep(4000);
	}

	@Given("check size as medium")
	public void check_size_as_medium() throws InterruptedException {
		  driver.executeScript("window.scrollBy(0,300)");
		  Thread.sleep(3000);
		  driver.findElementByXPath("(//li[@class = 'filter-title leftnav-first-title'])[3]/i").click();
		  driver.findElementByXPath("(//span[@class = 'attr-check-box'])[9]").click();
		  Thread.sleep(4000);
	}

	@Given("check whether the color is black")
	public void check_whether_the_color_is_black() throws InterruptedException {
		System.out.println("in");
		WebElement colorele = driver.findElementByXPath("(//a[@class='j-auto-attrlink']/span)[6]");
		Thread.sleep(2000);
		  String color = colorele.getText();
		System.out.println(color +" ********************************");
				if(color.equalsIgnoreCase("Black"))
				{
					System.out.println("***************"+"BLACK COLOUR" + "*******************");
				}
	}

	@Given("Click first item to Add to Bag")
	public void click_first_item_to_Add_to_Bag() {
		driver.findElementByXPath("(//img[@class = 'j-verlok-lazy loaded'])[1]").click();
		Set<String> winhandles = driver.getWindowHandles();
		List<String> winlist = new LinkedList(winhandles);
		driver.switchTo().window(winlist.get(winlist.size()-1));
		driver.findElementByXPath("//button[contains(text(), 'Add To Bag' )]").click();
	}

	@Given("Click the size as M abd click Submit")
	public void click_the_size_as_M_abd_click_Submit() {
		driver.findElementByXPath("(//span[contains(text() ,'M')])[5]").click();
		driver.findElementByXPath("//button[contains(text(), 'Add To Bag' )]").click();
	}

	@Given("Click view Bag")
	public void click_view_Bag() {
		driver.findElementByXPath("//a[text() = 'view bag']").click();
	}

	@When("Check the size is Medium or not.")
	public void check_the_size_is_Medium_or_not() {
		String size = driver.findElementByXPath("//div[@class = 'gd-color-size editable']/div/span").getText();
		if(size.equalsIgnoreCase("M"))
		{
			System.out.println("size is medium");
		}
		else
		{
			System.out.println("size is  not medium");
		}
	}
     
	@Then("close the shein browser")
	public void closeBrowser()
	{
		driver.quit();
	}


}
