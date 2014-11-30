package br.edu.unirn.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.component.tabview.TabView;

import br.edu.unirn.dao.IGenericDAO;
import br.edu.unirn.dao.PersistDB;

public abstract class AbstractController {

	protected IGenericDAO dao;
	
	protected PersistDB obj;
	
	private TabView tabCrud = new TabView();
	
	abstract void init();
	
	public IGenericDAO<PersistDB> getDao() {
		return dao;
	}

	public void setDao(IGenericDAO<PersistDB> dao) {
		this.dao = dao;
	}

	public PersistDB getObj() {
		return obj;
	}

	public void setObj(PersistDB obj) {
		this.obj = obj;
	}

	public TabView getTabCrud() {
		return tabCrud;
	}

	public void setTabCrud(TabView tabCrud) {
		this.tabCrud = tabCrud;
	}

	public void addInfo(String msg){
		FacesMessage fm = new FacesMessage(msg);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	@SuppressWarnings("unchecked")
	public void deletar(PersistDB obj){
		
		try{
			dao.delete(dao.castGeneric(obj));
		}finally{
			dao.close();
		}
		addInfo("Registro em "+obj.getClass().getSimpleName()+" apagado(a) com sucesso.");

	}
	
	public String salvar() throws InstantiationException, IllegalAccessException{
		try{
			if(obj.getId()==0){
				dao.create(dao.castGeneric(obj));
				dao.getEm().refresh(obj);
			}else{
				dao.update(dao.castGeneric(obj));
			}
			tabCrud.setActiveIndex(0);
			obj = obj.getClass().newInstance();
			addInfo("Registro em "+ obj.getClass().getSimpleName() +" salvo(a) com sucesso.");

			return null;
			
		}finally{
			dao.close();
		}
		

	}
	
	public String selecionar(PersistDB obj){
		this.obj = obj;
		tabCrud.setActiveIndex(1);
		return null;
	}


	public List<PersistDB> getListaCompleta(){
		try{
			return dao.findAll();
		}finally{
			dao.close();
		}
	}

	
}
