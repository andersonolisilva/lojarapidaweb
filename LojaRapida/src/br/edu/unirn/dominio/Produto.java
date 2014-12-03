package br.edu.unirn.dominio;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import br.edu.unirn.dao.PersistDB;

/**
 * Representa um produto dispon�vel na loja
 * @author Usuario
 *
 */
@Entity
public class Produto implements PersistDB{
	
	/**
	 * Identificador �nico do produto no sistema
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Denomina��o do produto, descreve-o de forma sucinta.
	 */
	private String denominacao;
	
	/**
	 * Descri��o do produto, detalhes sobre o produto
	 */
	private String descricao;
	
	/**
	 * Pre�o do produto
	 */
	private Double preco;
	
	@Transient
	private int quantidade = 1;
	
	/**
	 * Categoria da qual o produto pertence
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Categoria categoria;
	
	/**
	 * Guarda o caminho da imagem do produto
	 */
	private String img;

	@OneToMany(mappedBy="produto")
	Collection<Venda> vendas;
	
	private int qtdeEstoque;
	
	//constructors----------
	
	public int getQtdeEstoque() {
		return qtdeEstoque;
	}


	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}


	/**
	 * Construtor padr�o
	 */
	public Produto() {
		categoria = new Categoria();
	}
	
	
	/**
	 * Construtor recebendo apenas o id
	 * @param id
	 */
	public Produto(int id) {
		
		this.id = id;
		categoria = new Categoria();

	}
	
	
	/**
	 * Construtor recebendo todos os atributos.
	 * @param id
	 * @param denominacao
	 * @param descricao
	 * @param preco
	 */
	public Produto(int id, String denominacao, String descricao, Double preco) {
		this.id = id;
		this.denominacao = denominacao;
		this.descricao = descricao;
		this.preco = preco;
		categoria = new Categoria();
	}



	//getters and setters ----- 
	
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public String getImg() {
		return img != null ? img : "noimage.jpg";
	}


	public void setImg(String img) {
		this.img = img;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Collection<Venda> getVendas() {
		return vendas;
	}


	public void setVendas(Collection<Venda> vendas) {
		this.vendas = vendas;
	} 
}