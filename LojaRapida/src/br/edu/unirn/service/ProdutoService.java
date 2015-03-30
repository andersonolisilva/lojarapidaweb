package br.edu.unirn.service;

import java.util.Date;
import java.util.List;

import br.edu.unirn.dao.ProdutoDAO;
import br.edu.unirn.dominio.Produto;
import br.edu.unirn.test.dao.IDAO;

public class ProdutoService {

	private IDAO<Produto> produtoDAO;
	
	public ProdutoService(){}
	
	public ProdutoService(IDAO<Produto> dao){
		this.produtoDAO = dao;
	}
	
	public List<Produto> listTopProdutos(Date dataInicio, Date dataFim){
		return ((ProdutoDAO) produtoDAO).listTopProdutos(dataInicio, dataFim);
	}
	
	public void create(Produto produto){
		produtoDAO.create(produto);
	}
	
	public void update(Produto produto){
		produtoDAO.update(produto);
	}
	
	public void delete(Produto produto){
		produtoDAO.delete(produto);
	}
	
	public Produto findByPrimaryKey(int id){
		return (Produto) produtoDAO.findByPrimaryKey(id);
	}
	
}
