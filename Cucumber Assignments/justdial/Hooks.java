
  package steps;
  
  import java.util.concurrent.TimeUnit;
  
  import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
  import cucumber.api.java.Before;
  
  public class Hooks extends BaseClass {
  
  @Before 
  public void preCondition() {
  ChromeOptions options = new ChromeOptions();
  options.addArguments("--disable-notifications");
  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
  driver = new ChromeDriver(options);
  driver.get("https://www.justdial.com/");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
  }
  
  
  @After 
  public void postCondition()
  { 
	  driver.quit();
  
  }
  
  }
 