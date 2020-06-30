package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Bikewale extends BaseClass {
	
	WebDriverWait wait ;
	
	@Given("Go to menu and click new bikes")
	public void go_to_menu_and_click_new_bikes() {
		driver.findElementByXPath("//span[@class = 'navbarBtn nav-icon']").click();
		driver.findElementByXPath("//span[text() = 'New Bikes']").click();
	}

	@Given("Click New Bikes Then compare bikes")
	public void click_New_Bikes_Then_compare_bikes() throws InterruptedException {
		driver.findElementByXPath("//a[@title = 'Compare Bikes']").click();
		Thread.sleep(4000);
	}

	@Given("Add first bike as Royal Enfield and model as Thunderbird {int}")
	public void add_first_bike_as_Royal_Enfield_and_model_as_Thunderbird(Integer int1) throws InterruptedException {
		wait = new WebDriverWait(driver,70);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//span[@class = 'add-icon'])[1]")));
		driver.findElementByXPath("(//span[@class = 'add-icon'])[1]").click();
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(
				driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[1]")));
		driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[1]").click();
		driver.findElementByXPath("//li[text() = 'Royal Enfield']").click();
		Thread.sleep(9000);
		driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[2]").click();
		driver.findElementByXPath("//li[text() = 'Thunderbird 350']").click();
	}

	@Given("Add second bike Jawa, model as {int} and version Dual Channel ABS - BS VI")
	public void add_second_bike_Jawa_model_as_and_version_Dual_Channel_ABS_BS_VI(Integer int1) throws InterruptedException {
		driver.findElementByXPath("(//span[@class = 'add-icon'])[2]").click();
		driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[4]").click();
		driver.findElementByXPath("(//div[@class = 'chosen-search'])[4]/input").sendKeys("J");
		driver.findElementByXPath("(//ul[@class = 'chosen-results'])[4]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[5]").click();
		driver.findElementByXPath("//li[text() = '42']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[6]").click();
		driver.findElementByXPath("//li[text() = 'Dual Channel ABS - BS VI']").click();
	}

	@Given("Add bike brand Kawasaki model as Ninja {int}")
	public void add_bike_brand_Kawasaki_model_as_Ninja(Integer int1) throws InterruptedException {
		driver.findElementByXPath("(//span[@class = 'add-icon'])[3]").click();
		driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[7]").click();
		driver.findElementByXPath("(//div[@class = 'chosen-search'])[7]/input").sendKeys("Ka");
		driver.findElementByXPath("(//ul[@class = 'chosen-results'])[7]/li").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class = 'chosen-container chosen-container-single'])[8]").click();
		driver.findElementByXPath("(//ul[@class='chosen-results'])[8]/li").click();
	}
	

	@When("click compare")
	public void click_compare() {
		driver.findElementById("btnCompare").click();
	}

	@Then("Find and print the maximum overall rating of all the bikes and find the max")
	public void find_and_print_the_maximum_overall_rating_of_all_the_bikes_and_find_the_max() {
		List<String> l = new ArrayList<String>();
		for(int i =1 ; i<=3;i++)
		{
			String xpath = "(//div[@class = 'rating-block']/span[1])["+ i+"]";
			String rating = driver.findElementByXPath(xpath).getText();
			l.add(rating);
		}
		System.out.println(l);
		System.out.println(Collections.max(l));
	}



	}
