package sifiscon.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String cnpj;
	private String razaoSocial;
	private String inscricaoMunicipal;
	private long receitaBruta;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	public Fornecedor(){
		this.endereco = new Endereco();
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}
	public long getReceitaBruta() {
		return receitaBruta;
	}
	public void setReceitaBruta(long receitaBruta) {
		this.receitaBruta = receitaBruta;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
