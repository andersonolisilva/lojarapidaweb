package br.edu.unirn.controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.edu.unirn.dao.ClienteDAO;
import br.edu.unirn.dominio.Cliente;

@ManagedBean
public class ClienteMBean extends AbstractController{
	
	@PostConstruct
	public void init(){
		obj = new Cliente();
		dao = new ClienteDAO();
	}
		
}
