package steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Bigbasket2 extends BaseClass {
	
	Actions act;
@Given("Launch bigbasket")
public void launch_bigbasket() 
{
		/*
		 * System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 * driver = new ChromeDriver(); driver.get("http://www.Bigbasket.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 */
}


@Given("mouse over on  Shop by Category")
public void mouse_over_on_Shop_by_Category() throws InterruptedException {
	act = new Actions(driver);
	act.moveToElement(driver.findElementByXPath("//a[@qa='categoryDD']")).perform();
}

@Given("Go to Beverages and Fruit juices & Drinks")
public void go_to_Beverages_and_Fruit_juices_Drinks() {
	act.moveToElement(driver.findElementByXPath("(//a[text() = 'Beverages'])[2]")).perform();
	act.moveToElement(driver.findElementByXPath("(//a[text() = 'Fruit Juices & Drinks'])[2]")).perform();
}

@Given("Click on JUICES")
public void click_on_JUICES() {
	act.click(driver.findElementByXPath("(//a[text() = 'Juices'])[2]")).perform();
}

@Given("click Tropicana and Real under Brand")
public void click_Tropicana_and_Real_under_Brand() throws InterruptedException {
	driver.findElementByXPath("(//input[@value = 'Search by Brand'])[1]").sendKeys("Tro");
	driver.findElementByXPath("(//span[text() = 'Tropicana'])[1]").click();
	driver.findElementByXPath("(//input[@value = 'Search by Brand'])[1]").clear();
	driver.findElementByXPath("(//input[@value = 'Search by Brand'])[1]").sendKeys("Rea");
	driver.findElementByXPath("(//span[text() = 'Real'])[1]").click();
	Thread.sleep(3000);
}

@Given("Check count of the products from each Brands and total count")
public void check_count_of_the_products_from_each_Brands_and_total_count() {
	List<WebElement> brands = driver.findElementsByXPath("//div[@qa='product_name']/h6");
	int totalcount = brands.size();
	int tropcount = 0;
	int realcount = 0;
	for(WebElement  brand: brands)
	{
		if(brand.getText().equalsIgnoreCase("Tropicana"))
		{
			tropcount = tropcount +1;
		}
		else if(brand.getText().equalsIgnoreCase("Real"))
		{
			realcount = realcount + 1;
		}
	}
	
	System.out.println("total count = " + totalcount);
	System.out.println("tropicana count = " + tropcount );
	System.out.println("Real count = " + realcount);
}
List<WebElement> availitems ;
@Given("Check whether the products is availabe with Add button")
public void check_whether_the_products_is_availabe_with_Add_button() throws InterruptedException
{
	List<WebElement> availitems = driver.findElementsByXPath("//button[@qa = 'add']");
	int availitem_cnt = availitems.size();
	List<WebElement> notavailitems = driver.findElementsByXPath("//button[@qa = 'NM']");
	int notavailitem_cnt = notavailitems.size();
	System.out.println("Available items count " + availitem_cnt );
	System.out.println("Not Available items count " + notavailitem_cnt);
	Thread.sleep(3000);
}

@Given("Add the First listed available product")
public void add_the_First_listed_available_product() throws InterruptedException {
	driver.findElementByXPath("(//button[@qa = 'add'])[1]").click();
	Thread.sleep(2000);
}

@Given("click on Change Address")
public void click_on_Change_Address() throws InterruptedException {
	driver.findElementByXPath("(//a[text() = 'Change Location'])[1]").click();
	Thread.sleep(3000);
}

@Given("Select CHennai as City,Chennai as Area  and click Continue")
public void select_CHennai_as_City_Chennai_as_Area_and_click_Continue() throws InterruptedException {
	driver.findElementByXPath("(//div[@placeholder = 'Select your city'])[1]").click();
	Thread.sleep(2000);
	driver.findElementByXPath("(//span[text() = 'Chennai'])[3]").click();
	Thread.sleep(2000);
	driver.findElementByXPath("(//input[@qa = 'areaInput'])[1]").sendKeys("Alandur");
	Thread.sleep(2000);
	driver.findElementByXPath("(//strong[text()='Alandur']/parent::a[text()='-600016,Chennai'])[5]").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//button[text() = 'Continue']").click();
}

@Given("Mouse over on My Basket print the product name. count and price")
public void mouse_over_on_My_Basket_print_the_product_name_count_and_price() {
	act = new Actions(driver);
	act.moveToElement(driver.findElementByXPath("//span[@title ='Your Basket']")).perform();
	String prodname = driver.findElementByXPath("//a[@qa='prodNameMB']").getText();
	String prodcnt = driver.findElementByXPath("//div[@class = 'btn-counter row']/input").getText();
	String prodprice = driver.findElementByXPath("//span[@qa = 'priceMB']/parent::div").getText();
	System.out.println( prodname + " " + prodcnt + " " + prodprice);
}

@When("Click View Basker and Checkout")
public void click_View_Basker_and_Checkout() {
	act.click(driver.findElementByXPath("//button[@qa = 'viewBasketMB']")).perform();
}

@Then("Click the close button and close the browser")
public void click_the_close_button_and_close_the_browser() throws InterruptedException {
	driver.findElementByXPath("(//button[@class = 'close'])[1]").click();
	Thread.sleep(3000);
}




}
