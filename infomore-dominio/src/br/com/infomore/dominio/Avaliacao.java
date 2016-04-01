package br.com.infomore.dominio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao extends EntidadeDominio{

	private String comentario;

	private int estrelas;
	
	@ManyToOne
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
