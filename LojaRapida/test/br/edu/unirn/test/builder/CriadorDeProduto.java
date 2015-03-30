package br.edu.unirn.test.builder;

import br.edu.unirn.dominio.Produto;

public class CriadorDeProduto {

	private int id;
	private String descricao;
	private String denominacao;
	private Double preco;
	private int quantidade;
	
	public Produto controi(){
		Produto produto = new Produto();
			produto.setId(this.id);
			produto.setDescricao(this.descricao);
			produto.setDenominacao(this.denominacao);
			produto.setPreco(this.preco);
			produto.setQuantidade(this.quantidade);
		return produto;
	}
	
	public CriadorDeProduto para(int id, String descricao, String denominacao, Double preco,int quantidade){
		this.id = id;
		this.descricao = descricao;
		this.denominacao = denominacao;
		this.preco = preco;
		this.quantidade = quantidade;
		return this;
	}
	
}
