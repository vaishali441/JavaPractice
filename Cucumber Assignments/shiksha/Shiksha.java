package steps;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shiksha extends BaseClass {
	Actions builder;

	@Given("Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges")
	public void mouse_over_on_Colleges_and_click_MS_in_Computer_Science_Engg_under_MS_Colleges() {
		builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("(//label[@for = 'sm3'])[1]")).perform();
		driver.findElementByXPath("//a[text() = 'MS in Computer Science &Engg']").click();
	}

	@Given("Click Change course_country select box, choose course as BE_Btech and Choose specialization as Computer Science & Engineering")
	public void click_Change_course_country_select_box_choose_course_as_BE_Btech_and_Choose_specialization_as_Computer_Science_Engineering()
			throws InterruptedException {
		driver.findElementByXPath("//a[@class = 'change-course']").click();
		Thread.sleep(3000);
		Select s = new Select(driver.findElementByXPath("//select[@id = 'desiredCourse']"));
		s.selectByValue("1510");
		Thread.sleep(2000);
		Select s1 = new Select(driver.findElementById("subCatSelect"));
		s1.selectByValue("277");
		Thread.sleep(2000);
	}

	@Given("Select Study destination as USA, UK, Canada and click Update")
	public void select_Study_destination_as_USA_UK_Canada_and_click_Update() throws InterruptedException {
		driver.findElementByXPath("//div[@class = 'select-overlap']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//strong[text() = 'USA']").click();
		driver.findElementByXPath("//strong[text() = 'UK']").click();
		driver.findElementByXPath("//strong[text() = 'Canada']").click();
		driver.findElementByXPath("(//a[text() = 'OK'])[1]").click();
		driver.findElementByXPath("//input[@value = 'Update']").click();
		Thread.sleep(3000);
	}

	@Given("In Filters Select IELTS and score as {double} & Below in Exam Accepted")
	public void in_Filters_Select_IELTS_and_score_as_Below_in_Exam_Accepted(Double double1)
			throws InterruptedException {
		driver.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		driver.findElementByXPath("//label[@for = 'exam-1']/span").click();
		Thread.sleep(3000);
		Select s2 = new Select(driver.findElementByXPath("(//select[@name = 'examsScore[]'])[2]"));
		s2.selectByValue("IELTS--7.5--2");
		driver.findElementByClassName("cookAgr-btn").click();
		System.out.println(double1);
	}

	@Given("Total Fees as Max_{int}L")
	public void total_Fees_as_Max__L(Integer int1) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id = 'fee-1']/following-sibling::label/span").click();
		Thread.sleep(3000);
	}

	Map<String,Double>map;
	Map<String,List<String>>clgname1;
	@Given("Capture the college Names and fees only if it is Engineering  course")
	public void capture_the_college_Names_and_fees_only_if_it_is_Engineering_course() throws InterruptedException {
		boolean displayed = false;
		map = new HashMap<String, Double>();
		clgname1 = new HashMap<String,List<String>>(); 
		do {
			int size = driver.findElementsByXPath("//div[@class = 'uni-course-details flLt']").size();
			System.out.println(size);
			for (int i = 1; i <= size; i++) {
				String xpath = "(//a[@class = 'tuple-sub-title'])[" + i + "]";
				String course_name = driver.findElementByXPath(xpath).getText();
				if (course_name.contains("Engineering")) {
					String xpath2 = "(//div[@class = 'tuple-title'])[" + i + "]/p[2]";
					String clgname = driver.findElementByXPath(xpath2).getText();
					String xpath3 = "(//div[@class = 'uni-course-details flLt'])[" + i + "]/div[1]/p";
					String fees = driver.findElementByXPath(xpath3).getText();
					System.out.println(clgname + " " + fees);
					String fee = fees.replaceAll("[A-Za-z]", "").trim();
					String xpath4 = "(//a[@class = 'tuple-sub-title'])[" + i + "]";
					String coursetitle = driver.findElementByXPath(xpath4).getText();
					String xpath5 = "(//p[contains(text(),'IELTS:')])[" + i + "]";
					String ieltspts = driver.findElementByXPath(xpath5).getText();
					String courseielts[] = {coursetitle,ieltspts};
					System.out.println(fee);
					map.put(clgname, Double.parseDouble(fee));
					clgname1.put(clgname,Arrays.asList(courseielts));
				}
			}
			driver.executeScript("window.scrollBy(0,1400)");
			Thread.sleep(3000);
			try {
				displayed = driver.findElementByXPath("//a[text() = 'Next']").isDisplayed();
			} catch (Exception e) {
				displayed = false;
			}
			System.out.println(displayed);
			if (displayed) {
				driver.findElementByXPath("//a[text() = 'Next']").click();
			} else
				break;
			Thread.sleep(3000);
		} while (displayed = true);
	}

	Object min_details;Object min_clgname ;
	@When("Search the college name in the search box based on low fees")
	public void search_the_college_name_in_the_search_box_based_on_low_fees() throws InterruptedException {
		Double min = Collections.min(map.values());
		String clgname_minfee = null;
		for(Entry<String, Double> entry :map.entrySet())
		{
			if(entry.getValue().equals(min))
			{
				clgname_minfee = entry.getKey();
			}
		}
		for(Entry entry:clgname1.entrySet())
		{
			if(entry.getKey().equals(clgname_minfee))
			{
				min_details = entry.getValue();
				min_clgname = entry.getKey();
			}
		}
		System.out.println(clgname_minfee);
		driver.findElementById("seachTextBox").click();
		Thread.sleep(2000);
		driver.findElementById("mainSearchBox").sendKeys(clgname_minfee,Keys.ENTER);
		driver.findElementByXPath("//a[@loc = 'utitle']").click();
	}

	@Then("Match the IELTS score, course Title and country from the University Page")
	public void match_the_IELTS_score_course_Title_and_country_from_the_University_Page() {
		String ielts = driver.findElementByXPath("(//div[@class = 'Styled__AllCourseDetail-sc-1yl1nt-38 gpZxNg'])[3]/p").getText();
		String course = driver.findElementByXPath("(//div[@class = 'Styled__AllCourseTuple-sc-1yl1nt-33 kHvhnS'])[1]/a").getText();
		String country = driver.findElementByXPath("(//span[@class = 'loc-icn'])[1]").getText();
		System.out.println(country);
		System.out.println(course + " " + ielts);
		System.out.println("----------------------------------------------------------------------");
		System.out.println(min_clgname  );
		System.out.println(min_details);
	}

}
