package steps;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Lenskart extends BaseClass {
	Actions builder ;
	@Given("Mouseover on Contact Lenses")
	public void mouseover_on_Contact_Lenses() {
		builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[text() = 'Contact Lenses']")).perform();
	}

	@Given("Click on Monthly under Explore By Disposability")
	public void click_on_Monthly_under_Explore_By_Disposability() {
		builder.click(driver.findElementByXPath("//span[text() = 'Monthly']")).perform();
	}

	@Given("Select brand as Aqualens")
	public void select_brand_as_Aqualens() {
		driver.findElementByXPath("(//span[contains(text(),'Aqualens')])[2]").click();
	}
	

	@Given("Click on the first product")
	public void click_on_the_first_product() {
		driver.findElementByXPath("(//div[@class = 'col-md-12 no-padding'])[1]").click();
	}

	@Given("Click Buy Now")
	public void click_Buy_Now() {
		driver.findElementByXPath("//button[@class='thumbnail-btn'][2]").click();
		driver.findElementByXPath("//button[text() = 'BUY NOW']").click();
	}

	@Given("Select No of boxes as {int} and Power as {int} for both eyes.")
	public void select_No_of_boxes_as_and_Power_as_for_both_eyes(Integer noofbox, Integer int2) {
		Select s = new Select(driver.findElementByXPath("(//select[@name = 'boxes'])[1]"));
		s.selectByValue(Integer.toString(noofbox));
		driver.findElementByXPath("(//div[@class = ' dropdown-display cl-dd'])[1]").click();
		driver.findElementByXPath("//div[text() = '-1.00']").click();
		Select s1 = new Select(driver.findElementByXPath("(//select[@name = 'boxes'])[2]"));
		s.selectByValue(Integer.toString(noofbox));
		driver.findElementByXPath("(//div[@class = ' dropdown-display cl-dd'])[2]").click();
		driver.findElementByXPath("//div[text() = '-1.00']").click();
	}

	@Given("Type your name in User's name")
	public void type_your_name_in_User_s_name() {
		driver.findElementById("example-text-input").sendKeys("Vaishali");
	}

	@When("And click Save and continue")
	public void and_click_Save_and_continue() {
		driver.findElementByXPath("(//button[@unbxdattr='AddToCart'])[1]").click();
	}

	@Then("Print total amount and click Proceed to Checkout")
	public void print_total_amount_and_click_Proceed_to_Checkout() {
		String ordtot = driver.findElementByXPath("//span[text() = 'Order Total :']/following-sibling::span").getText();
		System.out.println(ordtot);
		driver.findElementByClassName("button-green").click();
	}

}
