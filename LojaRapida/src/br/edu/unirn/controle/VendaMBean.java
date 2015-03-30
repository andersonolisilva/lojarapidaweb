package br.edu.unirn.controle;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.unirn.dao.VendaDAO;
import br.edu.unirn.dominio.Venda;
import br.edu.unirn.service.VendaService;

@ManagedBean
@ViewScoped
public class VendaMBean extends AbstractController{

	private List<Venda> vendas;
	private Date dataInicio;
	private Date dataFim;
	private VendaService service;

	@PostConstruct
	public void init(){
		obj = new Venda();
		dao = new VendaDAO();
		service = new VendaService((VendaDAO)dao);
	}

	public void getVendaPorPeriodo(){
		this.vendas = service.vendaPorPeriodo(dataInicio, dataFim);
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}



}
