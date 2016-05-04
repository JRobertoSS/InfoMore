package br.com.infomore.dominio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="tipos_marcador")
public class TipoMarcador extends EntidadeDominio{

	private String tipo;

	private String descricao;

	@ManyToOne
	private Categoria categoria;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
