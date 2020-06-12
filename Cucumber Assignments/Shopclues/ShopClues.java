package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopClues extends BaseClass {
	
	@Given("Go to shopclues")
	public void go_to_shopclues() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.Shopclues.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//button[1]").click();
		Thread.sleep(2000);
	}

	@Given("Mouseover on women and click Casual Shoes")
	public void mouseover_on_women_and_click_Casual_Shoes() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[text() = 'WOMEN']")).perform();
		Thread.sleep(2000);
		builder.click(driver.findElementByXPath("(//a[text() = 'Casual Shoes'])[1]")).perform();
		Thread.sleep(3000);
	}

	@Given("Select Color as Black")
	public void select_Color_as_Black() throws InterruptedException {
		Set<String> winhandles = driver.getWindowHandles();
		List<String> winlist = new LinkedList<String>(winhandles);
		driver.switchTo().window(winlist.get(winlist.size()-1));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id = 'search_facet_color']").sendKeys("Black");
		driver.findElementByXPath("//input[@id = 'Black']/following-sibling::label").click();
		Thread.sleep(2000);
		 
		
	}
	
	List<WebElement> prodnames;
	@Given("Check whether the product name contains the word black")
	public void check_whether_the_product_name_contains_the_word_black() {
		  prodnames =
		  driver.findElementsByXPath("//span[@class = 'prod_name ']"); 
		  
		  for(WebElement name:prodnames) 
		  { 
			  if((!name.getText().contains("Black")) && (!name.getText().contains("black")))
			  {
				  System.out.println("*****************NOT CONTAIN BLACK***** " +
						  name.getText());
			  } 
		}
		 
	}

	Map<String,Integer>  blackprods;
	int size;
	@Given("If so, add the product name and price in to Map")
	public void if_so_add_the_product_name_and_price_in_to_Map() {
		
		size = prodnames.size();
		blackprods = new HashMap<String, Integer>();
		for(int i = 1 ; i<=size;i++)
		{
			String namexpath = "(//span[@class = 'prod_name '])[" +i+  "]";
			String name = driver.findElementByXPath(namexpath).getText();
			
			if(name.contains("Black"))
			{
				String pricexpath = namexpath + "/following-sibling::div[1]/div[1]/span[1]";
				String price = driver.findElementByXPath(pricexpath).getText();
				String  priceamt = price.replaceAll("[^0-9]", "");
				blackprods.put(name,Integer.parseInt(priceamt));
			}
			for(Entry<String,Integer> entry : blackprods.entrySet())
			{
				System.out.println(entry.getKey() + " "+ entry.getValue());
			}
		}
	}

	@Given("Check Display the count of shoes which are more than {int} rupees")
	public void check_Display_the_count_of_shoes_which_are_more_than_rupees(Integer int1) {
		int count = 0;
		for(Entry<String,Integer> entry :blackprods.entrySet())
		{
			if(entry.getValue() > int1)
			{
				count = count + 1;
			}
		}
		System.out.println("**********COUNT**************" + count);
		
	}

	@Given("Click the highest price of the shoe")
	public void click_the_highest_price_of_the_shoe() {
		ArrayList<Integer> a = new ArrayList<>(blackprods.values());
		int maxprice  =  Collections.max(a);
		for(int i = 1; i<=size;i++) {
		String pricexpath1 = "(//span[@class = 'prod_name '])[" +i+  "]" + "/following-sibling::div[1]/div[1]/span[1]";
		String price = driver.findElementByXPath(pricexpath1).getText();
		int price1 = Integer.parseInt(price.replaceAll("[^0-9]", ""));
		if(price1==maxprice)
		{
			driver.findElementByXPath("(//span[@class = 'prod_name '])[" +i+  "]").click();
			break;
		}
		}
	}

	@Given("et the current page URL and check with the product ID")
	public void et_the_current_page_URL_and_check_with_the_product_ID() {
		System.out.println(driver.getCurrentUrl());
		Set<String> winhandles = driver.getWindowHandles();
		List<String> listhandles = new ArrayList<String>(winhandles);
		driver.switchTo().window(listhandles.get(listhandles.size()-1));
		System.out.println(driver.getCurrentUrl());
		String prodID = driver.findElementByXPath("//span[@class = 'pID']/following-sibling::meta").getAttribute("content");
		System.out.println(prodID);
	}

	@Given("Copy the offercode")
	public void copy_the_offercode() {
		String offercode = driver.findElementByXPath("(//div[@class = 'coupons_code'])[1]/span").getText();
		System.out.println(offercode);
	}

	@Given("Select size, color and click ADD TO CART")
	public void select_size_color_and_click_ADD_TO_CART() throws InterruptedException {
		driver.findElementByXPath("(//div[@class = 'inf'])/following-sibling::span[2]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[@id = 'add_cart']").click();
	}

	@When("Mouse over on Shopping cart and click View Cart")
	public void mouse_over_on_Shopping_cart_and_click_View_Cart() {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[@class = 'cart_ic']")).perform();
		driver.findElementByXPath("//a[text() = 'View Cart']").click();
	}

	@Then("Pincode as {int} click Submit and Place Order")
	public void pincode_as_click_Submit_and_Place_Order(Integer int1) {
		driver.findElementById("pin_code_popup").sendKeys(int1.toString());
		driver.findElementById("get_pincode_popup").click();
		driver.findElementByXPath("//div[text() = 'Place Order']").click();
	}

	@Then("Close the Browser")
	public void close_the_Browser() {
		driver.quit();
	}



}
