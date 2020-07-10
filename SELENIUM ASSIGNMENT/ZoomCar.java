package Jun29_2020;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ZoomCar {
	@Test
	public void runZoomCar() throws InterruptedException, IOException {
		// 1. Go to https://www.zoomcar.com/chennai
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zoomcar.com/chennai");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// 2. Click on Start your wonderful journey
		driver.findElementByClassName("search").click();

		// 3. Select any location under POPULAR PICK-UP POINTS and click next
		driver.findElementByXPath("//div[contains(text() , 'Kodambakkam')]").click();
		driver.findElementByXPath("//button[@class = 'proceed']").click();
		Thread.sleep(1000);

		// 4. Select tomorrow's date and time as 9:00 AM as start date and time and
		// Click Next
		driver.findElementByXPath("(//div[@class = 'day low-price'])[1]").click();
		driver.findElementByXPath("//span[text() = '09:00']").click();
		driver.findElementByClassName("proceed").click();
		Thread.sleep(2000);

		// 5. Click on Show More and Select tomorrow's date and Select time as 6:00 PM
		// as end date and Click Done
		driver.findElementByClassName("show-more").click();
		driver.findElementByXPath("(//li[@class = 'active low-price'])[1]").click();
		driver.findElementByXPath("//span[text() = '18:00']").click();
		driver.findElementByXPath("//button[text() = 'Done']").click();
		Thread.sleep(2000);

		// 6. Take the snapshot for PICKUP TIME and DROP OFF TIME
		WebElement time_det = driver.findElementByXPath("//div[@class = 'duration-details']");
		File src = ((TakesScreenshot) time_det).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Admin\\Desktop\\Cucumber Assignments\\img1.png"));

		// 7. Validate the pickup time and Drop off time are correct (as you selected)
		// and click on Done
		String pickup_time = driver.findElementByXPath("(//div[@class = 'time']/div[2])[1]").getText().trim();
		String drop_time = driver.findElementByXPath("(//div[@class = 'time']/div[2])[2]").getText().trim();
		System.out.println("Pickup time - " + pickup_time + " and " + "Drop time - " + drop_time);

		// 8. Click on Price: High to Low and validate the sort order of the car price
		// programmatically
		driver.findElementByXPath("//div[text() = ' Price: High to Low ']").click();
		List<WebElement> prices = driver.findElementsByXPath("//div[@class = 'new-price']");
		List<Integer> prices1 = new ArrayList<>();
		for (WebElement price : prices) {
			String pricenum = price.getText();
			pricenum = pricenum.replaceAll("[^0-9]", "");
			prices1.add(Integer.parseInt(pricenum));
		}
		System.out.println("----------Before Sort---------");
		System.out.println(prices1);
		System.out.println("----------After Sort---------");
		Collections.sort(prices1);
		System.out.println(prices1);
		System.out.println("----------After Reverse Sort---------");
		Collections.reverse(prices1);
		System.out.println(prices1);

		// 9. Print all the Car name and respective Price from High to Low ( car name --
		// price )
		int size = driver.findElementsByXPath("//div[@class = 'details']/h3").size();
		for (int i = 1; i <= size; i++) {
			String carnames = "(//div[@class = 'details']/h3)[" + i + "]";
			String carname = driver.findElementByXPath(carnames).getText();
			String carprices = "(//div[@class = 'new-price'])[" + i + "]";
			String carprz = driver.findElementByXPath(carprices).getText();
			System.out.println(carname + "-----" + carprz);
		}

		// 10. Take snapshot of the details for the Highest price car
		WebElement high_paycar = driver.findElementByXPath("(//div[@class = 'details'])[1]");
		File src1 = ((TakesScreenshot) high_paycar).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("C:\\Users\\Admin\\Desktop\\Cucumber Assignments\\img2.png"));

		// 11. Click on Know More for the Highest price car and print the rate after 45Kms
		driver.findElementByXPath("(//div[@class='know-more-details'])[1]").click();
		String rate_af45km = driver.findElementByXPath("(//div[@class='price-info'])[1]").getText();
		System.out.println(rate_af45km);

		// 12. Close the Browser
		driver.quit();

	}

}
