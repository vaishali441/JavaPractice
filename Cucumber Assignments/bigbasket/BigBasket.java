package steps;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BigBasket extends BaseClass
{
	@Given("Go to bigbasket")
	public void go_to_bigbasket() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.Bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("Hover Shop by Category")
	public void hover_Shop_by_Category() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[@qa = 'categoryDD']")).perform();
		Thread.sleep(3000);
	}

	@Given("Go to Foodgrains, oil,rice")
	public void go_to_Foodgrains_oil_rice() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("(//a[text() = 'Foodgrains, Oil & Masala'])[2]")).perform();
		builder.moveToElement(driver.findElementByXPath("(//a[text() = 'Rice & Rice Products'])[2]")).perform();
		builder.click(driver.findElementByXPath("(//a[text() = 'Boiled & Steam Rice'])[2]")).perform();
	}

	@Given("get url and check")
	public void get_url_and_check() throws InterruptedException {
		String currURL = driver.getCurrentUrl();
		Thread.sleep(3000);
		List<WebElement> navelements = driver.findElementsByXPath("//div[@class = 'breadcrumb-item']");
		String navigation = "";
		for(WebElement ele:navelements)
		{
			navigation = navigation + "/" + ele.getText();
		}
		String lastnav = driver.findElementByXPath("(//div[@itemprop = 'child'])[2]/a/span").getText();
		navigation = navigation + "/" + lastnav;
		System.out.println(navigation);
		System.out.println("Current url----- " + currURL);
	}

	@Given("choose Brand")
	public void choose_Brand() throws InterruptedException {
		driver.findElementByXPath("(//span[text() = 'bb Royal'])[1]").click();
		Thread.sleep(2000);
	}

	@Given("Go to Ponni and selectqty and add")
	public void go_to_Ponni_and_selectqty_and_add() throws InterruptedException {
		driver.findElementByXPath("(//button[@data-toggle='dropdown'])[2]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[text() = '10 kg'])[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//button[@qa = 'add'])[1]").click();
		driver.findElementByXPath("//a[text() = 'Continue']").click();
		Thread.sleep(2000);
	}

	@Given("Search dal")
	public void search_dal() {
		driver.findElementByXPath("//input[@id = 'input']").sendKeys("Dal");
		driver.findElementByXPath("(//input[@qa = 'qtyAS'])[7]").clear();
		driver.findElementByXPath("(//input[@qa = 'qtyAS'])[7]").sendKeys("2");
	}

	@Given("Add toor dhal and set Qty")
	public void add_toor_dhal_and_set_Qty() throws InterruptedException {
		driver.findElementByXPath("(//span[text() = 'ADD'])[7]").click();
		Thread.sleep(2000);
	}

	@Given("Enter Address")
	public void enter_Address() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-200)");
		driver.findElementByXPath("//a[@qa = 'areaDD']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@placeholder = 'Select your city'])[1]").click();
		Thread.sleep(4000);
		driver.findElementByXPath("(//a[@class = 'ui-select-choices-row-inner'])[5]").click();
		//Thread.sleep(4000);
		WebElement ele = driver.findElementByXPath("(//input[@qa = 'areaInput'])[1]");
		ele.sendKeys("Alandur");
		driver.findElementByXPath("(//strong[text()='Alandur']/parent::a[text()='-600016,Chennai'])[5]").click();
		driver.findElementByXPath("//button[text() = 'Continue']").click();
	}

	@When("Hover Mybasket and screenshot")
	public void hover_Mybasket_and_screenshot() throws IOException, InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[@qa = 'myBasket']")).perform();
		Thread.sleep(3000);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:/selenium/error.png"));
	}

	@Then("View Basket and checkout")
	public void view_Basket_and_checkout() {
		driver.findElementByXPath("//button[@qa= 'viewBasketMB']").click();
		driver.findElementByXPath("//button[@class ='close']").click();
		driver.quit();
	}


}
