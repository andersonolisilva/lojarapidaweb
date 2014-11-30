package br.edu.unirn.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.edu.unirn.dominio.Produto;

public class ProdutoDAO extends GenericDAO<Produto>{

	@Override
	public Class<Produto> getClassType() {
		return Produto.class;
	}
	
	public List<Produto> listTopProdutos(Date dataInicio, Date dataFim){
		
		Query consulta = Database.getInstance().getEntityManager()
				.createQuery("select p "
						+ " from Produto p"
						+ "  join p.vendas v"
						+ " where v.dataVenda >= :dataInicio"						 
						+ "       and v.dataVenda <= :dataFim"	
						+ "  group by p"
						+ " order by sum(v.quantidade) DESC");
		consulta.setParameter("dataInicio", dataInicio);
		consulta.setParameter("dataFim", dataFim);
		
		List<Produto> produtos = consulta.setFirstResult(0).setMaxResults(10).getResultList();
		
		/**
		 * Caso tenha mais de 10 produtos, o sistema irá montar uma visão para exibir apenas
		 * 		os 10 com maior quantidade de venda.
		 */
		if(produtos.size()>10){
			produtos.subList(0, 9);
		}
			
		return produtos;
	}

}
