package br.edu.unirn.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;

import br.edu.unirn.dao.VendaDAO;
import br.edu.unirn.dominio.Cliente;
import br.edu.unirn.dominio.Produto;
import br.edu.unirn.dominio.Venda;

@ManagedBean
@SessionScoped
public class CarrinhoMBean extends AbstractController{

	@Override
	void init() {		
	}
	
	List<Produto> produtos;
	Produto produtoSelecionado;

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void onProdutoDrop(DragDropEvent ddEvent) {
		
		if(produtos == null){
			produtos = new ArrayList<Produto>();
		}
		
        Produto produto = ((Produto) ddEvent.getData());
        
        if ( produtos.contains(produto) ){
        	somaQuantidade(produto);	
        }else{
        	produtos.add(produto);
        }
        
    }
	
	private void somaQuantidade(Produto produto){
		for (Produto p : produtos) {
			if (p.getId() == produto.getId()){
				p.setQuantidade(p.getQuantidade()+1);
			}
		}
	}
	
	public double somarCarrinho(){
		double total = 0.0;
		for (Produto produto : this.produtos) {
			total += produto.getPreco()*produto.getQuantidade();			
		}
		return total;
	}
	
	public void limparCarrinho(){
		for (Produto produto : produtos) {
			produto.setQuantidade(1);
		}
		produtos = new ArrayList<Produto>();
	}

	public String fecharCompra(){
		return "lojalogin";
	}
	
	public String confirmarCompra(Cliente cliente){
		for (Produto produto : produtos) {
			VendaDAO daoVenda = new VendaDAO();
			Venda venda = new Venda();
			venda.setCliente(cliente);
			venda.setDataVenda(new Date());
			venda.setProduto(produto);
			venda.setQuantidade(produto.getQuantidade());
			
			daoVenda.create(venda);
		}
		produtos = new ArrayList<Produto>();
		addInfo("Venda efetuada com sucesso.");
		return "loja";
	}
}
