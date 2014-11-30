package br.edu.unirn.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Query;

import br.edu.unirn.dao.ClienteDAO;
import br.edu.unirn.dao.Database;
import br.edu.unirn.dominio.Cliente;
import br.edu.unirn.dominio.Produto;

@ManagedBean
@SessionScoped
public class LoginMBean extends AbstractController{

	@PostConstruct
	public void init(){
		obj = new Cliente();
		dao = new ClienteDAO();
	}

	public String logon(List<Produto> produtos){
		
		/**
		 * Testa se existe uma lista de produtos, caso contrário força o retorno para a loja.
		 */				
		if(produtos == null || produtos.size()==0){
			addInfo("Adicione produtos ao carrinho antes de entrar no sistema.");
			return "loja?faces-redirect=true";
		}
		
		Query consulta = Database.getInstance().getEntityManager()
				.createQuery("from Cliente where email = :email and senha = :senha");
		consulta.setParameter("email", ((Cliente)obj).getEmail());
		consulta.setParameter("senha", ((Cliente)obj).getSenha());
		List<Cliente> clientes = consulta.getResultList();
		if (clientes.size()==1){
			this.obj = clientes.get(0);
			return "lojaconfirmacaocompra";
		}else{
			addInfo("Usuário não identificado.");
		}
		return "";
	}
}
