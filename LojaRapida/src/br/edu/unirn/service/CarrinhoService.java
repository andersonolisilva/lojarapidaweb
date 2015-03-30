package br.edu.unirn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.unirn.dao.VendaDAO;
import br.edu.unirn.dominio.Cliente;
import br.edu.unirn.dominio.Produto;
import br.edu.unirn.dominio.Venda;

public class CarrinhoService {

	List<Produto> produtos;

	public CarrinhoService(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}

	public List<Produto> somaQuantidade(List<Produto> lista, Produto produto) {
		this.produtos = lista;
		for (Produto p : produtos) {
			if (p.getId() == produto.getId()) {
				p.setQuantidade(p.getQuantidade() + 1);
			}
		}

		return produtos;
	}

	public double somarCarrinho(List<Produto> lista) {
		this.produtos = lista;
		double total = 0.0;
		if (!(produtos == null)) {
			for (Produto produto : produtos) {
				total += produto.getPreco() * produto.getQuantidade();
			}
		}
		return total;
	}

	public List<Produto> limparCarrinho(List<Produto> lista) {
		this.produtos = lista;
		if (!(produtos == null)) {
			for (Produto produto : produtos) {
				produto.setQuantidade(1);
			}
		}
		return produtos = new ArrayList<Produto>();
		
	}

	public List<Produto> confirmarCompra(List<Produto> lista, Cliente cliente) {
		
		this.produtos = lista;
		
		if (!(produtos == null)) {
			for (Produto produto : produtos) {
				VendaDAO daoVenda = new VendaDAO();
				Venda venda = new Venda();
				venda.setCliente(cliente);
				venda.setDataVenda(new Date());
				venda.setProduto(produto);
				venda.setQuantidade(produto.getQuantidade());

				daoVenda.create(venda);
			}
		}
		return produtos = new ArrayList<Produto>();

	}
}
