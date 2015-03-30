package br.edu.unirn.dominio;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.edu.unirn.dao.PersistDB;

/**
 * Representa o cliente, que faz as compras no sistema
 * @author Usuario
 *
 */
@Entity
public class Cliente implements PersistDB{

	/**
	 * Identificador unico do cliente no sistema
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Nome do cliente
	 */
	private String nome;
	
	/**
	 * Email do cliente,tamb�m usado para efetuar login no sistema.
	 */
	private String email;
	
	/**
	 * Cpf do cliente
	 */
	private String cpf;
	
	/**
	 * Senha usada para acesso do cliente no sistema
	 */
	private String senha;

	@OneToMany(mappedBy="cliente")
	Collection<Venda> vendas;
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
/*		String cpfS = "";
		if (!(cpf == null)){
		  cpfS = cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9)+"-"+cpf.substring(9);
		}*/
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Collection<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	}
	
	
}
