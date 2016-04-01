package br.com.infomore.dominio;

import javax.persistence.OneToOne;

public class Prioridade extends EntidadeDominio{

	private double peso;

	private String descricao;
	
	@OneToOne
	private Categoria categoria;

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
