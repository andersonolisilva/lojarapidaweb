import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.unirn.dominio.Produto;
import br.edu.unirn.service.ProdutoService;
import br.edu.unirn.test.builder.CriadorDeProduto;
import br.edu.unirn.test.dao.ProdutoDAOFalso;


public class ProdutoTest {
	
	@Test
	public void gravacaoDeNovoProduto(){
		
		List<Produto> produtos = new ArrayList<Produto>();
		Produto produto = new CriadorDeProduto().para(1, "PenDrive 32Gb", "Pendrive King", 32.5, 100).controi();
		produtos.add(produto);
		
		ProdutoDAOFalso daoFalso = mock(ProdutoDAOFalso.class);
		
		when(daoFalso.findAll()).thenReturn(produtos);
		
		ProdutoService service = new ProdutoService(daoFalso);
		service.create(produto);
		
		Produto produtoPesquisado = service.findByPrimaryKey(1);
		
		assertEquals("PenDrive 32Gb", produtoPesquisado.getDescricao());
		
		assertEquals(1, daoFalso.getProdutos().size());
		
	}


	@Test
	public void atualizacaoDeProduto(){
		
		Produto produto = new CriadorDeProduto().para(1, "PenDrive 32Gb", "Pendrive King", 32.5, 100).controi();
		
		ProdutoDAOFalso daoFalso = mock(ProdutoDAOFalso.class);
		
		when(daoFalso.findByPrimaryKey(1)).thenReturn(produto);
		
		ProdutoService service = new ProdutoService(daoFalso);
		service.create(produto);
		Produto produtoPesquisado = service.findByPrimaryKey(1);
		
		assertEquals("Pendrive King", produtoPesquisado.getDenominacao());
		
		produtoPesquisado.setDenominacao("Denominacao alterada");
		service.update(produtoPesquisado);
		
		Produto produtoAtualizado = service.findByPrimaryKey(1);
		
		assertEquals("Denominacao alterada", produtoAtualizado.getDenominacao());

	}

	@Test
	public void remocaoProduto(){
		
		Produto produto = new CriadorDeProduto().para(1, "PenDrive 32Gb", "Pendrive King", 32.5, 100).controi();
		
		ProdutoDAOFalso daoFalso = mock(ProdutoDAOFalso.class);
		
		when(daoFalso.findByPrimaryKey(1)).thenReturn(produto);
		
		ProdutoService service = new ProdutoService(daoFalso);
		service.create(produto);
		Produto produtoPesquisado = service.findByPrimaryKey(1);
		
		assertEquals("Pendrive King", produtoPesquisado.getDenominacao());
		
		service.delete(produtoPesquisado);
		
		Produto produtoRemovido = service.findByPrimaryKey(1);
		
		assertNull(produtoRemovido);

	}

}
