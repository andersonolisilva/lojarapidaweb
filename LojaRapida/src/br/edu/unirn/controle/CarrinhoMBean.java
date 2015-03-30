package br.edu.unirn.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;

import br.edu.unirn.dominio.Cliente;
import br.edu.unirn.dominio.Produto;
import br.edu.unirn.service.CarrinhoService;
import br.edu.unirn.service.LogonService;

@ManagedBean
@SessionScoped
public class CarrinhoMBean extends AbstractController{

	
	List<Produto> produtos;
	Produto produtoSelecionado;
	
	CarrinhoService service;
	LogonService serviceLogon;
	
	Cliente cliente;

	@Override
	@PostConstruct
	void init() {	
		service = new CarrinhoService(produtos);
		serviceLogon = new LogonService();
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
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
		produtos = service.somaQuantidade(produtos, produto);
	}
	
	public double somarCarrinho(){
		return service.somarCarrinho(produtos);
	}
	
	public void limparCarrinho(){
		produtos = service.limparCarrinho(produtos);
	}

	public String fecharCompra(){
		return "lojalogin";
	}
	
	public String confirmarCompra(Cliente cliente){
		produtos = service.confirmarCompra(produtos, cliente);
		addInfo("Venda efetuada com sucesso.");
		return "loja";
	}
	
	public String logon(Cliente clienteLogado){
		clienteLogado = serviceLogon.logon(clienteLogado);
		setCliente(clienteLogado);
		if(clienteLogado==null){
			addInfo("Usuário ou senha inválidos");
			return "lojalogin";
		}else{
			addInfo("Usuário autenticado no sistema");
			return "lojaconfirmacaocompra";
		}
	}
}
