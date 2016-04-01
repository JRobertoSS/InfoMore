package br.com.infomore.dominio;

import java.util.List;

import javax.persistence.OneToMany;

public class Categoria extends EntidadeDominio{

	private String nome;

	private String descricao;

	@OneToMany
	private List<Categoria> categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	
	

}
