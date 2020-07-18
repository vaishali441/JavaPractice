package Jun29_2020;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTestMozilHP {
	static WebDriverWait wait ;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", ".\\\\drivers\\\\geckodriver_64 bit.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://store.hp.com/in-en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		Thread.sleep(6000);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title = 'Accept Cookies']")))).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@class = 'inside_closeButton fonticon icon-hclose']")).click();
		Actions  builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("(//span[text() = 'Laptops'])[1]"))).perform();
		builder.click(driver.findElement(By.xpath("(//span[text() = 'Pavilion'])[1]"))).perform();
		Thread.sleep(20000);
		driver.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text() = 'Processor'])[1]")).click();
		driver.findElement(By.xpath("(//span[text() = 'Processor'])[2]")).click();
		driver.findElement(By.xpath("//span[text() = 'Intel Core i5']")).click();
		Thread.sleep(3000);
		driver.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.xpath("//span[text() = 'Hard Drive Capacity']")).click();
		driver.findElement(By.xpath("//span[text() = '500 GB to 1 TB']")).click();
		Thread.sleep(6000);
		driver.executeScript("window.scrollBy(0,100)");
		WebElement stock = driver.findElement(By.xpath("//span[text() = 'In Stock']"));
		String prodstock = null;
		String price = null;
		if(stock.isDisplayed())
		{
			prodstock = driver.findElement(By.xpath("//strong[@class = 'product name product-item-name']")).getText();
			price = driver.findElement(By.xpath("(//span[@class = 'price'])[2]")).getText();
		}
		System.out.println(prodstock + "----------" +price );
		driver.findElementByXPath("//span[text() = 'Add To Cart']").click();
		Thread.sleep(7000);
		driver.findElementByXPath("//a[@class = 'action showcart']").click();
		driver.findElementByXPath("//span[text() = 'View and edit cart']").click();
		Thread.sleep(5000);
		driver.findElementByName("pincode").sendKeys("600064");
		Thread.sleep(1000);
		driver.findElementByXPath("//button[@class = 'primary standard_delivery-button']").click();
		String ordtot = driver.findElementByXPath("(//td[@class = 'amount'])[3]//span").getText();
		System.out.println(ordtot);
		if(price.equals(ordtot))
		{
			System.out.println("Order total against product price is verified");
			Thread.sleep(6000);
			driver.findElementByXPath("(//button[@id = 'sendIsCAC'])[1]").click();
		}
		Thread.sleep(10000);
		driver.executeScript("window.scrollBy(0,300)");
		driver.findElementByXPath("(//span[text() = 'Place Order'])[4]").click();
		Thread.sleep(6000);
		String email = driver.findElementByXPath("//input[@id = 'customer-email']").getAttribute("name");
		String err1 = 	driver.findElementByXPath("//input[@id = 'customer-email']/following-sibling::div[1]").getText();
		System.out.println(email + "-----------------"+ err1);
		String fname = driver.findElementByXPath("(//input[@name='firstname'])[1]").getAttribute("name");
		String err2 = driver.findElementByXPath("(//input[@name='firstname'])[1]/following-sibling::div[1]").getText();
		System.out.println(fname + "-----------------"+ err2);
		String lname = driver.findElementByXPath("(//input[@name= 'lastname'])[1]").getAttribute("name");
		String err3 = driver.findElementByXPath("(//input[@name= 'lastname'])[1]/following-sibling::div[1]").getText();
		System.out.println(lname + "-----------------"+ err3);
		String phone = driver.findElementByXPath("(//input[@name='telephone'])[1]").getAttribute("name");
		String err4 = driver.findElementByXPath("(//input[@name='telephone'])[1]/following-sibling::div[2]").getText();
		System.out.println(phone + "-----------------"+ err4);
		String addr = driver.findElementByXPath("(//input[@name='street[0]'])[1]").getAttribute("name");
		String err5 = driver.findElementByXPath("(//input[@name='street[0]'])[1]/following-sibling::div[1]").getText();
		System.out.println(addr + "-----------------"+ err5);
		
		
		
		
		
	}
	

}
