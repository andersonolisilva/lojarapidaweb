package br.edu.unirn.controle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.edu.unirn.dao.ProdutoDAO;
import br.edu.unirn.dominio.Produto;
import br.edu.unirn.service.ProdutoService;

@ManagedBean
@ViewScoped
public class ProdutoMBean extends AbstractController{

	List<Produto> produtoTopDez;
	private Date dataInicio;
	private Date dataFim;
	private ProdutoService service;
	
	@PostConstruct
	public void init(){
		obj = new Produto();
		dao = new ProdutoDAO();
		service = new ProdutoService((ProdutoDAO) dao);
	}
	
	@SuppressWarnings("unchecked")
	public void handleFileUpload(FileUploadEvent event) throws IOException {
		UploadedFile file = event.getFile();
		byte[] fileContent = file.getContents();
		
		String caminho = FacesContext
							.getCurrentInstance()
							.getExternalContext()
							.getRealPath("/resources/produtos/"+file.getFileName());
		
		FileOutputStream fos = new FileOutputStream(caminho);
		fos.write(fileContent);
		fos.close();
		
		((Produto) obj).setImg(file.getFileName());
		dao.update(obj);
		addInfo("Arquivos adicionado com sucesso.");
		
    }
	
	public void getTopProdutos(){
		this.produtoTopDez = service.listTopProdutos(dataInicio, dataFim);
	}

	public List<Produto> getProdutoTopDez() {
		return produtoTopDez;
	}

	public void setProdutoTopDez(List<Produto> produtoTopDez) {
		this.produtoTopDez = produtoTopDez;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	
}
