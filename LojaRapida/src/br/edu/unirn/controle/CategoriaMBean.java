package br.edu.unirn.controle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.edu.unirn.dao.CategoriaDAO;
import br.edu.unirn.dominio.Categoria;

@ManagedBean
public class CategoriaMBean extends AbstractController{
	
	@PostConstruct
	public void init(){
		obj = new Categoria();
		dao = new CategoriaDAO();
	}
}
