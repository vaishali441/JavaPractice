package Jun29_2020;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PepperFry {
	@Test
	public void runPepperFry() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElementById("webklipper-publisher-widget-container-notification-close-div").click();
		driver.switchTo().defaultContent();
		driver.findElementByXPath("(//a[@class = 'popup-close'])[6]").click();
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[text() = 'Furniture']")).perform();
		driver.findElementByXPath("//a[text() = 'Office Chairs']").click();
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElementByXPath("//div[@class = 'close']").click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class = 'cat-wrap-img'])[2]").click();
		WebElement minhght = driver.findElementByXPath("(//input[@class = 'clipFilterDimensionHeightValue'])[1]");
		minhght.clear();
		minhght.sendKeys("50",Keys.TAB);
		Thread.sleep(5000);
		Actions builder1 = new Actions(driver);
		builder1.click(driver.findElementByXPath("//a[@data-productname='Poise Executive Chair in Black Colour']")).perform();
		builder1.moveToElement(driver.findElementByXPath("//a[text() = 'Furniture']")).perform();
		Thread.sleep(1000);
		builder1.click(driver.findElementByXPath("//a[text() = 'Office Tables']")).perform();
		Thread.sleep(3000);
		builder1.click(driver.findElementByXPath("//img[@alt='Executive Desks']")).perform();
		driver.findElementByXPath("//label[@for='price20000-40000']").click();
		Thread.sleep(3000);
		driver.findElementById("clip_wishlist_").click();
		Thread.sleep(3000);
		String wshlst_itemcnt = driver.findElementByXPath("(//span[@class = 'count_alert'])[2]").getText();
		System.out.println(wshlst_itemcnt);
		driver.findElementByXPath("//a[@data-tooltip='Wishlist']").click();
		String offerprz = driver.findElementByXPath("(//span[text() = 'Offer Price '])[1]/following-sibling::span").getText();
		System.out.println(offerprz);
		String couponcde = driver.findElementByXPath("(//p[contains(@class , 'use-coupon')])[1]/strong").getText();
		System.out.println(couponcde);
		driver.findElementByXPath("(//a[@class = 'addtocart_icon'])[1]").click();
		driver.findElementByXPath("//input[@class='srvc_pin_text']").sendKeys("600128");
		driver.findElementByXPath("//a[text() = 'Check']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@class='proceed_cta']").click();
		Thread.sleep(2000);
		driver.findElementById("coupon_code").sendKeys(couponcde);
		driver.findElementById("cpn_check_btn").click();
		driver.findElementByXPath("//a[@class = 'btn_green_big  ']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text() = 'ORDER SUMMARY']").click();
		Thread.sleep(2000);
		driver.executeScript("window.scrollBy(0,300)");
		WebElement capture = driver.findElementByXPath("//li[contains(@class , 'onepge_ordersummary ')]");
		File src = ((TakesScreenshot)capture).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Admin\\Desktop\\Cucumber Assignments\\img.png"));
		driver.quit();
	}

}
