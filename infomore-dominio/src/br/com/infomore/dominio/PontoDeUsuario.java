package br.com.infomore.dominio;

import javax.persistence.ManyToOne;

public class PontoDeUsuario extends Ponto {
	@ManyToOne
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
