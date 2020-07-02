package Jun29_2020;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Microsoft {
	public void isFileDownloaded(String filename)
	{
		File file = new File("C:\\Users\\Admin\\Downloads");
		File[] dircontent = file.listFiles();
		for(int i = 0; i< dircontent.length;i++)
		{
			//System.out.println(dircontent[i].getName());
			  if(dircontent[i].getName().equals(filename)) 
			  {
			  System.out.println("Downloaded file is present in the local"); 
			  }
		}
	}
	
	@Test
	public void runMicroSoft() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://azure.microsoft.com/en-in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[text() = 'Pricing']").click();
		driver.findElementByXPath("//a[contains(text(),'Pricing calculator')]").click();
		driver.findElementByXPath("//button[@value = 'containers']").click();
		driver.findElementByXPath("(//button[@title='Container Instances'])[2]").click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//button[text() = 'View']"))).click();
		Select s = new Select(driver.findElementByName("region"));
		s.selectByValue("south-india");
		WebElement eleseconds = driver.findElementByXPath("//input[@name = 'seconds']");
		eleseconds.clear();
		eleseconds.sendKeys(Keys.ARROW_RIGHT,"80000");
		Select s1 = new Select(driver.findElementByName("memory"));
		s1.selectByValue("4");
		driver.findElementByName("devTestSelected").click();
		Select s2 = new Select(driver.findElementByXPath("//select[@class = 'select currency-dropdown']"));
		s2.selectByValue("INR");
		String monthlyprz = driver.findElementByXPath("(//div[@class = 'column large-3 text-right total']/div[2]//span)[2]").getText();
		System.out.println("Monthy estimate " + monthlyprz);
		driver.findElementByXPath("//button[contains(@class , 'export')]").click();
		Thread.sleep(3000);
		String file_name = "ExportedEstimate.xlsx";
		isFileDownloaded(file_name);
		driver.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		driver.findElementByXPath("//a[text() = 'Example Scenarios']").click();
		driver.findElementByXPath("//button[@title = 'CI/CD for Containers']").click();
		driver.findElementByXPath("//button[text() = 'Add to estimate']").click();
		Thread.sleep(10000);
		Select s3 = new Select(driver.findElementByXPath("//select[@class = 'select currency-dropdown']"));
		s3.selectByValue("INR");
		driver.findElementByName("devTestSelected").click();
		driver.findElementByXPath("//button[contains(@class , 'export-button')]").click();
		Thread.sleep(3000);
		String file_name1 = "ExportedEstimate (1).xlsx";
		isFileDownloaded(file_name1);
	}

}
