package br.edu.ifpb.dac.springdata.model;

import javax.persistence.Embeddable;


import javax.validation.constraints.NotBlank;



@Embeddable
public class Endereco {
	

	@NotBlank( message = "O CEP é obrigatorio")
	private String cep;
	
	
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	@Override
	public String toString() {
		return "CEP: "+this.cep+" Logradouro: "+this.logradouro+" Bairro: "+this.bairro+" Localidade:"
				+ " "+this.localidade+" UF: "+this.uf+" Complemento: "+this.complemento;
	}
}
