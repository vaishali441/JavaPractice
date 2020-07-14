package Jun29_2020;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SuperCalc {

@Test
public void runSuperCalc()
{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://juliemr.github.io/protractor-demo/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String inp1 = "4";
	String inp2 = "5";
	int result = Integer.parseInt(inp1) *Integer.parseInt(inp2);
	driver.findElementByXPath("//input[@ng-model='first']").sendKeys(inp1);
	Select s = new Select(driver.findElementByXPath("//select[@ng-model='operator']"));
	s.selectByValue("MULTIPLICATION");
	driver.findElementByXPath("//input[@ng-model='second']").sendKeys(inp2);
	driver.findElementById("gobutton").click();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.textToBePresentInElement
			(driver.findElementByXPath("//h2[@class = 'ng-binding']"),Integer.toString(result)));
	String res = driver.findElementByXPath("//h2[@class = 'ng-binding']").getText();
	System.out.println(res);
	
}
}
