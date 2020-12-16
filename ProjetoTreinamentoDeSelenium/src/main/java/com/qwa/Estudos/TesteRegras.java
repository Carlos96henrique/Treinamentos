package com.qwa.Estudos;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;





public class TesteRegras {
	WebElement btn;
	WebDriver driverChrome;
	Alert alert;
	
	@Before
	public void setUp() {
		driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@Test
	public void deveDarAlertaCadastroSemNome() {		
		btn = driverChrome.findElement(By.id("elementosForm:cadastrar"));
		
		btn.click();
		
		alert = driverChrome.switchTo().alert();
		
		assertEquals("Nome eh obrigatorio", alert.getText());
		
		alert.accept();
		driverChrome.quit();
		
	}
	
	@Test
	public void deveDarAlertaCadastrarSemSobrenome() {		
		btn = driverChrome.findElement(By.id("elementosForm:cadastrar"));		
		driverChrome.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer!");		
		btn.click();
		
		alert = driverChrome.switchTo().alert();
		
		assertEquals("Sobrenome eh obrigatorio", alert.getText());
		
		alert.accept();
		driverChrome.quit();
	}
	
	@Test
	public void deveDarAlertaSemGenero() {
		btn = driverChrome.findElement(By.id("elementosForm:cadastrar"));
		
		driverChrome.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer!");
		driverChrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome Qualquer!");
		
		btn.click();
		
		alert = driverChrome.switchTo().alert();
		
		assertEquals("Sexo eh obrigatorio", alert.getText());
		
		alert.accept();
		
		driverChrome.quit();
	}
	
	@Test
	public void deveDarAlertaCarneEVegetariano() {
		btn = driverChrome.findElement(By.id("elementosForm:cadastrar"));
		
		driverChrome.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer!");
		driverChrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome Qualquer!");
		driverChrome.findElement(By.id("elementosForm:sexo:1")).click();
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		btn.click();
		
		alert = driverChrome.switchTo().alert();
		
		assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		
		alert.accept();
		
		driverChrome.quit();
		
	}
	
	@Test
	public void deveDarAlertaEsporte() {
		btn = driverChrome.findElement(By.id("elementosForm:cadastrar"));
		
		driverChrome.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer!");
		driverChrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome Qualquer!");
		driverChrome.findElement(By.id("elementosForm:sexo:1")).click();
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		btn.click();
		
		alert = driverChrome.switchTo().alert();
	}
}
