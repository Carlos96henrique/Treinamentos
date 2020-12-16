package com.qwa.Estudos;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteDeJanelas {
	
	@Test
	public void deveInteragirComJanelaComTitulo() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("buttonPopUpEasy")).click();	
		driverChrome.switchTo().window("Popup");		
		driverChrome.findElement(By.tagName("textarea")).sendKeys("Foi aberto uma nova janela!");		
		driverChrome.close();		
		driverChrome.switchTo().window("");		
		driverChrome.findElement(By.tagName("textarea")).sendKeys("Agora a nova janela foi fechada!");		
		driverChrome.quit();

	}
	
	@Test
	public void deveInteragirComJanelaSemTitulo() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("buttonPopUpHard")).click();
		
		driverChrome.switchTo().window((String)driverChrome.getWindowHandles().toArray()[1]);
		
		driverChrome.findElement(By.tagName("textarea")).sendKeys("Foi aberto uma nova janela!");
		
//		driverChrome.close();
		
		driverChrome.switchTo().window((String)driverChrome.getWindowHandles().toArray()[0]);
		
		driverChrome.findElement(By.tagName("textarea")).sendKeys("De volta a Janela principal!");
		
		driverChrome.quit();
		
	}
	
}
