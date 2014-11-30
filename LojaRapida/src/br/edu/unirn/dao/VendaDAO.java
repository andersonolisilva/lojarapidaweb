package br.edu.unirn.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.edu.unirn.dominio.Venda;

public class VendaDAO extends GenericDAO<Venda>{

	@Override
	public Class<Venda> getClassType() {
		return Venda.class;
	}
	
    public List<Venda> vendaPorPeriodo(Date dataInicio, Date dataFim){
		
		Query consulta = Database.getInstance().getEntityManager()
				.createQuery("from Venda v where dataVenda >= :dataInicio and dataVenda <= :dataFim");
        consulta.setParameter("dataInicio", dataInicio);
		consulta.setParameter("dataFim", dataFim);
		
		List<Venda> vendas = consulta.getResultList();
		
		return vendas;
	}
	

}
