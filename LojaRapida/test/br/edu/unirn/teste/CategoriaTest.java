package br.edu.unirn.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CategoriaTest {

	private WebDriver driver;
	private CategoriaPage categorias;
	
	public CategoriaTest(){
		this.driver = new FirefoxDriver();
		categorias = new CategoriaPage(driver);
	}
	
	@Test
	public void deveAdicionarProduto(){
	
		categorias.visita();
		categorias.novo().cadastra("Pendrive", "Pen de 4gb");
		assertTrue(categorias.existeNaListagem("Pendrive", "Pen de 4gb"));
		categorias.remove();
		
	}

	@Test
	public void naoDeveAdicionarSemDenominacao(){
		categorias.visita();
		categorias.novo().cadastra("", "Xuxu");
		assertTrue(categorias.mensagemCampoDenominacaoObrigatorio());
	}
	
	@Test
	public void deveRemoverCategoria() {
		
		categorias.visita();
		categorias.novo().cadastra("Notebook", "Acer");
		categorias.remove();
		assertFalse(categorias.existeNaListagem("Notebook", "Acer"));
		
	}
	
	@After
	public void finaliza(){
		driver.close();
	}
	
}
