package br.edu.unirn.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.unirn.dao.CategoriaDAO;
import br.edu.unirn.dominio.Categoria;

public class CategoriaDAOTest {

	@Test
	public void deveAdicionarCategoria(){
		
		Categoria c = new Categoria();
		
		c.setId(1000);
		c.setDenominacao("Denominacao");
		c.setDescricao("descricao");
		
		CategoriaDAO dao = new CategoriaDAO();
		dao.create(c);
		
		Categoria c1 = dao.findByPrimaryKey(1000);
		
		assertEquals(c.getDenominacao(), c1.getDenominacao());
		
		
	}
}
