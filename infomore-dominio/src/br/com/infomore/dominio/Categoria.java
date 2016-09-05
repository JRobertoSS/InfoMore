package br.com.infomore.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="categorias")
public class Categoria extends EntidadeDominio{

	public Categoria() {
	}
	
	@Column(name="nome")
	private String nome;

	@Column(name="descricao")
	private String descricao;

	@OneToMany(mappedBy="categoria", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
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
