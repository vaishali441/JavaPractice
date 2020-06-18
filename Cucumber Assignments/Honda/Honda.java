package steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Honda extends BaseClass {
	Actions builder;
	@Given("Click on Specifications and mouseover on Engine")
	public void click_on_Specifications_and_mouseover_on_Engine() throws InterruptedException {
		driver.findElementByXPath("//button[@class = 'close']").click();
		driver.findElementById("link_Scooter").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//a[contains(@href,'dio')])[1]/img").click();
		driver.findElementByXPath("//a[text() = 'Specifications']").click();
		Thread.sleep(4000);
		builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[text() = 'ENGINE']")).perform();
	}

	Map<String , String > map1;
	@Given("Put all the details as key and value into Map")
	public void put_all_the_details_as_key_and_value_into_Map() {
	  WebElement  ele = driver.findElementByXPath("(//ul[@class  = 'tab_content'])[2]");
		int noofrows  = ele.findElements(By.tagName("li")).size();
		System.out.println("Size " + noofrows);
		map1 = new HashMap<String,String>();
		for(int i = 2 ; i<= noofrows ; i++)
		{
			String xpath1 = "(//ul[@class  = 'tab_content'])[2]/li["  + i + "]/span[1]";
			String xpath2 = "(//ul[@class  = 'tab_content'])[2]/li["  + i + "]/span[2]";
			String col1 = driver.findElementByXPath(xpath1).getText();
			String col2 = driver.findElementByXPath(xpath2).getText();
			map1.put(col1,col2);
		}
		for(Entry<String, String>  entry:map1.entrySet())
		{
			System.out.println(entry.getKey() + " :" + entry.getValue());
		}
		
	}

	@Given("Go to Scooters and click Activa")
	public void go_to_Scooters_and_click_Activa() throws InterruptedException {
		driver.findElementById("link_Scooter").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//a[contains(@href,'activa125')]/img").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//a[text() = 'Specifications']").click();
		Thread.sleep(3000);
		builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[text() = 'ENGINE']")).perform();
	}
 
	Map<String , String > map2;
	@Given("Put All its Engine Specification into another Map same as like dio")
	public void put_All_its_Engine_Specification_into_another_Map_same_as_like_dio() {
		WebElement  ele = driver.findElementByXPath("(//ul[@class  = 'tab_content'])[2]");
		int noofrows  = ele.findElements(By.tagName("li")).size();
		System.out.println("Size " + noofrows);
		map2 = new HashMap<String,String>();
		for(int i = 2 ; i<= noofrows ; i++)
		{
			String xpath1 = "(//ul[@class  = 'tab_content'])[2]/li["  + i + "]/span[1]";
			String xpath2 = "(//ul[@class  = 'tab_content'])[2]/li["  + i + "]/span[2]";
			String col1 = driver.findElementByXPath(xpath1).getText();
			String col2 = driver.findElementByXPath(xpath2).getText();
			map2.put(col1,col2);
		}
		System.out.println("-----------------Activa 125-----------------");
		for(Entry<String, String>  entry:map2.entrySet())
		{
			System.out.println(entry.getKey() + " :" + entry.getValue());
		}
		
	}

	@Given("Compare Dio and Activa Maps and print the different values of the samekeys.")
	public void compare_Dio_and_Activa_Maps_and_print_the_different_values_of_the_samekeys() {
		int mapsize = map1.size();
		Set<String> keySet1 = map1.keySet();
		Set<String> keySet2 = map2.keySet();
		if(keySet1.equals(keySet2))
		{
			System.out.println("Both keys are equal");
		}
		List<String> list =  new ArrayList<String>(keySet1);
		for(int i = 0; i < mapsize; i++) {
		String key = list.get(i);
		if(!map1.get(key).equals(map2.get(key)))
		{
			System.out.println(key  +  " Dio "  + map1.get(key) + "---" + "Activa " + map2.get(key));
			 
		}
		}
	}

	@Given("Click FAQ from Menu and Click dio under Browse By Product")
	public void click_FAQ_from_Menu_and_Click_dio_under_Browse_By_Product() {
		driver.findElementByXPath("(//a[text() = 'FAQ'])[1]").click();
		driver.findElementByXPath("//a[text() = 'Dio BS-VI']").click();
	}

	@Given("Click  Vehicle Price and Select scooter, Dio BS-VI from the dropdown and click submit")
	public void click_Vehicle_Price_and_Select_scooter_Dio_BS_VI_from_the_dropdown_and_click_submit() throws InterruptedException {
		driver.findElementByXPath("//ul[@class = 'nav nav-pills tabb-design  ']/li[6]").click();
		Thread.sleep(3000);
		Select s = new Select(driver.findElementByXPath("(//select[@name = 'SegmentID'])[6]"));
		s.selectByValue("2");
		Select s1 = new Select(driver.findElementByXPath("(//select[@name = 'ModelID'])[6]"));
		s1.selectByValue("34");
		driver.findElementByXPath("//button[@id = 'submit6']").click();
	}

	@Given("click the price link,  Go to the new Window and select the state, city")
	public void click_the_price_link_Go_to_the_new_Window_and_select_the_state_city() throws InterruptedException {
		driver.findElementByXPath("//a[text() = 'Click here to know the price of Dio BS-VI.']").click();
		Set<String> winhandles = driver.getWindowHandles();
		List<String> listhandles = new ArrayList<String>(winhandles);
		driver.switchTo().window(listhandles.get(1));
		Select s = new Select(driver.findElementByXPath("//select[@id = 'StateID']"));
		s.selectByValue("28");
		Select s1 = new Select(driver.findElementByXPath("//select[@id = 'CityID']")); 
		s1.selectByValue("1524");
		driver.findElementByXPath("//button[text() = 'Search']").click();
		Thread.sleep(2000);
	}

	@Given("Print the price and model")
	public void print_the_price_and_model() {
		String model1 = driver.findElementByXPath("//table[@id = 'gvshow']/tbody/tr[1]/td[2]").getText();
		String price1 = driver.findElementByXPath("//table[@id = 'gvshow']/tbody/tr[1]/td[3]").getText();
		String model2 = driver.findElementByXPath("//table[@id = 'gvshow']/tbody/tr[2]/td[1]").getText();
		String price2 = driver.findElementByXPath("//table[@id = 'gvshow']/tbody/tr[2]/td[2]").getText();
		System.out.println(model1 + " : " + price1);
		System.out.println(model2 + " : " + price2);
	}

	@When("Click Product Enquiry and Fill all the * field except Mobile, check the terms and conditions box and click submit")
	public void click_Product_Enquiry_and_Fill_all_the_field_except_Mobile_check_the_terms_and_conditions_box_and_click_submit() {
	driver.executeScript("window.scrollBy(0,300)");
	driver.findElementByXPath("//span[text() = 'Product Enquiry ']").click();
	Select s = new Select(driver.findElementByXPath("//select[@id = 'ModelID']"));
	s.selectByValue("28");
	Select s1 = new Select(driver.findElementByXPath("//select[@id = 'StateID']"));
	s1.selectByValue("28");
	Select s2 = new Select(driver.findElementByXPath("//select[@id = 'CityID']"));
	s2.selectByValue("1524");
	Select s3 = new Select(driver.findElementByXPath("//select[@id = 'TitleID']"));
	s3.selectByValue("Ms.");
	driver.findElementByXPath("//input[@id = 'Name']").sendKeys("Vaishali");
	driver.findElementByXPath("//input[@id = 'Email']").sendKeys("vaishalikarthika@gmail.com");
	driver.findElementByXPath("//input[@id = 'TermsAndConditions']").click();
	driver.findElementByXPath("//button[@id = 'submit']").click();
	}

	@Then("Verify the error message under the mobile number field.")
	public void verify_the_error_message_under_the_mobile_number_field() {
		String errtxt = driver.findElementByXPath("(//span[@class = 'text-danger field-validation-error'])[1]/span").getText();
	System.out.println(errtxt);
	}




}
