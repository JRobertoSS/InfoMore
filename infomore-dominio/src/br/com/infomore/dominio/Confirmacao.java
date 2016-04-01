package br.com.infomore.dominio;

import javax.persistence.ManyToOne;

public class Confirmacao extends EntidadeDominio{

	private boolean confirma;
	
	@ManyToOne
	private Usuario usuario;

	public boolean isConfirma() {
		return confirma;
	}

	public void setConfirma(boolean confirma) {
		this.confirma = confirma;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
