package br.edu.unirn.service;

import java.util.Date;
import java.util.List;

import br.edu.unirn.dao.ProdutoDAO;
import br.edu.unirn.dominio.Produto;

public class ProdutoService {

	private ProdutoDAO produtoDAO;
	
	public ProdutoService(){}
	
	public ProdutoService(ProdutoDAO dao){
		this.produtoDAO = dao;
	}
	
	public List<Produto> listTopProdutos(Date dataInicio, Date dataFim){
		return produtoDAO.listTopProdutos(dataInicio, dataFim);
	}
}
