package br.com.inmetrics.teste.runner;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunJUnit {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpTest(){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://inm-test-app.herokuapp.com/accounts/login/");
		WebElement campo_usuario = driver.findElement(By.name("username"));
		WebElement campo_senha = driver.findElement(By.name("pass"));
		WebElement entrar = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[6]/button"));
		campo_usuario.sendKeys("novo_usuario_01");
		campo_senha.sendKeys("Admin@123");
		entrar.click();
	}

	@AfterClass
	public static void tearDownTest(){
		driver.quit();
	}

	@Test
	public void add_usuario() {
		WebElement link_cadastrar = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[1]/a")); 
		link_cadastrar.click();
		WebElement campo_usuario = driver.findElement(By.name("username"));
		WebElement campo_senha = driver.findElement(By.name("pass"));
		WebElement campo_confirmar = driver.findElement(By.name("confirmpass"));
		WebElement cadastrar = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[7]/button"));
		campo_usuario.sendKeys("novo_usuario_05");
		campo_senha.sendKeys("Admin@123");
		campo_confirmar.sendKeys("Admin@123");
		cadastrar.click();
		assertEquals("https://inm-test-app.herokuapp.com/accounts/login/",driver.getCurrentUrl());
	}
	
	@Test
	public void cadastrarFuncionario(){
		WebElement novoFuncionario = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[2]/a"));
		novoFuncionario.click();
		WebElement campo_nome = driver.findElement(By.id("inputNome"));
		WebElement campo_cargo = driver.findElement(By.name("cargo"));
		WebElement campo_cpf = driver.findElement(By.name("cpf"));
		WebElement campo_salario = driver.findElement(By.name("salario"));
		WebElement campo_sexo = driver.findElement(By.name("sexo"));
		WebElement campo_tipoContratacaoPJ = driver.findElement(By.id("pj"));
		//WebElement campo_tipoContratacaoCLT = driver.findElement(By.id("clt"));
		WebElement campo_admissao = driver.findElement(By.name("admissao"));
		campo_nome.sendKeys("A_Funcionario_01");
		campo_cargo.sendKeys("Analista de testes");
		campo_cpf.sendKeys("215.602.960-11");
		campo_salario.sendKeys("4000,00");
		campo_sexo.sendKeys("Masculino");
		campo_tipoContratacaoPJ.click();
		campo_admissao.sendKeys("15/03/2021");	
		WebElement botao_cadastrar = driver.findElement(By.className("cadastrar-form-btn"));
		botao_cadastrar.click();
		WebElement nome = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[1]"));
		assertEquals("A_Funcionario_01",nome.getText());
	}
	
	@Test
	public void editarFuncionario(){
		WebElement editarFuncionario = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/a[2]/button/span"));
		editarFuncionario.click();
		WebElement campo_nome = driver.findElement(By.id("inputNome"));
		WebElement campo_cargo = driver.findElement(By.name("cargo"));
		campo_nome.sendKeys("_editado");
		campo_cargo.sendKeys("_editado");
		WebElement botao_cadastrar = driver.findElement(By.className("cadastrar-form-btn"));
		botao_cadastrar.click();
		WebElement editado_nome = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[1]"));
		WebElement editado_cargo = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[4]"));
		assertEquals("A_Funcionario_01_editado",editado_nome.getText());
		assertEquals("Analista de testes_editado",editado_cargo.getText());
	}
	
	@Test
	public void excluirFuncionario(){
		WebElement deletar = driver.findElement(By.id("delete-btn"));
		deletar.click();
		WebElement primeiro = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[1]"));
		assertNotEquals("A_Funcionario_01_editado",primeiro.getText());
	}

}