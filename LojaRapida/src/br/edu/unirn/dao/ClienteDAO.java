package br.edu.unirn.dao;

import br.edu.unirn.dominio.Cliente;

public class ClienteDAO extends GenericDAO<Cliente>{

	@Override
	public Class<Cliente> getClassType() {
		return Cliente.class;
	}

}
