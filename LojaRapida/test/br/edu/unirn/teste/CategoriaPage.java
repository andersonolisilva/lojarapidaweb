package br.edu.unirn.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriaPage {

	private WebDriver driver;

	public CategoriaPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		this.driver
				.get("http://localhost:8080/LojaRapida/faces/admin/categoria.xhtml");
	}

	public NovaCategoriaPage novo() {
		driver.findElement(By.linkText("Cadastro")).click();
		return new NovaCategoriaPage(driver);
	}

	public boolean existeNaListagem(String denominacao, String descricao) {
		
		Boolean temDenominacao =  new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(By.id("j_idt29:j_idt31:tableCategoria"), denominacao));
		
		if(temDenominacao) return driver.getPageSource().contains(descricao);
		
		return false;
		/*return driver.getPageSource().contains(denominacao) &&
				driver.getPageSource().contains(descricao);*/
	}

	public boolean mensagemCampoDenominacaoObrigatorio() {
		return driver.getPageSource().contains(
				"Campo denominação é obrigatório");
	}

	public void remove() {
		driver.findElement(By.id("j_idt29:j_idt31:tableCategoria:0:j_idt38"))
				.click();
		driver.findElement(By.id("j_idt13")).click();
	}

}
