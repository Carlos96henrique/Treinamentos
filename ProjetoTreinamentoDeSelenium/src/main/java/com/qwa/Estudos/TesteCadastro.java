package com.qwa.Estudos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	@Test
	public void deveCadastrarComSucesso() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement comboEscolaridade = driverChrome.findElement(By.id("elementosForm:escolaridade"));
		WebElement comboEsportes = driverChrome.findElement(By.id("elementosForm:esportes"));
		WebElement btn = driverChrome.findElement(By.id("buttonSimple"));
		WebElement btnCadastrar = driverChrome.findElement(By.id("elementosForm:cadastrar"));
		
		
		Select elementosCombo = new Select(comboEscolaridade);
		Select elementosCombo2 = new Select(comboEsportes);
		
		elementosCombo2.selectByIndex(0);
		elementosCombo2.selectByIndex(1);
		elementosCombo2.selectByIndex(2);
		
		btn.click();
		driverChrome.findElement(By.id("elementosForm:sexo:1")).click();
		driverChrome.findElement(By.id("elementosForm:nome")).sendKeys("Teste Parallax");
		driverChrome.findElement(By.id("elementosForm:sobrenome")).sendKeys("Parallax!");
		driverChrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("Para executar este teste foi necessario:\n "
				+ "Instalar a lib do selenium\n instalar os drivers dos navegadores.");
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		elementosCombo.selectByValue("doutorado");
		List<WebElement> options = elementosCombo.getOptions();
		List<WebElement> allSelectedOptoins = elementosCombo2.getAllSelectedOptions();
		
		btnCadastrar.click();
		
		
		
		assertEquals(8, options.size());
		assertEquals(3, allSelectedOptoins.size());
		assertTrue(driverChrome.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		assertEquals("Nome: Teste Parallax", driverChrome.findElement(By.id("descNome")).getText());
		assertEquals("Sobrenome: Parallax!", driverChrome.findElement(By.id("descSobrenome")).getText());
		assertEquals("Sexo: Feminino", driverChrome.findElement(By.id("descSexo")).getText());
		assertEquals("Comida: Carne", driverChrome.findElement(By.id("descComida")).getText());
		assertEquals("Escolaridade: doutorado", driverChrome.findElement(By.id("descEscolaridade")).getText());
		assertEquals("Esportes: Natacao Futebol Corrida", driverChrome.findElement(By.id("descEsportes")).getText());
		
		driverChrome.quit();

	}

}
