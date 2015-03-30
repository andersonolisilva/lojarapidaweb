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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result
				+ ((denominacao == null) ? 0 : denominacao.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + qtdeEstoque;
		result = prime * result + quantidade;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (denominacao == null) {
			if (other.denominacao != null)
				return false;
		} else if (!denominacao.equals(other.denominacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (qtdeEstoque != other.qtdeEstoque)
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	} 
	
	
}