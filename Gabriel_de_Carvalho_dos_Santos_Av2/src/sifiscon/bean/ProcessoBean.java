package sifiscon.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sifiscon.dao.DAO;
import sifiscon.modelo.Fornecedor;
import sifiscon.modelo.Processo;

@ManagedBean
@SessionScoped
public class ProcessoBean {
	
	private Processo processo;
	
	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public ProcessoBean(){
		 this.processo = new Processo();
	}
	
	public String salvarProcesso(){
		System.out.println("Registrando o processo " + this.processo.getFiscalResponsavel());

		if (processo.getFornecedor() == null) {
			throw new RuntimeException("O processo deve ter um fornecedor.");
		}
		
		Date data = this.processo.getDataRelato();
		String dataInversa;
		
		SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd-HHmmss-");
		
		dataInversa = formatador.format(data);
		
		String numeroProcesso = dataInversa + this.processo.getFornecedor().getCnpj();
		
		this.processo.setNumeroProcesso(numeroProcesso);
		
		DAO<Processo> dao = new DAO<Processo>(Processo.class);
		
		if(this.processo.getId() != null){
			Processo salvo = dao.buscarId(this.processo.getId());
			
			if(salvo != null){
				dao.atualizar(this.processo);
			}
		}
		else{
			dao.adicionar(this.processo);
		}

		// Para limpar o formulário após o envio.
		this.processo = new Processo();
		
		return "listarProcessos";
	}
	
	public String buscarFornecedor(){
		
		Fornecedor fornecedor = this.processo.getFornecedor();
		
		fornecedor = new DAO<Fornecedor>(Fornecedor.class).buscarPorCampo("cnpj", fornecedor.getCnpj());
		
		this.processo.setFornecedor(fornecedor);
		
		return "processo";
	}
	
	public String voltarHome(){
		return "index";
	}
	
	public String novoProcesso(){
		return "processo";
	}
	
	public String listarProcessos(){
		return "listarProcessos";
	}
	
	public List<Processo> getProcessos(){
		return new DAO<Processo>(Processo.class).listar();
	}
	
	public void excluir(Processo processo){
		new DAO<Processo>(Processo.class).remover(processo);
	}
	
	public String editar(Processo processo){
		this.setProcesso(processo);
		
		return "processo";
	}
}
