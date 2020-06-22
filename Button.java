package com.leafground;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Button {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//img[@alt = 'Buttons']").click();
		driver.findElementById("home").click();
		String homeurl = driver.getCurrentUrl();
		System.out.println(homeurl);
		driver.navigate().to("http://www.leafground.com/pages/Button.html");
		Point position = driver.findElementById("position").getLocation();
		System.out.println(position.getX() + " " + position.getY());
		String color = driver.findElementById("color").getCssValue("color");
		System.out.println(color);
		Dimension size = driver.findElementById("size").getSize();
		System.out.println(size);
		System.out.println(size.getHeight());
		System.out.println(size.getWidth());
	}

}
