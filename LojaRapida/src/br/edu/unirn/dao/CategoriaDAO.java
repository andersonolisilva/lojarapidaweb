package br.edu.unirn.dao;

import br.edu.unirn.dominio.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria>{

	@Override
	public Class<Categoria> getClassType() {
		return Categoria.class;
	}

}
