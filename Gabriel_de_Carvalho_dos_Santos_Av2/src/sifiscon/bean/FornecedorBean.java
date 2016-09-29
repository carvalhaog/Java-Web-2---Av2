package sifiscon.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sifiscon.dao.DAO;
import sifiscon.modelo.Fornecedor;

@ManagedBean
@ViewScoped
public class FornecedorBean {
	
	private Fornecedor fornecedor;	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorBean(){
		this.fornecedor = new Fornecedor();
	}
	
	public String salvarFornecedor(){
		System.out.println("Registrando o fornecedor " + this.fornecedor.getCnpj());

		if (fornecedor.getEndereco() == null) {
			throw new RuntimeException("O fornecedor deve ter um endereço.");
		}

		new DAO<Fornecedor>(Fornecedor.class).adicionar(this.fornecedor);

		this.fornecedor = new Fornecedor();
		
		return "listarFornecedores";
	}
	
	public String listarFornecedores(){
		return "listarFornecedores";
	}
	
	public String voltarHome(){
		return "index";
	}
	
	public String novoFornecedor(){
		return "fornecedor";
	}
	
	public List<Fornecedor> getFornecedores(){
		return new DAO<Fornecedor>(Fornecedor.class).listar();
	}
	
	
}
