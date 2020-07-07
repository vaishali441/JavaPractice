package Jun29_2020;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Zalando {
	
	@Test
	public void runZalando() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://www.zalando.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String alert_text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		System.out.println(alert_text);
		driver.findElementByXPath("//a[@class = 'nav_link nav_link-gb']").click();
		Thread.sleep(8000);
		driver.findElementByXPath("//button[@class = 'uc-btn uc-btn-primary']").click();
		driver.findElementByXPath("(//span[text() = 'Women'])[2]").click();
		Thread.sleep(2000);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//span[text() = 'Clothing']")).perform();
		builder.click(driver.findElementByXPath("//span[text() = 'Coats']")).perform();
		Thread.sleep(1000);
		driver.findElementByXPath("(//span[@class = 'cat_headLabel-2ZnvX'])[6]").click();
		driver.findElementByXPath("//span[text() = 'cotton (100%)']").click();
		driver.findElementByXPath("//button[text() = 'Save']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[@class='cat_headLabel-2ZnvX'])[9]").click();
		driver.findElementByXPath("//span[text() = 'thigh-length']").click();
		driver.findElementByXPath("//button[text() = 'Save']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[text()='Vero Moda'])[3]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//img[@alt='beige'])[2]").click();
		driver.findElementByXPath("//button[@aria-label='Choose your size']").click();
		driver.findElementByXPath("//span[text() = 'M']").click();
		String freedlyvry = driver.findElementByXPath("(//button[@aria-label='Free'])[1]").getText();
		if(freedlyvry.equalsIgnoreCase("Free"))
		{
			driver.findElementByXPath("//span[text() = 'Add to bag']").click();
		}
		Thread.sleep(1000);
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(driver.findElementByXPath("(//a[contains(@class , 'navToolItemLink')])[3]")).perform();
		builder1.click(driver.findElementByXPath("//div[text() = 'Go to bag']")).perform();
		Thread.sleep(4000);
		String dlyvrydt= driver.findElementByXPath("//div[@data-id = 'delivery-estimation']/span").getText();
		System.out.println(dlyvrydt);
		driver.findElementByXPath("//div[text() = 'Go to checkout']").click();
		Thread.sleep(3000);
		driver.findElementById("login.email").sendKeys("vaishalibaskar0909@gmail.com");
		driver.findElementByXPath("//span[text() = 'Login']").click();
		String errmsg = driver.findElementByXPath("//span[text() = 'error']/following-sibling::span").getText();
		System.out.println(errmsg);
		
	}

}
