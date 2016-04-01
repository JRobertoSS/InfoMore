package br.com.infomore.dominio;

import java.util.Date;

public abstract class Pessoa extends EntidadeDominio{

	private String nome;

	private Date dtNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	
}
