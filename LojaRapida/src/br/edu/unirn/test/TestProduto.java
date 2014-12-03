package br.edu.unirn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.unirn.dao.ProdutoDAO;
import br.edu.unirn.dominio.Produto;

public class TestProduto {

	@Test
	public void testGetProduto(){
		Produto produto = new Produto();
		produto.setDenominacao("Teste");
		assertEquals("Teste", produto.getDenominacao());
	}
	
	@Test
	public void testGetProdutoById(){
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.findByPrimaryKey(7);
		
		assertEquals("7", produto.getId());
	}

}
