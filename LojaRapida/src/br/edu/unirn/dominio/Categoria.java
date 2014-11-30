package br.edu.unirn.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.edu.unirn.dao.PersistDB;

/**
 * Representa a categoria de um produto.
 * @author Usuario
 *
 */
@Entity
public class Categoria implements PersistDB {
	
	/**
	 * Identificador unico de uam categoria de produto
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Denominação da categoria do produto
	 */
	private String denominacao;
	
	/**
	 * texto descritivo da categoria que irá aparecer para o cliente 
	 */
	private String descricao;
	
	//Constructors
	
	/**
	 * Construtor Padrão
	 */
	public Categoria() {
	
	}
	
	/**
	 * Construtor recebendo apenas o id
	 * @param id
	 */
	public Categoria(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * Construtor recebendo todos os atributos.
	 * @param id
	 * @param denominacao
	 */
	public Categoria(int id, String denominacao, String descricao) {
		super();
		this.id = id;
		this.denominacao = denominacao;
		this.descricao = descricao;
	}

	
	
	//getters and setters -------
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenominacao() {
		return denominacao;
	}
	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
	


}
