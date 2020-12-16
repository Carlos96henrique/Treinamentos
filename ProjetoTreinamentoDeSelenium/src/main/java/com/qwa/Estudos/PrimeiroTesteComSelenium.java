package com.qwa.Estudos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class PrimeiroTesteComSelenium {
	@Test
	public void deveRetornarOTitulo() {
		WebDriver driver = new FirefoxDriver();
		WebDriver driverChrome = new ChromeDriver();
		
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setPosition(new Point(100, 100));
		driver.get("http://www.google.com");
		driverChrome.get("http://www.google.com");
		
		assertEquals("Google", driverChrome.getTitle());
		assertEquals("Google", driver.getTitle());
		
		driver.quit();
		driverChrome.quit();
		
	}

}
