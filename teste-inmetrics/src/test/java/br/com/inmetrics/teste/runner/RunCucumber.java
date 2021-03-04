package br.com.inmetrics.teste.runner;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class RunCucumber {

	private static WebDriver driver;
	
	@Given("que eu preenchi os campos usuario, senha e confirmar senha") 
	public void acessarTelaCadastrarNovoUsuario() {
		WebElement link_cadastrar = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[1]/a")); 
		link_cadastrar.click();
		WebElement campo_usuario = driver.findElement(By.name("username"));
		WebElement campo_senha = driver.findElement(By.name("pass"));
		WebElement campo_confirmar = driver.findElement(By.name("confirmpass"));
		campo_usuario.sendKeys("NewUser_01");
		campo_senha.sendKeys("Admin@123");
		campo_confirmar.sendKeys("Admin@123");
	}
	
	@When("clico no botão cadastrar")
	public void confirmarCadastroNovoUsuario() {
		WebElement cadastrar = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[7]/button"));
		cadastrar.click();
	}
	
	@Then("o usuario é cadastrado com sucesso")
	public void usuarioCriadoComSucesso() {
		assertEquals("https://inm-test-app.herokuapp.com/accounts/login/",driver.getCurrentUrl());
		driver.quit();
	}
	
	@Given("que eu preencho todos os dados do funcionario")
	public void acessarTelaNovoFuncionario(){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://inm-test-app.herokuapp.com/accounts/login/");
		WebElement campo_usuario = driver.findElement(By.name("username"));
		WebElement campo_senha = driver.findElement(By.name("pass"));
		WebElement entrar = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[6]/button"));
		campo_usuario.sendKeys("novo_usuario_01");
		campo_senha.sendKeys("Admin@123");
		entrar.click();
		WebElement novoFuncionario = driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[2]/a"));
		novoFuncionario.click();
		WebElement campo_nome = driver.findElement(By.id("inputNome"));
		WebElement campo_cargo = driver.findElement(By.name("cargo"));
		WebElement campo_cpf = driver.findElement(By.name("cpf"));
		WebElement campo_salario = driver.findElement(By.name("salario"));
		WebElement campo_sexo = driver.findElement(By.name("sexo"));
		WebElement campo_tipoContratacaoPJ = driver.findElement(By.id("pj"));
		WebElement campo_admissao = driver.findElement(By.name("admissao"));
		campo_nome.sendKeys("A_Funcionario_01");
		campo_cargo.sendKeys("Analista de testes");
		campo_cpf.sendKeys("215.602.960-11");
		campo_salario.sendKeys("4000,00");
		campo_sexo.sendKeys("Masculino");
		campo_tipoContratacaoPJ.click();
		campo_admissao.sendKeys("15/03/2021");	
	}
	
	@When("clico no botão enviar")
	public void salvarNovoFuncionario(){
		WebElement botao_cadastrar = driver.findElement(By.className("cadastrar-form-btn"));
		botao_cadastrar.click();
	}
	
	@Then("o funcionario é cadastrado com sucesso")
	public void FuncionarioAdicionado(){
		WebElement nome = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[1]"));
		assertEquals("A_Funcionario_01",nome.getText());
		driver.quit();
	}

	@Given("que eu altero os dados do funcionario")
	public void acessarEditarFuncionario() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://inm-test-app.herokuapp.com/accounts/login/");
		WebElement campo_usuario = driver.findElement(By.name("username"));
		WebElement campo_senha = driver.findElement(By.name("pass"));
		WebElement entrar = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[6]/button"));
		campo_usuario.sendKeys("novo_usuario_01");
		campo_senha.sendKeys("Admin@123");
		entrar.click();
		WebElement editarFuncionario = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/a[2]/button/span"));
		editarFuncionario.click();
		WebElement campo_nome = driver.findElement(By.id("inputNome"));
		WebElement campo_cargo = driver.findElement(By.name("cargo"));
		campo_nome.sendKeys("_editado");
		campo_cargo.sendKeys("_editado");
	}
	
	@When("eu aperto o botão enviar")
	public void alterarCampos(){
		WebElement botao_cadastrar = driver.findElement(By.className("cadastrar-form-btn"));
		botao_cadastrar.click();		
	} 
	
	@Then("o funcionario é editado com sucesso")
	public void funcionarioEditado(){
		WebElement editado_nome = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[1]"));
		WebElement editado_cargo = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[4]"));
		assertEquals("A_Funcionario_01_editado",editado_nome.getText());
		assertEquals("Analista de testes_editado",editado_cargo.getText());
		driver.quit();
	}
	
	@Given("que eu acesso a tela de listagem de funcionários")
	public void acessarListagemFuncionarios(){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://inm-test-app.herokuapp.com/accounts/login/");
		WebElement campo_usuario = driver.findElement(By.name("username"));
		WebElement campo_senha = driver.findElement(By.name("pass"));
		WebElement entrar = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form/div[6]/button"));
		campo_usuario.sendKeys("novo_usuario_01");
		campo_senha.sendKeys("Admin@123");
		entrar.click();
		WebElement listagem = driver.findElement(By.id("/html/body/nav/div/div/ul/li[1]/a"));
		listagem.click();
	}
	
	@When("clico no botão excluir")
	public void selecionarFuncionarioExcluir(){
		WebElement deletar = driver.findElement(By.id("delete-btn"));
		deletar.click();
	}
		
	@Then("o funcionario é excluido com sucesso")
	public void funcionarioExcluido() {
		WebElement primeiro = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[1]"));
		assertNotEquals("A_Funcionario_01_editado",primeiro.getText());
		driver.quit();
	}

}