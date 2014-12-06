package br.edu.unirn.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovaCategoriaPage {
	
	private WebDriver driver;

	public NovaCategoriaPage(WebDriver driver){
		this.driver = driver;		
	}
	
	public void cadastra(String denominacao, String descricao){
		WebElement txtDenominacao = driver.findElement(By.name("j_idt29:j_idt40:denominacao"));
		WebElement txtDescricao = driver.findElement(By.name("j_idt29:j_idt40:descricao"));
		
		txtDenominacao.sendKeys(denominacao);
		txtDescricao.sendKeys(descricao);
		
		driver.findElement(By.id("j_idt29:j_idt40:withIconSalvar")).click();
		
	}

}
