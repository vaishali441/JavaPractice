package com.leafground;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Edit {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("(//img[@class = 'wp-categories-icon svg-image'])[1]").click();
		driver.findElementByXPath("//input[@id = 'email']").sendKeys("Vaishalikathika@gmail.com");
		driver.findElementByXPath("//input[@value = 'Append ']").sendKeys("Hi");
		String text = driver.findElementByXPath("(//input[@name = 'username'])[1]").getAttribute("value");
		System.out.println(text);
		driver.findElementByXPath("(//input[@name = 'username'])[2]").clear();
		boolean flag = driver.findElementByXPath("//label[contains(@for,'disabled')]/following-sibling::input").isEnabled();
	    System.out.println(flag);	
	}

}
