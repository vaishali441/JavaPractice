package Jun29_2020;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ajio {
	WebDriverWait wait;
	@Test
	public void runAjioTest() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions  options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.Ajio.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElementByXPath("//div[@class='row-btn-cat-nav']//a[1]").click();
		driver.findElementByName("searchVal").sendKeys("bags");
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//ul[@class = 'rilrtl-list ']/li[3]")));
		driver.findElementByXPath("//ul[@class = 'rilrtl-list ']/li[3]").click();
		driver.findElementByClassName("five-grid").click();
		Select s = new Select(driver.findElementByXPath("//div[@class = 'filter-dropdown']/select"));
		s.selectByValue("newn");
		driver.findElementByXPath("(//div[@class = 'facet-head '])[1]").click();
		driver.executeScript("window.scrollBy(0,200)");
		driver.findElementById("minPrice").sendKeys("2500");
		driver.findElementById("maxPrice").sendKeys("5000");
		driver.findElementByXPath("(//button[@type = 'submit'])[2]").click();
		driver.executeScript("window.scrollBy(0,300)");
		driver.findElementByXPath
			("//img[contains(@alt,'TOMMY HILFIGER Blue Slings & Satchels Sling Bag with Chain Strap')]").click();
		Set<String> winhandles = driver.getWindowHandles();
		List<String> lwin= new LinkedList<>(winhandles);
		driver.switchTo().window(lwin.get(1));
		String coupon_apply = driver.findElementByXPath("//div[@class = 'promo-desc']").getText();
		String coupon_code = null;
		String discnt_prz = null;
		if(coupon_apply.contains("2890 and Above "))
		{
			System.out.println("Yes 2890 coupon apllicable");
			coupon_code = driver.findElementByXPath("//div[@class = 'promo-title']").getText();
			coupon_code = coupon_code.replaceAll("Use Code", "");
			System.out.println(coupon_code);
			discnt_prz = driver.findElementByXPath("//div[@class = 'promo-discounted-price']/span").getText();
			discnt_prz = discnt_prz.replaceAll("[^0-9]", "");
			System.out.println("Discount price " + discnt_prz);
		}
		driver.findElementByXPath("//div[@class = 'edd-pincode-msg']").click();
		driver.findElementByXPath("//input[@name = 'pincode']").sendKeys("560043");
		driver.findElementByClassName("edd-pincode-modal-submit-btn").click();
		String dlvrydt = driver.findElementByXPath("//ul[@class = 'edd-message-success-details']//span").getText();
		System.out.println("Delivery :" + dlvrydt);
		driver.executeScript("window.scrollBy(0,300)");
		driver.findElementByXPath("//div[@class = 'other-info-toggle']").click();
		String cuscare = driver.findElementByXPath("//section[@class = 'prod-desc']//ul/li[11]").getText();
		System.out.println(cuscare);
		driver.findElementByXPath("//span[text() = 'ADD TO BAG']").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//span[text() = 'GO TO BAG']").click();
		String ord_tot = driver.findElementByXPath("//span[@class = 'price-value bold-font']").getText();
		System.out.println("Order total before coupon " + ord_tot);
		driver.findElementById("couponCodeInput").sendKeys(coupon_code);
		driver.findElementByXPath("//button[text() = 'Apply']").click();
		String prodprice  = driver.findElementByXPath("//div[@class = 'orignal-price']").getText();
		prodprice = prodprice.substring(4, 9);
		prodprice = prodprice.replaceAll(",", "");
		System.out.println(prodprice);
		if(!prodprice.equals(discnt_prz))
		{
			System.out.println("prod price doesn't match disc price");
		}
		driver.findElementByXPath("//div[@class = 'delete-btn']").click();
		driver.findElementByXPath("(//div[@class = 'delete-btn'])[2]").click();
		driver.quit();
		
		
	}

}
