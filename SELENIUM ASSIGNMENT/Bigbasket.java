package Jun29_2020;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Bigbasket {
	@Test
	public void runBigBasket() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// 1) Go to https://www.bigbasket.com/
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// 2) mouse over on Shop by Category
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[@qa = 'categoryDD']")).perform();
		Thread.sleep(1000);

		// 3) Go to Beverages and Fruit juices & Drinks
		builder.moveToElement(driver.findElementByXPath("(//a[text() = 'Beverages'])[2]")).perform();
		builder.moveToElement(driver.findElementByXPath("(//a[text() = 'Fruit Juices & Drinks'])[2]")).perform();

		// 4) Click on JUICES
		builder.click(driver.findElementByXPath("(//a[text() = 'Juices'])[2]")).perform();

		// 5) click Tropicana and Real under Brand
		driver.findElementByXPath("(//input[@value = 'Search by Brand'])[1]").sendKeys("Tro");
		driver.findElementByXPath("(//span[text() = 'Tropicana'])[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//input[@value = 'Search by Brand'])[1]").clear();
		driver.findElementByXPath("(//input[@value = 'Search by Brand'])[1]").sendKeys("Rea");
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[text() = 'Real'])[1]").click();
		Thread.sleep(3000);

		// 6) Check count of the products from each Brands and total count
		List<WebElement> brands = driver.findElementsByXPath("//div[@qa= 'product_name']/h6");
		int brands_totcnt = brands.size();
		System.out.println(brands_totcnt);
		int tropcnt = 0;
		int realcnt = 0;
		for (WebElement elebrand : brands) {
			if (elebrand.getText().equalsIgnoreCase("Tropicana")) {
				tropcnt = tropcnt + 1;
			} else if (elebrand.getText().equalsIgnoreCase("Real")) {
				realcnt = realcnt + 1;
			}

		}
		System.out.println(tropcnt + "------" + realcnt);

		// 6) Check whether the products is availabe with Add button.
		int availprds = driver.findElementsByXPath("//button[@qa = 'add']").size();
		System.out.println(availprds + "available");
		Thread.sleep(2000);

		// 7) Add the First listed available product
		driver.findElementByXPath("(//button[@qa = 'add'])[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//a[text() = 'Continue'])[1]").click();
		
		// 8) click on Change Address
		driver.executeScript("window.scrollBy(0,-200)");
		driver.findElementByXPath("//a[@qa='areaDD']/i").click();
		driver.findElementByXPath("(//i[@class = 'caret pull-right'])[1]").click();
		
		// 9) Select CHennai as City, Alandur-600016,Chennai as Area and clickContinue
		driver.findElementByXPath("(//span[text() = 'Chennai'])[3]").click();
		driver.findElementByXPath("(//input[@qa='areaInput'])[1]").sendKeys("Aland");
		driver.findElementByXPath("(//a[@class='ng-binding ng-scope'])[5]").click();
		driver.findElementByXPath("(//button[text() = 'Continue'])[1]").click();
        Thread.sleep(3000);
		
        // 10) Mouse over on My Basket print the product name. count and price.
        builder.moveToElement(driver.findElementByXPath("//a[@qa = 'myBasket']")).perform();
        String prod_name = driver.findElementByXPath("//div[@class = 'product-name']").getText();
        System.out.println(prod_name);
        String qty = driver.findElementByXPath("//button[@qa='decQtyMB']/following-sibling::input").getText();
        System.out.println(qty);
        String price = driver.findElementByXPath("//span[@qa='priceMB']").getText();
        System.out.println(price);
		
		// 11) Click View Basker and Checkout
        driver.findElementByXPath("//button[@qa = 'viewBasketMB']").click();
		
        // 12) Click the close button and close the browser*/
        driver.findElementByXPath("(//button[@class = 'close'])[1]").click();
        driver.quit();

	}

}
