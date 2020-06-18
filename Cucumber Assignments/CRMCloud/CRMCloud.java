package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CRMCloud extends BaseClass
{
	Actions builder;
	@Given("Enter username as (.*) and password as (.*)")
	public void enter_username_as_admin_and_password_as_admin(String uname , String pswd) {
		driver.findElementByName("user_name").sendKeys(uname);
		driver.findElementByName("user_password").sendKeys(pswd);
	}

	@Given("choose Claro theme")
	public void choose_Claro_theme() {
		Select s = new Select(driver.findElementById("login_theme"));
		s.selectByValue("Claro");
		driver.findElementById("login_button").click();
	}

	@Given("Go to Sales and Marketting and click Sales Home")
	public void go_to_Sales_and_Marketting_and_click_Sales_Home() {
		builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//div[text() = 'Sales & Marketing']")).perform();
		builder.click(driver.findElementByXPath("//div[text() = 'Sales Home']")).perform();
	}

	@Given("Click Create contact")
	public void click_Create_contact() {
		driver.findElementByXPath("//div[text() = 'Create Contact']").click();
	}

	@Given("Select Title and type First name, Last Name, Email and Phone Numbers")
	public void select_Title_and_type_First_name_Last_Name_Email_and_Phone_Numbers() {
		driver.findElementByName("first_name").sendKeys("Ram");
		driver.findElementByName("last_name").sendKeys("Kumar");
		driver.findElementByName("email1").sendKeys("Ram@gmail.com");
		driver.findElementByName("email2").sendKeys("Kumar@gmail.com");
		driver.findElementByName("phone_work").sendKeys("1234567890");
		driver.findElementByName("phone_home").sendKeys("0987654321");
		driver.findElementByName("phone_mobile").sendKeys("7890654321");
		driver.findElementByName("title").sendKeys("Manager");
	}

	@Given("Select Lead Source as Public Relations and Business Roles")
	public void select_Lead_Source_as_Public_Relations_and_Business_Roles() throws InterruptedException {
		driver.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElementById("DetailFormlead_source-input").click();
		driver.findElementByXPath("//div[text() = 'Public Relations']").click();
		driver.findElementById("DetailFormbusiness_role-input").click();
		driver.findElementByXPath("//div[text() = 'Admin']").click();
	}

	@Given("Fill the Primary Address, City, State, Country and Postal Code and click Save")
	public void fill_the_Primary_Address_City_State_Country_and_Postal_Code_and_click_Save() throws InterruptedException {
		driver.findElementByName("primary_address_street").sendKeys("Nehru street ,Nelson Manikam road");
		driver.findElementByName("primary_address_city").sendKeys("chennai");
		driver.findElementByName("primary_address_state").sendKeys("Tamil Nadu");
		driver.findElementByName("primary_address_country").sendKeys("India");
		driver.findElementByName("primary_address_postalcode").sendKeys("600012");
		driver.findElementById("DetailForm_save2").click();
		Thread.sleep(3000);
	}

	@Given("Click create and Leads")
	public void click_create_and_Leads() throws InterruptedException {
		builder.moveToElement(driver.findElementByXPath("//div[text() = 'Sales & Marketing']")).perform();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text() = 'Leads']").click();
		driver.findElementByXPath("//div[text() = 'Create Lead']").click();
	}

	@Given("Fill First & Last name, Status as In Process, Title as Manager and Department as Sales")
	public void fill_First_Last_name_Status_as_In_Process_Title_as_Manager_and_Department_as_Sales() {
		  driver.findElementByName("first_name").sendKeys("Santhosh");
		  driver.findElementByName("last_name").sendKeys("Kumar");
		  driver.findElementByName("email1").sendKeys("Santhos@gmail.com");
		  driver.findElementByName("email2").sendKeys("Kumar@gmail.com");
		  driver.findElementByName("phone_work").sendKeys("0234567890");
		  driver.findElementByName("phone_home").sendKeys("8987654321");
		  driver.findElementByName("phone_mobile").sendKeys("6890654321");
		  driver.findElementById("DetailFormstatus-input-label").click();
		  driver.findElementByXPath("//div[text() = 'In Process']").click();
		  driver.findElementByName("department").sendKeys("Sales");
		  driver.findElementByName("title").sendKeys("Manager");
	}

	@Given("Select Lead as Public Relations and fill department, Email and Phone Number")
	public void select_Lead_as_Public_Relations_and_fill_department_Email_and_Phone_Number() {
		driver.executeScript("window.scrollBy(0,300)");
		  driver.findElementById("DetailFormlead_source-input").click();
		  driver.findElementByXPath("//div[text() = 'Public Relations']").click();
	}

	@Given("Click Save and View")
	public void click_Save_and_View() throws InterruptedException {
		driver.findElementById("DetailForm_save2").click();
		Thread.sleep(3000);
	}

	@Given("Mouse over on Today's Activities and click Meetings")
	public void mouse_over_on_Today_s_Activities_and_click_Meetings() throws InterruptedException {
		builder = new Actions(driver);
		builder.moveToElement(driver.findElementById("grouptab-0")).perform();
		builder.click(driver.findElementByXPath("//div[text() = 'Meetings']")).perform();
		driver.findElementByXPath("//div[text() = 'Schedule Meeting']").click();
		Thread.sleep(4000);
	}

	@Given("Type Subject as Project Status Status as Planned and Time as tomorrow")
	public void type_Subject_as_Project_Status_Status_as_Planned_and_Time_as_tomorrow_p_m() throws InterruptedException {
		driver.findElementById("DetailFormname-input").sendKeys("Project Status");
		driver.findElementByXPath("//div[@id = 'DetailFormdate_start-input']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@id = 'DetailFormdate_start-calendar-text']/input").clear();
		driver.findElementByXPath("//div[@id = 'DetailFormdate_start-calendar-text']/input").sendKeys("2020-06-19");
		driver.findElementByXPath("//div[@class = 'active-icon uii-time uii-lg uii']").click();
		driver.findElementByXPath("//div[@id = 'DetailFormdate_start-calendar-text']/input").clear();
		driver.findElementByXPath("//div[@id = 'DetailFormdate_start-calendar-text']/input").sendKeys("15:00");
		driver.findElementByXPath("//div[@class = 'active-icon uii-accept uii-lg uii']").click();
	}

	@Given("Click Add paricipants, add your created Lead name and click Save")
	public void click_Add_paricipants_add_your_created_Lead_name_and_click_Save() 
	{
		  driver.executeScript("window.scrollBy(0,300)");
		  driver.findElementByXPath("//button[@name = 'addInvitee']").click();
		  driver.findElementByXPath("(//div[text() = 'Ram Kumar'])[2]").click(); 
		  driver.findElementById("DetailForm_save2").click();
	}

	@When("Click contacts under Sales and Marketting, search the lead Name and click the name from the result")
	public void click_contacts_under_Sales_and_Marketting_search_the_lead_Name_and_click_the_name_from_the_result() throws InterruptedException {
		  builder = new Actions(driver); builder.moveToElement(driver.
		  findElementByXPath("//div[text() = 'Sales & Marketing']")).perform();
		  Thread.sleep(2000);
		  builder.click(driver.findElementByXPath("//div[text() = 'Contacts']")).
		  perform();
		  driver.findElementByXPath("//input[@id = 'filter_text']").sendKeys("Ram Kumar " , Keys.ENTER);
		  Thread.sleep(2000);
		  //driver.findElementByXPath("(//div[text() = 'Ram Kumar'])[2]").click();
		  driver.findElementByXPath("//table[@class = 'listView']/tbody/tr/td[3]//a").click();
		  Thread.sleep(3000);
		 
	}

	@Then("Check weather the Meeting is assigned to the contact.")
	public void check_weather_the_Meeting_is_assigned_to_the_contact() 
	{
		driver.executeScript("window.scrollBy(0,300)");
		String meetingname = driver.findElementByXPath("(//div[@class = 'card-outer panel-outer listview-panel panel-system panel-border'])[1]/div[3]//table/tbody/tr/td[4]/span/a").getText();
		System.out.println(meetingname + " -------------------------");
		if(meetingname.equals("Project Status"))
		{
			System.out.println("Meeting has been assigned");
		}
	}


}
