package br.com.infomore.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="avaliacoes")
public class Avaliacao extends EntidadeDominio{

	public Avaliacao() {
	}
	
	@Column(name="comentario")
	private String comentario;

	@Column(name="estrelas")
	private int estrelas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_usuario", insertable=true, updatable=true, nullable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.DETACH)
	private Usuario usuario;
	

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
