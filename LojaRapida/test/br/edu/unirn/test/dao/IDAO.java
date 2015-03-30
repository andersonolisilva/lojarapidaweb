package br.edu.unirn.test.dao;

import java.util.List;



public interface IDAO<T> {

	public void create(T t);
	
	public void update(T t);

	public void delete(T t);
	
	public T findByPrimaryKey(int id);
	
	public List<T> findAll();

}
