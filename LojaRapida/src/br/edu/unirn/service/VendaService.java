package br.edu.unirn.service;

import java.util.Date;
import java.util.List;

import br.edu.unirn.dao.VendaDAO;
import br.edu.unirn.dominio.Venda;

public class VendaService {

	private VendaDAO vendaDAO;
	
	public VendaService(){}
	public VendaService(VendaDAO dao){
		this.vendaDAO = dao;
	}
	public List<Venda> vendaPorPeriodo(Date dataInicio, Date dataFim) {
		return vendaDAO.vendaPorPeriodo(dataInicio, dataFim);
	}
	
}
