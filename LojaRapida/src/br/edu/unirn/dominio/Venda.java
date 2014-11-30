package br.edu.unirn.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.unirn.dao.PersistDB;

@Entity
public class Venda implements PersistDB {

	/**
	 * Identificador unico do cliente no sistema
	 */
	@Id
	@GeneratedValue
	private int id;
	private Date dataVenda;
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	private int quantidade;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
