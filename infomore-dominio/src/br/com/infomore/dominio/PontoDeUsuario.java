package br.com.infomore.dominio;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PontoDeUsuario extends Ponto {
	@ManyToOne(optional=false)
	@JoinColumn(insertable=false, updatable=false)
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
