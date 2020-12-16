package com.qwa.Estudos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteDeCampos {
	
	@Test
	public void deveAcessarCaminho() {
		WebDriver driver = new FirefoxDriver();
		WebDriver driverChrome = new ChromeDriver();
		
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driver.manage().window().setPosition(new Point(100, 100));
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.quit();
		driverChrome.quit();
	}
	
	@Test
	public void deveAcessarTextArea() {
		WebDriver driverChrome = new ChromeDriver();
		
		driverChrome.manage().window().setPosition(new Point(100, 100));

		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		driverChrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("Para executar este teste foi necessario:\n "
				+ "Instalar a lib do selenium\n instalar os drivers dos navegadores.");
		
		assertEquals("Para executar este teste foi necessario:\n "
				+ "Instalar a lib do selenium\n instalar os drivers dos navegadores.", driverChrome.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		driverChrome.quit();
		
		
	}
	
	@Test
	public void deveAcessarTesxtField() {
		WebDriver driverChrome = new ChromeDriver();
		
		driverChrome.manage().window().setPosition(new Point(100, 100));

		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("elementosForm:nome")).sendKeys("Teste Parallax");
		
		assertEquals("Teste Parallax", driverChrome.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driverChrome.quit();
		

	}
	
	@Test
	public void deveInteragirComRadioButtom() {
		WebDriver driverChrome = new ChromeDriver();
		
		driverChrome.manage().window().setPosition(new Point(100, 100));

		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("elementosForm:sexo:1")).click();
		
		
		assertTrue(driverChrome.findElement(By.id("elementosForm:sexo:1")).isSelected());
		
		driverChrome.quit();
	}
	
	@Test
	public void deveInteragirComCheckbox() {
		WebDriver driverChrome = new ChromeDriver();
		
		driverChrome.manage().window().setPosition(new Point(100, 100));

		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		
		assertTrue(driverChrome.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		
		driverChrome.quit();
	}
	
	@Test
	public void deveInteragirComTodosElementosDoChebox() {
		WebDriver driverChrome = new ChromeDriver();
		
		driverChrome.manage().window().setPosition(new Point(100, 100));

		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		driverChrome.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		
		assertTrue(driverChrome.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		assertTrue(driverChrome.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
		assertTrue(driverChrome.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		assertTrue(driverChrome.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());
		
		driverChrome.quit();
	}
	
	@Test
	public void deveInteragirComComboBox() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement Combo = driverChrome.findElement(By.id("elementosForm:escolaridade"));
		
		Select elementosCombo = new Select(Combo);
		
		
//		elementosCombo.selectByIndex(4);
		elementosCombo.selectByValue("doutorado");
//		elementosCombo.selectByVisibleText("Especializacao");
		
		assertEquals("Doutorado", elementosCombo.getFirstSelectedOption().getText());
		
		driverChrome.quit();
	}
	
	@Test
	public void deveVerificarValoresDoCombo() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement Combo = driverChrome.findElement(By.id("elementosForm:escolaridade"));
		
		Select elementosCombo = new Select(Combo);
		
		List<WebElement> options = elementosCombo.getOptions();
		assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		
		assertTrue(encontrou);
		
		driverChrome.quit();
	}
	
	@Test
	public void deveVerificarValoresDoComboDeMultplaEscolha() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement Combo = driverChrome.findElement(By.id("elementosForm:esportes"));
		
		Select elementosCombo = new Select(Combo);
		
		elementosCombo.selectByIndex(0);
		elementosCombo.selectByIndex(1);
		elementosCombo.selectByIndex(2);
		
		
		
		List<WebElement> allSelectedOptoins = elementosCombo.getAllSelectedOptions();
		
		assertEquals(3, allSelectedOptoins.size());
		
		driverChrome.quit();
		
	}
	
	@Test
	public void deveTestarSelecaoEDeselecaoDoCombo() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement Combo = driverChrome.findElement(By.id("elementosForm:esportes"));
		
		Select elementosCombo = new Select(Combo);
		
		elementosCombo.selectByIndex(0);
		elementosCombo.selectByIndex(1);
		elementosCombo.selectByIndex(2);

		List<WebElement> allSelectedOptoins = elementosCombo.getAllSelectedOptions();
		
		assertEquals(3, allSelectedOptoins.size());
		
		elementosCombo.deselectAll();
		allSelectedOptoins = elementosCombo.getAllSelectedOptions();
		assertEquals(0, allSelectedOptoins.size());
		
		driverChrome.quit();
		
	}

	@Test
	public void deveInteragirComBotoes() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement btn = driverChrome.findElement(By.id("buttonSimple"));
		
		btn.click();
		
		assertEquals("Obrigado!", btn.getAttribute("value"));
		
		driverChrome.quit();
	}
	
	
	@Test
	public void deveInteragirComLink() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driverChrome.findElement(By.linkText("Voltar")).click();	
		assertEquals("Voltou!", driverChrome.findElement(By.id("resultado")).getText());
		
		driverChrome.quit();
	}
	
	@Test
	public void deveBuscarTextos() {
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().setPosition(new Point(100, 100));
		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		assertEquals("Campo de Treinamento", driverChrome.findElement(By.tagName("h3")).getText());
		assertEquals("Cuidado onde clica, muitas armadilhas...", driverChrome.findElement(By.className("facilAchar")).getText());
		
		driverChrome.quit();
	}
	
	@Test
	public void devePreencherTodoOFormulario() {
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
		assertEquals("Obrigado!", btn.getAttribute("value"));
		assertTrue(driverChrome.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		assertEquals("Para executar este teste foi necessario:\n "
				+ "Instalar a lib do selenium\n instalar os drivers dos navegadores.", driverChrome
			.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		assertEquals("Teste Parallax", driverChrome.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		assertEquals("Parallax!", driverChrome.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
		assertEquals("Doutorado", elementosCombo.getFirstSelectedOption().getText());
		assertTrue(driverChrome.findElement(By.id("elementosForm:sexo:1")).isSelected());
				
//		driverChrome.quit();
	}
}
