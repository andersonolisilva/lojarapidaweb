package br.edu.unirn.controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.unirn.dao.ClienteDAO;
import br.edu.unirn.dominio.Cliente;
import br.edu.unirn.service.LogonService;

@ManagedBean
@SessionScoped
public class LoginMBean extends AbstractController{

	private LogonService service;
	
	@PostConstruct
	public void init(){
		obj = new Cliente();
		dao = new ClienteDAO();
	}
	
	public String logon(){
		Cliente clienteLogado;
		clienteLogado = service.logon((Cliente) obj);
		if(clienteLogado==null){
			addInfo("Usuário ou senha inválidos");
			return "lojalogin";
		}else{
			addInfo("Usuário autenticado no sistema");
			return "lojaconfirmacao";
		}
	}
}
