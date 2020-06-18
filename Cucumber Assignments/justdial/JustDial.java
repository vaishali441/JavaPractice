package steps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JustDial extends BaseClass 
{
	@Given("Cick on Air Tickets")
	public void cick_on_Air_Tickets() {
		driver.findElementByXPath("//a[@title = 'Air Tickets']").click();
	}

	@Given("Type Chennai and choose Chennai, IN - Chennai Airport \\(MAA) as Leaving From")
	public void type_Chennai_and_choose_Chennai_IN_Chennai_Airport_MAA_as_Leaving_From() {
		driver.findElementByName("departurea").sendKeys("Chennai");
		driver.findElementByXPath("//li[text() = 'Chennai, IN - Chennai Airport (MAA)']").click();
	}

	@Given("Type Toronto and select Toronto, CA - Toronto City Centre Airport \\(YTZ) as Going To")
	public void type_Toronto_and_select_Toronto_CA_Toronto_City_Centre_Airport_YTZ_as_Going_To() {
		driver.findElementByName("arrival").sendKeys("Toronto");
		driver.findElementByXPath("//li[text() = 'Toronto, CA - Toronto City Centre Airport (YTZ)']").click();

	}

	@Given("Set Departure")
	public void set_Departure_as_July(){
		driver.findElementByXPath("//span[@class = 'ui-icon ui-icon-circle-triangle-e']").click();
		driver.findElementByXPath("//table [@class = 'ui-datepicker-calendar']/tbody/tr[4]/td[4]/a").click();
	}

	@Given("Add Adult {int}, Children {int} click and Search")
	public void add_Adult_Children_click_and_Search(Integer int1, Integer int2) {
		int adult = int1;
		for(int i = 1 ; i<= adult-1 ; i++)
		{
			driver.findElementByXPath("//input[@id = '_dAdultsCountSelectorVal']/following-sibling::span").click();
		}
		int child = int2;
		for(int j = 0 ; j< child ; j++ )
		{
			driver.findElementByXPath("//input[@id = '_dChildrenCountSelectorVal']/following-sibling::span").click();
		}
		driver.findElementByXPath("//input[@value = 'SEARCH']").click();
	}

	@Given("Select Air Canada from multi-airline itineraries")
	public void select_Air_Canada_from_multi_airline_itineraries() {
		driver.findElementByXPath("//input[@id = 'airline1']").click();
	}

	@Given("Click on Price to sort the result")
	public void click_on_Price_to_sort_the_result() {
		driver.findElementByXPath("//a[@id = 'priceSort']").click();
	}

	@Given("Click on +Details of first result under Price")
	public void click_on_Details_of_first_result_under_Price() {
		driver.findElementByXPath("(//a[text() = '+ Details'])[1]").click();
	}

	@Given("Capture the Flight Arrival times.")
	public void capture_the_Flight_Arrival_times() {
		List<WebElement> arrivaltime = driver.findElementsByXPath("//table[@class = 'detTab']/tbody/tr/td[6]");
		for(WebElement arr:arrivaltime)
		{
			System.out.println(arr.getText());
		}
	}

	String prices;
	@Given("Capture the total price in a list and Click on Book")
	public void capture_the_total_price_in_a_list_and_Click_on_Book() {
	prices = driver.findElementByXPath("//table[@id = 'sortResult']/tbody/tr[1]/td[5]/span").getText();
	System.out.println("Price  " + prices );
	driver.findElementByXPath("//table[@id = 'sortResult']/tbody/tr[1]/td[6]/a").click();
	}

	@When("Capture the Airport name base on the list of time")
	public void capture_the_Airport_name_base_on_the_list_of_time() {
		Map<String,String> airport_time = new HashMap<String, String>();
		for(int i = 1 ; i <= 13 ; i+=4)
		{
			String xpath1 = "//table[@class = 'detTabS detTab']/tbody[1]/tr[" + i + "]/td[3]";
			String xpath2 = "//table[@class = 'detTabS detTab']/tbody[1]/tr[" + i + "]/td[6]";
			String airport = driver.findElementByXPath(xpath1).getText();
			String time = driver.findElementByXPath(xpath2).getText();
			airport_time.put(airport , time);
		}
		System.out.println(airport_time);
	}

	@Then("Captur the total fare and print the difference amount from previous total price")
	public void captur_the_total_fare_and_print_the_difference_amount_from_previous_total_price() {
		String totprice = driver.findElementByXPath("//span[@id = 'totalFare']/b").getText();
		int diffamt = Integer.parseInt(totprice) - Integer.parseInt(prices) ;
		System.out.println("Difference amount = " + diffamt );
	}



}