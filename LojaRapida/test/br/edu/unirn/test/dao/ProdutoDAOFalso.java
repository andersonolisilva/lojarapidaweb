package br.edu.unirn.test.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.unirn.dao.GenericDAO;
import br.edu.unirn.dominio.Produto;

public class ProdutoDAOFalso extends GenericDAO<Produto> implements IDAO<Produto>{

	private List<Produto> produtos = new ArrayList<Produto>();

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	@Override
	public Class<Produto> getClassType() {
		return Produto.class;
	}

	@Override
	public void create(Produto t) {
		produtos.add(t);
	}

	@Override
	public void update(Produto c) {
		produtos.remove(c);
		produtos.add(c);
	}

	@Override
	public void delete(Produto c) {
		produtos.remove(c);
	}
	
	@Override
	public List<Produto> findAll(){
		return produtos;
	}
	
	@Override
	public Produto findByPrimaryKey(int id){
		Produto retorno = null;
		for(Produto produto : produtos){
			if(produto.getId()==id){
				retorno = produto;
			}
		}
		return retorno;
	}
	
	public List<Produto> listTopProdutos(Date dataInicio, Date dataFim){
		return null;
	}
	
}
