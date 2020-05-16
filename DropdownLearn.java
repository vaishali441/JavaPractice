package week1.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownLearn {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Select s = new Select(driver.findElementById("ctl00_mainContent_DropDownListCurrency"));
		s.selectByIndex(2);
		s.selectByValue("INR");
		s.selectByVisibleText("AED");
		//s.deselectAll();
		
		System.out.println(s.getOptions());         //list of webelements
		System.out.println(s.getOptions().size());
		
		for(WebElement e: s.getOptions())
		{
			System.out.println(e.getText());
		}
		
		//To get Last value in a dropdown
		
	System.out.println(s.getOptions().get(s.getOptions().size()-1).getText());
		
	}

}
