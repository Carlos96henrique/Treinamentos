package com.qwa.Estudos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteFrames {
	
	@Test
	public void deveInteragirComFrames() {
		WebDriver driver = new ChromeDriver();
		/**
		 * Neste exemplo eu usei o setSize e o Dimension no lugar de setPosition e Point
		 * e é necessário lembrar que se o elemento do DOM não estiver visivel na dimensão o teste não vai funcionar
		 */
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		
		Alert alertFrame = driver.switchTo().alert();
		
		String msg = alertFrame.getText();
		
		assertEquals("Frame OK!", msg);
		
		alertFrame.accept();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

		driver.quit();
	}
}
