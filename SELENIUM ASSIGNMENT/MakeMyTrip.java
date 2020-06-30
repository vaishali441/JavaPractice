package Jun29_2020;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MakeMyTrip {
	static WebDriverWait wait;
@Test
	public static void runMakeMyTrip() throws InterruptedException {
			   System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		       ChromeDriver driver = new ChromeDriver();
		       driver.get("https://www.makemytrip.com/");
		       driver.manage().window().maximize();
		       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		       driver.findElementByXPath("//li[@class = 'makeFlex hrtlCenter font10 makeRelative lhUser']").click();
		       driver.findElementByXPath("//span[text() = 'Hotels']").click();
		       driver.findElementByXPath("//input[@id = 'city']").click();
		       driver.findElementByXPath("(//label[@for= 'city']/following-sibling::div[1]//div)[1]//div//input").sendKeys("Goa");
		       driver.findElementByXPath("//p[text() = 'Goa, India']").click();
		       int indate = 13;
		       String inxpath = "(//div[@class = 'DayPicker-Day'])["+ Integer.toString(indate) +"]";
		       driver.findElementByXPath(inxpath).click();
		       int outdate = 4;
		       String outxpath = "(//div[@class = 'DayPicker-Day'])[" +Integer.toString(outdate) +  "]";
		       driver.findElementByXPath(outxpath).click();
		       driver.findElementByXPath("//input[@id = 'guest']").click();
		       driver.findElementByXPath("(//ul[contains(@class, 'guestCounter')])[1]/li[2]").click();
		       driver.findElementByXPath("(//ul[contains(@class, 'guestCounter')])[2]/li[2]").click();
		       Select s = new Select(driver.findElementByClassName("ageSelectBox"));
		       s.selectByVisibleText("12");
		       driver.findElementByXPath("//button[@class = 'primaryBtn btnApply']").click();
		       driver.manage().deleteAllCookies();
		       driver.findElementById("hsw_search_button").click();
		       wait = new WebDriverWait(driver,30);
		       wait.until(ExpectedConditions.visibilityOf(
		    		   driver.findElementByXPath("//a[@class='mapCont']")));
		       driver.findElementByXPath("//a[@class='mapCont']").click();
		       driver.findElementByXPath("//span[@class = 'mapClose']").click();
		       driver.executeScript("window.scrollBy(0,300)");
		       driver.findElementByXPath("(//span[@class = 'checkmarkOuter'])[8]").click();
		       Thread.sleep(3000);
		       driver.executeScript("window.scrollBy(0,300)");
		       driver.findElementByXPath("(//span[@class = 'checkmarkOuter'])[16]").click();
		       driver.findElementByXPath("//span[@class = 'customSelectTitle blueText latoBold']").click();
		       driver.findElementByXPath("//li[text() = 'Price - Low to High']").click();
		       driver.manage().deleteAllCookies();
		       driver.findElementByXPath("(//div[@class = 'makeFlex flexOne padding20 relative'])[1]").click();
		       Set<String> winhans = driver.getWindowHandles();
		       List<String> winhanlist = new LinkedList<String>(winhans);
		       driver.switchTo().window(winhanlist.get(1));
		       String hotelname = driver.findElementByXPath("//h1[@id = 'detpg_hotel_name']").getText();
		       System.out.println(hotelname);
		       driver.findElementByXPath("//a[@class = 'primaryBtn ']").click();
		       driver.findElementByXPath("//span[@class = 'close']").click();
		       String totamt = driver.findElementById("revpg_total_payable_amt").getText();
		       System.out.println(totamt);
		       driver.quit();
		       }
		}


