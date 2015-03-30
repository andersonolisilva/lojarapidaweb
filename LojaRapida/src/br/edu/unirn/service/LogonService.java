package br.edu.unirn.service;

import java.util.List;

import javax.persistence.Query;

import br.edu.unirn.dao.Database;
import br.edu.unirn.dominio.Cliente;

public class LogonService {

	private Cliente cliente;
	
	public Cliente logon(Cliente clienteLogon) {

		Query consulta = Database
				.getInstance()
				.getEntityManager()
				.createQuery(
						"from Cliente where email = :email and senha = :senha");
		consulta.setParameter("email", clienteLogon.getEmail());
		consulta.setParameter("senha", clienteLogon.getSenha());
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = consulta.getResultList();
		if (clientes.size() == 1) {
			this.cliente = clientes.get(0);
		} else {
			this.cliente = null;
		}
		return this.cliente;
	}

}
