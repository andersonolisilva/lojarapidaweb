package br.edu.unirn.controle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.edu.unirn.dao.Database;
import br.edu.unirn.dominio.Produto;

public class Teste {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dataI = sdf.parse("2014-01-01");
		Date dataF = sdf.parse("2014-07-01");
		
		Query consulta = Database.getInstance().getEntityManager()
				.createQuery("select p "
						+ " from Produto p"
						+ "  join p.vendas v"
						+ " where v.dataVenda >= :dataInicio"						 
						+ "       and v.dataVenda <= :dataFim"	
						+ "  group by p"
						+ " order by sum(v.quantidade) DESC");
		consulta.setParameter("dataInicio", dataI);
		consulta.setParameter("dataFim", dataF);
		
		List<Produto> produtos = consulta.getResultList();
		
		for (Produto produto : produtos) {
			System.out.println(produto.getDenominacao());
		}
	}
}
