package sifiscon.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Processo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String numeroProcesso;
	
	@OneToOne
	private Fornecedor fornecedor;
	
	private String relatoFiscalizacao;
	private Date dataRelato;
	private String fiscalResponsavel;
	
	public Processo(){
		fornecedor = new Fornecedor();
	}

	public Integer getId() {
		return id;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getRelatoFiscalizacao() {
		return relatoFiscalizacao;
	}

	public void setRelatoFiscalizacao(String relatoFiscalizacao) {
		this.relatoFiscalizacao = relatoFiscalizacao;
	}

	public Date getDataRelato() {
		return dataRelato;
	}

	public void setDataRelato(Date dataRelato) {
		this.dataRelato = dataRelato;
	}

	public String getFiscalResponsavel() {
		return fiscalResponsavel;
	}

	public void setFiscalResponsavel(String fiscalResponsavel) {
		this.fiscalResponsavel = fiscalResponsavel;
	}
	
	
}
