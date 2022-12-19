package br.com.cotiinformatica;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class CadastrarClienteStepDefinitions {

	WebDriver driver;
	
	@Given("Acessar a página de cadastro de cliente")
	public void acessar_a_pagina_de_cadastro_de_cliente() {

		System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://testesoftware-001-site1.atempurl.com/exercicios/tarefa04");
	}

	@Given("Informar o nome do cliente")
	public void informar_o_nome_do_cliente() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Nome\"]"));
		element.clear();
		element.sendKeys("Sergio Mendes");
	}

	@Given("Informar o telefone")
	public void informar_o_telefone() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Telefone\"]"));
		element.clear();
		element.sendKeys("(21) 96957-5900");
	}

	@Given("Informar a data de nascimento")
	public void informar_a_data_de_nascimento() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"DataNascimento\"]"));
		element.clear();
		element.sendKeys("1981-05-10");
	}

	@Given("Selecionar o tipo de plano")
	public void selecionar_o_tipo_de_plano() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"TipoPlano\"]"));
		Select select = new Select(element);
		select.selectByVisibleText("Plano Empresa");
	}

	@Given("Informar as observações")
	public void informar_as_observacoes() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Observacoes\"]"));
		element.clear();
		element.sendKeys("Cliente cadastrado em teste.");		
	}

	@When("Solicitar a realização do cadastro")
	public void solicitar_a_realizacao_do_cadastro() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]"));
		element.click();
	}

	@Then("Sistema informa que o cliente foi cadastrado com sucesso")
	public void sistema_informa_que_o_cliente_foi_cadastrado_com_sucesso() {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"mensagem\"]"));
		assertEquals("Cliente cadastrado com sucesso.", element.getText());
		
		try {
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Cadastrar cliente com sucesso.png"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
	}
}
