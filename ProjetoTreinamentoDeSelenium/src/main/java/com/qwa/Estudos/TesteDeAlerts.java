package com.qwa.Estudos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteDeAlerts {
	
	@Test
	public void deveInteragirComAlertSimples() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("alert")).click();
		Alert alert = driverChrome.switchTo().alert();
		
		assertEquals("Alert Simples", alert.getText());
		
		alert.dismiss();
		driverChrome.findElement(By.id("elementosForm:nome")).sendKeys("Alert Simples");

		
		driverChrome.quit();
	}
	
	@Test
	public void deveInteragirComAlertConfirmEAceitar() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("confirm")).click();
		
		Alert alertComfirm = driverChrome.switchTo().alert();
		
		assertEquals("Confirm Simples", alertComfirm.getText());
		
		alertComfirm.accept();
		
		assertEquals("Confirmado", alertComfirm.getText());

		alertComfirm.accept();

		driverChrome.quit();
			
	}

	@Test
	public void deveInteragirComAlertConfirmENegar() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("confirm")).click();
		
		Alert alertComfirm = driverChrome.switchTo().alert();
		
		assertEquals("Confirm Simples", alertComfirm.getText());
		
		alertComfirm.dismiss();
		
		assertEquals("Negado", alertComfirm.getText());
		
		alertComfirm.dismiss();

		driverChrome.quit();
			
	}
	
	@Test
	public void deveInteragirComAlertPromptEDarOK() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("prompt")).click();
		
		Alert alertPrompt = driverChrome.switchTo().alert();
		
		assertEquals("Digite um numero", alertPrompt.getText());
		alertPrompt.sendKeys("12");
		alertPrompt.accept();
		assertEquals("Era 12?", alertPrompt.getText());
		alertPrompt.accept();
		assertEquals(":D", alertPrompt.getText());
		alertPrompt.accept();
		driverChrome.quit();
	}
}
